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
    private LikeModel aLn;
    private CustomMessageListener bnf;
    private CustomMessageListener bng;
    private TextView dFT;
    private TextView gBJ;
    private TextView gBK;
    private TextView gBL;
    private TextView gBM;
    private BarImageView gBN;
    private TextView gBO;
    private TextView gBP;
    private com.baidu.tieba.personPolymeric.c.b gBQ;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bng = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gBQ.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gBQ.isAttention = true;
                                b.this.dFT.setVisibility(0);
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
        this.bnf = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gBQ.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gBQ.isAttention = false;
                            b.this.dFT.setVisibility(0);
                            b.this.mq(b.this.gBQ.isAttention);
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
        this.aLn = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_polymeric_attention_bar_rootview);
        this.gBJ = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_day);
        this.gBK = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_month);
        this.gBL = (TextView) view.findViewById(e.g.card_polymeric_attention_sex);
        this.gBM = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_des);
        this.gBN = (BarImageView) view.findViewById(e.g.card_polymeric_attention_icon);
        this.gBO = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_name);
        this.gBP = (TextView) view.findViewById(e.g.card_polymeric_attention_post_num);
        this.dFT = (TextView) view.findViewById(e.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dFT.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bng);
        this.mTbPageContext.registerListener(this.bnf);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.item_person_header_attention_bg_selector);
            al.c(this.gBJ, e.d.cp_cont_f, 1);
            al.c(this.gBK, e.d.cp_cont_f, 1);
            al.c(this.gBL, e.d.cp_cont_f, 1);
            al.c(this.gBM, e.d.cp_cont_f, 1);
            al.c(this.gBO, e.d.cp_cont_b, 1);
            al.c(this.gBP, e.d.cp_cont_c, 1);
            if (this.gBQ != null) {
                mq(this.gBQ.isAttention);
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
        this.gBQ = bVar;
        this.isHost = bVar.isHost;
        this.gBJ.setVisibility(bVar.dbB ? 0 : 4);
        this.gBK.setVisibility(bVar.dbB ? 0 : 4);
        this.gBJ.setText(bVar.dbv);
        this.gBK.setText(bVar.dbu);
        TextView textView = this.gBL;
        if (bVar.isHost) {
            string = this.mContext.getString(e.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(e.j.she) : this.mContext.getString(e.j.he);
        }
        textView.setText(string);
        this.gBN.startLoad(bVar.avatar, 10, false);
        String str = bVar.gAR;
        if (y.iM(str) > 10) {
            str = y.q(str, 0, 10) + "...";
        }
        this.gBO.setText(String.format(this.mContext.getString(e.j.person_polymeric_bar_suffix), str));
        String W = ao.W(bVar.gAS);
        this.gBP.setText(bVar.isHost ? String.format(this.mContext.getString(e.j.person_polymeric_attention_post_host), W, ao.W(bVar.postNum)) : String.format(this.mContext.getString(e.j.person_polymeric_attention_post_guess), W));
        if (bVar.isAttention || bVar.isHost) {
            this.dFT.setVisibility(8);
            return;
        }
        this.dFT.setVisibility(0);
        mq(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gBQ.gAR, "")));
        } else if (this.dFT == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bI(this.mContext);
            } else if (ao.bv(this.gBQ.gAR) && !this.gBQ.isAttention) {
                this.aLn.cK(this.gBQ.gAR, String.valueOf(this.gBQ.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
        if (z) {
            this.dFT.setText(this.mContext.getString(e.j.relate_forum_is_followed));
            al.h(this.dFT, e.d.cp_cont_e);
            al.i(this.dFT, e.d.transparent);
            this.dFT.setClickable(false);
            return;
        }
        this.dFT.setText(this.mContext.getString(e.j.focus_text));
        al.c(this.dFT, e.d.cp_link_tip_a, 1);
        al.i(this.dFT, e.f.polymeric_attention_btn_bg);
        this.dFT.setClickable(true);
    }
}
