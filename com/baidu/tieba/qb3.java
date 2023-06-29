package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.toast.SingleToast;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.tieba.ub3;
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
/* loaded from: classes7.dex */
public final class qb3 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<sb3> b;
    public static Toast c;
    public static Handler d;
    public static ub3.b e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ RelativeLayout b;

        public a(Context context, RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, relativeLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = qb3.c = new Toast(this.a);
                qb3.c.setView(this.b);
                qb3.c.setGravity(17, 0, 0);
                tb3.k(qb3.c, R.style.obfuscated_res_0x7f10043c);
                try {
                    qb3.c.show();
                } catch (NullPointerException e) {
                    if (qb3.a) {
                        e.printStackTrace();
                    }
                }
                if (qb3.a) {
                    Log.d(SingleToast.TAG, "mSystemToast.show() invoked in show");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ LinearLayout b;

        public b(Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = qb3.c = new Toast(this.a);
                qb3.c.setView(this.b);
                qb3.c.setGravity(17, 0, 0);
                tb3.k(qb3.c, R.style.obfuscated_res_0x7f1003d1);
                qb3.c.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ LinearLayout b;

        public c(Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = qb3.c = new Toast(this.a);
                qb3.c.setView(this.b);
                qb3.c.setGravity(17, 0, 0);
                tb3.k(qb3.c, R.style.obfuscated_res_0x7f1003d1);
                qb3.c.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub3.c a;

        public d(ub3.c cVar) {
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
                ub3.c cVar = this.a;
                if (cVar != null) {
                    cVar.onToastClick();
                }
                qb3.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ToastLocation a;
        public final /* synthetic */ Resources b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ LinearLayout d;

        public e(ToastLocation toastLocation, Resources resources, Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toastLocation, resources, context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = toastLocation;
            this.b = resources;
            this.c = context;
            this.d = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ToastLocation.BOTTOM == this.a) {
                    i = 81;
                    i2 = (int) this.b.getDimension(R.dimen.obfuscated_res_0x7f07011f);
                } else {
                    i = 17;
                    i2 = 0;
                }
                Toast unused = qb3.c = new Toast(this.c);
                qb3.c.setView(this.d);
                qb3.c.setGravity(i, 0, i2);
                tb3.k(qb3.c, R.style.obfuscated_res_0x7f1003d1);
                qb3.c.show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948086023, "Lcom/baidu/tieba/qb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948086023, "Lcom/baidu/tieba/qb3;");
                return;
            }
        }
        a = ms1.a;
        d = new Handler(Looper.getMainLooper());
    }

    public static void d() {
        sb3 sb3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            WeakReference<sb3> weakReference = b;
            if (weakReference != null && (sb3Var = weakReference.get()) != null) {
                sb3Var.s();
            }
            Toast toast = c;
            if (toast != null) {
                toast.cancel();
            }
            ub3.b bVar = e;
            if (bVar != null) {
                bVar.onDismiss();
                e = null;
            }
        }
    }

    public static void f(ub3.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bVar) == null) {
            e = bVar;
        }
    }

    public static void g(sb3 sb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, sb3Var) == null) {
            WeakReference<sb3> weakReference = b;
            if (weakReference != null) {
                weakReference.clear();
            }
            b = new WeakReference<>(sb3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        sb3 sb3Var;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            WeakReference<sb3> weakReference = b;
            if (weakReference != null) {
                sb3Var = weakReference.get();
            } else {
                sb3Var = null;
            }
            Toast toast = c;
            if (sb3Var != null && sb3Var.u()) {
                z = true;
            } else {
                z = false;
            }
            if (toast != null && toast.getView() != null && toast.getView().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || z2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void h(@NonNull Context context, @NonNull CharSequence charSequence, int i, boolean z, int i2, boolean z2) {
        TextView textView;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00c4, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801be));
            boolean z4 = true;
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091957)) != null) {
                textView.setTextColor(-1);
                textView.setText(charSequence);
                if (i2 >= 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                textView.setSingleLine((z3 || !z) ? false : false);
                if (z3) {
                    textView.setMaxLines(i2);
                    textView.setGravity(17);
                }
            }
            if (tb3.n(applicationContext)) {
                d.post(new a(applicationContext, relativeLayout));
                return;
            }
            sb3 sb3Var = new sb3(applicationContext);
            g(sb3Var);
            sb3Var.z(relativeLayout);
            sb3Var.x(z2);
            sb3Var.w(17, 0, 0);
            sb3Var.v(i);
            sb3Var.A(R.style.obfuscated_res_0x7f10043c);
            sb3Var.y(e);
            e = null;
            sb3Var.B();
        }
    }

    public static void i(Context context, CharSequence charSequence, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00de, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
            linearLayout.findViewById(R.id.obfuscated_res_0x7f090f25).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f26);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801e1));
            linearLayout.setClickable(true);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f27);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601db));
            }
            if (tb3.n(applicationContext)) {
                d.post(new c(context, linearLayout));
                return;
            }
            sb3 sb3Var = new sb3(applicationContext);
            g(sb3Var);
            sb3Var.z(linearLayout);
            sb3Var.x(z);
            sb3Var.w(17, 0, 0);
            sb3Var.v(i);
            sb3Var.A(R.style.obfuscated_res_0x7f1003d1);
            sb3Var.B();
        }
    }

    public static void j(@NonNull Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view2, int i, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65546, null, new Object[]{context, charSequence, drawable, view2, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00de, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f27)) != null) {
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601db));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f25);
        if (imageView != null) {
            if (view2 != null) {
                new xb3(applicationContext).a(imageView, view2);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f08018d);
                }
                tb3.j(drawable);
                imageView.setImageDrawable(drawable);
            }
        }
        if (tb3.n(applicationContext)) {
            d.post(new b(context, linearLayout));
            return;
        }
        sb3 sb3Var = new sb3(applicationContext);
        g(sb3Var);
        sb3Var.z(linearLayout);
        sb3Var.x(z);
        sb3Var.w(17, 0, 0);
        sb3Var.v(i);
        sb3Var.A(R.style.obfuscated_res_0x7f1003d1);
        sb3Var.B();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i, @NonNull ToastLocation toastLocation, @Nullable ub3.c cVar, boolean z) {
        float f;
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{context, uri, drawable, view2, charSequence, charSequence2, Integer.valueOf(i), toastLocation, cVar, Boolean.valueOf(z)}) != null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00dc, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0914b5);
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0914c1);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091ee0);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091ee1);
        View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091ee2);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(rb3.a);
            if (uri == null && drawable == null && view2 == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(wb3.a(context, 200.0f));
            } else {
                boolean z2 = true;
                if (view2 != null) {
                    simpleDraweeView.setVisibility(0);
                    new xb3(applicationContext).a(simpleDraweeView, view2);
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
                    layoutParams.setMargins(wb3.a(context, f), wb3.a(context, 9.0f), wb3.a(context, 14.0f), wb3.a(context, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        ((ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091ed7)).setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801e2));
                        textView2.setText(charSequence2);
                        textView2.setTextColor(rb3.a);
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f0601c1));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new d(cVar));
                            tb3.i(linearLayout2);
                        }
                        if (!tb3.n(applicationContext)) {
                            d.post(new e(toastLocation2, resources, context, linearLayout));
                            return;
                        }
                        sb3 sb3Var = new sb3(applicationContext);
                        g(sb3Var);
                        sb3Var.z(linearLayout);
                        sb3Var.x(z);
                        sb3Var.w(17, 0, 0);
                        sb3Var.v(i);
                        sb3Var.A(R.style.obfuscated_res_0x7f1003d1);
                        sb3Var.B();
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        tb3.j(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                if (!z2) {
                }
                layoutParams2.setMargins(wb3.a(context, f), wb3.a(context, 9.0f), wb3.a(context, 14.0f), wb3.a(context, 10.0f));
                textView.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            if (!tb3.n(applicationContext)) {
            }
        } else {
            tb3.h("has no main text");
        }
    }
}
