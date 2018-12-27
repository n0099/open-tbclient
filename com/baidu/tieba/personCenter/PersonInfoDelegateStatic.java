package com.baidu.tieba.personCenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.a;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class PersonInfoDelegateStatic extends b {
    private MessageRedDotView feg;
    private Boolean gud = false;
    private CustomMessageListener gue;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c NQ;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (NQ = personInfoDelegateStatic.NQ()) != null) {
                        NQ.bdN.setArguments(new Bundle());
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
    public c NP() {
        c cVar = new c();
        cVar.bdN = new PersonCenterFragment();
        cVar.type = 8;
        cVar.aFs = e.j.mine;
        cVar.aFt = e.f.s_tabbar_icon_four_bg;
        cVar.nk = e.f.tabbar_person_anim;
        cVar.bdT = c.bdS;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.bdz = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(e.h.maintab_bottom_indicator, (ViewGroup) null);
        this.feg = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.bei = this.bdz;
        aVar.Cd = l.dip2px(context, 10.0f);
        aVar.view = this.feg;
        this.bdz.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_tab_show", false);
        if (this.gud.booleanValue() || z) {
            this.feg.refresh(0);
            this.feg.setVisibility(0);
        } else {
            this.feg.setVisibility(8);
        }
        return this.bdz;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void NO() {
        this.gue = new CustomMessageListener(2007014) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.gud = Boolean.valueOf(((a) customResponsedMessage.getData()).bdw);
                    if (PersonInfoDelegateStatic.this.gud.booleanValue()) {
                        PersonInfoDelegateStatic.this.feg.refresh(0);
                        PersonInfoDelegateStatic.this.feg.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.feg.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.gud.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.gue.setPriority(7);
        MessageManager.getInstance().registerListener(this.gue);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void gy() {
        super.gy();
        MessageManager.getInstance().unRegisterListener(this.gue);
    }
}
