package com.baidu.tieba.themeCenter.dressCenter;

import android.os.Bundle;
import c.a.r0.q3.h.c;
import c.a.r0.q3.h.d;
import c.a.r0.q3.h.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class DressupCenterActivity extends BaseActivity<DressupCenterActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DressupCenterModel.b mCallback;
    public DressupCenterModel mModel;
    public c mView;

    /* loaded from: classes7.dex */
    public class a implements DressupCenterModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DressupCenterActivity f57558a;

        public a(DressupCenterActivity dressupCenterActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dressupCenterActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57558a = dressupCenterActivity;
        }

        @Override // com.baidu.tieba.themeCenter.dressCenter.DressupCenterModel.b
        public void a(int i2, String str, List<c.a.r0.q3.h.a> list, e eVar, List<d> list2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, list, eVar, list2}) == null) {
                DressupCenterActivity dressupCenterActivity = this.f57558a;
                dressupCenterActivity.hideLoadingView(dressupCenterActivity.mView.e());
                if (i2 == 0) {
                    this.f57558a.mView.m(list, eVar, list2, this.f57558a.mModel.D());
                    return;
                }
                this.f57558a.showToast(str);
                this.f57558a.mView.l();
            }
        }
    }

    public DressupCenterActivity() {
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
        this.mCallback = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b003" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public c.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.q0.o0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.f13644a = true;
            }
            return pageStayDurationItem;
        }
        return (c.a.q0.o0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            c cVar = this.mView;
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            DressupCenterModel dressupCenterModel = new DressupCenterModel(this);
            this.mModel = dressupCenterModel;
            dressupCenterModel.E(this.mCallback);
            c cVar = new c(this);
            this.mView = cVar;
            showLoadingView(cVar.e());
            this.mModel.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            DressupCenterModel dressupCenterModel = this.mModel;
            if (dressupCenterModel != null) {
                dressupCenterModel.destroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mModel == null || (cVar = this.mView) == null) {
            return;
        }
        hideNetRefreshView(cVar.e());
        showLoadingView(this.mView.e());
        this.mModel.loadData();
    }
}
