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
/* loaded from: classes2.dex */
public class PersonInfoDelegateStatic extends b {
    private MessageRedDotView eLz;
    private Boolean gbu = false;
    private CustomMessageListener gbv;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c KE;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (KE = personInfoDelegateStatic.KE()) != null) {
                        KE.aVa.setArguments(new Bundle());
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
    public c KD() {
        c cVar = new c();
        cVar.aVa = new PersonCenterFragment();
        cVar.type = 8;
        cVar.awr = e.j.mine;
        cVar.aws = e.f.s_tabbar_icon_four_bg;
        cVar.mt = e.f.tabbar_person_anim;
        cVar.aVg = c.aVf;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bJ(Context context) {
        this.aUM = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(e.h.maintab_bottom_indicator, (ViewGroup) null);
        this.eLz = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aVu = this.aUM;
        aVar.Bs = l.dip2px(context, 10.0f);
        aVar.view = this.eLz;
        this.aUM.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_tab_show", false);
        if (this.gbu.booleanValue() || z) {
            this.eLz.refresh(0);
            this.eLz.setVisibility(0);
        } else {
            this.eLz.setVisibility(8);
        }
        return this.aUM;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void KC() {
        this.gbv = new CustomMessageListener(2007014) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.gbu = Boolean.valueOf(((a) customResponsedMessage.getData()).aUJ);
                    if (PersonInfoDelegateStatic.this.gbu.booleanValue()) {
                        PersonInfoDelegateStatic.this.eLz.refresh(0);
                        PersonInfoDelegateStatic.this.eLz.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.eLz.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.gbu.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.gbv.setPriority(7);
        MessageManager.getInstance().registerListener(this.gbv);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void gg() {
        super.gg();
        MessageManager.getInstance().unRegisterListener(this.gbv);
    }
}
