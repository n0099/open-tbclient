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
            i = this.this$0.bPi;
            if (msgBookmark > i) {
                this.this$0.bPj = true;
                this.this$0.bPl = true;
            }
            int msgFans = newsNotifyMessage.getMsgFans();
            i2 = this.this$0.bPg;
            if (msgFans > i2) {
                this.this$0.bPj = true;
                this.this$0.bPk = true;
            }
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            i3 = this.this$0.bPh;
            if (msgGiftNum > i3) {
                this.this$0.bPj = true;
                this.this$0.bPm = true;
            }
            this.this$0.bPi = newsNotifyMessage.getMsgBookmark();
            this.this$0.bPg = newsNotifyMessage.getMsgFans();
            this.this$0.bPh = newsNotifyMessage.getMsgGiftNum();
            i4 = this.this$0.bPg;
            if (i4 <= 0) {
                this.this$0.bPk = false;
            }
            i5 = this.this$0.bPi;
            if (i5 <= 0) {
                this.this$0.bPl = false;
            }
            i6 = this.this$0.bPh;
            if (i6 <= 0) {
                this.this$0.bPm = false;
            }
            this.this$0.eJ(false);
        }
    }
}
