package com.baidu.tieba.write.bottomButton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class WriteThreadDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Eh() {
        c cVar = new c();
        cVar.aEi = new b();
        cVar.type = 9;
        cVar.aEj = w.l.home_write;
        cVar.aEk = w.g.home_bottom_selector;
        cVar.aEo = c.aEl;
        return cVar;
    }

    static {
        a aVar = new a(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        aVar.setPriority(3);
        MessageManager.getInstance().registerListener(aVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aDV = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.aDV.setTextSize(2.0f);
        return this.aDV;
    }
}
