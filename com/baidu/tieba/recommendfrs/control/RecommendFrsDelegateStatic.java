package com.baidu.tieba.recommendfrs.control;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.p;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d AC() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.anf = new a();
        dVar.type = 2;
        dVar.ang = t.recommend;
        dVar.anh = p.icon_tabbar_essence;
        return dVar;
    }

    static {
        e eVar = new e(2007002);
        eVar.setPriority(3);
        MessageManager.getInstance().registerListener(eVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aj(Context context) {
        this.amS = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hr().inflate(context, r.fragmenttabindicator, null);
        return this.amS;
    }
}
