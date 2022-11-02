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
import com.baidu.tieba.tv4;
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
/* loaded from: classes6.dex */
public class tx8 extends p9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public MaskVideoView c;
    public bx8 d;
    public Resources e;
    public rv4 f;
    public vx8 g;
    public xx8 h;
    public wx8 i;
    public FrameLayout j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public cr7 o;
    public tv4.e p;

    /* loaded from: classes6.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx8 a;

        /* loaded from: classes6.dex */
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
                    this.a.a.g.z();
                }
            }
        }

        /* renamed from: com.baidu.tieba.tx8$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0429b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0429b(b bVar) {
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
                        tx8 tx8Var = this.a.a;
                        if (tx8Var.l == 0) {
                            tx8Var.c.pause();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        }

        public b(tx8 tx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx8Var;
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
                tx8 tx8Var = this.a;
                if (tx8Var.l != 0) {
                    tx8Var.m.setVolume(1.0f, 1.0f);
                    zg.a().postDelayed(new a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.a.c.start();
                        mediaPlayer.setOnInfoListener(new C0429b(this));
                        return;
                    }
                    this.a.c.seekTo(this.a.g.getCurrentPosition());
                    return;
                }
            }
            this.a.m.setVolume(0.0f, 0.0f);
            zg.a().postDelayed(new a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx8 a;

        public a(tx8 tx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx8Var;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                tx8 tx8Var = this.a;
                if (i == tx8Var.l) {
                    return;
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            tx8Var.h.A().setVisibility(0);
                            this.a.g.p().setVisibility(8);
                            this.a.i.n().setVisibility(8);
                            this.a.g.x(false);
                            this.a.h.H(true);
                            this.a.i.s(false);
                        }
                    } else {
                        tx8Var.i.n().setVisibility(0);
                        this.a.h.A().setVisibility(8);
                        this.a.g.p().setVisibility(8);
                        this.a.g.x(false);
                        if (TextUtils.isEmpty(this.a.h.z())) {
                            this.a.h.H(false);
                        } else {
                            this.a.h.H(true);
                        }
                        this.a.i.s(true);
                    }
                } else {
                    tx8Var.g.p().setVisibility(0);
                    this.a.h.A().setVisibility(8);
                    this.a.i.n().setVisibility(8);
                    this.a.g.x(true);
                    this.a.h.H(false);
                    this.a.i.s(false);
                }
                tx8 tx8Var2 = this.a;
                tx8Var2.l = i;
                tx8Var2.k.setCurrentTab(this.a.l, true, true);
                this.a.g0();
                this.a.K();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx8 a;

        public c(tx8 tx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx8Var;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                tx8 tx8Var = this.a;
                if (tx8Var.l != 0) {
                    tx8Var.S();
                    this.a.h.N();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx8 a;

        public d(tx8 tx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx8 a;

        public e(tx8 tx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.g.r();
                if (this.a.d != null) {
                    this.a.d.onNext();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements tv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx8 a;

        public f(tx8 tx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx8Var;
        }

        @Override // com.baidu.tieba.tv4.e
        public void n0(tv4 tv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, tv4Var, i, view2) == null) {
                if (i != 0) {
                    if (i == 1 && this.a.d != null) {
                        this.a.d.g();
                    }
                } else if (this.a.d != null) {
                    this.a.d.n();
                }
                if (this.a.f != null && this.a.f.isShowing() && this.a.getPageContext() != null) {
                    this.a.f.dismiss();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tx8(r9 r9Var, bx8 bx8Var, View view2, cr7 cr7Var) {
        super(r9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, bx8Var, view2, cr7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.p = new f(this);
        this.d = bx8Var;
        this.a = view2;
        this.o = cr7Var;
        this.e = view2.getResources();
        this.g = new vx8(this.mContext, this);
        this.h = new xx8(this.mContext, this, this.o);
        this.i = new wx8(this.mContext, this);
        this.g.s(this.a);
        this.h.B(this.a);
        this.i.o(this.a);
        F();
        g0();
    }

    public void V(gx8 gx8Var) {
        wx8 wx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, gx8Var) == null) && (wx8Var = this.i) != null) {
            wx8Var.u(gx8Var);
        }
    }

    public void W(MaskVideoView.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) && fVar != null && C() != null) {
            C().setGenMaskCoverListener(fVar);
        }
    }

    public void X(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            this.h.P(list);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            S();
        }
    }

    public void Z(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            this.g.B(list);
        }
    }

    public void a0(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, intent) == null) {
            this.h.R(intent);
        }
    }

    public void d0(ox8 ox8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, ox8Var) == null) {
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(ox8Var);
            }
            wx8 wx8Var = this.i;
            if (wx8Var != null) {
                wx8Var.t(ox8Var);
            }
        }
    }

    public void e0(boolean z) {
        xx8 xx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && (xx8Var = this.h) != null) {
            xx8Var.Q(z);
            Y(!z);
        }
    }

    public Bitmap v(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, bitmap)) == null) {
            return this.g.n(bitmap);
        }
        return (Bitmap) invokeL.objValue;
    }

    public ox8 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            if (this.i != null && !wi.isEmpty(str)) {
                return this.i.m(str);
            }
            return null;
        }
        return (ox8) invokeL.objValue;
    }

    public void M(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            this.h.E(str, str2);
        }
    }

    public void b0(String str, String str2) {
        xx8 xx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) && (xx8Var = this.h) != null) {
            xx8Var.S(str, str2);
        }
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g.q();
        }
        return (String) invokeV.objValue;
    }

    public MaskVideoView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (MaskVideoView) invokeV.objValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.m(this.g.getCurrentPosition());
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.l == 0) {
                P();
                T();
                return;
            }
            S();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            P();
            this.g.v();
            this.h.F();
            this.i.q();
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.c.onResume();
            if (this.l != 0) {
                this.c.r();
            }
            this.g.w();
            this.h.G();
            this.i.r();
        }
    }

    public void P() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.p();
        }
    }

    public void Q() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.onPause();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            vx8 vx8Var = this.g;
            if (vx8Var != null) {
                vx8Var.y();
            }
            MaskVideoView maskVideoView = this.c;
            if (maskVideoView != null) {
                maskVideoView.stopPlayback();
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            P();
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

    public void T() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (maskVideoView = this.c) != null) {
            maskVideoView.seekTo(this.g.getCurrentPosition());
        }
    }

    public final void g0() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
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

    public void w() {
        bx8 bx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (bx8Var = this.d) != null) {
            bx8Var.y();
        }
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.h.y();
        }
        return (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.h.z();
        }
        return (String) invokeV.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setCenterTextTitle(this.e.getString(R.string.obfuscated_res_0x7f0f1136));
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.e.getString(R.string.obfuscated_res_0x7f0f1137), new e(this)), (int) R.color.CAM_X0106);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String[] stringArray = this.e.getStringArray(R.array.obfuscated_res_0x7f030010);
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.e.getDimension(R.dimen.obfuscated_res_0x7f07032f));
                this.k.addView(fragmentTabIndicator, i);
            }
            if (!G() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(xi.g(this.mContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070258));
            this.k.setTabSelectionListener(new a(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f091688);
            MaskVideoView maskVideoView = (MaskVideoView) this.a.findViewById(R.id.obfuscated_res_0x7f0925d4);
            this.c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.c.setZOrderMediaOverlay(true);
            this.c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090885);
            this.j = frameLayout;
            frameLayout.addView(this.g.p());
            this.k = (FragmentTabWidget) this.a.findViewById(R.id.obfuscated_res_0x7f09206e);
            D();
            E();
            this.j.addView(this.h.A());
            this.j.addView(this.i.n());
            this.h.A().setVisibility(8);
            this.i.n().setVisibility(8);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).E1(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.d.g();
                return;
            }
            if (this.f == null) {
                String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f10d0), getPageContext().getString(R.string.obfuscated_res_0x7f0f0ceb)};
                rv4 rv4Var = new rv4(getPageContext());
                this.f = rv4Var;
                rv4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10de));
                this.f.i(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f10de), strArr, this.p);
            }
            this.f.k();
        }
    }

    public void L(r9 r9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, r9Var, i) == null) {
            this.b.onChangeSkinType(r9Var, i);
            this.k.i(i);
            this.k.setDiverColor(SkinManager.getColor(i, (int) R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            vx8 vx8Var = this.g;
            if (vx8Var != null) {
                vx8Var.u(r9Var, i);
            }
            xx8 xx8Var = this.h;
            if (xx8Var != null) {
                xx8Var.D(r9Var, i);
            }
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.g.A(str);
            this.c.setVideoPath(str);
            this.c.setOnPreparedListener(new b(this));
            this.c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
