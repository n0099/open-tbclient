package com.baidu.tieba.tblauncher;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class y extends CustomMessageListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        if (customResponsedMessage != null) {
            MainTabActivity mainTabActivity = this.a;
            textView = this.a.E;
            mainTabActivity.a(textView, 0);
            MainTabActivity.d = false;
        }
    }
}
