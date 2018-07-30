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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel azq;
    private CustomMessageListener bbi;
    private CustomMessageListener bbj;
    private TextView dhu;
    private TextView gbL;
    private TextView gbM;
    private TextView gbN;
    private TextView gbO;
    private BarImageView gbP;
    private TextView gbQ;
    private TextView gbR;
    private com.baidu.tieba.personPolymeric.c.b gbS;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bbj = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gbS.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gbS.isAttention = true;
                                b.this.dhu.setVisibility(0);
                                b.this.lm(true);
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
        this.bbi = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gbS.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gbS.isAttention = false;
                            b.this.dhu.setVisibility(0);
                            b.this.lm(b.this.gbS.isAttention);
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
        this.azq = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.gbL = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.gbM = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.gbN = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.gbO = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.gbP = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.gbQ = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.gbR = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.dhu = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dhu.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bbj);
        this.mTbPageContext.registerListener(this.bbi);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, d.f.item_person_header_attention_bg_selector);
            am.c(this.gbL, d.C0140d.cp_cont_f, 1);
            am.c(this.gbM, d.C0140d.cp_cont_f, 1);
            am.c(this.gbN, d.C0140d.cp_cont_f, 1);
            am.c(this.gbO, d.C0140d.cp_cont_f, 1);
            am.c(this.gbQ, d.C0140d.cp_cont_b, 1);
            am.c(this.gbR, d.C0140d.cp_cont_c, 1);
            if (this.gbS != null) {
                lm(this.gbS.isAttention);
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
        this.gbS = bVar;
        this.isHost = bVar.isHost;
        this.gbL.setVisibility(bVar.cCP ? 0 : 4);
        this.gbM.setVisibility(bVar.cCP ? 0 : 4);
        this.gbL.setText(bVar.cCJ);
        this.gbM.setText(bVar.cCI);
        TextView textView = this.gbN;
        if (bVar.isHost) {
            string = this.mContext.getString(d.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        }
        textView.setText(string);
        this.gbP.startLoad(bVar.avatar, 10, false);
        String str = bVar.gaS;
        if (w.hH(str) > 10) {
            str = w.k(str, 0, 10) + "...";
        }
        this.gbQ.setText(String.format(this.mContext.getString(d.j.person_polymeric_bar_suffix), str));
        String G = ap.G(bVar.gaT);
        this.gbR.setText(bVar.isHost ? String.format(this.mContext.getString(d.j.person_polymeric_attention_post_host), G, ap.G(bVar.postNum)) : String.format(this.mContext.getString(d.j.person_polymeric_attention_post_guess), G));
        if (bVar.isAttention || bVar.isHost) {
            this.dhu.setVisibility(8);
            return;
        }
        this.dhu.setVisibility(0);
        lm(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gbS.gaS, "")));
        } else if (this.dhu == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.aU(this.mContext);
            } else if (ap.bf(this.gbS.gaS) && !this.gbS.isAttention) {
                this.azq.ck(this.gbS.gaS, String.valueOf(this.gbS.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm(boolean z) {
        if (z) {
            this.dhu.setText(this.mContext.getString(d.j.relate_forum_is_followed));
            am.h(this.dhu, d.C0140d.cp_cont_e);
            am.i(this.dhu, d.C0140d.transparent);
            this.dhu.setClickable(false);
            return;
        }
        this.dhu.setText(this.mContext.getString(d.j.focus_text));
        am.c(this.dhu, d.C0140d.cp_link_tip_a, 1);
        am.i(this.dhu, d.f.polymeric_attention_btn_bg);
        this.dhu.setClickable(true);
    }
}
