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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView ayY;
    private HeadImageView cAR;
    public OriginalThreadCardView cAp;
    private TextView cYJ;
    private int ds42;
    private int ds48;
    private TextView eIV;
    private TextView eIW;
    private View eIX;
    private View eIY;
    private TextView eIZ;
    private MessageCardBottomView eJa;
    private View eJb;
    private a eJc;
    private OriginalThreadCardView.a eJd;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eJd = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eJc != null && c.this.eJc.aPs() != null) {
                    an r = new an(c.this.eJc.aPs()).r("obj_locate", 2);
                    if (c.this.eJc.getType() == a.eIQ || c.this.eJc.getType() == a.eIM) {
                        r.r("obj_type", 1);
                    } else {
                        r.r("obj_type", 2);
                    }
                    TiebaStatic.log(r);
                }
                if (c.this.aiz() != null) {
                    c.this.aiz().a(c.this.cAp, c.this.eJc);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.f(this.mContext.getContext(), d.e.tbds42);
        this.ds48 = l.f(this.mContext.getContext(), d.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cAR = (HeadImageView) view.findViewById(d.g.photo);
        this.ayY = (TextView) view.findViewById(d.g.user_name);
        this.eIV = (TextView) view.findViewById(d.g.fans_reply);
        this.eIW = (TextView) view.findViewById(d.g.post_from);
        this.eIX = view.findViewById(d.g.divider_between_time_and_post_from);
        this.cYJ = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.eIY = view.findViewById(d.g.card_message_divider_line);
        this.eIZ = (TextView) view.findViewById(d.g.card_message_post_title);
        this.cAp = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.eJa = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.eJb = view.findViewById(d.g.new_message);
        this.cAR.setOnClickListener(this);
        this.ayY.setOnClickListener(this);
        this.eJa.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(getView(), d.f.addresslist_item_bg);
            am.h(this.ayY, d.C0140d.cp_cont_f);
            am.h(this.eIV, d.C0140d.cp_cont_d);
            am.i(this.eIV, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            am.h(this.eIW, d.C0140d.cp_cont_d);
            am.h(this.cYJ, d.C0140d.cp_cont_d);
            am.j(this.eIX, d.C0140d.cp_cont_e);
            am.h(this.mTitle, d.C0140d.cp_cont_b);
            am.j(this.eIY, d.C0140d.cp_bg_line_c);
            am.h(this.eIZ, d.C0140d.cp_cont_j);
            if (this.cAp != null) {
                this.cAp.onChangeSkinType();
            }
            if (this.eJa != null) {
                this.eJa.onChangeSkinType();
            }
            am.i(this.eJb, d.f.icon_news_red_dot);
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
            this.eJc = aVar;
            this.cAR.setVisibility(0);
            this.cAR.setDefaultResource(d.f.icon_default_avatar100);
            this.cAR.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cAR.setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cAR.setIsRound(true);
            this.cAR.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cAR.setTag(null);
            this.cAR.setPageId(this.mContext.getUniqueId());
            this.cAR.startLoad(portrait, 12, false);
            this.ayY.setText(ap.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eIV.setVisibility(0);
            } else {
                this.eIV.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.eIX.setVisibility(0);
                this.eIW.setVisibility(0);
                this.eIW.setText(aVar.getPostFrom());
            } else {
                this.eIX.setVisibility(8);
                this.eIW.setVisibility(8);
            }
            this.cYJ.setText(ap.w(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.IP().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.eIY.setVisibility(8);
                this.eIZ.setVisibility(8);
            } else {
                this.eIZ.setText(a(this.eIZ, TbFaceManager.IP().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eIZ.setVisibility(0);
                this.eIY.setVisibility(0);
            }
            this.cAp.b(aVar.getOriginalThreadInfo());
            this.cAp.setSubClickListener(this.eJd);
            MessageCardBottomView messageCardBottomView = this.eJa;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eIM || aVar.getType() == a.eIN) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eJb.setVisibility(0);
            } else {
                this.eJb.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eJc != null || this.mContext != null) {
            if (view == this.cAR || view == this.ayY) {
                if (this.eJc.getReplyer() != null) {
                    String userId = this.eJc.getReplyer().getUserId();
                    String userName = this.eJc.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aiz() != null) {
                aiz().a(view, this.eJc);
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
