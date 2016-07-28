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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ ChatMessageActivity dbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ChatMessageActivity chatMessageActivity, int i) {
        super(i);
        this.dbc = chatMessageActivity;
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
        fragment = this.dbc.dbb;
        if (fragment == null) {
            if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null && (data instanceof Fragment)) {
                this.dbc.dbb = (Fragment) data;
            }
            fragment2 = this.dbc.dbb;
            if (fragment2 != null) {
                this.dbc.mFragmentManager = this.dbc.getSupportFragmentManager();
                ChatMessageActivity chatMessageActivity = this.dbc;
                fragmentManager = this.dbc.mFragmentManager;
                chatMessageActivity.dba = fragmentManager.beginTransaction();
                fragmentTransaction = this.dbc.dba;
                int i = u.g.content;
                fragment3 = this.dbc.dbb;
                fragmentTransaction.add(i, fragment3);
                fragmentTransaction2 = this.dbc.dba;
                fragmentTransaction2.commitAllowingStateLoss();
            }
            if (this.dbc.getIntent() != null) {
                int intExtra = this.dbc.getIntent().getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
                Intent intent = new Intent();
                intent.putExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, intExtra);
                intent.putExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY, intent));
            }
        }
    }
}
