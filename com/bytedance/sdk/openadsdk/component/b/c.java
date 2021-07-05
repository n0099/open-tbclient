package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.r.o;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c extends com.bytedance.sdk.openadsdk.core.f.a implements TTFeedAd, c.b, c.InterfaceC0345c, a.InterfaceC0355a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.multipro.b.a f29222a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29223b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29224c;

    /* renamed from: d  reason: collision with root package name */
    public int f29225d;

    /* renamed from: e  reason: collision with root package name */
    public AdSlot f29226e;

    /* renamed from: f  reason: collision with root package name */
    public int f29227f;
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
        this.f29223b = false;
        this.f29224c = true;
        this.q = false;
        this.f29227f = i2;
        this.f29226e = adSlot;
        this.f29222a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        int d2 = o.d(this.f30079h.ao());
        this.f29225d = d2;
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
            if (this.f30079h != null && this.f30080i != null) {
                if (h()) {
                    try {
                        nativeVideoTsView = new NativeVideoTsView(this.f30080i, this.f30079h, false, false, o.b(this.f29227f), false, false);
                        if (i()) {
                            nativeVideoTsView.setVideoAdClickListener(new NativeVideoTsView.b(this) { // from class: com.bytedance.sdk.openadsdk.component.b.c.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ c f29228a;

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
                                    this.f29228a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                                public void a(View view, int i2) {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || this.f29228a.f30078g == null) {
                                        return;
                                    }
                                    this.f29228a.f30078g.a(view, i2);
                                }
                            });
                        }
                        nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a(this) { // from class: com.bytedance.sdk.openadsdk.component.b.c.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ c f29229a;

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
                                this.f29229a = this;
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                            public void a(boolean z, long j, long j2, long j3, boolean z2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z2)}) == null) {
                                    com.bytedance.sdk.openadsdk.multipro.b.a aVar = this.f29229a.f29222a;
                                    aVar.f31491a = z;
                                    aVar.f31495e = j;
                                    aVar.f31496f = j2;
                                    aVar.f31497g = j3;
                                    aVar.f31494d = z2;
                                }
                            }
                        });
                        nativeVideoTsView.setVideoAdLoadListener(this);
                        nativeVideoTsView.setVideoAdInteractionListener(this);
                        if (5 == this.f29227f) {
                            nativeVideoTsView.setIsAutoPlay(this.f29223b ? this.f29226e.isAutoPlay() : this.f29224c);
                        } else {
                            nativeVideoTsView.setIsAutoPlay(this.f29224c);
                        }
                        nativeVideoTsView.setIsQuiet(com.bytedance.sdk.openadsdk.core.o.h().b(this.f29225d));
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
                    this.n = x.a(this.f30079h);
                }
                if (this.n != null && this.n.length >= 2) {
                    return this.n[1];
                }
                return 720;
            } catch (Throwable th) {
                j.c("TTFeedAdImpl", "getAdViewHeight error", th);
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
                    this.n = x.a(this.f30079h);
                }
                if (this.n != null && this.n.length >= 2) {
                    return this.n[0];
                }
                return 1280;
            } catch (Throwable th) {
                j.c("TTFeedAdImpl", "getAdViewWidth error", th);
                return 1280;
            }
        }
        return invokeV.intValue;
    }

    public TTFeedAd.CustomizeVideo getCustomVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (m.a(this.f30079h)) {
                if (this.p == null) {
                    this.p = new TTFeedAd.CustomizeVideo(this) { // from class: com.bytedance.sdk.openadsdk.component.b.c.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f29230a;

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
                            this.f29230a = this;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public String getVideoUrl() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                                if (this.f29230a.f30079h == null || this.f29230a.f30079h.a() != 1 || this.f29230a.f30079h.V() == null) {
                                    return null;
                                }
                                if (!this.f29230a.q) {
                                    this.f29230a.q = true;
                                }
                                return this.f29230a.f30079h.V().i();
                            }
                            return (String) invokeV2.objValue;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoAutoStart() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                d.a(this.f29230a.f30080i, this.f29230a.f30079h, o.a(this.f29230a.f30079h), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoBreak(long j) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                                d.a(this.f29230a.f30080i, this.f29230a.f30079h, o.a(this.f29230a.f30079h), "feed_break", j, com.bytedance.sdk.openadsdk.core.video.d.a.a(j, ((long) this.f29230a.getVideoDuration()) * 1000), (Map<String, Object>) null);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoContinue(long j) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(1048579, this, j) == null) {
                                d.a(this.f29230a.f30080i, this.f29230a.f30079h, o.a(this.f29230a.f30079h), "feed_continue", j, com.bytedance.sdk.openadsdk.core.video.d.a.a(j, ((long) this.f29230a.getVideoDuration()) * 1000), (Map<String, Object>) null);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoError(long j, int i2, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("creative_id", this.f29230a.f30079h.ak());
                                hashMap.put("error_code", Integer.valueOf(i2));
                                hashMap.put("extra_error_code", Integer.valueOf(i3));
                                x V = this.f29230a.f30079h.V();
                                if (V != null) {
                                    hashMap.put("video_size", Long.valueOf(V.d()));
                                    hashMap.put("video_resolution", V.f());
                                }
                                hashMap.put("duration", Long.valueOf(j));
                                hashMap.put(SapiOptions.KEY_CACHE_PERCENT, Integer.valueOf(com.bytedance.sdk.openadsdk.core.video.d.a.a(j, ((long) this.f29230a.getVideoDuration()) * 1000)));
                                d.d(this.f29230a.f30080i, this.f29230a.f30079h, o.a(this.f29230a.f30079h), "play_error", hashMap);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                                d.a(this.f29230a.f30080i, this.f29230a.f30079h, o.a(this.f29230a.f30079h), "feed_over", ((long) this.f29230a.getVideoDuration()) * 1000, 100, (Map<String, Object>) null);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoPause(long j) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeJ(1048582, this, j) == null) {
                                d.a(this.f29230a.f30080i, this.f29230a.f30079h, o.a(this.f29230a.f30079h), "feed_pause", j, com.bytedance.sdk.openadsdk.core.video.d.a.a(j, ((long) this.f29230a.getVideoDuration()) * 1000), (Map<String, Object>) null);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoStart() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                                d.a(this.f29230a.f30080i, this.f29230a.f30079h, o.a(this.f29230a.f30079h), "feed_play", 0L, 0, (Map<String, Object>) null);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                        public void reportVideoStartError(int i2, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("creative_id", this.f29230a.f30079h.ak());
                                hashMap.put("error_code", Integer.valueOf(i2));
                                hashMap.put("extra_error_code", Integer.valueOf(i3));
                                x V = this.f29230a.f30079h.V();
                                if (V != null) {
                                    hashMap.put("video_size", Long.valueOf(V.d()));
                                    hashMap.put("video_resolution", V.f());
                                }
                                d.d(this.f29230a.f30080i, this.f29230a.f30079h, o.a(this.f29230a.f30079h), "play_start_error", hashMap);
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
            m mVar = this.f30079h;
            if (mVar == null || mVar.V() == null) {
                return 0.0d;
            }
            return this.f30079h.V().e();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            m mVar = this.f30079h;
            return mVar != null && mVar.P() == null && this.f30079h.h() == 1 && m.b(this.f30079h);
        }
        return invokeV.booleanValue;
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29222a : (com.bytedance.sdk.openadsdk.multipro.b.a) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? m.b(this.f30079h) : invokeV.booleanValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            int d2 = com.bytedance.sdk.openadsdk.core.o.h().d(i2);
            if (3 == d2) {
                this.f29223b = false;
                this.f29224c = false;
            } else if (1 == d2 && com.bytedance.sdk.component.utils.m.d(this.f30080i)) {
                this.f29223b = false;
                this.f29224c = true;
            } else if (2 == d2) {
                if (com.bytedance.sdk.component.utils.m.e(this.f30080i) || com.bytedance.sdk.component.utils.m.d(this.f30080i) || com.bytedance.sdk.component.utils.m.f(this.f30080i)) {
                    this.f29223b = false;
                    this.f29224c = true;
                }
            } else if (4 == d2) {
                this.f29223b = true;
            } else if (5 == d2) {
                if (com.bytedance.sdk.component.utils.m.d(this.f30080i) || com.bytedance.sdk.component.utils.m.f(this.f30080i)) {
                    this.f29224c = true;
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

    public void a(long j, long j2) {
        TTFeedAd.VideoAdListener videoAdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (videoAdListener = this.o) == null) {
            return;
        }
        videoAdListener.onProgressUpdate(j, j2);
    }
}
