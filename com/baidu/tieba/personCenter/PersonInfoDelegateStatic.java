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
    private CustomMessageListener eZK;
    private ImageView ein;
    private Boolean eZJ = false;
    private int aFX = 0;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c Eu;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (Eu = personInfoDelegateStatic.Eu()) != null) {
                        Eu.aGi.setArguments(new Bundle());
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
    public c Et() {
        c cVar = new c();
        cVar.aGi = new a();
        cVar.type = 8;
        cVar.aGj = d.l.mine;
        cVar.aGk = d.g.s_tabbar_icon_four_bg;
        cVar.aGm = d.g.tabbar_person_anim;
        cVar.aGq = c.aGp;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aFZ = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.j.maintab_bottom_indicator, (ViewGroup) null);
        this.ein = new ImageView(context);
        e.a aVar = new e.a();
        aVar.aGD = this.aFZ;
        aVar.ur = l.dip2px(context, 10.0f);
        aVar.view = this.ein;
        aVar.aGB = d.g.icon_news_down_bar_one;
        if (this.eZJ.booleanValue()) {
            this.ein.setVisibility(0);
        } else {
            this.ein.setVisibility(8);
        }
        this.aFZ.a("emotion", aVar);
        return this.aFZ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Es() {
        this.eZK = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
                    PersonInfoDelegateStatic.this.eZJ = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aFW);
                    PersonInfoDelegateStatic.this.aFX = ((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aFX;
                    PersonInfoDelegateStatic.this.ein.setVisibility(PersonInfoDelegateStatic.this.eZJ.booleanValue() ? 0 : 8);
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.eZJ.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.eZK.setPriority(7);
        MessageManager.getInstance().registerListener(this.eZK);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.eZK);
    }
}
