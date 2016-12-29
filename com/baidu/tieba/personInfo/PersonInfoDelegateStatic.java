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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView dAE;
    private Boolean esK = false;
    private CustomMessageListener esL;

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
    public com.baidu.tbadk.mainTab.c Er() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.azA = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.azB = r.j.mine;
        cVar.azC = r.f.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator an(Context context) {
        this.azn = (FragmentTabIndicator) LayoutInflater.from(context).inflate(r.h.fragmenttabindicator, (ViewGroup) null);
        this.dAE = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.azz = this.azn;
        aVar.nC = k.dip2px(context, 3.0f);
        aVar.view = this.dAE;
        aVar.azx = r.f.icon_news_down_bar_one;
        if (this.esK.booleanValue()) {
            this.dAE.setVisibility(0);
        } else {
            this.dAE.setVisibility(8);
        }
        this.azn.a("emotion", aVar);
        return this.azn;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Eq() {
        this.esL = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.esL.setPriority(5);
        MessageManager.getInstance().registerListener(this.esL);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.esL);
    }
}
