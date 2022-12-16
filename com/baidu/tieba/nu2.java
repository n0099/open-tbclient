package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.so1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.nu2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0374a implements so1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File[] a;

            public C0374a(a aVar, File[] fileArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fileArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fileArr;
            }

            @Override // com.baidu.tieba.so1.a
            public void onResult(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.contains("success")) {
                    for (File file : this.a) {
                        ik4.L(file);
                    }
                }
            }
        }

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap p = vh3.p();
                so1 u = ln2.u();
                ea3.d().b();
                File[] c = ea3.d().f().c();
                File b = ln2.i().b(AppRuntime.getAppContext(), e43.g0());
                if (c != null) {
                    int length = c.length;
                    fileArr = (File[]) Arrays.copyOf(c, length + 1);
                    fileArr[length] = b;
                } else {
                    fileArr = new File[]{b};
                }
                if (u != null) {
                    u.d(p, null, fileArr, new C0374a(this, fileArr));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948014878, "Lcom/baidu/tieba/nu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948014878, "Lcom/baidu/tieba/nu2;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void a() {
        n32 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (V = rp2.U().V()) != null && V.m() != null) {
            yg3.k(new a(), "feedback error page");
        }
    }

    public static m32 f() {
        InterceptResult invokeV;
        n32 X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            SwanAppActivity activity = rp2.U().getActivity();
            if (activity != null && (X = activity.X()) != null) {
                k32 m = X.m();
                if (m instanceof m32) {
                    return (m32) m;
                }
                return null;
            }
            return null;
        }
        return (m32) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return rp2.U().getActivity().d().f();
        }
        return invokeV.booleanValue;
    }

    public static Rect b(Bitmap bitmap, m32 m32Var, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bitmap, m32Var, view2)) == null) {
            if (bitmap == null || m32Var == null || view2 == null) {
                return null;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int min = Math.min(iArr[0] + view2.getMeasuredWidth(), bitmap.getWidth());
            int min2 = Math.min(iArr[1] + view2.getMeasuredHeight(), bitmap.getHeight());
            SwanAppActionBar K1 = m32Var.K1();
            if (K1 == null) {
                return null;
            }
            int[] iArr2 = new int[2];
            K1.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + K1.getHeight() + 1);
            kq1 o3 = m32Var.o3();
            if (o3 != null) {
                nq1 k = o3.k();
                if (k instanceof SwanAppWebViewWidget) {
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                    }
                    int M1 = ((SwanAppWebViewWidget) k).M1();
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + M1);
                    }
                    if (M1 > 0) {
                        iArr[1] = iArr[1] + M1 + 1;
                    }
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget newY=" + iArr[1]);
                    }
                }
            }
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return (Rect) invokeLLL.objValue;
    }

    public static String c(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitmap)) == null) {
            if (bitmap == null) {
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        }
        return (String) invokeL.objValue;
    }

    public static int d(m32 m32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, m32Var)) == null) {
            if (m32Var != null) {
                t43 G1 = m32Var.G1();
                if (G1 != null) {
                    return G1.e;
                }
                FrameLayout x3 = m32Var.x3();
                if (x3 != null) {
                    Drawable background = x3.getBackground();
                    if (background instanceof ColorDrawable) {
                        return ((ColorDrawable) background).getColor();
                    }
                    return -1;
                }
                return -1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (e43.M() != null) {
                    jSONObject.put("name", e43.M().Z());
                } else {
                    jSONObject.put("name", RomUtils.UNKNOWN);
                }
                jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, ln2.o().z(AppRuntime.getAppContext()));
                jSONObject.put("net", SwanAppNetworkUtils.e());
                jSONObject.put("swaninfo", jd3.e(d43.K().k()).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        l33 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SwanAppActivity activity = rp2.U().getActivity();
            if (activity == null || (d = activity.d()) == null || !(d.d() instanceof FrameLayout)) {
                return false;
            }
            return ((FrameLayout) d.d()).getChildAt(0) instanceof LoadingView;
        }
        return invokeV.booleanValue;
    }

    public static void i(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65545, null, z, str) == null) {
            String g0 = e43.g0();
            Context activity = rp2.U().getActivity();
            if (activity == null) {
                activity = AppRuntime.getAppContext();
            }
            if (!TextUtils.isEmpty(g0)) {
                if (g0.lastIndexOf("_dev") > 0 || g0.lastIndexOf("_trial") > 0) {
                    w33 f = w33.f(activity, R.string.obfuscated_res_0x7f0f01dd);
                    f.l(5);
                    f.q(3);
                    f.G();
                }
                if (z) {
                    e52 e52Var = new e52();
                    e52Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                    e52Var.d(str);
                }
            }
        }
    }
}
