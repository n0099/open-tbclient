package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class PersonInfoActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002003, new bk());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, String str3, String str4) {
        if (str != null && str.length() > 0 && !str.equals("0") && !str.startsWith("-")) {
            Intent intent = new Intent(context, PersonInfoActivity.class);
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().equals(str)) {
                intent.putExtra("self", true);
            } else {
                intent.putExtra("self", false);
            }
            intent.putExtra("un", str);
            intent.putExtra("name", str2);
            intent.putExtra("from_forum", str3);
            intent.putExtra("st_type", str4);
            intent.putExtra("tab_page", false);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }
}
