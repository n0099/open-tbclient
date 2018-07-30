package com.baidu.tieba.personPolymeric;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class PersonInfoActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002003, new CustomMessageTask.CustomRunnable<PersonInfoActivityConfig>() { // from class: com.baidu.tieba.personPolymeric.PersonInfoActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<PersonInfoActivityConfig> run(CustomMessage<PersonInfoActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    PersonInfoActivityStatic.a(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        Tl();
        ay.zK().a(new ay.a() { // from class: com.baidu.tieba.personPolymeric.PersonInfoActivityStatic.2
            @Override // com.baidu.tbadk.core.util.ay.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_personalCenter=1")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), z.at(str, "userid="), z.at(str, "un="))));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void Tl() {
        com.baidu.tieba.tbadkCore.a.a.c(303040, UserMuteCheckSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(303040, CmdConfigHttp.CMD_USER_MUTE_CHECK, TbConfig.USER_MUTE_CHECK, UserMuteCheckHttpResponsedMessage.class, false, false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(PersonInfoActivityConfig personInfoActivityConfig) {
        Context context = personInfoActivityConfig.getContext();
        String stringExtra = personInfoActivityConfig.getIntent().getStringExtra("user_id");
        if (stringExtra != null && stringExtra.length() > 0 && !stringExtra.equals("0") && !stringExtra.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
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
