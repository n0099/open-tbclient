package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.interfaces.LoadState;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.e4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class we1 implements ch1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ah1 a;
    public String b;
    public final Context c;
    public final re1 d;
    public e4.b e;
    public int f;
    public int g;
    public bf1 h;
    public int i;
    public pe1 j;
    public final qe1 k;

    /* loaded from: classes8.dex */
    public class a implements qe1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ we1 a;

        public a(we1 we1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = we1Var;
        }

        @Override // com.baidu.tieba.qe1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    re1 re1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    re1Var.a(message);
                }
            }
        }

        @Override // com.baidu.tieba.qe1
        public void b(@NonNull bf1 bf1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bf1Var) != null) || e4.f().i()) {
                return;
            }
            int f = ze1.f(bf1Var, this.a.i);
            if (f == 0) {
                this.a.h = bf1Var;
                ah1 a = new ig1().a(this.a.c, xe1.a(bf1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.a("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!bf1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        se1 se1Var = new se1(a, this.a.d.f(), bf1Var);
                        se1Var.k(this.a.d);
                        a.c(se1Var);
                        a.b(se1Var);
                        se1Var.j(this.a);
                        this.a.k(!bf1Var.n());
                        this.a.n(!bf1Var.l());
                        this.a.d.d(this.a);
                    }
                    if (this.a.e != null) {
                        this.a.e.onSuccess();
                        return;
                    }
                    return;
                } else {
                    new BaseVM(this.a.h).c(null);
                    if (this.a.d != null) {
                        this.a.d.a("virtual order cannot show");
                        return;
                    }
                    return;
                }
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                re1 re1Var = this.a.d;
                re1Var.a("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public we1(Context context, String str, kg1 kg1Var, re1 re1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, kg1Var, re1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        LoadState loadState = LoadState.INIT;
        this.i = 0;
        this.k = new a(this);
        this.c = context;
        this.b = str;
        this.d = re1Var;
        if (kg1Var != null && kg1Var.a() != null && kg1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(kg1Var.a().get("launch_type"));
            } catch (NumberFormatException unused) {
                this.i = 0;
            }
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void l(ah1 ah1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ah1Var) == null) {
            this.a = ah1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.ch1
    @Nullable
    public bf1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (bf1) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!e4.f().h()) {
                m(ze1.n(this.i));
                return;
            }
            pe1 pe1Var = new pe1();
            this.j = pe1Var;
            pe1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.ch1
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.h != null) {
                    jSONObject.put("source", this.h.E);
                    jSONObject.put(QuickPersistConfigConst.KEY_SPLASH_SORT, this.h.F);
                }
                jSONObject.put(TiebaStatic.Params.AD_TYPE, this.f);
                jSONObject.put("full_type", this.g);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void m(bf1 bf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bf1Var) == null) {
            if (bf1Var != null) {
                this.h = bf1Var;
                jg1 a2 = xe1.a(bf1Var);
                ah1 a3 = new ig1().a(this.c, a2);
                if (a3 == null) {
                    if (ke1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    re1 re1Var = this.d;
                    if (re1Var != null) {
                        re1Var.a("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (bf1Var.q()) {
                    new BaseVM(this.h).c(null);
                    re1 re1Var2 = this.d;
                    if (re1Var2 != null) {
                        re1Var2.a("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    re1 re1Var3 = this.d;
                    if (re1Var3 != null) {
                        se1 se1Var = new se1(a3, re1Var3.f(), bf1Var);
                        se1Var.k(this.d);
                        a3.c(se1Var);
                        a3.b(se1Var);
                        se1Var.j(this);
                        k(!bf1Var.n());
                        n(!bf1Var.l());
                        this.d.d(this);
                    }
                    e4.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            e4.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            re1 re1Var4 = this.d;
            if (re1Var4 != null) {
                re1Var4.a("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            ah1 ah1Var = this.a;
            if (viewGroup != null && ah1Var != null) {
                ah1Var.load();
                View a2 = ah1Var.a();
                if (a2 != null && a2.getParent() == null) {
                    viewGroup.addView(a2);
                    return;
                }
                i();
                re1 re1Var = this.d;
                if (re1Var != null) {
                    re1Var.e();
                    return;
                }
                return;
            }
            i();
            re1 re1Var2 = this.d;
            if (re1Var2 != null) {
                re1Var2.e();
            }
        }
    }
}
