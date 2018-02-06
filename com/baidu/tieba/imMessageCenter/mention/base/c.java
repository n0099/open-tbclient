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
    private TbPageContext aRR;
    private TextView bfg;
    public OriginalThreadCardView cYC;
    private int ds42;
    private int ds48;
    private TextView dvd;
    private HeadImageView eUf;
    private TextView eUg;
    private TextView eUh;
    private View eUi;
    private View eUj;
    private TextView eUk;
    private MessageCardBottomView eUl;
    private View eUm;
    private a eUn;
    private OriginalThreadCardView.a eUo;
    private int mSkinType;
    private TextView mTitle;

    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mSkinType = 3;
        this.eUo = new OriginalThreadCardView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.base.c.1
            @Override // com.baidu.tieba.card.OriginalThreadCardView.a
            public void a(OriginalThreadInfo originalThreadInfo) {
                if (c.this.eUn != null && c.this.eUn.aNQ() != null) {
                    ak s = new ak(c.this.eUn.aNQ()).s("obj_locate", 2);
                    if (c.this.eUn.getType() == a.eUa || c.this.eUn.getType() == a.eTW) {
                        s.s("obj_type", 1);
                    } else {
                        s.s("obj_type", 2);
                    }
                    TiebaStatic.log(s);
                }
                if (c.this.akP() != null) {
                    c.this.akP().a(c.this.cYC, c.this.eUn);
                }
            }
        };
        this.aRR = tbPageContext;
        this.ds42 = l.t(this.aRR.getContext(), d.e.tbds42);
        this.ds48 = l.t(this.aRR.getContext(), d.e.tbds48);
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.eUf = (HeadImageView) view.findViewById(d.g.photo);
        this.bfg = (TextView) view.findViewById(d.g.user_name);
        this.eUg = (TextView) view.findViewById(d.g.fans_reply);
        this.eUh = (TextView) view.findViewById(d.g.post_from);
        this.eUi = view.findViewById(d.g.divider_between_time_and_post_from);
        this.dvd = (TextView) view.findViewById(d.g.time);
        this.mTitle = (TextView) view.findViewById(d.g.card_message_title);
        this.eUj = view.findViewById(d.g.card_message_divider_line);
        this.eUk = (TextView) view.findViewById(d.g.card_message_post_title);
        this.cYC = (OriginalThreadCardView) view.findViewById(d.g.original_thread_view);
        this.eUl = (MessageCardBottomView) view.findViewById(d.g.card_message_bottom_layout);
        this.eUm = view.findViewById(d.g.new_message);
        this.eUf.setOnClickListener(this);
        this.bfg.setOnClickListener(this);
        this.eUl.getReplyContainer().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            aj.s(getView(), d.f.addresslist_item_bg);
            aj.r(this.bfg, d.C0140d.cp_cont_f);
            aj.r(this.eUg, d.C0140d.cp_cont_d);
            aj.s(this.eUg, d.f.btn_rounded_corner_gray_frame_transparent_thin);
            aj.r(this.eUh, d.C0140d.cp_cont_d);
            aj.r(this.dvd, d.C0140d.cp_cont_d);
            aj.t(this.eUi, d.C0140d.cp_cont_e);
            aj.r(this.mTitle, d.C0140d.cp_cont_b);
            aj.t(this.eUj, d.C0140d.cp_bg_line_c);
            aj.r(this.eUk, d.C0140d.cp_cont_j);
            if (this.cYC != null) {
                this.cYC.onChangeSkinType();
            }
            if (this.eUl != null) {
                this.eUl.onChangeSkinType();
            }
            aj.s(this.eUm, d.f.message_center_red_icon);
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
            this.eUn = aVar;
            this.eUf.setVisibility(0);
            this.eUf.setDefaultResource(d.f.icon_default_avatar100);
            this.eUf.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.eUf.setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.eUf.setIsRound(true);
            this.eUf.setShowV(aVar.getReplyer().isBigV());
            String portrait = aVar.getReplyer().getPortrait();
            this.eUf.setTag(null);
            this.eUf.setPageId(this.aRR.getUniqueId());
            this.eUf.startLoad(portrait, 12, false);
            this.bfg.setText(am.e(aVar.getReplyer().getName_show(), 14, "..."));
            if (aVar.getReplyer().getIsMyFans() == 1) {
                this.eUg.setVisibility(0);
            } else {
                this.eUg.setVisibility(8);
            }
            if (!am.isEmpty(aVar.getPostFrom())) {
                this.eUi.setVisibility(0);
                this.eUh.setVisibility(0);
                this.eUh.setText(aVar.getPostFrom());
            } else {
                this.eUi.setVisibility(8);
                this.eUh.setVisibility(8);
            }
            this.dvd.setText(am.z(aVar.getTime()));
            this.mTitle.setText(a(this.mTitle, TbFaceManager.Mw().a(this.aRR.getPageActivity().getApplicationContext(), aVar.getTitle(), this.ds48, this.ds48)));
            if (am.isEmpty(aVar.getSubTitle())) {
                this.eUj.setVisibility(8);
                this.eUk.setVisibility(8);
            } else {
                this.eUk.setText(a(this.eUk, TbFaceManager.Mw().a(this.aRR.getPageActivity().getApplicationContext(), aVar.getSubTitle(), this.ds42, this.ds42)));
                this.eUk.setVisibility(0);
                this.eUj.setVisibility(0);
            }
            this.cYC.b(aVar.getOriginalThreadInfo());
            this.cYC.setSubClickListener(this.eUo);
            MessageCardBottomView messageCardBottomView = this.eUl;
            String fname = aVar.getFname();
            if (aVar.getType() == a.eTW || aVar.getType() == a.eTX) {
                z = false;
            }
            messageCardBottomView.K(fname, z);
            if (aVar.isNew()) {
                this.eUm.setVisibility(0);
            } else {
                this.eUm.setVisibility(8);
            }
            d(this.aRR, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eUn != null || this.aRR != null) {
            if (view == this.eUf || view == this.bfg) {
                if (this.eUn.getReplyer() != null) {
                    String userId = this.eUn.getReplyer().getUserId();
                    String userName = this.eUn.getReplyer().getUserName();
                    if (userId != null && userId.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aRR.getContext(), userId, userName)));
                    }
                } else {
                    return;
                }
            }
            if (akP() != null) {
                akP().a(view, this.eUn);
            }
        }
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.aRR == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), ((l.ao(this.aRR.getPageActivity()) - (this.aRR.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
    }
}
