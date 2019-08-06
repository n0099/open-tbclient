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
    private MessageRedDotView gTg;
    private Boolean ikD = false;
    private CustomMessageListener ikE;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c atU;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (atU = personInfoDelegateStatic.atU()) != null) {
                        atU.cxK.setArguments(new Bundle());
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
    public c atT() {
        c cVar = new c();
        cVar.cxK = new PersonCenterFragment();
        cVar.type = 8;
        cVar.bXe = R.string.mine;
        cVar.kE = R.raw.mime;
        cVar.cxQ = c.cxP;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cP(Context context) {
        this.cxw = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.gTg = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.cyh = this.cxw;
        aVar.zQ = l.dip2px(context, 10.0f);
        aVar.view = this.gTg;
        this.cxw.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_feedback_tip_tab_show", false);
        if (this.ikD.booleanValue() || z) {
            this.gTg.refresh(0);
            this.gTg.setVisibility(0);
        } else {
            this.gTg.setVisibility(8);
        }
        return this.cxw;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void atS() {
        this.ikE = new CustomMessageListener(2007014) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.ikD = Boolean.valueOf(((a) customResponsedMessage.getData()).cxt);
                    if (PersonInfoDelegateStatic.this.ikD.booleanValue()) {
                        PersonInfoDelegateStatic.this.gTg.refresh(0);
                        PersonInfoDelegateStatic.this.gTg.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.gTg.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.ikD.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.ikE.setPriority(7);
        MessageManager.getInstance().registerListener(this.ikE);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void fv() {
        super.fv();
        MessageManager.getInstance().unRegisterListener(this.ikE);
    }
}
