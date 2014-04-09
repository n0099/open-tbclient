package com.baidu.tieba.tbluncher;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
final class r extends com.baidu.adp.framework.c.a {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(MainTabActivity mainTabActivity, int i) {
        super(2007002);
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<com.baidu.tbadk.mainTab.b> a;
        FragmentTabHost fragmentTabHost;
        FragmentTabHost fragmentTabHost2;
        MainTabActivity mainTabActivity;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2007002 || customResponsedMessage2.a() == null || (a = ((com.baidu.tbadk.mainTab.e) customResponsedMessage2.a()).a()) == null || a.size() == 0) {
            return;
        }
        fragmentTabHost = this.a.m;
        fragmentTabHost.b();
        Iterator<com.baidu.tbadk.mainTab.b> it = a.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.mainTab.b next = it.next();
            if (next != null) {
                com.baidu.tbadk.mainTab.d b = next.b();
                MainTabActivity mainTabActivity2 = this.a;
                mainTabActivity = this.a.E;
                MainTabActivity.a(mainTabActivity2, b, next.a(mainTabActivity));
            }
        }
        fragmentTabHost2 = this.a.m;
        fragmentTabHost2.a();
        MainTabActivity.a(this.a, this.a.getIntent());
    }
}
