package com.bytedance.sdk.openadsdk.core.k;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.f;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static long f67066a = 1800000;

    /* renamed from: b  reason: collision with root package name */
    public static com.bytedance.sdk.openadsdk.core.k.a f67067b;

    /* renamed from: c  reason: collision with root package name */
    public static long f67068c;

    /* renamed from: d  reason: collision with root package name */
    public static Handler f67069d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Callable<TTLocation> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public TTLocation call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? h.d().f().getTTLocation() : (TTLocation) invokeV.objValue;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class CallableC1913b implements Callable<Location> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LocationManager f67078a;

        /* renamed from: b  reason: collision with root package name */
        public String f67079b;

        public CallableC1913b(LocationManager locationManager, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationManager, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67078a = locationManager;
            this.f67079b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Location call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                Location lastKnownLocation = this.f67078a.getLastKnownLocation(this.f67079b);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                k.b("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + currentTimeMillis2);
                return lastKnownLocation;
            }
            return (Location) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268297400, "Lcom/bytedance/sdk/openadsdk/core/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268297400, "Lcom/bytedance/sdk/openadsdk/core/k/b;");
                return;
            }
        }
        f67069d = new Handler(Looper.getMainLooper());
    }

    public static com.bytedance.sdk.openadsdk.core.k.a c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            com.bytedance.sdk.openadsdk.core.k.a aVar = null;
            if (!h.d().f().isCanUseLocation()) {
                try {
                    TTLocation b2 = b();
                    if (b2 != null) {
                        return new com.bytedance.sdk.openadsdk.core.k.a(Double.valueOf(b2.getLatitude()).floatValue(), Double.valueOf(b2.getLongitude()).floatValue(), System.currentTimeMillis());
                    }
                } catch (Throwable unused) {
                }
                return null;
            }
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager != null) {
                try {
                    Location a2 = a(locationManager);
                    if (a2 != null && b(a2)) {
                        aVar = new com.bytedance.sdk.openadsdk.core.k.a((float) a2.getLatitude(), (float) a2.getLongitude(), System.currentTimeMillis());
                    }
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        new Handler(Looper.getMainLooper()).post(new Runnable(context, locationManager) { // from class: com.bytedance.sdk.openadsdk.core.k.b.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Context f67071a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ LocationManager f67072b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {context, locationManager};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f67071a = context;
                                this.f67072b = locationManager;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    b.b(this.f67071a, this.f67072b);
                                }
                            }
                        });
                    } else {
                        b(context, locationManager);
                    }
                } catch (Throwable th) {
                    if (k.c()) {
                        th.printStackTrace();
                    }
                }
            }
            return aVar;
        }
        return (com.bytedance.sdk.openadsdk.core.k.a) invokeL.objValue;
    }

    public static TTLocation b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                f fVar = new f(new a(), 1, 2);
                e.a(new g("getLastKnownLocation", fVar) { // from class: com.bytedance.sdk.openadsdk.core.k.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f67074a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67074a = fVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f67074a.run();
                        }
                    }
                });
                TTLocation tTLocation = (TTLocation) fVar.get(1L, TimeUnit.SECONDS);
                k.b("AdLocationUtils", "location dev:" + tTLocation);
                return tTLocation;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (TTLocation) invokeV.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.k.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (h.d().f().isCanUseLocation() || h.d().f().getTTLocation() != null) {
                com.bytedance.sdk.openadsdk.core.k.a aVar = f67067b;
                Context a2 = context == null ? o.a() : context.getApplicationContext();
                k.b("AdLocationUtils", "Location cache time =", Long.valueOf(f67066a));
                if (f67067b != null && !a()) {
                    return f67067b;
                }
                String a3 = h.a("sdk_ad_location", f67066a);
                if (!TextUtils.isEmpty(a3)) {
                    try {
                        JSONObject jSONObject = new JSONObject(a3);
                        String string = jSONObject.getString("latitude");
                        String string2 = jSONObject.getString("longitude");
                        long j2 = jSONObject.getLong("lbstime");
                        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            f67067b = new com.bytedance.sdk.openadsdk.core.k.a(Float.valueOf(string).floatValue(), Float.valueOf(string2).floatValue(), j2);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (a()) {
                    f67068c = System.currentTimeMillis();
                    k.c("AdLocationUtils", "Locating ...");
                    e.a(new g("getLocation c", a2) { // from class: com.bytedance.sdk.openadsdk.core.k.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Context f67070a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r7);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {r7, a2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((String) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f67070a = a2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.core.k.a c2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (c2 = b.c(this.f67070a)) == null) {
                                return;
                            }
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("latitude", Float.toString(c2.f67063a));
                                jSONObject2.put("longitude", Float.toString(c2.f67064b));
                                jSONObject2.put("lbstime", c2.f67065c);
                                h.a("sdk_ad_location", jSONObject2.toString());
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            com.bytedance.sdk.openadsdk.core.k.a unused = b.f67067b = c2;
                        }
                    });
                }
                if (f67067b == null) {
                    f67067b = aVar;
                    k.c("AdLocationUtils", "Use the last valid location");
                }
                return f67067b;
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.core.k.a) invokeL.objValue;
    }

    public static String b(LocationManager locationManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, locationManager)) == null) {
            if (locationManager.isProviderEnabled("gps")) {
                return "gps";
            }
            if (locationManager.isProviderEnabled("network")) {
                return "network";
            }
            if (locationManager.isProviderEnabled("passive")) {
                return "passive";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context, LocationManager locationManager) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, context, locationManager) == null) || context == null || locationManager == null) {
            return;
        }
        LocationListener locationListener = new LocationListener(locationManager) { // from class: com.bytedance.sdk.openadsdk.core.k.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LocationManager f67075a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {locationManager};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67075a = locationManager;
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, location) == null) {
                    if (location != null) {
                        b.b(location);
                    }
                    b.b(this.f67075a, this);
                }
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                }
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i2, Bundle bundle) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048579, this, str, i2, bundle) == null) {
                }
            }
        };
        try {
            String b2 = b(locationManager);
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            locationManager.requestSingleUpdate(b2, locationListener, Looper.getMainLooper());
            f67069d.postDelayed(new Runnable(locationManager, locationListener) { // from class: com.bytedance.sdk.openadsdk.core.k.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LocationManager f67076a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LocationListener f67077b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {locationManager, locationListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67076a = locationManager;
                    this.f67077b = locationListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        b.b(this.f67076a, this.f67077b);
                    }
                }
            }, 30000L);
        } catch (Throwable th) {
            if (k.c()) {
                th.printStackTrace();
            }
            b(locationManager, locationListener);
        }
    }

    public static void b(LocationManager locationManager, LocationListener locationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, locationManager, locationListener) == null) || locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (k.c()) {
                th.printStackTrace();
            }
        }
    }

    public static boolean b(Location location) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, location)) == null) ? (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true : invokeL.booleanValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? System.currentTimeMillis() - f67068c > f67066a : invokeV.booleanValue;
    }

    public static Location a(LocationManager locationManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, locationManager)) == null) {
            Location a2 = a(locationManager, "gps");
            if (a2 == null) {
                a2 = a(locationManager, "network");
            }
            return a2 == null ? a(locationManager, "passive") : a2;
        }
        return (Location) invokeL.objValue;
    }

    public static Location a(LocationManager locationManager, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, locationManager, str)) == null) {
            try {
                f fVar = new f(new CallableC1913b(locationManager, str), 1, 2);
                e.a(new g("getLastKnownLocation", fVar) { // from class: com.bytedance.sdk.openadsdk.core.k.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f67073a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, fVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67073a = fVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f67073a.run();
                        }
                    }
                });
                return (Location) fVar.get(1L, TimeUnit.SECONDS);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Location) invokeLL.objValue;
    }
}
