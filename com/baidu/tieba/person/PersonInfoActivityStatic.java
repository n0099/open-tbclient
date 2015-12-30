package com.baidu.tieba.person;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.personInfo.PersonInfoActivity;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
/* loaded from: classes.dex */
public class PersonInfoActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSON_INFO, new bl());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        Kf();
    }

    private static void Kf() {
        com.baidu.tieba.tbadkCore.a.a.a(303012, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.ak("c/u/user/profile", 303012));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ProfileHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(303040, UserMuteCheckSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(PersonInfoActivityConfig personInfoActivityConfig) {
        Context context = personInfoActivityConfig.getContext();
        String stringExtra = personInfoActivityConfig.getIntent().getStringExtra("user_id");
        String stringExtra2 = personInfoActivityConfig.getIntent().getStringExtra("user_name");
        String stringExtra3 = personInfoActivityConfig.getIntent().getStringExtra("from");
        String stringExtra4 = personInfoActivityConfig.getIntent().getStringExtra("st_type");
        if (stringExtra != null && stringExtra.length() > 0 && !stringExtra.equals("0") && !stringExtra.startsWith("-")) {
            Intent intent = personInfoActivityConfig.getIntent();
            intent.setClass(context, PersonInfoActivity.class);
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(stringExtra)) {
                intent.putExtra("self", true);
            } else {
                intent.putExtra("self", false);
            }
            intent.putExtra("un", stringExtra);
            intent.putExtra("name", stringExtra2);
            intent.putExtra("from_forum", stringExtra3);
            intent.putExtra("st_type", stringExtra4);
            intent.putExtra("tab_page", false);
            personInfoActivityConfig.setComponentClass(PersonInfoActivity.class);
            personInfoActivityConfig.run();
        }
    }
}
