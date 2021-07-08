package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.p0.j1.b.o.a;
import d.a.p0.j1.b.o.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w mItemClickListener;
    public d.a.p0.j1.b.o.a mMainView;
    public d.a.p0.j1.b.o.b mModel;
    public b.c mModelCallback;
    public int mSkinType;
    public a.e mViewCallback;

    /* loaded from: classes4.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AgreeMeActivity f17933a;

        public a(AgreeMeActivity agreeMeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeMeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17933a = agreeMeActivity;
        }

        @Override // d.a.p0.j1.b.o.a.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17933a.mModel == null) {
                return;
            }
            this.f17933a.mModel.j();
        }

        @Override // d.a.p0.j1.b.o.a.e
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17933a.mModel == null) {
                return;
            }
            this.f17933a.mModel.g();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AgreeMeActivity f17934a;

        public b(AgreeMeActivity agreeMeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeMeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17934a = agreeMeActivity;
        }

        @Override // d.a.p0.j1.b.o.b.c
        public void a(ArrayList<n> arrayList) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || this.f17934a.mMainView == null) {
                return;
            }
            this.f17934a.mMainView.k(this.f17934a.mModel.f59063f, arrayList);
            AgreeMeActivity agreeMeActivity = this.f17934a;
            agreeMeActivity.hideLoadingView(agreeMeActivity.mMainView.d());
            AgreeMeActivity agreeMeActivity2 = this.f17934a;
            agreeMeActivity2.hideNetRefreshView(agreeMeActivity2.mMainView.f());
            if (this.f17934a.mMainView.f59051f != null) {
                this.f17934a.mMainView.f59051f.setVisibility(0);
            }
        }

        @Override // d.a.p0.j1.b.o.b.c
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                d.a.o0.s.d.b.g0().Y(0);
                if (this.f17934a.mMainView == null) {
                    return;
                }
                this.f17934a.mMainView.l(false);
                if (ListUtils.isEmpty(this.f17934a.mMainView.e())) {
                    AgreeMeActivity agreeMeActivity = this.f17934a;
                    agreeMeActivity.hideLoadingView(agreeMeActivity.mMainView.d());
                    AgreeMeActivity agreeMeActivity2 = this.f17934a;
                    agreeMeActivity2.showNetRefreshView(agreeMeActivity2.mMainView.f(), this.f17934a.getResources().getString(R.string.refresh_view_title_text), null, this.f17934a.getResources().getString(R.string.refresh_view_button_text), true, this.f17934a.getNetRefreshListener());
                    this.f17934a.setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (this.f17934a.mMainView.f59051f != null) {
                        this.f17934a.mMainView.f59051f.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity agreeMeActivity3 = this.f17934a;
                agreeMeActivity3.hideLoadingView(agreeMeActivity3.mMainView.d());
                this.f17934a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AgreeMeActivity f17935e;

        public c(AgreeMeActivity agreeMeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agreeMeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17935e = agreeMeActivity;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.p0.j1.b.p.a)) {
                d.a.p0.j1.b.p.a aVar = (d.a.p0.j1.b.p.a) nVar;
                if (aVar.getType() == d.a.p0.j1.b.p.a.x) {
                    this.f17935e.jumpPb(aVar);
                } else {
                    this.f17935e.jumpToSubPb(aVar);
                }
                if (aVar.t() != null) {
                    StatisticItem param = new StatisticItem(aVar.t()).param("obj_locate", 1);
                    if (aVar.getType() == d.a.p0.j1.b.p.a.y) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (aVar != null) {
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", aVar.y());
                    statisticItem.param("fname", aVar.d());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSkinType = 3;
        this.mViewCallback = new a(this);
        this.mModelCallback = new b(this);
        this.mItemClickListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpPb(d.a.p0.j1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(aVar.c())) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(aVar.y(), (String) null, 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(aVar.o());
            createNormalCfg.setBjhData(aVar.c());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            return;
        }
        PbActivityConfig createNormalCfg2 = new PbActivityConfig(this).createNormalCfg(aVar.y(), aVar.o(), 1, "mention");
        createNormalCfg2.setStartFrom(12);
        createNormalCfg2.setHighLightPostId(aVar.o());
        createNormalCfg2.setBjhData(aVar.c());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToSubPb(d.a.p0.j1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, aVar) == null) || aVar == null) {
            return;
        }
        String y = aVar.y();
        String o = aVar.o();
        String userName = aVar.q() == null ? "" : aVar.q().getUserName();
        if (!TextUtils.isEmpty(aVar.p()) && !"0".equals(aVar.p())) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(y, aVar.p(), "mention", false, userName, false, aVar.p(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(13);
            createSubPbActivityConfig.setBjhData(aVar.c());
            createSubPbActivityConfig.setHighLightPostId(o);
            createSubPbActivityConfig.setKeyOriUgcTopPid(o);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(y, o, "mention", false, userName, false, o, 0);
        createSubPbActivityConfig2.setKeyPageStartFrom(13);
        createSubPbActivityConfig2.setBjhData(aVar.c());
        createSubPbActivityConfig2.setHighLightPostId(o);
        createSubPbActivityConfig2.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig2));
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.o0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.mSkinType == i2) {
            return;
        }
        this.mSkinType = i2;
        d.a.p0.j1.b.o.a aVar = this.mMainView;
        if (aVar != null) {
            aVar.c(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = getLayoutInflater().inflate(R.layout.agree_me_activity, (ViewGroup) null);
            setContentView(inflate);
            d.a.p0.j1.b.o.a aVar = new d.a.p0.j1.b.o.a(getPageContext(), inflate);
            this.mMainView = aVar;
            aVar.j(this.mViewCallback);
            this.mMainView.i(this.mItemClickListener);
            this.mModel = new d.a.p0.j1.b.o.b(getPageContext(), this.mModelCallback);
            showLoadingView(this.mMainView.d());
            this.mMainView.l(false);
            this.mModel.d();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            d.a.p0.j1.b.o.a aVar = this.mMainView;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        d.a.p0.j1.b.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || !j.z() || this.mModel == null || (aVar = this.mMainView) == null) {
            return;
        }
        hideNetRefreshView(aVar.f());
        showLoadingView(this.mMainView.d(), true);
        this.mModel.d();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.a.p0.j1.b.o.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bVar = this.mModel) == null) {
            return;
        }
        bVar.g();
    }
}
