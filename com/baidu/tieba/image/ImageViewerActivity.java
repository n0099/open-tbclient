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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
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
import com.baidu.tieba.a65;
import com.baidu.tieba.ah7;
import com.baidu.tieba.bf8;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cp8;
import com.baidu.tieba.di0;
import com.baidu.tieba.e95;
import com.baidu.tieba.ei0;
import com.baidu.tieba.hi5;
import com.baidu.tieba.iw8;
import com.baidu.tieba.ji5;
import com.baidu.tieba.jm4;
import com.baidu.tieba.kb5;
import com.baidu.tieba.kg7;
import com.baidu.tieba.ki5;
import com.baidu.tieba.kw4;
import com.baidu.tieba.lg7;
import com.baidu.tieba.mb5;
import com.baidu.tieba.mw6;
import com.baidu.tieba.ns6;
import com.baidu.tieba.ow6;
import com.baidu.tieba.p56;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.q55;
import com.baidu.tieba.qg7;
import com.baidu.tieba.qo8;
import com.baidu.tieba.rg7;
import com.baidu.tieba.rj5;
import com.baidu.tieba.sa5;
import com.baidu.tieba.sg7;
import com.baidu.tieba.ta5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.vg7;
import com.baidu.tieba.vi7;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.wd5;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.xg7;
import com.baidu.tieba.xi;
import com.baidu.tieba.xx4;
import com.baidu.tieba.yd5;
import com.baidu.tieba.yh5;
import com.baidu.tieba.yx4;
import com.baidu.tieba.z01;
import com.baidu.tieba.zd5;
import com.baidu.tieba.zg7;
import com.baidu.tieba.zm4;
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
public class ImageViewerActivity extends BaseFragmentActivity implements VoiceManager.j, di0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean A0;
    public String B;
    public final ta5 B0;
    public String C;
    public final ei0 C0;
    public String D;
    public CustomMessageListener D0;
    public String E;
    public final CustomMessageListener E0;
    public String F;
    public DragImageView.h F0;
    public String G;
    public ns6 G0;
    public xg7 H;
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
    public p56 f;
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
    public vg7 m;
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
    public lg7 u;
    public String u0;
    public qg7 v;
    public String v0;
    public sg7 w;
    public ah7 w0;
    public p56 x;
    public View x0;
    public String y;
    public zg7 y0;
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.vd5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
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
                this.a.b.m2();
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
                    imageViewerActivity.f = new p56(imageViewerActivity.getPageContext(), this.b.e);
                    this.b.f.L(R.drawable.obfuscated_res_0x7f0802f4);
                    this.b.f.o(32);
                    this.b.f.M(true);
                    this.b.f.B(1);
                    this.b.f.P(0);
                    this.b.f.n(3000);
                    this.b.f.m(new a(this));
                    if (this.b.e != null && this.b.e.getVisibility() != 0) {
                        this.b.h = this.a;
                        return;
                    }
                    this.b.f.R(this.a);
                } else if (this.b.h != null && this.b.f != null && this.b.e != null && this.b.e.getVisibility() == 0) {
                    this.b.f.R(this.a);
                    this.b.h = null;
                } else {
                    this.b.m2();
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
        public class a implements ns6.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r a;

            @Override // com.baidu.tieba.ns6.d
            public void a(boolean z, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                }
            }

            @Override // com.baidu.tieba.ns6.d
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

            @Override // com.baidu.tieba.ns6.d
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

        /* JADX DEBUG: Multi-variable search result rejected for r5v28, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "3").param("post_id", this.a.z).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y));
                if (!kb5.a(this.a)) {
                    return;
                }
                if (this.a.G0 == null) {
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.G0 = new ns6(imageViewerActivity.getPageContext());
                    this.a.G0.i(new a(this));
                }
                if (this.a.i != null && this.a.i.getCurrentUrlDragImageView() != null && this.a.i.getCurrentUrlDragImageView().getmAssistUrlData() != null) {
                    i = this.a.i.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost;
                } else {
                    i = 1;
                }
                this.a.G0.j(i ^ 1);
                this.a.G0.g(this.a.y, wg.g(this.a.z, 0L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements rj5.c {
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

        @Override // com.baidu.tieba.rj5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) {
                return;
            }
            this.a.R2();
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
                if (this.a.I && this.a.k2() && ow6.d(str) && this.a.e0) {
                    int currentItem = this.a.i.getCurrentItem();
                    if (currentItem < this.a.s.size() - 1) {
                        this.a.s.remove(str);
                        this.a.i.setUrlData(this.a.s);
                        this.a.i.setCurrentItem(currentItem, true);
                    } else {
                        this.a.finish();
                    }
                    StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", "a008").eventStat();
                    return;
                }
                this.a.finish();
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
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.a.O = true;
                    if (this.a.d != null) {
                        this.a.d.setEnabled(false);
                    }
                    String a = kg7.a((String) ListUtils.getItem(this.a.s, this.a.p));
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.A2(a, !imageViewerActivity.T, true);
                    StatisticItem statisticItem = new StatisticItem("c13857");
                    if (this.a.T) {
                        i2 = 7;
                    } else {
                        i2 = 8;
                    }
                    TiebaStatic.log(statisticItem.param("obj_type", i2).param("post_id", this.a.z).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y));
                    return true;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c7f);
                return false;
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
            this.a.n2();
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
                this.a.finish();
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
                if (action == 0) {
                    this.a.L0 = motionEvent.getX();
                    return false;
                }
                if (action != 1) {
                    if (action == 2) {
                        this.a.L0 = motionEvent.getX();
                        return false;
                    } else if (action != 3) {
                        return false;
                    }
                }
                this.a.L0 = motionEvent.getX();
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
                } else if (this.a.q2() == 1) {
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
                    this.a.v.e(i, (String) this.a.s.get(this.a.p));
                }
                boolean z3 = true;
                if (i == 1 && this.a.H != null) {
                    if ((this.a.p == 0 || this.a.H.w(this.a.p)) && !mw6.m().v(mw6.r()) && this.a.H.A(this.a.p)) {
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
                            imageViewerActivity2.G2((z || imageViewerActivity2.A0) ? false : false);
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
                    if (this.a.q2() == 1 && z) {
                        this.a.setSwipeBackEnabled(true);
                    } else {
                        this.a.setSwipeBackEnabled(false);
                    }
                    this.a.m2();
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
                this.a.W2();
                this.a.a3();
                this.a.V2(i);
                if (this.a.v.a() < this.a.p) {
                    this.a.v.h(this.a.p);
                }
                if (this.a.v.b() > this.a.p) {
                    this.a.v.i(this.a.p);
                }
                if (this.a.H != null) {
                    boolean z = true;
                    this.a.H.D((this.a.u == null || this.a.u.c0() != 1) ? false : false);
                    this.a.H.z(i);
                    if (this.a.k2() && this.a.I && this.a.H.x(i)) {
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
                    this.a.v2();
                }
                if (this.a.l2()) {
                    StatisticItem statisticItem = new StatisticItem("c15006");
                    rg7.b(statisticItem, this.a.y, this.a.B, TbadkCoreApplication.getCurrentAccount(), this.a.z);
                    TiebaStatic.log(statisticItem);
                    this.a.Y2();
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
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2 instanceof HeadImageView) || (alaInfo = ((HeadImageView) view2).getAlaInfo()) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext(), null)) {
                return;
            }
            String str2 = "";
            if (alaInfo.isLegalYYLiveData()) {
                YyExtData yyExtData = alaInfo.mYyExtData;
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BdUniDispatchSchemeController.SCHEME + "://" + BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_TIEBA_YY_ROOM + "?" + BdUniDispatchSchemeController.PARAM_YY_URL + "=" + Base64.encodeToString(YYLiveUtil.makeJumpToYYLiveRoomUrl(yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + alaInfo.roomId, alaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_PB_BIG_IMAGE_HEAD).getBytes(), 2))));
            } else if (alaInfo.isChushou) {
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BdUniDispatchSchemeController.SCHEME + "://" + BdUniDispatchSchemeController.HOST + BdUniDispatchSchemeController.PATH_CHUSHOU_ALA_ROOM + "?" + BdUniDispatchSchemeController.PARAM_CHUSHOU_THIRD_LIVE_TYPE + "=" + alaInfo.thirdLiveType + "&" + BdUniDispatchSchemeController.PARAM_CHUSHOU_ROOM_ID + "=" + alaInfo.thirdRoomId)));
            }
            StatisticItem param = new StatisticItem("c13711").param("fid", this.a.y).param("fname", this.a.B).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.z);
            if (alaInfo.user_info == null) {
                str = "";
            } else {
                str = "" + alaInfo.user_info.user_id;
            }
            StatisticItem param2 = param.param("obj_param1", str);
            int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfo);
            if (alaInfo.isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, alaInfo.mYyExtData);
                str2 = TiebaStatic.YYValues.YY_LIVE;
            }
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
            TiebaStatic.log(param2);
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
                this.a.m2();
                if (!booleanValue) {
                    this.a.B0.c();
                    this.a.S2();
                    return;
                }
                this.a.T2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends wd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity b;

        @Override // com.baidu.tieba.wd5
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

        @Override // com.baidu.tieba.wd5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return zd5.b().c();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qo8) && this.a.t != null && (agreeData = ((qo8) customResponsedMessage.getData()).b) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qo8) && this.a.t != null && (agreeData = ((qo8) customResponsedMessage.getData()).b) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
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
            q55 q55Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof q55) && (q55Var = (q55) customResponsedMessage.getData()) != null && !StringUtils.isNull(q55Var.a)) {
                ki5.h(q55Var);
                if (StringUtils.isNull(q55Var.c)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{q55Var.a});
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{q55Var.a, q55Var.c});
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
                imageViewerActivity.N2(imageViewerActivity.c, 8);
                ImageViewerActivity imageViewerActivity2 = this.a;
                imageViewerActivity2.N2(imageViewerActivity2.d, 8);
                ImageViewerActivity imageViewerActivity3 = this.a;
                imageViewerActivity3.N2(imageViewerActivity3.o, 8);
                ImageViewerActivity imageViewerActivity4 = this.a;
                imageViewerActivity4.N2(imageViewerActivity4.e, 8);
                this.a.S2();
                if (this.a.i != null) {
                    this.a.i.B(false);
                }
                this.a.n2();
                this.a.m2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.i.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.i.getCurrentMaxIndex()));
                this.a.finish();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.N2(imageViewerActivity.c, 0);
                this.a.o.setVisibility(0);
                if (this.a.i == null || this.a.k2()) {
                    return;
                }
                boolean u = this.a.i.u();
                if (!"portrait".equals(this.a.C) && !u) {
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.N2(imageViewerActivity2.d, 0);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.N2(imageViewerActivity3.e, 0);
                    this.a.T2();
                    ImageViewerActivity imageViewerActivity4 = this.a;
                    imageViewerActivity4.O2(imageViewerActivity4.h);
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
            this.a.o2();
        }
    }

    /* loaded from: classes4.dex */
    public class u implements lg7.b {
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

        @Override // com.baidu.tieba.lg7.b
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
                    this.a.F2();
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.T = !imageViewerActivity.T;
                } else if (!this.a.T) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0906);
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
            if (this.a.q2() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (!this.a.I || this.a.H == null) {
                if (this.a.w0 != null) {
                    this.a.w0.o(this.a.q2(), this.a.q);
                    this.a.w0.l();
                    c(arrayList, advertAppInfo);
                }
            } else {
                xg7 xg7Var = this.a.H;
                if (this.a.u.c0() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                xg7Var.D(z6);
                if (this.a.z0 || this.a.H.v(this.a.r2())) {
                    this.a.H.C(this.a.q2(), this.a.q);
                    this.a.H.s(this.a.T);
                    this.a.i.setUrlData(this.a.s);
                }
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
            imageViewerActivity3.G2((z4 || imageViewerActivity3.A0) ? false : false);
            this.a.i.setUrlData(arrayList);
            this.a.W2();
            if (this.a.m != null && this.a.i.getCurrentUrlDragImageView() != null) {
                this.a.m.q(this.a.i.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
            }
            if (this.a.z0) {
                this.a.z0 = false;
                this.a.v2();
            }
        }

        @Override // com.baidu.tieba.lg7.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.O = false;
                if (this.a.d != null) {
                    if (this.a.d.getState() != this.a.T && TextUtils.isEmpty(str)) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0906);
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
                    this.a.W2();
                }
                if (this.a.z0) {
                    this.a.z0 = false;
                    this.a.v2();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.w0 != null && advertAppInfo != null && arrayList != null) {
                    int n = advertAppInfo.n();
                    if (n != 0) {
                        this.a.J2(advertAppInfo, n);
                        return;
                    } else {
                        this.a.w0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.K2(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements bf8 {
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

        @Override // com.baidu.tieba.bf8
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.a.i.setUrlData(this.a.s);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements ta5.a {
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

        @Override // com.baidu.tieba.ta5.a
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.a.L2();
                } else {
                    this.a.M2();
                }
            }
        }

        @Override // com.baidu.tieba.ta5.a
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (z) {
                    if (!z2) {
                        return;
                    }
                    this.a.L2();
                    return;
                }
                this.a.M2();
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
        this.B0 = sa5.a();
        this.C0 = new ei0();
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

    public final void W2() {
        String str;
        int i2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.s != null) {
            long q2 = q2();
            String str2 = ("" + q2) + "/";
            if (this.q > 0) {
                str = str2 + this.q;
            } else {
                str = str2 + StringHelper.STRING_MORE;
            }
            if (this.C != null && !this.P && q2() == this.q && (this.C.equals("frs") || this.C.equals("index"))) {
                TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.C));
                this.P = true;
            }
            if (k2()) {
                long j2 = -1;
                String str3 = (String) ListUtils.getItem(this.s, this.p - 1);
                if (!StringUtils.isNull(str3) && (imageUrlData = this.t.get(str3)) != null) {
                    j2 = imageUrlData.overAllIndex;
                }
                X2(j2, this.q);
            } else if (l2()) {
                Y2();
            } else {
                Z2(str);
            }
            long j3 = q2 - 1;
            if (j3 > 0) {
                i2 = (int) j3;
            } else {
                i2 = 0;
            }
            U2(i2);
        }
    }

    public final void z2() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && !this.V && !this.U && !this.c0) {
            View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d01cd, (View.OnClickListener) null);
            this.x0 = addCustomView;
            if (this.d0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            addCustomView.setVisibility(i2);
            if (!UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShow()) {
                AlaLiveTipView alaLiveTipView = (AlaLiveTipView) this.x0.findViewById(R.id.obfuscated_res_0x7f091a08);
                this.e = alaLiveTipView;
                alaLiveTipView.setViewLocate(2);
                this.e.setForumInfo(this.y, this.B, this.z);
                this.e.setNormalBottomMarginParams(xi.g(getPageContext().getPageActivity(), R.dimen.tbds5));
            }
            if (this.S) {
                ArrayList arrayList = new ArrayList(2);
                cp8 cp8Var = new cp8();
                cp8Var.c(0);
                cp8Var.d(getString(R.string.obfuscated_res_0x7f0f026e));
                arrayList.add(cp8Var);
                cp8 cp8Var2 = new cp8();
                cp8Var2.c(1);
                cp8Var2.d(getString(R.string.obfuscated_res_0x7f0f0893));
                arrayList.add(cp8Var2);
                SortSwitchButton sortSwitchButton = (SortSwitchButton) this.x0.findViewById(R.id.obfuscated_res_0x7f090de6);
                this.d = sortSwitchButton;
                sortSwitchButton.setNeedDayNight(false);
                this.d.setData(arrayList, this.T ? 1 : 0);
                this.d.setVisibility(0);
                this.d.setOnSwitchChangeListener(this.J0);
                N2(this.e, 0);
                return;
            }
            N2(this.d, 8);
            N2(this.e, 8);
        }
    }

    public final void N2(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, view2, i2) == null) && view2 != null) {
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
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void K2(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (multiImageView = this.i) != null) {
            multiImageView.setAddSize(i2);
        }
    }

    public final void O2(@NonNull String str) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || (alaLiveTipView = this.e) == null) {
            return;
        }
        alaLiveTipView.post(new l(this, str));
    }

    public final void Z2(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.c.setText(str);
            if (this.S && !this.U && (sortSwitchButton = this.d) != null) {
                sortSwitchButton.w(this.T ? 1 : 0);
            }
            kw4.d(this.c).y(R.array.S_O_X001);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
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
            sg7 sg7Var = this.w;
            if (sg7Var != null) {
                sg7Var.z();
            }
            vg7 vg7Var = this.m;
            if (vg7Var != null) {
                vg7Var.m(this.q0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.i.setCurrentItem(this.p, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f08062e, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                o2();
            }
        }
    }

    public final void t2(AlaInfoData alaInfoData) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, alaInfoData) == null) && alaInfoData != null && alaInfoData.user_info != null && (alaLiveTipView = this.e) != null) {
            alaLiveTipView.setOnClickListener(this.Q0);
            if (!TextUtils.isEmpty(alaInfoData.tag)) {
                O2(alaInfoData.tag);
            }
        }
    }

    public final void u2(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048640, this, z) == null) && this.g != z) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048620, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.m.l(i2, i3, intent);
        }
    }

    public final void A2(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            lg7 lg7Var = new lg7(this.s, this.t, this.y, this.B, this.z, this.A, str, this.D, this.C, this.h0, z2, this.r0, this.s0, this.t0, this.u0, this.v0);
            this.u = lg7Var;
            lg7Var.m0(this.i0);
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

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091688);
            this.a = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.a.setClickable(false);
            w2();
            z2();
            TextView textView = new TextView(this);
            this.c = textView;
            textView.setPadding(xi.g(this, R.dimen.tbds15), 0, 0, 0);
            this.c.setGravity(17);
            this.c.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.c.setTextSize(0, xi.g(this, R.dimen.tbds44));
            kw4.d(this.c).y(R.array.S_O_X001);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.c, (View.OnClickListener) null);
            if (kg7.b((String) ListUtils.getItem(this.s, this.p))) {
                this.a.setVisibility(0);
            }
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !this.U && this.d != null) {
            if (this.x == null) {
                p56 p56Var = new p56(getPageContext(), this.d);
                this.x = p56Var;
                p56Var.L(R.drawable.pic_sign_tip);
                this.x.o(48);
                this.x.M(true);
                this.x.n(5000);
                this.x.P(-xi.g(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.x.m(new d(this));
            }
            this.x.S(getPageContext().getString(R.string.obfuscated_res_0x7f0f03f9), "key_large_image_tip_count");
        }
    }

    public final void v2() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            String str = (String) ListUtils.getItem(this.s, this.p);
            Map<String, ImageUrlData> map = this.t;
            if (map != null && str != null && (imageUrlData = map.get(str)) != null) {
                TiebaStatic.log(new StatisticItem("c13340").param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.z).param("obj_source", this.C).param("obj_param1", this.p).param(TiebaStatic.Params.OBJ_PARAM2, this.q - this.p).param(TiebaStatic.Params.OBJ_PARAM3, imageUrlData.mHeigth).param(TiebaStatic.Params.OBJ_PARAM4, imageUrlData.mWidth).param("obj_type", this.G));
            }
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShow()) {
            ji5.a(getSupportFragmentManager(), R.id.obfuscated_res_0x7f091e65, this.B0.d("big_pic"));
            this.B0.b(new w(this));
            rj5 f2 = rj5.f(this);
            f2.i(R.id.obfuscated_res_0x7f091e65, R.id.obfuscated_res_0x7f091688);
            f2.h(new a(this));
            f2.e();
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.r = findViewById(R.id.obfuscated_res_0x7f091a0c);
            M2();
            B2();
            C2();
            this.w = new sg7(this);
            F2();
            this.w.x(this.i);
            W2();
            P2();
            D2();
            y2();
            qg7 qg7Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.p;
            qg7Var.c(arrayList, i2, i2);
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.c.setVisibility(8);
            if (this.b == null) {
                TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f069c));
                this.b = centerTextTitle;
                centerTextTitle.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            }
            this.b.setVisibility(0);
            this.a.setVisibility(0);
            N2(this.d, 8);
            N2(this.e, 8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            this.i.y();
            this.mIsLogin = kb5.k();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = wg.g(this.z, 0L);
            if (uniqueId != null && g2 > 0) {
                zm4.j(jm4.d0, uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.m.p();
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.o = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new b(this));
            this.k = (ImageView) this.o.findViewById(R.id.obfuscated_res_0x7f0926c0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f08062e, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.o.setVisibility(0);
        }
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091fd4);
            this.j = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.j.setLayoutParams(layoutParams);
            this.j.setVisibility(0);
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.I && k2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080a2d, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f08062e, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final int Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (StringUtils.isNULL(this.C)) {
                return 7;
            }
            if (this.C.equals("pb")) {
                return 5;
            }
            if (this.C.equals("frs")) {
                return 3;
            }
            if (!this.C.equals("index")) {
                return 7;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public final void a3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            boolean z = false;
            if (k2()) {
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
            I2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public yd5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            yd5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(wg.g(this.y, 0L));
                pageStayDurationItem.C(wg.g(this.z, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (yd5) invokeV.objValue;
    }

    public final boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (!this.Q) {
                return false;
            }
            ah7 ah7Var = this.w0;
            if (ah7Var != null && ah7Var.h(this.p)) {
                return true;
            }
            xg7 xg7Var = this.H;
            if (xg7Var == null || !xg7Var.t(this.p)) {
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
            long g2 = wg.g(this.z, 0L);
            if (uniqueId != null && g2 > 0) {
                zm4.f(uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.m.o();
        }
    }

    public final long q2() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
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

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090ede);
            vg7 vg7Var = new vg7(getPageContext(), this.l);
            this.m = vg7Var;
            vg7Var.r(this.j0);
            this.m.s(this.q0);
            this.m.m(this.q0);
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiImageView multiImageView = this.i;
            if (multiImageView == null) {
                this.i = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f092619);
            } else {
                multiImageView.q();
            }
            this.G = this.z + "_" + System.currentTimeMillis();
            this.i.setIsFromCDN(this.Z);
            this.i.setIsCanDrag(this.R);
            this.i.setPageMargin(xi.d(getPageContext().getPageActivity(), 8.0f));
            this.i.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.i.setOnPageChangeListener(this.P0);
            this.i.setUrlData(this.s);
            this.i.setAssistUrls(this.t);
            this.i.setOuterOnTouchListener(this.M0);
            this.i.setItemOnclickListener(this.K0);
            this.i.setItemOnLongClickListener(this.N0);
            this.i.setCurrentItem(j2(), false);
            this.i.setOnScrollOutListener(this.O0);
            if (this.y0 == null) {
                zg7 zg7Var = new zg7(this.s, getPageContext(), this.y, this.B, this.z);
                this.y0 = zg7Var;
                zg7Var.i(this.a.getFixedNavHeight());
            }
            this.i.k(this.y0);
            if (this.I && this.e0) {
                if (this.H == null) {
                    this.H = new xg7(this.s, this.y, this.z, this.Q, this.p, getPageContext());
                }
                this.H.B(null);
                this.i.k(this.H);
            }
            if (this.w0 == null) {
                this.w0 = new ah7(this.s, this.y, this.B, this.Z, this.Q, getPageContext(), this.F0, this.t);
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
            TiebaStatic.log(new StatisticItem("c13340").param("uid", this.D).param("post_id", this.z).param("obj_source", Q2()));
        }
    }

    public final void G2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048582, this, z) != null) || this.y0 == null) {
            return;
        }
        if (!ListUtils.isEmpty(this.u.Y()) && z) {
            this.y0.k(this.u.Y());
            this.y0.j(true);
            ArrayList<String> arrayList = this.s;
            vi7.b(arrayList, "####mLiveRoomPageProvider", arrayList.size());
            return;
        }
        this.y0.k(null);
        this.y0.j(false);
    }

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.V;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.di0
    @NonNull
    public ei0 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.C0;
        }
        return (ei0) invokeV.objValue;
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.r.setBackgroundColor(SkinManager.getColor(R.color.obfuscated_res_0x7f060425));
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            kw4.d(this.r).p(new int[]{R.color.CAM_X0608, R.color.CAM_X0601}, Direction.TOP);
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.i.t()) {
            this.B0.a();
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.B0.hide();
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.i.t()) {
            this.B0.show();
        }
    }

    public final void b3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (intent = getIntent()) != null) {
            yh5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (hi5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (wi.isEmpty(this.z)) {
                return 0L;
            }
            return wg.g(this.z, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.vd5
    public wd5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return new m(this);
        }
        return (wd5) invokeV.objValue;
    }

    public int j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
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

    public final boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
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

    public final void m2() {
        p56 p56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (p56Var = this.f) != null) {
            p56Var.h();
        }
    }

    public final void n2() {
        p56 p56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (p56Var = this.x) != null) {
            p56Var.h();
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            getWindow().getDecorView().setSystemUiVisibility(1284);
            getWindow().addFlags(1024);
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

    public Map<String, ImageUrlData> p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.t;
        }
        return (Map) invokeV.objValue;
    }

    public final int r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return (int) q2();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.i.w();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.n == null) {
                this.n = VoiceManager.instance();
            }
            return this.n;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public String s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.D;
        }
        return (String) invokeV.objValue;
    }

    public final void J2(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            z01.b(clogBuilder);
        }
    }

    public final void U2(int i2) {
        lg7 lg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i2) == null) && (lg7Var = this.u) != null) {
            ArrayList<AlaInfoData> W = lg7Var.W();
            if (W != null && W.size() > 0) {
                u2(true);
                t2(W.get(i2 % W.size()));
                return;
            }
            u2(false);
        }
    }

    public final void V2(int i2) {
        MultiImageView multiImageView;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048598, this, i2) != null) || (multiImageView = this.i) == null) {
            return;
        }
        multiImageView.l(i2);
        if (!this.i.u() && !k2() && !l2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        N2(this.d, i3);
        N2(this.e, i3);
        if (i3 == 0) {
            T2();
        } else {
            S2();
        }
    }

    public final void X2(long j2, int i2) {
        xg7 xg7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ah7 ah7Var = this.w0;
            if ((ah7Var != null && ah7Var.j()) || ((xg7Var = this.H) != null && xg7Var.u())) {
                this.c.setText("");
            } else if (j2 > 0) {
                this.c.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.c.setText("");
            }
            N2(this.d, 8);
            N2(this.e, 8);
            S2();
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
            o2();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new t(this));
            mb5.f().g(TbadkCoreApplication.getInst());
            mb5.i(new ImageFpsEvent());
            this.M = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            x2(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d03ca);
            E2();
            A2(this.N, this.T, false);
            registerListener(this.E0);
            registerListener(this.D0);
            registerListener(this.R0);
            registerListener(this.S0);
            addGlobalLayoutListener();
            VoiceManager s0 = s0();
            this.n = s0;
            s0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                iw8.b(1, getWindow().getAttributes(), getWindow());
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
            e95.k().r();
            qg7 qg7Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.p;
            qg7Var.c(arrayList, i2, i2);
            this.v.g();
            lg7 lg7Var = this.u;
            if (lg7Var != null) {
                String X = lg7Var.X();
                str2 = this.u.b0();
                str = X;
            } else {
                str = null;
                str2 = null;
            }
            this.v.j(this.i.getPageCount(), "", this.y, this.z, str, str2);
            sg7 sg7Var = this.w;
            if (sg7Var != null) {
                sg7Var.C();
            }
            this.i.w();
            this.m.n();
            VoiceManager voiceManager = this.n;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            a65.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.M);
            n2();
            m2();
            ah7 ah7Var = this.w0;
            if (ah7Var != null) {
                ah7Var.k();
            }
            xg7 xg7Var = this.H;
            if (xg7Var != null) {
                xg7Var.y();
            }
            mb5.i(new PrePageKeyEvent(getCurrentPageKey()));
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
            bundle.putStringArrayList("url", this.s);
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
                bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, hashMap);
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
                bundle.putSerializable(ImageViewerConfig.ASSIST_URLS, concurrentHashMap);
            }
            bundle.putString("from", this.C);
            bundle.putInt("thread_type", this.h0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.T);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.i0);
            bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.W);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.U);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.X);
            bundle.putBoolean("is_login", kb5.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, kb5.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, kb5.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, kb5.f());
            bundle.putString("from_forum_id", this.j0);
            bundle.putInt("skin_type", this.q0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.c0);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.d0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.e0);
            bundle.putSerializable(ImageViewerConfig.REMIND_LIVE_DATA, this.f0);
            bundle.putInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY, this.g0);
            this.v.f(bundle);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void x2(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String str3;
        String a2;
        Map<String, ImageUrlData> map;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, bundle) == null) {
            this.v = new qg7();
            boolean k2 = kb5.k();
            String b2 = kb5.b();
            String f2 = kb5.f();
            String e2 = kb5.e();
            b3();
            if (bundle != null) {
                this.V = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                this.s = bundle.getStringArrayList("url");
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
                Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
                this.i0 = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.X = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
                boolean z2 = bundle.getBoolean("is_login");
                String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
                String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
                String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
                this.a0 = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.b0 = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                if (serializable instanceof Map) {
                    this.t = new ConcurrentHashMap();
                    for (Map.Entry entry : ((Map) serializable).entrySet()) {
                        if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                            try {
                                this.t.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
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
                Serializable serializable2 = bundle.getSerializable(ImageViewerConfig.REMIND_LIVE_DATA);
                if (serializable2 instanceof LiveRemindData) {
                    this.f0 = (LiveRemindData) serializable2;
                }
                this.g0 = bundle.getInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY);
                this.e0 = bundle.getBoolean(ImageViewerConfig.NEED_REQUEST_AD, true);
                Serializable serializable3 = bundle.getSerializable(ImageViewerConfig.KEY_PROFILE_VIRTUAL_IMAGE_INFO);
                if (serializable3 instanceof ProfileVirtualImageInfo) {
                    ProfileVirtualImageInfo.getInstance().parseRemoteInfo((ProfileVirtualImageInfo) serializable3);
                }
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
                    str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                    str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                    str2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
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
                } else {
                    z = k2;
                    str = b2;
                    str2 = f2;
                    str3 = e2;
                }
            }
            kb5.o(z);
            kb5.n(str);
            kb5.p(str3);
            kb5.q(str2);
            this.v.d(bundle, getIntent());
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
                a2 = kg7.a((String) ListUtils.getItem(this.s, this.p));
            }
            this.N = a2;
            if (this.T) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            xx4.a().d(this.f0);
            yx4.b().n(this.g0);
        }
    }
}
