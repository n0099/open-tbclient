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
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.a29;
import com.baidu.tieba.ap7;
import com.baidu.tieba.bf6;
import com.baidu.tieba.br4;
import com.baidu.tieba.c35;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cp7;
import com.baidu.tieba.d35;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.dp7;
import com.baidu.tieba.e67;
import com.baidu.tieba.ej;
import com.baidu.tieba.g67;
import com.baidu.tieba.hb5;
import com.baidu.tieba.jh5;
import com.baidu.tieba.jo5;
import com.baidu.tieba.kg5;
import com.baidu.tieba.lg5;
import com.baidu.tieba.lh5;
import com.baidu.tieba.m29;
import com.baidu.tieba.mo5;
import com.baidu.tieba.mo7;
import com.baidu.tieba.mv7;
import com.baidu.tieba.n21;
import com.baidu.tieba.no5;
import com.baidu.tieba.no7;
import com.baidu.tieba.p15;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.qr4;
import com.baidu.tieba.ri0;
import com.baidu.tieba.ro7;
import com.baidu.tieba.si0;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.to7;
import com.baidu.tieba.uo7;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vo7;
import com.baidu.tieba.wa5;
import com.baidu.tieba.wj5;
import com.baidu.tieba.wp5;
import com.baidu.tieba.wr8;
import com.baidu.tieba.x99;
import com.baidu.tieba.y17;
import com.baidu.tieba.yj5;
import com.baidu.tieba.yn5;
import com.baidu.tieba.yo7;
import com.baidu.tieba.zj5;
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
/* loaded from: classes4.dex */
public class ImageViewerActivity extends BaseFragmentActivity implements VoiceManager.j, ri0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean A0;
    public String B;
    public boolean B0;
    public String C;
    public final lg5 C0;
    public String D;
    public final si0 D0;
    public String E;
    public CustomMessageListener E0;
    public String F;
    public final CustomMessageListener F0;
    public String G;
    public DragImageView.h G0;
    public ap7 H;
    public y17 H0;
    public final boolean I;
    public View.OnClickListener I0;
    public boolean J;
    public UrlDragImageView.p J0;
    public boolean K;
    public final SortSwitchButton.f K0;
    public int L;
    public View.OnClickListener L0;
    public int M;
    public float M0;
    public String N;
    public View.OnTouchListener N0;
    public boolean O;
    public View.OnLongClickListener O0;
    public boolean P;
    public BaseViewPager.a P0;
    public boolean Q;
    public ViewPager.OnPageChangeListener Q0;
    public boolean R;
    public View.OnClickListener R0;
    public boolean S;
    public CustomMessageListener S0;
    public boolean T;
    public CustomMessageListener T0;
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
    public bf6 f;
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
    public yo7 m;
    public VoiceManager n;
    public View o;
    public int p;
    public int q;
    public View r;
    public int r0;
    public ArrayList<String> s;
    public int s0;
    public Map<String, ImageUrlData> t;
    public String t0;
    public no7 u;
    public String u0;
    public to7 v;
    public String v0;
    public vo7 w;
    public String w0;
    public bf6 x;
    public dp7 x0;
    public String y;
    public View y0;
    public String z;
    public cp7 z0;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.vj5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageViewerActivity b;

        /* loaded from: classes4.dex */
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
                this.a.b.K2();
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
                    imageViewerActivity.f = new bf6(imageViewerActivity.getPageContext(), this.b.e);
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
                    this.b.K2();
                } else {
                    this.b.f.S(this.a);
                    this.b.h = null;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* loaded from: classes4.dex */
        public class a implements y17.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r a;

            @Override // com.baidu.tieba.y17.d
            public void a(boolean z, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                }
            }

            @Override // com.baidu.tieba.y17.d
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

            @Override // com.baidu.tieba.y17.d
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
                uo7.f(3, this.a.z, this.a.y);
                if (!jh5.a(this.a)) {
                    return;
                }
                if (this.a.H0 == null) {
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.H0 = new y17(imageViewerActivity.getPageContext());
                    this.a.H0.i(new a(this));
                }
                if (this.a.i != null && this.a.i.getCurrentUrlDragImageView() != null && this.a.i.getCurrentUrlDragImageView().getmAssistUrlData() != null) {
                    i = this.a.i.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost;
                } else {
                    i = 1;
                }
                this.a.H0.j(i ^ 1);
                this.a.H0.g(this.a.y, dh.g(this.a.z, 0L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements wp5.c {
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

        @Override // com.baidu.tieba.wp5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) {
                return;
            }
            this.a.p3();
        }
    }

    /* loaded from: classes4.dex */
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
                if (!this.a.I || !this.a.I2() || !g67.d(str) || !this.a.e0) {
                    this.a.N2();
                    return;
                }
                int currentItem = this.a.i.getCurrentItem();
                if (currentItem >= this.a.s.size() - 1) {
                    this.a.N2();
                } else {
                    this.a.s.remove(str);
                    this.a.i.setUrlData(this.a.s);
                    this.a.i.setCurrentItem(currentItem, true);
                }
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", "a008").eventStat();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d08);
                    return false;
                }
                this.a.O = true;
                if (this.a.d != null) {
                    this.a.d.setEnabled(false);
                }
                String a = mo7.a((String) ListUtils.getItem(this.a.s, this.a.p));
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.Z2(a, !imageViewerActivity.T, true);
                if (this.a.T) {
                    i2 = 7;
                } else {
                    i2 = 8;
                }
                uo7.f(i2, this.a.z, this.a.y);
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            this.a.L2();
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.N2();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                } else if (this.a.P2() == 1) {
                } else {
                    this.a.u.a0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    if ((this.a.p == 0 || this.a.H.w(this.a.p)) && !e67.m().v(e67.r()) && this.a.H.A(this.a.p)) {
                        this.a.i.setUrlData(this.a.s);
                        if (this.a.B0) {
                            if (this.a.x0 != null && this.a.x0.j()) {
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
                            imageViewerActivity.B0 = z2;
                            ImageViewerActivity imageViewerActivity2 = this.a;
                            imageViewerActivity2.f3((z || imageViewerActivity2.B0) ? false : false);
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
                    if (this.a.P2() == 1 && z) {
                        this.a.setSwipeBackEnabled(true);
                    } else {
                        this.a.setSwipeBackEnabled(false);
                    }
                    this.a.K2();
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
                this.a.u3();
                this.a.y3();
                this.a.t3(i);
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
                    if (this.a.I2() && this.a.I && this.a.H.x(i)) {
                        this.a.H.B(null);
                    }
                }
                if (this.a.x0 != null) {
                    this.a.x0.m(i);
                }
                if (this.a.w != null) {
                    this.a.w.D();
                }
                if (this.a.m != null && this.a.i.getCurrentUrlDragImageView() != null) {
                    this.a.m.q(this.a.i.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
                }
                if (!this.a.A0) {
                    this.a.U2();
                }
                if (this.a.J2()) {
                    StatisticItem statisticItem = new StatisticItem("c15006");
                    uo7.b(statisticItem, this.a.y, this.a.B, TbadkCoreApplication.getCurrentAccount(), this.a.z);
                    TiebaStatic.log(statisticItem);
                    this.a.w3();
                    return;
                }
                if (this.a.b != null) {
                    this.a.b.setVisibility(8);
                }
                this.a.c.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            uo7.d(this.a.y, this.a.B, this.a.z, alaInfo);
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.K2();
                if (booleanValue) {
                    this.a.r3();
                    return;
                }
                this.a.C0.e();
                this.a.q3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends wj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity b;

        @Override // com.baidu.tieba.wj5
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

        @Override // com.baidu.tieba.wj5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return zj5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a29) && this.a.t != null && (agreeData = ((a29) customResponsedMessage.getData()).b) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a29) && this.a.t != null && (agreeData = ((a29) customResponsedMessage.getData()).b) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
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

    /* loaded from: classes4.dex */
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
            wa5 wa5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof wa5) && (wa5Var = (wa5) customResponsedMessage.getData()) != null && !StringUtils.isNull(wa5Var.a)) {
                no5.h(wa5Var);
                if (StringUtils.isNull(wa5Var.c)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{wa5Var.a});
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{wa5Var.a, wa5Var.c});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                imageViewerActivity.m3(imageViewerActivity.c, 8);
                ImageViewerActivity imageViewerActivity2 = this.a;
                imageViewerActivity2.m3(imageViewerActivity2.d, 8);
                ImageViewerActivity imageViewerActivity3 = this.a;
                imageViewerActivity3.m3(imageViewerActivity3.o, 8);
                ImageViewerActivity imageViewerActivity4 = this.a;
                imageViewerActivity4.m3(imageViewerActivity4.e, 8);
                this.a.q3();
                if (this.a.i != null) {
                    this.a.i.B(false);
                }
                this.a.L2();
                this.a.K2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.i.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.i.getCurrentMaxIndex()));
                this.a.N2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.m3(imageViewerActivity.c, 0);
                this.a.o.setVisibility(0);
                if (this.a.i == null || this.a.I2()) {
                    return;
                }
                boolean u = this.a.i.u();
                if (!"portrait".equals(this.a.C) && !u) {
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.m3(imageViewerActivity2.d, 0);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.m3(imageViewerActivity3.e, 0);
                    this.a.r3();
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.n3(imageViewerActivity4.h);
                    if (this.a.a0) {
                        this.a.i.B(true);
                    } else {
                        this.a.i.B(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            this.a.M2();
        }
    }

    /* loaded from: classes4.dex */
    public class u implements no7.b {
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

        @Override // com.baidu.tieba.no7.b
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
                    this.a.e3();
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
            if (this.a.P2() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (this.a.I && this.a.H != null) {
                ap7 ap7Var = this.a.H;
                if (this.a.u.c0() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                ap7Var.D(z6);
                if (this.a.A0 || this.a.H.v(this.a.Q2())) {
                    this.a.H.C(this.a.P2(), this.a.q);
                    this.a.H.s(this.a.T);
                    this.a.i.setUrlData(this.a.s);
                }
            } else if (this.a.x0 != null) {
                this.a.x0.o(this.a.P2(), this.a.q);
                this.a.x0.l();
                c(arrayList, advertAppInfo);
            }
            if (this.a.x0 != null && this.a.x0.j()) {
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
            imageViewerActivity2.B0 = z5;
            ImageViewerActivity imageViewerActivity3 = this.a;
            imageViewerActivity3.f3((z4 || imageViewerActivity3.B0) ? false : false);
            this.a.i.setUrlData(arrayList);
            this.a.u3();
            if (this.a.m != null && this.a.i.getCurrentUrlDragImageView() != null) {
                this.a.m.q(this.a.i.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
            }
            if (!this.a.A0) {
                return;
            }
            this.a.A0 = false;
            this.a.U2();
        }

        @Override // com.baidu.tieba.no7.b
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
                    this.a.u3();
                }
                if (this.a.A0) {
                    this.a.A0 = false;
                    this.a.U2();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.x0 != null && advertAppInfo != null && arrayList != null) {
                    int m = advertAppInfo.m();
                    if (m != 0) {
                        this.a.i3(advertAppInfo, m);
                        return;
                    } else {
                        this.a.x0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.j3(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements wr8 {
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

        @Override // com.baidu.tieba.wr8
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.a.i.setUrlData(this.a.s);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements lg5.a {
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

        @Override // com.baidu.tieba.lg5.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.a.k3();
                } else {
                    this.a.l3();
                }
            }
        }

        @Override // com.baidu.tieba.lg5.a
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (!z) {
                    this.a.l3();
                } else if (z2) {
                    this.a.k3();
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
        this.A0 = true;
        this.B0 = false;
        this.C0 = kg5.a();
        this.D0 = new si0();
        this.E0 = new k(this, 2016496);
        this.F0 = new p(this, 2016493);
        this.G0 = new q(this);
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

    public final void Y2() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && !this.V && !this.U && !this.c0) {
            View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.y0 = addCustomView;
            if (this.d0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            addCustomView.setVisibility(i2);
            if (!UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShow()) {
                AlaLiveTipView alaLiveTipView = (AlaLiveTipView) this.y0.findViewById(R.id.pic_ala_live_tip_view);
                this.e = alaLiveTipView;
                alaLiveTipView.setViewLocate(2);
                this.e.setForumInfo(this.y, this.B, this.z);
                this.e.setNormalBottomMarginParams(ej.g(getPageContext().getPageActivity(), R.dimen.tbds5));
            }
            if (this.S) {
                ArrayList arrayList = new ArrayList(2);
                m29 m29Var = new m29();
                m29Var.c(0);
                m29Var.d(getString(R.string.obfuscated_res_0x7f0f0272));
                arrayList.add(m29Var);
                m29 m29Var2 = new m29();
                m29Var2.c(1);
                m29Var2.d(getString(R.string.host_name));
                arrayList.add(m29Var2);
                SortSwitchButton sortSwitchButton = (SortSwitchButton) this.y0.findViewById(R.id.host_all_switch_btn);
                this.d = sortSwitchButton;
                sortSwitchButton.setNeedDayNight(false);
                this.d.setData(arrayList, this.T ? 1 : 0);
                this.d.setVisibility(0);
                this.d.setOnSwitchChangeListener(this.K0);
                m3(this.e, 0);
                return;
            }
            m3(this.d, 8);
            m3(this.e, 8);
        }
    }

    public final void u3() {
        String str;
        int i2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.s != null) {
            long P2 = P2();
            String str2 = ("" + P2) + "/";
            if (this.q > 0) {
                str = str2 + this.q;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.C != null && !this.P && P2() == this.q && (this.C.equals("frs") || this.C.equals("index"))) {
                TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.C));
                this.P = true;
            }
            if (I2()) {
                long j2 = -1;
                String str3 = (String) ListUtils.getItem(this.s, this.p - 1);
                if (!StringUtils.isNull(str3) && (imageUrlData = this.t.get(str3)) != null) {
                    j2 = imageUrlData.overAllIndex;
                }
                v3(j2, this.q);
            } else if (J2()) {
                w3();
            } else {
                x3(str);
            }
            long j3 = P2 - 1;
            if (j3 > 0) {
                i2 = (int) j3;
            } else {
                i2 = 0;
            }
            s3(i2);
        }
    }

    public final void S2(AlaInfoData alaInfoData) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, alaInfoData) == null) && alaInfoData != null && alaInfoData.user_info != null && (alaLiveTipView = this.e) != null) {
            alaLiveTipView.setOnClickListener(this.R0);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                n3(alaInfoData.tag);
            }
        }
    }

    public final void T2(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            this.D0.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void j3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i2) == null) && (multiImageView = this.i) != null) {
            multiImageView.setAddSize(i2);
        }
    }

    public final void n3(@NonNull String str) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048618, this, str) != null) || (alaLiveTipView = this.e) == null) {
            return;
        }
        if (!this.S) {
            alaLiveTipView.setVisibility(8);
        }
        this.e.post(new l(this, str));
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.i.setBackgroundColor(-16777216);
            this.i.z(i2);
            this.M = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            vo7 vo7Var = this.w;
            if (vo7Var != null) {
                vo7Var.z();
            }
            yo7 yo7Var = this.m;
            if (yo7Var != null) {
                yo7Var.m(this.r0);
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
                M2();
            }
        }
    }

    public final void x3(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.c.setText(str);
            if (this.S && !this.U && (sortSwitchButton = this.d) != null) {
                sortSwitchButton.w(this.T ? 1 : 0);
            }
            p15.d(this.c).y(R.array.S_O_X001);
        }
    }

    public final void m3(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048617, this, view2, i2) == null) && view2 != null) {
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
                N2();
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

    public int H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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

    public final boolean J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.z0 == null) {
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

    public final void K2() {
        bf6 bf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bf6Var = this.f) != null) {
            bf6Var.h();
        }
    }

    public final void L2() {
        bf6 bf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bf6Var = this.x) != null) {
            bf6Var.h();
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getWindow().getDecorView().setSystemUiVisibility(1284);
        }
    }

    public final void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            getWindow().addFlags(1024);
            finish();
        }
    }

    public Map<String, ImageUrlData> O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.t;
        }
        return (Map) invokeV.objValue;
    }

    public final int Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (int) P2();
        }
        return invokeV.intValue;
    }

    public String R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.D;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (jo5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    @Override // com.baidu.tieba.ri0
    @NonNull
    public si0 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.D0;
        }
        return (si0) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    public boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.V;
        }
        return invokeV.booleanValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (dj.isEmpty(this.z)) {
                return 0L;
            }
            return dh.g(this.z, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.vj5
    public wj5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return new m(this);
        }
        return (wj5) invokeV.objValue;
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.r.setBackgroundColor(-16777216);
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            p15.d(this.r).p(new int[]{R.color.CAM_X0608, R.color.CAM_X0601}, Direction.TOP);
        }
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

    public final void p3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && this.i.t()) {
            this.C0.c();
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.C0.hide();
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && this.i.t()) {
            this.C0.show();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.i.w();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.n == null) {
                this.n = VoiceManager.instance();
            }
            return this.n;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void z3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (intent = getIntent()) != null) {
            yn5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
        }
    }

    public final boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.Q) {
                return false;
            }
            dp7 dp7Var = this.x0;
            if (dp7Var != null && dp7Var.h(this.p)) {
                return true;
            }
            ap7 ap7Var = this.H;
            if (ap7Var == null || !ap7Var.t(this.p)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final long P2() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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

    public final void U2() {
        ImageUrlData imageUrlData;
        to7 to7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            String str = (String) ListUtils.getItem(this.s, this.p);
            Map<String, ImageUrlData> map = this.t;
            if (map != null && str != null && (imageUrlData = map.get(str)) != null && (to7Var = this.v) != null) {
                String str2 = this.z;
                String str3 = this.C;
                int i2 = this.p;
                to7Var.e(str2, str3, i2, this.q - i2, imageUrlData.mHeigth, imageUrlData.mWidth, this.G);
            }
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.l = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
            yo7 yo7Var = new yo7(getPageContext(), this.l);
            this.m = yo7Var;
            yo7Var.r(this.j0);
            this.m.s(this.r0);
            this.m.m(this.r0);
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.j = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.j.setLayoutParams(layoutParams);
            this.j.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public yj5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            yj5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(dh.g(this.y, 0L));
                pageStayDurationItem.C(dh.g(this.z, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (yj5) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.I && I2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            this.i.x();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = dh.g(this.z, 0L);
            if (uniqueId != null && g2 > 0) {
                qr4.f(uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            this.m.o();
        }
    }

    public final void y3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            boolean z = false;
            if (I2()) {
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
            h3();
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.o = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new b(this));
            this.k = (ImageView) this.o.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.o.setVisibility(0);
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShow() && this.S) {
            mo5.a(getSupportFragmentManager(), R.id.second_floor_container, this.C0.f("big_pic"));
            this.C0.d(new w(this));
            wp5 g2 = wp5.g(this);
            g2.j(R.id.second_floor_container, R.id.navigation_bar);
            g2.i(new a(this));
            g2.f();
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.r = findViewById(R.id.pic_top_obscuration_view);
            l3();
            a3();
            b3();
            this.w = new vo7(this);
            e3();
            this.w.x(this.i);
            u3();
            o3();
            c3();
            X2();
            to7 to7Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.p;
            to7Var.c(arrayList, i2, i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            this.i.y();
            this.mIsLogin = jh5.k();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = dh.g(this.z, 0L);
            if (uniqueId != null && g2 > 0) {
                qr4.j(br4.d0, uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.m.p();
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.c.setVisibility(8);
            if (this.b == null) {
                TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f06d8));
                this.b = centerTextTitle;
                centerTextTitle.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            }
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            m3(this.d, 8);
            m3(this.e, 8);
        }
    }

    public final void W2(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String str3;
        String a2;
        Map<String, ImageUrlData> map;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            this.v = new to7();
            boolean k2 = jh5.k();
            String b2 = jh5.b();
            String f2 = jh5.f();
            String e2 = jh5.e();
            z3();
            if (bundle != null) {
                this.V = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                ArrayList<String> c2 = ro7.d().c();
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
                Map<String, String> b3 = ro7.d().b();
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
                this.s0 = bundle.getInt("card_type", 0);
                this.t0 = bundle.getString("recom_source");
                this.u0 = bundle.getString("ab_tag");
                this.v0 = bundle.getString("weight");
                this.w0 = bundle.getString("extra");
                this.j0 = bundle.getString("from_forum_id");
                this.r0 = bundle.getInt("skin_type");
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
                ro7.d().a();
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
                    this.s0 = intent.getIntExtra("card_type", 0);
                    this.t0 = intent.getStringExtra("recom_source");
                    this.u0 = intent.getStringExtra("ab_tag");
                    this.v0 = intent.getStringExtra("weight");
                    this.w0 = intent.getStringExtra("extra");
                    this.j0 = intent.getStringExtra("from_forum_id");
                    this.r0 = intent.getIntExtra("skin_type", 0);
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
            jh5.o(z);
            jh5.n(str);
            jh5.p(str3);
            jh5.q(str2);
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
                a2 = mo7.a((String) ListUtils.getItem(this.s, this.p));
            }
            this.N = a2;
            if (this.T) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            c35.a().d(this.f0);
            d35.b().n(this.g0);
        }
    }

    public final void Z2(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            no7 no7Var = new no7(this.s, this.t, this.y, this.B, this.z, this.A, str, this.D, this.C, this.h0, z2, this.s0, this.t0, this.u0, this.v0, this.w0);
            this.u = no7Var;
            no7Var.m0(this.i0);
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
                this.x0.n(new v(this));
            }
            this.u.Z();
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.a.setClickable(false);
            V2();
            Y2();
            TextView textView = new TextView(this);
            this.c = textView;
            textView.setPadding(ej.g(this, R.dimen.tbds15), 0, 0, 0);
            this.c.setGravity(17);
            this.c.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.c.setTextSize(0, ej.g(this, R.dimen.tbds44));
            p15.d(this.c).y(R.array.S_O_X001);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.c, (View.OnClickListener) null);
            if (mo7.b((String) ListUtils.getItem(this.s, this.p))) {
                this.a.setVisibility(0);
            }
        }
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && !this.U && this.d != null) {
            if (this.x == null) {
                bf6 bf6Var = new bf6(getPageContext(), this.d);
                this.x = bf6Var;
                bf6Var.L(R.drawable.pic_sign_tip);
                this.x.o(48);
                this.x.N(true);
                this.x.n(5000);
                this.x.Q(-ej.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.x.m(new d(this));
            }
            this.x.T(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            MultiImageView multiImageView = this.i;
            if (multiImageView == null) {
                this.i = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f092733);
            } else {
                multiImageView.q();
            }
            this.G = this.z + "_" + System.currentTimeMillis();
            this.i.setIsFromCDN(this.Z);
            this.i.setIsCanDrag(this.R);
            this.i.setPageMargin(ej.d(getPageContext().getPageActivity(), 8.0f));
            this.i.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.i.setOnPageChangeListener(this.Q0);
            this.i.setUrlData(this.s);
            this.i.setAssistUrls(this.t);
            this.i.setOuterOnTouchListener(this.N0);
            this.i.setItemOnclickListener(this.L0);
            this.i.setItemOnLongClickListener(this.O0);
            this.i.setCurrentItem(H2(), false);
            this.i.setOnScrollOutListener(this.P0);
            if (this.z0 == null) {
                cp7 cp7Var = new cp7(this.s, getPageContext(), this.y, this.B, this.z);
                this.z0 = cp7Var;
                cp7Var.i(this.a.getFixedNavHeight());
            }
            this.i.k(this.z0);
            if (this.I && this.e0) {
                if (this.H == null) {
                    this.H = new ap7(this.s, this.y, this.z, this.Q, this.p, getPageContext());
                }
                this.H.B(null);
                this.i.k(this.H);
            }
            if (this.x0 == null) {
                this.x0 = new dp7(this.s, this.y, this.B, this.Z, this.Q, getPageContext(), this.G0, this.t);
            }
            this.i.k(this.x0);
            this.i.setOriImgSelectedCallback(this.J0);
            this.i.setDragToExitListener(this.G0);
            this.i.setUserId(this.D);
            this.i.setShowBottomContainer(this.a0);
            this.i.setOnShareImageListener(this.w);
            this.i.setOnDownloadImageListener(this.w);
            this.i.setOnReplyClickListener(this.I0);
            this.i.setYoungterCoverSomeView(this.d0);
            to7 to7Var = this.v;
            if (to7Var != null) {
                to7Var.d(this.D, this.z, this.C);
            }
        }
    }

    public final void f3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048605, this, z) != null) || this.z0 == null) {
            return;
        }
        if (!ListUtils.isEmpty(this.u.Y()) && z) {
            this.z0.k(this.u.Y());
            this.z0.j(true);
            ArrayList<String> arrayList = this.s;
            if (arrayList != null && !arrayList.contains("####mLiveRoomPageProvider")) {
                ArrayList<String> arrayList2 = this.s;
                mv7.b(arrayList2, "####mLiveRoomPageProvider", arrayList2.size());
                return;
            }
            return;
        }
        this.z0.k(null);
        this.z0.j(false);
    }

    public final void t3(int i2) {
        MultiImageView multiImageView;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048638, this, i2) != null) || (multiImageView = this.i) == null) {
            return;
        }
        multiImageView.l(i2);
        if (!this.i.u() && !I2() && !J2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        m3(this.d, i3);
        if (this.S) {
            m3(this.e, i3);
        }
        if (i3 == 0) {
            r3();
        } else {
            q3();
        }
    }

    public final void i3(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048613, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            n21.b(clogBuilder);
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
            M2();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new t(this));
            lh5.f().g(TbadkCoreApplication.getInst());
            lh5.i(new ImageFpsEvent());
            this.M = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            W2(bundle);
            setContentView(R.layout.image_activity_big_img);
            d3();
            Z2(this.N, this.T, false);
            registerListener(this.F0);
            registerListener(this.E0);
            registerListener(this.S0);
            registerListener(this.T0);
            addGlobalLayoutListener();
            VoiceManager u0 = u0();
            this.n = u0;
            u0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                x99.b(1, getWindow().getAttributes(), getWindow());
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
            MessageManager.getInstance().unRegisterListener(this.F0);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            TbImageMemoryCache.n().z();
            to7 to7Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.p;
            to7Var.c(arrayList, i2, i2);
            this.v.i();
            no7 no7Var = this.u;
            if (no7Var != null) {
                str = no7Var.X();
                str2 = this.u.b0();
            } else {
                str = null;
                str2 = null;
            }
            this.v.l(this.i.getPageCount(), "", this.y, this.z, str, str2);
            vo7 vo7Var = this.w;
            if (vo7Var != null) {
                vo7Var.C();
            }
            this.i.w();
            this.m.n();
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            hb5.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.M);
            L2();
            K2();
            dp7 dp7Var = this.x0;
            if (dp7Var != null) {
                dp7Var.k();
            }
            ap7 ap7Var = this.H;
            if (ap7Var != null) {
                ap7Var.y();
            }
            lh5.i(new PrePageKeyEvent(getCurrentPageKey()));
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
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
            ro7.d().f(this.s);
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
                ro7.d().e(hashMap);
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
                ro7.d().e(concurrentHashMap);
            }
            bundle.putString("from", this.C);
            bundle.putInt("thread_type", this.h0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.T);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.i0);
            bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.W);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.U);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.X);
            bundle.putBoolean("is_login", jh5.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, jh5.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, jh5.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, jh5.f());
            bundle.putString("from_forum_id", this.j0);
            bundle.putInt("skin_type", this.r0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.c0);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.d0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.e0);
            bundle.putSerializable(ImageViewerConfig.REMIND_LIVE_DATA, this.f0);
            bundle.putInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY, this.g0);
            this.v.h(bundle);
        }
    }

    public final void s3(int i2) {
        no7 no7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048636, this, i2) == null) && (no7Var = this.u) != null) {
            ArrayList<AlaInfoData> W = no7Var.W();
            if (W != null && W.size() > 0) {
                T2(true);
                S2(W.get(i2 % W.size()));
                return;
            }
            T2(false);
        }
    }

    public final void v3(long j2, int i2) {
        ap7 ap7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            dp7 dp7Var = this.x0;
            if ((dp7Var != null && dp7Var.j()) || ((ap7Var = this.H) != null && ap7Var.u())) {
                this.c.setText("");
            } else if (j2 > 0) {
                this.c.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.c.setText("");
            }
            m3(this.d, 8);
            m3(this.e, 8);
            q3();
        }
    }
}
