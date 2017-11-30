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
    private ImageView evQ;
    private Boolean frt = false;
    private CustomMessageListener fru;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c EZ;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (EZ = personInfoDelegateStatic.EZ()) != null) {
                        EZ.aHC.setArguments(new Bundle());
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
    public c EY() {
        c cVar = new c();
        cVar.aHC = new a();
        cVar.type = 8;
        cVar.aHD = d.j.mine;
        cVar.aHE = d.f.s_tabbar_icon_four_bg;
        cVar.aHG = d.f.tabbar_person_anim;
        cVar.aHK = c.aHJ;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bd(Context context) {
        this.aHt = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        this.evQ = new ImageView(context);
        e.a aVar = new e.a();
        aVar.aHX = this.aHt;
        aVar.ur = l.dip2px(context, 10.0f);
        aVar.view = this.evQ;
        aVar.aHV = d.f.icon_news_down_bar_one;
        if (this.frt.booleanValue()) {
            this.evQ.setVisibility(0);
        } else {
            this.evQ.setVisibility(8);
        }
        this.aHt.a("emotion", aVar);
        return this.aHt;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EX() {
        this.fru = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
                    PersonInfoDelegateStatic.this.frt = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aHq);
                    PersonInfoDelegateStatic.this.evQ.setVisibility(PersonInfoDelegateStatic.this.frt.booleanValue() ? 0 : 8);
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.frt.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.fru.setPriority(7);
        MessageManager.getInstance().registerListener(this.fru);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.fru);
    }
}
