package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
/* loaded from: classes6.dex */
public class m extends o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, AdSlot adSlot) {
        super(context, mVar, adSlot);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.bytedance.sdk.openadsdk.core.e.m) objArr2[1], (AdSlot) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o, com.bytedance.sdk.openadsdk.core.nativeexpress.k
    public void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, mVar, adSlot) == null) {
            this.f30340d = "draw_ad";
            NativeExpressDrawVideoView nativeExpressDrawVideoView = new NativeExpressDrawVideoView(context, mVar, adSlot, "draw_ad");
            this.f30337a = nativeExpressDrawVideoView;
            a(nativeExpressDrawVideoView, this.f30339c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (nativeExpressView = this.f30337a) == null) {
            return;
        }
        ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
    }
}
