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
public class xj1 implements tj1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public fs3 c;
    public uj1 d;
    public or3 e;
    public List<sj1> f;
    public sj1 g;
    public sj1 h;
    public Map<String, String> i;
    public es3 j;

    /* loaded from: classes6.dex */
    public class a implements es3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj1 a;

        public a(xj1 xj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj1Var;
        }

        @Override // com.baidu.tieba.es3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (sj1 sj1Var : this.a.f) {
                        sj1Var.a(0);
                        if (this.a.f.contains(sj1Var)) {
                            this.a.f.remove(sj1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (sj1 sj1Var2 : this.a.f) {
                    sj1Var2.a(1001);
                    if (this.a.f.contains(sj1Var2)) {
                        this.a.f.remove(sj1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.es3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.h.a(0);
                } else {
                    this.a.h.a(1001);
                }
            }
        }

        @Override // com.baidu.tieba.es3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(wj1.a(z));
            }
        }

        @Override // com.baidu.tieba.es3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.es3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(wj1.b(str));
                hs3.k(this.a.i, str);
            }
        }
    }

    public xj1(@NonNull JSONObject jSONObject, uj1 uj1Var, sj1 sj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, uj1Var, sj1Var};
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
            this.i = hs3.a("video", "app", optString, this.a, false);
            this.e = new yj1();
            fs3 fs3Var = new fs3(lo2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = fs3Var;
            fs3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, sj1Var, uj1Var);
            return;
        }
        sj1Var.a(202);
    }

    @Override // com.baidu.tieba.tj1
    public synchronized void a(JSONObject jSONObject, sj1 sj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, sj1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = sj1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.tj1
    public synchronized void b(JSONObject jSONObject, sj1 sj1Var, uj1 uj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, sj1Var, uj1Var) == null) {
            synchronized (this) {
                this.d = uj1Var;
                if (this.c != null) {
                    this.g = sj1Var;
                    if (sj1Var != null && !this.f.contains(sj1Var)) {
                        this.f.add(sj1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
