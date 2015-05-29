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
            i = this.this$0.cvw;
            boolean z = msgBookmark == i;
            int msgFans = newsNotifyMessage.getMsgFans();
            i2 = this.this$0.cvt;
            boolean z2 = msgFans == i2;
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            i3 = this.this$0.cvu;
            boolean z3 = msgGiftNum == i3;
            int msgLiveVip = newsNotifyMessage.getMsgLiveVip();
            i4 = this.this$0.cvv;
            boolean z4 = msgLiveVip == i4;
            if (!z || !z2 || !z3 || !z4) {
                MainTabActivity mainTabActivity = this.this$0;
                int msgBookmark2 = newsNotifyMessage.getMsgBookmark();
                i5 = this.this$0.cvw;
                mainTabActivity.cvC = msgBookmark2 > i5 ? true : this.this$0.cvC;
                MainTabActivity mainTabActivity2 = this.this$0;
                int msgFans2 = newsNotifyMessage.getMsgFans();
                i6 = this.this$0.cvt;
                mainTabActivity2.cvA = msgFans2 > i6 ? true : this.this$0.cvA;
                MainTabActivity mainTabActivity3 = this.this$0;
                int msgGiftNum2 = newsNotifyMessage.getMsgGiftNum();
                i7 = this.this$0.cvu;
                mainTabActivity3.cvB = msgGiftNum2 > i7 ? true : this.this$0.cvB;
                MainTabActivity mainTabActivity4 = this.this$0;
                int msgLiveVip2 = newsNotifyMessage.getMsgLiveVip();
                i8 = this.this$0.cvv;
                mainTabActivity4.cvD = msgLiveVip2 <= i8 ? this.this$0.cvD : true;
                this.this$0.cvw = newsNotifyMessage.getMsgBookmark();
                this.this$0.cvt = newsNotifyMessage.getMsgFans();
                this.this$0.cvu = newsNotifyMessage.getMsgGiftNum();
                this.this$0.cvv = newsNotifyMessage.getMsgLiveVip();
                i9 = this.this$0.cvt;
                if (i9 <= 0) {
                    this.this$0.cvA = false;
                }
                i10 = this.this$0.cvu;
                if (i10 <= 0) {
                    this.this$0.cvB = false;
                }
                i11 = this.this$0.cvw;
                if (i11 <= 0) {
                    this.this$0.cvC = false;
                }
                i12 = this.this$0.cvv;
                if (i12 <= 0) {
                    this.this$0.cvD = false;
                }
                this.this$0.fl(false);
            }
        }
    }
}
