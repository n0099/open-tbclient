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
    private MessageRedDotView ewF;
    private Boolean fPX = false;
    private CustomMessageListener fPY;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c Jb;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (Jb = personInfoDelegateStatic.Jb()) != null) {
                        Jb.aQP.setArguments(new Bundle());
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
    public c Ja() {
        c cVar = new c();
        cVar.aQP = new PersonCenterFragment();
        cVar.type = 8;
        cVar.aQQ = d.k.mine;
        cVar.aQR = d.f.s_tabbar_icon_four_bg;
        cVar.kc = d.f.tabbar_person_anim;
        cVar.aQW = c.aQV;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aQB = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.i.maintab_bottom_indicator, (ViewGroup) null);
        this.ewF = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aRj = this.aQB;
        aVar.zd = l.dip2px(context, 10.0f);
        aVar.view = this.ewF;
        this.aQB.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_tab_show", false);
        if (this.fPX.booleanValue() || z) {
            this.ewF.refresh(0);
            this.ewF.setVisibility(0);
        } else {
            this.ewF.setVisibility(8);
        }
        return this.aQB;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void IZ() {
        this.fPY = new CustomMessageListener(2007014) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.fPX = Boolean.valueOf(((a) customResponsedMessage.getData()).aQy);
                    if (PersonInfoDelegateStatic.this.fPX.booleanValue()) {
                        PersonInfoDelegateStatic.this.ewF.refresh(0);
                        PersonInfoDelegateStatic.this.ewF.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.ewF.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.fPX.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.fPY.setPriority(7);
        MessageManager.getInstance().registerListener(this.fPY);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void eY() {
        super.eY();
        MessageManager.getInstance().unRegisterListener(this.fPY);
    }
}
