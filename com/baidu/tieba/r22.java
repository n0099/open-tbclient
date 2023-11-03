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
/* loaded from: classes8.dex */
public final class r22 extends n12<SwanEditText, s22> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public o52 j;
    public int k;
    public i l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* loaded from: classes8.dex */
    public interface i {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* loaded from: classes8.dex */
    public class e implements th3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ View c;
        public final /* synthetic */ r22 d;

        /* loaded from: classes8.dex */
        public class a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s22 a;
            public final /* synthetic */ e b;

            public a(e eVar, s22 s22Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, s22Var};
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
                this.a = s22Var;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view2) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (!this.a.X && (inputMethodManager = (InputMethodManager) this.b.b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.b.a.getWindowToken(), 0);
                    }
                    g32.i("Component-TextArea", "send confirm change callback");
                    e eVar = this.b;
                    eVar.d.H0(eVar.a, "confirm");
                }
            }
        }

        public e(r22 r22Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, swanEditText, swanAppActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r22Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = view2;
        }

        @Override // com.baidu.tieba.th3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (this.d.k != 0) {
                    this.d.k = 0;
                    if (this.d.j.E3().getScrollY() > 0) {
                        this.d.j.E3().setScrollY(0);
                        this.d.p = false;
                    }
                    if (this.d.o != null && this.d.o.getVisibility() == 0) {
                        ((FrameLayout) this.c.findViewById(16908290)).removeView(this.d.o);
                        this.d.o = null;
                    }
                }
                if (this.a.hasFocus()) {
                    this.a.clearFocus();
                    if (w12.h) {
                        Log.d("Component-TextArea", "clearFocus");
                    }
                }
            }
        }

        @Override // com.baidu.tieba.th3
        public void b(String str, int i) {
            int i2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                s22 s22Var = (s22) this.d.n();
                os1 i5 = tr2.V().i();
                if (this.d.k != i && this.a.hasFocus() && i5 != null) {
                    this.d.k = i;
                    this.d.n = this.a.getHeight();
                    this.d.H0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                    boolean z = s22Var.f1160T;
                    if (s22Var.S) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        i2 = xj3.g(38.0f);
                        if (this.d.o == null) {
                            this.d.o = new ShowConfirmBarLayout(this.b);
                            this.d.o.setOnConfirmButtonClickListener(new a(this, s22Var));
                            layoutParams.topMargin = ((this.c.getHeight() - i) - i2) - qj3.c();
                            ((FrameLayout) this.c.findViewById(16908290)).addView(this.d.o, layoutParams);
                        }
                    } else {
                        i2 = 0;
                    }
                    if (z) {
                        if (!s22Var.R) {
                            i3 = i5.getWebViewScrollY();
                        } else {
                            i3 = 0;
                        }
                        mw2 mw2Var = s22Var.h;
                        if (mw2Var != null) {
                            i4 = mw2Var.e();
                        } else {
                            i4 = 0;
                        }
                        int height = ((this.d.j.E3().getHeight() - i4) - this.a.getHeight()) + i3;
                        int i6 = s22Var.E;
                        if (height - i6 < i) {
                            this.d.p = true;
                            if (i6 > height) {
                                this.d.j.E3().setScrollY(i + i2);
                                return;
                            } else {
                                this.d.j.E3().setScrollY((i - height) + i6 + i2);
                                return;
                            }
                        }
                        this.d.p = false;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.th3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.d.q != this.a.getLineCount()) {
                g32.i("Component-TextArea", "send line change callback");
                this.d.H0(this.a, "linechange");
                this.d.G0(this.a, str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s22 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ r22 c;

        public a(r22 r22Var, s22 s22Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, s22Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r22Var;
            this.a = s22Var;
            this.b = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.i == null) {
                    z22.a("Component-TextArea", "activity is null, set textarea attr failed");
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

    /* loaded from: classes8.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ r22 b;

        public b(r22 r22Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r22Var;
            this.a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.H0(this.a, "selection");
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ r22 b;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public c(r22 r22Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r22Var;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || !this.a.hasFocus()) {
                return;
            }
            g32.i("Component-TextArea", "send input callback");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            char charAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.getLineCount() > 0) {
                if (this.b.q != this.a.getLineCount()) {
                    g32.i("Component-TextArea", "send line change callback");
                    this.b.H0(this.a, "linechange");
                }
                int i4 = i3 - i2;
                if (i2 != i4) {
                    if (i2 > i4) {
                        charAt = '\b';
                    } else {
                        charAt = charSequence.charAt((i + i4) - 1);
                    }
                    this.b.I0(this.a, "input", charAt);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ r22 b;

        public d(r22 r22Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r22Var;
            this.a = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (w12.h) {
                    Log.d("Component-TextArea", "onFocusChange:" + z);
                }
                if (z) {
                    if (this.b.k != 0) {
                        this.b.H0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                    }
                    this.b.L0();
                    return;
                }
                this.b.H0(this.a, ConstPath.KEY_BLUR);
                this.b.K0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ r22 c;

        public f(r22 r22Var, SwanEditText swanEditText, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, swanEditText, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r22Var;
            this.a = swanEditText;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null) {
                JSONObject jSONObject = new JSONObject();
                String obj = this.a.getTag().toString();
                if (!TextUtils.equals(obj, ((s22) this.c.n()).b)) {
                    z22.a("Component-TextArea", "changeTextAreaStatus with different id");
                }
                int F0 = this.c.F0(this.a);
                try {
                    jSONObject.put("eventName", this.b);
                    jSONObject.put("value", this.a.getText().toString());
                    jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                    jSONObject.put("selectionStart", this.a.getSelectionStart());
                    jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                    jSONObject.put("lineCount", this.a.getLineCount());
                    jSONObject.put("height", "" + xj3.O(F0));
                    jSONObject.put("keyboardHeight", "" + xj3.O((float) this.c.k));
                } catch (JSONException e) {
                    if (w12.h) {
                        e.printStackTrace();
                    }
                }
                if (w12.h) {
                    Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
                }
                this.c.l.a(obj, this.c.m, jSONObject);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ r22 d;

        public g(r22 r22Var, SwanEditText swanEditText, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, swanEditText, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r22Var;
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
                if (!TextUtils.equals(obj, ((s22) this.d.n()).b)) {
                    z22.a("Component-TextArea", "changeTextAreaStatus with different id");
                }
                int F0 = this.d.F0(this.a);
                try {
                    jSONObject.put("eventName", this.b);
                    jSONObject.put("value", this.a.getText().toString());
                    jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                    jSONObject.put("selectionStart", this.a.getSelectionStart());
                    jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                    jSONObject.put("lineCount", this.a.getLineCount());
                    jSONObject.put("height", "" + xj3.O(F0));
                    jSONObject.put("keyboardHeight", "" + xj3.O((float) this.d.k));
                    jSONObject.put("keyCode", this.c);
                } catch (JSONException e) {
                    if (w12.h) {
                        e.printStackTrace();
                    }
                }
                if (w12.h) {
                    Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
                }
                this.d.l.a(obj, this.d.m, jSONObject);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ s22 b;
        public final /* synthetic */ r22 c;

        public h(r22 r22Var, SwanEditText swanEditText, s22 s22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, swanEditText, s22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r22Var;
            this.a = swanEditText;
            this.b = s22Var;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i >= 2 && i <= 7) {
                    this.c.H0(this.a, "confirm");
                }
                return this.b.X;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r22(@Nullable Context context, @NonNull s22 s22Var, @NonNull SwanAppActivity swanAppActivity, @NonNull o52 o52Var, @NonNull i iVar) {
        super(context, s22Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, s22Var, swanAppActivity, o52Var, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (o12) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = 1;
        this.i = swanAppActivity;
        this.j = o52Var;
        this.l = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w12
    @NonNull
    /* renamed from: M0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            return new SwanEditText(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w12
    /* renamed from: N0 */
    public void B(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            super.B(swanEditText);
            s22 s22Var = (s22) n();
            swanEditText.setTag(s22Var.b);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = s22Var.e;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n12
    /* renamed from: Q0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull s22 s22Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, swanEditText, s22Var) == null) {
            Editable text = swanEditText.getText();
            if (text != null) {
                i2 = text.length();
            } else {
                i2 = 0;
            }
            if (s22Var.P) {
                int i3 = s22Var.F;
                if (i3 <= i2 && i3 >= 0) {
                    swanEditText.setSelection(i3);
                } else {
                    swanEditText.setSelection(i2);
                }
            }
        }
    }

    public final void R0(@NonNull SwanEditText swanEditText, @NonNull s22 s22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, s22Var) == null) {
            if (w12.h) {
                Log.d("Component-TextArea", "renderDisable");
            }
            swanEditText.setEnabled(!s22Var.W);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s12
    /* renamed from: V0 */
    public void Z(@NonNull SwanEditText swanEditText, @NonNull s22 s22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, s22Var) == null) {
            super.a0(swanEditText, s22Var, 48);
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppActivity activity = tr2.V().getActivity();
            if (activity == null) {
                g32.o("Component-TextArea", "activity is null when open input");
                return;
            }
            if (w12.h) {
                Log.d("Component-TextArea", "forceOpenKeyboard");
            }
            hj3.b(activity, true);
        }
    }

    public final int F0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText)) == null) {
            s22 s22Var = (s22) n();
            int lineCount = swanEditText.getLineCount();
            int lineHeight = swanEditText.getLineHeight();
            int i2 = s22Var.U;
            int i3 = s22Var.V;
            int height = swanEditText.getHeight();
            if (s22Var.Q) {
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

    public void W0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (!TextUtils.equals(((s22) n()).b, str)) {
                z22.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                z22.a("Component-TextArea", "sendLineChangeEvent with a null editText");
            } else {
                H0(swanEditText, "linechange");
            }
        }
    }

    public final void G0(SwanEditText swanEditText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, swanEditText, str) == null) {
            s22 s22Var = (s22) n();
            if (!TextUtils.equals(str, s22Var.b)) {
                z22.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = s22Var.f1160T;
            if (swanEditText.hasFocus() && !s22Var.R) {
                if (this.k > 0 && z && this.p) {
                    int scrollY = this.j.E3().getScrollY() + (swanEditText.getHeight() - this.n);
                    if (scrollY > 0) {
                        this.j.E3().setScrollY(scrollY);
                    } else {
                        this.j.E3().setScrollY(0);
                    }
                }
                this.n = swanEditText.getHeight();
            }
        }
    }

    public final void S0(@NonNull SwanEditText swanEditText, @NonNull s22 s22Var) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanEditText, s22Var) == null) {
            if (w12.h) {
                Log.d("Component-TextArea", "renderPlaceHolder");
            }
            SpannableString spannableString = new SpannableString(s22Var.L);
            String str = s22Var.N;
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
            spannableString.setSpan(styleSpan, 0, s22Var.L.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.t(s22Var.O)), 0, s22Var.L.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(s22Var.M, true), 0, s22Var.L.length(), 33);
            swanEditText.setHint(spannableString);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void H0(SwanEditText swanEditText, String str) {
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
                                ((s22) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
                            }
                        } else {
                            ((s22) n()).q(false);
                        }
                    } else {
                        ((s22) n()).q(true);
                    }
                } else {
                    ((s22) n()).j(swanEditText.getText().toString());
                }
            } else {
                this.q = swanEditText.getLineCount();
                ((s22) n()).m(swanEditText.getHeight());
            }
            ak3.a0(new f(this, swanEditText, str));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void I0(SwanEditText swanEditText, String str, int i2) {
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
                                ((s22) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
                            }
                        } else {
                            ((s22) n()).q(false);
                        }
                    } else {
                        ((s22) n()).q(true);
                    }
                } else {
                    ((s22) n()).j(swanEditText.getText().toString());
                }
            } else {
                this.q = swanEditText.getLineCount();
                ((s22) n()).m(swanEditText.getHeight());
            }
            ak3.a0(new g(this, swanEditText, str, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n12, com.baidu.tieba.s12, com.baidu.tieba.u12, com.baidu.tieba.w12
    @NonNull
    /* renamed from: J0 */
    public y22 k(@NonNull s22 s22Var, @NonNull s22 s22Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, s22Var, s22Var2)) == null) {
            y22 k = super.k(s22Var, s22Var2);
            if (!TextUtils.equals(s22Var.L, s22Var2.L)) {
                k.b(14);
            }
            if (s22Var.M != s22Var2.M) {
                k.b(14);
            }
            if (!TextUtils.equals(s22Var.N, s22Var2.N)) {
                k.b(14);
            }
            if (!TextUtils.equals(s22Var.O, s22Var2.O)) {
                k.b(14);
            }
            if (s22Var.W != s22Var2.W) {
                k.b(15);
            }
            return k;
        }
        return (y22) invokeLL.objValue;
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SwanAppActivity activity = tr2.V().getActivity();
            if (activity == null) {
                g32.o("Component-TextArea", "activity is null when close input");
                return;
            }
            if (w12.h) {
                Log.d("Component-TextArea", "forceCloseKeyboard");
            }
            hj3.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s12
    /* renamed from: O0 */
    public void V(@NonNull SwanEditText swanEditText, @NonNull s22 s22Var, @NonNull y22 y22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, swanEditText, s22Var, y22Var) == null) {
            super.c0(swanEditText, s22Var, y22Var);
            if (y22Var.a(14)) {
                S0(swanEditText, s22Var);
            }
            boolean z = !t();
            if (z) {
                swanEditText.setMinHeight(s22Var.U);
                swanEditText.setMaxHeight(s22Var.V);
            }
            ak3.a0(new a(this, s22Var, swanEditText));
            if (y22Var.a(15)) {
                R0(swanEditText, s22Var);
            }
            if (z) {
                X0(swanEditText, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n12
    /* renamed from: P0 */
    public boolean e0(@NonNull SwanEditText swanEditText, @NonNull s22 s22Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, swanEditText, s22Var)) == null) {
            if (!TextUtils.isEmpty(s22Var.I) && !"default".equals(s22Var.I)) {
                boolean e0 = super.e0(swanEditText, s22Var);
                if (e0) {
                    swanEditText.setOnEditorActionListener(new h(this, swanEditText, s22Var));
                }
                return e0;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n12
    /* renamed from: T0 */
    public void h0(@NonNull SwanEditText swanEditText, @NonNull s22 s22Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, s22Var) == null) {
            Editable text = swanEditText.getText();
            if (text != null) {
                i2 = text.length();
            } else {
                i2 = 0;
            }
            int i4 = s22Var.H;
            if (i4 <= i2 && i4 > 0 && (i3 = s22Var.G) <= i4 && i3 > 0 && s22Var.P && !swanEditText.hasFocus()) {
                swanEditText.setSelection(s22Var.G, s22Var.H);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s12
    /* renamed from: U0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull s22 s22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, s22Var) == null) {
            if (w12.h) {
                Log.d("Component-TextArea", "renderText");
            }
            if (!TextUtils.equals(swanEditText.getText(), s22Var.t)) {
                swanEditText.setLineSpacing(s22Var.y, 1.0f);
                swanEditText.setText(s22Var.t);
            }
        }
    }

    public final void X0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, swanEditText, swanAppActivity) == null) {
            swanEditText.setSelectListener(new b(this, swanEditText));
            swanEditText.addTextChangedListener(new c(this, swanEditText));
            swanEditText.setOnFocusChangeListener(new d(this, swanEditText));
            uh3.g(((s22) n()).b, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}
