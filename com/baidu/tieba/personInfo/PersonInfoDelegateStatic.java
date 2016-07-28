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
    private ImageView dCN;
    private Boolean eAq = false;
    private CustomMessageListener eAr;

    static {
        f fVar = new f(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        fVar.setPriority(12);
        MessageManager.getInstance().registerListener(fVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Dk() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.awB = new h();
        cVar.type = 8;
        cVar.awC = u.j.mine;
        cVar.awD = u.f.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ah(Context context) {
        this.awo = (FragmentTabIndicator) LayoutInflater.from(context).inflate(u.h.fragmenttabindicator, (ViewGroup) null);
        this.dCN = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.awA = this.awo;
        aVar.lg = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.dCN;
        aVar.awy = u.f.icon_news_down_bar_one;
        if (this.eAq.booleanValue()) {
            this.dCN.setVisibility(0);
        } else {
            this.dCN.setVisibility(8);
        }
        this.awo.a("emotion", aVar);
        return this.awo;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Dj() {
        this.eAr = new g(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eAr.setPriority(12);
        MessageManager.getInstance().registerListener(this.eAr);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ay() {
        super.ay();
        MessageManager.getInstance().unRegisterListener(this.eAr);
    }
}
