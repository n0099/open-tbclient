package com.baidu.tieba;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes8.dex */
public class w86 implements vw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    @Override // com.baidu.tieba.vw1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.vw1
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.vw1
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a061" : (String) invokeV.objValue;
    }

    public rr5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (rr5) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948224500, "Lcom/baidu/tieba/w86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948224500, "Lcom/baidu/tieba/w86;");
                return;
            }
        }
        b = is1.a;
    }

    public w86() {
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

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("a001");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vw1
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppBackground");
            }
            long o = l95.m().o("smart_app_tid", 0L);
            String s = l95.m().s("smart_app_id", "");
            String s2 = l95.m().s("smart_app_name", "");
            if (this.a != 0 && o != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                tr5 tr5Var = new tr5();
                tr5Var.y(currentTimeMillis);
                tr5Var.s(g());
                tr5Var.C(o);
                tr5Var.i = s;
                tr5Var.j = s2;
                tr5Var.x(h());
                ur5.b().j(true);
                ur5.b().k(TbadkApplication.getInst().getApplicationContext(), tr5Var, i());
                l95.m().A("smart_app_tid", 0L);
            }
        }
    }

    @Override // com.baidu.tieba.vw1
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppForeground" + yb3.M().b);
            }
            File file = new File(nm.b("libBaiduMapSDK.so"));
            if (file.exists() && file.isFile() && BdBaseApplication.getInst().getResHashMap().get("libBaiduMapSDK.so") == null && pm.a(BdBaseApplication.getInst().getContext(), nm.a("libBaiduMapSDK.so"))) {
                try {
                    System.loadLibrary("BaiduMapSDK");
                } catch (Throwable unused) {
                }
                BdBaseApplication.getInst().getResHashMap().put("libBaiduMapSDK.so", nm.a("libBaiduMapSDK.so"));
            }
            this.a = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.vw1
    public void d(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable vw2 vw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, swanAppActivity, i, vw2Var) == null) {
            if (b) {
                Log.e("DefaultSwanAppLifecycle", "onAppExit");
            }
            if (l95.m().i("key_ai_app_guide_display", true)) {
                Intent intent = new Intent(swanAppActivity, DealIntentService.class);
                intent.putExtra("class", 38);
                swanAppActivity.startService(intent);
            }
        }
    }
}
