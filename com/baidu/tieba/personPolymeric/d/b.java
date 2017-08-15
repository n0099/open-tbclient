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
    private LikeModel bGL;
    private CustomMessageListener bGS;
    private CustomMessageListener bGT;
    private boolean buA;
    private TextView cKz;
    private u fkb;
    private TextView fmI;
    private TextView fmJ;
    private TextView fmK;
    private TextView fmL;
    private BarImageView fmM;
    private TextView fmN;
    private TextView fmO;
    private com.baidu.tieba.personPolymeric.c.b fmP;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bGT = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.buA) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fmP.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fmP.isAttention = true;
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
        this.bGS = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.buA) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fmP.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fmP.isAttention = false;
                            b.this.cKz.setVisibility(0);
                            b.this.kv(b.this.fmP.isAttention);
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
        this.bGL = likeModel;
    }

    public void a(u uVar) {
        this.fkb = uVar;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(d.h.card_polymeric_attention_bar_rootview);
        this.fmI = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_day);
        this.fmJ = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_month);
        this.fmK = (TextView) view.findViewById(d.h.card_polymeric_attention_sex);
        this.fmL = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_des);
        this.fmM = (BarImageView) view.findViewById(d.h.card_polymeric_attention_icon);
        this.fmN = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_name);
        this.fmO = (TextView) view.findViewById(d.h.card_polymeric_attention_post_num);
        this.cKz = (TextView) view.findViewById(d.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cKz.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bGT);
        this.mTbPageContext.registerListener(this.bGS);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
            ai.c(this.fmI, d.e.cp_cont_f, 1);
            ai.c(this.fmJ, d.e.cp_cont_f, 1);
            ai.c(this.fmK, d.e.cp_cont_f, 1);
            ai.c(this.fmL, d.e.cp_cont_f, 1);
            ai.c(this.fmN, d.e.cp_cont_b, 1);
            ai.c(this.fmO, d.e.cp_cont_c, 1);
            if (this.fmP != null) {
                kv(this.fmP.isAttention);
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
        this.fmP = bVar;
        this.buA = bVar.buA;
        this.fmI.setVisibility(bVar.bKY ? 0 : 4);
        this.fmJ.setVisibility(bVar.bKY ? 0 : 4);
        this.fmI.setText(bVar.fmc);
        this.fmJ.setText(bVar.bKR);
        TextView textView = this.fmK;
        if (bVar.buA) {
            string = this.mContext.getString(d.l.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.l.person_identity_she) : this.mContext.getString(d.l.he);
        }
        textView.setText(string);
        this.fmM.c(bVar.avatar, 10, false);
        String str = bVar.cXk;
        if (v.gT(str) > 10) {
            str = v.d(str, 0, 10) + "...";
        }
        this.fmN.setText(String.format(this.mContext.getString(d.l.person_polymeric_bar_suffix), str));
        String A = al.A(bVar.fmd);
        this.fmO.setText(bVar.buA ? String.format(this.mContext.getString(d.l.person_polymeric_attention_post_host), A, al.A(bVar.postNum)) : String.format(this.mContext.getString(d.l.person_polymeric_attention_post_guess), A));
        if (bVar.isAttention || bVar.buA) {
            this.cKz.setVisibility(8);
            return;
        }
        this.cKz.setVisibility(0);
        kv(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.buA) {
                TiebaStatic.log(new aj("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fmP.cXk, "")));
        } else if (this.cKz == view) {
            TiebaStatic.log(new aj("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aN(this.mContext);
            } else if (al.aO(this.fmP.cXk) && !this.fmP.isAttention) {
                this.bGL.cf(this.fmP.cXk, String.valueOf(this.fmP.forumId));
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
