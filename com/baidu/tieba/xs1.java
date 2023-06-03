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
public class xs1 implements ts1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public f14 c;
    public us1 d;
    public o04 e;
    public List<ss1> f;
    public ss1 g;
    public ss1 h;
    public Map<String, String> i;
    public e14 j;

    /* loaded from: classes8.dex */
    public class a implements e14 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs1 a;

        @Override // com.baidu.tieba.e14
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(xs1 xs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xs1Var;
        }

        @Override // com.baidu.tieba.e14
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(ws1.b(str));
                h14.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.e14
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (ss1 ss1Var : this.a.f) {
                        ss1Var.a(0);
                        if (this.a.f.contains(ss1Var)) {
                            this.a.f.remove(ss1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (ss1 ss1Var2 : this.a.f) {
                    ss1Var2.a(1001);
                    if (this.a.f.contains(ss1Var2)) {
                        this.a.f.remove(ss1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.e14
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

        @Override // com.baidu.tieba.e14
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(ws1.a(z));
            }
        }
    }

    public xs1(@NonNull JSONObject jSONObject, us1 us1Var, ss1 ss1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, us1Var, ss1Var};
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
            this.i = h14.a("video", "app", optString, this.a, false);
            this.e = new ys1();
            f14 f14Var = new f14(lx2.T().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = f14Var;
            f14Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, ss1Var, us1Var);
            return;
        }
        ss1Var.a(202);
    }

    @Override // com.baidu.tieba.ts1
    public synchronized void a(JSONObject jSONObject, ss1 ss1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, ss1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = ss1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.ts1
    public synchronized void b(JSONObject jSONObject, ss1 ss1Var, us1 us1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, ss1Var, us1Var) == null) {
            synchronized (this) {
                this.d = us1Var;
                if (this.c != null) {
                    this.g = ss1Var;
                    if (ss1Var != null && !this.f.contains(ss1Var)) {
                        this.f.add(ss1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
