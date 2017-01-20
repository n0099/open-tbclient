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
    private ImageView dJM;
    private Boolean eCF = false;
    private CustomMessageListener eCG;

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
    public com.baidu.tbadk.mainTab.c Em() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ayv = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.ayw = r.l.mine;
        cVar.ayx = r.g.s_tabbar_icon_four_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ap(Context context) {
        this.ayi = (FragmentTabIndicator) LayoutInflater.from(context).inflate(r.j.fragmenttabindicator, (ViewGroup) null);
        this.dJM = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.ayu = this.ayi;
        aVar.nv = k.dip2px(context, 3.0f);
        aVar.view = this.dJM;
        aVar.ays = r.g.icon_news_down_bar_one;
        if (this.eCF.booleanValue()) {
            this.dJM.setVisibility(0);
        } else {
            this.dJM.setVisibility(8);
        }
        this.ayi.a("emotion", aVar);
        return this.ayi;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void El() {
        this.eCG = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eCG.setPriority(5);
        MessageManager.getInstance().registerListener(this.eCG);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.eCG);
    }
}
