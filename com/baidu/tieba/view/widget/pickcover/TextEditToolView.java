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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.b65;
import com.baidu.tieba.bdb;
import com.baidu.tieba.kxb;
import com.baidu.tieba.mxb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class TextEditToolView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public EditText b;
    public ImageView c;
    public View d;
    public View e;
    public TBSpecificationBtn f;
    public bdb g;
    public TextPaint h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public ViewTreeObserver.OnGlobalLayoutListener n;

    /* loaded from: classes8.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getContext() instanceof Activity)) {
                Rect rect = new Rect();
                ((Activity) this.a.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.a.i != 0) {
                    int i = this.a.i - height;
                    if (i > this.a.i / 4) {
                        z = true;
                    } else {
                        z = false;
                    }
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
                        return;
                    }
                    return;
                }
                this.a.i = height;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextEditToolView a;

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
                this.a.n(editable.toString());
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2 == this.f) {
                String obj = this.b.getText().toString();
                j();
                bdb bdbVar = this.g;
                if (bdbVar != null) {
                    bdbVar.g(obj);
                }
            } else if (view2 == this.c) {
                this.b.setText("");
            }
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

    public void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048580, this, z, str) != null) || getVisibility() == 0) {
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
        if (!TextUtils.equals(str, kxb.l(R.string.obfuscated_res_0x7f0f1798))) {
            this.b.setText(str);
        }
        setVisibility(0);
        k(getContext(), this.b);
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
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d05cd, this);
        this.e = findViewById(R.id.obfuscated_res_0x7f091564);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091570);
        this.d = findViewById;
        EMManager.from(findViewById).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0106);
        this.f = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f0925a6);
        b65 b65Var = new b65();
        b65Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f.setConfig(b65Var);
        this.f.setTextSize(R.dimen.T_X08);
        this.f.setText(this.a.getResources().getString(R.string.pb_send_post));
        this.b = (EditText) findViewById(R.id.obfuscated_res_0x7f0909dd);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f09114c);
        this.f.setOnClickListener(this);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.n);
        }
        this.b.addTextChangedListener(new b(this));
        this.c.setOnClickListener(this);
    }

    public void setMaxSingLanguageLine(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public void setOnTextWordsEditListener(bdb bdbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdbVar) == null) {
            this.g = bdbVar;
        }
    }

    public final void i(Context context, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, view2) == null) && context != null && view2 != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 0);
        }
    }

    public final void k(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, view2) == null) {
            this.m = true;
            view2.requestFocus();
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view2, 0);
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

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getVisibility() == 8) {
            return;
        }
        this.m = false;
        this.b.setText("");
        i(getContext(), this.b);
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

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            int i = this.l;
            if (this.h == null) {
                TextPaint textPaint = new TextPaint();
                this.h = textPaint;
                textPaint.setTextSize(kxb.j(R.dimen.obfuscated_res_0x7f0702b7));
            }
            StaticLayout staticLayout = new StaticLayout(str, this.h, mxb.c(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            int i2 = 0;
            if (staticLayout.getLineCount() > i) {
                str = str.substring(0, staticLayout.getLineStart(i) - 1);
                this.b.setText(str);
            }
            if (this.b.getText() != null) {
                i2 = this.b.getText().length();
            }
            this.b.setSelection(i2);
            bdb bdbVar = this.g;
            if (bdbVar != null && this.m) {
                bdbVar.k(str);
            }
        }
    }
}
