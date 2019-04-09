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
    private TextView aGk;
    private TextView bUb;
    private int ds42;
    private int ds48;
    private TextView eKN;
    private HeadImageView ejN;
    public OriginalThreadCardView ejn;
    private TextView gzp;
    private TextView gzq;
    private View gzr;
    private View gzs;
    private MessageCardBottomView gzt;
    private View gzu;
    private a gzv;
    private OriginalThreadCardView.a gzw;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gzw = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gzv != null && c.this.gzv.bxR() != null) {
                    am T = new am(c.this.gzv.bxR()).T("obj_locate", 2);
                    if (c.this.gzv.getType() == a.gzl || c.this.gzv.getType() == a.gzh) {
                        T.T("obj_type", 1);
                    } else {
                        T.T("obj_type", 2);
                    }
                    TiebaStatic.log(T);
                }
                if (c.this.aQf() != null) {
                    c.this.aQf().a(c.this.ejn, c.this.gzv);
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
        this.ejN = (HeadImageView) view.findViewById(d.g.photo);
        this.bUb = (TextView) view.findViewById(d.g.user_name);
        this.gzp = (TextView) view.findViewById(d.g.fans_reply);
        this.gzq = (TextView) view.findViewById(d.g.post_from);
        this.gzr = view.findViewById(d.g.divider_between_time_and_post_from);
        this.eKN = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.gzs = view.findViewById(d.g.card_message_divider_line);
        this.aGk = (TextView) view.findViewById(d.g.card_message_post_title);
        this.ejn = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.gzt = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.gzu = view.findViewById(d.g.new_message);
        this.ejN.setOnClickListener(this);
        this.bUb.setOnClickListener(this);
        this.gzt.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(getView(), d.f.addresslist_item_bg);
            al.j(this.bUb, d.C0277d.cp_cont_f);
            al.j(this.gzp, d.C0277d.cp_cont_d);
            al.k(this.gzp, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.j(this.gzq, d.C0277d.cp_cont_d);
            al.j(this.eKN, d.C0277d.cp_cont_d);
            al.l(this.gzr, d.C0277d.cp_cont_e);
            al.j(this.mTitle, d.C0277d.cp_cont_b);
            al.l(this.gzs, d.C0277d.cp_bg_line_c);
            al.j(this.aGk, d.C0277d.cp_cont_j);
            if (this.ejn != null) {
                this.ejn.onChangeSkinType();
            }
            if (this.gzt != null) {
                this.gzt.onChangeSkinType();
            }
            al.k(this.gzu, d.f.icon_news_red_dot);
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
            this.gzv = aVar;
            this.ejN.setVisibility(0);
            this.ejN.setDefaultResource(d.f.icon_default_avatar100);
            this.ejN.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.ejN.setDefaultBgResource(d.C0277d.cp_bg_line_e);
            this.ejN.setIsRound(true);
            this.ejN.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.ejN.setTag(null);
            this.ejN.setPageId(this.mContext.getUniqueId());
            this.ejN.startLoad(portrait, 12, false);
            this.bUb.setText(ap.g(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gzp.setVisibility(0);
            } else {
                this.gzp.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.gzr.setVisibility(0);
                this.gzq.setVisibility(0);
                this.gzq.setText(aVar.getPostFrom());
            } else {
                this.gzr.setVisibility(8);
                this.gzq.setVisibility(8);
            }
            this.eKN.setText(ap.ao(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.anl().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.gzs.setVisibility(8);
                this.aGk.setVisibility(8);
            } else {
                this.aGk.setText(a(this.aGk, TbFaceManager.anl().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aGk.setVisibility(0);
                this.gzs.setVisibility(0);
            }
            this.ejn.b(aVar.getOriginalThreadInfo());
            this.ejn.setSubClickListener(this.gzw);
            MessageCardBottomView messageCardBottomView = this.gzt;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gzh || aVar.getType() == a.gzi) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gzu.setVisibility(0);
            } else {
                this.gzu.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gzv != null || this.mContext != null) {
            if (view == this.ejN || view == this.bUb) {
                if (this.gzv.getReplyer() != null) {
                    String userId = this.gzv.getReplyer().getUserId();
                    String userName = this.gzv.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aQf() != null) {
                aQf().a(view, this.gzv);
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
