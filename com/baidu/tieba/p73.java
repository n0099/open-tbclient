package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ib2;
import com.baidu.tieba.vu2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p73 extends n73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.n73
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n73
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n73
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n73
    public z32 m(j73 j73Var, ld2<k73> ld2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, j73Var, ld2Var)) == null) {
            return null;
        }
        return (z32) invokeLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j73 b;
        public final /* synthetic */ ib2 c;

        public a(p73 p73Var, String str, j73 j73Var, ib2 ib2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p73Var, str, j73Var, ib2Var};
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
            this.b = j73Var;
            this.c = ib2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z13 z13Var = new z13();
                z13Var.c = this.a;
                z13Var.b = k73.a(this.b);
                ib2.b i = this.c.i("navigateTo");
                i.n(ib2.g, ib2.i);
                i.k("pluginFunPage", z13Var).a();
            }
        }
    }

    public p73() {
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

    @Override // com.baidu.tieba.n73
    public z32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new z32(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new z32(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new z32(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (z32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n73
    public i73 f(j73 j73Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j73Var)) == null) {
            File file = null;
            if (j73Var == null) {
                return null;
            }
            String str = j73Var.a;
            String str2 = j73Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            i73 i73Var = new i73();
            i73Var.a = str;
            i73Var.b = str2;
            if (q92.d()) {
                file = vu2.f.e();
            } else if (y73.H()) {
                file = vu2.b.e();
            } else if (y73.D()) {
                file = g92.d();
            } else {
                if (TextUtils.equals(j73Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = b42.a(str);
                    File g = vu2.g();
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
                                    r73.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            i73Var.a = str3 + i2;
                            i73Var.e = true;
                            File file2 = new File(g, i73Var.a + File.separator + i2);
                            i73Var.c = file2.getAbsolutePath();
                            i73Var.d = i2;
                            file = file2;
                        } else {
                            i73Var.e = false;
                            i73Var.c = null;
                        }
                    } else {
                        return i73Var;
                    }
                } else {
                    File file3 = new File(vu2.g(), str);
                    if (!file3.exists()) {
                        return i73Var;
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
                                    r73.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            i73Var.d = i3;
                            i73Var.e = true;
                            file = new File(file3, str5);
                            i73Var.c = file.getAbsolutePath();
                        }
                    }
                    return i73Var;
                }
            }
            if (file == null) {
                return i73Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return i73Var;
            }
            i73Var.f = true;
            i73Var.c = file4.getAbsolutePath();
            return i73Var;
        }
        return (i73) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n73
    public z32 j(String str, j73 j73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, j73Var)) == null) {
            if (j73Var == null) {
                return new z32(201, "pay args is null");
            }
            SwanAppActivity w = yb3.K().w();
            if (w == null) {
                return new z32(1001, "runtime exception, try reopen this app");
            }
            ib2 Y = w.Y();
            if (Y == null) {
                return new z32(1001, "runtime exception, page manager breakdown");
            }
            r73.b("jump to fun page");
            yb3.M().post(new a(this, str, j73Var, Y));
            return new z32(0);
        }
        return (z32) invokeLL.objValue;
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
