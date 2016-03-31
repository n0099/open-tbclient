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
    private ImageView dCo;
    private Boolean dCp = false;
    private CustomMessageListener dCq;

    static {
        d dVar = new d(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        dVar.setPriority(11);
        MessageManager.getInstance().registerListener(dVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Fk() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ayV = new f();
        cVar.type = 8;
        cVar.ayW = t.j.mine;
        cVar.ayX = t.f.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aj(Context context) {
        this.ayI = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.dCo = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.ayU = this.ayI;
        aVar.uO = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.dCo;
        aVar.ayS = t.f.icon_news_down_bar_one;
        if (this.dCp.booleanValue()) {
            this.dCo.setVisibility(0);
        } else {
            this.dCo.setVisibility(8);
        }
        this.ayI.a("emotion", aVar);
        return this.ayI;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Fj() {
        this.dCq = new e(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.dCq.setPriority(11);
        MessageManager.getInstance().registerListener(this.dCq);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ei() {
        super.ei();
        MessageManager.getInstance().unRegisterListener(this.dCq);
    }
}
