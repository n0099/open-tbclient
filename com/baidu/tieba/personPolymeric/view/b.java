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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel aHL;
    private CustomMessageListener bjE;
    private CustomMessageListener bjF;
    private TextView dwF;
    private TextView gsc;
    private TextView gsd;
    private TextView gse;
    private TextView gsf;
    private BarImageView gsg;
    private TextView gsh;
    private TextView gsi;
    private com.baidu.tieba.personPolymeric.c.b gsj;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bjF = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.gsj.forumId) {
                            if (aVar.isSuccess) {
                                b.this.gsj.isAttention = true;
                                b.this.dwF.setVisibility(0);
                                b.this.mk(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, e.j.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, e.j.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.bjE = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.gsj.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.gsj.isAttention = false;
                            b.this.dwF.setVisibility(0);
                            b.this.mk(b.this.gsj.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, e.j.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, e.j.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.aHL = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.card_polymeric_attention_bar_rootview);
        this.gsc = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_day);
        this.gsd = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_month);
        this.gse = (TextView) view.findViewById(e.g.card_polymeric_attention_sex);
        this.gsf = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_des);
        this.gsg = (BarImageView) view.findViewById(e.g.card_polymeric_attention_icon);
        this.gsh = (TextView) view.findViewById(e.g.card_polymeric_attention_bar_name);
        this.gsi = (TextView) view.findViewById(e.g.card_polymeric_attention_post_num);
        this.dwF = (TextView) view.findViewById(e.g.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.dwF.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.bjF);
        this.mTbPageContext.registerListener(this.bjE);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.item_person_header_attention_bg_selector);
            al.c(this.gsc, e.d.cp_cont_f, 1);
            al.c(this.gsd, e.d.cp_cont_f, 1);
            al.c(this.gse, e.d.cp_cont_f, 1);
            al.c(this.gsf, e.d.cp_cont_f, 1);
            al.c(this.gsh, e.d.cp_cont_b, 1);
            al.c(this.gsi, e.d.cp_cont_c, 1);
            if (this.gsj != null) {
                mk(this.gsj.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_polymeric_attention_bar_view;
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
        this.gsj = bVar;
        this.isHost = bVar.isHost;
        this.gsc.setVisibility(bVar.cSc ? 0 : 4);
        this.gsd.setVisibility(bVar.cSc ? 0 : 4);
        this.gsc.setText(bVar.cRW);
        this.gsd.setText(bVar.cRV);
        TextView textView = this.gse;
        if (bVar.isHost) {
            string = this.mContext.getString(e.j.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(e.j.she) : this.mContext.getString(e.j.he);
        }
        textView.setText(string);
        this.gsg.startLoad(bVar.avatar, 10, false);
        String str = bVar.grk;
        if (y.it(str) > 10) {
            str = y.o(str, 0, 10) + "...";
        }
        this.gsh.setText(String.format(this.mContext.getString(e.j.person_polymeric_bar_suffix), str));
        String O = ao.O(bVar.grl);
        this.gsi.setText(bVar.isHost ? String.format(this.mContext.getString(e.j.person_polymeric_attention_post_host), O, ao.O(bVar.postNum)) : String.format(this.mContext.getString(e.j.person_polymeric_attention_post_guess), O));
        if (bVar.isAttention || bVar.isHost) {
            this.dwF.setVisibility(8);
            return;
        }
        this.dwF.setVisibility(0);
        mk(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.gsj.grk, "")));
        } else if (this.dwF == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                ba.bF(this.mContext);
            } else if (ao.bv(this.gsj.grk) && !this.gsj.isAttention) {
                this.aHL.cF(this.gsj.grk, String.valueOf(this.gsj.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mk(boolean z) {
        if (z) {
            this.dwF.setText(this.mContext.getString(e.j.relate_forum_is_followed));
            al.h(this.dwF, e.d.cp_cont_e);
            al.i(this.dwF, e.d.transparent);
            this.dwF.setClickable(false);
            return;
        }
        this.dwF.setText(this.mContext.getString(e.j.focus_text));
        al.c(this.dwF, e.d.cp_link_tip_a, 1);
        al.i(this.dwF, e.f.polymeric_attention_btn_bg);
        this.dwF.setClickable(true);
    }
}
