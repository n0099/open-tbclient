package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.os.Build;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public static boolean a(BaseFragmentActivity baseFragmentActivity, int i) {
        if (TbadkCoreApplication.m411getInst().appResponseToCmd(i)) {
            return true;
        }
        f(baseFragmentActivity);
        return false;
    }

    public static boolean a(BaseFragmentActivity baseFragmentActivity, Class<?> cls) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(cls)) {
            return true;
        }
        f(baseFragmentActivity);
        return false;
    }

    private static void f(BaseFragmentActivity baseFragmentActivity) {
        if (baseFragmentActivity != null) {
            if (Build.VERSION.SDK_INT <= 10) {
                baseFragmentActivity.showToast(t.j.plugin_not_exit_for_2_3);
            } else {
                baseFragmentActivity.showToast(t.j.plugin_not_exit);
            }
        }
    }
}
