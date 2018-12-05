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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel aLl;
    private CustomMessageListener bnc;
    private CustomMessageListener bnd;
    private TextView dDf;
    private TextView gyS;
    private TextView gyT;
    private TextView gyU;
    private TextView gyV;
    private BarImageView gyW;
    private TextView gyX;
    private TextView gyY;
    private com.baidu.tieba.personPolymeric.c.b gyZ;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bnd = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gyZ.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gyZ.isAttention = true;
                                b.this.dDf.setVisibility(0);
                                b.this.mn(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, e.j.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, e.j.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.bnc = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gyZ.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gyZ.isAttention = false;
                            b.this.dDf.setVisibility(0);
                            b.this.mn(b.this.gyZ.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, e.j.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, e.j.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.aLl = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_polymeric_attention_bar_rootview);
        this.gyS = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_day);
        this.gyT = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_month);
        this.gyU = (TextView) view.findViewById(e.g.card_polymeric_attention_sex);
        this.gyV = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_des);
        this.gyW = (BarImageView) view.findViewById(e.g.card_polymeric_attention_icon);
        this.gyX = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_name);
        this.gyY = (TextView) view.findViewById(e.g.card_polymeric_attention_post_num);
        this.dDf = (TextView) view.findViewById(e.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dDf.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bnd);
        this.mTbPageContext.registerListener(this.bnc);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.item_person_header_attention_bg_selector);
            al.c(this.gyS, e.d.cp_cont_f, 1);
            al.c(this.gyT, e.d.cp_cont_f, 1);
            al.c(this.gyU, e.d.cp_cont_f, 1);
            al.c(this.gyV, e.d.cp_cont_f, 1);
            al.c(this.gyX, e.d.cp_cont_b, 1);
            al.c(this.gyY, e.d.cp_cont_c, 1);
            if (this.gyZ != null) {
                mn(this.gyZ.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_polymeric_attention_bar_view;
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
        this.gyZ = bVar;
        this.isHost = bVar.isHost;
        this.gyS.setVisibility(bVar.cYJ ? 0 : 4);
        this.gyT.setVisibility(bVar.cYJ ? 0 : 4);
        this.gyS.setText(bVar.cYD);
        this.gyT.setText(bVar.cYC);
        TextView textView = this.gyU;
        if (bVar.isHost) {
            string = this.mContext.getString(e.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(e.j.she) : this.mContext.getString(e.j.he);
        }
        textView.setText(string);
        this.gyW.startLoad(bVar.avatar, 10, false);
        String str = bVar.gya;
        if (y.iL(str) > 10) {
            str = y.q(str, 0, 10) + "...";
        }
        this.gyX.setText(String.format(this.mContext.getString(e.j.person_polymeric_bar_suffix), str));
        String V = ao.V(bVar.gyb);
        this.gyY.setText(bVar.isHost ? String.format(this.mContext.getString(e.j.person_polymeric_attention_post_host), V, ao.V(bVar.postNum)) : String.format(this.mContext.getString(e.j.person_polymeric_attention_post_guess), V));
        if (bVar.isAttention || bVar.isHost) {
            this.dDf.setVisibility(8);
            return;
        }
        this.dDf.setVisibility(0);
        mn(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gyZ.gya, "")));
        } else if (this.dDf == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(this.mContext);
            } else if (ao.bv(this.gyZ.gya) && !this.gyZ.isAttention) {
                this.aLl.cK(this.gyZ.gya, String.valueOf(this.gyZ.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(boolean z) {
        if (z) {
            this.dDf.setText(this.mContext.getString(e.j.relate_forum_is_followed));
            al.h(this.dDf, e.d.cp_cont_e);
            al.i(this.dDf, e.d.transparent);
            this.dDf.setClickable(false);
            return;
        }
        this.dDf.setText(this.mContext.getString(e.j.focus_text));
        al.c(this.dDf, e.d.cp_link_tip_a, 1);
        al.i(this.dDf, e.f.polymeric_attention_btn_bg);
        this.dDf.setClickable(true);
    }
}
