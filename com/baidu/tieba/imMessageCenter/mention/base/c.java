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
    private TextView aKV;
    private HeadImageView cZD;
    public OriginalThreadCardView cZb;
    private int ds42;
    private int ds48;
    private TextView dxa;
    private TextView fiP;
    private TextView fiQ;
    private View fiR;
    private View fiS;
    private MessageCardBottomView fiT;
    private View fiU;
    private a fiV;
    private OriginalThreadCardView.a fiW;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.fiW = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.fiV != null && c.this.fiV.aWS() != null) {
                    am x = new am(c.this.fiV.aWS()).x("obj_locate", 2);
                    if (c.this.fiV.getType() == a.fiK || c.this.fiV.getType() == a.fiG) {
                        x.x("obj_type", 1);
                    } else {
                        x.x("obj_type", 2);
                    }
                    TiebaStatic.log(x);
                }
                if (c.this.apS() != null) {
                    c.this.apS().a(c.this.cZb, c.this.fiV);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.h(this.mContext.getContext(), e.C0210e.tbds42);
        this.ds48 = l.h(this.mContext.getContext(), e.C0210e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cZD = (HeadImageView) view.findViewById(e.g.photo);
        this.aKV = (TextView) view.findViewById(e.g.user_name);
        this.fiP = (TextView) view.findViewById(e.g.fans_reply);
        this.fiQ = (TextView) view.findViewById(e.g.post_from);
        this.fiR = view.findViewById(e.g.divider_between_time_and_post_from);
        this.dxa = (TextView) view.findViewById(e.g.time);
        this.mTitle = (TextView) view.findViewById(e.g.card_message_title);
        this.fiS = view.findViewById(e.g.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(e.g.card_message_post_title);
        this.cZb = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.fiT = (MessageCardBottomView) view.findViewById(e.g.card_message_bottom_layout);
        this.fiU = view.findViewById(e.g.new_message);
        this.cZD.setOnClickListener(this);
        this.aKV.setOnClickListener(this);
        this.fiT.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.aKV, e.d.cp_cont_f);
            al.h(this.fiP, e.d.cp_cont_d);
            al.i(this.fiP, e.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.h(this.fiQ, e.d.cp_cont_d);
            al.h(this.dxa, e.d.cp_cont_d);
            al.j(this.fiR, e.d.cp_cont_e);
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.fiS, e.d.cp_bg_line_c);
            al.h(this.mSubTitle, e.d.cp_cont_j);
            if (this.cZb != null) {
                this.cZb.onChangeSkinType();
            }
            if (this.fiT != null) {
                this.fiT.onChangeSkinType();
            }
            al.i(this.fiU, e.f.icon_news_red_dot);
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
            this.fiV = aVar;
            this.cZD.setVisibility(0);
            this.cZD.setDefaultResource(e.f.icon_default_avatar100);
            this.cZD.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cZD.setDefaultBgResource(e.d.cp_bg_line_e);
            this.cZD.setIsRound(true);
            this.cZD.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cZD.setTag(null);
            this.cZD.setPageId(this.mContext.getUniqueId());
            this.cZD.startLoad(portrait, 12, false);
            this.aKV.setText(ao.d(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.fiP.setVisibility(0);
            } else {
                this.fiP.setVisibility(8);
            }
            if (!ao.isEmpty(aVar.getPostFrom())) {
                this.fiR.setVisibility(0);
                this.fiQ.setVisibility(0);
                this.fiQ.setText(aVar.getPostFrom());
            } else {
                this.fiR.setVisibility(8);
                this.fiQ.setVisibility(8);
            }
            this.dxa.setText(ao.M(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.Nu().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ao.isEmpty(aVar.getSubTitle())) {
                this.fiS.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.Nu().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.fiS.setVisibility(0);
            }
            this.cZb.b(aVar.getOriginalThreadInfo());
            this.cZb.setSubClickListener(this.fiW);
            MessageCardBottomView messageCardBottomView = this.fiT;
            String fname = aVar.getFname();
            if (aVar.getType() == a.fiG || aVar.getType() == a.fiH) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.fiU.setVisibility(0);
            } else {
                this.fiU.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fiV != null || this.mContext != null) {
            if (view == this.cZD || view == this.aKV) {
                if (this.fiV.getReplyer() != null) {
                    String userId = this.fiV.getReplyer().getUserId();
                    String userName = this.fiV.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (apS() != null) {
                apS().a(view, this.fiV);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.aO(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
