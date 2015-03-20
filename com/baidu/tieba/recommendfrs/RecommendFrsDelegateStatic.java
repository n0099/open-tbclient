package com.baidu.tieba.recommendfrs;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d zK() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.alV = new b();
        dVar.type = 2;
        dVar.alW = y.recommend;
        dVar.alM = u.icon_tabbar_essence;
        return dVar;
    }

    static {
        a aVar = new a(2007002);
        aVar.setPriority(3);
        MessageManager.getInstance().registerListener(aVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator af(Context context) {
        this.alJ = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hH().inflate(context, w.fragmenttabindicator, null);
        return this.alJ;
    }
}
