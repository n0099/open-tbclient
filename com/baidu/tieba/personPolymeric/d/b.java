package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel bGM;
    private CustomMessageListener bGT;
    private CustomMessageListener bGU;
    private boolean buB;
    private TextView cKz;
    private u fkd;
    private TextView fmK;
    private TextView fmL;
    private TextView fmM;
    private TextView fmN;
    private BarImageView fmO;
    private TextView fmP;
    private TextView fmQ;
    private com.baidu.tieba.personPolymeric.c.b fmR;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bGU = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.buB) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fmR.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fmR.isAttention = true;
                                b.this.cKz.setVisibility(0);
                                b.this.kv(true);
                                com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.k.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.bGT = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.buB) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fmR.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fmR.isAttention = false;
                            b.this.cKz.setVisibility(0);
                            b.this.kv(b.this.fmR.isAttention);
                            com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.bGM = likeModel;
    }

    public void a(u uVar) {
        this.fkd = uVar;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.card_polymeric_attention_bar_rootview);
        this.fmK = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_day);
        this.fmL = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_month);
        this.fmM = (TextView) view.findViewById(d.h.card_polymeric_attention_sex);
        this.fmN = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_des);
        this.fmO = (BarImageView) view.findViewById(d.h.card_polymeric_attention_icon);
        this.fmP = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_name);
        this.fmQ = (TextView) view.findViewById(d.h.card_polymeric_attention_post_num);
        this.cKz = (TextView) view.findViewById(d.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cKz.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bGU);
        this.mTbPageContext.registerListener(this.bGT);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
            ai.c(this.fmK, d.e.cp_cont_f, 1);
            ai.c(this.fmL, d.e.cp_cont_f, 1);
            ai.c(this.fmM, d.e.cp_cont_f, 1);
            ai.c(this.fmN, d.e.cp_cont_f, 1);
            ai.c(this.fmP, d.e.cp_cont_b, 1);
            ai.c(this.fmQ, d.e.cp_cont_c, 1);
            if (this.fmR != null) {
                kv(this.fmR.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_polymeric_attention_bar_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.b bVar) {
        String string;
        if (bVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.fmR = bVar;
        this.buB = bVar.buB;
        this.fmK.setVisibility(bVar.bKZ ? 0 : 4);
        this.fmL.setVisibility(bVar.bKZ ? 0 : 4);
        this.fmK.setText(bVar.fme);
        this.fmL.setText(bVar.bKS);
        TextView textView = this.fmM;
        if (bVar.buB) {
            string = this.mContext.getString(d.l.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.l.person_identity_she) : this.mContext.getString(d.l.he);
        }
        textView.setText(string);
        this.fmO.c(bVar.avatar, 10, false);
        String str = bVar.cXk;
        if (v.gW(str) > 10) {
            str = v.e(str, 0, 10) + "...";
        }
        this.fmP.setText(String.format(this.mContext.getString(d.l.person_polymeric_bar_suffix), str));
        String A = al.A(bVar.fmf);
        this.fmQ.setText(bVar.buB ? String.format(this.mContext.getString(d.l.person_polymeric_attention_post_host), A, al.A(bVar.postNum)) : String.format(this.mContext.getString(d.l.person_polymeric_attention_post_guess), A));
        if (bVar.isAttention || bVar.buB) {
            this.cKz.setVisibility(8);
            return;
        }
        this.cKz.setVisibility(0);
        kv(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.buB) {
                TiebaStatic.log(new aj("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fmR.cXk, "")));
        } else if (this.cKz == view) {
            TiebaStatic.log(new aj("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(this.mContext);
            } else if (al.aP(this.fmR.cXk) && !this.fmR.isAttention) {
                this.bGM.ch(this.fmR.cXk, String.valueOf(this.fmR.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(boolean z) {
        if (z) {
            this.cKz.setText(this.mContext.getString(d.l.relate_forum_is_followed));
            ai.i(this.cKz, d.e.cp_cont_e);
            ai.j(this.cKz, d.e.transparent);
            this.cKz.setClickable(false);
            return;
        }
        this.cKz.setText(this.mContext.getString(d.l.focus_text));
        ai.c(this.cKz, d.e.cp_link_tip_a, 1);
        ai.j(this.cKz, d.g.polymeric_attention_btn_bg);
        this.cKz.setClickable(true);
    }
}
