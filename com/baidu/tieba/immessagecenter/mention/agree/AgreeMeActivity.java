package com.baidu.tieba.immessagecenter.mention.agree;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
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
import com.baidu.tieba.au8;
import com.baidu.tieba.b79;
import com.baidu.tieba.ga5;
import com.baidu.tieba.k69;
import com.baidu.tieba.l69;
import com.baidu.tieba.n69;
import com.baidu.tieba.pi;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
/* loaded from: classes6.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l69 a;
    public k69 b;
    public int c;
    public boolean d;
    public CustomToast e;
    @Nullable
    public b79 f;
    public k69.e g;
    public l69.c h;
    public zi i;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements k69.e {
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

        @Override // com.baidu.tieba.k69.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.k();
            }
        }

        @Override // com.baidu.tieba.k69.e
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.a != null) {
                this.a.a.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements l69.c {
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

        @Override // com.baidu.tieba.l69.c
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ga5.p0().f0(0);
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
                    if (this.a.e != null) {
                        this.a.e.showToast(R.string.obfuscated_res_0x7f0f0a73);
                        return;
                    }
                    return;
                }
                AgreeMeActivity agreeMeActivity3 = this.a;
                agreeMeActivity3.hideLoadingView(agreeMeActivity3.b.d());
                this.a.showToast(str);
            }
        }

        @Override // com.baidu.tieba.l69.c
        public void q(ArrayList<pi> arrayList) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) && this.a.b != null) {
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
    }

    /* loaded from: classes6.dex */
    public class c implements zi {
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

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(piVar instanceof n69)) {
                return;
            }
            n69 n69Var = (n69) piVar;
            if (!TextUtils.isEmpty(n69Var.getTargetScheme())) {
                UrlManager.getInstance().dealOneLink(n69Var.getTargetScheme());
            } else if (n69Var.c() == 6) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getBaseContext(), Long.toString(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName())));
            } else if (n69Var.c() != 2 && n69Var.c() != 4) {
                if (n69Var.c() == 5) {
                    this.a.T0(n69Var);
                } else {
                    this.a.R0(n69Var);
                }
            } else {
                this.a.S0(n69Var);
            }
            if (n69Var.t() != null) {
                StatisticItem param = new StatisticItem(n69Var.t()).param("obj_locate", 1);
                if (n69Var.getType() == n69.E) {
                    param.param("obj_type", 2);
                } else {
                    param.param("obj_type", 1);
                }
                TiebaStatic.log(param);
            }
            if (n69Var != null) {
                StatisticItem statisticItem = new StatisticItem("c13784");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", n69Var.x());
                statisticItem.param("fname", n69Var.d());
                statisticItem.param("obj_type", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Function1<Intent, Boolean> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Boolean invoke(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
                boolean z = false;
                if (intent.getIntExtra(AgreeMeActivityConfig.KEY_AGREE_NUMBER, 0) > 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.finish();
            b79 b79Var = this.f;
            if (b79Var != null) {
                b79Var.a(new d(this));
            }
            if (this.d) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setBottomTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        k69 k69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && BdNetTypeUtil.isNetWorkAvailable() && this.a != null && (k69Var = this.b) != null) {
            hideNetRefreshView(k69Var.f());
            showLoadingView(this.b.d(), true);
            this.a.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && this.c != i) {
            this.c = i;
            k69 k69Var = this.b;
            if (k69Var != null) {
                k69Var.c(i);
            }
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            au8.b().g(1, 0);
            ga5.p0().h();
            ga5.p0().f0(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.d) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            Q0();
            k69 k69Var = this.b;
            if (k69Var != null) {
                k69Var.h();
            }
            l69 l69Var = this.a;
            if (l69Var != null) {
                l69Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            CustomToast customToast = this.e;
            if (customToast != null) {
                customToast.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            CustomToast customToast = this.e;
            if (customToast != null) {
                customToast.onResume();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        l69 l69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (l69Var = this.a) != null) {
            l69Var.h();
        }
    }

    public final void R0(n69 n69Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n69Var) != null) || n69Var == null) {
            return;
        }
        String o = n69Var.o();
        PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(n69Var.x(), o, 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setHighLightPostId(n69Var.o());
        createNormalCfg.setJumpToCommentArea(!TextUtils.isEmpty(o));
        createNormalCfg.setBjhData(n69Var.getBaijiahaoData());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void S0(n69 n69Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n69Var) != null) || n69Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = n69Var.x();
        arrayList.add(videoItemData);
        if (n69Var.c() == 4) {
            videoItemData.highLightPostId = n69Var.o();
        }
        new VideoRecommentPlayActivityConfig(this, arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE, !TextUtils.isEmpty(videoItemData.highLightPostId)).start();
    }

    public final void T0(n69 n69Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, n69Var) != null) || n69Var == null) {
            return;
        }
        String x = n69Var.x();
        String o = n69Var.o();
        if (n69Var.s() == null) {
            userName = "";
        } else {
            userName = n69Var.s().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(x, "", "mention", false, userName, false, o, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(n69Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(o);
        createSubPbActivityConfig.setKeyOriUgcTopPid("");
        createSubPbActivityConfig.start();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            boolean z = true;
            z = (BdActivityStack.getInst().isActivityExist("YunPushProxyActivity") && BdActivityStack.getInst().getSize() == 1) ? false : false;
            this.d = z;
            if (z) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            this.e = CustomToast.newInstance();
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d008a, (ViewGroup) null);
            setContentView(inflate);
            k69 k69Var = new k69(getPageContext(), inflate);
            this.b = k69Var;
            k69Var.j(this.g);
            this.b.i(this.i);
            this.a = new l69(getPageContext(), this.h);
            showLoadingView(this.b.d());
            this.b.l(false);
            this.a.e();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AGREE_PAGE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
            this.f = new b79(this, 7);
        }
    }
}
