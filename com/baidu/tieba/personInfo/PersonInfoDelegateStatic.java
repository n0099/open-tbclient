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
    private ImageView aOe;
    private Boolean aOf = false;
    private CustomMessageListener aOg;

    static {
        b bVar = new b(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        bVar.setPriority(10);
        MessageManager.getInstance().registerListener(bVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.avR = new d();
        cVar.type = 8;
        cVar.avS = n.i.mine;
        cVar.avT = n.e.s_icon_tabbar_personinfo;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(n.g.fragmenttabindicator, (ViewGroup) null);
        this.aOe = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.avQ = this.mIndicator;
        aVar.uu = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aOe;
        aVar.avO = n.e.icon_news_down_bar_one;
        if (this.aOf.booleanValue()) {
            this.aOe.setVisibility(0);
        } else {
            this.aOe.setVisibility(8);
        }
        this.mIndicator.a("emotion", aVar);
        return this.mIndicator;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.aOg = new c(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.aOg.setPriority(10);
        MessageManager.getInstance().registerListener(this.aOg);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.aOg);
    }
}
