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
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener baf;
    private CustomMessageListener bag;
    private LikeModel bvr;
    private TextView dKB;
    private com.baidu.tieba.personPolymeric.c.b fXA;
    private TextView fXt;
    private TextView fXu;
    private TextView fXv;
    private TextView fXw;
    private BarImageView fXx;
    private TextView fXy;
    private TextView fXz;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bag = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fXA.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fXA.isAttention = true;
                                b.this.dKB.setVisibility(0);
                                b.this.lq(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.k.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.k.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.baf = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fXA.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fXA.isAttention = false;
                            b.this.dKB.setVisibility(0);
                            b.this.lq(b.this.fXA.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.k.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.k.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.bvr = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.fXt = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.fXu = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.fXv = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.fXw = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.fXx = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.fXy = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.fXz = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.dKB = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dKB.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bag);
        this.mTbPageContext.registerListener(this.baf);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, d.f.item_person_header_attention_bg_selector);
            al.c(this.fXt, d.C0141d.cp_cont_f, 1);
            al.c(this.fXu, d.C0141d.cp_cont_f, 1);
            al.c(this.fXv, d.C0141d.cp_cont_f, 1);
            al.c(this.fXw, d.C0141d.cp_cont_f, 1);
            al.c(this.fXy, d.C0141d.cp_cont_b, 1);
            al.c(this.fXz, d.C0141d.cp_cont_c, 1);
            if (this.fXA != null) {
                lq(this.fXA.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_polymeric_attention_bar_view;
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
        this.fXA = bVar;
        this.isHost = bVar.isHost;
        this.fXt.setVisibility(bVar.cCq ? 0 : 4);
        this.fXu.setVisibility(bVar.cCq ? 0 : 4);
        this.fXt.setText(bVar.cCk);
        this.fXu.setText(bVar.cCj);
        TextView textView = this.fXv;
        if (bVar.isHost) {
            string = this.mContext.getString(d.k.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.k.she) : this.mContext.getString(d.k.he);
        }
        textView.setText(string);
        this.fXx.startLoad(bVar.avatar, 10, false);
        String str = bVar.fWB;
        if (x.hG(str) > 10) {
            str = x.k(str, 0, 10) + "...";
        }
        this.fXy.setText(String.format(this.mContext.getString(d.k.person_polymeric_bar_suffix), str));
        String D = ao.D(bVar.fWC);
        this.fXz.setText(bVar.isHost ? String.format(this.mContext.getString(d.k.person_polymeric_attention_post_host), D, ao.D(bVar.postNum)) : String.format(this.mContext.getString(d.k.person_polymeric_attention_post_guess), D));
        if (bVar.isAttention || bVar.isHost) {
            this.dKB.setVisibility(8);
            return;
        }
        this.dKB.setVisibility(0);
        lq(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.fXA.fWB, "")));
        } else if (this.dKB == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.aT(this.mContext);
            } else if (ao.bc(this.fXA.fWB) && !this.fXA.isAttention) {
                this.bvr.cj(this.fXA.fWB, String.valueOf(this.fXA.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(boolean z) {
        if (z) {
            this.dKB.setText(this.mContext.getString(d.k.relate_forum_is_followed));
            al.h(this.dKB, d.C0141d.cp_cont_e);
            al.i(this.dKB, d.C0141d.transparent);
            this.dKB.setClickable(false);
            return;
        }
        this.dKB.setText(this.mContext.getString(d.k.focus_text));
        al.c(this.dKB, d.C0141d.cp_link_tip_a, 1);
        al.i(this.dKB, d.f.polymeric_attention_btn_bg);
        this.dKB.setClickable(true);
    }
}
