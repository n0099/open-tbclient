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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PersonInfoDelegateStatic extends b {
    private MessageRedDotView gMb;
    private Boolean idf = false;
    private CustomMessageListener idg;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c asK;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (asK = personInfoDelegateStatic.asK()) != null) {
                        asK.cwn.setArguments(new Bundle());
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
    public c asJ() {
        c cVar = new c();
        cVar.cwn = new PersonCenterFragment();
        cVar.type = 8;
        cVar.bVV = R.string.mine;
        cVar.kF = R.raw.mime;
        cVar.cwt = c.cws;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cO(Context context) {
        this.cvZ = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.gMb = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.cwK = this.cvZ;
        aVar.zL = l.dip2px(context, 10.0f);
        aVar.view = this.gMb;
        this.cvZ.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_feedback_tip_tab_show", false);
        if (this.idf.booleanValue() || z) {
            this.gMb.refresh(0);
            this.gMb.setVisibility(0);
        } else {
            this.gMb.setVisibility(8);
        }
        return this.cvZ;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void asI() {
        this.idg = new CustomMessageListener(2007014) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.idf = Boolean.valueOf(((a) customResponsedMessage.getData()).cvW);
                    if (PersonInfoDelegateStatic.this.idf.booleanValue()) {
                        PersonInfoDelegateStatic.this.gMb.refresh(0);
                        PersonInfoDelegateStatic.this.gMb.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.gMb.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.idf.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.idg.setPriority(7);
        MessageManager.getInstance().registerListener(this.idg);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void fn() {
        super.fn();
        MessageManager.getInstance().unRegisterListener(this.idg);
    }
}
