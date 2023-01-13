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
import com.baidu.tieba.y8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ue1 implements jh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hh1 a;
    public String b;
    public final Context c;
    public final pe1 d;
    public y8.b e;
    public int f;
    public int g;
    public ze1 h;
    public int i;
    public ne1 j;
    public final oe1 k;

    /* loaded from: classes6.dex */
    public class a implements oe1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue1 a;

        public a(ue1 ue1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue1Var;
        }

        @Override // com.baidu.tieba.oe1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d == null) {
                } else {
                    pe1 pe1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    pe1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.oe1
        public void b(@NonNull ze1 ze1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ze1Var) != null) || y8.f().i()) {
                return;
            }
            int f = xe1.f(ze1Var, this.a.i);
            if (f == 0) {
                this.a.h = ze1Var;
                hh1 a = new pg1().a(this.a.c, ve1.a(ze1Var));
                if (a != null) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        qe1 qe1Var = new qe1(a, this.a.d.g(), ze1Var);
                        qe1Var.m(this.a.d);
                        a.c(qe1Var);
                        a.a(qe1Var);
                        qe1Var.l(this.a);
                        this.a.j(!ze1Var.j());
                        this.a.m(!ze1Var.h());
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
                pe1 pe1Var = this.a.d;
                pe1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public ue1(Context context, String str, rg1 rg1Var, pe1 pe1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, rg1Var, pe1Var};
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
        this.d = pe1Var;
        if (rg1Var != null && rg1Var.a() != null && rg1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(rg1Var.a().get("launch_type"));
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

    public void k(hh1 hh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hh1Var) == null) {
            this.a = hh1Var;
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
            hh1 hh1Var = this.a;
            if (viewGroup != null && hh1Var != null) {
                hh1Var.load();
                View adView = hh1Var.getAdView();
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

    @Override // com.baidu.tieba.jh1
    @Nullable
    public ze1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ze1) invokeV.objValue;
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
            if (!y8.f().h()) {
                l(xe1.n(this.i));
                return;
            }
            ne1 ne1Var = new ne1();
            this.j = ne1Var;
            ne1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.jh1
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

    public void l(ze1 ze1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ze1Var) == null) {
            if (ze1Var != null) {
                this.h = ze1Var;
                qg1 a2 = ve1.a(ze1Var);
                hh1 a3 = new pg1().a(this.c, a2);
                if (a3 == null) {
                    if (ie1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    pe1 pe1Var = this.d;
                    if (pe1Var != null) {
                        pe1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                pe1 pe1Var2 = this.d;
                if (pe1Var2 != null) {
                    qe1 qe1Var = new qe1(a3, pe1Var2.g(), ze1Var);
                    qe1Var.m(this.d);
                    a3.c(qe1Var);
                    a3.a(qe1Var);
                    qe1Var.l(this);
                    j(!ze1Var.j());
                    m(!ze1Var.h());
                    this.d.e(this);
                }
                y8.b bVar = this.e;
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            y8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            pe1 pe1Var3 = this.d;
            if (pe1Var3 != null) {
                pe1Var3.b("本地物料null");
            }
        }
    }
}
