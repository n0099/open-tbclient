package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class rw0 extends pq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sw0 O;
    public tw0 P;
    public boolean Q;
    public int R;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ rw0 b;

        public a(rw0 rw0Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rw0Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == -2 || i == -1) {
                    this.b.f0(2);
                    this.b.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rw0(@NonNull gu0 gu0Var, @Nullable Context context) {
        super(gu0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gu0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((gu0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Q = false;
        this.R = 22;
    }

    @Override // com.baidu.tieba.nq0
    @Nullable
    public bw0 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.A() : (bw0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oq0
    public void A1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdVideoSeries) == null) {
            this.P.L(8);
            J1();
            this.O.M(true);
            this.O.N(8);
            super.B1(bdVideoSeries, true);
        }
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.nq0
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.R : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ar0, com.baidu.tieba.nq0
    public void G0(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            sw0 sw0Var = new sw0();
            this.O = sw0Var;
            b(sw0Var);
            tw0 tw0Var = new tw0();
            this.P = tw0Var;
            b(tw0Var);
            b(new uw0());
            v().setClickable(false);
        }
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.nq0
    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            d(lm0.b());
            d(new px0(context));
        }
    }

    public final boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            return (bdVideoSeries == null || TextUtils.isEmpty(bdVideoSeries.getVid()) || !this.I.getVid().contains(LaunchStatsUtils.AD)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.u = 0;
        }
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.nq0
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            bw0 bw0Var = this.b;
            if (bw0Var != null && bw0Var.getContentView() != null) {
                this.b.getContentView().setVisibility(0);
            }
            if (TextUtils.isEmpty(this.a.b)) {
                return;
            }
            l();
        }
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.nq0
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            w1();
            if (this.b != null) {
                R0().stop(w());
                q().i();
                H().j(w());
                this.b.t0();
                wt0.a(getActivity(), false);
            }
            ot0 ot0Var = this.A;
            if (ot0Var != null) {
                ot0Var.cancel();
            }
            sw0 sw0Var = this.O;
            if (sw0Var != null) {
                sw0Var.L();
            }
        }
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.ar0, com.baidu.tieba.nq0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.P();
        }
    }

    @Override // com.baidu.tieba.nq0
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ty0.c(m()) == 0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nq0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.a();
        }
    }

    @Override // com.baidu.tieba.nq0
    public void d0(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (activity = getActivity()) == null || X()) {
            return;
        }
        activity.runOnUiThread(new a(this, i));
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.nq0
    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            w1();
            sw0 sw0Var = this.O;
            if (sw0Var != null) {
                sw0Var.M(i == 1);
            }
            if (I1()) {
                if (W() || a0()) {
                    return;
                }
                super.f0(i);
                return;
            }
            super.f0(i);
        }
    }

    @Override // com.baidu.tieba.nq0
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.k0();
        }
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.nq0
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.l0();
        }
    }

    @Override // com.baidu.tieba.oq0
    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.J : invokeV.intValue;
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.nq0, com.baidu.tieba.pv0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            z().g();
            R0().end(w());
            y().p(C(), p(), r());
            ot0 ot0Var = this.A;
            if (ot0Var != null) {
                ot0Var.cancel();
            }
        }
    }

    @Override // com.baidu.tieba.oq0, com.baidu.tieba.nq0, com.baidu.tieba.pv0
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i, i2, obj)) == null) {
            super.onError(i, i2, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.nq0, com.baidu.tieba.pv0
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrepared();
            qy0.b("AdMiniVideoPlayer", "onPrepared position:" + this.a.d);
        }
    }

    @Override // com.baidu.tieba.nq0
    public int r() {
        InterceptResult invokeV;
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int r = super.r();
            if (r != 0 || (o1 = o1()) == null) {
                return r;
            }
            String selectedVideoTotalLength = o1.getSelectedVideoTotalLength();
            return !TextUtils.isEmpty(selectedVideoTotalLength) ? my0.c(selectedVideoTotalLength) : r;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.oq0
    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.Q : invokeV.booleanValue;
    }
}
