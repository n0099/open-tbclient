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
    private LikeModel bGc;
    private CustomMessageListener bGj;
    private CustomMessageListener bGk;
    private boolean buk;
    private TextView cIC;
    private u fih;
    private TextView fkP;
    private TextView fkQ;
    private TextView fkR;
    private TextView fkS;
    private BarImageView fkT;
    private TextView fkU;
    private TextView fkV;
    private com.baidu.tieba.personPolymeric.c.b fkW;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bGk = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.buk) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fkW.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fkW.isAttention = true;
                                b.this.cIC.setVisibility(0);
                                b.this.ks(true);
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
        this.bGj = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.buk) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fkW.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fkW.isAttention = false;
                            b.this.cIC.setVisibility(0);
                            b.this.ks(b.this.fkW.isAttention);
                            com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.unlike_failure);
                    }
                }
            }
        };
        S(getView());
    }

    public void a(LikeModel likeModel) {
        this.bGc = likeModel;
    }

    public void a(u uVar) {
        this.fih = uVar;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(d.h.card_polymeric_attention_bar_rootview);
        this.fkP = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_day);
        this.fkQ = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_month);
        this.fkR = (TextView) view.findViewById(d.h.card_polymeric_attention_sex);
        this.fkS = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_des);
        this.fkT = (BarImageView) view.findViewById(d.h.card_polymeric_attention_icon);
        this.fkU = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_name);
        this.fkV = (TextView) view.findViewById(d.h.card_polymeric_attention_post_num);
        this.cIC = (TextView) view.findViewById(d.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cIC.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bGk);
        this.mTbPageContext.registerListener(this.bGj);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
            ai.c(this.fkP, d.e.cp_cont_f, 1);
            ai.c(this.fkQ, d.e.cp_cont_f, 1);
            ai.c(this.fkR, d.e.cp_cont_f, 1);
            ai.c(this.fkS, d.e.cp_cont_f, 1);
            ai.c(this.fkU, d.e.cp_cont_b, 1);
            ai.c(this.fkV, d.e.cp_cont_c, 1);
            if (this.fkW != null) {
                ks(this.fkW.isAttention);
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
        this.fkW = bVar;
        this.buk = bVar.buk;
        this.fkP.setVisibility(bVar.bKp ? 0 : 4);
        this.fkQ.setVisibility(bVar.bKp ? 0 : 4);
        this.fkP.setText(bVar.fkj);
        this.fkQ.setText(bVar.bKi);
        TextView textView = this.fkR;
        if (bVar.buk) {
            string = this.mContext.getString(d.l.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.l.person_identity_she) : this.mContext.getString(d.l.he);
        }
        textView.setText(string);
        this.fkT.c(bVar.avatar, 10, false);
        String str = bVar.cVl;
        if (v.gT(str) > 10) {
            str = v.d(str, 0, 10) + "...";
        }
        this.fkU.setText(String.format(this.mContext.getString(d.l.person_polymeric_bar_suffix), str));
        String A = al.A(bVar.fkk);
        this.fkV.setText(bVar.buk ? String.format(this.mContext.getString(d.l.person_polymeric_attention_post_host), A, al.A(bVar.postNum)) : String.format(this.mContext.getString(d.l.person_polymeric_attention_post_guess), A));
        if (bVar.isAttention || bVar.buk) {
            this.cIC.setVisibility(8);
            return;
        }
        this.cIC.setVisibility(0);
        ks(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.buk) {
                TiebaStatic.log(new aj("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fkW.cVl, "")));
        } else if (this.cIC == view) {
            TiebaStatic.log(new aj("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(this.mContext);
            } else if (al.aO(this.fkW.cVl) && !this.fkW.isAttention) {
                this.bGc.ce(this.fkW.cVl, String.valueOf(this.fkW.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(boolean z) {
        if (z) {
            this.cIC.setText(this.mContext.getString(d.l.relate_forum_is_followed));
            ai.i(this.cIC, d.e.cp_cont_e);
            ai.j(this.cIC, d.e.transparent);
            this.cIC.setClickable(false);
            return;
        }
        this.cIC.setText(this.mContext.getString(d.l.focus_text));
        ai.c(this.cIC, d.e.cp_link_tip_a, 1);
        ai.j(this.cIC, d.g.polymeric_attention_btn_bg);
        this.cIC.setClickable(true);
    }
}
