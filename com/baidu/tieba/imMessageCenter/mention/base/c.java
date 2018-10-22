package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView aGD;
    public OriginalThreadCardView cOy;
    private HeadImageView cPa;
    private TextView dmH;
    private int ds42;
    private int ds48;
    private TextView eXP;
    private TextView eXQ;
    private View eXR;
    private View eXS;
    private MessageCardBottomView eXT;
    private View eXU;
    private a eXV;
    private OriginalThreadCardView.a eXW;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eXW = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eXV != null && c.this.eXV.aUQ() != null) {
                    am x = new am(c.this.eXV.aUQ()).x("obj_locate", 2);
                    if (c.this.eXV.getType() == a.eXK || c.this.eXV.getType() == a.eXG) {
                        x.x("obj_type", 1);
                    } else {
                        x.x("obj_type", 2);
                    }
                    TiebaStatic.log(x);
                }
                if (c.this.anP() != null) {
                    c.this.anP().a(c.this.cOy, c.this.eXV);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.h(this.mContext.getContext(), e.C0175e.tbds42);
        this.ds48 = l.h(this.mContext.getContext(), e.C0175e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cPa = (HeadImageView) view.findViewById(e.g.photo);
        this.aGD = (TextView) view.findViewById(e.g.user_name);
        this.eXP = (TextView) view.findViewById(e.g.fans_reply);
        this.eXQ = (TextView) view.findViewById(e.g.post_from);
        this.eXR = view.findViewById(e.g.divider_between_time_and_post_from);
        this.dmH = (TextView) view.findViewById(e.g.time);
        this.mTitle = (TextView) view.findViewById(e.g.card_message_title);
        this.eXS = view.findViewById(e.g.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(e.g.card_message_post_title);
        this.cOy = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.eXT = (MessageCardBottomView) view.findViewById(e.g.card_message_bottom_layout);
        this.eXU = view.findViewById(e.g.new_message);
        this.cPa.setOnClickListener(this);
        this.aGD.setOnClickListener(this);
        this.eXT.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.aGD, e.d.cp_cont_f);
            al.h(this.eXP, e.d.cp_cont_d);
            al.i(this.eXP, e.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.h(this.eXQ, e.d.cp_cont_d);
            al.h(this.dmH, e.d.cp_cont_d);
            al.j(this.eXR, e.d.cp_cont_e);
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.eXS, e.d.cp_bg_line_c);
            al.h(this.mSubTitle, e.d.cp_cont_j);
            if (this.cOy != null) {
                this.cOy.onChangeSkinType();
            }
            if (this.eXT != null) {
                this.eXT.onChangeSkinType();
            }
            al.i(this.eXU, e.f.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.eXV = aVar;
            this.cPa.setVisibility(0);
            this.cPa.setDefaultResource(e.f.icon_default_avatar100);
            this.cPa.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cPa.setDefaultBgResource(e.d.cp_bg_line_e);
            this.cPa.setIsRound(true);
            this.cPa.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cPa.setTag(null);
            this.cPa.setPageId(this.mContext.getUniqueId());
            this.cPa.startLoad(portrait, 12, false);
            this.aGD.setText(ao.d(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eXP.setVisibility(0);
            } else {
                this.eXP.setVisibility(8);
            }
            if (!ao.isEmpty(aVar.getPostFrom())) {
                this.eXR.setVisibility(0);
                this.eXQ.setVisibility(0);
                this.eXQ.setText(aVar.getPostFrom());
            } else {
                this.eXR.setVisibility(8);
                this.eXQ.setVisibility(8);
            }
            this.dmH.setText(ao.C(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.Md().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ao.isEmpty(aVar.getSubTitle())) {
                this.eXS.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.Md().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.eXS.setVisibility(0);
            }
            this.cOy.b(aVar.getOriginalThreadInfo());
            this.cOy.setSubClickListener(this.eXW);
            MessageCardBottomView messageCardBottomView = this.eXT;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eXG || aVar.getType() == a.eXH) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eXU.setVisibility(0);
            } else {
                this.eXU.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eXV != null || this.mContext != null) {
            if (view == this.cPa || view == this.aGD) {
                if (this.eXV.getReplyer() != null) {
                    String userId = this.eXV.getReplyer().getUserId();
                    String userName = this.eXV.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (anP() != null) {
                anP().a(view, this.eXV);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.aO(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
