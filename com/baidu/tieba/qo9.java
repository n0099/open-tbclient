package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes5.dex */
public class qo9 extends FunNativeAd2Bridger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public final /* synthetic */ oo9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qo9(oo9 oo9Var, ReporterPidLoader reporterPidLoader) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oo9Var, reporterPidLoader};
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
        this.c = oo9Var;
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            NativeExpressADData2 nativeExpressADData2 = (NativeExpressADData2) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public View createExpressView(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            return ((NativeExpressADData2) obj).getAdView();
        }
        return (View) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            NativeExpressADData2 nativeExpressADData2 = (NativeExpressADData2) obj;
            this.c.onShowStart(nativeExpressADData2, this.b);
            this.b = true;
            ExpressAdListenerWrapper expressAdListenerWrapper = (ExpressAdListenerWrapper) this.c.e.get(nativeExpressADData2);
            if (expressAdListenerWrapper == null) {
                LogPrinter.e("Can not get correspond listener by gdtNativeExpress2.", new Object[0]);
            } else {
                expressAdListenerWrapper.funListener = funAdInteractionListener;
            }
            expressInflater.inflate();
        }
    }
}
