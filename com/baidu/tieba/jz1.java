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
/* loaded from: classes4.dex */
public final class jz1 extends ey1<SwanEditText, kz1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public g22 j;
    public int k;
    public i l;
    public String m;
    public int n;
    public ShowConfirmBarLayout o;
    public boolean p;
    public int q;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz1 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ jz1 c;

        public a(jz1 jz1Var, kz1 kz1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz1Var, kz1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jz1Var;
            this.a = kz1Var;
            this.b = swanEditText;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.i != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.c.i.getSystemService("input_method");
                    if (inputMethodManager == null || !this.a.P) {
                        return;
                    }
                    this.b.setFocusable(true);
                    this.b.setFocusableInTouchMode(true);
                    this.b.requestFocus();
                    inputMethodManager.showSoftInput(this.b, 0);
                    return;
                }
                rz1.a("Component-TextArea", "activity is null, set textarea attr failed");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SwanEditText.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ jz1 b;

        public b(jz1 jz1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jz1Var;
            this.a = swanEditText;
        }

        @Override // com.baidu.swan.apps.component.components.textarea.SwanEditText.a
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.b.F0(this.a, "selection");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ jz1 b;

        public c(jz1 jz1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jz1Var;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.hasFocus()) {
                yz1.i("Component-TextArea", "send input callback");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.getLineCount() <= 0) {
                return;
            }
            if (this.b.q != this.a.getLineCount()) {
                yz1.i("Component-TextArea", "send line change callback");
                this.b.F0(this.a, "linechange");
            }
            int i4 = i3 - i2;
            if (i2 != i4) {
                this.b.G0(this.a, "input", i2 > i4 ? '\b' : charSequence.charAt((i + i4) - 1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ jz1 b;

        public d(jz1 jz1Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz1Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jz1Var;
            this.a = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (ny1.h) {
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

    /* loaded from: classes4.dex */
    public class e implements le3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ View c;
        public final /* synthetic */ jz1 d;

        /* loaded from: classes4.dex */
        public class a implements ShowConfirmBarLayout.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ kz1 a;
            public final /* synthetic */ e b;

            public a(e eVar, kz1 kz1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, kz1Var};
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
                this.a = kz1Var;
            }

            @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
            public void onClick(View view2) {
                InputMethodManager inputMethodManager;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (!this.a.X && (inputMethodManager = (InputMethodManager) this.b.b.getSystemService("input_method")) != null) {
                        inputMethodManager.hideSoftInputFromWindow(this.b.a.getWindowToken(), 0);
                    }
                    yz1.i("Component-TextArea", "send confirm change callback");
                    e eVar = this.b;
                    eVar.d.F0(eVar.a, "confirm");
                }
            }
        }

        public e(jz1 jz1Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz1Var, swanEditText, swanAppActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jz1Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = view2;
        }

        @Override // com.baidu.tieba.le3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (this.d.k != 0) {
                    this.d.k = 0;
                    if (this.d.j.x3().getScrollY() > 0) {
                        this.d.j.x3().setScrollY(0);
                        this.d.p = false;
                    }
                    if (this.d.o != null && this.d.o.getVisibility() == 0) {
                        ((FrameLayout) this.c.findViewById(16908290)).removeView(this.d.o);
                        this.d.o = null;
                    }
                }
                if (this.a.hasFocus()) {
                    this.a.clearFocus();
                    if (ny1.h) {
                        Log.d("Component-TextArea", "clearFocus");
                    }
                }
            }
        }

        @Override // com.baidu.tieba.le3
        public void b(String str, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                kz1 kz1Var = (kz1) this.d.n();
                fp1 i3 = lo2.U().i();
                if (this.d.k == i || !this.a.hasFocus() || i3 == null) {
                    return;
                }
                this.d.k = i;
                this.d.n = this.a.getHeight();
                this.d.F0(this.a, AddFriendActivityConfig.TYPE_FOCUS);
                boolean z = kz1Var.T;
                if (kz1Var.S) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    i2 = pg3.g(38.0f);
                    if (this.d.o == null) {
                        this.d.o = new ShowConfirmBarLayout(this.b);
                        this.d.o.setOnConfirmButtonClickListener(new a(this, kz1Var));
                        layoutParams.topMargin = ((this.c.getHeight() - i) - i2) - ig3.c();
                        ((FrameLayout) this.c.findViewById(16908290)).addView(this.d.o, layoutParams);
                    }
                } else {
                    i2 = 0;
                }
                if (z) {
                    int webViewScrollY = !kz1Var.R ? i3.getWebViewScrollY() : 0;
                    et2 et2Var = kz1Var.h;
                    int height = ((this.d.j.x3().getHeight() - (et2Var != null ? et2Var.e() : 0)) - this.a.getHeight()) + webViewScrollY;
                    int i4 = kz1Var.E;
                    if (height - i4 < i) {
                        this.d.p = true;
                        if (i4 > height) {
                            this.d.j.x3().setScrollY(i + i2);
                            return;
                        } else {
                            this.d.j.x3().setScrollY((i - height) + i4 + i2);
                            return;
                        }
                    }
                    this.d.p = false;
                }
            }
        }

        @Override // com.baidu.tieba.le3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.d.q == this.a.getLineCount()) {
                return;
            }
            yz1.i("Component-TextArea", "send line change callback");
            this.d.F0(this.a, "linechange");
            this.d.E0(this.a, str);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jz1 c;

        public f(jz1 jz1Var, SwanEditText swanEditText, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz1Var, swanEditText, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jz1Var;
            this.a = swanEditText;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.a.getTag().toString();
            if (!TextUtils.equals(obj, ((kz1) this.c.n()).b)) {
                rz1.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.c.D0(this.a);
            try {
                jSONObject.put("eventName", this.b);
                jSONObject.put("value", this.a.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                jSONObject.put("selectionStart", this.a.getSelectionStart());
                jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                jSONObject.put("lineCount", this.a.getLineCount());
                jSONObject.put("height", "" + pg3.O(D0));
                jSONObject.put("keyboardHeight", "" + pg3.O((float) this.c.k));
            } catch (JSONException e) {
                if (ny1.h) {
                    e.printStackTrace();
                }
            }
            if (ny1.h) {
                Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
            }
            this.c.l.a(obj, this.c.m, jSONObject);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ jz1 d;

        public g(jz1 jz1Var, SwanEditText swanEditText, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz1Var, swanEditText, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jz1Var;
            this.a = swanEditText;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String obj = this.a.getTag().toString();
            if (!TextUtils.equals(obj, ((kz1) this.d.n()).b)) {
                rz1.a("Component-TextArea", "changeTextAreaStatus with different id");
            }
            int D0 = this.d.D0(this.a);
            try {
                jSONObject.put("eventName", this.b);
                jSONObject.put("value", this.a.getText().toString());
                jSONObject.put(Constants.EXTRA_CONFIG_CURSOR, this.a.getSelectionStart());
                jSONObject.put("selectionStart", this.a.getSelectionStart());
                jSONObject.put("selectionEnd", this.a.getSelectionEnd());
                jSONObject.put("lineCount", this.a.getLineCount());
                jSONObject.put("height", "" + pg3.O(D0));
                jSONObject.put("keyboardHeight", "" + pg3.O((float) this.d.k));
                jSONObject.put("keyCode", this.c);
            } catch (JSONException e) {
                if (ny1.h) {
                    e.printStackTrace();
                }
            }
            if (ny1.h) {
                Log.d("Component-TextArea", "changeTextAreaStatus:" + jSONObject.toString());
            }
            this.d.l.a(obj, this.d.m, jSONObject);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ kz1 b;
        public final /* synthetic */ jz1 c;

        public h(jz1 jz1Var, SwanEditText swanEditText, kz1 kz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz1Var, swanEditText, kz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jz1Var;
            this.a = swanEditText;
            this.b = kz1Var;
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

    /* loaded from: classes4.dex */
    public interface i {
        void a(String str, String str2, JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jz1(@Nullable Context context, @NonNull kz1 kz1Var, @NonNull SwanAppActivity swanAppActivity, @NonNull g22 g22Var, @NonNull i iVar) {
        super(context, kz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kz1Var, swanAppActivity, g22Var, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (fy1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = 1;
        this.i = swanAppActivity;
        this.j = g22Var;
        this.l = iVar;
    }

    public final int D0(SwanEditText swanEditText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText)) == null) {
            kz1 kz1Var = (kz1) n();
            int lineCount = swanEditText.getLineCount();
            int lineHeight = swanEditText.getLineHeight();
            int i2 = kz1Var.U;
            int i3 = kz1Var.V;
            int height = swanEditText.getHeight();
            if (kz1Var.Q) {
                int paddingTop = (lineHeight * lineCount) + swanEditText.getPaddingTop() + swanEditText.getPaddingBottom();
                if (i3 < i2) {
                    i3 = i2;
                }
                return paddingTop <= i2 ? i2 : paddingTop >= i3 ? i3 : paddingTop;
            }
            return height;
        }
        return invokeL.intValue;
    }

    public final void E0(SwanEditText swanEditText, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, swanEditText, str) == null) {
            kz1 kz1Var = (kz1) n();
            if (!TextUtils.equals(str, kz1Var.b)) {
                rz1.a("Component-TextArea", "keyBoardShow with different id");
            }
            boolean z = kz1Var.T;
            if (!swanEditText.hasFocus() || kz1Var.R) {
                return;
            }
            if (this.k > 0 && z && this.p) {
                int scrollY = this.j.x3().getScrollY() + (swanEditText.getHeight() - this.n);
                if (scrollY > 0) {
                    this.j.x3().setScrollY(scrollY);
                } else {
                    this.j.x3().setScrollY(0);
                }
            }
            this.n = swanEditText.getHeight();
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
            if (c2 == 0) {
                this.q = swanEditText.getLineCount();
                ((kz1) n()).m(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((kz1) n()).j(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((kz1) n()).q(true);
            } else if (c2 == 3) {
                ((kz1) n()).q(false);
            } else if (c2 == 4) {
                ((kz1) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            sg3.a0(new f(this, swanEditText, str));
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
            if (c2 == 0) {
                this.q = swanEditText.getLineCount();
                ((kz1) n()).m(swanEditText.getHeight());
            } else if (c2 == 1) {
                ((kz1) n()).j(swanEditText.getText().toString());
            } else if (c2 == 2) {
                ((kz1) n()).q(true);
            } else if (c2 == 3) {
                ((kz1) n()).q(false);
            } else if (c2 == 4) {
                ((kz1) n()).l(swanEditText.getSelectionStart(), swanEditText.getSelectionEnd());
            }
            sg3.a0(new g(this, swanEditText, str, i2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ey1, com.baidu.tieba.jy1, com.baidu.tieba.ly1, com.baidu.tieba.ny1
    @NonNull
    /* renamed from: H0 */
    public qz1 k(@NonNull kz1 kz1Var, @NonNull kz1 kz1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, kz1Var, kz1Var2)) == null) {
            qz1 k = super.k(kz1Var, kz1Var2);
            if (!TextUtils.equals(kz1Var.L, kz1Var2.L)) {
                k.b(14);
            }
            if (kz1Var.M != kz1Var2.M) {
                k.b(14);
            }
            if (!TextUtils.equals(kz1Var.N, kz1Var2.N)) {
                k.b(14);
            }
            if (!TextUtils.equals(kz1Var.O, kz1Var2.O)) {
                k.b(14);
            }
            if (kz1Var.W != kz1Var2.W) {
                k.b(15);
            }
            return k;
        }
        return (qz1) invokeLL.objValue;
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SwanAppActivity activity = lo2.U().getActivity();
            if (activity == null) {
                yz1.o("Component-TextArea", "activity is null when close input");
                return;
            }
            if (ny1.h) {
                Log.d("Component-TextArea", "forceCloseKeyboard");
            }
            zf3.a(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwanAppActivity activity = lo2.U().getActivity();
            if (activity == null) {
                yz1.o("Component-TextArea", "activity is null when open input");
                return;
            }
            if (ny1.h) {
                Log.d("Component-TextArea", "forceOpenKeyboard");
            }
            zf3.b(activity, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ny1
    @NonNull
    /* renamed from: K0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? new SwanEditText(context) : (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ny1
    /* renamed from: L0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            super.A(swanEditText);
            kz1 kz1Var = (kz1) n();
            swanEditText.setTag(kz1Var.b);
            swanEditText.setInputType(262144);
            swanEditText.setSingleLine(false);
            swanEditText.setHorizontallyScrolling(false);
            this.m = kz1Var.e;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ey1
    /* renamed from: M0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull kz1 kz1Var, @NonNull qz1 qz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, swanEditText, kz1Var, qz1Var) == null) {
            super.T(swanEditText, kz1Var, qz1Var);
            if (qz1Var.a(14)) {
                Q0(swanEditText, kz1Var);
            }
            boolean z = !t();
            if (z) {
                swanEditText.setMinHeight(kz1Var.U);
                swanEditText.setMaxHeight(kz1Var.V);
            }
            sg3.a0(new a(this, kz1Var, swanEditText));
            if (qz1Var.a(15)) {
                P0(swanEditText, kz1Var);
            }
            if (z) {
                V0(swanEditText, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ey1
    /* renamed from: N0 */
    public boolean c0(@NonNull SwanEditText swanEditText, @NonNull kz1 kz1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, swanEditText, kz1Var)) == null) {
            if (TextUtils.isEmpty(kz1Var.I) || "default".equals(kz1Var.I)) {
                return false;
            }
            boolean c0 = super.c0(swanEditText, kz1Var);
            if (c0) {
                swanEditText.setOnEditorActionListener(new h(this, swanEditText, kz1Var));
            }
            return c0;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ey1
    /* renamed from: O0 */
    public void d0(@NonNull SwanEditText swanEditText, @NonNull kz1 kz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, swanEditText, kz1Var) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            if (kz1Var.P) {
                int i2 = kz1Var.F;
                if (i2 <= length && i2 >= 0) {
                    swanEditText.setSelection(i2);
                } else {
                    swanEditText.setSelection(length);
                }
            }
        }
    }

    public final void P0(@NonNull SwanEditText swanEditText, @NonNull kz1 kz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, kz1Var) == null) {
            if (ny1.h) {
                Log.d("Component-TextArea", "renderDisable");
            }
            swanEditText.setEnabled(!kz1Var.W);
        }
    }

    public final void Q0(@NonNull SwanEditText swanEditText, @NonNull kz1 kz1Var) {
        StyleSpan styleSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanEditText, kz1Var) == null) {
            if (ny1.h) {
                Log.d("Component-TextArea", "renderPlaceHolder");
            }
            SpannableString spannableString = new SpannableString(kz1Var.L);
            String str = kz1Var.N;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode == 3029637 && str.equals("bold")) {
                    c2 = 1;
                }
            } else if (str.equals("normal")) {
                c2 = 0;
            }
            if (c2 == 0) {
                styleSpan = new StyleSpan(0);
            } else if (c2 != 1) {
                styleSpan = new StyleSpan(0);
            } else {
                styleSpan = new StyleSpan(1);
            }
            spannableString.setSpan(styleSpan, 0, kz1Var.L.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(SwanAppConfigData.t(kz1Var.O)), 0, kz1Var.L.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(kz1Var.M, true), 0, kz1Var.L.length(), 33);
            swanEditText.setHint(spannableString);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ey1
    /* renamed from: R0 */
    public void f0(@NonNull SwanEditText swanEditText, @NonNull kz1 kz1Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, kz1Var) == null) {
            Editable text = swanEditText.getText();
            int length = text != null ? text.length() : 0;
            int i3 = kz1Var.H;
            if (i3 > length || i3 <= 0 || (i2 = kz1Var.G) > i3 || i2 <= 0 || !kz1Var.P || swanEditText.hasFocus()) {
                return;
            }
            swanEditText.setSelection(kz1Var.G, kz1Var.H);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jy1
    /* renamed from: S0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull kz1 kz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, swanEditText, kz1Var) == null) {
            if (ny1.h) {
                Log.d("Component-TextArea", "renderText");
            }
            if (TextUtils.equals(swanEditText.getText(), kz1Var.t)) {
                return;
            }
            swanEditText.setLineSpacing(kz1Var.y, 1.0f);
            swanEditText.setText(kz1Var.t);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jy1
    /* renamed from: T0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull kz1 kz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, swanEditText, kz1Var) == null) {
            super.Y(swanEditText, kz1Var, 48);
        }
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (!TextUtils.equals(((kz1) n()).b, str)) {
                rz1.a("Component-TextArea", "sendLineChangeEvent with different id");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                rz1.a("Component-TextArea", "sendLineChangeEvent with a null editText");
            } else {
                F0(swanEditText, "linechange");
            }
        }
    }

    public final void V0(SwanEditText swanEditText, @NonNull SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, swanEditText, swanAppActivity) == null) {
            swanEditText.setSelectListener(new b(this, swanEditText));
            swanEditText.addTextChangedListener(new c(this, swanEditText));
            swanEditText.setOnFocusChangeListener(new d(this, swanEditText));
            me3.g(((kz1) n()).b, swanAppActivity, new e(this, swanEditText, swanAppActivity, swanAppActivity.getWindow().getDecorView()));
        }
    }
}
