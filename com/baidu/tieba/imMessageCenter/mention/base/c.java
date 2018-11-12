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
    private TextView aHt;
    public OriginalThreadCardView cPE;
    private HeadImageView cQg;
    private TextView dnM;
    private int ds42;
    private int ds48;
    private TextView eZh;
    private TextView eZi;
    private View eZj;
    private View eZk;
    private MessageCardBottomView eZl;
    private View eZm;
    private a eZn;
    private OriginalThreadCardView.a eZo;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mSubTitle;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eZo = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eZn != null && c.this.eZn.aUn() != null) {
                    am x = new am(c.this.eZn.aUn()).x("obj_locate", 2);
                    if (c.this.eZn.getType() == a.eZc || c.this.eZn.getType() == a.eYY) {
                        x.x("obj_type", 1);
                    } else {
                        x.x("obj_type", 2);
                    }
                    TiebaStatic.log(x);
                }
                if (c.this.anq() != null) {
                    c.this.anq().a(c.this.cPE, c.this.eZn);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.h(this.mContext.getContext(), e.C0200e.tbds42);
        this.ds48 = l.h(this.mContext.getContext(), e.C0200e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cQg = (HeadImageView) view.findViewById(e.g.photo);
        this.aHt = (TextView) view.findViewById(e.g.user_name);
        this.eZh = (TextView) view.findViewById(e.g.fans_reply);
        this.eZi = (TextView) view.findViewById(e.g.post_from);
        this.eZj = view.findViewById(e.g.divider_between_time_and_post_from);
        this.dnM = (TextView) view.findViewById(e.g.time);
        this.mTitle = (TextView) view.findViewById(e.g.card_message_title);
        this.eZk = view.findViewById(e.g.card_message_divider_line);
        this.mSubTitle = (TextView) view.findViewById(e.g.card_message_post_title);
        this.cPE = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.eZl = (MessageCardBottomView) view.findViewById(e.g.card_message_bottom_layout);
        this.eZm = view.findViewById(e.g.new_message);
        this.cQg.setOnClickListener(this);
        this.aHt.setOnClickListener(this);
        this.eZl.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.aHt, e.d.cp_cont_f);
            al.h(this.eZh, e.d.cp_cont_d);
            al.i(this.eZh, e.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.h(this.eZi, e.d.cp_cont_d);
            al.h(this.dnM, e.d.cp_cont_d);
            al.j(this.eZj, e.d.cp_cont_e);
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.eZk, e.d.cp_bg_line_c);
            al.h(this.mSubTitle, e.d.cp_cont_j);
            if (this.cPE != null) {
                this.cPE.onChangeSkinType();
            }
            if (this.eZl != null) {
                this.eZl.onChangeSkinType();
            }
            al.i(this.eZm, e.f.icon_news_red_dot);
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
            this.eZn = aVar;
            this.cQg.setVisibility(0);
            this.cQg.setDefaultResource(e.f.icon_default_avatar100);
            this.cQg.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cQg.setDefaultBgResource(e.d.cp_bg_line_e);
            this.cQg.setIsRound(true);
            this.cQg.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cQg.setTag(null);
            this.cQg.setPageId(this.mContext.getUniqueId());
            this.cQg.startLoad(portrait, 12, false);
            this.aHt.setText(ao.d(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eZh.setVisibility(0);
            } else {
                this.eZh.setVisibility(8);
            }
            if (!ao.isEmpty(aVar.getPostFrom())) {
                this.eZj.setVisibility(0);
                this.eZi.setVisibility(0);
                this.eZi.setText(aVar.getPostFrom());
            } else {
                this.eZj.setVisibility(8);
                this.eZi.setVisibility(8);
            }
            this.dnM.setText(ao.E(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.Mp().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ao.isEmpty(aVar.getSubTitle())) {
                this.eZk.setVisibility(8);
                this.mSubTitle.setVisibility(8);
            } else {
                this.mSubTitle.setText(a(this.mSubTitle, TbFaceManager.Mp().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.mSubTitle.setVisibility(0);
                this.eZk.setVisibility(0);
            }
            this.cPE.b(aVar.getOriginalThreadInfo());
            this.cPE.setSubClickListener(this.eZo);
            MessageCardBottomView messageCardBottomView = this.eZl;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eYY || aVar.getType() == a.eYZ) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eZm.setVisibility(0);
            } else {
                this.eZm.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eZn != null || this.mContext != null) {
            if (view == this.cQg || view == this.aHt) {
                if (this.eZn.getReplyer() != null) {
                    String userId = this.eZn.getReplyer().getUserId();
                    String userName = this.eZn.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (anq() != null) {
                anq().a(view, this.eZn);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.aO(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
