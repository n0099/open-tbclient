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
    private ImageView dWb;
    private Boolean ePo = false;
    private CustomMessageListener ePp;

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
    public com.baidu.tbadk.mainTab.c EJ() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aAd = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aAe = r.j.mine;
        cVar.aAf = r.f.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ap(Context context) {
        this.azQ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(r.h.fragmenttabindicator, (ViewGroup) null);
        this.dWb = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aAc = this.azQ;
        aVar.nC = k.dip2px(context, 3.0f);
        aVar.view = this.dWb;
        aVar.aAa = r.f.icon_news_down_bar_one;
        if (this.ePo.booleanValue()) {
            this.dWb.setVisibility(0);
        } else {
            this.dWb.setVisibility(8);
        }
        this.azQ.a("emotion", aVar);
        return this.azQ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EI() {
        this.ePp = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.ePp.setPriority(5);
        MessageManager.getInstance().registerListener(this.ePp);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.ePp);
    }
}
