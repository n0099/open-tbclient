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
    private CustomMessageListener cIg;
    private CustomMessageListener cIh;
    private LikeModel cdy;
    private TextView fpl;
    private boolean isHost;
    private TextView isL;
    private TextView isM;
    private TextView isN;
    private TextView isO;
    private BarImageView isP;
    private TextView isQ;
    private TextView isR;
    private com.baidu.tieba.personPolymeric.c.b isS;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cIh = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.isS.forumId) {
                            if (aVar.isSuccess) {
                                b.this.isS.isAttention = true;
                                b.this.fpl.setVisibility(0);
                                b.this.pS(true);
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
        this.cIg = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.isS.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.isS.isAttention = false;
                            b.this.fpl.setVisibility(0);
                            b.this.pS(b.this.isS.isAttention);
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
        this.cdy = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.isL = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.isM = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.isN = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.isO = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.isP = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.isQ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.isR = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.fpl = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.fpl.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cIh);
        this.mTbPageContext.registerListener(this.cIg);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.f(this.isL, R.color.cp_cont_f, 1);
            am.f(this.isM, R.color.cp_cont_f, 1);
            am.f(this.isN, R.color.cp_cont_f, 1);
            am.f(this.isO, R.color.cp_cont_f, 1);
            am.f(this.isQ, R.color.cp_cont_b, 1);
            am.f(this.isR, R.color.cp_cont_c, 1);
            if (this.isS != null) {
                pS(this.isS.isAttention);
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
        this.isS = bVar;
        this.isHost = bVar.isHost;
        this.isL.setVisibility(bVar.eGP ? 0 : 4);
        this.isM.setVisibility(bVar.eGP ? 0 : 4);
        this.isL.setText(bVar.eGJ);
        this.isM.setText(bVar.eGI);
        TextView textView = this.isN;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.isP.startLoad(bVar.avatar, 10, false);
        String str = bVar.irU;
        if (ab.rn(str) > 10) {
            str = ab.p(str, 0, 10) + "...";
        }
        this.isQ.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String aN = aq.aN(bVar.irV);
        this.isR.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), aN, aq.aN(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), aN));
        if (bVar.isAttention || bVar.isHost) {
            this.fpl.setVisibility(8);
            return;
        }
        this.fpl.setVisibility(0);
        pS(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.isS.irU, "")));
        } else if (this.fpl == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bd.cE(this.mContext);
            } else if (aq.bg(this.isS.irU) && !this.isS.isAttention) {
                this.cdy.el(this.isS.irU, String.valueOf(this.isS.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(boolean z) {
        if (z) {
            this.fpl.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.j(this.fpl, R.color.cp_cont_e);
            am.k(this.fpl, R.color.transparent);
            this.fpl.setClickable(false);
            return;
        }
        this.fpl.setText(this.mContext.getString(R.string.focus_text));
        am.f(this.fpl, R.color.cp_link_tip_a, 1);
        am.k(this.fpl, R.drawable.polymeric_attention_btn_bg);
        this.fpl.setClickable(true);
    }
}
