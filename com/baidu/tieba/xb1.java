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
/* loaded from: classes6.dex */
public class xb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc1 a;

        /* renamed from: com.baidu.tieba.xb1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0469a extends pc1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONArray a;
            public final /* synthetic */ a b;

            public C0469a(a aVar, JSONArray jSONArray) {
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

            @Override // com.baidu.tieba.pc1
            public void a(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    pc1 pc1Var = this.b.a;
                    if (pc1Var != null) {
                        pc1Var.a(i, str);
                    }
                    if (i == 1) {
                        xb1.e(this.a);
                    }
                }
            }
        }

        public a(pc1 pc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pc1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c = xb1.c()) == null) {
                return;
            }
            tb1.d(c, new C0469a(this, c));
        }
    }

    public static void f(pc1 pc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, pc1Var) == null) {
            wc1.a(new a(pc1Var));
        }
    }

    public static synchronized JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (xb1.class) {
                File file = new File(id1.a().getFilesDir(), "poly_cashier_commission_record_cache.json");
                JSONArray jSONArray = null;
                if (!file.exists()) {
                    return null;
                }
                try {
                    JSONArray jSONArray2 = new JSONArray(cd1.b(file));
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
            synchronized (xb1.class) {
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        cd1.d(jSONArray.toString(), new File(id1.a().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                    }
                }
            }
        }
    }
}
