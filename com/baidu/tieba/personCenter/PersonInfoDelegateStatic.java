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
    private MessageRedDotView gSZ;
    private Boolean ilm = false;
    private CustomMessageListener iln;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c avz;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (avz = personInfoDelegateStatic.avz()) != null) {
                        avz.frag.setArguments(new Bundle());
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
    public c avy() {
        c cVar = new c();
        cVar.frag = new PersonCenterFragment();
        cVar.type = 8;
        cVar.textResId = R.string.mine;
        cVar.animationResId = R.raw.mime;
        cVar.showIconType = c.cKi;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cKb = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.gSZ = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.cKv = this.cKb;
        aVar.offsetX = l.dip2px(context, 10.0f);
        aVar.view = this.gSZ;
        this.cKb.b("emotion", aVar);
        boolean z = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.KEY_FEEDBACK_PERSON_TAB_SHOW, false);
        if (this.ilm.booleanValue() || z) {
            this.gSZ.refresh(0);
            this.gSZ.setVisibility(0);
        } else {
            this.gSZ.setVisibility(8);
        }
        return this.cKb;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.iln = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                    PersonInfoDelegateStatic.this.ilm = Boolean.valueOf(((a) customResponsedMessage.getData()).cJY);
                    if (PersonInfoDelegateStatic.this.ilm.booleanValue()) {
                        PersonInfoDelegateStatic.this.gSZ.refresh(0);
                        PersonInfoDelegateStatic.this.gSZ.setVisibility(0);
                    } else {
                        PersonInfoDelegateStatic.this.gSZ.setVisibility(8);
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.ilm.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.MEMBER_CLOSE_AD_MINE_CLICKED, true);
                    }
                }
            }
        };
        this.iln.setPriority(7);
        MessageManager.getInstance().registerListener(this.iln);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.iln);
    }
}
