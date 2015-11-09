package com.baidu.tieba.imMessageCenter.chatmessage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ ChatMessageActivity bJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ChatMessageActivity chatMessageActivity, int i) {
        super(i);
        this.bJJ = chatMessageActivity;
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
            this.bJJ.mFragmentManager = this.bJJ.getSupportFragmentManager();
            ChatMessageActivity chatMessageActivity = this.bJJ;
            fragmentManager = this.bJJ.mFragmentManager;
            chatMessageActivity.bJI = fragmentManager.beginTransaction();
            fragmentTransaction = this.bJJ.bJI;
            fragmentTransaction.add(i.f.content, fragment);
            fragmentTransaction2 = this.bJJ.bJI;
            fragmentTransaction2.commitAllowingStateLoss();
        }
    }
}
