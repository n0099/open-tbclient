package com.baidu.tieba;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.http.ContentType;
import com.fun.ad.sdk.internal.api.http.PostRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.j0;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u6b implements Reporter {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;
    public final Handler c;
    public final LinkedList<d> d;
    public boolean e;

    /* loaded from: classes8.dex */
    public interface d {
        int a();

        d a(d dVar);

        boolean b();

        void c();

        JSONArray d();

        boolean isEmpty();
    }

    /* loaded from: classes8.dex */
    public static abstract class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948164360, "Lcom/baidu/tieba/u6b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948164360, "Lcom/baidu/tieba/u6b;");
                return;
            }
        }
        f = !u6b.class.desiredAssertionStatus();
    }

    public u6b(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new LinkedList<>();
        this.e = true;
        this.a = str;
        this.b = z;
        HandlerThread handlerThread = new HandlerThread("reporter2");
        handlerThread.start();
        a aVar = new a(this, handlerThread.getLooper());
        this.c = aVar;
        if (z) {
            aVar.obtainMessage(3, l6b.k(), 0).sendToTarget();
        }
        com.fun.j0.b(new b(this));
    }

    public final boolean c(JSONArray jSONArray) {
        InterceptResult invokeL;
        Response response;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            try {
                response = new PostRequest(this.a, new RequestParams(jSONArray.toString(), ContentType.JSON), true).perform();
            } catch (IOException e2) {
                LogPrinter.e(e2);
                response = null;
            }
            return response != null && response.getResponseCode() == 200;
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            logEvent(str, jSONObject);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, map) == null) {
            logEvent(str, new JSONObject(map));
        }
    }

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u6b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u6b u6bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u6bVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u6bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            int i2 = message.arg1;
                            int l = l6b.l();
                            int h = l6b.h();
                            int i3 = (i2 - l) - h;
                            LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i2), Integer.valueOf(l), Integer.valueOf(h), Integer.valueOf(i3));
                            if (i3 > 0) {
                                l6b.g("key_rpt_mis_c", i3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    LogPrinter.v("turn on report switch", new Object[0]);
                    this.a.e = true;
                }
                u6b.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements j0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u6b a;

        public b(u6b u6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u6bVar;
        }

        @Override // com.fun.j0.b
        public void a(@Nullable NetworkInfo networkInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    this.a.c.removeMessages(1);
                    this.a.c.sendEmptyMessage(1);
                    return;
                }
                this.a.c.removeMessages(1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final JSONArray a;
        public final /* synthetic */ u6b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(u6b u6bVar, e eVar) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u6bVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u6bVar;
            this.a = new JSONArray();
            a(eVar);
        }

        @Override // com.baidu.tieba.u6b.d
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.length() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.length() >= 10 : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                for (int i = 0; i < this.a.length(); i++) {
                    try {
                        HostAppInfo.fillHostAppInfo(this.a.optJSONObject(i));
                    } catch (JSONException unused) {
                    }
                }
                return this.a;
            }
            return (JSONArray) invokeV.objValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.length() <= 0 : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
                if (b()) {
                    return this;
                }
                if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    this.a.put(eVar.e());
                    eVar.e = true;
                    eVar.d = null;
                    return this;
                } else if (dVar instanceof c) {
                    c cVar = (c) dVar;
                    while (!b() && cVar.a.length() > 0) {
                        this.a.put(cVar.a.remove(0));
                    }
                    return this;
                } else {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.v("ArrayEvent reported succeed with len:%d", Integer.valueOf(this.a.length()));
                if (this.b.b) {
                    l6b.g("key_rpt_suc_c", l6b.l() + this.a.length());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final JSONObject b;
        public long c;
        public JSONObject d;
        public boolean e;
        public final /* synthetic */ u6b f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(u6b u6bVar, String str, JSONObject jSONObject) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u6bVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = u6bVar;
            this.a = str;
            this.b = jSONObject;
            this.c = System.currentTimeMillis();
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // com.baidu.tieba.u6b.d
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
                if (dVar instanceof e) {
                    c cVar = new c(this.f, this);
                    cVar.a(dVar);
                    return cVar;
                } else if (dVar instanceof c) {
                    c cVar2 = (c) dVar;
                    cVar2.a(this);
                    return cVar2;
                } else {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject e = e();
                if (e == null) {
                    return null;
                }
                try {
                    HostAppInfo.fillHostAppInfo(e);
                } catch (JSONException unused) {
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(e);
                return jSONArray;
            }
            return (JSONArray) invokeV.objValue;
        }

        public JSONObject e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.e) {
                    return null;
                }
                if (this.d == null) {
                    this.d = HostAppInfo.buildBaseJson(this.a, this.b, this.c);
                }
                return this.d;
            }
            return (JSONObject) invokeV.objValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? e() == null : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "{key='" + this.a + "', content=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.u6b.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.v("JSONEvent reported succeed", new Object[0]);
                if (e() != null && this.f.b) {
                    l6b.g("key_rpt_suc_c", l6b.l() + 1);
                }
            }
        }
    }

    public static void a(u6b u6bVar) {
        d pollFirst;
        JSONArray jSONArray;
        d peekFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, u6bVar) == null) {
            while (u6bVar.e) {
                synchronized (u6bVar.d) {
                    pollFirst = u6bVar.d.pollFirst();
                    if (pollFirst != null) {
                        while (!pollFirst.b() && !u6bVar.d.isEmpty() && (peekFirst = u6bVar.d.peekFirst()) != null) {
                            pollFirst = pollFirst.a(peekFirst);
                            if (peekFirst.isEmpty()) {
                                u6bVar.d.removeFirst();
                            } else if (!f && !pollFirst.b()) {
                                throw new AssertionError();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (u6bVar.c(pollFirst.d())) {
                    pollFirst.c();
                    if (u6bVar.b) {
                        int h = l6b.h();
                        int j = l6b.j();
                        if (h > 0 || j > 0) {
                            int l = l6b.l();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("fai", h);
                                jSONObject.put("suc", l);
                                jSONObject.put("mis", j);
                            } catch (JSONException unused) {
                            }
                            JSONObject e2 = new e(u6bVar, "k_rpt", jSONObject).e();
                            if (e2 == null) {
                                jSONArray = null;
                            } else {
                                try {
                                    HostAppInfo.fillHostAppInfo(e2);
                                } catch (JSONException unused2) {
                                }
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(e2);
                                jSONArray = jSONArray2;
                            }
                            if (u6bVar.c(jSONArray)) {
                                l6b.f(h, l, j);
                            }
                        }
                    }
                } else {
                    synchronized (u6bVar.d) {
                        if (u6bVar.d.size() >= 1000) {
                            if (u6bVar.b) {
                                l6b.e(pollFirst.a());
                            }
                        } else {
                            u6bVar.d.addFirst(pollFirst);
                            LogPrinter.v("turn off report switch, reScheduleReport delay:%dms", 1500L);
                            u6bVar.e = false;
                            if (!u6bVar.c.hasMessages(2)) {
                                u6bVar.c.sendEmptyMessageDelayed(2, 1500L);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jSONObject) == null) {
            boolean z = false;
            if (z5b.i(str, jSONObject)) {
                LogPrinter.d("filter key:%s content:%s", str, jSONObject);
                return;
            }
            e eVar = new e(this, str, jSONObject);
            if (this.b) {
                l6b.o();
            }
            synchronized (this.d) {
                if (this.d.size() >= 1000) {
                    d removeFirst = this.d.removeFirst();
                    if (this.b && removeFirst != null) {
                        l6b.e(removeFirst.a());
                    }
                }
                this.d.add(eVar);
            }
            if (!this.c.hasMessages(1)) {
                Handler handler = this.c;
                long j = 0;
                long j2 = l6b.b.getLong("key_flt", 0L);
                if (j2 > 0 && System.currentTimeMillis() - j2 >= 86400000) {
                    z = true;
                }
                if (z) {
                    j = 5000;
                }
                handler.sendEmptyMessageDelayed(1, j);
            }
        }
    }
}
