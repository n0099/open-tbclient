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
    private TbPageContext cVh;
    private TextView cbK;
    private int ds42;
    private int ds48;
    private TextView eoi;
    private HeadImageView fCX;
    public OriginalThreadCardView fLb;
    private TextView hQr;
    private TextView hQs;
    private View hQt;
    private View hQu;
    private MessageCardBottomView hQv;
    private View hQw;
    private a hQx;
    private OriginalThreadCardView.a hQy;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.hQy = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.hQx != null && c.this.hQx.bZT() != null) {
                    an X = new an(c.this.hQx.bZT()).X("obj_locate", 2);
                    if (c.this.hQx.getType() == a.hQn || c.this.hQx.getType() == a.hQj) {
                        X.X("obj_type", 1);
                    } else {
                        X.X("obj_type", 2);
                    }
                    TiebaStatic.log(X);
                }
                if (c.this.buG() != null) {
                    c.this.buG().a(c.this.fLb, c.this.hQx);
                }
            }
        };
        this.cVh = tbPageContext;
        this.ds42 = l.getDimens(this.cVh.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.cVh.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fCX = (HeadImageView) view.findViewById(R.id.photo);
        this.cbK = (TextView) view.findViewById(R.id.user_name);
        this.hQr = (TextView) view.findViewById(R.id.fans_reply);
        this.hQs = (TextView) view.findViewById(R.id.post_from);
        this.hQt = view.findViewById(R.id.divider_between_time_and_post_from);
        this.eoi = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.hQu = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.fLb = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hQv = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.hQw = view.findViewById(R.id.new_message);
        this.fLb.setUsePlaceHolder(false);
        this.fCX.setOnClickListener(this);
        this.cbK.setOnClickListener(this);
        this.hQv.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
            am.setViewTextColor(this.cbK, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hQr, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.hQr, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.hQs, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eoi, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.hQt, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.hQu, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.fLb != null) {
                this.fLb.onChangeSkinType();
            }
            if (this.hQv != null) {
                this.hQv.onChangeSkinType();
            }
            am.setBackgroundResource(this.hQw, R.drawable.icon_news_red_dot);
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
            this.hQx = aVar;
            MetaData replyer = aVar.getReplyer();
            this.fCX.setVisibility(0);
            this.fCX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fCX.setPlaceHolder(1);
            this.fCX.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.fCX, replyer, 0);
            this.fCX.setTag(null);
            this.fCX.setPageId(this.cVh.getUniqueId());
            this.fCX.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.cbK.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.hQr.setVisibility(0);
            } else {
                this.hQr.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.hQt.setVisibility(0);
                this.hQs.setVisibility(0);
                this.hQs.setText(aVar.getPostFrom());
            } else {
                this.hQt.setVisibility(8);
                this.hQs.setVisibility(8);
            }
            this.eoi.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aPP().b(this.cVh.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.hQu.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.aPP().b(this.cVh.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.hQu.setVisibility(0);
            }
            this.fLb.b(aVar.getOriginalThreadInfo());
            this.fLb.setSubClickListener(this.hQy);
            MessageCardBottomView messageCardBottomView = this.hQv;
            String fname = aVar.getFname();
            if (aVar.getType() == a.hQj || aVar.getType() == a.hQk) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.hQw.setVisibility(0);
            } else {
                this.hQw.setVisibility(8);
            }
            onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hQx != null || this.cVh != null) {
            if (view == this.fCX || view == this.cbK) {
                if (this.hQx.getReplyer() != null) {
                    String userId = this.hQx.getReplyer().getUserId();
                    String userName = this.hQx.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cVh.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (buG() != null) {
                buG().a(view, this.hQx);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cVh == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.cVh.getPageActivity()) - (this.cVh.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
