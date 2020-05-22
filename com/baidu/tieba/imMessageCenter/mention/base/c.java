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
public class c extends com.baidu.tieba.card.b<a> {
    private TbPageContext dIF;
    private TextView dXU;
    private int ds42;
    private int ds48;
    private TextView feW;
    public OriginalThreadCardView gFy;
    private HeadImageView gxs;
    private TextView iQK;
    private TextView iQL;
    private View iQM;
    private View iQN;
    private MessageCardBottomView iQO;
    private View iQP;
    private a iQQ;
    private OriginalThreadCardView.a iQR;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.iQR = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.iQQ != null && c.this.iQQ.crl() != null) {
                    an ag = new an(c.this.iQQ.crl()).ag("obj_locate", 2);
                    if (c.this.iQQ.getType() == a.iQG || c.this.iQQ.getType() == a.iQC) {
                        ag.ag("obj_type", 1);
                    } else {
                        ag.ag("obj_type", 2);
                    }
                    TiebaStatic.log(ag);
                }
                if (c.this.bKS() != null) {
                    c.this.bKS().a(c.this.gFy, c.this.iQQ);
                }
            }
        };
        this.dIF = tbPageContext;
        this.ds42 = l.getDimens(this.dIF.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.dIF.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gxs = (HeadImageView) view.findViewById(R.id.photo);
        this.dXU = (TextView) view.findViewById(R.id.user_name);
        this.iQK = (TextView) view.findViewById(R.id.fans_reply);
        this.iQL = (TextView) view.findViewById(R.id.post_from);
        this.iQM = view.findViewById(R.id.divider_between_time_and_post_from);
        this.feW = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.iQN = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.gFy = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.iQO = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.iQP = view.findViewById(R.id.new_message);
        this.gFy.setUsePlaceHolder(false);
        this.gxs.setOnClickListener(this);
        this.dXU.setOnClickListener(this);
        this.iQO.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.lc(R.color.cp_bg_line_e));
            am.setViewTextColor(this.dXU, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.iQK, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.iQK, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.iQL, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.feW, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.iQM, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.iQN, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.gFy != null) {
                this.gFy.onChangeSkinType();
            }
            if (this.iQO != null) {
                this.iQO.onChangeSkinType();
            }
            am.setBackgroundResource(this.iQP, R.drawable.icon_news_red_dot);
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
            this.iQQ = aVar;
            MetaData replyer = aVar.getReplyer();
            this.gxs.setVisibility(0);
            this.gxs.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gxs.setPlaceHolder(1);
            this.gxs.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.gxs, replyer, 0);
            this.gxs.setTag(null);
            this.gxs.setPageId(this.dIF.getUniqueId());
            this.gxs.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.dXU.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.iQK.setVisibility(0);
            } else {
                this.iQK.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.iQM.setVisibility(0);
                this.iQL.setVisibility(0);
                this.iQL.setText(aVar.getPostFrom());
            } else {
                this.iQM.setVisibility(8);
                this.iQL.setVisibility(8);
            }
            this.feW.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bes().b(this.dIF.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.iQN.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bes().b(this.dIF.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.iQN.setVisibility(0);
            }
            this.gFy.b(aVar.getOriginalThreadInfo());
            this.gFy.setSubClickListener(this.iQR);
            MessageCardBottomView messageCardBottomView = this.iQO;
            String fname = aVar.getFname();
            if (aVar.getType() == a.iQC || aVar.getType() == a.iQD) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.iQP.setVisibility(0);
            } else {
                this.iQP.setVisibility(8);
            }
            onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iQQ != null || this.dIF != null) {
            if (view == this.gxs || view == this.dXU) {
                if (this.iQQ.getReplyer() != null) {
                    String userId = this.iQQ.getReplyer().getUserId();
                    String userName = this.iQQ.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.dIF.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (bKS() != null) {
                bKS().a(view, this.iQQ);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.dIF == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.dIF.getPageActivity()) - (this.dIF.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
