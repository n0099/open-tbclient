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
    private TbPageContext cVv;
    private TextView cbW;
    private int ds42;
    private int ds48;
    private TextView eoM;
    private HeadImageView fDS;
    public OriginalThreadCardView fLW;
    private TextView hSd;
    private TextView hSe;
    private View hSf;
    private View hSg;
    private MessageCardBottomView hSh;
    private View hSi;
    private a hSj;
    private OriginalThreadCardView.a hSk;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.hSk = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.hSj != null && c.this.hSj.cam() != null) {
                    an X = new an(c.this.hSj.cam()).X("obj_locate", 2);
                    if (c.this.hSj.getType() == a.hRZ || c.this.hSj.getType() == a.hRV) {
                        X.X("obj_type", 1);
                    } else {
                        X.X("obj_type", 2);
                    }
                    TiebaStatic.log(X);
                }
                if (c.this.buM() != null) {
                    c.this.buM().a(c.this.fLW, c.this.hSj);
                }
            }
        };
        this.cVv = tbPageContext;
        this.ds42 = l.getDimens(this.cVv.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.cVv.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fDS = (HeadImageView) view.findViewById(R.id.photo);
        this.cbW = (TextView) view.findViewById(R.id.user_name);
        this.hSd = (TextView) view.findViewById(R.id.fans_reply);
        this.hSe = (TextView) view.findViewById(R.id.post_from);
        this.hSf = view.findViewById(R.id.divider_between_time_and_post_from);
        this.eoM = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.hSg = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.fLW = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hSh = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.hSi = view.findViewById(R.id.new_message);
        this.fLW.setUsePlaceHolder(false);
        this.fDS.setOnClickListener(this);
        this.cbW.setOnClickListener(this);
        this.hSh.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
            am.setViewTextColor(this.cbW, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hSd, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.hSd, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.hSe, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eoM, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.hSf, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.hSg, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.fLW != null) {
                this.fLW.onChangeSkinType();
            }
            if (this.hSh != null) {
                this.hSh.onChangeSkinType();
            }
            am.setBackgroundResource(this.hSi, R.drawable.icon_news_red_dot);
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
            this.hSj = aVar;
            MetaData replyer = aVar.getReplyer();
            this.fDS.setVisibility(0);
            this.fDS.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fDS.setPlaceHolder(1);
            this.fDS.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.fDS, replyer, 0);
            this.fDS.setTag(null);
            this.fDS.setPageId(this.cVv.getUniqueId());
            this.fDS.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.cbW.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.hSd.setVisibility(0);
            } else {
                this.hSd.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.hSf.setVisibility(0);
                this.hSe.setVisibility(0);
                this.hSe.setText(aVar.getPostFrom());
            } else {
                this.hSf.setVisibility(8);
                this.hSe.setVisibility(8);
            }
            this.eoM.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aPU().b(this.cVv.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.hSg.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.aPU().b(this.cVv.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.hSg.setVisibility(0);
            }
            this.fLW.b(aVar.getOriginalThreadInfo());
            this.fLW.setSubClickListener(this.hSk);
            MessageCardBottomView messageCardBottomView = this.hSh;
            String fname = aVar.getFname();
            if (aVar.getType() == a.hRV || aVar.getType() == a.hRW) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.hSi.setVisibility(0);
            } else {
                this.hSi.setVisibility(8);
            }
            onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hSj != null || this.cVv != null) {
            if (view == this.fDS || view == this.cbW) {
                if (this.hSj.getReplyer() != null) {
                    String userId = this.hSj.getReplyer().getUserId();
                    String userName = this.hSj.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cVv.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (buM() != null) {
                buM().a(view, this.hSj);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cVv == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.cVv.getPageActivity()) - (this.cVv.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
