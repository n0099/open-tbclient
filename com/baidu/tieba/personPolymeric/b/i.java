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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.d.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.d {
    private ViewGroup abM;
    private TbPageContext acr;
    private BaseFragmentActivity bFr;
    private CustomMessageListener bgM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.b.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(i.this.bFr.getUniqueId())) {
                    if (updateAttentionMessage.getData().Ec) {
                        i.this.mIsLiked = updateAttentionMessage.getData().isAttention;
                        i.this.fly.setAttentionData(updateAttentionMessage.getData().isAttention);
                        if (!i.this.mIsLiked) {
                            BdToast.a(i.this.acr.getPageActivity(), i.this.acr.getString(d.l.unlike_success)).tA();
                        } else {
                            BdToast.a(i.this.acr.getPageActivity(), i.this.acr.getString(d.l.attention_success)).tA();
                        }
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        i.this.bFr.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    };
    private com.baidu.tbadk.coreExtra.c.a epM;
    private com.baidu.tieba.view.g fgG;
    private t fly;
    public com.baidu.tieba.f.c flz;
    private boolean mIsLiked;
    private View.OnClickListener mOnClickListener;
    private UserData mUserData;

    public i(BaseFragmentActivity baseFragmentActivity, ViewGroup viewGroup, UserData userData) {
        this.bFr = baseFragmentActivity;
        this.acr = baseFragmentActivity.getPageContext();
        this.abM = viewGroup;
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.epM = new com.baidu.tbadk.coreExtra.c.a(this);
        ami();
        initListener();
        if (this.abM != null && this.fly != null) {
            this.flz = new com.baidu.tieba.f.c(this.acr.getPageActivity(), this.fly, null);
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fgG = gVar;
    }

    private void ami() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.h.attention_btn) {
                        if (aw.aO(i.this.acr.getPageActivity())) {
                            TiebaStatic.log(new aj("c11592"));
                            if (i.this.mUserData != null) {
                                i.this.epM.a(!i.this.mIsLiked, i.this.mUserData.getPortrait(), i.this.mUserData.getUserId(), i.this.isUseSingleGod(i.this.mUserData), i.this.acr.getUniqueId());
                            }
                        }
                    } else if (view.getId() == d.h.chat_btn) {
                        if (aw.aO(i.this.acr.getPageActivity())) {
                            i.this.aKM();
                        }
                    } else if (view.getId() == d.h.gift_btn && i.this.fgG != null) {
                        com.baidu.tieba.personPolymeric.event.a aVar = new com.baidu.tieba.personPolymeric.event.a();
                        aVar.cbk = 12;
                        aVar.cbl = new Bundle();
                        aVar.cbl.putSerializable(UserData.TYPE_USER, i.this.mUserData);
                        i.this.fgG.a(view, aVar);
                    }
                }
            }
        };
        this.fly = new t(this.acr.getPageActivity(), this.mUserData, this.mIsLiked, this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, k.g(this.acr.getPageActivity(), d.f.ds110));
        this.fly.setLayoutParams(layoutParams);
        layoutParams.addRule(12);
        this.fly.setOrientation(0);
        this.abM.addView(this.fly);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (this.fly != null) {
            this.fly.l(z, z2, z3);
        }
    }

    public void onChangeSkinType(int i) {
        this.fly.onChangeSkinType(i);
    }

    private void initListener() {
        this.acr.registerListener(this.bgM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKM() {
        if (this.mUserData != null && this.mUserData.getUserId() != null && this.mUserData.getUserName() != null && !this.mUserData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            try {
                TiebaStatic.log(new aj("c11593"));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.acr.getPageActivity(), Long.parseLong(this.mUserData.getUserId()), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), this.mUserData.getIsFriend())));
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
    public void g(Object obj) {
    }

    public void setData(UserData userData) {
        this.mUserData = userData;
        this.mIsLiked = userData.getHave_attention() == 1;
        this.fly.a(this.mUserData, this.mIsLiked);
    }

    public void onDestroy() {
        if (this.flz != null) {
            this.flz.Ho();
        }
    }
}
