package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(MainTabActivity mainTabActivity, int i) {
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
        int i10;
        int i11;
        int i12;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124) {
            if (!(customResponsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            int msgBookmark = newsNotifyMessage.getMsgBookmark();
            i = this.this$0.cUA;
            boolean z = msgBookmark == i;
            int msgFans = newsNotifyMessage.getMsgFans();
            i2 = this.this$0.cUx;
            boolean z2 = msgFans == i2;
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            i3 = this.this$0.cUy;
            boolean z3 = msgGiftNum == i3;
            int msgLiveVip = newsNotifyMessage.getMsgLiveVip();
            i4 = this.this$0.cUz;
            boolean z4 = msgLiveVip == i4;
            if (!z || !z2 || !z3 || !z4) {
                MainTabActivity mainTabActivity = this.this$0;
                int msgBookmark2 = newsNotifyMessage.getMsgBookmark();
                i5 = this.this$0.cUA;
                mainTabActivity.cUG = msgBookmark2 > i5 ? true : this.this$0.cUG;
                MainTabActivity mainTabActivity2 = this.this$0;
                int msgFans2 = newsNotifyMessage.getMsgFans();
                i6 = this.this$0.cUx;
                mainTabActivity2.cUE = msgFans2 > i6 ? true : this.this$0.cUE;
                MainTabActivity mainTabActivity3 = this.this$0;
                int msgGiftNum2 = newsNotifyMessage.getMsgGiftNum();
                i7 = this.this$0.cUy;
                mainTabActivity3.cUF = msgGiftNum2 > i7 ? true : this.this$0.cUF;
                MainTabActivity mainTabActivity4 = this.this$0;
                int msgLiveVip2 = newsNotifyMessage.getMsgLiveVip();
                i8 = this.this$0.cUz;
                mainTabActivity4.cUH = msgLiveVip2 <= i8 ? this.this$0.cUH : true;
                this.this$0.cUA = newsNotifyMessage.getMsgBookmark();
                this.this$0.cUx = newsNotifyMessage.getMsgFans();
                this.this$0.cUy = newsNotifyMessage.getMsgGiftNum();
                this.this$0.cUz = newsNotifyMessage.getMsgLiveVip();
                i9 = this.this$0.cUx;
                if (i9 <= 0) {
                    this.this$0.cUE = false;
                }
                i10 = this.this$0.cUy;
                if (i10 <= 0) {
                    this.this$0.cUF = false;
                }
                i11 = this.this$0.cUA;
                if (i11 <= 0) {
                    this.this$0.cUG = false;
                }
                i12 = this.this$0.cUz;
                if (i12 <= 0) {
                    this.this$0.cUH = false;
                }
                this.this$0.go(false);
            }
        }
    }
}
