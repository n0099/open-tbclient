package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.q0.k0.c.b;
import b.a.q0.s.g0.f;
import b.a.r0.m1.b.d;
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
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements f.g, b.a.q0.k0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMeModelController atMeModelController;
    public d atMeViewController;
    public CustomMessageListener mMessageFromNotifyCenterListener;
    public ViewEventCenter viewEventController;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtMessageActivity f51700a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AtMessageActivity atMessageActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMessageActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51700a = atMessageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (this.f51700a.atMeModelController != null) {
                    this.f51700a.atMeModelController.y();
                }
            }
        }
    }

    public AtMessageActivity() {
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
        this.mMessageFromNotifyCenterListener = new a(this, 2016321);
    }

    private boolean toPb(FeedData feedData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, feedData)) == null) {
            if (feedData != null) {
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
            this.atMeViewController.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, b.a.q0.o0.a
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
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.atMeViewController) == null) {
            return;
        }
        BdListView bdListView = dVar.f22157b;
        if (bdListView != null) {
            bdListView.setVisibility(0);
        }
        hideNetRefreshView(this.atMeViewController.f22158c);
    }

    @Override // b.a.q0.k0.c.a
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
            this.atMeModelController.A();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.atMeViewController.h(getPageContext(), i2);
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
            this.atMeViewController = new d(this);
            if (bundle != null) {
                this.atMeModelController.z(bundle);
            } else {
                this.atMeModelController.z(null);
            }
            this.atMeViewController.i();
            getEventCenter().addEventDelegate(this);
            this.atMeModelController.y();
        }
    }

    @Override // b.a.q0.k0.c.a
    public boolean onEventDispatch(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            if (bVar == null) {
                return true;
            }
            if (bVar.b() == 9484) {
                b.a.q0.k0.b.a a2 = bVar.a();
                if (a2 instanceof FeedData) {
                    return toPb((FeedData) a2);
                }
                return false;
            } else if (bVar.b() == 9483) {
                b.a.q0.k0.b.a a3 = bVar.a();
                if (a3 instanceof FeedData) {
                    return toPersonInfo((FeedData) a3);
                }
                return false;
            } else if (bVar.b() == 9489) {
                b.a.q0.k0.b.a a4 = bVar.a();
                if (a4 instanceof FeedData) {
                    this.atMeViewController.f((FeedData) a4);
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.q0.s.g0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.atMeModelController.C();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        AtMeModelController atMeModelController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!l.D() || (atMeModelController = this.atMeModelController) == null) {
                return;
            }
            atMeModelController.C();
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
        BdListView bdListView = this.atMeViewController.f22157b;
        if (bdListView != null) {
            bdListView.setVisibility(8);
        }
        showNetRefreshView(this.atMeViewController.f22158c, getString(R.string.refresh_view_title_text), null, getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
        setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
    }

    public void onViewDataChanged(b.a.q0.k0.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.atMeViewController.k(aVar);
        }
    }

    public void onViewStateChanged(b.a.q0.k0.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.atMeViewController.l(bVar);
        }
    }

    public void showPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.atMeViewController.m();
        }
    }
}
