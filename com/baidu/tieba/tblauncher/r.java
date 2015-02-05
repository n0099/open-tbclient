package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(MainTabActivity mainTabActivity, int i) {
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
        int i7;
        int i8;
        int i9;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124) {
            if (!(customResponsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            int msgBookmark = newsNotifyMessage.getMsgBookmark();
            i = this.this$0.ccN;
            boolean z = msgBookmark == i;
            int msgFans = newsNotifyMessage.getMsgFans();
            i2 = this.this$0.ccL;
            boolean z2 = msgFans == i2;
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            i3 = this.this$0.ccM;
            boolean z3 = msgGiftNum == i3;
            if (!z || !z2 || !z3) {
                MainTabActivity mainTabActivity = this.this$0;
                int msgBookmark2 = newsNotifyMessage.getMsgBookmark();
                i4 = this.this$0.ccN;
                mainTabActivity.ccQ = msgBookmark2 > i4 ? true : this.this$0.ccQ;
                MainTabActivity mainTabActivity2 = this.this$0;
                int msgFans2 = newsNotifyMessage.getMsgFans();
                i5 = this.this$0.ccL;
                mainTabActivity2.ccO = msgFans2 > i5 ? true : this.this$0.ccO;
                MainTabActivity mainTabActivity3 = this.this$0;
                int msgGiftNum2 = newsNotifyMessage.getMsgGiftNum();
                i6 = this.this$0.ccM;
                mainTabActivity3.ccP = msgGiftNum2 <= i6 ? this.this$0.ccP : true;
                this.this$0.ccN = newsNotifyMessage.getMsgBookmark();
                this.this$0.ccL = newsNotifyMessage.getMsgFans();
                this.this$0.ccM = newsNotifyMessage.getMsgGiftNum();
                i7 = this.this$0.ccL;
                if (i7 <= 0) {
                    this.this$0.ccO = false;
                }
                i8 = this.this$0.ccM;
                if (i8 <= 0) {
                    this.this$0.ccP = false;
                }
                i9 = this.this$0.ccN;
                if (i9 <= 0) {
                    this.this$0.ccQ = false;
                }
                this.this$0.eH(false);
            }
        }
    }
}
