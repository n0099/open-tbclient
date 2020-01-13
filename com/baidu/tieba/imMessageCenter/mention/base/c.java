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
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView bXF;
    private TbPageContext cRe;
    private int ds42;
    private int ds48;
    private TextView ejW;
    private HeadImageView fAx;
    public OriginalThreadCardView fIC;
    private TextView hOr;
    private TextView hOs;
    private View hOt;
    private View hOu;
    private MessageCardBottomView hOv;
    private View hOw;
    private a hOx;
    private OriginalThreadCardView.a hOy;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.hOy = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.hOx != null && c.this.hOx.bYq() != null) {
                    an Z = new an(c.this.hOx.bYq()).Z("obj_locate", 2);
                    if (c.this.hOx.getType() == a.hOn || c.this.hOx.getType() == a.hOj) {
                        Z.Z("obj_type", 1);
                    } else {
                        Z.Z("obj_type", 2);
                    }
                    TiebaStatic.log(Z);
                }
                if (c.this.bta() != null) {
                    c.this.bta().a(c.this.fIC, c.this.hOx);
                }
            }
        };
        this.cRe = tbPageContext;
        this.ds42 = l.getDimens(this.cRe.getContext(), R.dimen.tbds42);
        this.ds48 = l.getDimens(this.cRe.getContext(), R.dimen.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fAx = (HeadImageView) view.findViewById(R.id.photo);
        this.bXF = (TextView) view.findViewById(R.id.user_name);
        this.hOr = (TextView) view.findViewById(R.id.fans_reply);
        this.hOs = (TextView) view.findViewById(R.id.post_from);
        this.hOt = view.findViewById(R.id.divider_between_time_and_post_from);
        this.ejW = (TextView) view.findViewById(R.id.time);
        this.mTitle = (TextView) view.findViewById(R.id.card_message_title);
        this.hOu = view.findViewById(R.id.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(R.id.card_message_post_title);
        this.fIC = (OriginalThreadCardView) view.findViewById(R.id.original_thread_view);
        this.hOv = (MessageCardBottomView) view.findViewById(R.id.card_message_bottom_layout);
        this.hOw = view.findViewById(R.id.new_message);
        this.fIC.setUsePlaceHolder(false);
        this.fAx.setOnClickListener(this);
        this.bXF.setOnClickListener(this);
        this.hOv.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            getView().setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
            am.setViewTextColor(this.bXF, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hOr, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.hOr, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            am.setViewTextColor(this.hOs, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ejW, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.hOt, R.color.cp_cont_e);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.hOu, R.color.cp_bg_line_c);
            am.setViewTextColor(this.mSubTitle, (int) R.color.cp_cont_j);
            if (this.fIC != null) {
                this.fIC.onChangeSkinType();
            }
            if (this.hOv != null) {
                this.hOv.onChangeSkinType();
            }
            am.setBackgroundResource(this.hOw, R.drawable.icon_news_red_dot);
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
            this.hOx = aVar;
            MetaData replyer = aVar.getReplyer();
            this.fAx.setVisibility(0);
            this.fAx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
            this.fAx.setPlaceHolder(1);
            this.fAx.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(this.fAx, replyer, 0);
            this.fAx.setTag(null);
            this.fAx.setPageId(this.cRe.getUniqueId());
            this.fAx.startLoad(aVar.getReplyer().getAvater(), 12, false);
            this.bXF.setText(aq.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(replyer), 14, StringHelper.STRING_MORE));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.hOr.setVisibility(0);
            } else {
                this.hOr.setVisibility(8);
            }
            if (!aq.isEmpty(aVar.getPostFrom())) {
                this.hOt.setVisibility(0);
                this.hOs.setVisibility(0);
                this.hOs.setText(aVar.getPostFrom());
            } else {
                this.hOt.setVisibility(8);
                this.hOs.setVisibility(8);
            }
            this.ejW.setText(aq.getFormatTime(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.aNr().b(this.cRe.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (aq.isEmpty(aVar.getSubTitle())) {
                this.hOu.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.aNr().b(this.cRe.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.hOu.setVisibility(0);
            }
            this.fIC.b(aVar.getOriginalThreadInfo());
            this.fIC.setSubClickListener(this.hOy);
            MessageCardBottomView messageCardBottomView = this.hOv;
            String fname = aVar.getFname();
            if (aVar.getType() == a.hOj || aVar.getType() == a.hOk) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.hOw.setVisibility(0);
            } else {
                this.hOw.setVisibility(8);
            }
            onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hOx != null || this.cRe != null) {
            if (view == this.fAx || view == this.bXF) {
                if (this.hOx.getReplyer() != null) {
                    String userId = this.hOx.getReplyer().getUserId();
                    String userName = this.hOx.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.cRe.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (bta() != null) {
                bta().a(view, this.hOx);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cRe == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.getEquipmentWidth(this.cRe.getPageActivity()) - (this.cRe.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
