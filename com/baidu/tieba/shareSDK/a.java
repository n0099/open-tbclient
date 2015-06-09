package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ ShareToTBActivity chk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ShareToTBActivity shareToTBActivity, int i) {
        super(i);
        this.chk = shareToTBActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ShareSDKResultMessage) {
            if (((ShareSDKResultMessage) customResponsedMessage).getData().booleanValue()) {
                this.chk.setResult(-1);
            } else {
                this.chk.setResult(0);
            }
            this.chk.finish();
        }
    }
}
