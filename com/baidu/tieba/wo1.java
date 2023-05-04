package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wo1 implements so1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public ex3 c;
    public to1 d;
    public nw3 e;
    public List<ro1> f;
    public ro1 g;
    public ro1 h;
    public Map<String, String> i;
    public dx3 j;

    /* loaded from: classes6.dex */
    public class a implements dx3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo1 a;

        @Override // com.baidu.tieba.dx3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(wo1 wo1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wo1Var;
        }

        @Override // com.baidu.tieba.dx3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(vo1.b(str));
                gx3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.dx3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (ro1 ro1Var : this.a.f) {
                        ro1Var.a(0);
                        if (this.a.f.contains(ro1Var)) {
                            this.a.f.remove(ro1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (ro1 ro1Var2 : this.a.f) {
                    ro1Var2.a(1001);
                    if (this.a.f.contains(ro1Var2)) {
                        this.a.f.remove(ro1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.dx3
        public void c(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
                if (z) {
                    this.a.h.a(0);
                } else {
                    this.a.h.a(1001);
                }
            }
        }

        @Override // com.baidu.tieba.dx3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(vo1.a(z));
            }
        }
    }

    public wo1(@NonNull JSONObject jSONObject, to1 to1Var, ro1 ro1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, to1Var, ro1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.b = optString;
            this.i = gx3.a("video", "app", optString, this.a, false);
            this.e = new xo1();
            ex3 ex3Var = new ex3(kt2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = ex3Var;
            ex3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, ro1Var, to1Var);
            return;
        }
        ro1Var.a(202);
    }

    @Override // com.baidu.tieba.so1
    public synchronized void a(JSONObject jSONObject, ro1 ro1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, ro1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = ro1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.so1
    public synchronized void b(JSONObject jSONObject, ro1 ro1Var, to1 to1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, ro1Var, to1Var) == null) {
            synchronized (this) {
                this.d = to1Var;
                if (this.c != null) {
                    this.g = ro1Var;
                    if (ro1Var != null && !this.f.contains(ro1Var)) {
                        this.f.add(ro1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
