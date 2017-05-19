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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.a> {
    private boolean bjW;
    private LikeModel bue;
    private CustomMessageListener bul;
    private CustomMessageListener bum;
    private TextView clK;
    private com.baidu.tieba.tbadkCore.ae eBL;
    private TextView eEd;
    private TextView eEe;
    private TextView eEf;
    private TextView eEg;
    private BarImageView eEh;
    private TextView eEi;
    private TextView eEj;
    private com.baidu.tieba.personPolymeric.c.a eEk;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bum = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.bul = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        V(getView());
    }

    public void a(LikeModel likeModel) {
        this.bue = likeModel;
    }

    public void a(com.baidu.tieba.tbadkCore.ae aeVar) {
        this.eBL = aeVar;
    }

    private void V(View view) {
        this.mRootView = view.findViewById(w.h.card_polymeric_attention_bar_rootview);
        this.eEd = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_day);
        this.eEe = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_month);
        this.eEf = (TextView) view.findViewById(w.h.card_polymeric_attention_sex);
        this.eEg = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_des);
        this.eEh = (BarImageView) view.findViewById(w.h.card_polymeric_attention_icon);
        this.eEi = (TextView) view.findViewById(w.h.card_polymeric_attention_bar_name);
        this.eEj = (TextView) view.findViewById(w.h.card_polymeric_attention_post_num);
        this.clK = (TextView) view.findViewById(w.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.clK.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bum);
        this.mTbPageContext.registerListener(this.bul);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(this.mRootView, w.g.item_person_header_attention_bg_selector);
            aq.c(this.eEd, w.e.cp_cont_f, 1);
            aq.c(this.eEe, w.e.cp_cont_f, 1);
            aq.c(this.eEf, w.e.cp_cont_f, 1);
            aq.c(this.eEg, w.e.cp_cont_f, 1);
            aq.c(this.eEi, w.e.cp_cont_b, 1);
            aq.c(this.eEj, w.e.cp_cont_c, 1);
            if (this.eEk != null) {
                jd(this.eEk.isAttention);
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
        this.eEk = aVar;
        this.bjW = aVar.bjW;
        this.eEd.setVisibility(aVar.byg ? 0 : 4);
        this.eEe.setVisibility(aVar.byg ? 0 : 4);
        this.eEd.setText(aVar.eDa);
        this.eEe.setText(aVar.bxY);
        this.eEf.setText(aVar.bjW ? this.mContext.getString(w.l.me) : aVar.sex == 2 ? this.mContext.getString(w.l.person_identity_she) : this.mContext.getString(w.l.he));
        this.eEh.c(aVar.avatar, 10, false);
        String str = aVar.cxa;
        if (com.baidu.tbadk.util.x.go(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.x.d(str, 0, 10)) + "...";
        }
        this.eEi.setText(String.format(this.mContext.getString(w.l.person_polymeric_bar_suffix), str));
        String y = au.y(aVar.eDb);
        this.eEj.setText(aVar.bjW ? String.format(this.mContext.getString(w.l.person_polymeric_attention_post_host), y, au.y(aVar.postNum)) : String.format(this.mContext.getString(w.l.person_polymeric_attention_post_guess), y));
        if (aVar.isAttention || aVar.bjW) {
            this.clK.setVisibility(8);
            return;
        }
        this.clK.setVisibility(0);
        jd(aVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bjW) {
                TiebaStatic.log(new as("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eEk.cxa, "")));
        } else if (this.clK == view) {
            TiebaStatic.log(new as("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.aL(this.mContext);
            } else if (au.aB(this.eEk.cxa) && !this.eEk.isAttention) {
                this.bue.bY(this.eEk.cxa, String.valueOf(this.eEk.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jd(boolean z) {
        if (z) {
            this.clK.setText(this.mContext.getString(w.l.relate_forum_is_followed));
            aq.i(this.clK, w.e.cp_cont_e);
            aq.j(this.clK, w.e.transparent);
            this.clK.setClickable(false);
            return;
        }
        this.clK.setText(this.mContext.getString(w.l.focus_text));
        aq.c(this.clK, w.e.cp_link_tip_a, 1);
        aq.j(this.clK, w.g.polymeric_attention_btn_bg);
        this.clK.setClickable(true);
    }
}
