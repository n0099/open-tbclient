package com.baidu.tieba.square.view;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.pi;
import com.baidu.tieba.psa;
import com.baidu.tieba.square.adapter.LeftAdapter;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class RightLeftListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LeftAdapter mLeftAdapter;
    public LinearLayoutManager mLeftLayoutManager;
    public PbListView mLoadMoreView;
    public LoadingView mLoadingView;
    public BdListView.p mOnRightScrollToBottomListener;
    public BdListView.p mOnScrollToBottomListener;
    public TbPageContext<?> mPageContext;
    public psa mRightAdapterManager;
    public RelativeLayout mRightContainer;
    public LinearLayoutManager mRightLayoutManager;
    public final View mRoot;
    public RecyclerView mRvLeft;
    public BdTypeRecyclerView mRvRight;

    /* loaded from: classes8.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RightLeftListView a;

        public a(RightLeftListView rightLeftListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rightLeftListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rightLeftListView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.mRvRight != null) {
                    this.a.mRvRight.stopScroll();
                }
                if (this.a.mOnRightScrollToBottomListener != null) {
                    this.a.mOnRightScrollToBottomListener.onScrollToBottom();
                }
            }
        }
    }

    public RightLeftListView(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnScrollToBottomListener = new a(this);
        this.mPageContext = tbPageContext;
        this.mRoot = view2;
        initView();
        initAdapter();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048587, this, i, i2) != null) || (bdTypeRecyclerView = this.mRvRight) == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i > this.mRvRight.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.mRvRight.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public String getItemByPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.mLeftAdapter.n(i);
        }
        return (String) invokeI.objValue;
    }

    public void setForumListData(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            setForumListData(list, 0);
        }
    }

    public void setListViewVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mRvLeft.setVisibility(i);
            this.mRvRight.setVisibility(i);
        }
    }

    public void setOnLeftItemClickListener(LeftAdapter.b bVar) {
        LeftAdapter leftAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) && (leftAdapter = this.mLeftAdapter) != null) {
            leftAdapter.t(bVar);
        }
    }

    public void setOnRightScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) && (bdTypeRecyclerView = this.mRvRight) != null) {
            bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
            this.mRvRight.addOnScrollListener(onScrollListener);
        }
    }

    public void setOnRightScrollToBottomListener(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pVar) == null) {
            this.mOnRightScrollToBottomListener = pVar;
        }
    }

    public void setRightListViewVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mRvRight.setVisibility(i);
        }
    }

    public void setSelectedClassName(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, str) != null) || str == null) {
            return;
        }
        int o = this.mLeftAdapter.o(str);
        this.mLeftAdapter.u(o);
        smoothMoveToPosition(o);
    }

    private void initAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mPageContext.getPageActivity());
            this.mLeftLayoutManager = linearLayoutManager;
            this.mRvLeft.setLayoutManager(linearLayoutManager);
            LeftAdapter leftAdapter = new LeftAdapter(this.mPageContext.getPageActivity());
            this.mLeftAdapter = leftAdapter;
            this.mRvLeft.setAdapter(leftAdapter);
            this.mRightAdapterManager = new psa(this.mPageContext, this.mRvRight);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.mPageContext.getPageActivity());
            this.mRightLayoutManager = linearLayoutManager2;
            this.mRvRight.setLayoutManager(linearLayoutManager2);
            this.mRvRight.setFadingEdgeLength(0);
            this.mRvRight.setOverScrollMode(2);
            this.mRvRight.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
            PbListView pbListView = new PbListView(this.mPageContext.getPageActivity());
            this.mLoadMoreView = pbListView;
            pbListView.c();
            this.mLoadMoreView.s(R.color.CAM_X0205);
            this.mLoadMoreView.w(BdUtilHelper.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
            this.mLoadMoreView.B();
            this.mLoadMoreView.L(R.dimen.tbfontsize33);
            this.mLoadMoreView.J(SkinManager.getColor(R.color.CAM_X0107));
            this.mLoadMoreView.F(R.color.CAM_X0110);
            this.mLoadMoreView.v();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mRightContainer = (RelativeLayout) this.mRoot.findViewById(R.id.right_container);
            this.mRvLeft = (RecyclerView) this.mRoot.findViewById(R.id.obfuscated_res_0x7f0920a2);
            this.mRvRight = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.obfuscated_res_0x7f0920a4);
        }
    }

    public Pair<Integer, Integer> getCurrentScrollPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int firstVisiblePosition = this.mRvRight.getFirstVisiblePosition();
            int i = 0;
            View childAt = this.mRvRight.getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(i));
        }
        return (Pair) invokeV.objValue;
    }

    public void loadMoreAsNoData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mRvRight.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.m();
            this.mLoadMoreView.c().setPadding(0, 0, 0, 0);
            this.mLoadMoreView.H(this.mPageContext.getPageActivity().getString(R.string.pb_load_more));
            this.mLoadMoreView.g();
        }
    }

    private boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            LoadingView loadingView = this.mLoadingView;
            if (loadingView != null) {
                return loadingView.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public RelativeLayout getRightContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRightContainer;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public RecyclerView getRvLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRvLeft;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public String getSelectedClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mLeftAdapter.p();
        }
        return (String) invokeV.objValue;
    }

    public void hideLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mRvRight.setNextPage(null);
        }
    }

    public void hideLoadingView() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (loadingView = this.mLoadingView) != null) {
            loadingView.dettachView(this.mRightContainer);
            this.mLoadingView = null;
        }
    }

    public void loadMoreAsLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mRvRight.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.m();
            this.mLoadMoreView.c().setPadding(0, 0, 0, 0);
            this.mLoadMoreView.R();
        }
    }

    public void setForumListNoData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList arrayList = new ArrayList();
            yi yiVar = new yi();
            yiVar.a = this.mPageContext.getString(R.string.obfuscated_res_0x7f0f07f7);
            yiVar.b = R.drawable.new_pic_emotion_06;
            arrayList.add(yiVar);
            this.mRightAdapterManager.c(arrayList);
        }
    }

    private void smoothMoveToPosition(int i) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65542, this, i) == null) && (recyclerView = this.mRvLeft) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mRvLeft.getLayoutManager();
            if (i < 0) {
                i = 0;
            } else if (i > this.mLeftAdapter.getItemCount() - 1) {
                i = this.mLeftAdapter.getItemCount() - 1;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            psa psaVar = this.mRightAdapterManager;
            if (psaVar != null) {
                psaVar.b();
            }
            LeftAdapter leftAdapter = this.mLeftAdapter;
            if (leftAdapter != null) {
                leftAdapter.notifyDataSetChanged();
            }
            PbListView pbListView = this.mLoadMoreView;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
                this.mLoadMoreView.e(i);
            }
            LoadingView loadingView = this.mLoadingView;
            if (loadingView != null) {
                loadingView.onChangeSkinType();
            }
        }
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048598, this, z) != null) || isLoadingViewShowing()) {
            return;
        }
        if (this.mLoadingView == null) {
            LoadingView loadingView = new LoadingView(this.mPageContext.getPageActivity());
            this.mLoadingView = loadingView;
            loadingView.setTopMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703ad));
        }
        this.mLoadingView.onChangeSkinType();
        this.mLoadingView.attachView(this.mRightContainer, z);
    }

    public void loadMoreAsEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mRvRight.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.m();
            this.mLoadMoreView.c().setPadding(0, BdUtilHelper.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, BdUtilHelper.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds362));
            this.mLoadMoreView.H(this.mPageContext.getPageActivity().getString(R.string.obfuscated_res_0x7f0f07f6));
            this.mLoadMoreView.g();
        }
    }

    public void setClassListData(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, list, z) == null) {
            int position = ListUtils.getPosition(list, str);
            this.mLeftAdapter.s(position, list);
            if (z) {
                smoothMoveToPosition(position);
            }
        }
    }

    public void setForumListData(List<pi> list, int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                setForumListNoData();
                return;
            }
            if (i > 0) {
                Pair<Integer, Integer> currentScrollPosition = getCurrentScrollPosition();
                int intValue = ((Integer) currentScrollPosition.first).intValue();
                int intValue2 = ((Integer) currentScrollPosition.second).intValue();
                int i2 = intValue - i;
                if (this.mRightLayoutManager != null && (bdTypeRecyclerView = this.mRvRight) != null) {
                    bdTypeRecyclerView.startInterceptLayout();
                    this.mRightLayoutManager.scrollToPositionWithOffset(i2, intValue2);
                    this.mRvRight.stopIntercerceptLayout();
                }
            }
            this.mRightAdapterManager.c(list);
        }
    }
}
