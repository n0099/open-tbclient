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
public class qe1 implements fh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dh1 a;
    public String b;
    public final Context c;
    public final le1 d;
    public x8.b e;
    public int f;
    public int g;
    public ve1 h;
    public int i;
    public je1 j;
    public final ke1 k;

    /* loaded from: classes5.dex */
    public class a implements ke1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qe1 a;

        public a(qe1 qe1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qe1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qe1Var;
        }

        @Override // com.baidu.tieba.ke1
        public void a(Throwable th) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d == null) {
                } else {
                    le1 le1Var = this.a.d;
                    if (th == null) {
                        message = "unKnow";
                    } else {
                        message = th.getMessage();
                    }
                    le1Var.b(message);
                }
            }
        }

        @Override // com.baidu.tieba.ke1
        public void b(@NonNull ve1 ve1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ve1Var) != null) || x8.f().i()) {
                return;
            }
            int e = te1.e(ve1Var, this.a.i);
            if (e == 0) {
                this.a.h = ve1Var;
                dh1 a = new lg1().a(this.a.c, re1.a(ve1Var));
                if (a != null) {
                    this.a.a = a;
                    if (this.a.d != null) {
                        me1 me1Var = new me1(a, this.a.d.g(), ve1Var);
                        me1Var.l(this.a.d);
                        a.c(me1Var);
                        a.a(me1Var);
                        me1Var.k(this.a);
                        this.a.j(!ve1Var.j());
                        this.a.m(!ve1Var.h());
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
                le1 le1Var = this.a.d;
                le1Var.b("query 后物料效验失败: " + e);
            }
            BaseVM.h(e);
        }
    }

    public qe1(Context context, String str, ng1 ng1Var, le1 le1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, ng1Var, le1Var};
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
        this.d = le1Var;
        if (ng1Var != null && ng1Var.a() != null && ng1Var.a().containsKey("launch_type")) {
            try {
                this.i = Integer.parseInt(ng1Var.a().get("launch_type"));
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

    public void k(dh1 dh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dh1Var) == null) {
            this.a = dh1Var;
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
            dh1 dh1Var = this.a;
            if (viewGroup != null && dh1Var != null) {
                dh1Var.load();
                View adView = dh1Var.getAdView();
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

    @Override // com.baidu.tieba.fh1
    @Nullable
    public ve1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (ve1) invokeV.objValue;
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
                l(te1.m(this.i));
                return;
            }
            je1 je1Var = new je1();
            this.j = je1Var;
            je1Var.j(this.b, this.k);
        }
    }

    @Override // com.baidu.tieba.fh1
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

    public void l(ve1 ve1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ve1Var) == null) {
            if (ve1Var != null) {
                this.h = ve1Var;
                mg1 a2 = re1.a(ve1Var);
                dh1 a3 = new lg1().a(this.c, a2);
                if (a3 == null) {
                    if (ee1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    le1 le1Var = this.d;
                    if (le1Var != null) {
                        le1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                le1 le1Var2 = this.d;
                if (le1Var2 != null) {
                    me1 me1Var = new me1(a3, le1Var2.g(), ve1Var);
                    me1Var.l(this.d);
                    a3.c(me1Var);
                    a3.a(me1Var);
                    me1Var.k(this);
                    j(!ve1Var.j());
                    m(!ve1Var.h());
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
            le1 le1Var3 = this.d;
            if (le1Var3 != null) {
                le1Var3.b("本地物料null");
            }
        }
    }
}
