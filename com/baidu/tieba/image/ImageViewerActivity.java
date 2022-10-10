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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.an8;
import com.baidu.tieba.bx4;
import com.baidu.tieba.cf7;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.cx4;
import com.baidu.tieba.d55;
import com.baidu.tieba.dh;
import com.baidu.tieba.di0;
import com.baidu.tieba.dj;
import com.baidu.tieba.ef7;
import com.baidu.tieba.ei0;
import com.baidu.tieba.ej;
import com.baidu.tieba.ff7;
import com.baidu.tieba.fh5;
import com.baidu.tieba.gm4;
import com.baidu.tieba.h01;
import com.baidu.tieba.h85;
import com.baidu.tieba.hd8;
import com.baidu.tieba.hh5;
import com.baidu.tieba.hv4;
import com.baidu.tieba.la5;
import com.baidu.tieba.mn8;
import com.baidu.tieba.na5;
import com.baidu.tieba.pu8;
import com.baidu.tieba.ql4;
import com.baidu.tieba.s45;
import com.baidu.tieba.se7;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.te7;
import com.baidu.tieba.vc5;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.wg5;
import com.baidu.tieba.wu6;
import com.baidu.tieba.x36;
import com.baidu.tieba.xc5;
import com.baidu.tieba.yc5;
import com.baidu.tieba.ye7;
import com.baidu.tieba.yq6;
import com.baidu.tieba.yu6;
import com.baidu.tieba.ze7;
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
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.j, di0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public final CustomMessageListener A0;
    public String B;
    public DragImageView.h B0;
    public String C;
    public yq6 C0;
    public String D;
    public View.OnClickListener D0;
    public String E;
    public UrlDragImageView.p E0;
    public String F;
    public final SortSwitchButton.f F0;
    public ef7 G;
    public View.OnClickListener G0;
    public final boolean H;
    public float H0;
    public boolean I;
    public View.OnTouchListener I0;
    public boolean J;
    public View.OnLongClickListener J0;
    public int K;
    public BaseViewPager.a K0;
    public int L;
    public ViewPager.OnPageChangeListener L0;
    public String M;
    public View.OnClickListener M0;
    public boolean N;
    public CustomMessageListener N0;
    public boolean O;
    public CustomMessageListener O0;
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
    public boolean a0;
    public TextView b;
    public boolean b0;
    public SortSwitchButton c;
    public boolean c0;
    public AlaLiveTipView d;
    public boolean d0;
    public x36 e;
    public LiveRemindData e0;
    public boolean f;
    public int f0;
    public String g;
    public int g0;
    public MultiImageView h;
    public String h0;
    public View i;
    public String i0;
    public ImageView j;
    public int j0;
    public LinearLayout k;
    public cf7 l;
    public VoiceManager m;
    public View n;
    public int o;
    public int p;
    public View q;
    public int q0;
    public ArrayList<String> r;
    public String r0;
    public Map<String, ImageUrlData> s;
    public String s0;
    public te7 t;
    public String t0;
    public ye7 u;
    public String u0;
    public ze7 v;
    public ff7 v0;
    public x36 w;
    public View w0;
    public String x;
    public boolean x0;
    public String y;
    public final ei0 y0;
    public String z;
    public CustomMessageListener z0;

    /* loaded from: classes4.dex */
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
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    this.a.N = true;
                    if (this.a.c != null) {
                        this.a.c.setEnabled(false);
                    }
                    String a = se7.a((String) ListUtils.getItem(this.a.r, this.a.o));
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.T2(a, !imageViewerActivity.S, true);
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", this.a.S ? 7 : 8).param("post_id", this.a.y).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.x));
                    return true;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c59);
                return false;
            }
            return invokeI.booleanValue;
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
                this.a.G2();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.h.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.h.getCurrentMaxIndex()));
                TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.H0 = motionEvent.getX();
                    return false;
                } else if (action == 1 || action == 2 || action == 3) {
                    this.a.H0 = motionEvent.getX();
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                    if (this.a.v != null) {
                        this.a.v.A();
                    }
                } else if (this.a.v != null) {
                    this.a.v.F();
                    this.a.v.G();
                    this.a.v.y(view2);
                }
                TiebaStatic.log(new StatisticItem("c13269").param("uid", this.a.C).param("fid", this.a.x).param("tid", this.a.y));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.t.V();
                } else if (this.a.I2() == 1) {
                } else {
                    this.a.t.W();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.r != null && this.a.o < this.a.r.size()) {
                    this.a.u.e(i, (String) this.a.r.get(this.a.o));
                }
                if (i != 1 || this.a.G == null) {
                    return;
                }
                if ((this.a.o == 0 || this.a.G.w(this.a.o)) && !wu6.m().v(wu6.r()) && this.a.G.A(this.a.o)) {
                    this.a.h.setUrlData(this.a.r);
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
                    DragImageView currentView = this.a.h != null ? this.a.h.getCurrentView() : null;
                    boolean d0 = currentView != null ? currentView.d0() : false;
                    if (this.a.I2() == 1 && d0) {
                        this.a.setSwipeBackEnabled(true);
                    } else {
                        this.a.setSwipeBackEnabled(false);
                    }
                    this.a.F2();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.t != null && i > this.a.h.getItemNum() - 5) {
                    this.a.t.V();
                }
                this.a.u.c(this.a.r, this.a.o, i);
                this.a.o = i;
                this.a.i3();
                this.a.l3();
                this.a.h3(i);
                if (this.a.u.a() < this.a.o) {
                    this.a.u.h(this.a.o);
                }
                if (this.a.u.b() > this.a.o) {
                    this.a.u.i(this.a.o);
                }
                if (this.a.G != null) {
                    boolean z = true;
                    this.a.G.D((this.a.t == null || this.a.t.Y() != 1) ? false : false);
                    this.a.G.z(i);
                    if (this.a.E2() && this.a.H && this.a.G.x(i)) {
                        this.a.G.B(null);
                    }
                }
                if (this.a.v0 != null) {
                    this.a.v0.m(i);
                }
                if (this.a.v != null) {
                    this.a.v.D();
                }
                if (this.a.l != null && this.a.h.getCurrentUrlDragImageView() != null) {
                    this.a.l.q(this.a.h.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.t);
                }
                if (this.a.x0) {
                    return;
                }
                this.a.O2();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            StatisticItem param = new StatisticItem("c13711").param("fid", this.a.x).param("fname", this.a.A).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.y);
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

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageViewerActivity b;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.b.F2();
                }
            }
        }

        public i(ImageViewerActivity imageViewerActivity, String str) {
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
                if (this.b.e != null) {
                    if (this.b.g == null || this.b.e == null || this.b.d == null || this.b.d.getVisibility() != 0) {
                        this.b.F2();
                        return;
                    }
                    this.b.e.w0(this.a);
                    this.b.g = null;
                    return;
                }
                ImageViewerActivity imageViewerActivity = this.b;
                imageViewerActivity.e = new x36(imageViewerActivity.getPageContext(), this.b.d);
                this.b.e.q0(R.drawable.obfuscated_res_0x7f0802f4);
                this.b.e.T(32);
                this.b.e.r0(true);
                this.b.e.g0(1);
                this.b.e.u0(0);
                this.b.e.S(3000);
                this.b.e.R(new a(this));
                if (this.b.d == null || this.b.d.getVisibility() == 0) {
                    this.b.e.w0(this.a);
                    return;
                }
                this.b.g = this.a;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends vc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity b;

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
            this.b = imageViewerActivity;
        }

        @Override // com.baidu.tieba.vc5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? yc5.b().c() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.vc5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.a.setVisibility(((Boolean) customResponsedMessage.getData()).booleanValue() ? 0 : 8);
                this.a.F2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ImageViewerActivity imageViewerActivity, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof an8) || this.a.s == null || (agreeData = ((an8) customResponsedMessage.getData()).b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : this.a.s.values()) {
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

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof an8) || this.a.s == null || (agreeData = ((an8) customResponsedMessage.getData()).b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : this.a.s.values()) {
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
            s45 s45Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof s45) || (s45Var = (s45) customResponsedMessage.getData()) == null || StringUtils.isNull(s45Var.a)) {
                return;
            }
            hh5.h(s45Var);
            if (StringUtils.isNull(s45Var.c)) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{s45Var.a});
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{s45Var.a, s45Var.c});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        public o(ImageViewerActivity imageViewerActivity) {
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
                imageViewerActivity.c3(imageViewerActivity.b, 8);
                ImageViewerActivity imageViewerActivity2 = this.a;
                imageViewerActivity2.c3(imageViewerActivity2.c, 8);
                ImageViewerActivity imageViewerActivity3 = this.a;
                imageViewerActivity3.c3(imageViewerActivity3.n, 8);
                ImageViewerActivity imageViewerActivity4 = this.a;
                imageViewerActivity4.c3(imageViewerActivity4.d, 8);
                if (this.a.h != null) {
                    this.a.h.A(false);
                }
                this.a.G2();
                this.a.F2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.h.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.h.getCurrentMaxIndex()));
                this.a.finish();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.c3(imageViewerActivity.b, 0);
                this.a.n.setVisibility(0);
                if (this.a.h == null || this.a.E2()) {
                    return;
                }
                boolean t = this.a.h.t();
                if ("portrait".equals(this.a.B) || t) {
                    return;
                }
                ImageViewerActivity imageViewerActivity2 = this.a;
                imageViewerActivity2.c3(imageViewerActivity2.c, 0);
                ImageViewerActivity imageViewerActivity3 = this.a;
                imageViewerActivity3.c3(imageViewerActivity3.d, 0);
                ImageViewerActivity imageViewerActivity4 = this.a;
                imageViewerActivity4.d3(imageViewerActivity4.g);
                if (this.a.Z) {
                    this.a.h.A(true);
                } else {
                    this.a.h.A(false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* loaded from: classes4.dex */
        public class a implements yq6.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = pVar;
            }

            @Override // com.baidu.tieba.yq6.d
            public void a(boolean z, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                }
            }

            @Override // com.baidu.tieba.yq6.d
            public void b(boolean z) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || !z || this.a.a.l == null || this.a.a.h.getCurrentUrlDragImageView() == null) {
                    return;
                }
                this.a.a.l.u(this.a.a.h.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.a.t);
            }

            @Override // com.baidu.tieba.yq6.d
            public void c(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                }
            }
        }

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

        /* JADX DEBUG: Multi-variable search result rejected for r5v28, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "3").param("post_id", this.a.y).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.x));
                if (la5.a(this.a)) {
                    if (this.a.C0 == null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.C0 = new yq6(imageViewerActivity.getPageContext());
                        this.a.C0.i(new a(this));
                    }
                    this.a.C0.j(((this.a.h == null || this.a.h.getCurrentUrlDragImageView() == null || this.a.h.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? 1 : this.a.h.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost) ^ 1);
                    this.a.C0.g(this.a.x, dh.g(this.a.y, 0L));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements UrlDragImageView.p {
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

        @Override // com.baidu.tbadk.coreExtra.view.UrlDragImageView.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.a.y).param("obj_type", this.a.B));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements te7.b {
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

        @Override // com.baidu.tieba.te7.b
        public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) == null) || this.a.h == null) {
                return;
            }
            if (this.a.N) {
                if (!z3) {
                    this.a.h.removeAllViews();
                    this.a.o = 0;
                    this.a.X2();
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.S = !imageViewerActivity.S;
                } else if (!this.a.S) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f08ef);
                }
            }
            this.a.N = false;
            if (this.a.c != null) {
                this.a.c.setEnabled(true);
            }
            this.a.hideProgressBar();
            if (z2 && this.a.h.getCurrentItem() <= 4) {
                int itemNum = this.a.h.getItemNum();
                this.a.h.setTempSize(itemNum + 100);
                this.a.h.setCurrentItem(itemNum + 90, false);
                this.a.h.setTempSize(0);
            }
            this.a.h.setUrlData(arrayList);
            this.a.h.setAssistUrls(this.a.s);
            this.a.h.setHasNext(z);
            this.a.h.setNextTitle(str);
            if (i < 0 || i >= this.a.h.getItemNum()) {
                this.a.h.u(this.a.h.getCurrentItem());
            } else {
                this.a.h.setCurrentItem(i, false);
            }
            if (i2 != 0) {
                this.a.p = i2;
            }
            if (arrayList != null && arrayList.size() >= 400 && this.a.h.getCurrentItem() > 200) {
                for (int i3 = 0; i3 < 200; i3++) {
                    arrayList.remove(0);
                }
                this.a.h.setUrlData(arrayList);
                this.a.h.setCurrentItem(this.a.h.getCurrentItem() - 200, false);
            }
            if (this.a.I2() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (!this.a.H || this.a.G == null) {
                if (this.a.v0 != null) {
                    this.a.v0.o(this.a.I2(), this.a.p);
                    this.a.v0.l();
                    c(arrayList, advertAppInfo);
                }
            } else {
                this.a.G.D(this.a.t.Y() == 1);
                if (this.a.x0 || this.a.G.v(this.a.J2())) {
                    this.a.G.C(this.a.I2(), this.a.p);
                    this.a.G.s(this.a.S);
                    this.a.h.setUrlData(this.a.r);
                }
            }
            this.a.i3();
            if (this.a.l != null && this.a.h.getCurrentUrlDragImageView() != null) {
                this.a.l.q(this.a.h.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.t);
            }
            if (this.a.x0) {
                this.a.x0 = false;
                this.a.O2();
            }
        }

        @Override // com.baidu.tieba.te7.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.N = false;
                if (this.a.c != null) {
                    if (this.a.c.getState() != this.a.S && TextUtils.isEmpty(str)) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f08ef);
                    }
                    this.a.c.w(this.a.S ? 1 : 0);
                    this.a.c.setEnabled(true);
                }
                this.a.hideProgressBar();
                this.a.showToast(str);
                if (i == 40) {
                    if (this.a.r != null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.p = imageViewerActivity.r.size();
                    }
                    this.a.i3();
                }
                if (this.a.x0) {
                    this.a.x0 = false;
                    this.a.O2();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.v0 != null && advertAppInfo != null && arrayList != null) {
                    int n = advertAppInfo.n();
                    if (n != 0) {
                        this.a.a3(advertAppInfo, n);
                        return;
                    } else {
                        this.a.v0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.b3(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements hd8 {
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

        @Override // com.baidu.tieba.hd8
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.a.h.setUrlData(this.a.r);
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
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (i & 4) == 0) {
                this.a.setFullScreen();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = (String) ListUtils.getItem(this.a.r, this.a.o);
                if (this.a.H && this.a.E2() && yu6.d(str) && this.a.d0) {
                    int currentItem = this.a.h.getCurrentItem();
                    if (currentItem < this.a.r.size() - 1) {
                        this.a.r.remove(str);
                        this.a.h.setUrlData(this.a.r);
                        this.a.h.setCurrentItem(currentItem, true);
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
        this.f = false;
        this.o = -1;
        this.p = -1;
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
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.d0 = true;
        this.x0 = true;
        this.y0 = new ei0();
        this.z0 = new k(this, 2016496);
        this.A0 = new n(this, 2016493);
        this.B0 = new o(this);
        this.D0 = new p(this);
        this.E0 = new q(this);
        this.F0 = new a(this);
        this.G0 = new c(this);
        this.I0 = new d(this);
        this.J0 = new e(this);
        this.K0 = new f(this);
        this.L0 = new g(this);
        this.M0 = new h(this);
        this.N0 = new l(this, 2016528);
        this.O0 = new m(this, 2016530);
    }

    public int D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int count = ListUtils.getCount(this.r);
            if (count > 0) {
                int i2 = this.o;
                if (i2 >= count) {
                    this.o = count - 1;
                } else if (i2 < 0) {
                    this.o = 0;
                }
            } else {
                this.o = 0;
            }
            return this.o;
        }
        return invokeV.intValue;
    }

    public final boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.P) {
                ff7 ff7Var = this.v0;
                if (ff7Var == null || !ff7Var.h(this.o)) {
                    ef7 ef7Var = this.G;
                    return ef7Var != null && ef7Var.t(this.o);
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void F2() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (x36Var = this.e) == null) {
            return;
        }
        x36Var.N();
    }

    public final void G2() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (x36Var = this.w) == null) {
            return;
        }
        x36Var.N();
    }

    public Map<String, ImageUrlData> H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : (Map) invokeV.objValue;
    }

    public final long I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = (String) ListUtils.getItem(this.r, this.o);
            Map<String, ImageUrlData> map = this.s;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            long j2 = imageUrlData != null ? imageUrlData.overAllIndex : 0L;
            return j2 == 0 ? this.o + 1 : j2;
        }
        return invokeV.longValue;
    }

    public final int J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) I2() : invokeV.intValue;
    }

    public String K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public String L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (String) invokeV.objValue;
    }

    public final void M2(AlaInfoData alaInfoData) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, alaInfoData) == null) || alaInfoData == null || alaInfoData.user_info == null || (alaLiveTipView = this.d) == null) {
            return;
        }
        alaLiveTipView.setOnClickListener(this.M0);
        if (TextUtils.isEmpty(alaInfoData.tag)) {
            return;
        }
        d3(alaInfoData.tag);
    }

    public final void N2(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.f == z) {
            return;
        }
        AlaLiveTipView alaLiveTipView = this.d;
        if (alaLiveTipView != null) {
            alaLiveTipView.setVisibility(z ? 0 : 8);
        }
        this.f = z;
    }

    public final void O2() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String str = (String) ListUtils.getItem(this.r, this.o);
            Map<String, ImageUrlData> map = this.s;
            if (map == null || str == null || (imageUrlData = map.get(str)) == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13340").param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.y).param("obj_source", this.B).param("obj_param1", this.o).param(TiebaStatic.Params.OBJ_PARAM2, this.p - this.o).param(TiebaStatic.Params.OBJ_PARAM3, imageUrlData.mHeigth).param(TiebaStatic.Params.OBJ_PARAM4, imageUrlData.mWidth).param("obj_type", this.F));
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.n = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new u(this));
            this.j = (ImageView) this.n.findViewById(R.id.obfuscated_res_0x7f092680);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080628, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.n.setVisibility(0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: java.util.Map<java.lang.String, com.baidu.tbadk.coreExtra.view.ImageUrlData> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Q2(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String str3;
        Map<String, ImageUrlData> map;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            this.u = new ye7();
            boolean k2 = la5.k();
            String b2 = la5.b();
            String f2 = la5.f();
            String e2 = la5.e();
            m3();
            if (bundle != null) {
                this.U = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                this.r = bundle.getStringArrayList("url");
                this.o = bundle.getInt("index", -1);
                this.x = bundle.getString("fid");
                this.y = bundle.getString("tid");
                this.z = bundle.getString("nid");
                this.A = bundle.getString("fname");
                this.D = bundle.getString("post_id");
                this.E = bundle.getString(IntentConfig.BJH_POST_ID);
                this.Y = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
                this.X = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
                this.P = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
                this.C = bundle.getString("user_id");
                this.B = bundle.getString("from");
                this.Q = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
                this.R = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
                this.g0 = bundle.getInt("thread_type");
                this.S = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
                Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
                this.h0 = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.W = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
                boolean z2 = bundle.getBoolean("is_login");
                String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
                String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
                String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
                this.Z = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.a0 = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                if (serializable instanceof Map) {
                    this.s = new ConcurrentHashMap();
                    for (Map.Entry entry : ((Map) serializable).entrySet()) {
                        if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                            try {
                                this.s.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
                this.V = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.T = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
                this.q0 = bundle.getInt("card_type", 0);
                this.r0 = bundle.getString("recom_source");
                this.s0 = bundle.getString("ab_tag");
                this.t0 = bundle.getString("weight");
                this.u0 = bundle.getString("extra");
                this.i0 = bundle.getString("from_forum_id");
                this.j0 = bundle.getInt("skin_type");
                this.b0 = bundle.getBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                Serializable serializable2 = bundle.getSerializable(ImageViewerConfig.REMIND_LIVE_DATA);
                if (serializable2 instanceof LiveRemindData) {
                    this.e0 = (LiveRemindData) serializable2;
                }
                this.f0 = bundle.getInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY);
                this.d0 = bundle.getBoolean(ImageViewerConfig.NEED_REQUEST_AD, true);
                z = z2;
                str = string;
                str2 = string2;
                str3 = string3;
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    this.U = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                    this.r = intent.getStringArrayListExtra("url");
                    this.o = intent.getIntExtra("index", -1);
                    this.x = intent.getStringExtra("fid");
                    this.y = intent.getStringExtra("tid");
                    this.z = intent.getStringExtra("nid");
                    this.A = intent.getStringExtra("fname");
                    this.D = intent.getStringExtra("post_id");
                    this.E = intent.getStringExtra(IntentConfig.BJH_POST_ID);
                    this.Y = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                    this.X = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                    this.P = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                    this.C = intent.getStringExtra("user_id");
                    this.B = intent.getStringExtra("from");
                    this.Q = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                    this.R = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                    this.S = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                    this.g0 = intent.getIntExtra("thread_type", 0);
                    this.Z = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                    this.a0 = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                    this.V = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                    this.T = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                    z = intent.getBooleanExtra("is_login", false);
                    str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                    str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                    str2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                    this.h0 = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                    this.W = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                    Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                    if (serializableExtra instanceof Map) {
                        this.s = (Map) serializableExtra;
                    }
                    this.q0 = intent.getIntExtra("card_type", 0);
                    this.r0 = intent.getStringExtra("recom_source");
                    this.s0 = intent.getStringExtra("ab_tag");
                    this.t0 = intent.getStringExtra("weight");
                    this.u0 = intent.getStringExtra("extra");
                    this.i0 = intent.getStringExtra("from_forum_id");
                    this.j0 = intent.getIntExtra("skin_type", 0);
                    this.b0 = intent.getBooleanExtra(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                    this.d0 = intent.getBooleanExtra(ImageViewerConfig.NEED_REQUEST_AD, true);
                    Serializable serializableExtra2 = intent.getSerializableExtra(ImageViewerConfig.REMIND_LIVE_DATA);
                    if (serializableExtra2 instanceof LiveRemindData) {
                        this.e0 = (LiveRemindData) serializableExtra2;
                    }
                    this.f0 = intent.getIntExtra(ImageViewerConfig.REMIND_LIVE_FREQUENCY, 0);
                } else {
                    z = k2;
                    str = b2;
                    str2 = f2;
                    str3 = e2;
                }
            }
            la5.o(z);
            la5.n(str);
            la5.p(str3);
            la5.q(str2);
            this.u.d(bundle, getIntent());
            this.p = ListUtils.getCount(this.r);
            if (this.h0 != null) {
                String str4 = (String) ListUtils.getItem(this.r, this.o);
                if (!StringUtils.isNull(str4) && (map = this.s) != null && (imageUrlData = map.get(str4)) != null) {
                    imageUrlData.setSourceImageRectInScreen(this.h0);
                }
            }
            this.M = this.U ? null : se7.a((String) ListUtils.getItem(this.r, this.o));
            if (this.S) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            bx4.a().d(this.e0);
            cx4.b().n(this.f0);
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090eb2);
            cf7 cf7Var = new cf7(getPageContext(), this.k);
            this.l = cf7Var;
            cf7Var.r(this.i0);
            this.l.s(this.j0);
            this.l.m(this.j0);
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.U || this.T || this.b0) {
            return;
        }
        View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d01cc, (View.OnClickListener) null);
        this.w0 = addCustomView;
        addCustomView.setVisibility(this.c0 ? 8 : 0);
        AlaLiveTipView alaLiveTipView = (AlaLiveTipView) this.w0.findViewById(R.id.obfuscated_res_0x7f0919c8);
        this.d = alaLiveTipView;
        alaLiveTipView.setViewLocate(2);
        this.d.setForumInfo(this.x, this.A, this.y);
        this.d.setNormalBottomMarginParams(ej.f(getPageContext().getPageActivity(), R.dimen.tbds5));
        if (this.R) {
            ArrayList arrayList = new ArrayList(2);
            mn8 mn8Var = new mn8();
            mn8Var.c(0);
            mn8Var.d(getString(R.string.obfuscated_res_0x7f0f026d));
            arrayList.add(mn8Var);
            mn8 mn8Var2 = new mn8();
            mn8Var2.c(1);
            mn8Var2.d(getString(R.string.obfuscated_res_0x7f0f087d));
            arrayList.add(mn8Var2);
            SortSwitchButton sortSwitchButton = (SortSwitchButton) this.w0.findViewById(R.id.obfuscated_res_0x7f090dc3);
            this.c = sortSwitchButton;
            sortSwitchButton.setNeedDayNight(false);
            this.c.setData(arrayList, this.S ? 1 : 0);
            this.c.setVisibility(0);
            this.c.setOnSwitchChangeListener(this.F0);
            c3(this.d, 0);
            return;
        }
        c3(this.c, 8);
        c3(this.d, 8);
    }

    public final void T2(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            te7 te7Var = new te7(this.r, this.s, this.x, this.A, this.y, this.z, str, this.C, this.B, this.g0, z2, this.q0, this.r0, this.s0, this.t0, this.u0);
            this.t = te7Var;
            te7Var.i0(this.h0);
            this.t.g0(this.X);
            this.t.h0(z);
            this.t.a0(this.M);
            this.t.d0(this.W);
            this.t.f0(this.D);
            this.t.Z(this.E);
            this.t.c0(this.a0);
            this.t.e0(new r(this));
            this.t.b0(true);
            if (this.d0) {
                this.v0.n(new s(this));
            }
            this.t.V();
        }
    }

    @Override // com.baidu.tieba.di0
    @NonNull
    public ei0 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.y0 : (ei0) invokeV.objValue;
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091657);
            this.a = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.a.setClickable(false);
            P2();
            S2();
            TextView textView = new TextView(this);
            this.b = textView;
            textView.setPadding(ej.f(this, R.dimen.tbds15), 0, 0, 0);
            this.b.setGravity(17);
            this.b.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.b.setTextSize(0, ej.f(this, R.dimen.tbds44));
            hv4.d(this.b).y(R.array.S_O_X001);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.b, (View.OnClickListener) null);
            if (se7.b((String) ListUtils.getItem(this.r, this.o))) {
                this.a.setVisibility(0);
            }
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091f89);
            this.i = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.i.setLayoutParams(layoutParams);
            this.i.setVisibility(0);
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0919cc);
            this.q = findViewById;
            hv4.d(findViewById).p(new int[]{R.color.CAM_X0608, R.color.CAM_X0601}, Direction.TOP);
            U2();
            this.v = new ze7(this);
            X2();
            this.v.x(this.h);
            i3();
            e3();
            V2();
            R2();
            ye7 ye7Var = this.u;
            ArrayList<String> arrayList = this.r;
            int i2 = this.o;
            ye7Var.c(arrayList, i2, i2);
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            MultiImageView multiImageView = this.h;
            if (multiImageView == null) {
                this.h = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f0925da);
            } else {
                multiImageView.q();
            }
            this.F = this.y + "_" + System.currentTimeMillis();
            this.h.setIsFromCDN(this.Y);
            this.h.setIsCanDrag(this.Q);
            this.h.setPageMargin(ej.d(getPageContext().getPageActivity(), 8.0f));
            this.h.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.h.setOnPageChangeListener(this.L0);
            this.h.setUrlData(this.r);
            this.h.setAssistUrls(this.s);
            this.h.setOuterOnTouchListener(this.I0);
            this.h.setItemOnclickListener(this.G0);
            this.h.setItemOnLongClickListener(this.J0);
            this.h.setCurrentItem(D2(), false);
            this.h.setOnScrollOutListener(this.K0);
            if (this.H && this.d0) {
                if (this.G == null) {
                    this.G = new ef7(this.r, this.x, this.y, this.P, this.o, getPageContext());
                }
                this.G.B(null);
                this.h.k(this.G);
            }
            if (this.v0 == null) {
                this.v0 = new ff7(this.r, this.x, this.A, this.Y, this.P, getPageContext(), this.B0, this.s);
            }
            this.h.k(this.v0);
            this.h.setOriImgSelectedCallback(this.E0);
            this.h.setDragToExitListener(this.B0);
            this.h.setUserId(this.C);
            this.h.setShowBottomContainer(this.Z);
            this.h.setOnShareImageListener(this.v);
            this.h.setOnDownloadImageListener(this.v);
            this.h.setOnReplyClickListener(this.D0);
            this.h.setYoungterCoverSomeView(this.c0);
            TiebaStatic.log(new StatisticItem("c13340").param("uid", this.C).param("post_id", this.y).param("obj_source", f3()));
        }
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.H && E2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080a13, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080628, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void a3(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            h01.b(clogBuilder);
        }
    }

    public void b3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (multiImageView = this.h) == null) {
            return;
        }
        multiImageView.setAddSize(i2);
    }

    public final void c3(View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048602, this, view2, i2) == null) || view2 == null) {
            return;
        }
        view2.clearAnimation();
        view2.setVisibility(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (fh5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    public final void d3(@NonNull String str) {
        AlaLiveTipView alaLiveTipView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (alaLiveTipView = this.d) == null) {
            return;
        }
        alaLiveTipView.post(new i(this, str));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, motionEvent)) == null) {
            this.y0.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.T || this.c == null) {
            return;
        }
        if (this.w == null) {
            x36 x36Var = new x36(getPageContext(), this.c);
            this.w = x36Var;
            x36Var.q0(R.drawable.pic_sign_tip);
            this.w.T(48);
            this.w.r0(true);
            this.w.S(5000);
            this.w.u0(-ej.f(getPageContext().getPageActivity(), R.dimen.tbds26));
            this.w.R(new b(this));
        }
        this.w.x0(getPageContext().getString(R.string.obfuscated_res_0x7f0f03f0), "key_large_image_tip_count");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    public final int f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (StringUtils.isNULL(this.B)) {
                return 7;
            }
            if (this.B.equals("pb")) {
                return 5;
            }
            if (this.B.equals("frs")) {
                return 3;
            }
            return this.B.equals("index") ? 1 : 7;
        }
        return invokeV.intValue;
    }

    public final void g3(int i2) {
        te7 te7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || (te7Var = this.t) == null) {
            return;
        }
        ArrayList<AlaInfoData> T = te7Var.T();
        if (T != null && T.size() > 0) {
            N2(true);
            M2(T.get(i2 % T.size()));
            return;
        }
        N2(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.uc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? "a008" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (dj.isEmpty(this.y)) {
                return 0L;
            }
            return dh.g(this.y, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public xc5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            xc5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(dh.g(this.x, 0L));
                pageStayDurationItem.C(dh.g(this.y, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (xc5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.uc5
    public vc5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? new j(this) : (vc5) invokeV.objValue;
    }

    public final void h3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i2) == null) || (multiImageView = this.h) == null) {
            return;
        }
        multiImageView.l(i2);
        int i3 = (this.h.t() || E2()) ? 8 : 0;
        c3(this.c, i3);
        c3(this.d, i3);
    }

    public final void i3() {
        String str;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.r == null) {
            return;
        }
        long I2 = I2();
        String str2 = ("" + I2) + "/";
        if (this.p > 0) {
            str = str2 + this.p;
        } else {
            str = str2 + StringHelper.STRING_MORE;
        }
        if (this.B != null && !this.O && I2() == this.p && (this.B.equals("frs") || this.B.equals("index"))) {
            TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.B));
            this.O = true;
        }
        if (E2()) {
            long j2 = -1;
            String str3 = (String) ListUtils.getItem(this.r, this.o - 1);
            if (!StringUtils.isNull(str3) && (imageUrlData = this.s.get(str3)) != null) {
                j2 = imageUrlData.overAllIndex;
            }
            j3(j2, this.p);
        } else {
            k3(str);
        }
        long j3 = I2 - 1;
        g3(j3 > 0 ? (int) j3 : 0);
    }

    public final void j3(long j2, int i2) {
        ef7 ef7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ff7 ff7Var = this.v0;
            if ((ff7Var != null && ff7Var.j()) || ((ef7Var = this.G) != null && ef7Var.u())) {
                this.b.setText("");
            } else if (j2 > 0) {
                this.b.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.b.setText("");
            }
            c3(this.c, 8);
            c3(this.d, 8);
        }
    }

    public final void k3(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.b.setText(str);
            if (this.R && !this.T && (sortSwitchButton = this.c) != null) {
                sortSwitchButton.w(this.S ? 1 : 0);
            }
            hv4.d(this.b).y(R.array.S_O_X001);
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (E2()) {
                this.J = this.a.getVisibility() == 0;
                this.I = true;
            } else if (this.I) {
                this.a.setVisibility(this.J ? 0 : 8);
                this.I = false;
            }
            Z2();
        }
    }

    public final void m3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        wg5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.l.l(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.h.setBackgroundColor(-16777216);
            this.h.y(i2);
            super.onChangeSkinType(i2);
            this.L = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            ze7 ze7Var = this.v;
            if (ze7Var != null) {
                ze7Var.z();
            }
            cf7 cf7Var = this.l;
            if (cf7Var != null) {
                cf7Var.m(this.j0);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.h.setCurrentItem(this.o, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080628, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
            na5.f().g(TbadkCoreApplication.getInst());
            na5.i(new ImageFpsEvent());
            this.L = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            Q2(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d03c4);
            W2();
            T2(this.M, this.S, false);
            registerListener(this.A0);
            registerListener(this.z0);
            registerListener(this.N0);
            registerListener(this.O0);
            addGlobalLayoutListener();
            VoiceManager t0 = t0();
            this.m = t0;
            t0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                pu8.b(1, getWindow().getAttributes(), getWindow());
            }
            if (!TbSingleton.getInstance().hasDownloadEmotion() && BdNetTypeUtil.isWifiNet() && TbadkCoreApplication.isLogin()) {
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
            MessageManager.getInstance().unRegisterListener(this.A0);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            h85.k().r();
            ye7 ye7Var = this.u;
            ArrayList<String> arrayList = this.r;
            int i2 = this.o;
            ye7Var.c(arrayList, i2, i2);
            this.u.g();
            te7 te7Var = this.t;
            if (te7Var != null) {
                String U = te7Var.U();
                str2 = this.t.X();
                str = U;
            } else {
                str = null;
                str2 = null;
            }
            this.u.j(this.h.getPageCount(), "", this.x, this.y, str, str2);
            ze7 ze7Var = this.v;
            if (ze7Var != null) {
                ze7Var.C();
            }
            this.h.v();
            this.l.n();
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d55.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.L);
            G2();
            F2();
            ff7 ff7Var = this.v0;
            if (ff7Var != null) {
                ff7Var.k();
            }
            ef7 ef7Var = this.G;
            if (ef7Var != null) {
                ef7Var.y();
            }
            na5.i(new PrePageKeyEvent(getCurrentPageKey()));
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2001277);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048626, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.o);
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
            this.h.w();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = dh.g(this.y, 0L);
            if (uniqueId != null && g2 > 0) {
                gm4.f(uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            this.l.o();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            this.h.x();
            this.mIsLogin = la5.k();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = dh.g(this.y, 0L);
            if (uniqueId != null && g2 > 0) {
                gm4.j(ql4.d0, uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.l.p();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            bundle.putBoolean(ImageViewerConfig.IS_BJH, this.U);
            bundle.putStringArrayList("url", this.r);
            bundle.putInt("index", this.o);
            bundle.putString("fid", this.x);
            bundle.putString("tid", this.y);
            bundle.putString("fname", this.A);
            bundle.putString("post_id", this.D);
            bundle.putString(IntentConfig.BJH_POST_ID, this.E);
            bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.X);
            bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.Q);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.R);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.P);
            bundle.putString("user_id", this.C);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.Z);
            bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.a0);
            Map<String, ImageUrlData> map = this.s;
            if (map instanceof HashMap) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, ImageUrlData> entry : this.s.entrySet()) {
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
                for (Map.Entry<String, ImageUrlData> entry2 : this.s.entrySet()) {
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
            bundle.putString("from", this.B);
            bundle.putInt("thread_type", this.g0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.S);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.h0);
            bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.V);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.T);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.W);
            bundle.putBoolean("is_login", la5.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, la5.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, la5.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, la5.f());
            bundle.putString("from_forum_id", this.i0);
            bundle.putInt("skin_type", this.j0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.b0);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.c0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.d0);
            bundle.putSerializable(ImageViewerConfig.REMIND_LIVE_DATA, this.e0);
            bundle.putInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY, this.f0);
            this.u.f(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.m;
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
            VoiceManager voiceManager = this.m;
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
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new t(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.h.v();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void setCurrentActivityTid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
        }
    }

    public final void setFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            getWindow().getDecorView().setSystemUiVisibility(1284);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.m == null) {
                this.m = VoiceManager.instance();
            }
            return this.m;
        }
        return (VoiceManager) invokeV.objValue;
    }
}
