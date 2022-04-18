package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aa7;
import com.repackage.cu4;
import com.repackage.i65;
import com.repackage.oi;
import com.repackage.r65;
import com.repackage.s65;
import com.repackage.v65;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements cu4.g, r65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMeModelController atMeModelController;
    public aa7 atMeViewController;
    public CustomMessageListener mMessageFromNotifyCenterListener;
    public ViewEventCenter viewEventController;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AtMessageActivity atMessageActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMessageActivity, Integer.valueOf(i)};
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
            this.a = atMessageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (this.a.atMeModelController != null) {
                    this.a.atMeModelController.A();
                }
            }
        }
    }

    public AtMessageActivity() {
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
        this.mMessageFromNotifyCenterListener = new a(this, 2016321);
    }

    private boolean toPb(FeedData feedData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, feedData)) == null) {
            if (feedData != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AT_PAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", feedData.getIsFirstPost()));
                if (ThreadCardUtils.isUgcThreadType(feedData.getBaijiahaoData())) {
                    TiebaStatic.log("new_at_me_visit_pb");
                    PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), (String) null, 1, "mention");
                    createNormalCfg.setStartFrom(13);
                    if (feedData.getFromForumId() > 0) {
                        createNormalCfg.setForumId(String.valueOf(feedData.getFromForumId()));
                    }
                    createNormalCfg.setBjhData(feedData.getBaijiahaoData());
                    createNormalCfg.setHighLightPostId(feedData.getPost_id());
                    return MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                } else if (feedData.getIsFloor()) {
                    TiebaStatic.log("new_at_me_visit_post");
                    String thread_id = feedData.getThread_id();
                    String post_id = feedData.getPost_id();
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, feedData.getReplyer() == null ? "" : feedData.getReplyer().getUserName(), false, post_id, 0);
                    if (feedData.getFromForumId() > 0) {
                        createSubPbActivityConfig.setKeyFromForumId(String.valueOf(feedData.getFromForumId()));
                    }
                    createSubPbActivityConfig.setKeyPageStartFrom(13);
                    createSubPbActivityConfig.setHighLightPostId(post_id);
                    return MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                } else {
                    TiebaStatic.log("new_at_me_visit_pb");
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention");
                    createNormalCfg2.setStartFrom(13);
                    if (feedData.getFromForumId() > 0) {
                        createNormalCfg2.setForumId(String.valueOf(feedData.getFromForumId()));
                    }
                    createNormalCfg2.setHighLightPostId(feedData.getPost_id());
                    return MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean toPersonInfo(FeedData feedData) {
        InterceptResult invokeL;
        List<LikeData> praiseList;
        LikeData likeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, feedData)) == null) {
            if (feedData != null) {
                String userId = feedData.getReplyer().getUserId();
                String userName = feedData.getReplyer().getUserName();
                if (TextUtils.isEmpty(userId) && (praiseList = feedData.getPraiseList()) != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                    userId = likeData.getId();
                    userName = likeData.getName();
                }
                if (userId != null && userId.length() > 0) {
                    return MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getActivity(), userId, userName)));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void dismissPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.atMeViewController.i();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    public ViewEventCenter getEventCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.viewEventController == null) {
                this.viewEventController = new ViewEventCenter();
            }
            return this.viewEventController;
        }
        return (ViewEventCenter) invokeV.objValue;
    }

    public void hideNetRefreshView() {
        aa7 aa7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aa7Var = this.atMeViewController) == null) {
            return;
        }
        BdListView bdListView = aa7Var.b;
        if (bdListView != null) {
            bdListView.setVisibility(0);
        }
        hideNetRefreshView(this.atMeViewController.c);
    }

    @Override // com.repackage.r65
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadMoreData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.atMeModelController.C();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            this.atMeViewController.j(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.atMeModelController = new AtMeModelController(this);
            registerListener(this.mMessageFromNotifyCenterListener);
            this.atMeModelController.setUniqueId(getUniqueId());
            this.atMeViewController = new aa7(this);
            if (bundle != null) {
                this.atMeModelController.B(bundle);
            } else {
                this.atMeModelController.B(null);
            }
            this.atMeViewController.k();
            getEventCenter().addEventDelegate(this);
            this.atMeModelController.A();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AT_PAGE_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.repackage.r65
    public boolean onEventDispatch(s65 s65Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s65Var)) == null) {
            if (s65Var == null) {
                return true;
            }
            if (s65Var.b() == 9484) {
                i65 a2 = s65Var.a();
                if (a2 instanceof FeedData) {
                    FeedData feedData = (FeedData) a2;
                    if (feedData.getThread_Type() == 40) {
                        if (feedData.getIsFloor()) {
                            toPb(feedData);
                            return false;
                        }
                        toVideoRecommend(feedData, Boolean.TRUE);
                        return false;
                    }
                    return toPb(feedData);
                }
                return false;
            } else if (s65Var.b() == 9483) {
                i65 a3 = s65Var.a();
                if (a3 instanceof FeedData) {
                    return toPersonInfo((FeedData) a3);
                }
                return false;
            } else if (s65Var.b() == 9489) {
                i65 a4 = s65Var.a();
                if (a4 instanceof FeedData) {
                    this.atMeViewController.h((FeedData) a4);
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.cu4.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.atMeModelController.E();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        AtMeModelController atMeModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!oi.C() || (atMeModelController = this.atMeModelController) == null) {
                return;
            }
            atMeModelController.E();
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, errorData) == null) || errorData == null || errorData.error_code == 0) {
            return;
        }
        if (!StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
        BdListView bdListView = this.atMeViewController.b;
        if (bdListView != null) {
            bdListView.setVisibility(8);
        }
        showNetRefreshView(this.atMeViewController.c, getString(R.string.obfuscated_res_0x7f0f0f69), null, getString(R.string.obfuscated_res_0x7f0f0f68), true, getNetRefreshListener());
        setNetRefreshViewEmotionMarginTop(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds530));
    }

    public void onViewDataChanged(i65 i65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, i65Var) == null) {
            this.atMeViewController.m(i65Var);
        }
    }

    public void onViewStateChanged(v65 v65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, v65Var) == null) {
            this.atMeViewController.n(v65Var);
        }
    }

    public void showPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.atMeViewController.o();
        }
    }

    public boolean toVideoRecommend(FeedData feedData, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, feedData, bool)) == null) {
            if (feedData == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.thread_id = feedData.getThread_id();
            if (bool.booleanValue()) {
                videoItemData.highLightPostId = feedData.getPost_id();
            }
            arrayList.add(videoItemData);
            VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this, arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_AT_PAGE, bool.booleanValue());
            videoRecommentPlayActivityConfig.setParamIsVertail(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
            return false;
        }
        return invokeLL.booleanValue;
    }
}
