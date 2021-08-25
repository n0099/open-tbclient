package com.bytedance.sdk.openadsdk.activity.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.g;
import com.bytedance.sdk.openadsdk.core.widget.TTScrollView;
/* loaded from: classes9.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public TTScrollView f65383d;

    public TTVideoScrollWebPageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            TTScrollView tTScrollView = (TTScrollView) findViewById(t.e(getApplicationContext(), "tt_scroll_view"));
            this.f65383d = tTScrollView;
            tTScrollView.setListener(new TTScrollView.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTVideoScrollWebPageActivity f65384a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65384a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.TTScrollView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        try {
                            if (this.f65384a.f65388c != null && (this.f65384a.f65388c instanceof g)) {
                                if (z && !this.f65384a.f65388c.x()) {
                                    ((g) this.f65384a.f65388c).f(false);
                                } else {
                                    this.f65384a.f65388c.i();
                                }
                            }
                        } catch (Throwable th) {
                            k.c("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                        }
                    }
                }
            });
            c cVar = this.f65388c;
            if (cVar != null) {
                cVar.d(false);
            }
            NativeVideoTsView nativeVideoTsView = this.f65387b;
            if (nativeVideoTsView != null) {
                nativeVideoTsView.setVideoAdInteractionListener(new c.b(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoScrollWebPageActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTVideoScrollWebPageActivity f65385a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f65385a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                    public void a(long j2, long j3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                    public void e_() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f65385a.f65383d == null || this.f65385a.f65383d.a()) {
                            return;
                        }
                        k.b("TTVideoScrollWebPageActivity", "video start play but video is hidden so pause");
                        c cVar2 = this.f65385a.f65388c;
                        if (cVar2 != null) {
                            cVar2.j();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                    public void f_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                    public void g_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
                    public void h_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        }
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.setContentView(t.f(getApplicationContext(), "tt_activity_video_scroll_landingpage"));
        }
    }
}
