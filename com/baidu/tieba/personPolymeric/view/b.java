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
    private CustomMessageListener bJF;
    private CustomMessageListener bJG;
    private LikeModel bJy;
    private TextView cSB;
    private u feo;
    private TextView fhA;
    private TextView fhB;
    private com.baidu.tieba.personPolymeric.c.b fhC;
    private TextView fhv;
    private TextView fhw;
    private TextView fhx;
    private TextView fhy;
    private BarImageView fhz;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bJG = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fhC.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fhC.isAttention = true;
                                b.this.cSB.setVisibility(0);
                                b.this.ko(true);
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
        this.bJF = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fhC.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fhC.isAttention = false;
                            b.this.cSB.setVisibility(0);
                            b.this.ko(b.this.fhC.isAttention);
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
        this.bJy = likeModel;
    }

    public void a(u uVar) {
        this.feo = uVar;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.card_polymeric_attention_bar_rootview);
        this.fhv = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_day);
        this.fhw = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_month);
        this.fhx = (TextView) view.findViewById(d.h.card_polymeric_attention_sex);
        this.fhy = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_des);
        this.fhz = (BarImageView) view.findViewById(d.h.card_polymeric_attention_icon);
        this.fhA = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_name);
        this.fhB = (TextView) view.findViewById(d.h.card_polymeric_attention_post_num);
        this.cSB = (TextView) view.findViewById(d.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cSB.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bJG);
        this.mTbPageContext.registerListener(this.bJF);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
            aj.c(this.fhv, d.e.cp_cont_f, 1);
            aj.c(this.fhw, d.e.cp_cont_f, 1);
            aj.c(this.fhx, d.e.cp_cont_f, 1);
            aj.c(this.fhy, d.e.cp_cont_f, 1);
            aj.c(this.fhA, d.e.cp_cont_b, 1);
            aj.c(this.fhB, d.e.cp_cont_c, 1);
            if (this.fhC != null) {
                ko(this.fhC.isAttention);
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
        this.fhC = bVar;
        this.isHost = bVar.isHost;
        this.fhv.setVisibility(bVar.bOc ? 0 : 4);
        this.fhw.setVisibility(bVar.bOc ? 0 : 4);
        this.fhv.setText(bVar.fgC);
        this.fhw.setText(bVar.bNV);
        TextView textView = this.fhx;
        if (bVar.isHost) {
            string = this.mContext.getString(d.l.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.l.she) : this.mContext.getString(d.l.he);
        }
        textView.setText(string);
        this.fhz.c(bVar.avatar, 10, false);
        String str = bVar.fgD;
        if (com.baidu.tbadk.util.u.gO(str) > 10) {
            str = com.baidu.tbadk.util.u.e(str, 0, 10) + "...";
        }
        this.fhA.setText(String.format(this.mContext.getString(d.l.person_polymeric_bar_suffix), str));
        String z = am.z(bVar.fgE);
        this.fhB.setText(bVar.isHost ? String.format(this.mContext.getString(d.l.person_polymeric_attention_post_host), z, am.z(bVar.postNum)) : String.format(this.mContext.getString(d.l.person_polymeric_attention_post_guess), z));
        if (bVar.isAttention || bVar.isHost) {
            this.cSB.setVisibility(8);
            return;
        }
        this.cSB.setVisibility(0);
        ko(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fhC.fgD, "")));
        } else if (this.cSB == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(this.mContext);
            } else if (am.aL(this.fhC.fgD) && !this.fhC.isAttention) {
                this.bJy.ca(this.fhC.fgD, String.valueOf(this.fhC.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(boolean z) {
        if (z) {
            this.cSB.setText(this.mContext.getString(d.l.relate_forum_is_followed));
            aj.i(this.cSB, d.e.cp_cont_e);
            aj.j(this.cSB, d.e.transparent);
            this.cSB.setClickable(false);
            return;
        }
        this.cSB.setText(this.mContext.getString(d.l.focus_text));
        aj.c(this.cSB, d.e.cp_link_tip_a, 1);
        aj.j(this.cSB, d.g.polymeric_attention_btn_bg);
        this.cSB.setClickable(true);
    }
}
