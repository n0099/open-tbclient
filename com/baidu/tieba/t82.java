package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ul2;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class t82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ u82 b;
        public final /* synthetic */ v82 c;
        public final /* synthetic */ t82 d;

        public a(t82 t82Var, HybridUbcFlow hybridUbcFlow, u82 u82Var, v82 v82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t82Var, hybridUbcFlow, u82Var, v82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t82Var;
            this.a = hybridUbcFlow;
            this.b = u82Var;
            this.c = v82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp#run-start");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                String f = this.d.f(this.b.g);
                if (TextUtils.isEmpty(f)) {
                    this.c.onFailed(0);
                    return;
                }
                JSONObject d = yf3.d(f);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp#run-appInfoJson");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                PMSAppInfo l = this.d.l(this.b, d);
                if (l == null) {
                    this.c.onFailed(1);
                    return;
                }
                HybridUbcFlow hybridUbcFlow3 = this.a;
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("loadPresetApp#run-PMSAppInfo");
                ubcFlowEvent3.a(true);
                hybridUbcFlow3.F(ubcFlowEvent3);
                this.c.a(l);
                long currentTimeMillis = System.currentTimeMillis();
                boolean e = this.d.e(this.b);
                if (t82.a) {
                    Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                }
                HybridUbcFlow hybridUbcFlow4 = this.a;
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("loadPresetApp#run-doUnzipBundle");
                ubcFlowEvent4.a(true);
                hybridUbcFlow4.F(ubcFlowEvent4);
                if (e) {
                    t82 t82Var = this.d;
                    u82 u82Var = this.b;
                    l.setOrientation(t82Var.g(u82Var.h, u82Var.g, u82Var.i));
                    l.updateInstallSrc(3);
                    va4.i().a(this.b, l);
                    HybridUbcFlow hybridUbcFlow5 = this.a;
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("loadPresetApp#run-bulkInsert");
                    ubcFlowEvent5.a(true);
                    hybridUbcFlow5.F(ubcFlowEvent5);
                    this.c.b(l);
                } else {
                    this.c.onFailed(2);
                }
                HybridUbcFlow hybridUbcFlow6 = this.a;
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("loadPresetApp#run-return");
                ubcFlowEvent6.a(true);
                hybridUbcFlow6.F(ubcFlowEvent6);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948135003, "Lcom/baidu/tieba/t82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948135003, "Lcom/baidu/tieba/t82;");
                return;
            }
        }
        a = ij1.a;
    }

    public t82() {
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

    public boolean d(ReadableByteChannel readableByteChannel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, readableByteChannel, str)) == null) {
            if (readableByteChannel != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean c = lg3.c(readableByteChannel, str);
                        if (a) {
                            Log.d("PresetController", "签名校验结果：" + c + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                        return c;
                    }
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    cj4.d(readableByteChannel);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract boolean e(u82 u82Var);

    public abstract String f(String str);

    public final int g(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            if (i == 1) {
                return gm2.i().u(str, j);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public HashMap<String, u82> h() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i = i();
            if (TextUtils.isEmpty(i) || (optJSONArray = yf3.d(i).optJSONArray("list")) == null) {
                return null;
            }
            HashMap<String, u82> hashMap = new HashMap<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                u82 m = m(optJSONArray.optJSONObject(i2));
                if (m != null) {
                    hashMap.put(m.g, m);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public abstract String i();

    public File j(int i, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)})) == null) {
            if (i == 0) {
                return ul2.e.i(str, String.valueOf(j));
            }
            if (i == 1) {
                return gm2.g().a(str, String.valueOf(j));
            }
            return null;
        }
        return (File) invokeCommon.objValue;
    }

    public void k(u82 u82Var, v82 v82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, u82Var, v82Var) == null) {
            HybridUbcFlow p = dw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp-start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (v82Var == null) {
                return;
            }
            if (u82Var == null) {
                v82Var.onFailed(0);
                return;
            }
            sf3.k(new a(this, p, u82Var, v82Var), "加载小程序预置包");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp-return");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final PMSAppInfo l(u82 u82Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        PMSAppInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u82Var, jSONObject)) == null) {
            if (jSONObject == null || u82Var == null || (a2 = fg4.a(jSONObject)) == null) {
                return null;
            }
            a2.copyMainPkgInfo(u82Var);
            a2.createTime = System.currentTimeMillis();
            return a2;
        }
        return (PMSAppInfo) invokeLL.objValue;
    }

    public final u82 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        u82 u82Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            if (jSONObject == null || (u82Var = (u82) fg4.j(jSONObject, new u82())) == null) {
                return null;
            }
            u82Var.o = jSONObject.optInt("pkg_type");
            u82Var.q = jSONObject.optString("bundle_name");
            if (u82Var.a()) {
                return u82Var;
            }
            return null;
        }
        return (u82) invokeL.objValue;
    }

    public boolean n(BufferedInputStream bufferedInputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bufferedInputStream, file)) == null) {
            if (bufferedInputStream != null) {
                try {
                    if (file != null) {
                        xl2.c i = xl2.i(bufferedInputStream);
                        if ((i == null || i.b == -1) ? false : true) {
                            return xl2.d(bufferedInputStream, file, i.b).a;
                        }
                        return fj4.d(bufferedInputStream, file.getPath());
                    }
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    cj4.d(bufferedInputStream);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
