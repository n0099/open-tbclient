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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.al;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.a> {
    private com.baidu.tieba.tbadkCore.x Gg;
    private CustomMessageListener bct;
    private CustomMessageListener bcu;
    private boolean bfT;
    private TextView cAT;
    private al ePt;
    private TextView eRs;
    private TextView eRt;
    private TextView eRu;
    private TextView eRv;
    private BarImageView eRw;
    private TextView eRx;
    private TextView eRy;
    private com.baidu.tieba.personPolymeric.c.a eRz;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bcu = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.bct = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        W(getView());
    }

    public void a(com.baidu.tieba.tbadkCore.x xVar) {
        this.Gg = xVar;
    }

    public void a(al alVar) {
        this.ePt = alVar;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(r.g.card_polymeric_attention_bar_rootview);
        this.eRs = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_day);
        this.eRt = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_month);
        this.eRu = (TextView) view.findViewById(r.g.card_polymeric_attention_sex);
        this.eRv = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_des);
        this.eRw = (BarImageView) view.findViewById(r.g.card_polymeric_attention_icon);
        this.eRx = (TextView) view.findViewById(r.g.card_polymeric_attention_bar_name);
        this.eRy = (TextView) view.findViewById(r.g.card_polymeric_attention_post_num);
        this.cAT = (TextView) view.findViewById(r.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cAT.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bcu);
        this.mTbPageContext.registerListener(this.bct);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            at.k(this.mRootView, r.f.item_person_header_attention_bg_selector);
            at.c(this.eRs, r.d.cp_cont_f, 1);
            at.c(this.eRt, r.d.cp_cont_f, 1);
            at.c(this.eRu, r.d.cp_cont_f, 1);
            at.c(this.eRv, r.d.cp_cont_f, 1);
            at.c(this.eRx, r.d.cp_cont_b, 1);
            at.c(this.eRy, r.d.cp_cont_c, 1);
            if (this.eRz != null) {
                ju(this.eRz.alx);
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
        this.eRz = aVar;
        this.bfT = aVar.bfT;
        this.eRs.setVisibility(aVar.bfR ? 0 : 4);
        this.eRt.setVisibility(aVar.bfR ? 0 : 4);
        this.eRs.setText(aVar.eQy);
        this.eRt.setText(aVar.bfK);
        this.eRu.setText(aVar.bfT ? this.mContext.getString(r.j.person_identity_me) : aVar.sex == 2 ? this.mContext.getString(r.j.person_identity_she) : this.mContext.getString(r.j.person_identity_he));
        this.eRw.c(aVar.avatar, 10, false);
        String str = aVar.eQz;
        if (com.baidu.tbadk.util.u.gD(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.u.d(str, 0, 10)) + "...";
        }
        this.eRx.setText(String.format(this.mContext.getString(r.j.person_polymeric_bar_suffix), str));
        String z = ax.z(aVar.eQA);
        this.eRy.setText(aVar.bfT ? String.format(this.mContext.getString(r.j.person_polymeric_attention_post_host), z, ax.z(aVar.postNum)) : String.format(this.mContext.getString(r.j.person_polymeric_attention_post_guess), z));
        if (aVar.alx || aVar.bfT) {
            this.cAT.setVisibility(8);
            return;
        }
        this.cAT.setVisibility(0);
        ju(aVar.alx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bfT) {
                TiebaStatic.log(new av("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eRz.eQz, "")));
        } else if (this.cAT == view) {
            TiebaStatic.log(new av("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bk.ai(this.mContext);
            } else if (ax.aN(this.eRz.eQz) && !this.eRz.alx) {
                this.Gg.bS(this.eRz.eQz, String.valueOf(this.eRz.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju(boolean z) {
        if (z) {
            this.cAT.setText(this.mContext.getString(r.j.person_polymeric_attention));
            at.j((View) this.cAT, r.d.cp_cont_e);
            at.k(this.cAT, r.d.transparent);
            this.cAT.setClickable(false);
            return;
        }
        this.cAT.setText(this.mContext.getString(r.j.person_polymeric_attention_bar_btn));
        at.c(this.cAT, r.d.cp_link_tip_a, 1);
        at.k(this.cAT, r.f.polymeric_attention_btn_bg);
        this.cAT.setClickable(true);
    }
}
