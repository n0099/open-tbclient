package com.baidu.tieba.write.write.relevance.list;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSearchMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class RelevanceItemListFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f58931e;

    /* renamed from: f  reason: collision with root package name */
    public RelevanceItemListController f58932f;

    /* renamed from: g  reason: collision with root package name */
    public String f58933g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f58934h;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelevanceItemListFragment f58935a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RelevanceItemListFragment relevanceItemListFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relevanceItemListFragment, Integer.valueOf(i2)};
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
            this.f58935a = relevanceItemListFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSearchMessage)) {
                this.f58935a.dealSearchEvent(((EvaluateRelevanceItemSearchMessage) customResponsedMessage).content);
            }
        }
    }

    public RelevanceItemListFragment() {
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
        this.f58934h = new a(this, 2921529);
    }

    public void dealSearchEvent(String str) {
        RelevanceItemListController relevanceItemListController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (relevanceItemListController = this.f58932f) == null) {
            return;
        }
        relevanceItemListController.g(str);
        this.f58932f.i().setVisibility(8);
        showLoadingView(this.f58931e);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            registerListener(this.f58934h);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f58932f = new RelevanceItemListController(this, this.f58931e, this.f58933g, getUniqueId());
            String obj = (((RelevanceItemSearchActivity) getActivity()).getSearchView() == null || ((RelevanceItemSearchActivity) getActivity()).getSearchView().getSearchText() == null) ? "" : ((RelevanceItemSearchActivity) getActivity()).getSearchView().getSearchText().getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                dealSearchEvent(obj);
                return;
            }
            showLoadingView(this.f58931e);
            this.f58932f.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f58931e == null) {
                this.f58931e = layoutInflater.inflate(R.layout.fragment_relevance_item_list, (ViewGroup) null);
            }
            initData();
            g();
            return this.f58931e;
        }
        return (View) invokeLLL.objValue;
    }

    public void onDataRes() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && isLoadingViewAttached()) {
            hideLoadingView(this.f58931e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.f58932f.k();
        }
    }

    public void onError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            hideLoadingView(this.f58931e);
            showNetRefreshView(this.f58931e, str, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hideNetRefreshView(this.f58931e);
            this.f58932f.h();
            showLoadingView(this.f58931e);
        }
    }

    public void onNoData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hideLoadingView(this.f58931e);
            showNoDataNoRefreshView(this.f58931e, false);
        }
    }

    public void setCategory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f58933g = str;
        }
    }
}
