package com.bytedance.sdk.openadsdk.component.reward;

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
/* loaded from: classes5.dex */
public class g extends com.bytedance.sdk.openadsdk.core.video.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, ViewGroup viewGroup, m mVar) {
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
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f30594b == null) {
            return;
        }
        String str = this.f30600h ? "play_error" : "play_start_error";
        Map<String, Object> a2 = o.a(this.f30594b, i2, i3, u());
        a2.put("play_type", Integer.valueOf(o.a(this, this.f30599g)));
        if (this.f30600h) {
            a2.put("duration", Long.valueOf(p()));
            a2.put(SapiOptions.KEY_CACHE_PERCENT, Integer.valueOf(r()));
            a2.put("buffers_time", Long.valueOf(o()));
        }
        com.bytedance.sdk.openadsdk.e.d.d(this.f30593a.get(), this.f30594b, "rewarded_video", str, a2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Map<String, Object> C = C();
            C.put("play_type", Integer.valueOf(o.a(this, this.f30599g)));
            com.bytedance.sdk.openadsdk.e.d.a(this.f30593a.get(), this.f30594b, "rewarded_video", "feed_over", this.f30595c, 100, C);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Map<String, Object> C = C();
            C.put("play_type", Integer.valueOf(o.a(this, this.f30599g)));
            com.bytedance.sdk.openadsdk.e.d.a(this.f30593a.get(), this.f30594b, "rewarded_video", "play_pause", p(), r(), C);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Map<String, Object> C = C();
            C.put("play_type", Integer.valueOf(o.a(this, this.f30599g)));
            com.bytedance.sdk.openadsdk.e.d.a(this.f30593a.get(), this.f30594b, "rewarded_video", "continue_play", this.f30601i, r(), C);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Map<String, Object> B = B();
            B.put("play_type", Integer.valueOf(o.a(this, this.f30599g)));
            com.bytedance.sdk.openadsdk.e.d.c(this.f30593a.get(), this.f30594b, "rewarded_video", "feed_play", B);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Map<String, Object> B = B();
            B.put("play_type", Integer.valueOf(o.a(this, this.f30599g)));
            com.bytedance.sdk.openadsdk.e.d.c(this.f30593a.get(), this.f30594b, "rewarded_video", "play_start", B);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Map<String, Object> B = B();
            B.put("play_type", Integer.valueOf(o.a(this, this.f30599g)));
            com.bytedance.sdk.openadsdk.e.d.c(this.f30593a.get(), this.f30594b, "rewarded_video", "feed_play", B);
        }
    }
}
