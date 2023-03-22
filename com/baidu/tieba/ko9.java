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
import com.baidu.tieba.jn9;
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
public class ko9 extends my8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int S0;
    public int T0;
    public String U0;
    public String V0;
    public TbPageContext<BaseFragmentActivity> W0;
    public BdUniqueId X0;
    public VideoItemData Y0;
    public int Z0;
    public View a1;
    public View b1;
    public boolean c1;
    public boolean d1;
    public ObjectAnimator e1;
    public ObjectAnimator f1;
    public ki8 g1;
    public VideoDanmuController h1;
    public jn9 i1;
    public d j1;
    public Runnable k1;
    public Runnable l1;

    /* loaded from: classes5.dex */
    public interface d {
        void a(boolean z);
    }

    @Override // com.baidu.tieba.my8
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.obfuscated_res_0x7f0d06e7 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.my8
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.my8
    public void z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ko9 a;

        public a(ko9 ko9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ko9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ko9Var;
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
        public final /* synthetic */ ko9 a;

        public b(ko9 ko9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ko9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ko9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d1 && (this.a.R instanceof Activity)) {
                this.a.L0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements jn9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ko9 a;

        public c(ko9 ko9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ko9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ko9Var;
        }

        @Override // com.baidu.tieba.jn9.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.h1 != null && this.a.i1 != null) {
                if (z) {
                    this.a.h1.a0();
                    if (this.a.t.getControl().isPlaying()) {
                        this.a.h1.V();
                    } else {
                        this.a.h1.S();
                    }
                } else {
                    this.a.h1.S();
                    this.a.h1.I();
                }
                this.a.i1.j(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ko9(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, View view2, int i) {
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
        this.T0 = 0;
        this.k1 = new a(this);
        this.l1 = new b(this);
        this.W0 = tbPageContext;
        this.X0 = bdUniqueId;
        this.U = bdUniqueId;
        this.Z0 = i;
        S();
        if (!TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) && !TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity())) {
            z = false;
        } else {
            z = true;
        }
        this.c1 = z;
        a0(true);
        b0(true);
        this.f0 = false;
    }

    public void N0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, videoItemData) != null) || videoItemData == null) {
            return;
        }
        this.Y0 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void O0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.j1 = dVar;
        }
    }

    public void P0(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ki8Var) == null) {
            this.g1 = ki8Var;
        }
    }

    @Override // com.baidu.tieba.my8
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            if (!this.b0 && motionEvent.getX() <= this.S0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.my8
    public void A0() {
        ey8 ey8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ey8Var = this.c0) != null) {
            ey8 b2 = ey8Var.b();
            b2.a = "pb";
            tx8.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
        }
    }

    public ki8 K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            VideoDanmuController videoDanmuController = this.h1;
            if (videoDanmuController != null) {
                return videoDanmuController.G();
            }
            return null;
        }
        return (ki8) invokeV.objValue;
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Q0();
            UtilHelper.hideStatusBar((Activity) this.R, this.a1);
            this.d1 = false;
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a0(false);
            b0(false);
            this.j1 = null;
            VideoDanmuController videoDanmuController = this.h1;
            if (videoDanmuController != null) {
                videoDanmuController.U();
            }
            jn9 jn9Var = this.i1;
            if (jn9Var != null) {
                jn9Var.f();
            }
        }
    }

    @Override // com.baidu.tieba.my8
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.g0();
            this.u.s();
            this.u.setDrawCorner(false);
            this.S0 = hi.l(this.R) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // com.baidu.tieba.my8
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b1, Key.ALPHA, 1.0f, 0.0f);
                this.f1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.f1.start();
        }
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.e1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b1, Key.ALPHA, 0.0f, 1.0f);
                this.e1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.e1.start();
        }
    }

    @Override // com.baidu.tieba.my8, com.baidu.tieba.jy8
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.R, true, 10);
            jg.a().removeCallbacks(this.k1);
            jg.a().postDelayed(this.k1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.my8
    public void S() {
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

    @Override // com.baidu.tieba.my8
    public void T() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.G.a(this.W, this.b0);
            this.H.e(this.W, this.b0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof VideoMediaController) {
                ((VideoMediaController) operableVideoMediaControllerView).q(this.W, this.b0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i2 = 0;
            if (this.b0 && this.W) {
                i = hi.g(this.R, R.dimen.tbds42);
            } else {
                i = 0;
            }
            if (this.b0 && !this.W) {
                i2 = hi.g(this.R, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = i;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // com.baidu.tieba.my8
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            Context context = this.R;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.b0);
            }
            super.Y(z);
            if (this.b0) {
                this.T.setVisibility(0);
                w0();
            } else {
                this.T.setVisibility(8);
                this.T.removeView(this.t);
            }
            d dVar = this.j1;
            if (dVar != null) {
                dVar.a(this.b0);
            }
            VideoDanmuController videoDanmuController = this.h1;
            if (videoDanmuController != null) {
                if (this.b0) {
                    videoDanmuController.c0(this.g1);
                } else {
                    videoDanmuController.d0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.my8, android.view.View.OnClickListener
    public void onClick(View view2) {
        jn9 jn9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091b84) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == R.id.obfuscated_res_0x7f09272f && (jn9Var = this.i1) != null) {
            jn9Var.i();
            VideoItemData videoItemData = this.Y0;
            if (videoItemData != null) {
                this.i1.e(videoItemData.thread_id, this.Z0);
            }
        }
        super.onClick(view2);
    }

    @Override // com.baidu.tieba.my8, com.baidu.tieba.jy8
    public void setData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, threadData) != null) || threadData == null) {
            return;
        }
        ey8 ey8Var = new ey8();
        ey8Var.a = "6";
        ey8Var.c = threadData.getTid();
        ey8Var.d = Long.toString(threadData.getFid());
        ey8Var.e = TbadkCoreApplication.getCurrentAccount();
        ey8Var.x = this.Y0.getChannelMidRequestNum();
        ey8Var.y = this.Y0.getChannelMidRequestVideoNum();
        Context context = this.R;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.T0 = intExtra;
                if (intExtra == 0) {
                    this.T0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.U0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    ey8Var.k = this.U0;
                }
                ey8Var.i = Integer.toString(this.T0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.V0 = stringExtra2;
                ey8Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            ey8Var.m = threadData.getThreadVideoInfo().video_md5;
            ey8Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(ey8Var);
        if (this.b0 && threadData.getThreadVideoInfo() != null) {
            boolean z2 = this.W;
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 != z) {
                X();
            }
        }
        super.setData(threadData);
        a0(!this.W);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.X) && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.W0, this.X0, this.T, R.id.obfuscated_res_0x7f092730, this.Y0, this.Z0);
            this.h1 = videoDanmuController;
            videoDanmuController.X(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
        }
        View findViewById = this.T.findViewById(R.id.video_full_screen);
        View findViewById2 = this.T.findViewById(R.id.video_media_controller);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            jn9 jn9Var = this.i1;
            if (jn9Var != null) {
                jn9Var.f();
                this.i1 = null;
            }
            jn9 jn9Var2 = new jn9(this.T, R.id.obfuscated_res_0x7f09272f);
            this.i1 = jn9Var2;
            jn9Var2.g(this);
            this.i1.h(new c(this));
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

    @Override // com.baidu.tieba.my8
    public void u0(int i) {
        View findViewById;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            int i3 = this.p;
            int i4 = this.k;
            if (i3 != i4 && i == i4) {
                jg.a().removeCallbacks(this.k1);
                int i5 = this.p;
                if ((i5 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.u0(i);
            int i6 = 8;
            if (!this.b0) {
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
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest() && (findViewById = this.T.findViewById(R.id.obfuscated_res_0x7f09272f)) != null) {
                if ((i & 64) > 0) {
                    i6 = 0;
                }
                findViewById.setVisibility(i6);
            }
            if (!this.b0 && !this.c1 && (this.R instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.d1) {
                        R0();
                        UtilHelper.showStatusBar((Activity) this.R, this.a1);
                        this.d1 = true;
                        jg.a().removeCallbacks(this.l1);
                        jg.a().postDelayed(this.l1, 3000L);
                    }
                } else if (this.d1) {
                    L0();
                }
            }
            VideoDanmuController videoDanmuController = this.h1;
            if (videoDanmuController != null) {
                if (i != this.d && i != this.f) {
                    videoDanmuController.S();
                } else {
                    this.h1.V();
                }
            }
        }
    }
}
