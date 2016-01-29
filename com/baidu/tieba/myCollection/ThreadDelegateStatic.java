package com.baidu.tieba.myCollection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ThreadDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ex() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ayo = s.ano();
        cVar.type = 1;
        cVar.ayp = t.j.collect_thread;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator am(Context context) {
        this.ayb = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        return this.ayb;
    }

    static {
        r rVar = new r(CmdConfigCustom.COLLECT_TAB_ADD_FRAGMENT);
        rVar.setPriority(1);
        MessageManager.getInstance().registerListener(rVar);
    }
}
