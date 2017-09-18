package com.baidu.tieba.personPolymeric.d;

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
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener bKE;
    private CustomMessageListener bKF;
    private LikeModel bKx;
    private boolean bwa;
    private TextView cRK;
    private u fjp;
    private TextView flY;
    private TextView flZ;
    private TextView fma;
    private TextView fmb;
    private BarImageView fmc;
    private TextView fmd;
    private TextView fme;
    private com.baidu.tieba.personPolymeric.c.b fmf;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bKF = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.bwa) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fmf.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fmf.isAttention = true;
                                b.this.cRK.setVisibility(0);
                                b.this.ky(true);
                                com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.k.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.bKE = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.bwa) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fmf.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fmf.isAttention = false;
                            b.this.cRK.setVisibility(0);
                            b.this.ky(b.this.fmf.isAttention);
                            com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.bKx = likeModel;
    }

    public void a(u uVar) {
        this.fjp = uVar;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.card_polymeric_attention_bar_rootview);
        this.flY = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_day);
        this.flZ = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_month);
        this.fma = (TextView) view.findViewById(d.h.card_polymeric_attention_sex);
        this.fmb = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_des);
        this.fmc = (BarImageView) view.findViewById(d.h.card_polymeric_attention_icon);
        this.fmd = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_name);
        this.fme = (TextView) view.findViewById(d.h.card_polymeric_attention_post_num);
        this.cRK = (TextView) view.findViewById(d.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cRK.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bKF);
        this.mTbPageContext.registerListener(this.bKE);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
            aj.c(this.flY, d.e.cp_cont_f, 1);
            aj.c(this.flZ, d.e.cp_cont_f, 1);
            aj.c(this.fma, d.e.cp_cont_f, 1);
            aj.c(this.fmb, d.e.cp_cont_f, 1);
            aj.c(this.fmd, d.e.cp_cont_b, 1);
            aj.c(this.fme, d.e.cp_cont_c, 1);
            if (this.fmf != null) {
                ky(this.fmf.isAttention);
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
        this.fmf = bVar;
        this.bwa = bVar.bwa;
        this.flY.setVisibility(bVar.bOJ ? 0 : 4);
        this.flZ.setVisibility(bVar.bOJ ? 0 : 4);
        this.flY.setText(bVar.fls);
        this.flZ.setText(bVar.bOC);
        TextView textView = this.fma;
        if (bVar.bwa) {
            string = this.mContext.getString(d.l.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.l.she) : this.mContext.getString(d.l.he);
        }
        textView.setText(string);
        this.fmc.c(bVar.avatar, 10, false);
        String str = bVar.deN;
        if (v.gS(str) > 10) {
            str = v.e(str, 0, 10) + "...";
        }
        this.fmd.setText(String.format(this.mContext.getString(d.l.person_polymeric_bar_suffix), str));
        String z = am.z(bVar.flt);
        this.fme.setText(bVar.bwa ? String.format(this.mContext.getString(d.l.person_polymeric_attention_post_host), z, am.z(bVar.postNum)) : String.format(this.mContext.getString(d.l.person_polymeric_attention_post_guess), z));
        if (bVar.isAttention || bVar.bwa) {
            this.cRK.setVisibility(8);
            return;
        }
        this.cRK.setVisibility(0);
        ky(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bwa) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fmf.deN, "")));
        } else if (this.cRK == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aT(this.mContext);
            } else if (am.aL(this.fmf.deN) && !this.fmf.isAttention) {
                this.bKx.cg(this.fmf.deN, String.valueOf(this.fmf.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky(boolean z) {
        if (z) {
            this.cRK.setText(this.mContext.getString(d.l.relate_forum_is_followed));
            aj.i(this.cRK, d.e.cp_cont_e);
            aj.j(this.cRK, d.e.transparent);
            this.cRK.setClickable(false);
            return;
        }
        this.cRK.setText(this.mContext.getString(d.l.focus_text));
        aj.c(this.cRK, d.e.cp_link_tip_a, 1);
        aj.j(this.cRK, d.g.polymeric_attention_btn_bg);
        this.cRK.setClickable(true);
    }
}
