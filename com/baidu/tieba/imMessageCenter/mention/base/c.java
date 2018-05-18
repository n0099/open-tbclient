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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TextView aqm;
    private TextView cOM;
    private HeadImageView crS;
    public OriginalThreadCardView crr;
    private int ds42;
    private int ds48;
    private TextView epU;
    private TextView epV;
    private View epW;
    private View epX;
    private TextView epY;
    private MessageCardBottomView epZ;
    private View eqa;
    private a eqb;
    private OriginalThreadCardView.a eqc;
    private TbPageContext mContext;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eqc = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eqb != null && c.this.eqb.aIR() != null) {
                    al r = new al(c.this.eqb.aIR()).r("obj_locate", 2);
                    if (c.this.eqb.getType() == a.epP || c.this.eqb.getType() == a.epL) {
                        r.r("obj_type", 1);
                    } else {
                        r.r("obj_type", 2);
                    }
                    TiebaStatic.log(r);
                }
                if (c.this.aeZ() != null) {
                    c.this.aeZ().a(c.this.crr, c.this.eqb);
                }
            }
        };
        this.mContext = tbPageContext;
        this.ds42 = l.e(this.mContext.getContext(), d.e.tbds42);
        this.ds48 = l.e(this.mContext.getContext(), d.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view2 = getView();
        this.crS = (HeadImageView) view2.findViewById(d.g.photo);
        this.aqm = (TextView) view2.findViewById(d.g.user_name);
        this.epU = (TextView) view2.findViewById(d.g.fans_reply);
        this.epV = (TextView) view2.findViewById(d.g.post_from);
        this.epW = view2.findViewById(d.g.divider_between_time_and_post_from);
        this.cOM = (TextView) view2.findViewById(d.g.time);
        this.mTitle = (TextView) view2.findViewById(d.g.card_message_title);
        this.epX = view2.findViewById(d.g.card_message_divider_line);
        this.epY = (TextView) view2.findViewById(d.g.card_message_post_title);
        this.crr = (OriginalThreadCardView) view2.findViewById(d.g.original_thread_view);
        this.epZ = (MessageCardBottomView) view2.findViewById(d.g.card_message_bottom_layout);
        this.eqa = view2.findViewById(d.g.new_message);
        this.crS.setOnClickListener(this);
        this.aqm.setOnClickListener(this);
        this.epZ.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ak.i(getView(), d.f.addresslist_item_bg);
            ak.h(this.aqm, d.C0126d.cp_cont_f);
            ak.h(this.epU, d.C0126d.cp_cont_d);
            ak.i(this.epU, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            ak.h(this.epV, d.C0126d.cp_cont_d);
            ak.h(this.cOM, d.C0126d.cp_cont_d);
            ak.j(this.epW, d.C0126d.cp_cont_e);
            ak.h(this.mTitle, d.C0126d.cp_cont_b);
            ak.j(this.epX, d.C0126d.cp_bg_line_c);
            ak.h(this.epY, d.C0126d.cp_cont_j);
            if (this.crr != null) {
                this.crr.onChangeSkinType();
            }
            if (this.epZ != null) {
                this.epZ.onChangeSkinType();
            }
            ak.i(this.eqa, d.f.icon_news_red_dot);
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
            this.eqb = aVar;
            this.crS.setVisibility(0);
            this.crS.setDefaultResource(d.f.icon_default_avatar100);
            this.crS.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.crS.setDefaultBgResource(d.C0126d.cp_bg_line_e);
            this.crS.setIsRound(true);
            this.crS.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.crS.setTag(null);
            this.crS.setPageId(this.mContext.getUniqueId());
            this.crS.startLoad(portrait, 12, false);
            this.aqm.setText(an.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.epU.setVisibility(0);
            } else {
                this.epU.setVisibility(8);
            }
            if (!an.isEmpty(aVar.getPostFrom())) {
                this.epW.setVisibility(0);
                this.epV.setVisibility(0);
                this.epV.setText(aVar.getPostFrom());
            } else {
                this.epW.setVisibility(8);
                this.epV.setVisibility(8);
            }
            this.cOM.setText(an.s(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.EX().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (an.isEmpty(aVar.getSubTitle())) {
                this.epX.setVisibility(8);
                this.epY.setVisibility(8);
            } else {
                this.epY.setText(a(this.epY, TbFaceManager.EX().a(this.mContext.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.epY.setVisibility(0);
                this.epX.setVisibility(0);
            }
            this.crr.b(aVar.getOriginalThreadInfo());
            this.crr.setSubClickListener(this.eqc);
            MessageCardBottomView messageCardBottomView = this.epZ;
            String fname = aVar.getFname();
            if (aVar.getType() == a.epL || aVar.getType() == a.epM) {
                z = false;
            }
            messageCardBottomView.setData(fname, z);
            if (aVar.isNew()) {
                this.eqa.setVisibility(0);
            } else {
                this.eqa.setVisibility(8);
            }
            d(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.eqb != null || this.mContext != null) {
            if (view2 == this.crS || view2 == this.aqm) {
                if (this.eqb.getReplyer() != null) {
                    String userId = this.eqb.getReplyer().getUserId();
                    String userName = this.eqb.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mContext.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (aeZ() != null) {
                aeZ().a(view2, this.eqb);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.mContext == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.af(this.mContext.getPageActivity()) - (this.mContext.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
