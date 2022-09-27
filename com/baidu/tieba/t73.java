package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class t73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static ContentObserver c;
    public static ContentResolver d;
    public static PackageManager e;
    public static boolean f;
    public static long g;
    public static List<r73> h;
    public static Runnable i;
    public static int j;
    public static Uri k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Handler a;

        /* renamed from: com.baidu.tieba.t73$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0422a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Uri a;
            public final /* synthetic */ a b;

            public RunnableC0422a(a aVar, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, uri};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    t73.q(this.b.a, this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Handler handler2) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, handler2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = handler2;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                super.onChange(z, uri);
                if (t73.a) {
                    Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
                }
                ExecutorUtilsExt.postOnElastic(new RunnableC0422a(this, uri), "systemScreenShot", 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Handler b;
        public final /* synthetic */ d c;

        public b(String str, Handler handler, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, handler, dVar};
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
            this.b = handler;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t73.e();
                if (t73.a) {
                    Log.d("SYSTEM_SCREENSHOT", "mCount: " + t73.j);
                }
                long j = sf3.a() ? 500L : 100L;
                if (t73.m(this.a, t73.k) || t73.j > 10) {
                    if (t73.m(this.a, t73.k) && t73.l() && !t73.o(this.a, t73.k)) {
                        for (r73 r73Var : t73.h) {
                            if (r73Var != null) {
                                r73Var.a(this.c);
                            }
                        }
                        return;
                    }
                    return;
                }
                this.b.postDelayed(t73.i, j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static String a;
        public static String[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-448915878, "Lcom/baidu/tieba/t73$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-448915878, "Lcom/baidu/tieba/t73$c;");
                    return;
                }
            }
            a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            b = new String[]{"_display_name", "_data", "date_added", "_id"};
        }

        public static boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? str != null && (str.toLowerCase().contains(StatisticConstants.SCREENSHOT) || str.contains("截屏") || str.contains("截图")) : invokeL.booleanValue;
        }

        public static boolean f(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? Math.abs(j - j2) <= 10 : invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Uri b;

        public /* synthetic */ d(String str, Long l, Uri uri, a aVar) {
            this(str, l, uri);
        }

        public d(String str, Long l, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, l, uri};
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
            l.longValue();
            this.b = uri;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948134073, "Lcom/baidu/tieba/t73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948134073, "Lcom/baidu/tieba/t73;");
                return;
            }
        }
        a = vj1.a;
        g = System.currentTimeMillis() - 10000;
        h = new ArrayList();
        j = 0;
        l = null;
        m = null;
    }

    public static /* synthetic */ int e() {
        int i2 = j;
        j = i2 + 1;
        return i2;
    }

    public static double i(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(d, uri);
                if (bitmap == null) {
                    return 0.0d;
                }
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                if (width != 0) {
                    return height / (width * 1.0d);
                }
                return 0.0d;
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeL.doubleValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return 0;
            }
            Resources resources = AppRuntime.getAppContext().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.h, EMABTest.TYPE_DIMEN, "android"));
        }
        return invokeV.intValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (!sf3.a()) {
                return TextUtils.isEmpty(str) || TextUtils.equals(m, str);
            }
            Uri uri = k;
            return uri == null || TextUtils.equals(l, uri.toString());
        }
        return invokeL.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return zo2.a().b() && System.currentTimeMillis() - b > 2000;
        }
        return invokeV.booleanValue;
    }

    public static boolean m(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, uri)) == null) {
            if (sf3.a()) {
                return n(uri);
            }
            new BitmapFactory.Options().inJustDecodeBounds = true;
            return BitmapFactory.decodeFile(str) != null;
        }
        return invokeLL.booleanValue;
    }

    public static boolean n(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                return MediaStore.Images.Media.getBitmap(d, uri) != null;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean o(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, uri)) == null) {
            Point point = new Point();
            WindowManager windowManager = (WindowManager) AppRuntime.getAppContext().getSystemService("window");
            if (windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            int j2 = point.y + j();
            int i2 = point.x;
            double d2 = (i2 != 0 ? j2 / (i2 * 1.0d) : 0.0d) * 1.2d;
            double i3 = sf3.a() ? i(uri) : 0.0d;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i5 != 0) {
                i3 = i4 / (i5 * 1.0d);
            }
            return i3 > d2;
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? Build.VERSION.SDK_INT < 23 || oh4.a(context, com.kuaishou.weapon.p0.h.i) == 0 : invokeL.booleanValue;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0157: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:44:0x0157 */
    public static void q(Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, handler, uri) == null) {
            if (uri.toString().matches(c.a + ".*")) {
                if (t() && f) {
                    g = System.currentTimeMillis();
                    return;
                }
                j = 0;
                g = System.currentTimeMillis();
                Closeable closeable2 = null;
                try {
                    try {
                        cursor = d.query(uri, c.b, null, null, "date_added DESC");
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                                    long j2 = cursor.getLong(cursor.getColumnIndex("date_added"));
                                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                                    k = uri;
                                    if (sf3.a()) {
                                        k = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex("_id")));
                                    }
                                    if (a) {
                                        Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                        Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + j2);
                                        Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + currentTimeMillis);
                                        Log.d("SYSTEM_SCREENSHOT", "imageUri: " + k.toString());
                                    }
                                    if (k(string)) {
                                        pj4.d(cursor);
                                        return;
                                    }
                                    l = k.toString();
                                    m = string;
                                    if (c.e(string) && c.f(currentTimeMillis, j2)) {
                                        f = true;
                                        b bVar = new b(string, handler, new d(string, Long.valueOf(j2), k, null));
                                        i = bVar;
                                        handler.post(bVar);
                                    } else {
                                        f = false;
                                    }
                                }
                            } catch (RuntimeException unused) {
                                if (e != null) {
                                    List<ProviderInfo> queryContentProviders = e.queryContentProviders(null, 0, 131072);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("from", "SystemScreenshot");
                                    hashMap.put("page", "SystemScreenshot");
                                    hashMap.put("ext", queryContentProviders.toString());
                                    s93.j(BdNetTypeUtil.NATION_CODE, hashMap);
                                }
                                pj4.d(cursor);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        pj4.d(closeable2);
                        throw th;
                    }
                } catch (RuntimeException unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    pj4.d(closeable2);
                    throw th;
                }
                pj4.d(cursor);
            }
        }
    }

    public static void r(r73 r73Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, r73Var) == null) || r73Var == null) {
            return;
        }
        h.add(r73Var);
    }

    public static void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            e = context.getPackageManager();
            Handler handler = new Handler(Looper.getMainLooper());
            d = context.getContentResolver();
            c = new a(handler, handler);
            if (p(context)) {
                d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, c);
            } else if (a && fh3.G()) {
                l02.i("SYSTEM_SCREENSHOT", "WRITE_EXTERNAL_STORAGE permission denied");
            }
        }
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? System.currentTimeMillis() - g <= 1000 : invokeV.booleanValue;
    }

    public static void u(r73 r73Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, r73Var) == null) || r73Var == null) {
            return;
        }
        h.remove(r73Var);
    }
}
