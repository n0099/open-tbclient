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
import com.bytedance.sdk.component.adnet.core.e;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.d.d;
import com.bytedance.sdk.component.adnet.d.f;
import com.bytedance.sdk.component.adnet.d.g;
import com.bytedance.sdk.component.adnet.d.h;
import com.bytedance.sdk.component.adnet.d.i;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.bytedance.sdk.component.adnet.c.a, i.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f27721b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final i f27722a;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f27723c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f27724d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27725e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27726f;

    /* renamed from: g  reason: collision with root package name */
    public long f27727g;

    /* renamed from: h  reason: collision with root package name */
    public long f27728h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f27729i;
    public final Context j;
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
        this.f27724d = false;
        this.f27725e = true;
        this.f27726f = false;
        this.f27727g = 0L;
        this.f27728h = 0L;
        this.f27729i = new AtomicBoolean(false);
        this.k = false;
        this.f27722a = new i(Looper.getMainLooper(), this);
        this.j = context;
        this.f27723c = z;
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65546, this, z) == null) || this.f27726f) {
            return;
        }
        if (this.f27725e) {
            this.f27725e = false;
            this.f27727g = 0L;
            this.f27728h = 0L;
        }
        long j = z ? Constants.SYNC_MSG_DELAY_TIME : 43200000L;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f27727g <= j || currentTimeMillis - this.f27728h <= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            return;
        }
        boolean a2 = f.a(this.j);
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
                long j = this.j.getSharedPreferences(com.bytedance.sdk.component.net.tnc.AppConfig.SP_SS_APP_CONFIG, 0).getLong(com.bytedance.sdk.component.net.tnc.AppConfig.KEY_LAST_REFRESH_TIME, 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j > currentTimeMillis) {
                    j = currentTimeMillis;
                }
                this.f27727g = j;
                if (com.bytedance.sdk.component.adnet.c.f.a().e() != null) {
                    com.bytedance.sdk.component.adnet.c.f.a().e().a();
                }
            }
        }
    }

    public static void b(Context context) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, context) == null) || (aVar = f27721b) == null) {
            return;
        }
        if (g.a(context)) {
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
                if (f27721b == null) {
                    a aVar2 = new a(context.getApplicationContext(), g.a(context));
                    f27721b = aVar2;
                    com.bytedance.sdk.component.adnet.a.a(aVar2);
                }
                aVar = f27721b;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f27727g > 3600000) {
                    this.f27727g = System.currentTimeMillis();
                    try {
                        if (com.bytedance.sdk.component.adnet.c.f.a().e() != null) {
                            com.bytedance.sdk.component.adnet.c.f.a().e().b();
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
                if (this.f27723c) {
                    d(z);
                } else if (this.f27727g <= 0) {
                    try {
                        com.bytedance.sdk.component.net.tnc.AppConfig.getInstance(this.j).getThreadPoolExecutor().execute(new Runnable(this) { // from class: com.bytedance.sdk.component.adnet.a.a.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a f27730a;

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
                                this.f27730a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f27730a.b();
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
            d.b(TNCManager.TAG, "doRefresh, actual request");
            c();
            this.f27726f = true;
            if (!z) {
                this.f27722a.sendEmptyMessage(102);
                return;
            }
            try {
                e();
            } catch (Exception unused) {
                this.f27729i.set(false);
            }
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            d.b(TNCManager.TAG, "doRefresh: updating state " + this.f27729i.get());
            if (!this.f27729i.compareAndSet(false, true)) {
                d.b(TNCManager.TAG, "doRefresh, already running");
                return false;
            }
            if (z) {
                this.f27728h = System.currentTimeMillis();
            }
            com.bytedance.sdk.component.net.tnc.AppConfig.getInstance(this.j).getThreadPoolExecutor().execute(new Runnable(this, z) { // from class: com.bytedance.sdk.component.adnet.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f27731a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f27732b;

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
                    this.f27732b = this;
                    this.f27731a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f27732b.c(this.f27731a);
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

    @Override // com.bytedance.sdk.component.adnet.d.i.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            int i2 = message.what;
            if (i2 == 101) {
                this.f27726f = false;
                this.f27727g = System.currentTimeMillis();
                d.b(TNCManager.TAG, "doRefresh, succ");
                if (this.f27725e) {
                    a();
                }
                this.f27729i.set(false);
            } else if (i2 != 102) {
            } else {
                this.f27726f = false;
                if (this.f27725e) {
                    a();
                }
                d.b(TNCManager.TAG, "doRefresh, error");
                this.f27729i.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i2) == null) || (iVar = this.f27722a) == null) {
            return;
        }
        iVar.sendEmptyMessage(i2);
    }

    private String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Address a2 = com.bytedance.sdk.component.adnet.a.a().a(this.j);
            h hVar = new h("https://" + str + "/get_domains/v4/");
            if (a2 != null && a2.hasLatitude() && a2.hasLongitude()) {
                hVar.a("latitude", a2.getLatitude());
                hVar.a("longitude", a2.getLongitude());
                String locality = a2.getLocality();
                if (!TextUtils.isEmpty(locality)) {
                    hVar.a("city", Uri.encode(locality));
                }
            }
            if (this.f27724d) {
                hVar.a("force", 1);
            }
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    str2 = Build.CPU_ABI;
                } else {
                    str2 = Build.SUPPORTED_ABIS[0];
                }
                hVar.a("abi", str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            hVar.a("aid", com.bytedance.sdk.component.adnet.a.a().a());
            hVar.a("device_platform", com.bytedance.sdk.component.adnet.a.a().c());
            hVar.a("channel", com.bytedance.sdk.component.adnet.a.a().b());
            hVar.a("version_code", com.bytedance.sdk.component.adnet.a.a().d());
            hVar.a("custom_info_1", com.bytedance.sdk.component.adnet.a.a().e());
            return hVar.toString();
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
                    return com.bytedance.sdk.component.adnet.c.f.a().a(str);
                } catch (Throwable unused) {
                    return str;
                }
            }
            try {
                if (this.f27723c) {
                    c();
                } else {
                    b();
                }
                return com.bytedance.sdk.component.adnet.c.f.a().a(str);
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
                SharedPreferences.Editor edit = this.j.getSharedPreferences(com.bytedance.sdk.component.net.tnc.AppConfig.SP_SS_APP_CONFIG, 0).edit();
                edit.putLong(com.bytedance.sdk.component.net.tnc.AppConfig.KEY_LAST_REFRESH_TIME, System.currentTimeMillis());
                edit.apply();
            }
            if (com.bytedance.sdk.component.adnet.c.f.a().e() != null) {
                com.bytedance.sdk.component.adnet.c.f.a().e().a(jSONObject2);
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
                        new com.bytedance.sdk.component.adnet.b.f(0, b2, new JSONObject(), new m.a<JSONObject>(this, i2) { // from class: com.bytedance.sdk.component.adnet.a.a.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f27733a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ a f27734b;

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
                                this.f27734b = this;
                                this.f27733a = i2;
                            }

                            @Override // com.bytedance.sdk.component.adnet.core.m.a
                            public void a(m<JSONObject> mVar) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mVar) == null) {
                                    JSONObject jSONObject = mVar.f27921a;
                                    if (jSONObject == null) {
                                        this.f27734b.a(this.f27733a + 1);
                                        return;
                                    }
                                    String str2 = null;
                                    try {
                                        str2 = jSONObject.getString("message");
                                    } catch (Exception unused) {
                                    }
                                    if (!"success".equals(str2)) {
                                        this.f27734b.a(this.f27733a + 1);
                                        return;
                                    }
                                    try {
                                        if (this.f27734b.a(jSONObject)) {
                                            this.f27734b.b(101);
                                        } else {
                                            this.f27734b.a(this.f27733a + 1);
                                        }
                                    } catch (Exception unused2) {
                                    }
                                }
                            }

                            @Override // com.bytedance.sdk.component.adnet.core.m.a
                            public void b(m<JSONObject> mVar) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                                    this.f27734b.a(this.f27733a + 1);
                                }
                            }
                        }).setRetryPolicy(new e().a(10000).b(0)).build(com.bytedance.sdk.component.adnet.a.a(this.j));
                        return;
                    }
                } catch (Throwable th) {
                    d.b(com.bytedance.sdk.component.net.tnc.AppConfig.TAG, "try app config exception: " + th);
                    return;
                }
            }
            b(102);
        }
    }
}
