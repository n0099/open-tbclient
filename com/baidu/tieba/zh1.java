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
public class zh1 implements vh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public gq3 c;
    public wh1 d;
    public pp3 e;
    public List<uh1> f;
    public uh1 g;
    public uh1 h;
    public Map<String, String> i;
    public fq3 j;

    /* loaded from: classes6.dex */
    public class a implements fq3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh1 a;

        public a(zh1 zh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zh1Var;
        }

        @Override // com.baidu.tieba.fq3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (uh1 uh1Var : this.a.f) {
                        uh1Var.a(0);
                        if (this.a.f.contains(uh1Var)) {
                            this.a.f.remove(uh1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (uh1 uh1Var2 : this.a.f) {
                    uh1Var2.a(1001);
                    if (this.a.f.contains(uh1Var2)) {
                        this.a.f.remove(uh1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.fq3
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

        @Override // com.baidu.tieba.fq3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(yh1.a(z));
            }
        }

        @Override // com.baidu.tieba.fq3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.fq3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(yh1.b(str));
                iq3.k(this.a.i, str);
            }
        }
    }

    public zh1(@NonNull JSONObject jSONObject, wh1 wh1Var, uh1 uh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, wh1Var, uh1Var};
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
            this.i = iq3.a("video", "app", optString, this.a, false);
            this.e = new ai1();
            gq3 gq3Var = new gq3(nm2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = gq3Var;
            gq3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, uh1Var, wh1Var);
            return;
        }
        uh1Var.a(202);
    }

    @Override // com.baidu.tieba.vh1
    public synchronized void a(JSONObject jSONObject, uh1 uh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, uh1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = uh1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.vh1
    public synchronized void b(JSONObject jSONObject, uh1 uh1Var, wh1 wh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, uh1Var, wh1Var) == null) {
            synchronized (this) {
                this.d = wh1Var;
                if (this.c != null) {
                    this.g = uh1Var;
                    if (uh1Var != null && !this.f.contains(uh1Var)) {
                        this.f.add(uh1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
