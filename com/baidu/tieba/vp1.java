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
public class vp1 implements rp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public dy3 c;
    public sp1 d;
    public mx3 e;
    public List<qp1> f;
    public qp1 g;
    public qp1 h;
    public Map<String, String> i;
    public cy3 j;

    /* loaded from: classes6.dex */
    public class a implements cy3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vp1 a;

        @Override // com.baidu.tieba.cy3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(vp1 vp1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vp1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vp1Var;
        }

        @Override // com.baidu.tieba.cy3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(up1.b(str));
                fy3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.cy3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (qp1 qp1Var : this.a.f) {
                        qp1Var.a(0);
                        if (this.a.f.contains(qp1Var)) {
                            this.a.f.remove(qp1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (qp1 qp1Var2 : this.a.f) {
                    qp1Var2.a(1001);
                    if (this.a.f.contains(qp1Var2)) {
                        this.a.f.remove(qp1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.cy3
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

        @Override // com.baidu.tieba.cy3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(up1.a(z));
            }
        }
    }

    public vp1(@NonNull JSONObject jSONObject, sp1 sp1Var, qp1 qp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, sp1Var, qp1Var};
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
            this.i = fy3.a("video", "app", optString, this.a, false);
            this.e = new wp1();
            dy3 dy3Var = new dy3(ju2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = dy3Var;
            dy3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, qp1Var, sp1Var);
            return;
        }
        qp1Var.a(202);
    }

    @Override // com.baidu.tieba.rp1
    public synchronized void a(JSONObject jSONObject, qp1 qp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, qp1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = qp1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.rp1
    public synchronized void b(JSONObject jSONObject, qp1 qp1Var, sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, qp1Var, sp1Var) == null) {
            synchronized (this) {
                this.d = sp1Var;
                if (this.c != null) {
                    this.g = qp1Var;
                    if (qp1Var != null && !this.f.contains(qp1Var)) {
                        this.f.add(qp1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
