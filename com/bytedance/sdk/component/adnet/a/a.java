package com.bytedance.sdk.component.adnet.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.b.b;
import com.bytedance.sdk.component.adnet.c.f;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.d.c;
import com.bytedance.sdk.component.adnet.d.e;
import com.bytedance.sdk.component.adnet.d.g;
import com.bytedance.sdk.component.adnet.d.h;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements com.bytedance.sdk.component.adnet.c.a, h.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f64208b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f64209a;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f64210c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f64211d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64212e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64213f;

    /* renamed from: g  reason: collision with root package name */
    public long f64214g;

    /* renamed from: h  reason: collision with root package name */
    public long f64215h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f64216i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f64217j;
    public volatile boolean k;

    public a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64211d = false;
        this.f64212e = true;
        this.f64213f = false;
        this.f64214g = 0L;
        this.f64215h = 0L;
        this.f64216i = new AtomicBoolean(false);
        this.k = false;
        this.f64209a = new h(Looper.getMainLooper(), this);
        this.f64217j = context;
        this.f64210c = z;
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65546, this, z) == null) || this.f64213f) {
            return;
        }
        if (this.f64212e) {
            this.f64212e = false;
            this.f64214g = 0L;
            this.f64215h = 0L;
        }
        long j2 = z ? Constants.SYNC_MSG_DELAY_TIME : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f64214g <= j2 || currentTimeMillis - this.f64215h <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            return;
        }
        boolean a2 = e.a(this.f64217j);
        if (!this.k || a2) {
            b(a2);
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            String[] d2 = d();
            if (d2 != null && d2.length != 0) {
                a(0);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.k) {
                    return;
                }
                this.k = true;
                long j2 = this.f64217j.getSharedPreferences(com.bytedance.sdk.component.net.tnc.AppConfig.SP_SS_APP_CONFIG, 0).getLong(com.bytedance.sdk.component.net.tnc.AppConfig.KEY_LAST_REFRESH_TIME, 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j2 > currentTimeMillis) {
                    j2 = currentTimeMillis;
                }
                this.f64214g = j2;
                if (f.a().e() != null) {
                    f.a().e().a();
                }
            }
        }
    }

    public static void b(Context context) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, context) == null) || (aVar = f64208b) == null) {
            return;
        }
        if (com.bytedance.sdk.component.adnet.d.f.a(context)) {
            aVar.a(true);
        } else {
            aVar.a();
        }
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (a.class) {
                if (f64208b == null) {
                    a aVar2 = new a(context.getApplicationContext(), com.bytedance.sdk.component.adnet.d.f.a(context));
                    f64208b = aVar2;
                    com.bytedance.sdk.component.adnet.a.a(aVar2);
                }
                aVar = f64208b;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f64214g > 3600000) {
                    this.f64214g = System.currentTimeMillis();
                    try {
                        if (f.a().e() != null) {
                            f.a().e().b();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(false);
        }
    }

    public synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            synchronized (this) {
                if (this.f64210c) {
                    d(z);
                } else if (this.f64214g <= 0) {
                    try {
                        com.bytedance.sdk.component.net.tnc.AppConfig.getInstance(this.f64217j).getThreadPoolExecutor().execute(new Runnable(this) { // from class: com.bytedance.sdk.component.adnet.a.a.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a f64218a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f64218a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f64218a.b();
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            c.b(TNCManager.TAG, "doRefresh, actual request");
            c();
            this.f64213f = true;
            if (!z) {
                this.f64209a.sendEmptyMessage(102);
                return;
            }
            try {
                e();
            } catch (Exception unused) {
                this.f64216i.set(false);
            }
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            c.b(TNCManager.TAG, "doRefresh: updating state " + this.f64216i.get());
            if (!this.f64216i.compareAndSet(false, true)) {
                c.b(TNCManager.TAG, "doRefresh, already running");
                return false;
            }
            if (z) {
                this.f64215h = System.currentTimeMillis();
            }
            com.bytedance.sdk.component.net.tnc.AppConfig.getInstance(this.f64217j).getThreadPoolExecutor().execute(new Runnable(this, z) { // from class: com.bytedance.sdk.component.adnet.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f64219a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f64220b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64220b = this;
                    this.f64219a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f64220b.c(this.f64219a);
                    }
                }
            });
            return true;
        }
        return invokeZ.booleanValue;
    }

    public String[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String[] f2 = com.bytedance.sdk.component.adnet.a.a().f();
            return (f2 == null || f2.length <= 0) ? new String[0] : f2;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.d.h.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            int i2 = message.what;
            if (i2 == 101) {
                this.f64213f = false;
                this.f64214g = System.currentTimeMillis();
                c.b(TNCManager.TAG, "doRefresh, succ");
                if (this.f64212e) {
                    a();
                }
                this.f64216i.set(false);
            } else if (i2 != 102) {
            } else {
                this.f64213f = false;
                if (this.f64212e) {
                    a();
                }
                c.b(TNCManager.TAG, "doRefresh, error");
                this.f64216i.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i2) == null) || (hVar = this.f64209a) == null) {
            return;
        }
        hVar.sendEmptyMessage(i2);
    }

    private String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Address a2 = com.bytedance.sdk.component.adnet.a.a().a(this.f64217j);
            g gVar = new g("https://" + str + "/get_domains/v4/");
            if (a2 != null && a2.hasLatitude() && a2.hasLongitude()) {
                gVar.a("latitude", a2.getLatitude());
                gVar.a("longitude", a2.getLongitude());
                String locality = a2.getLocality();
                if (!TextUtils.isEmpty(locality)) {
                    gVar.a("city", Uri.encode(locality));
                }
            }
            if (this.f64211d) {
                gVar.a("force", 1);
            }
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    str2 = Build.CPU_ABI;
                } else {
                    str2 = Build.SUPPORTED_ABIS[0];
                }
                gVar.a("abi", str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            gVar.a("aid", com.bytedance.sdk.component.adnet.a.a().a());
            gVar.a("device_platform", com.bytedance.sdk.component.adnet.a.a().c());
            gVar.a("channel", com.bytedance.sdk.component.adnet.a.a().b());
            gVar.a("version_code", com.bytedance.sdk.component.adnet.a.a().d());
            gVar.a("custom_info_1", com.bytedance.sdk.component.adnet.a.a().e());
            return gVar.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.c.a
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    return f.a().a(str);
                } catch (Throwable unused) {
                    return str;
                }
            }
            try {
                if (this.f64210c) {
                    c();
                } else {
                    b();
                }
                return f.a().a(str);
            } catch (Throwable unused2) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, obj)) == null) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                jSONObject = new JSONObject(str);
                if (!"success".equals(jSONObject.getString("message"))) {
                    return false;
                }
            } else {
                jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
            }
            if (jSONObject == null) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            synchronized (this) {
                SharedPreferences.Editor edit = this.f64217j.getSharedPreferences(com.bytedance.sdk.component.net.tnc.AppConfig.SP_SS_APP_CONFIG, 0).edit();
                edit.putLong(com.bytedance.sdk.component.net.tnc.AppConfig.KEY_LAST_REFRESH_TIME, System.currentTimeMillis());
                edit.apply();
            }
            if (f.a().e() != null) {
                f.a().e().a(jSONObject2);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            String[] d2 = d();
            if (d2 != null && d2.length > i2) {
                String str = d2[i2];
                if (TextUtils.isEmpty(str)) {
                    b(102);
                    return;
                }
                try {
                    String b2 = b(str);
                    if (TextUtils.isEmpty(b2)) {
                        b(102);
                        return;
                    } else {
                        new b(0, b2, new JSONObject(), new m.a<JSONObject>(this, i2) { // from class: com.bytedance.sdk.component.adnet.a.a.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f64221a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ a f64222b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f64222b = this;
                                this.f64221a = i2;
                            }

                            @Override // com.bytedance.sdk.component.adnet.core.m.a
                            public void a(m<JSONObject> mVar) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mVar) == null) {
                                    JSONObject jSONObject = mVar.f64352a;
                                    if (jSONObject == null) {
                                        this.f64222b.a(this.f64221a + 1);
                                        return;
                                    }
                                    String str2 = null;
                                    try {
                                        str2 = jSONObject.getString("message");
                                    } catch (Exception unused) {
                                    }
                                    if (!"success".equals(str2)) {
                                        this.f64222b.a(this.f64221a + 1);
                                        return;
                                    }
                                    try {
                                        if (this.f64222b.a(jSONObject)) {
                                            this.f64222b.b(101);
                                        } else {
                                            this.f64222b.a(this.f64221a + 1);
                                        }
                                    } catch (Exception unused2) {
                                    }
                                }
                            }

                            @Override // com.bytedance.sdk.component.adnet.core.m.a
                            public void b(m<JSONObject> mVar) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                                    this.f64222b.a(this.f64221a + 1);
                                }
                            }
                        }).setRetryPolicy(new com.bytedance.sdk.component.adnet.core.e().a(10000).b(0)).build(com.bytedance.sdk.component.adnet.a.a(this.f64217j));
                        return;
                    }
                } catch (Throwable th) {
                    c.b(com.bytedance.sdk.component.net.tnc.AppConfig.TAG, "try app config exception: " + th);
                    return;
                }
            }
            b(102);
        }
    }
}
