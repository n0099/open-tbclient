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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView ayt;
    private HeadImageView cAv;
    private TextView cXR;
    public OriginalThreadCardView czT;
    private int ds42;
    private int ds48;
    private TextView eBl;
    private TextView eBm;
    private View eBn;
    private View eBo;
    private TextView eBp;
    private MessageCardBottomView eBq;
    private View eBr;
    private a eBs;
    private OriginalThreadCardView.a eBt;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eBt = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eBs != null && c.this.eBs.aNM() != null) {
                    am r = new am(c.this.eBs.aNM()).r("obj_locate", 2);
                    if (c.this.eBs.getType() == a.eBg || c.this.eBs.getType() == a.eBc) {
                        r.r("obj_type", 1);
                    } else {
                        r.r("obj_type", 2);
                    }
                    TiebaStatic.log(r);
                }
                if (c.this.aiI() != null) {
                    c.this.aiI().a(c.this.czT, c.this.eBs);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.e(this.mContext.getContext(), d.e.tbds42);
        this.ds48 = l.e(this.mContext.getContext(), d.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cAv = (HeadImageView) view.findViewById(d.g.photo);
        this.ayt = (TextView) view.findViewById(d.g.user_name);
        this.eBl = (TextView) view.findViewById(d.g.fans_reply);
        this.eBm = (TextView) view.findViewById(d.g.post_from);
        this.eBn = view.findViewById(d.g.divider_between_time_and_post_from);
        this.cXR = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.eBo = view.findViewById(d.g.card_message_divider_line);
        this.eBp = (TextView) view.findViewById(d.g.card_message_post_title);
        this.czT = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.eBq = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.eBr = view.findViewById(d.g.new_message);
        this.cAv.setOnClickListener(this);
        this.ayt.setOnClickListener(this);
        this.eBq.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(getView(), d.f.addresslist_item_bg);
            al.h(this.ayt, d.C0141d.cp_cont_f);
            al.h(this.eBl, d.C0141d.cp_cont_d);
            al.i(this.eBl, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.h(this.eBm, d.C0141d.cp_cont_d);
            al.h(this.cXR, d.C0141d.cp_cont_d);
            al.j(this.eBn, d.C0141d.cp_cont_e);
            al.h(this.mTitle, d.C0141d.cp_cont_b);
            al.j(this.eBo, d.C0141d.cp_bg_line_c);
            al.h(this.eBp, d.C0141d.cp_cont_j);
            if (this.czT != null) {
                this.czT.onChangeSkinType();
            }
            if (this.eBq != null) {
                this.eBq.onChangeSkinType();
            }
            al.i(this.eBr, d.f.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.eBs = aVar;
            this.cAv.setVisibility(0);
            this.cAv.setDefaultResource(d.f.icon_default_avatar100);
            this.cAv.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cAv.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.cAv.setIsRound(true);
            this.cAv.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cAv.setTag(null);
            this.cAv.setPageId(this.mContext.getUniqueId());
            this.cAv.startLoad(portrait, 12, false);
            this.ayt.setText(ao.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eBl.setVisibility(0);
            } else {
                this.eBl.setVisibility(8);
            }
            if (!ao.isEmpty(aVar.getPostFrom())) {
                this.eBn.setVisibility(0);
                this.eBm.setVisibility(0);
                this.eBm.setText(aVar.getPostFrom());
            } else {
                this.eBn.setVisibility(8);
                this.eBm.setVisibility(8);
            }
            this.cXR.setText(ao.v(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.IC().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ao.isEmpty(aVar.getSubTitle())) {
                this.eBo.setVisibility(8);
                this.eBp.setVisibility(8);
            } else {
                this.eBp.setText(a(this.eBp, TbFaceManager.IC().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eBp.setVisibility(0);
                this.eBo.setVisibility(0);
            }
            this.czT.b(aVar.getOriginalThreadInfo());
            this.czT.setSubClickListener(this.eBt);
            MessageCardBottomView messageCardBottomView = this.eBq;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eBc || aVar.getType() == a.eBd) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eBr.setVisibility(0);
            } else {
                this.eBr.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eBs != null || this.mContext != null) {
            if (view == this.cAv || view == this.ayt) {
                if (this.eBs.getReplyer() != null) {
                    String userId = this.eBs.getReplyer().getUserId();
                    String userName = this.eBs.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aiI() != null) {
                aiI().a(view, this.eBs);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.ah(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
