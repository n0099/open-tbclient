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
    final /* synthetic */ ChatMessageActivity ddi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ChatMessageActivity chatMessageActivity, int i) {
        super(i);
        this.ddi = chatMessageActivity;
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
        fragment = this.ddi.ddh;
        if (fragment == null) {
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof Fragment)) {
                this.ddi.ddh = (Fragment) data;
            }
            fragment2 = this.ddi.ddh;
            if (fragment2 != null) {
                this.ddi.mFragmentManager = this.ddi.getSupportFragmentManager();
                ChatMessageActivity chatMessageActivity = this.ddi;
                fragmentManager = this.ddi.mFragmentManager;
                chatMessageActivity.bGD = fragmentManager.beginTransaction();
                fragmentTransaction = this.ddi.bGD;
                int i = w.h.content;
                fragment3 = this.ddi.ddh;
                fragmentTransaction.add(i, fragment3);
                fragmentTransaction2 = this.ddi.bGD;
                fragmentTransaction2.commitAllowingStateLoss();
            }
            if (this.ddi.getIntent() != null) {
                int intExtra = this.ddi.getIntent().getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
                Intent intent = new Intent();
                intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra);
                intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent));
            }
        }
    }
}
