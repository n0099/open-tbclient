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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<a> {
    private TextView dEL;
    private TbPageContext dPv;
    private int ds42;
    private int ds48;
    private TextView fqs;
    private HeadImageView gKr;
    public OriginalThreadCardView gSC;
    private TextView jiJ;
    private TextView jiK;
    private View jiL;
    private View jiM;
    private MessageCardBottomView jiN;
    private View jiO;
    private a jiP;
    private OriginalThreadCardView.a jiQ;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.jiQ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.jiP != null && c.this.jiP.cvm() != null) {
                    ao ag = new ao(c.this.jiP.cvm()).ag("obj_locate", 2);
                    if (c.this.jiP.getType() == a.jiF || c.this.jiP.getType() == a.jiB) {
                        ag.ag("obj_type", 1);
                    } else {
                        ag.ag("obj_type", 2);
                    }
                    TiebaStatic.log(ag);
                }
                if (c.this.bOd() != null) {
                    c.this.bOd().a(c.this.gSC, c.this.jiP);
                }
            }
        };
        this.dPv = tbPageContext;
        this.ds42 = l.getDimens(this.dPv.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.dPv.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gKr = (HeadImageView) view.findViewById(R.id.photo);
        this.dEL = (TextView) view.findViewById(R.id.user_name);
        this.jiJ = (TextView) view.findViewById(R.id.fans_reply);
        this.jiK = (TextView) view.findViewById(R.id.post_from);
        this.jiL = view.findViewById(R.id.divider_between_time_and_post_from);
        this.fqs = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.jiM = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.gSC = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.jiN = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.jiO = view.findViewById(R.id.new_message);
        this.gSC.setUsePlaceHolder(false);
        this.gKr.setOnClickListener(this);
        this.dEL.setOnClickListener(this);
        this.jiN.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(an.ls(R.color.cp_bg_line_e));
            an.setViewTextColor(this.dEL, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.jiJ, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.jiJ, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            an.setViewTextColor(this.jiK, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.fqs, (int) R.color.cp_cont_d);
            an.setBackgroundColor(this.jiL, R.color.cp_cont_e);
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            an.setBackgroundColor(this.jiM, R.color.cp_bg_line_c);
            an.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.gSC != null) {
                this.gSC.onChangeSkinType();
            }
            if (this.jiN != null) {
                this.jiN.onChangeSkinType();
            }
            an.setBackgroundResource(this.jiO, R.drawable.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: f */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.jiP = aVar;
            MetaData replyer = aVar.getReplyer();
            this.gKr.setVisibility(0);
            this.gKr.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gKr.setPlaceHolder(1);
            this.gKr.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.gKr, replyer, 0);
            this.gKr.setTag(null);
            this.gKr.setPageId(this.dPv.getUniqueId());
            this.gKr.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.dEL.setText(ar.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.jiJ.setVisibility(0);
            } else {
                this.jiJ.setVisibility(8);
            }
            if (!ar.isEmpty(aVar.getPostFrom())) {
                this.jiL.setVisibility(0);
                this.jiK.setVisibility(0);
                this.jiK.setText(aVar.getPostFrom());
            } else {
                this.jiL.setVisibility(8);
                this.jiK.setVisibility(8);
            }
            this.fqs.setText(ar.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bgy().b(this.dPv.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ar.isEmpty(aVar.getSubTitle())) {
                this.jiM.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bgy().b(this.dPv.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.jiM.setVisibility(0);
            }
            this.gSC.b(aVar.getOriginalThreadInfo());
            this.gSC.setSubClickListener(this.jiQ);
            MessageCardBottomView messageCardBottomView = this.jiN;
            String fname = aVar.getFname();
            if (aVar.getType() == a.jiB || aVar.getType() == a.jiC) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.jiO.setVisibility(0);
            } else {
                this.jiO.setVisibility(8);
            }
            onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jiP != null || this.dPv != null) {
            if (view == this.gKr || view == this.dEL) {
                if (this.jiP.getReplyer() != null) {
                    String userId = this.jiP.getReplyer().getUserId();
                    String userName = this.jiP.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.dPv.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (bOd() != null) {
                bOd().a(view, this.jiP);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.dPv == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.dPv.getPageActivity()) - (this.dPv.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
