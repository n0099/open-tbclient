package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.q.q;
/* loaded from: classes5.dex */
public class b extends c implements TTDrawFeedAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean n;
    public Bitmap o;
    public int p;
    public TTDrawFeedAd.DrawVideoListener q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context, @NonNull m mVar, int i2, AdSlot adSlot) {
        super(context, mVar, i2, adSlot);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, Integer.valueOf(i2), adSlot};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m) objArr2[1], ((Integer) objArr2[2]).intValue(), (AdSlot) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int i2 = this.p;
            if (i2 >= 200) {
                this.p = 200;
            } else if (i2 <= 20) {
                this.p = 20;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0347c
    public /* bridge */ /* synthetic */ void a(int i2, int i3) {
        super.a(i2, i3);
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.multipro.b.a.InterfaceC0357a
    public /* bridge */ /* synthetic */ com.bytedance.sdk.openadsdk.multipro.b.a e() {
        return super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void e_() {
        super.e_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void f_() {
        super.f_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.multipro.b.a.InterfaceC0357a
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void g_() {
        super.g_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.f.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        InterceptResult invokeV;
        NativeDrawVideoTsView nativeDrawVideoTsView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f30289h != null && this.f30290i != null) {
                if (h()) {
                    try {
                        nativeDrawVideoTsView = new NativeDrawVideoTsView(this.f30290i, this.f30289h);
                        nativeDrawVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a(this) { // from class: com.bytedance.sdk.openadsdk.component.b.b.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ b f29431a;

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
                                this.f29431a = this;
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                            public void a(boolean z, long j, long j2, long j3, boolean z2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z2)}) == null) {
                                    com.bytedance.sdk.openadsdk.multipro.b.a aVar = ((c) this.f29431a).f29432a;
                                    aVar.f31788a = z;
                                    aVar.f31792e = j;
                                    aVar.f31793f = j2;
                                    aVar.f31794g = j3;
                                    aVar.f31791d = z2;
                                }
                            }
                        });
                        nativeDrawVideoTsView.setVideoAdLoadListener(this);
                        nativeDrawVideoTsView.setVideoAdInteractionListener(this);
                        int d2 = q.d(this.f30289h.ao());
                        nativeDrawVideoTsView.setIsAutoPlay(a(d2));
                        nativeDrawVideoTsView.setIsQuiet(o.h().b(d2));
                        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.n);
                        if (this.o != null) {
                            nativeDrawVideoTsView.a(this.o, this.p);
                        }
                        nativeDrawVideoTsView.setDrawVideoListener(this.q);
                    } catch (Exception unused) {
                    }
                    if (!h() && nativeDrawVideoTsView != null && nativeDrawVideoTsView.a(0L, true, false)) {
                        return nativeDrawVideoTsView;
                    }
                }
                nativeDrawVideoTsView = null;
                if (!h()) {
                }
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ int getAdViewHeight() {
        return super.getAdViewHeight();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ int getAdViewWidth() {
        return super.getAdViewWidth();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ TTFeedAd.CustomizeVideo getCustomVideo() {
        return super.getCustomVideo();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ double getVideoDuration() {
        return super.getVideoDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void h_() {
        super.h_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0347c
    public /* bridge */ /* synthetic */ void i_() {
        super.i_();
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.n = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, drawVideoListener) == null) {
            this.q = drawVideoListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, bitmap, i2) == null) {
            this.o = bitmap;
            this.p = i2;
            i();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        super.setVideoAdListener(videoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void a(long j, long j2) {
        super.a(j, j2);
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int d2 = o.h().d(i2);
            if (3 == d2) {
                return false;
            }
            if (1 != d2 || !n.d(this.f30290i)) {
                if (2 == d2) {
                    if (!n.e(this.f30290i) && !n.d(this.f30290i) && !n.f(this.f30290i)) {
                        return false;
                    }
                } else if (5 != d2) {
                    return false;
                } else {
                    if (!n.d(this.f30290i) && !n.f(this.f30290i)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }
}
