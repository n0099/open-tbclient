package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SoLoadUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.mainTab.FragmentDelegate;
import com.baidu.tbadk.mainTab.FragmentTabStructure;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.dynamicIcon.DynamicIconData;
import com.baidu.tbadk.mainTab.dynamicIcon.MainTabBottomDynamicIconManager;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ad.incentivevideo.net.GetIncentiveVideoTaskModel;
import com.baidu.tieba.edgefloat.EdgeFloatLifecycle;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.y45;
import com.baidu.tieba.z66;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class kka {
    public static /* synthetic */ Interceptable $ic;
    public static long J;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public final ItemCardHelper.c B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public View.OnClickListener E;
    public Runnable F;
    public Runnable G;
    public Runnable H;
    public CustomMessageListener I;
    public MainTabActivity a;
    public FragmentTabHost b;
    public TextView c;
    public boolean d;
    public boolean e;
    public TBLottieAnimationView f;
    public TbImageView g;
    public PopupWindow h;
    public boolean i;
    public Handler j;
    public au6 k;
    public mra l;
    public MaintabBottomIndicator m;
    public MaintabBottomIndicator n;
    public int o;
    public boolean p;
    public boolean q;
    public qka r;
    public boolean s;
    public boolean t;
    public boolean u;
    public gza v;
    public boolean w;
    public gla x;
    public FragmentTabHost.b y;
    public CustomMessageListener z;

    /* loaded from: classes6.dex */
    public class a implements FragmentTabHost.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        /* renamed from: com.baidu.tieba.kka$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0371a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public RunnableC0371a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                }
            }
        }

        public a(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        public final void a(int i) {
            String prePageKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.b.g(i).a == 2) {
                    prePageKey = TbPageExtraHelper.getCurrentVisiblePageKey(this.a.a.getPageContext().getContext());
                } else {
                    prePageKey = TbPageExtraHelper.getPrePageKey();
                }
                SafeHandler.getInst().postDelayed(new RunnableC0371a(this, new CustomResponsedMessage(2921520, prePageKey)), 100L);
            }
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                int i2 = this.a.b.g(i).a;
                if (i2 == 8) {
                    TbPageExtraHelper.setPrePageKey("a011");
                } else if (i2 == 2) {
                    TbPageExtraHelper.setPrePageKey("a002");
                } else if (i2 == 3) {
                    TbPageExtraHelper.setPrePageKey("a079");
                } else if (i2 == 1) {
                    TbPageExtraHelper.setPrePageKey("a025");
                } else if (i2 == 21) {
                    TbPageExtraHelper.setPrePageKey("a075");
                } else if (i2 == 22) {
                    TbPageExtraHelper.setPrePageKey("a088");
                }
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean onPreTabSelectionChange(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                if (!TbadkCoreApplication.isLogin()) {
                    TbSingleton.MsgUpgradeTips.setIsMsgTabUpgradeTipsShowing(false);
                }
                FragmentTabHost.c g = this.a.b.g(i);
                if (g.a != 2 && FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.a.getPageContext())) {
                    return false;
                }
                int i2 = g.a;
                if (i2 == 9) {
                    if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a, LoginDialogData.HOME_PAGE_WRITE_PAGE))) {
                        if (UbsABTestHelper.isNewWrite()) {
                            this.a.K();
                        } else {
                            this.a.v.m();
                        }
                    }
                    return false;
                } else if (i2 == 8 && !TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_person");
                    if (this.a.m != null) {
                        this.a.m.h();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                    return false;
                } else {
                    int i3 = g.a;
                    if (i3 == 15) {
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                        if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                            return false;
                        }
                    } else if (i3 == 3 && !TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_msg");
                        return false;
                    } else if (g.a == 1) {
                        TiebaStatic.log(new StatisticItem("c13001"));
                    }
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0124, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r1) != false) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x02d5, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r14) != false) goto L47;
         */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTabSelectionChanged(int i, boolean z) {
            String str;
            int i2;
            boolean z2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                FragmentTabHost.c g = this.a.b.g(i);
                if (g != null && (g.b instanceof MaintabBottomIndicator)) {
                    kla a = fna.a().b().a();
                    a.a = ((MaintabBottomIndicator) g.b).getText();
                    a.c = g.a;
                    a.b = i;
                }
                int i5 = g.a;
                int i6 = 3;
                int i7 = 2;
                if (i5 == 8) {
                    TbSingleton.getInstance().setMyTabClicked(true);
                    if (this.a.m != null && this.a.m.getAnimationView() != null && this.a.m.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.a.m != null) {
                        this.a.m.h();
                    }
                    TiebaStatic.log("c13841");
                    SoLoadUtils.checkDownloadSo("libmml_framework.so", "com.baidu.tieba.soloader.libmmlframework", "mml_framework");
                    SoLoadUtils.checkDownloadSo("libc++_shared.so", "com.baidu.tieba.soloader.libcshared", SwanKV.LIB_CPP_SHARED);
                    SoLoadUtils.checkDownloadSo("libopencv_java3.so", "com.baidu.tieba.soloader.libopencv_java3", "opencv_java3");
                    SoLoadUtils.checkDownloadSo("libbd_pass_face_sdk.so", "com.baidu.tieba.soloader.libbdface", "bd_pass_face_sdk");
                } else if (i5 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                    pe5 pe5Var = (pe5) ServiceManager.getService(pe5.a);
                    if (pe5Var != null) {
                        pe5Var.e();
                    }
                    TbSingleton.MsgUpgradeTips.onMsgTabClick();
                    TbFragmentTabIndicator tbFragmentTabIndicator = g.b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.getTip("msg") != null && (maintabBottomIndicator.getTip("msg").f1082view instanceof MessageRedDotView)) {
                            str = ((MessageRedDotView) maintabBottomIndicator.getTip("msg").f1082view).getRedNum();
                            if (!TextUtils.isEmpty(str)) {
                            }
                        }
                    }
                    str = "0";
                    if (z) {
                        try {
                            i2 = Integer.parseInt(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                            i2 = 0;
                        }
                        if (i2 > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                        if (z2) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        TiebaStatic.log(param.param("obj_type", i3).param("obj_param1", str));
                        StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", str);
                        if (z2) {
                            i4 = 1;
                        } else {
                            i4 = 2;
                        }
                        TiebaStatic.log(param2.param("obj_type", i4).param("obj_source", 1));
                    }
                    this.a.D(((pe5) ServiceManager.getService(pe5.a)).a(), 1);
                }
                if (g.a == 2) {
                    if (this.a.p) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.a.p = true;
                    if (this.a.n != null) {
                        this.a.n.n(this.a.p);
                    }
                    if (WindowGreySwitch.getIsOnNew()) {
                        j9.b(this.a.b.getFragmentTabWidget());
                        j9.b(this.a.f);
                        j9.b(this.a.g);
                        j9.b(this.a.b.getTabcontainerDynamicBgImg());
                    }
                } else {
                    if (this.a.p && this.a.n != null) {
                        this.a.n.n(this.a.p);
                    }
                    this.a.p = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                    if (WindowGreySwitch.getIsOnNew()) {
                        j9.a(this.a.b.getFragmentTabWidget());
                        j9.a(this.a.f);
                        j9.a(this.a.g);
                        j9.a(this.a.b.getTabcontainerDynamicBgImg());
                    }
                }
                if (this.a.x() != null) {
                    this.a.x().q = this.a.p;
                }
                b(this.a.o);
                a(this.a.o);
                this.a.o = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(g.a)));
                if (g.a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator2 = g.b;
                    if (tbFragmentTabIndicator2 instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator2 = (MaintabBottomIndicator) tbFragmentTabIndicator2;
                        if (maintabBottomIndicator2.getTip("video_msg") != null && (maintabBottomIndicator2.getTip("video_msg").f1082view instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator2.getTip("video_msg").f1082view).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i7 = 1;
                    if (this.a.q) {
                        this.a.q = false;
                    } else {
                        i6 = i7;
                    }
                    if (z) {
                        long logWithBackTime = TiebaStatic.logWithBackTime(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i6));
                        if (this.a.b.g(this.a.b.getCurrentTabIndex()) != null && this.a.b.g(this.a.b.getCurrentTabIndex()).a != 22) {
                            TbSingleton.getInstance().setCurrentClickTime(logWithBackTime);
                        }
                    }
                    cq5.b().c();
                    cq5.b().l(true);
                    if (this.a.b.g(this.a.b.getCurrentTabIndex()) != null && this.a.b.g(this.a.b.getCurrentTabIndex()).a == 22) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    } else {
                        if (this.a.b.getFragmentTabWidget() != null) {
                            this.a.b.getFragmentTabWidget().i(true, R.color.CAM_X0215);
                        }
                        this.a.b.p(true);
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            BdUtilHelper.showLongToast(this.a.a, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e40));
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                    }
                } else {
                    cq5.b().o();
                    cq5.b().l(false);
                    if (this.a.b.getFragmentTabWidget() != null) {
                        this.a.b.getFragmentTabWidget().i(false, R.color.CAM_X0207);
                    }
                    this.a.b.p(false);
                }
                if (g.a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
                if (g.a == 22) {
                    this.a.r.f(true);
                } else {
                    this.a.r.f(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921728));
                }
            }
        }

        public t(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.b.getCurrentTabType() == 2) {
                    TiebaStatic.log("kantie_entry");
                } else if (this.a.b.getCurrentTabType() == 15) {
                    TiebaStatic.log("c12124");
                }
                if (this.a.b.getCurrentTabType() != this.a.b.g(i).a) {
                    this.a.b.setCurrentTab(i);
                }
                if (this.a.b.getCurrentTabType() == 1 && !SharedPrefHelper.getInstance().getBoolean("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (SharedPrefHelper.getInstance().getBoolean("enter_forum_edit_mode", false)) {
                    if (this.a.b.getCurrentTabType() == 3) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    } else if (this.a.b.getCurrentTabType() == 2) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                    }
                }
                if (this.a.b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
                SafeHandler.getInst().postDelayed(new a(this), 300L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        public b(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.K();
            TiebaStatic.log(new StatisticItem("c15362").param("obj_type", 2));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kka b;

        public c(kka kkaVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kkaVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.Q(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends TbFragmentTabIndicator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kka kkaVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        public e(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a, LoginDialogData.HOME_PAGE_WRITE_PAGE)) && this.a.v != null) {
                if (UbsABTestHelper.isNewWrite()) {
                    this.a.K();
                } else {
                    this.a.v.m();
                }
                int i = 1;
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_WRITE_TEST_ICON_CLICK).param("obj_type", 1);
                if (UbsABTestHelper.isNewWrite()) {
                    i = 2;
                }
                TiebaStatic.log(param.param("obj_source", i));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        public f(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null && this.a.h != null) {
                FragmentTabWidget fragmentTabWidget = this.a.b.getFragmentTabWidget();
                BdUtilHelper.getEquipmentWidth(this.a.a.getActivity());
                int dimens = BdUtilHelper.getDimens(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070388);
                View contentView = this.a.h.getContentView();
                if (contentView == null) {
                    return;
                }
                contentView.measure(0, 0);
                int measuredWidth = contentView.getMeasuredWidth();
                FragmentTabHost.c h = this.a.b.h(3);
                if (h == null || (tbFragmentTabIndicator = h.b) == null) {
                    return;
                }
                int[] iArr = new int[2];
                tbFragmentTabIndicator.getLocationInWindow(iArr);
                int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
                if (measuredWidth2 <= 0) {
                    measuredWidth2 = BdUtilHelper.getDimens(this.a.a.getActivity(), R.dimen.tbds570);
                }
                kg.l(this.a.h, fragmentTabWidget, measuredWidth2, -dimens);
                SharedPrefHelper.getInstance().putBoolean("show_maintab_last_message_tips", true);
                this.a.i = true;
                this.a.j.postDelayed(this.a.H, 5000L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        public g(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                y45Var.dismiss();
                xz7.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements z66.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        public j(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // com.baidu.tieba.z66.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q66.i().v(6);
                q66.i().t();
                new GetIncentiveVideoTaskModel(this.a.a, 6).U();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements z66.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.z66.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 2));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(kka kkaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar, Integer.valueOf(i)};
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
            this.a = kkaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.b.getCurrentTabIndex() != 0) {
                this.a.b.setCurrentTab(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(kka kkaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar, Integer.valueOf(i)};
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
            this.a = kkaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FragmentTabStructure fragmentTabStructure;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && (customResponsedMessage.getData() instanceof FragmentTabStructure) && (fragmentTabStructure = (FragmentTabStructure) customResponsedMessage.getData()) != null && this.a.b.h(fragmentTabStructure.type) != null && this.a.b.getCurrentTabType() != fragmentTabStructure.type) {
                TbFragmentTabIndicator tbFragmentTabIndicator = this.a.b.h(fragmentTabStructure.type).b;
                if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(fragmentTabStructure.imageIconUrl, fragmentTabStructure.text);
                    if (TextUtils.isEmpty(fragmentTabStructure.imageIconUrl)) {
                        return;
                    }
                    this.a.q = true;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(kka kkaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar, Integer.valueOf(i)};
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
            this.a = kkaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        public o(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.a.getActivityRootView(), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.a.getActivityRootView(), j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(kka kkaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar, Integer.valueOf(i)};
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
            this.a = kkaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DynamicIconData iconData;
            DynamicIconData iconData2;
            DynamicIconData iconData3;
            DynamicIconData iconData4;
            DynamicIconData iconData5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && MainTabBottomDynamicIconManager.getInstance().canShowDynamicIcon() && !MainTabBottomDynamicIconManager.getInstance().checkIsHasShowIcon()) {
                TbadkCoreApplication.getInst().setBottomBarDynamicHeightValid(true);
                FragmentTabHost.c h = this.a.b.h(2);
                if (h != null && (h.b instanceof MaintabBottomIndicator) && (iconData5 = MainTabBottomDynamicIconManager.getInstance().getIconData("homePage")) != null) {
                    ((MaintabBottomIndicator) h.b).setDynamicIconData(iconData5);
                }
                FragmentTabHost.c h2 = this.a.b.h(1);
                if (h2 != null && (h2.b instanceof MaintabBottomIndicator) && (iconData4 = MainTabBottomDynamicIconManager.getInstance().getIconData(MainTabBottomDynamicIconManager.TAG_ENTER_FORUM)) != null) {
                    ((MaintabBottomIndicator) h2.b).setDynamicIconData(iconData4);
                }
                FragmentTabHost.c h3 = this.a.b.h(22);
                if (h3 != null && (h3.b instanceof MaintabBottomIndicator) && (iconData3 = MainTabBottomDynamicIconManager.getInstance().getIconData("channel")) != null) {
                    ((MaintabBottomIndicator) h3.b).setDynamicIconData(iconData3);
                }
                FragmentTabHost.c h4 = this.a.b.h(3);
                if (h4 != null && (h4.b instanceof MaintabBottomIndicator) && (iconData2 = MainTabBottomDynamicIconManager.getInstance().getIconData("message")) != null) {
                    ((MaintabBottomIndicator) h4.b).setDynamicIconData(iconData2);
                }
                FragmentTabHost.c h5 = this.a.b.h(8);
                if (h5 != null && (h5.b instanceof MaintabBottomIndicator) && (iconData = MainTabBottomDynamicIconManager.getInstance().getIconData("person")) != null) {
                    ((MaintabBottomIndicator) h5.b).setDynamicIconData(iconData);
                }
                DynamicIconData iconData6 = MainTabBottomDynamicIconManager.getInstance().getIconData("write");
                if (iconData6 != null) {
                    if (this.a.f != null) {
                        this.a.f.setVisibility(4);
                    }
                    if (this.a.g != null) {
                        this.a.g.setUseNightOrDarkMask(false);
                        this.a.g.setVisibility(0);
                        this.a.g.startLoad(iconData6.getNormalStateUrl(), iconData6.getImgLoadType(), false);
                    }
                } else if (this.a.f != null) {
                    this.a.f.setVisibility(0);
                    this.a.g.setVisibility(8);
                }
                if (MainTabBottomDynamicIconManager.getInstance().getValidDynamicStyle() != null) {
                    this.a.b.m(MainTabBottomDynamicIconManager.getInstance().getValidDynamicStyle());
                    this.a.b.o();
                } else {
                    this.a.b.l();
                }
                this.a.b.setShouldDrawTopLine(false);
                this.a.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarDynamicStyleHeight());
                MainTabBottomDynamicIconManager.getInstance().setHasShowIconHash(MainTabBottomDynamicIconManager.getInstance().getIconDataMap().hashCode());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(kka kkaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar, Integer.valueOf(i)};
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
            this.a = kkaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.p = true;
            if (this.a.x() != null) {
                this.a.x().q = this.a.p;
            }
            SharedPrefHelper.getInstance().putBoolean("key_member_auto_ban_renewal_show", false);
            x56.k().o();
            q66.i().s();
            b95.b().l();
            mg5.a.h();
            MainTabBottomDynamicIconManager.getInstance().reset();
            this.a.f.setVisibility(0);
            this.a.g.setVisibility(8);
            this.a.b.setShouldDrawTopLine(true);
            this.a.b.l();
            this.a.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    /* loaded from: classes6.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        public r(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kka a;

        public s(kka kkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kkaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(0);
            }
        }
    }

    public kka(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.i = false;
        this.j = new Handler();
        this.o = 0;
        this.p = true;
        this.q = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.w = false;
        this.y = new a(this);
        this.z = new m(this, 2921492);
        this.A = new n(this, 2001440);
        this.B = new o(this);
        this.C = new p(this, 2921551);
        this.D = new q(this, 2921410);
        this.E = new b(this);
        this.G = new f(this);
        this.H = new g(this);
        this.I = new l(this, 2001378);
        this.a = mainTabActivity;
        eka.a("MainTabViewController init");
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            eka.a("MainTabViewController onKeyboardVisibilityChanged:" + z);
        }
    }

    public void V(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, postWriteCallBackData) == null) {
            if (this.k == null) {
                this.k = new au6(this.a.getPageContext(), (NavigationBarCoverTip) this.a.findViewById(R.id.obfuscated_res_0x7f091919));
            }
            this.k.l(postWriteCallBackData);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.e = z;
            if (!z) {
                SharedPrefHelper.getInstance().putBoolean("enter_forum_edit_mode", false);
            }
        }
    }

    public void D(@NonNull NewsRemindMessage newsRemindMessage, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, newsRemindMessage, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_NEW_MSG_TAB_CLICK);
            statisticItem.addParam("obj_type", z(newsRemindMessage));
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public FragmentTabHost A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.A);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SharedPrefHelper.getInstance().putBoolean("has_show_message_tab_tips", this.d);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f.setImageAssetsFolder("lottie_write_icon");
            SkinManager.setLottieAnimation(this.f, R.raw.write_icon_anim);
            this.f.playAnimation();
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (A() == null) {
                return true;
            }
            FragmentTabHost A = A();
            FragmentTabHost.c g2 = A.g(A.getCurrentTabIndex());
            if (g2 == null || g2.a != 22) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.j.removeCallbacks(this.G);
            this.j.removeCallbacks(this.H);
            kg.c(this.h);
        }
    }

    public MaintabBottomIndicator x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.n;
        }
        return (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.m;
        }
        return (MaintabBottomIndicator) invokeV.objValue;
    }

    public void B(ArrayList<FragmentDelegate> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.b.s();
            Iterator<FragmentDelegate> it = arrayList.iterator();
            while (it.hasNext()) {
                FragmentDelegate next = it.next();
                if (next != null && next.isAvailable()) {
                    v(next, next.getFragmentTabStructure(), next.getTabIndicator(this.a.getPageContext().getPageActivity()));
                }
            }
            s();
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.b.j(2);
            } else {
                this.b.j(1);
            }
            this.b.setViewPagerScrollable(false);
        }
    }

    public void E(int i2) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i2) != null) || (fragmentTabHost = this.b) == null) {
            return;
        }
        fragmentTabHost.setShouldDrawTopLine(true);
        gza gzaVar = this.v;
        if (gzaVar != null) {
            gzaVar.i(i2);
        }
        this.b.r(i2);
        FragmentTabHost fragmentTabHost2 = this.b;
        FragmentTabHost.c g2 = fragmentTabHost2.g(fragmentTabHost2.getCurrentTabIndex());
        if (g2 != null && g2.a == 22) {
            if (this.b.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().i(true, R.color.CAM_X0215);
            }
            this.b.p(true);
        } else {
            if (this.b.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().i(false, R.color.CAM_X0207);
            }
            this.b.p(false);
        }
        if (TbadkCoreApplication.getInst().isBottomBarDynamicHeightValid()) {
            this.b.setShouldDrawTopLine(false);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            N();
            if (A() != null) {
                A().s();
            }
            w();
            au6 au6Var = this.k;
            if (au6Var != null) {
                au6Var.h();
            }
            mra mraVar = this.l;
            if (mraVar != null) {
                mraVar.e();
            }
            ItemCardHelper.w(null);
            z66.L().J();
            EdgeFloatLifecycle.getInstance().release();
            gla glaVar = this.x;
            if (glaVar != null) {
                glaVar.d();
            }
        }
    }

    public void H(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (this.s != z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921645, Boolean.valueOf(z)));
                this.u = z;
                this.s = z;
            }
            if (!this.t && !this.u) {
                z2 = false;
            } else {
                z2 = true;
            }
            G(z2);
        }
    }

    public void M(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            A().setCurrentTabByType(i2);
            if (i2 != 2) {
                if (this.p && (maintabBottomIndicator = this.n) != null) {
                    maintabBottomIndicator.n(false);
                }
                this.p = false;
                if (x() != null) {
                    x().q = this.p;
                }
            }
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            y45 y45Var = new y45(this.a.getActivity());
            y45Var.setMessage(str);
            y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0474, new h(this));
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0422, new i(this));
            y45Var.create(this.a.getPageContext()).show();
        }
    }

    public void U(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, postWriteCallBackData) == null) && postWriteCallBackData != null && this.a.getActivityRootView() != null && postWriteCallBackData.mFrom == 1) {
            if (this.l == null) {
                MainTabActivity mainTabActivity = this.a;
                this.l = new mra(mainTabActivity, mainTabActivity.getActivityRootView());
            }
            this.l.g(postWriteCallBackData);
        }
    }

    public String z(@NonNull NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, newsRemindMessage)) == null) {
            int chatCount = newsRemindMessage.getChatCount() + newsRemindMessage.getMsgCount() + newsRemindMessage.getNotificationCount();
            if (!newsRemindMessage.hasChatRemind() && !newsRemindMessage.hasMsgRemind() && !newsRemindMessage.hasNotificationRemind()) {
                z = false;
            } else {
                z = true;
            }
            if (chatCount > 0) {
                return "1";
            }
            if (z) {
                return "3";
            }
            return "2";
        }
        return (String) invokeL.objValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ItemCardHelper.w(this.B);
            MessageManager.getInstance().registerListener(this.A);
            if (this.w != WindowGreySwitch.getIsOnNew()) {
                if (this.p && this.b != null) {
                    if (WindowGreySwitch.getIsOnNew()) {
                        j9.b(this.b.getFragmentTabWidget());
                        j9.b(this.f);
                        j9.b(this.g);
                        j9.b(this.b.getTabcontainerDynamicBgImg());
                    } else {
                        j9.a(this.b.getFragmentTabWidget());
                        j9.a(this.f);
                        j9.a(this.g);
                        j9.a(this.b.getTabcontainerDynamicBgImg());
                    }
                }
                this.w = WindowGreySwitch.getIsOnNew();
            }
        }
    }

    public final void K() {
        gla glaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - J) < 1500) {
                return;
            }
            J = currentTimeMillis;
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a, LoginDialogData.HOME_PAGE_WRITE_PAGE))) {
                return;
            }
            if (fna.a().i() && (glaVar = this.x) != null) {
                glaVar.e();
            }
            WriteActivityConfig.newInstance(this.a).setType(9).setFrom("main_tab").setCallFrom("2").setStatisticFrom(1).setIsWriteTest(true).send();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            d dVar = new d(this, this.a);
            dVar.setOnClickListener(new e(this));
            FragmentTabHost fragmentTabHost = this.b;
            if (fragmentTabHost != null && fragmentTabHost.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().d(dVar, 2);
            }
            DynamicIconData iconData = MainTabBottomDynamicIconManager.getInstance().getIconData("write");
            if (iconData != null && !TextUtils.isEmpty(iconData.getNormalStateUrl())) {
                TBLottieAnimationView tBLottieAnimationView = this.f;
                if (tBLottieAnimationView != null) {
                    tBLottieAnimationView.setVisibility(4);
                }
                TbImageView tbImageView = this.g;
                if (tbImageView != null) {
                    tbImageView.setVisibility(0);
                    this.g.startLoad(iconData.getNormalStateUrl(), iconData.getImgLoadType(), false);
                    return;
                }
                return;
            }
            TBLottieAnimationView tBLottieAnimationView2 = this.f;
            if (tBLottieAnimationView2 != null) {
                tBLottieAnimationView2.setVisibility(0);
                if (UbsABTestHelper.isNewWrite()) {
                    O();
                } else {
                    this.f.setImageResource(R.drawable.icon_mask_home_publish);
                }
            }
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.a.findViewById(R.id.obfuscated_res_0x7f0923bb);
            this.b = fragmentTabHost;
            fragmentTabHost.setVisibility(8);
            eka.a("MainTabViewController onViewCreated");
            fka.b(new r(this), 1);
            fka.b(new s(this), 5);
            this.b.setup(this.a.getSupportFragmentManager());
            this.b.setAbsoluteWeight(true);
            this.b.setOnTabSelectionListener(this.y);
            this.b.r(TbadkCoreApplication.getInst().getSkinType());
            this.b.setShouldDrawIndicatorLine(false);
            this.b.setShouldDrawTopLine(true);
            this.b.setOnPageChangeListener(new t(this));
            this.f = (TBLottieAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f090f87);
            this.g = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090f86);
            this.d = SharedPrefHelper.getInstance().getBoolean("has_show_message_tab_tips", false);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090088);
            this.b.setUIType(0);
            this.b.setTabContainerShadowShow(false);
            this.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            qka qkaVar = new qka(this.a, this.b.getTabWrapper());
            this.r = qkaVar;
            qkaVar.f(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.a.getPageContext()));
            this.a.registerListener(this.D);
            this.a.registerListener(this.z);
            this.a.registerListener(this.C);
            this.I.setSelfListener(true);
            this.a.registerListener(this.I);
            this.v = new gza(this.a, "main_tab", 1, "8");
            if (UbsABTestHelper.isNewWrite()) {
                gla glaVar = new gla(this.a, this.f);
                this.x = glaVar;
                glaVar.i(this.E);
            }
        }
    }

    public void Q(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.c.setVisibility(8);
                return;
            }
            FragmentTabHost.c h2 = this.b.h(8);
            if (h2 != null) {
                if (this.i && ((popupWindow = this.h) == null || !popupWindow.isShowing())) {
                    R(str, h2);
                    return;
                }
                if (this.F == null) {
                    this.F = new c(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.F);
                TbadkCoreApplication.getInst().handler.postDelayed(this.F, 5000L);
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public boolean u(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ei.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (!SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void R(String str, FragmentTabHost.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, cVar) == null) {
            int[] iArr = new int[2];
            cVar.b.getLocationInWindow(iArr);
            int width = iArr[0] + (cVar.b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.rightMargin = (BdUtilHelper.getScreenSize(this.a).widthPixels - width) - BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(0);
            this.c.setText(str);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            z66.L().O(this.a);
            z66.L().Y(BdUtilHelper.getEquipmentWidth(this.a));
            z66.L().X(BdUtilHelper.getEquipmentHeight(this.a));
            z66.L().Z(BdUtilHelper.getStatusBarHeight(this.a));
            z66.L().a0(BdUtilHelper.getDimens(this.a, R.dimen.tbds352));
            z66.L().T(TbadkCoreApplication.getInst().getNormalMainTabBarHeight() + BdUtilHelper.getDimens(this.a, R.dimen.tbds177));
            z66.L().V(new j(this));
            z66.L().W(new k(this));
            if (p66.h().b() > 0) {
                long b2 = p66.h().b() * 1000;
                z66.L().b0(b2);
                z66.L().U(b2);
                z66.L().c0();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public final void v(FragmentDelegate fragmentDelegate, FragmentTabStructure fragmentTabStructure, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048601, this, fragmentDelegate, fragmentTabStructure, tbFragmentTabIndicator) == null) && fragmentTabStructure != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.c = fragmentTabStructure.frag;
            cVar.a = fragmentTabStructure.type;
            maintabBottomIndicator.setShowIconType(fragmentTabStructure.showIconType);
            int i2 = fragmentTabStructure.showIconType;
            boolean z = false;
            if (i2 == FragmentTabStructure.SHOWICON) {
                maintabBottomIndicator.setWriteIconView();
                DynamicIconData dynamicIconData = fragmentTabStructure.dynamicIconData;
                if (dynamicIconData != null && !TextUtils.isEmpty(dynamicIconData.getNormalStateUrl())) {
                    this.f.setVisibility(4);
                    this.g.setVisibility(0);
                    this.g.startLoad(fragmentTabStructure.dynamicIconData.getNormalStateUrl(), fragmentTabStructure.dynamicIconData.getImgLoadType(), false);
                } else {
                    this.f.setVisibility(0);
                    if (UbsABTestHelper.isNewWrite()) {
                        O();
                    } else {
                        this.f.setImageResource(fragmentTabStructure.drawableResId);
                    }
                }
                z = true;
            } else if (i2 == FragmentTabStructure.SHOWLOTTIE) {
                maintabBottomIndicator.setText(fragmentTabStructure.textResId);
                maintabBottomIndicator.setAnimationResId(fragmentTabStructure.animationResId);
                this.m = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(fragmentTabStructure.textResId);
                maintabBottomIndicator.setAnimationResId(fragmentTabStructure.animationResId);
            }
            if (!ei.isEmpty(fragmentTabStructure.imageIconUrl)) {
                maintabBottomIndicator.setImageIconUrl(fragmentTabStructure.imageIconUrl, fragmentTabStructure.text);
            }
            DynamicIconData dynamicIconData2 = fragmentTabStructure.dynamicIconData;
            if (dynamicIconData2 != null) {
                maintabBottomIndicator.setDynamicIconData(dynamicIconData2);
            }
            if (cVar.a == 2) {
                maintabBottomIndicator.s = true;
                this.n = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            cVar.b = maintabBottomIndicator;
            cVar.d = fragmentDelegate;
            this.b.d(cVar, -1, z);
        }
    }
}
