package com.baidu.tieba.image;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
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
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
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
import com.baidu.tieba.bha;
import com.baidu.tieba.bt5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.dz0;
import com.baidu.tieba.eg9;
import com.baidu.tieba.h09;
import com.baidu.tieba.i09;
import com.baidu.tieba.ld5;
import com.baidu.tieba.le0;
import com.baidu.tieba.m09;
import com.baidu.tieba.me0;
import com.baidu.tieba.n09;
import com.baidu.tieba.n45;
import com.baidu.tieba.n5b;
import com.baidu.tieba.nl5;
import com.baidu.tieba.nt5;
import com.baidu.tieba.o45;
import com.baidu.tieba.ol5;
import com.baidu.tieba.oo4;
import com.baidu.tieba.p09;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.q09;
import com.baidu.tieba.q88;
import com.baidu.tieba.qt5;
import com.baidu.tieba.qwa;
import com.baidu.tieba.r09;
import com.baidu.tieba.rd;
import com.baidu.tieba.rt5;
import com.baidu.tieba.s88;
import com.baidu.tieba.sm5;
import com.baidu.tieba.sq6;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.u09;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vr7;
import com.baidu.tieba.w09;
import com.baidu.tieba.wd5;
import com.baidu.tieba.y09;
import com.baidu.tieba.yu5;
import com.baidu.tieba.z09;
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
public class ImageViewerActivity extends BaseFragmentActivity implements VoiceManager.j, le0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean A0;
    public String B;
    public boolean B0;
    public String C;
    public boolean C0;
    public String D;
    public final ol5 D0;
    public String E;
    public final me0 E0;
    public String F;
    public final Function0<Unit> F0;
    public String G;
    public CustomMessageListener G0;
    public w09 H;
    public final CustomMessageListener H0;
    public final boolean I;
    public DragImageView.h I0;
    public boolean J;
    public View.OnClickListener J0;
    public boolean K;
    public UrlDragImageView.p K0;
    public int L;
    public final SortSwitchButton.f L0;
    public int M;
    public View.OnClickListener M0;
    public String N;
    public float N0;
    public boolean O;
    public View.OnTouchListener O0;
    public boolean P;
    public View.OnLongClickListener P0;
    public boolean Q;
    public BaseViewPager.a Q0;
    public boolean R;
    public ViewPager.OnPageChangeListener R0;
    public boolean S;
    public CustomMessageListener S0;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1116T;
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
    public LiveRemindData e0;
    public boolean f;
    public int f0;
    public MultiImageView g;
    public int g0;
    public View h;
    public String h0;
    public ImageView i;
    public String i0;
    public LinearLayout j;
    public int j0;
    public u09 k;
    public VoiceManager l;
    public View m;
    public int n;
    public String o;
    public int p;
    public int q;
    public View r;
    public int r0;
    public ArrayList<String> s;
    public String s0;
    public Map<String, ImageUrlData> t;
    public String t0;
    public i09 u;
    public String u0;
    public p09 v;
    public String v0;
    public r09 w;
    public z09 w0;
    public sq6 x;
    public View x0;
    public String y;
    public y09 y0;
    public String z;
    public boolean z0;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView V1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
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
    public class a implements ol5.a {
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

        @Override // com.baidu.tieba.ol5.a
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

        @Override // com.baidu.tieba.ol5.a
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

    /* loaded from: classes6.dex */
    public class b implements yu5.c {
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

        @Override // com.baidu.tieba.yu5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, motionEvent) != null) {
                return;
            }
            this.a.A3();
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
                String str = (String) ListUtils.getItem(this.a.s, this.a.p);
                if (!this.a.I || !this.a.T2() || !s88.d(str) || !this.a.d0) {
                    this.a.Y2();
                    return;
                }
                int currentItem = this.a.g.getCurrentItem();
                if (currentItem >= this.a.s.size() - 1) {
                    this.a.Y2();
                } else {
                    this.a.s.remove(str);
                    this.a.g.setUrlData(this.a.s);
                    this.a.g.setCurrentItem(currentItem, true);
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
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e70);
                    return false;
                }
                this.a.O = true;
                if (this.a.e != null) {
                    this.a.e.setEnabled(false);
                }
                String a = h09.a((String) ListUtils.getItem(this.a.s, this.a.p));
                this.a.B0 = false;
                this.a.C0 = false;
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.k3(a, !imageViewerActivity.f1116T, true);
                if (this.a.f1116T) {
                    i2 = 7;
                } else {
                    i2 = 8;
                }
                q09.e(i2, this.a.z, this.a.y);
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
            this.a.W2();
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
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.g.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.g.getCurrentMaxIndex()));
                TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "1"));
                this.a.Y2();
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
                    this.a.u.c0();
                } else if (this.a.a3() == 1) {
                } else {
                    this.a.u.d0();
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
                if (this.a.s != null && this.a.p < this.a.s.size()) {
                    this.a.v.g(i, (String) this.a.s.get(this.a.p));
                }
                boolean z3 = true;
                if (i == 1 && this.a.H != null) {
                    if ((this.a.p == 0 || this.a.H.w(this.a.p)) && !q88.m().v(q88.r()) && this.a.H.A(this.a.p)) {
                        this.a.g.setUrlData(this.a.s);
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
                            imageViewerActivity2.q3((z || imageViewerActivity2.A0) ? false : false);
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
                    if (this.a.g != null) {
                        dragImageView = this.a.g.getCurrentView();
                    } else {
                        dragImageView = null;
                    }
                    boolean z2 = false;
                    if (dragImageView != null) {
                        z = dragImageView.e0();
                    } else {
                        z = false;
                    }
                    ImageViewerActivity imageViewerActivity = this.a;
                    if (imageViewerActivity.a3() == 1 && z) {
                        z2 = true;
                    }
                    imageViewerActivity.setSwipeBackEnabled(z2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.u != null && i > this.a.g.getItemNum() - 5) {
                    this.a.u.c0();
                }
                this.a.v.c(this.a.s, this.a.p, i);
                this.a.p = i;
                if (this.a.u != null) {
                    this.a.u.i0(this.a.b3());
                }
                this.a.F3();
                this.a.J3();
                this.a.E3(i);
                if (this.a.v.a() < this.a.p) {
                    this.a.v.j(this.a.p);
                }
                if (this.a.v.b() > this.a.p) {
                    this.a.v.k(this.a.p);
                }
                if (this.a.H != null) {
                    boolean z = true;
                    this.a.H.D((this.a.u == null || this.a.u.f0() != 1) ? false : false);
                    this.a.H.z(i);
                    if (this.a.T2() && this.a.I && this.a.H.x(i)) {
                        this.a.H.B(null);
                    }
                }
                if (this.a.w0 != null) {
                    this.a.w0.m(i);
                }
                if (this.a.w != null) {
                    this.a.w.D();
                }
                if (this.a.k != null && this.a.g.getCurrentUrlDragImageView() != null) {
                    this.a.k.q(this.a.g.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
                }
                if (!this.a.z0) {
                    this.a.f3();
                }
                if (this.a.U2()) {
                    StatisticItem statisticItem = new StatisticItem("c15006");
                    q09.b(statisticItem, this.a.y, this.a.B, TbadkCoreApplication.getCurrentAccount(), this.a.z);
                    TiebaStatic.log(statisticItem);
                    this.a.H3();
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
                this.a.s3();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l extends PageStayDurationFilter {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && this.a.t != null && (agreeData = ((AgreeMessageData) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AgreeMessageData) && this.a.t != null && (agreeData = ((AgreeMessageData) customResponsedMessage.getData()).agreeData) != null && !TextUtils.isEmpty(agreeData.threadId) && !TextUtils.isEmpty(agreeData.postId)) {
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
                if (booleanValue) {
                    this.a.C3();
                } else {
                    if (this.a.D0 != null) {
                        this.a.D0.l();
                    }
                    this.a.B3();
                }
                if (this.a.g != null) {
                    MultiImageView multiImageView = this.a.g;
                    if (!booleanValue) {
                        i2 = 8;
                    }
                    multiImageView.setLiveRoomEntranceButtonVisibility(i2);
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
            ld5 ld5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ld5) && (ld5Var = (ld5) customResponsedMessage.getData()) != null && !StringUtils.isNull(ld5Var.a)) {
                rt5.h(ld5Var);
                if (StringUtils.isNull(ld5Var.c)) {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{ld5Var.a});
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{ld5Var.a, ld5Var.c});
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
                boolean V2 = this.a.V2();
                if (!V2) {
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.y3(imageViewerActivity.d, 8);
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.y3(imageViewerActivity2.e, 8);
                    ImageViewerActivity imageViewerActivity3 = this.a;
                    imageViewerActivity3.y3(imageViewerActivity3.m, 8);
                    this.a.B3();
                }
                if (this.a.g != null && !V2) {
                    this.a.g.J(false);
                }
                this.a.W2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TiebaStatic.log(new StatisticItem("c13341").param("obj_param1", this.a.g.getItemNum()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.g.getCurrentMaxIndex()));
                this.a.Y2();
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ImageViewerActivity imageViewerActivity = this.a;
                imageViewerActivity.y3(imageViewerActivity.d, 0);
                this.a.m.setVisibility(0);
                if (this.a.g == null || this.a.T2()) {
                    return;
                }
                boolean z = this.a.g.z();
                if (!"portrait".equals(this.a.C) && !z) {
                    ImageViewerActivity imageViewerActivity2 = this.a;
                    imageViewerActivity2.y3(imageViewerActivity2.e, 0);
                    this.a.C3();
                    this.a.g.J(this.a.Z);
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
                q09.e(3, this.a.z, this.a.y);
                if (sm5.a(this.a) && this.a.k != null && this.a.g.getCurrentUrlDragImageView() != null) {
                    this.a.k.u(this.a.g.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
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
                TiebaStatic.log(new StatisticItem("c10351").param("tid", this.a.z).param("obj_type", this.a.C));
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
            this.a.X2();
        }
    }

    /* loaded from: classes6.dex */
    public class u implements i09.b {
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

        @Override // com.baidu.tieba.i09.b
        public void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3) {
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2), advertAppInfo, Boolean.valueOf(z3)}) != null) || this.a.g == null) {
                return;
            }
            if (this.a.O) {
                if (!z3) {
                    this.a.g.removeAllViews();
                    this.a.p = 0;
                    if (this.a.u != null) {
                        this.a.u.i0(1);
                    }
                    this.a.p3();
                    ImageViewerActivity imageViewerActivity = this.a;
                    imageViewerActivity.f1116T = !imageViewerActivity.f1116T;
                } else if (!this.a.f1116T) {
                    this.a.showToast(R.string.image_view_change_img_error);
                }
            }
            this.a.O = false;
            if (this.a.e != null) {
                this.a.e.setEnabled(true);
            }
            this.a.hideProgressBar();
            if (z2 && this.a.g.getCurrentItem() <= this.a.a * 2) {
                int itemNum = this.a.g.getItemNum();
                this.a.g.setTempSize(itemNum + 100);
                this.a.g.setCurrentItem(itemNum + 90, false);
                this.a.g.setTempSize(0);
            }
            this.a.g.setAssistUrls(this.a.t);
            this.a.g.setHasNext(z);
            this.a.g.setNextTitle(str);
            if (i >= 0 && i < this.a.g.getItemNum()) {
                if (this.a.n == 0) {
                    this.a.g.setCurrentItem(i, false);
                }
            } else {
                this.a.g.C(this.a.g.getCurrentItem());
            }
            if (i2 != 0) {
                this.a.q = i2;
            }
            if (arrayList != null && arrayList.size() >= 400 && this.a.g.getCurrentItem() > 200) {
                for (int i3 = 0; i3 < 200; i3++) {
                    arrayList.remove(0);
                }
                this.a.g.setUrlData(arrayList);
                this.a.g.setCurrentItem(this.a.g.getCurrentItem() - 200, false);
            }
            if (this.a.a3() != 1) {
                this.a.setSwipeBackEnabled(false);
            }
            if (this.a.I && this.a.H != null) {
                w09 w09Var = this.a.H;
                if (this.a.u.f0() == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                w09Var.D(z7);
                if (this.a.z0 || this.a.H.v(this.a.b3())) {
                    this.a.H.C(this.a.a3(), this.a.q);
                    this.a.H.s(this.a.f1116T);
                    this.a.C0 = true;
                    m09.a(this.a.g, this.a.s, this.a.B0, this.a.C0, this.a.F0);
                }
            } else if (this.a.w0 != null) {
                long a3 = this.a.a3();
                if (this.a.n > 0) {
                    a3 = this.a.c3();
                }
                this.a.w0.o(a3, this.a.q);
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
            if (!z4 && !imageViewerActivity3.A0) {
                z6 = true;
            } else {
                z6 = false;
            }
            imageViewerActivity3.q3(z6);
            this.a.B0 = true;
            if (!this.a.d0) {
                this.a.C0 = true;
            }
            m09.a(this.a.g, this.a.s, this.a.B0, this.a.C0, this.a.F0);
            this.a.F3();
            if (this.a.k != null && this.a.g.getCurrentUrlDragImageView() != null) {
                this.a.k.q(this.a.g.getCurrentUrlDragImageView().getmAssistUrlData(), this.a.u);
            }
            if (!this.a.z0) {
                return;
            }
            this.a.z0 = false;
            this.a.f3();
        }

        @Override // com.baidu.tieba.i09.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.O = false;
                if (this.a.e != null) {
                    if (this.a.e.getState() != this.a.f1116T && TextUtils.isEmpty(str)) {
                        this.a.showToast(R.string.image_view_change_img_error);
                    }
                    this.a.e.w(this.a.f1116T ? 1 : 0);
                    this.a.e.setEnabled(true);
                }
                this.a.hideProgressBar();
                this.a.showToast(str);
                if (i == 40) {
                    if (this.a.s != null) {
                        ImageViewerActivity imageViewerActivity = this.a;
                        imageViewerActivity.q = imageViewerActivity.s.size();
                    }
                    this.a.F3();
                }
                if (this.a.z0) {
                    this.a.z0 = false;
                    this.a.f3();
                }
            }
        }

        public final void c(ArrayList<String> arrayList, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, advertAppInfo) == null) {
                if (this.a.w0 != null && advertAppInfo != null && arrayList != null) {
                    int h = advertAppInfo.h();
                    if (h != 0) {
                        this.a.u3(advertAppInfo, h);
                        return;
                    } else {
                        this.a.w0.g(advertAppInfo);
                        return;
                    }
                }
                this.a.v3(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements bha {
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

        @Override // com.baidu.tieba.bha
        public <T> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t) != null) {
                return;
            }
            this.a.C0 = true;
            m09.a(this.a.g, this.a.s, this.a.B0, this.a.C0, this.a.F0);
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
        this.f = false;
        this.n = 0;
        this.o = "";
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
        this.f1116T = false;
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
        this.z0 = true;
        this.A0 = false;
        this.B0 = false;
        this.C0 = false;
        this.D0 = nl5.a();
        this.E0 = new me0();
        this.F0 = new k(this);
        this.G0 = new o(this, 2016496);
        this.H0 = new p(this, 2016493);
        this.I0 = new q(this);
        this.J0 = new r(this);
        this.K0 = new s(this);
        this.L0 = new d(this);
        this.M0 = new f(this);
        this.O0 = new g(this);
        this.P0 = new h(this);
        this.Q0 = new i(this);
        this.R0 = new j(this);
        this.S0 = new m(this, 2016528);
        this.T0 = new n(this, 2016530);
    }

    public final void F3() {
        String str;
        int i2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.s != null) {
            long a3 = a3();
            String str2 = ("" + a3) + "/";
            if (this.q > 0) {
                str = str2 + this.q;
            } else {
                str = str2 + "...";
            }
            if (this.C != null && !this.P && a3() == this.q && (this.C.equals("frs") || this.C.equals("index"))) {
                TiebaStatic.log(new StatisticItem("c13316").param("obj_source", this.C));
                this.P = true;
            }
            if (T2()) {
                long j2 = -1;
                String str3 = (String) ListUtils.getItem(this.s, this.p - 1);
                if (!StringUtils.isNull(str3) && (imageUrlData = this.t.get(str3)) != null) {
                    j2 = imageUrlData.overAllIndex;
                }
                G3(j2, this.q);
            } else if (U2()) {
                H3();
            } else {
                I3(str);
            }
            long j3 = a3 - 1;
            if (j3 > 0) {
                i2 = (int) j3;
            } else {
                i2 = 0;
            }
            D3(i2);
        }
    }

    public final void D3(int i2) {
        i09 i09Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (i09Var = this.u) != null) {
            ArrayList<AlaInfoData> X = i09Var.X();
            if (X != null && X.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            e3(z);
        }
    }

    public final void I3(String str) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.d.setText(str);
            if (this.S && !this.U && (sortSwitchButton = this.e) != null) {
                sortSwitchButton.w(this.f1116T ? 1 : 0);
            }
            EMManager.from(this.d).setTextShadow(R.array.S_O_X001);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            this.E0.a(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void e3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && this.f != z) {
            this.f = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.g.setBackgroundColor(-16777216);
            this.g.G(i2);
            this.M = i2;
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
            r09 r09Var = this.w;
            if (r09Var != null) {
                r09Var.z();
            }
            u09 u09Var = this.k;
            if (u09Var != null) {
                u09Var.m(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.g.setCurrentItem(this.p, false);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z) {
                X2();
            }
        }
    }

    public void v3(int i2) {
        MultiImageView multiImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048641, this, i2) == null) && (multiImageView = this.g) != null) {
            multiImageView.setAddSize(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048626, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                Intent intent = new Intent();
                intent.putExtra("index", this.p);
                setResult(-1, intent);
                Y2();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void y3(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048644, this, view2, i2) == null) && view2 != null) {
            view2.clearAnimation();
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.k.l(i2, i3, intent);
        }
    }

    public final void A3() {
        ol5 ol5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.g.y() && (ol5Var = this.D0) != null) {
            ol5Var.j();
        }
    }

    public final void B3() {
        ol5 ol5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ol5Var = this.D0) != null) {
            ol5Var.hide();
        }
    }

    public final void C3() {
        ol5 ol5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.g.y() && (ol5Var = this.D0) != null) {
            ol5Var.show();
        }
    }

    public final void K3() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (intent = getIntent()) != null) {
            bt5.d(intent.getStringExtra(TiebaStatic.Params.WISE_SAMPLE_ID));
        }
    }

    @Override // com.baidu.tieba.le0
    @NonNull
    public me0 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.E0;
        }
        return (me0) invokeV.objValue;
    }

    public final boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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

    public final void W2() {
        sq6 sq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (sq6Var = this.x) != null) {
            sq6Var.h();
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            getWindow().addFlags(1024);
            finish();
        }
    }

    public Map<String, ImageUrlData> Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.t;
        }
        return (Map) invokeV.objValue;
    }

    public final int b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return (int) a3();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 2);
            if (nt5.a()) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "4"));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.l == null) {
                this.l = VoiceManager.instance();
            }
            return this.l;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public String d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.D;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 2);
        }
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (rd.isEmpty(this.z)) {
                return 0L;
            }
            return JavaTypesHelper.toLong(this.z, 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return new l(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.l;
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
            VoiceManager voiceManager = this.l;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.V;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public void releaseResouce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.g.D();
        }
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.r.setBackgroundColor(-16777216);
        }
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            EMManager.from(this.r).setGradientColor(new int[]{R.color.CAM_X0608, R.color.CAM_X0601}, Direction.TOP);
        }
    }

    public final void E3(int i2) {
        MultiImageView multiImageView;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i2) != null) || (multiImageView = this.g) == null) {
            return;
        }
        multiImageView.p(i2);
        this.g.q(i2);
        if (!this.g.z() && !T2() && !U2()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        y3(this.e, i3);
        if (i3 == 0) {
            C3();
        } else {
            B3();
        }
    }

    public final void G3(long j2, int i2) {
        w09 w09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            z09 z09Var = this.w0;
            if ((z09Var != null && z09Var.j()) || ((w09Var = this.H) != null && w09Var.u())) {
                this.d.setText("");
            } else if (j2 > 0) {
                this.d.setText(String.format(Locale.CHINA, "%d/%d", Long.valueOf(j2), Integer.valueOf(i2)));
            } else {
                this.d.setText("");
            }
            y3(this.e, 8);
            B3();
        }
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.setVisibility(8);
            if (this.c == null) {
                TextView centerTextTitle = this.b.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f07b2));
                this.c = centerTextTitle;
                centerTextTitle.setTextColor(ContextCompat.getColor(this, R.color.CAM_X0101));
            }
            this.c.setVisibility(0);
            this.b.setVisibility(0);
            y3(this.e, 8);
        }
    }

    public final void J3() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = false;
            if (T2()) {
                if (this.b.getVisibility() == 0) {
                    z = true;
                }
                this.K = z;
                this.J = true;
            } else if (this.J) {
                NavigationBar navigationBar = this.b;
                if (this.K) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                navigationBar.setVisibility(i2);
                this.J = false;
            }
            t3();
        }
    }

    public int S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
            i09 i09Var = this.u;
            if (i09Var != null) {
                i09Var.i0(b3());
            }
            return this.p;
        }
        return invokeV.intValue;
    }

    public final boolean T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.Q) {
                return false;
            }
            z09 z09Var = this.w0;
            if (z09Var != null && z09Var.h(this.p)) {
                return true;
            }
            w09 w09Var = this.H;
            if (w09Var == null || !w09Var.t(this.p)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final long a3() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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

    public final long c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int count = ListUtils.getCount(this.s);
            for (int i2 = 0; i2 < count; i2++) {
                ImageUrlData imageUrlData = this.t.get(this.s.get(i2));
                if (imageUrlData != null && TextUtils.equals(imageUrlData.id, this.o)) {
                    return imageUrlData.overAllIndex;
                }
            }
            return a3();
        }
        return invokeV.longValue;
    }

    public final void f3() {
        ImageUrlData imageUrlData;
        p09 p09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            String str = (String) ListUtils.getItem(this.s, this.p);
            Map<String, ImageUrlData> map = this.t;
            if (map != null && str != null && (imageUrlData = map.get(str)) != null && (p09Var = this.v) != null) {
                String str2 = this.z;
                String str3 = this.C;
                int i2 = this.p;
                p09Var.e(str2, str3, i2, this.q - i2, imageUrlData.mHeigth, imageUrlData.mWidth, this.G);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.setFid(JavaTypesHelper.toLong(this.y, 0L));
                pageStayDurationItem.setTid(JavaTypesHelper.toLong(this.z, 0L));
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
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.j = (LinearLayout) findViewById(R.id.image_viewer_reply_root);
            u09 u09Var = new u09(getPageContext(), this.j);
            this.k = u09Var;
            u09Var.r(this.i0);
            this.k.s(this.j0);
            this.k.m(this.j0);
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.h = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.h.setLayoutParams(layoutParams);
            this.h.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            this.g.E();
            BdUniqueId uniqueId = getUniqueId();
            long j2 = JavaTypesHelper.toLong(this.z, 0L);
            if (uniqueId != null && j2 > 0) {
                MutiProcessMissionHelper.pauseBrowseTimeMission(uniqueId.getId(), j2);
            }
            VoiceManager voiceManager = this.l;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            this.k.o();
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.I && T2()) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_close44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final boolean V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            MultiImageView multiImageView = this.g;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.g.getCurrentUrlDragImageView().getImageView() != null && this.g.getCurrentUrlDragImageView().getImageView().getImageUrlData() != null) {
                return this.g.getCurrentUrlDragImageView().getImageView().getImageUrlData().isLongPic;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && getWindow() != null) {
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
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            View addSystemImageButton = this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.m = addSystemImageButton;
            addSystemImageButton.setOnClickListener(new c(this));
            this.i = (ImageView) this.m.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.m.setVisibility(0);
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.S && this.D0 != null) {
            qt5.a(getSupportFragmentManager(), R.id.second_floor_container, this.D0.m("big_pic"));
            this.D0.k(new a(this));
            yu5 g2 = yu5.g(this);
            g2.j(R.id.second_floor_container, R.id.navigation_bar);
            g2.i(new b(this));
            g2.f();
        }
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.r = findViewById(R.id.pic_top_obscuration_view);
            x3();
            l3();
            m3();
            this.w = new r09(this);
            p3();
            this.w.x(this.g);
            F3();
            z3();
            n3();
            i3();
            p09 p09Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.p;
            p09Var.c(arrayList, i2, i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            this.g.F();
            this.mIsLogin = sm5.k();
            BdUniqueId uniqueId = getUniqueId();
            long j2 = JavaTypesHelper.toLong(this.z, 0L);
            if (uniqueId != null && j2 > 0) {
                MutiProcessMissionHelper.startThreadBrowseTimeMission(oo4.d0, uniqueId.getId(), j2);
            }
            VoiceManager voiceManager = this.l;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            this.k.p();
        }
    }

    public final void s3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && this.n > 0) {
            int count = ListUtils.getCount(this.s);
            int i2 = 0;
            while (true) {
                if (i2 < count) {
                    ImageUrlData imageUrlData = this.t.get(this.s.get(i2));
                    if (imageUrlData != null && TextUtils.equals(imageUrlData.id, this.o)) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = 0;
                    break;
                }
            }
            int currentItem = this.g.getCurrentItem();
            if (i2 > 0 && i2 != currentItem) {
                this.g.setCurrentItem(i2, false);
            }
            E3(i2);
            this.n = 0;
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
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            this.v = new p09();
            boolean k2 = sm5.k();
            String b2 = sm5.b();
            String f2 = sm5.f();
            String e2 = sm5.e();
            K3();
            if (bundle != null) {
                this.V = bundle.getBoolean(ImageViewerConfig.IS_BJH);
                ArrayList<String> c2 = n09.d().c();
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
                this.Y = bundle.getBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
                this.X = bundle.getBoolean(ImageViewerConfig.REVERSE_MODE, true);
                this.Q = bundle.getBoolean(ImageViewerConfig.IS_SHOW_AD, false);
                this.D = bundle.getString("user_id");
                this.C = bundle.getString("from");
                this.R = bundle.getBoolean(ImageViewerConfig.IS_CAN_DRAG, true);
                this.S = bundle.getBoolean(ImageViewerConfig.IS_SHOW_HOST, true);
                this.g0 = bundle.getInt("thread_type");
                this.f1116T = bundle.getBoolean(ImageViewerConfig.SEE_HOST, false);
                Map<String, String> b3 = n09.d().b();
                this.h0 = bundle.getString(IntentConfig.SOURCE_RECT_IN_SCREEN);
                this.W = bundle.getBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE);
                boolean z2 = bundle.getBoolean("is_login");
                String string = bundle.getString(ImageViewerConfig.ACCOUNT_BDUSS);
                String string2 = bundle.getString(ImageViewerConfig.ACCOUNT_TBS);
                String string3 = bundle.getString(ImageViewerConfig.ACCOUNT_STOKEN);
                this.Z = bundle.getBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                this.a0 = bundle.getBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, false);
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
                this.U = bundle.getBoolean(ImageViewerConfig.IS_FROM_AI_APP, false);
                this.r0 = bundle.getInt("card_type", 0);
                this.s0 = bundle.getString("recom_source");
                this.t0 = bundle.getString("ab_tag");
                this.u0 = bundle.getString("weight");
                this.v0 = bundle.getString("extra");
                this.i0 = bundle.getString("from_forum_id");
                this.j0 = bundle.getInt("skin_type");
                this.b0 = bundle.getBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                Serializable serializable = bundle.getSerializable(ImageViewerConfig.REMIND_LIVE_DATA);
                if (serializable instanceof LiveRemindData) {
                    this.e0 = (LiveRemindData) serializable;
                }
                this.f0 = bundle.getInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY);
                this.d0 = bundle.getBoolean(ImageViewerConfig.NEED_REQUEST_AD, true);
                Serializable serializable2 = bundle.getSerializable(ImageViewerConfig.KEY_PROFILE_VIRTUAL_IMAGE_INFO);
                if (serializable2 instanceof ProfileVirtualImageInfo) {
                    ProfileVirtualImageInfo.getInstance().parseRemoteInfo((ProfileVirtualImageInfo) serializable2);
                }
                n09.d().a();
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
                    this.Y = intent.getBooleanExtra(ImageViewerConfig.PARAM_IS_CDN, false);
                    this.X = intent.getBooleanExtra(ImageViewerConfig.REVERSE_MODE, true);
                    this.Q = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_AD, false);
                    this.D = intent.getStringExtra("user_id");
                    this.C = intent.getStringExtra("from");
                    this.R = intent.getBooleanExtra(ImageViewerConfig.IS_CAN_DRAG, true);
                    this.S = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_HOST, true);
                    this.f1116T = intent.getBooleanExtra(ImageViewerConfig.SEE_HOST, false);
                    this.g0 = intent.getIntExtra("thread_type", 0);
                    this.Z = intent.getBooleanExtra(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, true);
                    this.a0 = intent.getBooleanExtra(ImageViewerConfig.IS_DYNAMIC_CARD, false);
                    this.U = intent.getBooleanExtra(ImageViewerConfig.IS_FROM_AI_APP, false);
                    z = intent.getBooleanExtra("is_login", false);
                    String stringExtra = intent.getStringExtra(ImageViewerConfig.ACCOUNT_BDUSS);
                    str3 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_STOKEN);
                    String stringExtra2 = intent.getStringExtra(ImageViewerConfig.ACCOUNT_TBS);
                    this.h0 = intent.getStringExtra(IntentConfig.SOURCE_RECT_IN_SCREEN);
                    this.W = intent.getBooleanExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, false);
                    Serializable serializableExtra = intent.getSerializableExtra(ImageViewerConfig.ASSIST_URLS);
                    if (serializableExtra instanceof Map) {
                        this.t = (Map) serializableExtra;
                    }
                    this.r0 = intent.getIntExtra("card_type", 0);
                    this.s0 = intent.getStringExtra("recom_source");
                    this.t0 = intent.getStringExtra("ab_tag");
                    this.u0 = intent.getStringExtra("weight");
                    this.v0 = intent.getStringExtra("extra");
                    this.i0 = intent.getStringExtra("from_forum_id");
                    this.j0 = intent.getIntExtra("skin_type", 0);
                    this.b0 = intent.getBooleanExtra(ImageViewerConfig.IS_VIDEO_WORKS_INFO, false);
                    this.d0 = intent.getBooleanExtra(ImageViewerConfig.NEED_REQUEST_AD, true);
                    Serializable serializableExtra2 = intent.getSerializableExtra(ImageViewerConfig.REMIND_LIVE_DATA);
                    if (serializableExtra2 instanceof LiveRemindData) {
                        this.e0 = (LiveRemindData) serializableExtra2;
                    }
                    this.f0 = intent.getIntExtra(ImageViewerConfig.REMIND_LIVE_FREQUENCY, 0);
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
            int i2 = this.p;
            if (i2 > 0) {
                str4 = (String) ListUtils.getItem(this.s, i2);
                this.n = this.p + 1;
            } else if (ListUtils.isNotEmpty(this.s)) {
                str4 = this.s.get(0);
                if (!TextUtils.isEmpty(str4) && (map = this.t) != null && (imageUrlData = map.get(str4)) != null) {
                    this.n = (int) imageUrlData.overAllIndex;
                }
            } else {
                str4 = "";
            }
            this.o = h09.a(str4);
            sm5.o(z);
            sm5.n(str);
            sm5.p(str3);
            sm5.q(str2);
            this.v.f(bundle, getIntent());
            this.q = ListUtils.getCount(this.s);
            if (this.h0 != null) {
                String str5 = (String) ListUtils.getItem(this.s, this.p);
                if (!StringUtils.isNull(str5) && (map2 = this.t) != null && (imageUrlData2 = map2.get(str5)) != null) {
                    imageUrlData2.setSourceImageRectInScreen(this.h0);
                }
            }
            if (this.V) {
                a2 = null;
            } else {
                a2 = h09.a((String) ListUtils.getItem(this.s, this.p));
            }
            this.N = a2;
            if (this.f1116T) {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "2"));
            } else {
                TiebaStatic.log(new StatisticItem("c13337").param("obj_type", "1"));
            }
            this.a = (ImagePrePageLimitSwitch.Companion.pageLimitSize() <= 0 || !UbsABTestHelper.isBigImagePreTest()) ? 2 : 2;
            n45.a().d(this.e0);
            o45.b().n(this.f0);
        }
    }

    public final void j3() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && !this.V && !this.U && !this.b0) {
            View addCustomView = this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.cell_image_view_right_layout, (View.OnClickListener) null);
            this.x0 = addCustomView;
            if (this.c0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            addCustomView.setVisibility(i2);
            if (this.S) {
                ArrayList arrayList = new ArrayList(2);
                qwa qwaVar = new qwa();
                qwaVar.c(0);
                qwaVar.d(getString(R.string.obfuscated_res_0x7f0f02a8));
                arrayList.add(qwaVar);
                qwa qwaVar2 = new qwa();
                qwaVar2.c(1);
                qwaVar2.d(getString(R.string.host_name));
                arrayList.add(qwaVar2);
                SortSwitchButton sortSwitchButton = (SortSwitchButton) this.x0.findViewById(R.id.host_all_switch_btn);
                this.e = sortSwitchButton;
                sortSwitchButton.setNeedDayNight(false);
                this.e.setData(arrayList, this.f1116T ? 1 : 0);
                this.e.setVisibility(0);
                this.e.setOnSwitchChangeListener(this.L0);
                return;
            }
            y3(this.e, 8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.H0);
            TbadkCoreApplication.getInst().delRemoteActivity(this);
            TbImageMemoryCache.w().J();
            p09 p09Var = this.v;
            ArrayList<String> arrayList = this.s;
            int i2 = this.p;
            p09Var.c(arrayList, i2, i2);
            this.v.i();
            i09 i09Var = this.u;
            if (i09Var != null) {
                String Z = i09Var.Z();
                String e0 = this.u.e0();
                this.u.s0();
                this.u.m0(null);
                str = Z;
                str2 = e0;
            } else {
                str = null;
                str2 = null;
            }
            this.v.l(this.g.getPageCount(), "", this.y, this.z, str, str2);
            r09 r09Var = this.w;
            if (r09Var != null) {
                r09Var.C();
            }
            this.g.D();
            this.k.n();
            VoiceManager voiceManager = this.l;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            wd5.k().i(13);
            TbadkCoreApplication.getInst().setSkinTypeValue(this.M);
            W2();
            z09 z09Var = this.w0;
            if (z09Var != null) {
                z09Var.k();
            }
            w09 w09Var = this.H;
            if (w09Var != null) {
                w09Var.y();
            }
            MutiProcessManager.publishEvent(new PrePageKeyEvent(getCurrentPageKey()));
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2001277);
        }
    }

    public final void k3(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i09 i09Var = new i09(this.s, this.t, this.y, this.B, this.z, this.A, str, this.D, this.C, this.g0, z2, this.r0, this.s0, this.t0, this.u0, this.v0, this.n);
            this.u = i09Var;
            i09Var.q0(this.h0);
            this.u.o0(this.X);
            this.u.p0(z);
            this.u.h0(this.N);
            this.u.l0(this.W);
            this.u.n0(this.E);
            this.u.g0(this.F);
            this.u.k0(this.a0);
            this.u.m0(new u(this));
            this.u.j0(true);
            if (this.d0) {
                this.w0.n(new v(this));
            }
            this.u.a0();
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
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
            if (h09.b((String) ListUtils.getItem(this.s, this.p))) {
                this.b.setVisibility(0);
            }
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && !this.U && this.e != null) {
            if (this.x == null) {
                sq6 sq6Var = new sq6(getPageContext(), this.e);
                this.x = sq6Var;
                sq6Var.L(R.drawable.pic_sign_tip);
                this.x.o(48);
                this.x.N(true);
                this.x.n(5000);
                this.x.Q(-BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.tbds26));
                this.x.m(new e(this));
            }
            this.x.T(getPageContext().getString(R.string.click_look_all_picture), "key_large_image_tip_count");
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
            X2();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new t(this));
            MutiProcessManager.getInstance().init(TbadkCoreApplication.getInst());
            MutiProcessManager.publishEvent(new ImageFpsEvent());
            this.M = TbadkCoreApplication.getInst().getSkinType();
            setSwipeBackEnabled(false);
            TbadkCoreApplication.getInst().addRemoteActivity(this);
            if (!Fresco.hasBeenInitialized()) {
                Fresco.initialize(TbadkCoreApplication.getInst(), vr7.a());
            }
            h3(bundle);
            setContentView(R.layout.image_activity_big_img);
            o3();
            this.B0 = false;
            this.C0 = false;
            k3(this.N, this.f1116T, false);
            registerListener(this.H0);
            registerListener(this.G0);
            registerListener(this.S0);
            registerListener(this.T0);
            addGlobalLayoutListener();
            VoiceManager d1 = d1();
            this.l = d1;
            d1.onCreate(getPageContext());
            if (Build.VERSION.SDK_INT >= 28 && (TbSingleton.getInstance().isCutoutScreen(this) || TbSingleton.getInstance().isNotchScreen(this))) {
                n5b.b(1, getWindow().getAttributes(), getWindow());
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
            bundle.putBoolean(ImageViewerConfig.IS_BJH, this.V);
            n09.d().f(this.s);
            bundle.putInt("index", this.p);
            bundle.putString("fid", this.y);
            bundle.putString("tid", this.z);
            bundle.putString("fname", this.B);
            bundle.putString("post_id", this.E);
            bundle.putString(IntentConfig.BJH_POST_ID, this.F);
            bundle.putBoolean(ImageViewerConfig.PARAM_IS_CDN, false);
            bundle.putBoolean(ImageViewerConfig.REVERSE_MODE, this.X);
            bundle.putBoolean(ImageViewerConfig.IS_CAN_DRAG, this.R);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_HOST, this.S);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_AD, this.Q);
            bundle.putString("user_id", this.D);
            bundle.putBoolean(ImageViewerConfig.IS_SHOW_BOTTOM_CONTAINER, this.Z);
            bundle.putBoolean(ImageViewerConfig.IS_DYNAMIC_CARD, this.a0);
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
                n09.d().e(hashMap);
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
                n09.d().e(concurrentHashMap);
            }
            bundle.putString("from", this.C);
            bundle.putInt("thread_type", this.g0);
            bundle.putBoolean(ImageViewerConfig.SEE_HOST, this.f1116T);
            bundle.putString(IntentConfig.SOURCE_RECT_IN_SCREEN, this.h0);
            bundle.putBoolean(ImageViewerConfig.IS_FROM_AI_APP, this.U);
            bundle.putBoolean(ImageViewerConfig.IS_GODREPLY_IMAGE, this.W);
            bundle.putBoolean("is_login", sm5.k());
            bundle.putString(ImageViewerConfig.ACCOUNT_BDUSS, sm5.b());
            bundle.putString(ImageViewerConfig.ACCOUNT_STOKEN, sm5.e());
            bundle.putString(ImageViewerConfig.ACCOUNT_TBS, sm5.f());
            bundle.putString("from_forum_id", this.i0);
            bundle.putInt("skin_type", this.j0);
            bundle.putBoolean(ImageViewerConfig.IS_VIDEO_WORKS_INFO, this.b0);
            bundle.putBoolean(ImageViewerConfig.IS_YOUNGSTER_MODE, this.c0);
            bundle.putBoolean(ImageViewerConfig.NEED_REQUEST_AD, this.d0);
            bundle.putSerializable(ImageViewerConfig.REMIND_LIVE_DATA, this.e0);
            bundle.putInt(ImageViewerConfig.REMIND_LIVE_FREQUENCY, this.f0);
            this.v.h(bundle);
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            MultiImageView multiImageView = this.g;
            if (multiImageView == null) {
                this.g = (MultiImageView) findViewById(R.id.obfuscated_res_0x7f092a75);
            } else {
                multiImageView.v();
            }
            this.G = this.z + "_" + System.currentTimeMillis();
            this.g.setIsFromCDN(this.Y);
            this.g.setIsCanDrag(this.R);
            this.g.setPageMargin(BdUtilHelper.dip2px(getPageContext().getPageActivity(), 8.0f));
            this.g.setOffscreenPageLimit(this.a, TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth());
            this.g.setOnPageChangeListener(this.R0);
            this.g.setUrlData(this.s);
            this.g.setAssistUrls(this.t);
            this.g.setOuterOnTouchListener(this.O0);
            this.g.setItemOnclickListener(this.M0);
            this.g.setItemOnLongClickListener(this.P0);
            this.g.setCurrentItem(S2(), false);
            this.g.setOnScrollOutListener(this.Q0);
            if (this.y0 == null) {
                y09 y09Var = new y09(this.s, getPageContext(), this.y, this.B, this.z);
                this.y0 = y09Var;
                y09Var.i(this.b.getFixedNavHeight());
            }
            this.g.o(this.y0);
            if (this.I && this.d0) {
                if (this.H == null) {
                    this.H = new w09(this.s, this.y, this.z, this.Q, this.p, getPageContext());
                }
                this.H.B(null);
                this.g.o(this.H);
            }
            if (this.w0 == null) {
                this.w0 = new z09(this.s, this.y, this.B, this.Y, this.Q, getPageContext(), this.I0, this.t);
            }
            this.g.o(this.w0);
            this.g.setOriImgSelectedCallback(this.K0);
            this.g.setDragToExitListener(this.I0);
            this.g.setUserId(this.D);
            this.g.setShowBottomContainer(this.Z);
            this.g.setOnShareImageListener(this.w);
            this.g.setOnDownloadImageListener(this.w);
            this.g.setOnReplyClickListener(this.J0);
            this.g.setYoungterCoverSomeView(this.c0);
            p09 p09Var = this.v;
            if (p09Var != null) {
                p09Var.d(this.D, this.z, this.C);
            }
        }
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048634, this, z) != null) || this.y0 == null) {
            return;
        }
        if (!ListUtils.isEmpty(this.u.b0()) && z) {
            this.y0.k(this.u.b0());
            this.y0.j(true);
            ArrayList<String> arrayList = this.s;
            if (arrayList != null && !arrayList.contains("####mLiveRoomPageProvider")) {
                ArrayList<String> arrayList2 = this.s;
                eg9.b(arrayList2, "####mLiveRoomPageProvider", arrayList2.size());
                return;
            }
            return;
        }
        this.y0.k(null);
        this.y0.j(false);
    }

    public final void u3(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048640, this, advertAppInfo, i2) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.DISCARD).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).k(String.valueOf(i2)).p(advertAppInfo.g);
            dz0.e(clogBuilder);
        }
    }
}
