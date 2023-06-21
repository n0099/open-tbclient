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
public class ys1 implements us1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public g14 c;
    public vs1 d;
    public p04 e;
    public List<ts1> f;
    public ts1 g;
    public ts1 h;
    public Map<String, String> i;
    public f14 j;

    /* loaded from: classes8.dex */
    public class a implements f14 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ys1 a;

        @Override // com.baidu.tieba.f14
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(ys1 ys1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ys1Var;
        }

        @Override // com.baidu.tieba.f14
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(xs1.b(str));
                i14.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.f14
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (ts1 ts1Var : this.a.f) {
                        ts1Var.a(0);
                        if (this.a.f.contains(ts1Var)) {
                            this.a.f.remove(ts1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (ts1 ts1Var2 : this.a.f) {
                    ts1Var2.a(1001);
                    if (this.a.f.contains(ts1Var2)) {
                        this.a.f.remove(ts1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.f14
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

        @Override // com.baidu.tieba.f14
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(xs1.a(z));
            }
        }
    }

    public ys1(@NonNull JSONObject jSONObject, vs1 vs1Var, ts1 ts1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, vs1Var, ts1Var};
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
            this.i = i14.a("video", "app", optString, this.a, false);
            this.e = new zs1();
            g14 g14Var = new g14(mx2.T().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = g14Var;
            g14Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, ts1Var, vs1Var);
            return;
        }
        ts1Var.a(202);
    }

    @Override // com.baidu.tieba.us1
    public synchronized void a(JSONObject jSONObject, ts1 ts1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, ts1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = ts1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.us1
    public synchronized void b(JSONObject jSONObject, ts1 ts1Var, vs1 vs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, ts1Var, vs1Var) == null) {
            synchronized (this) {
                this.d = vs1Var;
                if (this.c != null) {
                    this.g = ts1Var;
                    if (ts1Var != null && !this.f.contains(ts1Var)) {
                        this.f.add(ts1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
