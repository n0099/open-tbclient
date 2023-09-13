package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oj1 implements vl1, xl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final wl1 a;
    @NonNull
    public ViewGroup b;
    @NonNull
    public final xj1 c;
    @NonNull
    public final BaseVM d;
    @Nullable
    public nj1 e;
    public long f;
    public long g;
    public final long h;
    public long i;
    public boolean j;
    public sj1 k;

    @Override // com.baidu.tieba.vl1
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.vl1
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tieba.vl1
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements bk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj1 a;

        @Override // com.baidu.tieba.bk1
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            }
        }

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

        @Override // com.baidu.tieba.bk1
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a.e != null) {
                    return this.a.e.c(str);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj1 a;

        public b(oj1 oj1Var) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.d();
            }
        }
    }

    public oj1(@NonNull wl1 wl1Var, @NonNull ViewGroup viewGroup, @NonNull xj1 xj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wl1Var, viewGroup, xj1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.h = System.currentTimeMillis();
        this.a = wl1Var;
        this.b = viewGroup;
        this.c = xj1Var;
        this.d = new BaseVM(xj1Var);
        rj1.b(xj1Var);
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            q8.f().e();
            if (!this.j) {
                return;
            }
            this.j = false;
            this.d.e(str, this.i);
        }
    }

    public void l(sj1 sj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sj1Var) == null) {
            this.k = sj1Var;
            wl1 wl1Var = this.a;
            if (wl1Var != null) {
                sj1Var.l(wl1Var);
            }
        }
    }

    public void m(@NonNull nj1 nj1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, nj1Var) == null) {
            this.e = nj1Var;
        }
    }

    @Override // com.baidu.tieba.xl1
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            nj1 nj1Var = this.e;
            if (nj1Var != null) {
                nj1Var.f();
            }
        }
    }

    @Override // com.baidu.tieba.vl1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (wj1.s() && !TextUtils.isEmpty(this.c.p)) {
                cj0.b(this.c.p);
                if (ch0.a) {
                    s51.a().showToast(this.a.getAdView().getContext(), "执行nad统一新协议跳转");
                }
            } else {
                ek1.a(tj0.b(), this.c.o, new a(this));
                if (ch0.a) {
                    s51.a().showToast(this.a.getAdView().getContext(), "执行splash旧协议跳转");
                }
            }
            j(BaseVM.CloseType.CLICK_AD_AREA.value);
            this.d.b("");
            nj1 nj1Var = this.e;
            if (nj1Var != null) {
                nj1Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.xl1
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adShowScene", this.c.D);
                jSONObject.put("adSplashType", this.c.e);
                if (this.c.D == 1) {
                    long j = this.g - this.h;
                    if (j > 0) {
                        jSONObject.put("adLoadCostTime", j);
                    }
                }
                jSONObject.put("adRenderCostTime", this.f - this.h);
                long currentTimeMillis = System.currentTimeMillis();
                jSONObject.put("show_time", currentTimeMillis);
                k(currentTimeMillis);
            } catch (JSONException unused) {
            }
            this.d.c(jSONObject);
            vj1.D(this.c);
            zj1.e(this.c);
            nj1 nj1Var = this.e;
            if (nj1Var != null) {
                nj1Var.onAdShow();
            }
        }
    }

    @Override // com.baidu.tieba.xl1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.tieba.vl1
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nj1 nj1Var = this.e;
            if (nj1Var != null) {
                nj1Var.onSkip();
            }
            j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
        }
    }

    @Override // com.baidu.tieba.xl1
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f;
            if ("time_end".equals(str)) {
                j(BaseVM.CloseType.COUNTDOWN_TIME_FINISH.value);
            } else if ("click_skip_button".equals(str)) {
                j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
            } else if ("click_ad_area".equals(str)) {
                j(BaseVM.CloseType.CLICK_AD_AREA.value);
            } else {
                j(BaseVM.CloseType.OTHER.value);
            }
            if (this.e != null) {
                ik0.c(new b(this));
            }
        }
    }

    public final void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            String str = this.c.p;
            if (!TextUtils.isEmpty(str)) {
                this.c.p = str.replace("SplashShowTime", String.valueOf(j));
            }
            String str2 = this.c.O;
            if (!TextUtils.isEmpty(str2)) {
                this.c.O = str2.replace("SplashShowTime", String.valueOf(j));
            }
        }
    }
}
