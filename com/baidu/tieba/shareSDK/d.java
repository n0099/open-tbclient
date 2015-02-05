package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ ShareToTBActivity bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ShareToTBActivity shareToTBActivity, int i) {
        super(i);
        this.bPn = shareToTBActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ShareSDKResultMessage) {
            if (((ShareSDKResultMessage) customResponsedMessage).getData().booleanValue()) {
                this.bPn.setResult(-1);
            } else {
                this.bPn.setResult(0);
            }
            this.bPn.finish();
        }
    }
}
