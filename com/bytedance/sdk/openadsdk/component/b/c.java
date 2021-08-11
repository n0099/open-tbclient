package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.e.b.o;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.e.p;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class c extends com.bytedance.sdk.openadsdk.core.f.a implements TTFeedAd, c.b, c.InterfaceC1907c, p, a.InterfaceC1917a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.multipro.b.a f65311a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65312b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65313c;

    /* renamed from: d  reason: collision with root package name */
    public int f65314d;

    /* renamed from: e  reason: collision with root package name */
    public AdSlot f65315e;

    /* renamed from: f  reason: collision with root package name */
    public int f65316f;
    public int[] n;
    public TTFeedAd.VideoAdListener o;
    public TTFeedAd.CustomizeVideo p;
    public boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context, @NonNull m mVar, int i2, AdSlot adSlot) {
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
        this.n = null;
        this.f65312b = false;
        this.f65313c = true;
        this.q = false;
        this.f65316f = i2;
        this.f65315e = adSlot;
        this.f65311a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        int d2 = q.d(this.f66202h.ao());
        this.f65314d = d2;
        a(d2);
    }

    public void e_() {
        TTFeedAd.VideoAdListener videoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (videoAdListener = this.o) == null) {
            return;
        }
        videoAdListener.onVideoAdStartPlay(this);
    }

    public void f_() {
        TTFeedAd.VideoAdListener videoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoAdListener = this.o) == null) {
            return;
        }
        videoAdListener.onVideoAdPaused(this);
    }

    public void g_() {
        TTFeedAd.VideoAdListener videoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (videoAdListener = this.o) == null) {
            return;
        }
        videoAdListener.onVideoAdContinuePlay(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        InterceptResult invokeV;
        NativeVideoTsView nativeVideoTsView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f66202h != null && this.f66203i != null) {
                if (h()) {
                    try {
                        nativeVideoTsView = new NativeVideoTsView(this.f66203i, this.f66202h, false, false, q.b(this.f65316f), false, false);
                        if (i()) {
                            nativeVideoTsView.setVideoAdClickListener(new NativeVideoTsView.b(this) { // from class: com.bytedance.sdk.openadsdk.component.b.c.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ c f65317a;

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
                                    this.f65317a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                                public void a(View view, int i2) {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || this.f65317a.f66201g == null) {
                                        return;
                                    }
                                    this.f65317a.f66201g.a(view, i2);
                                }
                            });
                        }
                        nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a(this) { // from class: com.bytedance.sdk.openadsdk.component.b.c.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ c f65318a;

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
                                this.f65318a = this;
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                            public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z2)}) == null) {
                                    com.bytedance.sdk.openadsdk.multipro.b.a aVar = this.f65318a.f65311a;
                                    aVar.f67733a = z;
                                    aVar.f67737e = j2;
                                    aVar.f67738f = j3;
                                    aVar.f67739g = j4;
                                    aVar.f67736d = z2;
                                }
                            }
                        });
                        nativeVideoTsView.setVideoAdLoadListener(this);
                        nativeVideoTsView.setVideoAdInteractionListener(this);
                        if (5 == this.f65316f) {
                            nativeVideoTsView.setIsAutoPlay(this.f65312b ? this.f65315e.isAutoPlay() : this.f65313c);
                        } else {
                            nativeVideoTsView.setIsAutoPlay(this.f65313c);
                        }
                        nativeVideoTsView.setIsQuiet(o.h().b(this.f65314d));
                    } catch (Exception unused) {
                    }
                    if (!h() && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                        return nativeVideoTsView;
                    }
                }
                nativeVideoTsView = null;
                if (!h()) {
                }
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public int getAdViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                if (this.n == null) {
                    this.n = x.a(this.f66202h);
                }
                if (this.n != null && this.n.length >= 2) {
                    return this.n[1];
                }
                return 720;
            } catch (Throwable th) {
                k.c("TTFeedAdImpl", "getAdViewHeight error", th);
                return 720;
            }
        }
        return invokeV.intValue;
    }

    public int getAdViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                if (this.n == null) {
                    this.n = x.a(this.f66202h);
                }
                if (this.n != null && this.n.length >= 2) {
                    return this.n[0];
                }
                return 1280;
            } catch (Throwable th) {
                k.c("TTFeedAdImpl", "getAdViewWidth error", th);
                return 1280;
            }
        }
        return invokeV.intValue;
    }

    public TTFeedAd.CustomizeVideo getCustomVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (m.a(this.f66202h)) {
                if (this.p == null) {
                    this.p = new TTFeedAd.CustomizeVideo(this) { // from class: com.bytedance.sdk.openadsdk.component.b.c.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f65319a;

                        /* renamed from: b  reason: collision with root package name */
                        public long f65320b;

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
                            this.f65319a = this;
                            this.f65320b = 0L;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public String getVideoUrl() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                                if (this.f65319a.f66202h == null || this.f65319a.f66202h.a() != 1 || this.f65319a.f66202h.V() == null) {
                                    return null;
                                }
                                if (!this.f65319a.q) {
                                    this.f65319a.q = true;
                                }
                                return this.f65319a.f66202h.V().i();
                            }
                            return (String) invokeV2.objValue;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoAutoStart() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                d.a(this.f65319a.f66203i, this.f65319a.f66202h, q.a(this.f65319a.f66202h), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                                if (this.f65319a.f66202h == null || this.f65319a.f66202h.V() == null) {
                                    return;
                                }
                                com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                                bVar.a(this.f65319a.f66202h.V().i());
                                bVar.a(this.f65319a.f66202h.V().m());
                                bVar.b(this.f65319a.f66202h.V().l());
                                bVar.c(CacheDirConstants.getFeedCacheDir());
                                bVar.a(this.f65319a.f66202h.m());
                                bVar.a(this.f65319a.f66202h);
                                bVar.b(this.f65319a.f66202h.V().d());
                                bVar.a(this.f65319a.f66202h);
                                bVar.c(true);
                                com.bytedance.sdk.openadsdk.e.a.a.a(this.f65319a.f66203i, this.f65319a.f66202h, this.f65319a, bVar);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoBreak(long j2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
                                if (this.f65320b == 0) {
                                    this.f65320b = SystemClock.elapsedRealtime();
                                }
                                long videoDuration = ((long) this.f65319a.getVideoDuration()) * 1000;
                                long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f65320b) - j2;
                                long j3 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                                o.a aVar = new o.a();
                                aVar.a(j2);
                                aVar.c(videoDuration);
                                aVar.b(j3);
                                aVar.e(0);
                                aVar.f(0);
                                aVar.a(true);
                                com.bytedance.sdk.openadsdk.e.a.a.f(this.f65319a.f66203i, this.f65319a, aVar);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoContinue(long j2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(1048579, this, j2) == null) {
                                if (this.f65320b == 0) {
                                    this.f65320b = SystemClock.elapsedRealtime();
                                }
                                long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f65320b) - j2;
                                long j3 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                                o.a aVar = new o.a();
                                aVar.a(j2);
                                aVar.c(((long) this.f65319a.getVideoDuration()) * 1000);
                                aVar.b(j3);
                                aVar.a(true);
                                com.bytedance.sdk.openadsdk.e.a.a.c(this.f65319a.f66203i, this.f65319a, aVar);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoError(long j2, int i2, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                                if (this.f65320b == 0) {
                                    this.f65320b = SystemClock.elapsedRealtime();
                                }
                                long videoDuration = ((long) this.f65319a.getVideoDuration()) * 1000;
                                long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f65320b) - j2;
                                long j3 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                                o.a aVar = new o.a();
                                aVar.b(j3);
                                aVar.c(videoDuration);
                                aVar.a(j2);
                                aVar.a(i2);
                                aVar.b(i3);
                                aVar.a(true);
                                com.bytedance.sdk.openadsdk.e.a.a.d(this.f65319a.f66203i, this.f65319a, aVar);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                                if (this.f65320b == 0) {
                                    this.f65320b = SystemClock.elapsedRealtime();
                                }
                                long videoDuration = ((long) this.f65319a.getVideoDuration()) * 1000;
                                long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f65320b) - videoDuration;
                                long j2 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                                o.a aVar = new o.a();
                                aVar.a(videoDuration);
                                aVar.c(videoDuration);
                                aVar.b(j2);
                                aVar.f(0);
                                aVar.a(true);
                                com.bytedance.sdk.openadsdk.e.a.a.g(this.f65319a.f66203i, this.f65319a, aVar);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoPause(long j2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(1048582, this, j2) == null) {
                                if (this.f65320b == 0) {
                                    this.f65320b = SystemClock.elapsedRealtime();
                                }
                                long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f65320b) - j2;
                                long j3 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                                o.a aVar = new o.a();
                                aVar.a(j2);
                                aVar.c(((long) this.f65319a.getVideoDuration()) * 1000);
                                aVar.b(j3);
                                aVar.a(true);
                                com.bytedance.sdk.openadsdk.e.a.a.b(this.f65319a.f66203i, this.f65319a, aVar);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoStart() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                                this.f65320b = SystemClock.elapsedRealtime();
                                o.a aVar = new o.a();
                                aVar.b(true);
                                aVar.a(true);
                                com.bytedance.sdk.openadsdk.e.a.a.a(this.f65319a.f66203i, this.f65319a, aVar);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoStartError(int i2, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("creative_id", this.f65319a.f66202h.ak());
                                hashMap.put("error_code", Integer.valueOf(i2));
                                hashMap.put("extra_error_code", Integer.valueOf(i3));
                                x V = this.f65319a.f66202h.V();
                                if (V != null) {
                                    hashMap.put("video_size", Long.valueOf(V.d()));
                                    hashMap.put("video_resolution", V.f());
                                }
                                d.c(this.f65319a.f66203i, this.f65319a.f66202h, q.a(this.f65319a.f66202h), "play_start_error", hashMap);
                            }
                        }
                    };
                }
                return this.p;
            }
            return null;
        }
        return (TTFeedAd.CustomizeVideo) invokeV.objValue;
    }

    public double getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            m mVar = this.f66202h;
            if (mVar == null || mVar.V() == null) {
                return 0.0d;
            }
            return this.f66202h.V().e();
        }
        return invokeV.doubleValue;
    }

    public void h_() {
        TTFeedAd.VideoAdListener videoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (videoAdListener = this.o) == null) {
            return;
        }
        videoAdListener.onVideoAdComplete(this);
    }

    public void i_() {
        TTFeedAd.VideoAdListener videoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (videoAdListener = this.o) == null) {
            return;
        }
        videoAdListener.onVideoLoad(this);
    }

    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, videoAdListener) == null) {
            this.o = videoAdListener;
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            m mVar = this.f66202h;
            return mVar != null && mVar.P() == null && this.f66202h.h() == 1 && m.b(this.f66202h);
        }
        return invokeV.booleanValue;
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65311a : (com.bytedance.sdk.openadsdk.multipro.b.a) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? m.b(this.f66202h) : invokeV.booleanValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            int d2 = com.bytedance.sdk.openadsdk.core.o.h().d(i2);
            if (3 == d2) {
                this.f65312b = false;
                this.f65313c = false;
            } else if (1 == d2 && n.d(this.f66203i)) {
                this.f65312b = false;
                this.f65313c = true;
            } else if (2 == d2) {
                if (n.e(this.f66203i) || n.d(this.f66203i) || n.f(this.f66203i)) {
                    this.f65312b = false;
                    this.f65313c = true;
                }
            } else if (4 == d2) {
                this.f65312b = true;
            } else if (5 == d2) {
                if (n.d(this.f66203i) || n.f(this.f66203i)) {
                    this.f65313c = true;
                }
            }
        }
    }

    public void a(int i2, int i3) {
        TTFeedAd.VideoAdListener videoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || (videoAdListener = this.o) == null) {
            return;
        }
        videoAdListener.onVideoError(i2, i3);
    }

    public void a(long j2, long j3) {
        TTFeedAd.VideoAdListener videoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (videoAdListener = this.o) == null) {
            return;
        }
        videoAdListener.onProgressUpdate(j2, j3);
    }
}
