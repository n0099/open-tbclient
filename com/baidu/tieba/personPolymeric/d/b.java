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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ak;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.a> {
    private com.baidu.tieba.tbadkCore.w Gg;
    private CustomMessageListener bbA;
    private CustomMessageListener bbz;
    private boolean bfj;
    private TextView cgg;
    private ak esP;
    private TextView euR;
    private TextView euS;
    private TextView euT;
    private TextView euU;
    private BarImageView euV;
    private TextView euW;
    private TextView euX;
    private com.baidu.tieba.personPolymeric.c.a euY;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bbA = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.bbz = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        W(getView());
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        this.Gg = wVar;
    }

    public void a(ak akVar) {
        this.esP = akVar;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(r.g.card_polymeric_attention_bar_rootview);
        this.euR = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_day);
        this.euS = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_month);
        this.euT = (TextView) view.findViewById(r.g.card_polymeric_attention_sex);
        this.euU = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_des);
        this.euV = (BarImageView) view.findViewById(r.g.card_polymeric_attention_icon);
        this.euW = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_name);
        this.euX = (TextView) view.findViewById(r.g.card_polymeric_attention_post_num);
        this.cgg = (TextView) view.findViewById(r.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cgg.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bbA);
        this.mTbPageContext.registerListener(this.bbz);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ar.k(this.mRootView, r.f.item_person_header_attention_bg_selector);
            ar.c(this.euR, r.d.cp_cont_f, 1);
            ar.c(this.euS, r.d.cp_cont_f, 1);
            ar.c(this.euT, r.d.cp_cont_f, 1);
            ar.c(this.euU, r.d.cp_cont_f, 1);
            ar.c(this.euW, r.d.cp_cont_b, 1);
            ar.c(this.euX, r.d.cp_cont_c, 1);
            if (this.euY != null) {
                jf(this.euY.akY);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_polymeric_attention_bar_view;
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
        this.euY = aVar;
        this.bfj = aVar.bfj;
        this.euR.setVisibility(aVar.bfh ? 0 : 4);
        this.euS.setVisibility(aVar.bfh ? 0 : 4);
        this.euR.setText(aVar.etX);
        this.euS.setText(aVar.beZ);
        this.euT.setText(aVar.bfj ? this.mContext.getString(r.j.person_identity_me) : aVar.sex == 2 ? this.mContext.getString(r.j.person_identity_she) : this.mContext.getString(r.j.he));
        this.euV.c(aVar.avatar, 10, false);
        String str = aVar.etY;
        if (com.baidu.tbadk.util.u.gy(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.u.d(str, 0, 10)) + "...";
        }
        this.euW.setText(String.format(this.mContext.getString(r.j.person_polymeric_bar_suffix), str));
        String z = av.z(aVar.etZ);
        this.euX.setText(aVar.bfj ? String.format(this.mContext.getString(r.j.person_polymeric_attention_post_host), z, av.z(aVar.postNum)) : String.format(this.mContext.getString(r.j.person_polymeric_attention_post_guess), z));
        if (aVar.akY || aVar.bfj) {
            this.cgg.setVisibility(8);
            return;
        }
        this.cgg.setVisibility(0);
        jf(aVar.akY);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bfj) {
                TiebaStatic.log(new at("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.euY.etY, "")));
        } else if (this.cgg == view) {
            TiebaStatic.log(new at("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.ag(this.mContext);
            } else if (av.aN(this.euY.etY) && !this.euY.akY) {
                this.Gg.bV(this.euY.etY, String.valueOf(this.euY.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf(boolean z) {
        if (z) {
            this.cgg.setText(this.mContext.getString(r.j.person_polymeric_attention));
            ar.j((View) this.cgg, r.d.cp_cont_e);
            ar.k(this.cgg, r.d.transparent);
            this.cgg.setClickable(false);
            return;
        }
        this.cgg.setText(this.mContext.getString(r.j.focus_text));
        ar.c(this.cgg, r.d.cp_link_tip_a, 1);
        ar.k(this.cgg, r.f.polymeric_attention_btn_bg);
        this.cgg.setClickable(true);
    }
}
