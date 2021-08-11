package com.bytedance.sdk.openadsdk.dislike;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompatJellybean;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.dislike.a.b;
import com.bytedance.sdk.openadsdk.dislike.a.c;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f67142a;

    /* renamed from: b  reason: collision with root package name */
    public static c f67143b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            if (f67143b == null) {
                f67143b = new c() { // from class: com.bytedance.sdk.openadsdk.dislike.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.dislike.a.c
                    public int a(Context context, float f2) {
                        InterceptResult invokeLF;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLF = interceptable2.invokeLF(1048576, this, context, f2)) == null) ? s.d(context, f2) : invokeLF.intValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.dislike.a.c
                    public void a(Context context, com.bytedance.sdk.openadsdk.dislike.c.b bVar, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar, z) == null) || bVar == null || bVar.a() == null || bVar.a().getName() == null || bVar.a().getUrl() == null) {
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(context, TTDislikeWebViewActivity.class));
                        intent.putExtra("url", bVar.a().getUrl());
                        intent.putExtra("title", bVar.a().getName());
                        intent.putExtra("log_extra", bVar.e());
                        intent.putExtra(LegoListActivityConfig.AD_ID, bVar.d());
                        intent.putExtra("tag", bVar.i());
                        intent.putExtra(NotificationCompatJellybean.KEY_LABEL, z ? "ad_explation_personality_url_show" : "ad_explation_url_show");
                        com.bytedance.sdk.component.utils.b.a(context, intent, null);
                    }
                };
            }
            if (f67142a == null) {
                f67142a = new b() { // from class: com.bytedance.sdk.openadsdk.dislike.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.dislike.a.b
                    public void a(com.bytedance.sdk.openadsdk.dislike.c.b bVar, FilterWord filterWord) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, filterWord) == null) {
                            d.a(bVar, filterWord);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.dislike.a.b
                    public void a(Context context, com.bytedance.sdk.openadsdk.dislike.c.b bVar, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, context, bVar, str) == null) {
                            d.a(context, bVar.d(), bVar.e(), bVar.i(), str);
                        }
                    }
                };
            }
            com.bytedance.sdk.openadsdk.dislike.a.a.a(f67142a, f67143b);
        }
    }
}
