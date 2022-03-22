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
import c.a.o0.r.v.c;
import c.a.v0.r.t;
import c.a.v0.r.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
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

    /* renamed from: b  reason: collision with root package name */
    public EditText f37219b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37220c;

    /* renamed from: d  reason: collision with root package name */
    public View f37221d;

    /* renamed from: e  reason: collision with root package name */
    public View f37222e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f37223f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.q4.n.d.a f37224g;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f37225h;
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
                    if (this.a.f37224g != null) {
                        this.a.f37224g.n();
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
            return i + this.f37222e.getHeight();
        }
        return invokeV.intValue;
    }

    public final void i(Context context, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, view) == null) || context == null || view == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getVisibility() == 8) {
            return;
        }
        this.m = false;
        this.f37219b.setText("");
        i(getContext(), this.f37219b);
    }

    public final void k(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, view) == null) {
            this.m = true;
            view.requestFocus();
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
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
        if (!TextUtils.equals(str, t.l(R.string.obfuscated_res_0x7f0f145d))) {
            this.f37219b.setText(str);
        }
        setVisibility(0);
        k(getContext(), this.f37219b);
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            int i = this.l;
            if (this.f37225h == null) {
                TextPaint textPaint = new TextPaint();
                this.f37225h = textPaint;
                textPaint.setTextSize(t.j(R.dimen.obfuscated_res_0x7f0702b7));
            }
            StaticLayout staticLayout = new StaticLayout(str, this.f37225h, v.c(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            if (staticLayout.getLineCount() > i) {
                str = str.substring(0, staticLayout.getLineStart(i) - 1);
                this.f37219b.setText(str);
            }
            this.f37219b.setSelection(this.f37219b.getText() != null ? this.f37219b.getText().length() : 0);
            c.a.p0.q4.n.d.a aVar = this.f37224g;
            if (aVar == null || !this.m) {
                return;
            }
            aVar.k(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view == this.f37223f) {
                String obj = this.f37219b.getText().toString();
                j();
                c.a.p0.q4.n.d.a aVar = this.f37224g;
                if (aVar != null) {
                    aVar.g(obj);
                }
            } else if (view == this.f37220c) {
                this.f37219b.setText("");
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

    public void setOnTextWordsEditListener(c.a.p0.q4.n.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f37224g = aVar;
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
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04ee, this);
        this.f37222e = findViewById(R.id.obfuscated_res_0x7f0911d5);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0911e1);
        this.f37221d = findViewById;
        c d2 = c.d(findViewById);
        d2.n(R.string.J_X01);
        d2.f(R.color.CAM_X0106);
        this.f37223f = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f091f44);
        c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f37223f.setConfig(bVar);
        this.f37223f.setTextSize(R.dimen.T_X08);
        this.f37223f.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dbe));
        this.f37219b = (EditText) findViewById(R.id.obfuscated_res_0x7f090862);
        this.f37220c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eaa);
        this.f37223f.setOnClickListener(this);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.n);
        }
        this.f37219b.addTextChangedListener(new b(this));
        this.f37220c.setOnClickListener(this);
    }
}
