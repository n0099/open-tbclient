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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.zq1;
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
/* loaded from: classes8.dex */
public class tw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.tw2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0488a implements zq1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File[] a;

            public C0488a(a aVar, File[] fileArr) {
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

            @Override // com.baidu.tieba.zq1.a
            public void onResult(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.contains("success")) {
                    for (File file : this.a) {
                        nm4.L(file);
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
                Bitmap p = bk3.p();
                zq1 u = rp2.u();
                kc3.d().b();
                File[] c = kc3.d().f().c();
                File b = rp2.i().b(AppRuntime.getAppContext(), k63.h0());
                if (c != null) {
                    int length = c.length;
                    fileArr = (File[]) Arrays.copyOf(c, length + 1);
                    fileArr[length] = b;
                } else {
                    fileArr = new File[]{b};
                }
                if (u != null) {
                    u.d(p, null, fileArr, new C0488a(this, fileArr));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195546, "Lcom/baidu/tieba/tw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195546, "Lcom/baidu/tieba/tw2;");
                return;
            }
        }
        a = vm1.a;
    }

    public static void a() {
        t52 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (W = xr2.V().W()) != null && W.m() != null) {
            ej3.k(new a(), "feedback error page");
        }
    }

    public static s52 f() {
        InterceptResult invokeV;
        t52 Y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            SwanAppActivity activity = xr2.V().getActivity();
            if (activity != null && (Y = activity.Y()) != null) {
                q52 m = Y.m();
                if (m instanceof s52) {
                    return (s52) m;
                }
                return null;
            }
            return null;
        }
        return (s52) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return xr2.V().getActivity().getFloatLayer().g();
        }
        return invokeV.booleanValue;
    }

    public static Rect b(Bitmap bitmap, s52 s52Var, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bitmap, s52Var, view2)) == null) {
            if (bitmap == null || s52Var == null || view2 == null) {
                return null;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int min = Math.min(iArr[0] + view2.getMeasuredWidth(), bitmap.getWidth());
            int min2 = Math.min(iArr[1] + view2.getMeasuredHeight(), bitmap.getHeight());
            SwanAppActionBar P1 = s52Var.P1();
            if (P1 == null) {
                return null;
            }
            int[] iArr2 = new int[2];
            P1.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + P1.getHeight() + 1);
            rs1 v3 = s52Var.v3();
            if (v3 != null) {
                us1 j = v3.j();
                if (j instanceof SwanAppWebViewWidget) {
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                    }
                    int J1 = ((SwanAppWebViewWidget) j).J1();
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + J1);
                    }
                    if (J1 > 0) {
                        iArr[1] = iArr[1] + J1 + 1;
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

    public static int d(s52 s52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, s52Var)) == null) {
            if (s52Var != null) {
                z63 L1 = s52Var.L1();
                if (L1 != null) {
                    return L1.e;
                }
                FrameLayout E3 = s52Var.E3();
                if (E3 != null) {
                    Drawable background = E3.getBackground();
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
                if (k63.M() != null) {
                    jSONObject.put("name", k63.M().a0());
                } else {
                    jSONObject.put("name", "UNKNOWN");
                }
                jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, rp2.o().z(AppRuntime.getAppContext()));
                jSONObject.put("net", SwanAppNetworkUtils.e());
                jSONObject.put("swaninfo", pf3.e(j63.K().k()).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        r53 floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SwanAppActivity activity = xr2.V().getActivity();
            if (activity == null || (floatLayer = activity.getFloatLayer()) == null || !(floatLayer.e() instanceof FrameLayout)) {
                return false;
            }
            return ((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView;
        }
        return invokeV.booleanValue;
    }

    public static void i(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65545, null, z, str) == null) {
            String h0 = k63.h0();
            Context activity = xr2.V().getActivity();
            if (activity == null) {
                activity = AppRuntime.getAppContext();
            }
            if (!TextUtils.isEmpty(h0)) {
                if (h0.lastIndexOf("_dev") > 0 || h0.lastIndexOf("_trial") > 0) {
                    c63 f = c63.f(activity, R.string.obfuscated_res_0x7f0f0211);
                    f.l(5);
                    f.q(3);
                    f.G();
                }
                if (z) {
                    k72 k72Var = new k72();
                    k72Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                    k72Var.d(str);
                }
            }
        }
    }
}
