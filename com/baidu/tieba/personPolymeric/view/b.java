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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener bbb;
    private CustomMessageListener bbc;
    private LikeModel bwM;
    private TextView deE;
    private com.baidu.tieba.personPolymeric.c.b gbA;
    private TextView gbt;
    private TextView gbu;
    private TextView gbv;
    private TextView gbw;
    private BarImageView gbx;
    private TextView gby;
    private TextView gbz;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bbc = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gbA.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gbA.isAttention = true;
                                b.this.deE.setVisibility(0);
                                b.this.lA(true);
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
        this.bbb = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gbA.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gbA.isAttention = false;
                            b.this.deE.setVisibility(0);
                            b.this.lA(b.this.gbA.isAttention);
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
        this.bwM = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.gbt = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.gbu = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.gbv = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.gbw = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.gbx = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.gby = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.gbz = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.deE = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.deE.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bbc);
        this.mTbPageContext.registerListener(this.bbb);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, d.f.item_person_header_attention_bg_selector);
            am.c(this.gbt, d.C0142d.cp_cont_f, 1);
            am.c(this.gbu, d.C0142d.cp_cont_f, 1);
            am.c(this.gbv, d.C0142d.cp_cont_f, 1);
            am.c(this.gbw, d.C0142d.cp_cont_f, 1);
            am.c(this.gby, d.C0142d.cp_cont_b, 1);
            am.c(this.gbz, d.C0142d.cp_cont_c, 1);
            if (this.gbA != null) {
                lA(this.gbA.isAttention);
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
        this.gbA = bVar;
        this.isHost = bVar.isHost;
        this.gbt.setVisibility(bVar.cAk ? 0 : 4);
        this.gbu.setVisibility(bVar.cAk ? 0 : 4);
        this.gbt.setText(bVar.cAe);
        this.gbu.setText(bVar.cAd);
        TextView textView = this.gbv;
        if (bVar.isHost) {
            string = this.mContext.getString(d.k.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.k.she) : this.mContext.getString(d.k.he);
        }
        textView.setText(string);
        this.gbx.startLoad(bVar.avatar, 10, false);
        String str = bVar.gaB;
        if (x.hK(str) > 10) {
            str = x.k(str, 0, 10) + "...";
        }
        this.gby.setText(String.format(this.mContext.getString(d.k.person_polymeric_bar_suffix), str));
        String E = ap.E(bVar.gaC);
        this.gbz.setText(bVar.isHost ? String.format(this.mContext.getString(d.k.person_polymeric_attention_post_host), E, ap.E(bVar.postNum)) : String.format(this.mContext.getString(d.k.person_polymeric_attention_post_guess), E));
        if (bVar.isAttention || bVar.isHost) {
            this.deE.setVisibility(8);
            return;
        }
        this.deE.setVisibility(0);
        lA(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gbA.gaB, "")));
        } else if (this.deE == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bb.aT(this.mContext);
            } else if (ap.be(this.gbA.gaB) && !this.gbA.isAttention) {
                this.bwM.cn(this.gbA.gaB, String.valueOf(this.gbA.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA(boolean z) {
        if (z) {
            this.deE.setText(this.mContext.getString(d.k.relate_forum_is_followed));
            am.h(this.deE, d.C0142d.cp_cont_e);
            am.i(this.deE, d.C0142d.transparent);
            this.deE.setClickable(false);
            return;
        }
        this.deE.setText(this.mContext.getString(d.k.focus_text));
        am.c(this.deE, d.C0142d.cp_link_tip_a, 1);
        am.i(this.deE, d.f.polymeric_attention_btn_bg);
        this.deE.setClickable(true);
    }
}
