package com.baidu.tieba.personInfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView ens;
    private CustomMessageListener fjm;
    private Boolean fjl = false;
    private int aGJ = 0;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personInfo.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c EV;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (EV = personInfoDelegateStatic.EV()) != null) {
                        EV.aGU.setArguments(new Bundle());
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
    public c EU() {
        c cVar = new c();
        cVar.aGU = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aGV = d.l.mine;
        cVar.aGW = d.g.s_tabbar_icon_four_bg;
        cVar.aGY = d.g.tabbar_person_anim;
        cVar.aHc = c.aHb;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aZ(Context context) {
        this.aGL = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.j.maintab_bottom_indicator, (ViewGroup) null);
        this.ens = new ImageView(context);
        e.a aVar = new e.a();
        aVar.aHp = this.aGL;
        aVar.uo = k.dip2px(context, 10.0f);
        aVar.view = this.ens;
        aVar.aHn = d.g.icon_news_down_bar_one;
        if (this.fjl.booleanValue()) {
            this.ens.setVisibility(0);
        } else {
            this.ens.setVisibility(8);
        }
        this.aGL.a("emotion", aVar);
        return this.aGL;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ET() {
        this.fjm = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personInfo.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
                    PersonInfoDelegateStatic.this.fjl = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aGI);
                    PersonInfoDelegateStatic.this.aGJ = ((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aGJ;
                    PersonInfoDelegateStatic.this.ens.setVisibility(PersonInfoDelegateStatic.this.fjl.booleanValue() ? 0 : 8);
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.fjl.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.fjm.setPriority(7);
        MessageManager.getInstance().registerListener(this.fjm);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.fjm);
    }
}
