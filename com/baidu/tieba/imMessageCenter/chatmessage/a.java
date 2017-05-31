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
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class a extends CustomMessageListener {
    final /* synthetic */ ChatMessageActivity diE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ChatMessageActivity chatMessageActivity, int i) {
        super(i);
        this.diE = chatMessageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Fragment fragment;
        Fragment fragment2;
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        Fragment fragment3;
        FragmentTransaction fragmentTransaction2;
        Object data;
        fragment = this.diE.diD;
        if (fragment == null) {
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof Fragment)) {
                this.diE.diD = (Fragment) data;
            }
            fragment2 = this.diE.diD;
            if (fragment2 != null) {
                this.diE.mFragmentManager = this.diE.getSupportFragmentManager();
                ChatMessageActivity chatMessageActivity = this.diE;
                fragmentManager = this.diE.mFragmentManager;
                chatMessageActivity.bMs = fragmentManager.beginTransaction();
                fragmentTransaction = this.diE.bMs;
                int i = w.h.content;
                fragment3 = this.diE.diD;
                fragmentTransaction.add(i, fragment3);
                fragmentTransaction2 = this.diE.bMs;
                fragmentTransaction2.commitAllowingStateLoss();
            }
            if (this.diE.getIntent() != null) {
                int intExtra = this.diE.getIntent().getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
                Intent intent = new Intent();
                intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra);
                intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent));
            }
        }
    }
}
