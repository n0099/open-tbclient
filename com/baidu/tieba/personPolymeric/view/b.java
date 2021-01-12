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
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.b> {
    private CustomMessageListener fQj;
    private CustomMessageListener fQk;
    private LikeModel fle;
    private boolean isHost;
    private View mRootView;
    private TextView mvh;
    private TextView mvi;
    private TextView mvj;
    private TextView mvk;
    private BarImageView mvl;
    private TextView mvm;
    private TextView mvn;
    private TextView mvo;
    private com.baidu.tieba.personPolymeric.c.b mvp;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof com.baidu.tieba.tbadkCore.writeModel.e) {
                        com.baidu.tieba.tbadkCore.writeModel.e eVar = (com.baidu.tieba.tbadkCore.writeModel.e) data;
                        if (eVar.forumId == b.this.mvp.forumId) {
                            if (eVar.isSuccess) {
                                b.this.mvp.isAttention = true;
                                b.this.mvo.setVisibility(0);
                                b.this.wJ(true);
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
        this.fQj = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.personPolymeric.view.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && !b.this.isHost) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof com.baidu.tieba.tbadkCore.writeModel.e) && ((com.baidu.tieba.tbadkCore.writeModel.e) data).forumId == b.this.mvp.forumId) {
                        if (((com.baidu.tieba.tbadkCore.writeModel.e) data).isSuccess) {
                            b.this.mvp.isAttention = false;
                            b.this.mvo.setVisibility(0);
                            b.this.wJ(b.this.mvp.isAttention);
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
        this.fle = likeModel;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.card_polymeric_attention_bar_rootview);
        this.mvh = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_day);
        this.mvi = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_month);
        this.mvj = (TextView) view.findViewById(R.id.card_polymeric_attention_sex);
        this.mvk = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_des);
        this.mvl = (BarImageView) view.findViewById(R.id.card_polymeric_attention_icon);
        this.mvm = (TextView) view.findViewById(R.id.card_polymeric_attention_bar_name);
        this.mvn = (TextView) view.findViewById(R.id.card_polymeric_attention_post_num);
        this.mvo = (TextView) view.findViewById(R.id.card_polymeric_attention_btn);
        this.mRootView.setOnClickListener(this);
        this.mvo.setOnClickListener(this);
        this.mTbPageContext.registerListener(this.fQk);
        this.mTbPageContext.registerListener(this.fQj);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.drawable.item_person_header_attention_bg_selector);
            ao.setViewTextColor(this.mvh, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.mvi, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.mvj, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.mvk, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.mvm, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.mvn, R.color.CAM_X0108, 1);
            if (this.mvp != null) {
                wJ(this.mvp.isAttention);
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
        this.mvp = bVar;
        this.isHost = bVar.isHost;
        this.mvh.setVisibility(bVar.ivN ? 0 : 4);
        this.mvi.setVisibility(bVar.ivN ? 0 : 4);
        this.mvh.setText(bVar.ivH);
        this.mvi.setText(bVar.ivG);
        TextView textView = this.mvj;
        if (bVar.isHost) {
            string = this.mContext.getString(R.string.me);
        } else {
            string = bVar.sex == 2 ? this.mContext.getString(R.string.she) : this.mContext.getString(R.string.he);
        }
        textView.setText(string);
        this.mvl.startLoad(bVar.avatar, 10, false);
        String str = bVar.jUh;
        if (ad.getTextLength(str) > 10) {
            str = ad.subString(str, 0, 10) + StringHelper.STRING_MORE;
        }
        this.mvm.setText(String.format(this.mContext.getString(R.string.person_polymeric_bar_suffix), str));
        String numFormatOverWanNa = at.numFormatOverWanNa(bVar.msv);
        this.mvn.setText(bVar.isHost ? String.format(this.mContext.getString(R.string.person_polymeric_attention_post_host), numFormatOverWanNa, at.numFormatOverWanNa(bVar.postNum)) : String.format(this.mContext.getString(R.string.person_polymeric_attention_post_guess), numFormatOverWanNa));
        if (bVar.isAttention || bVar.isHost) {
            this.mvo.setVisibility(8);
            return;
        }
        this.mvo.setVisibility(0);
        wJ(bVar.isAttention);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mRootView == view) {
            if (!this.isHost) {
                TiebaStatic.log(new aq("c11595"));
            }
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mContext).createNormalCfg(this.mvp.jUh, "")));
        } else if (this.mvo == view) {
            TiebaStatic.log(new aq("c11596"));
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                bg.skipToLoginActivity(this.mContext);
            } else if (at.isForumName(this.mvp.jUh) && !this.mvp.isAttention) {
                this.fle.gq(this.mvp.jUh, String.valueOf(this.mvp.forumId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ(boolean z) {
        if (z) {
            this.mvo.setText(this.mContext.getString(R.string.relate_forum_is_followed));
            ao.setViewTextColor(this.mvo, R.color.CAM_X0110);
            ao.setBackgroundResource(this.mvo, R.color.transparent);
            this.mvo.setClickable(false);
            return;
        }
        this.mvo.setText(this.mContext.getString(R.string.focus_text));
        ao.setViewTextColor(this.mvo, R.color.CAM_X0302, 1);
        ao.setBackgroundResource(this.mvo, R.drawable.polymeric_attention_btn_bg);
        this.mvo.setClickable(true);
    }
}
