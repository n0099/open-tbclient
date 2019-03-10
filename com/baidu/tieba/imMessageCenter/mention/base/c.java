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
    private TextView aGf;
    private TextView bTX;
    private int ds42;
    private int ds48;
    private TextView eLe;
    public OriginalThreadCardView ejE;
    private HeadImageView eke;
    private TextView gzC;
    private TextView gzD;
    private View gzE;
    private View gzF;
    private MessageCardBottomView gzG;
    private View gzH;
    private a gzI;
    private OriginalThreadCardView.a gzJ;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.gzJ = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.gzI != null && c.this.gzI.bxV() != null) {
                    am T = new am(c.this.gzI.bxV()).T("obj_locate", 2);
                    if (c.this.gzI.getType() == a.gzy || c.this.gzI.getType() == a.gzu) {
                        T.T("obj_type", 1);
                    } else {
                        T.T("obj_type", 2);
                    }
                    TiebaStatic.log(T);
                }
                if (c.this.aQi() != null) {
                    c.this.aQi().a(c.this.ejE, c.this.gzI);
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
        this.eke = (HeadImageView) view.findViewById(d.g.photo);
        this.bTX = (TextView) view.findViewById(d.g.user_name);
        this.gzC = (TextView) view.findViewById(d.g.fans_reply);
        this.gzD = (TextView) view.findViewById(d.g.post_from);
        this.gzE = view.findViewById(d.g.divider_between_time_and_post_from);
        this.eLe = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.gzF = view.findViewById(d.g.card_message_divider_line);
        this.aGf = (TextView) view.findViewById(d.g.card_message_post_title);
        this.ejE = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.gzG = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.gzH = view.findViewById(d.g.new_message);
        this.eke.setOnClickListener(this);
        this.bTX.setOnClickListener(this);
        this.gzG.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.k(getView(), d.f.addresslist_item_bg);
            al.j(this.bTX, d.C0236d.cp_cont_f);
            al.j(this.gzC, d.C0236d.cp_cont_d);
            al.k(this.gzC, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            al.j(this.gzD, d.C0236d.cp_cont_d);
            al.j(this.eLe, d.C0236d.cp_cont_d);
            al.l(this.gzE, d.C0236d.cp_cont_e);
            al.j(this.mTitle, d.C0236d.cp_cont_b);
            al.l(this.gzF, d.C0236d.cp_bg_line_c);
            al.j(this.aGf, d.C0236d.cp_cont_j);
            if (this.ejE != null) {
                this.ejE.onChangeSkinType();
            }
            if (this.gzG != null) {
                this.gzG.onChangeSkinType();
            }
            al.k(this.gzH, d.f.icon_news_red_dot);
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
            this.gzI = aVar;
            this.eke.setVisibility(0);
            this.eke.setDefaultResource(d.f.icon_default_avatar100);
            this.eke.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.eke.setDefaultBgResource(d.C0236d.cp_bg_line_e);
            this.eke.setIsRound(true);
            this.eke.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eke.setTag(null);
            this.eke.setPageId(this.mContext.getUniqueId());
            this.eke.startLoad(portrait, 12, false);
            this.bTX.setText(ap.g(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.gzC.setVisibility(0);
            } else {
                this.gzC.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.gzE.setVisibility(0);
                this.gzD.setVisibility(0);
                this.gzD.setText(aVar.getPostFrom());
            } else {
                this.gzE.setVisibility(8);
                this.gzD.setVisibility(8);
            }
            this.eLe.setText(ap.ao(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.anp().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.gzF.setVisibility(8);
                this.aGf.setVisibility(8);
            } else {
                this.aGf.setText(a(this.aGf, TbFaceManager.anp().b(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.aGf.setVisibility(0);
                this.gzF.setVisibility(0);
            }
            this.ejE.b(aVar.getOriginalThreadInfo());
            this.ejE.setSubClickListener(this.gzJ);
            MessageCardBottomView messageCardBottomView = this.gzG;
            String fname = aVar.getFname();
            if (aVar.getType() == a.gzu || aVar.getType() == a.gzv) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.gzH.setVisibility(0);
            } else {
                this.gzH.setVisibility(8);
            }
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gzI != null || this.mContext != null) {
            if (view == this.eke || view == this.bTX) {
                if (this.gzI.getReplyer() != null) {
                    String userId = this.gzI.getReplyer().getUserId();
                    String userName = this.gzI.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aQi() != null) {
                aQi().a(view, this.gzI);
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
