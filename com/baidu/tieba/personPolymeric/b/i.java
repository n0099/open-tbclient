package com.baidu.tieba.personPolymeric.b;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.d.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.d {
    private ViewGroup aaQ;
    private TbPageContext aby;
    private BaseFragmentActivity bIl;
    private CustomMessageListener bgO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.b.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(i.this.bIl.getUniqueId())) {
                    if (updateAttentionMessage.getData().BW) {
                        i.this.mIsLiked = updateAttentionMessage.getData().isAttention;
                        i.this.fjS.setAttentionData(updateAttentionMessage.getData().isAttention);
                        if (!i.this.mIsLiked) {
                            BdToast.a(i.this.aby.getPageActivity(), i.this.aby.getString(d.l.unlike_success)).tw();
                        } else {
                            BdToast.a(i.this.aby.getPageActivity(), i.this.aby.getString(d.l.attention_success)).tw();
                        }
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        i.this.bIl.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a ewy;
    private com.baidu.tieba.view.g feW;
    private t fjS;
    public com.baidu.tieba.f.c fjT;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public i(BaseFragmentActivity baseFragmentActivity, ViewGroup viewGroup, UserData userData) {
        this.bIl = baseFragmentActivity;
        this.aby = baseFragmentActivity.getPageContext();
        this.aaQ = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.ewy = new com.baidu.tbadk.coreExtra.c.a(this);
        anQ();
        initListener();
        if (this.aaQ != null && this.fjS != null) {
            this.fjT = new com.baidu.tieba.f.c(this.aby.getPageActivity(), this.fjS, null);
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.feW = gVar;
    }

    private void anQ() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.h.attention_btn) {
                        if (ax.aT(i.this.aby.getPageActivity())) {
                            TiebaStatic.log(new ak("c11592"));
                            if (i.this.mUserData != null) {
                                i.this.ewy.a(!i.this.mIsLiked, i.this.mUserData.getPortrait(), i.this.mUserData.getUserId(), i.this.isUseSingleGod(i.this.mUserData), i.this.aby.getUniqueId());
                            }
                        }
                    } else if (view.getId() == d.h.chat_btn) {
                        if (ax.aT(i.this.aby.getPageActivity())) {
                            i.this.aMA();
                        }
                    } else if (view.getId() == d.h.gift_btn && i.this.feW != null) {
                        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                        aVar.ceb = 12;
                        aVar.cec = new Bundle();
                        aVar.cec.putSerializable(UserData.TYPE_USER, i.this.mUserData);
                        i.this.feW.a(view, aVar);
                    }
                }
            }
        };
        this.fjS = new t(this.aby.getPageActivity(), this.mUserData, this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(this.aby.getPageActivity(), d.f.ds110));
        this.fjS.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.fjS.setOrientation(0);
        this.aaQ.addView(this.fjS);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (this.fjS != null) {
            this.fjS.l(z, z2, z3);
        }
    }

    public void onChangeSkinType(int i) {
        this.fjS.onChangeSkinType(i);
    }

    private void initListener() {
        this.aby.registerListener(this.bgO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMA() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new ak("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.aby.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUseSingleGod(UserData userData) {
        return (userData == null || userData.getGodUserData() == null || userData.getGodUserData().getType() != 2) ? false : true;
    }

    @Override // com.baidu.adp.base.d
    public void f(Object obj) {
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.fjS.a(this.mUserData, this.mIsLiked);
    }

    public void onDestroy() {
        if (this.fjT != null) {
            this.fjT.Hn();
        }
    }
}
