package com.baidu.tieba;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class p25 {
    public static /* synthetic */ Interceptable $ic;
    public static final p25 a;
    public static final SharedPreferences b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948010166, "Lcom/baidu/tieba/p25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948010166, "Lcom/baidu/tieba/p25;");
                return;
            }
        }
        a = new p25();
        b = TbadkCoreApplication.getInst().getSharedPreferences("new_frequency_strategy_helper_sp", 0);
    }

    public p25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final int a(String dialogName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dialogName)) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            String str = "";
            String string = b.getString(c(dialogName), "");
            if (string != null) {
                str = string;
            }
            if (StringUtils.isNotNull(str)) {
                return e(str, "count");
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final int b(String dialogName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogName)) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            String str = "";
            String string = b.getString(c(dialogName), "");
            if (string != null) {
                str = string;
            }
            if (StringUtils.isNotNull(str)) {
                return e(str, "version");
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return SharedPrefHelper.getSharedPrefKeyWithAccount("KEY_NEW_FREQUENCE_DIALOG_STRATEGY_COUNTER") + '_' + str;
        }
        return (String) invokeL.objValue;
    }

    public final String d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            return StringsKt__IndentKt.trimIndent("\n        {\"version\":" + i + ",\"count\":" + i2 + "}\n    ");
        }
        return (String) invokeII.objValue;
    }

    public final void g(String dialogName, int i) {
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, dialogName, i) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            String c = c(dialogName);
            if (StringUtils.isNull(b.getString(c, ""))) {
                d = d(i, 1);
            } else {
                d = d(i, a(dialogName) + 1);
            }
            SharedPreferences.Editor edit = b.edit();
            edit.putString(c, d);
            edit.apply();
        }
    }

    public final int e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            try {
                return new JSONObject(str).optInt(str2);
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    TbLog yunDialogLog = YunDialogLog.getInstance();
                    yunDialogLog.e(YunDialogManager.LOG_KEY, "读取缓存频次json失败" + e.getMessage());
                    e.printStackTrace();
                    return 0;
                }
                throw e;
            }
        }
        return invokeLL.intValue;
    }

    public final void f(String dialogName, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, dialogName, i) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            TbLog yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.i(YunDialogManager.LOG_KEY, "重置弹窗 " + dialogName + " 的本地频次记录");
            String c = c(dialogName);
            SharedPreferences.Editor edit = b.edit();
            edit.putString(c, a.d(i, 0));
            edit.apply();
        }
    }
}
