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
import com.baidu.tbadk.core.util.StringHelper;
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
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ac5;
import com.baidu.tieba.ad5;
import com.baidu.tieba.ba5;
import com.baidu.tieba.bk5;
import com.baidu.tieba.ck5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cx4;
import com.baidu.tieba.dn4;
import com.baidu.tieba.e11;
import com.baidu.tieba.ho7;
import com.baidu.tieba.ii0;
import com.baidu.tieba.io7;
import com.baidu.tieba.ji0;
import com.baidu.tieba.k65;
import com.baidu.tieba.kx8;
import com.baidu.tieba.lf5;
import com.baidu.tieba.ll5;
import com.baidu.tieba.mo7;
import com.baidu.tieba.nf5;
import com.baidu.tieba.nj5;
import com.baidu.tieba.nx6;
import com.baidu.tieba.of5;
import com.baidu.tieba.om4;
import com.baidu.tieba.oo7;
import com.baidu.tieba.pa6;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.po7;
import com.baidu.tieba.py4;
import com.baidu.tieba.qo7;
import com.baidu.tieba.qy4;
import com.baidu.tieba.t17;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.to7;
import com.baidu.tieba.u49;
import com.baidu.tieba.uq7;
import com.baidu.tieba.v17;
import com.baidu.tieba.v65;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vo7;
import com.baidu.tieba.xm8;
import com.baidu.tieba.xo7;
import com.baidu.tieba.yc5;
import com.baidu.tieba.yg;
import com.baidu.tieba.yi;
import com.baidu.tieba.yj5;
import com.baidu.tieba.yo7;
import com.baidu.tieba.yw8;
import com.baidu.tieba.zb5;
import com.baidu.tieba.zi;
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
/* loaded from: classes5.dex */
public class ImageViewerActivity extends BaseFragmentActivity implements VoiceManager.j, ii0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean A0;
    public String B;
    public final ac5 B0;
    public String C;
    public final ji0 C0;
    public String D;
    public CustomMessageListener D0;
    public String E;
    public final CustomMessageListener E0;
    public String F;
    public DragImageView.h F0;
    public String G;
    public nx6 G0;
    public vo7 H;
    public View.OnClickListener H0;
    public final boolean I;
    public UrlDragImageView.p I0;
    public boolean J;
    public final SortSwitchButton.f J0;
    public boolean K;
    public View.OnClickListener K0;
    public int L;
    public float L0;
    public int M;
    public View.OnTouchListener M0;
    public String N;
    public View.OnLongClickListener N0;
    public boolean O;
    public BaseViewPager.a O0;
    public boolean P;
    public ViewPager.OnPageChangeListener P0;
    public boolean Q;
    public View.OnClickListener Q0;
    public boolean R;
    public CustomMessageListener R0;
    public boolean S;
    public CustomMessageListener S0;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public NavigationBar a;
    public boolean a0;
    public TextView b;
    public boolean b0;
    public TextView c;
    public boolean c0;
    public SortSwitchButton d;
    public boolean d0;
    public AlaLiveTipView e;
    public boolean e0;
    public pa6 f;
    public LiveRemindData f0;
    public boolean g;
    public int g0;
    public String h;
    public int h0;
    public MultiImageView i;
    public String i0;
    public View j;
    public String j0;
    public ImageView k;
    public LinearLayout l;
    public to7 m;
    public VoiceManager n;
    public View o;
    public int p;
    public int q;
    public int q0;
    public View r;
    public int r0;
    public ArrayList<String> s;
    public String s0;
    public Map<String, ImageUrlData> t;
    public String t0;
    public io7 u;
    public String u0;
    public oo7 v;
    public String v0;
    public qo7 w;
    public yo7 w0;
    public pa6 x;
    public View x0;
    public String y;
    public xo7 y0;
    public String z;
    public boolean z0;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.kf5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageViewerActivity b;

        /* loaded from: classes5.dex */
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
                this.a.b.p2();
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
                if (this.b.f == null) {
                    ImageViewerActivity imageViewerActivity = this.b;
                    imageViewerActivity.f = new pa6(imageViewerActivity.getPageContext(), this.b.e);
                    this.b.f.L(R.drawable.bg_tip_blue_up);
                    this.b.f.o(32);
                    this.b.f.N(true);
                    this.b.f.B(1);
                    this.b.f.Q(0);
                    this.b.f.n(3000);
                    this.b.f.m(new a(this));
                    if (this.b.e != null && this.b.e.getVisibility() != 0) {
                        this.b.h = this.a;
                        return;
                    }
                    this.b.f.S(this.a);
                } else if (this.b.h == null || this.b.f == null || this.b.e == null || this.b.e.getVisibility() != 0) {
                    this.b.p2();
                } else {
                    this.b.f.S(this.a);
                    this.b.h = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* loaded from: classes5.dex */
        public class a implements nx6.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r a;

            @Override // com.baidu.tieba.nx6.d
            public void a(boolean z, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                }
            }

            @Override // com.baidu.tieba.nx6.d
            public void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                }
            }

            public a(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = rVar;
            }

            @Override // com.baidu.tieba.nx6.d
            public void b(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z && this.a.a.m != null && this.a.a.i.getCurrentUrlDragImageView() != null) {
                    this.a.a.m.u(this.a.a.i.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.a.u);
                }
            }
        }

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

        /* JADX DEBUG: Multi-variable search result rejected for r5v25, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                po7.f(3, this.a.z, this.a.y);
                if (!yc5.a(this.a)) {
                    return;
                }
                if (this.a.G0 == null) {
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.G0 = new nx6(imageViewerActivity.getPageContext());
                    this.a.G0.i(new a(this));
                }
                if (this.a.i != null && this.a.i.getCurrentUrlDragImageView() != null && this.a.i.getCurrentUrlDragImageView().getmAssistUrlData() != null) {
                    i = this.a.i.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost;
                } else {
                    i = 1;
                }
                this.a.G0.j(i ^ 1);
                this.a.G0.g(this.a.y, yg.g(this.a.z, 0L));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ll5.c {
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

        @Override // com.baidu.tieba.ll5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) {
                return;
            }
            this.a.U2();
        }
    }

    /* loaded from: classes5.dex */
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
                String str = (String) ListUtils.getItem(this.a.s, this.a.p);
                if (!this.a.I || !this.a.n2() || !v17.d(str) || !this.a.e0) {
                    this.a.s2();
                    return;
                }
                int currentItem = this.a.i.getCurrentItem();
                if (currentItem >= this.a.s.size() - 1) {
                    this.a.s2();
                } else {
                    this.a.s.remove(str);
                    this.a.i.setUrlData(this.a.s);
                    this.a.i.setCurrentItem(currentItem, true);
                }
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", "a008").eventStat();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0cd1);
                    return false;
                }
                this.a.O = true;
                if (this.a.d != null) {
                    this.a.d.setEnabled(false);
                }
                String a = ho7.a((String) ListUtils.getItem(this.a.s, this.a.p));
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.E2(a, !imageViewerActivity.T, true);
                if (this.a.T) {
                    i2 = 7;
                } else {
                    i2 = 8;
                }
                po7.f(i2, this.a.z, this.a.y);
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.q2();
        }
    }

    /* loaded from: classes5.dex */
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
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.i.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.i.getCurrentMaxIndex()));
                TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
                this.a.s2();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                            this.a.L0 = motionEvent.getX();
                            return false;
                        }
                    }
                    this.a.L0 = motionEvent.getX();
                    return false;
                }
                this.a.L0 = motionEvent.getX();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
                    if (this.a.w != null) {
                        this.a.w.A();
                    }
                } else if (this.a.w != null) {
                    this.a.w.F();
                    this.a.w.G();
                    this.a.w.y(view2);
                }
                TiebaStatic.log(new StatisticItem("c13269").param("uid", this.a.D).param("fid", this.a.y).param("tid", this.a.z));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
                    this.a.u.Z();
                } else if (this.a.u2() == 1) {
                } else {
                    this.a.u.a0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.s != null && this.a.p < this.a.s.size()) {
                    this.a.v.g(i, (String) this.a.s.get(this.a.p));
                }
                boolean z3 = true;
                if (i == 1 && this.a.H != null) {
                    if ((this.a.p == 0 || this.a.H.w(this.a.p)) && !t17.m().v(t17.r()) && this.a.H.A(this.a.p)) {
                        this.a.i.setUrlData(this.a.s);
                        if (this.a.A0) {
                            if (this.a.w0 != null && this.a.w0.j()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ImageViewerActivity imageViewerActivity = this.a;
                            if (imageViewerActivity.H != null && this.a.H.u()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            imageViewerActivity.A0 = z2;
                            ImageViewerActivity imageViewerActivity2 = this.a;
                            imageViewerActivity2.K2((z || imageViewerActivity2.A0) ? false : false);
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
                if (i > this.a.L) {
                    this.a.L = i;
                } else if (i < this.a.L) {
                    this.a.L = i;
                    if (this.a.i != null) {
                        dragImageView = this.a.i.getCurrentView();
                    } else {
                        dragImageView = null;
                    }
                    if (dragImageView != null) {
                        z = dragImageView.d0();
                    } else {
                        z = false;
                    }
                    if (this.a.u2() == 1 && z) {
                        this.a.setSwipeBackEnabled(true);
                    } else {
                        this.a.setSwipeBackEnabled(false);
                    }
                    this.a.p2();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.u != null && i > this.a.i.getItemNum() - 5) {
                    this.a.u.Z();
                }
                this.a.v.c(this.a.s, this.a.p, i);
                this.a.p = i;
                this.a.Z2();
                this.a.d3();
                this.a.Y2(i);
                if (this.a.v.a() < this.a.p) {
                    this.a.v.j(this.a.p);
                }
                if (this.a.v.b() > this.a.p) {
                    this.a.v.k(this.a.p);
                }
                if (this.a.H != null) {
                    boolean z = true;
                    this.a.H.D((this.a.u == null || this.a.u.c0() != 1) ? false : false);
                    this.a.H.z(i);
                    if (this.a.n2() && this.a.I && this.a.H.x(i)) {
                        this.a.H.B(null);
                    }
                }
                if (this.a.w0 != null) {
                    this.a.w0.m(i);
                }
                if (this.a.w != null) {
                    this.a.w.D();
                }
                if (this.a.m != null && this.a.i.getCurrentUrlDragImageView() != null) {
                    this.a.m.q(this.a.i.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
                }
                if (!this.a.z0) {
                    this.a.z2();
                }
                if (this.a.o2()) {
                    StatisticItem statisticItem = new StatisticItem("c15006");
                    po7.b(statisticItem, this.a.y, this.a.B, TbadkCoreApplication.getCurrentAccount(), this.a.z);
                    TiebaStatic.log(statisticItem);
                    this.a.b3();
                    return;
                }
                if (this.a.b != null) {
                    this.a.b.setVisibility(8);
                }
                this.a.c.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BdUniDispatchSchemeController.SCHEME + "://" + BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_TIEBA_YY_ROOM + "?" + BdUniDispatchSchemeController.PARAM_YY_URL + "=" + encodeToString)));
            } else if (alaInfo.isChushou) {
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BdUniDispatchSchemeController.SCHEME + "://" + BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_CHUSHOU_ALA_ROOM + "?" + BdUniDispatchSchemeController.PARAM_CHUSHOU_THIRD_LIVE_TYPE + "=" + alaInfo.thirdLiveType + "&" + BdUniDispatchSchemeController.PARAM_CHUSHOU_ROOM_ID + "=" + alaInfo.thirdRoomId)));
            }
            po7.d(this.a.y, this.a.B, this.a.z, alaInfo);
        }
    }

    /* loaded from: classes5.dex */
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
                NavigationBar navigationBar = this.a.a;
                if (booleanValue) {
                    i = 0;
                } else {
                    i = 8;
                }
                navigationBar.setVisibility(i);
                this.a.p2();
                if (booleanValue) {
                    this.a.W2();
                    return;
                }
                this.a.B0.e();
                this.a.V2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends lf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity b;

        @Override // com.baidu.tieba.lf5
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

        @Override // com.baidu.tieba.lf5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return of5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yw8) && this.a.t != null && (agreeData = ((yw8) customResponsedMessage.getData()).b) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : this.a.t.values()) {
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

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yw8) && this.a.t != null && (agreeData = ((yw8) customResponsedMessage.getData()).b) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
                for (ImageUrlData imageUrlData : this.a.t.values()) {
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

    /* loaded from: classes5.dex */
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
            k65 k65Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k65) && (k65Var = (k65) customResponsedMessage.getData()) != null && !StringUtils.isNull(k65Var.a)) {
                ck5.h(k65Var);
                if (StringUtils.isNull(k65Var.c)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{k65Var.a});
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{k65Var.a, k65Var.c});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.R2(imageViewerActivity.c, 8);
                ImageViewerActivity imageViewerActivity2 = this.a;
                imageViewerActivity2.R2(imageViewerActivity2.d, 8);
                ImageViewerActivity imageViewerActivity3 = this.a;
                imageViewerActivity3.R2(imageViewerActivity3.o, 8);
                ImageViewerActivity imageViewerActivity4 = this.a;
                imageViewerActivity4.R2(imageViewerActivity4.e, 8);
                this.a.V2();
                if (this.a.i != null) {
                    this.a.i.B(false);
                }
                this.a.q2();
                this.a.p2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.i.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.i.getCurrentMaxIndex()));
                this.a.s2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.R2(imageViewerActivity.c, 0);
                this.a.o.setVisibility(0);
                if (this.a.i == null || this.a.n2()) {
                    return;
                }
                boolean u = this.a.i.u();
                if (!"portrait".equals(this.a.C) && !u) {
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.R2(imageViewerActivity2.d, 0);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.R2(imageViewerActivity3.e, 0);
                    this.a.W2();
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.S2(imageViewerActivity4.h);
                    if (this.a.a0) {
                        this.a.i.B(true);
                    } else {
                        this.a.i.B(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.a.z).param("obj_type", this.a.C));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.r2();
        }
    }

    /* loaded from: classes5.dex */
    public class u implements io7.b {
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

        @Override // com.baidu.tieba.io7.b
        public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            boolean z4;
            boolean z5;
            boolean z6;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) != null) || this.a.i == null) {
                return;
            }
            boolean z7 = true;
            if (this.a.O) {
                if (!z3) {
                    this.a.i.removeAllViews();
                    this.a.p = 0;
                    this.a.J2();
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.T = !imageViewerActivity.T;
                } else if (!this.a.T) {
                    this.a.showToast(R.string.image_view_change_img_error);
                }
            }
            this.a.O = false;
            if (this.a.d != null) {
                this.a.d.setEnabled(true);
            }
            this.a.hideProgressBar();
            if (z2 && this.a.i.getCurrentItem() <= 4) {
                int itemNum = this.a.i.getItemNum();
                this.a.i.setTempSize(itemNum + 100);
                this.a.i.setCurrentItem(itemNum + 90, false);
                this.a.i.setTempSize(0);
            }
            this.a.i.setAssistUrls(this.a.t);
            this.a.i.setHasNext(z);
            this.a.i.setNextTitle(str);
            if (i >= 0 && i < this.a.i.getItemNum()) {
                this.a.i.setCurrentItem(i, false);
            } else {
                this.a.i.v(this.a.i.getCurrentItem());
            }
            if (i2 != 0) {
                this.a.q = i2;
            }
            if (arrayList != null && arrayList.size() >= 400 && this.a.i.getCurrentItem() > 200) {
                for (int i3 = 0; i3 < 200; i3++) {
                    arrayList.remove(0);
                }
                this.a.i.setUrlData(arrayList);
                this.a.i.setCurrentItem(this.a.i.getCurrentItem() - 200, false);
            }
            if (this.a.u2() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (this.a.I && this.a.H != null) {
                vo7 vo7Var = this.a.H;
                if (this.a.u.c0() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                vo7Var.D(z6);
                if (this.a.z0 || this.a.H.v(this.a.v2())) {
                    this.a.H.C(this.a.u2(), this.a.q);
                    this.a.H.s(this.a.T);
                    this.a.i.setUrlData(this.a.s);
                }
            } else if (this.a.w0 != null) {
                this.a.w0.o(this.a.u2(), this.a.q);
                this.a.w0.l();
                c(arrayList, advertAppInfo);
            }
            if (this.a.w0 != null && this.a.w0.j()) {
                z4 = true;
            } else {
                z4 = false;
            }
            ImageViewerActivity imageViewerActivity2 = this.a;
            if (imageViewerActivity2.H != null && this.a.H.u()) {
                z5 = true;
            } else {
                z5 = false;
            }
            imageViewerActivity2.A0 = z5;
            ImageViewerActivity imageViewerActivity3 = this.a;
            imageViewerActivity3.K2((z4 || imageViewerActivity3.A0) ? false : false);
            this.a.i.setUrlData(arrayList);
            this.a.Z2();
            if (this.a.m != null && this.a.i.getCurrentUrlDragImageView() != null) {
                this.a.m.q(this.a.i.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
            }
            if (!this.a.z0) {
                return;
            }
            this.a.z0 = false;
            this.a.z2();
        }

        @Override // com.baidu.tieba.io7.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.O = false;
                if (this.a.d != null) {
                    if (this.a.d.getState() != this.a.T && TextUtils.isEmpty(str)) {
                        this.a.showToast(R.string.image_view_change_img_error);
                    }
                    this.a.d.w(this.a.T ? 1 : 0);
                    this.a.d.setEnabled(true);
                }
                this.a.hideProgressBar();
                this.a.showToast(str);
                if (i == 40) {
                    if (this.a.s != null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.q = imageViewerActivity.s.size();
                    }
                    this.a.Z2();
                }
                if (this.a.z0) {
                    this.a.z0 = false;
                    this.a.z2();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.w0 != null && advertAppInfo != null && arrayList != null) {
                    int m = advertAppInfo.m();
                    if (m != 0) {
                        this.a.N2(advertAppInfo, m);
                        return;
                    } else {
                        this.a.w0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.O2(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements xm8 {
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

        @Override // com.baidu.tieba.xm8
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.a.i.setUrlData(this.a.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements ac5.a {
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

        @Override // com.baidu.tieba.ac5.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.a.P2();
                } else {
                    this.a.Q2();
                }
            }
        }

        @Override // com.baidu.tieba.ac5.a
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    this.a.Q2();
                } else if (z2) {
                    this.a.P2();
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
        this.g = false;
        this.p = -1;
        this.q = -1;
        if (!UbsABTestHelper.isPicPageFunAdSdkTest() && !UbsABTestHelper.isPicPageFunAdInsert()) {
            z = false;
        } else {
            z = true;
        }
        this.I = z;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.P = false;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = true;
        this.Z = false;
        this.a0 = true;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = true;
        this.z0 = true;
        this.A0 = false;
        this.B0 = zb5.a();
        this.C0 = new ji0();
        this.D0 = new k(this, 2016496);
        this.E0 = new p(this, 2016493);
        this.F0 = new q(this);
        this.H0 = new r(this);
        this.I0 = new s(this);
        this.J0 = new c(this);
        this.K0 = new e(this);
        this.M0 = new f(this);
        this.N0 = new g(this);
        this.O0 = new h(this);
        this.P0 = new i(this);
        this.Q0 = new j(this);
        this.R0 = new n(this, 2016528);
        this.S0 = new o(this, 2016530);
    }

    public final void D2() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.V && !this.U && !this.c0) {
            View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.x0 = addCustomView;
            if (this.d0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            addCustomView.setVisibility(i2);
            if (!UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShow()) {
                AlaLiveTipView alaLiveTipView = (AlaLiveTipView) this.x0.findViewById(R.id.pic_ala_live_tip_view);
                this.e = alaLiveTipView;
                alaLiveTipView.setViewLocate(2);
                this.e.setForumInfo(this.y, this.B, this.z);
                this.e.setNormalBottomMarginParams(zi.g(getPageContext().getPageActivity(), R.dimen.tbds5));
            }
            if (this.S) {
                ArrayList arrayList = new ArrayList(2);
                kx8 kx8Var = new kx8();
                kx8Var.c(0);
                kx8Var.d(getString(R.string.obfuscated_res_0x7f0f0272));
                arrayList.add(kx8Var);
                kx8 kx8Var2 = new kx8();
                kx8Var2.c(1);
                kx8Var2.d(getString(R.string.host_name));
                arrayList.add(kx8Var2);
                SortSwitchButton sortSwitchButton = (SortSwitchButton) this.x0.findViewById(R.id.host_all_switch_btn);
                this.d = sortSwitchButton;
                sortSwitchButton.setNeedDayNight(false);
                this.d.setData(arrayList, this.T ? 1 : 0);
                this.d.setVisibility(0);
                this.d.setOnSwitchChangeListener(this.J0);
                R2(this.e, 0);
                return;
            }
            R2(this.d, 8);
            R2(this.e, 8);
        }
    }

    public final void Z2() {
        String str;
        int i2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.s != null) {
            long u2 = u2();
            String str2 = ("" + u2) + "/";
            if (this.q > 0) {
                str = str2 + this.q;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.C != null && !this.P && u2() == this.q && (this.C.equals("frs") || this.C.equals("index"))) {
                TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.C));
                this.P = true;
            }
            if (n2()) {
                long j2 = -1;
                String str3 = (String) ListUtils.getItem(this.s, this.p - 1);
                if (!StringUtils.isNull(str3) && (imageUrlData = this.t.get(str3)) != null) {
                    j2 = imageUrlData.overAllIndex;
                }
                a3(j2, this.q);
            } else if (o2()) {
                b3();
            } else {
                c3(str);
            }
            long j3 = u2 - 1;
            if (j3 > 0) {
                i2 = (int) j3;
            } else {
                i2 = 0;
            }
            X2(i2);
        }
    }

    public void O2(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && (multiImageView = this.i) != null) {
            multiImageView.setAddSize(i2);
        }
    }

    public final void S2(@NonNull String str) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || (alaLiveTipView = this.e) == null) {
            return;
        }
        if (!this.S) {
            alaLiveTipView.setVisibility(8);
        }
        this.e.post(new l(this, str));
    }

    public final void c3(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.c.setText(str);
            if (this.S && !this.U && (sortSwitchButton = this.d) != null) {
                sortSwitchButton.w(this.T ? 1 : 0);
            }
            cx4.d(this.c).y(R.array.S_O_X001);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, motionEvent)) == null) {
            this.C0.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.i.setBackgroundColor(-16777216);
            this.i.z(i2);
            this.M = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            qo7 qo7Var = this.w;
            if (qo7Var != null) {
                qo7Var.z();
            }
            to7 to7Var = this.m;
            if (to7Var != null) {
                to7Var.m(this.q0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.i.setCurrentItem(this.p, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                r2();
            }
        }
    }

    public final void x2(AlaInfoData alaInfoData) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048643, this, alaInfoData) == null) && alaInfoData != null && alaInfoData.user_info != null && (alaLiveTipView = this.e) != null) {
            alaLiveTipView.setOnClickListener(this.Q0);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                S2(alaInfoData.tag);
            }
        }
    }

    public final void y2(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048644, this, z) == null) && this.g != z) {
            AlaLiveTipView alaLiveTipView = this.e;
            if (alaLiveTipView != null) {
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                alaLiveTipView.setVisibility(i2);
            }
            this.g = z;
        }
    }

    public final void R2(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, view2, i2) == null) && view2 != null) {
            view2.clearAnimation();
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048625, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.p);
                setResult(-1, intent);
                s2();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048620, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.m.l(i2, i3, intent);
        }
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.o = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new b(this));
            this.k = (ImageView) this.o.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.o.setVisibility(0);
        }
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShow() && this.S) {
            bk5.a(getSupportFragmentManager(), R.id.second_floor_container, this.B0.f("big_pic"));
            this.B0.d(new w(this));
            ll5 g2 = ll5.g(this);
            g2.k(R.id.second_floor_container, R.id.navigation_bar);
            g2.i(new a(this));
            g2.f();
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.r = findViewById(R.id.pic_top_obscuration_view);
            Q2();
            F2();
            G2();
            this.w = new qo7(this);
            J2();
            this.w.x(this.i);
            Z2();
            T2();
            H2();
            C2();
            oo7 oo7Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.p;
            oo7Var.c(arrayList, i2, i2);
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.c.setVisibility(8);
            if (this.b == null) {
                TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f06ad));
                this.b = centerTextTitle;
                centerTextTitle.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            }
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            R2(this.d, 8);
            R2(this.e, 8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            this.i.y();
            this.mIsLogin = yc5.k();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = yg.g(this.z, 0L);
            if (uniqueId != null && g2 > 0) {
                dn4.j(om4.d0, uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.m.p();
        }
    }

    public final void B2(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String str3;
        String a2;
        Map<String, ImageUrlData> map;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.v = new oo7();
            boolean k2 = yc5.k();
            String b2 = yc5.b();
            String f2 = yc5.f();
            String e2 = yc5.e();
            e3();
            if (bundle != null) {
                this.V = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                ArrayList<String> c2 = mo7.d().c();
                if (!ListUtils.isEmpty(c2)) {
                    this.s = new ArrayList<>(c2);
                }
                this.p = bundle.getInt("index", -1);
                this.y = bundle.getString("fid");
                this.z = bundle.getString("tid");
                this.A = bundle.getString("nid");
                this.B = bundle.getString("fname");
                this.E = bundle.getString("post_id");
                this.F = bundle.getString(IntentConfig.BJH_POST_ID);
                this.Z = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
                this.Y = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
                this.Q = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
                this.D = bundle.getString("user_id");
                this.C = bundle.getString("from");
                this.R = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
                this.S = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
                this.h0 = bundle.getInt("thread_type");
                this.T = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
                Map<String, String> b3 = mo7.d().b();
                this.i0 = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.X = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
                boolean z2 = bundle.getBoolean("is_login");
                String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
                String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
                String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
                this.a0 = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.b0 = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                if (b3 instanceof Map) {
                    this.t = new ConcurrentHashMap();
                    for (Map.Entry<String, String> entry : b3.entrySet()) {
                        if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                            try {
                                this.t.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr(entry.getValue(), ImageUrlData.class));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
                this.W = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.U = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
                this.r0 = bundle.getInt("card_type", 0);
                this.s0 = bundle.getString("recom_source");
                this.t0 = bundle.getString("ab_tag");
                this.u0 = bundle.getString("weight");
                this.v0 = bundle.getString("extra");
                this.j0 = bundle.getString("from_forum_id");
                this.q0 = bundle.getInt("skin_type");
                this.c0 = bundle.getBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                Serializable serializable = bundle.getSerializable(ImageViewerConfig.REMIND_LIVE_DATA);
                if (serializable instanceof LiveRemindData) {
                    this.f0 = (LiveRemindData) serializable;
                }
                this.g0 = bundle.getInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY);
                this.e0 = bundle.getBoolean(ImageViewerConfig.NEED_REQUEST_AD, true);
                Serializable serializable2 = bundle.getSerializable(ImageViewerConfig.KEY_PROFILE_VIRTUAL_IMAGE_INFO);
                if (serializable2 instanceof ProfileVirtualImageInfo) {
                    ProfileVirtualImageInfo.getInstance().parseRemoteInfo((ProfileVirtualImageInfo) serializable2);
                }
                mo7.d().a();
                z = z2;
                str = string;
                str2 = string2;
                str3 = string3;
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    this.V = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                    this.s = intent.getStringArrayListExtra("url");
                    this.p = intent.getIntExtra("index", -1);
                    this.y = intent.getStringExtra("fid");
                    this.z = intent.getStringExtra("tid");
                    this.A = intent.getStringExtra("nid");
                    this.B = intent.getStringExtra("fname");
                    this.E = intent.getStringExtra("post_id");
                    this.F = intent.getStringExtra(IntentConfig.BJH_POST_ID);
                    this.Z = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                    this.Y = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                    this.Q = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                    this.D = intent.getStringExtra("user_id");
                    this.C = intent.getStringExtra("from");
                    this.R = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                    this.S = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                    this.T = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                    this.h0 = intent.getIntExtra("thread_type", 0);
                    this.a0 = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                    this.b0 = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                    this.W = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                    this.U = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                    z = intent.getBooleanExtra("is_login", false);
                    String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                    str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                    String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                    this.i0 = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                    this.X = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                    Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                    if (serializableExtra instanceof Map) {
                        this.t = (Map) serializableExtra;
                    }
                    this.r0 = intent.getIntExtra("card_type", 0);
                    this.s0 = intent.getStringExtra("recom_source");
                    this.t0 = intent.getStringExtra("ab_tag");
                    this.u0 = intent.getStringExtra("weight");
                    this.v0 = intent.getStringExtra("extra");
                    this.j0 = intent.getStringExtra("from_forum_id");
                    this.q0 = intent.getIntExtra("skin_type", 0);
                    this.c0 = intent.getBooleanExtra(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                    this.e0 = intent.getBooleanExtra(ImageViewerConfig.NEED_REQUEST_AD, true);
                    Serializable serializableExtra2 = intent.getSerializableExtra(ImageViewerConfig.REMIND_LIVE_DATA);
                    if (serializableExtra2 instanceof LiveRemindData) {
                        this.f0 = (LiveRemindData) serializableExtra2;
                    }
                    this.g0 = intent.getIntExtra(ImageViewerConfig.REMIND_LIVE_FREQUENCY, 0);
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
            yc5.o(z);
            yc5.n(str);
            yc5.p(str3);
            yc5.q(str2);
            this.v.f(bundle, getIntent());
            this.q = ListUtils.getCount(this.s);
            if (this.i0 != null) {
                String str4 = (String) ListUtils.getItem(this.s, this.p);
                if (!StringUtils.isNull(str4) && (map = this.t) != null && (imageUrlData = map.get(str4)) != null) {
                    imageUrlData.setSourceImageRectInScreen(this.i0);
                }
            }
            if (this.V) {
                a2 = null;
            } else {
                a2 = ho7.a((String) ListUtils.getItem(this.s, this.p));
            }
            this.N = a2;
            if (this.T) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            py4.a().d(this.f0);
            qy4.b().n(this.g0);
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
            to7 to7Var = new to7(getPageContext(), this.l);
            this.m = to7Var;
            to7Var.r(this.j0);
            this.m.s(this.q0);
            this.m.m(this.q0);
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.j = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.j.setLayoutParams(layoutParams);
            this.j.setVisibility(0);
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.I && n2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void d3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            boolean z = false;
            if (n2()) {
                if (this.a.getVisibility() == 0) {
                    z = true;
                }
                this.K = z;
                this.J = true;
            } else if (this.J) {
                NavigationBar navigationBar = this.a;
                if (this.K) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                navigationBar.setVisibility(i2);
                this.J = false;
            }
            M2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public nf5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            nf5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(yg.g(this.y, 0L));
                pageStayDurationItem.C(yg.g(this.z, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (nf5) invokeV.objValue;
    }

    public final boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!this.Q) {
                return false;
            }
            yo7 yo7Var = this.w0;
            if (yo7Var != null && yo7Var.h(this.p)) {
                return true;
            }
            vo7 vo7Var = this.H;
            if (vo7Var == null || !vo7Var.t(this.p)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            this.i.x();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = yg.g(this.z, 0L);
            if (uniqueId != null && g2 > 0) {
                dn4.f(uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            this.m.o();
        }
    }

    public final long u2() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            String str = (String) ListUtils.getItem(this.s, this.p);
            Map<String, ImageUrlData> map = this.t;
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
                return this.p + 1;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public final void z2() {
        ImageUrlData imageUrlData;
        oo7 oo7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            String str = (String) ListUtils.getItem(this.s, this.p);
            Map<String, ImageUrlData> map = this.t;
            if (map != null && str != null && (imageUrlData = map.get(str)) != null && (oo7Var = this.v) != null) {
                String str2 = this.z;
                String str3 = this.C;
                int i2 = this.p;
                oo7Var.e(str2, str3, i2, this.q - i2, imageUrlData.mHeigth, imageUrlData.mWidth, this.G);
            }
        }
    }

    public final void E2(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            io7 io7Var = new io7(this.s, this.t, this.y, this.B, this.z, this.A, str, this.D, this.C, this.h0, z2, this.r0, this.s0, this.t0, this.u0, this.v0);
            this.u = io7Var;
            io7Var.m0(this.i0);
            this.u.k0(this.Y);
            this.u.l0(z);
            this.u.e0(this.N);
            this.u.h0(this.X);
            this.u.j0(this.E);
            this.u.d0(this.F);
            this.u.g0(this.b0);
            this.u.i0(new u(this));
            this.u.f0(true);
            if (this.e0) {
                this.w0.n(new v(this));
            }
            this.u.Z();
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.a.setClickable(false);
            A2();
            D2();
            TextView textView = new TextView(this);
            this.c = textView;
            textView.setPadding(zi.g(this, R.dimen.tbds15), 0, 0, 0);
            this.c.setGravity(17);
            this.c.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.c.setTextSize(0, zi.g(this, R.dimen.tbds44));
            cx4.d(this.c).y(R.array.S_O_X001);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.c, (View.OnClickListener) null);
            if (ho7.b((String) ListUtils.getItem(this.s, this.p))) {
                this.a.setVisibility(0);
            }
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && !this.U && this.d != null) {
            if (this.x == null) {
                pa6 pa6Var = new pa6(getPageContext(), this.d);
                this.x = pa6Var;
                pa6Var.L(R.drawable.pic_sign_tip);
                this.x.o(48);
                this.x.N(true);
                this.x.n(5000);
                this.x.Q(-zi.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.x.m(new d(this));
            }
            this.x.T(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    @Override // com.baidu.tieba.ii0
    @NonNull
    public ji0 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.C0;
        }
        return (ji0) invokeV.objValue;
    }

    public boolean L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.V;
        }
        return invokeV.booleanValue;
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.r.setBackgroundColor(-16777216);
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            cx4.d(this.r).p(new int[]{R.color.CAM_X0608, R.color.CAM_X0601}, Direction.TOP);
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.i.t()) {
            this.B0.c();
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.B0.hide();
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.i.t()) {
            this.B0.show();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (yj5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    public final void e3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (intent = getIntent()) != null) {
            nj5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (yi.isEmpty(this.z)) {
                return 0L;
            }
            return yg.g(this.z, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.kf5
    public lf5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return new m(this);
        }
        return (lf5) invokeV.objValue;
    }

    public int m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            int count = ListUtils.getCount(this.s);
            if (count > 0) {
                int i2 = this.p;
                if (i2 >= count) {
                    this.p = count - 1;
                } else if (i2 < 0) {
                    this.p = 0;
                }
            } else {
                this.p = 0;
            }
            return this.p;
        }
        return invokeV.intValue;
    }

    public final boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.y0 == null) {
                return false;
            }
            String str = (String) ListUtils.getItem(this.s, this.p);
            if (StringUtils.isNull(str)) {
                return false;
            }
            return str.startsWith("####mLiveRoomPageProvider");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public final void p2() {
        pa6 pa6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (pa6Var = this.f) != null) {
            pa6Var.h();
        }
    }

    public final void q2() {
        pa6 pa6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (pa6Var = this.x) != null) {
            pa6Var.h();
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            getWindow().getDecorView().setSystemUiVisibility(1284);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.i.w();
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            getWindow().addFlags(1024);
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.n == null) {
                this.n = VoiceManager.instance();
            }
            return this.n;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public Map<String, ImageUrlData> t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.t;
        }
        return (Map) invokeV.objValue;
    }

    public final int v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return (int) u2();
        }
        return invokeV.intValue;
    }

    public String w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.D;
        }
        return (String) invokeV.objValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MultiImageView multiImageView = this.i;
            if (multiImageView == null) {
                this.i = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f0926cc);
            } else {
                multiImageView.q();
            }
            this.G = this.z + "_" + System.currentTimeMillis();
            this.i.setIsFromCDN(this.Z);
            this.i.setIsCanDrag(this.R);
            this.i.setPageMargin(zi.d(getPageContext().getPageActivity(), 8.0f));
            this.i.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.i.setOnPageChangeListener(this.P0);
            this.i.setUrlData(this.s);
            this.i.setAssistUrls(this.t);
            this.i.setOuterOnTouchListener(this.M0);
            this.i.setItemOnclickListener(this.K0);
            this.i.setItemOnLongClickListener(this.N0);
            this.i.setCurrentItem(m2(), false);
            this.i.setOnScrollOutListener(this.O0);
            if (this.y0 == null) {
                xo7 xo7Var = new xo7(this.s, getPageContext(), this.y, this.B, this.z);
                this.y0 = xo7Var;
                xo7Var.i(this.a.getFixedNavHeight());
            }
            this.i.k(this.y0);
            if (this.I && this.e0) {
                if (this.H == null) {
                    this.H = new vo7(this.s, this.y, this.z, this.Q, this.p, getPageContext());
                }
                this.H.B(null);
                this.i.k(this.H);
            }
            if (this.w0 == null) {
                this.w0 = new yo7(this.s, this.y, this.B, this.Z, this.Q, getPageContext(), this.F0, this.t);
            }
            this.i.k(this.w0);
            this.i.setOriImgSelectedCallback(this.I0);
            this.i.setDragToExitListener(this.F0);
            this.i.setUserId(this.D);
            this.i.setShowBottomContainer(this.a0);
            this.i.setOnShareImageListener(this.w);
            this.i.setOnDownloadImageListener(this.w);
            this.i.setOnReplyClickListener(this.H0);
            this.i.setYoungterCoverSomeView(this.d0);
            oo7 oo7Var = this.v;
            if (oo7Var != null) {
                oo7Var.d(this.D, this.z, this.C);
            }
        }
    }

    public final void K2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || this.y0 == null) {
            return;
        }
        if (!ListUtils.isEmpty(this.u.Y()) && z) {
            this.y0.k(this.u.Y());
            this.y0.j(true);
            ArrayList<String> arrayList = this.s;
            if (arrayList != null && !arrayList.contains("####mLiveRoomPageProvider")) {
                ArrayList<String> arrayList2 = this.s;
                uq7.b(arrayList2, "####mLiveRoomPageProvider", arrayList2.size());
                return;
            }
            return;
        }
        this.y0.k(null);
        this.y0.j(false);
    }

    public final void Y2(int i2) {
        MultiImageView multiImageView;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048601, this, i2) != null) || (multiImageView = this.i) == null) {
            return;
        }
        multiImageView.l(i2);
        if (!this.i.u() && !n2() && !o2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        R2(this.d, i3);
        if (this.S) {
            R2(this.e, i3);
        }
        if (i3 == 0) {
            W2();
        } else {
            V2();
        }
    }

    public final void N2(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            e11.b(clogBuilder);
        }
    }

    public final void X2(int i2) {
        io7 io7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && (io7Var = this.u) != null) {
            ArrayList<AlaInfoData> W = io7Var.W();
            if (W != null && W.size() > 0) {
                y2(true);
                x2(W.get(i2 % W.size()));
                return;
            }
            y2(false);
        }
    }

    public final void a3(long j2, int i2) {
        vo7 vo7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            yo7 yo7Var = this.w0;
            if ((yo7Var != null && yo7Var.j()) || ((vo7Var = this.H) != null && vo7Var.u())) {
                this.c.setText("");
            } else if (j2 > 0) {
                this.c.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.c.setText("");
            }
            R2(this.d, 8);
            R2(this.e, 8);
            V2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 28 && TbSingleton.getInstance().isNotchScreen(this)) {
                setUseStyleImmersiveSticky(false);
            }
            super.onCreate(bundle);
            r2();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new t(this));
            ad5.f().g(TbadkCoreApplication.getInst());
            ad5.i(new ImageFpsEvent());
            this.M = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            B2(bundle);
            setContentView(R.layout.image_activity_big_img);
            I2();
            E2(this.N, this.T, false);
            registerListener(this.E0);
            registerListener(this.D0);
            registerListener(this.R0);
            registerListener(this.S0);
            addGlobalLayoutListener();
            VoiceManager t0 = t0();
            this.n = t0;
            t0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                u49.b(1, getWindow().getAttributes(), getWindow());
            }
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
                TbSingleton.getInstance().setHasDownloadEmotion(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.E0);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            ba5.k().r();
            oo7 oo7Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.p;
            oo7Var.c(arrayList, i2, i2);
            this.v.i();
            io7 io7Var = this.u;
            if (io7Var != null) {
                String X = io7Var.X();
                str2 = this.u.b0();
                str = X;
            } else {
                str = null;
                str2 = null;
            }
            this.v.l(this.i.getPageCount(), "", this.y, this.z, str, str2);
            qo7 qo7Var = this.w;
            if (qo7Var != null) {
                qo7Var.C();
            }
            this.i.w();
            this.m.n();
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            v65.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.M);
            q2();
            p2();
            yo7 yo7Var = this.w0;
            if (yo7Var != null) {
                yo7Var.k();
            }
            vo7 vo7Var = this.H;
            if (vo7Var != null) {
                vo7Var.y();
            }
            ad5.i(new PrePageKeyEvent(getCurrentPageKey()));
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2001277);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(ImageViewerConfig.IS_BJH, this.V);
            mo7.d().f(this.s);
            bundle.putInt("index", this.p);
            bundle.putString("fid", this.y);
            bundle.putString("tid", this.z);
            bundle.putString("fname", this.B);
            bundle.putString("post_id", this.E);
            bundle.putString(IntentConfig.BJH_POST_ID, this.F);
            bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.Y);
            bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.R);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.S);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.Q);
            bundle.putString("user_id", this.D);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.a0);
            bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.b0);
            Map<String, ImageUrlData> map = this.t;
            if (map instanceof HashMap) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, ImageUrlData> entry : this.t.entrySet()) {
                    if (entry != null && (entry.getValue() instanceof ImageUrlData) && (entry.getKey() instanceof String)) {
                        try {
                            hashMap.put(entry.getKey(), OrmObject.jsonStrWithObject(entry.getValue()));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                mo7.d().e(hashMap);
            } else if (map instanceof ConcurrentHashMap) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (Map.Entry<String, ImageUrlData> entry2 : this.t.entrySet()) {
                    if (entry2 != null && (entry2.getValue() instanceof ImageUrlData) && (entry2.getKey() instanceof String)) {
                        try {
                            concurrentHashMap.put(entry2.getKey(), OrmObject.jsonStrWithObject(entry2.getValue()));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                mo7.d().e(concurrentHashMap);
            }
            bundle.putString("from", this.C);
            bundle.putInt("thread_type", this.h0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.T);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.i0);
            bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.W);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.U);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.X);
            bundle.putBoolean("is_login", yc5.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, yc5.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, yc5.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, yc5.f());
            bundle.putString("from_forum_id", this.j0);
            bundle.putInt("skin_type", this.q0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.c0);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.d0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.e0);
            bundle.putSerializable(ImageViewerConfig.REMIND_LIVE_DATA, this.f0);
            bundle.putInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY, this.g0);
            this.v.h(bundle);
        }
    }
}
