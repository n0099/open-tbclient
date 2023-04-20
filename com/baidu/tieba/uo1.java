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
public class uo1 implements qo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public cx3 c;
    public ro1 d;
    public lw3 e;
    public List<po1> f;
    public po1 g;
    public po1 h;
    public Map<String, String> i;
    public bx3 j;

    /* loaded from: classes6.dex */
    public class a implements bx3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo1 a;

        @Override // com.baidu.tieba.bx3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(uo1 uo1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uo1Var;
        }

        @Override // com.baidu.tieba.bx3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(to1.b(str));
                ex3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.bx3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (po1 po1Var : this.a.f) {
                        po1Var.a(0);
                        if (this.a.f.contains(po1Var)) {
                            this.a.f.remove(po1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (po1 po1Var2 : this.a.f) {
                    po1Var2.a(1001);
                    if (this.a.f.contains(po1Var2)) {
                        this.a.f.remove(po1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.bx3
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

        @Override // com.baidu.tieba.bx3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(to1.a(z));
            }
        }
    }

    public uo1(@NonNull JSONObject jSONObject, ro1 ro1Var, po1 po1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, ro1Var, po1Var};
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
            this.i = ex3.a("video", "app", optString, this.a, false);
            this.e = new vo1();
            cx3 cx3Var = new cx3(it2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = cx3Var;
            cx3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, po1Var, ro1Var);
            return;
        }
        po1Var.a(202);
    }

    @Override // com.baidu.tieba.qo1
    public synchronized void a(JSONObject jSONObject, po1 po1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, po1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = po1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.qo1
    public synchronized void b(JSONObject jSONObject, po1 po1Var, ro1 ro1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, po1Var, ro1Var) == null) {
            synchronized (this) {
                this.d = ro1Var;
                if (this.c != null) {
                    this.g = po1Var;
                    if (po1Var != null && !this.f.contains(po1Var)) {
                        this.f.add(po1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
