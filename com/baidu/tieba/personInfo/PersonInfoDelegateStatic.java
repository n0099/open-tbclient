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
    private ImageView dQy;
    private Boolean eIP = false;
    private CustomMessageListener eIQ;

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(13);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EE() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.azl = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.azm = r.j.mine;
        cVar.azn = r.f.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ap(Context context) {
        this.ayY = (FragmentTabIndicator) LayoutInflater.from(context).inflate(r.h.fragmenttabindicator, (ViewGroup) null);
        this.dQy = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.azk = this.ayY;
        aVar.nB = k.dip2px(context, 3.0f);
        aVar.view = this.dQy;
        aVar.azi = r.f.icon_news_down_bar_one;
        if (this.eIP.booleanValue()) {
            this.dQy.setVisibility(0);
        } else {
            this.dQy.setVisibility(8);
        }
        this.ayY.a("emotion", aVar);
        return this.ayY;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ED() {
        this.eIQ = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eIQ.setPriority(13);
        MessageManager.getInstance().registerListener(this.eIQ);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.eIQ);
    }
}
