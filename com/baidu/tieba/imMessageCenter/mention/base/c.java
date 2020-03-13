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
    private TbPageContext cVi;
    private TextView cbL;
    private int ds42;
    private int ds48;
    private TextView eov;
    private HeadImageView fDk;
    public OriginalThreadCardView fLo;
    private TextView hQD;
    private TextView hQE;
    private View hQF;
    private View hQG;
    private MessageCardBottomView hQH;
    private View hQI;
    private a hQJ;
    private OriginalThreadCardView.a hQK;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.hQK = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.hQJ != null && c.this.hQJ.bZU() != null) {
                    an X = new an(c.this.hQJ.bZU()).X("obj_locate", 2);
                    if (c.this.hQJ.getType() == a.hQz || c.this.hQJ.getType() == a.hQv) {
                        X.X("obj_type", 1);
                    } else {
                        X.X("obj_type", 2);
                    }
                    TiebaStatic.log(X);
                }
                if (c.this.buH() != null) {
                    c.this.buH().a(c.this.fLo, c.this.hQJ);
                }
            }
        };
        this.cVi = tbPageContext;
        this.ds42 = l.getDimens(this.cVi.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.cVi.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fDk = (HeadImageView) view.findViewById(R.id.photo);
        this.cbL = (TextView) view.findViewById(R.id.user_name);
        this.hQD = (TextView) view.findViewById(R.id.fans_reply);
        this.hQE = (TextView) view.findViewById(R.id.post_from);
        this.hQF = view.findViewById(R.id.divider_between_time_and_post_from);
        this.eov = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.hQG = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.fLo = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hQH = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.hQI = view.findViewById(R.id.new_message);
        this.fLo.setUsePlaceHolder(false);
        this.fDk.setOnClickListener(this);
        this.cbL.setOnClickListener(this);
        this.hQH.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
            am.setViewTextColor(this.cbL, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hQD, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.hQD, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.hQE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eov, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.hQF, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.hQG, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.fLo != null) {
                this.fLo.onChangeSkinType();
            }
            if (this.hQH != null) {
                this.hQH.onChangeSkinType();
            }
            am.setBackgroundResource(this.hQI, R.drawable.icon_news_red_dot);
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
            this.hQJ = aVar;
            MetaData replyer = aVar.getReplyer();
            this.fDk.setVisibility(0);
            this.fDk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fDk.setPlaceHolder(1);
            this.fDk.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.fDk, replyer, 0);
            this.fDk.setTag(null);
            this.fDk.setPageId(this.cVi.getUniqueId());
            this.fDk.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.cbL.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.hQD.setVisibility(0);
            } else {
                this.hQD.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.hQF.setVisibility(0);
                this.hQE.setVisibility(0);
                this.hQE.setText(aVar.getPostFrom());
            } else {
                this.hQF.setVisibility(8);
                this.hQE.setVisibility(8);
            }
            this.eov.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aPQ().b(this.cVi.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.hQG.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.aPQ().b(this.cVi.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.hQG.setVisibility(0);
            }
            this.fLo.b(aVar.getOriginalThreadInfo());
            this.fLo.setSubClickListener(this.hQK);
            MessageCardBottomView messageCardBottomView = this.hQH;
            String fname = aVar.getFname();
            if (aVar.getType() == a.hQv || aVar.getType() == a.hQw) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.hQI.setVisibility(0);
            } else {
                this.hQI.setVisibility(8);
            }
            onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hQJ != null || this.cVi != null) {
            if (view == this.fDk || view == this.cbL) {
                if (this.hQJ.getReplyer() != null) {
                    String userId = this.hQJ.getReplyer().getUserId();
                    String userName = this.hQJ.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cVi.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (buH() != null) {
                buH().a(view, this.hQJ);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cVi == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.cVi.getPageActivity()) - (this.cVi.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
