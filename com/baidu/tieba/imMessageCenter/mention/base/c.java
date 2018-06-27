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
    private TextView azm;
    private TextView cVU;
    public OriginalThreadCardView cxM;
    private HeadImageView cyo;
    private int ds42;
    private int ds48;
    private TextView eFb;
    private TextView eFc;
    private View eFd;
    private View eFe;
    private TextView eFf;
    private MessageCardBottomView eFg;
    private View eFh;
    private a eFi;
    private OriginalThreadCardView.a eFj;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eFj = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eFi != null && c.this.eFi.aOs() != null) {
                    an r = new an(c.this.eFi.aOs()).r("obj_locate", 2);
                    if (c.this.eFi.getType() == a.eEW || c.this.eFi.getType() == a.eES) {
                        r.r("obj_type", 1);
                    } else {
                        r.r("obj_type", 2);
                    }
                    TiebaStatic.log(r);
                }
                if (c.this.aia() != null) {
                    c.this.aia().a(c.this.cxM, c.this.eFi);
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
        this.cyo = (HeadImageView) view.findViewById(d.g.photo);
        this.azm = (TextView) view.findViewById(d.g.user_name);
        this.eFb = (TextView) view.findViewById(d.g.fans_reply);
        this.eFc = (TextView) view.findViewById(d.g.post_from);
        this.eFd = view.findViewById(d.g.divider_between_time_and_post_from);
        this.cVU = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.eFe = view.findViewById(d.g.card_message_divider_line);
        this.eFf = (TextView) view.findViewById(d.g.card_message_post_title);
        this.cxM = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.eFg = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.eFh = view.findViewById(d.g.new_message);
        this.cyo.setOnClickListener(this);
        this.azm.setOnClickListener(this);
        this.eFg.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.i(getView(), d.f.addresslist_item_bg);
            am.h(this.azm, d.C0142d.cp_cont_f);
            am.h(this.eFb, d.C0142d.cp_cont_d);
            am.i(this.eFb, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            am.h(this.eFc, d.C0142d.cp_cont_d);
            am.h(this.cVU, d.C0142d.cp_cont_d);
            am.j(this.eFd, d.C0142d.cp_cont_e);
            am.h(this.mTitle, d.C0142d.cp_cont_b);
            am.j(this.eFe, d.C0142d.cp_bg_line_c);
            am.h(this.eFf, d.C0142d.cp_cont_j);
            if (this.cxM != null) {
                this.cxM.onChangeSkinType();
            }
            if (this.eFg != null) {
                this.eFg.onChangeSkinType();
            }
            am.i(this.eFh, d.f.icon_news_red_dot);
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
            this.eFi = aVar;
            this.cyo.setVisibility(0);
            this.cyo.setDefaultResource(d.f.icon_default_avatar100);
            this.cyo.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cyo.setDefaultBgResource(d.C0142d.cp_bg_line_e);
            this.cyo.setIsRound(true);
            this.cyo.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.cyo.setTag(null);
            this.cyo.setPageId(this.mContext.getUniqueId());
            this.cyo.startLoad(portrait, 12, false);
            this.azm.setText(ap.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eFb.setVisibility(0);
            } else {
                this.eFb.setVisibility(8);
            }
            if (!ap.isEmpty(aVar.getPostFrom())) {
                this.eFd.setVisibility(0);
                this.eFc.setVisibility(0);
                this.eFc.setText(aVar.getPostFrom());
            } else {
                this.eFd.setVisibility(8);
                this.eFc.setVisibility(8);
            }
            this.cVU.setText(ap.w(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.IU().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (ap.isEmpty(aVar.getSubTitle())) {
                this.eFe.setVisibility(8);
                this.eFf.setVisibility(8);
            } else {
                this.eFf.setText(a(this.eFf, TbFaceManager.IU().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eFf.setVisibility(0);
                this.eFe.setVisibility(0);
            }
            this.cxM.b(aVar.getOriginalThreadInfo());
            this.cxM.setSubClickListener(this.eFj);
            MessageCardBottomView messageCardBottomView = this.eFg;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eES || aVar.getType() == a.eET) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eFh.setVisibility(0);
            } else {
                this.eFh.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eFi != null || this.mContext != null) {
            if (view == this.cyo || view == this.azm) {
                if (this.eFi.getReplyer() != null) {
                    String userId = this.eFi.getReplyer().getUserId();
                    String userName = this.eFi.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aia() != null) {
                aia().a(view, this.eFi);
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
