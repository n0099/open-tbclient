package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.baidu.tieba.y83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class z83 {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference<View> a;
    public static Runnable b;
    public static y83.b c;
    @SuppressLint({"StaticFieldLeak"})
    public static View d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948313780, "Lcom/baidu/tieba/z83;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948313780, "Lcom/baidu/tieba/z83;");
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ View b;

        /* renamed from: com.baidu.tieba.z83$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class animation.Animation$AnimationListenerC0512a implements Animation.AnimationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                }
            }

            /* renamed from: com.baidu.tieba.z83$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0513a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ animation.Animation$AnimationListenerC0512a a;

                public RunnableC0513a(animation.Animation$AnimationListenerC0512a animation_animation_animationlistenerc0512a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {animation_animation_animationlistenerc0512a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = animation_animation_animationlistenerc0512a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.a.getParent() != null) {
                        ((ViewGroup) this.a.a.a.getParent()).removeView(this.a.a.a);
                    }
                }
            }

            /* renamed from: com.baidu.tieba.z83$a$a$b */
            /* loaded from: classes8.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ animation.Animation$AnimationListenerC0512a a;

                public b(animation.Animation$AnimationListenerC0512a animation_animation_animationlistenerc0512a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {animation_animation_animationlistenerc0512a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = animation_animation_animationlistenerc0512a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    View view2;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (view2 = this.a.a.b) != null && view2.getParent() != null && (this.a.a.b.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.a.b.getParent()).removeView(this.a.a.b);
                    }
                }
            }

            public animation.Animation$AnimationListenerC0512a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    if (this.a.a.getParent() instanceof ViewGroup) {
                        this.a.a.post(new RunnableC0513a(this));
                    }
                    View view2 = this.a.b;
                    if (view2 != null) {
                        view2.post(new b(this));
                    }
                }
            }
        }

        public a(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WeakReference weakReference = new WeakReference(this.a.getContext());
                if (weakReference.get() == null) {
                    return;
                }
                Animation loadAnimation = AnimationUtils.loadAnimation((Context) weakReference.get(), R.anim.obfuscated_res_0x7f010029);
                loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0512a(this));
                this.a.startAnimation(loadAnimation);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83.c a;

        public b(y83.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                y83.c cVar = this.a;
                if (cVar != null) {
                    cVar.onToastClick();
                }
                z83.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y83.c a;

        public c(y83.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                y83.c cVar = this.a;
                if (cVar != null) {
                    cVar.onToastClick();
                }
                z83.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ View c;
        public final /* synthetic */ FrameLayout.LayoutParams d;
        public final /* synthetic */ Animation e;

        public d(View view2, Context context, View view3, FrameLayout.LayoutParams layoutParams, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, context, view3, layoutParams, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = context;
            this.c = view3;
            this.d = layoutParams;
            this.e = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (z83.e && this.a != null) {
                    if (z83.d != null && (z83.d.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) z83.d.getParent()).removeView(z83.d);
                    }
                    Context context = this.b;
                    if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                        return;
                    }
                    FrameLayout frameLayout = new FrameLayout(this.b);
                    frameLayout.setClickable(true);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.topMargin = y83.c(this.b);
                    View view3 = this.a;
                    if (view3 instanceof ViewGroup) {
                        ((ViewGroup) view3).addView(frameLayout, layoutParams);
                        View unused = z83.d = frameLayout;
                    }
                }
                if (z83.a != null && (view2 = (View) z83.a.get()) != null && (view2.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                Context context2 = this.b;
                if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                    return;
                }
                ((ViewGroup) this.a).addView(this.c, this.d);
                this.c.startAnimation(this.e);
                WeakReference unused2 = z83.a = new WeakReference(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z83.h();
            }
        }
    }

    public static boolean k() {
        InterceptResult invokeV;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            WeakReference<View> weakReference = a;
            if (weakReference == null || (view2 = weakReference.get()) == null || view2.getParent() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void l(y83.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bVar) == null) {
            c = bVar;
        }
    }

    public static void f(View view2, View view3, int i, FrameLayout.LayoutParams layoutParams, @AnimRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{view2, view3, Integer.valueOf(i), layoutParams, Integer.valueOf(i2)}) == null) && view2 != null && view3 != null) {
            g(view2, view3, i, layoutParams, AnimationUtils.loadAnimation(view2.getContext(), i2));
        }
    }

    public static void g(View view2, View view3, int i, FrameLayout.LayoutParams layoutParams, Animation animation) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{view2, view3, Integer.valueOf(i), layoutParams, animation}) == null) && view2 != null && view3 != null) {
            Context context = view2.getContext();
            if (view3.getParent() instanceof ViewGroup) {
                ((ViewGroup) view3.getParent()).removeView(view3);
            }
            view3.setClickable(true);
            if (view2 instanceof ViewGroup) {
                view2.post(new d(view2, context, view3, layoutParams, animation));
                if (b == null) {
                    b = new e();
                }
                f93.M().postDelayed(b, i * 1000);
            }
        }
    }

    public static synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            synchronized (z83.class) {
                if (a != null) {
                    View view2 = a.get();
                    if (view2 != null) {
                        view2.post(new a(view2, d));
                        if (b != null) {
                            view2.removeCallbacks(b);
                        }
                    }
                    if (b != null) {
                        f93.M().removeCallbacks(b);
                    }
                    b = null;
                    a = null;
                    d = null;
                    if (c != null) {
                        c.onDismiss();
                        c = null;
                    }
                }
            }
        }
    }

    public static View i(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, activity)) == null) {
            if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                return activity.getWindow().getDecorView().findViewById(16908290);
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static View j(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                return activity.getWindow().getDecorView();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static void m(Activity activity, CharSequence charSequence, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{activity, charSequence, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Resources resources = ns2.c().getResources();
            e = z;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d00de, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
            linearLayout.findViewById(R.id.obfuscated_res_0x7f090f08).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f09);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801e1));
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f0a);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601d7));
                textView.setText(charSequence);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            f(i(activity), linearLayout, i, layoutParams, R.anim.obfuscated_res_0x7f01001c);
        }
    }

    public static void n(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{activity, charSequence, drawable, view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Resources resources = activity.getResources();
            e = z;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d00de, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f0a);
            if (textView != null && !TextUtils.isEmpty(charSequence)) {
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601d7));
                textView.setText(charSequence);
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f08);
            if (imageView != null) {
                if (view2 != null) {
                    new b93(activity).a(imageView, view2);
                } else {
                    if (drawable == null) {
                        drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f08018d);
                    }
                    x83.j(drawable);
                    imageView.setImageDrawable(drawable);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070152), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070150));
            layoutParams.gravity = 17;
            f(i(activity), linearLayout, i, layoutParams, R.anim.obfuscated_res_0x7f01001c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i, @NonNull ToastLocation toastLocation, @Nullable y83.c cVar, boolean z) {
        float f;
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65551, null, new Object[]{activity, uri, drawable, view2, charSequence, charSequence2, Integer.valueOf(i), toastLocation, cVar, Boolean.valueOf(z)}) != null) || activity == null) {
            return;
        }
        Resources resources = ns2.c().getResources();
        View i2 = i(activity);
        if (i2 == null) {
            return;
        }
        e = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d00dc, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091488);
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091493);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091e4b);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091e4c);
        View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091e4d);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(v83.a);
            if (uri == null && drawable == null && view2 == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(a93.a(activity, 200.0f));
            } else {
                boolean z2 = true;
                if (view2 != null) {
                    simpleDraweeView.setVisibility(0);
                    new b93(activity).a(simpleDraweeView, view2);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (!z2) {
                        f = 14.0f;
                    } else {
                        f = 5.0f;
                    }
                    layoutParams.setMargins(a93.a(activity, f), a93.a(activity, 9.0f), a93.a(activity, 14.0f), a93.a(activity, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        ((ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091e43)).setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801e2));
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        textView2.setText(charSequence2);
                        textView2.setTextColor(v83.a);
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f0601bd));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new b(cVar));
                            x83.i(linearLayout2);
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                        if (ToastLocation.BOTTOM != toastLocation2) {
                            layoutParams2.gravity = 81;
                            layoutParams2.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f07011f);
                        } else {
                            layoutParams2.gravity = 17;
                        }
                        f(i2, linearLayout, i, layoutParams2, R.anim.obfuscated_res_0x7f010028);
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        x83.j(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                if (!z2) {
                }
                layoutParams3.setMargins(a93.a(activity, f), a93.a(activity, 9.0f), a93.a(activity, 14.0f), a93.a(activity, 10.0f));
                textView.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(-2, -2);
            if (ToastLocation.BOTTOM != toastLocation2) {
            }
            f(i2, linearLayout, i, layoutParams22, R.anim.obfuscated_res_0x7f010028);
            return;
        }
        x83.h("has no main text");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: android.widget.LinearLayout */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable ToastRightAreaStyle toastRightAreaStyle, int i, boolean z, y83.c cVar) {
        View i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65552, null, new Object[]{activity, uri, drawable, view2, charSequence, charSequence2, charSequence3, toastRightAreaStyle, Integer.valueOf(i), Boolean.valueOf(z), cVar}) != null) || activity == null) {
            return;
        }
        Resources resources = ns2.c().getResources();
        if (z) {
            i2 = j(activity);
        } else {
            i2 = i(activity);
        }
        if (i2 == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d00dd, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
        boolean z2 = true;
        linearLayout.setClickable(true);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f092374);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091487);
        simpleDraweeView.setVisibility(0);
        if (view2 != null) {
            new b93(activity).a(simpleDraweeView, view2);
        } else if (drawable != null) {
            x83.j(drawable);
            simpleDraweeView.setImageDrawable(drawable);
        } else if (uri != null) {
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
        } else {
            simpleDraweeView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(a93.a(activity, 15.0f), 0, 0, 0);
            linearLayout2.setLayoutParams(layoutParams);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09246f);
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0921e6);
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09191f);
            if (TextUtils.isEmpty(charSequence)) {
                if (!TextUtils.isEmpty(charSequence2)) {
                    if (z2) {
                        textView.setMaxWidth(a93.a(activity, 175.0f));
                        textView2.setMaxWidth(a93.a(activity, 175.0f));
                    }
                    textView.setText(charSequence);
                    textView2.setText(charSequence2);
                    textView.setVisibility(0);
                    textView2.setVisibility(0);
                    textView.setTextColor(v83.a);
                    textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601c1));
                    textView3.setVisibility(8);
                } else {
                    if (z2) {
                        textView3.setMaxWidth(a93.a(activity, 175.0f));
                    }
                    textView3.setText(charSequence);
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    textView3.setVisibility(0);
                    textView3.setTextColor(v83.a);
                }
                FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f09049f);
                LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f0911e7);
                TextView textView4 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0904df);
                textView4.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801dd));
                TextView textView5 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0911ea);
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0911ed);
                View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091e4d);
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (toastRightAreaStyle == ToastRightAreaStyle.BUTTON) {
                        frameLayout.setVisibility(0);
                        linearLayout3.setVisibility(8);
                        textView4.setText(charSequence3);
                        textView4.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601d7));
                    } else {
                        linearLayout3.setVisibility(0);
                        frameLayout.setVisibility(8);
                        textView5.setText(charSequence3);
                        textView5.setTextColor(v83.a);
                        imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801e2));
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f0601bd));
                        frameLayout = linearLayout3;
                    }
                    if (frameLayout != null) {
                        frameLayout.setOnClickListener(new c(cVar));
                        x83.i(frameLayout);
                    }
                } else {
                    frameLayout.setVisibility(8);
                    linearLayout3.setVisibility(8);
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 81;
                layoutParams2.bottomMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f07011f);
                f(i(activity), linearLayout, i, layoutParams2, R.anim.obfuscated_res_0x7f010028);
                return;
            }
            x83.h("has no main text");
            return;
        }
        z2 = false;
        TextView textView6 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09246f);
        TextView textView22 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0921e6);
        TextView textView32 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09191f);
        if (TextUtils.isEmpty(charSequence)) {
        }
    }
}
