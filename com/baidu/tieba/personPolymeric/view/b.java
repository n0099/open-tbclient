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
    private LikeModel bRr;
    private CustomMessageListener bRy;
    private CustomMessageListener bRz;
    private TextView dbM;
    private v fnb;
    private TextView fqr;
    private TextView fqs;
    private TextView fqt;
    private TextView fqu;
    private BarImageView fqv;
    private TextView fqw;
    private TextView fqx;
    private com.baidu.tieba.personPolymeric.c.b fqy;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bRz = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.fqy.forumId) {
                            if (aVar.isSuccess) {
                                b.this.fqy.isAttention = true;
                                b.this.dbM.setVisibility(0);
                                b.this.ko(true);
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
        this.bRy = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.fqy.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.fqy.isAttention = false;
                            b.this.dbM.setVisibility(0);
                            b.this.ko(b.this.fqy.isAttention);
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
        this.bRr = likeModel;
    }

    public void a(v vVar) {
        this.fnb = vVar;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.card_polymeric_attention_bar_rootview);
        this.fqr = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_day);
        this.fqs = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_month);
        this.fqt = (TextView) view.findViewById(d.g.card_polymeric_attention_sex);
        this.fqu = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_des);
        this.fqv = (BarImageView) view.findViewById(d.g.card_polymeric_attention_icon);
        this.fqw = (TextView) view.findViewById(d.g.card_polymeric_attention_bar_name);
        this.fqx = (TextView) view.findViewById(d.g.card_polymeric_attention_post_num);
        this.dbM = (TextView) view.findViewById(d.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dbM.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bRz);
        this.mTbPageContext.registerListener(this.bRy);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.f.item_person_header_attention_bg_selector);
            aj.c(this.fqr, d.C0080d.cp_cont_f, 1);
            aj.c(this.fqs, d.C0080d.cp_cont_f, 1);
            aj.c(this.fqt, d.C0080d.cp_cont_f, 1);
            aj.c(this.fqu, d.C0080d.cp_cont_f, 1);
            aj.c(this.fqw, d.C0080d.cp_cont_b, 1);
            aj.c(this.fqx, d.C0080d.cp_cont_c, 1);
            if (this.fqy != null) {
                ko(this.fqy.isAttention);
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
        this.fqy = bVar;
        this.isHost = bVar.isHost;
        this.fqr.setVisibility(bVar.bVU ? 0 : 4);
        this.fqs.setVisibility(bVar.bVU ? 0 : 4);
        this.fqr.setText(bVar.fpy);
        this.fqs.setText(bVar.bVN);
        TextView textView = this.fqt;
        if (bVar.isHost) {
            string = this.mContext.getString(d.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(d.j.she) : this.mContext.getString(d.j.he);
        }
        textView.setText(string);
        this.fqv.startLoad(bVar.avatar, 10, false);
        String str = bVar.fpz;
        if (w.gW(str) > 10) {
            str = w.e(str, 0, 10) + "...";
        }
        this.fqw.setText(String.format(this.mContext.getString(d.j.person_polymeric_bar_suffix), str));
        String z = am.z(bVar.fpA);
        this.fqx.setText(bVar.isHost ? String.format(this.mContext.getString(d.j.person_polymeric_attention_post_host), z, am.z(bVar.postNum)) : String.format(this.mContext.getString(d.j.person_polymeric_attention_post_guess), z));
        if (bVar.isAttention || bVar.isHost) {
            this.dbM.setVisibility(8);
            return;
        }
        this.dbM.setVisibility(0);
        ko(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ak("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.fqy.fpz, "")));
        } else if (this.dbM == view) {
            TiebaStatic.log(new ak("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ax.aS(this.mContext);
            } else if (am.aL(this.fqy.fpz) && !this.fqy.isAttention) {
                this.bRr.cb(this.fqy.fpz, String.valueOf(this.fqy.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(boolean z) {
        if (z) {
            this.dbM.setText(this.mContext.getString(d.j.relate_forum_is_followed));
            aj.i(this.dbM, d.C0080d.cp_cont_e);
            aj.j(this.dbM, d.C0080d.transparent);
            this.dbM.setClickable(false);
            return;
        }
        this.dbM.setText(this.mContext.getString(d.j.focus_text));
        aj.c(this.dbM, d.C0080d.cp_link_tip_a, 1);
        aj.j(this.dbM, d.f.polymeric_attention_btn_bg);
        this.dbM.setClickable(true);
    }
}
