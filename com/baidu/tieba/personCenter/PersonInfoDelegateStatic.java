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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class PersonInfoDelegateStatic extends b {
    private MessageRedDotView eEj;
    private Boolean fUe = false;
    private CustomMessageListener fUf;

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
                        Jo.aRI.setArguments(new Bundle());
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
        cVar.aRI = new PersonCenterFragment();
        cVar.type = 8;
        cVar.aRJ = f.j.mine;
        cVar.aRK = f.C0146f.s_tabbar_icon_four_bg;
        cVar.jU = f.C0146f.tabbar_person_anim;
        cVar.aRQ = c.aRP;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRu = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(f.h.maintab_bottom_indicator, (ViewGroup) null);
        this.eEj = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aSf = this.aRu;
        aVar.yX = l.dip2px(context, 10.0f);
        aVar.view = this.eEj;
        this.aRu.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_tab_show", false);
        if (this.fUe.booleanValue() || z) {
            this.eEj.refresh(0);
            this.eEj.setVisibility(0);
        } else {
            this.eEj.setVisibility(8);
        }
        return this.aRu;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Jm() {
        this.fUf = new CustomMessageListener(2007014) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.fUe = Boolean.valueOf(((a) customResponsedMessage.getData()).aRr);
                    if (PersonInfoDelegateStatic.this.fUe.booleanValue()) {
                        PersonInfoDelegateStatic.this.eEj.refresh(0);
                        PersonInfoDelegateStatic.this.eEj.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.eEj.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.fUe.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.fUf.setPriority(7);
        MessageManager.getInstance().registerListener(this.fUf);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void eX() {
        super.eX();
        MessageManager.getInstance().unRegisterListener(this.fUf);
    }
}
