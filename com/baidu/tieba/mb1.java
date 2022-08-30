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
import com.baidu.tieba.w8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mb1 implements be1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zd1 a;
    public String b;
    public final Context c;
    public final hb1 d;
    public w8.b e;
    public int f;
    public int g;
    public rb1 h;
    public int i;
    public fb1 j;
    public final gb1 k;

    /* loaded from: classes5.dex */
    public class a implements gb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb1 a;

        public a(mb1 mb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mb1Var;
        }

        @Override // com.baidu.tieba.gb1
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (this.a.e != null) {
                    this.a.e.onFailed();
                } else if (this.a.d != null) {
                    this.a.d.b(th == null ? "unKnow" : th.getMessage());
                }
            }
        }

        @Override // com.baidu.tieba.gb1
        public void b(@NonNull rb1 rb1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rb1Var) == null) || w8.f().i()) {
                return;
            }
            int f = pb1.f(rb1Var, this.a.i);
            if (f == 0) {
                this.a.h = rb1Var;
                zd1 a = new hd1().a(this.a.c, nb1.a(rb1Var));
                if (a == null) {
                    if (this.a.d != null) {
                        this.a.d.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a.a = a;
                if (this.a.d != null) {
                    ib1 ib1Var = new ib1(a, this.a.d.g(), rb1Var);
                    ib1Var.l(this.a.d);
                    a.c(ib1Var);
                    a.a(ib1Var);
                    ib1Var.k(this.a);
                    this.a.j(!rb1Var.i());
                    this.a.m(!rb1Var.g());
                    this.a.d.e(this.a);
                }
                if (this.a.e != null) {
                    this.a.e.onSuccess();
                    return;
                }
                return;
            }
            if (this.a.e != null) {
                this.a.e.onFailed();
            } else if (this.a.d != null) {
                hb1 hb1Var = this.a.d;
                hb1Var.b("query 后物料效验失败: " + f);
            }
            BaseVM.h(f);
        }
    }

    public mb1(Context context, String str, jd1 jd1Var, hb1 hb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, jd1Var, hb1Var};
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
        this.d = hb1Var;
        if (jd1Var == null || jd1Var.a() == null || !jd1Var.a().containsKey("launch_type")) {
            return;
        }
        try {
            this.i = Integer.parseInt(jd1Var.a().get("launch_type"));
        } catch (NumberFormatException unused) {
            this.i = 0;
        }
    }

    @Override // com.baidu.tieba.be1
    @Nullable
    public rb1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : (rb1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.be1
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

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        this.a = null;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!w8.f().h()) {
                l(pb1.p(this.i));
                return;
            }
            fb1 fb1Var = new fb1();
            this.j = fb1Var;
            fb1Var.j(this.b, this.k);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f = i;
        }
    }

    public void k(zd1 zd1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zd1Var) == null) {
            this.a = zd1Var;
        }
    }

    public void l(rb1 rb1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rb1Var) == null) {
            if (rb1Var != null) {
                this.h = rb1Var;
                id1 a2 = nb1.a(rb1Var);
                zd1 a3 = new hd1().a(this.c, a2);
                if (a3 == null) {
                    if (ab1.a.get().a()) {
                        Log.e("PrologueAd", "创建 AdContainer 失败，params: " + a2.a());
                    }
                    hb1 hb1Var = this.d;
                    if (hb1Var != null) {
                        hb1Var.b("创建 AdContainer 失败");
                        return;
                    }
                    return;
                }
                this.a = a3;
                hb1 hb1Var2 = this.d;
                if (hb1Var2 != null) {
                    ib1 ib1Var = new ib1(a3, hb1Var2.g(), rb1Var);
                    ib1Var.l(this.d);
                    a3.c(ib1Var);
                    a3.a(ib1Var);
                    ib1Var.k(this);
                    j(!rb1Var.i());
                    m(!rb1Var.g());
                    this.d.e(this);
                }
                w8.b bVar = this.e;
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            w8.b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.onFailed();
                return;
            }
            hb1 hb1Var3 = this.d;
            if (hb1Var3 != null) {
                hb1Var3.b("本地物料null");
            }
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
            zd1 zd1Var = this.a;
            if (viewGroup != null && zd1Var != null) {
                zd1Var.load();
                View adView = zd1Var.getAdView();
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
}
