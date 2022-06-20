package com.baidu.tieba.square.view;

import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h45;
import com.repackage.je8;
import com.repackage.nn;
import com.repackage.pi;
import com.repackage.wn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class RightLeftListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LeftAdapter mLeftAdapter;
    public LinearLayoutManager mLeftLayoutManager;
    public PbListView mLoadMoreView;
    public h45 mLoadingView;
    public BdListView.p mOnRightScrollToBottomListener;
    public BdListView.p mOnScrollToBottomListener;
    public TbPageContext<?> mPageContext;
    public je8 mRightAdapterManager;
    public RelativeLayout mRightContainer;
    public LinearLayoutManager mRightLayoutManager;
    public final View mRoot;
    public RecyclerView mRvLeft;
    public BdTypeRecyclerView mRvRight;

    /* loaded from: classes4.dex */
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

    private void initAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mPageContext.getPageActivity());
            this.mLeftLayoutManager = linearLayoutManager;
            this.mRvLeft.setLayoutManager(linearLayoutManager);
            LeftAdapter leftAdapter = new LeftAdapter(this.mPageContext.getPageActivity());
            this.mLeftAdapter = leftAdapter;
            this.mRvLeft.setAdapter(leftAdapter);
            this.mRightAdapterManager = new je8(this.mPageContext, this.mRvRight);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.mPageContext.getPageActivity());
            this.mRightLayoutManager = linearLayoutManager2;
            this.mRvRight.setLayoutManager(linearLayoutManager2);
            this.mRvRight.setFadingEdgeLength(0);
            this.mRvRight.setOverScrollMode(2);
            this.mRvRight.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
            PbListView pbListView = new PbListView(this.mPageContext.getPageActivity());
            this.mLoadMoreView = pbListView;
            pbListView.b();
            this.mLoadMoreView.p(R.color.CAM_X0205);
            this.mLoadMoreView.t(pi.f(this.mPageContext.getPageActivity(), R.dimen.tbds182));
            this.mLoadMoreView.x();
            this.mLoadMoreView.G(R.dimen.tbfontsize33);
            this.mLoadMoreView.E(SkinManager.getColor(R.color.CAM_X0107));
            this.mLoadMoreView.A(R.color.CAM_X0110);
            this.mLoadMoreView.s();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mRightContainer = (RelativeLayout) this.mRoot.findViewById(R.id.obfuscated_res_0x7f091a93);
            this.mRvLeft = (RecyclerView) this.mRoot.findViewById(R.id.obfuscated_res_0x7f091aed);
            this.mRvRight = (BdTypeRecyclerView) this.mRoot.findViewById(R.id.obfuscated_res_0x7f091aef);
        }
    }

    private boolean isLoadingViewShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            h45 h45Var = this.mLoadingView;
            if (h45Var != null) {
                return h45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
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

    public Pair<Integer, Integer> getCurrentScrollPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int firstVisiblePosition = this.mRvRight.getFirstVisiblePosition();
            View childAt = this.mRvRight.getChildAt(0);
            return new Pair<>(Integer.valueOf(firstVisiblePosition), Integer.valueOf(childAt != null ? childAt.getTop() : 0));
        }
        return (Pair) invokeV.objValue;
    }

    public String getItemByPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.mLeftAdapter.e(i) : (String) invokeI.objValue;
    }

    public RelativeLayout getRightContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRightContainer : (RelativeLayout) invokeV.objValue;
    }

    public RecyclerView getRvLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRvLeft : (RecyclerView) invokeV.objValue;
    }

    public String getSelectedClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLeftAdapter.g() : (String) invokeV.objValue;
    }

    public void hideLoadMoreView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mRvRight.setNextPage(null);
        }
    }

    public void hideLoadingView() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (h45Var = this.mLoadingView) == null) {
            return;
        }
        h45Var.dettachView(this.mRightContainer);
        this.mLoadingView = null;
    }

    public void loadMoreAsEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mRvRight.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.j();
            this.mLoadMoreView.b().setPadding(0, pi.f(this.mPageContext.getPageActivity(), R.dimen.tbds62), 0, pi.f(this.mPageContext.getPageActivity(), R.dimen.tbds362));
            this.mLoadMoreView.C(this.mPageContext.getPageActivity().getString(R.string.obfuscated_res_0x7f0f06ab));
            this.mLoadMoreView.f();
        }
    }

    public void loadMoreAsLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mRvRight.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.j();
            this.mLoadMoreView.b().setPadding(0, 0, 0, 0);
            this.mLoadMoreView.N();
        }
    }

    public void loadMoreAsNoData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mRvRight.setNextPage(this.mLoadMoreView);
            this.mLoadMoreView.j();
            this.mLoadMoreView.b().setPadding(0, 0, 0, 0);
            this.mLoadMoreView.C(this.mPageContext.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0dcd));
            this.mLoadMoreView.f();
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            je8 je8Var = this.mRightAdapterManager;
            if (je8Var != null) {
                je8Var.b();
            }
            LeftAdapter leftAdapter = this.mLeftAdapter;
            if (leftAdapter != null) {
                leftAdapter.notifyDataSetChanged();
            }
            PbListView pbListView = this.mLoadMoreView;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.mLoadMoreView.d(i);
            }
            h45 h45Var = this.mLoadingView;
            if (h45Var != null) {
                h45Var.onChangeSkinType();
            }
        }
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) || (bdTypeRecyclerView = this.mRvRight) == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || i > this.mRvRight.getCount() - 1) {
            return;
        }
        ((LinearLayoutManager) this.mRvRight.getLayoutManager()).scrollToPositionWithOffset(i, i2);
    }

    public void setClassListData(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048588, this, str, list, z) == null) {
            int position = ListUtils.getPosition(list, str);
            this.mLeftAdapter.j(position, list);
            if (z) {
                smoothMoveToPosition(position);
            }
        }
    }

    public void setForumListData(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            setForumListData(list, 0);
        }
    }

    public void setForumListNoData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList arrayList = new ArrayList();
            wn wnVar = new wn();
            wnVar.a = this.mPageContext.getString(R.string.obfuscated_res_0x7f0f06ac);
            wnVar.b = R.drawable.new_pic_emotion_06;
            arrayList.add(wnVar);
            this.mRightAdapterManager.c(arrayList);
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
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) || (leftAdapter = this.mLeftAdapter) == null) {
            return;
        }
        leftAdapter.k(bVar);
    }

    public void setOnRightScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) || (bdTypeRecyclerView = this.mRvRight) == null) {
            return;
        }
        bdTypeRecyclerView.removeOnScrollListener(onScrollListener);
        this.mRvRight.addOnScrollListener(onScrollListener);
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
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || str == null) {
            return;
        }
        int f = this.mLeftAdapter.f(str);
        this.mLeftAdapter.l(f);
        smoothMoveToPosition(f);
    }

    public void showLoadingView(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || isLoadingViewShowing()) {
            return;
        }
        if (this.mLoadingView == null) {
            h45 h45Var = new h45(this.mPageContext.getPageActivity());
            this.mLoadingView = h45Var;
            h45Var.s(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070291));
        }
        this.mLoadingView.onChangeSkinType();
        this.mLoadingView.attachView(this.mRightContainer, z);
    }

    public void setForumListData(List<nn> list, int i) {
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
                    bdTypeRecyclerView.A();
                    this.mRightLayoutManager.scrollToPositionWithOffset(i2, intValue2);
                    this.mRvRight.B();
                }
            }
            this.mRightAdapterManager.c(list);
        }
    }
}
