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
    private ImageView dYX;
    private CustomMessageListener dYY;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Dc() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.auW = new a();
        cVar.type = 2;
        cVar.auX = t.j.home_recommend;
        cVar.auY = t.f.s_tabbar_icon_one_bg;
        return cVar;
    }

    static {
        k kVar = new k(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        kVar.setPriority(3);
        MessageManager.getInstance().registerListener(kVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Db() {
        this.dYY = new l(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.dYY);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ai(Context context) {
        this.auJ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.dYX = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.auV = this.auJ;
        aVar.kF = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.dYX;
        aVar.auT = t.f.icon_news_down_bar_one;
        this.dYX.setVisibility(8);
        this.auJ.a("godFeed", aVar);
        return this.auJ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ay() {
        super.ay();
        MessageManager.getInstance().unRegisterListener(this.dYY);
    }
}
