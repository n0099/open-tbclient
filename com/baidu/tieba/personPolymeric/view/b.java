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
    private TextView dyk;
    private TextView fLb;
    private TextView fLc;
    private TextView fLd;
    private TextView fLe;
    private BarImageView fLf;
    private TextView fLg;
    private TextView fLh;
    private com.baidu.tieba.personPolymeric.c.b fLi;
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
                        if (aVar.forumId == b.this.fLi.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fLi.isAttention = true;
                                b.this.dyk.setVisibility(0);
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
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fLi.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fLi.isAttention = false;
                            b.this.dyk.setVisibility(0);
                            b.this.lj(b.this.fLi.isAttention);
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
        this.fLb = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_day);
        this.fLc = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_month);
        this.fLd = (TextView) view2.findViewById(d.g.card_polymeric_attention_sex);
        this.fLe = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_des);
        this.fLf = (BarImageView) view2.findViewById(d.g.card_polymeric_attention_icon);
        this.fLg = (TextView) view2.findViewById(d.g.card_polymeric_attention_bar_name);
        this.fLh = (TextView) view2.findViewById(d.g.card_polymeric_attention_post_num);
        this.dyk = (TextView) view2.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dyk.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.aSl);
        this.mTbPageContext.registerListener(this.aSk);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.f.item_person_header_attention_bg_selector);
            ak.c(this.fLb, d.C0126d.cp_cont_f, 1);
            ak.c(this.fLc, d.C0126d.cp_cont_f, 1);
            ak.c(this.fLd, d.C0126d.cp_cont_f, 1);
            ak.c(this.fLe, d.C0126d.cp_cont_f, 1);
            ak.c(this.fLg, d.C0126d.cp_cont_b, 1);
            ak.c(this.fLh, d.C0126d.cp_cont_c, 1);
            if (this.fLi != null) {
                lj(this.fLi.isAttention);
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
        this.fLi = bVar;
        this.isHost = bVar.isHost;
        this.fLb.setVisibility(bVar.csC ? 0 : 4);
        this.fLc.setVisibility(bVar.csC ? 0 : 4);
        this.fLb.setText(bVar.csw);
        this.fLc.setText(bVar.csv);
        TextView textView = this.fLd;
        if (bVar.isHost) {
            string = this.mContext.getString(d.k.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.k.she) : this.mContext.getString(d.k.he);
        }
        textView.setText(string);
        this.fLf.startLoad(bVar.avatar, 10, false);
        String str = bVar.fKj;
        if (w.hk(str) > 10) {
            str = w.k(str, 0, 10) + "...";
        }
        this.fLg.setText(String.format(this.mContext.getString(d.k.person_polymeric_bar_suffix), str));
        String A = an.A(bVar.fKk);
        this.fLh.setText(bVar.isHost ? String.format(this.mContext.getString(d.k.person_polymeric_attention_post_host), A, an.A(bVar.postNum)) : String.format(this.mContext.getString(d.k.person_polymeric_attention_post_guess), A));
        if (bVar.isAttention || bVar.isHost) {
            this.dyk.setVisibility(8);
            return;
        }
        this.dyk.setVisibility(0);
        lj(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.mRootView == view2) {
            if (!this.isHost) {
                TiebaStatic.log(new al("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.fLi.fKj, "")));
        } else if (this.dyk == view2) {
            TiebaStatic.log(new al("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                az.aJ(this.mContext);
            } else if (an.aQ(this.fLi.fKj) && !this.fLi.isAttention) {
                this.bmW.cb(this.fLi.fKj, String.valueOf(this.fLi.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        if (z) {
            this.dyk.setText(this.mContext.getString(d.k.relate_forum_is_followed));
            ak.h(this.dyk, d.C0126d.cp_cont_e);
            ak.i(this.dyk, d.C0126d.transparent);
            this.dyk.setClickable(false);
            return;
        }
        this.dyk.setText(this.mContext.getString(d.k.focus_text));
        ak.c(this.dyk, d.C0126d.cp_link_tip_a, 1);
        ak.i(this.dyk, d.f.polymeric_attention_btn_bg);
        this.dyk.setClickable(true);
    }
}
