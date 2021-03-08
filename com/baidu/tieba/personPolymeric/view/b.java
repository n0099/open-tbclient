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
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener fTW;
    private CustomMessageListener fTX;
    private LikeModel foW;
    private boolean isHost;
    private TextView mGD;
    private TextView mGE;
    private TextView mGF;
    private TextView mGG;
    private BarImageView mGH;
    private TextView mGI;
    private TextView mGJ;
    private TextView mGK;
    private com.baidu.tieba.personPolymeric.c.b mGL;
    private View mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fTX = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.e) {
                        com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) data;
                        if (eVar.forumId == b.this.mGL.forumId) {
                            if (eVar.isSuccess) {
                                b.this.mGL.isAttention = true;
                                b.this.mGK.setVisibility(0);
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
        this.fTW = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.e) && ((com.baidu.tieba.tbadkCore.writeModel.e) data).forumId == b.this.mGL.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.e) data).isSuccess) {
                            b.this.mGL.isAttention = false;
                            b.this.mGK.setVisibility(0);
                            b.this.xa(b.this.mGL.isAttention);
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
        this.foW = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.mGD = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.mGE = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.mGF = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.mGG = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.mGH = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.mGI = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.mGJ = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.mGK = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.mGK.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fTX);
        this.mTbPageContext.registerListener(this.fTW);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ap.setViewTextColor(this.mGD, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mGE, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mGF, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mGG, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.mGI, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.mGJ, R.color.CAM_X0108, 1);
            if (this.mGL != null) {
                xa(this.mGL.isAttention);
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
        this.mGL = bVar;
        this.isHost = bVar.isHost;
        this.mGD.setVisibility(bVar.iDu ? 0 : 4);
        this.mGE.setVisibility(bVar.iDu ? 0 : 4);
        this.mGD.setText(bVar.iDo);
        this.mGE.setText(bVar.iDn);
        TextView textView = this.mGF;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.mGH.startLoad(bVar.avatar, 10, false);
        String str = bVar.kdY;
        if (ag.getTextLength(str) > 10) {
            str = ag.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.mGI.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = au.numFormatOverWanNa(bVar.mDQ);
        this.mGJ.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, au.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.mGK.setVisibility(8);
            return;
        }
        this.mGK.setVisibility(0);
        xa(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new ar("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.mGL.kdY, "")));
        } else if (this.mGK == view) {
            TiebaStatic.log(new ar("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bh.skipToLoginActivity(this.mContext);
            } else if (au.isForumName(this.mGL.kdY) && !this.mGL.isAttention) {
                this.foW.gy(this.mGL.kdY, String.valueOf(this.mGL.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(boolean z) {
        if (z) {
            this.mGK.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ap.setViewTextColor(this.mGK, R.color.CAM_X0110);
            ap.setBackgroundResource(this.mGK, R.color.transparent);
            this.mGK.setClickable(false);
            return;
        }
        this.mGK.setText(this.mContext.getString(R.string.focus_text));
        ap.setViewTextColor(this.mGK, R.color.CAM_X0302, 1);
        ap.setBackgroundResource(this.mGK, R.drawable.polymeric_attention_btn_bg);
        this.mGK.setClickable(true);
    }
}
