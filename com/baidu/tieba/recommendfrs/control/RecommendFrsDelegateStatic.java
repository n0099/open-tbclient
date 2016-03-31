package com.baidu.tieba.recommendfrs.control;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class RecommendFrsDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView dVW;
    private CustomMessageListener dVX;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Fk() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ayV = new a();
        cVar.type = 2;
        cVar.ayW = t.j.recommend;
        cVar.ayX = t.f.s_tabbar_icon_one_bg;
        return cVar;
    }

    static {
        k kVar = new k(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        kVar.setPriority(3);
        MessageManager.getInstance().registerListener(kVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Fj() {
        this.dVX = new l(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.dVX);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aj(Context context) {
        this.ayI = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.dVW = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.ayU = this.ayI;
        aVar.uO = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.dVW;
        aVar.ayS = t.f.icon_news_down_bar_one;
        this.dVW.setVisibility(8);
        this.ayI.a("godFeed", aVar);
        return this.ayI;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ei() {
        super.ei();
        MessageManager.getInstance().unRegisterListener(this.dVX);
    }
}
