package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView cBd;
    private int ds42;
    private int ds48;
    private TbPageContext duK;
    private TextView eSo;
    private HeadImageView giC;
    public OriginalThreadCardView gqJ;
    private TextView iCa;
    private TextView iCb;
    private View iCc;
    private View iCd;
    private MessageCardBottomView iCe;
    private View iCf;
    private a iCg;
    private OriginalThreadCardView.a iCh;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.iCh = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.iCg != null && c.this.iCg.ckL() != null) {
                    an af = new an(c.this.iCg.ckL()).af("obj_locate", 2);
                    if (c.this.iCg.getType() == a.iBW || c.this.iCg.getType() == a.iBS) {
                        af.af("obj_type", 1);
                    } else {
                        af.af("obj_type", 2);
                    }
                    TiebaStatic.log(af);
                }
                if (c.this.bEw() != null) {
                    c.this.bEw().a(c.this.gqJ, c.this.iCg);
                }
            }
        };
        this.duK = tbPageContext;
        this.ds42 = l.getDimens(this.duK.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.duK.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.giC = (HeadImageView) view.findViewById(R.id.photo);
        this.cBd = (TextView) view.findViewById(R.id.user_name);
        this.iCa = (TextView) view.findViewById(R.id.fans_reply);
        this.iCb = (TextView) view.findViewById(R.id.post_from);
        this.iCc = view.findViewById(R.id.divider_between_time_and_post_from);
        this.eSo = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.iCd = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.gqJ = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.iCe = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.iCf = view.findViewById(R.id.new_message);
        this.gqJ.setUsePlaceHolder(false);
        this.giC.setOnClickListener(this);
        this.cBd.setOnClickListener(this);
        this.iCe.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
            am.setViewTextColor(this.cBd, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.iCa, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.iCa, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.iCb, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eSo, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.iCc, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.iCd, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.gqJ != null) {
                this.gqJ.onChangeSkinType();
            }
            if (this.iCe != null) {
                this.iCe.onChangeSkinType();
            }
            am.setBackgroundResource(this.iCf, R.drawable.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: f */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.iCg = aVar;
            MetaData replyer = aVar.getReplyer();
            this.giC.setVisibility(0);
            this.giC.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.giC.setPlaceHolder(1);
            this.giC.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.giC, replyer, 0);
            this.giC.setTag(null);
            this.giC.setPageId(this.duK.getUniqueId());
            this.giC.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.cBd.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.iCa.setVisibility(0);
            } else {
                this.iCa.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.iCc.setVisibility(0);
                this.iCb.setVisibility(0);
                this.iCb.setText(aVar.getPostFrom());
            } else {
                this.iCc.setVisibility(8);
                this.iCb.setVisibility(8);
            }
            this.eSo.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aYj().b(this.duK.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.iCd.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.aYj().b(this.duK.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.iCd.setVisibility(0);
            }
            this.gqJ.b(aVar.getOriginalThreadInfo());
            this.gqJ.setSubClickListener(this.iCh);
            MessageCardBottomView messageCardBottomView = this.iCe;
            String fname = aVar.getFname();
            if (aVar.getType() == a.iBS || aVar.getType() == a.iBT) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.iCf.setVisibility(0);
            } else {
                this.iCf.setVisibility(8);
            }
            onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iCg != null || this.duK != null) {
            if (view == this.giC || view == this.cBd) {
                if (this.iCg.getReplyer() != null) {
                    String userId = this.iCg.getReplyer().getUserId();
                    String userName = this.iCg.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.duK.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (bEw() != null) {
                bEw().a(view, this.iCg);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.duK == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.duK.getPageActivity()) - (this.duK.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
