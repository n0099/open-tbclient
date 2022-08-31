package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jh9;
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
/* loaded from: classes5.dex */
public class nh9 extends FunNativeAd2Bridger<wh9, com.fun.module.csj.g0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTNativeAd.AdInteractionListener b;
    public final /* synthetic */ jh9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nh9(jh9 jh9Var, ReporterPidLoader reporterPidLoader, wh9 wh9Var) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jh9Var, reporterPidLoader, wh9Var};
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
        this.c = jh9Var;
        this.b = new jh9.b(jh9Var, wh9Var);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.module.csj.g0, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.csj.g0 createExpressView(wh9 wh9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wh9Var)) == null) ? kh9.a((TTNativeAd) wh9Var.a) : (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, wh9 wh9Var, BaseNativeAd2<wh9, com.fun.module.csj.g0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, wh9Var, baseNativeAd2, funAdInteractionListener}) == null) {
            this.c.g(activity, wh9Var, str, customInflater.inflate(), customInflater.getClickViews(), customInflater.getCreativeViews(), this.b, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, wh9 wh9Var, BaseNativeAd2<wh9, com.fun.module.csj.g0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, wh9Var, baseNativeAd2, funAdInteractionListener}) == null) {
            wh9 wh9Var2 = wh9Var;
            jh9 jh9Var = this.c;
            FunNativeAdListenerHelper<wh9, TTNativeAd.AdInteractionListener> funNativeAdListenerHelper = jh9Var.f;
            pid = jh9Var.mPid;
            funNativeAdListenerHelper.startShow(wh9Var2, str, pid, this.b, funAdInteractionListener);
            com.fun.module.csj.g0 expressView = baseNativeAd2.getExpressView();
            if (expressView != null) {
                this.c.f(activity, wh9Var2, expressInflater.inflate(), expressView, this.b);
            } else if (FunAdSdk.isLogEnabled()) {
                throw new RuntimeException("The image mode of ad is not support!");
            } else {
                LogPrinter.e("The image mode of ad is not support!", new Object[0]);
            }
        }
    }
}
