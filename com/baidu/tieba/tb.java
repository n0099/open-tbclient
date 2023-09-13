package com.baidu.tieba;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class tb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public String b;
    public String c;
    public String d;

    public tb() {
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
        this.a = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.b = this.a + "/baidu/";
        this.c = null;
        this.d = null;
        try {
            this.c = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.d = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z2) {
                if (!b()) {
                    return null;
                }
                if (str != null) {
                    str3 = this.b + str + "/";
                } else {
                    str3 = this.b;
                }
            } else if (z3) {
                str2 = this.d;
                if (str2 == null) {
                    return null;
                }
                if (str != null) {
                    str3 = this.d + str + "/";
                }
                str3 = str2;
            } else {
                str2 = this.c;
                if (str2 == null) {
                    return null;
                }
                if (str != null) {
                    str3 = this.c + str + "/";
                }
                str3 = str2;
            }
            File file = new File(str3);
            if (file.exists()) {
                return str3;
            }
            if (!z || !file.mkdirs()) {
                return null;
            }
            return str3;
        }
        return (String) invokeCommon.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public File c(String str, String str2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (str2 == null || (a = a(str, z, z2, z3)) == null) {
                return null;
            }
            return new File(a + str2);
        }
        return (File) invokeCommon.objValue;
    }

    public File d(String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            String a = a(str, z, z2, z3);
            if (a == null) {
                return null;
            }
            return new File(a);
        }
        return (File) invokeCommon.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || str == null) {
            return;
        }
        this.b = this.a + "/" + str + "/";
    }
}
