package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes5.dex */
public class SplashExpressBackupView extends BackupView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NativeExpressView l;
    public View m;
    public ImageView n;
    public TextView o;
    public Button p;
    public FrameLayout q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashExpressBackupView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30379a = context;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
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
            com.bytedance.sdk.component.utils.j.b("SplashExpressBackupView", "image mode: " + this.f30380b.ap());
            c(this.f30380b.ap());
        }
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            if (i2 != 2) {
                if (i2 == 3) {
                    d();
                    return;
                } else if (i2 != 4) {
                    if (i2 == 5) {
                        e();
                        return;
                    } else if (i2 != 15) {
                        g();
                        return;
                    } else {
                        f();
                        return;
                    }
                }
            }
            c();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            h();
            this.n.setVisibility(0);
            this.q.setVisibility(8);
            a(this.n);
            this.o.setText(this.f30380b.ai());
            this.p.setText(this.f30380b.aj());
            a((View) this, false);
            a((View) this.p, true);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            h();
            this.n.setVisibility(8);
            this.q.setVisibility(0);
            if (this.f30380b.V() != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                this.q.addView((NativeVideoTsView) getVideoView(), layoutParams);
            }
            this.o.setText(this.f30380b.ai());
            this.p.setText(this.f30380b.aj());
            a((View) this, false);
            a((View) this.p, true);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            addView((NativeVideoTsView) getVideoView());
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ImageView imageView = new ImageView(this.f30379a);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            a(imageView);
            addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            View inflate = LayoutInflater.from(this.f30379a).inflate(r.f(this.f30379a, "tt_backup_splash"), (ViewGroup) this, true);
            this.m = inflate;
            this.n = (ImageView) inflate.findViewById(r.e(this.f30379a, "tt_splash_backup_img"));
            this.o = (TextView) this.m.findViewById(r.e(this.f30379a, "tt_splash_backup_desc"));
            this.q = (FrameLayout) this.m.findViewById(r.e(this.f30379a, "tt_splash_backup_video_container"));
            this.p = (Button) this.m.findViewById(r.e(this.f30379a, "tt_splash_backup_text"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || (nativeExpressView = this.l) == null) {
            return;
        }
        nativeExpressView.a(i2, kVar);
    }

    public void a(@NonNull com.bytedance.sdk.openadsdk.core.e.m mVar, NativeExpressView nativeExpressView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, nativeExpressView) == null) {
            this.f30380b = mVar;
            this.l = nativeExpressView;
            this.f30384f = q.d(this.f30379a, nativeExpressView.getExpectExpressWidth());
            this.f30385g = q.d(this.f30379a, this.l.getExpectExpressWidth());
            b();
            this.l.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            h();
            this.n.setVisibility(0);
            this.q.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            layoutParams.height = q.d(this.f30379a, 291.0f);
            this.n.setLayoutParams(layoutParams);
            a(this.n);
            this.o.setText(this.f30380b.ai());
            this.p.setText(this.f30380b.aj());
            a((View) this, false);
            a((View) this.p, true);
        }
    }

    private void a(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, imageView) == null) || this.f30380b.ad().get(0) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.e.b().a(this.f30380b.ad().get(0).a(), imageView);
    }
}
