package com.baidu.tieba.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ am bnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(am amVar, int i) {
        super(i);
        this.bnU = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        ao aoVar;
        BaseFragmentActivity baseFragmentActivity4;
        BaseFragmentActivity baseFragmentActivity5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            baseFragmentActivity = this.bnU.mActivity;
            baseFragmentActivity.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                baseFragmentActivity5 = this.bnU.mActivity;
                baseFragmentActivity5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            baseFragmentActivity4 = this.bnU.mActivity;
            baseFragmentActivity4.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        if (postState == 1) {
            aoVar = this.bnU.bnT;
            aoVar.gP(new StringBuilder(String.valueOf(forumId)).toString());
        } else if (postState == 0) {
            baseFragmentActivity3 = this.bnU.mActivity;
            baseFragmentActivity3.showToast(com.baidu.tieba.y.thread_delete_tip);
        } else if (postState == -1) {
            baseFragmentActivity2 = this.bnU.mActivity;
            baseFragmentActivity2.showToast(com.baidu.tieba.y.thread_shield_tip);
        }
    }
}
