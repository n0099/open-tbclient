package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.notification.NotificationReceiver;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class jn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<gm0> a;
    public HashMap<String, gm0> b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a implements Comparator<gm0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jn0 jn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(gm0 gm0Var, gm0 gm0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gm0Var, gm0Var2)) == null) {
                long j = gm0Var.m;
                long j2 = gm0Var2.m;
                if (j > j2) {
                    return -1;
                }
                if (j < j2) {
                    return 1;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sp0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm0 a;
        public final /* synthetic */ jn0 b;

        @Override // com.baidu.tieba.sp0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(jn0 jn0Var, gm0 gm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn0Var, gm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jn0Var;
            this.a = gm0Var;
        }

        @Override // com.baidu.tieba.sp0
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) || bitmap == null) {
                return;
            }
            PendingIntent e = pm0.f().e(NotificationReceiver.RECEIVER_ACTION_CLICK_ITEM, this.a);
            PendingIntent e2 = pm0.f().e(NotificationReceiver.RECEIVER_ACTION_REMOVE_ITEM, this.a);
            RemoteViews i = this.b.i(bitmap, pm0.f().e(NotificationReceiver.RECEIVER_ACTION_CLICK_BUTTON, this.a), this.a);
            if (i == null) {
                return;
            }
            pm0.f().j(bitmap, i, e, e2, this.a);
            this.b.s(this.a);
            HashMap hashMap = this.b.b;
            gm0 gm0Var = this.a;
            hashMap.put(gm0Var.d, gm0Var);
            pm0 f = pm0.f();
            String str = ClogBuilder.LogType.FREE_SHOW.type;
            String str2 = ClogBuilder.Area.AD_NOTIFICATION_SHOW.type;
            gm0 gm0Var2 = this.a;
            f.h(str, str2, gm0Var2.p.a, gm0Var2.q.m);
            if (!this.b.c) {
                pm0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(this.b.j() + 1));
                this.b.u();
                this.b.c = true;
            }
            this.b.t(this.a, false);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ym0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gm0 a;
        public final /* synthetic */ jn0 b;

        public c(jn0 jn0Var, gm0 gm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn0Var, gm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jn0Var;
            this.a = gm0Var;
        }

        @Override // com.baidu.tieba.ym0
        public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull gm0 gm0Var) {
            gm0 gm0Var2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, gm0Var) == null) && adDownloadAction == AdDownloadAction.INSTALL_FINISH && !x31.h(this.b.b)) {
                String str = gm0Var.d;
                if (!TextUtils.isEmpty(str) && (gm0Var2 = (gm0) z31.b(this.b.b, str)) != null && gm0Var2.e() != null) {
                    this.b.t(gm0Var2, true);
                    pm0.f().a(gm0Var2.e().hashCode());
                    pm0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, gm0Var2.p.a, gm0Var2.q.m);
                    z31.g(this.b.b, str);
                }
            }
        }

        @Override // com.baidu.tieba.ym0
        public gm0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (gm0) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final jn0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-684503075, "Lcom/baidu/tieba/jn0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-684503075, "Lcom/baidu/tieba/jn0$d;");
                    return;
                }
            }
            a = new jn0(null);
        }
    }

    public jn0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = false;
    }

    public static jn0 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return d.a;
        }
        return (jn0) invokeV.objValue;
    }

    public /* synthetic */ jn0(a aVar) {
        this();
    }

    public final void k(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gm0Var) == null) {
            rp0.a().c(gm0Var.p.g, new b(this, gm0Var));
        }
    }

    public final void s(gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, gm0Var) != null) || gm0Var == null) {
            return;
        }
        c cVar = new c(this, gm0Var);
        AdAppStateManager.instance().register(gm0Var);
        tl0.c().k(gm0Var.e(), cVar);
    }

    public final void h(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gm0Var) == null) {
            Context b2 = rk0.b();
            String n = n(gm0Var.d);
            gm0Var.q.m = n;
            if (TextUtils.equals(n, "notify_type_unactivated")) {
                gm0Var.q.n = b2.getString(R.string.nad_notification_active_text);
                return;
            }
            gm0Var.q.n = b2.getString(R.string.nad_notification_text);
        }
    }

    public final RemoteViews i(Bitmap bitmap, PendingIntent pendingIntent, gm0 gm0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, pendingIntent, gm0Var)) == null) {
            hn0 c2 = fm0.b().c();
            if (c2 == null || c2.a <= 0) {
                return null;
            }
            Context b2 = rk0.b();
            RemoteViews remoteViews = new RemoteViews(b2.getPackageName(), c2.a);
            int i = c2.c;
            if (i > 0) {
                remoteViews.setOnClickPendingIntent(i, pendingIntent);
                if (TextUtils.equals("notify_type_unactivated", n(gm0Var.d))) {
                    remoteViews.setTextViewText(c2.c, b2.getString(R.string.nad_notification_btn_active_text));
                } else {
                    remoteViews.setTextViewText(c2.c, b2.getString(R.string.nad_notification_btn_text));
                }
            }
            int i2 = c2.b;
            if (i2 > 0) {
                remoteViews.setImageViewBitmap(i2, r(bitmap, 24.0f));
            }
            int i3 = c2.d;
            if (i3 > 0) {
                remoteViews.setTextViewText(i3, gm0Var.p.h);
            }
            int i4 = c2.e;
            if (i4 > 0) {
                remoteViews.setTextViewText(i4, gm0Var.q.n);
            }
            return remoteViews;
        }
        return (RemoteViews) invokeLLL.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = k41.a().b("nad_app_quick_config").getString("key_bar_notify_date", "");
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (!format.equals(string)) {
                k41.a().b("nad_app_quick_config").f("key_bar_notify_time_per_day", 0);
                k41.a().b("nad_app_quick_config").h("key_bar_notify_date", format);
            }
            return k41.a().b("nad_app_quick_config").getInt("key_bar_notify_time_per_day", 0);
        }
        return invokeV.intValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (j() >= 3) {
                return false;
            }
            List<gm0> q = q();
            this.a = q;
            if (x31.g(q)) {
                return false;
            }
            if (!pm0.f().g()) {
                for (gm0 gm0Var : this.a) {
                    if (gm0Var != null) {
                        pm0.f().h(ClogBuilder.LogType.AD_NOTIFICATION_NOTIFY_FAILED.type, "", gm0Var.p.a, null);
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final List<gm0> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap<String, gm0> a2 = xl0.b().a();
            if (x31.h(a2)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, gm0> entry : a2.entrySet()) {
                if (entry != null) {
                    gm0 value = entry.getValue();
                    if (m(value)) {
                        h(value);
                        x31.b(arrayList, value);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i = k41.a().b("nad_app_quick_config").getInt("key_bar_notify_time_per_day", 0);
            if (new SimpleDateFormat("yyyy-MM-dd").format(new Date()).equals(k41.a().b("nad_app_quick_config").getString("key_bar_notify_date", ""))) {
                k41.a().b("nad_app_quick_config").f("key_bar_notify_time_per_day", i + 1);
            }
        }
    }

    public final boolean m(gm0 gm0Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gm0Var)) == null) {
            if (gm0Var == null) {
                return false;
            }
            String n = n(gm0Var.d);
            if (TextUtils.equals("notify_type_activated", n) || TextUtils.equals("notify_type_no_permission", n)) {
                return false;
            }
            if (TextUtils.equals("notify_type_uninstall", n) && !qn0.g(gm0Var.h)) {
                return false;
            }
            km0 km0Var = gm0Var.p;
            String str = km0Var.h;
            String str2 = km0Var.g;
            int i = gm0Var.q.k;
            long j = gm0Var.m;
            long currentTimeMillis = System.currentTimeMillis();
            if (j <= currentTimeMillis && j >= currentTimeMillis - 604800000) {
                z = true;
            } else {
                z = false;
            }
            if (i >= 3 || !z || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!qn0.c(str)) {
                return "notify_type_uninstall";
            }
            if (rk0.b().checkPermission(com.kuaishou.weapon.p0.h.i, Process.myPid(), Process.myUid()) != 0) {
                return "notify_type_no_permission";
            }
            try {
                if (!new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str).exists()) {
                    return "notify_type_unactivated";
                }
                return "notify_type_activated";
            } catch (Exception e) {
                e.printStackTrace();
                return "notify_type_no_permission";
            }
        }
        return (String) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !o()) {
            return;
        }
        x31.m(this.a, new a(this));
        int min = Math.min(x31.l(this.a), 5);
        for (int i = 0; i < min; i++) {
            gm0 gm0Var = (gm0) x31.d(this.a, i);
            if (gm0Var != null) {
                k(gm0Var);
            }
        }
    }

    public Bitmap r(Bitmap bitmap, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048585, this, bitmap, f)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(rect);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectF, f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return createBitmap;
        }
        return (Bitmap) invokeLF.objValue;
    }

    public void t(gm0 gm0Var, boolean z) {
        hm0 hm0Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, gm0Var, z) == null) && gm0Var != null && (hm0Var = gm0Var.q) != null) {
            if (z) {
                i = 0;
            } else {
                i = hm0Var.k + 1;
            }
            hm0Var.k = i;
            l41 l41Var = new l41();
            l41Var.o(gm0Var.e());
            l41Var.k(hm0.b(gm0Var.q));
            xl0.b().f(l41Var);
        }
    }
}
