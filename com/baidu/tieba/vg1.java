package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nh1 a;

        /* renamed from: com.baidu.tieba.vg1$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0501a extends nh1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONArray a;
            public final /* synthetic */ a b;

            public C0501a(a aVar, JSONArray jSONArray) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONArray};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = jSONArray;
            }

            @Override // com.baidu.tieba.nh1
            public void a(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    nh1 nh1Var = this.b.a;
                    if (nh1Var != null) {
                        nh1Var.a(i, str);
                    }
                    if (i == 1) {
                        vg1.e(this.a);
                    }
                }
            }
        }

        public a(nh1 nh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nh1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (a = vg1.a()) == null) {
                return;
            }
            rg1.d(a, new C0501a(this, a));
        }
    }

    public static /* synthetic */ JSONArray a() {
        return c();
    }

    public static void f(nh1 nh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, nh1Var) == null) {
            uh1.a(new a(nh1Var));
        }
    }

    public static synchronized JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (vg1.class) {
                File file = new File(gi1.a().getFilesDir(), "poly_cashier_commission_record_cache.json");
                JSONArray jSONArray = null;
                if (!file.exists()) {
                    return null;
                }
                try {
                    JSONArray jSONArray2 = new JSONArray(ai1.b(file));
                    try {
                        file.delete();
                    } catch (JSONException unused) {
                    }
                    jSONArray = jSONArray2;
                } catch (JSONException unused2) {
                }
                return jSONArray;
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
        } catch (JSONException unused) {
        }
        JSONArray c = c();
        if (c == null) {
            c = new JSONArray();
        }
        c.put(jSONObject);
        if (c.length() > 100) {
            c.remove(0);
        }
        e(c);
    }

    public static synchronized void e(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray) == null) {
            synchronized (vg1.class) {
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        ai1.d(jSONArray.toString(), new File(gi1.a().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                    }
                }
            }
        }
    }
}
