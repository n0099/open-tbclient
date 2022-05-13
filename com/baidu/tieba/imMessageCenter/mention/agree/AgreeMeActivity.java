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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
import com.repackage.bp;
import com.repackage.ki;
import com.repackage.ky4;
import com.repackage.mi;
import com.repackage.ro;
import com.repackage.ta7;
import com.repackage.ua7;
import com.repackage.wa7;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bp mItemClickListener;
    public ta7 mMainView;
    public ua7 mModel;
    public ua7.c mModelCallback;
    public int mSkinType;
    public ta7.e mViewCallback;

    /* loaded from: classes3.dex */
    public class a implements ta7.e {
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

        @Override // com.repackage.ta7.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mModel == null) {
                return;
            }
            this.a.mModel.j();
        }

        @Override // com.repackage.ta7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.mModel == null) {
                return;
            }
            this.a.mModel.g();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ua7.c {
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

        @Override // com.repackage.ua7.c
        public void e(ArrayList<ro> arrayList) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || this.a.mMainView == null) {
                return;
            }
            this.a.mMainView.k(this.a.mModel.f, arrayList);
            AgreeMeActivity agreeMeActivity = this.a;
            agreeMeActivity.hideLoadingView(agreeMeActivity.mMainView.d());
            AgreeMeActivity agreeMeActivity2 = this.a;
            agreeMeActivity2.hideNetRefreshView(agreeMeActivity2.mMainView.f());
            if (this.a.mMainView.f != null) {
                this.a.mMainView.f.setVisibility(0);
            }
        }

        @Override // com.repackage.ua7.c
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                ky4.h0().Z(0);
                if (this.a.mMainView == null) {
                    return;
                }
                this.a.mMainView.l(false);
                if (ListUtils.isEmpty(this.a.mMainView.e())) {
                    AgreeMeActivity agreeMeActivity = this.a;
                    agreeMeActivity.hideLoadingView(agreeMeActivity.mMainView.d());
                    AgreeMeActivity agreeMeActivity2 = this.a;
                    agreeMeActivity2.showNetRefreshView(agreeMeActivity2.mMainView.f(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f84), null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f83), true, this.a.getNetRefreshListener());
                    this.a.setNetRefreshViewEmotionMarginTop(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (this.a.mMainView.f != null) {
                        this.a.mMainView.f.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity agreeMeActivity3 = this.a;
                agreeMeActivity3.hideLoadingView(agreeMeActivity3.mMainView.d());
                this.a.showToast(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements bp {
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

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof wa7)) {
                wa7 wa7Var = (wa7) roVar;
                if (wa7Var.getType() == wa7.x) {
                    this.a.jumpPb(wa7Var);
                } else if (wa7Var.getThreadType() != 40) {
                    this.a.jumpToSubPb(wa7Var);
                } else {
                    this.a.jumpToRecommend(wa7Var);
                }
                if (wa7Var.z() != null) {
                    StatisticItem param = new StatisticItem(wa7Var.z()).param("obj_locate", 1);
                    if (wa7Var.getType() == wa7.y) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (wa7Var != null) {
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", wa7Var.C());
                    statisticItem.param("fname", wa7Var.e());
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
        this.mSkinType = 3;
        this.mViewCallback = new a(this);
        this.mModelCallback = new b(this);
        this.mItemClickListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpPb(wa7 wa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, wa7Var) == null) || wa7Var == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(wa7Var.getBaijiahaoData())) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(wa7Var.C(), (String) null, 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(wa7Var.r());
            createNormalCfg.setBjhData(wa7Var.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        } else if (wa7Var.getThreadType() == 40) {
            jumpToRecommend(wa7Var);
        } else {
            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this).createNormalCfg(wa7Var.C(), wa7Var.r(), 1, "mention");
            createNormalCfg2.setStartFrom(12);
            createNormalCfg2.setHighLightPostId(wa7Var.r());
            createNormalCfg2.setBjhData(wa7Var.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToSubPb(wa7 wa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, wa7Var) == null) || wa7Var == null) {
            return;
        }
        String C = wa7Var.C();
        String r = wa7Var.r();
        String userName = wa7Var.y() == null ? "" : wa7Var.y().getUserName();
        if (!TextUtils.isEmpty(wa7Var.s()) && !"0".equals(wa7Var.s())) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(C, wa7Var.s(), "mention", false, userName, false, wa7Var.s(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(13);
            createSubPbActivityConfig.setBjhData(wa7Var.getBaijiahaoData());
            createSubPbActivityConfig.setHighLightPostId(r);
            createSubPbActivityConfig.setKeyOriUgcTopPid(r);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(C, r, "mention", false, userName, false, r, 0);
        createSubPbActivityConfig2.setKeyPageStartFrom(13);
        createSubPbActivityConfig2.setBjhData(wa7Var.getBaijiahaoData());
        createSubPbActivityConfig2.setHighLightPostId(r);
        createSubPbActivityConfig2.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig2));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.m85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    public void jumpToRecommend(wa7 wa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wa7Var) == null) || wa7Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = wa7Var.C();
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this, arrayList, null, VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.mSkinType == i) {
            return;
        }
        this.mSkinType = i;
        ta7 ta7Var = this.mMainView;
        if (ta7Var != null) {
            ta7Var.c(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0084, (ViewGroup) null);
            setContentView(inflate);
            ta7 ta7Var = new ta7(getPageContext(), inflate);
            this.mMainView = ta7Var;
            ta7Var.j(this.mViewCallback);
            this.mMainView.i(this.mItemClickListener);
            this.mModel = new ua7(getPageContext(), this.mModelCallback);
            showLoadingView(this.mMainView.d());
            this.mMainView.l(false);
            this.mModel.d();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AGREE_PAGE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            ta7 ta7Var = this.mMainView;
            if (ta7Var != null) {
                ta7Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        ta7 ta7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || !ki.z() || this.mModel == null || (ta7Var = this.mMainView) == null) {
            return;
        }
        hideNetRefreshView(ta7Var.f());
        showLoadingView(this.mMainView.d(), true);
        this.mModel.d();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        ua7 ua7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ua7Var = this.mModel) == null) {
            return;
        }
        ua7Var.g();
    }
}
