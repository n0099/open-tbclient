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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel bJK;
    private CustomMessageListener bJR;
    private CustomMessageListener bJS;
    private TextView cSN;
    private u feD;
    private TextView fhK;
    private TextView fhL;
    private TextView fhM;
    private TextView fhN;
    private BarImageView fhO;
    private TextView fhP;
    private TextView fhQ;
    private com.baidu.tieba.personPolymeric.c.b fhR;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bJS = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fhR.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fhR.isAttention = true;
                                b.this.cSN.setVisibility(0);
                                b.this.kp(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.l.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.l.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.bJR = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fhR.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fhR.isAttention = false;
                            b.this.cSN.setVisibility(0);
                            b.this.kp(b.this.fhR.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.l.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, d.l.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.bJK = likeModel;
    }

    public void a(u uVar) {
        this.feD = uVar;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.card_polymeric_attention_bar_rootview);
        this.fhK = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_day);
        this.fhL = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_month);
        this.fhM = (TextView) view.findViewById(d.h.card_polymeric_attention_sex);
        this.fhN = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_des);
        this.fhO = (BarImageView) view.findViewById(d.h.card_polymeric_attention_icon);
        this.fhP = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_name);
        this.fhQ = (TextView) view.findViewById(d.h.card_polymeric_attention_post_num);
        this.cSN = (TextView) view.findViewById(d.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cSN.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bJS);
        this.mTbPageContext.registerListener(this.bJR);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
            aj.c(this.fhK, d.e.cp_cont_f, 1);
            aj.c(this.fhL, d.e.cp_cont_f, 1);
            aj.c(this.fhM, d.e.cp_cont_f, 1);
            aj.c(this.fhN, d.e.cp_cont_f, 1);
            aj.c(this.fhP, d.e.cp_cont_b, 1);
            aj.c(this.fhQ, d.e.cp_cont_c, 1);
            if (this.fhR != null) {
                kp(this.fhR.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_polymeric_attention_bar_view;
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
        this.fhR = bVar;
        this.isHost = bVar.isHost;
        this.fhK.setVisibility(bVar.bOo ? 0 : 4);
        this.fhL.setVisibility(bVar.bOo ? 0 : 4);
        this.fhK.setText(bVar.fgR);
        this.fhL.setText(bVar.bOh);
        TextView textView = this.fhM;
        if (bVar.isHost) {
            string = this.mContext.getString(d.l.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.l.she) : this.mContext.getString(d.l.he);
        }
        textView.setText(string);
        this.fhO.c(bVar.avatar, 10, false);
        String str = bVar.fgS;
        if (com.baidu.tbadk.util.u.gP(str) > 10) {
            str = com.baidu.tbadk.util.u.e(str, 0, 10) + "...";
        }
        this.fhP.setText(String.format(this.mContext.getString(d.l.person_polymeric_bar_suffix), str));
        String y = am.y(bVar.fgT);
        this.fhQ.setText(bVar.isHost ? String.format(this.mContext.getString(d.l.person_polymeric_attention_post_host), y, am.y(bVar.postNum)) : String.format(this.mContext.getString(d.l.person_polymeric_attention_post_guess), y));
        if (bVar.isAttention || bVar.isHost) {
            this.cSN.setVisibility(8);
            return;
        }
        this.cSN.setVisibility(0);
        kp(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fhR.fgS, "")));
        } else if (this.cSN == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aT(this.mContext);
            } else if (am.aL(this.fhR.fgS) && !this.fhR.isAttention) {
                this.bJK.cb(this.fhR.fgS, String.valueOf(this.fhR.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(boolean z) {
        if (z) {
            this.cSN.setText(this.mContext.getString(d.l.relate_forum_is_followed));
            aj.i(this.cSN, d.e.cp_cont_e);
            aj.j(this.cSN, d.e.transparent);
            this.cSN.setClickable(false);
            return;
        }
        this.cSN.setText(this.mContext.getString(d.l.focus_text));
        aj.c(this.cSN, d.e.cp_link_tip_a, 1);
        aj.j(this.cSN, d.g.polymeric_attention_btn_bg);
        this.cSN.setClickable(true);
    }
}
