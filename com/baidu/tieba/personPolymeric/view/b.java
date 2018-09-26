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
    private LikeModel aCp;
    private CustomMessageListener beB;
    private CustomMessageListener beC;
    private TextView dnk;
    private TextView gjc;
    private TextView gjd;
    private TextView gje;
    private TextView gjf;
    private BarImageView gjg;
    private TextView gjh;
    private TextView gji;
    private com.baidu.tieba.personPolymeric.c.b gjj;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.beC = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gjj.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gjj.isAttention = true;
                                b.this.dnk.setVisibility(0);
                                b.this.lI(true);
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
        this.beB = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gjj.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gjj.isAttention = false;
                            b.this.dnk.setVisibility(0);
                            b.this.lI(b.this.gjj.isAttention);
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
        this.aCp = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_polymeric_attention_bar_rootview);
        this.gjc = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_day);
        this.gjd = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_month);
        this.gje = (TextView) view.findViewById(e.g.card_polymeric_attention_sex);
        this.gjf = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_des);
        this.gjg = (BarImageView) view.findViewById(e.g.card_polymeric_attention_icon);
        this.gjh = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_name);
        this.gji = (TextView) view.findViewById(e.g.card_polymeric_attention_post_num);
        this.dnk = (TextView) view.findViewById(e.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dnk.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.beC);
        this.mTbPageContext.registerListener(this.beB);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.item_person_header_attention_bg_selector);
            al.c(this.gjc, e.d.cp_cont_f, 1);
            al.c(this.gjd, e.d.cp_cont_f, 1);
            al.c(this.gje, e.d.cp_cont_f, 1);
            al.c(this.gjf, e.d.cp_cont_f, 1);
            al.c(this.gjh, e.d.cp_cont_b, 1);
            al.c(this.gji, e.d.cp_cont_c, 1);
            if (this.gjj != null) {
                lI(this.gjj.isAttention);
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
        this.gjj = bVar;
        this.isHost = bVar.isHost;
        this.gjc.setVisibility(bVar.cID ? 0 : 4);
        this.gjd.setVisibility(bVar.cID ? 0 : 4);
        this.gjc.setText(bVar.cIx);
        this.gjd.setText(bVar.cIw);
        TextView textView = this.gje;
        if (bVar.isHost) {
            string = this.mContext.getString(e.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(e.j.she) : this.mContext.getString(e.j.he);
        }
        textView.setText(string);
        this.gjg.startLoad(bVar.avatar, 10, false);
        String str = bVar.gik;
        if (y.m16if(str) > 10) {
            str = y.o(str, 0, 10) + "...";
        }
        this.gjh.setText(String.format(this.mContext.getString(e.j.person_polymeric_bar_suffix), str));
        String K = ao.K(bVar.gil);
        this.gji.setText(bVar.isHost ? String.format(this.mContext.getString(e.j.person_polymeric_attention_post_host), K, ao.K(bVar.postNum)) : String.format(this.mContext.getString(e.j.person_polymeric_attention_post_guess), K));
        if (bVar.isAttention || bVar.isHost) {
            this.dnk.setVisibility(8);
            return;
        }
        this.dnk.setVisibility(0);
        lI(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gjj.gik, "")));
        } else if (this.dnk == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bz(this.mContext);
            } else if (ao.bw(this.gjj.gik) && !this.gjj.isAttention) {
                this.aCp.cu(this.gjj.gik, String.valueOf(this.gjj.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (z) {
            this.dnk.setText(this.mContext.getString(e.j.relate_forum_is_followed));
            al.h(this.dnk, e.d.cp_cont_e);
            al.i(this.dnk, e.d.transparent);
            this.dnk.setClickable(false);
            return;
        }
        this.dnk.setText(this.mContext.getString(e.j.focus_text));
        al.c(this.dnk, e.d.cp_link_tip_a, 1);
        al.i(this.dnk, e.f.polymeric_attention_btn_bg);
        this.dnk.setClickable(true);
    }
}
