package com.baidu.tieba.personInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView dLf;
    private CustomMessageListener eKu;
    private Boolean eKt = false;
    private int aDG = 0;

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(7);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Eb() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aDV = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aDW = w.l.mine;
        cVar.aDX = w.g.s_tabbar_icon_four_bg;
        cVar.aEb = com.baidu.tbadk.mainTab.c.aDY;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aDI = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.dLf = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aDU = this.aDI;
        aVar.uT = k.dip2px(context, 3.0f);
        aVar.view = this.dLf;
        aVar.aDS = w.g.icon_news_down_bar_one;
        if (this.eKt.booleanValue()) {
            this.dLf.setVisibility(0);
        } else {
            this.dLf.setVisibility(8);
        }
        return this.aDI;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Ea() {
        this.eKu = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eKu.setPriority(7);
        MessageManager.getInstance().registerListener(this.eKu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setVisibility(0);
            aq.c((View) imageView, w.e.common_color_10225, 1);
            if (i <= 0) {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.eKu);
    }
}
