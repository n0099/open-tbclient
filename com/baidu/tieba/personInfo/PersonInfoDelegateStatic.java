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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView dyI;
    private Boolean eoA = false;
    private CustomMessageListener eoB;

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
    public com.baidu.tbadk.mainTab.c Dl() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.avM = new f();
        cVar.type = 8;
        cVar.avN = u.j.mine;
        cVar.avO = u.f.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ah(Context context) {
        this.avz = (FragmentTabIndicator) LayoutInflater.from(context).inflate(u.h.fragmenttabindicator, (ViewGroup) null);
        this.dyI = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.avL = this.avz;
        aVar.kD = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.dyI;
        aVar.avJ = u.f.icon_news_down_bar_one;
        if (this.eoA.booleanValue()) {
            this.dyI.setVisibility(0);
        } else {
            this.dyI.setVisibility(8);
        }
        this.avz.a("emotion", aVar);
        return this.avz;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Dk() {
        this.eoB = new e(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eoB.setPriority(12);
        MessageManager.getInstance().registerListener(this.eoB);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ay() {
        super.ay();
        MessageManager.getInstance().unRegisterListener(this.eoB);
    }
}
