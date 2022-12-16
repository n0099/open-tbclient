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
import com.baidu.tieba.x8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pe1 implements eh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ch1 a;
    public String b;
    public final Context c;
    public final ke1 d;
    public x8.b e;
    public int f;
    public int g;
    public ue1 h;
    public int i;
    public ie1 j;
    public final je1 k;

    /* loaded from: classes5.dex */
    public class a implements je1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe1 a;

        public a(pe1 pe1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe1Var;
        }

        @Override // com.baidu.tieba.je1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d == null) {
                } else {
                    ke1 ke1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    ke1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.je1
        public void b(@NonNull ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ue1Var) != null) || x8.f().i()) {
                return;
            }
            int f = se1.f(ue1Var, this.a.i);
            if (f == 0) {
                this.a.h = ue1Var;
                ch1 a = new kg1().a(this.a.c, qe1.a(ue1Var));
                if (a != null) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        le1 le1Var = new le1(a, this.a.d.g(), ue1Var);
                        le1Var.m(this.a.d);
                        a.c(le1Var);
                        a.a(le1Var);
                        le1Var.l(this.a);
                        this.a.j(!ue1Var.j());
                        this.a.m(!ue1Var.h());
                        this.a.d.e(this.a);
                    }
                    if (this.a.e != null) {
                        this.a.e.onSuccess();
                        return;
                    }
                    return;
                } else if (this.a.d != null) {
                    this.a.d.b("创建 AdContainer 失败");
                    return;
                } else {
                    return;
                }
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                ke1 ke1Var = this.a.d;
                ke1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public pe1(Context context, String str, mg1 mg1Var, ke1 ke1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, mg1Var, ke1Var};
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
        this.d = ke1Var;
        if (mg1Var != null && mg1Var.a() != null && mg1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(mg1Var.a().get("launch_type"));
            } catch (NumberFormatException unused) {
                this.i = 0;
            }
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(ch1 ch1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ch1Var) == null) {
            this.a = ch1Var;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    public void n(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            ch1 ch1Var = this.a;
            if (viewGroup != null && ch1Var != null) {
                ch1Var.load();
                View adView = ch1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                } else {
                    h();
                    return;
                }
            }
            h();
        }
    }

    @Override // com.baidu.tieba.eh1
    @Nullable
    public ue1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ue1) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a != null) {
            this.a = null;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!x8.f().h()) {
                l(se1.n(this.i));
                return;
            }
            ie1 ie1Var = new ie1();
            this.j = ie1Var;
            ie1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.eh1
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

    public void l(ue1 ue1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ue1Var) == null) {
            if (ue1Var != null) {
                this.h = ue1Var;
                lg1 a2 = qe1.a(ue1Var);
                ch1 a3 = new kg1().a(this.c, a2);
                if (a3 == null) {
                    if (de1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    ke1 ke1Var = this.d;
                    if (ke1Var != null) {
                        ke1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                ke1 ke1Var2 = this.d;
                if (ke1Var2 != null) {
                    le1 le1Var = new le1(a3, ke1Var2.g(), ue1Var);
                    le1Var.m(this.d);
                    a3.c(le1Var);
                    a3.a(le1Var);
                    le1Var.l(this);
                    j(!ue1Var.j());
                    m(!ue1Var.h());
                    this.d.e(this);
                }
                x8.b bVar = this.e;
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            x8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            ke1 ke1Var3 = this.d;
            if (ke1Var3 != null) {
                ke1Var3.b("本地物料null");
            }
        }
    }
}
