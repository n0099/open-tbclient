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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PersonInfoDelegateStatic extends b {
    private MessageRedDotView eEn;
    private Boolean fUm = false;
    private CustomMessageListener fUn;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c Jo;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (Jo = personInfoDelegateStatic.Jo()) != null) {
                        Jo.aRL.setArguments(new Bundle());
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
    public c Jn() {
        c cVar = new c();
        cVar.aRL = new PersonCenterFragment();
        cVar.type = 8;
        cVar.aRM = d.j.mine;
        cVar.aRN = d.f.s_tabbar_icon_four_bg;
        cVar.jT = d.f.tabbar_person_anim;
        cVar.aRS = c.aRR;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator be(Context context) {
        this.aRx = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        this.eEn = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aSf = this.aRx;
        aVar.yW = l.dip2px(context, 10.0f);
        aVar.view = this.eEn;
        this.aRx.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_tab_show", false);
        if (this.fUm.booleanValue() || z) {
            this.eEn.refresh(0);
            this.eEn.setVisibility(0);
        } else {
            this.eEn.setVisibility(8);
        }
        return this.aRx;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Jm() {
        this.fUn = new CustomMessageListener(2007014) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.fUm = Boolean.valueOf(((a) customResponsedMessage.getData()).aRu);
                    if (PersonInfoDelegateStatic.this.fUm.booleanValue()) {
                        PersonInfoDelegateStatic.this.eEn.refresh(0);
                        PersonInfoDelegateStatic.this.eEn.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.eEn.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.fUm.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.fUn.setPriority(7);
        MessageManager.getInstance().registerListener(this.fUn);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void eX() {
        super.eX();
        MessageManager.getInstance().unRegisterListener(this.fUn);
    }
}
