package com.baidu.tieba.tbluncher;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class u extends com.baidu.adp.framework.c.a {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(MainTabActivity mainTabActivity, int i) {
        super(2007006);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            MainTabActivity.d(2);
        }
    }
}
