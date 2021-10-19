package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.q.q;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean E;
    public boolean F;
    public TTDrawFeedAd.DrawVideoListener G;
    public int H;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66557a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull m mVar, @NonNull String str, int i2) {
        super(context, mVar, str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66557a = true;
        this.E = false;
        this.F = false;
    }

    private boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, view)) != null) {
            return invokeL.booleanValue;
        }
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            k.c("ClickCreativeListener", "NativeVideoTsView....");
            return true;
        } else if (view.getId() != t.e(this.f66559b, "tt_video_ad_cover_center_layout") && view.getId() != t.e(this.f66559b, "tt_video_ad_logo_image") && view.getId() != t.e(this.f66559b, "tt_video_btn_ad_image_tv") && view.getId() != t.e(this.f66559b, "tt_video_ad_name") && view.getId() != t.e(this.f66559b, "tt_video_ad_button")) {
            if (view.getId() != t.e(this.f66559b, "tt_root_view") && view.getId() != t.e(this.f66559b, "tt_video_play")) {
                if (!(view instanceof ViewGroup)) {
                    return false;
                }
                int i2 = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i2 >= viewGroup.getChildCount()) {
                        return false;
                    }
                    if (c(viewGroup.getChildAt(i2))) {
                        return true;
                    }
                    i2++;
                }
            } else {
                k.c("ClickCreativeListener", "tt_root_view....");
                return true;
            }
        } else {
            k.c("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
            return true;
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            m mVar = this.f66560c;
            return mVar != null && mVar.h() == 1 && m.b(this.f66560c);
        }
        return invokeV.booleanValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.d : invokeV.booleanValue;
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.f66560c == null || h() || !m.b(this.f66560c)) {
                return false;
            }
            if (this.H == 0) {
                this.H = q.c(this.f66560c.ao());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("!isViewVisibility()=");
            sb.append(!b());
            sb.append(",isAutoPlay()=");
            sb.append(a());
            sb.append(",!isCoverPageVisibility()=");
            sb.append(!c());
            k.b("ClickCreativeListener", sb.toString());
            if (this.H == 5 && g() && a() && !b() && !c()) {
                return false;
            }
            int i2 = this.H;
            return i2 == 1 || i2 == 2 || i2 == 5;
        }
        return invokeV.booleanValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.F) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.m;
            if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
            }
        }
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawVideoListener) == null) {
            this.G = drawVideoListener;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.E = z;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) ? !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page") : invokeL.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f66557a = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.b.b, com.bytedance.sdk.openadsdk.core.b.c
    public void a(View view, int i2, int i3, int i4, int i5) {
        b.InterfaceC1908b interfaceC1908b;
        TTDrawFeedAd.DrawVideoListener drawVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || a(2)) {
            return;
        }
        if (i() && c(view) && !this.F) {
            k.b("ClickCreativeListener", "拦截原生视频view走普通点击事件.....");
            super.a(view, i2, i3, i4, i5);
            return;
        }
        j();
        k.b("ClickCreativeListener", "走创意区域点击事件.....");
        if (this.f66559b == null) {
            this.f66559b = o.a();
        }
        if (this.f66559b == null) {
            return;
        }
        long j2 = this.x;
        long j3 = this.y;
        WeakReference<View> weakReference = this.f66563f;
        View view2 = weakReference == null ? null : weakReference.get();
        WeakReference<View> weakReference2 = this.f66564g;
        this.f66565h = a(i2, i3, i4, i5, j2, j3, view2, weakReference2 == null ? null : weakReference2.get(), f());
        int X = this.f66560c.X();
        if (X == 2 || X == 3) {
            if (this.f66567j != null || this.E) {
                com.bytedance.sdk.openadsdk.e.d.a(this.f66559b, "click_button", this.f66560c, this.f66565h, this.f66561d, true, this.n);
            }
            z.a(true);
            Context context = this.f66559b;
            m mVar = this.f66560c;
            int i6 = this.f66562e;
            boolean a2 = z.a(context, mVar, i6, this.f66567j, this.o, this.p, q.a(i6), this.m, true, this.n, this.r, b(this.f66561d));
            if (this.f66557a) {
                com.bytedance.sdk.openadsdk.e.d.a(this.f66559b, PrefetchEvent.STATE_CLICK, this.f66560c, this.f66565h, this.f66561d, a2, this.n);
            }
        } else if (X != 4) {
            if (X != 5) {
                X = -1;
            } else {
                String c2 = c(this.f66561d);
                if (!TextUtils.isEmpty(c2)) {
                    com.bytedance.sdk.openadsdk.e.d.a(this.f66559b, "click_call", this.f66560c, this.f66565h, c2, true, this.n);
                }
                com.bytedance.sdk.openadsdk.e.d.a(this.f66559b, PrefetchEvent.STATE_CLICK, this.f66560c, this.f66565h, this.f66561d, q.d(view.getContext(), this.f66560c.ae()), this.n);
            }
        } else if ((this.f66567j != null || this.o != null || this.p != null) && !"feed_video_middle_page".equals(this.f66561d) && com.bytedance.sdk.openadsdk.core.e.o.a(this.f66560c)) {
            Context context2 = this.f66559b;
            m mVar2 = this.f66560c;
            int i7 = this.f66562e;
            TTNativeAd tTNativeAd = this.f66567j;
            TTNativeExpressAd tTNativeExpressAd = this.o;
            TTSplashAd tTSplashAd = this.p;
            String str = this.f66561d;
            boolean a3 = z.a(context2, mVar2, i7, tTNativeAd, tTNativeExpressAd, tTSplashAd, str, this.m, true, this.n, this.r, b(str));
            if (this.f66557a) {
                com.bytedance.sdk.openadsdk.e.d.a(this.f66559b, PrefetchEvent.STATE_CLICK, this.f66560c, this.f66565h, this.f66561d, a3, this.n);
            }
        } else {
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.m;
            if (aVar != null) {
                aVar.g();
                if (this.f66557a) {
                    com.bytedance.sdk.openadsdk.e.d.a(this.f66559b, PrefetchEvent.STATE_CLICK, this.f66560c, this.f66565h, this.f66561d, true, this.n);
                }
            }
        }
        b.a aVar2 = this.f66566i;
        if (aVar2 != null) {
            aVar2.a(view, X);
        }
        if (q.b(this.f66560c) && (drawVideoListener = this.G) != null) {
            drawVideoListener.onClick();
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar3 = this.m;
        if (!(aVar3 instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) || (interfaceC1908b = this.s) == null) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar3).a(interfaceC1908b);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String c(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            switch (str.hashCode()) {
                case -1695837674:
                    if (str.equals("banner_ad")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -712491894:
                    if (str.equals("embeded_ad")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 174971131:
                    if (str.equals("splash_ad")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1844104722:
                    if (str.equals(ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1912999166:
                    if (str.equals("draw_ad")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2091589896:
                    if (str.equals("slide_banner_ad")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            return (c2 == 0 || c2 == 1) ? "feed_call" : (c2 == 2 || c2 == 3) ? "banner_call" : c2 != 4 ? c2 != 5 ? "" : "splash_ad" : "interaction_call";
        }
        return (String) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.F = z;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m mVar = this.f66560c;
            if (mVar == null) {
                return true;
            }
            int d2 = o.h().d(q.d(mVar.ao()));
            if (d2 != 1) {
                if (d2 == 2) {
                    return n.e(this.f66559b) || n.d(this.f66559b) || n.f(this.f66559b);
                } else if (d2 != 3) {
                    return d2 != 5 || n.d(this.f66559b) || n.f(this.f66559b);
                } else {
                    return false;
                }
            }
            return n.d(this.f66559b);
        }
        return invokeV.booleanValue;
    }
}
