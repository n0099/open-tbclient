package com.baidu.tieba.view.widget.pickcover;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.ns4;
import com.baidu.tieba.pc9;
import com.baidu.tieba.qv4;
import com.baidu.tieba.rc9;
import com.baidu.tieba.uy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TextEditToolView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public EditText b;
    public ImageView c;
    public View d;
    public View e;
    public TBSpecificationBtn f;
    public uy8 g;
    public TextPaint h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public ViewTreeObserver.OnGlobalLayoutListener n;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextEditToolView a;

        public a(TextEditToolView textEditToolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textEditToolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textEditToolView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getContext() instanceof Activity)) {
                Rect rect = new Rect();
                ((Activity) this.a.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.a.i == 0) {
                    this.a.i = height;
                    return;
                }
                int i = this.a.i - height;
                boolean z = i > this.a.i / 4;
                if (!z || this.a.j) {
                    if (!this.a.j || z) {
                        return;
                    }
                    this.a.j = false;
                    this.a.setVisibility(8);
                    if (this.a.g != null) {
                        this.a.g.n();
                        return;
                    }
                    return;
                }
                this.a.j = true;
                this.a.k = i;
                if (this.a.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
                    layoutParams.bottomMargin = this.a.k;
                    this.a.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextEditToolView a;

        public b(TextEditToolView textEditToolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textEditToolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textEditToolView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.m(editable.toString());
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
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextEditToolView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getToolsViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.k;
            if (i == 0) {
                return 0;
            }
            return i + this.e.getHeight();
        }
        return invokeV.intValue;
    }

    public final void i(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, view2) == null) || context == null || view2 == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 0);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getVisibility() == 8) {
            return;
        }
        this.m = false;
        this.b.setText("");
        i(getContext(), this.b);
    }

    public final void k(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, view2) == null) {
            this.m = true;
            view2.requestFocus();
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view2, 0);
        }
    }

    public void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) || getVisibility() == 0) {
            return;
        }
        if (z) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 80;
            if (this.j) {
                layoutParams.bottomMargin = this.k;
            }
            setLayoutParams(layoutParams);
        }
        this.m = false;
        if (!TextUtils.equals(str, pc9.l(R.string.obfuscated_res_0x7f0f1499))) {
            this.b.setText(str);
        }
        setVisibility(0);
        k(getContext(), this.b);
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            int i = this.l;
            if (this.h == null) {
                TextPaint textPaint = new TextPaint();
                this.h = textPaint;
                textPaint.setTextSize(pc9.j(R.dimen.obfuscated_res_0x7f0702b7));
            }
            StaticLayout staticLayout = new StaticLayout(str, this.h, rc9.c(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            if (staticLayout.getLineCount() > i) {
                str = str.substring(0, staticLayout.getLineStart(i) - 1);
                this.b.setText(str);
            }
            this.b.setSelection(this.b.getText() != null ? this.b.getText().length() : 0);
            uy8 uy8Var = this.g;
            if (uy8Var == null || !this.m) {
                return;
            }
            uy8Var.k(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2 == this.f) {
                String obj = this.b.getText().toString();
                j();
                uy8 uy8Var = this.g;
                if (uy8Var != null) {
                    uy8Var.g(obj);
                }
            } else if (view2 == this.c) {
                this.b.setText("");
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.n);
            }
        }
    }

    public void setMaxSingLanguageLine(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public void setOnTextWordsEditListener(uy8 uy8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uy8Var) == null) {
            this.g = uy8Var;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextEditToolView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextEditToolView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.m = true;
        this.n = new a(this);
        this.a = context;
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0501, this);
        this.e = findViewById(R.id.obfuscated_res_0x7f091269);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091275);
        this.d = findViewById;
        ns4 d = ns4.d(findViewById);
        d.n(R.string.J_X01);
        d.f(R.color.CAM_X0106);
        this.f = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f0920d6);
        qv4 qv4Var = new qv4();
        qv4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f.setConfig(qv4Var);
        this.f.setTextSize(R.dimen.T_X08);
        this.f.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0df2));
        this.b = (EditText) findViewById(R.id.obfuscated_res_0x7f09086e);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ebc);
        this.f.setOnClickListener(this);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.n);
        }
        this.b.addTextChangedListener(new b(this));
        this.c.setOnClickListener(this);
    }
}
