package com.baidu.tieba.tblauncher;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124) {
            if (!(customResponsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
            } else if (MainTabActivity.c) {
                NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
                int msgReplyme = newsNotifyMessage.getMsgReplyme() + newsNotifyMessage.getMsgAtme();
                MainTabActivity mainTabActivity = this.a;
                textView = this.a.C;
                mainTabActivity.a(textView, msgReplyme);
            }
        }
    }
}
