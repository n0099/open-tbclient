package com.baidu.tieba.tbluncher;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
final class p extends com.baidu.adp.framework.c.a {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(MainTabActivity mainTabActivity, int i) {
        super(2001124);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2001124) {
            return;
        }
        if (!(customResponsedMessage2 instanceof NewsNotifyMessage)) {
            com.baidu.adp.lib.util.f.b("transform error");
            return;
        }
        NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage2;
        this.a.L = newsNotifyMessage.j();
        this.a.K = newsNotifyMessage.d();
        this.a.h();
    }
}
