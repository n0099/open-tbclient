package com.baidu.tieba;

import android.text.TextUtils;
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
/* loaded from: classes4.dex */
public class lk1 implements hk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public ts3 c;
    public ik1 d;
    public cs3 e;
    public List f;
    public gk1 g;
    public gk1 h;
    public Map i;
    public ss3 j;

    /* loaded from: classes4.dex */
    public class a implements ss3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lk1 a;

        @Override // com.baidu.tieba.ss3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(lk1 lk1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lk1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lk1Var;
        }

        @Override // com.baidu.tieba.ss3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(kk1.b(str));
                vs3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.ss3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (gk1 gk1Var : this.a.f) {
                        gk1Var.a(0);
                        if (this.a.f.contains(gk1Var)) {
                            this.a.f.remove(gk1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (gk1 gk1Var2 : this.a.f) {
                    gk1Var2.a(1001);
                    if (this.a.f.contains(gk1Var2)) {
                        this.a.f.remove(gk1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ss3
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

        @Override // com.baidu.tieba.ss3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(kk1.a(z));
            }
        }
    }

    public lk1(JSONObject jSONObject, ik1 ik1Var, gk1 gk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, ik1Var, gk1Var};
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
            this.i = vs3.a("video", "app", optString, this.a, false);
            this.e = new mk1();
            ts3 ts3Var = new ts3(zo2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = ts3Var;
            ts3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, gk1Var, ik1Var);
            return;
        }
        gk1Var.a(202);
    }

    @Override // com.baidu.tieba.hk1
    public synchronized void a(JSONObject jSONObject, gk1 gk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, gk1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = gk1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.hk1
    public synchronized void b(JSONObject jSONObject, gk1 gk1Var, ik1 ik1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, gk1Var, ik1Var) == null) {
            synchronized (this) {
                this.d = ik1Var;
                if (this.c != null) {
                    this.g = gk1Var;
                    if (gk1Var != null && !this.f.contains(gk1Var)) {
                        this.f.add(gk1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
