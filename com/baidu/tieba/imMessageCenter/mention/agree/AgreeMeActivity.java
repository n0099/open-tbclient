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
import com.repackage.dp;
import com.repackage.ja7;
import com.repackage.ka7;
import com.repackage.la7;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.uo;
import com.repackage.xx4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dp mItemClickListener;
    public ja7 mMainView;
    public ka7 mModel;
    public ka7.c mModelCallback;
    public int mSkinType;
    public ja7.e mViewCallback;

    /* loaded from: classes3.dex */
    public class a implements ja7.e {
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

        @Override // com.repackage.ja7.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mModel == null) {
                return;
            }
            this.a.mModel.j();
        }

        @Override // com.repackage.ja7.e
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.mModel == null) {
                return;
            }
            this.a.mModel.g();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ka7.c {
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

        @Override // com.repackage.ka7.c
        public void e(ArrayList<uo> arrayList) {
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

        @Override // com.repackage.ka7.c
        public void onFailed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                xx4.g0().Y(0);
                if (this.a.mMainView == null) {
                    return;
                }
                this.a.mMainView.l(false);
                if (ListUtils.isEmpty(this.a.mMainView.e())) {
                    AgreeMeActivity agreeMeActivity = this.a;
                    agreeMeActivity.hideLoadingView(agreeMeActivity.mMainView.d());
                    AgreeMeActivity agreeMeActivity2 = this.a;
                    agreeMeActivity2.showNetRefreshView(agreeMeActivity2.mMainView.f(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f6a), null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f69), true, this.a.getNetRefreshListener());
                    this.a.setNetRefreshViewEmotionMarginTop(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds530));
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
    public class c implements dp {
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

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof la7)) {
                la7 la7Var = (la7) uoVar;
                if (la7Var.getType() == la7.x) {
                    this.a.jumpPb(la7Var);
                } else if (la7Var.getThreadType() != 40) {
                    this.a.jumpToSubPb(la7Var);
                } else {
                    this.a.jumpToRecommend(la7Var);
                }
                if (la7Var.z() != null) {
                    StatisticItem param = new StatisticItem(la7Var.z()).param("obj_locate", 1);
                    if (la7Var.getType() == la7.y) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (la7Var != null) {
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", la7Var.C());
                    statisticItem.param("fname", la7Var.e());
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
    public void jumpPb(la7 la7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, la7Var) == null) || la7Var == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(la7Var.getBaijiahaoData())) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(la7Var.C(), (String) null, 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(la7Var.r());
            createNormalCfg.setBjhData(la7Var.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        } else if (la7Var.getThreadType() == 40) {
            jumpToRecommend(la7Var);
        } else {
            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this).createNormalCfg(la7Var.C(), la7Var.r(), 1, "mention");
            createNormalCfg2.setStartFrom(12);
            createNormalCfg2.setHighLightPostId(la7Var.r());
            createNormalCfg2.setBjhData(la7Var.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToSubPb(la7 la7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, la7Var) == null) || la7Var == null) {
            return;
        }
        String C = la7Var.C();
        String r = la7Var.r();
        String userName = la7Var.y() == null ? "" : la7Var.y().getUserName();
        if (!TextUtils.isEmpty(la7Var.s()) && !"0".equals(la7Var.s())) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(C, la7Var.s(), "mention", false, userName, false, la7Var.s(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(13);
            createSubPbActivityConfig.setBjhData(la7Var.getBaijiahaoData());
            createSubPbActivityConfig.setHighLightPostId(r);
            createSubPbActivityConfig.setKeyOriUgcTopPid(r);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(C, r, "mention", false, userName, false, r, 0);
        createSubPbActivityConfig2.setKeyPageStartFrom(13);
        createSubPbActivityConfig2.setBjhData(la7Var.getBaijiahaoData());
        createSubPbActivityConfig2.setHighLightPostId(r);
        createSubPbActivityConfig2.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig2));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    public void jumpToRecommend(la7 la7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, la7Var) == null) || la7Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = la7Var.C();
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
        ja7 ja7Var = this.mMainView;
        if (ja7Var != null) {
            ja7Var.c(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0088, (ViewGroup) null);
            setContentView(inflate);
            ja7 ja7Var = new ja7(getPageContext(), inflate);
            this.mMainView = ja7Var;
            ja7Var.j(this.mViewCallback);
            this.mMainView.i(this.mItemClickListener);
            this.mModel = new ka7(getPageContext(), this.mModelCallback);
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
            ja7 ja7Var = this.mMainView;
            if (ja7Var != null) {
                ja7Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        ja7 ja7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || !mi.z() || this.mModel == null || (ja7Var = this.mMainView) == null) {
            return;
        }
        hideNetRefreshView(ja7Var.f());
        showLoadingView(this.mMainView.d(), true);
        this.mModel.d();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        ka7 ka7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ka7Var = this.mModel) == null) {
            return;
        }
        ka7Var.g();
    }
}
