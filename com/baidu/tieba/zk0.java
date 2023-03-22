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
/* loaded from: classes7.dex */
public class zk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wj0> a;
    public HashMap<String, wj0> b;
    public boolean c;

    /* loaded from: classes7.dex */
    public class a implements Comparator<wj0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(zk0 zk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk0Var};
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
        public int compare(wj0 wj0Var, wj0 wj0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wj0Var, wj0Var2)) == null) {
                long j = wj0Var.m;
                long j2 = wj0Var2.m;
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

    /* loaded from: classes7.dex */
    public class b implements bn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj0 a;
        public final /* synthetic */ zk0 b;

        @Override // com.baidu.tieba.bn0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(zk0 zk0Var, wj0 wj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk0Var, wj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk0Var;
            this.a = wj0Var;
        }

        @Override // com.baidu.tieba.bn0
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) || bitmap == null) {
                return;
            }
            PendingIntent e = fk0.f().e(NotificationReceiver.RECEIVER_ACTION_CLICK_ITEM, this.a);
            PendingIntent e2 = fk0.f().e(NotificationReceiver.RECEIVER_ACTION_REMOVE_ITEM, this.a);
            RemoteViews i = this.b.i(bitmap, fk0.f().e(NotificationReceiver.RECEIVER_ACTION_CLICK_BUTTON, this.a), this.a);
            if (i == null) {
                return;
            }
            fk0.f().j(bitmap, i, e, e2, this.a);
            this.b.s(this.a);
            HashMap hashMap = this.b.b;
            wj0 wj0Var = this.a;
            hashMap.put(wj0Var.d, wj0Var);
            fk0 f = fk0.f();
            String str = ClogBuilder.LogType.FREE_SHOW.type;
            String str2 = ClogBuilder.Area.AD_NOTIFICATION_SHOW.type;
            wj0 wj0Var2 = this.a;
            f.h(str, str2, wj0Var2.p.a, wj0Var2.q.m);
            if (!this.b.c) {
                fk0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(this.b.j() + 1));
                this.b.u();
                this.b.c = true;
            }
            this.b.t(this.a, false);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ok0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj0 a;
        public final /* synthetic */ zk0 b;

        public c(zk0 zk0Var, wj0 wj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk0Var, wj0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zk0Var;
            this.a = wj0Var;
        }

        @Override // com.baidu.tieba.ok0
        public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull wj0 wj0Var) {
            wj0 wj0Var2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, wj0Var) == null) && adDownloadAction == AdDownloadAction.INSTALL_FINISH && !u01.h(this.b.b)) {
                String str = wj0Var.d;
                if (!TextUtils.isEmpty(str) && (wj0Var2 = (wj0) w01.b(this.b.b, str)) != null && wj0Var2.e() != null) {
                    this.b.t(wj0Var2, true);
                    fk0.f().a(wj0Var2.e().hashCode());
                    fk0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, wj0Var2.p.a, wj0Var2.q.m);
                    w01.g(this.b.b, str);
                }
            }
        }

        @Override // com.baidu.tieba.ok0
        public wj0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (wj0) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final zk0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229207222, "Lcom/baidu/tieba/zk0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-229207222, "Lcom/baidu/tieba/zk0$d;");
                    return;
                }
            }
            a = new zk0(null);
        }
    }

    public zk0() {
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

    public static zk0 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return d.a;
        }
        return (zk0) invokeV.objValue;
    }

    public /* synthetic */ zk0(a aVar) {
        this();
    }

    public final void k(@NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wj0Var) == null) {
            an0.a().c(wj0Var.p.g, new b(this, wj0Var));
        }
    }

    public final void s(wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, wj0Var) != null) || wj0Var == null) {
            return;
        }
        c cVar = new c(this, wj0Var);
        AdAppStateManager.instance().register(wj0Var);
        jj0.b().i(wj0Var.e(), cVar);
    }

    public final void h(@NonNull wj0 wj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wj0Var) == null) {
            Context b2 = hi0.b();
            String n = n(wj0Var.d);
            wj0Var.q.m = n;
            if (TextUtils.equals(n, "notify_type_unactivated")) {
                wj0Var.q.n = b2.getString(R.string.nad_notification_active_text);
                return;
            }
            wj0Var.q.n = b2.getString(R.string.nad_notification_text);
        }
    }

    public final RemoteViews i(Bitmap bitmap, PendingIntent pendingIntent, wj0 wj0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, pendingIntent, wj0Var)) == null) {
            xk0 c2 = vj0.b().c();
            if (c2 == null || c2.a <= 0) {
                return null;
            }
            Context b2 = hi0.b();
            RemoteViews remoteViews = new RemoteViews(b2.getPackageName(), c2.a);
            int i = c2.c;
            if (i > 0) {
                remoteViews.setOnClickPendingIntent(i, pendingIntent);
                if (TextUtils.equals("notify_type_unactivated", n(wj0Var.d))) {
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
                remoteViews.setTextViewText(i3, wj0Var.p.h);
            }
            int i4 = c2.e;
            if (i4 > 0) {
                remoteViews.setTextViewText(i4, wj0Var.q.n);
            }
            return remoteViews;
        }
        return (RemoteViews) invokeLLL.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = h11.a().b("nad_app_quick_config").getString("key_bar_notify_date", "");
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (!format.equals(string)) {
                h11.a().b("nad_app_quick_config").g("key_bar_notify_time_per_day", 0);
                h11.a().b("nad_app_quick_config").i("key_bar_notify_date", format);
            }
            return h11.a().b("nad_app_quick_config").getInt("key_bar_notify_time_per_day", 0);
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
            List<wj0> q = q();
            this.a = q;
            if (u01.g(q)) {
                return false;
            }
            if (!fk0.f().g()) {
                for (wj0 wj0Var : this.a) {
                    if (wj0Var != null) {
                        fk0.f().h(ClogBuilder.LogType.AD_NOTIFICATION_NOTIFY_FAILED.type, "", wj0Var.p.a, null);
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final List<wj0> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap<String, wj0> a2 = nj0.b().a();
            if (u01.h(a2)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, wj0> entry : a2.entrySet()) {
                if (entry != null) {
                    wj0 value = entry.getValue();
                    if (m(value)) {
                        h(value);
                        u01.b(arrayList, value);
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
            int i = h11.a().b("nad_app_quick_config").getInt("key_bar_notify_time_per_day", 0);
            if (new SimpleDateFormat("yyyy-MM-dd").format(new Date()).equals(h11.a().b("nad_app_quick_config").getString("key_bar_notify_date", ""))) {
                h11.a().b("nad_app_quick_config").g("key_bar_notify_time_per_day", i + 1);
            }
        }
    }

    public final boolean m(wj0 wj0Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wj0Var)) == null) {
            if (wj0Var == null) {
                return false;
            }
            String n = n(wj0Var.d);
            if (TextUtils.equals("notify_type_activated", n) || TextUtils.equals("notify_type_no_permission", n)) {
                return false;
            }
            if (TextUtils.equals("notify_type_uninstall", n) && !al0.f(wj0Var.h)) {
                return false;
            }
            ak0 ak0Var = wj0Var.p;
            String str = ak0Var.h;
            String str2 = ak0Var.g;
            int i = wj0Var.q.k;
            long j = wj0Var.m;
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
            if (!al0.c(str)) {
                return "notify_type_uninstall";
            }
            if (hi0.b().checkPermission(com.kuaishou.weapon.p0.h.i, Process.myPid(), Process.myUid()) != 0) {
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
        u01.m(this.a, new a(this));
        int min = Math.min(u01.l(this.a), 5);
        for (int i = 0; i < min; i++) {
            wj0 wj0Var = (wj0) u01.d(this.a, i);
            if (wj0Var != null) {
                k(wj0Var);
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

    public void t(wj0 wj0Var, boolean z) {
        xj0 xj0Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, wj0Var, z) == null) && wj0Var != null && (xj0Var = wj0Var.q) != null) {
            if (z) {
                i = 0;
            } else {
                i = xj0Var.k + 1;
            }
            xj0Var.k = i;
            i11 i11Var = new i11();
            i11Var.o(wj0Var.e());
            i11Var.k(xj0.b(wj0Var.q));
            nj0.b().f(i11Var);
        }
    }
}
