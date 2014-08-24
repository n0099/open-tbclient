package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        int i4;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124) {
            if (!(customResponsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            int msgBookmark = newsNotifyMessage.getMsgBookmark();
            i = this.a.O;
            if (msgBookmark > i) {
                this.a.Q = true;
                this.a.S = true;
            }
            int msgFans = newsNotifyMessage.getMsgFans();
            i2 = this.a.N;
            if (msgFans > i2) {
                this.a.Q = true;
                this.a.R = true;
            }
            this.a.O = newsNotifyMessage.getMsgBookmark();
            this.a.N = newsNotifyMessage.getMsgFans();
            i3 = this.a.N;
            if (i3 <= 0) {
                this.a.R = false;
            }
            i4 = this.a.O;
            if (i4 <= 0) {
                this.a.S = false;
            }
            this.a.a(false);
        }
    }
}
