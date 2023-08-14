package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.http.PostRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class teb implements Reporter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final String b;

    /* loaded from: classes8.dex */
    public interface c {
        boolean a();
    }

    /* loaded from: classes8.dex */
    public class d extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int f;
        public final int g;
        public final int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(teb tebVar, String str, JSONObject jSONObject, int i, int i2, int i3) {
            super(tebVar, str, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tebVar, str, jSONObject, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((teb) objArr2[0], (String) objArr2[1], (JSONObject) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = i;
            this.g = i2;
            this.h = i3;
        }

        @Override // com.baidu.tieba.teb.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                neb.f(this.f, this.g, this.h);
            }
        }
    }

    public teb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("rep");
        handlerThread.start();
        f fVar = new f(handlerThread.getLooper());
        this.a = fVar;
        this.b = str;
        fVar.obtainMessage(101, neb.k(), 0).sendToTarget();
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
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
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            logEvent(str, new JSONObject(map));
        }
    }

    /* loaded from: classes8.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ teb h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(teb tebVar, String str, JSONObject jSONObject) {
            super(tebVar, str, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tebVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((teb) objArr2[0], (String) objArr2[1], (JSONObject) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = tebVar;
            neb.o();
        }

        @Override // com.baidu.tieba.teb.b
        public void c() {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                neb.g("key_rpt_suc_c", neb.l() + 1);
                teb tebVar = this.h;
                tebVar.getClass();
                int h = neb.h();
                int j = neb.j();
                if (h <= 0 && j <= 0) {
                    dVar = null;
                } else {
                    int l = neb.l();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fai", h);
                        jSONObject.put("suc", l);
                        jSONObject.put("mis", j);
                    } catch (JSONException unused) {
                    }
                    dVar = new d(tebVar, "k_rpt", jSONObject, h, l, j);
                }
                if (dVar != null) {
                    dVar.d();
                }
            }
        }

        @Override // com.baidu.tieba.teb.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                neb.e(1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final JSONObject b;
        public final long c;
        public JSONObject d;
        public final /* synthetic */ teb e;

        public b(teb tebVar, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tebVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tebVar;
            this.a = str;
            this.b = jSONObject;
            this.c = System.currentTimeMillis();
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // com.baidu.tieba.teb.c
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d() : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Event{key=" + this.a + ", content=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean d() {
            boolean z;
            Response perform;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                try {
                    if (this.d == null) {
                        this.d = HostAppInfo.buildReportJson(this.a, this.b, this.c);
                    }
                    perform = new PostRequest(this.e.b, new RequestParams(this.d)).perform();
                } catch (IOException e) {
                    LogPrinter.e(e);
                }
                if (perform != null) {
                    if (perform.getResponseCode() == 200) {
                        z = true;
                        if (!z) {
                            c();
                        } else {
                            b();
                        }
                        return z;
                    }
                }
                z = false;
                if (!z) {
                }
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int f;
        public final /* synthetic */ teb g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(teb tebVar, String str, JSONObject jSONObject) {
            super(tebVar, str, jSONObject);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tebVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((teb) objArr2[0], (String) objArr2[1], (JSONObject) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = tebVar;
            this.f = 0;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.teb.b
        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.f;
                this.f = i + 1;
                if (i >= 3) {
                    LogPrinter.e("Give up report event:" + this, new Object[0]);
                    e();
                    return;
                }
                try {
                    if (this.d == null) {
                        this.d = HostAppInfo.buildReportJson(this.a, this.b, this.c);
                    }
                    this.d.put(HostAppInfo.RETRY_I, this.f);
                } catch (JSONException unused) {
                }
                teb tebVar = this.g;
                tebVar.a.sendMessageDelayed(tebVar.a.obtainMessage(102, this), 2000L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NonNull Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 101) {
                    if (i == 102) {
                        ((c) message.obj).a();
                        return;
                    }
                    return;
                }
                int i2 = message.arg1;
                int l = neb.l();
                int h = neb.h();
                int i3 = (i2 - l) - h;
                LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i2), Integer.valueOf(l), Integer.valueOf(h), Integer.valueOf(i3));
                if (i3 > 0) {
                    neb.g("key_rpt_mis_c", i3);
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, JSONObject jSONObject) {
        Object eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            if (beb.i(str, jSONObject)) {
                LogPrinter.d("filter key:%s content:%s", str, jSONObject);
                return;
            }
            if ("ad".equals(str)) {
                eVar = new a(this, str, jSONObject);
            } else {
                eVar = new e(this, str, jSONObject);
            }
            this.a.sendMessageDelayed(this.a.obtainMessage(102, eVar), 0L);
        }
    }
}
