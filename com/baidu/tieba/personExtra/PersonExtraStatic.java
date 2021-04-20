package com.baidu.tieba.personExtra;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.atomData.SmartAppBrowseHistoryActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.ResponseGetLivableForumList;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.data.PersonFriendActivityConfig;
import com.baidu.tieba.person.data.PersonImageActivityConfig;
import com.baidu.tieba.person.more.PersonCenterMoreActivity;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericHttpResMsg;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericSocketResMsg;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserReportHttpResponseMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabSocketResMessage;
import com.baidu.tieba.post.PersonPostActivity;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import d.b.c.e.p.l;
import d.b.h0.z0.n0;
import d.b.i0.m2.m;
/* loaded from: classes3.dex */
public class PersonExtraStatic {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<PersonInfoActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<PersonInfoActivityConfig> run(CustomMessage<PersonInfoActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                PersonExtraStatic.d(customMessage.getData());
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_PERSON_INFO)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), n0.c(str, "userid="), n0.c(str, "un="))));
                    return 1;
                } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.OPEN_PERSON_INFO)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), n0.c(str, "userid="), n0.c(str, "un="))));
                    return 0;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr.length == 0 || strArr[0] == null || !strArr[0].toLowerCase().contains(UrlSchemaHelper.JUMP_TO_MODIFY_NICKNAME)) {
                return 3;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(tbPageContext.getPageActivity(), 25020, 0, null)));
            return 0;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_PERSON_INFO)) {
                    String c2 = n0.c(str, "userid=");
                    long f2 = d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long f3 = d.b.c.e.m.b.f(c2, 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(f3, f3 == f2, false)));
                    return 1;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements d.b.h0.d.d {
        @Override // d.b.h0.d.d
        public View a(Context context) {
            TextView a2 = d.b.h0.d.c.a(context);
            if (a2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                SkinManager.setViewTextColor(a2, R.color.CAM_X0302);
                layoutParams.setMargins(l.g(context, R.dimen.ds8), 0, l.g(context, R.dimen.ds8), 0);
                layoutParams.gravity = 16;
                a2.setLayoutParams(layoutParams);
            }
            return a2;
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            AccountData currentAccountObj;
            if (strArr == null || strArr.length == 0 || strArr[0] == null || !strArr[0].contains(UrlSchemaHelper.JUMP_TO_POST_LIST) || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
                return 3;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(tbPageContext.getPageActivity(), currentAccountObj.getID(), currentAccountObj.getSex(), currentAccountObj.getPortrait())));
            return 0;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(EditHeadActivityConfig.class, EditHeadActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonMoreActivityConfig.class, PersonCenterMoreActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonFriendActivityConfig.class, PersonFriendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonBarActivityConfig.class, PersonBarActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonImageActivityConfig.class, PersonImageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonChangeActivityConfig.class, PersonChangeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(EditNickNameActivityConfig.class, EditNickNameActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SmartAppBrowseHistoryActivityConfig.class, SmartAppBrowseHistoryActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonPolymericActivityConfig.class, PersonPolymericActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonPostActivityConfig.class, PersonPostActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2002003, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UrlManager.getInstance().addListener(new b());
        k();
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(107129);
        bVar.setResponsedClass(ResponseGetLivableForumList.class);
        bVar.h(false);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        i();
        m();
        l();
        n();
        o();
        f();
        e();
        b();
        c();
        m.a();
        g();
        h();
        j();
    }

    public static void b() {
        d.b.h0.d.b.b().c(7, new e());
    }

    public static void c() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_USER_REPORT, TbConfig.SERVER_ADDRESS + TbConfig.URL_USER_REPORT);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(UserReportHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void d(PersonInfoActivityConfig personInfoActivityConfig) {
        Context context = personInfoActivityConfig.getContext();
        String stringExtra = personInfoActivityConfig.getIntent().getStringExtra("user_id");
        if (stringExtra == null || stringExtra.length() <= 0 || stringExtra.equals("0") || stringExtra.startsWith("-")) {
            return;
        }
        Intent intent = personInfoActivityConfig.getIntent();
        intent.setClass(context, PersonPolymericActivity.class);
        intent.putExtra("user_id", d.b.c.e.m.b.f(stringExtra, 0L));
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            intent.putExtra(PersonPolymericActivityConfig.IS_USER_SELF, TbadkCoreApplication.getCurrentAccount().equals(stringExtra));
        } else {
            intent.putExtra(PersonPolymericActivityConfig.IS_USER_SELF, false);
        }
        personInfoActivityConfig.setComponentClass(PersonPolymericActivity.class);
        personInfoActivityConfig.run();
    }

    public static void e() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void f() {
        d.b.i0.d3.d0.a.h(303002, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, d.b.i0.d3.d0.a.a("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void g() {
        UrlManager.getInstance().addListener(new f());
    }

    public static void h() {
        d.b.i0.d3.d0.a.d(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647, TbConfig.PERSON_CENTER_DYNAMIC_TAB_URL, PersonCenterDynamicTabHttpResMessage.class, PersonCenterDynamicTabSocketResMessage.class);
    }

    public static void i() {
        UrlManager.getInstance().addListener(new c());
    }

    public static void j() {
        d.b.i0.d3.d0.a.f(309684, RecommendGodSocketResponseMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, d.b.i0.d3.d0.a.a("c/u/user/getRecommendGodList", 309684));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RecommendGodHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void k() {
        d.b.i0.d3.d0.a.f(303040, UserMuteCheckSocketResponsedMessage.class, false);
        d.b.i0.d3.d0.a.c(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    public static void l() {
        d.b.i0.d3.d0.a.f(303040, UserMuteCheckSocketResponsedMessage.class, false);
        d.b.i0.d3.d0.a.c(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    public static void m() {
        d.b.i0.d3.d0.a.h(309408, PersonPolymericSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PERSON_POLYMERIC, d.b.i0.d3.d0.a.a("c/u/user/personal", 309408));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(PersonPolymericHttpResMsg.class);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_PERSON_POLYMERIC);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void n() {
        UrlManager.getInstance().addListener(new d());
    }

    public static void o() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }
}
