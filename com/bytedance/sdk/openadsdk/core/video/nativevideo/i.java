package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.d.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.core.widget.i;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.p;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i implements w.a, b, com.bytedance.sdk.openadsdk.core.video.renderview.a, h.a, i.b, p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.bytedance.sdk.openadsdk.core.widget.i A;
    public d B;
    public boolean C;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a D;
    public c E;
    public com.bytedance.sdk.openadsdk.core.b.a F;
    public com.bytedance.sdk.openadsdk.core.b.a G;
    public TTDrawFeedAd.DrawVideoListener H;
    public boolean I;
    public View J;
    public TextView K;
    public TextView L;
    public NativeVideoTsView.b M;
    public final String N;

    /* renamed from: a  reason: collision with root package name */
    public View f67494a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.renderview.b f67495b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f67496c;

    /* renamed from: d  reason: collision with root package name */
    public View f67497d;

    /* renamed from: e  reason: collision with root package name */
    public View f67498e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f67499f;

    /* renamed from: g  reason: collision with root package name */
    public ViewStub f67500g;

    /* renamed from: h  reason: collision with root package name */
    public View f67501h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f67502i;

    /* renamed from: j  reason: collision with root package name */
    public View f67503j;
    public RoundImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public ProgressBar o;
    public ViewStub p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public EnumSet<b.a> x;
    public m y;
    public Context z;

    public i(Context context, View view, boolean z, EnumSet<b.a> enumSet, m mVar, c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, Boolean.valueOf(z), enumSet, mVar, cVar, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = true;
        this.C = true;
        this.I = true;
        this.N = Build.MODEL;
        if (this instanceof h) {
            return;
        }
        this.z = o.a().getApplicationContext();
        c(z2);
        this.f67494a = view;
        this.u = z;
        this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.E = cVar;
        this.y = mVar;
        c(8);
        a(context, this.f67494a);
        a();
        n();
    }

    private boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? "C8817D".equals(this.N) || "M5".equals(this.N) || "R7t".equals(this.N) : invokeV.booleanValue;
    }

    private void b(View view, Context context) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, view, context) == null) || view == null || context == null || (viewStub = this.p) == null || viewStub.getParent() == null || this.J != null) {
            return;
        }
        this.p.inflate();
        this.J = view.findViewById(t.e(context, "tt_video_ad_cover_center_layout_draw"));
        this.K = (TextView) view.findViewById(t.e(context, "tt_video_ad_button_draw"));
        this.L = (TextView) view.findViewById(t.e(context, "tt_video_ad_replay"));
    }

    private int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            if (this.s <= 0 || this.t <= 0) {
                return 0;
            }
            int dimensionPixelSize = this.z.getResources().getDimensionPixelSize(t.h(this.z, "tt_video_container_maxheight"));
            int dimensionPixelSize2 = this.z.getResources().getDimensionPixelSize(t.h(this.z, "tt_video_container_minheight"));
            int i3 = (int) (this.t * ((i2 * 1.0f) / this.s));
            return i3 > dimensionPixelSize ? dimensionPixelSize : i3 < dimensionPixelSize2 ? dimensionPixelSize2 : i3;
        }
        return invokeI.intValue;
    }

    private void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            s.a(this.f67503j, i2);
            s.a(this.J, i2);
        }
    }

    private boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            m mVar = this.y;
            return mVar != null && mVar.P() == null && this.y.h() == 1 && m.b(this.y);
        }
        return invokeV.booleanValue;
    }

    private void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.z == null || this.f67494a == null) {
            return;
        }
        View view = new View(this, this.z) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.i.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ i f67507a;

            /* renamed from: b  reason: collision with root package name */
            public final AtomicBoolean f67508b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67507a = this;
                this.f67508b = new AtomicBoolean(true);
            }

            private void a() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(65537, this) == null) && this.f67508b.getAndSet(false) && (aVar = this.f67507a.D) != null) {
                    aVar.a();
                }
            }

            private void b() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(65538, this) == null) || this.f67508b.getAndSet(true) || (aVar = this.f67507a.D) == null) {
                    return;
                }
                aVar.d();
            }

            @Override // android.view.View
            public void onAttachedToWindow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onAttachedToWindow();
                    a();
                }
            }

            @Override // android.view.View
            public void onDetachedFromWindow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.onDetachedFromWindow();
                    b();
                }
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.onFinishTemporaryDetach();
                    a();
                }
            }

            @Override // android.view.View
            public void onMeasure(int i2, int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048579, this, i2, i3) == null) {
                    super.onMeasure(0, 0);
                }
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.onStartTemporaryDetach();
                    b();
                }
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048581, this, z) == null) {
                    super.onWindowFocusChanged(z);
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f67507a.D;
                    if (aVar != null) {
                        if (z) {
                            aVar.b();
                        } else {
                            aVar.c();
                        }
                    }
                }
            }
        };
        View view2 = this.f67494a;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
        }
    }

    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, message) == null) {
        }
    }

    public void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, view, z) == null) {
        }
    }

    public void a(@Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, viewGroup) == null) {
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, surfaceTexture) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048603, this, surfaceTexture, i2, i3) == null) {
        }
    }

    public void b(@Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, viewGroup) == null) {
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.C = z;
            if (z) {
                com.bytedance.sdk.openadsdk.core.b.a aVar = this.F;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.bytedance.sdk.openadsdk.core.b.a aVar2 = this.G;
                if (aVar2 != null) {
                    aVar2.a(true);
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.core.b.a aVar3 = this.F;
            if (aVar3 != null) {
                aVar3.a(false);
                this.F.c(true);
            }
            com.bytedance.sdk.openadsdk.core.b.a aVar4 = this.G;
            if (aVar4 != null) {
                aVar4.a(false);
                this.G.c(true);
            }
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            s.a(this.f67494a, 0);
            com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.f67495b;
            if (bVar != null) {
                bVar.setVisibility(i2);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            ProgressBar progressBar = this.o;
            if (progressBar != null) {
                progressBar.setProgress(0);
                this.o.setSecondaryProgress(0);
            }
            c(8);
            if (x()) {
                this.f67495b.setVisibility(8);
            }
            ImageView imageView = this.f67499f;
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            c(8);
            s.a(this.f67501h, 8);
            s.a((View) this.f67502i, 8);
            s.a(this.f67503j, 8);
            s.a((View) this.k, 8);
            s.a((View) this.l, 8);
            s.a((View) this.m, 8);
            com.bytedance.sdk.openadsdk.core.widget.i iVar = this.A;
            if (iVar != null) {
                iVar.a(true);
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            a(true, false);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            com.bytedance.sdk.openadsdk.core.widget.i iVar = this.A;
            return iVar != null && iVar.a();
        }
        return invokeV.booleanValue;
    }

    public void n() {
        String str;
        int i2;
        com.bytedance.sdk.openadsdk.core.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            String str2 = this.C ? "embeded_ad" : "embeded_ad_landingpage";
            if (q.b(this.y)) {
                str = this.C ? "draw_ad" : "draw_ad_landingpage";
                i2 = 6;
            } else if (q.e(this.y)) {
                str = "rewarded_video";
                i2 = 7;
            } else if (q.f(this.y)) {
                str = "fullscreen_interstitial_ad";
                i2 = 5;
            } else {
                str = str2;
                i2 = 1;
            }
            if (this.y.X() == 4) {
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.z, this.y, str);
                this.D = a2;
                a2.a(2, new a.InterfaceC1920a(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.i.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f67504a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67504a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC1920a
                    public boolean a(int i3, m mVar, String str3, String str4, Object obj) {
                        InterceptResult invokeCommon;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), mVar, str3, str4, obj})) == null) {
                            if (i3 == 2 && mVar != null && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                                if (str4.equals("click_start_play")) {
                                    String str5 = this.f67504a.C ? "click_start" : "click_start_detail";
                                    i iVar = this.f67504a;
                                    com.bytedance.sdk.openadsdk.e.d.a(iVar.z, iVar.y, str3, str5, (JSONObject) null);
                                    return true;
                                } else if (str4.equals("click_open")) {
                                    i iVar2 = this.f67504a;
                                    if (iVar2.C) {
                                        Context context = iVar2.z;
                                        m mVar2 = iVar2.y;
                                        com.bytedance.sdk.openadsdk.e.d.i(context, mVar2, str3, q.h(mVar2), null);
                                    } else {
                                        com.bytedance.sdk.openadsdk.e.d.h(iVar2.z, iVar2.y, str3, "click_open_detail", null);
                                    }
                                }
                            }
                            return true;
                        }
                        return invokeCommon.booleanValue;
                    }
                });
            }
            z();
            com.bytedance.sdk.openadsdk.core.b.a aVar2 = new com.bytedance.sdk.openadsdk.core.b.a(this.z, this.y, str, i2);
            this.F = aVar2;
            aVar2.d(true);
            this.F.b(true);
            if (this.C) {
                this.F.a(true);
            } else {
                this.F.a(false);
                this.F.c(true);
            }
            this.F.a(this.E);
            this.F.e(true);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar3 = this.D;
            if (aVar3 != null && (aVar = this.F) != null) {
                aVar.a(aVar3);
            }
            if (y()) {
                com.bytedance.sdk.openadsdk.core.b.a aVar4 = new com.bytedance.sdk.openadsdk.core.b.a(this, this.z, this.y, str, i2) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.i.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f67505a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r11, r12, str, i2);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r11, r12, str, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((Context) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67505a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.b.a
                    public boolean b() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            com.bytedance.sdk.openadsdk.core.widget.i iVar = this.f67505a.A;
                            boolean a3 = iVar != null ? iVar.a() : false;
                            StringBuilder sb = new StringBuilder();
                            sb.append("isVisible=");
                            sb.append(a3);
                            sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                            sb.append(this.f67505a.f67496c.getVisibility() == 0);
                            k.c("ClickCreativeListener", sb.toString());
                            return a3 || this.f67505a.f67496c.getVisibility() == 0;
                        }
                        return invokeV.booleanValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.b.a
                    public boolean c() {
                        InterceptResult invokeV;
                        View view;
                        RoundImageView roundImageView;
                        TextView textView;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            View view2 = this.f67505a.f67501h;
                            return (view2 != null && view2.getVisibility() == 0) || ((view = this.f67505a.f67503j) != null && view.getVisibility() == 0) || (((roundImageView = this.f67505a.k) != null && roundImageView.getVisibility() == 0) || ((textView = this.f67505a.l) != null && textView.getVisibility() == 0));
                        }
                        return invokeV.booleanValue;
                    }
                };
                this.G = aVar4;
                aVar4.d(true);
                this.G.a(new b.a(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.i.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f67506a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67506a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                    public void a(View view, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i3) == null) || this.f67506a.M == null) {
                            return;
                        }
                        this.f67506a.M.a(view, i3);
                    }
                });
                this.G.b(true);
                if (this.C) {
                    this.G.a(true);
                } else {
                    this.G.a(false);
                }
                this.G.a(this.E);
                this.G.e(true);
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar5 = this.D;
                if (aVar5 != null) {
                    this.G.a(aVar5);
                }
                View view = this.f67494a;
                if (view != null) {
                    view.setOnClickListener(this.G);
                    this.f67494a.setOnTouchListener(this.G);
                }
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.renderview.b o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f67495b : (com.bytedance.sdk.openadsdk.core.video.renderview.b) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.B != null && this.A == null) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.openadsdk.core.widget.i iVar = new com.bytedance.sdk.openadsdk.core.widget.i();
            this.A = iVar;
            iVar.a(this.z, this.f67494a);
            this.A.a(this.B, this);
            k.b("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.widget.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (iVar = this.A) == null) {
            return;
        }
        iVar.a(false);
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.B == null) {
                k.f("NewLiveViewLayout", "callback is null");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f67494a : (View) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            s.f(this.f67497d);
            s.f(this.f67498e);
            ImageView imageView = this.f67496c;
            if (imageView == null || imageView.getVisibility() != 0) {
                return;
            }
            s.a((View) this.f67496c, 8);
        }
    }

    @RequiresApi(api = 14)
    @TargetApi(14)
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            s.a(this.f67494a, 0);
            com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.f67495b;
            if (bVar != null) {
                View view = bVar.getView();
                if (view instanceof TextureView) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        int indexOfChild = viewGroup.indexOfChild(view);
                        viewGroup.removeView(view);
                        viewGroup.addView(view, indexOfChild);
                    }
                }
                s.a(view, 8);
                s.a(view, 0);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            s.a(this.f67501h, 8);
            s.a((View) this.f67502i, 8);
            s.a(this.f67503j, 8);
            s.a((View) this.k, 8);
            s.a((View) this.l, 8);
            s.a((View) this.m, 8);
            s.a((View) this.n, 8);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            s.e(this.f67497d);
            s.e(this.f67498e);
            ImageView imageView = this.f67499f;
            if (imageView != null) {
                s.e(imageView);
            }
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? !this.x.contains(b.a.f67461c) || this.u : invokeV.booleanValue;
    }

    public void a(NativeVideoTsView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.M = bVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v36, types: [com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView] */
    public void a(Context context, View view) {
        SSRenderSurfaceView sSRenderSurfaceView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, view) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String a2 = q.a(context);
            if (a2 == null) {
                a2 = "0";
            }
            boolean z = Build.VERSION.SDK_INT != 20 || Integer.valueOf(a2).intValue() >= 1572864;
            if (!A() && z && com.bytedance.sdk.openadsdk.core.h.d().u() && Build.VERSION.SDK_INT >= 14) {
                ?? sSRenderTextureView = new SSRenderTextureView(this.z);
                k.b("NewLiveViewLayout", "use TextureView......");
                sSRenderSurfaceView = sSRenderTextureView;
            } else {
                SSRenderSurfaceView sSRenderSurfaceView2 = new SSRenderSurfaceView(this.z);
                k.b("NewLiveViewLayout", "use SurfaceView......");
                sSRenderSurfaceView = sSRenderSurfaceView2;
            }
            if (view instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                ((RelativeLayout) view).addView(sSRenderSurfaceView, 0, layoutParams);
                view.setBackgroundColor(-16777216);
            }
            s.a((View) sSRenderSurfaceView, 8);
            this.f67495b = sSRenderSurfaceView;
            this.f67496c = (ImageView) view.findViewById(t.e(context, "tt_video_play"));
            this.o = (ProgressBar) view.findViewById(t.e(context, "tt_video_progress"));
            this.f67497d = view.findViewById(t.e(context, "tt_video_loading_retry_layout"));
            this.f67498e = view.findViewById(t.e(context, "tt_video_loading_progress"));
            this.f67499f = (ImageView) view.findViewById(t.e(context, "tt_video_loading_cover_image"));
            this.f67500g = (ViewStub) view.findViewById(t.e(context, "tt_video_ad_cover"));
            this.p = (ViewStub) view.findViewById(t.e(context, "tt_video_draw_layout_viewStub"));
            k.b("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            s.e(this.f67497d);
        }
    }

    public void d() {
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            s.f(this.f67497d);
            s.f(this.f67498e);
            if (this.f67499f != null && (mVar = this.y) != null && mVar.V() != null && this.y.V().h() != null) {
                s.f(this.f67499f);
                ImageLoaderWrapper.from(this.y.V().h()).to(this.f67499f);
            }
            ImageView imageView = this.f67496c;
            if (imageView == null || imageView.getVisibility() != 0) {
                return;
            }
            s.a((View) this.f67496c, 8);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            a(false, this.u);
            v();
        }
    }

    public void b(boolean z, boolean z2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (imageView = this.f67496c) == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(t.d(this.z, "tt_play_movebar_textpage"));
        } else {
            imageView.setImageResource(t.d(this.z, "tt_stop_movebar_textpage"));
        }
    }

    public void b(int i2, int i3) {
        View view;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) || (view = this.f67494a) == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.width = i2;
        }
        if (i3 == -1 || i3 == -2 || i3 > 0) {
            layoutParams.height = i3;
        }
        this.f67494a.setLayoutParams(layoutParams);
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
            this.s = i2;
            this.t = i3;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.I = z;
        }
    }

    public void c(@Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        if (this.f67494a.getParent() != null) {
            ((ViewGroup) this.f67494a.getParent()).removeView(this.f67494a);
        }
        viewGroup.addView(this.f67494a);
        c(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, surfaceHolder) == null) && surfaceHolder == this.f67495b.getHolder()) {
            this.v = false;
            if (r()) {
                this.B.b(this, surfaceHolder);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Context context, View view, boolean z, EnumSet<b.a> enumSet, m mVar, c cVar) {
        this(context, view, z, enumSet, mVar, cVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, Boolean.valueOf(z), enumSet, mVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (View) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (EnumSet) objArr2[3], (m) objArr2[4], (c) objArr2[5], ((Boolean) objArr2[6]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.w = i2;
            s.a(this.f67494a, i2);
        }
    }

    public void a(View view, Context context) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, context) == null) || view == null || context == null || (viewStub = this.f67500g) == null || viewStub.getParent() == null || this.f67501h != null) {
            return;
        }
        this.f67501h = this.f67500g.inflate();
        this.f67502i = (ImageView) view.findViewById(t.e(context, "tt_video_ad_finish_cover_image"));
        this.f67503j = view.findViewById(t.e(context, "tt_video_ad_cover_center_layout"));
        this.k = (RoundImageView) view.findViewById(t.e(context, "tt_video_ad_logo_image"));
        this.l = (TextView) view.findViewById(t.e(context, "tt_video_btn_ad_image_tv"));
        this.m = (TextView) view.findViewById(t.e(context, "tt_video_ad_name"));
        this.n = (TextView) view.findViewById(t.e(context, "tt_video_ad_button"));
    }

    public boolean a(int i2, x xVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), xVar, Boolean.valueOf(z)})) == null) {
            com.bytedance.sdk.openadsdk.core.widget.i iVar = this.A;
            return iVar == null || iVar.a(i2, xVar, z);
        }
        return invokeCommon.booleanValue;
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) && (aVar instanceof d)) {
            this.B = (d) aVar;
            p();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67495b.a(this);
            ImageView imageView = this.f67496c;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.i.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f67509a;

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
                        this.f67509a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f67509a.r()) {
                            TextView textView = this.f67509a.n;
                            if (textView == null || textView.getVisibility() != 0) {
                                i iVar = this.f67509a;
                                iVar.B.a(iVar, view);
                            }
                        }
                    }
                });
            }
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (i2 == -1) {
                i2 = s.c(this.z);
            }
            if (i2 <= 0) {
                return;
            }
            this.q = i2;
            if (!i() && !h() && !this.x.contains(b.a.f67462d)) {
                this.r = e(i2);
            } else {
                this.r = i3;
            }
            b(this.q, this.r);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            k.c("Progress", "setSeekProgress-percent=" + i2);
            s.a((View) this.o, 0);
            ProgressBar progressBar = this.o;
            if (progressBar != null) {
                progressBar.setProgress(i2);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(m mVar, WeakReference<Context> weakReference, boolean z) {
        m mVar2;
        String ai;
        m mVar3;
        m mVar4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048591, this, mVar, weakReference, z) == null) || mVar == null) {
            return;
        }
        a(false, this.u);
        a(this.f67494a, o.a());
        View view = this.f67501h;
        if (view != null) {
            s.a(view, 0);
        }
        ImageView imageView = this.f67502i;
        if (imageView != null) {
            s.a((View) imageView, 0);
        }
        if (q.b(this.y)) {
            b(this.f67494a, o.a());
            s.a(this.f67503j, 8);
            s.a((View) this.f67502i, 0);
            s.a(this.J, 0);
            s.a((View) this.K, 0);
            s.a((View) this.L, 0);
            if (this.L != null && n.c(o.a()) == 0) {
                s.a((View) this.L, 8);
            }
            View view2 = this.f67501h;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.i.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f67510a;

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
                        this.f67510a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        c cVar;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) || (cVar = this.f67510a.E) == null) {
                            return;
                        }
                        ((a) cVar).h();
                        TTDrawFeedAd.DrawVideoListener drawVideoListener = this.f67510a.H;
                        if (drawVideoListener != null) {
                            drawVideoListener.onClickRetry();
                        }
                    }
                });
            }
            if (this.f67502i != null && (mVar4 = this.y) != null && mVar4.V() != null && this.y.V().h() != null) {
                com.bytedance.sdk.openadsdk.core.video.d.b.a((long) this.y.V().e(), this.y.V().i(), new b.InterfaceC1914b(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.i.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f67511a;

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
                        this.f67511a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.video.d.b.InterfaceC1914b
                    public void a(Bitmap bitmap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap) == null) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f67511a.f67502i.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    layoutParams.width = s.c(o.a());
                                    layoutParams.height = (bitmap.getHeight() * s.c(o.a())) / bitmap.getWidth();
                                    layoutParams.addRule(13);
                                    this.f67511a.f67502i.setLayoutParams(layoutParams);
                                }
                                this.f67511a.f67502i.setImageBitmap(bitmap);
                                return;
                            }
                            ImageLoaderWrapper.from(this.f67511a.y.V().h()).to(this.f67511a.f67502i);
                        }
                    }
                });
            }
        } else {
            s.a(this.f67503j, 0);
            if (this.f67502i != null && (mVar2 = this.y) != null && mVar2.V() != null && this.y.V().h() != null) {
                ImageLoaderWrapper.from(this.y.V().h()).to(this.f67502i);
            }
        }
        if (!TextUtils.isEmpty(mVar.W())) {
            ai = mVar.W();
        } else if (!TextUtils.isEmpty(mVar.ah())) {
            ai = mVar.ah();
        } else {
            ai = !TextUtils.isEmpty(mVar.ai()) ? mVar.ai() : "";
        }
        if (this.k != null && (mVar3 = this.y) != null && mVar3.Y() != null && this.y.Y().a() != null) {
            s.a((View) this.k, 0);
            s.a((View) this.l, 4);
            ImageLoaderWrapper.from(this.y.Y()).to(this.k);
            if (y()) {
                this.k.setOnClickListener(this.G);
                this.k.setOnTouchListener(this.G);
            } else {
                this.k.setOnClickListener(this.F);
                this.k.setOnTouchListener(this.F);
            }
        } else if (!TextUtils.isEmpty(ai)) {
            s.a((View) this.k, 4);
            s.a((View) this.l, 0);
            TextView textView = this.l;
            if (textView != null) {
                textView.setText(ai.substring(0, 1));
                if (y()) {
                    this.l.setOnClickListener(this.G);
                    this.l.setOnTouchListener(this.G);
                } else {
                    this.l.setOnClickListener(this.F);
                    this.l.setOnTouchListener(this.F);
                }
            }
        }
        if (this.m != null && !TextUtils.isEmpty(ai)) {
            this.m.setText(ai);
        }
        s.a((View) this.m, 0);
        s.a((View) this.n, 0);
        String aj = mVar.aj();
        if (TextUtils.isEmpty(aj)) {
            int X = mVar.X();
            if (X == 4) {
                aj = t.a(this.z, "tt_video_download_apk");
            } else if (X != 5) {
                aj = t.a(this.z, "tt_video_mobile_go_detail");
            } else {
                aj = t.a(this.z, "tt_video_dial_phone");
            }
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setText(aj);
            this.n.setOnClickListener(this.F);
            this.n.setOnTouchListener(this.F);
        }
        TextView textView3 = this.K;
        if (textView3 != null) {
            textView3.setText(aj);
            this.K.setOnClickListener(this.F);
            this.K.setOnTouchListener(this.F);
        }
        if (this.I) {
            return;
        }
        f(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, surfaceHolder) == null) && surfaceHolder == this.f67495b.getHolder()) {
            this.v = true;
            if (r()) {
                this.B.a(this, surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048586, this, surfaceHolder, i2, i3, i4) == null) && surfaceHolder == this.f67495b.getHolder() && r()) {
            this.B.a(this, surfaceHolder, i2, i3, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, surfaceTexture, i2, i3) == null) {
            this.v = true;
            if (r()) {
                this.B.a(this, surfaceTexture);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public boolean a(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, surfaceTexture)) == null) {
            this.v = false;
            if (r()) {
                this.B.b(this, surfaceTexture);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            int i2 = 0;
            s.a((View) this.o, 0);
            s.a((View) this.f67496c, (!z || this.f67497d.getVisibility() == 0) ? 8 : 8);
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            s.a((View) this.o, z ? 0 : 8);
            s.a((View) this.f67496c, 8);
        }
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawVideoListener) == null) {
            this.H = drawVideoListener;
            com.bytedance.sdk.openadsdk.core.b.a aVar = this.F;
            if (aVar != null) {
                aVar.a(drawVideoListener);
            }
        }
    }

    public void a(Drawable drawable) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, drawable) == null) || (view = this.f67494a) == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
    }
}
