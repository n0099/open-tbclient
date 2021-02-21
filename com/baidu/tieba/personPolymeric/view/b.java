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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener fSw;
    private CustomMessageListener fSx;
    private LikeModel fnw;
    private boolean isHost;
    private TextView mEA;
    private TextView mEB;
    private TextView mEC;
    private TextView mED;
    private BarImageView mEE;
    private TextView mEF;
    private TextView mEG;
    private TextView mEH;
    private com.baidu.tieba.personPolymeric.c.b mEI;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.e) {
                        com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) data;
                        if (eVar.forumId == b.this.mEI.forumId) {
                            if (eVar.isSuccess) {
                                b.this.mEI.isAttention = true;
                                b.this.mEH.setVisibility(0);
                                b.this.xa(true);
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
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.e) && ((com.baidu.tieba.tbadkCore.writeModel.e) data).forumId == b.this.mEI.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.e) data).isSuccess) {
                            b.this.mEI.isAttention = false;
                            b.this.mEH.setVisibility(0);
                            b.this.xa(b.this.mEI.isAttention);
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
        this.fnw = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.mEA = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.mEB = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.mEC = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.mED = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.mEE = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.mEF = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.mEG = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.mEH = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.mEH.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fSx);
        this.mTbPageContext.registerListener(this.fSw);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.mEA, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mEB, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mEC, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mED, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mEF, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mEG, R.color.CAM_X0108, 1);
            if (this.mEI != null) {
                xa(this.mEI.isAttention);
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
        this.mEI = bVar;
        this.isHost = bVar.isHost;
        this.mEA.setVisibility(bVar.iBL ? 0 : 4);
        this.mEB.setVisibility(bVar.iBL ? 0 : 4);
        this.mEA.setText(bVar.iBF);
        this.mEB.setText(bVar.iBE);
        TextView textView = this.mEC;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.mEE.startLoad(bVar.avatar, 10, false);
        String str = bVar.kbW;
        if (ag.getTextLength(str) > 10) {
            str = ag.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.mEF.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = au.numFormatOverWanNa(bVar.mBK);
        this.mEG.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, au.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.mEH.setVisibility(8);
            return;
        }
        this.mEH.setVisibility(0);
        xa(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ar("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.mEI.kbW, "")));
        } else if (this.mEH == view) {
            TiebaStatic.log(new ar("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(this.mContext);
            } else if (au.isForumName(this.mEI.kbW) && !this.mEI.isAttention) {
                this.fnw.gy(this.mEI.kbW, String.valueOf(this.mEI.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(boolean z) {
        if (z) {
            this.mEH.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.mEH, R.color.CAM_X0110);
            ap.setBackgroundResource(this.mEH, R.color.transparent);
            this.mEH.setClickable(false);
            return;
        }
        this.mEH.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.mEH, R.color.CAM_X0302, 1);
        ap.setBackgroundResource(this.mEH, R.drawable.polymeric_attention_btn_bg);
        this.mEH.setClickable(true);
    }
}
