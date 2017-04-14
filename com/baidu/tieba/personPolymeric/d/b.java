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
    private boolean bho;
    private LikeModel brQ;
    private CustomMessageListener brX;
    private CustomMessageListener brY;
    private TextView cmw;
    private ag eEi;
    private TextView eGi;
    private TextView eGj;
    private TextView eGk;
    private TextView eGl;
    private BarImageView eGm;
    private TextView eGn;
    private TextView eGo;
    private com.baidu.tieba.personPolymeric.c.a eGp;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.brY = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.brX = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        W(getView());
    }

    public void a(LikeModel likeModel) {
        this.brQ = likeModel;
    }

    public void a(ag agVar) {
        this.eEi = agVar;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(w.h.card_polymeric_attention_bar_rootview);
        this.eGi = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_day);
        this.eGj = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_month);
        this.eGk = (TextView) view.findViewById(w.h.card_polymeric_attention_sex);
        this.eGl = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_des);
        this.eGm = (BarImageView) view.findViewById(w.h.card_polymeric_attention_icon);
        this.eGn = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_name);
        this.eGo = (TextView) view.findViewById(w.h.card_polymeric_attention_post_num);
        this.cmw = (TextView) view.findViewById(w.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cmw.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.brY);
        this.mTbPageContext.registerListener(this.brX);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
            aq.c(this.eGi, w.e.cp_cont_f, 1);
            aq.c(this.eGj, w.e.cp_cont_f, 1);
            aq.c(this.eGk, w.e.cp_cont_f, 1);
            aq.c(this.eGl, w.e.cp_cont_f, 1);
            aq.c(this.eGn, w.e.cp_cont_b, 1);
            aq.c(this.eGo, w.e.cp_cont_c, 1);
            if (this.eGp != null) {
                jn(this.eGp.isAttention);
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
        this.eGp = aVar;
        this.bho = aVar.bho;
        this.eGi.setVisibility(aVar.bvP ? 0 : 4);
        this.eGj.setVisibility(aVar.bvP ? 0 : 4);
        this.eGi.setText(aVar.eFp);
        this.eGj.setText(aVar.bvI);
        this.eGk.setText(aVar.bho ? this.mContext.getString(w.l.me) : aVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he));
        this.eGm.c(aVar.avatar, 10, false);
        String str = aVar.eFq;
        if (com.baidu.tbadk.util.u.gq(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.u.d(str, 0, 10)) + "...";
        }
        this.eGn.setText(String.format(this.mContext.getString(w.l.person_polymeric_bar_suffix), str));
        String x = au.x(aVar.eFr);
        this.eGo.setText(aVar.bho ? String.format(this.mContext.getString(w.l.person_polymeric_attention_post_host), x, au.x(aVar.postNum)) : String.format(this.mContext.getString(w.l.person_polymeric_attention_post_guess), x));
        if (aVar.isAttention || aVar.bho) {
            this.cmw.setVisibility(8);
            return;
        }
        this.cmw.setVisibility(0);
        jn(aVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bho) {
                TiebaStatic.log(new as("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eGp.eFq, "")));
        } else if (this.cmw == view) {
            TiebaStatic.log(new as("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.aI(this.mContext);
            } else if (au.aB(this.eGp.eFq) && !this.eGp.isAttention) {
                this.brQ.bZ(this.eGp.eFq, String.valueOf(this.eGp.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jn(boolean z) {
        if (z) {
            this.cmw.setText(this.mContext.getString(w.l.relate_forum_is_followed));
            aq.i(this.cmw, w.e.cp_cont_e);
            aq.j(this.cmw, w.e.transparent);
            this.cmw.setClickable(false);
            return;
        }
        this.cmw.setText(this.mContext.getString(w.l.focus_text));
        aq.c(this.cmw, w.e.cp_link_tip_a, 1);
        aq.j(this.cmw, w.g.polymeric_attention_btn_bg);
        this.cmw.setClickable(true);
    }
}
