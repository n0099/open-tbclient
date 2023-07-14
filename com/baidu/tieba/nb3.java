package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.baidu.swan.apps.res.widget.toast.ToastTemplate;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public CharSequence b;
    public CharSequence c;
    public CharSequence d;
    public Drawable e;
    public Drawable f;
    public Uri g;
    public int h;
    public int i;
    public c j;
    public int k;
    public b l;
    public boolean m;
    public View n;
    public ToastRightAreaStyle o;
    public CharSequence p;
    public CharSequence q;
    public ToastLocation r;
    public ToastTemplate s;
    public boolean t;

    /* loaded from: classes7.dex */
    public interface b {
        void onDismiss();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void onToastClick();
    }

    @Deprecated
    public nb3 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? this : (nb3) invokeI.objValue;
    }

    public nb3 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this : (nb3) invokeI.objValue;
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-580979443, "Lcom/baidu/tieba/nb3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-580979443, "Lcom/baidu/tieba/nb3$a;");
                    return;
                }
            }
            int[] iArr = new int[ToastTemplate.values().length];
            a = iArr;
            try {
                iArr[ToastTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ToastTemplate.T2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ToastTemplate.T3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ToastTemplate.T4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947996650, "Lcom/baidu/tieba/nb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947996650, "Lcom/baidu/tieba/nb3;");
                return;
            }
        }
        u = fs1.a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            jb3.d();
            ob3.h();
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!jb3.e() && !ob3.k()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C(false);
        }
    }

    @Deprecated
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            E(false);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !b()) {
            return;
        }
        a();
        jb3.h(this.a, this.b, this.h, false, this.i, this.m);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            H(false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            J(false);
        }
    }

    @Deprecated
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            x(false, false);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            A(false);
        }
    }

    public nb3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 2;
        this.o = ToastRightAreaStyle.JUMP;
        this.r = ToastLocation.MIDDLE;
        this.s = ToastTemplate.T1;
        this.t = false;
        this.a = context;
        this.h = 2;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || !b()) {
            return;
        }
        a();
        if (!z) {
            Context context = this.a;
            if (context instanceof Activity) {
                ob3.m((Activity) context, this.b, this.h, this.m);
                return;
            }
        }
        jb3.i(this.a, this.b, this.h, this.m);
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || !b()) {
            return;
        }
        a();
        if (!z) {
            Context context = this.a;
            if (context instanceof Activity) {
                ob3.n((Activity) context, this.b, this.e, this.n, this.h, this.m);
                return;
            }
        }
        jb3.j(this.a, this.b, this.e, this.n, this.h, this.m);
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048585, this, z) != null) || !b()) {
            return;
        }
        a();
        if (!z) {
            Context context = this.a;
            if (context instanceof Activity) {
                ob3.o((Activity) context, null, null, null, this.b, null, this.h, ToastLocation.BOTTOM, this.j, this.m);
                return;
            }
        }
        y(this.a, this.b);
    }

    public static int c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return mp3.t() + ((int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070160));
        }
        return invokeL.intValue;
    }

    public static nb3 e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return new nb3(context);
        }
        return (nb3) invokeL.objValue;
    }

    @Deprecated
    public nb3 j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (nb3) invokeI.objValue;
    }

    public nb3 k(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
            this.d = charSequence;
            return this;
        }
        return (nb3) invokeL.objValue;
    }

    public nb3 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            this.h = Math.max(i, 1);
            return this;
        }
        return (nb3) invokeI.objValue;
    }

    public nb3 m(@DrawableRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            Context context = this.a;
            if (context != null && context.getResources() != null) {
                this.e = this.a.getResources().getDrawable(i);
            }
            return this;
        }
        return (nb3) invokeI.objValue;
    }

    public nb3 n(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) {
            this.e = drawable;
            return this;
        }
        return (nb3) invokeL.objValue;
    }

    public nb3 o(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            this.g = uri;
            return this;
        }
        return (nb3) invokeL.objValue;
    }

    public nb3 p(ToastLocation toastLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, toastLocation)) == null) {
            this.r = toastLocation;
            return this;
        }
        return (nb3) invokeL.objValue;
    }

    public nb3 q(@NonNull int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (nb3) invokeI.objValue;
    }

    public nb3 r(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
            this.b = charSequence;
            return this;
        }
        return (nb3) invokeL.objValue;
    }

    public nb3 s(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.m = z;
            return this;
        }
        return (nb3) invokeZ.objValue;
    }

    public nb3 t(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, charSequence)) == null) {
            this.c = charSequence;
            return this;
        }
        return (nb3) invokeL.objValue;
    }

    public nb3 u(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, cVar)) == null) {
            this.j = cVar;
            return this;
        }
        return (nb3) invokeL.objValue;
    }

    public static nb3 f(@NonNull Context context, @StringRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            nb3 nb3Var = new nb3(context);
            nb3Var.b = context.getText(i);
            return nb3Var;
        }
        return (nb3) invokeLI.objValue;
    }

    public static nb3 g(@NonNull Context context, @NonNull CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, charSequence)) == null) {
            nb3 nb3Var = new nb3(context);
            nb3Var.b = charSequence;
            return nb3Var;
        }
        return (nb3) invokeLL.objValue;
    }

    public final void y(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048604, this, context, charSequence) != null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        jb3.k(context, null, null, null, charSequence, null, this.h, this.r, null, this.m);
    }

    @Deprecated
    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || !b()) {
            return;
        }
        a();
        if (z) {
            y(this.a, this.c);
        } else if (this.a instanceof Activity) {
            b bVar = this.l;
            if (bVar != null) {
                ob3.l(bVar);
                this.l = null;
            }
            if (1 == this.k) {
                this.o = ToastRightAreaStyle.JUMP;
            } else {
                this.o = ToastRightAreaStyle.BUTTON;
            }
            if (TextUtils.isEmpty(this.d)) {
                ob3.o((Activity) this.a, null, null, null, this.b, null, this.h, this.r, this.j, this.m);
                return;
            }
            CharSequence charSequence = this.c;
            CharSequence charSequence2 = this.b;
            if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.b)) {
                charSequence = this.b;
                charSequence2 = "";
            }
            ob3.p((Activity) this.a, this.g, null, null, charSequence, charSequence2, this.d, this.o, this.h, false, this.j);
        } else {
            b bVar2 = this.l;
            if (bVar2 != null) {
                jb3.f(bVar2);
                this.l = null;
            }
            y(this.a, this.c);
        }
    }

    public void H(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048583, this, z) != null) || !b()) {
            return;
        }
        a();
        if (!z && (this.a instanceof Activity)) {
            if (u) {
                StringBuilder sb = new StringBuilder();
                sb.append("给View set 的mOnDismissListener是不是空?");
                if (this.l == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                sb.append(z2);
                Log.w(UniversalToast.TAG, sb.toString());
            }
            b bVar = this.l;
            if (bVar != null) {
                ob3.l(bVar);
                this.l = null;
            }
            ob3.o((Activity) this.a, null, null, null, this.b, null, this.h, this.r, this.j, this.m);
            return;
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            jb3.f(bVar2);
            this.l = null;
        }
        y(this.a, this.b);
    }

    @SuppressLint({"BDThrowableCheck"})
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.a == null) {
                if (!u) {
                    return false;
                }
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            } else if (this.b == null) {
                if (!u) {
                    return false;
                }
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void v() {
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.a != null && (!TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c))) {
                a();
                if (this.a instanceof Activity) {
                    int i = a.a[this.s.ordinal()];
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (TextUtils.isEmpty(this.b)) {
                                    return;
                                }
                                ob3.o((Activity) this.a, null, null, null, this.b, null, this.h, this.r, null, this.m);
                                return;
                            } else if (TextUtils.isEmpty(this.b)) {
                                return;
                            } else {
                                ob3.n((Activity) this.a, this.b, this.e, this.n, this.h, this.m);
                                return;
                            }
                        } else if (TextUtils.isEmpty(this.q) && !TextUtils.isEmpty(this.b)) {
                            ob3.o((Activity) this.a, this.g, this.f, this.n, this.b, this.q, this.h, this.r, this.j, this.m);
                            return;
                        } else if (TextUtils.isEmpty(this.c)) {
                            return;
                        } else {
                            ob3.p((Activity) this.a, this.g, this.f, this.n, this.c, this.p, this.q, this.o, this.h, this.t, this.j);
                            return;
                        }
                    } else if (TextUtils.isEmpty(this.b)) {
                        return;
                    } else {
                        ob3.o((Activity) this.a, this.g, this.f, this.n, this.b, this.q, this.h, this.r, this.j, this.m);
                        return;
                    }
                } else if (a.a[this.s.ordinal()] != 4) {
                    Context context = this.a;
                    if (TextUtils.isEmpty(this.b)) {
                        charSequence = this.c;
                    } else {
                        charSequence = this.b;
                    }
                    y(context, charSequence);
                    return;
                } else if (TextUtils.isEmpty(this.b)) {
                    return;
                } else {
                    jb3.j(this.a, this.b, this.e, this.n, this.h, this.m);
                    return;
                }
            }
            mb3.h("has no mToastText or mTitleText");
        }
    }

    @Deprecated
    public void x(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !b()) {
            return;
        }
        a();
        if (!z && (this.a instanceof Activity)) {
            b bVar = this.l;
            if (bVar != null) {
                ob3.l(bVar);
                this.l = null;
            }
            if (TextUtils.isEmpty(this.d)) {
                this.d = cv2.c().getResources().getText(R.string.obfuscated_res_0x7f0f0142);
            }
            ob3.o((Activity) this.a, null, null, null, this.b, this.d, this.h, ToastLocation.BOTTOM, this.j, this.m);
            return;
        }
        b bVar2 = this.l;
        if (bVar2 != null) {
            jb3.f(bVar2);
            this.l = null;
        }
        y(this.a, this.b);
    }
}
