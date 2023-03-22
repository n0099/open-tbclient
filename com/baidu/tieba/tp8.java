package com.baidu.tieba;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.mx8;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.CustomFrameLayout;
import com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.rx8;
import com.baidu.tieba.ze;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import tbclient.McnAdInfo;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class tp8 {
    public static /* synthetic */ Interceptable $ic;
    public static VideoControllerView.c T;
    public static mx8.z U;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoWifiTipLayout A;
    public int B;
    public long C;
    public mx8.g0 D;
    public mx8.u E;
    public boolean F;
    public Handler G;
    public PbFullScreenFloatingHuajiAninationView H;
    public PbFullScreenFloatingHuajiAninationView.c I;
    public ye J;
    public Bitmap K;
    public boolean L;
    public boolean M;
    public boolean N;
    public mx8.d0 O;
    public CustomMessageListener P;
    public int Q;
    public Animation.AnimationListener R;
    public CustomMessageListener S;
    public RelativeLayout a;
    public ro8 b;
    public CustomFrameLayout c;
    public PbFragment d;
    public mx8.u e;
    public String f;
    public VideoInfo g;
    public mx8 h;
    public ey8 i;
    public rp8 j;
    public boolean k;
    public ThreadData l;
    public ThreadData m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public float r;
    public boolean s;
    public boolean t;
    public int u;
    public double v;
    public View w;
    public float x;
    public boolean y;
    public md0 z;

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mx8.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

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
                    if (this.a.a.B > 0) {
                        tp8 tp8Var = this.a.a;
                        tp8Var.M(tp8Var.B);
                        tp8 tp8Var2 = this.a.a;
                        tp8Var2.j0(tp8Var2.B);
                        this.a.a.B = 0;
                    }
                    this.a.a.F = true;
                }
            }
        }

        public b(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.mx8.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.getBaseFragmentActivity().setSwipeBackEnabled(false);
                this.a.F = false;
                tp8 tp8Var = this.a;
                tp8Var.B = tp8Var.P().getHeight();
            }
        }

        @Override // com.baidu.tieba.mx8.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.d.getBaseFragmentActivity().setSwipeBackEnabled(true);
                this.a.G.postDelayed(new a(this), 200L);
                this.a.C = -1L;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements rx8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoInfo a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ThreadData c;
        public final /* synthetic */ tp8 d;

        public a(tp8 tp8Var, VideoInfo videoInfo, String str, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var, videoInfo, str, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tp8Var;
            this.a = videoInfo;
            this.b = str;
            this.c = threadData;
        }

        @Override // com.baidu.tieba.rx8.c
        public void a(int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.d.C <= 0) {
                    this.d.C = i2;
                }
                McnAdInfo mcnAdInfo = this.a.mcn_ad_card;
                if (mcnAdInfo == null) {
                    return;
                }
                boolean a = ld0.b().a(mcnAdInfo.jump_url);
                if (this.d.y && !a && !this.d.o) {
                    boolean z2 = true;
                    if (this.d.C >= (mcnAdInfo.ad_start_time.longValue() * 1000) + 1000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long j = i2;
                    if ((j < mcnAdInfo.ad_start_time.longValue() * 1000 || j >= mcnAdInfo.ad_end_time.longValue() * 1000) ? false : false) {
                        if (!this.d.z.c()) {
                            kd0 kd0Var = new kd0();
                            kd0Var.b = mcnAdInfo.card_title;
                            kd0Var.c = mcnAdInfo.button_title;
                            kd0Var.d = mcnAdInfo.jump_url;
                            kd0Var.a = mcnAdInfo.pic_url;
                            kd0Var.f = this.b;
                            kd0Var.e = this.c.getTid();
                            kd0Var.g = 4;
                            if (z) {
                                this.d.z.f(kd0Var, (ViewGroup) this.d.h.E0());
                            } else {
                                this.d.z.e(kd0Var, (ViewGroup) this.d.h.E0());
                            }
                        }
                    } else if (this.d.z.c()) {
                        this.d.z.a();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements mx8.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public c(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.mx8.y
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null && this.a.m != null && !StringUtils.isNull(this.a.m.getId())) {
                this.a.d.k6(this.a.m.getId());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements mx8.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public d(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.mx8.a0
        public void a(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.l != null) {
                tp8 tp8Var = this.a;
                if (z) {
                    str = "1";
                } else {
                    str = "2";
                }
                tp8Var.l0(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public e(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.a.f);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements xe {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        @Override // com.baidu.tieba.xe
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public f(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.xe
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                ImageView imageView = new ImageView(this.a.d.getActivity());
                if (this.a.K == null) {
                    try {
                        this.a.K = BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f080f8d);
                        imageView.setImageBitmap(this.a.K);
                    } catch (Throwable unused) {
                    }
                }
                return imageView;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ze.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        @Override // com.baidu.tieba.ze.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public g(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.ze.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.J = null;
            if (this.a.K != null && !this.a.K.isRecycled()) {
                this.a.K.recycle();
            }
            this.a.K = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements VideoControllerView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.play.VideoControllerView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class i implements mx8.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.mx8.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public j(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tp8 tp8Var = this.a;
                tp8Var.j0(tp8Var.P().getHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements mx8.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public k(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.mx8.g0
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null && this.a.d.L() != null && this.a.d.L().w1() != null) {
                bc9 j = this.a.d.L().w1().j();
                if (j == null && ListUtils.getCount(this.a.d.L().w1().H()) > 1) {
                    j = (bc9) ListUtils.getItem(this.a.d.L().w1().H(), 0);
                }
                mp8.b(this.a.d.L().w1(), j, 1, 1, 4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public l(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(tp8 tp8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.g != null) {
                tp8 tp8Var = this.a;
                tp8Var.b0(tp8Var.g);
                this.a.h.q0();
                if (this.a.w != null && this.a.w.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.w.getLayoutParams();
                    layoutParams.height = this.a.u;
                    this.a.w.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements PbFullScreenFloatingHuajiAninationView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public n(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.N(false);
        }
    }

    /* loaded from: classes6.dex */
    public class o implements mx8.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        @Override // com.baidu.tieba.mx8.d0
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public o(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.mx8.d0
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v >= 1.0d) {
                    if (!this.a.d.checkUpIsLogin()) {
                        return true;
                    }
                    this.a.d.Z5();
                    if (this.a.d.L() != null && this.a.d.L().w1() != null && this.a.d.L().w1().U() != null) {
                        yi8 U = this.a.d.L().w1().U();
                        if (this.a.H == null) {
                            this.a.H = new PbFullScreenFloatingHuajiAninationView(this.a.d.getActivity());
                            this.a.H.setFloatingHuajiAninationListener(this.a.I);
                        }
                        this.a.H.f(!U.f());
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(tp8 tp8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                if (this.a.h != null) {
                    this.a.h.m1();
                }
                if (BdNetTypeUtil.isMobileNet() && this.a.h != null && this.a.h.R0() && this.a.g != null && this.a.g.video_length.intValue() > 0 && this.a.g.video_duration.intValue() > 0) {
                    DecimalFormat decimalFormat = new DecimalFormat("0.0");
                    double intValue = ((this.a.g.video_length.intValue() * (1.0f - ((this.a.h.B0() * 1.0f) / (this.a.g.video_duration.intValue() * 1000)))) * 1.0f) / 1048576.0f;
                    if (intValue >= 0.1d) {
                        hi.Q(this.a.d.getPageContext().getPageActivity(), String.format(this.a.d.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ee5), decimalFormat.format(intValue)));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements mx8.e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public q(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // com.baidu.tieba.mx8.e0
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, seekBar) != null) {
                return;
            }
            this.a.C = -1L;
        }
    }

    /* loaded from: classes6.dex */
    public class r implements mx8.b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        @Override // com.baidu.tieba.mx8.b0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.mx8.b0
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public r(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
            if (r5 != 3) goto L11;
         */
        @Override // com.baidu.tieba.mx8.b0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            if (this.a.d.getListView() != null && this.a.d.getListView().getChildCount() > 0 && this.a.d.getListView().getChildAt(0) == this.a.R()) {
                                this.a.d.getListView().setSelectionFromTop(0, this.a.Q + ((int) (motionEvent.getY() - this.a.x)));
                            }
                        }
                    }
                    this.a.x = 0.0f;
                    this.a.Q = 0;
                } else {
                    this.a.x = motionEvent.getY();
                    if (this.a.d.getListView() != null && this.a.d.getListView().getChildCount() > 0 && this.a.d.getListView().getChildAt(0) == this.a.R()) {
                        tp8 tp8Var = this.a;
                        tp8Var.Q = tp8Var.R().getTop();
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        public s(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.L = true;
            this.a.A.setVisibility(8);
            this.a.v0();
            TiebaStatic.log("c12618");
        }
    }

    /* loaded from: classes6.dex */
    public class t implements mx8.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;
        public final /* synthetic */ tp8 b;

        public t(tp8 tp8Var, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tp8Var;
            this.a = animation;
        }

        @Override // com.baidu.tieba.mx8.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.b.a0() && this.b.b != null) {
                this.a.setAnimationListener(null);
                this.b.b.q().clearAnimation();
                this.b.t0();
                if (z) {
                    this.a.setAnimationListener(this.b.R);
                    this.b.b.q().startAnimation(this.a);
                }
            }
        }

        @Override // com.baidu.tieba.mx8.u
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.a0()) {
                this.b.S();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tp8 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public u(tp8 tp8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tp8Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.S();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948189005, "Lcom/baidu/tieba/tp8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948189005, "Lcom/baidu/tieba/tp8;");
                return;
            }
        }
        T = new h();
        U = new i();
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public View R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.w;
        }
        return (View) invokeV.objValue;
    }

    public void S() {
        ro8 ro8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ro8Var = this.b) != null) {
            ro8Var.s();
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.v >= 1.0d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (P().getY() >= 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g0() {
        mx8 mx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (mx8Var = this.h) != null && this.n) {
            mx8Var.e1();
        }
    }

    public void m0() {
        mx8 mx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (mx8Var = this.h) != null) {
            mx8Var.c1();
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.t = true;
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.b != null) {
            this.b.F(this.d.x0());
        }
    }

    public tp8(PbFragment pbFragment, ro8 ro8Var, VideoInfo videoInfo, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, ro8Var, videoInfo, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = null;
        this.g = null;
        this.n = false;
        this.o = false;
        this.p = 0;
        this.q = 0;
        this.r = 0.0f;
        this.s = false;
        this.t = false;
        this.C = -1L;
        this.D = new k(this);
        this.F = true;
        this.I = new n(this);
        this.M = false;
        this.O = new o(this);
        this.P = new p(this, 2000994);
        this.R = new u(this);
        this.S = new m(this, 2921414);
        this.d = pbFragment;
        this.b = ro8Var;
        this.r = hi.g(pbFragment.getActivity(), R.dimen.obfuscated_res_0x7f070284);
        V(videoInfo);
        T();
        MessageManager.getInstance().registerListener(this.P);
        this.S.setTag(pbFragment.getUniqueId());
        this.S.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.S);
        this.z = new md0(pbFragment.getActivity());
    }

    public final void N(boolean z) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (pbFragment = this.d) != null) {
            pbFragment.q5();
        }
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            ro8 ro8Var = this.b;
            if (ro8Var != null) {
                ro8Var.x(i2);
            }
            PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.H;
            if (pbFullScreenFloatingHuajiAninationView != null) {
                pbFullScreenFloatingHuajiAninationView.e(i2);
            }
            rp8 rp8Var = this.j;
            if (rp8Var != null) {
                rp8Var.j(i2);
            }
        }
    }

    public boolean e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            mx8 mx8Var = this.h;
            if (mx8Var == null) {
                return false;
            }
            return mx8Var.b1(i2);
        }
        return invokeI.booleanValue;
    }

    public final void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            n0(i2);
            Y();
        }
    }

    public void o0(mx8.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, uVar) == null) {
            this.E = uVar;
        }
    }

    public void p0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, threadData) == null) {
            this.m = threadData;
        }
    }

    public void r0(View.OnClickListener onClickListener) {
        rp8 rp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) && (rp8Var = this.j) != null) {
            rp8Var.o(onClickListener);
        }
    }

    public void w0(String str) {
        ey8 ey8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, str) == null) && (ey8Var = this.i) != null) {
            ey8Var.d = str;
        }
    }

    public void i0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048598, this, absListView, i2) != null) || W()) {
            return;
        }
        this.p = i2;
        if (i2 == 0) {
            new Handler().postDelayed(new j(this), 100L);
        }
        Y();
    }

    public final void M(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i2) != null) || P().getHeight() + i2 <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        if ((layoutParams.width != -1 || layoutParams.height != -1) && i2 != 0) {
            if (i2 > 0) {
                this.N = false;
                if (this.u != P().getHeight()) {
                    this.c.setLayoutParams(new RelativeLayout.LayoutParams(hi.l(this.d.getActivity()), Math.min(this.u, P().getHeight() + i2)));
                    this.h.q0();
                }
            } else if (hi.l(this.d.getActivity()) * 0.5625d != P().getHeight()) {
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(hi.l(this.d.getActivity()), (int) Math.max(hi.l(this.d.getActivity()) * 0.5625d, P().getHeight() + i2)));
                this.h.q0();
            }
        }
    }

    public final int b0(VideoInfo videoInfo) {
        InterceptResult invokeL;
        int height;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, videoInfo)) == null) {
            if (TbadkCoreApplication.getInst().getResources() != null && TbadkCoreApplication.getInst().getResources().getConfiguration() != null && TbadkCoreApplication.getInst().getResources().getConfiguration().orientation == 2) {
                this.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                return hi.l(this.d.getActivity());
            }
            int l2 = hi.l(this.d.getActivity());
            Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.d.getPageContext().getPageActivity());
            if (visibilityRegion.height() <= 0) {
                height = hi.j(this.d.getActivity());
            } else {
                height = visibilityRegion.height();
            }
            int i3 = (int) (l2 * 0.5625d);
            int i4 = 0;
            if (videoInfo != null) {
                i2 = videoInfo.video_width.intValue();
            } else {
                i2 = 0;
            }
            if (videoInfo != null) {
                i4 = videoInfo.video_height.intValue();
            }
            if (i2 > 0) {
                double d2 = (i4 * 1.0d) / i2;
                this.v = d2;
                if (d2 > 0.5625d) {
                    i3 = Math.min((i4 * l2) / i2, height);
                }
            }
            this.u = i3;
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(l2, i3));
            return i3;
        }
        return invokeL.intValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mx8 mx8Var = this.h;
            if (mx8Var != null) {
                mx8Var.v0();
            }
            CustomFrameLayout customFrameLayout = this.c;
            if (customFrameLayout != null) {
                customFrameLayout.clearAnimation();
            }
            rp8 rp8Var = this.j;
            if (rp8Var != null) {
                rp8Var.k();
            }
            MessageManager.getInstance().unRegisterListener(this.P);
            MessageManager.getInstance().unRegisterListener(this.S);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.d.getActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
            if (this.e == null) {
                this.e = new t(this, loadAnimation);
            }
            o0(this.e);
            UtilHelper.getLightStatusBarHeight();
            hi.g(this.d.getActivity(), R.dimen.obfuscated_res_0x7f070282);
            this.G = new Handler();
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (P() == null) {
                return false;
            }
            if (P().getBottom() <= hi.j(P().getContext()) - hi.g(P().getContext(), R.dimen.obfuscated_res_0x7f0702d3)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void U(VideoInfo videoInfo, ThreadData threadData, String str) {
        mx8 mx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoInfo, threadData, str) == null) && videoInfo != null && (mx8Var = this.h) != null && threadData != null) {
            this.g = videoInfo;
            this.l = threadData;
            this.f = videoInfo.video_url;
            mx8Var.T1();
            ey8 ey8Var = new ey8();
            this.i = ey8Var;
            ey8Var.a = "pb";
            ey8Var.c = threadData.getTid();
            ey8 ey8Var2 = this.i;
            ey8Var2.d = str;
            ey8Var2.e = TbadkCoreApplication.getCurrentAccount();
            if (threadData.isBjh()) {
                if (!StringUtils.isNull(this.d.s1)) {
                    this.i.k = this.d.s1;
                }
                ey8 ey8Var3 = this.i;
                ey8Var3.i = this.d.r1 + "";
            } else {
                this.i.i = this.d.R5();
            }
            uy4 O5 = this.d.O5();
            if (O5 != null) {
                O5.d(this.i);
            }
            ey8 ey8Var4 = this.i;
            ey8Var4.m = videoInfo.video_md5;
            ey8 b2 = ey8Var4.b();
            b2.a = "6";
            this.C = -1L;
            if (this.h.H0() != null && this.h.H0().getMediaProgressObserver() != null) {
                this.h.H0().getMediaProgressObserver().j(new a(this, videoInfo, str, threadData));
            }
            this.h.H0().setVideoStatData(b2);
            if (this.h.G0()) {
                this.h.q0();
            }
            this.h.o1(this.E);
            this.m = null;
            this.h.J0().setOnDragingListener(T);
            this.h.n1(new b(this));
            this.h.q1(new c(this));
            this.h.s1(new d(this));
            this.h.w1(new e(this));
            this.h.D1(videoInfo.thumbnail_url);
            this.h.H1(this.f, threadData.getTid());
            this.h.h1(str);
            this.h.G1(threadData.getTitle());
            this.h.r1(U);
            this.h.X0();
            this.h.J1();
        }
    }

    public final void V(VideoInfo videoInfo) {
        boolean z;
        NavigationBar navigationBar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoInfo) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.d.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0956, (ViewGroup) null);
            this.a = relativeLayout;
            this.c = (CustomFrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091a20);
            int b0 = b0(videoInfo);
            int i2 = 0;
            if (this.u <= (hi.l(this.d.getActivity()) * 0.5625d) + 5.0d) {
                z = true;
            } else {
                z = false;
            }
            this.y = z;
            int intValue = videoInfo.video_width.intValue();
            mx8 mx8Var = new mx8(this.d.getPageContext(), this.c, true);
            this.h = mx8Var;
            mx8Var.z1("2002");
            this.h.I1(this.O);
            this.h.k1(false);
            this.h.E1(this.D);
            this.h.F1(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            this.h.y1(new q(this));
            if (TbSingleton.getInstance().isNotchScreen(this.d.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.d.getBaseFragmentActivity())) {
                this.h.i1(false);
            }
            this.h.t1(new r(this));
            if (intValue > 0) {
                if (this.v >= 1.0d) {
                    this.h.x1(false, true);
                } else {
                    this.h.x1(true, false);
                }
                if (b0 + this.r > hi.j(this.d.getActivity())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.s = z2;
                if (z2) {
                    if (this.j == null) {
                        this.j = new rp8(this.d.getPageContext(), this.c);
                    }
                    this.d.M5().v1();
                    this.k = true;
                }
            }
            u0();
            this.w = new View(this.d.getContext());
            this.w.setLayoutParams(new AbsListView.LayoutParams(-1, this.u));
            ro8 ro8Var = this.b;
            if (ro8Var != null && (navigationBar = ro8Var.a) != null) {
                navigationBar.getBarBgView().setAlpha(0.0f);
                this.b.a.getTopCoverBgView().setAlpha(1.0f);
                NavigationBar navigationBar2 = this.b.a;
                if (!DeviceInfoUtil.isHWnova() && !TbSingleton.getInstance().isNotchScreen(this.d.getBaseFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.d.getBaseFragmentActivity())) {
                    i2 = 8;
                }
                navigationBar2.setStatusBarVisibility(i2);
            }
            PbVideoWifiTipLayout pbVideoWifiTipLayout = (PbVideoWifiTipLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091419);
            this.A = pbVideoWifiTipLayout;
            pbVideoWifiTipLayout.setOnPlayClickListener(new s(this));
            md0 md0Var = this.z;
            if (md0Var != null) {
                md0Var.d();
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.j == null) {
            return;
        }
        if (W()) {
            this.d.M5().v1();
        } else if (this.j.f().getVisibility() == 0) {
            this.d.M5().v1();
            this.k = true;
        } else if (this.k) {
            this.d.M5().N3(false);
            this.k = false;
        }
    }

    public void f0() {
        mx8 mx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (mx8Var = this.h) == null) {
            return;
        }
        if (mx8Var.R0()) {
            this.n = true;
            this.h.T1();
        } else if (this.h.C0() == 3) {
            this.n = false;
        } else if (this.h.C0() != 0 && this.h.C0() != 1) {
            this.n = false;
            this.h.T1();
        } else {
            this.n = true;
            this.h.T1();
        }
        PbFullScreenFloatingHuajiAninationView pbFullScreenFloatingHuajiAninationView = this.H;
        if (pbFullScreenFloatingHuajiAninationView != null) {
            pbFullScreenFloatingHuajiAninationView.g();
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && !m35.m().i("show_video_pb_double_tap_tips", false)) {
            m35.m().w("show_video_pb_double_tap_tips", true);
            ze zeVar = new ze();
            zeVar.d(true);
            zeVar.i(false);
            zeVar.l(16908290);
            zeVar.c(153);
            zeVar.j(false);
            zeVar.a(new f(this));
            zeVar.h(new g(this));
            ye b2 = zeVar.b();
            this.J = b2;
            b2.p(this.d.getActivity());
        }
    }

    public void d0(Configuration configuration) {
        CustomFrameLayout customFrameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, configuration) == null) {
            this.o = false;
            if (this.h != null && (customFrameLayout = this.c) != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customFrameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                if (configuration.orientation == 2) {
                    md0 md0Var = this.z;
                    if (md0Var != null && md0Var.c()) {
                        this.z.b();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001450));
                    ye yeVar = this.J;
                    if (yeVar != null) {
                        yeVar.d();
                    }
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.o = true;
                    this.c.setLayoutParams(layoutParams);
                    this.d.M5().v1();
                    this.k = true;
                } else {
                    b0(this.g);
                    t0();
                    this.o = false;
                    this.b.D(true);
                }
                this.h.S0(this.d.getPageContext(), configuration);
            }
        }
    }

    public void h0(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, absListView, i2) == null) {
            if (absListView != null && absListView.getChildAt(0) != null) {
                View childAt = absListView.getChildAt(0);
                if (childAt == R()) {
                    int bottom = childAt.getBottom() - P().getBottom();
                    M((childAt.getHeight() == 0 || P().getHeight() == 0) ? 0 : 0);
                } else {
                    M((-this.u) + 2);
                }
            }
            if (W() || !this.F) {
                return;
            }
            int i3 = this.p;
            if (i3 == 1) {
                this.M = true;
                j0(P().getHeight());
            } else if (i3 == 2) {
                this.M = true;
                int y = (int) P().getY();
                if (this.q == y) {
                    j0(P().getHeight());
                } else {
                    this.q = y;
                    j0(P().getHeight());
                }
                if (i2 == 0 && this.t) {
                    this.t = false;
                    this.G.postDelayed(new l(this), 100L);
                }
            } else if (i3 == 0) {
                if (this.M || !"nani_midpage".equals(this.d.R5())) {
                    j0(P().getHeight());
                }
            }
        }
    }

    public void k0(bc9 bc9Var, ThreadData threadData, yi8 yi8Var) {
        rp8 rp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048600, this, bc9Var, threadData, yi8Var) == null) && (rp8Var = this.j) != null) {
            rp8Var.m(bc9Var, threadData, yi8Var);
        }
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && this.g != null) {
            if ("1".equals(str) || "2".equals(str)) {
                tx8.e(this.g.video_md5, "", str, this.i, this.h.H0().getPcdnState());
            }
        }
    }

    public final void n0(int i2) {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048603, this, i2) != null) || this.j == null) {
            return;
        }
        ThreadData threadData = this.l;
        if (threadData != null && threadData.isUgcThreadType()) {
            this.j.f().setVisibility(8);
            return;
        }
        if (i2 == 0) {
            i2 = this.u;
        }
        float f3 = this.u - i2;
        float f4 = this.r;
        if (f3 > f4) {
            f2 = 0.0f;
        } else {
            f2 = 1.0f - (f3 / f4);
        }
        if (this.N) {
            f2 = 0.0f;
        }
        if (f2 == 0.0f) {
            this.j.f().setVisibility(8);
        } else {
            this.j.f().setVisibility(0);
        }
        this.j.n(f2);
    }

    public void v0() {
        String tid;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.h != null) {
            if (BdNetTypeUtil.isMobileNet() && !this.L && !vk9.c().d()) {
                this.A.setVisibility(0);
                this.A.setData(this.g);
                TiebaStatic.log("c12622");
                return;
            }
            if (StringUtils.isNull(this.f) && (threadData = this.l) != null && threadData.getThreadVideoInfo() != null) {
                CommonStatisticUtils.staticUrlNullReport("pb", this.l.getTid());
                this.f = this.l.getThreadVideoInfo().video_url;
            }
            mx8 mx8Var = this.h;
            String str = this.f;
            ThreadData threadData2 = this.l;
            if (threadData2 == null) {
                tid = "";
            } else {
                tid = threadData2.getTid();
            }
            mx8Var.M1(str, tid);
            l0("2");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }
}
