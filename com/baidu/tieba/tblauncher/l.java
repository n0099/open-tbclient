package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(MainTabActivity mainTabActivity, int i) {
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
            i = this.this$0.crp;
            boolean z = msgBookmark == i;
            int msgFans = newsNotifyMessage.getMsgFans();
            i2 = this.this$0.crn;
            boolean z2 = msgFans == i2;
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            i3 = this.this$0.cro;
            boolean z3 = msgGiftNum == i3;
            if (!z || !z2 || !z3) {
                MainTabActivity mainTabActivity = this.this$0;
                int msgBookmark2 = newsNotifyMessage.getMsgBookmark();
                i4 = this.this$0.crp;
                mainTabActivity.crv = msgBookmark2 > i4 ? true : this.this$0.crv;
                MainTabActivity mainTabActivity2 = this.this$0;
                int msgFans2 = newsNotifyMessage.getMsgFans();
                i5 = this.this$0.crn;
                mainTabActivity2.crt = msgFans2 > i5 ? true : this.this$0.crt;
                MainTabActivity mainTabActivity3 = this.this$0;
                int msgGiftNum2 = newsNotifyMessage.getMsgGiftNum();
                i6 = this.this$0.cro;
                mainTabActivity3.cru = msgGiftNum2 <= i6 ? this.this$0.cru : true;
                this.this$0.crp = newsNotifyMessage.getMsgBookmark();
                this.this$0.crn = newsNotifyMessage.getMsgFans();
                this.this$0.cro = newsNotifyMessage.getMsgGiftNum();
                i7 = this.this$0.crn;
                if (i7 <= 0) {
                    this.this$0.crt = false;
                }
                i8 = this.this$0.cro;
                if (i8 <= 0) {
                    this.this$0.cru = false;
                }
                i9 = this.this$0.crp;
                if (i9 <= 0) {
                    this.this$0.crv = false;
                }
                this.this$0.eS(false);
            }
        }
    }
}
