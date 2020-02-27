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
    private TbPageContext cVg;
    private TextView cbJ;
    private int ds42;
    private int ds48;
    private TextView eoh;
    private HeadImageView fCV;
    public OriginalThreadCardView fKZ;
    private TextView hQp;
    private TextView hQq;
    private View hQr;
    private View hQs;
    private MessageCardBottomView hQt;
    private View hQu;
    private a hQv;
    private OriginalThreadCardView.a hQw;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.hQw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.hQv != null && c.this.hQv.bZR() != null) {
                    an X = new an(c.this.hQv.bZR()).X("obj_locate", 2);
                    if (c.this.hQv.getType() == a.hQl || c.this.hQv.getType() == a.hQh) {
                        X.X("obj_type", 1);
                    } else {
                        X.X("obj_type", 2);
                    }
                    TiebaStatic.log(X);
                }
                if (c.this.buE() != null) {
                    c.this.buE().a(c.this.fKZ, c.this.hQv);
                }
            }
        };
        this.cVg = tbPageContext;
        this.ds42 = l.getDimens(this.cVg.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.cVg.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fCV = (HeadImageView) view.findViewById(R.id.photo);
        this.cbJ = (TextView) view.findViewById(R.id.user_name);
        this.hQp = (TextView) view.findViewById(R.id.fans_reply);
        this.hQq = (TextView) view.findViewById(R.id.post_from);
        this.hQr = view.findViewById(R.id.divider_between_time_and_post_from);
        this.eoh = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.hQs = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.fKZ = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hQt = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.hQu = view.findViewById(R.id.new_message);
        this.fKZ.setUsePlaceHolder(false);
        this.fCV.setOnClickListener(this);
        this.cbJ.setOnClickListener(this);
        this.hQt.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
            am.setViewTextColor(this.cbJ, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hQp, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.hQp, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.hQq, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eoh, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.hQr, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.hQs, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.fKZ != null) {
                this.fKZ.onChangeSkinType();
            }
            if (this.hQt != null) {
                this.hQt.onChangeSkinType();
            }
            am.setBackgroundResource(this.hQu, R.drawable.icon_news_red_dot);
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
            this.hQv = aVar;
            MetaData replyer = aVar.getReplyer();
            this.fCV.setVisibility(0);
            this.fCV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fCV.setPlaceHolder(1);
            this.fCV.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.fCV, replyer, 0);
            this.fCV.setTag(null);
            this.fCV.setPageId(this.cVg.getUniqueId());
            this.fCV.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.cbJ.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.hQp.setVisibility(0);
            } else {
                this.hQp.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.hQr.setVisibility(0);
                this.hQq.setVisibility(0);
                this.hQq.setText(aVar.getPostFrom());
            } else {
                this.hQr.setVisibility(8);
                this.hQq.setVisibility(8);
            }
            this.eoh.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aPN().b(this.cVg.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.hQs.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.aPN().b(this.cVg.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.hQs.setVisibility(0);
            }
            this.fKZ.b(aVar.getOriginalThreadInfo());
            this.fKZ.setSubClickListener(this.hQw);
            MessageCardBottomView messageCardBottomView = this.hQt;
            String fname = aVar.getFname();
            if (aVar.getType() == a.hQh || aVar.getType() == a.hQi) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.hQu.setVisibility(0);
            } else {
                this.hQu.setVisibility(8);
            }
            onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hQv != null || this.cVg != null) {
            if (view == this.fCV || view == this.cbJ) {
                if (this.hQv.getReplyer() != null) {
                    String userId = this.hQv.getReplyer().getUserId();
                    String userName = this.hQv.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cVg.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (buE() != null) {
                buE().a(view, this.hQv);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cVg == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.cVg.getPageActivity()) - (this.cVg.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
