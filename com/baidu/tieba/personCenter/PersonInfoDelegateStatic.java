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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.redpackage.NewUserRedPackageActivity;
/* loaded from: classes9.dex */
public class PersonInfoDelegateStatic extends b {
    private Boolean isNew = false;
    private CustomMessageListener maintabEmotionListener;
    private MessageRedDotView tipView;

    static {
        bqt();
        com.baidu.tieba.p.a.cVL();
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c fragmentTabStructure;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (fragmentTabStructure = personInfoDelegateStatic.getFragmentTabStructure()) != null) {
                        fragmentTabStructure.frag.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(8);
        MessageManager.getInstance().registerListener(customMessageListener);
        TbadkCoreApplication.getInst().RegisterIntent(NewUserRedPackageActivityConfig.class, NewUserRedPackageActivity.class);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.frag = new PersonCenterFragment();
        cVar.type = 8;
        cVar.textResId = R.string.mine;
        cVar.animationResId = R.raw.lottie_tab_my;
        cVar.showIconType = c.epP;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.eqe = this.mIndicator;
        aVar.offsetX = l.dip2px(context, 10.0f);
        aVar.view = this.tipView;
        this.mIndicator.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, false);
        if (this.isNew.booleanValue() || z) {
            this.tipView.refresh(0);
            this.tipView.setVisibility(0);
        } else {
            this.tipView.setVisibility(8);
        }
        return this.mIndicator;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.maintabEmotionListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
                    PersonInfoDelegateStatic.this.isNew = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).epI);
                    if (PersonInfoDelegateStatic.this.isNew.booleanValue()) {
                        PersonInfoDelegateStatic.this.tipView.refresh(0);
                        PersonInfoDelegateStatic.this.tipView.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.tipView.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.isNew.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_MINE_CLICKED, true);
                    }
                }
            }
        };
        this.maintabEmotionListener.setPriority(8);
        MessageManager.getInstance().registerListener(this.maintabEmotionListener);
    }

    private static void bqt() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PROFILE, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002700, com.baidu.tieba.tbadkCore.a.a.bF(Config.USER_INFO_ADDRESS, CmdConfigSocket.CMD_PROFILE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.maintabEmotionListener);
    }
}
