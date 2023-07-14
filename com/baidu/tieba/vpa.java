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
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.roa;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.videoplay.videoview.VideoMediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vpa extends iv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int T0;
    public int U0;
    public String V0;
    public String W0;
    public TbPageContext<BaseFragmentActivity> X0;
    public BdUniqueId Y0;
    public VideoItemData Z0;
    public int a1;
    public View b1;
    public View c1;
    public boolean d1;
    public boolean e1;
    public ObjectAnimator f1;
    public ObjectAnimator g1;
    public ze9 h1;
    public VideoDanmuController i1;
    public roa j1;
    public d k1;
    public Runnable l1;
    public Runnable m1;

    /* loaded from: classes8.dex */
    public interface d {
        void a(boolean z);
    }

    @Override // com.baidu.tieba.iv9
    public void B0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.iv9
    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? R.layout.obfuscated_res_0x7f0d074c : invokeV.intValue;
    }

    @Override // com.baidu.tieba.iv9
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vpa a;

        public a(vpa vpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vpaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vpaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vpa a;

        public b(vpa vpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vpaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vpaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e1 && (this.a.S instanceof Activity)) {
                this.a.N0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements roa.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vpa a;

        public c(vpa vpaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vpaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vpaVar;
        }

        @Override // com.baidu.tieba.roa.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.i1 != null && this.a.j1 != null) {
                if (z) {
                    this.a.i1.a0();
                    if (this.a.t.getControl().isPlaying()) {
                        this.a.i1.V();
                    } else {
                        this.a.i1.S();
                    }
                } else {
                    this.a.i1.S();
                    this.a.i1.I();
                }
                this.a.j1.j(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vpa(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, View view2, int i) {
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
        this.U0 = 0;
        this.l1 = new a(this);
        this.m1 = new b(this);
        this.X0 = tbPageContext;
        this.Y0 = bdUniqueId;
        this.V = bdUniqueId;
        this.a1 = i;
        T();
        if (!TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) && !TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity())) {
            z = false;
        } else {
            z = true;
        }
        this.d1 = z;
        b0(true);
        c0(true);
        this.g0 = false;
    }

    public void P0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, videoItemData) != null) || videoItemData == null) {
            return;
        }
        this.Z0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void Q0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.k1 = dVar;
        }
    }

    public void R0(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ze9Var) == null) {
            this.h1 = ze9Var;
        }
    }

    @Override // com.baidu.tieba.iv9
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            if (!this.c0 && motionEvent.getX() <= this.T0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iv9
    public void C0() {
        av9 av9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (av9Var = this.d0) != null) {
            av9 b2 = av9Var.b();
            b2.a = "pb";
            ou9.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
        }
    }

    public ze9 M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoDanmuController videoDanmuController = this.i1;
            if (videoDanmuController != null) {
                return videoDanmuController.G();
            }
            return null;
        }
        return (ze9) invokeV.objValue;
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            S0();
            UtilHelper.hideStatusBar((Activity) this.S, this.b1);
            this.e1 = false;
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b0(false);
            c0(false);
            this.k1 = null;
            VideoDanmuController videoDanmuController = this.i1;
            if (videoDanmuController != null) {
                videoDanmuController.U();
            }
            roa roaVar = this.j1;
            if (roaVar != null) {
                roaVar.f();
            }
        }
    }

    @Override // com.baidu.tieba.iv9
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.g0();
            this.u.s();
            this.u.setDrawCorner(false);
            this.T0 = yi.l(this.S) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // com.baidu.tieba.iv9
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.g1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, Key.ALPHA, 1.0f, 0.0f);
                this.g1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.g1.start();
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c1, Key.ALPHA, 0.0f, 1.0f);
                this.f1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.f1.start();
        }
    }

    @Override // com.baidu.tieba.iv9, com.baidu.tieba.fv9
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.S, true, 10);
            zg.a().removeCallbacks(this.l1);
            zg.a().postDelayed(this.l1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iv9
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

    @Override // com.baidu.tieba.iv9
    public void U() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.G.a(this.X, this.c0);
            this.H.e(this.X, this.c0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).u(this.X, this.c0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i2 = 0;
            if (this.c0 && this.X) {
                i = yi.g(this.S, R.dimen.tbds42);
            } else {
                i = 0;
            }
            if (this.c0 && !this.X) {
                i2 = yi.g(this.S, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = i;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // com.baidu.tieba.iv9
    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            Context context = this.S;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.c0);
            }
            super.Z(z);
            if (this.c0) {
                this.U.setVisibility(0);
                x0();
            } else {
                this.U.setVisibility(8);
                this.U.removeView(this.t);
            }
            d dVar = this.k1;
            if (dVar != null) {
                dVar.a(this.c0);
            }
            VideoDanmuController videoDanmuController = this.i1;
            if (videoDanmuController != null) {
                if (this.c0) {
                    videoDanmuController.c0(this.h1);
                } else {
                    videoDanmuController.d0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.iv9, android.view.View.OnClickListener
    public void onClick(View view2) {
        roa roaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091c7a) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == R.id.obfuscated_res_0x7f092889 && (roaVar = this.j1) != null) {
            roaVar.i();
            VideoItemData videoItemData = this.Z0;
            if (videoItemData != null) {
                this.j1.e(videoItemData.thread_id, this.a1);
            }
        }
        super.onClick(view2);
    }

    @Override // com.baidu.tieba.iv9, com.baidu.tieba.fv9
    public void setData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, threadData) != null) || threadData == null) {
            return;
        }
        av9 av9Var = new av9();
        av9Var.a = "6";
        av9Var.c = threadData.getTid();
        av9Var.d = Long.toString(threadData.getFid());
        av9Var.e = TbadkCoreApplication.getCurrentAccount();
        av9Var.x = this.Z0.getChannelMidRequestNum();
        av9Var.y = this.Z0.getChannelMidRequestVideoNum();
        Context context = this.S;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.U0 = intExtra;
                if (intExtra == 0) {
                    this.U0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.V0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    av9Var.k = this.V0;
                }
                av9Var.i = Integer.toString(this.U0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.W0 = stringExtra2;
                av9Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            av9Var.m = threadData.getThreadVideoInfo().video_md5;
            av9Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(av9Var);
        if (this.c0 && threadData.getThreadVideoInfo() != null) {
            boolean z2 = this.X;
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 != z) {
                Y();
            }
        }
        super.setData(threadData);
        b0(!this.X);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.Y) && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.X0, this.Y0, this.U, R.id.obfuscated_res_0x7f09288a, this.Z0, this.a1);
            this.i1 = videoDanmuController;
            videoDanmuController.X(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
        }
        View findViewById = this.U.findViewById(R.id.video_full_screen);
        View findViewById2 = this.U.findViewById(R.id.video_media_controller);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            roa roaVar = this.j1;
            if (roaVar != null) {
                roaVar.f();
                this.j1 = null;
            }
            roa roaVar2 = new roa(this.U, R.id.obfuscated_res_0x7f092889);
            this.j1 = roaVar2;
            roaVar2.g(this);
            this.j1.h(new c(this));
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

    @Override // com.baidu.tieba.iv9
    public void v0(int i) {
        View findViewById;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            int i3 = this.p;
            int i4 = this.k;
            if (i3 != i4 && i == i4) {
                zg.a().removeCallbacks(this.l1);
                int i5 = this.p;
                if ((i5 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.v0(i);
            int i6 = 8;
            if (!this.c0) {
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
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest() && (findViewById = this.U.findViewById(R.id.obfuscated_res_0x7f092889)) != null) {
                if ((i & 64) > 0) {
                    i6 = 0;
                }
                findViewById.setVisibility(i6);
            }
            if (!this.c0 && !this.d1 && (this.S instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.e1) {
                        T0();
                        UtilHelper.showStatusBar((Activity) this.S, this.b1);
                        this.e1 = true;
                        zg.a().removeCallbacks(this.m1);
                        zg.a().postDelayed(this.m1, 3000L);
                    }
                } else if (this.e1) {
                    N0();
                }
            }
            VideoDanmuController videoDanmuController = this.i1;
            if (videoDanmuController != null) {
                if (i != this.d && i != this.f) {
                    videoDanmuController.S();
                } else {
                    this.i1.V();
                }
            }
        }
    }
}
