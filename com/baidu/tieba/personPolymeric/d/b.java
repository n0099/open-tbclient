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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel bAL;
    private CustomMessageListener bAS;
    private CustomMessageListener bAT;
    private boolean boT;
    private TextView czW;
    private com.baidu.tieba.tbadkCore.ae eUv;
    private TextView eXb;
    private TextView eXc;
    private TextView eXd;
    private TextView eXe;
    private BarImageView eXf;
    private TextView eXg;
    private TextView eXh;
    private com.baidu.tieba.personPolymeric.c.b eXi;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bAT = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.bAS = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        S(getView());
    }

    public void a(LikeModel likeModel) {
        this.bAL = likeModel;
    }

    public void a(com.baidu.tieba.tbadkCore.ae aeVar) {
        this.eUv = aeVar;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(w.h.card_polymeric_attention_bar_rootview);
        this.eXb = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_day);
        this.eXc = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_month);
        this.eXd = (TextView) view.findViewById(w.h.card_polymeric_attention_sex);
        this.eXe = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_des);
        this.eXf = (BarImageView) view.findViewById(w.h.card_polymeric_attention_icon);
        this.eXg = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_name);
        this.eXh = (TextView) view.findViewById(w.h.card_polymeric_attention_post_num);
        this.czW = (TextView) view.findViewById(w.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.czW.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bAT);
        this.mTbPageContext.registerListener(this.bAS);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
            as.c(this.eXb, w.e.cp_cont_f, 1);
            as.c(this.eXc, w.e.cp_cont_f, 1);
            as.c(this.eXd, w.e.cp_cont_f, 1);
            as.c(this.eXe, w.e.cp_cont_f, 1);
            as.c(this.eXg, w.e.cp_cont_b, 1);
            as.c(this.eXh, w.e.cp_cont_c, 1);
            if (this.eXi != null) {
                jX(this.eXi.isAttention);
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
    public void a(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eXi = bVar;
        this.boT = bVar.boT;
        this.eXb.setVisibility(bVar.bET ? 0 : 4);
        this.eXc.setVisibility(bVar.bET ? 0 : 4);
        this.eXb.setText(bVar.eWw);
        this.eXc.setText(bVar.bEM);
        this.eXd.setText(bVar.boT ? this.mContext.getString(w.l.me) : bVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he));
        this.eXf.c(bVar.avatar, 10, false);
        String str = bVar.cLo;
        if (com.baidu.tbadk.util.y.gI(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.y.d(str, 0, 10)) + "...";
        }
        this.eXg.setText(String.format(this.mContext.getString(w.l.person_polymeric_bar_suffix), str));
        String z = aw.z(bVar.eWx);
        this.eXh.setText(bVar.boT ? String.format(this.mContext.getString(w.l.person_polymeric_attention_post_host), z, aw.z(bVar.postNum)) : String.format(this.mContext.getString(w.l.person_polymeric_attention_post_guess), z));
        if (bVar.isAttention || bVar.boT) {
            this.czW.setVisibility(8);
            return;
        }
        this.czW.setVisibility(0);
        jX(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.boT) {
                TiebaStatic.log(new au("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eXi.cLo, "")));
        } else if (this.czW == view) {
            TiebaStatic.log(new au("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bl.aM(this.mContext);
            } else if (aw.aG(this.eXi.cLo) && !this.eXi.isAttention) {
                this.bAL.cc(this.eXi.cLo, String.valueOf(this.eXi.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jX(boolean z) {
        if (z) {
            this.czW.setText(this.mContext.getString(w.l.relate_forum_is_followed));
            as.i(this.czW, w.e.cp_cont_e);
            as.j(this.czW, w.e.transparent);
            this.czW.setClickable(false);
            return;
        }
        this.czW.setText(this.mContext.getString(w.l.focus_text));
        as.c(this.czW, w.e.cp_link_tip_a, 1);
        as.j(this.czW, w.g.polymeric_attention_btn_bg);
        this.czW.setClickable(true);
    }
}
