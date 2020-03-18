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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener dLt;
    private CustomMessageListener dLu;
    private LikeModel dku;
    private boolean isHost;
    private TextView jsI;
    private TextView jsJ;
    private TextView jsK;
    private TextView jsL;
    private BarImageView jsM;
    private TextView jsN;
    private TextView jsO;
    private TextView jsP;
    private com.baidu.tieba.personPolymeric.c.b jsQ;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dLu = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                        com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                        if (aVar.forumId == b.this.jsQ.forumId) {
                            if (aVar.isSuccess) {
                                b.this.jsQ.isAttention = true;
                                b.this.jsP.setVisibility(0);
                                b.this.rG(true);
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
        this.dLt = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.a) && ((com.baidu.tieba.tbadkCore.writeModel.a) data).forumId == b.this.jsQ.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.a) data).isSuccess) {
                            b.this.jsQ.isAttention = false;
                            b.this.jsP.setVisibility(0);
                            b.this.rG(b.this.jsQ.isAttention);
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
        this.dku = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.jsI = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.jsJ = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.jsK = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.jsL = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.jsM = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.jsN = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.jsO = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.jsP = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.jsP.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.dLu);
        this.mTbPageContext.registerListener(this.dLt);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            am.setViewTextColor(this.jsI, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jsJ, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jsK, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jsL, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.jsN, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.jsO, R.color.cp_cont_c, 1);
            if (this.jsQ != null) {
                rG(this.jsQ.isAttention);
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
        this.jsQ = bVar;
        this.isHost = bVar.isHost;
        this.jsI.setVisibility(bVar.fOK ? 0 : 4);
        this.jsJ.setVisibility(bVar.fOK ? 0 : 4);
        this.jsI.setText(bVar.fOE);
        this.jsJ.setText(bVar.fOD);
        TextView textView = this.jsK;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.jsM.startLoad(bVar.avatar, 10, false);
        String str = bVar.jqs;
        if (ad.getTextLength(str) > 10) {
            str = ad.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.jsN.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = aq.numFormatOverWanNa(bVar.jqt);
        this.jsO.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, aq.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.jsP.setVisibility(8);
            return;
        }
        this.jsP.setVisibility(0);
        rG(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new an("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.jsQ.jqs, "")));
        } else if (this.jsP == view) {
            TiebaStatic.log(new an("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bc.skipToLoginActivity(this.mContext);
            } else if (aq.isForumName(this.jsQ.jqs) && !this.jsQ.isAttention) {
                this.dku.eA(this.jsQ.jqs, String.valueOf(this.jsQ.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rG(boolean z) {
        if (z) {
            this.jsP.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            am.setViewTextColor(this.jsP, (int) R.color.cp_cont_e);
            am.setBackgroundResource(this.jsP, R.color.transparent);
            this.jsP.setClickable(false);
            return;
        }
        this.jsP.setText(this.mContext.getString(R.string.focus_text));
        am.setViewTextColor(this.jsP, R.color.cp_link_tip_a, 1);
        am.setBackgroundResource(this.jsP, R.drawable.polymeric_attention_btn_bg);
        this.jsP.setClickable(true);
    }
}
