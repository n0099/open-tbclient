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
    private LikeModel aGV;
    private CustomMessageListener biT;
    private CustomMessageListener biU;
    private TextView dvn;
    private TextView gqC;
    private TextView gqD;
    private TextView gqE;
    private TextView gqF;
    private BarImageView gqG;
    private TextView gqH;
    private TextView gqI;
    private com.baidu.tieba.personPolymeric.c.b gqJ;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.biU = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gqJ.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gqJ.isAttention = true;
                                b.this.dvn.setVisibility(0);
                                b.this.lZ(true);
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
        this.biT = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gqJ.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gqJ.isAttention = false;
                            b.this.dvn.setVisibility(0);
                            b.this.lZ(b.this.gqJ.isAttention);
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
        this.aGV = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_polymeric_attention_bar_rootview);
        this.gqC = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_day);
        this.gqD = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_month);
        this.gqE = (TextView) view.findViewById(e.g.card_polymeric_attention_sex);
        this.gqF = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_des);
        this.gqG = (BarImageView) view.findViewById(e.g.card_polymeric_attention_icon);
        this.gqH = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_name);
        this.gqI = (TextView) view.findViewById(e.g.card_polymeric_attention_post_num);
        this.dvn = (TextView) view.findViewById(e.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dvn.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.biU);
        this.mTbPageContext.registerListener(this.biT);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.item_person_header_attention_bg_selector);
            al.c(this.gqC, e.d.cp_cont_f, 1);
            al.c(this.gqD, e.d.cp_cont_f, 1);
            al.c(this.gqE, e.d.cp_cont_f, 1);
            al.c(this.gqF, e.d.cp_cont_f, 1);
            al.c(this.gqH, e.d.cp_cont_b, 1);
            al.c(this.gqI, e.d.cp_cont_c, 1);
            if (this.gqJ != null) {
                lZ(this.gqJ.isAttention);
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
        this.gqJ = bVar;
        this.isHost = bVar.isHost;
        this.gqC.setVisibility(bVar.cQW ? 0 : 4);
        this.gqD.setVisibility(bVar.cQW ? 0 : 4);
        this.gqC.setText(bVar.cQQ);
        this.gqD.setText(bVar.cQP);
        TextView textView = this.gqE;
        if (bVar.isHost) {
            string = this.mContext.getString(e.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(e.j.she) : this.mContext.getString(e.j.he);
        }
        textView.setText(string);
        this.gqG.startLoad(bVar.avatar, 10, false);
        String str = bVar.gpK;
        if (y.is(str) > 10) {
            str = y.o(str, 0, 10) + "...";
        }
        this.gqH.setText(String.format(this.mContext.getString(e.j.person_polymeric_bar_suffix), str));
        String M = ao.M(bVar.gpL);
        this.gqI.setText(bVar.isHost ? String.format(this.mContext.getString(e.j.person_polymeric_attention_post_host), M, ao.M(bVar.postNum)) : String.format(this.mContext.getString(e.j.person_polymeric_attention_post_guess), M));
        if (bVar.isAttention || bVar.isHost) {
            this.dvn.setVisibility(8);
            return;
        }
        this.dvn.setVisibility(0);
        lZ(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gqJ.gpK, "")));
        } else if (this.dvn == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bH(this.mContext);
            } else if (ao.bv(this.gqJ.gpK) && !this.gqJ.isAttention) {
                this.aGV.cF(this.gqJ.gpK, String.valueOf(this.gqJ.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(boolean z) {
        if (z) {
            this.dvn.setText(this.mContext.getString(e.j.relate_forum_is_followed));
            al.h(this.dvn, e.d.cp_cont_e);
            al.i(this.dvn, e.d.transparent);
            this.dvn.setClickable(false);
            return;
        }
        this.dvn.setText(this.mContext.getString(e.j.focus_text));
        al.c(this.dvn, e.d.cp_link_tip_a, 1);
        al.i(this.dvn, e.f.polymeric_attention_btn_bg);
        this.dvn.setClickable(true);
    }
}
