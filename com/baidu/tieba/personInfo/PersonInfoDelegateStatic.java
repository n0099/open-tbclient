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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView aRW;
    private Boolean aRX = false;
    private CustomMessageListener aRY;

    static {
        b bVar = new b(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        bVar.setPriority(9);
        MessageManager.getInstance().registerListener(bVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.axv = new d();
        cVar.type = 8;
        cVar.axw = n.j.mine;
        cVar.axx = n.f.s_icon_tabbar_personinfo;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(n.h.fragmenttabindicator, (ViewGroup) null);
        this.aRW = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.axu = this.mIndicator;
        aVar.uw = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aRW;
        aVar.axs = n.f.icon_news_down_bar_one;
        if (this.aRX.booleanValue()) {
            this.aRW.setVisibility(0);
        } else {
            this.aRW.setVisibility(8);
        }
        this.mIndicator.a("emotion", aVar);
        return this.mIndicator;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.aRY = new c(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.aRY.setPriority(9);
        MessageManager.getInstance().registerListener(this.aRY);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.aRY);
    }
}
