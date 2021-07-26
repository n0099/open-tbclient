package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FullRewardExpressBackupView extends BackupView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View l;
    public NativeExpressView m;
    public FrameLayout n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullRewardExpressBackupView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30478a = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f30483f = com.bytedance.sdk.openadsdk.q.s.d(this.f30478a, this.m.getExpectExpressWidth());
            this.f30484g = com.bytedance.sdk.openadsdk.q.s.d(this.f30478a, this.m.getExpectExpressWidth());
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.f30483f, this.f30484g);
            }
            layoutParams.width = this.f30483f;
            layoutParams.height = this.f30484g;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            setLayoutParams(layoutParams);
            this.f30479b.k();
            c();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            View inflate = LayoutInflater.from(this.f30478a).inflate(com.bytedance.sdk.component.utils.t.f(this.f30478a, "tt_backup_full_reward"), (ViewGroup) this, true);
            this.l = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(com.bytedance.sdk.component.utils.t.e(this.f30478a, "tt_bu_video_container"));
            this.n = frameLayout;
            frameLayout.removeAllViews();
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar, NativeExpressView nativeExpressView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, nativeExpressView) == null) {
            com.bytedance.sdk.component.utils.k.b("FullRewardExpressBackupView", "show backup view");
            setBackgroundColor(-1);
            this.f30479b = mVar;
            this.m = nativeExpressView;
            if (com.bytedance.sdk.openadsdk.q.q.c(mVar.ao()) == 7) {
                this.f30482e = "rewarded_video";
            } else {
                this.f30482e = "fullscreen_interstitial_ad";
            }
            b();
            this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        }
    }

    public FrameLayout getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (FrameLayout) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || (nativeExpressView = this.m) == null) {
            return;
        }
        nativeExpressView.a(i2, kVar);
    }
}
