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
    private ImageView dIW;
    private Boolean eEd = false;
    private CustomMessageListener eEe;

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
        cVar.aEf = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aEg = w.l.mine;
        cVar.aEh = w.g.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aP(Context context) {
        this.aDS = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.dIW = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aEe = this.aDS;
        aVar.uN = k.dip2px(context, 3.0f);
        aVar.view = this.dIW;
        aVar.aEc = w.g.icon_news_down_bar_one;
        if (this.eEd.booleanValue()) {
            this.dIW.setVisibility(0);
        } else {
            this.dIW.setVisibility(8);
        }
        this.aDS.a("emotion", aVar);
        return this.aDS;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Fc() {
        this.eEe = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eEe.setPriority(5);
        MessageManager.getInstance().registerListener(this.eEe);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.eEe);
    }
}
