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
/* loaded from: classes8.dex */
public class us1 implements qs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public c14 c;
    public rs1 d;
    public l04 e;
    public List<ps1> f;
    public ps1 g;
    public ps1 h;
    public Map<String, String> i;
    public b14 j;

    /* loaded from: classes8.dex */
    public class a implements b14 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us1 a;

        @Override // com.baidu.tieba.b14
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(us1 us1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us1Var;
        }

        @Override // com.baidu.tieba.b14
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(ts1.b(str));
                e14.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.b14
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (ps1 ps1Var : this.a.f) {
                        ps1Var.a(0);
                        if (this.a.f.contains(ps1Var)) {
                            this.a.f.remove(ps1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (ps1 ps1Var2 : this.a.f) {
                    ps1Var2.a(1001);
                    if (this.a.f.contains(ps1Var2)) {
                        this.a.f.remove(ps1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.b14
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

        @Override // com.baidu.tieba.b14
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(ts1.a(z));
            }
        }
    }

    public us1(@NonNull JSONObject jSONObject, rs1 rs1Var, ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, rs1Var, ps1Var};
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
            this.i = e14.a("video", "app", optString, this.a, false);
            this.e = new vs1();
            c14 c14Var = new c14(ix2.T().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = c14Var;
            c14Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, ps1Var, rs1Var);
            return;
        }
        ps1Var.a(202);
    }

    @Override // com.baidu.tieba.qs1
    public synchronized void a(JSONObject jSONObject, ps1 ps1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, ps1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = ps1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.qs1
    public synchronized void b(JSONObject jSONObject, ps1 ps1Var, rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, ps1Var, rs1Var) == null) {
            synchronized (this) {
                this.d = rs1Var;
                if (this.c != null) {
                    this.g = ps1Var;
                    if (ps1Var != null && !this.f.contains(ps1Var)) {
                        this.f.add(ps1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
