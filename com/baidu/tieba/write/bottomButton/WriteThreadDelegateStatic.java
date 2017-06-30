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
    public c Ey() {
        c cVar = new c();
        cVar.aFj = new b();
        cVar.type = 9;
        cVar.aFk = w.l.home_write;
        cVar.aFl = w.g.home_bottom_selector;
        cVar.aFp = c.aFm;
        return cVar;
    }

    static {
        a aVar = new a(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        aVar.setPriority(3);
        MessageManager.getInstance().registerListener(aVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aEW = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.aEW.setTextSize(2.0f);
        return this.aEW;
    }
}
