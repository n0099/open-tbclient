package com.baidu.tieba.person;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.h.b;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.personPolymeric.PersonPolymericActivity;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
/* loaded from: classes.dex */
public class PersonInfoActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PERSON_INFO, new d());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        Kt();
        bi.vx().a(new e());
    }

    private static void Kt() {
        com.baidu.tieba.tbadkCore.a.a.a(303012, ProfileSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PROFILE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aG("c/u/user/profile", 303012));
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
        personInfoActivityConfig.getIntent().getStringExtra("user_name");
        personInfoActivityConfig.getIntent().getStringExtra("from");
        personInfoActivityConfig.getIntent().getStringExtra("st_type");
        if (stringExtra != null && stringExtra.length() > 0 && !stringExtra.equals("0") && !stringExtra.startsWith("-")) {
            Intent intent = personInfoActivityConfig.getIntent();
            intent.setClass(context, PersonPolymericActivity.class);
            intent.putExtra("user_id", b.c(stringExtra, 0L));
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
