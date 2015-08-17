package com.baidu.tieba.imMessageCenter.chatmessage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ ChatMessageActivity bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ChatMessageActivity chatMessageActivity, int i) {
        super(i);
        this.bFr = chatMessageActivity;
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
            this.bFr.mFragmentManager = this.bFr.getSupportFragmentManager();
            ChatMessageActivity chatMessageActivity = this.bFr;
            fragmentManager = this.bFr.mFragmentManager;
            chatMessageActivity.bFq = fragmentManager.beginTransaction();
            fragmentTransaction = this.bFr.bFq;
            fragmentTransaction.add(i.f.content, fragment);
            fragmentTransaction2 = this.bFr.bFq;
            fragmentTransaction2.commitAllowingStateLoss();
        }
    }
}
