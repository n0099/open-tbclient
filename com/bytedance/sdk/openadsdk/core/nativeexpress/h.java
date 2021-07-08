package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.r.q;
import java.util.Locale;
/* loaded from: classes5.dex */
public class h extends BackupView {
    public static /* synthetic */ Interceptable $ic;
    public static i[] l;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-364922076, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-364922076, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/h;");
                return;
            }
        }
        l = new i[]{new i(2, 3.0241935f, 375, 124), new i(3, 1.25f, 375, 300), new i(4, 1.4044944f, 375, 267), new i(16, 1.25f, 375, 300), new i(5, 1.25f, 375, 300), new i(15, 1.25f, 375, 300)};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull Context context) {
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
        this.f30379a = context;
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            i d2 = d(this.f30380b.ap());
            this.f30384f = q.d(this.f30379a, this.o.getExpectExpressWidth());
            this.f30385g = q.d(this.f30379a, this.o.getExpectExpressHeight());
            if (this.f30384f <= 0) {
                this.f30384f = q.c(this.f30379a);
            }
            if (this.f30385g <= 0) {
                this.f30385g = Float.valueOf(this.f30384f / d2.f30444c).intValue();
            }
            int i3 = this.f30384f;
            if (i3 > 0 && i3 > q.c(this.f30379a)) {
                float c2 = q.c(this.f30379a) / this.f30384f;
                this.f30384f = q.c(this.f30379a);
                this.f30385g = Float.valueOf(this.f30385g * c2).intValue();
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.f30384f, this.f30385g);
            }
            layoutParams.width = this.f30384f;
            layoutParams.height = this.f30385g;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            setLayoutParams(layoutParams);
            if (i2 == 9) {
                this.f30383e = "draw_ad";
                h();
                return;
            }
            this.f30383e = "embeded_ad";
            int ap = this.f30380b.ap();
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

    private i d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            i[] iVarArr = l;
            i iVar = iVarArr[0];
            try {
                for (i iVar2 : iVarArr) {
                    if (iVar2.f30442a == i2) {
                        return iVar2;
                    }
                }
                return iVar;
            } catch (Throwable unused) {
                return iVar;
            }
        }
        return (i) invokeI.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            View inflate = LayoutInflater.from(this.f30379a).inflate(r.f(this.f30379a, "tt_backup_feed_img_group"), (ViewGroup) this, true);
            this.n = inflate;
            this.s = (ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_download"));
            com.bytedance.sdk.openadsdk.g.a.a(this.f30380b.ad().get(0)).a((ImageView) inflate.findViewById(r.e(this.f30379a, "tt_bu_img_1")));
            com.bytedance.sdk.openadsdk.g.a.a(this.f30380b.ad().get(1)).a((ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_img_2")));
            com.bytedance.sdk.openadsdk.g.a.a(this.f30380b.ad().get(2)).a((ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_img_3")));
            com.bytedance.sdk.openadsdk.g.a.a(this.f30380b.Y()).a((ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_icon")));
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f30437a;

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
                    this.f30437a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30437a.a();
                    }
                }
            });
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f30380b.aj())) {
                textView.setText(this.f30380b.aj());
            }
            a((View) this, false);
            a((View) textView, true);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            View inflate = LayoutInflater.from(this.f30379a).inflate(r.f(this.f30379a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
            this.n = inflate;
            inflate.findViewById(r.e(this.f30379a, "tt_bu_video_container")).setVisibility(8);
            this.n.findViewById(r.e(this.f30379a, "tt_bu_img_container")).setVisibility(0);
            ImageView imageView = (ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_img"));
            this.s = (ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_download"));
            imageView.setAdjustViewBounds(true);
            imageView.setMaxHeight(this.f30385g);
            a(imageView);
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f30438a;

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
                    this.f30438a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30438a.a();
                    }
                }
            });
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f30380b.aj())) {
                textView.setText(this.f30380b.aj());
            }
            a((View) this, false);
            a((View) textView, true);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            View inflate = LayoutInflater.from(this.f30379a).inflate(r.f(this.f30379a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
            this.n = inflate;
            inflate.findViewById(r.e(this.f30379a, "tt_bu_video_container")).setVisibility(0);
            this.n.findViewById(r.e(this.f30379a, "tt_bu_img_container")).setVisibility(8);
            FrameLayout frameLayout = (FrameLayout) this.n.findViewById(r.e(this.f30379a, "tt_bu_video_container_inner"));
            this.s = (ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_video_name1"));
            TextView textView2 = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_video_name2"));
            TextView textView3 = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_download"));
            TextView textView4 = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_video_score"));
            TTRatingBar tTRatingBar = (TTRatingBar) this.n.findViewById(r.e(this.f30379a, "tt_bu_video_score_bar"));
            com.bytedance.sdk.openadsdk.g.a.a(this.f30380b.Y()).a((ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_video_icon")));
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f30439a;

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
                    this.f30439a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30439a.a();
                    }
                }
            });
            int e2 = this.f30380b.al() != null ? this.f30380b.al().e() : 4;
            textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e2)));
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(e2);
            tTRatingBar.setStarImageWidth(q.d(this.f30379a, 15.0f));
            tTRatingBar.setStarImageHeight(q.d(this.f30379a, 14.0f));
            tTRatingBar.setStarImagePadding(q.d(this.f30379a, 4.0f));
            tTRatingBar.a();
            textView.setText(getNameOrSource());
            textView2.setText(getTitle());
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f30380b.aj())) {
                textView3.setText(this.f30380b.aj());
            }
            View videoView = getVideoView();
            if (videoView != null) {
                int i2 = (this.f30384f * 123) / 375;
                frameLayout.removeAllViews();
                frameLayout.addView(videoView, new ViewGroup.LayoutParams(i2, (i2 * 16) / 9));
            }
            a((View) this, false);
            a((View) textView3, true);
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            View inflate = LayoutInflater.from(this.f30379a).inflate(r.f(this.f30379a, "tt_backup_draw"), (ViewGroup) this, true);
            this.n = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(r.e(this.f30379a, "tt_bu_video_container"));
            TextView textView = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_desc"));
            TextView textView2 = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_title"));
            TextView textView3 = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_download"));
            textView.setText(getDescription());
            textView2.setText(getTitle());
            if (!TextUtils.isEmpty(this.f30380b.aj())) {
                textView3.setText(this.f30380b.aj());
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
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            View inflate = LayoutInflater.from(this.f30379a).inflate(r.f(this.f30379a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
            this.n = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(r.e(this.f30379a, "tt_bu_video_container"));
            frameLayout.setVisibility(0);
            this.n.findViewById(r.e(this.f30379a, "tt_bu_img_container")).setVisibility(8);
            this.s = (ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_download"));
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f30440a;

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
                    this.f30440a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30440a.a();
                    }
                }
            });
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f30380b.aj())) {
                textView.setText(this.f30380b.aj());
            }
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int i2 = this.f30384f;
                frameLayout.addView(videoView, new ViewGroup.LayoutParams(i2, (i2 * 9) / 16));
            }
            a((View) this, false);
            a((View) textView, true);
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            View inflate = LayoutInflater.from(this.f30379a).inflate(r.f(this.f30379a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
            this.n = inflate;
            inflate.findViewById(r.e(this.f30379a, "tt_bu_video_container")).setVisibility(8);
            this.n.findViewById(r.e(this.f30379a, "tt_bu_img_container")).setVisibility(0);
            this.s = (ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_title"));
            TextView textView = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_download"));
            a((ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_img")));
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f30441a;

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
                    this.f30441a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30441a.a();
                    }
                }
            });
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            if (!TextUtils.isEmpty(this.f30380b.aj())) {
                textView.setText(this.f30380b.aj());
            }
            a((View) this, false);
            a((View) textView, true);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mVar, nativeExpressView, aVar) == null) {
            com.bytedance.sdk.component.utils.j.b("FeedExpressBackupView", "show backup view");
            setBackgroundColor(-1);
            this.f30380b = mVar;
            this.o = nativeExpressView;
            this.p = aVar;
            int d2 = com.bytedance.sdk.openadsdk.r.o.d(mVar.ao());
            this.m = d2;
            b(d2);
            int c2 = com.bytedance.sdk.openadsdk.r.o.c(this.f30380b.ao());
            c(c2);
            e(com.bytedance.sdk.openadsdk.core.h.d().A());
            int i2 = c2 != 9 ? -2 : -1;
            this.o.addView(this, new ViewGroup.LayoutParams(i2, i2));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.openadsdk.theme.a
    public void a_(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.a_(i2);
            e(i2);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.q == null || this.r == null) {
            return;
        }
        int ap = this.f30380b.ap();
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            View inflate = LayoutInflater.from(this.f30379a).inflate(r.f(this.f30379a, "tt_backup_feed_img_small"), (ViewGroup) this, true);
            this.n = inflate;
            this.s = (ImageView) this.n.findViewById(r.e(this.f30379a, "tt_bu_close"));
            this.r = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_desc"));
            this.q = (TextView) this.n.findViewById(r.e(this.f30379a, "tt_bu_title"));
            a((ImageView) inflate.findViewById(r.e(this.f30379a, "tt_bu_img")));
            this.r.setText(getDescription());
            this.q.setText(getTitle());
            this.s.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f30436a;

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
                    this.f30436a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f30436a.a();
                    }
                }
            });
            a((View) this, true);
        }
    }

    private void a(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, imageView) == null) {
            com.bytedance.sdk.openadsdk.g.a.a(this.f30380b.ad().get(0)).a(imageView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, kVar) == null) || (nativeExpressView = this.o) == null) {
            return;
        }
        nativeExpressView.a(i2, kVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public NativeVideoTsView a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new NativeDrawVideoTsView(context, mVar, str, z, z2) : (NativeVideoTsView) invokeCommon.objValue;
    }

    private void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            if (i2 == 1) {
                c();
                this.n.setBackgroundColor(0);
                ImageView imageView = this.s;
                if (imageView != null) {
                    imageView.setImageResource(r.d(getContext(), "tt_dislike_icon_night"));
                    return;
                }
                return;
            }
            b();
            this.n.setBackgroundColor(-1);
            ImageView imageView2 = this.s;
            if (imageView2 != null) {
                imageView2.setImageResource(r.d(getContext(), "tt_dislike_icon2"));
            }
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
