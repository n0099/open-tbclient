package com.baidu.tieba;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class t22 extends r12<SwanEditText, u22> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public s52 j;
    public cp2 k;
    public int l;

    /* loaded from: classes8.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* loaded from: classes8.dex */
    public class a extends hj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ t22 b;

        public a(t22 t22Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t22Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t22Var;
            this.a = swanEditText;
        }

        @Override // com.baidu.tieba.hj2, com.baidu.tieba.ij2
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.k != null) {
                this.b.k.dismiss();
                this.b.r0(this.a);
            }
        }

        @Override // com.baidu.tieba.hj2, com.baidu.tieba.ij2
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, keyEvent)) == null) {
                if (i == 4 && this.b.k != null) {
                    this.b.k.dismiss();
                    this.b.r0(this.a);
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements cp2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ u22 b;
        public final /* synthetic */ hj2 c;
        public final /* synthetic */ t22 d;

        public b(t22 t22Var, SwanEditText swanEditText, u22 u22Var, hj2 hj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t22Var, swanEditText, u22Var, hj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t22Var;
            this.a = swanEditText;
            this.b = u22Var;
            this.c = hj2Var;
        }

        @Override // com.baidu.tieba.cp2.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a22.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.d.A0(this.a);
                this.d.i.G0(this.c);
            }
        }

        @Override // com.baidu.tieba.cp2.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (a22.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                t22 t22Var = this.d;
                t22Var.B0(t22Var.i, this.a, this.b, i);
                this.d.i.u0(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ t22 c;

        public c(t22 t22Var, u22 u22Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t22Var, u22Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t22Var;
            this.a = u22Var;
            this.b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                yo2.d(xo2.d().c(), this.c.l);
                if (this.a.M) {
                    return true;
                }
                this.b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ t22 b;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public d(t22 t22Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t22Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t22Var;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            char charAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && i2 != i3) {
                if (i2 > i3) {
                    charAt = '\b';
                } else {
                    charAt = charSequence.charAt((i + i3) - 1);
                }
                yo2.c((u22) this.b.n(), this.a, charAt);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ t22 c;

        public e(t22 t22Var, u22 u22Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t22Var, u22Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t22Var;
            this.a = u22Var;
            this.b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (a22.h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (!z) {
                    k32.i("Component-Input", "send blur callback");
                    if (!TextUtils.equals("text", this.a.L) && this.c.k != null) {
                        this.c.k.dismiss();
                    }
                    yo2.b(this.b, this.c.l);
                    this.c.r0(this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements xh3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ u22 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ t22 e;

        @Override // com.baidu.tieba.xh3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public f(t22 t22Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, u22 u22Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t22Var, swanEditText, swanAppActivity, u22Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t22Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = u22Var;
            this.d = view2;
        }

        @Override // com.baidu.tieba.xh3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) {
                return;
            }
            this.e.A0(this.a);
            zh3.i().k(this.d);
        }

        @Override // com.baidu.tieba.xh3
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) != null) || !this.a.hasFocus()) {
                return;
            }
            this.e.B0(this.b, this.a, this.c, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t22(@Nullable Context context, @NonNull u22 u22Var, @NonNull SwanAppActivity swanAppActivity, @NonNull s52 s52Var, @NonNull g gVar) {
        super(context, u22Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, u22Var, swanAppActivity, s52Var, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (s12) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = s52Var;
        yo2.a(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a22
    @NonNull
    /* renamed from: t0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            s0();
            return xo2.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y12
    /* renamed from: w0 */
    public void T(@NonNull SwanEditText swanEditText, @NonNull u22 u22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, u22Var) == null) {
            if (a22.h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w12
    /* renamed from: z0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull u22 u22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, swanEditText, u22Var) == null) {
            a0(swanEditText, u22Var, 16);
        }
    }

    @Override // com.baidu.tieba.a22
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A();
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            r0(xo2.d().c());
        }
    }

    public final void A0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText) == null) {
            if (a22.h) {
                Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.j.E3().getScrollY() > 0) {
                    this.j.E3().setScrollY(0);
                }
            }
        }
    }

    public final void r0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, swanEditText) == null) {
            SwanAppActivity activity = xr2.V().getActivity();
            if (activity == null) {
                k32.o("Component-Input", "activity is null when close input");
                return;
            }
            lj3.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            k32.i("Component-Input", "remove input");
            if (C().a()) {
                k32.i("Component-Input", "remove input success");
            } else {
                k32.o("Component-Input", "remove input fail");
            }
            xo2.d().b();
        }
    }

    public final void B0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, u22 u22Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, swanAppActivity, swanEditText, u22Var, i) == null) {
            ss1 i3 = xr2.V().i();
            if (a22.h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l != i && i3 != null) {
                this.l = i;
                yo2.f(swanEditText, i);
                if (u22Var.N) {
                    if (u22Var.h == null) {
                        u22Var.h = new qw2();
                    }
                    int webViewScrollY = i3.getWebViewScrollY();
                    int height = swanEditText.getHeight();
                    if (height == 0) {
                        height = u22Var.h.c();
                    }
                    int height2 = ((this.j.E3().getHeight() - u22Var.h.e()) - height) + webViewScrollY + bk3.k(swanAppActivity);
                    int i4 = u22Var.E;
                    if (i4 > height2) {
                        i4 = height2;
                    }
                    int i5 = height2 - i;
                    int scrollY = this.j.E3().getScrollY();
                    if (i5 < 0) {
                        i2 = i4 - i5;
                    } else {
                        if (i4 > i5) {
                            scrollY = i4 - i5;
                        }
                        i2 = scrollY;
                    }
                    this.j.E3().setScrollY(i2);
                }
            }
        }
    }

    public final void C0(SwanEditText swanEditText, u22 u22Var, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, swanEditText, u22Var, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, u22Var, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, u22Var, swanEditText));
            if (TextUtils.equals("text", u22Var.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                zh3.i().l(decorView, u22Var.b, new f(this, swanEditText, swanAppActivity, u22Var, decorView));
            }
            xo2.d().f(dVar);
            swanEditText.addTextChangedListener(dVar);
        }
    }

    public final void D0(SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanEditText) == null) {
            try {
                Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(swanEditText, Boolean.FALSE);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                if (a22.h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a22
    /* renamed from: u0 */
    public void B(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, swanEditText) == null) {
            super.B(swanEditText);
            u22 u22Var = (u22) n();
            swanEditText.setText(u22Var.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(u22Var.e);
            if (!TextUtils.equals("text", u22Var.L)) {
                String str = u22Var.L;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1193508181) {
                    if (hashCode == 95582509 && str.equals("digit")) {
                        c2 = 0;
                    }
                } else if (str.equals("idcard")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        i = 0;
                    }
                } else {
                    i = 2;
                }
                this.k = new cp2(this.i, swanEditText, i, u22Var.D);
                this.k.e(new b(this, swanEditText, u22Var, new a(this, swanEditText)));
                this.k.f();
            }
            if (u22Var.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.baidu.tieba.a22
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.y(z);
            if (!z) {
                d32.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                d32.a("Component-Input", "onAttached with null editText");
                swanEditText = xo2.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((u22) n()).L, "text")) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.i.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(swanEditText, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                swanEditText.setShowSoftInputOnFocus(false);
            } else {
                D0(swanEditText);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w12
    /* renamed from: v0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull u22 u22Var, @NonNull c32 c32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, swanEditText, u22Var, c32Var) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(xo2.d().e());
            }
            super.c0(swanEditText, u22Var, c32Var);
            if (t) {
                swanEditText.addTextChangedListener(xo2.d().e());
            } else {
                C0(swanEditText, u22Var, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w12
    /* renamed from: x0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull u22 u22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, u22Var) == null) {
            if (a22.h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.W(swanEditText, u22Var);
                try {
                    swanEditText.setSelection(u22Var.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (a22.h) {
                        e2.printStackTrace();
                    }
                    d32.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (!TextUtils.equals(swanEditText.getText(), u22Var.t)) {
                d32.a("Component-Input", "insert input: set text must before render");
                super.W(swanEditText, u22Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w12
    /* renamed from: y0 */
    public void Y(@NonNull SwanEditText swanEditText, @NonNull u22 u22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, u22Var) == null) {
            if (a22.h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = u22Var.A;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1178781136) {
                if (hashCode == -841373419 && str.equals("boldItalic")) {
                    c2 = 1;
                }
            } else if (str.equals("italic")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    super.Y(swanEditText, u22Var);
                    return;
                } else {
                    swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
                    return;
                }
            }
            swanEditText.setTypeface(Typeface.SANS_SERIF, 2);
        }
    }
}
