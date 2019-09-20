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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener cIX;
    private CustomMessageListener cIY;
    private LikeModel cer;
    private TextView fqZ;
    private boolean isHost;
    private TextView iuK;
    private TextView iuL;
    private TextView iuM;
    private TextView iuN;
    private BarImageView iuO;
    private TextView iuP;
    private TextView iuQ;
    private com.baidu.tieba.personPolymeric.c.b iuR;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cIY = new CustomMessageListener(2001437) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.iuR.forumId) {
                            if (aVar.isSuccess) {
                                b.this.iuR.isAttention = true;
                                b.this.fqZ.setVisibility(0);
                                b.this.pV(true);
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
        this.cIX = new CustomMessageListener(2001438) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.iuR.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.iuR.isAttention = false;
                            b.this.fqZ.setVisibility(0);
                            b.this.pV(b.this.iuR.isAttention);
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
        this.cer = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.iuK = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.iuL = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.iuM = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.iuN = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.iuO = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.iuP = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.iuQ = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.fqZ = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.fqZ.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.cIY);
        this.mTbPageContext.registerListener(this.cIX);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.f(this.iuK, R.color.cp_cont_f, 1);
            am.f(this.iuL, R.color.cp_cont_f, 1);
            am.f(this.iuM, R.color.cp_cont_f, 1);
            am.f(this.iuN, R.color.cp_cont_f, 1);
            am.f(this.iuP, R.color.cp_cont_b, 1);
            am.f(this.iuQ, R.color.cp_cont_c, 1);
            if (this.iuR != null) {
                pV(this.iuR.isAttention);
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
        this.iuR = bVar;
        this.isHost = bVar.isHost;
        this.iuK.setVisibility(bVar.eIy ? 0 : 4);
        this.iuL.setVisibility(bVar.eIy ? 0 : 4);
        this.iuK.setText(bVar.eIs);
        this.iuL.setText(bVar.eIr);
        TextView textView = this.iuM;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.iuO.startLoad(bVar.avatar, 10, false);
        String str = bVar.itT;
        if (aa.ry(str) > 10) {
            str = aa.p(str, 0, 10) + "...";
        }
        this.iuP.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String aN = aq.aN(bVar.itU);
        this.iuQ.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), aN, aq.aN(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), aN));
        if (bVar.isAttention || bVar.isHost) {
            this.fqZ.setVisibility(8);
            return;
        }
        this.fqZ.setVisibility(0);
        pV(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mContext).createNormalCfg(this.iuR.itT, "")));
        } else if (this.fqZ == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.cE(this.mContext);
            } else if (aq.bg(this.iuR.itT) && !this.iuR.isAttention) {
                this.cer.em(this.iuR.itT, String.valueOf(this.iuR.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(boolean z) {
        if (z) {
            this.fqZ.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.j(this.fqZ, R.color.cp_cont_e);
            am.k(this.fqZ, R.color.transparent);
            this.fqZ.setClickable(false);
            return;
        }
        this.fqZ.setText(this.mContext.getString(R.string.focus_text));
        am.f(this.fqZ, R.color.cp_link_tip_a, 1);
        am.k(this.fqZ, R.drawable.polymeric_attention_btn_bg);
        this.fqZ.setClickable(true);
    }
}
