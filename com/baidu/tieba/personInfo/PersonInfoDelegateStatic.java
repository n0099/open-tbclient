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
    private ImageView dMu;
    private Boolean eGh = false;
    private CustomMessageListener eGi;

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
    public com.baidu.tbadk.mainTab.c EF() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aDP = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aDQ = w.l.mine;
        cVar.aDR = w.g.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aN(Context context) {
        this.aDC = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.dMu = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aDO = this.aDC;
        aVar.vk = k.dip2px(context, 3.0f);
        aVar.view = this.dMu;
        aVar.aDM = w.g.icon_news_down_bar_one;
        if (this.eGh.booleanValue()) {
            this.dMu.setVisibility(0);
        } else {
            this.dMu.setVisibility(8);
        }
        this.aDC.a("emotion", aVar);
        return this.aDC;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EE() {
        this.eGi = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eGi.setPriority(5);
        MessageManager.getInstance().registerListener(this.eGi);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cC() {
        super.cC();
        MessageManager.getInstance().unRegisterListener(this.eGi);
    }
}
