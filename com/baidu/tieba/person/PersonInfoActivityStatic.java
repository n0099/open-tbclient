package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class PersonInfoActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001003, new ca());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, String str, String str2) {
        Intent intent;
        if (str == null || str.length() <= 0 || str.equals("0")) {
            return;
        }
        if (TbadkApplication.E() == null || !TbadkApplication.E().equals(str)) {
            intent = new Intent(context, SinglePersonInfoActivity.class);
            intent.putExtra("self", false);
        } else {
            intent = new Intent(context, SingleMyPersonInfoActivity.class);
            intent.putExtra("self", true);
        }
        intent.putExtra("un", str);
        intent.putExtra("name", str2);
        intent.putExtra("tab_page", false);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }
}
