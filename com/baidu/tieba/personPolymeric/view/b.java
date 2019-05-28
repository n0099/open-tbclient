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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener cGE;
    private CustomMessageListener cGF;
    private LikeModel ccn;
    private TextView fjP;
    private TextView ilp;
    private TextView ilq;
    private TextView ilr;
    private TextView ils;
    private BarImageView ilt;
    private TextView ilu;
    private TextView ilv;
    private com.baidu.tieba.personPolymeric.c.b ilw;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cGF = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.ilw.forumId) {
                            if (aVar.isSuccess) {
                                b.this.ilw.isAttention = true;
                                b.this.fjP.setVisibility(0);
                                b.this.pC(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, (int) R.string.attention_success);
                            } else if (StringUtils.isNull(aVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, (int) R.string.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, aVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.cGE = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.ilw.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.ilw.isAttention = false;
                            b.this.fjP.setVisibility(0);
                            b.this.pC(b.this.ilw.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, (int) R.string.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, (int) R.string.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.ccn = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.ilp = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.ilq = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.ilr = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.ils = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.ilt = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.ilu = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.ilv = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.fjP = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.fjP.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cGF);
        this.mTbPageContext.registerListener(this.cGE);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            al.f(this.ilp, R.color.cp_cont_f, 1);
            al.f(this.ilq, R.color.cp_cont_f, 1);
            al.f(this.ilr, R.color.cp_cont_f, 1);
            al.f(this.ils, R.color.cp_cont_f, 1);
            al.f(this.ilu, R.color.cp_cont_b, 1);
            al.f(this.ilv, R.color.cp_cont_c, 1);
            if (this.ilw != null) {
                pC(this.ilw.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_polymeric_attention_bar_view;
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
        this.ilw = bVar;
        this.isHost = bVar.isHost;
        this.ilp.setVisibility(bVar.eBM ? 0 : 4);
        this.ilq.setVisibility(bVar.eBM ? 0 : 4);
        this.ilp.setText(bVar.eBG);
        this.ilq.setText(bVar.eBF);
        TextView textView = this.ilr;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.ilt.startLoad(bVar.avatar, 10, false);
        String str = bVar.ikx;
        if (ab.qW(str) > 10) {
            str = ab.p(str, 0, 10) + "...";
        }
        this.ilu.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String aM = ap.aM(bVar.iky);
        this.ilv.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), aM, ap.aM(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), aM));
        if (bVar.isAttention || bVar.isHost) {
            this.fjP.setVisibility(8);
            return;
        }
        this.fjP.setVisibility(0);
        pC(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.ilw.ikx, "")));
        } else if (this.fjP == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(this.mContext);
            } else if (ap.bf(this.ilw.ikx) && !this.ilw.isAttention) {
                this.ccn.ek(this.ilw.ikx, String.valueOf(this.ilw.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC(boolean z) {
        if (z) {
            this.fjP.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            al.j(this.fjP, R.color.cp_cont_e);
            al.k(this.fjP, R.color.transparent);
            this.fjP.setClickable(false);
            return;
        }
        this.fjP.setText(this.mContext.getString(R.string.focus_text));
        al.f(this.fjP, R.color.cp_link_tip_a, 1);
        al.k(this.fjP, R.drawable.polymeric_attention_btn_bg);
        this.fjP.setClickable(true);
    }
}
