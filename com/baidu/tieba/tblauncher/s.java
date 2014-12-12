package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(MainTabActivity mainTabActivity, int i) {
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
            i = this.this$0.caY;
            boolean z = msgBookmark == i;
            int msgFans = newsNotifyMessage.getMsgFans();
            i2 = this.this$0.caW;
            boolean z2 = msgFans == i2;
            int msgGiftNum = newsNotifyMessage.getMsgGiftNum();
            i3 = this.this$0.caX;
            boolean z3 = msgGiftNum == i3;
            if (!z || !z2 || !z3) {
                MainTabActivity mainTabActivity = this.this$0;
                int msgBookmark2 = newsNotifyMessage.getMsgBookmark();
                i4 = this.this$0.caY;
                mainTabActivity.cbb = msgBookmark2 > i4 ? true : this.this$0.cbb;
                MainTabActivity mainTabActivity2 = this.this$0;
                int msgFans2 = newsNotifyMessage.getMsgFans();
                i5 = this.this$0.caW;
                mainTabActivity2.caZ = msgFans2 > i5 ? true : this.this$0.caZ;
                MainTabActivity mainTabActivity3 = this.this$0;
                int msgGiftNum2 = newsNotifyMessage.getMsgGiftNum();
                i6 = this.this$0.caX;
                mainTabActivity3.cba = msgGiftNum2 <= i6 ? this.this$0.cba : true;
                this.this$0.caY = newsNotifyMessage.getMsgBookmark();
                this.this$0.caW = newsNotifyMessage.getMsgFans();
                this.this$0.caX = newsNotifyMessage.getMsgGiftNum();
                i7 = this.this$0.caW;
                if (i7 <= 0) {
                    this.this$0.caZ = false;
                }
                i8 = this.this$0.caX;
                if (i8 <= 0) {
                    this.this$0.cba = false;
                }
                i9 = this.this$0.caY;
                if (i9 <= 0) {
                    this.this$0.cbb = false;
                }
                this.this$0.eA(false);
            }
        }
    }
}
