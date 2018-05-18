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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener aSl;
    private CustomMessageListener aSm;
    private LikeModel bnl;
    private TextView dzr;
    private TextView fMh;
    private TextView fMi;
    private TextView fMj;
    private TextView fMk;
    private BarImageView fMl;
    private TextView fMm;
    private TextView fMn;
    private com.baidu.tieba.personPolymeric.c.b fMo;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aSm = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fMo.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fMo.isAttention = true;
                                b.this.dzr.setVisibility(0);
                                b.this.lk(true);
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
        this.aSl = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fMo.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fMo.isAttention = false;
                            b.this.dzr.setVisibility(0);
                            b.this.lk(b.this.fMo.isAttention);
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
        this.bnl = likeModel;
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.fMh = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_day);
        this.fMi = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_month);
        this.fMj = (TextView) view2.findViewById(d.g.card_polymeric_attention_sex);
        this.fMk = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_des);
        this.fMl = (BarImageView) view2.findViewById(d.g.card_polymeric_attention_icon);
        this.fMm = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_name);
        this.fMn = (TextView) view2.findViewById(d.g.card_polymeric_attention_post_num);
        this.dzr = (TextView) view2.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dzr.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.aSm);
        this.mTbPageContext.registerListener(this.aSl);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.f.item_person_header_attention_bg_selector);
            ak.c(this.fMh, d.C0126d.cp_cont_f, 1);
            ak.c(this.fMi, d.C0126d.cp_cont_f, 1);
            ak.c(this.fMj, d.C0126d.cp_cont_f, 1);
            ak.c(this.fMk, d.C0126d.cp_cont_f, 1);
            ak.c(this.fMm, d.C0126d.cp_cont_b, 1);
            ak.c(this.fMn, d.C0126d.cp_cont_c, 1);
            if (this.fMo != null) {
                lk(this.fMo.isAttention);
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
        this.fMo = bVar;
        this.isHost = bVar.isHost;
        this.fMh.setVisibility(bVar.ctM ? 0 : 4);
        this.fMi.setVisibility(bVar.ctM ? 0 : 4);
        this.fMh.setText(bVar.ctG);
        this.fMi.setText(bVar.ctF);
        TextView textView = this.fMj;
        if (bVar.isHost) {
            string = this.mContext.getString(d.k.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.k.she) : this.mContext.getString(d.k.he);
        }
        textView.setText(string);
        this.fMl.startLoad(bVar.avatar, 10, false);
        String str = bVar.fLp;
        if (w.hl(str) > 10) {
            str = w.k(str, 0, 10) + "...";
        }
        this.fMm.setText(String.format(this.mContext.getString(d.k.person_polymeric_bar_suffix), str));
        String A = an.A(bVar.fLq);
        this.fMn.setText(bVar.isHost ? String.format(this.mContext.getString(d.k.person_polymeric_attention_post_host), A, an.A(bVar.postNum)) : String.format(this.mContext.getString(d.k.person_polymeric_attention_post_guess), A));
        if (bVar.isAttention || bVar.isHost) {
            this.dzr.setVisibility(8);
            return;
        }
        this.dzr.setVisibility(0);
        lk(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.mRootView == view2) {
            if (!this.isHost) {
                TiebaStatic.log(new al("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.fMo.fLp, "")));
        } else if (this.dzr == view2) {
            TiebaStatic.log(new al("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                az.aJ(this.mContext);
            } else if (an.aQ(this.fMo.fLp) && !this.fMo.isAttention) {
                this.bnl.cb(this.fMo.fLp, String.valueOf(this.fMo.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lk(boolean z) {
        if (z) {
            this.dzr.setText(this.mContext.getString(d.k.relate_forum_is_followed));
            ak.h(this.dzr, d.C0126d.cp_cont_e);
            ak.i(this.dzr, d.C0126d.transparent);
            this.dzr.setClickable(false);
            return;
        }
        this.dzr.setText(this.mContext.getString(d.k.focus_text));
        ak.c(this.dzr, d.C0126d.cp_link_tip_a, 1);
        ak.i(this.dzr, d.f.polymeric_attention_btn_bg);
        this.dzr.setClickable(true);
    }
}
