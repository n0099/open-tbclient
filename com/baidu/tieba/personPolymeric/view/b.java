package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel bUq;
    private CustomMessageListener cys;
    private CustomMessageListener cyt;
    private TextView eTQ;
    private TextView hSN;
    private TextView hSO;
    private TextView hSP;
    private TextView hSQ;
    private BarImageView hSR;
    private TextView hSS;
    private TextView hST;
    private com.baidu.tieba.personPolymeric.c.b hSU;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cyt = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.hSU.forumId) {
                            if (aVar.isSuccess) {
                                b.this.hSU.isAttention = true;
                                b.this.eTQ.setVisibility(0);
                                b.this.oN(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.j.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.j.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.cys = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.hSU.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.hSU.isAttention = false;
                            b.this.eTQ.setVisibility(0);
                            b.this.oN(b.this.hSU.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.j.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.j.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.bUq = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.hSN = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.hSO = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.hSP = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.hSQ = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.hSR = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.hSS = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.hST = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.eTQ = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.eTQ.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cyt);
        this.mTbPageContext.registerListener(this.cys);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.f.item_person_header_attention_bg_selector);
            al.d(this.hSN, d.C0277d.cp_cont_f, 1);
            al.d(this.hSO, d.C0277d.cp_cont_f, 1);
            al.d(this.hSP, d.C0277d.cp_cont_f, 1);
            al.d(this.hSQ, d.C0277d.cp_cont_f, 1);
            al.d(this.hSS, d.C0277d.cp_cont_b, 1);
            al.d(this.hST, d.C0277d.cp_cont_c, 1);
            if (this.hSU != null) {
                oN(this.hSU.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_polymeric_attention_bar_view;
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
        this.hSU = bVar;
        this.isHost = bVar.isHost;
        this.hSN.setVisibility(bVar.eml ? 0 : 4);
        this.hSO.setVisibility(bVar.eml ? 0 : 4);
        this.hSN.setText(bVar.emf);
        this.hSO.setText(bVar.eme);
        TextView textView = this.hSP;
        if (bVar.isHost) {
            string = this.mContext.getString(d.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        }
        textView.setText(string);
        this.hSR.startLoad(bVar.avatar, 10, false);
        String str = bVar.hRV;
        if (ab.pM(str) > 10) {
            str = ab.p(str, 0, 10) + "...";
        }
        this.hSS.setText(String.format(this.mContext.getString(d.j.person_polymeric_bar_suffix), str));
        String ay = ap.ay(bVar.hRW);
        this.hST.setText(bVar.isHost ? String.format(this.mContext.getString(d.j.person_polymeric_attention_post_host), ay, ap.ay(bVar.postNum)) : String.format(this.mContext.getString(d.j.person_polymeric_attention_post_guess), ay));
        if (bVar.isAttention || bVar.isHost) {
            this.eTQ.setVisibility(8);
            return;
        }
        this.eTQ.setVisibility(0);
        oN(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.hSU.hRV, "")));
        } else if (this.eTQ == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(this.mContext);
            } else if (ap.bv(this.hSU.hRV) && !this.hSU.isAttention) {
                this.bUq.dV(this.hSU.hRV, String.valueOf(this.hSU.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oN(boolean z) {
        if (z) {
            this.eTQ.setText(this.mContext.getString(d.j.relate_forum_is_followed));
            al.j(this.eTQ, d.C0277d.cp_cont_e);
            al.k(this.eTQ, d.C0277d.transparent);
            this.eTQ.setClickable(false);
            return;
        }
        this.eTQ.setText(this.mContext.getString(d.j.focus_text));
        al.d(this.eTQ, d.C0277d.cp_link_tip_a, 1);
        al.k(this.eTQ, d.f.polymeric_attention_btn_bg);
        this.eTQ.setClickable(true);
    }
}
