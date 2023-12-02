package com.baidu.tieba;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class lu5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] g;
    public static final String[] h;
    public static final String[] i;
    public static Point j;
    public static final List<String> k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public b b;
    public long c;
    public a d;
    public a e;
    public final Handler f;

    /* loaded from: classes7.dex */
    public interface b {
        void onShot(String str);
    }

    /* loaded from: classes7.dex */
    public class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Uri a;
        public final /* synthetic */ lu5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lu5 lu5Var, Uri uri, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lu5Var, uri, handler};
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
            this.b = lu5Var;
            this.a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                this.b.i(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends nu5<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Context> a;
        public Uri b;

        public c(Context context, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uri;
            this.a = new WeakReference<>(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public Cursor doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Context context = this.a.get();
                if (context == null) {
                    return null;
                }
                try {
                    return context.getContentResolver().query(this.b, Build.VERSION.SDK_INT < 16 ? lu5.g : lu5.h, null, null, "date_added desc limit 1");
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return (Cursor) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements st5<Cursor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<lu5> a;

        public d(lu5 lu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(lu5Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Cursor cursor) {
            lu5 lu5Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cursor) != null) || (lu5Var = this.a.get()) == null) {
                return;
            }
            lu5Var.j(cursor);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955389, "Lcom/baidu/tieba/lu5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955389, "Lcom/baidu/tieba/lu5;");
                return;
            }
        }
        g = new String[]{"_data", "datetaken"};
        h = new String[]{"_data", "datetaken", "width", "height"};
        i = new String[]{StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
        k = new ArrayList();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !l()) {
            return;
        }
        if (this.d != null) {
            try {
                this.a.getContentResolver().unregisterContentObserver(this.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.d = null;
        }
        if (this.e != null) {
            try {
                this.a.getContentResolver().unregisterContentObserver(this.e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.e = null;
        }
        this.c = 0L;
        this.b = null;
    }

    public lu5(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new Handler(Looper.getMainLooper());
        this.a = context;
        if (j == null) {
            Point h2 = h();
            j = h2;
            if (h2 != null) {
                BdLog.d("ScreenShotListenManager: Screen Real Size: " + j.x + " * " + j.y);
                return;
            }
            BdLog.d("ScreenShotListenManager: Get screen real size failed.");
        }
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (k.contains(str)) {
                BdLog.d("ScreenShotListenManager: ScreenShot: imgPath has done; imagePath = " + str);
                return true;
            }
            if (k.size() >= 20) {
                for (int i2 = 0; i2 < 5; i2++) {
                    k.remove(0);
                }
            }
            k.add(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean f(String str, long j2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (j2 >= this.c && System.currentTimeMillis() - j2 <= 10000) {
                Point point = j;
                if (point != null && (i2 > point.x || i3 > point.y)) {
                    Point point2 = j;
                    if (i3 > point2.x || i2 > point2.y) {
                        return false;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String lowerCase = str.toLowerCase();
                for (String str2 : i) {
                    if (lowerCase.contains(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final Point g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new Point(options.outWidth, options.outHeight);
        }
        return (Point) invokeL.objValue;
    }

    public final void i(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
            ru5.b(new c(this.a, uri), new d(this));
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public final Point h() {
        InterceptResult invokeV;
        Exception e;
        Point point;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!l() || this.a == null) {
                return null;
            }
            try {
                point = new Point();
            } catch (Exception e2) {
                e = e2;
                point = null;
            }
            try {
                Display defaultDisplay = ((WindowManager) this.a.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay();
                if (Build.VERSION.SDK_INT >= 17) {
                    defaultDisplay.getRealSize(point);
                } else {
                    try {
                        point.set(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue());
                    } catch (Exception e3) {
                        point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                        BdLog.e(e3);
                    }
                }
            } catch (Exception e4) {
                e = e4;
                BdLog.e(e);
                return point;
            }
            return point;
        }
        return (Point) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || !l() || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        this.c = System.currentTimeMillis();
        this.d = new a(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f);
        this.e = new a(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f);
        if (Build.VERSION.SDK_INT >= 29) {
            this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.d);
            this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.e);
            return;
        }
        this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.d);
        this.a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.e);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    public final void j(Cursor cursor) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cursor) == null) {
            try {
                if (cursor == null) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                }
                if (!cursor.moveToFirst()) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                int columnIndex = cursor.getColumnIndex("_data");
                int columnIndex2 = cursor.getColumnIndex("datetaken");
                int i5 = -1;
                if (Build.VERSION.SDK_INT >= 16) {
                    i5 = cursor.getColumnIndex("width");
                    i2 = cursor.getColumnIndex("height");
                } else {
                    i2 = -1;
                }
                String string = cursor.getString(columnIndex);
                long j2 = cursor.getLong(columnIndex2);
                if (i5 >= 0 && i2 >= 0) {
                    i4 = cursor.getInt(i5);
                    i3 = cursor.getInt(i2);
                } else {
                    Point g2 = g(string);
                    int i6 = g2.x;
                    i3 = g2.y;
                    i4 = i6;
                }
                k(string, j2, i4, i3);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public final void k(String str, long j2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (f(str, j2, i2, i3)) {
                BdLog.d("ScreenShotListenManager: ScreenShot: path = " + str + "; size = " + i2 + " * " + i3 + "; date = " + j2);
                if (this.b != null && !e(str)) {
                    this.b.onShot(str);
                    return;
                }
                return;
            }
            BdLog.d("ScreenShotListenManager: Media content changed, but not screenshot: path = " + str + "; size = " + i2 + " * " + i3 + "; date = " + j2);
        }
    }
}
