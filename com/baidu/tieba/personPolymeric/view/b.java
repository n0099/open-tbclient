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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener fUQ;
    private CustomMessageListener fUR;
    private LikeModel fpO;
    private boolean isHost;
    private View mRootView;
    private TextView mzM;
    private TextView mzN;
    private TextView mzO;
    private TextView mzP;
    private BarImageView mzQ;
    private TextView mzR;
    private TextView mzS;
    private TextView mzT;
    private com.baidu.tieba.personPolymeric.c.b mzU;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fUR = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.e) {
                        com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) data;
                        if (eVar.forumId == b.this.mzU.forumId) {
                            if (eVar.isSuccess) {
                                b.this.mzU.isAttention = true;
                                b.this.mzT.setVisibility(0);
                                b.this.wN(true);
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.attention_success);
                            } else if (StringUtils.isNull(eVar.errorMessage)) {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.attention_fail);
                            } else {
                                com.baidu.adp.lib.util.l.showToast(b.this.mContext, eVar.errorMessage);
                            }
                        }
                    }
                }
            }
        };
        this.fUQ = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.e) && ((com.baidu.tieba.tbadkCore.writeModel.e) data).forumId == b.this.mzU.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.e) data).isSuccess) {
                            b.this.mzU.isAttention = false;
                            b.this.mzT.setVisibility(0);
                            b.this.wN(b.this.mzU.isAttention);
                            com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.unlike_success);
                            return;
                        }
                        com.baidu.adp.lib.util.l.showToast(b.this.mContext, R.string.unlike_failure);
                    }
                }
            }
        };
        init(getView());
    }

    public void a(LikeModel likeModel) {
        this.fpO = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.mzM = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.mzN = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.mzO = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.mzP = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.mzQ = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.mzR = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.mzS = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.mzT = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.mzT.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fUR);
        this.mTbPageContext.registerListener(this.fUQ);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ao.setViewTextColor(this.mzM, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.mzN, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.mzO, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.mzP, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.mzR, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.mzS, R.color.CAM_X0108, 1);
            if (this.mzU != null) {
                wN(this.mzU.isAttention);
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
        this.mzU = bVar;
        this.isHost = bVar.isHost;
        this.mzM.setVisibility(bVar.iAu ? 0 : 4);
        this.mzN.setVisibility(bVar.iAu ? 0 : 4);
        this.mzM.setText(bVar.iAo);
        this.mzN.setText(bVar.iAn);
        TextView textView = this.mzO;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.mzQ.startLoad(bVar.avatar, 10, false);
        String str = bVar.jYM;
        if (ad.getTextLength(str) > 10) {
            str = ad.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.mzR.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = at.numFormatOverWanNa(bVar.mxa);
        this.mzS.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, at.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.mzT.setVisibility(8);
            return;
        }
        this.mzT.setVisibility(0);
        wN(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new aq("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.mzU.jYM, "")));
        } else if (this.mzT == view) {
            TiebaStatic.log(new aq("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(this.mContext);
            } else if (at.isForumName(this.mzU.jYM) && !this.mzU.isAttention) {
                this.fpO.gr(this.mzU.jYM, String.valueOf(this.mzU.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN(boolean z) {
        if (z) {
            this.mzT.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ao.setViewTextColor(this.mzT, R.color.CAM_X0110);
            ao.setBackgroundResource(this.mzT, R.color.transparent);
            this.mzT.setClickable(false);
            return;
        }
        this.mzT.setText(this.mContext.getString(R.string.focus_text));
        ao.setViewTextColor(this.mzT, R.color.CAM_X0302, 1);
        ao.setBackgroundResource(this.mzT, R.drawable.polymeric_attention_btn_bg);
        this.mzT.setClickable(true);
    }
}
