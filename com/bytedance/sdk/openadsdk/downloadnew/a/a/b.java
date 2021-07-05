package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements d.l.a.a.a.c.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f30986a;

    /* loaded from: classes6.dex */
    public static class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.l.a.a.a.f.d f30987a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.downloadnew.a.b.a f30988b;

        /* renamed from: c  reason: collision with root package name */
        public m f30989c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d.l.a.a.a.f.d dVar) {
            super("LogTask");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30987a = dVar;
            if (dVar == null || dVar.d() == null) {
                return;
            }
            String optString = this.f30987a.d().optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.downloadnew.a.b.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra"));
                this.f30988b = a2;
                a2.b(this.f30987a.b());
                if (this.f30988b != null) {
                    this.f30989c = this.f30988b.f31014a;
                }
            } catch (Exception unused) {
            }
        }

        public static a a(d.l.a.a.a.f.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) ? new a(dVar) : (a) invokeL.objValue;
        }

        private Context c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? o.a() : (Context) invokeV.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f30987a == null) {
                        return;
                    }
                    String a2 = this.f30987a.a();
                    j.f("LibEventLogger", "tag " + a2);
                    j.f("LibEventLogger", "label " + this.f30987a.b());
                    if (this.f30988b != null && !TextUtils.isEmpty(this.f30988b.f31015b)) {
                        a2 = this.f30988b.f31015b;
                    }
                    if (!com.bytedance.sdk.openadsdk.downloadnew.a.g.a(a2, this.f30987a.b(), this.f30989c, new HashMap()) && this.f30988b != null && this.f30989c != null && !TextUtils.isEmpty(this.f30987a.a()) && !TextUtils.isEmpty(this.f30987a.b())) {
                        JSONObject e2 = b.e(this.f30987a);
                        String str = this.f30988b.f31015b;
                        if (!a(this.f30987a.a()) || PrefetchEvent.STATE_CLICK.equals(this.f30987a.b())) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.e.d.b(c(), this.f30989c, str, this.f30987a.b(), e2);
                    }
                } catch (Throwable th) {
                    j.a("LibEventLogger", "upload event log error", th);
                }
            }
        }

        private boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? !TextUtils.isEmpty(str) && ("embeded_ad".equals(this.f30987a.a()) || "draw_ad".equals(this.f30987a.a()) || "draw_ad_landingpage".equals(this.f30987a.a()) || "banner_ad".equals(this.f30987a.a()) || "banner_call".equals(this.f30987a.a()) || "banner_ad_landingpage".equals(this.f30987a.a()) || "feed_call".equals(this.f30987a.a()) || "embeded_ad_landingpage".equals(this.f30987a.a()) || "interaction".equals(this.f30987a.a()) || "interaction_call".equals(this.f30987a.a()) || "interaction_landingpage".equals(this.f30987a.a()) || "slide_banner_ad".equals(this.f30987a.a()) || "splash_ad".equals(this.f30987a.a()) || "fullscreen_interstitial_ad".equals(this.f30987a.a()) || "splash_ad_landingpage".equals(this.f30987a.a()) || "rewarded_video".equals(this.f30987a.a()) || "rewarded_video_landingpage".equals(this.f30987a.a()) || "openad_sdk_download_complete_tag".equals(this.f30987a.a()) || "download_notification".equals(this.f30987a.a()) || "landing_h5_download_ad_button".equals(this.f30987a.a()) || "fullscreen_interstitial_ad_landingpage".equals(this.f30987a.a()) || "feed_video_middle_page".equals(this.f30987a.a()) || "stream".equals(this.f30987a.a())) : invokeL.booleanValue;
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30986a = new WeakReference<>(context);
    }

    private void d(d.l.a.a.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, dVar) == null) || dVar == null) {
            return;
        }
        com.bytedance.sdk.component.e.e.a(a.a(dVar), 5);
    }

    public static JSONObject e(d.l.a.a.a.f.d dVar) {
        InterceptResult invokeL;
        JSONObject d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, dVar)) == null) {
            if (dVar == null || (d2 = dVar.d()) == null) {
                return null;
            }
            String optString = d2.optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            try {
                return new JSONObject(optString);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private boolean f(d.l.a.a.a.f.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, dVar)) == null) {
            dVar.c();
            if (dVar == null) {
                return false;
            }
            String dVar2 = dVar.toString();
            if (TextUtils.isEmpty(dVar2)) {
                return false;
            }
            return dVar2.contains("open_ad_sdk_download_extra");
        }
        return invokeL.booleanValue;
    }

    @Override // d.l.a.a.a.c.f
    public void a(@NonNull d.l.a.a.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            j.b("LibEventLogger", "onV3Event: " + String.valueOf(dVar));
            a(dVar, true);
        }
    }

    @Override // d.l.a.a.a.c.f
    public void b(@NonNull d.l.a.a.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            j.b("LibEventLogger", "onEvent: " + String.valueOf(dVar));
            a(dVar, false);
            d(dVar);
        }
    }

    private void a(d.l.a.a.a.f.d dVar, boolean z) {
        TTDownloadEventLogger p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65537, this, dVar, z) == null) || (p = h.d().p()) == null || dVar == null) {
            return;
        }
        if (p.shouldFilterOpenSdkLog() && f(dVar)) {
            return;
        }
        if (z) {
            p.onV3Event(dVar);
        } else {
            p.onEvent(dVar);
        }
    }
}
