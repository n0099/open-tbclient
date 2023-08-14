package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lfb;
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
/* loaded from: classes7.dex */
public class qfb extends FunNativeAd2Bridger<yfb, com.fun.module.csj.f0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTNativeAd.AdInteractionListener b;
    public final /* synthetic */ lfb c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qfb(lfb lfbVar, ReporterPidLoader reporterPidLoader, yfb yfbVar) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lfbVar, reporterPidLoader, yfbVar};
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
        this.c = lfbVar;
        this.b = new lfb.b(lfbVar, yfbVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'android.view.View' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.fun.module.csj.f0, android.view.View] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public com.fun.module.csj.f0 createExpressView(yfb yfbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yfbVar)) == null) {
            return mfb.a((TTNativeAd) yfbVar.a);
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.CustomInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, yfb yfbVar, BaseNativeAd2<yfb, com.fun.module.csj.f0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, yfbVar, baseNativeAd2, funAdInteractionListener}) == null) {
            this.c.k(activity, yfbVar, str, customInflater.inflate(), customInflater.getClickViews(), customInflater.getCreativeViews(), this.b, funAdInteractionListener);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, com.fun.ad.sdk.ExpressInflater, java.lang.String, java.lang.Object, com.fun.ad.sdk.internal.api.BaseNativeAd2, com.fun.ad.sdk.FunAdInteractionListener] */
    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, yfb yfbVar, BaseNativeAd2<yfb, com.fun.module.csj.f0> baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, yfbVar, baseNativeAd2, funAdInteractionListener}) == null) {
            yfb yfbVar2 = yfbVar;
            lfb lfbVar = this.c;
            FunNativeAdListenerHelper<yfb, TTNativeAd.AdInteractionListener> funNativeAdListenerHelper = lfbVar.g;
            pid = lfbVar.mPid;
            funNativeAdListenerHelper.startShow(yfbVar2, str, pid, this.b, funAdInteractionListener);
            com.fun.module.csj.f0 expressView = baseNativeAd2.getExpressView();
            if (expressView == null) {
                if (!FunAdSdk.isLogEnabled()) {
                    LogPrinter.e("The image mode of ad is not support!", new Object[0]);
                    return;
                }
                throw new RuntimeException("The image mode of ad is not support!");
            }
            this.c.j(activity, yfbVar2, expressInflater.inflate(), expressView, this.b);
        }
    }
}
