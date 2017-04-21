package com.baidu.tieba.personInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView dLm;
    private Boolean eGt = false;
    private CustomMessageListener eGu;

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(5);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Fd() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aEh = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aEi = w.l.mine;
        cVar.aEj = w.g.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aP(Context context) {
        this.aDU = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.dLm = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aEg = this.aDU;
        aVar.uS = k.dip2px(context, 3.0f);
        aVar.view = this.dLm;
        aVar.aEe = w.g.icon_news_down_bar_one;
        if (this.eGt.booleanValue()) {
            this.dLm.setVisibility(0);
        } else {
            this.dLm.setVisibility(8);
        }
        this.aDU.a("emotion", aVar);
        return this.aDU;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Fc() {
        this.eGu = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eGu.setPriority(5);
        MessageManager.getInstance().registerListener(this.eGu);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.eGu);
    }
}
