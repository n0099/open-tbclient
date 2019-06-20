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
    private CustomMessageListener cGF;
    private CustomMessageListener cGG;
    private LikeModel cco;
    private TextView fjP;
    private TextView ilq;
    private TextView ilr;
    private TextView ils;
    private TextView ilt;
    private BarImageView ilu;
    private TextView ilv;
    private TextView ilw;
    private com.baidu.tieba.personPolymeric.c.b ilx;
    private boolean isHost;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cGG = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.ilx.forumId) {
                            if (aVar.isSuccess) {
                                b.this.ilx.isAttention = true;
                                b.this.fjP.setVisibility(0);
                                b.this.pD(true);
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
        this.cGF = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.ilx.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.ilx.isAttention = false;
                            b.this.fjP.setVisibility(0);
                            b.this.pD(b.this.ilx.isAttention);
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
        this.cco = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.ilq = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.ilr = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.ils = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.ilt = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.ilu = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.ilv = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.ilw = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.fjP = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.fjP.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cGG);
        this.mTbPageContext.registerListener(this.cGF);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            al.f(this.ilq, R.color.cp_cont_f, 1);
            al.f(this.ilr, R.color.cp_cont_f, 1);
            al.f(this.ils, R.color.cp_cont_f, 1);
            al.f(this.ilt, R.color.cp_cont_f, 1);
            al.f(this.ilv, R.color.cp_cont_b, 1);
            al.f(this.ilw, R.color.cp_cont_c, 1);
            if (this.ilx != null) {
                pD(this.ilx.isAttention);
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
        this.ilx = bVar;
        this.isHost = bVar.isHost;
        this.ilq.setVisibility(bVar.eBM ? 0 : 4);
        this.ilr.setVisibility(bVar.eBM ? 0 : 4);
        this.ilq.setText(bVar.eBG);
        this.ilr.setText(bVar.eBF);
        TextView textView = this.ils;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.ilu.startLoad(bVar.avatar, 10, false);
        String str = bVar.iky;
        if (ab.qV(str) > 10) {
            str = ab.p(str, 0, 10) + "...";
        }
        this.ilv.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String aM = ap.aM(bVar.ikz);
        this.ilw.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), aM, ap.aM(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), aM));
        if (bVar.isAttention || bVar.isHost) {
            this.fjP.setVisibility(8);
            return;
        }
        this.fjP.setVisibility(0);
        pD(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new am("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.ilx.iky, "")));
        } else if (this.fjP == view) {
            TiebaStatic.log(new am("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cD(this.mContext);
            } else if (ap.bf(this.ilx.iky) && !this.ilx.isAttention) {
                this.cco.ek(this.ilx.iky, String.valueOf(this.ilx.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(boolean z) {
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
