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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView aGg;
    private TextView bTY;
    private int ds42;
    private int ds48;
    private TextView eLa;
    public OriginalThreadCardView ejA;
    private HeadImageView eka;
    private TextView gzB;
    private TextView gzC;
    private View gzD;
    private View gzE;
    private MessageCardBottomView gzF;
    private View gzG;
    private a gzH;
    private OriginalThreadCardView.a gzI;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gzI = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gzH != null && c.this.gzH.bxU() != null) {
                    am T = new am(c.this.gzH.bxU()).T("obj_locate", 2);
                    if (c.this.gzH.getType() == a.gzx || c.this.gzH.getType() == a.gzt) {
                        T.T("obj_type", 1);
                    } else {
                        T.T("obj_type", 2);
                    }
                    TiebaStatic.log(T);
                }
                if (c.this.aQh() != null) {
                    c.this.aQh().a(c.this.ejA, c.this.gzH);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.h(this.mContext.getContext(), d.e.tbds42);
        this.ds48 = l.h(this.mContext.getContext(), d.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.eka = (HeadImageView) view.findViewById(d.g.photo);
        this.bTY = (TextView) view.findViewById(d.g.user_name);
        this.gzB = (TextView) view.findViewById(d.g.fans_reply);
        this.gzC = (TextView) view.findViewById(d.g.post_from);
        this.gzD = view.findViewById(d.g.divider_between_time_and_post_from);
        this.eLa = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.gzE = view.findViewById(d.g.card_message_divider_line);
        this.aGg = (TextView) view.findViewById(d.g.card_message_post_title);
        this.ejA = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.gzF = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.gzG = view.findViewById(d.g.new_message);
        this.eka.setOnClickListener(this);
        this.bTY.setOnClickListener(this);
        this.gzF.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(getView(), d.f.addresslist_item_bg);
            al.j(this.bTY, d.C0277d.cp_cont_f);
            al.j(this.gzB, d.C0277d.cp_cont_d);
            al.k(this.gzB, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.j(this.gzC, d.C0277d.cp_cont_d);
            al.j(this.eLa, d.C0277d.cp_cont_d);
            al.l(this.gzD, d.C0277d.cp_cont_e);
            al.j(this.mTitle, d.C0277d.cp_cont_b);
            al.l(this.gzE, d.C0277d.cp_bg_line_c);
            al.j(this.aGg, d.C0277d.cp_cont_j);
            if (this.ejA != null) {
                this.ejA.onChangeSkinType();
            }
            if (this.gzF != null) {
                this.gzF.onChangeSkinType();
            }
            al.k(this.gzG, d.f.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.gzH = aVar;
            this.eka.setVisibility(0);
            this.eka.setDefaultResource(d.f.icon_default_avatar100);
            this.eka.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.eka.setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.eka.setIsRound(true);
            this.eka.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eka.setTag(null);
            this.eka.setPageId(this.mContext.getUniqueId());
            this.eka.startLoad(portrait, 12, false);
            this.bTY.setText(ap.g(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gzB.setVisibility(0);
            } else {
                this.gzB.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.gzD.setVisibility(0);
                this.gzC.setVisibility(0);
                this.gzC.setText(aVar.getPostFrom());
            } else {
                this.gzD.setVisibility(8);
                this.gzC.setVisibility(8);
            }
            this.eLa.setText(ap.ao(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.ano().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.gzE.setVisibility(8);
                this.aGg.setVisibility(8);
            } else {
                this.aGg.setText(a(this.aGg, TbFaceManager.ano().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aGg.setVisibility(0);
                this.gzE.setVisibility(0);
            }
            this.ejA.b(aVar.getOriginalThreadInfo());
            this.ejA.setSubClickListener(this.gzI);
            MessageCardBottomView messageCardBottomView = this.gzF;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gzt || aVar.getType() == a.gzu) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gzG.setVisibility(0);
            } else {
                this.gzG.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gzH != null || this.mContext != null) {
            if (view == this.eka || view == this.bTY) {
                if (this.gzH.getReplyer() != null) {
                    String userId = this.gzH.getReplyer().getUserId();
                    String userName = this.gzH.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aQh() != null) {
                aQh().a(view, this.gzH);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.aO(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
