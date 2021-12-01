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
import c.a.q0.s.u.c;
import c.a.x0.t.t;
import c.a.x0.t.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class TextEditToolView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f50698e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f50699f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f50700g;

    /* renamed from: h  reason: collision with root package name */
    public View f50701h;

    /* renamed from: i  reason: collision with root package name */
    public View f50702i;

    /* renamed from: j  reason: collision with root package name */
    public TBSpecificationBtn f50703j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.r0.k4.m.d.a f50704k;
    public TextPaint l;
    public int m;
    public boolean n;
    public int o;
    public int p;
    public boolean q;
    public ViewTreeObserver.OnGlobalLayoutListener r;

    /* loaded from: classes11.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextEditToolView f50705e;

        public a(TextEditToolView textEditToolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textEditToolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50705e = textEditToolView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f50705e.getContext() instanceof Activity)) {
                Rect rect = new Rect();
                ((Activity) this.f50705e.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f50705e.m == 0) {
                    this.f50705e.m = height;
                    return;
                }
                int i2 = this.f50705e.m - height;
                boolean z = i2 > this.f50705e.m / 4;
                if (!z || this.f50705e.n) {
                    if (!this.f50705e.n || z) {
                        return;
                    }
                    this.f50705e.n = false;
                    this.f50705e.setVisibility(8);
                    if (this.f50705e.f50704k != null) {
                        this.f50705e.f50704k.l();
                        return;
                    }
                    return;
                }
                this.f50705e.n = true;
                this.f50705e.o = i2;
                if (this.f50705e.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f50705e.getLayoutParams();
                    layoutParams.bottomMargin = this.f50705e.o;
                    this.f50705e.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextEditToolView f50706e;

        public b(TextEditToolView textEditToolView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textEditToolView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50706e = textEditToolView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f50706e.k(editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = this.o;
            if (i2 == 0) {
                return 0;
            }
            return i2 + this.f50702i.getHeight();
        }
        return invokeV.intValue;
    }

    public void hideToolView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || getVisibility() == 8) {
            return;
        }
        this.q = false;
        this.f50699f.setText("");
        i(getContext(), this.f50699f);
    }

    public final void i(Context context, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, view) == null) || context == null || view == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    public final void j(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, view) == null) {
            this.q = true;
            view.requestFocus();
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            int i2 = this.p;
            if (this.l == null) {
                TextPaint textPaint = new TextPaint();
                this.l = textPaint;
                textPaint.setTextSize(t.j(R.dimen.fontsize32));
            }
            StaticLayout staticLayout = new StaticLayout(str, this.l, v.c(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            if (staticLayout.getLineCount() > i2) {
                str = str.substring(0, staticLayout.getLineStart(i2) - 1);
                this.f50699f.setText(str);
            }
            this.f50699f.setSelection(this.f50699f.getText() != null ? this.f50699f.getText().length() : 0);
            c.a.r0.k4.m.d.a aVar = this.f50704k;
            if (aVar == null || !this.q) {
                return;
            }
            aVar.i(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view == this.f50703j) {
                String obj = this.f50699f.getText().toString();
                hideToolView();
                c.a.r0.k4.m.d.a aVar = this.f50704k;
                if (aVar != null) {
                    aVar.e(obj);
                }
            } else if (view == this.f50700g) {
                this.f50699f.setText("");
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.r);
            }
        }
    }

    public void setMaxSingLanguageLine(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setOnTextWordsEditListener(c.a.r0.k4.m.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f50704k = aVar;
        }
    }

    public void showToolView(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048586, this, z, str) == null) || getVisibility() == 0) {
            return;
        }
        if (z) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 80;
            if (this.n) {
                layoutParams.bottomMargin = this.o;
            }
            setLayoutParams(layoutParams);
        }
        this.q = false;
        if (!TextUtils.equals(str, t.l(R.string.ugc_capture_text_words_hint))) {
            this.f50699f.setText(str);
        }
        setVisibility(0);
        j(getContext(), this.f50699f);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextEditToolView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.q = true;
        this.r = new a(this);
        this.f50698e = context;
        FrameLayout.inflate(context, R.layout.layout_text_edit_tool_view, this);
        this.f50702i = findViewById(R.id.layout_edit_tool_edit);
        View findViewById = findViewById(R.id.layout_input_box);
        this.f50701h = findViewById;
        c d2 = c.d(findViewById);
        d2.n(R.string.J_X01);
        d2.f(R.color.CAM_X0106);
        this.f50703j = (TBSpecificationBtn) findViewById(R.id.text_ok);
        c.a.q0.s.g0.n.b bVar = new c.a.q0.s.g0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.f50703j.setConfig(bVar);
        this.f50703j.setTextSize(R.dimen.T_X08);
        this.f50703j.setText(this.f50698e.getResources().getString(R.string.pb_send_post));
        this.f50699f = (EditText) findViewById(R.id.edit_text_input);
        this.f50700g = (ImageView) findViewById(R.id.img_clear_text);
        this.f50703j.setOnClickListener(this);
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.r);
        }
        this.f50699f.addTextChangedListener(new b(this));
        this.f50700g.setOnClickListener(this);
    }
}
