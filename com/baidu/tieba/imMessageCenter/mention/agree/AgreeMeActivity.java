package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.la7;
import com.repackage.ma7;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.ny4;
import com.repackage.oa7;
import com.repackage.pi;
import com.repackage.xn;
import com.repackage.z8;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ma7 a;
    public la7 b;
    public int c;
    public boolean d;
    public la7.e e;
    public ma7.c f;
    public xn g;

    /* loaded from: classes3.dex */
    public class a implements la7.e {
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

        @Override // com.repackage.la7.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.j();
        }

        @Override // com.repackage.la7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.g();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ma7.c {
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

        @Override // com.repackage.ma7.c
        public void h(ArrayList<nn> arrayList) {
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

        @Override // com.repackage.ma7.c
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                ny4.f0().X(0);
                if (this.a.b == null) {
                    return;
                }
                this.a.b.l(false);
                if (ListUtils.isEmpty(this.a.b.e())) {
                    AgreeMeActivity agreeMeActivity = this.a;
                    agreeMeActivity.hideLoadingView(agreeMeActivity.b.d());
                    AgreeMeActivity agreeMeActivity2 = this.a;
                    agreeMeActivity2.showNetRefreshView(agreeMeActivity2.b.f(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f9b), null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f9a), true, this.a.getNetRefreshListener());
                    this.a.setNetRefreshViewEmotionMarginTop(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds530));
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

    /* loaded from: classes3.dex */
    public class c implements xn {
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

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof oa7)) {
                oa7 oa7Var = (oa7) nnVar;
                if (oa7Var.getType() == oa7.A) {
                    this.a.F1(oa7Var);
                } else if (oa7Var.getType() == oa7.C) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getBaseContext(), Long.toString(TbadkCoreApplication.getCurrentAccountId()), TbadkCoreApplication.getCurrentAccountName())));
                } else if (oa7Var.getThreadType() != 40) {
                    this.a.H1(oa7Var);
                } else {
                    this.a.G1(oa7Var);
                }
                if (oa7Var.B() != null) {
                    StatisticItem param = new StatisticItem(oa7Var.B()).param("obj_locate", 1);
                    if (oa7Var.getType() == oa7.B) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (oa7Var != null) {
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", oa7Var.E());
                    statisticItem.param("fname", oa7Var.c());
                    statisticItem.param("obj_type", 2);
                    TiebaStatic.log(statisticItem);
                }
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
        this.e = new a(this);
        this.f = new b(this);
        this.g = new c(this);
    }

    public final void F1(oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oa7Var) == null) || oa7Var == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(oa7Var.getBaijiahaoData())) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(oa7Var.E(), (String) null, 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(oa7Var.t());
            createNormalCfg.setBjhData(oa7Var.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        } else if (oa7Var.getThreadType() == 40) {
            G1(oa7Var);
        } else {
            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this).createNormalCfg(oa7Var.E(), oa7Var.t(), 1, "mention");
            createNormalCfg2.setStartFrom(12);
            createNormalCfg2.setHighLightPostId(oa7Var.t());
            createNormalCfg2.setBjhData(oa7Var.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
        }
    }

    public void G1(oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oa7Var) == null) || oa7Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = oa7Var.E();
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this, arrayList, null, VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public final void H1(oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oa7Var) == null) || oa7Var == null) {
            return;
        }
        String E = oa7Var.E();
        String t = oa7Var.t();
        String userName = oa7Var.A() == null ? "" : oa7Var.A().getUserName();
        if (!TextUtils.isEmpty(oa7Var.u()) && !"0".equals(oa7Var.u())) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(E, oa7Var.u(), "mention", false, userName, false, oa7Var.u(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(13);
            createSubPbActivityConfig.setBjhData(oa7Var.getBaijiahaoData());
            createSubPbActivityConfig.setHighLightPostId(t);
            createSubPbActivityConfig.setKeyOriUgcTopPid(t);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(E, t, "mention", false, userName, false, t, 0);
        createSubPbActivityConfig2.setKeyPageStartFrom(13);
        createSubPbActivityConfig2.setBjhData(oa7Var.getBaijiahaoData());
        createSubPbActivityConfig2.setHighLightPostId(t);
        createSubPbActivityConfig2.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig2));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.d) {
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
            if (this.d) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setBottomTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.c == i) {
            return;
        }
        this.c = i;
        la7 la7Var = this.b;
        if (la7Var != null) {
            la7Var.c(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            boolean z = true;
            z = (z8.g().i("YunPushProxyActivity") && z8.g().h() == 1) ? false : false;
            this.d = z;
            if (z) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d007f, (ViewGroup) null);
            setContentView(inflate);
            la7 la7Var = new la7(getPageContext(), inflate);
            this.b = la7Var;
            la7Var.j(this.e);
            this.b.i(this.g);
            this.a = new ma7(getPageContext(), this.f);
            showLoadingView(this.b.d());
            this.b.l(false);
            this.a.d();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AGREE_PAGE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            la7 la7Var = this.b;
            if (la7Var != null) {
                la7Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        la7 la7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || !ni.z() || this.a == null || (la7Var = this.b) == null) {
            return;
        }
        hideNetRefreshView(la7Var.f());
        showLoadingView(this.b.d(), true);
        this.a.d();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        ma7 ma7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ma7Var = this.a) == null) {
            return;
        }
        ma7Var.g();
    }
}
