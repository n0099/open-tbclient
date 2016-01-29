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
    private ImageView dhM;
    private Boolean dhN = false;
    private CustomMessageListener dhO;

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
    public com.baidu.tbadk.mainTab.c Ex() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ayo = new f();
        cVar.type = 8;
        cVar.ayp = t.j.mine;
        cVar.ayq = t.f.s_icon_tabbar_personinfo;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator am(Context context) {
        this.ayb = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.dhM = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.ayn = this.ayb;
        aVar.uF = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.dhM;
        aVar.ayl = t.f.icon_news_down_bar_one;
        if (this.dhN.booleanValue()) {
            this.dhM.setVisibility(0);
        } else {
            this.dhM.setVisibility(8);
        }
        this.ayb.a("emotion", aVar);
        return this.ayb;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Ew() {
        this.dhO = new e(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.dhO.setPriority(11);
        MessageManager.getInstance().registerListener(this.dhO);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ei() {
        super.ei();
        MessageManager.getInstance().unRegisterListener(this.dhO);
    }
}
