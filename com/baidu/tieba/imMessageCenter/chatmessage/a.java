package com.baidu.tieba.imMessageCenter.chatmessage;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ ChatMessageActivity ccO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ChatMessageActivity chatMessageActivity, int i) {
        super(i);
        this.ccO = chatMessageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Fragment fragment;
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        FragmentTransaction fragmentTransaction2;
        Object data;
        if (customResponsedMessage == null || (data = customResponsedMessage.getData()) == null || !(data instanceof Fragment)) {
            fragment = null;
        } else {
            fragment = (Fragment) data;
        }
        if (fragment != null) {
            this.ccO.mFragmentManager = this.ccO.getSupportFragmentManager();
            ChatMessageActivity chatMessageActivity = this.ccO;
            fragmentManager = this.ccO.mFragmentManager;
            chatMessageActivity.ccN = fragmentManager.beginTransaction();
            fragmentTransaction = this.ccO.ccN;
            fragmentTransaction.add(n.g.content, fragment);
            fragmentTransaction2 = this.ccO.ccN;
            fragmentTransaction2.commitAllowingStateLoss();
        }
        if (this.ccO.getIntent() != null) {
            int intExtra = this.ccO.getIntent().getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            Intent intent = new Intent();
            intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra);
            intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent));
        }
    }
}
