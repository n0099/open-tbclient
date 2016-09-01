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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.am;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.a> {
    private com.baidu.tieba.tbadkCore.x Ge;
    private CustomMessageListener aYQ;
    private CustomMessageListener aYR;
    private boolean bcA;
    private TextView cvn;
    private am eGQ;
    private TextView eIR;
    private TextView eIS;
    private TextView eIT;
    private TextView eIU;
    private BarImageView eIV;
    private TextView eIW;
    private TextView eIX;
    private com.baidu.tieba.personPolymeric.c.a eIY;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aYR = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.aYQ = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        V(getView());
    }

    public void a(com.baidu.tieba.tbadkCore.x xVar) {
        this.Ge = xVar;
    }

    public void a(am amVar) {
        this.eGQ = amVar;
    }

    private void V(View view) {
        this.mRootView = view.findViewById(t.g.card_polymeric_attention_bar_rootview);
        this.eIR = (TextView) view.findViewById(t.g.card_polymeric_attention_bar_day);
        this.eIS = (TextView) view.findViewById(t.g.card_polymeric_attention_bar_month);
        this.eIT = (TextView) view.findViewById(t.g.card_polymeric_attention_sex);
        this.eIU = (TextView) view.findViewById(t.g.card_polymeric_attention_bar_des);
        this.eIV = (BarImageView) view.findViewById(t.g.card_polymeric_attention_icon);
        this.eIW = (TextView) view.findViewById(t.g.card_polymeric_attention_bar_name);
        this.eIX = (TextView) view.findViewById(t.g.card_polymeric_attention_post_num);
        this.cvn = (TextView) view.findViewById(t.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cvn.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.aYR);
        this.mTbPageContext.registerListener(this.aYQ);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(this.mRootView, t.f.item_person_header_attention_bg_selector);
            av.c(this.eIR, t.d.cp_cont_f, 1);
            av.c(this.eIS, t.d.cp_cont_f, 1);
            av.c(this.eIT, t.d.cp_cont_f, 1);
            av.c(this.eIU, t.d.cp_cont_f, 1);
            av.c(this.eIW, t.d.cp_cont_b, 1);
            av.c(this.eIX, t.d.cp_cont_c, 1);
            if (this.eIY != null) {
                iR(this.eIY.akW);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_polymeric_attention_bar_view;
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
        this.eIY = aVar;
        this.bcA = aVar.bcA;
        this.eIR.setVisibility(aVar.bcy ? 0 : 4);
        this.eIS.setVisibility(aVar.bcy ? 0 : 4);
        this.eIR.setText(aVar.eHW);
        this.eIS.setText(aVar.bcr);
        this.eIT.setText(aVar.bcA ? this.mContext.getString(t.j.person_identity_me) : aVar.sex == 2 ? this.mContext.getString(t.j.person_identity_she) : this.mContext.getString(t.j.person_identity_he));
        this.eIV.c(aVar.avatar, 10, false);
        String str = aVar.eHX;
        if (com.baidu.tbadk.util.v.gz(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.v.d(str, 0, 10)) + "...";
        }
        this.eIW.setText(String.format(this.mContext.getString(t.j.person_polymeric_bar_suffix), str));
        String z = ba.z(aVar.eHY);
        this.eIX.setText(aVar.bcA ? String.format(this.mContext.getString(t.j.person_polymeric_attention_post_host), z, ba.z(aVar.postNum)) : String.format(this.mContext.getString(t.j.person_polymeric_attention_post_guess), z));
        if (aVar.akW || aVar.bcA) {
            this.cvn.setVisibility(8);
            return;
        }
        this.cvn.setVisibility(0);
        iR(aVar.akW);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bcA) {
                TiebaStatic.log(new ay("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eIY.eHX, "")));
        } else if (this.cvn == view) {
            TiebaStatic.log(new ay("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bn.aj(this.mContext);
            } else if (ba.aN(this.eIY.eHX) && !this.eIY.akW) {
                this.Ge.bP(this.eIY.eHX, String.valueOf(this.eIY.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(boolean z) {
        if (z) {
            this.cvn.setText(this.mContext.getString(t.j.person_polymeric_attention));
            av.j((View) this.cvn, t.d.cp_cont_e);
            av.k(this.cvn, t.d.transparent);
            this.cvn.setClickable(false);
            return;
        }
        this.cvn.setText(this.mContext.getString(t.j.person_polymeric_attention_bar_btn));
        av.c(this.cvn, t.d.cp_link_tip_a, 1);
        av.k(this.cvn, t.f.polymeric_attention_btn_bg);
        this.cvn.setClickable(true);
    }
}
