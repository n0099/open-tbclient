package com.baidu.tieba.personCenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonInfoDelegateStatic extends b {
    private ImageView fja;
    private Boolean gfs = false;
    private CustomMessageListener gft;

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c Mz;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (Mz = personInfoDelegateStatic.Mz()) != null) {
                        Mz.bvx.setArguments(new Bundle());
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
    public c My() {
        c cVar = new c();
        cVar.bvx = new a();
        cVar.type = 8;
        cVar.bvy = d.j.mine;
        cVar.bvz = d.f.s_tabbar_icon_four_bg;
        cVar.bvB = d.f.tabbar_person_anim;
        cVar.bvF = c.bvE;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e bm(Context context) {
        this.bvo = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(d.h.maintab_bottom_indicator, (ViewGroup) null);
        this.fja = new ImageView(context);
        e.a aVar = new e.a();
        aVar.bvS = this.bvo;
        aVar.aiC = l.dip2px(context, 10.0f);
        aVar.view = this.fja;
        aVar.bvQ = d.f.icon_news_down_bar_one;
        boolean z = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_feedback_tip_tab_show", false);
        if (this.gfs.booleanValue() || z) {
            this.fja.setVisibility(0);
        } else {
            this.fja.setVisibility(8);
        }
        this.bvo.b("emotion", aVar);
        return this.bvo;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Mx() {
        this.gft = new CustomMessageListener(CmdConfigCustom.MAINTAB_PERSON_TIP) { // from class: com.baidu.tieba.personCenter.PersonInfoDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007014 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.mainTab.a)) {
                    PersonInfoDelegateStatic.this.gfs = Boolean.valueOf(((com.baidu.tbadk.mainTab.a) customResponsedMessage.getData()).bvl);
                    PersonInfoDelegateStatic.this.fja.setVisibility(PersonInfoDelegateStatic.this.gfs.booleanValue() ? 0 : 8);
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (!PersonInfoDelegateStatic.this.gfs.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("member_close_ad_mine_clicked", true);
                    }
                }
            }
        };
        this.gft.setPriority(7);
        MessageManager.getInstance().registerListener(this.gft);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void kg() {
        super.kg();
        MessageManager.getInstance().unRegisterListener(this.gft);
    }
}
