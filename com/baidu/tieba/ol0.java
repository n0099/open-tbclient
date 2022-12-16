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
/* loaded from: classes5.dex */
public class ol0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<lk0> a;
    public HashMap<String, lk0> b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a implements Comparator<lk0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ol0 ol0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol0Var};
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
        public int compare(lk0 lk0Var, lk0 lk0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lk0Var, lk0Var2)) == null) {
                long j = lk0Var.m;
                long j2 = lk0Var2.m;
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

    /* loaded from: classes5.dex */
    public class b implements qn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lk0 a;
        public final /* synthetic */ ol0 b;

        @Override // com.baidu.tieba.qn0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(ol0 ol0Var, lk0 lk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol0Var, lk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ol0Var;
            this.a = lk0Var;
        }

        @Override // com.baidu.tieba.qn0
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) || bitmap == null) {
                return;
            }
            PendingIntent e = uk0.f().e(NotificationReceiver.RECEIVER_ACTION_CLICK_ITEM, this.a);
            PendingIntent e2 = uk0.f().e(NotificationReceiver.RECEIVER_ACTION_REMOVE_ITEM, this.a);
            RemoteViews i = this.b.i(bitmap, uk0.f().e(NotificationReceiver.RECEIVER_ACTION_CLICK_BUTTON, this.a), this.a);
            if (i == null) {
                return;
            }
            uk0.f().j(bitmap, i, e, e2, this.a);
            this.b.s(this.a);
            HashMap hashMap = this.b.b;
            lk0 lk0Var = this.a;
            hashMap.put(lk0Var.d, lk0Var);
            uk0 f = uk0.f();
            String str = ClogBuilder.LogType.FREE_SHOW.type;
            String str2 = ClogBuilder.Area.AD_NOTIFICATION_SHOW.type;
            lk0 lk0Var2 = this.a;
            f.h(str, str2, lk0Var2.p.a, lk0Var2.q.m);
            if (!this.b.c) {
                uk0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(this.b.j() + 1));
                this.b.u();
                this.b.c = true;
            }
            this.b.t(this.a, false);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements dl0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lk0 a;
        public final /* synthetic */ ol0 b;

        public c(ol0 ol0Var, lk0 lk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol0Var, lk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ol0Var;
            this.a = lk0Var;
        }

        @Override // com.baidu.tieba.dl0
        public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull lk0 lk0Var) {
            lk0 lk0Var2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, lk0Var) == null) && adDownloadAction == AdDownloadAction.INSTALL_FINISH && !o01.h(this.b.b)) {
                String str = lk0Var.d;
                if (!TextUtils.isEmpty(str) && (lk0Var2 = (lk0) q01.b(this.b.b, str)) != null && lk0Var2.e() != null) {
                    this.b.t(lk0Var2, true);
                    uk0.f().a(lk0Var2.e().hashCode());
                    uk0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, lk0Var2.p.a, lk0Var2.q.m);
                    q01.g(this.b.b, str);
                }
            }
        }

        @Override // com.baidu.tieba.dl0
        public lk0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (lk0) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final ol0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-543204362, "Lcom/baidu/tieba/ol0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-543204362, "Lcom/baidu/tieba/ol0$d;");
                    return;
                }
            }
            a = new ol0(null);
        }
    }

    public ol0() {
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

    public static ol0 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return d.a;
        }
        return (ol0) invokeV.objValue;
    }

    public /* synthetic */ ol0(a aVar) {
        this();
    }

    public final void k(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lk0Var) == null) {
            pn0.a().c(lk0Var.p.g, new b(this, lk0Var));
        }
    }

    public final void s(lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, lk0Var) != null) || lk0Var == null) {
            return;
        }
        c cVar = new c(this, lk0Var);
        AdAppStateManager.instance().register(lk0Var);
        yj0.b().i(lk0Var.e(), cVar);
    }

    public final void h(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lk0Var) == null) {
            Context b2 = zi0.b();
            String n = n(lk0Var.d);
            lk0Var.q.m = n;
            if (TextUtils.equals(n, "notify_type_unactivated")) {
                lk0Var.q.n = b2.getString(R.string.nad_notification_active_text);
                return;
            }
            lk0Var.q.n = b2.getString(R.string.nad_notification_text);
        }
    }

    public final RemoteViews i(Bitmap bitmap, PendingIntent pendingIntent, lk0 lk0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, pendingIntent, lk0Var)) == null) {
            ml0 c2 = kk0.b().c();
            if (c2 == null || c2.a <= 0) {
                return null;
            }
            Context b2 = zi0.b();
            RemoteViews remoteViews = new RemoteViews(b2.getPackageName(), c2.a);
            int i = c2.c;
            if (i > 0) {
                remoteViews.setOnClickPendingIntent(i, pendingIntent);
                if (TextUtils.equals("notify_type_unactivated", n(lk0Var.d))) {
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
                remoteViews.setTextViewText(i3, lk0Var.p.h);
            }
            int i4 = c2.e;
            if (i4 > 0) {
                remoteViews.setTextViewText(i4, lk0Var.q.n);
            }
            return remoteViews;
        }
        return (RemoteViews) invokeLLL.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = w01.a().b("nad_app_quick_config").getString("key_bar_notify_date", "");
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (!format.equals(string)) {
                w01.a().b("nad_app_quick_config").g("key_bar_notify_time_per_day", 0);
                w01.a().b("nad_app_quick_config").i("key_bar_notify_date", format);
            }
            return w01.a().b("nad_app_quick_config").getInt("key_bar_notify_time_per_day", 0);
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
            List<lk0> q = q();
            this.a = q;
            if (o01.g(q)) {
                return false;
            }
            if (!uk0.f().g()) {
                for (lk0 lk0Var : this.a) {
                    if (lk0Var != null) {
                        uk0.f().h(ClogBuilder.LogType.AD_NOTIFICATION_NOTIFY_FAILED.type, "", lk0Var.p.a, null);
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final List<lk0> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap<String, lk0> a2 = ck0.b().a();
            if (o01.h(a2)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, lk0> entry : a2.entrySet()) {
                if (entry != null) {
                    lk0 value = entry.getValue();
                    if (m(value)) {
                        h(value);
                        o01.b(arrayList, value);
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
            int i = w01.a().b("nad_app_quick_config").getInt("key_bar_notify_time_per_day", 0);
            if (new SimpleDateFormat("yyyy-MM-dd").format(new Date()).equals(w01.a().b("nad_app_quick_config").getString("key_bar_notify_date", ""))) {
                w01.a().b("nad_app_quick_config").g("key_bar_notify_time_per_day", i + 1);
            }
        }
    }

    public final boolean m(lk0 lk0Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lk0Var)) == null) {
            if (lk0Var == null) {
                return false;
            }
            String n = n(lk0Var.d);
            if (TextUtils.equals("notify_type_activated", n) || TextUtils.equals("notify_type_no_permission", n)) {
                return false;
            }
            if (TextUtils.equals("notify_type_uninstall", n) && !pl0.f(lk0Var.h)) {
                return false;
            }
            pk0 pk0Var = lk0Var.p;
            String str = pk0Var.h;
            String str2 = pk0Var.g;
            int i = lk0Var.q.k;
            long j = lk0Var.m;
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
            if (!pl0.c(str)) {
                return "notify_type_uninstall";
            }
            if (zi0.b().checkPermission(com.kuaishou.weapon.p0.h.i, Process.myPid(), Process.myUid()) != 0) {
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
        o01.m(this.a, new a(this));
        int min = Math.min(o01.l(this.a), 5);
        for (int i = 0; i < min; i++) {
            lk0 lk0Var = (lk0) o01.d(this.a, i);
            if (lk0Var != null) {
                k(lk0Var);
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

    public void t(lk0 lk0Var, boolean z) {
        mk0 mk0Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, lk0Var, z) == null) && lk0Var != null && (mk0Var = lk0Var.q) != null) {
            if (z) {
                i = 0;
            } else {
                i = mk0Var.k + 1;
            }
            mk0Var.k = i;
            x01 x01Var = new x01();
            x01Var.o(lk0Var.e());
            x01Var.k(mk0.b(lk0Var.q));
            ck0.b().f(x01Var);
        }
    }
}
