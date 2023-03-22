package com.baidu.tieba;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.k05;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ol9 extends y8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public MaskVideoView c;
    public wk9 d;
    public Resources e;
    public i05 f;
    public ql9 g;
    public sl9 h;
    public rl9 i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public oc8 o;
    public k05.f p;

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol9 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.g.C();
                }
            }
        }

        /* renamed from: com.baidu.tieba.ol9$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0365b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0365b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                    if (i == 3) {
                        ol9 ol9Var = this.a.a;
                        if (ol9Var.l == 0) {
                            ol9Var.c.pause();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        }

        public b(ol9 ol9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol9Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
        @Override // android.media.MediaPlayer.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mediaPlayer) != null) {
                return;
            }
            this.a.m = mediaPlayer;
            if (!this.a.n) {
                ol9 ol9Var = this.a;
                if (ol9Var.l != 0) {
                    ol9Var.m.setVolume(1.0f, 1.0f);
                    jg.a().postDelayed(new a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.a.c.start();
                        mediaPlayer.setOnInfoListener(new C0365b(this));
                        return;
                    }
                    this.a.c.seekTo(this.a.g.getCurrentPosition());
                    return;
                }
            }
            this.a.m.setVolume(0.0f, 0.0f);
            jg.a().postDelayed(new a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements FragmentTabWidget.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol9 a;

        public a(ol9 ol9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol9Var;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                ol9 ol9Var = this.a;
                if (i == ol9Var.l) {
                    return;
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ol9Var.h.D().setVisibility(0);
                            this.a.g.q().setVisibility(8);
                            this.a.i.o().setVisibility(8);
                            this.a.g.A(false);
                            this.a.h.L(true);
                            this.a.i.t(false);
                        }
                    } else {
                        ol9Var.i.o().setVisibility(0);
                        this.a.h.D().setVisibility(8);
                        this.a.g.q().setVisibility(8);
                        this.a.g.A(false);
                        if (TextUtils.isEmpty(this.a.h.C())) {
                            this.a.h.L(false);
                        } else {
                            this.a.h.L(true);
                        }
                        this.a.i.t(true);
                    }
                } else {
                    ol9Var.g.q().setVisibility(0);
                    this.a.h.D().setVisibility(8);
                    this.a.i.o().setVisibility(8);
                    this.a.g.A(true);
                    this.a.h.L(false);
                    this.a.i.t(false);
                }
                ol9 ol9Var2 = this.a;
                ol9Var2.l = i;
                ol9Var2.k.setCurrentTab(this.a.l, true, true);
                this.a.j0();
                this.a.N();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol9 a;

        public c(ol9 ol9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol9Var;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                ol9 ol9Var = this.a;
                if (ol9Var.l != 0) {
                    ol9Var.V();
                    this.a.h.Q();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol9 a;

        public d(ol9 ol9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol9 a;

        public e(ol9 ol9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g.s();
                if (this.a.d != null) {
                    this.a.d.onNext();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements k05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ol9 a;

        public f(ol9 ol9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ol9Var;
        }

        @Override // com.baidu.tieba.k05.f
        public void M0(k05 k05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, k05Var, i, view2) == null) {
                if (i != 0) {
                    if (i == 1 && this.a.d != null) {
                        this.a.d.h();
                    }
                } else if (this.a.d != null) {
                    this.a.d.m();
                }
                if (this.a.f != null && this.a.f.isShowing() && this.a.getPageContext() != null) {
                    this.a.f.dismiss();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ol9(a9 a9Var, wk9 wk9Var, View view2, oc8 oc8Var) {
        super(a9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var, wk9Var, view2, oc8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.p = new f(this);
        this.d = wk9Var;
        this.a = view2;
        this.o = oc8Var;
        this.e = view2.getResources();
        this.g = new ql9(this.mContext, this);
        this.h = new sl9(this.mContext, this, this.o);
        this.i = new rl9(this.mContext, this);
        this.g.t(this.a);
        this.h.E(this.a);
        this.i.p(this.a);
        I();
        j0();
    }

    public jl9 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.i != null && !gi.isEmpty(str)) {
                return this.i.n(str);
            }
            return null;
        }
        return (jl9) invokeL.objValue;
    }

    public void Y(bl9 bl9Var) {
        rl9 rl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, bl9Var) == null) && (rl9Var = this.i) != null) {
            rl9Var.x(bl9Var);
        }
    }

    public void Z(MaskVideoView.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, fVar) == null) && fVar != null && F() != null) {
            F().setGenMaskCoverListener(fVar);
        }
    }

    public void a0(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            this.h.S(list);
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            V();
        }
    }

    public void c0(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            this.g.E(list);
        }
    }

    public void d0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, intent) == null) {
            this.h.U(intent);
        }
    }

    public void g0(jl9 jl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, jl9Var) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(jl9Var);
            }
            rl9 rl9Var = this.i;
            if (rl9Var != null) {
                rl9Var.u(jl9Var);
            }
        }
    }

    public void h0(boolean z) {
        sl9 sl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && (sl9Var = this.h) != null) {
            sl9Var.T(z);
            b0(!z);
        }
    }

    public Bitmap y(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, bitmap)) == null) {
            return this.g.o(bitmap);
        }
        return (Bitmap) invokeL.objValue;
    }

    public void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.h.H(str, str2);
        }
    }

    public void e0(String str, String str2) {
        sl9 sl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, str, str2) == null) && (sl9Var = this.h) != null) {
            sl9Var.V(str, str2);
        }
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h.B();
        }
        return (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h.C();
        }
        return (String) invokeV.objValue;
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g.r();
        }
        return (String) invokeV.objValue;
    }

    public MaskVideoView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (MaskVideoView) invokeV.objValue;
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public void M() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.m(this.g.getCurrentPosition());
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.l == 0) {
                S();
                W();
                return;
            }
            V();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            S();
            this.g.y();
            this.h.I();
            this.i.r();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c.onResume();
            if (this.l != 0) {
                this.c.r();
            }
            this.g.z();
            this.h.J();
            this.i.s();
        }
    }

    public void S() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.p();
        }
    }

    public void T() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.onPause();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ql9 ql9Var = this.g;
            if (ql9Var != null) {
                ql9Var.B();
            }
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.stopPlayback();
            }
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            S();
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.n) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
            this.c.start();
            this.c.seekTo(0);
        }
    }

    public void W() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.seekTo(this.g.getCurrentPosition());
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView == null) {
                return 0;
            }
            return maskVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public final void j0() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c12424");
            if (this.l == 0) {
                i = 1;
            } else {
                i = 3;
            }
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public void z() {
        wk9 wk9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (wk9Var = this.d) != null) {
            wk9Var.z();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.setCenterTextTitle(this.e.getString(R.string.obfuscated_res_0x7f0f11ce));
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.e.getString(R.string.obfuscated_res_0x7f0f11cf), new e(this)), (int) R.color.CAM_X0106);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String[] stringArray = this.e.getStringArray(R.array.obfuscated_res_0x7f030011);
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.e.getDimension(R.dimen.obfuscated_res_0x7f070330));
                this.k.addView(fragmentTabIndicator, i);
            }
            if (!J() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(hi.g(this.mContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070258));
            this.k.setTabSelectionListener(new a(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b = (NavigationBar) this.a.findViewById(R.id.navigation_bar);
            MaskVideoView maskVideoView = (MaskVideoView) this.a.findViewById(R.id.video_view);
            this.c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.c.setZOrderMediaOverlay(true);
            this.c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090925);
            this.j = frameLayout;
            frameLayout.addView(this.g.q());
            this.k = (FragmentTabWidget) this.a.findViewById(R.id.obfuscated_res_0x7f092202);
            G();
            H();
            this.j.addView(this.h.D());
            this.j.addView(this.i.o());
            this.h.D().setVisibility(8);
            this.i.o().setVisibility(8);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).H1(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.d.h();
                return;
            }
            if (this.f == null) {
                String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f1168), getPageContext().getString(R.string.not_save)};
                i05 i05Var = new i05(getPageContext());
                this.f = i05Var;
                i05Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
                this.f.i(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
            }
            this.f.k();
        }
    }

    public void O(a9 a9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, a9Var, i) == null) {
            this.b.onChangeSkinType(a9Var, i);
            this.k.j(i);
            this.k.setDiverColor(SkinManager.getColor(i, (int) R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            ql9 ql9Var = this.g;
            if (ql9Var != null) {
                ql9Var.x(a9Var, i);
            }
            sl9 sl9Var = this.h;
            if (sl9Var != null) {
                sl9Var.G(a9Var, i);
            }
        }
    }

    public void X(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.g.D(str);
            this.c.setVideoPath(str);
            this.c.setOnPreparedListener(new b(this));
            this.c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
