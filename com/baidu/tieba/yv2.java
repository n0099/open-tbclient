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
import com.baidu.tieba.eq1;
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
/* loaded from: classes9.dex */
public class yv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.yv2$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0538a implements eq1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File[] a;

            public C0538a(a aVar, File[] fileArr) {
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

            @Override // com.baidu.tieba.eq1.a
            public void onResult(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.contains("success")) {
                    for (File file : this.a) {
                        sl4.L(file);
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
                Bitmap p = gj3.p();
                eq1 u = wo2.u();
                pb3.d().b();
                File[] c = pb3.d().f().c();
                File b = wo2.i().b(AppRuntime.getAppContext(), p53.h0());
                if (c != null) {
                    int length = c.length;
                    fileArr = (File[]) Arrays.copyOf(c, length + 1);
                    fileArr[length] = b;
                } else {
                    fileArr = new File[]{b};
                }
                if (u != null) {
                    u.d(p, null, fileArr, new C0538a(this, fileArr));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948343540, "Lcom/baidu/tieba/yv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948343540, "Lcom/baidu/tieba/yv2;");
                return;
            }
        }
        a = am1.a;
    }

    public static void a() {
        y42 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (W = cr2.V().W()) != null && W.m() != null) {
            ji3.k(new a(), "feedback error page");
        }
    }

    public static x42 f() {
        InterceptResult invokeV;
        y42 Y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            SwanAppActivity activity = cr2.V().getActivity();
            if (activity != null && (Y = activity.Y()) != null) {
                v42 m = Y.m();
                if (m instanceof x42) {
                    return (x42) m;
                }
                return null;
            }
            return null;
        }
        return (x42) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return cr2.V().getActivity().getFloatLayer().g();
        }
        return invokeV.booleanValue;
    }

    public static Rect b(Bitmap bitmap, x42 x42Var, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bitmap, x42Var, view2)) == null) {
            if (bitmap == null || x42Var == null || view2 == null) {
                return null;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int min = Math.min(iArr[0] + view2.getMeasuredWidth(), bitmap.getWidth());
            int min2 = Math.min(iArr[1] + view2.getMeasuredHeight(), bitmap.getHeight());
            SwanAppActionBar Q1 = x42Var.Q1();
            if (Q1 == null) {
                return null;
            }
            int[] iArr2 = new int[2];
            Q1.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + Q1.getHeight() + 1);
            wr1 v3 = x42Var.v3();
            if (v3 != null) {
                zr1 j = v3.j();
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

    public static int d(x42 x42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, x42Var)) == null) {
            if (x42Var != null) {
                e63 M1 = x42Var.M1();
                if (M1 != null) {
                    return M1.e;
                }
                FrameLayout E3 = x42Var.E3();
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
                if (p53.M() != null) {
                    jSONObject.put("name", p53.M().a0());
                } else {
                    jSONObject.put("name", "UNKNOWN");
                }
                jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, wo2.o().z(AppRuntime.getAppContext()));
                jSONObject.put("net", SwanAppNetworkUtils.e());
                jSONObject.put("swaninfo", ue3.e(o53.K().k()).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        w43 floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SwanAppActivity activity = cr2.V().getActivity();
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
            String h0 = p53.h0();
            Context activity = cr2.V().getActivity();
            if (activity == null) {
                activity = AppRuntime.getAppContext();
            }
            if (!TextUtils.isEmpty(h0)) {
                if (h0.lastIndexOf("_dev") > 0 || h0.lastIndexOf("_trial") > 0) {
                    h53 f = h53.f(activity, R.string.obfuscated_res_0x7f0f0209);
                    f.l(5);
                    f.q(3);
                    f.G();
                }
                if (z) {
                    p62 p62Var = new p62();
                    p62Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                    p62Var.d(str);
                }
            }
        }
    }
}
