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
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class q72 extends n62<SwanEditText, r72> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public pa2 j;
    public zt2 k;
    public int l;

    /* loaded from: classes7.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* loaded from: classes7.dex */
    public class a extends eo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ q72 b;

        public a(q72 q72Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q72Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q72Var;
            this.a = swanEditText;
        }

        @Override // com.baidu.tieba.eo2, com.baidu.tieba.fo2
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.k != null) {
                this.b.k.dismiss();
                this.b.p0(this.a);
            }
        }

        @Override // com.baidu.tieba.eo2, com.baidu.tieba.fo2
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, keyEvent)) == null) {
                if (i == 4 && this.b.k != null) {
                    this.b.k.dismiss();
                    this.b.p0(this.a);
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements zt2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ r72 b;
        public final /* synthetic */ eo2 c;
        public final /* synthetic */ q72 d;

        public b(q72 q72Var, SwanEditText swanEditText, r72 r72Var, eo2 eo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q72Var, swanEditText, r72Var, eo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = q72Var;
            this.a = swanEditText;
            this.b = r72Var;
            this.c = eo2Var;
        }

        @Override // com.baidu.tieba.zt2.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (w62.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.d.y0(this.a);
                this.d.i.G0(this.c);
            }
        }

        @Override // com.baidu.tieba.zt2.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (w62.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                q72 q72Var = this.d;
                q72Var.z0(q72Var.i, this.a, this.b, i);
                this.d.i.u0(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r72 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ q72 c;

        public c(q72 q72Var, r72 r72Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q72Var, r72Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q72Var;
            this.a = r72Var;
            this.b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                vt2.d(ut2.d().c(), this.c.l);
                if (this.a.M) {
                    return true;
                }
                this.b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ q72 b;

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

        public d(q72 q72Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q72Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q72Var;
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
                vt2.c((r72) this.b.n(), this.a, charAt);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r72 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ q72 c;

        public e(q72 q72Var, r72 r72Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q72Var, r72Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q72Var;
            this.a = r72Var;
            this.b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (w62.h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (!z) {
                    h82.i("Component-Input", "send blur callback");
                    if (!TextUtils.equals("text", this.a.L) && this.c.k != null) {
                        this.c.k.dismiss();
                    }
                    vt2.b(this.b, this.c.l);
                    this.c.p0(this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements um3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ r72 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ q72 e;

        @Override // com.baidu.tieba.um3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public f(q72 q72Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, r72 r72Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q72Var, swanEditText, swanAppActivity, r72Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = q72Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = r72Var;
            this.d = view2;
        }

        @Override // com.baidu.tieba.um3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) {
                return;
            }
            this.e.y0(this.a);
            wm3.i().k(this.d);
        }

        @Override // com.baidu.tieba.um3
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) != null) || !this.a.hasFocus()) {
                return;
            }
            this.e.z0(this.b, this.a, this.c, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q72(@Nullable Context context, @NonNull r72 r72Var, @NonNull SwanAppActivity swanAppActivity, @NonNull pa2 pa2Var, @NonNull g gVar) {
        super(context, r72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, r72Var, swanAppActivity, pa2Var, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (o62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = pa2Var;
        vt2.a(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w62
    @NonNull
    /* renamed from: r0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            q0();
            return ut2.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u62
    /* renamed from: u0 */
    public void R(@NonNull SwanEditText swanEditText, @NonNull r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, r72Var) == null) {
            if (w62.h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    /* renamed from: x0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, r72Var) == null) {
            Y(swanEditText, r72Var, 16);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p0(ut2.d().c());
        }
    }

    @Override // com.baidu.tieba.w62
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
        }
    }

    public final void A0(SwanEditText swanEditText, r72 r72Var, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText, r72Var, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, r72Var, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, r72Var, swanEditText));
            if (TextUtils.equals("text", r72Var.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                wm3.i().l(decorView, r72Var.b, new f(this, swanEditText, swanAppActivity, r72Var, decorView));
            }
            ut2.d().f(dVar);
            swanEditText.addTextChangedListener(dVar);
        }
    }

    public final void B0(SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText) == null) {
            try {
                Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(swanEditText, Boolean.FALSE);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                if (w62.h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            SwanAppActivity activity = uw2.T().getActivity();
            if (activity == null) {
                h82.o("Component-Input", "activity is null when close input");
                return;
            }
            io3.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            h82.i("Component-Input", "remove input");
            if (B().a()) {
                h82.i("Component-Input", "remove input success");
            } else {
                h82.o("Component-Input", "remove input fail");
            }
            ut2.d().b();
        }
    }

    public final void y0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, swanEditText) == null) {
            if (w62.h) {
                Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.j.z3().getScrollY() > 0) {
                    this.j.z3().setScrollY(0);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w62
    /* renamed from: s0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, swanEditText) == null) {
            super.A(swanEditText);
            r72 r72Var = (r72) n();
            swanEditText.setText(r72Var.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(r72Var.e);
            if (!TextUtils.equals("text", r72Var.L)) {
                String str = r72Var.L;
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
                this.k = new zt2(this.i, swanEditText, i, r72Var.D);
                this.k.e(new b(this, swanEditText, r72Var, new a(this, swanEditText)));
                this.k.f();
            }
            if (r72Var.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.baidu.tieba.w62
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.x(z);
            if (!z) {
                a82.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                a82.a("Component-Input", "onAttached with null editText");
                swanEditText = ut2.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((r72) n()).L, "text")) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.i.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(swanEditText, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                swanEditText.setShowSoftInputOnFocus(false);
            } else {
                B0(swanEditText);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n62
    /* renamed from: t0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull r72 r72Var, @NonNull z72 z72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, swanEditText, r72Var, z72Var) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(ut2.d().e());
            }
            super.T(swanEditText, r72Var, z72Var);
            if (t) {
                swanEditText.addTextChangedListener(ut2.d().e());
            } else {
                A0(swanEditText, r72Var, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    /* renamed from: v0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, r72Var) == null) {
            if (w62.h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.U(swanEditText, r72Var);
                try {
                    swanEditText.setSelection(r72Var.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (w62.h) {
                        e2.printStackTrace();
                    }
                    a82.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (!TextUtils.equals(swanEditText.getText(), r72Var.t)) {
                a82.a("Component-Input", "insert input: set text must before render");
                super.U(swanEditText, r72Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    /* renamed from: w0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, r72Var) == null) {
            if (w62.h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = r72Var.A;
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
                    super.W(swanEditText, r72Var);
                    return;
                } else {
                    swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
                    return;
                }
            }
            swanEditText.setTypeface(Typeface.SANS_SERIF, 2);
        }
    }

    public final void z0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, r72 r72Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, swanAppActivity, swanEditText, r72Var, i) == null) {
            ox1 i3 = uw2.T().i();
            if (w62.h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l != i && i3 != null) {
                this.l = i;
                vt2.f(swanEditText, i);
                if (r72Var.N) {
                    if (r72Var.h == null) {
                        r72Var.h = new n13();
                    }
                    int webViewScrollY = i3.getWebViewScrollY();
                    int height = swanEditText.getHeight();
                    if (height == 0) {
                        height = r72Var.h.c();
                    }
                    int height2 = ((this.j.z3().getHeight() - r72Var.h.e()) - height) + webViewScrollY + yo3.k(swanAppActivity);
                    int i4 = r72Var.E;
                    if (i4 > height2) {
                        i4 = height2;
                    }
                    int i5 = height2 - i;
                    int scrollY = this.j.z3().getScrollY();
                    if (i5 < 0) {
                        i2 = i4 - i5;
                    } else {
                        if (i4 > i5) {
                            scrollY = i4 - i5;
                        }
                        i2 = scrollY;
                    }
                    this.j.z3().setScrollY(i2);
                }
            }
        }
    }
}
