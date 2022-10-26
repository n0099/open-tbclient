package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CustomInflater;
import com.fun.ad.sdk.ExpressInflater;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeView;
import com.fun.ad.sdk.internal.api.BaseNativeAd2;
import com.fun.ad.sdk.internal.api.FunNativeAd2Bridger;
import com.fun.ad.sdk.internal.api.FunNativeAdListenerHelper;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.PBNative;
/* loaded from: classes5.dex */
public class np9 extends FunNativeAd2Bridger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ qp9 b;
    public final /* synthetic */ mp9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public np9(mp9 mp9Var, ReporterPidLoader reporterPidLoader, qp9 qp9Var) {
        super(reporterPidLoader);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mp9Var, reporterPidLoader, qp9Var};
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
        this.c = mp9Var;
        this.b = qp9Var;
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public View createExpressView(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            return this.c.e((PBNative) obj);
        }
        return (View) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showCustom(Activity activity, CustomInflater customInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{activity, customInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            PBNative pBNative = (PBNative) obj;
            mp9 mp9Var = this.c;
            FunNativeAdListenerHelper funNativeAdListenerHelper = mp9Var.e;
            pid = mp9Var.mPid;
            funNativeAdListenerHelper.startShow(pBNative, str, pid, null, funAdInteractionListener);
            ViewGroup inflate = customInflater.inflate();
            if (inflate instanceof FunNativeView) {
                inflate = ((FunNativeView) inflate).getRoot();
            }
            pBNative.registerViewForInteraction(inflate, (PBMediaView) this.b.getVideoView(), customInflater.getClickViews());
        }
    }

    @Override // com.fun.ad.sdk.internal.api.FunNativeAd2Bridger
    public void showExpress(Activity activity, ExpressInflater expressInflater, String str, Object obj, BaseNativeAd2 baseNativeAd2, FunAdInteractionListener funAdInteractionListener) {
        Ssp.Pid pid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, expressInflater, str, obj, baseNativeAd2, funAdInteractionListener}) == null) {
            mp9 mp9Var = this.c;
            FunNativeAdListenerHelper funNativeAdListenerHelper = mp9Var.e;
            pid = mp9Var.mPid;
            funNativeAdListenerHelper.startShow((PBNative) obj, str, pid, null, funAdInteractionListener);
            expressInflater.inflate();
        }
    }
}
