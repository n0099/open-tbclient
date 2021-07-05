package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.r.o;
import java.util.Map;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.core.video.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, ViewGroup viewGroup, m mVar) {
        super(context, viewGroup, mVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ViewGroup) objArr2[1], (m) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f30484b == null || i2 == 308) {
            return;
        }
        String str = this.f30490h ? "play_error" : "play_start_error";
        Map<String, Object> a2 = o.a(this.f30484b, i2, i3, u());
        if (this.f30490h) {
            a2.put("duration", Long.valueOf(p()));
            a2.put(SapiOptions.KEY_CACHE_PERCENT, Integer.valueOf(r()));
            a2.put("buffers_time", Long.valueOf(o()));
        }
        com.bytedance.sdk.openadsdk.e.d.d(this.f30483a.get(), this.f30484b, "splash_ad", str, a2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.j) {
            return;
        }
        this.j = true;
        com.bytedance.sdk.openadsdk.e.d.a(this.f30483a.get(), this.f30484b, "splash_ad", "feed_over", this.f30485c, 100, C());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.bytedance.sdk.openadsdk.e.d.c(this.f30483a.get(), this.f30484b, "splash_ad", "feed_play", B());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.bytedance.sdk.openadsdk.e.d.c(this.f30483a.get(), this.f30484b, "splash_ad", "play_start", B());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.bytedance.sdk.openadsdk.e.d.c(this.f30483a.get(), this.f30484b, "splash_ad", "feed_play", B());
        }
    }
}
