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
import com.baidu.tieba.cn;
import com.baidu.tieba.kf8;
import com.baidu.tieba.mn;
import com.baidu.tieba.re5;
import com.baidu.tieba.ut8;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.vt8;
import com.baidu.tieba.xt8;
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
    public vt8 a;
    public ut8 b;
    public int c;
    public boolean d;
    public boolean e;
    public CustomToast f;
    public ut8.e g;
    public vt8.c h;
    public mn i;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ut8.e {
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

        @Override // com.baidu.tieba.ut8.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.k();
            }
        }

        @Override // com.baidu.tieba.ut8.e
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.a != null) {
                this.a.a.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements vt8.c {
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

        @Override // com.baidu.tieba.vt8.c
        public void l(ArrayList<cn> arrayList) {
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

        @Override // com.baidu.tieba.vt8.c
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                re5.p0().f0(0);
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
                        this.a.f.showToast(R.string.obfuscated_res_0x7f0f0a50);
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
    public class c implements mn {
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

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(cnVar instanceof xt8)) {
                return;
            }
            xt8 xt8Var = (xt8) cnVar;
            if (!TextUtils.isEmpty(xt8Var.getTargetScheme())) {
                UrlManager.getInstance().dealOneLink(xt8Var.getTargetScheme());
            } else if (xt8Var.c() == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getBaseContext(), Long.toString(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName())));
            } else if (xt8Var.c() != 2 && xt8Var.c() != 4) {
                if (xt8Var.c() == 5) {
                    this.a.A1(xt8Var);
                } else {
                    this.a.y1(xt8Var);
                }
            } else {
                this.a.z1(xt8Var);
            }
            if (xt8Var.t() != null) {
                StatisticItem param = new StatisticItem(xt8Var.t()).param("obj_locate", 1);
                if (xt8Var.getType() == xt8.E) {
                    param.param("obj_type", 2);
                } else {
                    param.param("obj_type", 1);
                }
                TiebaStatic.log(param);
            }
            if (xt8Var != null) {
                StatisticItem statisticItem = new StatisticItem("c13784");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", xt8Var.v());
                statisticItem.param("fname", xt8Var.d());
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
                this.a.C1();
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
        ut8 ut8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && BdNetTypeUtil.isNetWorkAvailable() && this.a != null && (ut8Var = this.b) != null) {
            hideNetRefreshView(ut8Var.f());
            showLoadingView(this.b.d(), true);
            this.a.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.c != i) {
            this.c = i;
            ut8 ut8Var = this.b;
            if (ut8Var != null) {
                ut8Var.c(i);
            }
        }
    }

    public final void A1(xt8 xt8Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, xt8Var) != null) || xt8Var == null) {
            return;
        }
        String v = xt8Var.v();
        String o = xt8Var.o();
        if (xt8Var.s() == null) {
            userName = "";
        } else {
            userName = xt8Var.s().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(v, "", "mention", false, userName, false, o, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(xt8Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(o);
        createSubPbActivityConfig.setKeyOriUgcTopPid("");
        createSubPbActivityConfig.start();
    }

    public final void y1(xt8 xt8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, xt8Var) != null) || xt8Var == null) {
            return;
        }
        String o = xt8Var.o();
        PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(xt8Var.v(), o, 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setHighLightPostId(xt8Var.o());
        createNormalCfg.setJumpToCommentArea(!TextUtils.isEmpty(o));
        createNormalCfg.setBjhData(xt8Var.getBaijiahaoData());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void z1(xt8 xt8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, xt8Var) != null) || xt8Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = xt8Var.v();
        arrayList.add(videoItemData);
        if (xt8Var.c() == 4) {
            videoItemData.highLightPostId = xt8Var.o();
        }
        new VideoRecommentPlayActivityConfig(this, arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE, !TextUtils.isEmpty(videoItemData.highLightPostId)).start();
    }

    public final void B1() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (swipeBackLayout = this.mSwipeBackLayout) != null) {
            swipeBackLayout.setOnSlidingStateChangeListener(new d(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            x1();
            ut8 ut8Var = this.b;
            if (ut8Var != null) {
                ut8Var.h();
            }
            vt8 vt8Var = this.a;
            if (vt8Var != null) {
                vt8Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            CustomToast customToast = this.f;
            if (customToast != null) {
                customToast.onPause();
            }
            if (isFinishing()) {
                C1();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            CustomToast customToast = this.f;
            if (customToast != null) {
                customToast.onResume();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        vt8 vt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (vt8Var = this.a) != null) {
            vt8Var.h();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            kf8.b().g(1, 0);
            re5.p0().h();
            re5.p0().f0(0);
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.d) {
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
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            boolean z = true;
            z = (BdActivityStack.getInst().isActivityExist("YunPushProxyActivity") && BdActivityStack.getInst().getSize() == 1) ? false : false;
            this.e = z;
            if (z) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            this.f = CustomToast.newInstance();
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d008b, (ViewGroup) null);
            setContentView(inflate);
            ut8 ut8Var = new ut8(getPageContext(), inflate);
            this.b = ut8Var;
            ut8Var.j(this.g);
            this.b.i(this.i);
            this.a = new vt8(getPageContext(), this.h);
            showLoadingView(this.b.d());
            this.b.l(false);
            this.a.e();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AGREE_PAGE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            B1();
        }
    }
}
