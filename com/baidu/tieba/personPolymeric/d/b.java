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
    private LikeModel bJG;
    private CustomMessageListener bJN;
    private CustomMessageListener bJO;
    private boolean bvm;
    private TextView cQQ;
    private u fiv;
    private TextView flf;
    private TextView flg;
    private TextView flh;
    private TextView fli;
    private BarImageView flj;
    private TextView flk;
    private TextView fll;
    private com.baidu.tieba.personPolymeric.c.b flm;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bJO = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.bvm) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.flm.forumId) {
                            if (aVar.isSuccess) {
                                b.this.flm.isAttention = true;
                                b.this.cQQ.setVisibility(0);
                                b.this.kx(true);
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
        this.bJN = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.bvm) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.flm.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.flm.isAttention = false;
                            b.this.cQQ.setVisibility(0);
                            b.this.kx(b.this.flm.isAttention);
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
        this.bJG = likeModel;
    }

    public void a(u uVar) {
        this.fiv = uVar;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.card_polymeric_attention_bar_rootview);
        this.flf = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_day);
        this.flg = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_month);
        this.flh = (TextView) view.findViewById(d.h.card_polymeric_attention_sex);
        this.fli = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_des);
        this.flj = (BarImageView) view.findViewById(d.h.card_polymeric_attention_icon);
        this.flk = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_name);
        this.fll = (TextView) view.findViewById(d.h.card_polymeric_attention_post_num);
        this.cQQ = (TextView) view.findViewById(d.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cQQ.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bJO);
        this.mTbPageContext.registerListener(this.bJN);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
            aj.c(this.flf, d.e.cp_cont_f, 1);
            aj.c(this.flg, d.e.cp_cont_f, 1);
            aj.c(this.flh, d.e.cp_cont_f, 1);
            aj.c(this.fli, d.e.cp_cont_f, 1);
            aj.c(this.flk, d.e.cp_cont_b, 1);
            aj.c(this.fll, d.e.cp_cont_c, 1);
            if (this.flm != null) {
                kx(this.flm.isAttention);
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
        this.flm = bVar;
        this.bvm = bVar.bvm;
        this.flf.setVisibility(bVar.bNS ? 0 : 4);
        this.flg.setVisibility(bVar.bNS ? 0 : 4);
        this.flf.setText(bVar.fkz);
        this.flg.setText(bVar.bNL);
        TextView textView = this.flh;
        if (bVar.bvm) {
            string = this.mContext.getString(d.l.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.l.she) : this.mContext.getString(d.l.he);
        }
        textView.setText(string);
        this.flj.c(bVar.avatar, 10, false);
        String str = bVar.ddR;
        if (v.gS(str) > 10) {
            str = v.e(str, 0, 10) + "...";
        }
        this.flk.setText(String.format(this.mContext.getString(d.l.person_polymeric_bar_suffix), str));
        String z = am.z(bVar.fkA);
        this.fll.setText(bVar.bvm ? String.format(this.mContext.getString(d.l.person_polymeric_attention_post_host), z, am.z(bVar.postNum)) : String.format(this.mContext.getString(d.l.person_polymeric_attention_post_guess), z));
        if (bVar.isAttention || bVar.bvm) {
            this.cQQ.setVisibility(8);
            return;
        }
        this.cQQ.setVisibility(0);
        kx(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bvm) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.flm.ddR, "")));
        } else if (this.cQQ == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(this.mContext);
            } else if (am.aL(this.flm.ddR) && !this.flm.isAttention) {
                this.bJG.cg(this.flm.ddR, String.valueOf(this.flm.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx(boolean z) {
        if (z) {
            this.cQQ.setText(this.mContext.getString(d.l.relate_forum_is_followed));
            aj.i(this.cQQ, d.e.cp_cont_e);
            aj.j(this.cQQ, d.e.transparent);
            this.cQQ.setClickable(false);
            return;
        }
        this.cQQ.setText(this.mContext.getString(d.l.focus_text));
        aj.c(this.cQQ, d.e.cp_link_tip_a, 1);
        aj.j(this.cQQ, d.g.polymeric_attention_btn_bg);
        this.cQQ.setClickable(true);
    }
}
