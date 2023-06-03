package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.hb2;
import com.baidu.tieba.uu2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o73 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.m73
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m73
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m73
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m73
    public y32 m(i73 i73Var, kd2<j73> kd2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, i73Var, kd2Var)) == null) {
            return null;
        }
        return (y32) invokeLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ i73 b;
        public final /* synthetic */ hb2 c;

        public a(o73 o73Var, String str, i73 i73Var, hb2 hb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o73Var, str, i73Var, hb2Var};
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
            this.b = i73Var;
            this.c = hb2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y13 y13Var = new y13();
                y13Var.c = this.a;
                y13Var.b = j73.a(this.b);
                hb2.b i = this.c.i("navigateTo");
                i.n(hb2.g, hb2.i);
                i.k("pluginFunPage", y13Var).a();
            }
        }
    }

    public o73() {
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

    @Override // com.baidu.tieba.m73
    public y32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new y32(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new y32(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new y32(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (y32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m73
    public h73 f(i73 i73Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i73Var)) == null) {
            File file = null;
            if (i73Var == null) {
                return null;
            }
            String str = i73Var.a;
            String str2 = i73Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            h73 h73Var = new h73();
            h73Var.a = str;
            h73Var.b = str2;
            if (p92.d()) {
                file = uu2.f.e();
            } else if (x73.H()) {
                file = uu2.b.e();
            } else if (x73.D()) {
                file = f92.d();
            } else {
                if (TextUtils.equals(i73Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = a42.a(str);
                    File g = uu2.g();
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
                                    q73.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            h73Var.a = str3 + i2;
                            h73Var.e = true;
                            File file2 = new File(g, h73Var.a + File.separator + i2);
                            h73Var.c = file2.getAbsolutePath();
                            h73Var.d = i2;
                            file = file2;
                        } else {
                            h73Var.e = false;
                            h73Var.c = null;
                        }
                    } else {
                        return h73Var;
                    }
                } else {
                    File file3 = new File(uu2.g(), str);
                    if (!file3.exists()) {
                        return h73Var;
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
                                    q73.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            h73Var.d = i3;
                            h73Var.e = true;
                            file = new File(file3, str5);
                            h73Var.c = file.getAbsolutePath();
                        }
                    }
                    return h73Var;
                }
            }
            if (file == null) {
                return h73Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return h73Var;
            }
            h73Var.f = true;
            h73Var.c = file4.getAbsolutePath();
            return h73Var;
        }
        return (h73) invokeL.objValue;
    }

    @Override // com.baidu.tieba.m73
    public y32 j(String str, i73 i73Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, i73Var)) == null) {
            if (i73Var == null) {
                return new y32(201, "pay args is null");
            }
            SwanAppActivity w = xb3.K().w();
            if (w == null) {
                return new y32(1001, "runtime exception, try reopen this app");
            }
            hb2 Y = w.Y();
            if (Y == null) {
                return new y32(1001, "runtime exception, page manager breakdown");
            }
            q73.b("jump to fun page");
            xb3.M().post(new a(this, str, i73Var, Y));
            return new y32(0);
        }
        return (y32) invokeLL.objValue;
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
