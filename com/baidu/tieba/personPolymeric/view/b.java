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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener cHZ;
    private CustomMessageListener cIa;
    private LikeModel cdr;
    private TextView foM;
    private TextView irI;
    private TextView irJ;
    private TextView irK;
    private TextView irL;
    private BarImageView irM;
    private TextView irN;
    private TextView irO;
    private com.baidu.tieba.personPolymeric.c.b irP;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cIa = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.irP.forumId) {
                            if (aVar.isSuccess) {
                                b.this.irP.isAttention = true;
                                b.this.foM.setVisibility(0);
                                b.this.pR(true);
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
        this.cHZ = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.irP.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.irP.isAttention = false;
                            b.this.foM.setVisibility(0);
                            b.this.pR(b.this.irP.isAttention);
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
        this.cdr = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.irI = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.irJ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.irK = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.irL = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.irM = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.irN = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.irO = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.foM = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.foM.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cIa);
        this.mTbPageContext.registerListener(this.cHZ);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.f(this.irI, R.color.cp_cont_f, 1);
            am.f(this.irJ, R.color.cp_cont_f, 1);
            am.f(this.irK, R.color.cp_cont_f, 1);
            am.f(this.irL, R.color.cp_cont_f, 1);
            am.f(this.irN, R.color.cp_cont_b, 1);
            am.f(this.irO, R.color.cp_cont_c, 1);
            if (this.irP != null) {
                pR(this.irP.isAttention);
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
        this.irP = bVar;
        this.isHost = bVar.isHost;
        this.irI.setVisibility(bVar.eGI ? 0 : 4);
        this.irJ.setVisibility(bVar.eGI ? 0 : 4);
        this.irI.setText(bVar.eGC);
        this.irJ.setText(bVar.eGB);
        TextView textView = this.irK;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.irM.startLoad(bVar.avatar, 10, false);
        String str = bVar.iqQ;
        if (ab.rn(str) > 10) {
            str = ab.p(str, 0, 10) + "...";
        }
        this.irN.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String aN = aq.aN(bVar.iqR);
        this.irO.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), aN, aq.aN(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), aN));
        if (bVar.isAttention || bVar.isHost) {
            this.foM.setVisibility(8);
            return;
        }
        this.foM.setVisibility(0);
        pR(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.irP.iqQ, "")));
        } else if (this.foM == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bd.cE(this.mContext);
            } else if (aq.bg(this.irP.iqQ) && !this.irP.isAttention) {
                this.cdr.el(this.irP.iqQ, String.valueOf(this.irP.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(boolean z) {
        if (z) {
            this.foM.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.j(this.foM, R.color.cp_cont_e);
            am.k(this.foM, R.color.transparent);
            this.foM.setClickable(false);
            return;
        }
        this.foM.setText(this.mContext.getString(R.string.focus_text));
        am.f(this.foM, R.color.cp_link_tip_a, 1);
        am.k(this.foM, R.drawable.polymeric_attention_btn_bg);
        this.foM.setClickable(true);
    }
}
