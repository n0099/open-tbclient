package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.n9;
import com.baidu.tieba.no;
import com.baidu.tieba.rd7;
import com.baidu.tieba.sd7;
import com.baidu.tieba.ud7;
import com.baidu.tieba.v15;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sd7 a;
    public rd7 b;
    public int c;
    public boolean d;
    public boolean e;
    public rd7.e f;
    public sd7.c g;
    public no h;

    /* loaded from: classes4.dex */
    public class a implements rd7.e {
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

        @Override // com.baidu.tieba.rd7.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.j();
        }

        @Override // com.baidu.tieba.rd7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.g();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements sd7.c {
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

        @Override // com.baidu.tieba.sd7.c
        public void h(ArrayList<Cdo> arrayList) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || this.a.b == null) {
                return;
            }
            this.a.b.k(this.a.a.f, arrayList);
            AgreeMeActivity agreeMeActivity = this.a;
            agreeMeActivity.hideLoadingView(agreeMeActivity.b.d());
            AgreeMeActivity agreeMeActivity2 = this.a;
            agreeMeActivity2.hideNetRefreshView(agreeMeActivity2.b.f());
            if (this.a.b.f != null) {
                this.a.b.f.setVisibility(0);
            }
        }

        @Override // com.baidu.tieba.sd7.c
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                v15.h0().Y(0);
                if (this.a.b == null) {
                    return;
                }
                this.a.b.l(false);
                if (ListUtils.isEmpty(this.a.b.e())) {
                    AgreeMeActivity agreeMeActivity = this.a;
                    agreeMeActivity.hideLoadingView(agreeMeActivity.b.d());
                    AgreeMeActivity agreeMeActivity2 = this.a;
                    agreeMeActivity2.showNetRefreshView(agreeMeActivity2.b.f(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fd9), null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fd8), true, this.a.getNetRefreshListener());
                    this.a.setNetRefreshViewEmotionMarginTop(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (this.a.b.f != null) {
                        this.a.b.f.setVisibility(8);
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

    /* loaded from: classes4.dex */
    public class c implements no {
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

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof ud7)) {
                ud7 ud7Var = (ud7) cdo;
                if (ud7Var.getType() == ud7.A) {
                    this.a.F1(ud7Var);
                } else if (ud7Var.getType() == ud7.C) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getBaseContext(), Long.toString(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName())));
                } else if (ud7Var.getThreadType() != 40) {
                    this.a.H1(ud7Var);
                } else {
                    this.a.G1(ud7Var);
                }
                if (ud7Var.B() != null) {
                    StatisticItem param = new StatisticItem(ud7Var.B()).param("obj_locate", 1);
                    if (ud7Var.getType() == ud7.B) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (ud7Var != null) {
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", ud7Var.D());
                    statisticItem.param("fname", ud7Var.c());
                    statisticItem.param("obj_type", 2);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements SwipeBackLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AgreeMeActivity a;

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

        @Override // com.baidu.adp.widget.SwipeBackLayout.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.J1();
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
        this.f = new a(this);
        this.g = new b(this);
        this.h = new c(this);
    }

    public final void F1(ud7 ud7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ud7Var) == null) || ud7Var == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(ud7Var.getBaijiahaoData())) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(ud7Var.D(), (String) null, 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(ud7Var.t());
            createNormalCfg.setBjhData(ud7Var.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        } else if (ud7Var.getThreadType() == 40) {
            G1(ud7Var);
        } else {
            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this).createNormalCfg(ud7Var.D(), ud7Var.t(), 1, "mention");
            createNormalCfg2.setStartFrom(12);
            createNormalCfg2.setHighLightPostId(ud7Var.t());
            createNormalCfg2.setBjhData(ud7Var.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
        }
    }

    public void G1(ud7 ud7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ud7Var) == null) || ud7Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = ud7Var.D();
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this, arrayList, null, VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public final void H1(ud7 ud7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ud7Var) == null) || ud7Var == null) {
            return;
        }
        String D = ud7Var.D();
        String t = ud7Var.t();
        String userName = ud7Var.A() == null ? "" : ud7Var.A().getUserName();
        if (!TextUtils.isEmpty(ud7Var.w()) && !"0".equals(ud7Var.w())) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(D, ud7Var.w(), "mention", false, userName, false, ud7Var.w(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(13);
            createSubPbActivityConfig.setBjhData(ud7Var.getBaijiahaoData());
            createSubPbActivityConfig.setHighLightPostId(t);
            createSubPbActivityConfig.setKeyOriUgcTopPid(t);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(D, t, "mention", false, userName, false, t, 0);
        createSubPbActivityConfig2.setKeyPageStartFrom(13);
        createSubPbActivityConfig2.setBjhData(ud7Var.getBaijiahaoData());
        createSubPbActivityConfig2.setHighLightPostId(t);
        createSubPbActivityConfig2.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig2));
    }

    public final void I1() {
        SwipeBackLayout swipeBackLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (swipeBackLayout = this.mSwipeBackLayout) == null) {
            return;
        }
        swipeBackLayout.setOnSlidingStateChangeListener(new d(this));
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.d) {
            return;
        }
        this.d = true;
        if (getIntent() != null && getIntent().getIntExtra(AgreeMeActivityConfig.KEY_AGREE_NUMBER, 0) > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921700, new int[]{getIntent().getIntExtra("last_page_unique_id", 0), 7}));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.finish();
            if (this.e) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setBottomTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.hc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.c == i) {
            return;
        }
        this.c = i;
        rd7 rd7Var = this.b;
        if (rd7Var != null) {
            rd7Var.c(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            boolean z = true;
            z = (n9.g().i("YunPushProxyActivity") && n9.g().h() == 1) ? false : false;
            this.e = z;
            if (z) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0082, (ViewGroup) null);
            setContentView(inflate);
            rd7 rd7Var = new rd7(getPageContext(), inflate);
            this.b = rd7Var;
            rd7Var.j(this.f);
            this.b.i(this.h);
            this.a = new sd7(getPageContext(), this.g);
            showLoadingView(this.b.d());
            this.b.l(false);
            this.a.d();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AGREE_PAGE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            I1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            rd7 rd7Var = this.b;
            if (rd7Var != null) {
                rd7Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        rd7 rd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || !BdNetTypeUtil.isNetWorkAvailable() || this.a == null || (rd7Var = this.b) == null) {
            return;
        }
        hideNetRefreshView(rd7Var.f());
        showLoadingView(this.b.d(), true);
        this.a.d();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            if (isFinishing()) {
                J1();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        sd7 sd7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (sd7Var = this.a) == null) {
            return;
        }
        sd7Var.g();
    }
}
