package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes5.dex */
public class kea implements TTAdDislike.DislikeInteractionCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ View a;
    public final /* synthetic */ bea b;
    public final /* synthetic */ FunAdInteractionListener c;
    public final /* synthetic */ String d;
    public final /* synthetic */ hea e;

    public kea(hea heaVar, View view2, bea beaVar, FunAdInteractionListener funAdInteractionListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {heaVar, view2, beaVar, funAdInteractionListener, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = heaVar;
        this.a = view2;
        this.b = beaVar;
        this.c = funAdInteractionListener;
        this.d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.e("CSJNativeExpressAd dislike callback onCancel", new Object[0]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            LogPrinter.e("CSJNativeExpressAd dislike callback onSelected position: " + i + ", message: " + str, new Object[0]);
            View view2 = this.a;
            if (view2 != null && view2.getParent() != null) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
            this.e.onAdClose(this.b);
            FunAdInteractionListener funAdInteractionListener = this.c;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(this.d);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
