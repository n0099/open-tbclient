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
import com.baidu.tieba.a95;
import com.baidu.tieba.ax5;
import com.baidu.tieba.b95;
import com.baidu.tieba.bp5;
import com.baidu.tieba.bx5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cp5;
import com.baidu.tieba.ei;
import com.baidu.tieba.gk8;
import com.baidu.tieba.hi5;
import com.baidu.tieba.hk8;
import com.baidu.tieba.i39;
import com.baidu.tieba.iq5;
import com.baidu.tieba.iy5;
import com.baidu.tieba.iy7;
import com.baidu.tieba.ky7;
import com.baidu.tieba.lk8;
import com.baidu.tieba.mt4;
import com.baidu.tieba.mw5;
import com.baidu.tieba.n2a;
import com.baidu.tieba.nk8;
import com.baidu.tieba.ok8;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.pk8;
import com.baidu.tieba.qqa;
import com.baidu.tieba.sk8;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.uk8;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.wh5;
import com.baidu.tieba.wha;
import com.baidu.tieba.wk8;
import com.baidu.tieba.x31;
import com.baidu.tieba.xi0;
import com.baidu.tieba.xk8;
import com.baidu.tieba.xw5;
import com.baidu.tieba.yi0;
import com.baidu.tieba.yt6;
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
public class ImageViewerActivity extends BaseFragmentActivity implements VoiceManager.j, xi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yt6 A;
    public View A0;
    public String B;
    public wk8 B0;
    public String C;
    public boolean C0;
    public String D;
    public boolean D0;
    public String E;
    public final cp5 E0;
    public String F;
    public final yi0 F0;
    public String G;
    public CustomMessageListener G0;
    public String H;
    public final CustomMessageListener H0;
    public String I;
    public DragImageView.h I0;
    public String J;
    public View.OnClickListener J0;
    public uk8 K;
    public UrlDragImageView.p K0;
    public final boolean L;
    public final SortSwitchButton.f L0;
    public boolean M;
    public View.OnClickListener M0;
    public boolean N;
    public float N0;
    public int O;
    public View.OnTouchListener O0;
    public int P;
    public View.OnLongClickListener P0;
    public String Q;
    public BaseViewPager.a Q0;
    public boolean R;
    public ViewPager.OnPageChangeListener R0;
    public boolean S;
    public View.OnClickListener S0;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1119T;
    public CustomMessageListener T0;
    public boolean U;
    public CustomMessageListener U0;
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
    public yt6 g;
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
    public sk8 n;
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
    public hk8 x;
    public String x0;
    public nk8 y;
    public String y0;
    public pk8 z;
    public xk8 z0;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
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
                this.a.b.U2();
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
                    imageViewerActivity.g = new yt6(imageViewerActivity.getPageContext(), this.b.f);
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
                    this.b.U2();
                } else {
                    this.b.g.S(this.a);
                    this.b.i = null;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements iy5.c {
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

        @Override // com.baidu.tieba.iy5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) {
                return;
            }
            this.a.B3();
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
                String str = (String) ListUtils.getItem(this.a.v, this.a.s);
                if (!this.a.L || !this.a.R2() || !ky7.d(str) || !this.a.g0) {
                    this.a.X2();
                    return;
                }
                int currentItem = this.a.j.getCurrentItem();
                if (currentItem >= this.a.v.size() - 1) {
                    this.a.X2();
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
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e40);
                    return false;
                }
                this.a.R = true;
                if (this.a.e != null) {
                    this.a.e.setEnabled(false);
                }
                String a = gk8.a((String) ListUtils.getItem(this.a.v, this.a.s));
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.k3(a, !imageViewerActivity.W, true);
                if (this.a.W) {
                    i2 = 7;
                } else {
                    i2 = 8;
                }
                ok8.f(i2, this.a.C, this.a.B);
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
            this.a.V2();
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
                this.a.X2();
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
                            this.a.N0 = motionEvent.getX();
                            return false;
                        }
                    }
                    this.a.N0 = motionEvent.getX();
                    return false;
                }
                this.a.N0 = motionEvent.getX();
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
                    this.a.x.c0();
                } else if (this.a.Z2() == 1) {
                } else {
                    this.a.x.d0();
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
                if (this.a.v != null && this.a.s < this.a.v.size()) {
                    this.a.y.g(i, (String) this.a.v.get(this.a.s));
                }
                boolean z3 = true;
                if (i == 1 && this.a.K != null) {
                    if ((this.a.s == 0 || this.a.K.w(this.a.s)) && !iy7.m().v(iy7.r()) && this.a.K.A(this.a.s)) {
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
                            imageViewerActivity2.q3((z || imageViewerActivity2.D0) ? false : false);
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
                if (i > this.a.O) {
                    this.a.O = i;
                } else if (i < this.a.O) {
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
                    if (this.a.Z2() == 1 && z) {
                        this.a.setSwipeBackEnabled(true);
                    } else {
                        this.a.setSwipeBackEnabled(false);
                    }
                    this.a.U2();
                }
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
                    this.a.x.i0(this.a.a3());
                }
                this.a.G3();
                this.a.K3();
                this.a.F3(i);
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
                    if (this.a.R2() && this.a.L && this.a.K.x(i)) {
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
                    this.a.f3();
                }
                if (this.a.S2()) {
                    StatisticItem statisticItem = new StatisticItem("c15006");
                    ok8.b(statisticItem, this.a.B, this.a.E, TbadkCoreApplication.getCurrentAccount(), this.a.C);
                    TiebaStatic.log(statisticItem);
                    this.a.I3();
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
            ok8.d(this.a.B, this.a.E, this.a.C, alaInfo);
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
                this.a.U2();
                if (booleanValue) {
                    this.a.D3();
                    return;
                }
                if (this.a.E0 != null) {
                    this.a.E0.i();
                }
                this.a.C3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends PageStayDurationFilter {
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
            wh5 wh5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof wh5) && (wh5Var = (wh5) customResponsedMessage.getData()) != null && !StringUtils.isNull(wh5Var.a)) {
                bx5.h(wh5Var);
                if (StringUtils.isNull(wh5Var.c)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{wh5Var.a});
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{wh5Var.a, wh5Var.c});
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
                boolean T2 = this.a.T2();
                if (!T2) {
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.y3(imageViewerActivity.d, 8);
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.y3(imageViewerActivity2.e, 8);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.y3(imageViewerActivity3.p, 8);
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.y3(imageViewerActivity4.f, 8);
                    this.a.C3();
                }
                if (this.a.j != null && !T2) {
                    this.a.j.J(false);
                }
                this.a.V2();
                this.a.U2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.j.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.j.getCurrentMaxIndex()));
                this.a.X2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.y3(imageViewerActivity.d, 0);
                this.a.p.setVisibility(0);
                if (this.a.j == null || this.a.R2()) {
                    return;
                }
                boolean z = this.a.j.z();
                if (!"portrait".equals(this.a.F) && !z) {
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.y3(imageViewerActivity2.e, 0);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.y3(imageViewerActivity3.f, 0);
                    this.a.D3();
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.z3(imageViewerActivity4.i);
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
                ok8.f(3, this.a.C, this.a.B);
                if (iq5.a(this.a) && this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                    this.a.n.u(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.x);
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
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.a.C).param("obj_type", this.a.F));
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
            this.a.W2();
        }
    }

    /* loaded from: classes6.dex */
    public class u implements hk8.b {
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

        @Override // com.baidu.tieba.hk8.b
        public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            boolean z4;
            boolean z5;
            boolean z6;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) != null) || this.a.j == null) {
                return;
            }
            boolean z7 = true;
            if (this.a.R) {
                if (!z3) {
                    this.a.j.removeAllViews();
                    this.a.s = 0;
                    if (this.a.x != null) {
                        this.a.x.i0(1);
                    }
                    this.a.p3();
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
                this.a.j.setCurrentItem(i, false);
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
            if (this.a.Z2() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (this.a.L && this.a.K != null) {
                uk8 uk8Var = this.a.K;
                if (this.a.x.f0() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                uk8Var.D(z6);
                if (this.a.C0 || this.a.K.v(this.a.a3())) {
                    this.a.K.C(this.a.Z2(), this.a.t);
                    this.a.K.s(this.a.W);
                    this.a.j.setUrlData(this.a.v);
                }
            } else if (this.a.z0 != null) {
                long Z2 = this.a.Z2();
                if (this.a.q > 0) {
                    Z2 = this.a.b3();
                }
                this.a.z0.o(Z2, this.a.t);
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
            imageViewerActivity3.q3((z4 || imageViewerActivity3.D0) ? false : false);
            this.a.j.setUrlData(arrayList);
            this.a.G3();
            if (!this.a.g0) {
                this.a.s3();
            }
            if (this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                this.a.n.q(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.x);
            }
            if (!this.a.C0) {
                return;
            }
            this.a.C0 = false;
            this.a.f3();
        }

        @Override // com.baidu.tieba.hk8.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.R = false;
                if (this.a.e != null) {
                    if (this.a.e.getState() != this.a.W && TextUtils.isEmpty(str)) {
                        this.a.showToast(R.string.image_view_change_img_error);
                    }
                    this.a.e.x(this.a.W ? 1 : 0);
                    this.a.e.setEnabled(true);
                }
                this.a.hideProgressBar();
                this.a.showToast(str);
                if (i == 40) {
                    if (this.a.v != null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.t = imageViewerActivity.v.size();
                    }
                    this.a.G3();
                }
                if (this.a.C0) {
                    this.a.C0 = false;
                    this.a.f3();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.z0 != null && advertAppInfo != null && arrayList != null) {
                    int h = advertAppInfo.h();
                    if (h != 0) {
                        this.a.u3(advertAppInfo, h);
                        return;
                    } else {
                        this.a.z0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.v3(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements n2a {
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

        @Override // com.baidu.tieba.n2a
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.a.j.setUrlData(this.a.v);
                this.a.s3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements cp5.a {
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

        @Override // com.baidu.tieba.cp5.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.a.w3();
                } else {
                    this.a.x3();
                }
            }
        }

        @Override // com.baidu.tieba.cp5.a
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    this.a.x3();
                } else if (z2) {
                    this.a.w3();
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
        this.f1119T = true;
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
        this.E0 = bp5.a();
        this.F0 = new yi0();
        this.G0 = new k(this, 2016496);
        this.H0 = new p(this, 2016493);
        this.I0 = new q(this);
        this.J0 = new r(this);
        this.K0 = new s(this);
        this.L0 = new c(this);
        this.M0 = new e(this);
        this.O0 = new f(this);
        this.P0 = new g(this);
        this.Q0 = new h(this);
        this.R0 = new i(this);
        this.S0 = new j(this);
        this.T0 = new n(this, 2016528);
        this.U0 = new o(this, 2016530);
    }

    public final void G3() {
        String str;
        int i2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.v != null) {
            long Z2 = Z2();
            String str2 = ("" + Z2) + "/";
            if (this.t > 0) {
                str = str2 + this.t;
            } else {
                str = str2 + "...";
            }
            if (this.F != null && !this.S && Z2() == this.t && (this.F.equals("frs") || this.F.equals("index"))) {
                TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.F));
                this.S = true;
            }
            if (R2()) {
                long j2 = -1;
                String str3 = (String) ListUtils.getItem(this.v, this.s - 1);
                if (!StringUtils.isNull(str3) && (imageUrlData = this.w.get(str3)) != null) {
                    j2 = imageUrlData.overAllIndex;
                }
                H3(j2, this.t);
            } else if (S2()) {
                I3();
            } else {
                J3(str);
            }
            long j3 = Z2 - 1;
            if (j3 > 0) {
                i2 = (int) j3;
            } else {
                i2 = 0;
            }
            E3(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.H0);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            TbImageMemoryCache.A().I();
            nk8 nk8Var = this.y;
            ArrayList<String> arrayList = this.v;
            int i2 = this.s;
            nk8Var.c(arrayList, i2, i2);
            this.y.i();
            hk8 hk8Var = this.x;
            if (hk8Var != null) {
                String Z = hk8Var.Z();
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
            pk8 pk8Var = this.z;
            if (pk8Var != null) {
                pk8Var.C();
            }
            this.j.D();
            this.n.n();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            hi5.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.P);
            V2();
            U2();
            xk8 xk8Var = this.z0;
            if (xk8Var != null) {
                xk8Var.k();
            }
            uk8 uk8Var = this.K;
            if (uk8Var != null) {
                uk8Var.y();
            }
            MutiProcessManager.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2001277);
        }
    }

    public final void J3(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d.setText(str);
            if (this.V && !this.X && (sortSwitchButton = this.e) != null) {
                sortSwitchButton.x(this.W ? 1 : 0);
            }
            EMManager.from(this.d).setTextShadow(R.array.S_O_X001);
        }
    }

    public final void d3(AlaInfoData alaInfoData) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, alaInfoData) == null) && alaInfoData != null && alaInfoData.user_info != null && (alaLiveTipView = this.f) != null) {
            alaLiveTipView.setOnClickListener(this.S0);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                z3(alaInfoData.tag);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, motionEvent)) == null) {
            this.F0.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void e3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z) == null) && this.h != z) {
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
            pk8 pk8Var = this.z;
            if (pk8Var != null) {
                pk8Var.z();
            }
            sk8 sk8Var = this.n;
            if (sk8Var != null) {
                sk8Var.m(i2);
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
                W2();
            }
        }
    }

    public void v3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048644, this, i2) == null) && (multiImageView = this.j) != null) {
            multiImageView.setAddSize(i2);
        }
    }

    public final void z3(@NonNull String str) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048648, this, str) != null) || (alaLiveTipView = this.f) == null) {
            return;
        }
        if (!this.V) {
            alaLiveTipView.setVisibility(8);
        }
        this.f.post(new l(this, str));
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
                X2();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void y3(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048647, this, view2, i2) == null) && view2 != null) {
            view2.clearAnimation();
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048623, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.n.l(i2, i3, intent);
        }
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.X && this.e != null) {
            if (this.A == null) {
                yt6 yt6Var = new yt6(getPageContext(), this.e);
                this.A = yt6Var;
                yt6Var.L(R.drawable.pic_sign_tip);
                this.A.o(48);
                this.A.N(true);
                this.A.n(5000);
                this.A.Q(-BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.A.m(new d(this));
            }
            this.A.T(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.b = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.b.setClickable(false);
            g3();
            j3();
            TextView textView = new TextView(this);
            this.d = textView;
            textView.setPadding(BdUtilHelper.getDimens(this, R.dimen.tbds15), 0, 0, 0);
            this.d.setGravity(17);
            this.d.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.d.setTextSize(0, BdUtilHelper.getDimens(this, R.dimen.tbds44));
            EMManager.from(this.d).setTextShadow(R.array.S_O_X001);
            this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.d, (View.OnClickListener) null);
            if (gk8.b((String) ListUtils.getItem(this.v, this.s))) {
                this.b.setVisibility(0);
            }
        }
    }

    public final void B3() {
        cp5 cp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.j.y() && (cp5Var = this.E0) != null) {
            cp5Var.g();
        }
    }

    public final void C3() {
        cp5 cp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cp5Var = this.E0) != null) {
            cp5Var.hide();
        }
    }

    public final void D3() {
        cp5 cp5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.j.y() && (cp5Var = this.E0) != null) {
            cp5Var.show();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.o == null) {
                this.o = VoiceManager.instance();
            }
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void L3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (intent = getIntent()) != null) {
            mw5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
        }
    }

    @Override // com.baidu.tieba.xi0
    @NonNull
    public yi0 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.F0;
        }
        return (yi0) invokeV.objValue;
    }

    public final boolean S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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

    public final void U2() {
        yt6 yt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (yt6Var = this.g) != null) {
            yt6Var.h();
        }
    }

    public final void V2() {
        yt6 yt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (yt6Var = this.A) != null) {
            yt6Var.h();
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            getWindow().addFlags(1024);
            finish();
        }
    }

    public Map<String, ImageUrlData> Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.w;
        }
        return (Map) invokeV.objValue;
    }

    public final int a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return (int) Z2();
        }
        return invokeV.intValue;
    }

    public String c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.G;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (xw5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
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
            if (ei.isEmpty(this.C)) {
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
            return new m(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
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

    public boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.Y;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.j.D();
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.u.setBackgroundColor(-16777216);
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            EMManager.from(this.u).setGradientColor(new int[]{R.color.CAM_X0608, R.color.CAM_X0601}, Direction.TOP);
        }
    }

    public final void E3(int i2) {
        hk8 hk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && (hk8Var = this.x) != null) {
            ArrayList<AlaInfoData> X = hk8Var.X();
            if (X != null && X.size() > 0) {
                e3(true);
                d3(X.get(i2 % X.size()));
                return;
            }
            e3(false);
        }
    }

    public final void F3(int i2) {
        MultiImageView multiImageView;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i2) != null) || (multiImageView = this.j) == null) {
            return;
        }
        multiImageView.p(i2);
        this.j.q(i2);
        if (!this.j.z() && !R2() && !S2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        y3(this.e, i3);
        if (this.V) {
            y3(this.f, i3);
        }
        if (i3 == 0) {
            D3();
        } else {
            C3();
        }
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048636, this, z) != null) || this.B0 == null) {
            return;
        }
        if (!ListUtils.isEmpty(this.x.b0()) && z) {
            this.B0.k(this.x.b0());
            this.B0.j(true);
            ArrayList<String> arrayList = this.v;
            if (arrayList != null && !arrayList.contains("####mLiveRoomPageProvider")) {
                ArrayList<String> arrayList2 = this.v;
                i39.b(arrayList2, "####mLiveRoomPageProvider", arrayList2.size());
                return;
            }
            return;
        }
        this.B0.k(null);
        this.B0.j(false);
    }

    public final void H3(long j2, int i2) {
        uk8 uk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            xk8 xk8Var = this.z0;
            if ((xk8Var != null && xk8Var.j()) || ((uk8Var = this.K) != null && uk8Var.u())) {
                this.d.setText("");
            } else if (j2 > 0) {
                this.d.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.d.setText("");
            }
            y3(this.e, 8);
            y3(this.f, 8);
            C3();
        }
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.setVisibility(8);
            if (this.c == null) {
                TextView centerTextTitle = this.b.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f07a1));
                this.c = centerTextTitle;
                centerTextTitle.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            }
            this.c.setVisibility(0);
            this.b.setVisibility(0);
            y3(this.e, 8);
            y3(this.f, 8);
        }
    }

    public final boolean T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            MultiImageView multiImageView = this.j;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.j.getCurrentUrlDragImageView().getImageView() != null && this.j.getCurrentUrlDragImageView().getImageView().getImageUrlData() != null) {
                return this.j.getCurrentUrlDragImageView().getImageView().getImageUrlData().isLongPic;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && getWindow() != null) {
            if (UtilHelper.isFoldScreen() || (DeviceInfoUtil.isHuaWei() && !DeviceInfoUtil.isHonor30NotchDevice())) {
                getWindow().setFlags(1024, 1024);
            }
            if (getWindow().getDecorView() != null) {
                getWindow().getDecorView().setSystemUiVisibility(1284);
            }
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            View addSystemImageButton = this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.p = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new b(this));
            this.l = (ImageView) this.p.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.p.setVisibility(0);
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.V && this.E0 != null) {
            ax5.a(getSupportFragmentManager(), R.id.second_floor_container, this.E0.j("big_pic"));
            this.E0.h(new w(this));
            iy5 g2 = iy5.g(this);
            g2.j(R.id.second_floor_container, R.id.navigation_bar);
            g2.i(new a(this));
            g2.f();
        }
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.u = findViewById(R.id.pic_top_obscuration_view);
            x3();
            l3();
            m3();
            this.z = new pk8(this);
            p3();
            this.z.x(this.j);
            G3();
            A3();
            n3();
            i3();
            nk8 nk8Var = this.y;
            ArrayList<String> arrayList = this.v;
            int i2 = this.s;
            nk8Var.c(arrayList, i2, i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
            this.j.F();
            this.mIsLogin = iq5.k();
            BdUniqueId uniqueId = getUniqueId();
            long j2 = JavaTypesHelper.toLong(this.C, 0L);
            if (uniqueId != null && j2 > 0) {
                MutiProcessMissionHelper.startThreadBrowseTimeMission(mt4.d0, uniqueId.getId(), j2);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.n.p();
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.q > 0) {
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
            this.q = 0;
        }
    }

    public final void K3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean z = false;
            if (R2()) {
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
            t3();
        }
    }

    public int Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
            hk8 hk8Var = this.x;
            if (hk8Var != null) {
                hk8Var.i0(a3());
            }
            return this.s;
        }
        return invokeV.intValue;
    }

    public final boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.f1119T) {
                return false;
            }
            xk8 xk8Var = this.z0;
            if (xk8Var != null && xk8Var.h(this.s)) {
                return true;
            }
            uk8 uk8Var = this.K;
            if (uk8Var == null || !uk8Var.t(this.s)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final long Z2() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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

    public final long b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int count = ListUtils.getCount(this.v);
            for (int i2 = 0; i2 < count; i2++) {
                ImageUrlData imageUrlData = this.w.get(this.v.get(i2));
                if (imageUrlData != null && TextUtils.equals(imageUrlData.id, this.r)) {
                    return imageUrlData.overAllIndex;
                }
            }
            return Z2();
        }
        return invokeV.longValue;
    }

    public final void f3() {
        ImageUrlData imageUrlData;
        nk8 nk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            String str = (String) ListUtils.getItem(this.v, this.s);
            Map<String, ImageUrlData> map = this.w;
            if (map != null && str != null && (imageUrlData = map.get(str)) != null && (nk8Var = this.y) != null) {
                String str2 = this.C;
                String str3 = this.F;
                int i2 = this.s;
                nk8Var.e(str2, str3, i2, this.t - i2, imageUrlData.mHeigth, imageUrlData.mWidth, this.J);
            }
        }
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

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.m = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
            sk8 sk8Var = new sk8(getPageContext(), this.m);
            this.n = sk8Var;
            sk8Var.r(this.s0);
            this.n.s(this.t0);
            this.n.m(this.t0);
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.k = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.k.setLayoutParams(layoutParams);
            this.k.setVisibility(0);
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

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (this.L && R2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void h3(Bundle bundle) {
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
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            this.y = new nk8();
            boolean k2 = iq5.k();
            String b2 = iq5.b();
            String f2 = iq5.f();
            String e2 = iq5.e();
            L3();
            if (bundle != null) {
                this.Y = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                ArrayList<String> c2 = lk8.d().c();
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
                this.f1119T = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
                this.G = bundle.getString("user_id");
                this.F = bundle.getString("from");
                this.U = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
                this.V = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
                this.j0 = bundle.getInt("thread_type");
                this.W = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
                Map<String, String> b3 = lk8.d().b();
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
                lk8.d().a();
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
                    this.f1119T = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
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
            this.r = gk8.a(str4);
            iq5.o(z);
            iq5.n(str);
            iq5.p(str3);
            iq5.q(str2);
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
                a2 = gk8.a((String) ListUtils.getItem(this.v, this.s));
            }
            this.Q = a2;
            if (this.W) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            this.a = (ImagePrePageLimitSwitch.Companion.pageLimitSize() <= 0 || !UbsABTestHelper.isBigImagePreTest()) ? 2 : 2;
            a95.a().d(this.h0);
            b95.b().n(this.i0);
        }
    }

    public final void j3() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && !this.Y && !this.X && !this.e0) {
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
                wha whaVar = new wha();
                whaVar.c(0);
                whaVar.d(getString(R.string.obfuscated_res_0x7f0f029d));
                arrayList.add(whaVar);
                wha whaVar2 = new wha();
                whaVar2.c(1);
                whaVar2.d(getString(R.string.host_name));
                arrayList.add(whaVar2);
                SortSwitchButton sortSwitchButton = (SortSwitchButton) this.A0.findViewById(R.id.host_all_switch_btn);
                this.e = sortSwitchButton;
                sortSwitchButton.setNeedDayNight(false);
                this.e.setData(arrayList, this.W ? 1 : 0);
                this.e.setVisibility(0);
                this.e.setOnSwitchChangeListener(this.L0);
                y3(this.f, 0);
                return;
            }
            y3(this.e, 8);
            y3(this.f, 8);
        }
    }

    public final void k3(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            hk8 hk8Var = new hk8(this.v, this.w, this.B, this.E, this.C, this.D, str, this.G, this.F, this.j0, z2, this.u0, this.v0, this.w0, this.x0, this.y0, this.q);
            this.x = hk8Var;
            hk8Var.q0(this.r0);
            this.x.o0(this.a0);
            this.x.p0(z);
            this.x.h0(this.Q);
            this.x.l0(this.Z);
            this.x.n0(this.H);
            this.x.g0(this.I);
            this.x.k0(this.d0);
            this.x.m0(new u(this));
            this.x.j0(true);
            if (this.g0) {
                this.z0.n(new v(this));
            }
            this.x.a0();
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
            W2();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new t(this));
            MutiProcessManager.getInstance().init(TbadkCoreApplication.getInst());
            MutiProcessManager.publishEvent(new ImageFpsEvent());
            this.P = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            h3(bundle);
            setContentView(R.layout.image_activity_big_img);
            o3();
            k3(this.Q, this.W, false);
            registerListener(this.H0);
            registerListener(this.G0);
            registerListener(this.T0);
            registerListener(this.U0);
            addGlobalLayoutListener();
            VoiceManager H0 = H0();
            this.o = H0;
            H0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                qqa.b(1, getWindow().getAttributes(), getWindow());
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
            lk8.d().f(this.v);
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
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.f1119T);
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
                lk8.d().e(hashMap);
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
                lk8.d().e(concurrentHashMap);
            }
            bundle.putString("from", this.F);
            bundle.putInt("thread_type", this.j0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.W);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.r0);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.X);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.Z);
            bundle.putBoolean("is_login", iq5.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, iq5.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, iq5.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, iq5.f());
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

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            MultiImageView multiImageView = this.j;
            if (multiImageView == null) {
                this.j = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f0929ce);
            } else {
                multiImageView.v();
            }
            this.J = this.C + "_" + System.currentTimeMillis();
            this.j.setIsFromCDN(this.b0);
            this.j.setIsCanDrag(this.U);
            this.j.setPageMargin(BdUtilHelper.dip2px(getPageContext().getPageActivity(), 8.0f));
            this.j.setOffscreenPageLimit(this.a, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.j.setOnPageChangeListener(this.R0);
            this.j.setUrlData(this.v);
            this.j.setAssistUrls(this.w);
            this.j.setOuterOnTouchListener(this.O0);
            this.j.setItemOnclickListener(this.M0);
            this.j.setItemOnLongClickListener(this.P0);
            this.j.setCurrentItem(Q2(), false);
            this.j.setOnScrollOutListener(this.Q0);
            if (this.B0 == null) {
                wk8 wk8Var = new wk8(this.v, getPageContext(), this.B, this.E, this.C);
                this.B0 = wk8Var;
                wk8Var.i(this.b.getFixedNavHeight());
            }
            this.j.o(this.B0);
            if (this.L && this.g0) {
                if (this.K == null) {
                    this.K = new uk8(this.v, this.B, this.C, this.f1119T, this.s, getPageContext());
                }
                this.K.B(null);
                this.j.o(this.K);
            }
            if (this.z0 == null) {
                this.z0 = new xk8(this.v, this.B, this.E, this.b0, this.f1119T, getPageContext(), this.I0, this.w);
            }
            this.j.o(this.z0);
            this.j.setOriImgSelectedCallback(this.K0);
            this.j.setDragToExitListener(this.I0);
            this.j.setUserId(this.G);
            this.j.setShowBottomContainer(this.c0);
            this.j.setOnShareImageListener(this.z);
            this.j.setOnDownloadImageListener(this.z);
            this.j.setOnReplyClickListener(this.J0);
            this.j.setYoungterCoverSomeView(this.f0);
            nk8 nk8Var = this.y;
            if (nk8Var != null) {
                nk8Var.d(this.G, this.C, this.F);
            }
        }
    }

    public final void u3(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048643, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            x31.e(clogBuilder);
        }
    }
}
