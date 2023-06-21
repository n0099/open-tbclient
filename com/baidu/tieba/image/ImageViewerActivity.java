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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
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
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.switchs.ImagePrePageLimitSwitch;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad8;
import com.baidu.tieba.as5;
import com.baidu.tieba.at7;
import com.baidu.tieba.b8a;
import com.baidu.tieba.b95;
import com.baidu.tieba.bs5;
import com.baidu.tieba.bw5;
import com.baidu.tieba.c95;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.ct7;
import com.baidu.tieba.e0a;
import com.baidu.tieba.eu4;
import com.baidu.tieba.gn9;
import com.baidu.tieba.go5;
import com.baidu.tieba.ho5;
import com.baidu.tieba.jc8;
import com.baidu.tieba.jh5;
import com.baidu.tieba.kc8;
import com.baidu.tieba.lp5;
import com.baidu.tieba.mw5;
import com.baidu.tieba.np5;
import com.baidu.tieba.o31;
import com.baidu.tieba.oc8;
import com.baidu.tieba.p75;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.pj0;
import com.baidu.tieba.pw5;
import com.baidu.tieba.qc8;
import com.baidu.tieba.qj0;
import com.baidu.tieba.qw5;
import com.baidu.tieba.rc8;
import com.baidu.tieba.rz9;
import com.baidu.tieba.sc8;
import com.baidu.tieba.sp8;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tr6;
import com.baidu.tieba.ug;
import com.baidu.tieba.uh5;
import com.baidu.tieba.uu4;
import com.baidu.tieba.vc8;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.wi;
import com.baidu.tieba.xc8;
import com.baidu.tieba.yr5;
import com.baidu.tieba.yx5;
import com.baidu.tieba.zc8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class ImageViewerActivity extends BaseFragmentActivity implements VoiceManager.j, pj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public zc8 A0;
    public String B;
    public boolean B0;
    public String C;
    public boolean C0;
    public String D;
    public final ho5 D0;
    public String E;
    public final qj0 E0;
    public String F;
    public CustomMessageListener F0;
    public String G;
    public final CustomMessageListener G0;
    public String H;
    public DragImageView.h H0;
    public xc8 I;
    public View.OnClickListener I0;
    public final boolean J;
    public UrlDragImageView.p J0;
    public boolean K;
    public final SortSwitchButton.f K0;
    public boolean L;
    public View.OnClickListener L0;
    public int M;
    public float M0;
    public int N;
    public View.OnTouchListener N0;
    public String O;
    public View.OnLongClickListener O0;
    public boolean P;
    public BaseViewPager.a P0;
    public boolean Q;
    public ViewPager.OnPageChangeListener Q0;
    public boolean R;
    public View.OnClickListener R0;
    public boolean S;
    public CustomMessageListener S0;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1121T;
    public CustomMessageListener T0;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
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
    public tr6 g;
    public LiveRemindData g0;
    public boolean h;
    public int h0;
    public String i;
    public int i0;
    public MultiImageView j;
    public String j0;
    public View k;
    public ImageView l;
    public LinearLayout m;
    public vc8 n;
    public VoiceManager o;
    public View p;
    public int q;
    public int r;
    public String r0;
    public View s;
    public int s0;
    public ArrayList<String> t;
    public int t0;
    public Map<String, ImageUrlData> u;
    public String u0;
    public kc8 v;
    public String v0;
    public qc8 w;
    public String w0;
    public sc8 x;
    public String x0;
    public tr6 y;
    public ad8 y0;
    public String z;
    public View z0;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.xr5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageViewerActivity b;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.b.Q2();
            }
        }

        public l(ImageViewerActivity imageViewerActivity, String str) {
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
                    imageViewerActivity.g = new tr6(imageViewerActivity.getPageContext(), this.b.f);
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
                    this.b.Q2();
                } else {
                    this.b.g.S(this.a);
                    this.b.i = null;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements yx5.c {
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

        @Override // com.baidu.tieba.yx5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) {
                return;
            }
            this.a.v3();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = (String) ListUtils.getItem(this.a.t, this.a.q);
                if (!this.a.J || !this.a.N2() || !ct7.d(str) || !this.a.f0) {
                    this.a.T2();
                    return;
                }
                int currentItem = this.a.j.getCurrentItem();
                if (currentItem >= this.a.t.size() - 1) {
                    this.a.T2();
                } else {
                    this.a.t.remove(str);
                    this.a.j.setUrlData(this.a.t);
                    this.a.j.setCurrentItem(currentItem, true);
                }
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", "a008").eventStat();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements SortSwitchButton.f {
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

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0df3);
                    return false;
                }
                this.a.P = true;
                if (this.a.e != null) {
                    this.a.e.setEnabled(false);
                }
                String a = jc8.a((String) ListUtils.getItem(this.a.t, this.a.q));
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.f3(a, !imageViewerActivity.U, true);
                if (this.a.U) {
                    i2 = 7;
                } else {
                    i2 = 8;
                }
                rc8.f(i2, this.a.A, this.a.z);
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.R2();
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.j.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.j.getCurrentMaxIndex()));
                TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
                this.a.T2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnTouchListener {
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
                            this.a.M0 = motionEvent.getX();
                            return false;
                        }
                    }
                    this.a.M0 = motionEvent.getX();
                    return false;
                }
                this.a.M0 = motionEvent.getX();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext())) {
                    return true;
                }
                if (UbsABTestHelper.isImageViewerTestA()) {
                    if (this.a.x != null) {
                        this.a.x.A();
                    }
                } else if (this.a.x != null) {
                    this.a.x.F();
                    this.a.x.G();
                    this.a.x.y(view2);
                }
                TiebaStatic.log(new StatisticItem("c13269").param("uid", this.a.E).param("fid", this.a.z).param("tid", this.a.A));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements BaseViewPager.a {
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

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.v.Z();
                } else if (this.a.V2() == 1) {
                } else {
                    this.a.v.a0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ViewPager.OnPageChangeListener {
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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.t != null && this.a.q < this.a.t.size()) {
                    this.a.w.g(i, (String) this.a.t.get(this.a.q));
                }
                boolean z3 = true;
                if (i == 1 && this.a.I != null) {
                    if ((this.a.q == 0 || this.a.I.w(this.a.q)) && !at7.m().v(at7.r()) && this.a.I.A(this.a.q)) {
                        this.a.j.setUrlData(this.a.t);
                        if (this.a.C0) {
                            if (this.a.y0 != null && this.a.y0.j()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ImageViewerActivity imageViewerActivity = this.a;
                            if (imageViewerActivity.I != null && this.a.I.u()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            imageViewerActivity.C0 = z2;
                            ImageViewerActivity imageViewerActivity2 = this.a;
                            imageViewerActivity2.l3((z || imageViewerActivity2.C0) ? false : false);
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
                if (i > this.a.M) {
                    this.a.M = i;
                } else if (i < this.a.M) {
                    this.a.M = i;
                    if (this.a.j != null) {
                        dragImageView = this.a.j.getCurrentView();
                    } else {
                        dragImageView = null;
                    }
                    if (dragImageView != null) {
                        z = dragImageView.d0();
                    } else {
                        z = false;
                    }
                    if (this.a.V2() == 1 && z) {
                        this.a.setSwipeBackEnabled(true);
                    } else {
                        this.a.setSwipeBackEnabled(false);
                    }
                    this.a.Q2();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.v != null && i > this.a.j.getItemNum() - 5) {
                    this.a.v.Z();
                }
                this.a.w.c(this.a.t, this.a.q, i);
                this.a.q = i;
                this.a.A3();
                this.a.E3();
                this.a.z3(i);
                if (this.a.w.a() < this.a.q) {
                    this.a.w.j(this.a.q);
                }
                if (this.a.w.b() > this.a.q) {
                    this.a.w.k(this.a.q);
                }
                if (this.a.I != null) {
                    boolean z = true;
                    this.a.I.D((this.a.v == null || this.a.v.c0() != 1) ? false : false);
                    this.a.I.z(i);
                    if (this.a.N2() && this.a.J && this.a.I.x(i)) {
                        this.a.I.B(null);
                    }
                }
                if (this.a.y0 != null) {
                    this.a.y0.m(i);
                }
                if (this.a.x != null) {
                    this.a.x.D();
                }
                if (this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                    this.a.n.q(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.v);
                }
                if (!this.a.B0) {
                    this.a.a3();
                }
                if (this.a.O2()) {
                    StatisticItem statisticItem = new StatisticItem("c15006");
                    rc8.b(statisticItem, this.a.z, this.a.C, TbadkCoreApplication.getCurrentAccount(), this.a.A);
                    TiebaStatic.log(statisticItem);
                    this.a.C3();
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
    public class j implements View.OnClickListener {
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
            rc8.d(this.a.z, this.a.C, this.a.A, alaInfo);
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ImageViewerActivity imageViewerActivity, int i) {
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
                if (booleanValue) {
                    i = 0;
                } else {
                    i = 8;
                }
                navigationBar.setVisibility(i);
                this.a.Q2();
                if (booleanValue) {
                    this.a.x3();
                    return;
                }
                if (this.a.D0 != null) {
                    this.a.D0.f();
                }
                this.a.w3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends yr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity b;

        @Override // com.baidu.tieba.yr5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public m(ImageViewerActivity imageViewerActivity) {
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
            this.b = imageViewerActivity;
        }

        @Override // com.baidu.tieba.yr5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return bs5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ImageViewerActivity imageViewerActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof rz9) && this.a.u != null && (agreeData = ((rz9) customResponsedMessage.getData()).b) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : this.a.u.values()) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof rz9) && this.a.u != null && (agreeData = ((rz9) customResponsedMessage.getData()).b) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : this.a.u.values()) {
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
            jh5 jh5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof jh5) && (jh5Var = (jh5) customResponsedMessage.getData()) != null && !StringUtils.isNull(jh5Var.a)) {
                qw5.h(jh5Var);
                if (StringUtils.isNull(jh5Var.c)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jh5Var.a});
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jh5Var.a, jh5Var.c});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public q(ImageViewerActivity imageViewerActivity) {
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
                boolean P2 = this.a.P2();
                if (!P2) {
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.s3(imageViewerActivity.d, 8);
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.s3(imageViewerActivity2.e, 8);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.s3(imageViewerActivity3.p, 8);
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.s3(imageViewerActivity4.f, 8);
                    this.a.w3();
                }
                if (this.a.j != null && !P2) {
                    this.a.j.B(false);
                }
                this.a.R2();
                this.a.Q2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.j.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.j.getCurrentMaxIndex()));
                this.a.T2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.s3(imageViewerActivity.d, 0);
                this.a.p.setVisibility(0);
                if (this.a.j == null || this.a.N2()) {
                    return;
                }
                boolean u = this.a.j.u();
                if (!"portrait".equals(this.a.D) && !u) {
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.s3(imageViewerActivity2.e, 0);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.s3(imageViewerActivity3.f, 0);
                    this.a.x3();
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.t3(imageViewerActivity4.i);
                    if (this.a.b0) {
                        this.a.j.B(true);
                    } else {
                        this.a.j.B(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public r(ImageViewerActivity imageViewerActivity) {
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
                rc8.f(3, this.a.A, this.a.z);
                if (lp5.a(this.a) && this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                    this.a.n.u(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.v);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements UrlDragImageView.p {
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

        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.a.A).param("obj_type", this.a.D));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnSystemUiVisibilityChangeListener {
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

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (i & 4) == 0) {
                return;
            }
            this.a.S2();
        }
    }

    /* loaded from: classes6.dex */
    public class u implements kc8.b {
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

        @Override // com.baidu.tieba.kc8.b
        public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            boolean z4;
            boolean z5;
            boolean z6;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) != null) || this.a.j == null) {
                return;
            }
            boolean z7 = true;
            if (this.a.P) {
                if (!z3) {
                    this.a.j.removeAllViews();
                    this.a.q = 0;
                    this.a.k3();
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.U = !imageViewerActivity.U;
                } else if (!this.a.U) {
                    this.a.showToast(R.string.image_view_change_img_error);
                }
            }
            this.a.P = false;
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
            this.a.j.setAssistUrls(this.a.u);
            this.a.j.setHasNext(z);
            this.a.j.setNextTitle(str);
            if (i >= 0 && i < this.a.j.getItemNum()) {
                this.a.j.setCurrentItem(i, false);
            } else {
                this.a.j.v(this.a.j.getCurrentItem());
            }
            if (i2 != 0) {
                this.a.r = i2;
            }
            if (arrayList != null && arrayList.size() >= 400 && this.a.j.getCurrentItem() > 200) {
                for (int i3 = 0; i3 < 200; i3++) {
                    arrayList.remove(0);
                }
                this.a.j.setUrlData(arrayList);
                this.a.j.setCurrentItem(this.a.j.getCurrentItem() - 200, false);
            }
            if (this.a.V2() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (this.a.J && this.a.I != null) {
                xc8 xc8Var = this.a.I;
                if (this.a.v.c0() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                xc8Var.D(z6);
                if (this.a.B0 || this.a.I.v(this.a.W2())) {
                    this.a.I.C(this.a.V2(), this.a.r);
                    this.a.I.s(this.a.U);
                    this.a.j.setUrlData(this.a.t);
                }
            } else if (this.a.y0 != null) {
                this.a.y0.o(this.a.V2(), this.a.r);
                this.a.y0.l();
                c(arrayList, advertAppInfo);
            }
            if (this.a.y0 != null && this.a.y0.j()) {
                z4 = true;
            } else {
                z4 = false;
            }
            ImageViewerActivity imageViewerActivity2 = this.a;
            if (imageViewerActivity2.I != null && this.a.I.u()) {
                z5 = true;
            } else {
                z5 = false;
            }
            imageViewerActivity2.C0 = z5;
            ImageViewerActivity imageViewerActivity3 = this.a;
            imageViewerActivity3.l3((z4 || imageViewerActivity3.C0) ? false : false);
            this.a.j.setUrlData(arrayList);
            this.a.A3();
            if (this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                this.a.n.q(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.v);
            }
            if (!this.a.B0) {
                return;
            }
            this.a.B0 = false;
            this.a.a3();
        }

        @Override // com.baidu.tieba.kc8.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.P = false;
                if (this.a.e != null) {
                    if (this.a.e.getState() != this.a.U && TextUtils.isEmpty(str)) {
                        this.a.showToast(R.string.image_view_change_img_error);
                    }
                    this.a.e.w(this.a.U ? 1 : 0);
                    this.a.e.setEnabled(true);
                }
                this.a.hideProgressBar();
                this.a.showToast(str);
                if (i == 40) {
                    if (this.a.t != null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.r = imageViewerActivity.t.size();
                    }
                    this.a.A3();
                }
                if (this.a.B0) {
                    this.a.B0 = false;
                    this.a.a3();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.y0 != null && advertAppInfo != null && arrayList != null) {
                    int i = advertAppInfo.i();
                    if (i != 0) {
                        this.a.o3(advertAppInfo, i);
                        return;
                    } else {
                        this.a.y0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.p3(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements gn9 {
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

        @Override // com.baidu.tieba.gn9
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.a.j.setUrlData(this.a.t);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements ho5.a {
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

        @Override // com.baidu.tieba.ho5.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.a.q3();
                } else {
                    this.a.r3();
                }
            }
        }

        @Override // com.baidu.tieba.ho5.a
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    this.a.r3();
                } else if (z2) {
                    this.a.q3();
                }
            }
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
        this.q = -1;
        this.r = -1;
        if (!UbsABTestHelper.isPicPageFunAdSdkTest() && !UbsABTestHelper.isPicPageFunAdInsert()) {
            z = false;
        } else {
            z = true;
        }
        this.J = z;
        this.K = false;
        this.L = false;
        this.M = 0;
        this.Q = false;
        this.R = true;
        this.S = true;
        this.f1121T = true;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = true;
        this.a0 = false;
        this.b0 = true;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.f0 = true;
        this.B0 = true;
        this.C0 = false;
        this.D0 = go5.a();
        this.E0 = new qj0();
        this.F0 = new k(this, 2016496);
        this.G0 = new p(this, 2016493);
        this.H0 = new q(this);
        this.I0 = new r(this);
        this.J0 = new s(this);
        this.K0 = new c(this);
        this.L0 = new e(this);
        this.N0 = new f(this);
        this.O0 = new g(this);
        this.P0 = new h(this);
        this.Q0 = new i(this);
        this.R0 = new j(this);
        this.S0 = new n(this, 2016528);
        this.T0 = new o(this, 2016530);
    }

    public final void A3() {
        String str;
        int i2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.t != null) {
            long V2 = V2();
            String str2 = ("" + V2) + "/";
            if (this.r > 0) {
                str = str2 + this.r;
            } else {
                str = str2 + "...";
            }
            if (this.D != null && !this.Q && V2() == this.r && (this.D.equals("frs") || this.D.equals("index"))) {
                TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.D));
                this.Q = true;
            }
            if (N2()) {
                long j2 = -1;
                String str3 = (String) ListUtils.getItem(this.t, this.q - 1);
                if (!StringUtils.isNull(str3) && (imageUrlData = this.u.get(str3)) != null) {
                    j2 = imageUrlData.overAllIndex;
                }
                B3(j2, this.r);
            } else if (O2()) {
                C3();
            } else {
                D3(str);
            }
            long j3 = V2 - 1;
            if (j3 > 0) {
                i2 = (int) j3;
            } else {
                i2 = 0;
            }
            y3(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.G0);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            TbImageMemoryCache.u().H();
            qc8 qc8Var = this.w;
            ArrayList<String> arrayList = this.t;
            int i2 = this.q;
            qc8Var.c(arrayList, i2, i2);
            this.w.i();
            kc8 kc8Var = this.v;
            if (kc8Var != null) {
                String X = kc8Var.X();
                String b0 = this.v.b0();
                this.v.o0();
                this.v.i0(null);
                str = X;
                str2 = b0;
            } else {
                str = null;
                str2 = null;
            }
            this.w.l(this.j.getPageCount(), "", this.z, this.A, str, str2);
            sc8 sc8Var = this.x;
            if (sc8Var != null) {
                sc8Var.C();
            }
            this.j.w();
            this.n.n();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            uh5.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.N);
            R2();
            Q2();
            ad8 ad8Var = this.y0;
            if (ad8Var != null) {
                ad8Var.k();
            }
            xc8 xc8Var = this.I;
            if (xc8Var != null) {
                xc8Var.y();
            }
            np5.i(new PrePageKeyEvent(getCurrentPageKey()));
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2001277);
        }
    }

    public final void D3(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d.setText(str);
            if (this.f1121T && !this.V && (sortSwitchButton = this.e) != null) {
                sortSwitchButton.w(this.U ? 1 : 0);
            }
            p75.d(this.d).B(R.array.S_O_X001);
        }
    }

    public final void Y2(AlaInfoData alaInfoData) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, alaInfoData) == null) && alaInfoData != null && alaInfoData.user_info != null && (alaLiveTipView = this.f) != null) {
            alaLiveTipView.setOnClickListener(this.R0);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                t3(alaInfoData.tag);
            }
        }
    }

    public final void Z2(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && this.h != z) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            this.E0.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.j.setBackgroundColor(-16777216);
            this.j.z(i2);
            this.N = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            sc8 sc8Var = this.x;
            if (sc8Var != null) {
                sc8Var.z();
            }
            vc8 vc8Var = this.n;
            if (vc8Var != null) {
                vc8Var.m(this.s0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.j.setCurrentItem(this.q, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                S2();
            }
        }
    }

    public void p3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048633, this, i2) == null) && (multiImageView = this.j) != null) {
            multiImageView.setAddSize(i2);
        }
    }

    public final void t3(@NonNull String str) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, str) != null) || (alaLiveTipView = this.f) == null) {
            return;
        }
        if (!this.f1121T) {
            alaLiveTipView.setVisibility(8);
        }
        this.f.post(new l(this, str));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048626, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.q);
                setResult(-1, intent);
                T2();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void s3(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048637, this, view2, i2) == null) && view2 != null) {
            view2.clearAnimation();
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.n.l(i2, i3, intent);
        }
    }

    public final void B3(long j2, int i2) {
        xc8 xc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ad8 ad8Var = this.y0;
            if ((ad8Var != null && ad8Var.j()) || ((xc8Var = this.I) != null && xc8Var.u())) {
                this.d.setText("");
            } else if (j2 > 0) {
                this.d.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.d.setText("");
            }
            s3(this.e, 8);
            s3(this.f, 8);
            w3();
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.setVisibility(8);
            if (this.c == null) {
                TextView centerTextTitle = this.b.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0789));
                this.c = centerTextTitle;
                centerTextTitle.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            }
            this.c.setVisibility(0);
            this.b.setVisibility(0);
            s3(this.e, 8);
            s3(this.f, 8);
        }
    }

    public final boolean P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            View addSystemImageButton = this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.p = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new b(this));
            this.l = (ImageView) this.p.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.p.setVisibility(0);
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.f1121T && this.D0 != null) {
            pw5.a(getSupportFragmentManager(), R.id.second_floor_container, this.D0.g("big_pic"));
            this.D0.e(new w(this));
            yx5 g2 = yx5.g(this);
            g2.j(R.id.second_floor_container, R.id.navigation_bar);
            g2.i(new a(this));
            g2.f();
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.s = findViewById(R.id.pic_top_obscuration_view);
            r3();
            g3();
            h3();
            this.x = new sc8(this);
            k3();
            this.x.x(this.j);
            A3();
            u3();
            i3();
            d3();
            qc8 qc8Var = this.w;
            ArrayList<String> arrayList = this.t;
            int i2 = this.q;
            qc8Var.c(arrayList, i2, i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            this.j.y();
            this.mIsLogin = lp5.k();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = ug.g(this.A, 0L);
            if (uniqueId != null && g2 > 0) {
                uu4.j(eu4.d0, uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.n.p();
        }
    }

    public final void E3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = false;
            if (N2()) {
                if (this.b.getVisibility() == 0) {
                    z = true;
                }
                this.L = z;
                this.K = true;
            } else if (this.K) {
                NavigationBar navigationBar = this.b;
                if (this.L) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                navigationBar.setVisibility(i2);
                this.K = false;
            }
            n3();
        }
    }

    public final boolean N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.R) {
                return false;
            }
            ad8 ad8Var = this.y0;
            if (ad8Var != null && ad8Var.h(this.q)) {
                return true;
            }
            xc8 xc8Var = this.I;
            if (xc8Var == null || !xc8Var.t(this.q)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final long V2() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String str = (String) ListUtils.getItem(this.t, this.q);
            Map<String, ImageUrlData> map = this.u;
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
                return this.q + 1;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public final void a3() {
        ImageUrlData imageUrlData;
        qc8 qc8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            String str = (String) ListUtils.getItem(this.t, this.q);
            Map<String, ImageUrlData> map = this.u;
            if (map != null && str != null && (imageUrlData = map.get(str)) != null && (qc8Var = this.w) != null) {
                String str2 = this.A;
                String str3 = this.D;
                int i2 = this.q;
                qc8Var.e(str2, str3, i2, this.r - i2, imageUrlData.mHeigth, imageUrlData.mWidth, this.H);
            }
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.m = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
            vc8 vc8Var = new vc8(getPageContext(), this.m);
            this.n = vc8Var;
            vc8Var.r(this.r0);
            this.n.s(this.s0);
            this.n.m(this.s0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public as5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            as5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(ug.g(this.z, 0L));
                pageStayDurationItem.C(ug.g(this.A, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (as5) invokeV.objValue;
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.k = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.k.setLayoutParams(layoutParams);
            this.k.setVisibility(0);
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.J && N2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            this.j.x();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = ug.g(this.A, 0L);
            if (uniqueId != null && g2 > 0) {
                uu4.f(uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            this.n.o();
        }
    }

    public final void F3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (intent = getIntent()) != null) {
            bw5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
        }
    }

    public int M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int count = ListUtils.getCount(this.t);
            if (count > 0) {
                int i2 = this.q;
                if (i2 >= count) {
                    this.q = count - 1;
                } else if (i2 < 0) {
                    this.q = 0;
                }
            } else {
                this.q = 0;
            }
            return this.q;
        }
        return invokeV.intValue;
    }

    public final boolean O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.A0 == null) {
                return false;
            }
            String str = (String) ListUtils.getItem(this.t, this.q);
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.startsWith("####mLiveRoomPageProvider");
        }
        return invokeV.booleanValue;
    }

    public final void Q2() {
        tr6 tr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tr6Var = this.g) != null) {
            tr6Var.h();
        }
    }

    public final void R2() {
        tr6 tr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (tr6Var = this.y) != null) {
            tr6Var.h();
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            getWindow().getDecorView().setSystemUiVisibility(1284);
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            getWindow().addFlags(1024);
            finish();
        }
    }

    public Map<String, ImageUrlData> U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.u;
        }
        return (Map) invokeV.objValue;
    }

    public final int W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (int) V2();
        }
        return invokeV.intValue;
    }

    public String X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.E;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (mw5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    @Override // com.baidu.tieba.pj0
    @NonNull
    public qj0 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.E0;
        }
        return (qj0) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.D;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (vi.isEmpty(this.A)) {
                return 0L;
            }
            return ug.g(this.A, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.xr5
    public yr5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return new m(this);
        }
        return (yr5) invokeV.objValue;
    }

    public boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.W;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.s.setBackgroundColor(-16777216);
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            p75.d(this.s).q(new int[]{R.color.CAM_X0608, R.color.CAM_X0601}, Direction.TOP);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.j.w();
        }
    }

    public final void v3() {
        ho5 ho5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && this.j.t() && (ho5Var = this.D0) != null) {
            ho5Var.d();
        }
    }

    public final void w3() {
        ho5 ho5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (ho5Var = this.D0) != null) {
            ho5Var.hide();
        }
    }

    public final void x3() {
        ho5 ho5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && this.j.t() && (ho5Var = this.D0) != null) {
            ho5Var.show();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (this.o == null) {
                this.o = VoiceManager.instance();
            }
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void c3(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String str3;
        String a2;
        Map<String, ImageUrlData> map;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            this.w = new qc8();
            boolean k2 = lp5.k();
            String b2 = lp5.b();
            String f2 = lp5.f();
            String e2 = lp5.e();
            F3();
            if (bundle != null) {
                this.W = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                ArrayList<String> c2 = oc8.d().c();
                if (!ListUtils.isEmpty(c2)) {
                    this.t = new ArrayList<>(c2);
                }
                this.q = bundle.getInt("index", -1);
                this.z = bundle.getString("fid");
                this.A = bundle.getString("tid");
                this.B = bundle.getString("nid");
                this.C = bundle.getString("fname");
                this.F = bundle.getString("post_id");
                this.G = bundle.getString(IntentConfig.BJH_POST_ID);
                this.a0 = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
                this.Z = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
                this.R = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
                this.E = bundle.getString("user_id");
                this.D = bundle.getString("from");
                this.S = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
                this.f1121T = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
                this.i0 = bundle.getInt("thread_type");
                this.U = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
                Map<String, String> b3 = oc8.d().b();
                this.j0 = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.Y = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
                boolean z2 = bundle.getBoolean("is_login");
                String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
                String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
                String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
                this.b0 = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.c0 = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                if (b3 instanceof Map) {
                    this.u = new ConcurrentHashMap();
                    for (Map.Entry<String, String> entry : b3.entrySet()) {
                        if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                            try {
                                this.u.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr(entry.getValue(), ImageUrlData.class));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
                this.X = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.V = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
                this.t0 = bundle.getInt("card_type", 0);
                this.u0 = bundle.getString("recom_source");
                this.v0 = bundle.getString("ab_tag");
                this.w0 = bundle.getString("weight");
                this.x0 = bundle.getString("extra");
                this.r0 = bundle.getString("from_forum_id");
                this.s0 = bundle.getInt("skin_type");
                this.d0 = bundle.getBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                Serializable serializable = bundle.getSerializable(ImageViewerConfig.REMIND_LIVE_DATA);
                if (serializable instanceof LiveRemindData) {
                    this.g0 = (LiveRemindData) serializable;
                }
                this.h0 = bundle.getInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY);
                this.f0 = bundle.getBoolean(ImageViewerConfig.NEED_REQUEST_AD, true);
                Serializable serializable2 = bundle.getSerializable(ImageViewerConfig.KEY_PROFILE_VIRTUAL_IMAGE_INFO);
                if (serializable2 instanceof ProfileVirtualImageInfo) {
                    ProfileVirtualImageInfo.getInstance().parseRemoteInfo((ProfileVirtualImageInfo) serializable2);
                }
                oc8.d().a();
                z = z2;
                str = string;
                str2 = string2;
                str3 = string3;
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    this.W = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                    this.t = intent.getStringArrayListExtra("url");
                    this.q = intent.getIntExtra("index", -1);
                    this.z = intent.getStringExtra("fid");
                    this.A = intent.getStringExtra("tid");
                    this.B = intent.getStringExtra("nid");
                    this.C = intent.getStringExtra("fname");
                    this.F = intent.getStringExtra("post_id");
                    this.G = intent.getStringExtra(IntentConfig.BJH_POST_ID);
                    this.a0 = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                    this.Z = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                    this.R = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                    this.E = intent.getStringExtra("user_id");
                    this.D = intent.getStringExtra("from");
                    this.S = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                    this.f1121T = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                    this.U = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                    this.i0 = intent.getIntExtra("thread_type", 0);
                    this.b0 = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                    this.c0 = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                    this.X = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                    this.V = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                    z = intent.getBooleanExtra("is_login", false);
                    String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                    str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                    String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                    this.j0 = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                    this.Y = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                    Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                    if (serializableExtra instanceof Map) {
                        this.u = (Map) serializableExtra;
                    }
                    this.t0 = intent.getIntExtra("card_type", 0);
                    this.u0 = intent.getStringExtra("recom_source");
                    this.v0 = intent.getStringExtra("ab_tag");
                    this.w0 = intent.getStringExtra("weight");
                    this.x0 = intent.getStringExtra("extra");
                    this.r0 = intent.getStringExtra("from_forum_id");
                    this.s0 = intent.getIntExtra("skin_type", 0);
                    this.d0 = intent.getBooleanExtra(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                    this.f0 = intent.getBooleanExtra(ImageViewerConfig.NEED_REQUEST_AD, true);
                    Serializable serializableExtra2 = intent.getSerializableExtra(ImageViewerConfig.REMIND_LIVE_DATA);
                    if (serializableExtra2 instanceof LiveRemindData) {
                        this.g0 = (LiveRemindData) serializableExtra2;
                    }
                    this.h0 = intent.getIntExtra(ImageViewerConfig.REMIND_LIVE_FREQUENCY, 0);
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
            lp5.o(z);
            lp5.n(str);
            lp5.p(str3);
            lp5.q(str2);
            this.w.f(bundle, getIntent());
            this.r = ListUtils.getCount(this.t);
            if (this.j0 != null) {
                String str4 = (String) ListUtils.getItem(this.t, this.q);
                if (!StringUtils.isNull(str4) && (map = this.u) != null && (imageUrlData = map.get(str4)) != null) {
                    imageUrlData.setSourceImageRectInScreen(this.j0);
                }
            }
            if (this.W) {
                a2 = null;
            } else {
                a2 = jc8.a((String) ListUtils.getItem(this.t, this.q));
            }
            this.O = a2;
            if (this.U) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            this.a = (ImagePrePageLimitSwitch.Companion.pageLimitSize() <= 0 || !UbsABTestHelper.isBigImagePreTest()) ? 2 : 2;
            b95.a().d(this.g0);
            c95.b().n(this.h0);
        }
    }

    public final void e3() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && !this.W && !this.V && !this.d0) {
            View addCustomView = this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.z0 = addCustomView;
            if (this.e0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            addCustomView.setVisibility(i2);
            if (this.f1121T) {
                ArrayList arrayList = new ArrayList(2);
                e0a e0aVar = new e0a();
                e0aVar.c(0);
                e0aVar.d(getString(R.string.obfuscated_res_0x7f0f029a));
                arrayList.add(e0aVar);
                e0a e0aVar2 = new e0a();
                e0aVar2.c(1);
                e0aVar2.d(getString(R.string.host_name));
                arrayList.add(e0aVar2);
                SortSwitchButton sortSwitchButton = (SortSwitchButton) this.z0.findViewById(R.id.host_all_switch_btn);
                this.e = sortSwitchButton;
                sortSwitchButton.setNeedDayNight(false);
                this.e.setData(arrayList, this.U ? 1 : 0);
                this.e.setVisibility(0);
                this.e.setOnSwitchChangeListener(this.K0);
                s3(this.f, 0);
                return;
            }
            s3(this.e, 8);
            s3(this.f, 8);
        }
    }

    public final void f3(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            kc8 kc8Var = new kc8(this.t, this.u, this.z, this.C, this.A, this.B, str, this.E, this.D, this.i0, z2, this.t0, this.u0, this.v0, this.w0, this.x0);
            this.v = kc8Var;
            kc8Var.m0(this.j0);
            this.v.k0(this.Z);
            this.v.l0(z);
            this.v.e0(this.O);
            this.v.h0(this.Y);
            this.v.j0(this.F);
            this.v.d0(this.G);
            this.v.g0(this.c0);
            this.v.i0(new u(this));
            this.v.f0(true);
            if (this.f0) {
                this.y0.n(new v(this));
            }
            this.v.Z();
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.b = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.b.setClickable(false);
            b3();
            e3();
            TextView textView = new TextView(this);
            this.d = textView;
            textView.setPadding(wi.g(this, R.dimen.tbds15), 0, 0, 0);
            this.d.setGravity(17);
            this.d.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.d.setTextSize(0, wi.g(this, R.dimen.tbds44));
            p75.d(this.d).B(R.array.S_O_X001);
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.d, (View.OnClickListener) null);
            if (jc8.b((String) ListUtils.getItem(this.t, this.q))) {
                this.b.setVisibility(0);
            }
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && !this.V && this.e != null) {
            if (this.y == null) {
                tr6 tr6Var = new tr6(getPageContext(), this.e);
                this.y = tr6Var;
                tr6Var.L(R.drawable.pic_sign_tip);
                this.y.o(48);
                this.y.N(true);
                this.y.n(5000);
                this.y.Q(-wi.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.y.m(new d(this));
            }
            this.y.T(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            MultiImageView multiImageView = this.j;
            if (multiImageView == null) {
                this.j = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f0928af);
            } else {
                multiImageView.q();
            }
            this.H = this.A + "_" + System.currentTimeMillis();
            this.j.setIsFromCDN(this.a0);
            this.j.setIsCanDrag(this.S);
            this.j.setPageMargin(wi.d(getPageContext().getPageActivity(), 8.0f));
            this.j.setOffscreenPageLimit(this.a, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.j.setOnPageChangeListener(this.Q0);
            this.j.setUrlData(this.t);
            this.j.setAssistUrls(this.u);
            this.j.setOuterOnTouchListener(this.N0);
            this.j.setItemOnclickListener(this.L0);
            this.j.setItemOnLongClickListener(this.O0);
            this.j.setCurrentItem(M2(), false);
            this.j.setOnScrollOutListener(this.P0);
            if (this.A0 == null) {
                zc8 zc8Var = new zc8(this.t, getPageContext(), this.z, this.C, this.A);
                this.A0 = zc8Var;
                zc8Var.i(this.b.getFixedNavHeight());
            }
            this.j.k(this.A0);
            if (this.J && this.f0) {
                if (this.I == null) {
                    this.I = new xc8(this.t, this.z, this.A, this.R, this.q, getPageContext());
                }
                this.I.B(null);
                this.j.k(this.I);
            }
            if (this.y0 == null) {
                this.y0 = new ad8(this.t, this.z, this.C, this.a0, this.R, getPageContext(), this.H0, this.u);
            }
            this.j.k(this.y0);
            this.j.setOriImgSelectedCallback(this.J0);
            this.j.setDragToExitListener(this.H0);
            this.j.setUserId(this.E);
            this.j.setShowBottomContainer(this.b0);
            this.j.setOnShareImageListener(this.x);
            this.j.setOnDownloadImageListener(this.x);
            this.j.setOnReplyClickListener(this.I0);
            this.j.setYoungterCoverSomeView(this.e0);
            qc8 qc8Var = this.w;
            if (qc8Var != null) {
                qc8Var.d(this.E, this.A, this.D);
            }
        }
    }

    public final void l3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048617, this, z) != null) || this.A0 == null) {
            return;
        }
        if (!ListUtils.isEmpty(this.v.Y()) && z) {
            this.A0.k(this.v.Y());
            this.A0.j(true);
            ArrayList<String> arrayList = this.t;
            if (arrayList != null && !arrayList.contains("####mLiveRoomPageProvider")) {
                ArrayList<String> arrayList2 = this.t;
                sp8.b(arrayList2, "####mLiveRoomPageProvider", arrayList2.size());
                return;
            }
            return;
        }
        this.A0.k(null);
        this.A0.j(false);
    }

    public final void z3(int i2) {
        MultiImageView multiImageView;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048646, this, i2) != null) || (multiImageView = this.j) == null) {
            return;
        }
        multiImageView.l(i2);
        if (!this.j.u() && !N2() && !O2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        s3(this.e, i3);
        if (this.f1121T) {
            s3(this.f, i3);
        }
        if (i3 == 0) {
            x3();
        } else {
            w3();
        }
    }

    public final void o3(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            o31.b(clogBuilder);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 28 && TbSingleton.getInstance().isNotchScreen(this)) {
                setUseStyleImmersiveSticky(false);
            }
            super.onCreate(bundle);
            S2();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new t(this));
            np5.f().g(TbadkCoreApplication.getInst());
            np5.i(new ImageFpsEvent());
            this.N = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            c3(bundle);
            setContentView(R.layout.image_activity_big_img);
            j3();
            f3(this.O, this.U, false);
            registerListener(this.G0);
            registerListener(this.F0);
            registerListener(this.S0);
            registerListener(this.T0);
            addGlobalLayoutListener();
            VoiceManager y0 = y0();
            this.o = y0;
            y0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                b8a.b(1, getWindow().getAttributes(), getWindow());
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
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(ImageViewerConfig.IS_BJH, this.W);
            oc8.d().f(this.t);
            bundle.putInt("index", this.q);
            bundle.putString("fid", this.z);
            bundle.putString("tid", this.A);
            bundle.putString("fname", this.C);
            bundle.putString("post_id", this.F);
            bundle.putString(IntentConfig.BJH_POST_ID, this.G);
            bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.Z);
            bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.S);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.f1121T);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.R);
            bundle.putString("user_id", this.E);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.b0);
            bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.c0);
            Map<String, ImageUrlData> map = this.u;
            if (map instanceof HashMap) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, ImageUrlData> entry : this.u.entrySet()) {
                    if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                        try {
                            hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                oc8.d().e(hashMap);
            } else if (map instanceof ConcurrentHashMap) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (Map.Entry<String, ImageUrlData> entry2 : this.u.entrySet()) {
                    if (entry2 != null && (entry2.getValue() instanceof ImageUrlData) && (entry2.getKey() instanceof String)) {
                        try {
                            concurrentHashMap.put(entry2.getKey(), OrmObject.jsonStrWithObject(entry2.getValue()));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                oc8.d().e(concurrentHashMap);
            }
            bundle.putString("from", this.D);
            bundle.putInt("thread_type", this.i0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.U);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.j0);
            bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.X);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.V);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.Y);
            bundle.putBoolean("is_login", lp5.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, lp5.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, lp5.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, lp5.f());
            bundle.putString("from_forum_id", this.r0);
            bundle.putInt("skin_type", this.s0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.d0);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.e0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.f0);
            bundle.putSerializable(ImageViewerConfig.REMIND_LIVE_DATA, this.g0);
            bundle.putInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY, this.h0);
            this.w.h(bundle);
        }
    }

    public final void y3(int i2) {
        kc8 kc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048645, this, i2) == null) && (kc8Var = this.v) != null) {
            ArrayList<AlaInfoData> W = kc8Var.W();
            if (W != null && W.size() > 0) {
                Z2(true);
                Y2(W.get(i2 % W.size()));
                return;
            }
            Z2(false);
        }
    }
}
