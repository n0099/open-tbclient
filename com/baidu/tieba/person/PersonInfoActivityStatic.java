package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class PersonInfoActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002003, new dj());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, String str3, String str4) {
        Intent intent;
        if (str != null && str.length() > 0 && !str.equals("0") && !str.startsWith("-")) {
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().equals(str)) {
                intent = new Intent(context, SingleMyPersonInfoActivity.class);
                intent.putExtra("self", true);
            } else {
                intent = new Intent(context, SinglePersonInfoActivity.class);
                intent.putExtra("self", false);
            }
            intent.putExtra("un", str);
            intent.putExtra("name", str2);
            intent.putExtra("from_forum", str3);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str4);
            intent.putExtra("tab_page", false);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }
}
