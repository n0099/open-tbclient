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
    private TextView aGj;
    private TextView bUa;
    private int ds42;
    private int ds48;
    private TextView eKM;
    private HeadImageView ejM;
    public OriginalThreadCardView ejm;
    private TextView gzo;
    private TextView gzp;
    private View gzq;
    private View gzr;
    private MessageCardBottomView gzs;
    private View gzt;
    private a gzu;
    private OriginalThreadCardView.a gzv;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gzv = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gzu != null && c.this.gzu.bxR() != null) {
                    am T = new am(c.this.gzu.bxR()).T("obj_locate", 2);
                    if (c.this.gzu.getType() == a.gzk || c.this.gzu.getType() == a.gzg) {
                        T.T("obj_type", 1);
                    } else {
                        T.T("obj_type", 2);
                    }
                    TiebaStatic.log(T);
                }
                if (c.this.aQf() != null) {
                    c.this.aQf().a(c.this.ejm, c.this.gzu);
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
        this.ejM = (HeadImageView) view.findViewById(d.g.photo);
        this.bUa = (TextView) view.findViewById(d.g.user_name);
        this.gzo = (TextView) view.findViewById(d.g.fans_reply);
        this.gzp = (TextView) view.findViewById(d.g.post_from);
        this.gzq = view.findViewById(d.g.divider_between_time_and_post_from);
        this.eKM = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.gzr = view.findViewById(d.g.card_message_divider_line);
        this.aGj = (TextView) view.findViewById(d.g.card_message_post_title);
        this.ejm = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.gzs = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.gzt = view.findViewById(d.g.new_message);
        this.ejM.setOnClickListener(this);
        this.bUa.setOnClickListener(this);
        this.gzs.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(getView(), d.f.addresslist_item_bg);
            al.j(this.bUa, d.C0277d.cp_cont_f);
            al.j(this.gzo, d.C0277d.cp_cont_d);
            al.k(this.gzo, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.j(this.gzp, d.C0277d.cp_cont_d);
            al.j(this.eKM, d.C0277d.cp_cont_d);
            al.l(this.gzq, d.C0277d.cp_cont_e);
            al.j(this.mTitle, d.C0277d.cp_cont_b);
            al.l(this.gzr, d.C0277d.cp_bg_line_c);
            al.j(this.aGj, d.C0277d.cp_cont_j);
            if (this.ejm != null) {
                this.ejm.onChangeSkinType();
            }
            if (this.gzs != null) {
                this.gzs.onChangeSkinType();
            }
            al.k(this.gzt, d.f.icon_news_red_dot);
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
            this.gzu = aVar;
            this.ejM.setVisibility(0);
            this.ejM.setDefaultResource(d.f.icon_default_avatar100);
            this.ejM.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ejM.setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ejM.setIsRound(true);
            this.ejM.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.ejM.setTag(null);
            this.ejM.setPageId(this.mContext.getUniqueId());
            this.ejM.startLoad(portrait, 12, false);
            this.bUa.setText(ap.g(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gzo.setVisibility(0);
            } else {
                this.gzo.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.gzq.setVisibility(0);
                this.gzp.setVisibility(0);
                this.gzp.setText(aVar.getPostFrom());
            } else {
                this.gzq.setVisibility(8);
                this.gzp.setVisibility(8);
            }
            this.eKM.setText(ap.ao(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.anl().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.gzr.setVisibility(8);
                this.aGj.setVisibility(8);
            } else {
                this.aGj.setText(a(this.aGj, TbFaceManager.anl().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aGj.setVisibility(0);
                this.gzr.setVisibility(0);
            }
            this.ejm.b(aVar.getOriginalThreadInfo());
            this.ejm.setSubClickListener(this.gzv);
            MessageCardBottomView messageCardBottomView = this.gzs;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gzg || aVar.getType() == a.gzh) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gzt.setVisibility(0);
            } else {
                this.gzt.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gzu != null || this.mContext != null) {
            if (view == this.ejM || view == this.bUa) {
                if (this.gzu.getReplyer() != null) {
                    String userId = this.gzu.getReplyer().getUserId();
                    String userName = this.gzu.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aQf() != null) {
                aQf().a(view, this.gzu);
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
