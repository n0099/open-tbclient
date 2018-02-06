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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener cVZ;
    private CustomMessageListener cWa;
    private LikeModel cdg;
    private TextView edD;
    private TextView gqA;
    private TextView gqB;
    private BarImageView gqC;
    private TextView gqD;
    private TextView gqE;
    private com.baidu.tieba.personPolymeric.c.b gqF;
    private TextView gqy;
    private TextView gqz;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cWa = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gqF.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gqF.isAttention = true;
                                b.this.edD.setVisibility(0);
                                b.this.lE(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.j.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.j.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.cVZ = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gqF.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gqF.isAttention = false;
                            b.this.edD.setVisibility(0);
                            b.this.lE(b.this.gqF.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.j.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.j.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.cdg = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.gqy = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.gqz = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.gqA = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.gqB = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.gqC = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.gqD = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.gqE = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.edD = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.edD.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cWa);
        this.mTbPageContext.registerListener(this.cVZ);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.item_person_header_attention_bg_selector);
            aj.e(this.gqy, d.C0140d.cp_cont_f, 1);
            aj.e(this.gqz, d.C0140d.cp_cont_f, 1);
            aj.e(this.gqA, d.C0140d.cp_cont_f, 1);
            aj.e(this.gqB, d.C0140d.cp_cont_f, 1);
            aj.e(this.gqD, d.C0140d.cp_cont_b, 1);
            aj.e(this.gqE, d.C0140d.cp_cont_c, 1);
            if (this.gqF != null) {
                lE(this.gqF.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_polymeric_attention_bar_view;
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
        this.gqF = bVar;
        this.isHost = bVar.isHost;
        this.gqy.setVisibility(bVar.daW ? 0 : 4);
        this.gqz.setVisibility(bVar.daW ? 0 : 4);
        this.gqy.setText(bVar.daP);
        this.gqz.setText(bVar.daO);
        TextView textView = this.gqA;
        if (bVar.isHost) {
            string = this.mContext.getString(d.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        }
        textView.setText(string);
        this.gqC.startLoad(bVar.avatar, 10, false);
        String str = bVar.gpF;
        if (w.hs(str) > 10) {
            str = w.j(str, 0, 10) + "...";
        }
        this.gqD.setText(String.format(this.mContext.getString(d.j.person_polymeric_bar_suffix), str));
        String I = am.I(bVar.gpG);
        this.gqE.setText(bVar.isHost ? String.format(this.mContext.getString(d.j.person_polymeric_attention_post_host), I, am.I(bVar.postNum)) : String.format(this.mContext.getString(d.j.person_polymeric_attention_post_guess), I));
        if (bVar.isAttention || bVar.isHost) {
            this.edD.setVisibility(8);
            return;
        }
        this.edD.setVisibility(0);
        lE(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gqF.gpF, "")));
        } else if (this.edD == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ay.aZ(this.mContext);
            } else if (am.aT(this.gqF.gpF) && !this.gqF.isAttention) {
                this.cdg.cc(this.gqF.gpF, String.valueOf(this.gqF.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(boolean z) {
        if (z) {
            this.edD.setText(this.mContext.getString(d.j.relate_forum_is_followed));
            aj.r(this.edD, d.C0140d.cp_cont_e);
            aj.s(this.edD, d.C0140d.transparent);
            this.edD.setClickable(false);
            return;
        }
        this.edD.setText(this.mContext.getString(d.j.focus_text));
        aj.e(this.edD, d.C0140d.cp_link_tip_a, 1);
        aj.s(this.edD, d.f.polymeric_attention_btn_bg);
        this.edD.setClickable(true);
    }
}
