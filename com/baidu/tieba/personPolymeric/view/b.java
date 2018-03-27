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
    private CustomMessageListener cVQ;
    private CustomMessageListener cVR;
    private LikeModel ccX;
    private TextView edH;
    private TextView gqD;
    private TextView gqE;
    private TextView gqF;
    private TextView gqG;
    private BarImageView gqH;
    private TextView gqI;
    private TextView gqJ;
    private com.baidu.tieba.personPolymeric.c.b gqK;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVR = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gqK.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gqK.isAttention = true;
                                b.this.edH.setVisibility(0);
                                b.this.lJ(true);
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
        this.cVQ = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gqK.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gqK.isAttention = false;
                            b.this.edH.setVisibility(0);
                            b.this.lJ(b.this.gqK.isAttention);
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
        this.ccX = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.gqD = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.gqE = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.gqF = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.gqG = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.gqH = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.gqI = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.gqJ = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.edH = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.edH.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cVR);
        this.mTbPageContext.registerListener(this.cVQ);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.item_person_header_attention_bg_selector);
            aj.e(this.gqD, d.C0141d.cp_cont_f, 1);
            aj.e(this.gqE, d.C0141d.cp_cont_f, 1);
            aj.e(this.gqF, d.C0141d.cp_cont_f, 1);
            aj.e(this.gqG, d.C0141d.cp_cont_f, 1);
            aj.e(this.gqI, d.C0141d.cp_cont_b, 1);
            aj.e(this.gqJ, d.C0141d.cp_cont_c, 1);
            if (this.gqK != null) {
                lJ(this.gqK.isAttention);
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
        this.gqK = bVar;
        this.isHost = bVar.isHost;
        this.gqD.setVisibility(bVar.daN ? 0 : 4);
        this.gqE.setVisibility(bVar.daN ? 0 : 4);
        this.gqD.setText(bVar.daG);
        this.gqE.setText(bVar.daF);
        TextView textView = this.gqF;
        if (bVar.isHost) {
            string = this.mContext.getString(d.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        }
        textView.setText(string);
        this.gqH.startLoad(bVar.avatar, 10, false);
        String str = bVar.gpK;
        if (w.hs(str) > 10) {
            str = w.j(str, 0, 10) + "...";
        }
        this.gqI.setText(String.format(this.mContext.getString(d.j.person_polymeric_bar_suffix), str));
        String I = am.I(bVar.gpL);
        this.gqJ.setText(bVar.isHost ? String.format(this.mContext.getString(d.j.person_polymeric_attention_post_host), I, am.I(bVar.postNum)) : String.format(this.mContext.getString(d.j.person_polymeric_attention_post_guess), I));
        if (bVar.isAttention || bVar.isHost) {
            this.edH.setVisibility(8);
            return;
        }
        this.edH.setVisibility(0);
        lJ(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gqK.gpK, "")));
        } else if (this.edH == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ay.aZ(this.mContext);
            } else if (am.aT(this.gqK.gpK) && !this.gqK.isAttention) {
                this.ccX.cc(this.gqK.gpK, String.valueOf(this.gqK.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(boolean z) {
        if (z) {
            this.edH.setText(this.mContext.getString(d.j.relate_forum_is_followed));
            aj.r(this.edH, d.C0141d.cp_cont_e);
            aj.s(this.edH, d.C0141d.transparent);
            this.edH.setClickable(false);
            return;
        }
        this.edH.setText(this.mContext.getString(d.j.focus_text));
        aj.e(this.edH, d.C0141d.cp_link_tip_a, 1);
        aj.s(this.edH, d.f.polymeric_attention_btn_bg);
        this.edH.setClickable(true);
    }
}
