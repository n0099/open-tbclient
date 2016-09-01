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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView dOC;
    private Boolean eGL = false;
    private CustomMessageListener eGM;

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(12);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EE() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.azI = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.azJ = t.j.mine;
        cVar.azK = t.f.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ar(Context context) {
        this.azv = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.dOC = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.azH = this.azv;
        aVar.nB = k.dip2px(context, 3.0f);
        aVar.view = this.dOC;
        aVar.azF = t.f.icon_news_down_bar_one;
        if (this.eGL.booleanValue()) {
            this.dOC.setVisibility(0);
        } else {
            this.dOC.setVisibility(8);
        }
        this.azv.a("emotion", aVar);
        return this.azv;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ED() {
        this.eGM = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eGM.setPriority(12);
        MessageManager.getInstance().registerListener(this.eGM);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.eGM);
    }
}
