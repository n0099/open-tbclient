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
import com.baidu.tieba.qa3;
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
public final class ma3 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<oa3> b;
    public static Toast c;
    public static Handler d;
    public static qa3.b e;
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
                Toast unused = ma3.c = new Toast(this.a);
                ma3.c.setView(this.b);
                ma3.c.setGravity(17, 0, 0);
                pa3.k(ma3.c, R.style.obfuscated_res_0x7f10043e);
                try {
                    ma3.c.show();
                } catch (NullPointerException e) {
                    if (ma3.a) {
                        e.printStackTrace();
                    }
                }
                if (ma3.a) {
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
                Toast unused = ma3.c = new Toast(this.a);
                ma3.c.setView(this.b);
                ma3.c.setGravity(17, 0, 0);
                pa3.k(ma3.c, R.style.obfuscated_res_0x7f1003d4);
                ma3.c.show();
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
                Toast unused = ma3.c = new Toast(this.a);
                ma3.c.setView(this.b);
                ma3.c.setGravity(17, 0, 0);
                pa3.k(ma3.c, R.style.obfuscated_res_0x7f1003d4);
                ma3.c.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qa3.c a;

        public d(qa3.c cVar) {
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
                qa3.c cVar = this.a;
                if (cVar != null) {
                    cVar.onToastClick();
                }
                ma3.d();
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
                Toast unused = ma3.c = new Toast(this.c);
                ma3.c.setView(this.d);
                ma3.c.setGravity(i, 0, i2);
                pa3.k(ma3.c, R.style.obfuscated_res_0x7f1003d4);
                ma3.c.show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947965898, "Lcom/baidu/tieba/ma3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947965898, "Lcom/baidu/tieba/ma3;");
                return;
            }
        }
        a = ir1.a;
        d = new Handler(Looper.getMainLooper());
    }

    public static void d() {
        oa3 oa3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            WeakReference<oa3> weakReference = b;
            if (weakReference != null && (oa3Var = weakReference.get()) != null) {
                oa3Var.s();
            }
            Toast toast = c;
            if (toast != null) {
                toast.cancel();
            }
            qa3.b bVar = e;
            if (bVar != null) {
                bVar.onDismiss();
                e = null;
            }
        }
    }

    public static void f(qa3.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bVar) == null) {
            e = bVar;
        }
    }

    public static void g(oa3 oa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, oa3Var) == null) {
            WeakReference<oa3> weakReference = b;
            if (weakReference != null) {
                weakReference.clear();
            }
            b = new WeakReference<>(oa3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        oa3 oa3Var;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            WeakReference<oa3> weakReference = b;
            if (weakReference != null) {
                oa3Var = weakReference.get();
            } else {
                oa3Var = null;
            }
            Toast toast = c;
            if (oa3Var != null && oa3Var.u()) {
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
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00c3, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801be));
            boolean z4 = true;
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091981)) != null) {
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
            if (pa3.n(applicationContext)) {
                d.post(new a(applicationContext, relativeLayout));
                return;
            }
            oa3 oa3Var = new oa3(applicationContext);
            g(oa3Var);
            oa3Var.z(relativeLayout);
            oa3Var.x(z2);
            oa3Var.w(17, 0, 0);
            oa3Var.v(i);
            oa3Var.A(R.style.obfuscated_res_0x7f10043e);
            oa3Var.y(e);
            e = null;
            oa3Var.B();
        }
    }

    public static void i(Context context, CharSequence charSequence, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00dd, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
            linearLayout.findViewById(R.id.obfuscated_res_0x7f090f47).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f48);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801e1));
            linearLayout.setClickable(true);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f49);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601db));
            }
            if (pa3.n(applicationContext)) {
                d.post(new c(context, linearLayout));
                return;
            }
            oa3 oa3Var = new oa3(applicationContext);
            g(oa3Var);
            oa3Var.z(linearLayout);
            oa3Var.x(z);
            oa3Var.w(17, 0, 0);
            oa3Var.v(i);
            oa3Var.A(R.style.obfuscated_res_0x7f1003d4);
            oa3Var.B();
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00dd, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f49)) != null) {
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601db));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090f47);
        if (imageView != null) {
            if (view2 != null) {
                new ta3(applicationContext).a(imageView, view2);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f08018d);
                }
                pa3.j(drawable);
                imageView.setImageDrawable(drawable);
            }
        }
        if (pa3.n(applicationContext)) {
            d.post(new b(context, linearLayout));
            return;
        }
        oa3 oa3Var = new oa3(applicationContext);
        g(oa3Var);
        oa3Var.z(linearLayout);
        oa3Var.x(z);
        oa3Var.w(17, 0, 0);
        oa3Var.v(i);
        oa3Var.A(R.style.obfuscated_res_0x7f1003d4);
        oa3Var.B();
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
    public static void k(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i, @NonNull ToastLocation toastLocation, @Nullable qa3.c cVar, boolean z) {
        float f;
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{context, uri, drawable, view2, charSequence, charSequence2, Integer.valueOf(i), toastLocation, cVar, Boolean.valueOf(z)}) != null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00db, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801df));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0914dc);
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0914e8);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f2f);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f30);
        View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091f31);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(na3.a);
            if (uri == null && drawable == null && view2 == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(sa3.a(context, 200.0f));
            } else {
                boolean z2 = true;
                if (view2 != null) {
                    simpleDraweeView.setVisibility(0);
                    new ta3(applicationContext).a(simpleDraweeView, view2);
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
                    layoutParams.setMargins(sa3.a(context, f), sa3.a(context, 9.0f), sa3.a(context, 14.0f), sa3.a(context, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        ((ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f26)).setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801e2));
                        textView2.setText(charSequence2);
                        textView2.setTextColor(na3.a);
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f0601c1));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new d(cVar));
                            pa3.i(linearLayout2);
                        }
                        if (!pa3.n(applicationContext)) {
                            d.post(new e(toastLocation2, resources, context, linearLayout));
                            return;
                        }
                        oa3 oa3Var = new oa3(applicationContext);
                        g(oa3Var);
                        oa3Var.z(linearLayout);
                        oa3Var.x(z);
                        oa3Var.w(17, 0, 0);
                        oa3Var.v(i);
                        oa3Var.A(R.style.obfuscated_res_0x7f1003d4);
                        oa3Var.B();
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        pa3.j(drawable);
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
                layoutParams2.setMargins(sa3.a(context, f), sa3.a(context, 9.0f), sa3.a(context, 14.0f), sa3.a(context, 10.0f));
                textView.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            if (!pa3.n(applicationContext)) {
            }
        } else {
            pa3.h("has no main text");
        }
    }
}
