package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.fn2;
import com.baidu.tieba.s32;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zz2 extends xz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xz2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xz2
    public jw1 m(tz2 tz2Var, v52<uz2> v52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, tz2Var, v52Var)) == null) {
            return null;
        }
        return (jw1) invokeLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tz2 b;
        public final /* synthetic */ s32 c;

        public a(zz2 zz2Var, String str, tz2 tz2Var, s32 s32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz2Var, str, tz2Var, s32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = tz2Var;
            this.c = s32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ju2 ju2Var = new ju2();
                ju2Var.c = this.a;
                ju2Var.b = uz2.a(this.b);
                s32.b i = this.c.i("navigateTo");
                i.n(s32.g, s32.i);
                i.k("pluginFunPage", ju2Var).a();
            }
        }
    }

    public zz2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.xz2
    public jw1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new jw1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new jw1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new jw1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (jw1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public sz2 f(tz2 tz2Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tz2Var)) == null) {
            File file = null;
            if (tz2Var == null) {
                return null;
            }
            String str = tz2Var.a;
            String str2 = tz2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            sz2 sz2Var = new sz2();
            sz2Var.a = str;
            sz2Var.b = str2;
            if (a22.d()) {
                file = fn2.f.e();
            } else if (i03.H()) {
                file = fn2.b.e();
            } else if (i03.D()) {
                file = q12.d();
            } else {
                if (TextUtils.equals(tz2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = lw1.a(str);
                    File g = fn2.g();
                    String[] list = g.list();
                    if (list != null && g.length() != 0) {
                        String str3 = a2 + "_dev";
                        int i2 = -1;
                        for (String str4 : list) {
                            if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                                try {
                                    int parseInt = Integer.parseInt(str4.substring(str3.length()));
                                    if (parseInt > i2) {
                                        i2 = parseInt;
                                    }
                                } catch (NumberFormatException e) {
                                    b03.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            sz2Var.a = str3 + i2;
                            sz2Var.e = true;
                            File file2 = new File(g, sz2Var.a + File.separator + i2);
                            sz2Var.c = file2.getAbsolutePath();
                            sz2Var.d = i2;
                            file = file2;
                        } else {
                            sz2Var.e = false;
                            sz2Var.c = null;
                        }
                    } else {
                        return sz2Var;
                    }
                } else {
                    File file3 = new File(fn2.g(), str);
                    if (!file3.exists()) {
                        return sz2Var;
                    }
                    String[] list2 = file3.list();
                    if (list2 != null && list2.length != 0) {
                        String str5 = null;
                        int i3 = -1;
                        for (String str6 : list2) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i = Integer.parseInt(str6);
                                } catch (NumberFormatException e2) {
                                    b03.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            sz2Var.d = i3;
                            sz2Var.e = true;
                            file = new File(file3, str5);
                            sz2Var.c = file.getAbsolutePath();
                        }
                    }
                    return sz2Var;
                }
            }
            if (file == null) {
                return sz2Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return sz2Var;
            }
            sz2Var.f = true;
            sz2Var.c = file4.getAbsolutePath();
            return sz2Var;
        }
        return (sz2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xz2
    public jw1 j(String str, tz2 tz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, tz2Var)) == null) {
            if (tz2Var == null) {
                return new jw1(201, "pay args is null");
            }
            SwanAppActivity w = i43.K().w();
            if (w == null) {
                return new jw1(1001, "runtime exception, try reopen this app");
            }
            s32 X = w.X();
            if (X == null) {
                return new jw1(1001, "runtime exception, page manager breakdown");
            }
            b03.b("jump to fun page");
            i43.M().post(new a(this, str, tz2Var, X));
            return new jw1(0);
        }
        return (jw1) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            if (file == null || !file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
