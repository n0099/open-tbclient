package com.baidu.tieba.tbluncher;

import android.widget.TextView;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
final class q extends com.baidu.adp.framework.c.a {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(MainTabActivity mainTabActivity, int i) {
        super(2001124);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2001124) {
            return;
        }
        if (!(customResponsedMessage2 instanceof NewsNotifyMessage)) {
            com.baidu.adp.lib.util.f.b("transform error");
        } else if (MainTabActivity.c) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage2;
            int b = newsNotifyMessage.b() + newsNotifyMessage.c() + newsNotifyMessage.i();
            MainTabActivity mainTabActivity = this.a;
            textView = this.a.A;
            MainTabActivity.a(mainTabActivity, textView, b);
        }
    }
}
