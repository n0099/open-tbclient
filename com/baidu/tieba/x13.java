package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.dp2;
import com.baidu.tieba.q52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class x13 extends v13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.v13
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v13
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v13
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v13
    public iy1 m(r13 r13Var, t72<s13> t72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, r13Var, t72Var)) == null) {
            return null;
        }
        return (iy1) invokeLL.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ r13 b;
        public final /* synthetic */ q52 c;

        public a(x13 x13Var, String str, r13 r13Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x13Var, str, r13Var, q52Var};
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
            this.b = r13Var;
            this.c = q52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hw2 hw2Var = new hw2();
                hw2Var.c = this.a;
                hw2Var.b = s13.a(this.b);
                q52.b i = this.c.i("navigateTo");
                i.n(q52.g, q52.i);
                i.k("pluginFunPage", hw2Var).a();
            }
        }
    }

    public x13() {
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

    @Override // com.baidu.tieba.v13
    public iy1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new iy1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new iy1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new iy1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (iy1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v13
    public q13 f(r13 r13Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r13Var)) == null) {
            File file = null;
            if (r13Var == null) {
                return null;
            }
            String str = r13Var.a;
            String str2 = r13Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            q13 q13Var = new q13();
            q13Var.a = str;
            q13Var.b = str2;
            if (y32.d()) {
                file = dp2.f.e();
            } else if (g23.H()) {
                file = dp2.b.e();
            } else if (g23.D()) {
                file = o32.d();
            } else {
                if (TextUtils.equals(r13Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = ky1.a(str);
                    File g = dp2.g();
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
                                    z13.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            q13Var.a = str3 + i2;
                            q13Var.e = true;
                            File file2 = new File(g, q13Var.a + File.separator + i2);
                            q13Var.c = file2.getAbsolutePath();
                            q13Var.d = i2;
                            file = file2;
                        } else {
                            q13Var.e = false;
                            q13Var.c = null;
                        }
                    } else {
                        return q13Var;
                    }
                } else {
                    File file3 = new File(dp2.g(), str);
                    if (!file3.exists()) {
                        return q13Var;
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
                                    z13.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            q13Var.d = i3;
                            q13Var.e = true;
                            file = new File(file3, str5);
                            q13Var.c = file.getAbsolutePath();
                        }
                    }
                    return q13Var;
                }
            }
            if (file == null) {
                return q13Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return q13Var;
            }
            q13Var.f = true;
            q13Var.c = file4.getAbsolutePath();
            return q13Var;
        }
        return (q13) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v13
    public iy1 j(String str, r13 r13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, r13Var)) == null) {
            if (r13Var == null) {
                return new iy1(201, "pay args is null");
            }
            SwanAppActivity w = g63.K().w();
            if (w == null) {
                return new iy1(1001, "runtime exception, try reopen this app");
            }
            q52 Y = w.Y();
            if (Y == null) {
                return new iy1(1001, "runtime exception, page manager breakdown");
            }
            z13.b("jump to fun page");
            g63.M().post(new a(this, str, r13Var, Y));
            return new iy1(0);
        }
        return (iy1) invokeLL.objValue;
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
