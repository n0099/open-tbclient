package com.baidu.tieba.personInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView cSN;
    private Boolean dFw = false;
    private CustomMessageListener dFx;

    static {
        d dVar = new d(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        dVar.setPriority(12);
        MessageManager.getInstance().registerListener(dVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Dd() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.auW = new f();
        cVar.type = 8;
        cVar.auX = t.j.mine;
        cVar.auY = t.f.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ai(Context context) {
        this.auJ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.cSN = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.auV = this.auJ;
        aVar.kF = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.cSN;
        aVar.auT = t.f.icon_news_down_bar_one;
        if (this.dFw.booleanValue()) {
            this.cSN.setVisibility(0);
        } else {
            this.cSN.setVisibility(8);
        }
        this.auJ.a("emotion", aVar);
        return this.auJ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Dc() {
        this.dFx = new e(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.dFx.setPriority(12);
        MessageManager.getInstance().registerListener(this.dFx);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ay() {
        super.ay();
        MessageManager.getInstance().unRegisterListener(this.dFx);
    }
}
