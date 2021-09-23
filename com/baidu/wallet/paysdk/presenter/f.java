package com.baidu.wallet.paysdk.presenter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseBeanActivity f62971a;

    public f(PayBaseBeanActivity payBaseBeanActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payBaseBeanActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62971a = payBaseBeanActivity;
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bindFastRequest) == null) || this.f62971a == null || bindFastRequest == null) {
            return;
        }
        PayRequestCache.BindCategory category = BindFastRequest.getCategory(bindFastRequest.getmBindFrom());
        if (PayRequestCache.BindCategory.Initiative != category && PayRequestCache.BindCategory.Pwd != category) {
            if (PayRequestCache.BindCategory.Other == category) {
                this.f62971a.setFlagPaySdk();
                return;
            }
            return;
        }
        this.f62971a.setFlagActiveBindCard();
    }
}
