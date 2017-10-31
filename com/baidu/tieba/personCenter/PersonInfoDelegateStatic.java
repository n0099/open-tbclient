package com.baidu.tieba.personCenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends b {
    private ImageView epW;
    private Boolean fhY = false;
    private CustomMessageListener fhZ;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c EG;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (EG = personInfoDelegateStatic.EG()) != null) {
                        EG.aGS.setArguments(new Bundle());
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
    public c EF() {
        c cVar = new c();
        cVar.aGS = new a();
        cVar.type = 8;
        cVar.aGT = d.j.mine;
        cVar.aGU = d.f.s_tabbar_icon_four_bg;
        cVar.aGW = d.f.tabbar_person_anim;
        cVar.aHa = c.aGZ;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aGJ = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        this.epW = new ImageView(context);
        e.a aVar = new e.a();
        aVar.aHn = this.aGJ;
        aVar.ur = l.dip2px(context, 10.0f);
        aVar.view = this.epW;
        aVar.aHl = d.f.icon_news_down_bar_one;
        if (this.fhY.booleanValue()) {
            this.epW.setVisibility(0);
        } else {
            this.epW.setVisibility(8);
        }
        this.aGJ.a("emotion", aVar);
        return this.aGJ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EE() {
        this.fhZ = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
                    PersonInfoDelegateStatic.this.fhY = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aGG);
                    PersonInfoDelegateStatic.this.epW.setVisibility(PersonInfoDelegateStatic.this.fhY.booleanValue() ? 0 : 8);
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.fhY.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.fhZ.setPriority(7);
        MessageManager.getInstance().registerListener(this.fhZ);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.fhZ);
    }
}
