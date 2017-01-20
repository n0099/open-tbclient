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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ah;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.a> {
    private LikeModel Fq;
    private boolean baK;
    private CustomMessageListener blm;
    private CustomMessageListener bln;
    private TextView cmy;
    private ah eCK;
    private TextView eEL;
    private TextView eEM;
    private TextView eEN;
    private TextView eEO;
    private BarImageView eEP;
    private TextView eEQ;
    private TextView eER;
    private com.baidu.tieba.personPolymeric.c.a eES;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bln = new c(this, CmdConfigCustom.CMD_PERSON_LIKE_FORUM);
        this.blm = new d(this, CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM);
        Y(getView());
    }

    public void a(LikeModel likeModel) {
        this.Fq = likeModel;
    }

    public void a(ah ahVar) {
        this.eCK = ahVar;
    }

    private void Y(View view) {
        this.mRootView = view.findViewById(r.h.card_polymeric_attention_bar_rootview);
        this.eEL = (TextView) view.findViewById(r.h.card_polymeric_attention_bar_day);
        this.eEM = (TextView) view.findViewById(r.h.card_polymeric_attention_bar_month);
        this.eEN = (TextView) view.findViewById(r.h.card_polymeric_attention_sex);
        this.eEO = (TextView) view.findViewById(r.h.card_polymeric_attention_bar_des);
        this.eEP = (BarImageView) view.findViewById(r.h.card_polymeric_attention_icon);
        this.eEQ = (TextView) view.findViewById(r.h.card_polymeric_attention_bar_name);
        this.eER = (TextView) view.findViewById(r.h.card_polymeric_attention_post_num);
        this.cmy = (TextView) view.findViewById(r.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cmy.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bln);
        this.mTbPageContext.registerListener(this.blm);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.j(this.mRootView, r.g.item_person_header_attention_bg_selector);
            ap.c(this.eEL, r.e.cp_cont_f, 1);
            ap.c(this.eEM, r.e.cp_cont_f, 1);
            ap.c(this.eEN, r.e.cp_cont_f, 1);
            ap.c(this.eEO, r.e.cp_cont_f, 1);
            ap.c(this.eEQ, r.e.cp_cont_b, 1);
            ap.c(this.eER, r.e.cp_cont_c, 1);
            if (this.eES != null) {
                jr(this.eES.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_polymeric_attention_bar_view;
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
        this.eES = aVar;
        this.baK = aVar.baK;
        this.eEL.setVisibility(aVar.bpb ? 0 : 4);
        this.eEM.setVisibility(aVar.bpb ? 0 : 4);
        this.eEL.setText(aVar.eDR);
        this.eEM.setText(aVar.boU);
        this.eEN.setText(aVar.baK ? this.mContext.getString(r.l.me) : aVar.sex == 2 ? this.mContext.getString(r.l.person_identity_she) : this.mContext.getString(r.l.he));
        this.eEP.c(aVar.avatar, 10, false);
        String str = aVar.eDS;
        if (com.baidu.tbadk.util.u.gv(str) > 10) {
            str = String.valueOf(com.baidu.tbadk.util.u.d(str, 0, 10)) + "...";
        }
        this.eEQ.setText(String.format(this.mContext.getString(r.l.person_polymeric_bar_suffix), str));
        String x = at.x(aVar.eDT);
        this.eER.setText(aVar.baK ? String.format(this.mContext.getString(r.l.person_polymeric_attention_post_host), x, at.x(aVar.postNum)) : String.format(this.mContext.getString(r.l.person_polymeric_attention_post_guess), x));
        if (aVar.isAttention || aVar.baK) {
            this.cmy.setVisibility(8);
            return;
        }
        this.cmy.setVisibility(0);
        jr(aVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.baK) {
                TiebaStatic.log(new ar("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.eES.eDS, "")));
        } else if (this.cmy == view) {
            TiebaStatic.log(new ar("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bf.ai(this.mContext);
            } else if (at.aM(this.eES.eDS) && !this.eES.isAttention) {
                this.Fq.ce(this.eES.eDS, String.valueOf(this.eES.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(boolean z) {
        if (z) {
            this.cmy.setText(this.mContext.getString(r.l.relate_forum_is_followed));
            ap.i((View) this.cmy, r.e.cp_cont_e);
            ap.j((View) this.cmy, r.e.transparent);
            this.cmy.setClickable(false);
            return;
        }
        this.cmy.setText(this.mContext.getString(r.l.focus_text));
        ap.c(this.cmy, r.e.cp_link_tip_a, 1);
        ap.j((View) this.cmy, r.g.polymeric_attention_btn_bg);
        this.cmy.setClickable(true);
    }
}
