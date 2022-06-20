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
import android.view.Window;
import android.view.WindowManager;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.YyExtData;
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
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.am6;
import com.repackage.d05;
import com.repackage.d88;
import com.repackage.dc5;
import com.repackage.fc5;
import com.repackage.fg0;
import com.repackage.fr4;
import com.repackage.ga7;
import com.repackage.gg0;
import com.repackage.ha7;
import com.repackage.j35;
import com.repackage.jh8;
import com.repackage.li4;
import com.repackage.ma7;
import com.repackage.n55;
import com.repackage.na7;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nq6;
import com.repackage.oi;
import com.repackage.p55;
import com.repackage.pi;
import com.repackage.po8;
import com.repackage.pq6;
import com.repackage.qa7;
import com.repackage.sa7;
import com.repackage.ta7;
import com.repackage.u75;
import com.repackage.vb5;
import com.repackage.vh4;
import com.repackage.vh8;
import com.repackage.vx0;
import com.repackage.vz4;
import com.repackage.w75;
import com.repackage.x75;
import com.repackage.zy5;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.j, fg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public am6 A0;
    public String B;
    public View.OnClickListener B0;
    public String C;
    public UrlDragImageView.p C0;
    public String D;
    public final SortSwitchButton.f D0;
    public String E;
    public View.OnClickListener E0;
    public String F;
    public float F0;
    public sa7 G;
    public View.OnTouchListener G0;
    public final boolean H;
    public View.OnLongClickListener H0;
    public boolean I;
    public BaseViewPager.a I0;
    public boolean J;
    public ViewPager.OnPageChangeListener J0;
    public int K;
    public View.OnClickListener K0;
    public int L;
    public CustomMessageListener L0;
    public String M;
    public CustomMessageListener M0;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public NavigationBar a;
    public TextView b;
    public SortSwitchButton c;
    public View d;
    public HeadImageView e;
    public TBLottieAnimationView f;
    public zy5 g;
    public boolean g0;
    public boolean h;
    public boolean h0;
    public String i;
    public boolean i0;
    public MultiImageView j;
    public boolean j0;
    public View k;
    public int k0;
    public ImageView l;
    public String l0;
    public LinearLayout m;
    public String m0;
    public qa7 n;
    public int n0;
    public VoiceManager o;
    public int o0;
    public View p;
    public String p0;
    public int q;
    public String q0;
    public int r;
    public String r0;
    public ArrayList<String> s;
    public String s0;
    public Map<String, ImageUrlData> t;
    public ta7 t0;
    public ha7 u;
    public View u0;
    public ma7 v;
    public boolean v0;
    public na7 w;
    public final gg0 w0;
    public zy5 x;
    public CustomMessageListener x0;
    public String y;
    public final CustomMessageListener y0;
    public String z;
    public DragImageView.h z0;

    /* loaded from: classes3.dex */
    public class a implements SortSwitchButton.f {
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

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (ni.A()) {
                    this.a.N = true;
                    if (this.a.c != null) {
                        this.a.c.setEnabled(false);
                    }
                    String a = ga7.a((String) ListUtils.getItem(this.a.s, this.a.q));
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.W2(a, !imageViewerActivity.S, true);
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", this.a.S ? 7 : 8).param("post_id", this.a.z).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y));
                    return true;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                return false;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.I2();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.j.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.j.getCurrentMaxIndex()));
                TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                if (action == 0) {
                    this.a.F0 = motionEvent.getX();
                    return false;
                } else if (action == 1 || action == 2 || action == 3) {
                    this.a.F0 = motionEvent.getX();
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (UbsABTestHelper.isImageViewerTestA()) {
                    if (this.a.w != null) {
                        this.a.w.z();
                    }
                } else if (this.a.w != null) {
                    this.a.w.E();
                    this.a.w.F();
                    this.a.w.x(view2);
                }
                TiebaStatic.log(new StatisticItem("c13269").param("uid", this.a.D).param("fid", this.a.y).param("tid", this.a.z));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements BaseViewPager.a {
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

        @Override // com.baidu.tbadk.core.view.BaseViewPager.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 0) {
                    this.a.u.V();
                } else if (this.a.K2() == 1) {
                } else {
                    this.a.u.W();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ViewPager.OnPageChangeListener {
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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.s != null && this.a.q < this.a.s.size()) {
                    this.a.v.e(i, (String) this.a.s.get(this.a.q));
                }
                if (i != 1 || this.a.G == null) {
                    return;
                }
                if ((this.a.q == 0 || this.a.G.w(this.a.q)) && !nq6.m().w(nq6.r()) && this.a.G.A(this.a.q)) {
                    this.a.j.setUrlData(this.a.s);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                if (i > this.a.K) {
                    this.a.K = i;
                } else if (i < this.a.K) {
                    this.a.K = i;
                    DragImageView currentView = this.a.j != null ? this.a.j.getCurrentView() : null;
                    boolean d0 = currentView != null ? currentView.d0() : false;
                    if (this.a.K2() == 1 && d0) {
                        this.a.setSwipeBackEnabled(true);
                    } else {
                        this.a.setSwipeBackEnabled(false);
                    }
                    this.a.H2();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.u != null && i > this.a.j.getItemNum() - 5) {
                    this.a.u.V();
                }
                this.a.v.c(this.a.s, this.a.q, i);
                this.a.q = i;
                this.a.m3();
                this.a.p3();
                this.a.l3(i);
                if (this.a.v.a() < this.a.q) {
                    this.a.v.h(this.a.q);
                }
                if (this.a.v.b() > this.a.q) {
                    this.a.v.i(this.a.q);
                }
                if (this.a.G != null) {
                    boolean z = true;
                    this.a.G.D((this.a.u == null || this.a.u.Y() != 1) ? false : false);
                    this.a.G.z(i);
                    if (this.a.G2() && this.a.H && this.a.G.x(i)) {
                        this.a.G.B(null);
                    }
                }
                if (this.a.t0 != null) {
                    this.a.t0.m(i);
                }
                if (this.a.w != null) {
                    this.a.w.C();
                }
                if (this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                    this.a.n.q(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
                }
                if (this.a.v0) {
                    return;
                }
                this.a.R2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlaInfoData alaInfo;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !(view2 instanceof HeadImageView) || (alaInfo = ((HeadImageView) view2).getAlaInfo()) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext(), null)) {
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
            if (alaInfo.user_info != null) {
                str = "" + alaInfo.user_info.user_id;
            } else {
                str = "";
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

    /* loaded from: classes3.dex */
    public class i implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.playAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageViewerActivity b;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.b.H2();
                }
            }
        }

        public j(ImageViewerActivity imageViewerActivity, String str) {
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
                if (this.b.g != null) {
                    if (this.b.i == null || this.b.g == null || this.b.d == null || this.b.d.getVisibility() != 0) {
                        this.b.H2();
                        return;
                    }
                    this.b.g.l0(this.a);
                    this.b.i = null;
                    return;
                }
                ImageViewerActivity imageViewerActivity = this.b;
                imageViewerActivity.g = new zy5(imageViewerActivity.getPageContext(), this.b.f);
                this.b.g.g0(R.drawable.obfuscated_res_0x7f0802ee);
                this.b.g.O(32);
                this.b.g.h0(true);
                this.b.g.W(1);
                this.b.g.j0(0);
                this.b.g.N(3000);
                this.b.g.M(new a(this));
                if (this.b.d == null || this.b.d.getVisibility() == 0) {
                    this.b.g.l0(this.a);
                    return;
                }
                this.b.i = this.a;
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.a.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                this.a.H2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends u75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity b;

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
            this.b = imageViewerActivity;
        }

        @Override // com.repackage.u75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? x75.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.u75
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ImageViewerActivity imageViewerActivity, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof jh8) || this.a.t == null || (agreeData = ((jh8) customResponsedMessage.getData()).b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof jh8) || this.a.t == null || (agreeData = ((jh8) customResponsedMessage.getData()).b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
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

    /* loaded from: classes3.dex */
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
            vz4 vz4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof vz4) || (vz4Var = (vz4) customResponsedMessage.getData()) == null || StringUtils.isNull(vz4Var.a)) {
                return;
            }
            fc5.h(vz4Var);
            if (StringUtils.isNull(vz4Var.c)) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{vz4Var.a});
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{vz4Var.a, vz4Var.c});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public p(ImageViewerActivity imageViewerActivity) {
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
                imageViewerActivity.f3(imageViewerActivity.b, 8);
                ImageViewerActivity imageViewerActivity2 = this.a;
                imageViewerActivity2.f3(imageViewerActivity2.c, 8);
                ImageViewerActivity imageViewerActivity3 = this.a;
                imageViewerActivity3.f3(imageViewerActivity3.p, 8);
                ImageViewerActivity imageViewerActivity4 = this.a;
                imageViewerActivity4.f3(imageViewerActivity4.d, 8);
                if (this.a.j != null) {
                    this.a.j.A(false);
                }
                this.a.I2();
                this.a.H2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.j.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.j.getCurrentMaxIndex()));
                this.a.finish();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.f3(imageViewerActivity.b, 0);
                this.a.p.setVisibility(0);
                if (this.a.j == null || this.a.G2()) {
                    return;
                }
                boolean t = this.a.j.t();
                if ("portrait".equals(this.a.C) || t) {
                    return;
                }
                ImageViewerActivity imageViewerActivity2 = this.a;
                imageViewerActivity2.f3(imageViewerActivity2.c, 0);
                ImageViewerActivity imageViewerActivity3 = this.a;
                imageViewerActivity3.f3(imageViewerActivity3.d, 0);
                ImageViewerActivity imageViewerActivity4 = this.a;
                imageViewerActivity4.g3(imageViewerActivity4.i);
                if (this.a.Z) {
                    this.a.j.A(true);
                } else {
                    this.a.j.A(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* loaded from: classes3.dex */
        public class a implements am6.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // com.repackage.am6.d
            public void a(boolean z, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                }
            }

            @Override // com.repackage.am6.d
            public void b(boolean z) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || !z || this.a.a.n == null || this.a.a.j.getCurrentUrlDragImageView() == null) {
                    return;
                }
                this.a.a.n.u(this.a.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.a.u);
            }

            @Override // com.repackage.am6.d
            public void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                }
            }
        }

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

        /* JADX DEBUG: Multi-variable search result rejected for r5v28, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "3").param("post_id", this.a.z).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y));
                if (n55.a(this.a)) {
                    if (this.a.A0 == null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.A0 = new am6(imageViewerActivity.getPageContext());
                        this.a.A0.i(new a(this));
                    }
                    this.a.A0.j(((this.a.j == null || this.a.j.getCurrentUrlDragImageView() == null || this.a.j.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? 1 : this.a.j.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost) ^ 1);
                    this.a.A0.g(this.a.y, ng.g(this.a.z, 0L));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements UrlDragImageView.p {
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

        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.a.z).param("obj_type", this.a.C));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements ha7.b {
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

        @Override // com.repackage.ha7.b
        public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) == null) || this.a.j == null) {
                return;
            }
            if (this.a.N) {
                if (!z3) {
                    this.a.j.removeAllViews();
                    this.a.q = 0;
                    this.a.a3();
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.S = !imageViewerActivity.S;
                } else if (!this.a.S) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f08ce);
                }
            }
            this.a.N = false;
            if (this.a.c != null) {
                this.a.c.setEnabled(true);
            }
            this.a.hideProgressBar();
            if (z2 && this.a.j.getCurrentItem() <= 4) {
                int itemNum = this.a.j.getItemNum();
                this.a.j.setTempSize(itemNum + 100);
                this.a.j.setCurrentItem(itemNum + 90, false);
                this.a.j.setTempSize(0);
            }
            this.a.j.setUrlData(arrayList);
            this.a.j.setAssistUrls(this.a.t);
            this.a.j.setHasNext(z);
            this.a.j.setNextTitle(str);
            if (i < 0 || i >= this.a.j.getItemNum()) {
                this.a.j.u(this.a.j.getCurrentItem());
            } else {
                this.a.j.setCurrentItem(i, false);
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
            if (this.a.K2() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (!this.a.H || this.a.G == null) {
                if (this.a.t0 != null) {
                    this.a.t0.o(this.a.K2(), this.a.r);
                    this.a.t0.l();
                    c(arrayList, advertAppInfo);
                }
            } else {
                this.a.G.D(this.a.u.Y() == 1);
                if (this.a.v0 || this.a.G.v(this.a.L2())) {
                    this.a.G.C(this.a.K2(), this.a.r);
                    this.a.G.s(this.a.S);
                    this.a.j.setUrlData(this.a.s);
                }
            }
            this.a.m3();
            if (this.a.n != null && this.a.j.getCurrentUrlDragImageView() != null) {
                this.a.n.q(this.a.j.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
            }
            if (this.a.v0) {
                this.a.v0 = false;
                this.a.R2();
            }
        }

        @Override // com.repackage.ha7.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.N = false;
                if (this.a.c != null) {
                    if (this.a.c.getState() != this.a.S && TextUtils.isEmpty(str)) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f08ce);
                    }
                    this.a.c.v(this.a.S ? 1 : 0);
                    this.a.c.setEnabled(true);
                }
                this.a.hideProgressBar();
                this.a.showToast(str);
                if (i == 40) {
                    if (this.a.s != null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.r = imageViewerActivity.s.size();
                    }
                    this.a.m3();
                }
                if (this.a.v0) {
                    this.a.v0 = false;
                    this.a.R2();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.t0 != null && advertAppInfo != null && arrayList != null) {
                    int n = advertAppInfo.n();
                    if (n != 0) {
                        this.a.d3(advertAppInfo, n);
                        return;
                    } else {
                        this.a.t0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.e3(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements d88 {
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

        @Override // com.repackage.d88
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.a.j.setUrlData(this.a.s);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements View.OnSystemUiVisibilityChangeListener {
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

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (i & 4) == 0) {
                this.a.setFullScreen();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = (String) ListUtils.getItem(this.a.s, this.a.q);
                if (this.a.H && this.a.G2() && pq6.d(str) && this.a.j0) {
                    int currentItem = this.a.j.getCurrentItem();
                    if (currentItem < this.a.s.size() - 1) {
                        this.a.s.remove(str);
                        this.a.j.setUrlData(this.a.s);
                        this.a.j.setCurrentItem(currentItem, true);
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

    public ImageViewerActivity() {
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
        this.H = UbsABTestHelper.isPicPageFunAdSdkTest() || UbsABTestHelper.isPicPageFunAdInsert();
        this.I = false;
        this.J = false;
        this.K = 0;
        this.O = false;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = true;
        this.Y = false;
        this.Z = true;
        this.g0 = false;
        this.h0 = false;
        this.i0 = false;
        this.j0 = true;
        this.v0 = true;
        this.w0 = new gg0();
        this.x0 = new k(this, 2016496);
        this.y0 = new o(this, 2016493);
        this.z0 = new p(this);
        this.B0 = new q(this);
        this.C0 = new r(this);
        this.D0 = new a(this);
        this.E0 = new c(this);
        this.G0 = new d(this);
        this.H0 = new e(this);
        this.I0 = new f(this);
        this.J0 = new g(this);
        this.K0 = new h(this);
        this.L0 = new m(this, 2016528);
        this.M0 = new n(this, 2016530);
    }

    public int F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int count = ListUtils.getCount(this.s);
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

    public final boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.P) {
                ta7 ta7Var = this.t0;
                if (ta7Var == null || !ta7Var.h(this.q)) {
                    sa7 sa7Var = this.G;
                    return sa7Var != null && sa7Var.t(this.q);
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void H2() {
        zy5 zy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (zy5Var = this.g) == null) {
            return;
        }
        zy5Var.I();
    }

    public final void I2() {
        zy5 zy5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (zy5Var = this.x) == null) {
            return;
        }
        zy5Var.I();
    }

    public Map<String, ImageUrlData> J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : (Map) invokeV.objValue;
    }

    public final long K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = (String) ListUtils.getItem(this.s, this.q);
            Map<String, ImageUrlData> map = this.t;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            long j2 = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
            return j2 == 0 ? this.q + 1 : j2;
        }
        return invokeV.longValue;
    }

    public final int L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) K2() : invokeV.intValue;
    }

    public String M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.C : (String) invokeV.objValue;
    }

    public String N2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    public final void O2(AlaInfoData alaInfoData) {
        AlaUserInfoData alaUserInfoData;
        HeadImageView headImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, alaInfoData) == null) || alaInfoData == null || (alaUserInfoData = alaInfoData.user_info) == null || (headImageView = this.e) == null) {
            return;
        }
        i3(headImageView, alaUserInfoData.portrait);
        this.e.setAlaInfo(alaInfoData);
        this.e.setOnClickListener(this.K0);
        if (!TextUtils.isEmpty(alaInfoData.tag)) {
            g3(alaInfoData.tag);
        }
        StatisticItem param = new StatisticItem("c13710").param("fid", this.y).param("fname", this.B).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.z);
        String str2 = "";
        if (alaInfoData.user_info != null) {
            str = "" + alaInfoData.user_info.user_id;
        } else {
            str = "";
        }
        StatisticItem param2 = param.param("obj_param1", str);
        int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData);
        if (alaInfoData.isLegalYYLiveData()) {
            TiebaStaticHelper.addYYParam(param2, alaInfoData.mYyExtData);
            str2 = TiebaStatic.YYValues.YY_LIVE;
        }
        param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
        param2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
        TiebaStatic.log(param2);
    }

    public final void P2(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (tBLottieAnimationView = this.f) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public final void Q2(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.h == z) {
            return;
        }
        TBLottieAnimationView tBLottieAnimationView = this.f;
        if (tBLottieAnimationView != null) {
            if (z) {
                tBLottieAnimationView.setVisibility(0);
                if (!this.f.isAnimating()) {
                    this.f.setSpeed(0.8f);
                    this.f.setRepeatCount(-1);
                    this.f.post(new i(this));
                }
            } else {
                tBLottieAnimationView.setVisibility(8);
                if (this.f.isAnimating()) {
                    this.f.cancelAnimation();
                }
            }
        }
        HeadImageView headImageView = this.e;
        if (headImageView != null) {
            headImageView.setVisibility(z ? 0 : 8);
        }
        this.h = z;
    }

    public final void R2() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String str = (String) ListUtils.getItem(this.s, this.q);
            Map<String, ImageUrlData> map = this.t;
            if (map == null || str == null || (imageUrlData = map.get(str)) == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13340").param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.z).param("obj_source", this.C).param("obj_param1", this.q).param(TiebaStatic.Params.OBJ_PARAM2, this.r - this.q).param(TiebaStatic.Params.OBJ_PARAM3, imageUrlData.mHeigth).param(TiebaStatic.Params.OBJ_PARAM4, imageUrlData.mWidth).param("obj_id", this.F));
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.p = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new v(this));
            this.l = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f09242f);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f08060d, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.p.setVisibility(0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void T2(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String str3;
        Map<String, ImageUrlData> map;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            this.v = new ma7();
            boolean k2 = n55.k();
            String b2 = n55.b();
            String f2 = n55.f();
            String e2 = n55.e();
            q3();
            if (bundle != null) {
                this.U = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                this.s = bundle.getStringArrayList("url");
                this.q = bundle.getInt("index", -1);
                this.y = bundle.getString("fid");
                this.z = bundle.getString("tid");
                this.A = bundle.getString("nid");
                this.B = bundle.getString("fname");
                this.E = bundle.getString("post_id");
                this.Y = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
                this.X = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
                this.P = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
                this.D = bundle.getString("user_id");
                this.C = bundle.getString("from");
                this.Q = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
                this.R = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
                this.k0 = bundle.getInt("thread_type");
                this.S = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
                Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
                this.l0 = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.W = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
                boolean z2 = bundle.getBoolean("is_login");
                String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
                String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
                String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
                this.Z = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.g0 = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
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
                this.V = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.T = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
                this.o0 = bundle.getInt("card_type", 0);
                this.p0 = bundle.getString("recom_source");
                this.q0 = bundle.getString("ab_tag");
                this.r0 = bundle.getString("weight");
                this.s0 = bundle.getString("extra");
                this.m0 = bundle.getString("from_forum_id");
                this.n0 = bundle.getInt("skin_type");
                this.h0 = bundle.getBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                this.j0 = bundle.getBoolean(ImageViewerConfig.NEED_REQUEST_AD, true);
                z = z2;
                str = string;
                str2 = string2;
                str3 = string3;
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    this.U = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                    this.s = intent.getStringArrayListExtra("url");
                    this.q = intent.getIntExtra("index", -1);
                    this.y = intent.getStringExtra("fid");
                    this.z = intent.getStringExtra("tid");
                    this.A = intent.getStringExtra("nid");
                    this.B = intent.getStringExtra("fname");
                    this.E = intent.getStringExtra("post_id");
                    this.Y = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                    this.X = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                    this.P = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                    this.D = intent.getStringExtra("user_id");
                    this.C = intent.getStringExtra("from");
                    this.Q = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                    this.R = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                    this.S = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                    this.k0 = intent.getIntExtra("thread_type", 0);
                    this.Z = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                    this.g0 = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                    this.V = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                    this.T = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                    z = intent.getBooleanExtra("is_login", false);
                    str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                    str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                    str2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                    this.l0 = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                    this.W = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                    Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                    if (serializableExtra instanceof Map) {
                        this.t = (Map) serializableExtra;
                    }
                    this.o0 = intent.getIntExtra("card_type", 0);
                    this.p0 = intent.getStringExtra("recom_source");
                    this.q0 = intent.getStringExtra("ab_tag");
                    this.r0 = intent.getStringExtra("weight");
                    this.s0 = intent.getStringExtra("extra");
                    this.m0 = intent.getStringExtra("from_forum_id");
                    this.n0 = intent.getIntExtra("skin_type", 0);
                    this.h0 = intent.getBooleanExtra(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                    this.j0 = intent.getBooleanExtra(ImageViewerConfig.NEED_REQUEST_AD, true);
                } else {
                    z = k2;
                    str = b2;
                    str2 = f2;
                    str3 = e2;
                }
            }
            n55.o(z);
            n55.n(str);
            n55.p(str3);
            n55.q(str2);
            this.v.d(bundle, getIntent());
            this.r = ListUtils.getCount(this.s);
            if (this.l0 != null) {
                String str4 = (String) ListUtils.getItem(this.s, this.q);
                if (!StringUtils.isNull(str4) && (map = this.t) != null && (imageUrlData = map.get(str4)) != null) {
                    imageUrlData.setSourceImageRectInScreen(this.l0);
                }
            }
            this.M = this.U ? null : ga7.a((String) ListUtils.getItem(this.s, this.q));
            if (this.S) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
        }
    }

    @Override // com.repackage.fg0
    @NonNull
    public gg0 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.w0 : (gg0) invokeV.objValue;
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.m = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090e43);
            qa7 qa7Var = new qa7(getPageContext(), this.m);
            this.n = qa7Var;
            qa7Var.r(this.m0);
            this.n.s(this.n0);
            this.n.m(this.n0);
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.U || this.T || this.h0) {
            return;
        }
        View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d01c7, (View.OnClickListener) null);
        this.u0 = addCustomView;
        addCustomView.setVisibility(this.i0 ? 8 : 0);
        this.d = this.u0.findViewById(R.id.obfuscated_res_0x7f0923a0);
        this.e = (HeadImageView) this.u0.findViewById(R.id.obfuscated_res_0x7f091579);
        this.f = (TBLottieAnimationView) this.u0.findViewById(R.id.obfuscated_res_0x7f092283);
        this.e.setIsRound(true);
        this.e.setPlaceHolder(1);
        if (this.R) {
            ArrayList arrayList = new ArrayList(2);
            vh8 vh8Var = new vh8();
            vh8Var.c(0);
            vh8Var.d(getString(R.string.obfuscated_res_0x7f0f0263));
            arrayList.add(vh8Var);
            vh8 vh8Var2 = new vh8();
            vh8Var2.c(1);
            vh8Var2.d(getString(R.string.obfuscated_res_0x7f0f0861));
            arrayList.add(vh8Var2);
            SortSwitchButton sortSwitchButton = (SortSwitchButton) this.u0.findViewById(R.id.obfuscated_res_0x7f090d59);
            this.c = sortSwitchButton;
            sortSwitchButton.setNeedDayNight(false);
            this.c.setData(arrayList, this.S ? 1 : 0);
            this.c.setVisibility(0);
            this.c.setOnSwitchChangeListener(this.D0);
            f3(this.d, 0);
            return;
        }
        f3(this.c, 8);
        f3(this.d, 8);
    }

    public final void W2(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ha7 ha7Var = new ha7(this.s, this.t, this.y, this.B, this.z, this.A, str, this.D, this.C, this.k0, z2, this.o0, this.p0, this.q0, this.r0, this.s0);
            this.u = ha7Var;
            ha7Var.h0(this.l0);
            this.u.f0(this.X);
            this.u.g0(z);
            this.u.Z(this.M);
            this.u.c0(this.W);
            this.u.e0(this.E);
            this.u.b0(this.g0);
            this.u.d0(new s(this));
            this.u.a0(true);
            if (this.j0) {
                this.t0.n(new t(this));
            }
            this.u.V();
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0914e4);
            this.a = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.a.setClickable(false);
            S2();
            V2();
            TextView textView = new TextView(this);
            this.b = textView;
            textView.setPadding(pi.f(this, R.dimen.tbds15), 0, 0, 0);
            this.b.setGravity(17);
            this.b.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.b.setTextSize(0, pi.f(this, R.dimen.tbds44));
            fr4.d(this.b).y(R.array.S_O_X001);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.b, (View.OnClickListener) null);
            if (ga7.b((String) ListUtils.getItem(this.s, this.q))) {
                this.a.setVisibility(0);
            }
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091d95);
            this.k = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.k.setLayoutParams(layoutParams);
            this.k.setVisibility(0);
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            X2();
            this.w = new na7(this);
            a3();
            this.w.w(this.j);
            m3();
            h3();
            Y2();
            U2();
            ma7 ma7Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.q;
            ma7Var.c(arrayList, i2, i2);
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            MultiImageView multiImageView = this.j;
            if (multiImageView == null) {
                this.j = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f0923a4);
            } else {
                multiImageView.q();
            }
            this.F = this.z + "_" + System.currentTimeMillis();
            this.j.setIsFromCDN(this.Y);
            this.j.setIsCanDrag(this.Q);
            this.j.setPageMargin(pi.d(getPageContext().getPageActivity(), 8.0f));
            this.j.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.j.setOnPageChangeListener(this.J0);
            this.j.setUrlData(this.s);
            this.j.setAssistUrls(this.t);
            this.j.setOuterOnTouchListener(this.G0);
            this.j.setItemOnclickListener(this.E0);
            this.j.setItemOnLongClickListener(this.H0);
            this.j.setCurrentItem(F2(), false);
            this.j.setOnScrollOutListener(this.I0);
            if (this.H && this.j0) {
                if (this.G == null) {
                    this.G = new sa7(this.s, this.y, this.z, this.P, this.q, getPageContext());
                }
                this.G.B(null);
                this.j.k(this.G);
            }
            if (this.t0 == null) {
                this.t0 = new ta7(this.s, this.y, this.B, this.Y, this.P, getPageContext(), this.z0, this.t);
            }
            this.j.k(this.t0);
            this.j.setOriImgSelectedCallback(this.C0);
            this.j.setDragToExitListener(this.z0);
            this.j.setUserId(this.D);
            this.j.setShowBottomContainer(this.Z);
            this.j.setOnShareImageListener(this.w);
            this.j.setOnDownloadImageListener(this.w);
            this.j.setOnReplyClickListener(this.B0);
            this.j.setYoungterCoverSomeView(this.i0);
            TiebaStatic.log(new StatisticItem("c13340").param("uid", this.D).param("post_id", this.z).param("obj_source", j3()));
        }
    }

    public boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.H && G2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f0809c8, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f08060d, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (dc5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    public final void d3(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.DISCARD).t(advertAppInfo.j).o(String.valueOf(advertAppInfo.position + 1)).i(String.valueOf(i2)).n(advertAppInfo.g);
            vx0.c(clogBuilder);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            this.w0.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || (multiImageView = this.j) == null) {
            return;
        }
        multiImageView.setAddSize(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void f3(View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048607, this, view2, i2) == null) || view2 == null) {
            return;
        }
        view2.clearAnimation();
        view2.setVisibility(i2);
    }

    public final void g3(@NonNull String str) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || (tBLottieAnimationView = this.f) == null) {
            return;
        }
        tBLottieAnimationView.post(new j(this, str));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.t75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (oi.isEmpty(this.z)) {
                return 0L;
            }
            return ng.g(this.z, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public w75 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            w75 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(ng.g(this.y, 0L));
                pageStayDurationItem.C(ng.g(this.z, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (w75) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.t75
    public u75 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? new l(this) : (u75) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.T || this.c == null) {
            return;
        }
        if (this.x == null) {
            zy5 zy5Var = new zy5(getPageContext(), this.c);
            this.x = zy5Var;
            zy5Var.g0(R.drawable.pic_sign_tip);
            this.x.O(48);
            this.x.h0(true);
            this.x.N(5000);
            this.x.j0(-pi.f(getPageContext().getPageActivity(), R.dimen.tbds26));
            this.x.M(new b(this));
        }
        this.x.m0(getPageContext().getString(R.string.obfuscated_res_0x7f0f03d9), "key_large_image_tip_count");
    }

    public final void i3(TbImageView tbImageView, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048614, this, tbImageView, str) == null) || tbImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = " ";
        }
        if (str.toLowerCase().startsWith("http")) {
            tbImageView.J(str, 10, false);
        } else {
            tbImageView.J(str, 12, false);
        }
    }

    public final int j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (StringUtils.isNULL(this.C)) {
                return 7;
            }
            if (this.C.equals("pb")) {
                return 5;
            }
            if (this.C.equals("frs")) {
                return 3;
            }
            return this.C.equals("index") ? 1 : 7;
        }
        return invokeV.intValue;
    }

    public final void k3(int i2) {
        ha7 ha7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048616, this, i2) == null) || (ha7Var = this.u) == null) {
            return;
        }
        ArrayList<AlaInfoData> T = ha7Var.T();
        if (T != null && T.size() > 0) {
            Q2(true);
            O2(T.get(i2 % T.size()));
            return;
        }
        Q2(false);
    }

    public final void l3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i2) == null) || (multiImageView = this.j) == null) {
            return;
        }
        multiImageView.l(i2);
        int i3 = (this.j.t() || G2()) ? 8 : 0;
        f3(this.c, i3);
        f3(this.d, i3);
    }

    public final void m3() {
        String str;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || this.s == null) {
            return;
        }
        long K2 = K2();
        String str2 = ("" + K2) + "/";
        if (this.r > 0) {
            str = str2 + this.r;
        } else {
            str = str2 + StringHelper.STRING_MORE;
        }
        if (this.C != null && !this.O && K2() == this.r && (this.C.equals("frs") || this.C.equals("index"))) {
            TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.C));
            this.O = true;
        }
        if (G2()) {
            long j2 = -1;
            String str3 = (String) ListUtils.getItem(this.s, this.q - 1);
            if (!StringUtils.isNull(str3) && (imageUrlData = this.t.get(str3)) != null) {
                j2 = imageUrlData.overAllIndex;
            }
            n3(j2, this.r);
        } else {
            o3(str);
        }
        long j3 = K2 - 1;
        k3(j3 > 0 ? (int) j3 : 0);
    }

    public final void n3(long j2, int i2) {
        sa7 sa7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ta7 ta7Var = this.t0;
            if ((ta7Var != null && ta7Var.j()) || ((sa7Var = this.G) != null && sa7Var.u())) {
                this.b.setText("");
            } else if (j2 > 0) {
                this.b.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.b.setText("");
            }
            f3(this.c, 8);
            f3(this.d, 8);
        }
    }

    public final void o3(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.b.setText(str);
            if (this.R && !this.T && (sortSwitchButton = this.c) != null) {
                sortSwitchButton.v(this.S ? 1 : 0);
            }
            fr4.d(this.b).y(R.array.S_O_X001);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.n.l(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.j.setBackgroundColor(-16777216);
            this.j.y(i2);
            super.onChangeSkinType(i2);
            this.L = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            P2(i2);
            na7 na7Var = this.w;
            if (na7Var != null) {
                na7Var.y();
            }
            qa7 qa7Var = this.n;
            if (qa7Var != null) {
                qa7Var.m(this.n0);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.j.setCurrentItem(this.q, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f08060d, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bundle) == null) {
            if (Build.VERSION.SDK_INT >= 28 && TbSingleton.getInstance().isNotchScreen(this)) {
                setUseStyleImmersiveSticky(false);
            }
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.systemUiVisibility = 2050;
            window.setAttributes(attributes);
            super.onCreate(bundle);
            p55.f().g(TbadkCoreApplication.getInst());
            p55.i(new ImageFpsEvent());
            this.L = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            T2(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d03b9);
            Z2();
            W2(this.M, this.S, false);
            registerListener(this.y0);
            registerListener(this.x0);
            registerListener(this.L0);
            registerListener(this.M0);
            addGlobalLayoutListener();
            VoiceManager u0 = u0();
            this.o = u0;
            u0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                po8.b(1, getWindow().getAttributes(), getWindow());
            }
            if (!TbSingleton.getInstance().hasDownloadEmotion() && ni.H() && TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
                TbSingleton.getInstance().setHasDownloadEmotion(true);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.y0);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            j35.k().r();
            ma7 ma7Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.q;
            ma7Var.c(arrayList, i2, i2);
            this.v.g();
            ha7 ha7Var = this.u;
            if (ha7Var != null) {
                String U = ha7Var.U();
                str2 = this.u.X();
                str = U;
            } else {
                str = null;
                str2 = null;
            }
            this.v.j(this.j.getPageCount(), "", this.y, this.z, str, str2);
            na7 na7Var = this.w;
            if (na7Var != null) {
                na7Var.B();
            }
            this.j.v();
            this.n.n();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d05.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.L);
            I2();
            H2();
            ta7 ta7Var = this.t0;
            if (ta7Var != null) {
                ta7Var.k();
            }
            sa7 sa7Var = this.G;
            if (sa7Var != null) {
                sa7Var.y();
            }
            p55.i(new PrePageKeyEvent(getCurrentPageKey()));
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048626, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.q);
                setResult(-1, intent);
                finish();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            this.j.w();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = ng.g(this.z, 0L);
            if (uniqueId != null && g2 > 0) {
                li4.f(uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.n.o();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            this.j.x();
            this.mIsLogin = n55.k();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = ng.g(this.z, 0L);
            if (uniqueId != null && g2 > 0) {
                li4.j(vh4.b0, uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.n.p();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            bundle.putBoolean(ImageViewerConfig.IS_BJH, this.U);
            bundle.putStringArrayList("url", this.s);
            bundle.putInt("index", this.q);
            bundle.putString("fid", this.y);
            bundle.putString("tid", this.z);
            bundle.putString("fname", this.B);
            bundle.putString("post_id", this.E);
            bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.X);
            bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.Q);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.R);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.P);
            bundle.putString("user_id", this.D);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.Z);
            bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.g0);
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
            bundle.putInt("thread_type", this.k0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.S);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.l0);
            bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.V);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.T);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.W);
            bundle.putBoolean("is_login", n55.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, n55.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, n55.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, n55.f());
            bundle.putString("from_forum_id", this.m0);
            bundle.putInt("skin_type", this.n0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.h0);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.i0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.j0);
            this.v.f(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            super.onWindowFocusChanged(z);
            setFullScreen();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new u(this));
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (G2()) {
                this.J = this.a.getVisibility() == 0;
                this.I = true;
            } else if (this.I) {
                this.a.setVisibility(this.J ? 0 : 8);
                this.I = false;
            }
            c3();
        }
    }

    public final void q3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        vb5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.j.v();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
        }
    }

    public final void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            getWindow().getDecorView().setSystemUiVisibility(1284);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (this.o == null) {
                this.o = VoiceManager.instance();
            }
            return this.o;
        }
        return (VoiceManager) invokeV.objValue;
    }
}
