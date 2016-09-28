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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.am;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.a> {
    private com.baidu.tieba.tbadkCore.x Ge;
    private CustomMessageListener aZk;
    private CustomMessageListener aZl;
    private boolean bcU;
    private TextView cvK;
    private am eIU;
    private TextView eKU;
    private TextView eKV;
    private TextView eKW;
    private TextView eKX;
    private BarImageView eKY;
    private TextView eKZ;
    private TextView eLa;
    private com.baidu.tieba.personPolymeric.c.a eLb;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aZl = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.aZk = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        V(getView());
    }

    public void a(com.baidu.tieba.tbadkCore.x xVar) {
        this.Ge = xVar;
    }

    public void a(am amVar) {
        this.eIU = amVar;
    }

    private void V(View view) {
        this.mRootView = view.findViewById(r.g.card_polymeric_attention_bar_rootview);
        this.eKU = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_day);
        this.eKV = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_month);
        this.eKW = (TextView) view.findViewById(r.g.card_polymeric_attention_sex);
        this.eKX = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_des);
        this.eKY = (BarImageView) view.findViewById(r.g.card_polymeric_attention_icon);
        this.eKZ = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_name);
        this.eLa = (TextView) view.findViewById(r.g.card_polymeric_attention_post_num);
        this.cvK = (TextView) view.findViewById(r.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cvK.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.aZl);
        this.mTbPageContext.registerListener(this.aZk);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(this.mRootView, r.f.item_person_header_attention_bg_selector);
            av.c(this.eKU, r.d.cp_cont_f, 1);
            av.c(this.eKV, r.d.cp_cont_f, 1);
            av.c(this.eKW, r.d.cp_cont_f, 1);
            av.c(this.eKX, r.d.cp_cont_f, 1);
            av.c(this.eKZ, r.d.cp_cont_b, 1);
            av.c(this.eLa, r.d.cp_cont_c, 1);
            if (this.eLb != null) {
                iU(this.eLb.akC);
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
        this.eLb = aVar;
        this.bcU = aVar.bcU;
        this.eKU.setVisibility(aVar.bcS ? 0 : 4);
        this.eKV.setVisibility(aVar.bcS ? 0 : 4);
        this.eKU.setText(aVar.eKa);
        this.eKV.setText(aVar.bcL);
        this.eKW.setText(aVar.bcU ? this.mContext.getString(r.j.person_identity_me) : aVar.sex == 2 ? this.mContext.getString(r.j.person_identity_she) : this.mContext.getString(r.j.person_identity_he));
        this.eKY.c(aVar.avatar, 10, false);
        String str = aVar.eKb;
        if (com.baidu.tbadk.util.v.gD(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.v.d(str, 0, 10)) + "...";
        }
        this.eKZ.setText(String.format(this.mContext.getString(r.j.person_polymeric_bar_suffix), str));
        String A = az.A(aVar.eKc);
        this.eLa.setText(aVar.bcU ? String.format(this.mContext.getString(r.j.person_polymeric_attention_post_host), A, az.A(aVar.postNum)) : String.format(this.mContext.getString(r.j.person_polymeric_attention_post_guess), A));
        if (aVar.akC || aVar.bcU) {
            this.cvK.setVisibility(8);
            return;
        }
        this.cvK.setVisibility(0);
        iU(aVar.akC);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bcU) {
                TiebaStatic.log(new ax("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eLb.eKb, "")));
        } else if (this.cvK == view) {
            TiebaStatic.log(new ax("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bm.ai(this.mContext);
            } else if (az.aN(this.eLb.eKb) && !this.eLb.akC) {
                this.Ge.bQ(this.eLb.eKb, String.valueOf(this.eLb.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU(boolean z) {
        if (z) {
            this.cvK.setText(this.mContext.getString(r.j.person_polymeric_attention));
            av.j((View) this.cvK, r.d.cp_cont_e);
            av.k(this.cvK, r.d.transparent);
            this.cvK.setClickable(false);
            return;
        }
        this.cvK.setText(this.mContext.getString(r.j.person_polymeric_attention_bar_btn));
        av.c(this.cvK, r.d.cp_link_tip_a, 1);
        av.k(this.cvK, r.f.polymeric_attention_btn_bg);
        this.cvK.setClickable(true);
    }
}
