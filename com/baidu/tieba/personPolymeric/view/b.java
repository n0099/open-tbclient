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
import com.baidu.tbadk.util.z;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel aLP;
    private CustomMessageListener bnT;
    private CustomMessageListener bnU;
    private TextView dGC;
    private TextView gCN;
    private TextView gCO;
    private TextView gCP;
    private TextView gCQ;
    private BarImageView gCR;
    private TextView gCS;
    private TextView gCT;
    private com.baidu.tieba.personPolymeric.c.b gCU;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bnU = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gCU.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gCU.isAttention = true;
                                b.this.dGC.setVisibility(0);
                                b.this.mq(true);
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
        this.bnT = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gCU.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gCU.isAttention = false;
                            b.this.dGC.setVisibility(0);
                            b.this.mq(b.this.gCU.isAttention);
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
        this.aLP = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_polymeric_attention_bar_rootview);
        this.gCN = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_day);
        this.gCO = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_month);
        this.gCP = (TextView) view.findViewById(e.g.card_polymeric_attention_sex);
        this.gCQ = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_des);
        this.gCR = (BarImageView) view.findViewById(e.g.card_polymeric_attention_icon);
        this.gCS = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_name);
        this.gCT = (TextView) view.findViewById(e.g.card_polymeric_attention_post_num);
        this.dGC = (TextView) view.findViewById(e.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dGC.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bnU);
        this.mTbPageContext.registerListener(this.bnT);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.item_person_header_attention_bg_selector);
            al.c(this.gCN, e.d.cp_cont_f, 1);
            al.c(this.gCO, e.d.cp_cont_f, 1);
            al.c(this.gCP, e.d.cp_cont_f, 1);
            al.c(this.gCQ, e.d.cp_cont_f, 1);
            al.c(this.gCS, e.d.cp_cont_b, 1);
            al.c(this.gCT, e.d.cp_cont_c, 1);
            if (this.gCU != null) {
                mq(this.gCU.isAttention);
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
        this.gCU = bVar;
        this.isHost = bVar.isHost;
        this.gCN.setVisibility(bVar.dcn ? 0 : 4);
        this.gCO.setVisibility(bVar.dcn ? 0 : 4);
        this.gCN.setText(bVar.dch);
        this.gCO.setText(bVar.dcg);
        TextView textView = this.gCP;
        if (bVar.isHost) {
            string = this.mContext.getString(e.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(e.j.she) : this.mContext.getString(e.j.he);
        }
        textView.setText(string);
        this.gCR.startLoad(bVar.avatar, 10, false);
        String str = bVar.gBV;
        if (z.jc(str) > 10) {
            str = z.q(str, 0, 10) + "...";
        }
        this.gCS.setText(String.format(this.mContext.getString(e.j.person_polymeric_bar_suffix), str));
        String W = ao.W(bVar.gBW);
        this.gCT.setText(bVar.isHost ? String.format(this.mContext.getString(e.j.person_polymeric_attention_post_host), W, ao.W(bVar.postNum)) : String.format(this.mContext.getString(e.j.person_polymeric_attention_post_guess), W));
        if (bVar.isAttention || bVar.isHost) {
            this.dGC.setVisibility(8);
            return;
        }
        this.dGC.setVisibility(0);
        mq(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gCU.gBV, "")));
        } else if (this.dGC == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(this.mContext);
            } else if (ao.bv(this.gCU.gBV) && !this.gCU.isAttention) {
                this.aLP.cM(this.gCU.gBV, String.valueOf(this.gCU.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
        if (z) {
            this.dGC.setText(this.mContext.getString(e.j.relate_forum_is_followed));
            al.h(this.dGC, e.d.cp_cont_e);
            al.i(this.dGC, e.d.transparent);
            this.dGC.setClickable(false);
            return;
        }
        this.dGC.setText(this.mContext.getString(e.j.focus_text));
        al.c(this.dGC, e.d.cp_link_tip_a, 1);
        al.i(this.dGC, e.f.polymeric_attention_btn_bg);
        this.dGC.setClickable(true);
    }
}
