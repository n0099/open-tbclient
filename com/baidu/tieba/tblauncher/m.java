package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124) {
            if (!(customResponsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            int msgBookmark = newsNotifyMessage.getMsgBookmark();
            i = this.this$0.bOT;
            if (msgBookmark > i) {
                this.this$0.bOU = true;
                this.this$0.bOW = true;
            }
            int msgFans = newsNotifyMessage.getMsgFans();
            i2 = this.this$0.bOR;
            if (msgFans > i2) {
                this.this$0.bOU = true;
                this.this$0.bOV = true;
            }
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            i3 = this.this$0.bOS;
            if (msgGiftNum > i3) {
                this.this$0.bOU = true;
                this.this$0.bOX = true;
            }
            this.this$0.bOT = newsNotifyMessage.getMsgBookmark();
            this.this$0.bOR = newsNotifyMessage.getMsgFans();
            this.this$0.bOS = newsNotifyMessage.getMsgGiftNum();
            i4 = this.this$0.bOR;
            if (i4 <= 0) {
                this.this$0.bOV = false;
            }
            i5 = this.this$0.bOT;
            if (i5 <= 0) {
                this.this$0.bOW = false;
            }
            i6 = this.this$0.bOS;
            if (i6 <= 0) {
                this.this$0.bOX = false;
            }
            this.this$0.eJ(false);
        }
    }
}
