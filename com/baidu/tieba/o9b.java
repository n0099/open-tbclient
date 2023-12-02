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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.k8b;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.videoplay.videoview.VideoMediaController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o9b extends oea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int U0;
    public int V0;
    public String W0;
    public String X0;
    public TbPageContext<BaseFragmentActivity> Y0;
    public BdUniqueId Z0;
    public VideoItemData a1;
    public int b1;
    public View c1;
    public View d1;
    public boolean e1;
    public boolean f1;
    public ObjectAnimator g1;
    public ObjectAnimator h1;
    public zv9 i1;
    public VideoDanmuController j1;
    public k8b k1;
    public d l1;
    public Runnable m1;
    public Runnable n1;

    /* loaded from: classes7.dex */
    public interface d {
        void a(boolean z);
    }

    @Override // com.baidu.tieba.oea
    public void D0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.oea
    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? R.layout.obfuscated_res_0x7f0d078e : invokeV.intValue;
    }

    @Override // com.baidu.tieba.oea
    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o9b a;

        public a(o9b o9bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o9bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o9bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o9b a;

        public b(o9b o9bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o9bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o9bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f1 && (this.a.S instanceof Activity)) {
                this.a.P0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements k8b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o9b a;

        public c(o9b o9bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o9bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o9bVar;
        }

        @Override // com.baidu.tieba.k8b.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.j1 != null && this.a.k1 != null) {
                if (z) {
                    this.a.j1.a0();
                    if (this.a.t.getControl().isPlaying()) {
                        this.a.j1.V();
                    } else {
                        this.a.j1.S();
                    }
                } else {
                    this.a.j1.S();
                    this.a.j1.I();
                }
                this.a.k1.j(z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o9b(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId, View view2, int i) {
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
        this.V0 = 0;
        this.m1 = new a(this);
        this.n1 = new b(this);
        this.Y0 = tbPageContext;
        this.Z0 = bdUniqueId;
        this.V = bdUniqueId;
        this.b1 = i;
        V();
        if (!TbSingleton.getInstance().isNotchScreen(tbPageContext.getPageActivity()) && !TbSingleton.getInstance().isCutoutScreen(tbPageContext.getPageActivity())) {
            z = false;
        } else {
            z = true;
        }
        this.e1 = z;
        d0(true);
        e0(true);
        this.g0 = false;
    }

    public void R0(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, videoItemData) != null) || videoItemData == null) {
            return;
        }
        this.a1 = videoItemData;
        setData(videoItemData.threadData);
    }

    public void S0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.l1 = dVar;
        }
    }

    public void T0(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zv9Var) == null) {
            this.i1 = zv9Var;
        }
    }

    @Override // com.baidu.tieba.oea
    public boolean k0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            if (!this.c0 && motionEvent.getX() <= this.U0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.oea
    public void E0() {
        gea geaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (geaVar = this.d0) != null) {
            gea b2 = geaVar.b();
            b2.a = "pb";
            vda.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
        }
    }

    public zv9 O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VideoDanmuController videoDanmuController = this.j1;
            if (videoDanmuController != null) {
                return videoDanmuController.G();
            }
            return null;
        }
        return (zv9) invokeV.objValue;
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            U0();
            UtilHelper.hideStatusBar((Activity) this.S, this.c1);
            this.f1 = false;
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d0(false);
            e0(false);
            this.l1 = null;
            VideoDanmuController videoDanmuController = this.j1;
            if (videoDanmuController != null) {
                videoDanmuController.U();
            }
            k8b k8bVar = this.k1;
            if (k8bVar != null) {
                k8bVar.f();
            }
        }
    }

    @Override // com.baidu.tieba.oea
    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.i0();
            this.u.clearCornerFlag();
            this.u.setDrawCorner(false);
            this.U0 = BdUtilHelper.getEquipmentWidth(this.S) / 10;
            this.H.setShareFrom(18);
        }
    }

    @Override // com.baidu.tieba.oea
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.h1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d1, Key.ALPHA, 1.0f, 0.0f);
                this.h1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.h1.start();
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.g1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d1, Key.ALPHA, 0.0f, 1.0f);
                this.g1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.g1.start();
        }
    }

    @Override // com.baidu.tieba.oea, com.baidu.tieba.lea
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.S, true, 10);
            SafeHandler.getInst().removeCallbacks(this.m1);
            SafeHandler.getInst().postDelayed(this.m1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.oea
    public void V() {
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

    @Override // com.baidu.tieba.oea
    public void W() {
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
                i = BdUtilHelper.getDimens(this.S, R.dimen.tbds42);
            } else {
                i = 0;
            }
            if (this.c0 && !this.X) {
                i2 = BdUtilHelper.getDimens(this.S, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = i;
            layoutParams.rightMargin = i2;
        }
    }

    @Override // com.baidu.tieba.oea
    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            Context context = this.S;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.c0);
            }
            super.b0(z);
            if (this.c0) {
                this.U.setVisibility(0);
                z0();
            } else {
                this.U.setVisibility(8);
                this.U.removeView(this.t);
            }
            d dVar = this.l1;
            if (dVar != null) {
                dVar.a(this.c0);
            }
            VideoDanmuController videoDanmuController = this.j1;
            if (videoDanmuController != null) {
                if (this.c0) {
                    videoDanmuController.c0(this.i1);
                } else {
                    videoDanmuController.d0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.oea, android.view.View.OnClickListener
    public void onClick(View view2) {
        k8b k8bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091d8e) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        } else if (id == R.id.obfuscated_res_0x7f0929b6 && (k8bVar = this.k1) != null) {
            k8bVar.i();
            VideoItemData videoItemData = this.a1;
            if (videoItemData != null) {
                this.k1.e(videoItemData.thread_id, this.b1);
            }
        }
        super.onClick(view2);
    }

    @Override // com.baidu.tieba.oea, com.baidu.tieba.lea
    public void setData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, threadData) != null) || threadData == null) {
            return;
        }
        gea geaVar = new gea();
        geaVar.a = "6";
        geaVar.c = threadData.getTid();
        geaVar.d = Long.toString(threadData.getFid());
        geaVar.e = TbadkCoreApplication.getCurrentAccount();
        geaVar.x = this.a1.getChannelMidRequestNum();
        geaVar.y = this.a1.getChannelMidRequestVideoNum();
        Context context = this.S;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.V0 = intExtra;
                if (intExtra == 0) {
                    this.V0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.W0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    geaVar.k = this.W0;
                }
                geaVar.i = Integer.toString(this.V0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.X0 = stringExtra2;
                geaVar.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            geaVar.m = threadData.getThreadVideoInfo().video_md5;
            geaVar.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(geaVar);
        if (this.c0 && threadData.getThreadVideoInfo() != null) {
            boolean z2 = this.X;
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 != z) {
                a0();
            }
        }
        super.setData(threadData);
        d0(!this.X);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        if (!TextUtils.isEmpty(this.Y) && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            VideoDanmuController videoDanmuController = new VideoDanmuController(this.Y0, this.Z0, this.U, R.id.obfuscated_res_0x7f0929b7, this.a1, this.b1);
            this.j1 = videoDanmuController;
            videoDanmuController.X(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
        }
        View findViewById = this.U.findViewById(R.id.video_full_screen);
        View findViewById2 = this.U.findViewById(R.id.video_media_controller);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
        if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
            k8b k8bVar = this.k1;
            if (k8bVar != null) {
                k8bVar.f();
                this.k1 = null;
            }
            k8b k8bVar2 = new k8b(this.U, R.id.obfuscated_res_0x7f0929b6);
            this.k1 = k8bVar2;
            k8bVar2.g(this);
            this.k1.h(new c(this));
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

    @Override // com.baidu.tieba.oea
    public void x0(int i) {
        View findViewById;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            int i3 = this.p;
            int i4 = this.k;
            if (i3 != i4 && i == i4) {
                SafeHandler.getInst().removeCallbacks(this.m1);
                int i5 = this.p;
                if ((i5 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i5 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.x0(i);
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
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest() && (findViewById = this.U.findViewById(R.id.obfuscated_res_0x7f0929b6)) != null) {
                if ((i & 64) > 0) {
                    i6 = 0;
                }
                findViewById.setVisibility(i6);
            }
            if (!this.c0 && !this.e1 && (this.S instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.f1) {
                        V0();
                        UtilHelper.showStatusBar((Activity) this.S, this.c1);
                        this.f1 = true;
                        SafeHandler.getInst().removeCallbacks(this.n1);
                        SafeHandler.getInst().postDelayed(this.n1, 3000L);
                    }
                } else if (this.f1) {
                    P0();
                }
            }
            VideoDanmuController videoDanmuController = this.j1;
            if (videoDanmuController != null) {
                if (i != this.d && i != this.f) {
                    videoDanmuController.S();
                } else {
                    this.j1.V();
                }
            }
        }
    }
}
