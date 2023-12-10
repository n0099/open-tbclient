package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tieba.f3b;
import com.baidu.tieba.h3b;
import com.baidu.tieba.i3b;
import com.baidu.tieba.j3b;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h3b a;
    public DressupCenterModel b;
    public DressupCenterModel.b c;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b003" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements DressupCenterModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DressupCenterActivity a;

        public a(DressupCenterActivity dressupCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dressupCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dressupCenterActivity;
        }

        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.b
        public void a(int i, String str, List<f3b> list, j3b j3bVar, List<i3b> list2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, list, j3bVar, list2}) == null) {
                DressupCenterActivity dressupCenterActivity = this.a;
                dressupCenterActivity.hideLoadingView(dressupCenterActivity.a.e());
                if (i != 0) {
                    this.a.showToast(str);
                    this.a.a.n();
                    return;
                }
                this.a.a.o(list, j3bVar, list2, this.a.b.V());
            }
        }
    }

    public DressupCenterActivity() {
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
        this.c = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.isRouteStat = true;
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            DressupCenterModel dressupCenterModel = this.b;
            if (dressupCenterModel != null) {
                dressupCenterModel.destroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        h3b h3bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b != null && (h3bVar = this.a) != null) {
            hideNetRefreshView(h3bVar.e());
            showLoadingView(this.a.e());
            this.b.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            h3b h3bVar = this.a;
            if (h3bVar != null) {
                h3bVar.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            h3b h3bVar = this.a;
            if (h3bVar != null) {
                h3bVar.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            h3b h3bVar = this.a;
            if (h3bVar != null) {
                h3bVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            DressupCenterModel dressupCenterModel = new DressupCenterModel(this);
            this.b = dressupCenterModel;
            dressupCenterModel.W(this.c);
            h3b h3bVar = new h3b(this);
            this.a = h3bVar;
            showLoadingView(h3bVar.e());
            this.b.loadData();
        }
    }
}
