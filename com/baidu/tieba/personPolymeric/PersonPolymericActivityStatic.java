package com.baidu.tieba.personPolymeric;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.c;
import com.baidu.tbadk.ala.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericHttpResMsg;
import com.baidu.tieba.personPolymeric.mode.message.PersonPolymericSocketResMsg;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageHttpResponseMessage;
import com.baidu.tieba.personPolymeric.mode.message.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
/* loaded from: classes.dex */
public class PersonPolymericActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonPolymericActivityConfig.class, PersonPolymericActivity.class);
        Nq();
        aWm();
        aGv();
        aWn();
        aWo();
        aWp();
        agA();
    }

    private static void Nq() {
        com.baidu.tieba.tbadkCore.a.a.a(309408, PersonPolymericSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PERSON_POLYMERIC, com.baidu.tieba.tbadkCore.a.a.ay("c/u/user/personal", 309408));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(PersonPolymericHttpResMsg.class);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_PERSON_POLYMERIC);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aWm() {
        com.baidu.tieba.tbadkCore.a.a.c(303040, UserMuteCheckSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    private static void aGv() {
        av.vA().a(new av.a() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericActivityStatic.1
            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_personalCenter=1")) {
                    String as = x.as(str, "userid=");
                    x.as(str, "un=");
                    long c = b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    long c2 = b.c(as, 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(c2, c2 == c, false)));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void aWn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_USER_PICS, TbConfig.SET_USER_PICS);
        tbHttpMessageTask.setResponsedClass(SetUserPicsResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_CHANGE_PORTRAIT, TbConfig.CHANGE_USER_PORTRAIT);
        tbHttpMessageTask2.setResponsedClass(ChangePortraitResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public static void aWo() {
        com.baidu.tieba.tbadkCore.a.a.a(303002, UserPostPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.ay("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aWp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void agA() {
        com.baidu.tbadk.ala.b.nr().a(7, new d() { // from class: com.baidu.tieba.personPolymeric.PersonPolymericActivityStatic.2
            @Override // com.baidu.tbadk.ala.d
            public View aw(Context context) {
                TextView av = c.av(context);
                if (av != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    aj.i(av, d.e.cp_link_tip_a);
                    layoutParams.setMargins(l.f(context, d.f.ds8), 0, l.f(context, d.f.ds8), 0);
                    layoutParams.gravity = 16;
                    av.setLayoutParams(layoutParams);
                }
                return av;
            }
        });
    }
}
