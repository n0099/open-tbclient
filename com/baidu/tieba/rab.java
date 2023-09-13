package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.qab;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rab {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static volatile rab l;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ScheduledExecutorService b;
    public ExecutorService c;
    public uab d;
    public qab e;
    public int f;
    public boolean g;
    public jbb h;
    public boolean i;
    public boolean j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public a(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "sendArrivalData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.E();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bbb a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ rab c;

        public b(rab rabVar, bbb bbbVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, bbbVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            this.a = bbbVar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "processUploadRealTimeEvent#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.c.e.w(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ rab c;

        public c(rab rabVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (this.a) {
                    this.c.e.Q(this.b);
                } else {
                    this.c.e.P(this.b);
                }
                wbb.m().B(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public d(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.e == null) {
                return;
            }
            this.a.e.S();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public e(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (Math.abs(System.currentTimeMillis() - ybb.a().c("ubc_last_upload_all_time", 0L)) < 3600000) {
                    return;
                }
                this.a.e.S();
                long currentTimeMillis = System.currentTimeMillis();
                ybb.a().e("ubc_last_upload_all_time", currentTimeMillis);
                ybb.a().e("ubc_last_upload_non_real", currentTimeMillis);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public f(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.e == null) {
                return;
            }
            this.a.e.M();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public g(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qab.c a;
        public final /* synthetic */ rab b;

        public h(rab rabVar, qab.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rabVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.b.e.N(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qab.c a;
        public final /* synthetic */ rab b;

        public i(rab rabVar, qab.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rabVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.b.e.N(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public j(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "processOneFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public k(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public l(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.e.F();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public kbb a;
        public boolean b;
        public gbb c;
        public final /* synthetic */ rab d;

        public m(rab rabVar, kbb kbbVar, boolean z, gbb gbbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, kbbVar, Boolean.valueOf(z), gbbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rabVar;
            this.a = kbbVar;
            this.b = z;
            this.c = gbbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "ConfigUpdateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.d.e.K(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public bbb a;
        public String b;
        public final /* synthetic */ rab c;

        public n(rab rabVar, String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, str2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            this.a = new bbb(str, str2, i);
            this.b = str;
        }

        public n(rab rabVar, String str, String str2, int i, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, str2, Integer.valueOf(i), str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            bbb bbbVar = new bbb(str, str2, i);
            this.a = bbbVar;
            this.b = str;
            bbbVar.r(str3);
        }

        public n(rab rabVar, String str, String str2, int i, String str3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            this.a = new bbb(str, str2, i, str3, i2);
            this.b = str;
        }

        public n(rab rabVar, String str, String str2, int i, String str3, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, str2, Integer.valueOf(i), str3, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            this.a = new bbb(str, str2, i, str3, j, i2);
            this.b = str;
        }

        public n(rab rabVar, String str, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            this.a = new bbb(str, jSONObject, i);
            this.b = str;
        }

        public n(rab rabVar, String str, JSONObject jSONObject, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, jSONObject, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65541, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            bbb bbbVar = new bbb(str, jSONObject, i);
            this.a = bbbVar;
            this.b = str;
            bbbVar.r(str2);
        }

        public final boolean a(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
                if ((i & 16) != 0 && !pbb.i().c(str)) {
                    return false;
                }
                if (this.c.d != null && !this.c.d.g(str, i)) {
                    return false;
                }
                if (this.c.d != null && this.c.d.F(str)) {
                    return false;
                }
                if (this.c.d != null && this.c.d.h(str)) {
                    return false;
                }
                if (this.c.d != null && this.c.d.d(str)) {
                    return false;
                }
                return true;
            }
            return invokeLI.booleanValue;
        }

        public final void b(String str, String str2) {
            int length;
            int s;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && (length = str2.length()) > (s = uab.o().s())) {
                rbb.a().g(String.valueOf(s), String.valueOf(length), str);
                if (rab.k) {
                    Log.e("UBCBehaviorProcessor", "UBC log too large, id=" + str + ", content=" + str2);
                    throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", Integer.valueOf(length / 1024), Integer.valueOf(s / 1024), str, str2));
                }
            }
        }

        public final void c() {
            bbb bbbVar;
            JSONObject m;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (bbbVar = this.a) == null) {
                return;
            }
            String l = bbbVar.l();
            if (TextUtils.isEmpty(l)) {
                return;
            }
            String f = this.a.f();
            if (TextUtils.isEmpty(f) && (m = this.a.m()) != null) {
                try {
                    f = m.toString();
                } catch (ConcurrentModificationException e) {
                    if (this.c.h != null) {
                        this.c.h.b(l, e.toString());
                        return;
                    }
                    return;
                }
            }
            if (!TextUtils.isEmpty(f)) {
                b(l, f);
                if (this.c.h != null) {
                    this.c.h.a(l, f);
                }
            }
        }

        public void d(boolean z) {
            bbb bbbVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (bbbVar = this.a) != null) {
                bbbVar.u(z);
            }
        }

        public void e(String str) {
            bbb bbbVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (bbbVar = this.a) != null) {
                bbbVar.x(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (this.c.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                if (!this.c.i) {
                    if (this.c.h == null) {
                        this.c.h = (jbb) ServiceManager.getService(jbb.a);
                    }
                    this.c.i = true;
                }
                if (this.c.d != null && this.c.d.b(this.b) == 1) {
                    c();
                }
                if (this.a.j() == -1) {
                    if (!a(this.a.l(), this.a.n())) {
                        return;
                    }
                    if (this.c.d != null && this.c.d.J(this.a.l())) {
                        d(true);
                    }
                    lbb.f().a(this.a.l(), true);
                }
                this.a.v();
                String l = this.a.l();
                if (TextUtils.isEmpty(l)) {
                    return;
                }
                if (this.c.d != null) {
                    String j = this.c.d.j(l);
                    if (!TextUtils.isEmpty(j)) {
                        this.a.s(j);
                    }
                }
                if (this.c.d != null && this.c.d.b(this.b) == 2) {
                    c();
                }
                if (this.a.j() == -1 && TextUtils.equals(l, "1876")) {
                    this.c.e.C(this.a);
                } else if ((this.a.n() & 8) != 0) {
                    this.c.e.B(this.a);
                } else if ((this.a.n() & 128) != 0) {
                    if (this.c.j) {
                        this.c.e.t(this.a);
                    } else {
                        this.c.e.A(this.a);
                    }
                } else if (this.a != null && this.c.d != null && this.c.d.f(l)) {
                    this.c.e.X(this.a);
                } else if (this.c.j) {
                    this.c.e.t(this.a);
                } else {
                    this.c.e.A(this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public final /* synthetic */ rab c;

        public o(rab rabVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rabVar;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "FlowCancelRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.c.e.h(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public dbb a;
        public final /* synthetic */ rab b;

        public p(rab rabVar, Flow flow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, flow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rabVar;
            dbb dbbVar = new dbb(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.a = dbbVar;
            dbbVar.q(flow.getStartTime());
            this.a.C("1");
            rab.n(rabVar);
        }

        public p(rab rabVar, Flow flow, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, flow, str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = rabVar;
            dbb dbbVar = new dbb(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.a = dbbVar;
            dbbVar.q(flow.getStartTime());
            this.a.C("1");
            rab.n(rabVar);
            this.a.r(str2);
        }

        public p(rab rabVar, Flow flow, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, flow, jSONObject};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.b = rabVar;
            dbb dbbVar = new dbb(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.a = dbbVar;
            dbbVar.q(flow.getStartTime());
            this.a.C("1");
            rab.n(rabVar);
        }

        public p(rab rabVar, Flow flow, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, flow, jSONObject, str};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.b = rabVar;
            dbb dbbVar = new dbb(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.a = dbbVar;
            dbbVar.q(flow.getStartTime());
            this.a.C("1");
            rab.n(rabVar);
            this.a.r(str);
        }

        public void a(boolean z) {
            dbb dbbVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (dbbVar = this.a) != null) {
                dbbVar.u(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.b.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.a.x();
                if (!TextUtils.isEmpty(this.b.d.j(this.a.l()))) {
                    this.a.s(this.b.d.j(this.a.l()));
                }
                this.b.e.I(this.a);
                pbb.q(this.b.f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public int c;
        public long d;
        public JSONArray e;
        public final /* synthetic */ rab f;

        public q(rab rabVar, String str, int i, int i2, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, Integer.valueOf(i), Integer.valueOf(i2), jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rabVar;
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = System.currentTimeMillis();
            this.e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "FlowEndRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                lbb.f().a(this.a, true);
                this.f.e.l(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public String c;
        public final /* synthetic */ rab d;

        public r(rab rabVar, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rabVar;
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.e == null) {
                    if (rab.k) {
                        Log.d("UBCBehaviorProcessor", "FlowUpdateRunnable#ubc init not finish");
                        return;
                    }
                    return;
                }
                this.d.e.L(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rab a;

        public s(rab rabVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rabVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rabVar;
        }

        public /* synthetic */ s(rab rabVar, d dVar) {
            this(rabVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.a.d = uab.o();
                this.a.e = new qab(this.a.a);
                this.a.e.H();
                rab rabVar = this.a;
                rabVar.j = rabVar.d.N();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948116310, "Lcom/baidu/tieba/rab;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948116310, "Lcom/baidu/tieba/rab;");
                return;
            }
        }
        k = pbb.m();
    }

    public rab() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        y(pbb.b());
    }

    public static rab w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (l == null) {
                synchronized (rab.class) {
                    if (l == null) {
                        l = new rab();
                    }
                }
            }
            return l;
        }
        return (rab) invokeV.objValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.execute(new k(this));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.execute(new j(this));
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !qk1.g()) {
            return;
        }
        this.b.execute(new a(this));
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.execute(new l(this));
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.g) {
            return;
        }
        this.g = true;
        this.b.execute(new e(this));
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b.execute(new f(this));
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b.execute(new d(this));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.b.execute(new g(this));
        }
    }

    public static /* synthetic */ int n(rab rabVar) {
        int i2 = rabVar.f;
        rabVar.f = i2 + 1;
        return i2;
    }

    public void R(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            S(jSONObject, null);
        }
    }

    public String x(String str) {
        InterceptResult invokeL;
        int q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            qab qabVar = this.e;
            if (qabVar != null && (q2 = qabVar.q(str)) != -1) {
                return String.valueOf(q2);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public void I(bbb bbbVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bbbVar, z) == null) {
            this.b.execute(new b(this, bbbVar, z));
        }
    }

    public void J(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, runnable, j2) == null) {
            this.b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void S(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, jSONObject, str) == null) {
            T(jSONObject, str, false, null, null);
        }
    }

    public void V(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            this.b.execute(new c(this, z, str));
        }
    }

    public void s(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, str, i2) == null) {
            this.b.execute(new o(this, str, i2));
        }
    }

    public void A(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i2) == null) {
            this.b.execute(new n(this, str, str2, i2));
        }
    }

    public void C(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject, i2) == null) {
            this.b.execute(new n(this, str, jSONObject, i2));
        }
    }

    public void M(kbb kbbVar, boolean z, gbb gbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{kbbVar, Boolean.valueOf(z), gbbVar}) == null) {
            this.b.execute(new m(this, kbbVar, z, gbbVar));
        }
    }

    public void N(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, str, i2, str2) == null) {
            this.b.execute(new r(this, str, i2, str2));
        }
    }

    public void B(String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2, str3) == null) {
            this.b.execute(new n(this, str, str2, i2, str3));
        }
    }

    public void D(String str, JSONObject jSONObject, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, str, jSONObject, i2, str2) == null) {
            this.b.execute(new n(this, str, jSONObject, i2, str2));
        }
    }

    public void U(JSONObject jSONObject, boolean z, bbb bbbVar, hbb hbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{jSONObject, Boolean.valueOf(z), bbbVar, hbbVar}) == null) {
            T(jSONObject, null, z, bbbVar, hbbVar);
        }
    }

    public void z(String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048609, this, str, str2, str3, i2) == null) {
            n nVar = new n(this, str, str2, i2);
            if (!TextUtils.isEmpty(str3)) {
                nVar.e(str3);
            }
            this.b.execute(nVar);
        }
    }

    public void F(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.b.execute(new n(this, str, str2, i2, str3, i3));
        }
    }

    public void G(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.b.execute(new n(this, str, str2, i2, str3, j2, i3));
        }
    }

    public void Q(zbb zbbVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, zbbVar, str) == null) {
            if (k) {
                Log.d("UBCBehaviorProcessor", "uploadData isDataInFile:" + zbbVar.x());
                if (zbbVar.x()) {
                    zbbVar.F("UBCDEBUG");
                } else {
                    Log.d("UBCDEBUG", zbbVar.u().toString());
                }
            }
            if (!pbb.l() && !zbbVar.A()) {
                return;
            }
            qab.c cVar = new qab.c();
            boolean x = zbbVar.x();
            cVar.a = x;
            if (x) {
                cVar.c = zbbVar.o();
                cVar.f = zbbVar.m();
            } else {
                cVar.d = zbbVar.u();
            }
            cVar.h = zbbVar.A();
            cVar.e = str;
            wbb.m().z();
            this.c.execute(new i(this, cVar));
        }
    }

    public Flow t(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f, i2);
            uab uabVar = this.d;
            if (uabVar != null && !uabVar.g(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !pbb.i().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                uab uabVar2 = this.d;
                if (uabVar2 != null && uabVar2.h(str)) {
                    flow.setValid(false);
                    return flow;
                }
                uab uabVar3 = this.d;
                if (uabVar3 != null && uabVar3.F(str)) {
                    flow.setValid(false);
                    return flow;
                }
                uab uabVar4 = this.d;
                if (uabVar4 != null && !uabVar4.K(str)) {
                    flow.setValid(false);
                }
                return flow;
            }
        }
        return (Flow) invokeLI.objValue;
    }

    public final void T(JSONObject jSONObject, String str, boolean z, bbb bbbVar, hbb hbbVar) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{jSONObject, str, Boolean.valueOf(z), bbbVar, hbbVar}) == null) {
            if (k) {
                Log.d("UBCBehaviorProcessor", "uploadData:" + str);
                Log.d("UBCDEBUG", jSONObject.toString());
            }
            boolean l2 = pbb.l();
            if (bbbVar != null && (bbbVar.n() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!l2 && !z2) {
                return;
            }
            qab.c cVar = new qab.c();
            cVar.a = false;
            cVar.d = jSONObject;
            cVar.e = str;
            cVar.g = z;
            cVar.h = z2;
            cVar.b = bbbVar;
            cVar.i = hbbVar;
            this.c.execute(new h(this, cVar));
        }
    }

    public synchronized Flow o(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, str, str2, i2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, str2);
                    if (this.d != null && this.d.J(str)) {
                        pVar.a(true);
                    }
                    this.b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLI.objValue;
    }

    public synchronized Flow q(String str, JSONObject jSONObject, int i2) {
        InterceptResult invokeLLI;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048601, this, str, jSONObject, i2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, jSONObject);
                    if (this.d != null && this.d.J(str)) {
                        pVar.a(true);
                    }
                    this.b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLI.objValue;
    }

    public synchronized Flow p(String str, String str2, int i2, String str3) {
        InterceptResult invokeLLIL;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048600, this, str, str2, i2, str3)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, str2, str3);
                    if (this.d != null && this.d.J(str)) {
                        pVar.a(true);
                    }
                    this.b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public synchronized Flow r(String str, JSONObject jSONObject, int i2, String str2) {
        InterceptResult invokeLLIL;
        Flow t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048602, this, str, jSONObject, i2, str2)) == null) {
            synchronized (this) {
                t = t(str, i2);
                if (t != null && t.getValid()) {
                    p pVar = new p(this, t, jSONObject, str2);
                    if (this.d != null && this.d.J(str)) {
                        pVar.a(true);
                    }
                    this.b.execute(pVar);
                }
            }
            return t;
        }
        return (Flow) invokeLLIL.objValue;
    }

    public void u(String str, int i2, int i3, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), jSONArray}) == null) {
            this.b.execute(new q(this, str, i2, i3, jSONArray));
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, context) == null) && this.a == null && context != null) {
            if (context instanceof Application) {
                this.a = context;
            } else {
                this.a = context.getApplicationContext();
            }
            this.f = pbb.d();
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.b = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.execute(new s(this, null));
            this.c = Executors.newSingleThreadExecutor();
        }
    }
}
