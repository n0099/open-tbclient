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
    private TextView cAX;
    private int ds42;
    private int ds48;
    private TbPageContext duG;
    private TextView eSj;
    private HeadImageView giw;
    public OriginalThreadCardView gqD;
    private TextView iBU;
    private TextView iBV;
    private View iBW;
    private View iBX;
    private MessageCardBottomView iBY;
    private View iBZ;
    private a iCa;
    private OriginalThreadCardView.a iCb;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.iCb = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.iCa != null && c.this.iCa.ckN() != null) {
                    an af = new an(c.this.iCa.ckN()).af("obj_locate", 2);
                    if (c.this.iCa.getType() == a.iBQ || c.this.iCa.getType() == a.iBM) {
                        af.af("obj_type", 1);
                    } else {
                        af.af("obj_type", 2);
                    }
                    TiebaStatic.log(af);
                }
                if (c.this.bEy() != null) {
                    c.this.bEy().a(c.this.gqD, c.this.iCa);
                }
            }
        };
        this.duG = tbPageContext;
        this.ds42 = l.getDimens(this.duG.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.duG.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.giw = (HeadImageView) view.findViewById(R.id.photo);
        this.cAX = (TextView) view.findViewById(R.id.user_name);
        this.iBU = (TextView) view.findViewById(R.id.fans_reply);
        this.iBV = (TextView) view.findViewById(R.id.post_from);
        this.iBW = view.findViewById(R.id.divider_between_time_and_post_from);
        this.eSj = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.iBX = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.gqD = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.iBY = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.iBZ = view.findViewById(R.id.new_message);
        this.gqD.setUsePlaceHolder(false);
        this.giw.setOnClickListener(this);
        this.cAX.setOnClickListener(this);
        this.iBY.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
            am.setViewTextColor(this.cAX, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.iBU, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.iBU, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.iBV, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eSj, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.iBW, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.iBX, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.gqD != null) {
                this.gqD.onChangeSkinType();
            }
            if (this.iBY != null) {
                this.iBY.onChangeSkinType();
            }
            am.setBackgroundResource(this.iBZ, R.drawable.icon_news_red_dot);
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
            this.iCa = aVar;
            MetaData replyer = aVar.getReplyer();
            this.giw.setVisibility(0);
            this.giw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.giw.setPlaceHolder(1);
            this.giw.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.giw, replyer, 0);
            this.giw.setTag(null);
            this.giw.setPageId(this.duG.getUniqueId());
            this.giw.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.cAX.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.iBU.setVisibility(0);
            } else {
                this.iBU.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.iBW.setVisibility(0);
                this.iBV.setVisibility(0);
                this.iBV.setText(aVar.getPostFrom());
            } else {
                this.iBW.setVisibility(8);
                this.iBV.setVisibility(8);
            }
            this.eSj.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aYl().b(this.duG.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.iBX.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.aYl().b(this.duG.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.iBX.setVisibility(0);
            }
            this.gqD.b(aVar.getOriginalThreadInfo());
            this.gqD.setSubClickListener(this.iCb);
            MessageCardBottomView messageCardBottomView = this.iBY;
            String fname = aVar.getFname();
            if (aVar.getType() == a.iBM || aVar.getType() == a.iBN) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.iBZ.setVisibility(0);
            } else {
                this.iBZ.setVisibility(8);
            }
            onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iCa != null || this.duG != null) {
            if (view == this.giw || view == this.cAX) {
                if (this.iCa.getReplyer() != null) {
                    String userId = this.iCa.getReplyer().getUserId();
                    String userName = this.iCa.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.duG.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (bEy() != null) {
                bEy().a(view, this.iCa);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.duG == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.duG.getPageActivity()) - (this.duG.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
