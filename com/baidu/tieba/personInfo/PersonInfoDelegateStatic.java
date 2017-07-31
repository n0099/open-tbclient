package com.baidu.tieba.personInfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private ImageView edS;
    private CustomMessageListener fie;
    private Boolean fic = false;
    private int aHr = 0;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personInfo.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c EX;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (EX = personInfoDelegateStatic.EX()) != null) {
                        EX.aHG.setArguments(new Bundle());
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
    public c EW() {
        c cVar = new c();
        cVar.aHG = new com.baidu.tieba.personCenter.a();
        cVar.type = 8;
        cVar.aHH = d.l.mine;
        cVar.aHI = d.g.s_tabbar_icon_four_bg;
        cVar.aHM = c.aHJ;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aT(Context context) {
        this.aHt = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.edS = new ImageView(context);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aHF = this.aHt;
        aVar.ww = k.dip2px(context, 10.0f);
        aVar.view = this.edS;
        aVar.aHD = d.g.icon_news_down_bar_one;
        if (this.fic.booleanValue()) {
            this.edS.setVisibility(0);
        } else {
            this.edS.setVisibility(8);
        }
        this.aHt.a("emotion", aVar);
        return this.aHt;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void EV() {
        this.fie = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personInfo.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null) {
                    if (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a) {
                        PersonInfoDelegateStatic.this.fic = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aHq);
                        PersonInfoDelegateStatic.this.aHr = ((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).aHr;
                        PersonInfoDelegateStatic.this.edS.setVisibility(PersonInfoDelegateStatic.this.fic.booleanValue() ? 0 : 8);
                        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                        if (!PersonInfoDelegateStatic.this.fic.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                        }
                    }
                    PersonInfoDelegateStatic.f(PersonInfoDelegateStatic.this.edS, PersonInfoDelegateStatic.this.aHr);
                }
            }
        };
        this.fie.setPriority(7);
        MessageManager.getInstance().registerListener(this.fie);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setVisibility(0);
            ai.c((View) imageView, d.e.common_color_10225, 1);
            if (i <= 0) {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cM() {
        super.cM();
        MessageManager.getInstance().unRegisterListener(this.fie);
    }
}
