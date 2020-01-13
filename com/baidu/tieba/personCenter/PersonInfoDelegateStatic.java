package com.baidu.tieba.personCenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
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
/* loaded from: classes7.dex */
public class PersonInfoDelegateStatic extends b {
    private MessageRedDotView hJO;
    private Boolean jfR = false;
    private CustomMessageListener jfS;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c aNy;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (aNy = personInfoDelegateStatic.aNy()) != null) {
                        aNy.frag.setArguments(new Bundle());
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
    public c aNx() {
        c cVar = new c();
        cVar.frag = new PersonCenterFragment();
        cVar.type = 8;
        cVar.textResId = R.string.mine;
        if (TbSingleton.getInstance().isShowNewYearSkin()) {
            cVar.animationResId = R.raw.lottie_use_my_cj_n;
        } else {
            cVar.animationResId = R.raw.lottie_tab_my;
        }
        cVar.showIconType = c.dxj;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator dW(Context context) {
        this.dxc = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.hJO = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.dxy = this.dxc;
        aVar.offsetX = l.dip2px(context, 10.0f);
        aVar.view = this.hJO;
        this.dxc.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, false);
        if (this.jfR.booleanValue() || z) {
            this.hJO.refresh(0);
            this.hJO.setVisibility(0);
        } else {
            this.hJO.setVisibility(8);
        }
        return this.dxc;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.jfS = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.jfR = Boolean.valueOf(((a) customResponsedMessage.getData()).dwZ);
                    if (PersonInfoDelegateStatic.this.jfR.booleanValue()) {
                        PersonInfoDelegateStatic.this.hJO.refresh(0);
                        PersonInfoDelegateStatic.this.hJO.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.hJO.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.jfR.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_MINE_CLICKED, true);
                    }
                }
            }
        };
        this.jfS.setPriority(7);
        MessageManager.getInstance().registerListener(this.jfS);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.jfS);
    }
}
