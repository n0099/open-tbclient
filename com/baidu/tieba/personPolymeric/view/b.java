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
    private TextView fjO;
    private TextView ilm;
    private TextView iln;
    private TextView ilo;
    private TextView ilp;
    private BarImageView ilq;
    private TextView ilr;
    private TextView ils;
    private com.baidu.tieba.personPolymeric.c.b ilt;
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
                        if (aVar.forumId == b.this.ilt.forumId) {
                            if (aVar.isSuccess) {
                                b.this.ilt.isAttention = true;
                                b.this.fjO.setVisibility(0);
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
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.ilt.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.ilt.isAttention = false;
                            b.this.fjO.setVisibility(0);
                            b.this.pC(b.this.ilt.isAttention);
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
        this.ilm = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.iln = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.ilo = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.ilp = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.ilq = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.ilr = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.ils = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.fjO = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.fjO.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cGF);
        this.mTbPageContext.registerListener(this.cGE);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            al.f(this.ilm, R.color.cp_cont_f, 1);
            al.f(this.iln, R.color.cp_cont_f, 1);
            al.f(this.ilo, R.color.cp_cont_f, 1);
            al.f(this.ilp, R.color.cp_cont_f, 1);
            al.f(this.ilr, R.color.cp_cont_b, 1);
            al.f(this.ils, R.color.cp_cont_c, 1);
            if (this.ilt != null) {
                pC(this.ilt.isAttention);
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
        this.ilt = bVar;
        this.isHost = bVar.isHost;
        this.ilm.setVisibility(bVar.eBL ? 0 : 4);
        this.iln.setVisibility(bVar.eBL ? 0 : 4);
        this.ilm.setText(bVar.eBF);
        this.iln.setText(bVar.eBE);
        TextView textView = this.ilo;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.ilq.startLoad(bVar.avatar, 10, false);
        String str = bVar.iku;
        if (ab.qW(str) > 10) {
            str = ab.p(str, 0, 10) + "...";
        }
        this.ilr.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String aM = ap.aM(bVar.ikv);
        this.ils.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), aM, ap.aM(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), aM));
        if (bVar.isAttention || bVar.isHost) {
            this.fjO.setVisibility(8);
            return;
        }
        this.fjO.setVisibility(0);
        pC(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.ilt.iku, "")));
        } else if (this.fjO == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(this.mContext);
            } else if (ap.bf(this.ilt.iku) && !this.ilt.isAttention) {
                this.ccn.ek(this.ilt.iku, String.valueOf(this.ilt.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC(boolean z) {
        if (z) {
            this.fjO.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            al.j(this.fjO, R.color.cp_cont_e);
            al.k(this.fjO, R.color.transparent);
            this.fjO.setClickable(false);
            return;
        }
        this.fjO.setText(this.mContext.getString(R.string.focus_text));
        al.f(this.fjO, R.color.cp_link_tip_a, 1);
        al.k(this.fjO, R.drawable.polymeric_attention_btn_bg);
        this.fjO.setClickable(true);
    }
}
