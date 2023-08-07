package com.baidu.tieba.square;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.s7a;
import com.baidu.tieba.square.model.ForumSquareModel;
import com.baidu.tieba.t7a;
import com.baidu.tieba.y7a;
import com.baidu.tieba.ym;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class ForumSquareDelegate implements t7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public String mCurrentClassName;
    public ForumSquareModel mForumSquareModel;
    public ForumSquareView mForumSquareView;
    public s7a mSquareViewController;
    public final TbPageContext mTbPageContext;
    public CustomMessageListener refreshForumSquareListener;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareDelegate a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumSquareDelegate forumSquareDelegate, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareDelegate, Integer.valueOf(i)};
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
            this.a = forumSquareDelegate;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ForumSquareDelegate forumSquareDelegate = this.a;
                if (forumSquareDelegate.mForumSquareView == null || forumSquareDelegate.mForumSquareModel == null) {
                    return;
                }
                this.a.mCurrentClassName = "";
                this.a.mForumSquareModel.clearData();
                this.a.startLoadData();
            }
        }
    }

    public ForumSquareDelegate(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentClassName = "";
        this.refreshForumSquareListener = new a(this, 2921589);
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.mForumSquareModel = new ForumSquareModel(context, this);
        this.mForumSquareView = new ForumSquareView(context, this.mTbPageContext);
        this.mTbPageContext.registerListener(this.refreshForumSquareListener);
    }

    @Override // com.baidu.tieba.t7a
    public void onError(String str, ErrorData errorData) {
        ForumSquareView forumSquareView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, errorData) == null) && (forumSquareView = this.mForumSquareView) != null && this.mForumSquareModel != null) {
            forumSquareView.showNormalUI();
            y7a Z = this.mForumSquareModel.Z(str);
            if (Z != null && (!Z.d || !ListUtils.isEmpty(Z.a()))) {
                this.mForumSquareView.setForumListData(Z.a());
                checkLoadMoreStateUI(str, Z.a());
                return;
            }
            this.mForumSquareView.hideLoadMoreView();
            this.mForumSquareView.setForumListNoData();
        }
    }

    @Override // com.baidu.tieba.t7a
    public void onNoData(ErrorData errorData) {
        ForumSquareView forumSquareView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, errorData) == null) && (forumSquareView = this.mForumSquareView) != null) {
            forumSquareView.showNoDataUI();
        }
    }

    public void selectForumCategory(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.mForumSquareView.setSelectedClassName(str);
            onSelected(str);
        }
    }

    private void checkLoadMoreStateUI(String str, List<ym> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, this, str, list) == null) && this.mForumSquareView != null && this.mForumSquareModel != null) {
            if (ListUtils.isEmpty(list)) {
                this.mForumSquareView.hideLoadMoreView();
            } else if (ListUtils.getCount(list) < 10) {
                this.mForumSquareView.loadMoreAsEnd();
            } else {
                this.mForumSquareView.showLoadMore(this.mForumSquareModel.a0(str));
            }
        }
    }

    private void startLoadNetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mForumSquareView.showLoadingUI();
            this.mForumSquareModel.c0(this.mCurrentClassName);
        }
    }

    public void configHideHeadStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mForumSquareView.configHideHeadStyle();
        }
    }

    public String getClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCurrentClassName;
        }
        return (String) invokeV.objValue;
    }

    public void onLoadRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ForumSquareView forumSquareView = this.mForumSquareView;
            if (forumSquareView != null) {
                forumSquareView.showLoadingUI();
            }
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel != null) {
                forumSquareModel.c0(getClassName());
            }
        }
    }

    public void startLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            s7a s7aVar = new s7a(this.mContext, this, this.mForumSquareView);
            this.mSquareViewController = s7aVar;
            s7aVar.e();
            startLoadNetData();
        }
    }

    public void onLoadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String className = getClassName();
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel != null && this.mForumSquareView != null) {
                boolean b0 = forumSquareModel.b0();
                boolean showLoadMore = this.mForumSquareView.showLoadMore(this.mForumSquareModel.a0(className));
                if (!b0 && showLoadMore) {
                    this.mForumSquareModel.c0(className);
                }
            }
        }
    }

    public void onSelected(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            saveScrollPosition(this.mCurrentClassName);
            this.mCurrentClassName = str;
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel != null && this.mForumSquareView != null) {
                y7a Z = forumSquareModel.Z(str);
                if (Z != null && (!Z.d || !ListUtils.isEmpty(Z.a()))) {
                    this.mForumSquareView.showNormalUI();
                    checkLoadMoreStateUI(str, Z.a());
                    this.mForumSquareView.setForumListData(Z.a());
                    this.mForumSquareView.scrollToPositionWithOffset(Z.f, Z.g);
                    return;
                }
                this.mForumSquareView.showForumListLoadingUI();
                checkLoadMoreStateUI(str, null);
                this.mForumSquareModel.c0(str);
                this.mForumSquareView.scrollToPositionWithOffset(0, 0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    @Override // com.baidu.tieba.t7a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSucc(String str, List<String> list, List<ym> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, list, list2) == null) && this.mForumSquareModel != null && this.mForumSquareView != null) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || str.equals(this.mCurrentClassName)) {
                String selectedClassName = this.mForumSquareView.getSelectedClassName();
                if (!TextUtils.isEmpty(str)) {
                }
                this.mCurrentClassName = str;
                this.mForumSquareView.showNormalUI();
                this.mForumSquareView.setClassListData(str, list, z);
                this.mForumSquareView.setForumListData(list2, this.mForumSquareModel.f0(list2, 300));
                checkLoadMoreStateUI(str, list2);
            }
            z = true;
            this.mCurrentClassName = str;
            this.mForumSquareView.showNormalUI();
            this.mForumSquareView.setClassListData(str, list, z);
            this.mForumSquareView.setForumListData(list2, this.mForumSquareModel.f0(list2, 300));
            checkLoadMoreStateUI(str, list2);
        }
    }

    public void parserIntent(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) && intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.mCurrentClassName = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.mCurrentClassName = uri.getQueryParameter("tab_name");
            }
            boolean z = false;
            int intExtra = intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0);
            ForumSquareView forumSquareView = this.mForumSquareView;
            if (intExtra == 0) {
                z = true;
            }
            forumSquareView.showCreateBarLayout(z);
        }
    }

    public void saveScrollPosition(String str) {
        y7a Z;
        Pair<Integer, Integer> currentScrollPosition;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || this.mForumSquareView == null || this.mForumSquareModel == null || TextUtils.isEmpty(str) || (Z = this.mForumSquareModel.Z(str)) == null || (currentScrollPosition = this.mForumSquareView.getCurrentScrollPosition()) == null) {
            return;
        }
        Z.f = ((Integer) currentScrollPosition.first).intValue();
        Z.g = ((Integer) currentScrollPosition.second).intValue();
    }
}
