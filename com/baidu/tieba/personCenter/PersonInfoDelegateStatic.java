package com.baidu.tieba.personCenter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MissionCustomDialogActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserRedPackageActivityConfig;
import com.baidu.tbadk.core.atomData.UserTropicGiftBagActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.missionCustomDialog.MissionCustomDialogActivity;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.redpackage.NewUserRedPackageActivity;
import com.baidu.tieba.tropicgiftbag.UserTropicGiftBagActivity;
import d.a.c.e.p.l;
import d.a.m0.e0.d;
/* loaded from: classes5.dex */
public class PersonInfoDelegateStatic extends d.a.m0.e0.b {

    /* renamed from: a  reason: collision with root package name */
    public MessageRedDotView f19740a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f19741b = Boolean.FALSE;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f19742c;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.m0.e0.c fragmentTabStructure;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            PersonInfoDelegateStatic personInfoDelegateStatic = new PersonInfoDelegateStatic();
            ((d) customResponsedMessage.getData()).a(personInfoDelegateStatic);
            if (((d) customResponsedMessage.getData()).b() == null || (fragmentTabStructure = personInfoDelegateStatic.getFragmentTabStructure()) == null) {
                return;
            }
            fragmentTabStructure.f53008a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2007014 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.m0.e0.a)) {
                return;
            }
            PersonInfoDelegateStatic.this.f19741b = Boolean.valueOf(((d.a.m0.e0.a) customResponsedMessage.getData()).f53007a);
            if (PersonInfoDelegateStatic.this.f19741b.booleanValue()) {
                PersonInfoDelegateStatic.this.f19740a.f(0);
                PersonInfoDelegateStatic.this.f19740a.setVisibility(0);
            } else {
                PersonInfoDelegateStatic.this.f19740a.setVisibility(8);
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (!PersonInfoDelegateStatic.this.f19741b.booleanValue() && TbadkCoreApplication.isLogin() && currentAccountObj.isMemberCloseAdIsOpen()) {
                d.a.m0.r.d0.b.j().t("member_close_ad_mine_clicked", true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr[0] == null || tbPageContext == null || tbPageContext.getPageActivity() == null || !strArr[0].contains("openAiCustomService")) {
                return 3;
            }
            d.a.n0.h2.b.a().b();
            return 0;
        }
    }

    static {
        d();
        d.a.n0.u2.a.v();
        a aVar = new a(2007002);
        aVar.setPriority(9);
        MessageManager.getInstance().registerListener(aVar);
        TbadkCoreApplication.getInst().RegisterIntent(NewUserRedPackageActivityConfig.class, NewUserRedPackageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MissionCustomDialogActivityConfig.class, MissionCustomDialogActivity.class);
        e();
        TbadkCoreApplication.getInst().RegisterIntent(UserTropicGiftBagActivityConfig.class, UserTropicGiftBagActivity.class);
        d.a.n0.h2.b.a();
    }

    public static void d() {
        d.a.n0.e3.d0.a.h(303012, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, d.a.n0.e3.d0.a.a("c/u/user/profile", 303012));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void e() {
        UrlManager.getInstance().addListener(new c());
    }

    @Override // d.a.m0.e0.b
    public d.a.m0.e0.c createFragmentTabStructure() {
        d.a.m0.e0.c cVar = new d.a.m0.e0.c();
        cVar.f53008a = new PersonCenterFragment();
        cVar.f53012e = 8;
        cVar.f53009b = R.string.mine;
        cVar.f53013f = R.raw.lottie_tab_my;
        cVar.f53016i = d.a.m0.e0.c.m;
        cVar.f53015h = d.a.m0.e0.e.c.d().c("person");
        return cVar;
    }

    @Override // d.a.m0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.f19740a = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.f12937f = this.mIndicator;
        aVar.f12934c = l.e(context, 10.0f);
        aVar.f12932a = this.f19740a;
        this.mIndicator.b(FileHelper.FILE_CACHE_EMOTION_PACKAGE, aVar);
        boolean g2 = d.a.m0.r.d0.b.j().g("key_feedback_tip_tab_show", false);
        if (!this.f19741b.booleanValue() && !g2) {
            this.f19740a.setVisibility(8);
        } else {
            this.f19740a.f(0);
            this.f19740a.setVisibility(0);
        }
        return this.mIndicator;
    }

    @Override // d.a.m0.e0.b
    public boolean isAvailable() {
        return MainTabActivityConfig.PERSON_TAB_AVAIBLE;
    }

    @Override // d.a.m0.e0.b
    public void onAdd() {
        b bVar = new b(2007014);
        this.f19742c = bVar;
        bVar.setPriority(9);
        MessageManager.getInstance().registerListener(this.f19742c);
    }

    @Override // d.a.m0.e0.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.f19742c);
    }
}
