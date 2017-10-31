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
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel bRe;
    private CustomMessageListener bRl;
    private CustomMessageListener bRm;
    private TextView dbs;
    private v fmE;
    private TextView fpU;
    private TextView fpV;
    private TextView fpW;
    private TextView fpX;
    private BarImageView fpY;
    private TextView fpZ;
    private TextView fqa;
    private com.baidu.tieba.personPolymeric.c.b fqb;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bRm = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fqb.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fqb.isAttention = true;
                                b.this.dbs.setVisibility(0);
                                b.this.ki(true);
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
        this.bRl = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fqb.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fqb.isAttention = false;
                            b.this.dbs.setVisibility(0);
                            b.this.ki(b.this.fqb.isAttention);
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
        this.bRe = likeModel;
    }

    public void a(v vVar) {
        this.fmE = vVar;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.fpU = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.fpV = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.fpW = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.fpX = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.fpY = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.fpZ = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.fqa = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.dbs = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dbs.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bRm);
        this.mTbPageContext.registerListener(this.bRl);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.f.item_person_header_attention_bg_selector);
            aj.c(this.fpU, d.C0080d.cp_cont_f, 1);
            aj.c(this.fpV, d.C0080d.cp_cont_f, 1);
            aj.c(this.fpW, d.C0080d.cp_cont_f, 1);
            aj.c(this.fpX, d.C0080d.cp_cont_f, 1);
            aj.c(this.fpZ, d.C0080d.cp_cont_b, 1);
            aj.c(this.fqa, d.C0080d.cp_cont_c, 1);
            if (this.fqb != null) {
                ki(this.fqb.isAttention);
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
        this.fqb = bVar;
        this.isHost = bVar.isHost;
        this.fpU.setVisibility(bVar.bVH ? 0 : 4);
        this.fpV.setVisibility(bVar.bVH ? 0 : 4);
        this.fpU.setText(bVar.fpa);
        this.fpV.setText(bVar.bVA);
        TextView textView = this.fpW;
        if (bVar.isHost) {
            string = this.mContext.getString(d.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        }
        textView.setText(string);
        this.fpY.startLoad(bVar.avatar, 10, false);
        String str = bVar.fpb;
        if (w.gV(str) > 10) {
            str = w.e(str, 0, 10) + "...";
        }
        this.fpZ.setText(String.format(this.mContext.getString(d.j.person_polymeric_bar_suffix), str));
        String z = am.z(bVar.fpc);
        this.fqa.setText(bVar.isHost ? String.format(this.mContext.getString(d.j.person_polymeric_attention_post_host), z, am.z(bVar.postNum)) : String.format(this.mContext.getString(d.j.person_polymeric_attention_post_guess), z));
        if (bVar.isAttention || bVar.isHost) {
            this.dbs.setVisibility(8);
            return;
        }
        this.dbs.setVisibility(0);
        ki(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fqb.fpb, "")));
        } else if (this.dbs == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(this.mContext);
            } else if (am.aL(this.fqb.fpb) && !this.fqb.isAttention) {
                this.bRe.bX(this.fqb.fpb, String.valueOf(this.fqb.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki(boolean z) {
        if (z) {
            this.dbs.setText(this.mContext.getString(d.j.relate_forum_is_followed));
            aj.i(this.dbs, d.C0080d.cp_cont_e);
            aj.j(this.dbs, d.C0080d.transparent);
            this.dbs.setClickable(false);
            return;
        }
        this.dbs.setText(this.mContext.getString(d.j.focus_text));
        aj.c(this.dbs, d.C0080d.cp_link_tip_a, 1);
        aj.j(this.dbs, d.f.polymeric_attention_btn_bg);
        this.dbs.setClickable(true);
    }
}
