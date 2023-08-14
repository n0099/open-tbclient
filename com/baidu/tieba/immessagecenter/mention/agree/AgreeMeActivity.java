package com.baidu.tieba.immessagecenter.mention.agree;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.be5;
import com.baidu.tieba.in;
import com.baidu.tieba.ob8;
import com.baidu.tieba.to8;
import com.baidu.tieba.uo8;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wo8;
import com.baidu.tieba.ym;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uo8 a;
    public to8 b;
    public int c;
    public boolean d;
    public boolean e;
    public CustomToast f;
    public to8.e g;
    public uo8.c h;
    public in i;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements to8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeMeActivity a;

        public a(AgreeMeActivity agreeMeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeMeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeMeActivity;
        }

        @Override // com.baidu.tieba.to8.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.k();
            }
        }

        @Override // com.baidu.tieba.to8.e
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.a != null) {
                this.a.a.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements uo8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeMeActivity a;

        public b(AgreeMeActivity agreeMeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeMeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeMeActivity;
        }

        @Override // com.baidu.tieba.uo8.c
        public void l(ArrayList<ym> arrayList) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) && this.a.b != null) {
                this.a.b.k(this.a.a.f, arrayList);
                AgreeMeActivity agreeMeActivity = this.a;
                agreeMeActivity.hideLoadingView(agreeMeActivity.b.d());
                AgreeMeActivity agreeMeActivity2 = this.a;
                agreeMeActivity2.hideNetRefreshView(agreeMeActivity2.b.d());
                if (this.a.b.f != null) {
                    this.a.b.f.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.uo8.c
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                be5.p0().f0(0);
                if (this.a.b == null) {
                    return;
                }
                this.a.b.l(false);
                if (ListUtils.isEmpty(this.a.b.e())) {
                    AgreeMeActivity agreeMeActivity = this.a;
                    agreeMeActivity.hideLoadingView(agreeMeActivity.b.d());
                    AgreeMeActivity agreeMeActivity2 = this.a;
                    agreeMeActivity2.showNetRefreshView(agreeMeActivity2.b.d(), this.a.getResources().getString(R.string.refresh_view_title_text), null, this.a.getResources().getString(R.string.refresh_view_button_text), true, this.a.getNetRefreshListener());
                    this.a.setNetRefreshViewEmotionMarginTop(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds370));
                    if (this.a.b.f != null) {
                        this.a.b.f.setVisibility(8);
                    }
                    if (this.a.f != null) {
                        this.a.f.showToast(R.string.obfuscated_res_0x7f0f0a42);
                        return;
                    }
                    return;
                }
                AgreeMeActivity agreeMeActivity3 = this.a;
                agreeMeActivity3.hideLoadingView(agreeMeActivity3.b.d());
                this.a.showToast(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements in {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeMeActivity a;

        public c(AgreeMeActivity agreeMeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeMeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeMeActivity;
        }

        @Override // com.baidu.tieba.in
        public void b(View view2, ym ymVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ymVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(ymVar instanceof wo8)) {
                return;
            }
            wo8 wo8Var = (wo8) ymVar;
            if (!TextUtils.isEmpty(wo8Var.getTargetScheme())) {
                UrlManager.getInstance().dealOneLink(wo8Var.getTargetScheme());
            } else if (wo8Var.c() == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getBaseContext(), Long.toString(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName())));
            } else if (wo8Var.c() != 2 && wo8Var.c() != 4) {
                if (wo8Var.c() == 5) {
                    this.a.F1(wo8Var);
                } else {
                    this.a.D1(wo8Var);
                }
            } else {
                this.a.E1(wo8Var);
            }
            if (wo8Var.t() != null) {
                StatisticItem param = new StatisticItem(wo8Var.t()).param("obj_locate", 1);
                if (wo8Var.getType() == wo8.E) {
                    param.param("obj_type", 2);
                } else {
                    param.param("obj_type", 1);
                }
                TiebaStatic.log(param);
            }
            if (wo8Var != null) {
                StatisticItem statisticItem = new StatisticItem("c13784");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", wo8Var.v());
                statisticItem.param("fname", wo8Var.d());
                statisticItem.param("obj_type", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements SwipeBackLayout.OnSlidingStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeMeActivity a;

        @Override // com.baidu.adp.widget.SwipeBackLayout.OnSlidingStateChangeListener
        public void onSlidingEnd(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        public d(AgreeMeActivity agreeMeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeMeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = agreeMeActivity;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.OnSlidingStateChangeListener
        public void onSlidingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I1();
            }
        }
    }

    public AgreeMeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 3;
        this.g = new a(this);
        this.h = new b(this);
        this.i = new c(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        to8 to8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && BdNetTypeUtil.isNetWorkAvailable() && this.a != null && (to8Var = this.b) != null) {
            hideNetRefreshView(to8Var.f());
            showLoadingView(this.b.d(), true);
            this.a.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && this.c != i) {
            this.c = i;
            to8 to8Var = this.b;
            if (to8Var != null) {
                to8Var.c(i);
            }
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ob8.b().g(1, 0);
            be5.p0().h();
            be5.p0().f0(0);
        }
    }

    public final void G1() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setOnSlidingStateChangeListener(new d(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.e) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.finish();
            if (this.e) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setBottomTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            B1();
            to8 to8Var = this.b;
            if (to8Var != null) {
                to8Var.h();
            }
            uo8 uo8Var = this.a;
            if (uo8Var != null) {
                uo8Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            CustomToast customToast = this.f;
            if (customToast != null) {
                customToast.onPause();
            }
            if (isFinishing()) {
                I1();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            CustomToast customToast = this.f;
            if (customToast != null) {
                customToast.onResume();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        uo8 uo8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (uo8Var = this.a) != null) {
            uo8Var.h();
        }
    }

    public final void D1(wo8 wo8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wo8Var) != null) || wo8Var == null) {
            return;
        }
        String n = wo8Var.n();
        PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(wo8Var.v(), n, 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setHighLightPostId(wo8Var.n());
        createNormalCfg.setJumpToCommentArea(!TextUtils.isEmpty(n));
        createNormalCfg.setBjhData(wo8Var.getBaijiahaoData());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void E1(wo8 wo8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wo8Var) != null) || wo8Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = wo8Var.v();
        arrayList.add(videoItemData);
        if (wo8Var.c() == 4) {
            videoItemData.highLightPostId = wo8Var.n();
        }
        new VideoRecommentPlayActivityConfig(this, arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE, !TextUtils.isEmpty(videoItemData.highLightPostId)).start();
    }

    public final void F1(wo8 wo8Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, wo8Var) != null) || wo8Var == null) {
            return;
        }
        String v = wo8Var.v();
        String n = wo8Var.n();
        if (wo8Var.r() == null) {
            userName = "";
        } else {
            userName = wo8Var.r().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(v, "", "mention", false, userName, false, n, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(wo8Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(n);
        createSubPbActivityConfig.setKeyOriUgcTopPid("");
        createSubPbActivityConfig.start();
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.d) {
            return;
        }
        this.d = true;
        if (getIntent() == null || getIntent().getIntExtra(AgreeMeActivityConfig.KEY_AGREE_NUMBER, 0) <= 0) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921700, new int[]{getIntent().getIntExtra("last_page_unique_id", 0), 7}));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            boolean z = true;
            z = (BdActivityStack.getInst().isActivityExist("YunPushProxyActivity") && BdActivityStack.getInst().getSize() == 1) ? false : false;
            this.e = z;
            if (z) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            this.f = CustomToast.newInstance();
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0086, (ViewGroup) null);
            setContentView(inflate);
            to8 to8Var = new to8(getPageContext(), inflate);
            this.b = to8Var;
            to8Var.j(this.g);
            this.b.i(this.i);
            this.a = new uo8(getPageContext(), this.h);
            showLoadingView(this.b.d());
            this.b.l(false);
            this.a.e();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AGREE_PAGE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            G1();
        }
    }
}
