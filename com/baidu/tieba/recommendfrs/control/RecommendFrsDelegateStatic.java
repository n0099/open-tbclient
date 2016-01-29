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
    private ImageView dEe;
    private CustomMessageListener dEf;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ex() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ayo = new a();
        cVar.type = 2;
        cVar.ayp = t.j.recommend;
        cVar.ayq = t.f.s_icon_tabbar_essence;
        return cVar;
    }

    static {
        j jVar = new j(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        jVar.setPriority(3);
        MessageManager.getInstance().registerListener(jVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Ew() {
        this.dEf = new k(this, CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW);
        MessageManager.getInstance().registerListener(this.dEf);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator am(Context context) {
        this.ayb = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.dEe = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.ayn = this.ayb;
        aVar.uF = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.dEe;
        aVar.ayl = t.f.icon_news_down_bar_one;
        this.dEe.setVisibility(8);
        this.ayb.a("godFeed", aVar);
        return this.ayb;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ei() {
        super.ei();
        MessageManager.getInstance().unRegisterListener(this.dEf);
    }
}
