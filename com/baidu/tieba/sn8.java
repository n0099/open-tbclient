package com.baidu.tieba;

import android.os.Build;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(BaseFragmentActivity baseFragmentActivity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseFragmentActivity, i)) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(i)) {
                b(baseFragmentActivity);
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void b(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, baseFragmentActivity) != null) || baseFragmentActivity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 10) {
            baseFragmentActivity.showToast(R.string.plugin_not_exit_for_2_3);
        } else {
            baseFragmentActivity.showToast(R.string.plugin_not_exit);
        }
    }
}
