package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SoLoadUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.ad.incentivevideo.net.GetIncentiveVideoTaskModel;
import com.baidu.tieba.e86;
import com.baidu.tieba.edgefloat.EdgeFloatLifecycle;
import com.baidu.tieba.p55;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class pfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ItemCardHelper.c A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public Runnable D;
    public Runnable E;
    public Runnable F;
    public MainTabActivity a;
    public FragmentTabHost b;
    public TextView c;
    public boolean d;
    public boolean e;
    public TbImageView f;
    public TbImageView g;
    public PopupWindow h;
    public boolean i;
    public Handler j;
    public gu6 k;
    public ama l;
    public MaintabBottomIndicator m;
    public MaintabBottomIndicator n;
    public int o;
    public boolean p;
    public boolean q;
    public vfa r;
    public boolean s;
    public boolean t;
    public boolean u;
    public nta v;
    public boolean w;
    public FragmentTabHost.b x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes7.dex */
    public class a implements FragmentTabHost.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        /* renamed from: com.baidu.tieba.pfa$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0451a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public RunnableC0451a(a aVar, CustomResponsedMessage customResponsedMessage) {
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

        public a(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
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
                zg.a().postDelayed(new RunnableC0451a(this, new CustomResponsedMessage(2921520, prePageKey)), 100L);
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
                        this.a.v.m();
                    }
                    return false;
                } else if (i2 == 8 && !TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_person");
                    if (this.a.m != null) {
                        this.a.m.n();
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
        /* JADX WARN: Code restructure failed: missing block: B:89:0x02c4, code lost:
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
                    lga a = kia.a().b().a();
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
                        this.a.m.n();
                    }
                    TiebaStatic.log("c13841");
                    SoLoadUtils.checkDownloadSo("libmml_framework.so", "com.baidu.tieba.soloader.libmmlframework", "mml_framework");
                    SoLoadUtils.checkDownloadSo("libc++_shared.so", "com.baidu.tieba.soloader.libcshared", SwanKV.LIB_CPP_SHARED);
                    SoLoadUtils.checkDownloadSo("libopencv_java3.so", "com.baidu.tieba.soloader.libopencv_java3", "opencv_java3");
                    SoLoadUtils.checkDownloadSo("libbd_pass_face_sdk.so", "com.baidu.tieba.soloader.libbdface", "bd_pass_face_sdk");
                } else if (i5 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                    lf5 lf5Var = (lf5) ServiceManager.getService(lf5.a);
                    if (lf5Var != null) {
                        lf5Var.d();
                    }
                    TbSingleton.MsgUpgradeTips.onMsgTabClick();
                    TbFragmentTabIndicator tbFragmentTabIndicator = g.b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.d("msg") != null && (maintabBottomIndicator.d("msg").a instanceof MessageRedDotView)) {
                            str = ((MessageRedDotView) maintabBottomIndicator.d("msg").a).getRedNum();
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
                }
                if (g.a == 2) {
                    if (this.a.p) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.a.p = true;
                    if (this.a.n != null) {
                        this.a.n.t(this.a.p);
                    }
                    if (WindowGreySwitch.getIsOnNew()) {
                        o9.b(this.a.b.getFragmentTabWidget());
                        o9.b(this.a.f);
                        o9.b(this.a.g);
                        o9.b(this.a.b.getTabcontainerDynamicBgImg());
                    }
                } else {
                    if (this.a.p && this.a.n != null) {
                        this.a.n.t(this.a.p);
                    }
                    this.a.p = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                    if (WindowGreySwitch.getIsOnNew()) {
                        o9.a(this.a.b.getFragmentTabWidget());
                        o9.a(this.a.f);
                        o9.a(this.a.g);
                        o9.a(this.a.b.getTabcontainerDynamicBgImg());
                    }
                }
                if (this.a.w() != null) {
                    this.a.w().w = this.a.p;
                }
                b(this.a.o);
                a(this.a.o);
                this.a.o = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(g.a)));
                if (g.a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator2 = g.b;
                    if (tbFragmentTabIndicator2 instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator2 = (MaintabBottomIndicator) tbFragmentTabIndicator2;
                        if (maintabBottomIndicator2.d("video_msg") != null && (maintabBottomIndicator2.d("video_msg").a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator2.d("video_msg").a).getRedNum();
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
                    nq5.b().c();
                    nq5.b().l(true);
                    if (this.a.b.g(this.a.b.getCurrentTabIndex()) != null && this.a.b.g(this.a.b.getCurrentTabIndex()).a == 22) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    } else {
                        if (this.a.b.getFragmentTabWidget() != null) {
                            this.a.b.getFragmentTabWidget().i(true, R.color.CAM_X0215);
                        }
                        this.a.b.q(true);
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            yi.O(this.a.a, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e1f));
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                    }
                } else {
                    nq5.b().o();
                    nq5.b().l(false);
                    if (this.a.b.getFragmentTabWidget() != null) {
                        this.a.b.getFragmentTabWidget().i(false, R.color.CAM_X0207);
                    }
                    this.a.b.q(false);
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

    /* loaded from: classes7.dex */
    public class r implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

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

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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

        public r(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
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
                if (this.a.b.getCurrentTabType() == 1 && !da5.p().l("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (da5.p().l("enter_forum_edit_mode", false)) {
                    if (this.a.b.getCurrentTabType() == 3) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    } else if (this.a.b.getCurrentTabType() == 2) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                    }
                }
                if (this.a.b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
                zg.a().postDelayed(new a(this), 300L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pfa b;

        public b(pfa pfaVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pfaVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.L(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends TbFragmentTabIndicator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(pfa pfaVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar, context};
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

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        public d(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nta ntaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a, LoginDialogData.HOME_PAGE_WRITE_PAGE)) && (ntaVar = this.a.v) != null) {
                ntaVar.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        public e(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null && this.a.h != null) {
                FragmentTabWidget fragmentTabWidget = this.a.b.getFragmentTabWidget();
                yi.l(this.a.a.getActivity());
                int g = yi.g(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070384);
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
                    measuredWidth2 = yi.g(this.a.a.getActivity(), R.dimen.tbds570);
                }
                bh.l(this.a.h, fragmentTabWidget, measuredWidth2, -g);
                da5.p().A("show_maintab_last_message_tips", true);
                this.a.i = true;
                this.a.j.postDelayed(this.a.F, 5000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        public f(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                p55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                p55Var.dismiss();
                jz7.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements e86.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        public i(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
        }

        @Override // com.baidu.tieba.e86.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v76.i().v(6);
                v76.i().t();
                new GetIncentiveVideoTaskModel(this.a.a, 6).d0();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements e86.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.e86.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(pfa pfaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar, Integer.valueOf(i)};
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
            this.a = pfaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            jo5 jo5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && (customResponsedMessage.getData() instanceof jo5) && (jo5Var = (jo5) customResponsedMessage.getData()) != null && this.a.b.h(jo5Var.e) != null && this.a.b.getCurrentTabType() != jo5Var.e) {
                TbFragmentTabIndicator tbFragmentTabIndicator = this.a.b.h(jo5Var.e).b;
                if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(jo5Var.g, jo5Var.c);
                    if (TextUtils.isEmpty(jo5Var.g)) {
                        return;
                    }
                    this.a.q = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(pfa pfaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar, Integer.valueOf(i)};
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
            this.a = pfaVar;
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

    /* loaded from: classes7.dex */
    public class m implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        public m(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
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

    /* loaded from: classes7.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(pfa pfaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar, Integer.valueOf(i)};
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
            this.a = pfaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            no5 d;
            no5 d2;
            no5 d3;
            no5 d4;
            no5 d5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && qo5.f().b() && !qo5.f().c()) {
                TbadkCoreApplication.getInst().setBottomBarDynamicHeightValid(true);
                FragmentTabHost.c h = this.a.b.h(2);
                if (h != null && (h.b instanceof MaintabBottomIndicator) && (d5 = qo5.f().d("homePage")) != null) {
                    ((MaintabBottomIndicator) h.b).setDynamicIconData(d5);
                }
                FragmentTabHost.c h2 = this.a.b.h(1);
                if (h2 != null && (h2.b instanceof MaintabBottomIndicator) && (d4 = qo5.f().d("enterForum")) != null) {
                    ((MaintabBottomIndicator) h2.b).setDynamicIconData(d4);
                }
                FragmentTabHost.c h3 = this.a.b.h(22);
                if (h3 != null && (h3.b instanceof MaintabBottomIndicator) && (d3 = qo5.f().d("channel")) != null) {
                    ((MaintabBottomIndicator) h3.b).setDynamicIconData(d3);
                }
                FragmentTabHost.c h4 = this.a.b.h(3);
                if (h4 != null && (h4.b instanceof MaintabBottomIndicator) && (d2 = qo5.f().d("message")) != null) {
                    ((MaintabBottomIndicator) h4.b).setDynamicIconData(d2);
                }
                FragmentTabHost.c h5 = this.a.b.h(8);
                if (h5 != null && (h5.b instanceof MaintabBottomIndicator) && (d = qo5.f().d("person")) != null) {
                    ((MaintabBottomIndicator) h5.b).setDynamicIconData(d);
                }
                no5 d6 = qo5.f().d("write");
                if (d6 != null) {
                    if (this.a.f != null) {
                        this.a.f.setVisibility(8);
                    }
                    if (this.a.g != null) {
                        this.a.g.setUseNightOrDarkMask(false);
                        this.a.g.setVisibility(0);
                        this.a.g.N(d6.t(), d6.s(), false);
                    }
                } else if (this.a.f != null) {
                    this.a.f.setVisibility(0);
                    this.a.g.setVisibility(8);
                }
                if (qo5.f().i() != null) {
                    this.a.b.n(qo5.f().i());
                    this.a.b.p();
                } else {
                    this.a.b.m();
                }
                this.a.b.setShouldDrawTopLine(false);
                this.a.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarDynamicStyleHeight());
                qo5.f().m(qo5.f().e().hashCode());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(pfa pfaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar, Integer.valueOf(i)};
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
            this.a = pfaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.p = true;
            if (this.a.w() != null) {
                this.a.w().w = this.a.p;
            }
            da5.p().A("key_member_auto_ban_renewal_show", false);
            c76.k().o();
            v76.i().s();
            r95.b().l();
            qo5.f().l();
            this.a.f.setVisibility(0);
            this.a.g.setVisibility(8);
            this.a.b.setShouldDrawTopLine(true);
            this.a.b.m();
            this.a.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        public p(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(4);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pfa a;

        public q(pfa pfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pfaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(0);
            }
        }
    }

    public pfa(MainTabActivity mainTabActivity) {
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
        this.x = new a(this);
        this.y = new k(this, 2921492);
        this.z = new l(this, 2001440);
        this.A = new m(this);
        this.B = new n(this, 2921551);
        this.C = new o(this, 2921410);
        this.E = new e(this);
        this.F = new f(this);
        this.a = mainTabActivity;
        jfa.a("MainTabViewController init");
    }

    public void B(int i2) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) != null) || (fragmentTabHost = this.b) == null) {
            return;
        }
        fragmentTabHost.setShouldDrawTopLine(true);
        nta ntaVar = this.v;
        if (ntaVar != null) {
            ntaVar.i(i2);
        }
        this.b.s(i2);
        FragmentTabHost fragmentTabHost2 = this.b;
        FragmentTabHost.c g2 = fragmentTabHost2.g(fragmentTabHost2.getCurrentTabIndex());
        if (g2 != null && g2.a == 22) {
            if (this.b.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().i(true, R.color.CAM_X0215);
            }
            this.b.q(true);
        } else {
            if (this.b.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().i(false, R.color.CAM_X0207);
            }
            this.b.q(false);
        }
        if (TbadkCoreApplication.getInst().isBottomBarDynamicHeightValid()) {
            this.b.setShouldDrawTopLine(false);
        }
    }

    public void z(ArrayList<io5> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) {
            this.b.t();
            Iterator<io5> it = arrayList.iterator();
            while (it.hasNext()) {
                io5 next = it.next();
                if (next != null && next.d()) {
                    u(next, next.b(), next.c(this.a.getPageContext().getPageActivity()));
                }
            }
            r();
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.b.k(2);
            } else {
                this.b.k(1);
            }
            this.b.setViewPagerScrollable(false);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            jfa.a("MainTabViewController onKeyboardVisibilityChanged:" + z);
            FragmentTabHost fragmentTabHost = this.b;
            if (fragmentTabHost != null) {
                if (z) {
                    fragmentTabHost.i();
                } else {
                    fragmentTabHost.u();
                }
            }
        }
    }

    public void Q(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postWriteCallBackData) == null) {
            if (this.k == null) {
                this.k = new gu6(this.a.getPageContext(), (NavigationBarCoverTip) this.a.findViewById(R.id.obfuscated_res_0x7f0918c9));
            }
            this.k.l(postWriteCallBackData);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.e = z;
            if (!z) {
                da5.p().A("enter_forum_edit_mode", false);
            }
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.z);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            da5.p().A("has_show_message_tab_tips", this.d);
        }
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (y() == null) {
                return true;
            }
            FragmentTabHost y = y();
            FragmentTabHost.c g2 = y.g(y.getCurrentTabIndex());
            if (g2 == null || g2.a != 22) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.j.removeCallbacks(this.E);
            this.j.removeCallbacks(this.F);
            bh.c(this.h);
        }
    }

    public MaintabBottomIndicator w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.n;
        }
        return (MaintabBottomIndicator) invokeV.objValue;
    }

    public MaintabBottomIndicator x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.m;
        }
        return (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.b;
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            J();
            if (y() != null) {
                y().t();
            }
            v();
            gu6 gu6Var = this.k;
            if (gu6Var != null) {
                gu6Var.h();
            }
            ama amaVar = this.l;
            if (amaVar != null) {
                amaVar.e();
            }
            ItemCardHelper.w(null);
            e86.K().J();
            EdgeFloatLifecycle.c().j();
        }
    }

    public void E(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
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
            D(z2);
        }
    }

    public void I(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            y().setCurrentTabByType(i2);
            if (i2 != 2) {
                if (this.p && (maintabBottomIndicator = this.n) != null) {
                    maintabBottomIndicator.t(false);
                }
                this.p = false;
                if (w() != null) {
                    w().w = this.p;
                }
            }
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            p55 p55Var = new p55(this.a.getActivity());
            p55Var.setMessage(str);
            p55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0471, new g(this));
            p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f041f, new h(this));
            p55Var.create(this.a.getPageContext()).show();
        }
    }

    public void P(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, postWriteCallBackData) == null) && postWriteCallBackData != null && this.a.getActivityRootView() != null && postWriteCallBackData.mFrom == 1) {
            if (this.l == null) {
                MainTabActivity mainTabActivity = this.a;
                this.l = new ama(mainTabActivity, mainTabActivity.getActivityRootView());
            }
            this.l.g(postWriteCallBackData);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ItemCardHelper.w(this.A);
            MessageManager.getInstance().registerListener(this.z);
            if (this.w != WindowGreySwitch.getIsOnNew()) {
                if (this.p && this.b != null) {
                    if (WindowGreySwitch.getIsOnNew()) {
                        o9.b(this.b.getFragmentTabWidget());
                        o9.b(this.f);
                        o9.b(this.g);
                        o9.b(this.b.getTabcontainerDynamicBgImg());
                    } else {
                        o9.a(this.b.getFragmentTabWidget());
                        o9.a(this.f);
                        o9.a(this.g);
                        o9.a(this.b.getTabcontainerDynamicBgImg());
                    }
                }
                this.w = WindowGreySwitch.getIsOnNew();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c cVar = new c(this, this.a);
            cVar.setOnClickListener(new d(this));
            FragmentTabHost fragmentTabHost = this.b;
            if (fragmentTabHost != null && fragmentTabHost.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().d(cVar, 2);
            }
            no5 d2 = qo5.f().d("write");
            if (d2 != null && !TextUtils.isEmpty(d2.t())) {
                TbImageView tbImageView = this.f;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                TbImageView tbImageView2 = this.g;
                if (tbImageView2 != null) {
                    tbImageView2.setVisibility(0);
                    this.g.N(d2.t(), d2.s(), false);
                    return;
                }
                return;
            }
            TbImageView tbImageView3 = this.f;
            if (tbImageView3 != null) {
                tbImageView3.setVisibility(0);
                this.f.setImageResource(R.drawable.icon_mask_home_publish);
            }
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.a.findViewById(R.id.obfuscated_res_0x7f09232f);
            this.b = fragmentTabHost;
            fragmentTabHost.setVisibility(8);
            jfa.a("MainTabViewController onViewCreated");
            kfa.b(new p(this), 1);
            kfa.b(new q(this), 5);
            this.b.setup(this.a.getSupportFragmentManager());
            this.b.setAbsoluteWeight(true);
            this.b.setOnTabSelectionListener(this.x);
            this.b.s(TbadkCoreApplication.getInst().getSkinType());
            this.b.setShouldDrawIndicatorLine(false);
            this.b.setShouldDrawTopLine(true);
            this.b.setOnPageChangeListener(new r(this));
            this.f = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090f68);
            this.g = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090f67);
            this.d = da5.p().l("has_show_message_tab_tips", false);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090088);
            this.b.setUIType(0);
            this.b.setTabContainerShadowShow(false);
            this.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            vfa vfaVar = new vfa(this.a, this.b.getTabWrapper());
            this.r = vfaVar;
            vfaVar.f(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.a.getPageContext()));
            this.a.registerListener(this.C);
            this.a.registerListener(this.y);
            this.a.registerListener(this.B);
            this.v = new nta(this.a, "main_tab", 1, "8");
        }
    }

    public void L(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.c.setVisibility(8);
                return;
            }
            FragmentTabHost.c h2 = this.b.h(8);
            if (h2 != null) {
                if (this.i && ((popupWindow = this.h) == null || !popupWindow.isShowing())) {
                    M(str, h2);
                    return;
                }
                if (this.D == null) {
                    this.D = new b(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.D);
                TbadkCoreApplication.getInst().handler.postDelayed(this.D, 5000L);
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public boolean t(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || xi.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (!da5.p().l(da5.t(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M(String str, FragmentTabHost.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, cVar) == null) {
            int[] iArr = new int[2];
            cVar.b.getLocationInWindow(iArr);
            int width = iArr[0] + (cVar.b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.rightMargin = (yi.u(this.a).widthPixels - width) - yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(0);
            this.c.setText(str);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            e86.K().N(this.a);
            e86.K().X(yi.l(this.a));
            e86.K().W(yi.j(this.a));
            e86.K().Y(yi.v(this.a));
            e86.K().Z(yi.g(this.a, R.dimen.tbds352));
            e86.K().S(TbadkCoreApplication.getInst().getNormalMainTabBarHeight() + yi.g(this.a, R.dimen.tbds177));
            e86.K().U(new i(this));
            e86.K().V(new j(this));
            if (u76.h().b() > 0) {
                long b2 = u76.h().b() * 1000;
                e86.K().a0(b2);
                e86.K().T(b2);
                e86.K().b0();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public final void u(io5 io5Var, jo5 jo5Var, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048596, this, io5Var, jo5Var, tbFragmentTabIndicator) == null) && jo5Var != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.c = jo5Var.a;
            cVar.a = jo5Var.e;
            maintabBottomIndicator.setShowIconType(jo5Var.i);
            int i2 = jo5Var.i;
            boolean z = false;
            if (i2 == jo5.j) {
                maintabBottomIndicator.setWriteIconView();
                no5 no5Var = jo5Var.h;
                if (no5Var != null && !TextUtils.isEmpty(no5Var.t())) {
                    this.f.setVisibility(8);
                    this.g.setVisibility(0);
                    this.g.N(jo5Var.h.t(), jo5Var.h.s(), false);
                } else {
                    this.f.setVisibility(0);
                    this.f.setImageResource(jo5Var.d);
                }
                z = true;
            } else if (i2 == jo5.m) {
                maintabBottomIndicator.setText(jo5Var.b);
                maintabBottomIndicator.setAnimationResId(jo5Var.f);
                this.m = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(jo5Var.b);
                maintabBottomIndicator.setAnimationResId(jo5Var.f);
            }
            if (!xi.isEmpty(jo5Var.g)) {
                maintabBottomIndicator.setImageIconUrl(jo5Var.g, jo5Var.c);
            }
            no5 no5Var2 = jo5Var.h;
            if (no5Var2 != null) {
                maintabBottomIndicator.setDynamicIconData(no5Var2);
            }
            if (cVar.a == 2) {
                maintabBottomIndicator.y = true;
                this.n = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            cVar.b = maintabBottomIndicator;
            cVar.d = io5Var;
            this.b.d(cVar, -1, z);
        }
    }
}
