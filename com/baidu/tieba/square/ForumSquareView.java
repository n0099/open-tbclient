package com.baidu.tieba.square;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.fk5;
import com.baidu.tieba.pi;
import com.baidu.tieba.square.adapter.LeftAdapter;
import com.baidu.tieba.square.view.RightLeftListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class ForumSquareView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View createBarLayout;
    public Context mActivity;
    public TextView mCreateBarView;
    public RelativeLayout mLayoutContainer;
    public LoadingView mLoadingView;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public View.OnClickListener mOnNetRefreshClickListener;
    public fk5 mRefreshView;
    public RightLeftListView mRightLeftView;
    public View mRootLayout;
    public RelativeLayout mSearchViewContainer;
    public final TbPageContext mTbPageContext;
    public ForumHeaderView searchView;
    public CustomMessageListener skinChangeListener;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumSquareView forumSquareView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareView, Integer.valueOf(i)};
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
            this.a = forumSquareView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public ForumSquareView(Context context, TbPageContext tbPageContext) {
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
        this.skinChangeListener = new a(this, 2001304);
        this.mActivity = context;
        this.mTbPageContext = tbPageContext;
        this.mRootLayout = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0335, (ViewGroup) null);
        initUI();
        initListener();
    }

    private void initListener() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && (tbPageContext = this.mTbPageContext) != null) {
            tbPageContext.registerListener(this.skinChangeListener);
        }
    }

    private boolean isRefreshViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            fk5 fk5Var = this.mRefreshView;
            if (fk5Var != null) {
                return fk5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Pair<Integer, Integer> getCurrentScrollPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RightLeftListView rightLeftListView = this.mRightLeftView;
            if (rightLeftListView != null) {
                return rightLeftListView.getCurrentScrollPosition();
            }
            return new Pair<>(0, 0);
        }
        return (Pair) invokeV.objValue;
    }

    public View getRootLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRootLayout;
        }
        return (View) invokeV.objValue;
    }

    public String getSelectedClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRightLeftView.getSelectedClassName();
        }
        return (String) invokeV.objValue;
    }

    public void hideLoadMoreView() {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.hideLoadMoreView();
        }
    }

    public void hideLoadingView() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (loadingView = this.mLoadingView) != null) {
            loadingView.dettachView(this.mLayoutContainer);
            this.mLoadingView = null;
        }
    }

    public void hideNetRefreshView() {
        fk5 fk5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (fk5Var = this.mRefreshView) != null) {
            fk5Var.dettachView(this.mLayoutContainer);
            this.mRefreshView = null;
        }
    }

    public void hideNoDataView() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (noDataView = this.mNoDataView) != null) {
            noDataView.setVisibility(8);
        }
    }

    public boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LoadingView loadingView = this.mLoadingView;
            if (loadingView != null) {
                return loadingView.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadMoreAsEnd() {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.loadMoreAsEnd();
        }
    }

    public void loadMoreAsLoading() {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.loadMoreAsLoading();
        }
    }

    public void loadMoreAsNoData() {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.loadMoreAsNoData();
        }
    }

    public void setForumListNoData() {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.setForumListNoData();
        }
    }

    public void showForumListLoadingUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            hideLoadingView();
            hideNetRefreshView();
            hideNoDataView();
            RightLeftListView rightLeftListView = this.mRightLeftView;
            if (rightLeftListView != null) {
                rightLeftListView.showLoadingView(true);
                this.mRightLeftView.setRightListViewVisibility(8);
            }
        }
    }

    public void showLoadingUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            hideNetRefreshView();
            hideNoDataView();
            showLoadingView(true);
        }
    }

    public void showNoDataUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            hideLoadingView();
            hideNoDataView();
            showNetRefreshView(true);
            RightLeftListView rightLeftListView = this.mRightLeftView;
            if (rightLeftListView != null) {
                rightLeftListView.setListViewVisibility(8);
            }
        }
    }

    public void showNormalUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            hideLoadingView();
            hideNetRefreshView();
            hideNoDataView();
            RightLeftListView rightLeftListView = this.mRightLeftView;
            if (rightLeftListView != null) {
                rightLeftListView.hideLoadingView();
                this.mRightLeftView.setListViewVisibility(0);
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.mRootLayout.findViewById(R.id.navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.obfuscated_res_0x7f0f07f2));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            this.createBarLayout = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
            this.mCreateBarView = textView;
            textView.setText(this.mActivity.getString(R.string.obfuscated_res_0x7f0f07f3));
            this.mSearchViewContainer = (RelativeLayout) this.mRootLayout.findViewById(R.id.obfuscated_res_0x7f090c3f);
            ForumHeaderView forumHeaderView = (ForumHeaderView) this.mRootLayout.findViewById(R.id.obfuscated_res_0x7f090c40);
            this.searchView = forumHeaderView;
            forumHeaderView.setFrom(1);
            this.searchView.setSearchHint(TbSingleton.getInstance().getHotSearch());
            this.mRightLeftView = new RightLeftListView(this.mTbPageContext, this.mRootLayout);
            this.mLayoutContainer = (RelativeLayout) this.mRootLayout.findViewById(R.id.layout_container);
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            ForumHeaderView forumHeaderView = this.searchView;
            if (forumHeaderView != null) {
                forumHeaderView.b();
            }
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null && this.mActivity != null) {
                navigationBar.onChangeSkinType(this.mTbPageContext, i);
            }
            RightLeftListView rightLeftListView = this.mRightLeftView;
            if (rightLeftListView != null) {
                rightLeftListView.onChangeSkinType(i);
            }
            LoadingView loadingView = this.mLoadingView;
            if (loadingView != null) {
                loadingView.onChangeSkinType();
            }
            fk5 fk5Var = this.mRefreshView;
            if (fk5Var != null) {
                fk5Var.onChangeSkinType();
            }
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null && this.mActivity != null) {
                noDataView.setSubTitleTextColor(R.color.CAM_X0105);
                this.mNoDataView.f(this.mTbPageContext, i);
            }
            SkinManager.setViewTextColor(this.mCreateBarView, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundColor(this.mRootLayout, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.mSearchViewContainer, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.mNavigationBar, R.color.CAM_X0207, i);
        }
    }

    public void configHideHeadStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mNavigationBar.setVisibility(8);
            this.searchView.setVisibility(8);
            this.mSearchViewContainer.setVisibility(8);
            ((LinearLayout.LayoutParams) this.mLayoutContainer.getLayoutParams()).bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds22);
        }
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.scrollToPositionWithOffset(i, i2);
        }
    }

    public void setForumListData(List<pi> list, int i) {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, list, i) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.setForumListData(list, i);
        }
    }

    public void setClassListData(String str, List<String> list, boolean z) {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048590, this, str, list, z) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.setClassListData(str, list, z);
        }
    }

    public void setForumListData(List<pi> list) {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, list) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.setForumListData(list);
        }
    }

    public void setOnCreateBarClickListener(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && (textView = this.mCreateBarView) != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setOnLeftItemClickListener(LeftAdapter.b bVar) {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.setOnLeftItemClickListener(bVar);
        }
    }

    public void setOnNetRefreshClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.mOnNetRefreshClickListener = onClickListener;
        }
    }

    public void setOnRightScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onScrollListener) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.setOnRightScrollListener(onScrollListener);
        }
    }

    public void setOnRightScrollToBottomListener(BdListView.p pVar) {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, pVar) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.setOnRightScrollToBottomListener(pVar);
        }
    }

    public void setSearchHint(String str) {
        ForumHeaderView forumHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && (forumHeaderView = this.searchView) != null) {
            forumHeaderView.setSearchHint(str);
        }
    }

    public void setSelectedClassName(String str) {
        RightLeftListView rightLeftListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && (rightLeftListView = this.mRightLeftView) != null) {
            rightLeftListView.setSelectedClassName(str);
        }
    }

    public void showCreateBarLayout(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            View view2 = this.createBarLayout;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public boolean showLoadMore(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            if (z) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    loadMoreAsLoading();
                    return true;
                }
                loadMoreAsNoData();
                return true;
            }
            loadMoreAsEnd();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048605, this, z) != null) || isLoadingViewShowing()) {
            return;
        }
        if (this.mLoadingView == null) {
            LoadingView loadingView = new LoadingView(this.mActivity);
            this.mLoadingView = loadingView;
            loadingView.setTopMargin(BdUtilHelper.getDimens(this.mActivity, R.dimen.obfuscated_res_0x7f0703a7));
        }
        this.mLoadingView.onChangeSkinType();
        this.mLoadingView.attachView(this.mLayoutContainer, z);
    }

    public void showNetRefreshView(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048606, this, z) != null) || isRefreshViewShowing()) {
            return;
        }
        if (this.mRefreshView == null) {
            fk5 fk5Var = new fk5(this.mActivity, this.mOnNetRefreshClickListener);
            this.mRefreshView = fk5Var;
            fk5Var.k(BdUtilHelper.getDimens(this.mActivity, R.dimen.obfuscated_res_0x7f0703a7));
        }
        this.mRefreshView.attachView(this.mLayoutContainer, z);
        this.mRefreshView.q();
    }

    public void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.mNoDataView == null) {
                NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                aVar.i(NoDataViewFactory.ImgType.NODATA);
                aVar.j(BdUtilHelper.getDimens(this.mActivity, R.dimen.obfuscated_res_0x7f0703a7));
                NoDataViewFactory.d f = aVar.f();
                NoDataViewFactory.e.a aVar2 = new NoDataViewFactory.e.a();
                aVar2.g(this.mActivity.getString(R.string.refresh_view_title_text));
                NoDataViewFactory.e f2 = aVar2.f();
                NoDataViewFactory.c.a aVar3 = new NoDataViewFactory.c.a();
                aVar3.f(new NoDataViewFactory.b(this.mActivity.getString(R.string.refresh_view_button_text), this.mOnNetRefreshClickListener));
                this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.mLayoutContainer, f, f2, aVar3.e());
            }
            this.mNoDataView.f(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.bringToFront();
        }
    }
}
