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
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
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
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ad7;
import com.repackage.cj4;
import com.repackage.cs8;
import com.repackage.d25;
import com.repackage.dd7;
import com.repackage.el8;
import com.repackage.eu4;
import com.repackage.fb8;
import com.repackage.fd7;
import com.repackage.fu4;
import com.repackage.gd7;
import com.repackage.ge5;
import com.repackage.hg0;
import com.repackage.hy0;
import com.repackage.i55;
import com.repackage.ie5;
import com.repackage.ig0;
import com.repackage.m75;
import com.repackage.ms4;
import com.repackage.o16;
import com.repackage.o75;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.qo6;
import com.repackage.s15;
import com.repackage.sj4;
import com.repackage.sk8;
import com.repackage.ss6;
import com.repackage.tc7;
import com.repackage.uc7;
import com.repackage.us6;
import com.repackage.v95;
import com.repackage.x95;
import com.repackage.xd5;
import com.repackage.y95;
import com.repackage.zc7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class ImageViewerActivity extends BaseActivity<ImageViewerActivity> implements VoiceManager.j, hg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public qo6 A0;
    public String B;
    public View.OnClickListener B0;
    public String C;
    public UrlDragImageView.p C0;
    public String D;
    public final SortSwitchButton.f D0;
    public fd7 E;
    public View.OnClickListener E0;
    public final boolean F;
    public float F0;
    public boolean G;
    public View.OnTouchListener G0;
    public boolean H;
    public View.OnLongClickListener H0;
    public int I;
    public BaseViewPager.a I0;
    public int J;
    public ViewPager.OnPageChangeListener J0;
    public String K;
    public View.OnClickListener K0;
    public boolean L;
    public CustomMessageListener L0;
    public boolean M;
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
    public boolean a0;
    public TextView b;
    public boolean b0;
    public SortSwitchButton c;
    public LiveRemindData c0;
    public AlaLiveTipView d;
    public int d0;
    public o16 e;
    public int e0;
    public boolean f;
    public String f0;
    public String g;
    public String g0;
    public MultiImageView h;
    public int h0;
    public View i;
    public int i0;
    public ImageView j;
    public String j0;
    public LinearLayout k;
    public dd7 l;
    public VoiceManager m;
    public View n;
    public int o;
    public int p;
    public ArrayList<String> q;
    public String q0;
    public Map<String, ImageUrlData> r;
    public String r0;
    public uc7 s;
    public String s0;
    public zc7 t;
    public gd7 t0;
    public ad7 u;
    public View u0;
    public o16 v;
    public boolean v0;
    public String w;
    public final ig0 w0;
    public String x;
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
                if (oi.A()) {
                    this.a.L = true;
                    if (this.a.c != null) {
                        this.a.c.setEnabled(false);
                    }
                    String a = tc7.a((String) ListUtils.getItem(this.a.q, this.a.o));
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.T2(a, !imageViewerActivity.Q, true);
                    TiebaStatic.log(new StatisticItem("c13857").param("obj_type", this.a.Q ? 7 : 8).param("post_id", this.a.x).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.w));
                    return true;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3c);
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
                this.a.G2();
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
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.h.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.h.getCurrentMaxIndex()));
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
                    if (this.a.u != null) {
                        this.a.u.A();
                    }
                } else if (this.a.u != null) {
                    this.a.u.F();
                    this.a.u.G();
                    this.a.u.y(view2);
                }
                TiebaStatic.log(new StatisticItem("c13269").param("uid", this.a.B).param("fid", this.a.w).param("tid", this.a.x));
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
                    this.a.s.V();
                } else if (this.a.I2() == 1) {
                } else {
                    this.a.s.W();
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
                if (this.a.q != null && this.a.o < this.a.q.size()) {
                    this.a.t.e(i, (String) this.a.q.get(this.a.o));
                }
                if (i != 1 || this.a.E == null) {
                    return;
                }
                if ((this.a.o == 0 || this.a.E.w(this.a.o)) && !ss6.m().v(ss6.r()) && this.a.E.A(this.a.o)) {
                    this.a.h.setUrlData(this.a.q);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                if (i > this.a.I) {
                    this.a.I = i;
                } else if (i < this.a.I) {
                    this.a.I = i;
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
                if (this.a.s != null && i > this.a.h.getItemNum() - 5) {
                    this.a.s.V();
                }
                this.a.t.c(this.a.q, this.a.o, i);
                this.a.o = i;
                this.a.i3();
                this.a.l3();
                this.a.h3(i);
                if (this.a.t.a() < this.a.o) {
                    this.a.t.h(this.a.o);
                }
                if (this.a.t.b() > this.a.o) {
                    this.a.t.i(this.a.o);
                }
                if (this.a.E != null) {
                    boolean z = true;
                    this.a.E.D((this.a.s == null || this.a.s.Y() != 1) ? false : false);
                    this.a.E.z(i);
                    if (this.a.E2() && this.a.F && this.a.E.x(i)) {
                        this.a.E.B(null);
                    }
                }
                if (this.a.t0 != null) {
                    this.a.t0.m(i);
                }
                if (this.a.u != null) {
                    this.a.u.D();
                }
                if (this.a.l != null && this.a.h.getCurrentUrlDragImageView() != null) {
                    this.a.l.q(this.a.h.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.s);
                }
                if (this.a.v0) {
                    return;
                }
                this.a.O2();
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
            StatisticItem param = new StatisticItem("c13711").param("fid", this.a.w).param("fname", this.a.z).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.x);
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
        public final /* synthetic */ String a;
        public final /* synthetic */ ImageViewerActivity b;

        /* loaded from: classes3.dex */
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
                imageViewerActivity.e = new o16(imageViewerActivity.getPageContext(), this.b.d);
                this.b.e.q0(R.drawable.obfuscated_res_0x7f0802f0);
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

    /* loaded from: classes3.dex */
    public class j extends v95 {
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

        @Override // com.repackage.v95
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? y95.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.v95
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof sk8) || this.a.r == null || (agreeData = ((sk8) customResponsedMessage.getData()).b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : this.a.r.values()) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof sk8) || this.a.r == null || (agreeData = ((sk8) customResponsedMessage.getData()).b) == null || TextUtils.isEmpty(agreeData.threadId) || TextUtils.isEmpty(agreeData.postId)) {
                return;
            }
            for (ImageUrlData imageUrlData : this.a.r.values()) {
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
            s15 s15Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof s15) || (s15Var = (s15) customResponsedMessage.getData()) == null || StringUtils.isNull(s15Var.a)) {
                return;
            }
            ie5.h(s15Var);
            if (StringUtils.isNull(s15Var.c)) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{s15Var.a});
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{s15Var.a, s15Var.c});
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if ("portrait".equals(this.a.A) || t) {
                    return;
                }
                ImageViewerActivity imageViewerActivity2 = this.a;
                imageViewerActivity2.c3(imageViewerActivity2.c, 0);
                ImageViewerActivity imageViewerActivity3 = this.a;
                imageViewerActivity3.c3(imageViewerActivity3.d, 0);
                ImageViewerActivity imageViewerActivity4 = this.a;
                imageViewerActivity4.d3(imageViewerActivity4.g);
                if (this.a.X) {
                    this.a.h.A(true);
                } else {
                    this.a.h.A(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageViewerActivity a;

        /* loaded from: classes3.dex */
        public class a implements qo6.d {
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

            @Override // com.repackage.qo6.d
            public void a(boolean z, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                }
            }

            @Override // com.repackage.qo6.d
            public void b(boolean z) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || !z || this.a.a.l == null || this.a.a.h.getCurrentUrlDragImageView() == null) {
                    return;
                }
                this.a.a.l.u(this.a.a.h.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.a.s);
            }

            @Override // com.repackage.qo6.d
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
                TiebaStatic.log(new StatisticItem("c13857").param("obj_type", "3").param("post_id", this.a.x).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.w));
                if (m75.a(this.a)) {
                    if (this.a.A0 == null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.A0 = new qo6(imageViewerActivity.getPageContext());
                        this.a.A0.i(new a(this));
                    }
                    this.a.A0.j(((this.a.h == null || this.a.h.getCurrentUrlDragImageView() == null || this.a.h.getCurrentUrlDragImageView().getmAssistUrlData() == null) ? 1 : this.a.h.getCurrentUrlDragImageView().getmAssistUrlData().isFirstPost) ^ 1);
                    this.a.A0.g(this.a.w, og.g(this.a.x, 0L));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.a.x).param("obj_type", this.a.A));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements uc7.b {
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

        @Override // com.repackage.uc7.b
        public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) == null) || this.a.h == null) {
                return;
            }
            if (this.a.L) {
                if (!z3) {
                    this.a.h.removeAllViews();
                    this.a.o = 0;
                    this.a.X2();
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.Q = !imageViewerActivity.Q;
                } else if (!this.a.Q) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f08d8);
                }
            }
            this.a.L = false;
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
            this.a.h.setAssistUrls(this.a.r);
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
            if (!this.a.F || this.a.E == null) {
                if (this.a.t0 != null) {
                    this.a.t0.o(this.a.I2(), this.a.p);
                    this.a.t0.l();
                    c(arrayList, advertAppInfo);
                }
            } else {
                this.a.E.D(this.a.s.Y() == 1);
                if (this.a.v0 || this.a.E.v(this.a.J2())) {
                    this.a.E.C(this.a.I2(), this.a.p);
                    this.a.E.s(this.a.Q);
                    this.a.h.setUrlData(this.a.q);
                }
            }
            this.a.i3();
            if (this.a.l != null && this.a.h.getCurrentUrlDragImageView() != null) {
                this.a.l.q(this.a.h.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.s);
            }
            if (this.a.v0) {
                this.a.v0 = false;
                this.a.O2();
            }
        }

        @Override // com.repackage.uc7.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.L = false;
                if (this.a.c != null) {
                    if (this.a.c.getState() != this.a.Q && TextUtils.isEmpty(str)) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f08d8);
                    }
                    this.a.c.w(this.a.Q ? 1 : 0);
                    this.a.c.setEnabled(true);
                }
                this.a.hideProgressBar();
                this.a.showToast(str);
                if (i == 40) {
                    if (this.a.q != null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.p = imageViewerActivity.q.size();
                    }
                    this.a.i3();
                }
                if (this.a.v0) {
                    this.a.v0 = false;
                    this.a.O2();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.t0 != null && advertAppInfo != null && arrayList != null) {
                    int n = advertAppInfo.n();
                    if (n != 0) {
                        this.a.a3(advertAppInfo, n);
                        return;
                    } else {
                        this.a.t0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.b3(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements fb8 {
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

        @Override // com.repackage.fb8
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.a.h.setUrlData(this.a.q);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                String str = (String) ListUtils.getItem(this.a.q, this.a.o);
                if (this.a.F && this.a.E2() && us6.d(str) && this.a.b0) {
                    int currentItem = this.a.h.getCurrentItem();
                    if (currentItem < this.a.q.size() - 1) {
                        this.a.q.remove(str);
                        this.a.h.setUrlData(this.a.q);
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
        this.F = UbsABTestHelper.isPicPageFunAdSdkTest() || UbsABTestHelper.isPicPageFunAdInsert();
        this.G = false;
        this.H = false;
        this.I = 0;
        this.M = false;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = true;
        this.W = false;
        this.X = true;
        this.Y = false;
        this.Z = false;
        this.a0 = false;
        this.b0 = true;
        this.v0 = true;
        this.w0 = new ig0();
        this.x0 = new k(this, 2016496);
        this.y0 = new n(this, 2016493);
        this.z0 = new o(this);
        this.B0 = new p(this);
        this.C0 = new q(this);
        this.D0 = new a(this);
        this.E0 = new c(this);
        this.G0 = new d(this);
        this.H0 = new e(this);
        this.I0 = new f(this);
        this.J0 = new g(this);
        this.K0 = new h(this);
        this.L0 = new l(this, 2016528);
        this.M0 = new m(this, 2016530);
    }

    public int D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int count = ListUtils.getCount(this.q);
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
            if (this.N) {
                gd7 gd7Var = this.t0;
                if (gd7Var == null || !gd7Var.h(this.o)) {
                    fd7 fd7Var = this.E;
                    return fd7Var != null && fd7Var.t(this.o);
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void F2() {
        o16 o16Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (o16Var = this.e) == null) {
            return;
        }
        o16Var.N();
    }

    public final void G2() {
        o16 o16Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (o16Var = this.v) == null) {
            return;
        }
        o16Var.N();
    }

    public Map<String, ImageUrlData> H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : (Map) invokeV.objValue;
    }

    public final long I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = (String) ListUtils.getItem(this.q, this.o);
            Map<String, ImageUrlData> map = this.r;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public String L2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public final void M2(AlaInfoData alaInfoData) {
        AlaLiveTipView alaLiveTipView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, alaInfoData) == null) || alaInfoData == null || alaInfoData.user_info == null || (alaLiveTipView = this.d) == null) {
            return;
        }
        alaLiveTipView.setOnClickListener(this.K0);
        if (!TextUtils.isEmpty(alaInfoData.tag)) {
            d3(alaInfoData.tag);
        }
        StatisticItem param = new StatisticItem("c13710").param("fid", this.w).param("fname", this.z).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.x);
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
            String str = (String) ListUtils.getItem(this.q, this.o);
            Map<String, ImageUrlData> map = this.r;
            if (map == null || str == null || (imageUrlData = map.get(str)) == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13340").param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.x).param("obj_source", this.A).param("obj_param1", this.o).param(TiebaStatic.Params.OBJ_PARAM2, this.p - this.o).param(TiebaStatic.Params.OBJ_PARAM3, imageUrlData.mHeigth).param(TiebaStatic.Params.OBJ_PARAM4, imageUrlData.mWidth).param("obj_type", this.D));
        }
    }

    @Override // com.repackage.hg0
    @NonNull
    public ig0 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.w0 : (ig0) invokeV.objValue;
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.n = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new u(this));
            this.j = (ImageView) this.n.findViewById(R.id.obfuscated_res_0x7f092614);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080612, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            this.t = new zc7();
            boolean k2 = m75.k();
            String b2 = m75.b();
            String f2 = m75.f();
            String e2 = m75.e();
            m3();
            if (bundle != null) {
                this.S = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                this.q = bundle.getStringArrayList("url");
                this.o = bundle.getInt("index", -1);
                this.w = bundle.getString("fid");
                this.x = bundle.getString("tid");
                this.y = bundle.getString("nid");
                this.z = bundle.getString("fname");
                this.C = bundle.getString("post_id");
                this.W = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
                this.V = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
                this.N = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
                this.B = bundle.getString("user_id");
                this.A = bundle.getString("from");
                this.O = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
                this.P = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
                this.e0 = bundle.getInt("thread_type");
                this.Q = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
                Serializable serializable = bundle.getSerializable(ImageViewerConfig.ASSIST_URLS);
                this.f0 = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.U = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
                boolean z2 = bundle.getBoolean("is_login");
                String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
                String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
                String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
                this.X = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.Y = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                if (serializable instanceof Map) {
                    this.r = new ConcurrentHashMap();
                    for (Map.Entry entry : ((Map) serializable).entrySet()) {
                        if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                            try {
                                this.r.put(entry.getKey(), (ImageUrlData) OrmObject.objectWithJsonStr((String) entry.getValue(), ImageUrlData.class));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
                this.T = bundle.getBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                this.R = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
                this.i0 = bundle.getInt("card_type", 0);
                this.j0 = bundle.getString("recom_source");
                this.q0 = bundle.getString("ab_tag");
                this.r0 = bundle.getString("weight");
                this.s0 = bundle.getString("extra");
                this.g0 = bundle.getString("from_forum_id");
                this.h0 = bundle.getInt("skin_type");
                this.Z = bundle.getBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                Serializable serializable2 = bundle.getSerializable(ImageViewerConfig.REMIND_LIVE_DATA);
                if (serializable2 instanceof LiveRemindData) {
                    this.c0 = (LiveRemindData) serializable2;
                }
                this.d0 = bundle.getInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY);
                this.b0 = bundle.getBoolean(ImageViewerConfig.NEED_REQUEST_AD, true);
                z = z2;
                str = string;
                str2 = string2;
                str3 = string3;
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    this.S = intent.getBooleanExtra(ImageViewerConfig.IS_BJH, false);
                    this.q = intent.getStringArrayListExtra("url");
                    this.o = intent.getIntExtra("index", -1);
                    this.w = intent.getStringExtra("fid");
                    this.x = intent.getStringExtra("tid");
                    this.y = intent.getStringExtra("nid");
                    this.z = intent.getStringExtra("fname");
                    this.C = intent.getStringExtra("post_id");
                    this.W = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                    this.V = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                    this.N = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                    this.B = intent.getStringExtra("user_id");
                    this.A = intent.getStringExtra("from");
                    this.O = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                    this.P = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                    this.Q = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                    this.e0 = intent.getIntExtra("thread_type", 0);
                    this.X = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                    this.Y = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                    this.T = intent.getBooleanExtra(ImageViewerConfig.IS_IDENTIFY_IMAGE, true);
                    this.R = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                    z = intent.getBooleanExtra("is_login", false);
                    str = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                    str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                    str2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                    this.f0 = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                    this.U = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                    Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                    if (serializableExtra instanceof Map) {
                        this.r = (Map) serializableExtra;
                    }
                    this.i0 = intent.getIntExtra("card_type", 0);
                    this.j0 = intent.getStringExtra("recom_source");
                    this.q0 = intent.getStringExtra("ab_tag");
                    this.r0 = intent.getStringExtra("weight");
                    this.s0 = intent.getStringExtra("extra");
                    this.g0 = intent.getStringExtra("from_forum_id");
                    this.h0 = intent.getIntExtra("skin_type", 0);
                    this.Z = intent.getBooleanExtra(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                    this.b0 = intent.getBooleanExtra(ImageViewerConfig.NEED_REQUEST_AD, true);
                    Serializable serializableExtra2 = intent.getSerializableExtra(ImageViewerConfig.REMIND_LIVE_DATA);
                    if (serializableExtra2 instanceof LiveRemindData) {
                        this.c0 = (LiveRemindData) serializableExtra2;
                    }
                    this.d0 = intent.getIntExtra(ImageViewerConfig.REMIND_LIVE_FREQUENCY, 0);
                } else {
                    z = k2;
                    str = b2;
                    str2 = f2;
                    str3 = e2;
                }
            }
            m75.o(z);
            m75.n(str);
            m75.p(str3);
            m75.q(str2);
            this.t.d(bundle, getIntent());
            this.p = ListUtils.getCount(this.q);
            if (this.f0 != null) {
                String str4 = (String) ListUtils.getItem(this.q, this.o);
                if (!StringUtils.isNull(str4) && (map = this.r) != null && (imageUrlData = map.get(str4)) != null) {
                    imageUrlData.setSourceImageRectInScreen(this.f0);
                }
            }
            this.K = this.S ? null : tc7.a((String) ListUtils.getItem(this.q, this.o));
            if (this.Q) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            eu4.a().d(this.c0);
            fu4.b().n(this.d0);
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.k = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090e96);
            dd7 dd7Var = new dd7(getPageContext(), this.k);
            this.l = dd7Var;
            dd7Var.r(this.g0);
            this.l.s(this.h0);
            this.l.m(this.h0);
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.S || this.R || this.Z) {
            return;
        }
        View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d01c8, (View.OnClickListener) null);
        this.u0 = addCustomView;
        addCustomView.setVisibility(this.a0 ? 8 : 0);
        AlaLiveTipView alaLiveTipView = (AlaLiveTipView) this.u0.findViewById(R.id.obfuscated_res_0x7f091987);
        this.d = alaLiveTipView;
        alaLiveTipView.setViewLocate(2);
        this.d.setForumInfo(this.w, this.z, this.x);
        if (this.P) {
            ArrayList arrayList = new ArrayList(2);
            el8 el8Var = new el8();
            el8Var.c(0);
            el8Var.d(getString(R.string.obfuscated_res_0x7f0f0268));
            arrayList.add(el8Var);
            el8 el8Var2 = new el8();
            el8Var2.c(1);
            el8Var2.d(getString(R.string.obfuscated_res_0x7f0f0869));
            arrayList.add(el8Var2);
            SortSwitchButton sortSwitchButton = (SortSwitchButton) this.u0.findViewById(R.id.obfuscated_res_0x7f090da7);
            this.c = sortSwitchButton;
            sortSwitchButton.setNeedDayNight(false);
            this.c.setData(arrayList, this.Q ? 1 : 0);
            this.c.setVisibility(0);
            this.c.setOnSwitchChangeListener(this.D0);
            c3(this.d, 0);
            return;
        }
        c3(this.c, 8);
        c3(this.d, 8);
    }

    public final void T2(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            uc7 uc7Var = new uc7(this.q, this.r, this.w, this.z, this.x, this.y, str, this.B, this.A, this.e0, z2, this.i0, this.j0, this.q0, this.r0, this.s0);
            this.s = uc7Var;
            uc7Var.h0(this.f0);
            this.s.f0(this.V);
            this.s.g0(z);
            this.s.Z(this.K);
            this.s.c0(this.U);
            this.s.e0(this.C);
            this.s.b0(this.Y);
            this.s.d0(new r(this));
            this.s.a0(true);
            if (this.b0) {
                this.t0.n(new s(this));
            }
            this.s.V();
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091624);
            this.a = navigationBar;
            navigationBar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
            this.a.setClickable(false);
            P2();
            S2();
            TextView textView = new TextView(this);
            this.b = textView;
            textView.setPadding(qi.f(this, R.dimen.tbds15), 0, 0, 0);
            this.b.setGravity(17);
            this.b.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            this.b.setTextSize(0, qi.f(this, R.dimen.tbds44));
            ms4.d(this.b).y(R.array.S_O_X001);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.b, (View.OnClickListener) null);
            if (tc7.b((String) ListUtils.getItem(this.q, this.o))) {
                this.a.setVisibility(0);
            }
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091f34);
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
            U2();
            this.u = new ad7(this);
            X2();
            this.u.x(this.h);
            i3();
            e3();
            V2();
            R2();
            zc7 zc7Var = this.t;
            ArrayList<String> arrayList = this.q;
            int i2 = this.o;
            zc7Var.c(arrayList, i2, i2);
        }
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            MultiImageView multiImageView = this.h;
            if (multiImageView == null) {
                this.h = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f092570);
            } else {
                multiImageView.q();
            }
            this.D = this.x + "_" + System.currentTimeMillis();
            this.h.setIsFromCDN(this.W);
            this.h.setIsCanDrag(this.O);
            this.h.setPageMargin(qi.d(getPageContext().getPageActivity(), 8.0f));
            this.h.setOffscreenPageLimit(2, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.h.setOnPageChangeListener(this.J0);
            this.h.setUrlData(this.q);
            this.h.setAssistUrls(this.r);
            this.h.setOuterOnTouchListener(this.G0);
            this.h.setItemOnclickListener(this.E0);
            this.h.setItemOnLongClickListener(this.H0);
            this.h.setCurrentItem(D2(), false);
            this.h.setOnScrollOutListener(this.I0);
            if (this.F && this.b0) {
                if (this.E == null) {
                    this.E = new fd7(this.q, this.w, this.x, this.N, this.o, getPageContext());
                }
                this.E.B(null);
                this.h.k(this.E);
            }
            if (this.t0 == null) {
                this.t0 = new gd7(this.q, this.w, this.z, this.W, this.N, getPageContext(), this.z0, this.r);
            }
            this.h.k(this.t0);
            this.h.setOriImgSelectedCallback(this.C0);
            this.h.setDragToExitListener(this.z0);
            this.h.setUserId(this.B);
            this.h.setShowBottomContainer(this.X);
            this.h.setOnShareImageListener(this.u);
            this.h.setOnDownloadImageListener(this.u);
            this.h.setOnReplyClickListener(this.B0);
            this.h.setYoungterCoverSomeView(this.a0);
            TiebaStatic.log(new StatisticItem("c13340").param("uid", this.B).param("post_id", this.x).param("obj_source", f3()));
        }
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.F && E2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f0809f3, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080612, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final void a3(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            hy0.b(clogBuilder);
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
            if (ge5.a()) {
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
            this.w0.a(motionEvent);
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
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.R || this.c == null) {
            return;
        }
        if (this.v == null) {
            o16 o16Var = new o16(getPageContext(), this.c);
            this.v = o16Var;
            o16Var.q0(R.drawable.pic_sign_tip);
            this.v.T(48);
            this.v.r0(true);
            this.v.S(5000);
            this.v.u0(-qi.f(getPageContext().getPageActivity(), R.dimen.tbds26));
            this.v.R(new b(this));
        }
        this.v.x0(getPageContext().getString(R.string.obfuscated_res_0x7f0f03eb), "key_large_image_tip_count");
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
            if (StringUtils.isNULL(this.A)) {
                return 7;
            }
            if (this.A.equals("pb")) {
                return 5;
            }
            if (this.A.equals("frs")) {
                return 3;
            }
            return this.A.equals("index") ? 1 : 7;
        }
        return invokeV.intValue;
    }

    public final void g3(int i2) {
        uc7 uc7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || (uc7Var = this.s) == null) {
            return;
        }
        ArrayList<AlaInfoData> T = uc7Var.T();
        if (T != null && T.size() > 0) {
            N2(true);
            M2(T.get(i2 % T.size()));
            return;
        }
        N2(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.u95
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
            if (pi.isEmpty(this.x)) {
                return 0L;
            }
            return og.g(this.x, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public x95 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            x95 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.t(og.g(this.w, 0L));
                pageStayDurationItem.C(og.g(this.x, 0L));
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    pageStayDurationItem.q(TbadkCoreApplication.getInst().getAdAdSense().k);
                }
            }
            return pageStayDurationItem;
        }
        return (x95) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.u95
    public v95 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? new j(this) : (v95) invokeV.objValue;
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
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.q == null) {
            return;
        }
        long I2 = I2();
        String str2 = ("" + I2) + "/";
        if (this.p > 0) {
            str = str2 + this.p;
        } else {
            str = str2 + StringHelper.STRING_MORE;
        }
        if (this.A != null && !this.M && I2() == this.p && (this.A.equals("frs") || this.A.equals("index"))) {
            TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.A));
            this.M = true;
        }
        if (E2()) {
            long j2 = -1;
            String str3 = (String) ListUtils.getItem(this.q, this.o - 1);
            if (!StringUtils.isNull(str3) && (imageUrlData = this.r.get(str3)) != null) {
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
        fd7 fd7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            gd7 gd7Var = this.t0;
            if ((gd7Var != null && gd7Var.j()) || ((fd7Var = this.E) != null && fd7Var.u())) {
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
            if (this.P && !this.R && (sortSwitchButton = this.c) != null) {
                sortSwitchButton.w(this.Q ? 1 : 0);
            }
            ms4.d(this.b).y(R.array.S_O_X001);
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (E2()) {
                this.H = this.a.getVisibility() == 0;
                this.G = true;
            } else if (this.G) {
                this.a.setVisibility(this.H ? 0 : 8);
                this.G = false;
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
        xd5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
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
            this.J = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            ad7 ad7Var = this.u;
            if (ad7Var != null) {
                ad7Var.z();
            }
            dd7 dd7Var = this.l;
            if (dd7Var != null) {
                dd7Var.m(this.h0);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.h.setCurrentItem(this.o, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f080612, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
            o75.f().g(TbadkCoreApplication.getInst());
            o75.i(new ImageFpsEvent());
            this.J = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            Q2(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d03bf);
            W2();
            T2(this.K, this.Q, false);
            registerListener(this.y0);
            registerListener(this.x0);
            registerListener(this.L0);
            registerListener(this.M0);
            addGlobalLayoutListener();
            VoiceManager t0 = t0();
            this.m = t0;
            t0.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                cs8.b(1, getWindow().getAttributes(), getWindow());
            }
            if (!TbSingleton.getInstance().hasDownloadEmotion() && oi.H() && TbadkCoreApplication.isLogin()) {
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
            i55.k().r();
            zc7 zc7Var = this.t;
            ArrayList<String> arrayList = this.q;
            int i2 = this.o;
            zc7Var.c(arrayList, i2, i2);
            this.t.g();
            uc7 uc7Var = this.s;
            if (uc7Var != null) {
                String U = uc7Var.U();
                str2 = this.s.X();
                str = U;
            } else {
                str = null;
                str2 = null;
            }
            this.t.j(this.h.getPageCount(), "", this.w, this.x, str, str2);
            ad7 ad7Var = this.u;
            if (ad7Var != null) {
                ad7Var.C();
            }
            this.h.v();
            this.l.n();
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d25.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.J);
            G2();
            F2();
            gd7 gd7Var = this.t0;
            if (gd7Var != null) {
                gd7Var.k();
            }
            fd7 fd7Var = this.E;
            if (fd7Var != null) {
                fd7Var.y();
            }
            o75.i(new PrePageKeyEvent(getCurrentPageKey()));
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
            long g2 = og.g(this.x, 0L);
            if (uniqueId != null && g2 > 0) {
                sj4.f(uniqueId.getId(), g2);
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
            this.mIsLogin = m75.k();
            BdUniqueId uniqueId = getUniqueId();
            long g2 = og.g(this.x, 0L);
            if (uniqueId != null && g2 > 0) {
                sj4.j(cj4.d0, uniqueId.getId(), g2);
            }
            VoiceManager voiceManager = this.m;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.l.p();
            fu4.b().f(LiveRemindConfig.Scene.LIVE_BUBBLE);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            bundle.putBoolean(ImageViewerConfig.IS_BJH, this.S);
            bundle.putStringArrayList("url", this.q);
            bundle.putInt("index", this.o);
            bundle.putString("fid", this.w);
            bundle.putString("tid", this.x);
            bundle.putString("fname", this.z);
            bundle.putString("post_id", this.C);
            bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.V);
            bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.O);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.P);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.N);
            bundle.putString("user_id", this.B);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.X);
            bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.Y);
            Map<String, ImageUrlData> map = this.r;
            if (map instanceof HashMap) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, ImageUrlData> entry : this.r.entrySet()) {
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
                for (Map.Entry<String, ImageUrlData> entry2 : this.r.entrySet()) {
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
            bundle.putString("from", this.A);
            bundle.putInt("thread_type", this.e0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.Q);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.f0);
            bundle.putBoolean(ImageViewerConfig.IS_IDENTIFY_IMAGE, this.T);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.R);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.U);
            bundle.putBoolean("is_login", m75.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, m75.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, m75.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, m75.f());
            bundle.putString("from_forum_id", this.g0);
            bundle.putInt("skin_type", this.h0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.Z);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.a0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.b0);
            bundle.putSerializable(ImageViewerConfig.REMIND_LIVE_DATA, this.c0);
            bundle.putInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY, this.d0);
            this.t.f(bundle);
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
