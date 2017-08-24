package com.baidu.tieba.personInfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView efO;
    private CustomMessageListener fka;
    private Boolean fjZ = false;
    private int aHt = 0;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personInfo.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c EX;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (EX = personInfoDelegateStatic.EX()) != null) {
                        EX.aHI.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(7);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c EW() {
        c cVar = new c();
        cVar.aHI = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aHJ = d.l.mine;
        cVar.aHK = d.g.s_tabbar_icon_four_bg;
        cVar.aHO = c.aHL;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aT(Context context) {
        this.aHv = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.efO = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aHH = this.aHv;
        aVar.wy = k.dip2px(context, 10.0f);
        aVar.view = this.efO;
        aVar.aHF = d.g.icon_news_down_bar_one;
        if (this.fjZ.booleanValue()) {
            this.efO.setVisibility(0);
        } else {
            this.efO.setVisibility(8);
        }
        this.aHv.a("emotion", aVar);
        return this.aHv;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EV() {
        this.fka = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personInfo.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null) {
                    if (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a) {
                        PersonInfoDelegateStatic.this.fjZ = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aHs);
                        PersonInfoDelegateStatic.this.aHt = ((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aHt;
                        PersonInfoDelegateStatic.this.efO.setVisibility(PersonInfoDelegateStatic.this.fjZ.booleanValue() ? 0 : 8);
                        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                        if (!PersonInfoDelegateStatic.this.fjZ.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                        }
                    }
                    PersonInfoDelegateStatic.f(PersonInfoDelegateStatic.this.efO, PersonInfoDelegateStatic.this.aHt);
                }
            }
        };
        this.fka.setPriority(7);
        MessageManager.getInstance().registerListener(this.fka);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setVisibility(0);
            ai.c((View) imageView, d.e.common_color_10225, 1);
            if (i <= 0) {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cM() {
        super.cM();
        MessageManager.getInstance().unRegisterListener(this.fka);
    }
}
