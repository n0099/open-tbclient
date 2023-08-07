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
public class xr1 implements tr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public f04 c;
    public ur1 d;
    public oz3 e;
    public List<sr1> f;
    public sr1 g;
    public sr1 h;
    public Map<String, String> i;
    public e04 j;

    /* loaded from: classes8.dex */
    public class a implements e04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr1 a;

        @Override // com.baidu.tieba.e04
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(xr1 xr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xr1Var;
        }

        @Override // com.baidu.tieba.e04
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(wr1.b(str));
                h04.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.e04
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (sr1 sr1Var : this.a.f) {
                        sr1Var.a(0);
                        if (this.a.f.contains(sr1Var)) {
                            this.a.f.remove(sr1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (sr1 sr1Var2 : this.a.f) {
                    sr1Var2.a(1001);
                    if (this.a.f.contains(sr1Var2)) {
                        this.a.f.remove(sr1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.e04
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

        @Override // com.baidu.tieba.e04
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(wr1.a(z));
            }
        }
    }

    public xr1(@NonNull JSONObject jSONObject, ur1 ur1Var, sr1 sr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, ur1Var, sr1Var};
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
            this.i = h04.a("video", "app", optString, this.a, false);
            this.e = new yr1();
            f04 f04Var = new f04(lw2.T().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = f04Var;
            f04Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, sr1Var, ur1Var);
            return;
        }
        sr1Var.a(202);
    }

    @Override // com.baidu.tieba.tr1
    public synchronized void a(JSONObject jSONObject, sr1 sr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, sr1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = sr1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.tr1
    public synchronized void b(JSONObject jSONObject, sr1 sr1Var, ur1 ur1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, sr1Var, ur1Var) == null) {
            synchronized (this) {
                this.d = ur1Var;
                if (this.c != null) {
                    this.g = sr1Var;
                    if (sr1Var != null && !this.f.contains(sr1Var)) {
                        this.f.add(sr1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
