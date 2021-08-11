package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66754a;
    public int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeDrawVideoTsView(@NonNull Context context, @NonNull m mVar) {
        super(context, mVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66754a = false;
        setOnClickListener(this);
        this.p = getResources().getConfiguration().orientation;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            s.a((View) this.f66762f, 0);
            s.a((View) this.f66763g, 0);
            s.a((View) this.f66765i, 8);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            h();
            RelativeLayout relativeLayout = this.f66762f;
            if (relativeLayout != null) {
                if (relativeLayout.getVisibility() == 0) {
                    return;
                }
                ImageLoaderWrapper.from(this.f66758b.V().h()).to(this.f66763g);
            }
            e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f66761e = false;
            this.k = "draw_ad";
            o.h().r(String.valueOf(q.d(this.f66758b.ao())));
            super.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f66754a) {
            super.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = getResources().getConfiguration().orientation;
            if (this.p != i2) {
                this.p = i2;
                s.a(this, new s.a(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NativeDrawVideoTsView f66756a;

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
                        this.f66756a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.q.s.a
                    public void a(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            NativeDrawVideoTsView nativeDrawVideoTsView = this.f66756a;
                            if (nativeDrawVideoTsView.f66759c == null) {
                                return;
                            }
                            this.f66756a.a(nativeDrawVideoTsView.getWidth(), this.f66756a.getHeight());
                            NativeDrawVideoTsView.super.d();
                        }
                    }
                });
                return;
            }
            super.d();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            ImageView imageView = this.f66764h;
            if (imageView != null && imageView.getVisibility() == 0) {
                s.e(this.f66762f);
            }
            c();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            int i2 = this.p;
            int i3 = configuration.orientation;
            if (i2 == i3) {
                return;
            }
            this.p = i3;
            s.a(this, new s.a(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NativeDrawVideoTsView f66755a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66755a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.q.s.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        NativeDrawVideoTsView nativeDrawVideoTsView = this.f66755a;
                        if (nativeDrawVideoTsView.f66759c == null) {
                            return;
                        }
                        this.f66755a.a(nativeDrawVideoTsView.getWidth(), this.f66755a.getHeight());
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            ImageView imageView = this.f66764h;
            if (imageView != null && imageView.getVisibility() == 0) {
                f();
            } else {
                super.onWindowFocusChanged(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ImageView imageView = this.f66764h;
            if (imageView != null && imageView.getVisibility() == 0) {
                f();
            } else {
                super.onWindowVisibilityChanged(i2);
            }
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f66754a = z;
        }
    }

    public void a(Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, i2) == null) {
            com.bytedance.sdk.openadsdk.core.h.d().a(bitmap);
            this.l = i2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public c a(Context context, ViewGroup viewGroup, m mVar, String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, viewGroup, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) ? new f(context, viewGroup, mVar, str, z, z2, z3) : (c) invokeCommon.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeDrawVideoTsView(@NonNull Context context, @NonNull m mVar, String str, boolean z, boolean z2) {
        super(context, mVar, str, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66754a = false;
        setOnClickListener(this);
        this.p = getResources().getConfiguration().orientation;
    }
}
