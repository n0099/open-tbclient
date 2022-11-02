package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.oz8;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.videoplay.videoview.VideoMediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p09 extends cd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public int O0;
    public String P0;
    public String Q0;
    public TbPageContext<BaseFragmentActivity> R0;
    public BdUniqueId S0;
    public VideoItemData T0;
    public int U0;
    public View V0;
    public View W0;
    public boolean X0;
    public boolean Y0;
    public ObjectAnimator Z0;
    public ObjectAnimator a1;
    public dx7 b1;
    public VideoDanmuController c1;
    public oz8 d1;
    public d e1;
    public Runnable f1;
    public Runnable g1;

    /* loaded from: classes5.dex */
    public interface d {
        void a(boolean z);
    }

    @Override // com.baidu.tieba.cd8
    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? R.layout.obfuscated_res_0x7f0d06a4 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.cd8
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cd8
    public void t0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p09 a;

        public a(p09 p09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p09Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p09 a;

        public b(p09 p09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p09Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.Y0 && (this.a.O instanceof Activity)) {
                this.a.E0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements oz8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p09 a;

        public c(p09 p09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p09Var;
        }

        @Override // com.baidu.tieba.oz8.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.c1 != null && this.a.d1 != null) {
                if (z) {
                    this.a.c1.Z();
                    if (this.a.t.getControl().isPlaying()) {
                        this.a.c1.U();
                    } else {
                        this.a.c1.R();
                    }
                } else {
                    this.a.c1.R();
                    this.a.c1.H();
                }
                this.a.d1.j(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p09(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, View view2, int i) {
        super(tbPageContext.getPageActivity(), view2);
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, view2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.O0 = 0;
        this.f1 = new a(this);
        this.g1 = new b(this);
        this.R0 = tbPageContext;
        this.S0 = bdUniqueId;
        this.R = bdUniqueId;
        this.U0 = i;
        P();
        if (!TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) && !TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity())) {
            z = false;
        } else {
            z = true;
        }
        this.X0 = z;
        X(true);
        Y(true);
        this.c0 = false;
    }

    public void G0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, videoItemData) != null) || videoItemData == null) {
            return;
        }
        this.T0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void H0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.e1 = dVar;
        }
    }

    public void I0(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dx7Var) == null) {
            this.b1 = dx7Var;
        }
    }

    @Override // com.baidu.tieba.cd8
    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            if (!this.Y && motionEvent.getX() <= this.N0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public dx7 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                return videoDanmuController.F();
            }
            return null;
        }
        return (dx7) invokeV.objValue;
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J0();
            UtilHelper.hideStatusBar((Activity) this.O, this.V0);
            this.Y0 = false;
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            X(false);
            Y(false);
            this.e1 = null;
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            oz8 oz8Var = this.d1;
            if (oz8Var != null) {
                oz8Var.f();
            }
        }
    }

    @Override // com.baidu.tieba.cd8
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.d0();
            this.u.s();
            this.u.setDrawCorner(false);
            this.N0 = xi.l(this.O) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // com.baidu.tieba.cd8
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.baidu.tieba.cd8
    public void u0() {
        uc8 uc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (uc8Var = this.Z) != null) {
            uc8 b2 = uc8Var.b();
            b2.a = "pb";
            jc8.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.a1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.W0, Key.ALPHA, 1.0f, 0.0f);
                this.a1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.a1.start();
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.Z0 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.W0, Key.ALPHA, 0.0f, 1.0f);
                this.Z0 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.Z0.start();
        }
    }

    @Override // com.baidu.tieba.cd8, com.baidu.tieba.zc8
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, true, 10);
            zg.a().removeCallbacks(this.f1);
            zg.a().postDelayed(this.f1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cd8
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i = this.b & (-33);
            this.b = i;
            int i2 = this.o & (-33);
            this.o = i2;
            int i3 = this.d & (-33);
            this.d = i3;
            int i4 = this.e & (-33);
            this.e = i4;
            int i5 = this.n & (-33);
            this.n = i5;
            int i6 = this.f & (-33);
            this.f = i6;
            int i7 = this.g & (-33);
            this.g = i7;
            int i8 = this.h & (-33);
            this.h = i8;
            int i9 = this.i & (-33);
            this.i = i9;
            int i10 = this.j & (-33);
            this.j = i10;
            int i11 = this.k & (-33);
            this.k = i11;
            this.b = i | 1024;
            this.o = i2 | 1024;
            int i12 = i3 | 1024;
            this.d = i12;
            this.e = i4 & (-1025);
            this.n = i5 & (-1025);
            this.f = i6 | 1024;
            this.g = i7 | 1024;
            int i13 = i8 | 1024;
            this.h = i13;
            int i14 = i9 | 1024;
            this.i = i14;
            this.j = i10 | 1024;
            this.k = i11 & (-1025);
            this.d = i12 | 16384;
            this.h = i13 | 16384;
            this.i = i14 & (-2);
        }
    }

    @Override // com.baidu.tieba.cd8
    public void Q() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).q(this.T, this.Y);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i2 = 0;
            if (this.Y && this.T) {
                i = xi.g(this.O, R.dimen.tbds42);
            } else {
                i = 0;
            }
            if (this.Y && !this.T) {
                i2 = xi.g(this.O, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = i;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // com.baidu.tieba.cd8
    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            Context context = this.O;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.Y);
            }
            super.V(z);
            if (this.Y) {
                this.Q.setVisibility(0);
                q0();
            } else {
                this.Q.setVisibility(8);
                this.Q.removeView(this.t);
            }
            d dVar = this.e1;
            if (dVar != null) {
                dVar.a(this.Y);
            }
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                if (this.Y) {
                    videoDanmuController.b0(this.b1);
                } else {
                    videoDanmuController.c0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cd8
    public void o0(int i) {
        View findViewById;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            int i3 = this.p;
            int i4 = this.k;
            if (i3 != i4 && i == i4) {
                zg.a().removeCallbacks(this.f1);
                int i5 = this.p;
                if ((i5 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.o0(i);
            int i6 = 8;
            if (!this.Y) {
                this.I.setVisibility(8);
                this.J.setVisibility(8);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                int i7 = i & 16384;
                if (i7 <= 0 && (i & 128) <= 0) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                operableVideoMediaControllerView.setVisibility(i2);
                VideoMediaController videoMediaController = (VideoMediaController) this.F;
                if (i7 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                videoMediaController.setBottomBarShow(z);
            }
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest() && (findViewById = this.Q.findViewById(R.id.obfuscated_res_0x7f09255b)) != null) {
                if ((i & 64) > 0) {
                    i6 = 0;
                }
                findViewById.setVisibility(i6);
            }
            if (!this.Y && !this.X0 && (this.O instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.Y0) {
                        K0();
                        UtilHelper.showStatusBar((Activity) this.O, this.V0);
                        this.Y0 = true;
                        zg.a().removeCallbacks(this.g1);
                        zg.a().postDelayed(this.g1, 3000L);
                    }
                } else if (this.Y0) {
                    E0();
                }
            }
            VideoDanmuController videoDanmuController = this.c1;
            if (videoDanmuController != null) {
                if (i != this.d && i != this.f) {
                    videoDanmuController.R();
                } else {
                    this.c1.U();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cd8, android.view.View.OnClickListener
    public void onClick(View view2) {
        oz8 oz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091a2a) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == R.id.obfuscated_res_0x7f09255b && (oz8Var = this.d1) != null) {
            oz8Var.i();
            VideoItemData videoItemData = this.T0;
            if (videoItemData != null) {
                this.d1.e(videoItemData.thread_id, this.U0);
            }
        }
        super.onClick(view2);
    }

    @Override // com.baidu.tieba.cd8, com.baidu.tieba.zc8
    public void setData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, threadData) != null) || threadData == null) {
            return;
        }
        uc8 uc8Var = new uc8();
        uc8Var.a = "6";
        uc8Var.c = threadData.getTid();
        uc8Var.d = Long.toString(threadData.getFid());
        uc8Var.e = TbadkCoreApplication.getCurrentAccount();
        uc8Var.x = this.T0.getChannelMidRequestNum();
        uc8Var.y = this.T0.getChannelMidRequestVideoNum();
        Context context = this.O;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.O0 = intExtra;
                if (intExtra == 0) {
                    this.O0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.P0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    uc8Var.k = this.P0;
                }
                uc8Var.i = Integer.toString(this.O0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.Q0 = stringExtra2;
                uc8Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            uc8Var.m = threadData.getThreadVideoInfo().video_md5;
            uc8Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(uc8Var);
        if (this.Y && threadData.getThreadVideoInfo() != null) {
            boolean z2 = this.T;
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 != z) {
                U();
            }
        }
        super.setData(threadData);
        X(!this.T);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.U) && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.R0, this.S0, this.Q, R.id.obfuscated_res_0x7f09255c, this.T0, this.U0);
            this.c1 = videoDanmuController;
            videoDanmuController.W(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
        }
        View findViewById = this.Q.findViewById(R.id.obfuscated_res_0x7f092562);
        View findViewById2 = this.Q.findViewById(R.id.obfuscated_res_0x7f092581);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            oz8 oz8Var = this.d1;
            if (oz8Var != null) {
                oz8Var.f();
                this.d1 = null;
            }
            oz8 oz8Var2 = new oz8(this.Q, R.id.obfuscated_res_0x7f09255b);
            this.d1 = oz8Var2;
            oz8Var2.g(this);
            this.d1.h(new c(this));
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                findViewById.setPadding(0, findViewById.getPaddingTop(), 0, findViewById.getPaddingBottom());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = UtilHelper.getDimenPixelSize(R.dimen.tbds68);
                layoutParams3.rightMargin = dimenPixelSize;
                ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = dimenPixelSize;
            }
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            findViewById.setPadding(dimenPixelSize, findViewById.getPaddingTop(), dimenPixelSize, findViewById.getPaddingBottom());
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams4.width = UtilHelper.getDimenPixelSize(R.dimen.tbds150);
            layoutParams4.rightMargin = 0;
            ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = 0;
        }
    }
}
