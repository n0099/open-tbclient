package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class NativeExpressDrawVideoView extends NativeExpressVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressDrawVideoView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, AdSlot adSlot, String str) {
        super(context, mVar, adSlot, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.bytedance.sdk.openadsdk.core.e.m) objArr2[1], (AdSlot) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = getResources().getConfiguration().orientation;
    }

    private void o() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.r == (i2 = getResources().getConfiguration().orientation)) {
            return;
        }
        this.r = i2;
        com.bytedance.sdk.openadsdk.q.s.a(this, new s.a(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressDrawVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressDrawVideoView f67105a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67105a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.q.s.a
            public void a(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    int width = this.f67105a.getWidth();
                    int height = this.f67105a.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = this.f67105a;
                    nativeExpressDrawVideoView.a(nativeExpressDrawVideoView.l, width, height);
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = this.f67105a;
                    View findViewById = nativeExpressDrawVideoView2.l.findViewById(com.bytedance.sdk.component.utils.t.e(nativeExpressDrawVideoView2.f67121g, "tt_root_view"));
                    this.f67105a.a(findViewById, width, height);
                    if (findViewById != null) {
                        findViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView3 = this.f67105a;
                    nativeExpressDrawVideoView3.a(nativeExpressDrawVideoView3.getWebView(), width, height);
                    ExpressVideoView expressVideoView = ((NativeExpressVideoView) this.f67105a).f67106a;
                    if (expressVideoView != null) {
                        expressVideoView.a(width, height);
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            o();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            o();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishTemporaryDetach();
            o();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView
    public ExpressVideoView a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, mVar, str)) == null) ? new ExpressVideoView(context, mVar, str, true) : (ExpressVideoView) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65537, this, view, i2, i3) == null) || view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i2;
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }
}
