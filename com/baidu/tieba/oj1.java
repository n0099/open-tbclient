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
import com.baidu.tieba.p8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oj1 implements ul1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sl1 a;
    public String b;
    public final Context c;
    public final jj1 d;
    public p8.b e;
    public int f;
    public int g;
    public tj1 h;
    public int i;
    public hj1 j;
    public final ij1 k;

    /* loaded from: classes7.dex */
    public class a implements ij1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj1 a;

        public a(oj1 oj1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj1Var;
        }

        @Override // com.baidu.tieba.ij1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    jj1 jj1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    jj1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.ij1
        public void b(@NonNull tj1 tj1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tj1Var) != null) || p8.f().i()) {
                return;
            }
            int f = rj1.f(tj1Var, this.a.i);
            if (f == 0) {
                this.a.h = tj1Var;
                sl1 a = new al1().a(this.a.c, pj1.a(tj1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (!tj1Var.q()) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        kj1 kj1Var = new kj1(a, this.a.d.g(), tj1Var);
                        kj1Var.m(this.a.d);
                        a.c(kj1Var);
                        a.a(kj1Var);
                        kj1Var.l(this.a);
                        this.a.k(!tj1Var.n());
                        this.a.n(!tj1Var.l());
                        this.a.d.e(this.a);
                    }
                    if (this.a.e != null) {
                        this.a.e.onSuccess();
                        return;
                    }
                    return;
                } else {
                    new BaseVM(this.a.h).c(null);
                    if (this.a.d != null) {
                        this.a.d.b("virtual order cannot show");
                        return;
                    }
                    return;
                }
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                jj1 jj1Var = this.a.d;
                jj1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public oj1(Context context, String str, cl1 cl1Var, jj1 jj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cl1Var, jj1Var};
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
        this.d = jj1Var;
        if (cl1Var != null && cl1Var.a() != null && cl1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(cl1Var.a().get("launch_type"));
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

    public void l(sl1 sl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sl1Var) == null) {
            this.a = sl1Var;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.ul1
    @Nullable
    public tj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (tj1) invokeV.objValue;
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
            if (!p8.f().h()) {
                m(rj1.n(this.i));
                return;
            }
            hj1 hj1Var = new hj1();
            this.j = hj1Var;
            hj1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.ul1
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

    public void m(tj1 tj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tj1Var) == null) {
            if (tj1Var != null) {
                this.h = tj1Var;
                bl1 a2 = pj1.a(tj1Var);
                sl1 a3 = new al1().a(this.c, a2);
                if (a3 == null) {
                    if (cj1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    jj1 jj1Var = this.d;
                    if (jj1Var != null) {
                        jj1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                } else if (tj1Var.q()) {
                    new BaseVM(this.h).c(null);
                    jj1 jj1Var2 = this.d;
                    if (jj1Var2 != null) {
                        jj1Var2.b("virtual order cannot show");
                        return;
                    }
                    return;
                } else {
                    this.a = a3;
                    jj1 jj1Var3 = this.d;
                    if (jj1Var3 != null) {
                        kj1 kj1Var = new kj1(a3, jj1Var3.g(), tj1Var);
                        kj1Var.m(this.d);
                        a3.c(kj1Var);
                        a3.a(kj1Var);
                        kj1Var.l(this);
                        k(!tj1Var.n());
                        n(!tj1Var.l());
                        this.d.e(this);
                    }
                    p8.b bVar = this.e;
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
            }
            p8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            jj1 jj1Var4 = this.d;
            if (jj1Var4 != null) {
                jj1Var4.b("本地物料null");
            }
        }
    }

    public void o(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            sl1 sl1Var = this.a;
            if (viewGroup != null && sl1Var != null) {
                sl1Var.load();
                View adView = sl1Var.getAdView();
                if (adView != null && adView.getParent() == null) {
                    viewGroup.addView(adView);
                    return;
                }
                i();
                jj1 jj1Var = this.d;
                if (jj1Var != null) {
                    jj1Var.f();
                    return;
                }
                return;
            }
            i();
            jj1 jj1Var2 = this.d;
            if (jj1Var2 != null) {
                jj1Var2.f();
            }
        }
    }
}
