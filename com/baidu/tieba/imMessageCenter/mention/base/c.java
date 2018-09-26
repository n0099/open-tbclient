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
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView aBX;
    private HeadImageView cGG;
    public OriginalThreadCardView cGe;
    private TextView deC;
    private int ds42;
    private int ds48;
    private TextView eQg;
    private TextView eQh;
    private View eQi;
    private View eQj;
    private TextView eQk;
    private MessageCardBottomView eQl;
    private View eQm;
    private a eQn;
    private OriginalThreadCardView.a eQo;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eQo = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eQn != null && c.this.eQn.aRC() != null) {
                    am w = new am(c.this.eQn.aRC()).w("obj_locate", 2);
                    if (c.this.eQn.getType() == a.eQb || c.this.eQn.getType() == a.ePX) {
                        w.w("obj_type", 1);
                    } else {
                        w.w("obj_type", 2);
                    }
                    TiebaStatic.log(w);
                }
                if (c.this.akm() != null) {
                    c.this.akm().a(c.this.cGe, c.this.eQn);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.h(this.mContext.getContext(), e.C0141e.tbds42);
        this.ds48 = l.h(this.mContext.getContext(), e.C0141e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cGG = (HeadImageView) view.findViewById(e.g.photo);
        this.aBX = (TextView) view.findViewById(e.g.user_name);
        this.eQg = (TextView) view.findViewById(e.g.fans_reply);
        this.eQh = (TextView) view.findViewById(e.g.post_from);
        this.eQi = view.findViewById(e.g.divider_between_time_and_post_from);
        this.deC = (TextView) view.findViewById(e.g.time);
        this.mTitle = (TextView) view.findViewById(e.g.card_message_title);
        this.eQj = view.findViewById(e.g.card_message_divider_line);
        this.eQk = (TextView) view.findViewById(e.g.card_message_post_title);
        this.cGe = (OriginalThreadCardView) view.findViewById(e.g.original_thread_view);
        this.eQl = (MessageCardBottomView) view.findViewById(e.g.card_message_bottom_layout);
        this.eQm = view.findViewById(e.g.new_message);
        this.cGG.setOnClickListener(this);
        this.aBX.setOnClickListener(this);
        this.eQl.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.aBX, e.d.cp_cont_f);
            al.h(this.eQg, e.d.cp_cont_d);
            al.i(this.eQg, e.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.h(this.eQh, e.d.cp_cont_d);
            al.h(this.deC, e.d.cp_cont_d);
            al.j(this.eQi, e.d.cp_cont_e);
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.eQj, e.d.cp_bg_line_c);
            al.h(this.eQk, e.d.cp_cont_j);
            if (this.cGe != null) {
                this.cGe.onChangeSkinType();
            }
            if (this.eQl != null) {
                this.eQl.onChangeSkinType();
            }
            al.i(this.eQm, e.f.icon_news_red_dot);
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
            this.eQn = aVar;
            this.cGG.setVisibility(0);
            this.cGG.setDefaultResource(e.f.icon_default_avatar100);
            this.cGG.setDefaultErrorResource(e.f.icon_default_avatar100);
            this.cGG.setDefaultBgResource(e.d.cp_bg_line_e);
            this.cGG.setIsRound(true);
            this.cGG.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cGG.setTag(null);
            this.cGG.setPageId(this.mContext.getUniqueId());
            this.cGG.startLoad(portrait, 12, false);
            this.aBX.setText(ao.d(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eQg.setVisibility(0);
            } else {
                this.eQg.setVisibility(8);
            }
            if (!ao.isEmpty(aVar.getPostFrom())) {
                this.eQi.setVisibility(0);
                this.eQh.setVisibility(0);
                this.eQh.setText(aVar.getPostFrom());
            } else {
                this.eQi.setVisibility(8);
                this.eQh.setVisibility(8);
            }
            this.deC.setText(ao.A(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.Kf().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ao.isEmpty(aVar.getSubTitle())) {
                this.eQj.setVisibility(8);
                this.eQk.setVisibility(8);
            } else {
                this.eQk.setText(a(this.eQk, TbFaceManager.Kf().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eQk.setVisibility(0);
                this.eQj.setVisibility(0);
            }
            this.cGe.b(aVar.getOriginalThreadInfo());
            this.cGe.setSubClickListener(this.eQo);
            MessageCardBottomView messageCardBottomView = this.eQl;
            String fname = aVar.getFname();
            if (aVar.getType() == a.ePX || aVar.getType() == a.ePY) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eQm.setVisibility(0);
            } else {
                this.eQm.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eQn != null || this.mContext != null) {
            if (view == this.cGG || view == this.aBX) {
                if (this.eQn.getReplyer() != null) {
                    String userId = this.eQn.getReplyer().getUserId();
                    String userName = this.eQn.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (akm() != null) {
                akm().a(view, this.eQn);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.aO(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
