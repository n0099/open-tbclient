package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vxa {
    public static /* synthetic */ Interceptable $ic = null;
    public static int c = 524288;
    public static int d = 6144000;
    public static int e = 524288;
    public transient /* synthetic */ FieldHolder $fh;
    public zxa a;
    public fp9 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948257546, "Lcom/baidu/tieba/vxa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948257546, "Lcom/baidu/tieba/vxa;");
        }
    }

    public vxa(fp9 fp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fp9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = fp9Var;
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            if (i <= 0) {
                d = 6144000;
            } else {
                d = i;
            }
        }
    }

    public static void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            if (i <= 0) {
                c = 524288;
            } else {
                c = i;
            }
        }
    }

    public static void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            if (i <= 0) {
                e = 524288;
            } else {
                e = i;
            }
        }
    }

    public void a() {
        zxa zxaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (zxaVar = this.a) != null) {
            zxaVar.cancel();
        }
    }

    public VideoFinishResult e(String str, String str2, int i, cya cyaVar) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i, cyaVar)) == null) {
            try {
                if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                    this.a = new bya(str2, e, this.b);
                } else {
                    this.a = new aya(str, c, d, this.b);
                }
                this.a.a(cyaVar);
                return this.a.b(str2, i);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                fp9 fp9Var = this.b;
                if (fp9Var != null) {
                    fp9Var.f(306, -4399, zo9.a(e2));
                    return null;
                }
                return null;
            }
        }
        return (VideoFinishResult) invokeLLIL.objValue;
    }
}
