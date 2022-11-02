package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.an2;
import com.baidu.tieba.n32;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uz2 extends sz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sz2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sz2
    public ew1 m(oz2 oz2Var, q52<pz2> q52Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, oz2Var, q52Var)) == null) {
            return null;
        }
        return (ew1) invokeLL.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ oz2 b;
        public final /* synthetic */ n32 c;

        public a(uz2 uz2Var, String str, oz2 oz2Var, n32 n32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz2Var, str, oz2Var, n32Var};
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
            this.b = oz2Var;
            this.c = n32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                eu2 eu2Var = new eu2();
                eu2Var.c = this.a;
                eu2Var.b = pz2.a(this.b);
                n32.b i = this.c.i("navigateTo");
                i.n(n32.g, n32.i);
                i.k("pluginFunPage", eu2Var).a();
            }
        }
    }

    public uz2() {
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

    @Override // com.baidu.tieba.sz2
    public ew1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new ew1(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new ew1(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new ew1(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (ew1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public nz2 f(oz2 oz2Var) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oz2Var)) == null) {
            File file = null;
            if (oz2Var == null) {
                return null;
            }
            String str = oz2Var.a;
            String str2 = oz2Var.c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            nz2 nz2Var = new nz2();
            nz2Var.a = str;
            nz2Var.b = str2;
            if (v12.d()) {
                file = an2.f.e();
            } else if (d03.H()) {
                file = an2.b.e();
            } else if (d03.D()) {
                file = l12.d();
            } else {
                if (TextUtils.equals(oz2Var.d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = gw1.a(str);
                    File g = an2.g();
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
                                    wz2.b(Log.getStackTraceString(e));
                                }
                            }
                        }
                        if (i2 > -1) {
                            nz2Var.a = str3 + i2;
                            nz2Var.e = true;
                            File file2 = new File(g, nz2Var.a + File.separator + i2);
                            nz2Var.c = file2.getAbsolutePath();
                            nz2Var.d = i2;
                            file = file2;
                        } else {
                            nz2Var.e = false;
                            nz2Var.c = null;
                        }
                    } else {
                        return nz2Var;
                    }
                } else {
                    File file3 = new File(an2.g(), str);
                    if (!file3.exists()) {
                        return nz2Var;
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
                                    wz2.b(Log.getStackTraceString(e2));
                                    i = -1;
                                }
                                if (i > i3) {
                                    str5 = str6;
                                    i3 = i;
                                }
                            }
                        }
                        if (i3 != -1) {
                            nz2Var.d = i3;
                            nz2Var.e = true;
                            file = new File(file3, str5);
                            nz2Var.c = file.getAbsolutePath();
                        }
                    }
                    return nz2Var;
                }
            }
            if (file == null) {
                return nz2Var;
            }
            File file4 = new File(file, str2);
            if (!n(file4)) {
                return nz2Var;
            }
            nz2Var.f = true;
            nz2Var.c = file4.getAbsolutePath();
            return nz2Var;
        }
        return (nz2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public ew1 j(String str, oz2 oz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, oz2Var)) == null) {
            if (oz2Var == null) {
                return new ew1(201, "pay args is null");
            }
            SwanAppActivity w = d43.K().w();
            if (w == null) {
                return new ew1(1001, "runtime exception, try reopen this app");
            }
            n32 X = w.X();
            if (X == null) {
                return new ew1(1001, "runtime exception, page manager breakdown");
            }
            wz2.b("jump to fun page");
            d43.M().post(new a(this, str, oz2Var, X));
            return new ew1(0);
        }
        return (ew1) invokeLL.objValue;
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
