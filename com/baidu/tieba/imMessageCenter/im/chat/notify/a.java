package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.os.Build;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    public static boolean a(BaseFragmentActivity baseFragmentActivity, int i) {
        if (TbadkCoreApplication.getInst().appResponseToCmd(i)) {
            return true;
        }
        f(baseFragmentActivity);
        return false;
    }

    public static boolean a(BaseFragmentActivity baseFragmentActivity, Class<?> cls) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(cls)) {
            return true;
        }
        f(baseFragmentActivity);
        return false;
    }

    private static void f(BaseFragmentActivity baseFragmentActivity) {
        if (baseFragmentActivity != null) {
            if (Build.VERSION.SDK_INT <= 10) {
                baseFragmentActivity.showToast(d.j.plugin_not_exit_for_2_3);
            } else {
                baseFragmentActivity.showToast(d.j.plugin_not_exit);
            }
        }
    }
}
