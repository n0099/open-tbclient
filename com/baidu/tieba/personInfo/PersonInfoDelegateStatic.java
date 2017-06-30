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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView dTE;
    private CustomMessageListener eUs;
    private Boolean eUr = false;
    private int aEU = 0;

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
    public com.baidu.tbadk.mainTab.c Ey() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aFj = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aFk = w.l.mine;
        cVar.aFl = w.g.s_tabbar_icon_four_bg;
        cVar.aFp = com.baidu.tbadk.mainTab.c.aFm;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aEW = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.dTE = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aFi = this.aEW;
        aVar.uS = k.dip2px(context, 10.0f);
        aVar.view = this.dTE;
        aVar.aFg = w.g.icon_news_down_bar_one;
        if (this.eUr.booleanValue()) {
            this.dTE.setVisibility(0);
        } else {
            this.dTE.setVisibility(8);
        }
        this.aEW.a("emotion", aVar);
        return this.aEW;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Ex() {
        this.eUs = new d(this, CmdConfigCustom.MAINTAB_PERSON_TIP);
        this.eUs.setPriority(7);
        MessageManager.getInstance().registerListener(this.eUs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setVisibility(0);
            as.c((View) imageView, w.e.common_color_10225, 1);
            if (i <= 0) {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.eUs);
    }
}
