package com.baidu.tieba.person;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class PersonInfoActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002003, new bc());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
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
            personInfoActivityConfig.run();
        }
    }
}
