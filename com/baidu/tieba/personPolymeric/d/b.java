package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ag;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.a> {
    private boolean bjz;
    private LikeModel bui;
    private CustomMessageListener bup;
    private CustomMessageListener buq;
    private TextView coO;
    private ag eGy;
    private TextView eIA;
    private TextView eIB;
    private BarImageView eIC;
    private TextView eID;
    private TextView eIE;
    private com.baidu.tieba.personPolymeric.c.a eIF;
    private TextView eIy;
    private TextView eIz;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.buq = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.bup = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        W(getView());
    }

    public void a(LikeModel likeModel) {
        this.bui = likeModel;
    }

    public void a(ag agVar) {
        this.eGy = agVar;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(w.h.card_polymeric_attention_bar_rootview);
        this.eIy = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_day);
        this.eIz = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_month);
        this.eIA = (TextView) view.findViewById(w.h.card_polymeric_attention_sex);
        this.eIB = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_des);
        this.eIC = (BarImageView) view.findViewById(w.h.card_polymeric_attention_icon);
        this.eID = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_name);
        this.eIE = (TextView) view.findViewById(w.h.card_polymeric_attention_post_num);
        this.coO = (TextView) view.findViewById(w.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.coO.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.buq);
        this.mTbPageContext.registerListener(this.bup);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
            aq.c(this.eIy, w.e.cp_cont_f, 1);
            aq.c(this.eIz, w.e.cp_cont_f, 1);
            aq.c(this.eIA, w.e.cp_cont_f, 1);
            aq.c(this.eIB, w.e.cp_cont_f, 1);
            aq.c(this.eID, w.e.cp_cont_b, 1);
            aq.c(this.eIE, w.e.cp_cont_c, 1);
            if (this.eIF != null) {
                jx(this.eIF.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_polymeric_attention_bar_view;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [134=5] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eIF = aVar;
        this.bjz = aVar.bjz;
        this.eIy.setVisibility(aVar.byg ? 0 : 4);
        this.eIz.setVisibility(aVar.byg ? 0 : 4);
        this.eIy.setText(aVar.eHF);
        this.eIz.setText(aVar.bxZ);
        this.eIA.setText(aVar.bjz ? this.mContext.getString(w.l.me) : aVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he));
        this.eIC.c(aVar.avatar, 10, false);
        String str = aVar.eHG;
        if (com.baidu.tbadk.util.u.gq(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.u.d(str, 0, 10)) + "...";
        }
        this.eID.setText(String.format(this.mContext.getString(w.l.person_polymeric_bar_suffix), str));
        String x = au.x(aVar.eHH);
        this.eIE.setText(aVar.bjz ? String.format(this.mContext.getString(w.l.person_polymeric_attention_post_host), x, au.x(aVar.postNum)) : String.format(this.mContext.getString(w.l.person_polymeric_attention_post_guess), x));
        if (aVar.isAttention || aVar.bjz) {
            this.coO.setVisibility(8);
            return;
        }
        this.coO.setVisibility(0);
        jx(aVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bjz) {
                TiebaStatic.log(new as("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eIF.eHG, "")));
        } else if (this.coO == view) {
            TiebaStatic.log(new as("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.aI(this.mContext);
            } else if (au.aB(this.eIF.eHG) && !this.eIF.isAttention) {
                this.bui.bY(this.eIF.eHG, String.valueOf(this.eIF.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jx(boolean z) {
        if (z) {
            this.coO.setText(this.mContext.getString(w.l.relate_forum_is_followed));
            aq.i(this.coO, w.e.cp_cont_e);
            aq.j(this.coO, w.e.transparent);
            this.coO.setClickable(false);
            return;
        }
        this.coO.setText(this.mContext.getString(w.l.focus_text));
        aq.c(this.coO, w.e.cp_link_tip_a, 1);
        aq.j(this.coO, w.g.polymeric_attention_btn_bg);
        this.coO.setClickable(true);
    }
}
