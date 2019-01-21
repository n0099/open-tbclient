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
    private LikeModel aLQ;
    private CustomMessageListener bnU;
    private CustomMessageListener bnV;
    private TextView dGD;
    private TextView gCO;
    private TextView gCP;
    private TextView gCQ;
    private TextView gCR;
    private BarImageView gCS;
    private TextView gCT;
    private TextView gCU;
    private com.baidu.tieba.personPolymeric.c.b gCV;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bnV = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gCV.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gCV.isAttention = true;
                                b.this.dGD.setVisibility(0);
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
        this.bnU = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gCV.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gCV.isAttention = false;
                            b.this.dGD.setVisibility(0);
                            b.this.mq(b.this.gCV.isAttention);
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
        this.aLQ = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_polymeric_attention_bar_rootview);
        this.gCO = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_day);
        this.gCP = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_month);
        this.gCQ = (TextView) view.findViewById(e.g.card_polymeric_attention_sex);
        this.gCR = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_des);
        this.gCS = (BarImageView) view.findViewById(e.g.card_polymeric_attention_icon);
        this.gCT = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_name);
        this.gCU = (TextView) view.findViewById(e.g.card_polymeric_attention_post_num);
        this.dGD = (TextView) view.findViewById(e.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dGD.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bnV);
        this.mTbPageContext.registerListener(this.bnU);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.item_person_header_attention_bg_selector);
            al.c(this.gCO, e.d.cp_cont_f, 1);
            al.c(this.gCP, e.d.cp_cont_f, 1);
            al.c(this.gCQ, e.d.cp_cont_f, 1);
            al.c(this.gCR, e.d.cp_cont_f, 1);
            al.c(this.gCT, e.d.cp_cont_b, 1);
            al.c(this.gCU, e.d.cp_cont_c, 1);
            if (this.gCV != null) {
                mq(this.gCV.isAttention);
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
        this.gCV = bVar;
        this.isHost = bVar.isHost;
        this.gCO.setVisibility(bVar.dco ? 0 : 4);
        this.gCP.setVisibility(bVar.dco ? 0 : 4);
        this.gCO.setText(bVar.dci);
        this.gCP.setText(bVar.dch);
        TextView textView = this.gCQ;
        if (bVar.isHost) {
            string = this.mContext.getString(e.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(e.j.she) : this.mContext.getString(e.j.he);
        }
        textView.setText(string);
        this.gCS.startLoad(bVar.avatar, 10, false);
        String str = bVar.gBW;
        if (z.jc(str) > 10) {
            str = z.q(str, 0, 10) + "...";
        }
        this.gCT.setText(String.format(this.mContext.getString(e.j.person_polymeric_bar_suffix), str));
        String W = ao.W(bVar.gBX);
        this.gCU.setText(bVar.isHost ? String.format(this.mContext.getString(e.j.person_polymeric_attention_post_host), W, ao.W(bVar.postNum)) : String.format(this.mContext.getString(e.j.person_polymeric_attention_post_guess), W));
        if (bVar.isAttention || bVar.isHost) {
            this.dGD.setVisibility(8);
            return;
        }
        this.dGD.setVisibility(0);
        mq(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gCV.gBW, "")));
        } else if (this.dGD == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(this.mContext);
            } else if (ao.bv(this.gCV.gBW) && !this.gCV.isAttention) {
                this.aLQ.cM(this.gCV.gBW, String.valueOf(this.gCV.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
        if (z) {
            this.dGD.setText(this.mContext.getString(e.j.relate_forum_is_followed));
            al.h(this.dGD, e.d.cp_cont_e);
            al.i(this.dGD, e.d.transparent);
            this.dGD.setClickable(false);
            return;
        }
        this.dGD.setText(this.mContext.getString(e.j.focus_text));
        al.c(this.dGD, e.d.cp_link_tip_a, 1);
        al.i(this.dGD, e.f.polymeric_attention_btn_bg);
        this.dGD.setClickable(true);
    }
}
