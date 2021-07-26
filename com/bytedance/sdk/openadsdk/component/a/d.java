package com.bytedance.sdk.openadsdk.component.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.r;
import com.bytedance.sdk.openadsdk.q.s;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes5.dex */
public class d extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f29389a;

    /* renamed from: b  reason: collision with root package name */
    public c f29390b;

    /* renamed from: c  reason: collision with root package name */
    public c f29391c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f29392d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f29393e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f29394f;

    /* renamed from: g  reason: collision with root package name */
    public int f29395g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29396h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29397i;
    public boolean j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull Context context) {
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
        this.f29397i = false;
        this.j = false;
        this.f29389a = context;
        g();
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            c cVar = new c(this.f29389a);
            this.f29390b = cVar;
            addView(cVar, new FrameLayout.LayoutParams(-1, -1));
            i();
            h();
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.j) {
            return;
        }
        this.j = true;
        ImageView imageView = new ImageView(this.f29389a);
        this.f29392d = imageView;
        imageView.setImageResource(t.d(o.a(), "tt_dislike_icon"));
        this.f29392d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f29392d.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f29398a;

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
                this.f29398a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f29398a.f29394f == null) {
                    return;
                }
                this.f29398a.f29394f.showDislikeDialog();
            }
        });
        int b2 = (int) s.b(this.f29389a, 15.0f);
        int b3 = (int) s.b(this.f29389a, 10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.topMargin = b3;
        layoutParams.rightMargin = b3;
        addView(this.f29392d, layoutParams);
        s.a(this.f29392d, b2, b2, b2, b2);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.f29397i) {
            return;
        }
        this.f29397i = true;
        ImageView imageView = new ImageView(this.f29389a);
        this.f29393e = imageView;
        imageView.setImageResource(t.d(o.a(), "tt_ad_logo_new"));
        this.f29393e.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        addView(this.f29393e, layoutParams);
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            ImageView imageView = this.f29393e;
            if (imageView != null) {
                bringChildToFront(imageView);
            }
            ImageView imageView2 = this.f29392d;
            if (imageView2 != null) {
                bringChildToFront(imageView2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            c cVar = this.f29390b;
            this.f29390b = this.f29391c;
            this.f29391c = cVar;
            cVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, layoutParams) == null) {
            super.addView(view, layoutParams);
            j();
        }
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f29391c : (c) invokeV.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f29392d : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f29396h) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(this.f29390b)).with(b(this.f29391c));
        animatorSet.setDuration(this.f29395g).start();
        this.f29391c.setVisibility(0);
        this.f29396h = true;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c cVar = this.f29391c;
            return (cVar == null || cVar.a() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            this.f29397i = false;
            this.j = false;
        }
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29390b : (c) invokeV.objValue;
    }

    private ObjectAnimator b(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, cVar)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "translationX", getWidth(), 0.0f);
            ofFloat.addListener(new Animator.AnimatorListener(this, cVar) { // from class: com.bytedance.sdk.openadsdk.component.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f29399a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f29400b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29400b = this;
                    this.f29399a = cVar;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.f29400b.f29396h = false;
                        this.f29400b.k();
                        c cVar2 = this.f29399a;
                        if (cVar2 != null) {
                            this.f29400b.a(cVar2.a());
                        }
                        k.b("TTBannerAd", "SLIDE END");
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                        k.b("TTBannerAd", "SLIDE START");
                    }
                }
            });
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.addView(view);
            j();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c cVar = new c(this.f29389a);
            this.f29391c = cVar;
            cVar.setVisibility(8);
            addView(this.f29391c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, view, i2) == null) {
            super.addView(view, i2);
            j();
        }
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.ui.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f29394f = aVar;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, view, i2, i3) == null) {
            super.addView(view, i2, i3);
            j();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f29395g = i2;
        }
    }

    private ObjectAnimator a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cVar)) == null) ? ObjectAnimator.ofFloat(cVar, "translationX", 0.0f, -getWidth()) : (ObjectAnimator) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, view, i2, layoutParams) == null) {
            super.addView(view, i2, layoutParams);
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        com.bytedance.sdk.openadsdk.dislike.ui.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, mVar) == null) || (aVar = this.f29394f) == null || mVar == null) {
            return;
        }
        aVar.a(mVar.aG());
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            r.a(this.f29393e, str);
        }
    }
}
