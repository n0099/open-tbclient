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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.a<a> {
    private TbPageContext aRG;
    private TextView beT;
    public OriginalThreadCardView cYq;
    private int ds42;
    private int ds48;
    private TextView duR;
    private HeadImageView eTT;
    private TextView eTU;
    private TextView eTV;
    private View eTW;
    private View eTX;
    private TextView eTY;
    private MessageCardBottomView eTZ;
    private View eUa;
    private a eUb;
    private OriginalThreadCardView.a eUc;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eUc = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eUb != null && c.this.eUb.aNP() != null) {
                    ak s = new ak(c.this.eUb.aNP()).s("obj_locate", 2);
                    if (c.this.eUb.getType() == a.eTO || c.this.eUb.getType() == a.eTK) {
                        s.s("obj_type", 1);
                    } else {
                        s.s("obj_type", 2);
                    }
                    TiebaStatic.log(s);
                }
                if (c.this.akO() != null) {
                    c.this.akO().a(c.this.cYq, c.this.eUb);
                }
            }
        };
        this.aRG = tbPageContext;
        this.ds42 = l.t(this.aRG.getContext(), d.e.tbds42);
        this.ds48 = l.t(this.aRG.getContext(), d.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.eTT = (HeadImageView) view.findViewById(d.g.photo);
        this.beT = (TextView) view.findViewById(d.g.user_name);
        this.eTU = (TextView) view.findViewById(d.g.fans_reply);
        this.eTV = (TextView) view.findViewById(d.g.post_from);
        this.eTW = view.findViewById(d.g.divider_between_time_and_post_from);
        this.duR = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.eTX = view.findViewById(d.g.card_message_divider_line);
        this.eTY = (TextView) view.findViewById(d.g.card_message_post_title);
        this.cYq = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.eTZ = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.eUa = view.findViewById(d.g.new_message);
        this.eTT.setOnClickListener(this);
        this.beT.setOnClickListener(this);
        this.eTZ.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.beT, d.C0141d.cp_cont_f);
            aj.r(this.eTU, d.C0141d.cp_cont_d);
            aj.s(this.eTU, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            aj.r(this.eTV, d.C0141d.cp_cont_d);
            aj.r(this.duR, d.C0141d.cp_cont_d);
            aj.t(this.eTW, d.C0141d.cp_cont_e);
            aj.r(this.mTitle, d.C0141d.cp_cont_b);
            aj.t(this.eTX, d.C0141d.cp_bg_line_c);
            aj.r(this.eTY, d.C0141d.cp_cont_j);
            if (this.cYq != null) {
                this.cYq.onChangeSkinType();
            }
            if (this.eTZ != null) {
                this.eTZ.onChangeSkinType();
            }
            aj.s(this.eUa, d.f.message_center_red_icon);
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
            this.eUb = aVar;
            this.eTT.setVisibility(0);
            this.eTT.setDefaultResource(d.f.icon_default_avatar100);
            this.eTT.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.eTT.setDefaultBgResource(d.C0141d.cp_bg_line_e);
            this.eTT.setIsRound(true);
            this.eTT.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eTT.setTag(null);
            this.eTT.setPageId(this.aRG.getUniqueId());
            this.eTT.startLoad(portrait, 12, false);
            this.beT.setText(am.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eTU.setVisibility(0);
            } else {
                this.eTU.setVisibility(8);
            }
            if (!am.isEmpty(aVar.getPostFrom())) {
                this.eTW.setVisibility(0);
                this.eTV.setVisibility(0);
                this.eTV.setText(aVar.getPostFrom());
            } else {
                this.eTW.setVisibility(8);
                this.eTV.setVisibility(8);
            }
            this.duR.setText(am.z(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.Mv().a(this.aRG.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (am.isEmpty(aVar.getSubTitle())) {
                this.eTX.setVisibility(8);
                this.eTY.setVisibility(8);
            } else {
                this.eTY.setText(a(this.eTY, TbFaceManager.Mv().a(this.aRG.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eTY.setVisibility(0);
                this.eTX.setVisibility(0);
            }
            this.cYq.b(aVar.getOriginalThreadInfo());
            this.cYq.setSubClickListener(this.eUc);
            MessageCardBottomView messageCardBottomView = this.eTZ;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eTK || aVar.getType() == a.eTL) {
                z = false;
            }
            messageCardBottomView.J(fname, z);
            if (aVar.isNew()) {
                this.eUa.setVisibility(0);
            } else {
                this.eUa.setVisibility(8);
            }
            d(this.aRG, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eUb != null || this.aRG != null) {
            if (view == this.eTT || view == this.beT) {
                if (this.eUb.getReplyer() != null) {
                    String userId = this.eUb.getReplyer().getUserId();
                    String userName = this.eUb.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aRG.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (akO() != null) {
                akO().a(view, this.eUb);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.aRG == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.ao(this.aRG.getPageActivity()) - (this.aRG.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
