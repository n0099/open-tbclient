package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.os.Build;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class a {
    public static boolean a(BaseFragmentActivity baseFragmentActivity, int i) {
        if (TbadkCoreApplication.getInst().appResponseToCmd(i)) {
            return true;
        }
        d(baseFragmentActivity);
        return false;
    }

    public static boolean a(BaseFragmentActivity baseFragmentActivity, Class<?> cls) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(cls)) {
            return true;
        }
        d(baseFragmentActivity);
        return false;
    }

    private static void d(BaseFragmentActivity baseFragmentActivity) {
        if (baseFragmentActivity != null) {
            if (Build.VERSION.SDK_INT <= 10) {
                baseFragmentActivity.showToast(f.j.plugin_not_exit_for_2_3);
            } else {
                baseFragmentActivity.showToast(f.j.plugin_not_exit);
            }
        }
    }
}
