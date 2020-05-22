package com.baidu.tieba.personPolymeric.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private LikeModel dYI;
    private CustomMessageListener ezU;
    private CustomMessageListener ezV;
    private boolean isHost;
    private TextView kuT;
    private TextView kuU;
    private TextView kuV;
    private TextView kuW;
    private BarImageView kuX;
    private TextView kuY;
    private TextView kuZ;
    private TextView kva;
    private com.baidu.tieba.personPolymeric.c.b kvb;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ezV = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.kvb.forumId) {
                            if (aVar.isSuccess) {
                                b.this.kvb.isAttention = true;
                                b.this.kva.setVisibility(0);
                                b.this.ti(true);
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
        this.ezU = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.kvb.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.kvb.isAttention = false;
                            b.this.kva.setVisibility(0);
                            b.this.ti(b.this.kvb.isAttention);
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
        this.dYI = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.kuT = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.kuU = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.kuV = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.kuW = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.kuX = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.kuY = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.kuZ = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.kva = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.kva.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.ezV);
        this.mTbPageContext.registerListener(this.ezU);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.kuT, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kuU, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kuV, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kuW, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.kuY, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.kuZ, R.color.cp_cont_c, 1);
            if (this.kvb != null) {
                ti(this.kvb.isAttention);
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_polymeric_attention_bar_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.b bVar) {
        String string;
        if (bVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.kvb = bVar;
        this.isHost = bVar.isHost;
        this.kuT.setVisibility(bVar.gIi ? 0 : 4);
        this.kuU.setVisibility(bVar.gIi ? 0 : 4);
        this.kuT.setText(bVar.gIc);
        this.kuU.setText(bVar.gIb);
        TextView textView = this.kuV;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.kuX.startLoad(bVar.avatar, 10, false);
        String str = bVar.ksD;
        if (ae.getTextLength(str) > 10) {
            str = ae.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.kuY.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.ksE);
        this.kuZ.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.kva.setVisibility(8);
            return;
        }
        this.kva.setVisibility(0);
        ti(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.kvb.ksD, "")));
        } else if (this.kva == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.kvb.ksD) && !this.kvb.isAttention) {
                this.dYI.fq(this.kvb.ksD, String.valueOf(this.kvb.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(boolean z) {
        if (z) {
            this.kva.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.kva, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.kva, R.color.transparent);
            this.kva.setClickable(false);
            return;
        }
        this.kva.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.kva, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.kva, R.drawable.polymeric_attention_btn_bg);
        this.kva.setClickable(true);
    }
}
