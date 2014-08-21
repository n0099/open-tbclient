package com.baidu.tieba.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ at a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(at atVar, int i) {
        super(i);
        this.a = atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        av avVar;
        BaseFragmentActivity baseFragmentActivity4;
        BaseFragmentActivity baseFragmentActivity5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            baseFragmentActivity = this.a.a;
            baseFragmentActivity.c(com.baidu.tieba.x.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                baseFragmentActivity5 = this.a.a;
                baseFragmentActivity5.a(checkPostResponseMessage.getErrorString());
                return;
            }
            baseFragmentActivity4 = this.a.a;
            baseFragmentActivity4.c(com.baidu.tieba.x.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        if (postState == 1) {
            avVar = this.a.b;
            avVar.a(new StringBuilder(String.valueOf(forumId)).toString());
        } else if (postState == 0) {
            baseFragmentActivity3 = this.a.a;
            baseFragmentActivity3.c(com.baidu.tieba.x.thread_delete_tip);
        } else if (postState == -1) {
            baseFragmentActivity2 = this.a.a;
            baseFragmentActivity2.c(com.baidu.tieba.x.thread_shield_tip);
        }
    }
}
