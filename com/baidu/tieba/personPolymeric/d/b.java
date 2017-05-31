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
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener bAa;
    private boolean bld;
    private LikeModel bzS;
    private CustomMessageListener bzZ;
    private TextView csj;
    private com.baidu.tieba.tbadkCore.ae eKx;
    private TextView eMS;
    private TextView eMT;
    private TextView eMU;
    private TextView eMV;
    private BarImageView eMW;
    private TextView eMX;
    private TextView eMY;
    private com.baidu.tieba.personPolymeric.c.b eMZ;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bAa = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.bzZ = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        R(getView());
    }

    public void a(LikeModel likeModel) {
        this.bzS = likeModel;
    }

    public void a(com.baidu.tieba.tbadkCore.ae aeVar) {
        this.eKx = aeVar;
    }

    private void R(View view) {
        this.mRootView = view.findViewById(w.h.card_polymeric_attention_bar_rootview);
        this.eMS = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_day);
        this.eMT = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_month);
        this.eMU = (TextView) view.findViewById(w.h.card_polymeric_attention_sex);
        this.eMV = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_des);
        this.eMW = (BarImageView) view.findViewById(w.h.card_polymeric_attention_icon);
        this.eMX = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_name);
        this.eMY = (TextView) view.findViewById(w.h.card_polymeric_attention_post_num);
        this.csj = (TextView) view.findViewById(w.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.csj.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bAa);
        this.mTbPageContext.registerListener(this.bzZ);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
            aq.c(this.eMS, w.e.cp_cont_f, 1);
            aq.c(this.eMT, w.e.cp_cont_f, 1);
            aq.c(this.eMU, w.e.cp_cont_f, 1);
            aq.c(this.eMV, w.e.cp_cont_f, 1);
            aq.c(this.eMX, w.e.cp_cont_b, 1);
            aq.c(this.eMY, w.e.cp_cont_c, 1);
            if (this.eMZ != null) {
                jx(this.eMZ.isAttention);
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
        this.eMZ = bVar;
        this.bld = bVar.bld;
        this.eMS.setVisibility(bVar.bEb ? 0 : 4);
        this.eMT.setVisibility(bVar.bEb ? 0 : 4);
        this.eMS.setText(bVar.eMn);
        this.eMT.setText(bVar.bDU);
        this.eMU.setText(bVar.bld ? this.mContext.getString(w.l.me) : bVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he));
        this.eMW.c(bVar.avatar, 10, false);
        String str = bVar.cDr;
        if (com.baidu.tbadk.util.x.gn(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.x.d(str, 0, 10)) + "...";
        }
        this.eMX.setText(String.format(this.mContext.getString(w.l.person_polymeric_bar_suffix), str));
        String y = au.y(bVar.eMo);
        this.eMY.setText(bVar.bld ? String.format(this.mContext.getString(w.l.person_polymeric_attention_post_host), y, au.y(bVar.postNum)) : String.format(this.mContext.getString(w.l.person_polymeric_attention_post_guess), y));
        if (bVar.isAttention || bVar.bld) {
            this.csj.setVisibility(8);
            return;
        }
        this.csj.setVisibility(0);
        jx(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bld) {
                TiebaStatic.log(new as("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eMZ.cDr, "")));
        } else if (this.csj == view) {
            TiebaStatic.log(new as("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.aL(this.mContext);
            } else if (au.aB(this.eMZ.cDr) && !this.eMZ.isAttention) {
                this.bzS.bY(this.eMZ.cDr, String.valueOf(this.eMZ.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jx(boolean z) {
        if (z) {
            this.csj.setText(this.mContext.getString(w.l.relate_forum_is_followed));
            aq.i(this.csj, w.e.cp_cont_e);
            aq.j(this.csj, w.e.transparent);
            this.csj.setClickable(false);
            return;
        }
        this.csj.setText(this.mContext.getString(w.l.focus_text));
        aq.c(this.csj, w.e.cp_link_tip_a, 1);
        aq.j(this.csj, w.g.polymeric_attention_btn_bg);
        this.csj.setClickable(true);
    }
}
