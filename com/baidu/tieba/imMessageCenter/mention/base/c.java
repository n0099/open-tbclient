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
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView bXt;
    private TbPageContext cQU;
    private int ds42;
    private int ds48;
    private TextView eji;
    public OriginalThreadCardView fFs;
    private HeadImageView fxm;
    private TextView hKO;
    private TextView hKP;
    private View hKQ;
    private View hKR;
    private MessageCardBottomView hKS;
    private View hKT;
    private a hKU;
    private OriginalThreadCardView.a hKV;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.hKV = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.hKU != null && c.this.hKU.bXh() != null) {
                    an Z = new an(c.this.hKU.bXh()).Z("obj_locate", 2);
                    if (c.this.hKU.getType() == a.hKK || c.this.hKU.getType() == a.hKG) {
                        Z.Z("obj_type", 1);
                    } else {
                        Z.Z("obj_type", 2);
                    }
                    TiebaStatic.log(Z);
                }
                if (c.this.brY() != null) {
                    c.this.brY().a(c.this.fFs, c.this.hKU);
                }
            }
        };
        this.cQU = tbPageContext;
        this.ds42 = l.getDimens(this.cQU.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.cQU.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fxm = (HeadImageView) view.findViewById(R.id.photo);
        this.bXt = (TextView) view.findViewById(R.id.user_name);
        this.hKO = (TextView) view.findViewById(R.id.fans_reply);
        this.hKP = (TextView) view.findViewById(R.id.post_from);
        this.hKQ = view.findViewById(R.id.divider_between_time_and_post_from);
        this.eji = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.hKR = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.fFs = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hKS = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.hKT = view.findViewById(R.id.new_message);
        this.fFs.setUsePlaceHolder(false);
        this.fxm.setOnClickListener(this);
        this.bXt.setOnClickListener(this);
        this.hKS.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
            am.setViewTextColor(this.bXt, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hKO, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.hKO, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.hKP, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eji, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.hKQ, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.hKR, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.fFs != null) {
                this.fFs.onChangeSkinType();
            }
            if (this.hKS != null) {
                this.hKS.onChangeSkinType();
            }
            am.setBackgroundResource(this.hKT, R.drawable.icon_news_red_dot);
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
            this.hKU = aVar;
            MetaData replyer = aVar.getReplyer();
            this.fxm.setVisibility(0);
            this.fxm.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fxm.setPlaceHolder(1);
            this.fxm.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.fxm, replyer, 0);
            this.fxm.setTag(null);
            this.fxm.setPageId(this.cQU.getUniqueId());
            this.fxm.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.bXt.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.hKO.setVisibility(0);
            } else {
                this.hKO.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.hKQ.setVisibility(0);
                this.hKP.setVisibility(0);
                this.hKP.setText(aVar.getPostFrom());
            } else {
                this.hKQ.setVisibility(8);
                this.hKP.setVisibility(8);
            }
            this.eji.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aMY().b(this.cQU.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.hKR.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.aMY().b(this.cQU.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.hKR.setVisibility(0);
            }
            this.fFs.b(aVar.getOriginalThreadInfo());
            this.fFs.setSubClickListener(this.hKV);
            MessageCardBottomView messageCardBottomView = this.hKS;
            String fname = aVar.getFname();
            if (aVar.getType() == a.hKG || aVar.getType() == a.hKH) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.hKT.setVisibility(0);
            } else {
                this.hKT.setVisibility(8);
            }
            onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hKU != null || this.cQU != null) {
            if (view == this.fxm || view == this.bXt) {
                if (this.hKU.getReplyer() != null) {
                    String userId = this.hKU.getReplyer().getUserId();
                    String userName = this.hKU.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cQU.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (brY() != null) {
                brY().a(view, this.hKU);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cQU == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.cQU.getPageActivity()) - (this.cQU.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
