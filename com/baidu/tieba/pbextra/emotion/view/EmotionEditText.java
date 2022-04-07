package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dz8;
import com.repackage.oi;
/* loaded from: classes3.dex */
public class EmotionEditText extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText a;
    public ImageView b;
    public ImageView c;
    public int d;
    public float e;
    public float f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;
    public TextView l;
    public boolean m;
    public int n;
    public float o;
    public int p;
    public int q;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditText a;

        public a(EmotionEditText emotionEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.e = motionEvent.getRawX();
                    this.a.f = motionEvent.getRawY();
                    EmotionEditText emotionEditText = this.a;
                    emotionEditText.g = emotionEditText.e;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.a.getLeft(), this.a.getTop(), 0, 0);
                    this.a.setLayoutParams(layoutParams);
                    return true;
                } else if (action != 2) {
                    return true;
                } else {
                    float rawX = motionEvent.getRawX();
                    motionEvent.getRawY();
                    float f = rawX - this.a.g;
                    if (!this.a.s(motionEvent)) {
                        if (f > 0.0f) {
                            this.a.setSize(f);
                        } else {
                            this.a.setSize(f);
                        }
                    }
                    this.a.g = rawX;
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditText a;

        public b(EmotionEditText emotionEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.setText("");
                this.a.l.setText("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionEditText a;

        public c(EmotionEditText emotionEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionEditText;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0119  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            int width = (this.a.j - this.a.getWidth()) - this.a.getLeft();
            if (editable.toString().length() > this.a.l.getText().toString().length()) {
                float textSize = this.a.l.getTextSize();
                EmotionEditText emotionEditText = this.a;
                if (textSize > emotionEditText.v(emotionEditText.getContext(), this.a.i)) {
                    float textSize2 = this.a.l.getTextSize();
                    EmotionEditText emotionEditText2 = this.a;
                    if (textSize2 != emotionEditText2.v(emotionEditText2.getContext(), this.a.h) && width == 0) {
                        EmotionEditText emotionEditText3 = this.a;
                        emotionEditText3.setTextSize(2, emotionEditText3.t(emotionEditText3.getContext(), this.a.l.getTextSize()) - 1);
                        this.a.l.setText(editable.toString());
                        if (editable.toString().length() <= 0) {
                            this.a.a.setHint("");
                            this.a.l.setHint("");
                            return;
                        }
                        EmotionEditText emotionEditText4 = this.a;
                        emotionEditText4.setTextSize(2, emotionEditText4.h);
                        this.a.a.setHint(this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f053d));
                        this.a.l.setHint(this.a.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f053d));
                        return;
                    }
                }
            }
            if (editable.toString().length() < this.a.l.getText().toString().length() && width > 0) {
                float textSize3 = this.a.l.getTextSize();
                EmotionEditText emotionEditText5 = this.a;
                if (textSize3 != emotionEditText5.v(emotionEditText5.getContext(), this.a.h)) {
                    EmotionEditText emotionEditText6 = this.a;
                    emotionEditText6.setTextSize(2, emotionEditText6.t(emotionEditText6.getContext(), this.a.l.getTextSize()) + 1);
                }
            }
            this.a.l.setText(editable.toString());
            if (editable.toString().length() <= 0) {
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
    public EmotionEditText(Context context) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65551, this, f) == null) {
            int width = getWidth() - (this.d * 2);
            int height = getHeight() - (this.d * 2);
            if (this.p == 0 && this.q == 0) {
                this.p = width;
                this.q = height;
            }
            if (f >= 0.0f) {
                if (getLeft() + width >= this.j || getTop() + height >= this.k) {
                    return;
                }
                setTextSize(2, t(getContext(), this.l.getTextSize()) + 1);
            } else if (this.l.getTextSize() <= v(getContext(), this.i)) {
            } else {
                setTextSize(2, t(getContext(), this.l.getTextSize()) - 1);
            }
        }
    }

    public View getEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l.getText().toString() : (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l.getCurrentTextColor() : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l.getTextSize() : invokeV.floatValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.m) {
            return;
        }
        this.m = true;
        this.a.setVisibility(4);
        this.l.setVisibility(0);
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        setEditTextEnable(false);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
            this.d = dimensionPixelSize;
            this.n = dimensionPixelSize * 2;
            this.h = 24;
            this.i = 16;
            FrameLayout.LayoutParams q = q();
            addView(this.a, q);
            r(q);
            o();
            p();
            setTextSize(2, this.h);
            m();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.b = imageView;
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080711);
            this.b.setOnClickListener(new b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            ImageView imageView2 = this.b;
            int i = this.d;
            imageView2.setPadding(i, i, i, i);
            addView(this.b, layoutParams);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.c = imageView;
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080712);
            this.c.setOnTouchListener(new a(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            ImageView imageView2 = this.c;
            int i = this.d;
            imageView2.setPadding(0, 0, i, i);
            addView(this.c, layoutParams);
        }
    }

    public final FrameLayout.LayoutParams q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            EditText editText = new EditText(getContext());
            this.a = editText;
            editText.setHint(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f053d));
            this.a.setBackgroundDrawable(null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int i = this.n;
            layoutParams.setMargins(i, i, i, i);
            layoutParams.gravity = 17;
            EditText editText2 = this.a;
            int i2 = this.d;
            editText2.setPadding(i2, i2 / 2, i2, i2 / 2);
            this.a.setSingleLine();
            this.a.setIncludeFontPadding(false);
            this.a.getPaint().setFakeBoldText(true);
            this.a.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            dz8.l(this.a, R.drawable.obfuscated_res_0x7f0804bc);
            this.a.addTextChangedListener(new c(this));
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public final void r(FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, layoutParams) == null) {
            TextView textView = new TextView(getContext());
            this.l = textView;
            textView.setHint(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f053d));
            this.l.setBackgroundResource(R.drawable.obfuscated_res_0x7f080271);
            TextView textView2 = this.l;
            int i = this.d;
            textView2.setPadding(i, i / 2, i, i / 2);
            this.l.setSingleLine();
            this.l.setIncludeFontPadding(false);
            this.l.setEllipsize(TextUtils.TruncateAt.END);
            this.l.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            this.l.getPaint().setFakeBoldText(true);
            addView(this.l, layoutParams);
        }
    }

    public final boolean s(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getRawX() - this.e);
            float abs2 = Math.abs(motionEvent.getRawY() - this.f);
            float f = this.o;
            return abs < f && abs2 < f;
        }
        return invokeL.booleanValue;
    }

    public void setEditTextEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.a.setFocusable(true);
                this.a.setFocusableInTouchMode(true);
                this.a.requestFocus();
                return;
            }
            this.a.setFocusable(false);
            this.a.setFocusableInTouchMode(false);
        }
    }

    public void setMaxImageSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            this.j = i;
            this.k = i2;
            if (i < oi.k(getContext()) / 4) {
                setTextSize(2, this.i);
            }
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.a.setTextColor(i);
            this.l.setTextColor(i);
        }
    }

    public void setTextSize(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            if (this.a.getTextSize() != f) {
                this.a.setTextSize(i, f);
            }
            if (this.l.getTextSize() != f) {
                this.l.setTextSize(i, f);
            }
        }
    }

    public int t(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048592, this, context, f)) == null) ? (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.m) {
            this.m = false;
            this.a.setVisibility(0);
            this.l.setVisibility(4);
            this.b.setVisibility(4);
            this.c.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public int v(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048594, this, context, f)) == null) ? (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmotionEditText(Context context, AttributeSet attributeSet) {
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
    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
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
        this.o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        n();
    }
}
