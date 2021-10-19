package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b implements c.p.a.a.a.c.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f67943a;

    /* loaded from: classes9.dex */
    public static class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c.p.a.a.a.f.d f67944a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.downloadnew.a.b.a f67945b;

        /* renamed from: c  reason: collision with root package name */
        public m f67946c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c.p.a.a.a.f.d dVar) {
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
            this.f67944a = dVar;
            if (dVar == null || dVar.d() == null) {
                return;
            }
            String optString = this.f67944a.d().optString("ad_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.downloadnew.a.b.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(new JSONObject(optString).optJSONObject("open_ad_sdk_download_extra"));
                this.f67945b = a2;
                a2.b(this.f67944a.b());
                if (this.f67945b != null) {
                    this.f67946c = this.f67945b.f67971a;
                }
            } catch (Exception unused) {
            }
        }

        public static a a(c.p.a.a.a.f.d dVar) {
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
                    if (this.f67944a == null) {
                        return;
                    }
                    String a2 = this.f67944a.a();
                    k.f("LibEventLogger", "tag " + a2);
                    k.f("LibEventLogger", "label " + this.f67944a.b());
                    if (this.f67945b != null && !TextUtils.isEmpty(this.f67945b.f67972b)) {
                        a2 = this.f67945b.f67972b;
                    }
                    if (!com.bytedance.sdk.openadsdk.downloadnew.a.g.a(a2, this.f67944a.b(), this.f67946c, new HashMap()) && this.f67945b != null && this.f67946c != null && !TextUtils.isEmpty(this.f67944a.a()) && !TextUtils.isEmpty(this.f67944a.b())) {
                        JSONObject e2 = b.e(this.f67944a);
                        String str = this.f67945b.f67972b;
                        if (!a(this.f67944a.a()) || PrefetchEvent.STATE_CLICK.equals(this.f67944a.b())) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.e.d.b(c(), this.f67946c, str, this.f67944a.b(), e2);
                    }
                } catch (Throwable th) {
                    k.a("LibEventLogger", "upload event log error", th);
                }
            }
        }

        private boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? !TextUtils.isEmpty(str) && ("embeded_ad".equals(this.f67944a.a()) || "draw_ad".equals(this.f67944a.a()) || "draw_ad_landingpage".equals(this.f67944a.a()) || "banner_ad".equals(this.f67944a.a()) || "banner_call".equals(this.f67944a.a()) || "banner_ad_landingpage".equals(this.f67944a.a()) || "feed_call".equals(this.f67944a.a()) || "embeded_ad_landingpage".equals(this.f67944a.a()) || ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE.equals(this.f67944a.a()) || "interaction_call".equals(this.f67944a.a()) || "interaction_landingpage".equals(this.f67944a.a()) || "slide_banner_ad".equals(this.f67944a.a()) || "splash_ad".equals(this.f67944a.a()) || "fullscreen_interstitial_ad".equals(this.f67944a.a()) || "splash_ad_landingpage".equals(this.f67944a.a()) || "rewarded_video".equals(this.f67944a.a()) || "rewarded_video_landingpage".equals(this.f67944a.a()) || "openad_sdk_download_complete_tag".equals(this.f67944a.a()) || "download_notification".equals(this.f67944a.a()) || "landing_h5_download_ad_button".equals(this.f67944a.a()) || "fullscreen_interstitial_ad_landingpage".equals(this.f67944a.a()) || "feed_video_middle_page".equals(this.f67944a.a()) || "stream".equals(this.f67944a.a())) : invokeL.booleanValue;
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
        this.f67943a = new WeakReference<>(context);
    }

    private void d(c.p.a.a.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, dVar) == null) || dVar == null) {
            return;
        }
        com.bytedance.sdk.component.d.e.a(a.a(dVar), 5);
    }

    public static JSONObject e(c.p.a.a.a.f.d dVar) {
        InterceptResult invokeL;
        JSONObject d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dVar)) == null) {
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

    private boolean f(c.p.a.a.a.f.d dVar) {
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

    @Override // c.p.a.a.a.c.f
    public void a(@NonNull c.p.a.a.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            a(dVar, true);
        }
    }

    @Override // c.p.a.a.a.c.f
    public void b(@NonNull c.p.a.a.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            a(dVar, false);
            d(dVar);
        }
    }

    private void a(c.p.a.a.a.f.d dVar, boolean z) {
        TTDownloadEventLogger q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65537, this, dVar, z) == null) || (q = h.d().q()) == null || dVar == null) {
            return;
        }
        if (q.shouldFilterOpenSdkLog() && f(dVar)) {
            return;
        }
        if (z) {
            q.onV3Event(dVar);
        } else {
            q.onEvent(dVar);
        }
    }
}
