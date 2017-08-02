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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel bES;
    private CustomMessageListener bEZ;
    private CustomMessageListener bFa;
    private boolean bsZ;
    private TextView cHh;
    private u fgU;
    private TextView fjD;
    private TextView fjE;
    private TextView fjF;
    private TextView fjG;
    private BarImageView fjH;
    private TextView fjI;
    private TextView fjJ;
    private com.baidu.tieba.personPolymeric.c.b fjK;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bFa = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.bsZ) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fjK.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fjK.isAttention = true;
                                b.this.cHh.setVisibility(0);
                                b.this.ks(true);
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
        this.bEZ = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.d.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.bsZ) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fjK.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fjK.isAttention = false;
                            b.this.cHh.setVisibility(0);
                            b.this.ks(b.this.fjK.isAttention);
                            com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.k.showToast(b.this.mContext, d.l.unlike_failure);
                    }
                }
            }
        };
        S(getView());
    }

    public void a(LikeModel likeModel) {
        this.bES = likeModel;
    }

    public void a(u uVar) {
        this.fgU = uVar;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(d.h.card_polymeric_attention_bar_rootview);
        this.fjD = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_day);
        this.fjE = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_month);
        this.fjF = (TextView) view.findViewById(d.h.card_polymeric_attention_sex);
        this.fjG = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_des);
        this.fjH = (BarImageView) view.findViewById(d.h.card_polymeric_attention_icon);
        this.fjI = (TextView) view.findViewById(d.h.card_polymeric_attention_bar_name);
        this.fjJ = (TextView) view.findViewById(d.h.card_polymeric_attention_post_num);
        this.cHh = (TextView) view.findViewById(d.h.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.cHh.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bFa);
        this.mTbPageContext.registerListener(this.bEZ);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.g.item_person_header_attention_bg_selector);
            ai.c(this.fjD, d.e.cp_cont_f, 1);
            ai.c(this.fjE, d.e.cp_cont_f, 1);
            ai.c(this.fjF, d.e.cp_cont_f, 1);
            ai.c(this.fjG, d.e.cp_cont_f, 1);
            ai.c(this.fjI, d.e.cp_cont_b, 1);
            ai.c(this.fjJ, d.e.cp_cont_c, 1);
            if (this.fjK != null) {
                ks(this.fjK.isAttention);
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
        this.fjK = bVar;
        this.bsZ = bVar.bsZ;
        this.fjD.setVisibility(bVar.bJf ? 0 : 4);
        this.fjE.setVisibility(bVar.bJf ? 0 : 4);
        this.fjD.setText(bVar.fiX);
        this.fjE.setText(bVar.bIY);
        TextView textView = this.fjF;
        if (bVar.bsZ) {
            string = this.mContext.getString(d.l.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.l.person_identity_she) : this.mContext.getString(d.l.he);
        }
        textView.setText(string);
        this.fjH.c(bVar.avatar, 10, false);
        String str = bVar.cTS;
        if (v.gO(str) > 10) {
            str = v.d(str, 0, 10) + "...";
        }
        this.fjI.setText(String.format(this.mContext.getString(d.l.person_polymeric_bar_suffix), str));
        String A = al.A(bVar.fiY);
        this.fjJ.setText(bVar.bsZ ? String.format(this.mContext.getString(d.l.person_polymeric_attention_post_host), A, al.A(bVar.postNum)) : String.format(this.mContext.getString(d.l.person_polymeric_attention_post_guess), A));
        if (bVar.isAttention || bVar.bsZ) {
            this.cHh.setVisibility(8);
            return;
        }
        this.cHh.setVisibility(0);
        ks(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.bsZ) {
                TiebaStatic.log(new aj("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fjK.cTS, "")));
        } else if (this.cHh == view) {
            TiebaStatic.log(new aj("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aw.aM(this.mContext);
            } else if (al.aI(this.fjK.cTS) && !this.fjK.isAttention) {
                this.bES.ce(this.fjK.cTS, String.valueOf(this.fjK.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(boolean z) {
        if (z) {
            this.cHh.setText(this.mContext.getString(d.l.relate_forum_is_followed));
            ai.i(this.cHh, d.e.cp_cont_e);
            ai.j(this.cHh, d.e.transparent);
            this.cHh.setClickable(false);
            return;
        }
        this.cHh.setText(this.mContext.getString(d.l.focus_text));
        ai.c(this.cHh, d.e.cp_link_tip_a, 1);
        ai.j(this.cHh, d.g.polymeric_attention_btn_bg);
        this.cHh.setClickable(true);
    }
}
