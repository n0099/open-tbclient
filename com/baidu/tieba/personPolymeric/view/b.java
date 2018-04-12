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
    private CustomMessageListener aSk;
    private CustomMessageListener aSl;
    private LikeModel bmW;
    private TextView dyn;
    private TextView fLe;
    private TextView fLf;
    private TextView fLg;
    private TextView fLh;
    private BarImageView fLi;
    private TextView fLj;
    private TextView fLk;
    private com.baidu.tieba.personPolymeric.c.b fLl;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aSl = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fLl.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fLl.isAttention = true;
                                b.this.dyn.setVisibility(0);
                                b.this.lj(true);
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
        this.aSk = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fLl.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fLl.isAttention = false;
                            b.this.dyn.setVisibility(0);
                            b.this.lj(b.this.fLl.isAttention);
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
        this.bmW = likeModel;
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.fLe = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_day);
        this.fLf = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_month);
        this.fLg = (TextView) view2.findViewById(d.g.card_polymeric_attention_sex);
        this.fLh = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_des);
        this.fLi = (BarImageView) view2.findViewById(d.g.card_polymeric_attention_icon);
        this.fLj = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_name);
        this.fLk = (TextView) view2.findViewById(d.g.card_polymeric_attention_post_num);
        this.dyn = (TextView) view2.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dyn.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.aSl);
        this.mTbPageContext.registerListener(this.aSk);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.f.item_person_header_attention_bg_selector);
            ak.c(this.fLe, d.C0126d.cp_cont_f, 1);
            ak.c(this.fLf, d.C0126d.cp_cont_f, 1);
            ak.c(this.fLg, d.C0126d.cp_cont_f, 1);
            ak.c(this.fLh, d.C0126d.cp_cont_f, 1);
            ak.c(this.fLj, d.C0126d.cp_cont_b, 1);
            ak.c(this.fLk, d.C0126d.cp_cont_c, 1);
            if (this.fLl != null) {
                lj(this.fLl.isAttention);
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
        this.fLl = bVar;
        this.isHost = bVar.isHost;
        this.fLe.setVisibility(bVar.csF ? 0 : 4);
        this.fLf.setVisibility(bVar.csF ? 0 : 4);
        this.fLe.setText(bVar.csz);
        this.fLf.setText(bVar.csy);
        TextView textView = this.fLg;
        if (bVar.isHost) {
            string = this.mContext.getString(d.k.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.k.she) : this.mContext.getString(d.k.he);
        }
        textView.setText(string);
        this.fLi.startLoad(bVar.avatar, 10, false);
        String str = bVar.fKm;
        if (w.hk(str) > 10) {
            str = w.k(str, 0, 10) + "...";
        }
        this.fLj.setText(String.format(this.mContext.getString(d.k.person_polymeric_bar_suffix), str));
        String A = an.A(bVar.fKn);
        this.fLk.setText(bVar.isHost ? String.format(this.mContext.getString(d.k.person_polymeric_attention_post_host), A, an.A(bVar.postNum)) : String.format(this.mContext.getString(d.k.person_polymeric_attention_post_guess), A));
        if (bVar.isAttention || bVar.isHost) {
            this.dyn.setVisibility(8);
            return;
        }
        this.dyn.setVisibility(0);
        lj(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.mRootView == view2) {
            if (!this.isHost) {
                TiebaStatic.log(new al("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.fLl.fKm, "")));
        } else if (this.dyn == view2) {
            TiebaStatic.log(new al("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                az.aJ(this.mContext);
            } else if (an.aQ(this.fLl.fKm) && !this.fLl.isAttention) {
                this.bmW.cb(this.fLl.fKm, String.valueOf(this.fLl.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        if (z) {
            this.dyn.setText(this.mContext.getString(d.k.relate_forum_is_followed));
            ak.h(this.dyn, d.C0126d.cp_cont_e);
            ak.i(this.dyn, d.C0126d.transparent);
            this.dyn.setClickable(false);
            return;
        }
        this.dyn.setText(this.mContext.getString(d.k.focus_text));
        ak.c(this.dyn, d.C0126d.cp_link_tip_a, 1);
        ak.i(this.dyn, d.f.polymeric_attention_btn_bg);
        this.dyn.setClickable(true);
    }
}
