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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView ayV;
    private HeadImageView cAO;
    public OriginalThreadCardView cAm;
    private TextView cYF;
    private int ds42;
    private int ds48;
    private TextView eIQ;
    private TextView eIR;
    private View eIS;
    private View eIT;
    private TextView eIU;
    private MessageCardBottomView eIV;
    private View eIW;
    private a eIX;
    private OriginalThreadCardView.a eIY;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eIY = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eIX != null && c.this.eIX.aPp() != null) {
                    an r = new an(c.this.eIX.aPp()).r("obj_locate", 2);
                    if (c.this.eIX.getType() == a.eIL || c.this.eIX.getType() == a.eIH) {
                        r.r("obj_type", 1);
                    } else {
                        r.r("obj_type", 2);
                    }
                    TiebaStatic.log(r);
                }
                if (c.this.aiC() != null) {
                    c.this.aiC().a(c.this.cAm, c.this.eIX);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.f(this.mContext.getContext(), f.e.tbds42);
        this.ds48 = l.f(this.mContext.getContext(), f.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cAO = (HeadImageView) view.findViewById(f.g.photo);
        this.ayV = (TextView) view.findViewById(f.g.user_name);
        this.eIQ = (TextView) view.findViewById(f.g.fans_reply);
        this.eIR = (TextView) view.findViewById(f.g.post_from);
        this.eIS = view.findViewById(f.g.divider_between_time_and_post_from);
        this.cYF = (TextView) view.findViewById(f.g.time);
        this.mTitle = (TextView) view.findViewById(f.g.card_message_title);
        this.eIT = view.findViewById(f.g.card_message_divider_line);
        this.eIU = (TextView) view.findViewById(f.g.card_message_post_title);
        this.cAm = (OriginalThreadCardView) view.findViewById(f.g.original_thread_view);
        this.eIV = (MessageCardBottomView) view.findViewById(f.g.card_message_bottom_layout);
        this.eIW = view.findViewById(f.g.new_message);
        this.cAO.setOnClickListener(this);
        this.ayV.setOnClickListener(this);
        this.eIV.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(getView(), f.C0146f.addresslist_item_bg);
            am.h(this.ayV, f.d.cp_cont_f);
            am.h(this.eIQ, f.d.cp_cont_d);
            am.i(this.eIQ, f.C0146f.btn_rounded_corner_gray_frame_transparent_thin);
            am.h(this.eIR, f.d.cp_cont_d);
            am.h(this.cYF, f.d.cp_cont_d);
            am.j(this.eIS, f.d.cp_cont_e);
            am.h(this.mTitle, f.d.cp_cont_b);
            am.j(this.eIT, f.d.cp_bg_line_c);
            am.h(this.eIU, f.d.cp_cont_j);
            if (this.cAm != null) {
                this.cAm.onChangeSkinType();
            }
            if (this.eIV != null) {
                this.eIV.onChangeSkinType();
            }
            am.i(this.eIW, f.C0146f.icon_news_red_dot);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_message_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: c */
    public void a(a aVar) {
        boolean z = true;
        if (aVar != null && aVar.getReplyer() != null) {
            this.eIX = aVar;
            this.cAO.setVisibility(0);
            this.cAO.setDefaultResource(f.C0146f.icon_default_avatar100);
            this.cAO.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
            this.cAO.setDefaultBgResource(f.d.cp_bg_line_e);
            this.cAO.setIsRound(true);
            this.cAO.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cAO.setTag(null);
            this.cAO.setPageId(this.mContext.getUniqueId());
            this.cAO.startLoad(portrait, 12, false);
            this.ayV.setText(ap.d(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eIQ.setVisibility(0);
            } else {
                this.eIQ.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.eIS.setVisibility(0);
                this.eIR.setVisibility(0);
                this.eIR.setText(aVar.getPostFrom());
            } else {
                this.eIS.setVisibility(8);
                this.eIR.setVisibility(8);
            }
            this.cYF.setText(ap.w(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.IP().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.eIT.setVisibility(8);
                this.eIU.setVisibility(8);
            } else {
                this.eIU.setText(a(this.eIU, TbFaceManager.IP().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eIU.setVisibility(0);
                this.eIT.setVisibility(0);
            }
            this.cAm.b(aVar.getOriginalThreadInfo());
            this.cAm.setSubClickListener(this.eIY);
            MessageCardBottomView messageCardBottomView = this.eIV;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eIH || aVar.getType() == a.eII) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eIW.setVisibility(0);
            } else {
                this.eIW.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eIX != null || this.mContext != null) {
            if (view == this.cAO || view == this.ayV) {
                if (this.eIX.getReplyer() != null) {
                    String userId = this.eIX.getReplyer().getUserId();
                    String userName = this.eIX.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aiC() != null) {
                aiC().a(view, this.eIX);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.ah(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(f.e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
