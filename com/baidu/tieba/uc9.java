package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.model.ImmersiveVideoCardEx;
import com.baidu.tieba.mc9;
import com.baidu.tieba.oc9;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public q8a c;
    public int d;
    public ImmersiveVideoCardEx.a e;
    public TbImageView f;
    public ImageView g;
    public String h;
    public boolean i;
    public View j;
    public int k;
    public int l;
    public boolean m;
    public tc9 n;
    public mc9 o;
    public oc9 p;
    public TbImageView.f q;
    public SeekBar.OnSeekBarChangeListener r;
    public VideoControllerView.d s;
    public View.OnClickListener t;
    public oc9.n u;
    public CyberPlayerManager.OnPreparedListener v;
    public VideoControllerView.c w;
    public mc9.h x;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc9 a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(uc9 uc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc9Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.f != null) {
                this.a.f.setDefaultBgResource(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc9 a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
            }
        }

        public b(uc9 uc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc9Var;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
                this.a.p.V();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) && !this.a.p.Y() && this.a.p.f0() != null) {
                this.a.p.B0(this.a.p.f0().getSeekPosition());
                this.a.p.M0(this.a.h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc9 a;

        public c(uc9 uc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc9Var;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.r()) {
                return;
            }
            this.a.p.g0(i);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc9 a;

        public d(uc9 uc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !this.a.r() && view2.getId() == this.a.b.getId()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showLongToast(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0e61));
                }
                if (this.a.o != null && this.a.c.isPlaying()) {
                    this.a.o.r();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements oc9.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc9 a;

        @Override // com.baidu.tieba.oc9.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public e(uc9 uc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc9Var;
        }

        @Override // com.baidu.tieba.oc9.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o.l();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc9 a;

        public f(uc9 uc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc9Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.c == null) {
                return;
            }
            this.a.o.r();
            if (this.a.n != null && this.a.n.e() != null && this.a.n.e().equals(this.a.h) && this.a.n.f() > 0) {
                this.a.c.seekTo(this.a.n.f());
                this.a.n.o(null);
                this.a.n.p(0);
            } else if (this.a.n != null && this.a.n.g(this.a.h) > 0) {
                this.a.c.seekTo(this.a.n.g(this.a.h));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc9 a;

        public g(uc9 uc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc9Var;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.r() && this.a.o != null && this.a.j != null) {
                if (this.a.c.isPlaying()) {
                    this.a.o.r();
                }
                if (this.a.j.getAlpha() != 1.0f) {
                    this.a.j.setAlpha(1.0f);
                }
                this.a.j.clearAnimation();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements mc9.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc9 a;

        public h(uc9 uc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc9Var;
        }

        @Override // com.baidu.tieba.mc9.h
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p.Y()) {
                this.a.p.j0();
            }
        }

        @Override // com.baidu.tieba.mc9.h
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.p.Y()) {
                this.a.p.U();
            }
        }

        @Override // com.baidu.tieba.mc9.h
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.p.Y()) {
                this.a.p.U();
            }
        }
    }

    public uc9(TbPageContext<?> tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.m = false;
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.v = new f(this);
        this.w = new g(this);
        this.x = new h(this);
        this.a = tbPageContext;
        this.b = view2;
        view2.setOnClickListener(this.t);
        oc9 a2 = pc9.a(tbPageContext);
        this.p = a2;
        a2.F0(this);
        this.c = this.p.d0();
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.video_thumbnail);
        this.f = tbImageView;
        tbImageView.setEvent(this.q);
        this.g = (ImageView) this.b.findViewById(R.id.img_play);
        this.j = this.p.Z();
        this.k = BdUtilHelper.getEquipmentWidth(this.a.getPageActivity());
        this.l = BdUtilHelper.getEquipmentHeight(this.a.getPageActivity());
        this.n = pc9.c(this.a);
    }

    public void s(mc9 mc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mc9Var) == null) {
            this.o = mc9Var;
            if (mc9Var != null) {
                mc9Var.t(this.x);
            }
        }
    }

    public void t(boolean z) {
        oc9 oc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (oc9Var = this.p) != null) {
            oc9Var.A0(z);
        }
    }

    public void u(boolean z) {
        oc9 oc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (oc9Var = this.p) != null) {
            oc9Var.L0(z);
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (r()) {
                return 0;
            }
            return this.c.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return !this.i;
        }
        return invokeV.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b != null && this.c != null && this.f != null && this.g != null && this.j != null && this.o != null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        oc9 oc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (oc9Var = this.p) != null && this.c != null && this.e != null) {
            oc9Var.N0();
            this.p.y0(this.b);
            if (this.p.c0()) {
                this.p.O();
            }
            this.p.f0().setOnProgressUpdatedListener(this.s);
            this.p.f0().setOnDragingListener(this.w);
            this.p.f0().setOnSeekBarChangeListener(this.r);
            this.p.x0(this.v);
            this.p.E0(this.e.d);
            this.p.G0(this.e.g);
            this.p.H0(this.h);
            this.p.v0(this.u);
            this.p.p0();
            this.p.J0();
        }
    }

    public void v() {
        oc9 oc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.m) {
            return;
        }
        int i = this.d;
        if (i > 0 && i != jc9.a) {
            return;
        }
        this.m = true;
        if (r()) {
            return;
        }
        o();
        if (uqa.b() && (oc9Var = this.p) != null) {
            oc9Var.M0(this.h);
        }
    }

    public void w() {
        oc9 oc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || r()) {
            return;
        }
        if (this.m && (oc9Var = this.p) != null && this.b.equals(oc9Var.a0())) {
            this.p.N0();
            if (this.p.c0()) {
                this.p.h0();
            }
        }
        this.m = false;
        this.i = false;
    }

    public void x(ImmersiveVideoCardEx.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, aVar, i) == null) {
            this.e = aVar;
            this.d = i;
            if (r() || aVar == null) {
                return;
            }
            String str = this.h;
            if (str != null && str.equalsIgnoreCase(aVar.a)) {
                return;
            }
            w();
            this.h = aVar.a;
            this.f.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f.startLoad(aVar.d, 17, false);
            int i2 = aVar.e;
            int i3 = aVar.f;
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (i2 > 0 && i3 > 0 && layoutParams != null && !aVar.h) {
                if (i2 > i3) {
                    layoutParams.height = ((this.k * 1) * i3) / i2;
                } else {
                    layoutParams.height = this.k;
                }
                this.b.setLayoutParams(layoutParams);
                this.p.K0();
            } else if (layoutParams != null && aVar.h) {
                layoutParams.width = this.k;
                layoutParams.height = this.l;
                this.b.setLayoutParams(layoutParams);
                this.p.i0();
            }
            this.p.R();
        }
    }

    public void y(String str, String str2) {
        oc9 oc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) && (oc9Var = this.p) != null) {
            oc9Var.P0(str, str2);
        }
    }
}
