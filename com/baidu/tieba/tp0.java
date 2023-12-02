package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.video.plugin.videoplayer.model.ClarityUrlList;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.fq0;
import com.baidu.tieba.rj0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
/* loaded from: classes8.dex */
public abstract class tp0 extends fq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int H;
    public BdVideoSeries I;
    public int J;
    public IVideoUpdateStrategy K;
    public dx0 L;
    @Nullable
    public br0 M;
    @Nullable
    public cr0 N;

    public abstract void B1(boolean z);

    @Override // com.baidu.tieba.sp0
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final void D1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdVideoSeries) == null) {
        }
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp0(@NonNull kt0 kt0Var, @Nullable Context context) {
        super(kt0Var, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kt0Var, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((kt0) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.H = 0;
        this.J = 0;
    }

    public void A1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdVideoSeries) == null) {
            zv0.b(bdVideoSeries, (P() || Math.abs(t() - E()) < 3000) ? 0 : 0, t());
        }
    }

    @Override // com.baidu.tieba.sp0
    public void G0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            super.G0(context);
            d(qj0.b());
            if (o1()) {
                d(new rw0());
            }
            d(new tw0());
        }
    }

    @Override // com.baidu.tieba.fq0
    public void X0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            br0 br0Var = this.M;
            if (br0Var != null && br0Var.a(i)) {
                return;
            }
            super.X0(i);
        }
    }

    @Override // com.baidu.tieba.fq0
    public void Y0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            cr0 cr0Var = this.N;
            if (cr0Var != null && cr0Var.a(i)) {
                return;
            }
            super.Y0(i);
        }
    }

    @Override // com.baidu.tieba.sp0
    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            super.d0(i);
            this.A.cancel();
        }
    }

    public void v1(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, iVideoUpdateStrategy) == null) {
            this.K = iVideoUpdateStrategy;
        }
    }

    public void w1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bdVideoSeries) == null) {
            x1(bdVideoSeries, true);
        }
    }

    public void C1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && BdNetUtils.c()) {
            String a = i31.a().a(str);
            if (!TextUtils.isEmpty(a) && !TextUtils.equals(a, this.a.b)) {
                this.a.b = a;
                r0(true);
            }
        }
    }

    public final boolean p1(BdVideoSeries bdVideoSeries) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, bdVideoSeries)) == null) {
            if (o1() && bdVideoSeries != null && !m1() && E() > 0 && bdVideoSeries.getPositionMs() != E()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.sp0
    public void F0(@Nullable Context context, @Nullable fv0 fv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, fv0Var) == null) {
            super.F0(context, fv0Var);
            fr0.a(this);
        }
    }

    public void r1(boolean z, @NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048616, this, z, bdVideoSeries) == null) && o1() && !m1()) {
            u1("plugin_event_load_player_history", z, bdVideoSeries);
        }
    }

    public void t1(boolean z, @Nullable BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048618, this, z, bdVideoSeries) != null) || p1(bdVideoSeries)) {
            return;
        }
        A1(bdVideoSeries);
        u1("plugin_event_save_player_history", z, bdVideoSeries);
    }

    @Override // com.baidu.tieba.sp0
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.m = new rq0();
        }
    }

    @Override // com.baidu.tieba.sp0
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            rp0.e(false);
            rj0.a.a().a();
            k1();
        }
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sp0
    @NonNull
    /* renamed from: b1 */
    public rq0 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (rq0) this.m;
        }
        return (rq0) invokeV.objValue;
    }

    public String c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            float d1 = d1();
            if (d1 <= 0.0f) {
                return "";
            }
            return new DecimalFormat("#.#").format(d1);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fq0, com.baidu.tieba.sp0
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            s1();
            super.e0();
            this.A.cancel();
            L0();
            this.M = null;
            this.N = null;
        }
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.J;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sp0
    @NonNull
    /* renamed from: h1 */
    public dx0 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.L == null) {
                this.L = new dx0();
            }
            return this.L;
        }
        return (dx0) invokeV.objValue;
    }

    @NonNull
    public IVideoUpdateStrategy i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.K == null) {
                this.K = new cx0();
            }
            return this.K;
        }
        return (IVideoUpdateStrategy) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sp0
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.j0();
            this.A.start();
        }
    }

    @Nullable
    public BdVideoSeries j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.I;
        }
        return (BdVideoSeries) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sp0
    @Nullable
    public fv0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            s1();
            return super.k();
        }
        return (fv0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sp0
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.l();
            this.A.start();
            System.currentTimeMillis();
        }
    }

    public final boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (n1() && !iq0.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            if (bdVideoSeries != null) {
                return bdVideoSeries.isInteractVideo();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sp0, com.baidu.tieba.tu0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onCompletion();
            z().p(D(), q(), s());
            this.A.cancel();
        }
    }

    @Override // com.baidu.tieba.sp0, com.baidu.tieba.tu0
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onSeekComplete();
            this.A.start();
        }
    }

    public void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            t1(true, this.I);
        }
    }

    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            BdNetUtils.i(n(), c1());
        }
    }

    @Override // com.baidu.tieba.sp0
    public void I0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || TextUtils.isEmpty(this.a.b)) {
            return;
        }
        if (BdNetUtils.e()) {
            l();
        } else if (BdNetUtils.h()) {
            if (i1().i() != 0) {
                l();
            }
        } else if (BdNetUtils.d()) {
            if (i1().i() == 2) {
                l();
                z1();
                return;
            }
            r().g();
        }
    }

    public float d1() {
        InterceptResult invokeV;
        ClarityUrlList clarityList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            BdVideoSeries bdVideoSeries = this.I;
            if (bdVideoSeries == null || (clarityList = bdVideoSeries.getClarityList()) == null || clarityList.size() <= 0) {
                return 0.0f;
            }
            if (W() && s() > 0) {
                return (1.0f - ((D() * 1.0f) / s())) * clarityList.getCurrentClarityUrl().l();
            }
            return clarityList.getCurrentClarityUrl().l();
        }
        return invokeV.floatValue;
    }

    public final void Z0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdVideoSeries) == null) {
            try {
                this.a.d = 0;
                this.a.e = 0;
                if (bdVideoSeries.getSelectedVideo() != null) {
                    if (!TextUtils.isEmpty(bdVideoSeries.getSelectedVideo().getCurrentLength())) {
                        this.a.d = hx0.c(bdVideoSeries.getSelectedVideo().getCurrentLength());
                    }
                    if (!TextUtils.isEmpty(bdVideoSeries.getSelectedVideo().getTotalLength())) {
                        this.a.e = hx0.c(bdVideoSeries.getSelectedVideo().getTotalLength());
                    }
                }
                if (this.a.e < 0 || this.a.d < 0 || this.a.d > this.a.e) {
                    this.a.e = 0;
                    this.a.d = 0;
                }
            } catch (Exception e) {
                lx0.f("applyPosition(" + System.identityHashCode(bdVideoSeries) + SmallTailInfo.EMOTION_SUFFIX, e);
            }
        }
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.A = new zs0(this);
            ws0 ws0Var = new ws0(rp0.b(), 3);
            this.B = ws0Var;
            if (ws0Var.canDetectOrientation()) {
                this.E = true;
                this.B.disable();
                this.B.g(new fq0.a(this));
            }
            this.C = new vs0(this);
        }
    }

    @Override // com.baidu.tieba.sp0, com.baidu.tieba.tu0
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048612, this, i, i2, obj)) == null) {
            this.A.cancel();
            s1();
            return super.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void u1(@NonNull String str, boolean z, @NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{str, Boolean.valueOf(z), bdVideoSeries}) == null) {
            ms0 x = fs0.x(str, z ? 1 : 0);
            x.o(1, bdVideoSeries);
            o0(x);
        }
    }

    public void x1(@NonNull BdVideoSeries bdVideoSeries, boolean z) {
        String str;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048622, this, bdVideoSeries, z) == null) {
            lx0.g(J0("setVideoSeriesForPrepare(" + System.identityHashCode(bdVideoSeries) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + SmallTailInfo.EMOTION_SUFFIX));
            if (("series = " + bdVideoSeries) != null) {
                str = bdVideoSeries.toString();
            } else {
                str = null;
            }
            lx0.g(J0(str));
            boolean z3 = false;
            t1(false, this.I);
            this.I = bdVideoSeries;
            if (!TextUtils.isEmpty(bdVideoSeries.getNid())) {
                A0(this.I.getNid());
            }
            D1(bdVideoSeries);
            if (bdVideoSeries.getSelectedVideo() != null) {
                y1(bdVideoSeries);
                C1(this.a.b);
                if (Z() && F().d(this, this.b)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 || E() <= 0) {
                    r1(false, bdVideoSeries);
                }
                vx0.q(this.I.getNid(), this.a.b);
                t0(bdVideoSeries.isPlayLoop());
                if (z) {
                    v0(bdVideoSeries.getPlayConf());
                }
                if (bdVideoSeries.getClarityList() != null) {
                    p0(bdVideoSeries.getClarityList().getClarityInfoStr());
                }
                B1(false);
                String str2 = this.a.b;
                if (z && !z2) {
                    z3 = true;
                }
                C0(str2, z3);
            }
        }
    }

    public final void y1(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bdVideoSeries) == null) {
            BdVideo selectedVideo = bdVideoSeries.getSelectedVideo();
            if (selectedVideo != null) {
                String localSavePath = selectedVideo.getLocalSavePath();
                if (kx0.a(localSavePath)) {
                    this.a.b = localSavePath;
                }
                this.a.c = selectedVideo.getTitle();
                this.a.a = selectedVideo.getSourceUrl();
            }
            ClarityUrlList clarityList = bdVideoSeries.getClarityList();
            if (clarityList != null && clarityList.size() > 0) {
                this.a.b = clarityList.getDefaultUrl();
            } else if (selectedVideo != null) {
                this.a.b = selectedVideo.getPlayUrl();
            }
            this.a.e = bdVideoSeries.getDuration();
            if (!o1()) {
                Z0(bdVideoSeries);
            }
        }
    }
}
