package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends cq1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;

        public a(int i, int i2, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = context;
        }

        @Override // com.baidu.tieba.cq1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.b);
                    jSONObject.put("1", System.currentTimeMillis());
                    jSONObject.put("2", this.c);
                    jSONObject.put("3", this.d);
                    jSONObject.put("4", "1");
                    jSONArray.put(jSONObject);
                    vp1.c(this.e).f(jSONArray.toString(), "1077112", 2);
                } catch (Throwable th) {
                    hq1.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends cq1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Context g;

        public b(int i, long j, int i2, int i3, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i;
            this.c = j;
            this.d = i2;
            this.e = i3;
            this.f = str;
            this.g = context;
        }

        @Override // com.baidu.tieba.cq1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = "";
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.b);
                    jSONObject.put("1", "");
                    jSONObject.put("2", Build.VERSION.SDK_INT);
                    jSONObject.put("3", this.c);
                    jSONObject.put("4", this.d);
                    jSONObject.put("5", this.e);
                    if (!TextUtils.isEmpty(this.f)) {
                        str = this.f;
                    }
                    jSONObject.put("6", str);
                    jSONArray.put(jSONObject);
                    vp1.c(this.g).f(jSONArray.toString(), "1077128", 2);
                } catch (Throwable th) {
                    hq1.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends cq1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;

        public c(int i, Context context, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), context, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i;
            this.c = context;
            this.d = i2;
            this.e = i3;
            this.f = str;
        }

        @Override // com.baidu.tieba.cq1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.b);
                    jSONObject.put("3", System.currentTimeMillis());
                    int a0 = ro1.g(this.c).a0();
                    if (a0 != -1) {
                        jSONObject.put("4", a0);
                    }
                    jSONObject.put("5", ro1.g(this.c).b0());
                    jSONObject.put("7", this.d);
                    if (this.e != -1) {
                        jSONObject.put("8", this.e);
                    }
                    jSONObject.put("9", this.f);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", cp1.q);
                    jSONObject.put("12", "1");
                    new pp1(this.c, null).h(jSONObject);
                } catch (Throwable th) {
                    hq1.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends cq1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;

        public d(int i, Context context, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), context, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i;
            this.c = context;
            this.d = i2;
            this.e = i3;
            this.f = str;
        }

        @Override // com.baidu.tieba.cq1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", this.b);
                    jSONObject.put("3", System.currentTimeMillis());
                    int e0 = ro1.g(this.c).e0();
                    if (e0 != -1) {
                        jSONObject.put("4", e0);
                    }
                    jSONObject.put("5", ro1.g(this.c).f0());
                    jSONObject.put("7", this.d);
                    if (this.e != -1) {
                        jSONObject.put("8", this.e);
                    }
                    jSONObject.put("9", this.f);
                    jSONObject.put("10", 1);
                    jSONObject.put("11", cp1.r);
                    jSONObject.put("12", "1");
                    jSONArray.put(jSONObject);
                    vp1.c(this.c).f(jSONArray.toString(), "1077122", 2);
                } catch (Throwable th) {
                    hq1.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends cq1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Context g;

        public e(int i, int i2, String str, int i3, int i4, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = i3;
            this.f = i4;
            this.g = context;
        }

        @Override // com.baidu.tieba.cq1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.e);
                    jSONObject.put("2", this.b);
                    if (this.c != -1) {
                        jSONObject.put("3", this.c);
                    }
                    if (!TextUtils.isEmpty(this.d)) {
                        jSONObject.put("4", this.d);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", cp1.q);
                    jSONObject.put("7", this.f);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    vp1.c(this.g).f(jSONArray.toString(), "1077105", 2);
                } catch (Throwable th) {
                    hq1.d(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends cq1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Context g;

        public f(int i, int i2, String str, int i3, int i4, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = i3;
            this.f = i4;
            this.g = context;
        }

        @Override // com.baidu.tieba.cq1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("0", System.currentTimeMillis());
                    jSONObject.put("1", this.e);
                    jSONObject.put("2", this.b);
                    if (this.c != -1) {
                        jSONObject.put("3", this.c);
                    }
                    if (!TextUtils.isEmpty(this.d)) {
                        jSONObject.put("4", this.d);
                    }
                    jSONObject.put("5", 1);
                    jSONObject.put("6", cp1.r);
                    jSONObject.put("7", this.f);
                    jSONObject.put("8", "1");
                    jSONArray.put(jSONObject);
                    vp1.c(this.g).f(jSONArray.toString(), "1077123", 2);
                } catch (Throwable th) {
                    hq1.d(th);
                }
            }
        }
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            eq1.c().b(new e(i3, i4, str, i, i2, context));
        }
    }

    public static void c(Context context, int i, int i2, long j, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), str}) == null) {
            eq1.c().b(new b(i, j, i3, i2, str, context));
        }
    }

    public static void e(Context context, int i, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            eq1.c().b(new f(i3, i4, str, i, i2, context));
        }
    }

    public static void b(Context context, int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            eq1.c().b(new c(i, context, i3, i2, str));
        }
    }

    public static void f(Context context, int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            eq1.c().b(new d(i, context, i3, i2, str));
        }
    }

    public static void d(Context context, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            eq1.c().b(new a(i, i2, str, context));
        }
    }
}
