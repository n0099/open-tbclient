package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.arch.utils.MiniScreenOrientationCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bh3;
import com.baidu.tieba.i33;
import com.baidu.tieba.s32;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class yh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static Handler b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface g {
        void a(boolean z);

        void onCancel();
    }

    /* loaded from: classes6.dex */
    public static class b implements no3<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ int b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ b b;

            public a(b bVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.setImageBitmap(this.a);
                }
            }
        }

        /* renamed from: com.baidu.tieba.yh3$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0480b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0480b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.a;
                    bVar.a.setImageResource(bVar.b);
                }
            }
        }

        public b(ImageView imageView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.no3
        /* renamed from: a */
        public void run(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                if (bitmap != null) {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        this.a.setImageBitmap(bitmap);
                        return;
                    } else {
                        yh3.e0(new a(this, bitmap));
                        return;
                    }
                }
                yh3.e0(new RunnableC0480b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ int b;

        public a(ImageView imageView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setImageResource(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements bh3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ no3 a;

        public c(no3 no3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {no3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = no3Var;
        }

        @Override // com.baidu.tieba.bh3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                this.a.run(bitmap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh3.b a;
        public final /* synthetic */ String b;

        public d(bh3.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.b = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                this.a.a(this.b, null);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                this.a.a(this.b, null);
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        this.a.a(this.b, copy);
                        return;
                    } catch (Exception unused) {
                        this.a.a(this.b, null);
                        return;
                    }
                }
                this.a.a(this.b, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ Intent b;
        public final /* synthetic */ String c;
        public final /* synthetic */ g d;

        public e(Context context, Intent intent, String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent, str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = intent;
            this.c = str;
            this.d = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                boolean b = ln2.a().b(this.a, this.b, d43.K().q().O(), this.c, null);
                g gVar = this.d;
                if (gVar != null) {
                    gVar.a(b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            g gVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && (gVar = this.a) != null) {
                gVar.onCancel();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948330117, "Lcom/baidu/tieba/yh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948330117, "Lcom/baidu/tieba/yh3;");
                return;
            }
        }
        a = ok1.a;
        b = new Handler(Looper.getMainLooper());
    }

    public static String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            m32 H = rp2.U().H();
            if (H != null) {
                return H.t3();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                Application c2 = ln2.c();
                return c2.getPackageManager().getPackageInfo(c2.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            qp1 n = ln2.n();
            return TextUtils.equals(n.getAppName(), n.getSchemeHeader());
        }
        return invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return I(rp2.U().T());
        }
        return invokeV.booleanValue;
    }

    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (Build.VERSION.SDK_INT < 23 || AppRuntime.getAppContext().checkSelfPermission(com.kuaishou.weapon.p0.h.g) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return rg3.g();
        }
        return invokeV.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            s32.d b3 = s32.b3("https://baozhang.baidu.com/guarantee/m/#/swan-guarantee");
            b3.a(false);
            b3.b();
        }
    }

    public static Handler q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) {
            return b;
        }
        return (Handler) invokeV.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) {
            return z(Integer.MAX_VALUE);
        }
        return (String) invokeV.objValue;
    }

    public static Uri A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("tel:")) {
                return Uri.parse(str);
            }
            return null;
        }
        return (Uri) invokeL.objValue;
    }

    public static boolean I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && TextUtils.equals(str, p())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean N(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        return invokeL.booleanValue;
    }

    public static boolean V(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.isWifiEnabled();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void a0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, runnable) == null) {
            b0(runnable, 0L);
        }
    }

    public static void d0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, runnable) == null) {
            b.removeCallbacks(runnable);
        }
    }

    public static void e0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, runnable) == null) {
            f0(runnable, 0L);
        }
    }

    public static void g0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, runnable) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                b.postAtFrontOfQueue(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static View m(String str) {
        InterceptResult invokeL;
        lq1 r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            mq1 A = rp2.U().A(str);
            if (A == null || (r = A.r()) == null) {
                return null;
            }
            return r.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    public static int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static Uri C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith("res:/")) {
                if (!str.startsWith("/")) {
                    return null;
                }
                return Uri.fromFile(new File(str));
            }
            return Uri.parse(str);
        }
        return (Uri) invokeL.objValue;
    }

    public static boolean J(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(activity);
                Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isFixedOrientation", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
                if (!a) {
                    return false;
                }
                Log.e("SwanAppUtils", "isFixedOrientation reflect fail", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean T(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            Application c2 = ln2.c();
            if (c2 == null) {
                return false;
            }
            String str = c2.getString(R.string.obfuscated_res_0x7f0f12b8) + "\n" + c2.getString(i);
            if (!ln2.y0().d()) {
                return false;
            }
            w33 g2 = w33.g(c2, str);
            g2.l(4);
            g2.F();
            return true;
        }
        return invokeI.booleanValue;
    }

    @Nullable
    public static String f(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                } else {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static synchronized String l(Context context) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            synchronized (yh3.class) {
                try {
                    string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                } catch (Exception e2) {
                    if (a) {
                        Log.e("SwanAppUtils", e2.toString());
                        return "";
                    }
                    return "";
                }
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65595, null, i)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (i2 >= i) {
                        break;
                    }
                    if (stackTraceElement != null) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i2++;
                    }
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public static boolean E(String str) {
        InterceptResult invokeL;
        SwanAppConfigData Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            d43 K = d43.K();
            if (!K.E() || (Q = K.q().Q()) == null || !Q.n() || TextUtils.isEmpty(str)) {
                return false;
            }
            return Q.r(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean K(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ((LocationManager) context.getSystemService("location")).isLocationEnabled();
            }
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "location_mode") == 0) {
                    return false;
                }
                return true;
            } catch (Settings.SettingNotFoundException e2) {
                if (a) {
                    Log.d("SwanAppUtils", Log.getStackTraceString(e2));
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean L(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (!ih3.j(context, com.kuaishou.weapon.p0.h.g)) {
                return false;
            }
            try {
                LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                if (locationManager != null) {
                    return locationManager.isProviderEnabled("gps");
                }
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String s(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, file)) == null) {
            String t = ik4.t(file.getPath());
            if (TextUtils.isEmpty(t)) {
                return "*/*";
            }
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(t);
            if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                return "*/*";
            }
            return mimeTypeFromExtension;
        }
        return (String) invokeL.objValue;
    }

    public static File x(e43 e43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, e43Var)) == null) {
            if (e43Var == null) {
                return null;
            }
            String appId = e43Var.getAppId();
            String v1 = e43Var.W().v1();
            File g2 = an2.g();
            return new File(g2, appId + File.separator + v1);
        }
        return (File) invokeL.objValue;
    }

    public static boolean F(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                        return true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    if (a) {
                        Log.e("SwanAppUtils", str + " is not found");
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean P() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (e43.b0() == null) {
                return false;
            }
            PMSAppInfo f0 = e43.b0().W().f0();
            if (f0 == null) {
                i = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
            } else {
                i = f0.payProtected;
            }
            if (i != PMSConstants.PayProtected.PAY_PROTECTED.type) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean Q() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (e43.b0() == null) {
                return false;
            }
            PMSAppInfo f0 = e43.b0().W().f0();
            if (f0 == null) {
                i = PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type;
            } else {
                i = f0.customerService;
            }
            if (i != PMSConstants.CustomerService.CUSTOMER_SERVICE.type) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            if (a) {
                Log.d("SwanAppSlavePool", "onPreloadNextEnv()");
            }
            SwanAppActivity activity = rp2.U().getActivity();
            if (activity != null) {
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "2");
                activity.s0(bundle);
                ja2.n(activity);
            }
        }
    }

    public static eu2 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            eu2 eu2Var = new eu2();
            eu2Var.b = "";
            eu2Var.a = "";
            n32 V = rp2.U().V();
            if (V != null && V.o() != null) {
                return V.o().m3();
            }
            return eu2Var;
        }
        return (eu2) invokeV.objValue;
    }

    public static eu2 v() {
        InterceptResult invokeV;
        eu2 r3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            eu2 eu2Var = new eu2();
            eu2Var.b = "";
            eu2Var.a = "";
            n32 V = rp2.U().V();
            if (V != null && V.o() != null && (r3 = V.o().r3()) != null) {
                return r3;
            }
            return eu2Var;
        }
        return (eu2) invokeV.objValue;
    }

    public static boolean S(@NonNull kq1<?> kq1Var, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, kq1Var, str)) == null) {
            int Q = kq1Var.Q();
            if (a) {
                Log.d("SwanAppUtils", "slave type - " + Q);
                Log.d("SwanAppUtils", "page viewModel type - " + str);
            }
            boolean z = false;
            if (Q != 0) {
                if (Q == 1) {
                    z = TextUtils.equals(str, "na");
                }
            } else {
                z = !TextUtils.equals(str, "na");
            }
            if (a) {
                Log.d("SwanAppUtils", "accept - " + z);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean W(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                String decode = Uri.decode(str);
                try {
                    Intent parseUri = Intent.parseUri(decode, 1);
                    parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) != null && ln2.a().d()) {
                        return ln2.a().b(context, parseUri, d43.K().q().O(), decode, null);
                    }
                } catch (URISyntaxException e2) {
                    if (a) {
                        Log.w("SwanAppUtils", Log.getStackTraceString(e2));
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.w("SwanAppUtils", "openUrl && downloadUrl is empty");
                    return null;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder(SchemeConfig.getSchemeHead());
            sb.append("://v26/swan/openApp?upgrade=0");
            try {
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                jSONObject.put("open", str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                jSONObject.put("download", str2);
                sb.append("&params=");
                sb.append(URLEncoder.encode(jSONObject.toString(), IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException | JSONException e2) {
                if (a) {
                    Log.w("SwanAppUtils", Log.getStackTraceString(e2));
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String w(e43 e43Var, String str) {
        InterceptResult invokeLL;
        File x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, e43Var, str)) == null) {
            if (e43Var == null || TextUtils.isEmpty(str) || (x = x(e43Var)) == null) {
                return null;
            }
            if (str.startsWith(File.separator)) {
                return new File(x, str).getPath();
            }
            String T = rp2.U().T();
            if (TextUtils.isEmpty(T)) {
                return null;
            }
            File parentFile = new File(T).getParentFile();
            if (parentFile == null || TextUtils.isEmpty(parentFile.getPath())) {
                parentFile = new File(File.separator);
            }
            try {
                return new File(x, new File(parentFile, str).getCanonicalPath()).getPath();
            } catch (IOException e2) {
                if (a) {
                    Log.d("SwanAppUtils", Log.getStackTraceString(e2));
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean U(Activity activity) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, activity)) == null) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$styleable");
                Field declaredField = cls.getDeclaredField("Window");
                declaredField.setAccessible(true);
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
                Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
                declaredField3.setAccessible(true);
                Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
                declaredField4.setAccessible(true);
                boolean z2 = obtainStyledAttributes.getBoolean(((Integer) declaredField2.get(null)).intValue(), false);
                if (!obtainStyledAttributes.hasValue(((Integer) declaredField2.get(null)).intValue()) && obtainStyledAttributes.getBoolean(((Integer) declaredField3.get(null)).intValue(), false)) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z3 = obtainStyledAttributes.getBoolean(((Integer) declaredField4.get(null)).intValue(), false);
                obtainStyledAttributes.recycle();
                if (!z3 && !z2 && !z) {
                    return false;
                }
                return true;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                if (a) {
                    Log.e("SwanAppUtils", "isTranslucentOrFloating reflect fail", e2);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int c0(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, activity)) == null) {
            if (a) {
                Log.d(MiniScreenOrientationCompat.TAG, "releaseFixedOrientation() called with: activity = [" + activity + PreferencesUtil.RIGHT_MOUNT);
            }
            int i = -1;
            if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !U(activity) || !J(activity)) {
                return -1;
            }
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(activity);
                Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
                declaredField2.setAccessible(true);
                int i2 = declaredField2.getInt(obj);
                if (i2 != -1) {
                    try {
                        declaredField2.setInt(obj, -1);
                        if (a) {
                            Log.d(MiniScreenOrientationCompat.TAG, "set " + activity.getComponentName() + " screenOrientation to UNSPECIFIED");
                        }
                    } catch (IllegalAccessException | NoSuchFieldException e2) {
                        e = e2;
                        i = i2;
                        if (a) {
                            Log.e("SwanAppUtils", "releaseFixedOrientation reflect fail", e);
                            return i;
                        }
                        return i;
                    }
                }
                return i2;
            } catch (IllegalAccessException e3) {
                e = e3;
            } catch (NoSuchFieldException e4) {
                e = e4;
            }
        } else {
            return invokeL.intValue;
        }
    }

    @AnyThread
    public static void X(@NonNull ImageView imageView, @Nullable String str, @DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65560, null, imageView, str, i) == null) {
            if (TextUtils.isEmpty(str)) {
                e0(new a(imageView, i));
                return;
            }
            b bVar = new b(imageView, i);
            bVar.run(k(str, str, false, new c(bVar)));
        }
    }

    public static boolean Z(Context context, String str, g gVar) {
        InterceptResult invokeLLL;
        boolean z;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, context, str, gVar)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    PackageManager packageManager = context.getPackageManager();
                    ResolveInfo resolveActivity = packageManager.resolveActivity(parseUri, 65536);
                    if (resolveActivity != null && resolveActivity.activityInfo != null && ln2.a().d()) {
                        if (resolveActivity.match != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            str2 = resolveActivity.activityInfo.applicationInfo.loadLabel(packageManager).toString();
                        } else {
                            str2 = "其他应用";
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str3 = "";
                        } else {
                            str3 = context.getResources().getString(R.string.obfuscated_res_0x7f0f132a) + str2;
                        }
                        String str4 = context.getResources().getString(R.string.obfuscated_res_0x7f0f1329) + packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() + str3;
                        String string = context.getString(R.string.obfuscated_res_0x7f0f011a);
                        String string2 = context.getString(R.string.obfuscated_res_0x7f0f0112);
                        i33.a aVar = new i33.a(context);
                        aVar.f(true);
                        aVar.x(str4);
                        aVar.n(new mj3());
                        aVar.m(false);
                        aVar.P(string, new e(context, parseUri, str, gVar));
                        aVar.C(string2, new f(gVar));
                        aVar.X();
                        return true;
                    }
                    return false;
                } catch (PackageManager.NameNotFoundException | URISyntaxException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @NonNull
    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!str.endsWith(File.separator)) {
                    str = str + File.separator;
                }
                String str4 = str + str2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                if (a) {
                    Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4);
                }
                if (TextUtils.isEmpty(str3)) {
                    return wh3.w(str4);
                }
                Uri v = wh3.v(str4);
                if (v == null) {
                    return wh3.w(str4);
                }
                if (a) {
                    Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4 + str3);
                }
                return v.buildUpon().query(str3).build().toString();
            }
            return "";
        }
        return (String) invokeLLL.objValue;
    }

    public static boolean b(SwanAppConfigData swanAppConfigData, eu2 eu2Var, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65565, null, swanAppConfigData, eu2Var, z)) == null) {
            if (swanAppConfigData == null || eu2Var == null) {
                return false;
            }
            if (lz2.k(eu2Var.e())) {
                return true;
            }
            if (a) {
                Log.d("SwanAppUtils", "checkPageParam pageParam : " + eu2Var.a);
                Log.d("SwanAppUtils", "checkPageParam pageRouteParam : " + eu2Var.d);
                Log.d("SwanAppUtils", "checkPageParam allowTab : " + z);
            }
            if (z) {
                if (!swanAppConfigData.p(eu2Var.d) && !swanAppConfigData.r(eu2Var.d)) {
                    return false;
                }
                return true;
            } else if (!swanAppConfigData.p(eu2Var.d) || swanAppConfigData.r(eu2Var.d)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static void b0(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65566, null, runnable, j) == null) {
            b.postDelayed(runnable, j);
        }
    }

    public static boolean c(SwanAppConfigData swanAppConfigData, eu2 eu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, swanAppConfigData, eu2Var)) == null) {
            if (swanAppConfigData == null || !swanAppConfigData.n() || !swanAppConfigData.r(eu2Var.d)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void f0(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65574, null, runnable, j) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                b.postDelayed(runnable, j);
            } else {
                runnable.run();
            }
        }
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static PackageInfo t(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            try {
                return context.getPackageManager().getPackageInfo(str, 64);
            } catch (PackageManager.NameNotFoundException e2) {
                if (!a) {
                    return null;
                }
                Log.w("SwanAppUtils", e2.getMessage());
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static String u(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65590, null, context, str)) == null) {
            PackageInfo t = t(context, str);
            if (t != null) {
                return t.versionName;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (a) {
                Log.i("SwanAppUtils", "downloadParams is " + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                    return false;
                }
                return ln2.d().f(context, jSONObject);
            } catch (JSONException e2) {
                if (!a) {
                    return false;
                }
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void g(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65575, null, activity, i) == null) {
            if (a) {
                Log.d(MiniScreenOrientationCompat.TAG, "fixedOrientation() called with: activity = [" + activity + "], orientation = [" + i + PreferencesUtil.RIGHT_MOUNT);
            }
            if (i != -1 && Build.VERSION.SDK_INT == 26 && activity.getApplicationInfo().targetSdkVersion > 26 && U(activity) && !J(activity)) {
                try {
                    Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(activity);
                    Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
                    declaredField2.setAccessible(true);
                    if (declaredField2.getInt(obj) == -1) {
                        declaredField2.setInt(obj, i);
                        if (a) {
                            Log.d(MiniScreenOrientationCompat.TAG, "set " + activity.getComponentName() + " screenOrientation to " + i);
                        }
                    }
                } catch (IllegalAccessException | NoSuchFieldException e2) {
                    if (a) {
                        Log.e("SwanAppUtils", "isTranslucentOrFloating reflect fail", e2);
                    }
                }
            }
        }
    }

    public static Bitmap i(bp2 bp2Var, String str, boolean z) {
        InterceptResult invokeLLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65578, null, bp2Var, str, z)) == null) {
            if (bp2Var != null && !TextUtils.isEmpty(bp2Var.Q())) {
                str2 = bp2Var.Q();
            } else {
                str2 = "";
            }
            return j(str2, str, z);
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    public static Bitmap j(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65579, null, str, str2, z)) == null) {
            return k(str, str2, z, null);
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    public static Bitmap k(String str, String str2, boolean z, bh3.b bVar) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65580, null, new Object[]{str, str2, Boolean.valueOf(z), bVar})) == null) {
            Uri C = C(str);
            if (bh3.d(C)) {
                return bh3.c(C, AppRuntime.getAppContext());
            }
            if (C != null) {
                if (bVar != null) {
                    Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new d(bVar, str), UiThreadImmediateExecutorService.getInstance());
                } else {
                    bh3.f(C, str2);
                }
            }
            Resources resources = AppRuntime.getAppContext().getResources();
            if (z) {
                i = R.drawable.obfuscated_res_0x7f080140;
            } else {
                i = R.drawable.obfuscated_res_0x7f08013f;
            }
            return BitmapFactory.decodeResource(resources, i);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    @Nullable
    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            e43 b0 = e43.b0();
            if (b0 == null) {
                return null;
            }
            String e0 = b0.W().e0();
            if (TextUtils.isEmpty(e0)) {
                return rp2.U().g();
            }
            int lastIndexOf = e0.lastIndexOf("?");
            if (lastIndexOf > 0) {
                e0 = e0.substring(0, lastIndexOf);
            }
            if (e0.startsWith(File.separator)) {
                return e0.substring(1);
            }
            return e0;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                if (a) {
                    Log.d("SwanAppUtils", "android 29 can not get imei");
                }
                return "";
            } else if (!TextUtils.isEmpty(c)) {
                if (a) {
                    Log.d("SwanAppUtils", "imei hit cache");
                }
                return c;
            } else {
                Application c2 = ln2.c();
                if (ContextCompat.checkSelfPermission(c2, com.kuaishou.weapon.p0.h.c) != 0) {
                    return "";
                }
                String str = null;
                if (c2.getSystemService("phone") == null) {
                    return "";
                }
                str = jp3.b.getDeviceId(c2);
                if (!TextUtils.isEmpty(str)) {
                    c = str;
                    return str;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    String d2 = jp3.b.d(c2);
                    if (!TextUtils.isEmpty(d2)) {
                        c = d2;
                        return d2;
                    }
                    str = jp3.b.c(c2);
                    c = str;
                }
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                return str;
            }
        }
        return (String) invokeV.objValue;
    }
}
