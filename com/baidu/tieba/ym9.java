package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.um9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class ym9 extends FunNativeAd2Bridger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTNativeAd.AdInteractionListener b;
    public final /* synthetic */ um9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ym9(um9 um9Var, ReporterPidLoader reporterPidLoader, hn9 hn9Var) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {um9Var, reporterPidLoader, hn9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ReporterPidLoader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = um9Var;
        this.b = new um9.b(um9Var, hn9Var);
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public View createExpressView(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            return vm9.a((TTNativeAd) ((hn9) obj).a);
        }
        return (View) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            this.c.g(activity, (hn9) obj, str, customInflater.inflate(), customInflater.getClickViews(), customInflater.getCreativeViews(), this.b, funAdInteractionListener);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            hn9 hn9Var = (hn9) obj;
            um9 um9Var = this.c;
            FunNativeAdListenerHelper funNativeAdListenerHelper = um9Var.f;
            pid = um9Var.mPid;
            funNativeAdListenerHelper.startShow(hn9Var, str, pid, this.b, funAdInteractionListener);
            com.fun.module.csj.g0 g0Var = (com.fun.module.csj.g0) baseNativeAd2.getExpressView();
            if (g0Var == null) {
                if (!FunAdSdk.isLogEnabled()) {
                    LogPrinter.e("The image mode of ad is not support!", new Object[0]);
                    return;
                }
                throw new RuntimeException("The image mode of ad is not support!");
            }
            this.c.f(activity, hn9Var, expressInflater.inflate(), g0Var, this.b);
        }
    }
}
