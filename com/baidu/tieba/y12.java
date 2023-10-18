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
import com.baidu.tieba.ho2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class y12 extends w02<SwanEditText, z12> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public x42 j;
    public ho2 k;
    public int l;

    /* loaded from: classes8.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* loaded from: classes8.dex */
    public class a extends mi2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ y12 b;

        public a(y12 y12Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y12Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y12Var;
            this.a = swanEditText;
        }

        @Override // com.baidu.tieba.mi2, com.baidu.tieba.ni2
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.k != null) {
                this.b.k.dismiss();
                this.b.r0(this.a);
            }
        }

        @Override // com.baidu.tieba.mi2, com.baidu.tieba.ni2
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
    public class b implements ho2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ z12 b;
        public final /* synthetic */ mi2 c;
        public final /* synthetic */ y12 d;

        public b(y12 y12Var, SwanEditText swanEditText, z12 z12Var, mi2 mi2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y12Var, swanEditText, z12Var, mi2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = y12Var;
            this.a = swanEditText;
            this.b = z12Var;
            this.c = mi2Var;
        }

        @Override // com.baidu.tieba.ho2.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f12.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.d.A0(this.a);
                this.d.i.G0(this.c);
            }
        }

        @Override // com.baidu.tieba.ho2.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (f12.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                y12 y12Var = this.d;
                y12Var.B0(y12Var.i, this.a, this.b, i);
                this.d.i.u0(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z12 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ y12 c;

        public c(y12 y12Var, z12 z12Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y12Var, z12Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y12Var;
            this.a = z12Var;
            this.b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                do2.d(co2.d().c(), this.c.l);
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
        public final /* synthetic */ y12 b;

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

        public d(y12 y12Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y12Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y12Var;
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
                do2.c((z12) this.b.n(), this.a, charAt);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z12 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ y12 c;

        public e(y12 y12Var, z12 z12Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y12Var, z12Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y12Var;
            this.a = z12Var;
            this.b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (f12.h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (!z) {
                    p22.i("Component-Input", "send blur callback");
                    if (!TextUtils.equals("text", this.a.L) && this.c.k != null) {
                        this.c.k.dismiss();
                    }
                    do2.b(this.b, this.c.l);
                    this.c.r0(this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ch3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ z12 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ y12 e;

        @Override // com.baidu.tieba.ch3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public f(y12 y12Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, z12 z12Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y12Var, swanEditText, swanAppActivity, z12Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y12Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = z12Var;
            this.d = view2;
        }

        @Override // com.baidu.tieba.ch3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) {
                return;
            }
            this.e.A0(this.a);
            eh3.i().k(this.d);
        }

        @Override // com.baidu.tieba.ch3
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) != null) || !this.a.hasFocus()) {
                return;
            }
            this.e.B0(this.b, this.a, this.c, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y12(@Nullable Context context, @NonNull z12 z12Var, @NonNull SwanAppActivity swanAppActivity, @NonNull x42 x42Var, @NonNull g gVar) {
        super(context, z12Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, z12Var, swanAppActivity, x42Var, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (x02) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = x42Var;
        do2.a(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    @NonNull
    /* renamed from: t0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            s0();
            return co2.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d12
    /* renamed from: w0 */
    public void T(@NonNull SwanEditText swanEditText, @NonNull z12 z12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, z12Var) == null) {
            if (f12.h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b12
    /* renamed from: z0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull z12 z12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, swanEditText, z12Var) == null) {
            a0(swanEditText, z12Var, 16);
        }
    }

    @Override // com.baidu.tieba.f12
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A();
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            r0(co2.d().c());
        }
    }

    public final void A0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText) == null) {
            if (f12.h) {
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
            SwanAppActivity activity = cr2.V().getActivity();
            if (activity == null) {
                p22.o("Component-Input", "activity is null when close input");
                return;
            }
            qi3.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            p22.i("Component-Input", "remove input");
            if (C().a()) {
                p22.i("Component-Input", "remove input success");
            } else {
                p22.o("Component-Input", "remove input fail");
            }
            co2.d().b();
        }
    }

    public final void B0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, z12 z12Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, swanAppActivity, swanEditText, z12Var, i) == null) {
            xr1 i3 = cr2.V().i();
            if (f12.h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l != i && i3 != null) {
                this.l = i;
                do2.f(swanEditText, i);
                if (z12Var.N) {
                    if (z12Var.h == null) {
                        z12Var.h = new vv2();
                    }
                    int webViewScrollY = i3.getWebViewScrollY();
                    int height = swanEditText.getHeight();
                    if (height == 0) {
                        height = z12Var.h.c();
                    }
                    int height2 = ((this.j.E3().getHeight() - z12Var.h.e()) - height) + webViewScrollY + gj3.k(swanAppActivity);
                    int i4 = z12Var.E;
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

    public final void C0(SwanEditText swanEditText, z12 z12Var, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, swanEditText, z12Var, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, z12Var, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, z12Var, swanEditText));
            if (TextUtils.equals("text", z12Var.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                eh3.i().l(decorView, z12Var.b, new f(this, swanEditText, swanAppActivity, z12Var, decorView));
            }
            co2.d().f(dVar);
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
                if (f12.h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    /* renamed from: u0 */
    public void B(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, swanEditText) == null) {
            super.B(swanEditText);
            z12 z12Var = (z12) n();
            swanEditText.setText(z12Var.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(z12Var.e);
            if (!TextUtils.equals("text", z12Var.L)) {
                String str = z12Var.L;
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
                this.k = new ho2(this.i, swanEditText, i, z12Var.D);
                this.k.e(new b(this, swanEditText, z12Var, new a(this, swanEditText)));
                this.k.f();
            }
            if (z12Var.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.baidu.tieba.f12
    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.y(z);
            if (!z) {
                i22.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                i22.a("Component-Input", "onAttached with null editText");
                swanEditText = co2.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((z12) n()).L, "text")) {
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
    @Override // com.baidu.tieba.b12
    /* renamed from: v0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull z12 z12Var, @NonNull h22 h22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, swanEditText, z12Var, h22Var) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(co2.d().e());
            }
            super.c0(swanEditText, z12Var, h22Var);
            if (t) {
                swanEditText.addTextChangedListener(co2.d().e());
            } else {
                C0(swanEditText, z12Var, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b12
    /* renamed from: x0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull z12 z12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, z12Var) == null) {
            if (f12.h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.W(swanEditText, z12Var);
                try {
                    swanEditText.setSelection(z12Var.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (f12.h) {
                        e2.printStackTrace();
                    }
                    i22.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (!TextUtils.equals(swanEditText.getText(), z12Var.t)) {
                i22.a("Component-Input", "insert input: set text must before render");
                super.W(swanEditText, z12Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b12
    /* renamed from: y0 */
    public void Y(@NonNull SwanEditText swanEditText, @NonNull z12 z12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, z12Var) == null) {
            if (f12.h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = z12Var.A;
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
                    super.Y(swanEditText, z12Var);
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
