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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.data.Config;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseGetLivableForumList;
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
import com.baidu.tieba.post.PersonPostActivity;
import com.baidu.tieba.post.m;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class PersonExtraStatic {
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
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSON_INFO, new CustomMessageTask.CustomRunnable<PersonInfoActivityConfig>() { // from class: com.baidu.tieba.personExtra.PersonExtraStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<PersonInfoActivityConfig> run(CustomMessage<PersonInfoActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    PersonExtraStatic.a(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ba.amO().a(new ba.a() { // from class: com.baidu.tieba.personExtra.PersonExtraStatic.2
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.GOTO_PERSON_INFO)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), ad.getMatchStringFromURL(str, "userid="), ad.getMatchStringFromURL(str, "un="))));
                    return 1;
                } else if (str.contains("jump_tieba_native=1") && str.contains("open_personalCenter=1")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), ad.getMatchStringFromURL(str, "userid="), ad.getMatchStringFromURL(str, "un="))));
                    return 0;
                } else {
                    return 3;
                }
            }
        });
        caw();
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_GET_LIVABLE_FORUM_LIST);
        bVar.setResponsedClass(ResponseGetLivableForumList.class);
        bVar.setNeedCompress(false);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        aIL();
        cao();
        cap();
        caq();
        car();
        cas();
        cat();
        bjp();
        cau();
        m.init();
        cav();
    }

    private static void aIL() {
        ba.amO().a(new ba.a() { // from class: com.baidu.tieba.personExtra.PersonExtraStatic.3
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                if (strArr[0].toLowerCase().contains(UrlSchemaHelper.JUMP_TO_MODIFY_NICKNAME)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(tbPageContext.getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    return 0;
                }
                return 3;
            }
        });
    }

    private static void cao() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSON_POLYMERIC, PersonPolymericSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003181, com.baidu.tieba.tbadkCore.a.a.bl(Config.PERSON_POLYMERIC_ADDRESS, CmdConfigSocket.CMD_PERSON_POLYMERIC));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(PersonPolymericHttpResMsg.class);
        MessageManager.getInstance().unRegisterTask(1003181);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cap() {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_USER_MUTE_CHECK, UserMuteCheckSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_USER_MUTE_CHECK, 1003025, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    private static void caq() {
        ba.amO().a(new ba.a() { // from class: com.baidu.tieba.personExtra.PersonExtraStatic.4
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.GOTO_PERSON_INFO)) {
                    String matchStringFromURL = ad.getMatchStringFromURL(str, "userid=");
                    long j = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long j2 = com.baidu.adp.lib.g.b.toLong(matchStringFromURL, 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(j2, j2 == j, false)));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void car() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003064, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1003063, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public static void cas() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_USER_POST_PAGE, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001503, com.baidu.tieba.tbadkCore.a.a.bl(Config.USER_POST_ADDRESS, CmdConfigSocket.CMD_USER_POST_PAGE));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cat() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001506, TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bjp() {
        com.baidu.tbadk.ala.b.afa().a(7, new com.baidu.tbadk.ala.e() { // from class: com.baidu.tieba.personExtra.PersonExtraStatic.5
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView ck = com.baidu.tbadk.ala.c.ck(context);
                if (ck != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    am.setViewTextColor(ck, (int) R.color.cp_link_tip_a);
                    layoutParams.setMargins(l.getDimens(context, R.dimen.ds8), 0, l.getDimens(context, R.dimen.ds8), 0);
                    layoutParams.gravity = 16;
                    ck.setLayoutParams(layoutParams);
                }
                return ck;
            }
        });
    }

    private static void cau() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003382, TbConfig.SERVER_ADDRESS + TbConfig.URL_USER_REPORT);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(UserReportHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cav() {
        ba.amO().a(new ba.a() { // from class: com.baidu.tieba.personExtra.PersonExtraStatic.6
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                AccountData currentAccountObj;
                if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                    return 3;
                }
                if (!strArr[0].contains(UrlSchemaHelper.JUMP_TO_POST_LIST) || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
                    return 3;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(tbPageContext.getPageActivity(), currentAccountObj.getID(), currentAccountObj.getSex(), currentAccountObj.getPortrait())));
                return 0;
            }
        });
    }

    private static void caw() {
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_USER_MUTE_CHECK, UserMuteCheckSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_USER_MUTE_CHECK, 1003025, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(PersonInfoActivityConfig personInfoActivityConfig) {
        Context context = personInfoActivityConfig.getContext();
        String stringExtra = personInfoActivityConfig.getIntent().getStringExtra("user_id");
        if (stringExtra != null && stringExtra.length() > 0 && !stringExtra.equals("0") && !stringExtra.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            Intent intent = personInfoActivityConfig.getIntent();
            intent.setClass(context, PersonPolymericActivity.class);
            intent.putExtra("user_id", com.baidu.adp.lib.g.b.toLong(stringExtra, 0L));
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                intent.putExtra(PersonPolymericActivityConfig.IS_USER_SELF, TbadkCoreApplication.getCurrentAccount().equals(stringExtra));
            } else {
                intent.putExtra(PersonPolymericActivityConfig.IS_USER_SELF, false);
            }
            personInfoActivityConfig.setComponentClass(PersonPolymericActivity.class);
            personInfoActivityConfig.run();
        }
    }
}
