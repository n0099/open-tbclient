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
    private TextView ffh;
    public OriginalThreadCardView gFJ;
    private HeadImageView gxD;
    private View iRA;
    private MessageCardBottomView iRB;
    private View iRC;
    private a iRD;
    private OriginalThreadCardView.a iRE;
    private TextView iRx;
    private TextView iRy;
    private View iRz;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.iRE = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.iRD != null && c.this.iRD.cru() != null) {
                    an ag = new an(c.this.iRD.cru()).ag("obj_locate", 2);
                    if (c.this.iRD.getType() == a.iRt || c.this.iRD.getType() == a.iRp) {
                        ag.ag("obj_type", 1);
                    } else {
                        ag.ag("obj_type", 2);
                    }
                    TiebaStatic.log(ag);
                }
                if (c.this.bKU() != null) {
                    c.this.bKU().a(c.this.gFJ, c.this.iRD);
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
        this.gxD = (HeadImageView) view.findViewById(R.id.photo);
        this.dXU = (TextView) view.findViewById(R.id.user_name);
        this.iRx = (TextView) view.findViewById(R.id.fans_reply);
        this.iRy = (TextView) view.findViewById(R.id.post_from);
        this.iRz = view.findViewById(R.id.divider_between_time_and_post_from);
        this.ffh = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.iRA = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.gFJ = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.iRB = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.iRC = view.findViewById(R.id.new_message);
        this.gFJ.setUsePlaceHolder(false);
        this.gxD.setOnClickListener(this);
        this.dXU.setOnClickListener(this);
        this.iRB.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.le(R.color.cp_bg_line_e));
            am.setViewTextColor(this.dXU, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.iRx, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.iRx, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.iRy, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ffh, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.iRz, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.iRA, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.gFJ != null) {
                this.gFJ.onChangeSkinType();
            }
            if (this.iRB != null) {
                this.iRB.onChangeSkinType();
            }
            am.setBackgroundResource(this.iRC, R.drawable.icon_news_red_dot);
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
            this.iRD = aVar;
            MetaData replyer = aVar.getReplyer();
            this.gxD.setVisibility(0);
            this.gxD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.gxD.setPlaceHolder(1);
            this.gxD.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.gxD, replyer, 0);
            this.gxD.setTag(null);
            this.gxD.setPageId(this.dIF.getUniqueId());
            this.gxD.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.dXU.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.iRx.setVisibility(0);
            } else {
                this.iRx.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.iRz.setVisibility(0);
                this.iRy.setVisibility(0);
                this.iRy.setText(aVar.getPostFrom());
            } else {
                this.iRz.setVisibility(8);
                this.iRy.setVisibility(8);
            }
            this.ffh.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.bet().b(this.dIF.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.iRA.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.bet().b(this.dIF.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.iRA.setVisibility(0);
            }
            this.gFJ.b(aVar.getOriginalThreadInfo());
            this.gFJ.setSubClickListener(this.iRE);
            MessageCardBottomView messageCardBottomView = this.iRB;
            String fname = aVar.getFname();
            if (aVar.getType() == a.iRp || aVar.getType() == a.iRq) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.iRC.setVisibility(0);
            } else {
                this.iRC.setVisibility(8);
            }
            onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iRD != null || this.dIF != null) {
            if (view == this.gxD || view == this.dXU) {
                if (this.iRD.getReplyer() != null) {
                    String userId = this.iRD.getReplyer().getUserId();
                    String userName = this.iRD.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.dIF.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (bKU() != null) {
                bKU().a(view, this.iRD);
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
