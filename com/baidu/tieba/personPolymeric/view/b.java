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
    private CustomMessageListener cVN;
    private CustomMessageListener cVO;
    private LikeModel ccU;
    private TextView edr;
    private TextView gqn;
    private TextView gqo;
    private TextView gqp;
    private TextView gqq;
    private BarImageView gqr;
    private TextView gqs;
    private TextView gqt;
    private com.baidu.tieba.personPolymeric.c.b gqu;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVO = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gqu.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gqu.isAttention = true;
                                b.this.edr.setVisibility(0);
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
        this.cVN = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gqu.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gqu.isAttention = false;
                            b.this.edr.setVisibility(0);
                            b.this.lE(b.this.gqu.isAttention);
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
        this.ccU = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.gqn = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.gqo = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.gqp = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.gqq = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.gqr = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.gqs = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.gqt = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.edr = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.edr.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cVO);
        this.mTbPageContext.registerListener(this.cVN);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.item_person_header_attention_bg_selector);
            aj.e(this.gqn, d.C0141d.cp_cont_f, 1);
            aj.e(this.gqo, d.C0141d.cp_cont_f, 1);
            aj.e(this.gqp, d.C0141d.cp_cont_f, 1);
            aj.e(this.gqq, d.C0141d.cp_cont_f, 1);
            aj.e(this.gqs, d.C0141d.cp_cont_b, 1);
            aj.e(this.gqt, d.C0141d.cp_cont_c, 1);
            if (this.gqu != null) {
                lE(this.gqu.isAttention);
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
        this.gqu = bVar;
        this.isHost = bVar.isHost;
        this.gqn.setVisibility(bVar.daK ? 0 : 4);
        this.gqo.setVisibility(bVar.daK ? 0 : 4);
        this.gqn.setText(bVar.daD);
        this.gqo.setText(bVar.daC);
        TextView textView = this.gqp;
        if (bVar.isHost) {
            string = this.mContext.getString(d.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        }
        textView.setText(string);
        this.gqr.startLoad(bVar.avatar, 10, false);
        String str = bVar.gpu;
        if (w.hs(str) > 10) {
            str = w.j(str, 0, 10) + "...";
        }
        this.gqs.setText(String.format(this.mContext.getString(d.j.person_polymeric_bar_suffix), str));
        String I = am.I(bVar.gpv);
        this.gqt.setText(bVar.isHost ? String.format(this.mContext.getString(d.j.person_polymeric_attention_post_host), I, am.I(bVar.postNum)) : String.format(this.mContext.getString(d.j.person_polymeric_attention_post_guess), I));
        if (bVar.isAttention || bVar.isHost) {
            this.edr.setVisibility(8);
            return;
        }
        this.edr.setVisibility(0);
        lE(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gqu.gpu, "")));
        } else if (this.edr == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ay.aZ(this.mContext);
            } else if (am.aT(this.gqu.gpu) && !this.gqu.isAttention) {
                this.ccU.cc(this.gqu.gpu, String.valueOf(this.gqu.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(boolean z) {
        if (z) {
            this.edr.setText(this.mContext.getString(d.j.relate_forum_is_followed));
            aj.r(this.edr, d.C0141d.cp_cont_e);
            aj.s(this.edr, d.C0141d.transparent);
            this.edr.setClickable(false);
            return;
        }
        this.edr.setText(this.mContext.getString(d.j.focus_text));
        aj.e(this.edr, d.C0141d.cp_link_tip_a, 1);
        aj.s(this.edr, d.f.polymeric_attention_btn_bg);
        this.edr.setClickable(true);
    }
}
