package com.baidu.tieba;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class o72 extends j62<SwanEditText, p72> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public la2 j;
    public int k;
    public i l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* loaded from: classes7.dex */
    public interface i {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* loaded from: classes7.dex */
    public class e implements qm3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ View c;
        public final /* synthetic */ o72 d;

        /* loaded from: classes7.dex */
        public class a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p72 a;
            public final /* synthetic */ e b;

            public a(e eVar, p72 p72Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, p72Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = p72Var;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view2) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (!this.a.X && (inputMethodManager = (InputMethodManager) this.b.b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.b.a.getWindowToken(), 0);
                    }
                    d82.i("Component-TextArea", "send confirm change callback");
                    e eVar = this.b;
                    eVar.d.F0(eVar.a, "confirm");
                }
            }
        }

        public e(o72 o72Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, swanEditText, swanAppActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o72Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = view2;
        }

        @Override // com.baidu.tieba.qm3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (this.d.k != 0) {
                    this.d.k = 0;
                    if (this.d.j.z3().getScrollY() > 0) {
                        this.d.j.z3().setScrollY(0);
                        this.d.p = false;
                    }
                    if (this.d.o != null && this.d.o.getVisibility() == 0) {
                        ((FrameLayout) this.c.findViewById(16908290)).removeView(this.d.o);
                        this.d.o = null;
                    }
                }
                if (this.a.hasFocus()) {
                    this.a.clearFocus();
                    if (s62.h) {
                        Log.d("Component-TextArea", "clearFocus");
                    }
                }
            }
        }

        @Override // com.baidu.tieba.qm3
        public void b(String str, int i) {
            int i2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                p72 p72Var = (p72) this.d.n();
                kx1 i5 = qw2.T().i();
                if (this.d.k != i && this.a.hasFocus() && i5 != null) {
                    this.d.k = i;
                    this.d.n = this.a.getHeight();
                    this.d.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                    boolean z = p72Var.f1150T;
                    if (p72Var.S) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        i2 = uo3.g(38.0f);
                        if (this.d.o == null) {
                            this.d.o = new ShowConfirmBarLayout(this.b);
                            this.d.o.setOnConfirmButtonClickListener(new a(this, p72Var));
                            layoutParams.topMargin = ((this.c.getHeight() - i) - i2) - no3.c();
                            ((FrameLayout) this.c.findViewById(16908290)).addView(this.d.o, layoutParams);
                        }
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        if (!p72Var.R) {
                            i3 = i5.getWebViewScrollY();
                        } else {
                            i3 = 0;
                        }
                        j13 j13Var = p72Var.h;
                        if (j13Var != null) {
                            i4 = j13Var.e();
                        } else {
                            i4 = 0;
                        }
                        int height = ((this.d.j.z3().getHeight() - i4) - this.a.getHeight()) + i3;
                        int i6 = p72Var.E;
                        if (height - i6 < i) {
                            this.d.p = true;
                            if (i6 > height) {
                                this.d.j.z3().setScrollY(i + i2);
                                return;
                            } else {
                                this.d.j.z3().setScrollY((i - height) + i6 + i2);
                                return;
                            }
                        }
                        this.d.p = false;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.qm3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.d.q != this.a.getLineCount()) {
                d82.i("Component-TextArea", "send line change callback");
                this.d.F0(this.a, "linechange");
                this.d.E0(this.a, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p72 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ o72 c;

        public a(o72 o72Var, p72 p72Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, p72Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o72Var;
            this.a = p72Var;
            this.b = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.i == null) {
                    w72.a("Component-TextArea", "activity is null, set textarea attr failed");
                    return;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) this.c.i.getSystemService("input_method");
                if (inputMethodManager != null && this.a.P) {
                    this.b.setFocusable(true);
                    this.b.setFocusableInTouchMode(true);
                    this.b.requestFocus();
                    inputMethodManager.showSoftInput(this.b, 0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ o72 b;

        public b(o72 o72Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o72Var;
            this.a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.F0(this.a, "selection");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ o72 b;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public c(o72 o72Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o72Var;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || !this.a.hasFocus()) {
                return;
            }
            d82.i("Component-TextArea", "send input callback");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            char charAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.getLineCount() > 0) {
                if (this.b.q != this.a.getLineCount()) {
                    d82.i("Component-TextArea", "send line change callback");
                    this.b.F0(this.a, "linechange");
                }
                int i4 = i3 - i2;
                if (i2 != i4) {
                    if (i2 > i4) {
                        charAt = '\b';
                    } else {
                        charAt = charSequence.charAt((i + i4) - 1);
                    }
                    this.b.G0(this.a, "input", charAt);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ o72 b;

        public d(o72 o72Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o72Var;
            this.a = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (s62.h) {
                    Log.d("Component-TextArea", "onFocusChange:" + z);
                }
                if (z) {
                    if (this.b.k != 0) {
                        this.b.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    this.b.J0();
                    return;
                }
                this.b.F0(this.a, ConstPath.KEY_BLUR);
                this.b.I0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ o72 c;

        public f(o72 o72Var, SwanEditText swanEditText, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, swanEditText, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o72Var;
            this.a = swanEditText;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null) {
                JSONObject jSONObject = new JSONObject();
                String obj = this.a.getTag().toString();
                if (!TextUtils.equals(obj, ((p72) this.c.n()).b)) {
                    w72.a("Component-TextArea", "changeTextAreaStatus with different id");
                }
                int D0 = this.c.D0(this.a);
                try {
                    jSONObject.put("eventName", this.b);
                    jSONObject.put("value", this.a.getText().toString());
                    jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                    jSONObject.put("selectionStart", this.a.getSelectionStart());
                    jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                    jSONObject.put("lineCount", this.a.getLineCount());
                    jSONObject.put("height", "" + uo3.O(D0));
                    jSONObject.put("keyboardHeight", "" + uo3.O((float) this.c.k));
                } catch (JSONException e) {
                    if (s62.h) {
                        e.printStackTrace();
                    }
                }
                if (s62.h) {
                    Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
                }
                this.c.l.a(obj, this.c.m, jSONObject);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ o72 d;

        public g(o72 o72Var, SwanEditText swanEditText, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, swanEditText, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o72Var;
            this.a = swanEditText;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null) {
                JSONObject jSONObject = new JSONObject();
                String obj = this.a.getTag().toString();
                if (!TextUtils.equals(obj, ((p72) this.d.n()).b)) {
                    w72.a("Component-TextArea", "changeTextAreaStatus with different id");
                }
                int D0 = this.d.D0(this.a);
                try {
                    jSONObject.put("eventName", this.b);
                    jSONObject.put("value", this.a.getText().toString());
                    jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                    jSONObject.put("selectionStart", this.a.getSelectionStart());
                    jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                    jSONObject.put("lineCount", this.a.getLineCount());
                    jSONObject.put("height", "" + uo3.O(D0));
                    jSONObject.put("keyboardHeight", "" + uo3.O((float) this.d.k));
                    jSONObject.put("keyCode", this.c);
                } catch (JSONException e) {
                    if (s62.h) {
                        e.printStackTrace();
                    }
                }
                if (s62.h) {
                    Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
                }
                this.d.l.a(obj, this.d.m, jSONObject);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ p72 b;
        public final /* synthetic */ o72 c;

        public h(o72 o72Var, SwanEditText swanEditText, p72 p72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, swanEditText, p72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o72Var;
            this.a = swanEditText;
            this.b = p72Var;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i >= 2 && i <= 7) {
                    this.c.F0(this.a, "confirm");
                }
                return this.b.X;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o72(@Nullable Context context, @NonNull p72 p72Var, @NonNull SwanAppActivity swanAppActivity, @NonNull la2 la2Var, @NonNull i iVar) {
        super(context, p72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, p72Var, swanAppActivity, la2Var, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (k62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = 1;
        this.i = swanAppActivity;
        this.j = la2Var;
        this.l = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j62
    /* renamed from: O0 */
    public void d0(@NonNull SwanEditText swanEditText, @NonNull p72 p72Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, swanEditText, p72Var) == null) {
            Editable text = swanEditText.getText();
            if (text != null) {
                i2 = text.length();
            } else {
                i2 = 0;
            }
            if (p72Var.P) {
                int i3 = p72Var.F;
                if (i3 <= i2 && i3 >= 0) {
                    swanEditText.setSelection(i3);
                } else {
                    swanEditText.setSelection(i2);
                }
            }
        }
    }

    public final void P0(@NonNull SwanEditText swanEditText, @NonNull p72 p72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, p72Var) == null) {
            if (s62.h) {
                Log.d("Component-TextArea", "renderDisable");
            }
            swanEditText.setEnabled(!p72Var.W);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o62
    /* renamed from: T0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull p72 p72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, p72Var) == null) {
            super.Y(swanEditText, p72Var, 48);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    @NonNull
    /* renamed from: K0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            return new SwanEditText(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    /* renamed from: L0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            super.A(swanEditText);
            p72 p72Var = (p72) n();
            swanEditText.setTag(p72Var.b);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = p72Var.e;
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppActivity activity = qw2.T().getActivity();
            if (activity == null) {
                d82.o("Component-TextArea", "activity is null when open input");
                return;
            }
            if (s62.h) {
                Log.d("Component-TextArea", "forceOpenKeyboard");
            }
            eo3.b(activity, true);
        }
    }

    public final int D0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText)) == null) {
            p72 p72Var = (p72) n();
            int lineCount = swanEditText.getLineCount();
            int lineHeight = swanEditText.getLineHeight();
            int i2 = p72Var.U;
            int i3 = p72Var.V;
            int height = swanEditText.getHeight();
            if (p72Var.Q) {
                int paddingTop = (lineHeight * lineCount) + swanEditText.getPaddingTop() + swanEditText.getPaddingBottom();
                if (i3 < i2) {
                    i3 = i2;
                }
                if (paddingTop > i2) {
                    if (paddingTop >= i3) {
                        return i3;
                    }
                    return paddingTop;
                }
                return i2;
            }
            return height;
        }
        return invokeL.intValue;
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (!TextUtils.equals(((p72) n()).b, str)) {
                w72.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                w72.a("Component-TextArea", "sendLineChangeEvent with a null editText");
            } else {
                F0(swanEditText, "linechange");
            }
        }
    }

    public final void E0(SwanEditText swanEditText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, swanEditText, str) == null) {
            p72 p72Var = (p72) n();
            if (!TextUtils.equals(str, p72Var.b)) {
                w72.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = p72Var.f1150T;
            if (swanEditText.hasFocus() && !p72Var.R) {
                if (this.k > 0 && z && this.p) {
                    int scrollY = this.j.z3().getScrollY() + (swanEditText.getHeight() - this.n);
                    if (scrollY > 0) {
                        this.j.z3().setScrollY(scrollY);
                    } else {
                        this.j.z3().setScrollY(0);
                    }
                }
                this.n = swanEditText.getHeight();
            }
        }
    }

    public final void Q0(@NonNull SwanEditText swanEditText, @NonNull p72 p72Var) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanEditText, p72Var) == null) {
            if (s62.h) {
                Log.d("Component-TextArea", "renderPlaceHolder");
            }
            SpannableString spannableString = new SpannableString(p72Var.L);
            String str = p72Var.N;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode == 3029637 && str.equals("bold")) {
                    c2 = 1;
                }
            } else if (str.equals("normal")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    styleSpan = new StyleSpan(0);
                } else {
                    styleSpan = new StyleSpan(1);
                }
            } else {
                styleSpan = new StyleSpan(0);
            }
            spannableString.setSpan(styleSpan, 0, p72Var.L.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.t(p72Var.O)), 0, p72Var.L.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(p72Var.M, true), 0, p72Var.L.length(), 33);
            swanEditText.setHint(spannableString);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void F0(SwanEditText swanEditText, String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, swanEditText, str) == null) {
            switch (str.hashCode()) {
                case -1715965556:
                    if (str.equals("selection")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3027047:
                    if (str.equals(ConstPath.KEY_BLUR)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 97604824:
                    if (str.equals(AddFriendActivityConfig.TYPE_FOCUS)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100358090:
                    if (str.equals("input")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 259718308:
                    if (str.equals("linechange")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 == 4) {
                                ((p72) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
                            }
                        } else {
                            ((p72) n()).q(false);
                        }
                    } else {
                        ((p72) n()).q(true);
                    }
                } else {
                    ((p72) n()).j(swanEditText.getText().toString());
                }
            } else {
                this.q = swanEditText.getLineCount();
                ((p72) n()).m(swanEditText.getHeight());
            }
            xo3.a0(new f(this, swanEditText, str));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void G0(SwanEditText swanEditText, String str, int i2) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, swanEditText, str, i2) == null) {
            switch (str.hashCode()) {
                case -1715965556:
                    if (str.equals("selection")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3027047:
                    if (str.equals(ConstPath.KEY_BLUR)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 97604824:
                    if (str.equals(AddFriendActivityConfig.TYPE_FOCUS)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100358090:
                    if (str.equals("input")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 259718308:
                    if (str.equals("linechange")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 == 4) {
                                ((p72) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
                            }
                        } else {
                            ((p72) n()).q(false);
                        }
                    } else {
                        ((p72) n()).q(true);
                    }
                } else {
                    ((p72) n()).j(swanEditText.getText().toString());
                }
            } else {
                this.q = swanEditText.getLineCount();
                ((p72) n()).m(swanEditText.getHeight());
            }
            xo3.a0(new g(this, swanEditText, str, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j62, com.baidu.tieba.o62, com.baidu.tieba.q62, com.baidu.tieba.s62
    @NonNull
    /* renamed from: H0 */
    public v72 k(@NonNull p72 p72Var, @NonNull p72 p72Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, p72Var, p72Var2)) == null) {
            v72 k = super.k(p72Var, p72Var2);
            if (!TextUtils.equals(p72Var.L, p72Var2.L)) {
                k.b(14);
            }
            if (p72Var.M != p72Var2.M) {
                k.b(14);
            }
            if (!TextUtils.equals(p72Var.N, p72Var2.N)) {
                k.b(14);
            }
            if (!TextUtils.equals(p72Var.O, p72Var2.O)) {
                k.b(14);
            }
            if (p72Var.W != p72Var2.W) {
                k.b(15);
            }
            return k;
        }
        return (v72) invokeLL.objValue;
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SwanAppActivity activity = qw2.T().getActivity();
            if (activity == null) {
                d82.o("Component-TextArea", "activity is null when close input");
                return;
            }
            if (s62.h) {
                Log.d("Component-TextArea", "forceCloseKeyboard");
            }
            eo3.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j62
    /* renamed from: M0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull p72 p72Var, @NonNull v72 v72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, swanEditText, p72Var, v72Var) == null) {
            super.T(swanEditText, p72Var, v72Var);
            if (v72Var.a(14)) {
                Q0(swanEditText, p72Var);
            }
            boolean z = !t();
            if (z) {
                swanEditText.setMinHeight(p72Var.U);
                swanEditText.setMaxHeight(p72Var.V);
            }
            xo3.a0(new a(this, p72Var, swanEditText));
            if (v72Var.a(15)) {
                P0(swanEditText, p72Var);
            }
            if (z) {
                V0(swanEditText, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j62
    /* renamed from: N0 */
    public boolean c0(@NonNull SwanEditText swanEditText, @NonNull p72 p72Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, swanEditText, p72Var)) == null) {
            if (!TextUtils.isEmpty(p72Var.I) && !"default".equals(p72Var.I)) {
                boolean c0 = super.c0(swanEditText, p72Var);
                if (c0) {
                    swanEditText.setOnEditorActionListener(new h(this, swanEditText, p72Var));
                }
                return c0;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.j62
    /* renamed from: R0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull p72 p72Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, p72Var) == null) {
            Editable text = swanEditText.getText();
            if (text != null) {
                i2 = text.length();
            } else {
                i2 = 0;
            }
            int i4 = p72Var.H;
            if (i4 <= i2 && i4 > 0 && (i3 = p72Var.G) <= i4 && i3 > 0 && p72Var.P && !swanEditText.hasFocus()) {
                swanEditText.setSelection(p72Var.G, p72Var.H);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o62
    /* renamed from: S0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull p72 p72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, p72Var) == null) {
            if (s62.h) {
                Log.d("Component-TextArea", "renderText");
            }
            if (!TextUtils.equals(swanEditText.getText(), p72Var.t)) {
                swanEditText.setLineSpacing(p72Var.y, 1.0f);
                swanEditText.setText(p72Var.t);
            }
        }
    }

    public final void V0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, swanEditText, swanAppActivity) == null) {
            swanEditText.setSelectListener(new b(this, swanEditText));
            swanEditText.addTextChangedListener(new c(this, swanEditText));
            swanEditText.setOnFocusChangeListener(new d(this, swanEditText));
            rm3.g(((p72) n()).b, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}
