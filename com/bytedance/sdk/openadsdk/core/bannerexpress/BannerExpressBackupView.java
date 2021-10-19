package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.k;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import java.util.Locale;
/* loaded from: classes9.dex */
public class BannerExpressBackupView extends BackupView {
    public static /* synthetic */ Interceptable $ic;
    public static k[] l;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public NativeExpressView n;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a o;
    public int p;
    public k q;
    public TextView r;
    public TextView s;
    public ImageView t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2113192726, "Lcom/bytedance/sdk/openadsdk/core/bannerexpress/BannerExpressBackupView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2113192726, "Lcom/bytedance/sdk/openadsdk/core/bannerexpress/BannerExpressBackupView;");
                return;
            }
        }
        l = new k[]{new k(1, 6.4f, 640, 100), new k(3, 1.2f, 600, 500)};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerExpressBackupView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 1;
        this.f67123a = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.q = a(this.n.getExpectExpressWidth(), this.n.getExpectExpressHeight());
            if (this.n.getExpectExpressWidth() > 0 && this.n.getExpectExpressHeight() > 0) {
                this.f67128f = s.d(this.f67123a, this.n.getExpectExpressWidth());
                this.f67129g = s.d(this.f67123a, this.n.getExpectExpressHeight());
            } else {
                int c2 = s.c(this.f67123a);
                this.f67128f = c2;
                this.f67129g = Float.valueOf(c2 / this.q.f67241c).intValue();
            }
            int i2 = this.f67128f;
            if (i2 > 0 && i2 > s.c(this.f67123a)) {
                float c3 = s.c(this.f67123a) / this.f67128f;
                this.f67128f = s.c(this.f67123a);
                this.f67129g = Float.valueOf(this.f67129g * c3).intValue();
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.f67128f, this.f67129g);
            }
            layoutParams.width = this.f67128f;
            layoutParams.height = this.f67129g;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            setLayoutParams(layoutParams);
            k kVar = this.q;
            int i3 = kVar.f67239a;
            if (i3 == 1) {
                c();
            } else if (i3 == 3) {
                a(kVar);
            } else {
                c();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            float d2 = (this.f67129g * 1.0f) / s.d(this.f67123a, 50.0f);
            int i2 = this.f67128f;
            if ((this.f67129g * 1.0f) / i2 > 0.21875f) {
                d2 = (i2 * 1.0f) / s.d(this.f67123a, 320.0f);
            }
            View inflate = LayoutInflater.from(this.f67123a).inflate(t.f(this.f67123a, "tt_backup_banner_layout1"), (ViewGroup) this, true);
            this.m = inflate;
            this.t = (ImageView) inflate.findViewById(t.e(this.f67123a, "tt_bu_close"));
            ImageView imageView = (ImageView) this.m.findViewById(t.e(this.f67123a, "tt_bu_icon"));
            this.r = (TextView) this.m.findViewById(t.e(this.f67123a, "tt_bu_title"));
            TextView textView = (TextView) this.m.findViewById(t.e(this.f67123a, "tt_bu_score"));
            TTRatingBar tTRatingBar = (TTRatingBar) this.m.findViewById(t.e(this.f67123a, "tt_bu_score_bar"));
            TextView textView2 = (TextView) this.m.findViewById(t.e(this.f67123a, "tt_bu_download"));
            TextView textView3 = this.r;
            textView3.setTextSize(2, s.a(this.f67123a, textView3.getTextSize()) * d2);
            textView.setTextSize(2, s.a(this.f67123a, textView.getTextSize()) * d2);
            textView2.setTextSize(2, s.a(this.f67123a, textView2.getTextSize()) * d2);
            this.t.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BannerExpressBackupView f66578a;

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
                    this.f66578a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f66578a.a();
                    }
                }
            });
            s.a((TextView) this.m.findViewById(t.e(this.f67123a, "tt_ad_logo")), this.f67124b, 27, 11);
            ImageLoaderWrapper.from(this.f67124b.Y()).to(imageView);
            this.r.setText(getTitle());
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = (int) (s.d(this.f67123a, 45.0f) * d2);
                layoutParams.height = (int) (s.d(this.f67123a, 45.0f) * d2);
            }
            if (!TextUtils.isEmpty(this.f67124b.aj())) {
                textView2.setText(this.f67124b.aj());
            }
            int e2 = this.f67124b.al() != null ? this.f67124b.al().e() : 4;
            textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e2)));
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(e2);
            tTRatingBar.setStarImageWidth(s.d(this.f67123a, 15.0f) * d2);
            tTRatingBar.setStarImageHeight(s.d(this.f67123a, 14.0f) * d2);
            tTRatingBar.setStarImagePadding(s.d(this.f67123a, 4.0f));
            tTRatingBar.a();
            a((View) this, true);
            a((View) textView2, true);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int i2 = this.q.f67239a;
            if (i2 != 2 && i2 != 3) {
                TextView textView = this.r;
                if (textView != null) {
                    textView.setTextColor(Color.parseColor("#FF333333"));
                }
                ImageView imageView = this.t;
                if (imageView != null) {
                    imageView.setImageResource(t.d(getContext(), "tt_dislike_icon"));
                    return;
                }
                return;
            }
            TextView textView2 = this.r;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#FFAEAEAE"));
            }
            TextView textView3 = this.s;
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#3E3E3E"));
            }
            ImageView imageView2 = this.t;
            if (imageView2 != null) {
                imageView2.setImageResource(t.d(getContext(), "tt_titlebar_close_press_for_dark"));
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            int i2 = this.q.f67239a;
            if (i2 != 2 && i2 != 3) {
                TextView textView = this.r;
                if (textView != null) {
                    textView.setTextColor(-1);
                }
            } else {
                TextView textView2 = this.r;
                if (textView2 != null) {
                    textView2.setTextColor(-1);
                }
                TextView textView3 = this.s;
                if (textView3 != null) {
                    textView3.setTextColor(-1);
                }
            }
            this.t.setImageResource(t.d(getContext(), "tt_dislike_icon_night"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, kVar) == null) || (nativeExpressView = this.n) == null) {
            return;
        }
        nativeExpressView.a(i2, kVar);
    }

    public void a(m mVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mVar, nativeExpressView, aVar) == null) {
            setBackgroundColor(-1);
            this.f67124b = mVar;
            this.n = nativeExpressView;
            this.o = aVar;
            this.f67127e = "banner_ad";
            nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
            int d2 = q.d(this.f67124b.ao());
            this.f67130h = d2;
            b(d2);
            b();
            c(h.d().A());
        }
    }

    private void a(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, imageView) == null) {
            ImageLoaderWrapper.from(this.f67124b.ad().get(0)).to(imageView);
        }
    }

    private void a(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, kVar) == null) {
            float d2 = (this.f67129g * 1.0f) / s.d(this.f67123a, 250.0f);
            View inflate = LayoutInflater.from(this.f67123a).inflate(t.f(this.f67123a, "tt_backup_banner_layout3"), (ViewGroup) this, true);
            this.m = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(t.e(this.f67123a, "tt_ad_content_layout"));
            this.t = (ImageView) this.m.findViewById(t.e(this.f67123a, "tt_bu_close"));
            ImageView imageView = (ImageView) this.m.findViewById(t.e(this.f67123a, "tt_bu_img"));
            ImageView imageView2 = (ImageView) this.m.findViewById(t.e(this.f67123a, "tt_bu_icon"));
            this.r = (TextView) this.m.findViewById(t.e(this.f67123a, "tt_bu_title"));
            this.s = (TextView) this.m.findViewById(t.e(this.f67123a, "tt_bu_desc"));
            TextView textView = (TextView) this.m.findViewById(t.e(this.f67123a, "tt_bu_name"));
            TextView textView2 = (TextView) this.m.findViewById(t.e(this.f67123a, "tt_bu_download"));
            s.a((TextView) this.m.findViewById(t.e(this.f67123a, "tt_ad_logo")), this.f67124b);
            LinearLayout linearLayout = (LinearLayout) this.m.findViewById(t.e(this.f67123a, "tt_bu_total_title"));
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = (int) (s.d(this.f67123a, 45.0f) * d2);
                layoutParams.height = (int) (s.d(this.f67123a, 45.0f) * d2);
            }
            TextView textView3 = this.r;
            textView3.setTextSize(2, s.a(this.f67123a, textView3.getTextSize()) * d2);
            TextView textView4 = this.s;
            textView4.setTextSize(2, s.a(this.f67123a, textView4.getTextSize()) * d2);
            textView.setTextSize(2, s.a(this.f67123a, textView.getTextSize()) * d2);
            textView2.setTextSize(2, s.a(this.f67123a, textView2.getTextSize()) * d2);
            try {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                float f2 = d2 - 1.0f;
                if (f2 > 0.0f) {
                    layoutParams2.topMargin = s.d(this.f67123a, f2 * 8.0f);
                }
                ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (s.d(this.f67123a, 16.0f) * d2), 0, 0);
            } catch (Throwable unused) {
            }
            this.t.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BannerExpressBackupView f66577a;

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
                    this.f66577a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f66577a.a();
                    }
                }
            });
            int b2 = (int) s.b(this.f67123a, 15.0f);
            s.a(this.t, b2, b2, b2, b2);
            if (this.f67124b.V() != null) {
                View videoView = getVideoView();
                if (videoView != null) {
                    int i2 = (this.f67129g * 266) / 400;
                    int i3 = (this.f67128f * 406) / 600;
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i3, (i3 * 9) / 16);
                    int i4 = kVar.f67240b;
                    if (i4 == 1) {
                        int i5 = (this.f67128f * 406) / 600;
                        layoutParams3 = new FrameLayout.LayoutParams(i5, (i5 * 9) / 16);
                    } else if (i4 == 2) {
                        layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                    } else if (i4 == 3) {
                        int i6 = (this.f67129g * Opcodes.NEWARRAY) / 260;
                        layoutParams3 = new FrameLayout.LayoutParams((i6 * 16) / 9, i6);
                    } else if (i4 == 4) {
                        int i7 = (this.f67128f * 480) / 690;
                        layoutParams3 = new FrameLayout.LayoutParams(i7, (i7 * 9) / 16);
                    }
                    layoutParams3.gravity = 17;
                    frameLayout.addView(videoView, 0, layoutParams3);
                }
                s.a((View) imageView, 8);
            } else {
                a(imageView);
                s.a((View) imageView, 0);
            }
            ImageLoaderWrapper.from(this.f67124b.Y()).to(imageView2);
            textView.setText(getNameOrSource());
            this.r.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
            this.s.setText(getDescription());
            if (!TextUtils.isEmpty(this.f67124b.aj())) {
                textView2.setText(this.f67124b.aj());
            }
            a((View) this, true);
            a((View) textView2, true);
            a(frameLayout);
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            if (i2 == 1) {
                e();
                this.m.setBackgroundColor(0);
                return;
            }
            d();
            this.m.setBackgroundColor(-1);
        }
    }

    private k a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, this, i2, i3)) == null) {
            try {
                return ((double) i3) >= Math.floor((((double) i2) * 450.0d) / 600.0d) ? l[1] : l[0];
            } catch (Throwable unused) {
                return l[0];
            }
        }
        return (k) invokeII.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.openadsdk.theme.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.a(i2);
            c(i2);
        }
    }
}
