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
    private CustomMessageListener fjY;
    private Boolean fjX = false;
    private int aHs = 0;

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
                        EX.aHH.setArguments(new Bundle());
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
        cVar.aHH = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aHI = d.l.mine;
        cVar.aHJ = d.g.s_tabbar_icon_four_bg;
        cVar.aHN = c.aHK;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aT(Context context) {
        this.aHu = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.efO = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aHG = this.aHu;
        aVar.wy = k.dip2px(context, 10.0f);
        aVar.view = this.efO;
        aVar.aHE = d.g.icon_news_down_bar_one;
        if (this.fjX.booleanValue()) {
            this.efO.setVisibility(0);
        } else {
            this.efO.setVisibility(8);
        }
        this.aHu.a("emotion", aVar);
        return this.aHu;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EV() {
        this.fjY = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personInfo.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null) {
                    if (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a) {
                        PersonInfoDelegateStatic.this.fjX = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aHr);
                        PersonInfoDelegateStatic.this.aHs = ((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aHs;
                        PersonInfoDelegateStatic.this.efO.setVisibility(PersonInfoDelegateStatic.this.fjX.booleanValue() ? 0 : 8);
                        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                        if (!PersonInfoDelegateStatic.this.fjX.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                        }
                    }
                    PersonInfoDelegateStatic.f(PersonInfoDelegateStatic.this.efO, PersonInfoDelegateStatic.this.aHs);
                }
            }
        };
        this.fjY.setPriority(7);
        MessageManager.getInstance().registerListener(this.fjY);
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
        MessageManager.getInstance().unRegisterListener(this.fjY);
    }
}
