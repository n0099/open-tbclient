package com.baidu.tieba.image;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.BdToken.MutiProcessMissionHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.floatCardView.AlaLiveTipView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageStayDuration.PageStayDurationFilter;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.pageStayDuration.PageStayDurationStat;
import com.baidu.tbadk.switchs.ImagePrePageLimitSwitch;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad;
import com.baidu.tieba.ak8;
import com.baidu.tieba.bk8;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.dk8;
import com.baidu.tieba.ek8;
import com.baidu.tieba.ez8;
import com.baidu.tieba.fk8;
import com.baidu.tieba.gc5;
import com.baidu.tieba.gr5;
import com.baidu.tieba.ik8;
import com.baidu.tieba.jr5;
import com.baidu.tieba.jy0;
import com.baidu.tieba.kk8;
import com.baidu.tieba.kr5;
import com.baidu.tieba.lj5;
import com.baidu.tieba.m35;
import com.baidu.tieba.mc7;
import com.baidu.tieba.mj5;
import com.baidu.tieba.mk8;
import com.baidu.tieba.n35;
import com.baidu.tieba.nk8;
import com.baidu.tieba.no6;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.pk5;
import com.baidu.tieba.pna;
import com.baidu.tieba.rc5;
import com.baidu.tieba.rs5;
import com.baidu.tieba.sea;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.td0;
import com.baidu.tieba.tn4;
import com.baidu.tieba.ud0;
import com.baidu.tieba.uq5;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vj8;
import com.baidu.tieba.vs7;
import com.baidu.tieba.wj8;
import com.baidu.tieba.xs7;
import com.baidu.tieba.yy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes6.dex */
public class ImageViewerActivity extends BaseFragmentActivity implements VoiceManager.j, td0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public no6 A;
    public View A0;
    public String B;
    public mk8 B0;
    public String C;
    public boolean C0;
    public String D;
    public boolean D0;
    public String E;
    public boolean E0;
    public String F;
    public boolean F0;
    public String G;
    public final mj5 G0;
    public String H;
    public final ud0 H0;
    public String I;
    public final Function0<Unit> I0;
    public String J;
    public CustomMessageListener J0;
    public kk8 K;
    public final CustomMessageListener K0;
    public final boolean L;
    public DragImageView.h L0;
    public boolean M;
    public View.OnClickListener M0;
    public boolean N;
    public UrlDragImageView.p N0;
    public int O;
    public final SortSwitchButton.f O0;
    public int P;
    public View.OnClickListener P0;
    public String Q;
    public float Q0;
    public boolean R;
    public View.OnTouchListener R0;
    public boolean S;
    public View.OnLongClickListener S0;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1123T;
    public BaseViewPager.a T0;
    public boolean U;
    public ViewPager.OnPageChangeListener U0;
    public boolean V;
    public View.OnClickListener V0;
    public boolean W;
    public CustomMessageListener W0;
    public boolean X;
    public CustomMessageListener X0;
    public boolean Y;
    public boolean Z;
    public int a;
    public boolean a0;
    public NavigationBar b;
    public boolean b0;
    public TextView c;
    public boolean c0;
    public TextView d;
    public boolean d0;
    public SortSwitchButton e;
    public boolean e0;
    public AlaLiveTipView f;
    public boolean f0;
    public no6 g;
    public boolean g0;
    public boolean h;
    public LiveRemindData h0;
    public String i;
    public int i0;
    public MultiImageView j;
    public int j0;
    public View k;
    public ImageView l;
    public LinearLayout m;
    public ik8 n;
    public VoiceManager o;
    public View p;
    public int q;
    public String r;
    public String r0;
    public int s;
    public String s0;
    public int t;
    public int t0;
    public View u;
    public int u0;
    public ArrayList<String> v;
    public String v0;
    public Map<String, ImageUrlData> w;
    public String w0;
    public wj8 x;
    public String x0;
    public dk8 y;
    public String y0;
    public fk8 z;
    public nk8 z0;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView v1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageViewerActivity b;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.b.Z2();
            }
        }

        public m(ImageViewerActivity imageViewerActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = imageViewerActivity;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.g == null) {
                    ImageViewerActivity imageViewerActivity = this.b;
                    imageViewerActivity.g = new no6(imageViewerActivity.getPageContext(), this.b.f);
                    this.b.g.L(R.drawable.bg_tip_blue_up);
                    this.b.g.o(32);
                    this.b.g.N(true);
                    this.b.g.B(1);
                    this.b.g.Q(0);
                    this.b.g.n(3000);
                    this.b.g.m(new a(this));
                    if (this.b.f != null && this.b.f.getVisibility() != 0) {
                        this.b.i = this.a;
                        return;
                    }
                    this.b.g.S(this.a);
                } else if (this.b.i == null || this.b.g == null || this.b.f == null || this.b.f.getVisibility() != 0) {
                    this.b.Z2();
                } else {
                    this.b.g.S(this.a);
                    this.b.i = null;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements mj5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public a(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tieba.mj5.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.a.B3();
                } else {
                    this.a.C3();
                }
            }
        }

        @Override // com.baidu.tieba.mj5.a
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    this.a.C3();
                } else if (z2) {
                    this.a.B3();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements rs5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public b(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tieba.rs5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) {
                return;
            }
            this.a.G3();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public c(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = (String) ListUtils.getItem(this.a.v, this.a.s);
                if (!this.a.L || !this.a.W2() || !xs7.d(str) || !this.a.g0) {
                    this.a.c3();
                    return;
                }
                int currentItem = this.a.j.getCurrentItem();
                if (currentItem >= this.a.v.size() - 1) {
                    this.a.c3();
                } else {
                    this.a.v.remove(str);
                    this.a.j.setUrlData(this.a.v);
                    this.a.j.setCurrentItem(currentItem, true);
                }
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", "a008").eventStat();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public d(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e4f);
                    return false;
                }
                this.a.R = true;
                if (this.a.e != null) {
                    this.a.e.setEnabled(false);
                }
                String a = vj8.a((String) ListUtils.getItem(this.a.v, this.a.s));
                this.a.E0 = false;
                this.a.F0 = false;
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.p3(a, !imageViewerActivity.W, true);
                if (this.a.W) {
                    i2 = 7;
                } else {
                    i2 = 8;
                }
                ek8.f(i2, this.a.C, this.a.B);
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public e(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.a3();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public f(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.j.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.j.getCurrentMaxIndex()));
                TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
                this.a.c3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public g(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                                return false;
                            }
                        } else {
                            this.a.Q0 = motionEvent.getX();
                            return false;
                        }
                    }
                    this.a.Q0 = motionEvent.getX();
                    return false;
                }
                this.a.Q0 = motionEvent.getX();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public h(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext())) {
                    return true;
                }
                if (UbsABTestHelper.isImageViewerTestA()) {
                    if (this.a.z != null) {
                        this.a.z.A();
                    }
                } else if (this.a.z != null) {
                    this.a.z.F();
                    this.a.z.G();
                    this.a.z.y(view2);
                }
                TiebaStatic.log(new StatisticItem("c13269").param("uid", this.a.G).param("fid", this.a.B).param("tid", this.a.C));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements BaseViewPager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public i(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.x.c0();
                } else if (this.a.e3() == 1) {
                } else {
                    this.a.x.d0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public j(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.v != null && this.a.s < this.a.v.size()) {
                    this.a.y.g(i, (String) this.a.v.get(this.a.s));
                }
                boolean z3 = true;
                if (i == 1 && this.a.K != null) {
                    if ((this.a.s == 0 || this.a.K.w(this.a.s)) && !vs7.m().v(vs7.r()) && this.a.K.A(this.a.s)) {
                        this.a.j.setUrlData(this.a.v);
                        if (this.a.D0) {
                            if (this.a.z0 != null && this.a.z0.j()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ImageViewerActivity imageViewerActivity = this.a;
                            if (imageViewerActivity.K != null && this.a.K.u()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            imageViewerActivity.D0 = z2;
                            ImageViewerActivity imageViewerActivity2 = this.a;
                            imageViewerActivity2.v3((z || imageViewerActivity2.D0) ? false : false);
                        }
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            DragImageView dragImageView;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                if (i <= this.a.O) {
                    if (i >= this.a.O) {
                        return;
                    }
                    this.a.O = i;
                    if (this.a.j != null) {
                        dragImageView = this.a.j.getCurrentView();
                    } else {
                        dragImageView = null;
                    }
                    if (dragImageView != null) {
                        z = dragImageView.e0();
                    } else {
                        z = false;
                    }
                    if (this.a.e3() == 1 && z) {
                        this.a.setSwipeBackEnabled(true);
                    } else {
                        this.a.setSwipeBackEnabled(false);
                    }
                    this.a.Z2();
                    return;
                }
                this.a.O = i;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.x != null && i > this.a.j.getItemNum() - 5) {
                    this.a.x.c0();
                }
                this.a.y.c(this.a.v, this.a.s, i);
                this.a.s = i;
                if (this.a.x != null) {
                    this.a.x.i0(this.a.f3());
                }
                this.a.L3();
                this.a.P3();
                this.a.K3(i);
                if (this.a.y.a() < this.a.s) {
                    this.a.y.j(this.a.s);
                }
                if (this.a.y.b() > this.a.s) {
                    this.a.y.k(this.a.s);
                }
                if (this.a.K != null) {
                    boolean z = true;
                    this.a.K.D((this.a.x == null || this.a.x.f0() != 1) ? false : false);
                    this.a.K.z(i);
                    if (this.a.W2() && this.a.L && this.a.K.x(i)) {
                        this.a.K.B(null);
                    }
                }
                if (this.a.z0 != null) {
                    this.a.z0.m(i);
                }
                if (this.a.z != null) {
                    this.a.z.D();
                }
                if (this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                    this.a.n.q(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.x);
                }
                if (!this.a.C0) {
                    this.a.k3();
                }
                if (this.a.X2()) {
                    StatisticItem statisticItem = new StatisticItem("c15006");
                    ek8.b(statisticItem, this.a.B, this.a.E, TbadkCoreApplication.getCurrentAccount(), this.a.C);
                    TiebaStatic.log(statisticItem);
                    this.a.N3();
                    return;
                }
                if (this.a.c != null) {
                    this.a.c.setVisibility(8);
                }
                this.a.d.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public k(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.x3();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public l(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlaInfoData alaInfo;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2 instanceof HeadImageView) || (alaInfo = ((HeadImageView) view2).getAlaInfo()) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext())) {
                return;
            }
            if (alaInfo.isLegalYYLiveData()) {
                YyExtData yyExtData = alaInfo.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                String encodeToString = Base64.encodeToString(YYLiveUtil.makeJumpToYYLiveRoomUrl(str, str2, str3, "" + alaInfo.roomId, alaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_PB_BIG_IMAGE_HEAD).getBytes(), 2);
                this.a.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(BdUniDispatchSchemeController.SCHEME + "://" + BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_TIEBA_YY_ROOM + "?" + BdUniDispatchSchemeController.PARAM_YY_URL + "=" + encodeToString)));
            } else if (alaInfo.isChushou) {
                this.a.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(BdUniDispatchSchemeController.SCHEME + "://" + BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_CHUSHOU_ALA_ROOM + "?" + BdUniDispatchSchemeController.PARAM_CHUSHOU_THIRD_LIVE_TYPE + "=" + alaInfo.thirdLiveType + "&" + BdUniDispatchSchemeController.PARAM_CHUSHOU_ROOM_ID + "=" + alaInfo.thirdRoomId)));
            }
            ek8.d(this.a.B, this.a.E, this.a.C, alaInfo);
        }
    }

    /* loaded from: classes6.dex */
    public class n extends PageStayDurationFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public n(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return PageStayDurationStat.getInstance().getMaxCostFromServer();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ImageViewerActivity imageViewerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, Integer.valueOf(i)};
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
            this.a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && this.a.w != null && (agreeData = ((AgreeMessageData) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : this.a.w.values()) {
                    if (imageUrlData != null) {
                        String valueOf = String.valueOf(imageUrlData.threadId);
                        String valueOf2 = String.valueOf(imageUrlData.postId);
                        if (agreeData.threadId.equals(valueOf) && agreeData.postId.equals(valueOf2) && (agreeData2 = imageUrlData.agreeData) != null) {
                            agreeData2.agreeType = agreeData.agreeType;
                            agreeData2.hasAgree = agreeData.hasAgree;
                            agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
                            agreeData2.agreeNum = agreeData.agreeNum;
                            agreeData2.disAgreeNum = agreeData.disAgreeNum;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ImageViewerActivity imageViewerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, Integer.valueOf(i)};
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
            this.a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            AgreeData agreeData2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && this.a.w != null && (agreeData = ((AgreeMessageData) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : this.a.w.values()) {
                    if (imageUrlData != null) {
                        String valueOf = String.valueOf(imageUrlData.threadId);
                        String valueOf2 = String.valueOf(imageUrlData.postId);
                        if (agreeData.threadId.equals(valueOf) && agreeData.postId.equals(valueOf2) && (agreeData2 = imageUrlData.agreeData) != null) {
                            agreeData2.agreeType = agreeData.agreeType;
                            agreeData2.hasAgree = agreeData.hasAgree;
                            agreeData2.diffAgreeNum = agreeData.diffAgreeNum;
                            agreeData2.agreeNum = agreeData.agreeNum;
                            agreeData2.disAgreeNum = agreeData.disAgreeNum;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ImageViewerActivity imageViewerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, Integer.valueOf(i)};
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
            this.a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                NavigationBar navigationBar = this.a.b;
                int i2 = 0;
                if (booleanValue) {
                    i = 0;
                } else {
                    i = 8;
                }
                navigationBar.setVisibility(i);
                this.a.Z2();
                if (booleanValue) {
                    this.a.I3();
                } else {
                    if (this.a.G0 != null) {
                        this.a.G0.i();
                    }
                    this.a.H3();
                }
                if (this.a.j != null) {
                    MultiImageView multiImageView = this.a.j;
                    if (!booleanValue) {
                        i2 = 8;
                    }
                    multiImageView.setLiveRoomEntranceButtonVisibility(i2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(ImageViewerActivity imageViewerActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity, Integer.valueOf(i)};
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
            this.a = imageViewerActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            gc5 gc5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gc5) && (gc5Var = (gc5) customResponsedMessage.getData()) != null && !StringUtils.isNull(gc5Var.a)) {
                kr5.h(gc5Var);
                if (StringUtils.isNull(gc5Var.c)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{gc5Var.a});
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{gc5Var.a, gc5Var.c});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public s(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean Y2 = this.a.Y2();
                if (!Y2) {
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.D3(imageViewerActivity.d, 8);
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.D3(imageViewerActivity2.e, 8);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.D3(imageViewerActivity3.p, 8);
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.D3(imageViewerActivity4.f, 8);
                    this.a.H3();
                }
                if (this.a.j != null && !Y2) {
                    this.a.j.J(false);
                }
                this.a.a3();
                this.a.Z2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.j.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.j.getCurrentMaxIndex()));
                this.a.c3();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.D3(imageViewerActivity.d, 0);
                this.a.p.setVisibility(0);
                if (this.a.j == null || this.a.W2()) {
                    return;
                }
                boolean z = this.a.j.z();
                if (!"portrait".equals(this.a.F) && !z) {
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.D3(imageViewerActivity2.e, 0);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.D3(imageViewerActivity3.f, 0);
                    this.a.I3();
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.E3(imageViewerActivity4.i);
                    if (this.a.c0) {
                        this.a.j.J(true);
                    } else {
                        this.a.j.J(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public t(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ek8.f(3, this.a.C, this.a.B);
                if (pk5.a(this.a) && this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                    this.a.n.u(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.x);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements UrlDragImageView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public u(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.a.C).param("obj_type", this.a.F));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public v(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (i & 4) == 0) {
                return;
            }
            this.a.b3();
        }
    }

    /* loaded from: classes6.dex */
    public class w implements wj8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public w(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tieba.wj8.b
        public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) != null) || this.a.j == null) {
                return;
            }
            if (this.a.R) {
                if (!z3) {
                    this.a.j.removeAllViews();
                    this.a.s = 0;
                    if (this.a.x != null) {
                        this.a.x.i0(1);
                    }
                    this.a.u3();
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.W = !imageViewerActivity.W;
                } else if (!this.a.W) {
                    this.a.showToast(R.string.image_view_change_img_error);
                }
            }
            this.a.R = false;
            if (this.a.e != null) {
                this.a.e.setEnabled(true);
            }
            this.a.hideProgressBar();
            if (z2 && this.a.j.getCurrentItem() <= this.a.a * 2) {
                int itemNum = this.a.j.getItemNum();
                this.a.j.setTempSize(itemNum + 100);
                this.a.j.setCurrentItem(itemNum + 90, false);
                this.a.j.setTempSize(0);
            }
            this.a.j.setAssistUrls(this.a.w);
            this.a.j.setHasNext(z);
            this.a.j.setNextTitle(str);
            if (i >= 0 && i < this.a.j.getItemNum()) {
                if (this.a.q == 0) {
                    this.a.j.setCurrentItem(i, false);
                }
            } else {
                this.a.j.C(this.a.j.getCurrentItem());
            }
            if (i2 != 0) {
                this.a.t = i2;
            }
            if (arrayList != null && arrayList.size() >= 400 && this.a.j.getCurrentItem() > 200) {
                for (int i3 = 0; i3 < 200; i3++) {
                    arrayList.remove(0);
                }
                this.a.j.setUrlData(arrayList);
                this.a.j.setCurrentItem(this.a.j.getCurrentItem() - 200, false);
            }
            if (this.a.e3() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (this.a.L && this.a.K != null) {
                kk8 kk8Var = this.a.K;
                if (this.a.x.f0() == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                kk8Var.D(z7);
                if (this.a.C0 || this.a.K.v(this.a.f3())) {
                    this.a.K.C(this.a.e3(), this.a.t);
                    this.a.K.s(this.a.W);
                    this.a.F0 = true;
                    ak8.a(this.a.j, this.a.v, this.a.E0, this.a.F0, this.a.I0);
                }
            } else if (this.a.z0 != null) {
                long e3 = this.a.e3();
                if (this.a.q > 0) {
                    e3 = this.a.g3();
                }
                this.a.z0.o(e3, this.a.t);
                this.a.z0.l();
                c(arrayList, advertAppInfo);
            }
            if (this.a.z0 != null && this.a.z0.j()) {
                z4 = true;
            } else {
                z4 = false;
            }
            ImageViewerActivity imageViewerActivity2 = this.a;
            if (imageViewerActivity2.K != null && this.a.K.u()) {
                z5 = true;
            } else {
                z5 = false;
            }
            imageViewerActivity2.D0 = z5;
            ImageViewerActivity imageViewerActivity3 = this.a;
            if (!z4 && !imageViewerActivity3.D0) {
                z6 = true;
            } else {
                z6 = false;
            }
            imageViewerActivity3.v3(z6);
            this.a.E0 = true;
            if (!this.a.g0) {
                this.a.F0 = true;
            }
            ak8.a(this.a.j, this.a.v, this.a.E0, this.a.F0, this.a.I0);
            this.a.L3();
            if (this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                this.a.n.q(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.x);
            }
            if (!this.a.C0) {
                return;
            }
            this.a.C0 = false;
            this.a.k3();
        }

        @Override // com.baidu.tieba.wj8.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) {
                return;
            }
            this.a.R = false;
            if (this.a.e != null) {
                if (this.a.e.getState() != this.a.W && TextUtils.isEmpty(str)) {
                    this.a.showToast(R.string.image_view_change_img_error);
                }
                this.a.e.w(this.a.W ? 1 : 0);
                this.a.e.setEnabled(true);
            }
            this.a.hideProgressBar();
            this.a.showToast(str);
            if (i == 40) {
                if (this.a.v != null) {
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.t = imageViewerActivity.v.size();
                }
                this.a.L3();
            }
            if (!this.a.C0) {
                return;
            }
            this.a.C0 = false;
            this.a.k3();
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.z0 != null && advertAppInfo != null && arrayList != null) {
                    int h = advertAppInfo.h();
                    if (h == 0) {
                        this.a.z0.g(advertAppInfo);
                        return;
                    } else {
                        this.a.z3(advertAppInfo, h);
                        return;
                    }
                }
                this.a.A3(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements yy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public x(ImageViewerActivity imageViewerActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageViewerActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageViewerActivity;
        }

        @Override // com.baidu.tieba.yy9
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t) != null) {
                return;
            }
            this.a.F0 = true;
            ak8.a(this.a.j, this.a.v, this.a.E0, this.a.F0, this.a.I0);
        }
    }

    public ImageViewerActivity() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.q = 0;
        this.r = "";
        this.s = -1;
        this.t = -1;
        if (!UbsABTestHelper.isPicPageFunAdSdkTest() && !UbsABTestHelper.isPicPageFunAdInsert()) {
            z = false;
        } else {
            z = true;
        }
        this.L = z;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.S = false;
        this.f1123T = true;
        this.U = true;
        this.V = true;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.a0 = true;
        this.b0 = false;
        this.c0 = true;
        this.d0 = false;
        this.e0 = false;
        this.f0 = false;
        this.g0 = true;
        this.C0 = true;
        this.D0 = false;
        this.E0 = false;
        this.F0 = false;
        this.G0 = lj5.a();
        this.H0 = new ud0();
        this.I0 = new k(this);
        this.J0 = new q(this, 2016496);
        this.K0 = new r(this, 2016493);
        this.L0 = new s(this);
        this.M0 = new t(this);
        this.N0 = new u(this);
        this.O0 = new d(this);
        this.P0 = new f(this);
        this.R0 = new g(this);
        this.S0 = new h(this);
        this.T0 = new i(this);
        this.U0 = new j(this);
        this.V0 = new l(this);
        this.W0 = new o(this, 2016528);
        this.X0 = new p(this, 2016530);
    }

    public final void L3() {
        String str;
        int i2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.v != null) {
            long e3 = e3();
            String str2 = ("" + e3) + "/";
            if (this.t > 0) {
                str = str2 + this.t;
            } else {
                str = str2 + "...";
            }
            if (this.F != null && !this.S && e3() == this.t && (this.F.equals("frs") || this.F.equals("index"))) {
                TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.F));
                this.S = true;
            }
            if (W2()) {
                long j2 = -1;
                String str3 = (String) ListUtils.getItem(this.v, this.s - 1);
                if (!StringUtils.isNull(str3) && (imageUrlData = this.w.get(str3)) != null) {
                    j2 = imageUrlData.overAllIndex;
                }
                M3(j2, this.t);
            } else if (X2()) {
                N3();
            } else {
                O3(str);
            }
            long j3 = e3 - 1;
            if (j3 > 0) {
                i2 = (int) j3;
            } else {
                i2 = 0;
            }
            J3(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.K0);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            TbImageMemoryCache.B().J();
            dk8 dk8Var = this.y;
            ArrayList<String> arrayList = this.v;
            int i2 = this.s;
            dk8Var.c(arrayList, i2, i2);
            this.y.i();
            wj8 wj8Var = this.x;
            if (wj8Var != null) {
                String Z = wj8Var.Z();
                String e0 = this.x.e0();
                this.x.s0();
                this.x.m0(null);
                str = Z;
                str2 = e0;
            } else {
                str = null;
                str2 = null;
            }
            this.y.l(this.j.getPageCount(), "", this.B, this.C, str, str2);
            fk8 fk8Var = this.z;
            if (fk8Var != null) {
                fk8Var.C();
            }
            this.j.D();
            this.n.n();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            rc5.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.P);
            a3();
            Z2();
            nk8 nk8Var = this.z0;
            if (nk8Var != null) {
                nk8Var.k();
            }
            kk8 kk8Var = this.K;
            if (kk8Var != null) {
                kk8Var.y();
            }
            MutiProcessManager.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2001277);
        }
    }

    public void A3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (multiImageView = this.j) != null) {
            multiImageView.setAddSize(i2);
        }
    }

    public final void E3(@NonNull String str) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || (alaLiveTipView = this.f) == null) {
            return;
        }
        if (!this.V) {
            alaLiveTipView.setVisibility(8);
        }
        this.f.post(new m(this, str));
    }

    public final void O3(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.d.setText(str);
            if (this.V && !this.X && (sortSwitchButton = this.e) != null) {
                sortSwitchButton.w(this.W ? 1 : 0);
            }
            EMManager.from(this.d).setTextShadow(R.array.S_O_X001);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, motionEvent)) == null) {
            this.H0.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void i3(AlaInfoData alaInfoData) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048616, this, alaInfoData) == null) && alaInfoData != null && alaInfoData.user_info != null && (alaLiveTipView = this.f) != null) {
            alaLiveTipView.setOnClickListener(this.V0);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                E3(alaInfoData.tag);
            }
        }
    }

    public final void j3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048617, this, z) == null) && this.h != z) {
            AlaLiveTipView alaLiveTipView = this.f;
            if (alaLiveTipView != null) {
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                alaLiveTipView.setVisibility(i2);
            }
            this.h = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            this.j.setBackgroundColor(-16777216);
            this.j.G(i2);
            this.P = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            fk8 fk8Var = this.z;
            if (fk8Var != null) {
                fk8Var.z();
            }
            ik8 ik8Var = this.n;
            if (ik8Var != null) {
                ik8Var.m(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.j.setCurrentItem(this.s, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                b3();
            }
        }
    }

    public final void D3(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, view2, i2) == null) && view2 != null) {
            view2.clearAnimation();
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048628, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.s);
                setResult(-1, intent);
                c3();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048623, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.n.l(i2, i3, intent);
        }
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.u.setBackgroundColor(-16777216);
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMManager.from(this.u).setGradientColor(new int[]{R.color.CAM_X0608, R.color.CAM_X0601}, Direction.TOP);
        }
    }

    public final void G3() {
        mj5 mj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.j.y() && (mj5Var = this.G0) != null) {
            mj5Var.g();
        }
    }

    public final void H3() {
        mj5 mj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (mj5Var = this.G0) != null) {
            mj5Var.hide();
        }
    }

    public final void I3() {
        mj5 mj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.j.y() && (mj5Var = this.G0) != null) {
            mj5Var.show();
        }
    }

    @Override // com.baidu.tieba.td0
    @NonNull
    public ud0 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.H0;
        }
        return (ud0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.o == null) {
                this.o = VoiceManager.instance();
            }
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void Q3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (intent = getIntent()) != null) {
            uq5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
        }
    }

    public final boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.B0 == null) {
                return false;
            }
            String str = (String) ListUtils.getItem(this.v, this.s);
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.startsWith("####mLiveRoomPageProvider");
        }
        return invokeV.booleanValue;
    }

    public final void Z2() {
        no6 no6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (no6Var = this.g) != null) {
            no6Var.h();
        }
    }

    public final void a3() {
        no6 no6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (no6Var = this.A) != null) {
            no6Var.h();
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            getWindow().addFlags(1024);
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (gr5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    public Map<String, ImageUrlData> d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.w;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    public final int f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return (int) e3();
        }
        return invokeV.intValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (ad.isEmpty(this.C)) {
                return 0L;
            }
            return JavaTypesHelper.toLong(this.C, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return new n(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    public String h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.G;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.j.D();
        }
    }

    public boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.Y;
        }
        return invokeV.booleanValue;
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.X && this.e != null) {
            if (this.A == null) {
                no6 no6Var = new no6(getPageContext(), this.e);
                this.A = no6Var;
                no6Var.L(R.drawable.pic_sign_tip);
                this.A.o(48);
                this.A.N(true);
                this.A.n(5000);
                this.A.Q(-BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.A.m(new e(this));
            }
            this.A.T(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.b = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.b.setClickable(false);
            l3();
            o3();
            TextView textView = new TextView(this);
            this.d = textView;
            textView.setPadding(BdUtilHelper.getDimens(this, R.dimen.tbds15), 0, 0, 0);
            this.d.setGravity(17);
            this.d.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.d.setTextSize(0, BdUtilHelper.getDimens(this, R.dimen.tbds44));
            EMManager.from(this.d).setTextShadow(R.array.S_O_X001);
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.d, (View.OnClickListener) null);
            if (vj8.b((String) ListUtils.getItem(this.v, this.s))) {
                this.b.setVisibility(0);
            }
        }
    }

    public final void J3(int i2) {
        wj8 wj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i2) == null) && (wj8Var = this.x) != null) {
            ArrayList<AlaInfoData> X = wj8Var.X();
            if (X != null && X.size() > 0) {
                j3(true);
                i3(X.get(i2 % X.size()));
                return;
            }
            j3(false);
        }
    }

    public final void K3(int i2) {
        MultiImageView multiImageView;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048586, this, i2) != null) || (multiImageView = this.j) == null) {
            return;
        }
        multiImageView.p(i2);
        this.j.q(i2);
        if (!this.j.z() && !W2() && !X2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        D3(this.e, i3);
        if (this.V) {
            D3(this.f, i3);
        }
        if (i3 == 0) {
            I3();
        } else {
            H3();
        }
    }

    public final void v3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048644, this, z) != null) || this.B0 == null) {
            return;
        }
        if (!ListUtils.isEmpty(this.x.b0()) && z) {
            this.B0.k(this.x.b0());
            this.B0.j(true);
            ArrayList<String> arrayList = this.v;
            if (arrayList != null && !arrayList.contains("####mLiveRoomPageProvider")) {
                ArrayList<String> arrayList2 = this.v;
                ez8.b(arrayList2, "####mLiveRoomPageProvider", arrayList2.size());
                return;
            }
            return;
        }
        this.B0.k(null);
        this.B0.j(false);
    }

    public final void M3(long j2, int i2) {
        kk8 kk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            nk8 nk8Var = this.z0;
            if ((nk8Var != null && nk8Var.j()) || ((kk8Var = this.K) != null && kk8Var.u())) {
                this.d.setText("");
            } else if (j2 > 0) {
                this.d.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.d.setText("");
            }
            D3(this.e, 8);
            D3(this.f, 8);
            H3();
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.setVisibility(8);
            if (this.c == null) {
                TextView centerTextTitle = this.b.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f07a7));
                this.c = centerTextTitle;
                centerTextTitle.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            }
            this.c.setVisibility(0);
            this.b.setVisibility(0);
            D3(this.e, 8);
            D3(this.f, 8);
        }
    }

    public final boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            MultiImageView multiImageView = this.j;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.j.getCurrentUrlDragImageView().getImageView() != null && this.j.getCurrentUrlDragImageView().getImageView().getImageUrlData() != null) {
                return this.j.getCurrentUrlDragImageView().getImageView().getImageUrlData().isLongPic;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && getWindow() != null) {
            if (UtilHelper.isFoldScreen() || (DeviceInfoUtil.isHuaWei() && !DeviceInfoUtil.isHonor30NotchDevice())) {
                getWindow().setFlags(1024, 1024);
            }
            if (getWindow().getDecorView() != null) {
                getWindow().getDecorView().setSystemUiVisibility(1284);
            }
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            View addSystemImageButton = this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.p = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new c(this));
            this.l = (ImageView) this.p.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.p.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
            this.j.F();
            this.mIsLogin = pk5.k();
            BdUniqueId uniqueId = getUniqueId();
            long j2 = JavaTypesHelper.toLong(this.C, 0L);
            if (uniqueId != null && j2 > 0) {
                MutiProcessMissionHelper.startThreadBrowseTimeMission(tn4.d0, uniqueId.getId(), j2);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.n.p();
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && this.V && this.G0 != null) {
            jr5.a(getSupportFragmentManager(), R.id.second_floor_container, this.G0.j("big_pic"));
            this.G0.h(new a(this));
            rs5 g2 = rs5.g(this);
            g2.j(R.id.second_floor_container, R.id.navigation_bar);
            g2.i(new b(this));
            g2.f();
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.u = findViewById(R.id.pic_top_obscuration_view);
            C3();
            q3();
            r3();
            this.z = new fk8(this);
            u3();
            this.z.x(this.j);
            L3();
            F3();
            s3();
            n3();
            dk8 dk8Var = this.y;
            ArrayList<String> arrayList = this.v;
            int i2 = this.s;
            dk8Var.c(arrayList, i2, i2);
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && this.q > 0) {
            int count = ListUtils.getCount(this.v);
            int i2 = 0;
            while (true) {
                if (i2 < count) {
                    ImageUrlData imageUrlData = this.w.get(this.v.get(i2));
                    if (imageUrlData != null && TextUtils.equals(imageUrlData.id, this.r)) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = 0;
                    break;
                }
            }
            int currentItem = this.j.getCurrentItem();
            if (i2 > 0 && i2 != currentItem) {
                this.j.setCurrentItem(i2, false);
            }
            K3(i2);
            this.q = 0;
        }
    }

    public final void P3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            boolean z = false;
            if (W2()) {
                if (this.b.getVisibility() == 0) {
                    z = true;
                }
                this.N = z;
                this.M = true;
            } else if (this.M) {
                NavigationBar navigationBar = this.b;
                if (this.N) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                navigationBar.setVisibility(i2);
                this.M = false;
            }
            y3();
        }
    }

    public int V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int count = ListUtils.getCount(this.v);
            if (count > 0) {
                int i2 = this.s;
                if (i2 >= count) {
                    this.s = count - 1;
                } else if (i2 < 0) {
                    this.s = 0;
                }
            } else {
                this.s = 0;
            }
            wj8 wj8Var = this.x;
            if (wj8Var != null) {
                wj8Var.i0(f3());
            }
            return this.s;
        }
        return invokeV.intValue;
    }

    public final boolean W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (!this.f1123T) {
                return false;
            }
            nk8 nk8Var = this.z0;
            if (nk8Var != null && nk8Var.h(this.s)) {
                return true;
            }
            kk8 kk8Var = this.K;
            if (kk8Var == null || !kk8Var.t(this.s)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final long e3() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            String str = (String) ListUtils.getItem(this.v, this.s);
            Map<String, ImageUrlData> map = this.w;
            if (map != null && str != null) {
                imageUrlData = map.get(str);
            } else {
                imageUrlData = null;
            }
            if (imageUrlData != null) {
                j2 = imageUrlData.overAllIndex;
            } else {
                j2 = 0;
            }
            if (j2 == 0) {
                return this.s + 1;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public final long g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int count = ListUtils.getCount(this.v);
            for (int i2 = 0; i2 < count; i2++) {
                ImageUrlData imageUrlData = this.w.get(this.v.get(i2));
                if (imageUrlData != null && TextUtils.equals(imageUrlData.id, this.r)) {
                    return imageUrlData.overAllIndex;
                }
            }
            return e3();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.setFid(JavaTypesHelper.toLong(this.B, 0L));
                pageStayDurationItem.setTid(JavaTypesHelper.toLong(this.C, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.setAbTag(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public final void k3() {
        ImageUrlData imageUrlData;
        dk8 dk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            String str = (String) ListUtils.getItem(this.v, this.s);
            Map<String, ImageUrlData> map = this.w;
            if (map != null && str != null && (imageUrlData = map.get(str)) != null && (dk8Var = this.y) != null) {
                String str2 = this.C;
                String str3 = this.F;
                int i2 = this.s;
                dk8Var.e(str2, str3, i2, this.t - i2, imageUrlData.mHeigth, imageUrlData.mWidth, this.J);
            }
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.m = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
            ik8 ik8Var = new ik8(getPageContext(), this.m);
            this.n = ik8Var;
            ik8Var.r(this.s0);
            this.n.s(this.t0);
            this.n.m(this.t0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onPause();
            this.j.E();
            BdUniqueId uniqueId = getUniqueId();
            long j2 = JavaTypesHelper.toLong(this.C, 0L);
            if (uniqueId != null && j2 > 0) {
                MutiProcessMissionHelper.pauseBrowseTimeMission(uniqueId.getId(), j2);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            this.n.o();
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.k = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.k.setLayoutParams(layoutParams);
            this.k.setVisibility(0);
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            if (this.L && W2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void m3(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String str3;
        String str4;
        Map<String, ImageUrlData> map;
        ImageUrlData imageUrlData;
        String a2;
        Map<String, ImageUrlData> map2;
        ImageUrlData imageUrlData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            this.y = new dk8();
            boolean k2 = pk5.k();
            String b2 = pk5.b();
            String f2 = pk5.f();
            String e2 = pk5.e();
            Q3();
            if (bundle != null) {
                this.Y = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                ArrayList<String> c2 = bk8.d().c();
                if (!ListUtils.isEmpty(c2)) {
                    this.v = new ArrayList<>(c2);
                }
                this.s = bundle.getInt("index", -1);
                this.B = bundle.getString("fid");
                this.C = bundle.getString("tid");
                this.D = bundle.getString("nid");
                this.E = bundle.getString("fname");
                this.H = bundle.getString("post_id");
                this.I = bundle.getString(IntentConfig.BJH_POST_ID);
                this.b0 = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
                this.a0 = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
                this.f1123T = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
                this.G = bundle.getString("user_id");
                this.F = bundle.getString("from");
                this.U = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
                this.V = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
                this.j0 = bundle.getInt("thread_type");
                this.W = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
                Map<String, String> b3 = bk8.d().b();
                this.r0 = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.Z = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
                boolean z2 = bundle.getBoolean("is_login");
                String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
                String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
                String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
                this.c0 = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.d0 = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                if (b3 instanceof Map) {
                    this.w = new ConcurrentHashMap();
                    for (Map.Entry<String, String> entry : b3.entrySet()) {
                        if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                            try {
                                this.w.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr(entry.getValue(), ImageUrlData.class));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
                this.X = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
                this.u0 = bundle.getInt("card_type", 0);
                this.v0 = bundle.getString("recom_source");
                this.w0 = bundle.getString("ab_tag");
                this.x0 = bundle.getString("weight");
                this.y0 = bundle.getString("extra");
                this.s0 = bundle.getString("from_forum_id");
                this.t0 = bundle.getInt("skin_type");
                this.e0 = bundle.getBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                Serializable serializable = bundle.getSerializable(ImageViewerConfig.REMIND_LIVE_DATA);
                if (serializable instanceof LiveRemindData) {
                    this.h0 = (LiveRemindData) serializable;
                }
                this.i0 = bundle.getInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY);
                this.g0 = bundle.getBoolean(ImageViewerConfig.NEED_REQUEST_AD, true);
                Serializable serializable2 = bundle.getSerializable(ImageViewerConfig.KEY_PROFILE_VIRTUAL_IMAGE_INFO);
                if (serializable2 instanceof ProfileVirtualImageInfo) {
                    ProfileVirtualImageInfo.getInstance().parseRemoteInfo((ProfileVirtualImageInfo) serializable2);
                }
                bk8.d().a();
                z = z2;
                str = string;
                str2 = string2;
                str3 = string3;
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    this.Y = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                    this.v = intent.getStringArrayListExtra("url");
                    this.s = intent.getIntExtra("index", -1);
                    this.B = intent.getStringExtra("fid");
                    this.C = intent.getStringExtra("tid");
                    this.D = intent.getStringExtra("nid");
                    this.E = intent.getStringExtra("fname");
                    this.H = intent.getStringExtra("post_id");
                    this.I = intent.getStringExtra(IntentConfig.BJH_POST_ID);
                    this.b0 = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                    this.a0 = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                    this.f1123T = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                    this.G = intent.getStringExtra("user_id");
                    this.F = intent.getStringExtra("from");
                    this.U = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                    this.V = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                    this.W = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                    this.j0 = intent.getIntExtra("thread_type", 0);
                    this.c0 = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                    this.d0 = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                    this.X = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                    z = intent.getBooleanExtra("is_login", false);
                    String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                    str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                    String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                    this.r0 = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                    this.Z = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                    Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                    if (serializableExtra instanceof Map) {
                        this.w = (Map) serializableExtra;
                    }
                    this.u0 = intent.getIntExtra("card_type", 0);
                    this.v0 = intent.getStringExtra("recom_source");
                    this.w0 = intent.getStringExtra("ab_tag");
                    this.x0 = intent.getStringExtra("weight");
                    this.y0 = intent.getStringExtra("extra");
                    this.s0 = intent.getStringExtra("from_forum_id");
                    this.t0 = intent.getIntExtra("skin_type", 0);
                    this.e0 = intent.getBooleanExtra(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                    this.g0 = intent.getBooleanExtra(ImageViewerConfig.NEED_REQUEST_AD, true);
                    Serializable serializableExtra2 = intent.getSerializableExtra(ImageViewerConfig.REMIND_LIVE_DATA);
                    if (serializableExtra2 instanceof LiveRemindData) {
                        this.h0 = (LiveRemindData) serializableExtra2;
                    }
                    this.i0 = intent.getIntExtra(ImageViewerConfig.REMIND_LIVE_FREQUENCY, 0);
                    Serializable serializableExtra3 = intent.getSerializableExtra(ImageViewerConfig.KEY_PROFILE_VIRTUAL_IMAGE_INFO);
                    if (serializableExtra3 instanceof ProfileVirtualImageInfo) {
                        ProfileVirtualImageInfo.getInstance().parseRemoteInfo((ProfileVirtualImageInfo) serializableExtra3);
                    }
                    str = stringExtra;
                    str2 = stringExtra2;
                } else {
                    z = k2;
                    str = b2;
                    str2 = f2;
                    str3 = e2;
                }
            }
            int i2 = this.s;
            if (i2 > 0) {
                str4 = (String) ListUtils.getItem(this.v, i2);
                this.q = this.s + 1;
            } else if (ListUtils.isNotEmpty(this.v)) {
                str4 = this.v.get(0);
                if (!TextUtils.isEmpty(str4) && (map = this.w) != null && (imageUrlData = map.get(str4)) != null) {
                    this.q = (int) imageUrlData.overAllIndex;
                }
            } else {
                str4 = "";
            }
            this.r = vj8.a(str4);
            pk5.o(z);
            pk5.n(str);
            pk5.p(str3);
            pk5.q(str2);
            this.y.f(bundle, getIntent());
            this.t = ListUtils.getCount(this.v);
            if (this.r0 != null) {
                String str5 = (String) ListUtils.getItem(this.v, this.s);
                if (!StringUtils.isNull(str5) && (map2 = this.w) != null && (imageUrlData2 = map2.get(str5)) != null) {
                    imageUrlData2.setSourceImageRectInScreen(this.r0);
                }
            }
            if (this.Y) {
                a2 = null;
            } else {
                a2 = vj8.a((String) ListUtils.getItem(this.v, this.s));
            }
            this.Q = a2;
            if (this.W) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            this.a = (ImagePrePageLimitSwitch.Companion.pageLimitSize() <= 0 || !UbsABTestHelper.isBigImagePreTest()) ? 2 : 2;
            m35.a().d(this.h0);
            n35.b().n(this.i0);
        }
    }

    public final void o3() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && !this.Y && !this.X && !this.e0) {
            View addCustomView = this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.A0 = addCustomView;
            if (this.f0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            addCustomView.setVisibility(i2);
            if (this.V) {
                ArrayList arrayList = new ArrayList(2);
                sea seaVar = new sea();
                seaVar.c(0);
                seaVar.d(getString(R.string.obfuscated_res_0x7f0f02a0));
                arrayList.add(seaVar);
                sea seaVar2 = new sea();
                seaVar2.c(1);
                seaVar2.d(getString(R.string.host_name));
                arrayList.add(seaVar2);
                SortSwitchButton sortSwitchButton = (SortSwitchButton) this.A0.findViewById(R.id.host_all_switch_btn);
                this.e = sortSwitchButton;
                sortSwitchButton.setNeedDayNight(false);
                this.e.setData(arrayList, this.W ? 1 : 0);
                this.e.setVisibility(0);
                this.e.setOnSwitchChangeListener(this.O0);
                D3(this.f, 0);
                return;
            }
            D3(this.e, 8);
            D3(this.f, 8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 28 && TbSingleton.getInstance().isNotchScreen(this)) {
                setUseStyleImmersiveSticky(false);
            }
            super.onCreate(bundle);
            b3();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new v(this));
            MutiProcessManager.getInstance().init(TbadkCoreApplication.getInst());
            MutiProcessManager.publishEvent(new ImageFpsEvent());
            this.P = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            if (!Fresco.hasBeenInitialized()) {
                Fresco.initialize(TbadkCoreApplication.getInst(), mc7.a());
            }
            m3(bundle);
            setContentView(R.layout.image_activity_big_img);
            t3();
            this.E0 = false;
            this.F0 = false;
            p3(this.Q, this.W, false);
            registerListener(this.K0);
            registerListener(this.J0);
            registerListener(this.W0);
            registerListener(this.X0);
            addGlobalLayoutListener();
            VoiceManager O0 = O0();
            this.o = O0;
            O0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                pna.b(1, getWindow().getAttributes(), getWindow());
            }
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
                TbSingleton.getInstance().setHasDownloadEmotion(true);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(ImageViewerConfig.IS_BJH, this.Y);
            bk8.d().f(this.v);
            bundle.putInt("index", this.s);
            bundle.putString("fid", this.B);
            bundle.putString("tid", this.C);
            bundle.putString("fname", this.E);
            bundle.putString("post_id", this.H);
            bundle.putString(IntentConfig.BJH_POST_ID, this.I);
            bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.a0);
            bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.U);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.V);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.f1123T);
            bundle.putString("user_id", this.G);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.c0);
            bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.d0);
            Map<String, ImageUrlData> map = this.w;
            if (map instanceof HashMap) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, ImageUrlData> entry : this.w.entrySet()) {
                    if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                        try {
                            hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                bk8.d().e(hashMap);
            } else if (map instanceof ConcurrentHashMap) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (Map.Entry<String, ImageUrlData> entry2 : this.w.entrySet()) {
                    if (entry2 != null && (entry2.getValue() instanceof ImageUrlData) && (entry2.getKey() instanceof String)) {
                        try {
                            concurrentHashMap.put(entry2.getKey(), OrmObject.jsonStrWithObject(entry2.getValue()));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                bk8.d().e(concurrentHashMap);
            }
            bundle.putString("from", this.F);
            bundle.putInt("thread_type", this.j0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.W);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.r0);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.X);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.Z);
            bundle.putBoolean("is_login", pk5.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, pk5.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, pk5.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, pk5.f());
            bundle.putString("from_forum_id", this.s0);
            bundle.putInt("skin_type", this.t0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.e0);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.f0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.g0);
            bundle.putSerializable(ImageViewerConfig.REMIND_LIVE_DATA, this.h0);
            bundle.putInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY, this.i0);
            this.y.h(bundle);
        }
    }

    public final void p3(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            wj8 wj8Var = new wj8(this.v, this.w, this.B, this.E, this.C, this.D, str, this.G, this.F, this.j0, z2, this.u0, this.v0, this.w0, this.x0, this.y0, this.q);
            this.x = wj8Var;
            wj8Var.q0(this.r0);
            this.x.o0(this.a0);
            this.x.p0(z);
            this.x.h0(this.Q);
            this.x.l0(this.Z);
            this.x.n0(this.H);
            this.x.g0(this.I);
            this.x.k0(this.d0);
            this.x.m0(new w(this));
            this.x.j0(true);
            if (this.g0) {
                this.z0.n(new x(this));
            }
            this.x.a0();
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            MultiImageView multiImageView = this.j;
            if (multiImageView == null) {
                this.j = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f09298b);
            } else {
                multiImageView.v();
            }
            this.J = this.C + "_" + System.currentTimeMillis();
            this.j.setIsFromCDN(this.b0);
            this.j.setIsCanDrag(this.U);
            this.j.setPageMargin(BdUtilHelper.dip2px(getPageContext().getPageActivity(), 8.0f));
            this.j.setOffscreenPageLimit(this.a, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.j.setOnPageChangeListener(this.U0);
            this.j.setUrlData(this.v);
            this.j.setAssistUrls(this.w);
            this.j.setOuterOnTouchListener(this.R0);
            this.j.setItemOnclickListener(this.P0);
            this.j.setItemOnLongClickListener(this.S0);
            this.j.setCurrentItem(V2(), false);
            this.j.setOnScrollOutListener(this.T0);
            if (this.B0 == null) {
                mk8 mk8Var = new mk8(this.v, getPageContext(), this.B, this.E, this.C);
                this.B0 = mk8Var;
                mk8Var.i(this.b.getFixedNavHeight());
            }
            this.j.o(this.B0);
            if (this.L && this.g0) {
                if (this.K == null) {
                    this.K = new kk8(this.v, this.B, this.C, this.f1123T, this.s, getPageContext());
                }
                this.K.B(null);
                this.j.o(this.K);
            }
            if (this.z0 == null) {
                this.z0 = new nk8(this.v, this.B, this.E, this.b0, this.f1123T, getPageContext(), this.L0, this.w);
            }
            this.j.o(this.z0);
            this.j.setOriImgSelectedCallback(this.N0);
            this.j.setDragToExitListener(this.L0);
            this.j.setUserId(this.G);
            this.j.setShowBottomContainer(this.c0);
            this.j.setOnShareImageListener(this.z);
            this.j.setOnDownloadImageListener(this.z);
            this.j.setOnReplyClickListener(this.M0);
            this.j.setYoungterCoverSomeView(this.f0);
            dk8 dk8Var = this.y;
            if (dk8Var != null) {
                dk8Var.d(this.G, this.C, this.F);
            }
        }
    }

    public final void z3(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048648, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            jy0.e(clogBuilder);
        }
    }
}
