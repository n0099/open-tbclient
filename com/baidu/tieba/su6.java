package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes5.dex */
public class su6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPreferences a;

    public su6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbadkCoreApplication.getInst().getSharedPreferences("frs_guide_sp", 0);
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && !"0".equals(str) && !"0".equals(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) || !a(str, str2)) {
            return;
        }
        String str3 = str + '_' + str2;
        Set<String> keySet = this.a.getAll().keySet();
        SharedPreferences.Editor edit = this.a.edit();
        for (String str4 : keySet) {
            if (str4.startsWith(str3)) {
                edit.remove(str4);
            }
        }
        edit.apply();
    }

    public long c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!a(str, str2)) {
                return 0L;
            }
            return this.a.getLong(str + '_' + str2 + "_visit_time", 0L);
        }
        return invokeLL.longValue;
    }

    public boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (!a(str, str2)) {
                return false;
            }
            return this.a.getBoolean(str + '_' + str2 + "_show", false);
        }
        return invokeLL.booleanValue;
    }

    public int e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (!a(str, str2)) {
                return 0;
            }
            return this.a.getInt(str + '_' + str2 + "_show_cnt", 0);
        }
        return invokeLL.intValue;
    }

    public long f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (!a(str, str2)) {
                return 0L;
            }
            return this.a.getLong(str + '_' + str2 + "_show_time", 0L);
        }
        return invokeLL.longValue;
    }

    public void g(String str, String str2, long j, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Long.valueOf(j), Boolean.valueOf(z)}) != null) || !a(str, str2)) {
            return;
        }
        String str3 = str + '_' + str2 + "_show_time";
        String str4 = str + '_' + str2 + "_show_cnt";
        int i = this.a.getInt(str4, 0);
        SharedPreferences.Editor edit = this.a.edit();
        if (i > 3) {
            edit.putInt(str4, i + 1);
        }
        edit.putLong(str3, j);
        if (z) {
            edit.putBoolean(str + '_' + str2 + "_show", true);
        }
        edit.apply();
    }

    public void h(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Long.valueOf(j)}) != null) || !a(str, str2)) {
            return;
        }
        String str3 = str + '_' + str2 + "_visit_time";
        SharedPreferences.Editor edit = this.a.edit();
        edit.putLong(str3, j);
        edit.apply();
    }
}
