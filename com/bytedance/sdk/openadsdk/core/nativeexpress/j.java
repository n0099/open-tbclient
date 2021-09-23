package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import java.util.Locale;
/* loaded from: classes9.dex */
public class j extends BackupView {
    public static /* synthetic */ Interceptable $ic;
    public static k[] l;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public View n;
    public NativeExpressView o;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a p;
    public TextView q;
    public TextView r;
    public ImageView s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-364922014, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-364922014, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/j;");
                return;
            }
        }
        l = new k[]{new k(2, 3.0241935f, 375, 124), new k(3, 1.25f, 375, 300), new k(4, 1.4044944f, 375, 267), new k(16, 1.25f, 375, 300), new k(5, 1.25f, 375, 300), new k(15, 1.25f, 375, 300)};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull Context context) {
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
        this.f67088a = context;
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            k d2 = d(this.f67089b.ap());
            this.f67093f = com.bytedance.sdk.openadsdk.q.s.d(this.f67088a, this.o.getExpectExpressWidth());
            this.f67094g = com.bytedance.sdk.openadsdk.q.s.d(this.f67088a, this.o.getExpectExpressHeight());
            if (this.f67093f <= 0) {
                this.f67093f = com.bytedance.sdk.openadsdk.q.s.c(this.f67088a);
            }
            if (this.f67094g <= 0) {
                this.f67094g = Float.valueOf(this.f67093f / d2.f67206c).intValue();
            }
            int i3 = this.f67093f;
            if (i3 > 0 && i3 > com.bytedance.sdk.openadsdk.q.s.c(this.f67088a)) {
                float c2 = com.bytedance.sdk.openadsdk.q.s.c(this.f67088a) / this.f67093f;
                this.f67093f = com.bytedance.sdk.openadsdk.q.s.c(this.f67088a);
                this.f67094g = Float.valueOf(this.f67094g * c2).intValue();
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.f67093f, this.f67094g);
            }
            layoutParams.width = this.f67093f;
            layoutParams.height = this.f67094g;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            setLayoutParams(layoutParams);
            if (i2 == 9) {
                this.f67092e = "draw_ad";
                h();
                return;
            }
            this.f67092e = "embeded_ad";
            int ap = this.f67089b.ap();
            if (ap == 2) {
                d();
            } else if (ap == 3) {
                f();
            } else if (ap == 4) {
                e();
            } else if (ap == 5) {
                i();
            } else if (ap == 15) {
                g();
            } else if (ap != 16) {
            } else {
                j();
            }
        }
    }

    private k d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            k[] kVarArr = l;
            k kVar = kVarArr[0];
            try {
                for (k kVar2 : kVarArr) {
                    if (kVar2.f67204a == i2) {
                        return kVar2;
                    }
                }
                return kVar;
            } catch (Throwable unused) {
                return kVar;
            }
        }
        return (k) invokeI.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            View inflate = LayoutInflater.from(this.f67088a).inflate(com.bytedance.sdk.component.utils.t.f(this.f67088a, "tt_backup_feed_img_group"), (ViewGroup) this, true);
            this.n = inflate;
            this.s = (ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_download"));
            com.bytedance.sdk.openadsdk.q.s.a((TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_ad_logo")), this.f67089b);
            ImageLoaderWrapper.from(this.f67089b.ad().get(0)).to((ImageView) inflate.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img_1")));
            ImageLoaderWrapper.from(this.f67089b.ad().get(1)).to((ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img_2")));
            ImageLoaderWrapper.from(this.f67089b.ad().get(2)).to((ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img_3")));
            ImageLoaderWrapper.from(this.f67089b.Y()).to((ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_icon")));
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ j f67199a;

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
                    this.f67199a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f67199a.a();
                    }
                }
            });
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f67089b.aj())) {
                textView.setText(this.f67089b.aj());
            }
            a((View) this, false);
            a((View) textView, true);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            View inflate = LayoutInflater.from(this.f67088a).inflate(com.bytedance.sdk.component.utils.t.f(this.f67088a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
            this.n = inflate;
            inflate.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_container")).setVisibility(8);
            this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img_container")).setVisibility(0);
            ImageView imageView = (ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img"));
            this.s = (ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_download"));
            com.bytedance.sdk.openadsdk.q.s.a((TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_ad_logo")), this.f67089b);
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(this.f67094g);
            a(imageView);
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ j f67200a;

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
                    this.f67200a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f67200a.a();
                    }
                }
            });
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f67089b.aj())) {
                textView.setText(this.f67089b.aj());
            }
            a((View) this, false);
            a((View) textView, true);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            View inflate = LayoutInflater.from(this.f67088a).inflate(com.bytedance.sdk.component.utils.t.f(this.f67088a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
            this.n = inflate;
            inflate.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_container")).setVisibility(0);
            this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img_container")).setVisibility(8);
            FrameLayout frameLayout = (FrameLayout) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_container_inner"));
            this.s = (ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_name1"));
            TextView textView2 = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_name2"));
            TextView textView3 = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_download"));
            TextView textView4 = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_score"));
            TTRatingBar tTRatingBar = (TTRatingBar) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_score_bar"));
            com.bytedance.sdk.openadsdk.q.s.a((TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_video_ad_logo")), this.f67089b);
            ImageLoaderWrapper.from(this.f67089b.Y()).to((ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_icon")));
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ j f67201a;

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
                    this.f67201a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f67201a.a();
                    }
                }
            });
            int e2 = this.f67089b.al() != null ? this.f67089b.al().e() : 4;
            textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e2)));
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(e2);
            tTRatingBar.setStarImageWidth(com.bytedance.sdk.openadsdk.q.s.d(this.f67088a, 15.0f));
            tTRatingBar.setStarImageHeight(com.bytedance.sdk.openadsdk.q.s.d(this.f67088a, 14.0f));
            tTRatingBar.setStarImagePadding(com.bytedance.sdk.openadsdk.q.s.d(this.f67088a, 4.0f));
            tTRatingBar.a();
            textView.setText(getNameOrSource());
            textView2.setText(getTitle());
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f67089b.aj())) {
                textView3.setText(this.f67089b.aj());
            }
            View videoView = getVideoView();
            if (videoView != null) {
                int i2 = (this.f67093f * 123) / 375;
                frameLayout.removeAllViews();
                frameLayout.addView(videoView, new ViewGroup.LayoutParams(i2, (i2 * 16) / 9));
            }
            a((View) this, false);
            a((View) textView3, true);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            View inflate = LayoutInflater.from(this.f67088a).inflate(com.bytedance.sdk.component.utils.t.f(this.f67088a, "tt_backup_draw"), (ViewGroup) this, true);
            this.n = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_container"));
            TextView textView = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_desc"));
            TextView textView2 = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_title"));
            TextView textView3 = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_download"));
            textView.setText(getDescription());
            textView2.setText(getTitle());
            com.bytedance.sdk.openadsdk.q.s.a((TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_ad_logo")), this.f67089b);
            if (!TextUtils.isEmpty(this.f67089b.aj())) {
                textView3.setText(this.f67089b.aj());
            }
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(videoView, new ViewGroup.LayoutParams(-1, -1));
            }
            a((View) textView2, false);
            a((View) textView, false);
            a((View) textView3, true);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            View inflate = LayoutInflater.from(this.f67088a).inflate(com.bytedance.sdk.component.utils.t.f(this.f67088a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
            this.n = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_container"));
            frameLayout.setVisibility(0);
            this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img_container")).setVisibility(8);
            this.s = (ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_download"));
            com.bytedance.sdk.openadsdk.q.s.a((TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_ad_logo")), this.f67089b);
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ j f67202a;

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
                    this.f67202a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f67202a.a();
                    }
                }
            });
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f67089b.aj())) {
                textView.setText(this.f67089b.aj());
            }
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int i2 = this.f67093f;
                frameLayout.addView(videoView, new ViewGroup.LayoutParams(i2, (i2 * 9) / 16));
            }
            a((View) this, false);
            a((View) textView, true);
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            View inflate = LayoutInflater.from(this.f67088a).inflate(com.bytedance.sdk.component.utils.t.f(this.f67088a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
            this.n = inflate;
            inflate.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_video_container")).setVisibility(8);
            this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img_container")).setVisibility(0);
            this.s = (ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_download"));
            com.bytedance.sdk.openadsdk.q.s.a((TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_ad_logo")), this.f67089b);
            a((ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img")));
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ j f67203a;

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
                    this.f67203a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f67203a.a();
                    }
                }
            });
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f67089b.aj())) {
                textView.setText(this.f67089b.aj());
            }
            a((View) this, false);
            a((View) textView, true);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mVar, nativeExpressView, aVar) == null) {
            com.bytedance.sdk.component.utils.k.b("FeedExpressBackupView", "show backup view");
            setBackgroundColor(-1);
            this.f67089b = mVar;
            this.o = nativeExpressView;
            this.p = aVar;
            int d2 = com.bytedance.sdk.openadsdk.q.q.d(mVar.ao());
            this.m = d2;
            b(d2);
            int c2 = com.bytedance.sdk.openadsdk.q.q.c(this.f67089b.ao());
            c(c2);
            e(com.bytedance.sdk.openadsdk.core.h.d().A());
            int i2 = c2 != 9 ? -2 : -1;
            this.o.addView(this, new ViewGroup.LayoutParams(i2, i2));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.q == null || this.r == null) {
            return;
        }
        int ap = this.f67089b.ap();
        if (ap != 2) {
            if (ap != 3) {
                if (ap == 4) {
                    this.q.setTextColor(Color.parseColor("#FF3E3E3E"));
                    this.r.setTextColor(Color.parseColor("#FF3E3E3E"));
                    return;
                } else if (ap != 5 && ap != 15 && ap != 16) {
                    return;
                }
            }
            this.q.setTextColor(Color.parseColor("#FF222222"));
            this.r.setTextColor(Color.parseColor("#FF505050"));
            return;
        }
        this.q.setTextColor(Color.parseColor("#FFBCBCBC"));
        this.r.setTextColor(Color.parseColor("#FF999999"));
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            View inflate = LayoutInflater.from(this.f67088a).inflate(com.bytedance.sdk.component.utils.t.f(this.f67088a, "tt_backup_feed_img_small"), (ViewGroup) this, true);
            this.n = inflate;
            this.s = (ImageView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_title"));
            a((LinearLayout) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_ad_logo_layout")), (TextView) this.n.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_ad_logo")), this.f67089b);
            a((ImageView) inflate.findViewById(com.bytedance.sdk.component.utils.t.e(this.f67088a, "tt_bu_img")));
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ j f67198a;

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
                    this.f67198a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f67198a.a();
                    }
                }
            });
            a((View) this, true);
        }
    }

    private void a(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, imageView) == null) {
            ImageLoaderWrapper.from(this.f67089b.ad().get(0)).to(imageView);
        }
    }

    private void a(View view, TextView textView, com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, this, view, textView, mVar) == null) || view == null || textView == null) {
            return;
        }
        if (mVar == null) {
            view.setVisibility(0);
            return;
        }
        String aO = mVar.aO();
        if (TextUtils.isEmpty(aO)) {
            view.setVisibility(0);
            textView.setVisibility(8);
            return;
        }
        view.setVisibility(8);
        textView.setVisibility(0);
        com.bytedance.sdk.openadsdk.q.s.a(textView, aO);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, kVar) == null) || (nativeExpressView = this.o) == null) {
            return;
        }
        nativeExpressView.a(i2, kVar);
    }

    private void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            if (i2 == 1) {
                c();
                this.n.setBackgroundColor(0);
                ImageView imageView = this.s;
                if (imageView != null) {
                    imageView.setImageResource(com.bytedance.sdk.component.utils.t.d(getContext(), "tt_dislike_icon_night"));
                    return;
                }
                return;
            }
            b();
            this.n.setBackgroundColor(-1);
            ImageView imageView2 = this.s;
            if (imageView2 != null) {
                imageView2.setImageResource(com.bytedance.sdk.component.utils.t.d(getContext(), "tt_dislike_icon2"));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public NativeVideoTsView a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if ("draw_ad".equals(str)) {
                return new NativeDrawVideoTsView(context, mVar, str, z, z2);
            }
            return new NativeVideoTsView(context, mVar, str, z, z2);
        }
        return (NativeVideoTsView) invokeCommon.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.openadsdk.theme.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.a(i2);
            e(i2);
        }
    }

    public void c() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (textView = this.q) == null || this.r == null) {
            return;
        }
        textView.setTextColor(-1);
        this.r.setTextColor(-1);
    }
}
