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
    private LikeModel bUs;
    private CustomMessageListener cyu;
    private CustomMessageListener cyv;
    private TextView eTC;
    private TextView hSA;
    private TextView hSB;
    private TextView hSC;
    private BarImageView hSD;
    private TextView hSE;
    private TextView hSF;
    private com.baidu.tieba.personPolymeric.c.b hSG;
    private TextView hSz;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cyv = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.hSG.forumId) {
                            if (aVar.isSuccess) {
                                b.this.hSG.isAttention = true;
                                b.this.eTC.setVisibility(0);
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
        this.cyu = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.hSG.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.hSG.isAttention = false;
                            b.this.eTC.setVisibility(0);
                            b.this.oN(b.this.hSG.isAttention);
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
        this.bUs = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.hSz = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.hSA = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.hSB = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.hSC = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.hSD = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.hSE = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.hSF = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.eTC = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.eTC.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cyv);
        this.mTbPageContext.registerListener(this.cyu);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.f.item_person_header_attention_bg_selector);
            al.d(this.hSz, d.C0277d.cp_cont_f, 1);
            al.d(this.hSA, d.C0277d.cp_cont_f, 1);
            al.d(this.hSB, d.C0277d.cp_cont_f, 1);
            al.d(this.hSC, d.C0277d.cp_cont_f, 1);
            al.d(this.hSE, d.C0277d.cp_cont_b, 1);
            al.d(this.hSF, d.C0277d.cp_cont_c, 1);
            if (this.hSG != null) {
                oN(this.hSG.isAttention);
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
        this.hSG = bVar;
        this.isHost = bVar.isHost;
        this.hSz.setVisibility(bVar.elX ? 0 : 4);
        this.hSA.setVisibility(bVar.elX ? 0 : 4);
        this.hSz.setText(bVar.elR);
        this.hSA.setText(bVar.elQ);
        TextView textView = this.hSB;
        if (bVar.isHost) {
            string = this.mContext.getString(d.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        }
        textView.setText(string);
        this.hSD.startLoad(bVar.avatar, 10, false);
        String str = bVar.hRH;
        if (ab.pN(str) > 10) {
            str = ab.p(str, 0, 10) + "...";
        }
        this.hSE.setText(String.format(this.mContext.getString(d.j.person_polymeric_bar_suffix), str));
        String ay = ap.ay(bVar.hRI);
        this.hSF.setText(bVar.isHost ? String.format(this.mContext.getString(d.j.person_polymeric_attention_post_host), ay, ap.ay(bVar.postNum)) : String.format(this.mContext.getString(d.j.person_polymeric_attention_post_guess), ay));
        if (bVar.isAttention || bVar.isHost) {
            this.eTC.setVisibility(8);
            return;
        }
        this.eTC.setVisibility(0);
        oN(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.hSG.hRH, "")));
        } else if (this.eTC == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cY(this.mContext);
            } else if (ap.bv(this.hSG.hRH) && !this.hSG.isAttention) {
                this.bUs.dW(this.hSG.hRH, String.valueOf(this.hSG.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oN(boolean z) {
        if (z) {
            this.eTC.setText(this.mContext.getString(d.j.relate_forum_is_followed));
            al.j(this.eTC, d.C0277d.cp_cont_e);
            al.k(this.eTC, d.C0277d.transparent);
            this.eTC.setClickable(false);
            return;
        }
        this.eTC.setText(this.mContext.getString(d.j.focus_text));
        al.d(this.eTC, d.C0277d.cp_link_tip_a, 1);
        al.k(this.eTC, d.f.polymeric_attention_btn_bg);
        this.eTC.setClickable(true);
    }
}
