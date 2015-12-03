package com.baidu.tieba.recommendfrs.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.avR = new a();
        cVar.type = 2;
        cVar.avS = n.i.recommend;
        cVar.avT = n.e.s_icon_tabbar_essence;
        return cVar;
    }

    static {
        g gVar = new g(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        gVar.setPriority(4);
        MessageManager.getInstance().registerListener(gVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(n.g.fragmenttabindicator, (ViewGroup) null);
        return this.mIndicator;
    }
}
