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
import com.baidu.tieba.q61;
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
public class lm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<il0> a;
    public HashMap<String, il0> b;
    public boolean c;

    /* loaded from: classes6.dex */
    public class a implements Comparator<il0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(lm0 lm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm0Var};
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
        public int compare(il0 il0Var, il0 il0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, il0Var, il0Var2)) == null) {
                long j = il0Var.m;
                long j2 = il0Var2.m;
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
    public class b implements uo0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il0 a;
        public final /* synthetic */ lm0 b;

        @Override // com.baidu.tieba.uo0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public b(lm0 lm0Var, il0 il0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm0Var, il0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm0Var;
            this.a = il0Var;
        }

        @Override // com.baidu.tieba.uo0
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) || bitmap == null) {
                return;
            }
            PendingIntent e = rl0.f().e(NotificationReceiver.RECEIVER_ACTION_CLICK_ITEM, this.a);
            PendingIntent e2 = rl0.f().e(NotificationReceiver.RECEIVER_ACTION_REMOVE_ITEM, this.a);
            RemoteViews i = this.b.i(bitmap, rl0.f().e(NotificationReceiver.RECEIVER_ACTION_CLICK_BUTTON, this.a), this.a);
            if (i == null) {
                return;
            }
            rl0.f().j(bitmap, i, e, e2, this.a);
            this.b.s(this.a);
            HashMap hashMap = this.b.b;
            il0 il0Var = this.a;
            hashMap.put(il0Var.d, il0Var);
            rl0 f = rl0.f();
            String str = ClogBuilder.LogType.FREE_SHOW.type;
            String str2 = ClogBuilder.Area.AD_NOTIFICATION_SHOW.type;
            il0 il0Var2 = this.a;
            f.h(str, str2, il0Var2.p.a, il0Var2.q.m);
            if (!this.b.c) {
                rl0.f().h(ClogBuilder.LogType.FREE_SHOW.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, "", String.valueOf(this.b.j() + 1));
                this.b.u();
                this.b.c = true;
            }
            this.b.t(this.a, false);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements am0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il0 a;
        public final /* synthetic */ lm0 b;

        public c(lm0 lm0Var, il0 il0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm0Var, il0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm0Var;
            this.a = il0Var;
        }

        @Override // com.baidu.tieba.am0
        public void a(@NonNull AdDownloadAction adDownloadAction, @NonNull il0 il0Var) {
            il0 il0Var2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, adDownloadAction, il0Var) == null) && adDownloadAction == AdDownloadAction.INSTALL_FINISH && !h31.h(this.b.b)) {
                String str = il0Var.d;
                if (!TextUtils.isEmpty(str) && (il0Var2 = (il0) j31.b(this.b.b, str)) != null && il0Var2.e() != null) {
                    this.b.t(il0Var2, true);
                    rl0.f().a(il0Var2.e().hashCode());
                    rl0.f().h(ClogBuilder.LogType.INSTALL_COMPLETE.type, ClogBuilder.Area.AD_NOTIFICATION_NOTIFY.type, il0Var2.p.a, il0Var2.q.m);
                    j31.g(this.b.b, str);
                }
            }
        }

        @Override // com.baidu.tieba.am0
        public il0 getData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (il0) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final lm0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-628168294, "Lcom/baidu/tieba/lm0$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-628168294, "Lcom/baidu/tieba/lm0$d;");
                    return;
                }
            }
            a = new lm0(null);
        }
    }

    public lm0() {
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

    public static lm0 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return d.a;
        }
        return (lm0) invokeV.objValue;
    }

    public /* synthetic */ lm0(a aVar) {
        this();
    }

    public final void k(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, il0Var) == null) {
            to0.a().c(il0Var.p.g, new b(this, il0Var));
        }
    }

    public final void s(il0 il0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, il0Var) != null) || il0Var == null) {
            return;
        }
        c cVar = new c(this, il0Var);
        AdAppStateManager.instance().register(il0Var);
        vk0.c().k(il0Var.e(), cVar);
    }

    public final void h(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, il0Var) == null) {
            Context b2 = tj0.b();
            String n = n(il0Var.d);
            il0Var.q.m = n;
            if (TextUtils.equals(n, "notify_type_unactivated")) {
                il0Var.q.n = b2.getString(R.string.nad_notification_active_text);
                return;
            }
            il0Var.q.n = b2.getString(R.string.nad_notification_text);
        }
    }

    public final RemoteViews i(Bitmap bitmap, PendingIntent pendingIntent, il0 il0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, pendingIntent, il0Var)) == null) {
            jm0 c2 = hl0.b().c();
            if (c2 == null || c2.a <= 0) {
                return null;
            }
            Context b2 = tj0.b();
            RemoteViews remoteViews = new RemoteViews(b2.getPackageName(), c2.a);
            int i = c2.c;
            if (i > 0) {
                remoteViews.setOnClickPendingIntent(i, pendingIntent);
                if (TextUtils.equals("notify_type_unactivated", n(il0Var.d))) {
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
                remoteViews.setTextViewText(i3, il0Var.p.h);
            }
            int i4 = c2.e;
            if (i4 > 0) {
                remoteViews.setTextViewText(i4, il0Var.q.n);
            }
            return remoteViews;
        }
        return (RemoteViews) invokeLLL.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = u31.a().b("nad_app_quick_config").getString("key_bar_notify_date", "");
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (!format.equals(string)) {
                u31.a().b("nad_app_quick_config").f("key_bar_notify_time_per_day", 0);
                u31.a().b("nad_app_quick_config").h("key_bar_notify_date", format);
            }
            return u31.a().b("nad_app_quick_config").getInt("key_bar_notify_time_per_day", 0);
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
            List<il0> q = q();
            this.a = q;
            if (h31.g(q)) {
                return false;
            }
            if (!rl0.f().g()) {
                for (il0 il0Var : this.a) {
                    if (il0Var != null) {
                        rl0.f().h(ClogBuilder.LogType.AD_NOTIFICATION_NOTIFY_FAILED.type, "", il0Var.p.a, null);
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final List<il0> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap<String, il0> a2 = zk0.b().a();
            if (h31.h(a2)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, il0> entry : a2.entrySet()) {
                if (entry != null) {
                    il0 value = entry.getValue();
                    if (m(value)) {
                        h(value);
                        h31.b(arrayList, value);
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
            int i = u31.a().b("nad_app_quick_config").getInt("key_bar_notify_time_per_day", 0);
            if (new SimpleDateFormat("yyyy-MM-dd").format(new Date()).equals(u31.a().b("nad_app_quick_config").getString("key_bar_notify_date", ""))) {
                u31.a().b("nad_app_quick_config").f("key_bar_notify_time_per_day", i + 1);
            }
        }
    }

    public final boolean m(il0 il0Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, il0Var)) == null) {
            if (il0Var == null) {
                return false;
            }
            String n = n(il0Var.d);
            if (TextUtils.equals("notify_type_activated", n) || TextUtils.equals("notify_type_no_permission", n)) {
                return false;
            }
            if (TextUtils.equals("notify_type_uninstall", n) && !sm0.g(il0Var.h)) {
                return false;
            }
            ml0 ml0Var = il0Var.p;
            String str = ml0Var.h;
            String str2 = ml0Var.g;
            int i = il0Var.q.k;
            long j = il0Var.m;
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
            if (!sm0.c(str)) {
                return "notify_type_uninstall";
            }
            if (!q61.b.f() && tj0.b().checkPermission(com.kuaishou.weapon.p0.h.i, Process.myPid(), Process.myUid()) != 0) {
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
        h31.n(this.a, new a(this));
        int min = Math.min(h31.l(this.a), 5);
        for (int i = 0; i < min; i++) {
            il0 il0Var = (il0) h31.d(this.a, i);
            if (il0Var != null) {
                k(il0Var);
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

    public void t(il0 il0Var, boolean z) {
        jl0 jl0Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, il0Var, z) == null) && il0Var != null && (jl0Var = il0Var.q) != null) {
            if (z) {
                i = 0;
            } else {
                i = jl0Var.k + 1;
            }
            jl0Var.k = i;
            v31 v31Var = new v31();
            v31Var.o(il0Var.e());
            v31Var.k(jl0.b(il0Var.q));
            zk0.b().f(v31Var);
        }
    }
}
