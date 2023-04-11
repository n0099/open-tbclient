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
public class to1 implements po1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public bx3 c;
    public qo1 d;
    public kw3 e;
    public List<oo1> f;
    public oo1 g;
    public oo1 h;
    public Map<String, String> i;
    public ax3 j;

    /* loaded from: classes6.dex */
    public class a implements ax3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to1 a;

        @Override // com.baidu.tieba.ax3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(to1 to1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = to1Var;
        }

        @Override // com.baidu.tieba.ax3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(so1.b(str));
                dx3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.ax3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (oo1 oo1Var : this.a.f) {
                        oo1Var.a(0);
                        if (this.a.f.contains(oo1Var)) {
                            this.a.f.remove(oo1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (oo1 oo1Var2 : this.a.f) {
                    oo1Var2.a(1001);
                    if (this.a.f.contains(oo1Var2)) {
                        this.a.f.remove(oo1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ax3
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

        @Override // com.baidu.tieba.ax3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(so1.a(z));
            }
        }
    }

    public to1(@NonNull JSONObject jSONObject, qo1 qo1Var, oo1 oo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, qo1Var, oo1Var};
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
            this.i = dx3.a("video", "app", optString, this.a, false);
            this.e = new uo1();
            bx3 bx3Var = new bx3(ht2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = bx3Var;
            bx3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, oo1Var, qo1Var);
            return;
        }
        oo1Var.a(202);
    }

    @Override // com.baidu.tieba.po1
    public synchronized void a(JSONObject jSONObject, oo1 oo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, oo1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = oo1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.po1
    public synchronized void b(JSONObject jSONObject, oo1 oo1Var, qo1 qo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, oo1Var, qo1Var) == null) {
            synchronized (this) {
                this.d = qo1Var;
                if (this.c != null) {
                    this.g = oo1Var;
                    if (oo1Var != null && !this.f.contains(oo1Var)) {
                        this.f.add(oo1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
