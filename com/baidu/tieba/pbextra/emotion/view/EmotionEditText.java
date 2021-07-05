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
import d.a.c.e.p.l;
import d.a.s0.a4.i;
/* loaded from: classes5.dex */
public class EmotionEditText extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditText f19929e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19930f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19931g;

    /* renamed from: h  reason: collision with root package name */
    public int f19932h;

    /* renamed from: i  reason: collision with root package name */
    public float f19933i;
    public float j;
    public float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public TextView p;
    public boolean q;
    public int r;
    public float s;
    public int t;
    public int u;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f19934e;

        public a(EmotionEditText emotionEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19934e = emotionEditText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f19934e.f19933i = motionEvent.getRawX();
                    this.f19934e.j = motionEvent.getRawY();
                    EmotionEditText emotionEditText = this.f19934e;
                    emotionEditText.k = emotionEditText.f19933i;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.f19934e.getLeft(), this.f19934e.getTop(), 0, 0);
                    this.f19934e.setLayoutParams(layoutParams);
                    return true;
                } else if (action != 2) {
                    return true;
                } else {
                    float rawX = motionEvent.getRawX();
                    motionEvent.getRawY();
                    float f2 = rawX - this.f19934e.k;
                    if (!this.f19934e.s(motionEvent)) {
                        if (f2 > 0.0f) {
                            this.f19934e.setSize(f2);
                        } else {
                            this.f19934e.setSize(f2);
                        }
                    }
                    this.f19934e.k = rawX;
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f19935e;

        public b(EmotionEditText emotionEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19935e = emotionEditText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19935e.f19929e.setText("");
                this.f19935e.p.setText("");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f19936e;

        public c(EmotionEditText emotionEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19936e = emotionEditText;
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
            int width = (this.f19936e.n - this.f19936e.getWidth()) - this.f19936e.getLeft();
            if (editable.toString().length() > this.f19936e.p.getText().toString().length()) {
                float textSize = this.f19936e.p.getTextSize();
                EmotionEditText emotionEditText = this.f19936e;
                if (textSize > emotionEditText.v(emotionEditText.getContext(), this.f19936e.m)) {
                    float textSize2 = this.f19936e.p.getTextSize();
                    EmotionEditText emotionEditText2 = this.f19936e;
                    if (textSize2 != emotionEditText2.v(emotionEditText2.getContext(), this.f19936e.l) && width == 0) {
                        EmotionEditText emotionEditText3 = this.f19936e;
                        emotionEditText3.setTextSize(2, emotionEditText3.t(emotionEditText3.getContext(), this.f19936e.p.getTextSize()) - 1);
                        this.f19936e.p.setText(editable.toString());
                        if (editable.toString().length() <= 0) {
                            this.f19936e.f19929e.setHint("");
                            this.f19936e.p.setHint("");
                            return;
                        }
                        EmotionEditText emotionEditText4 = this.f19936e;
                        emotionEditText4.setTextSize(2, emotionEditText4.l);
                        this.f19936e.f19929e.setHint(this.f19936e.getContext().getResources().getString(R.string.emotion_edit_hint));
                        this.f19936e.p.setHint(this.f19936e.getContext().getResources().getString(R.string.emotion_edit_hint));
                        return;
                    }
                }
            }
            if (editable.toString().length() < this.f19936e.p.getText().toString().length() && width > 0) {
                float textSize3 = this.f19936e.p.getTextSize();
                EmotionEditText emotionEditText5 = this.f19936e;
                if (textSize3 != emotionEditText5.v(emotionEditText5.getContext(), this.f19936e.l)) {
                    EmotionEditText emotionEditText6 = this.f19936e;
                    emotionEditText6.setTextSize(2, emotionEditText6.t(emotionEditText6.getContext(), this.f19936e.p.getTextSize()) + 1);
                }
            }
            this.f19936e.p.setText(editable.toString());
            if (editable.toString().length() <= 0) {
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
    public EmotionEditText(Context context) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65551, this, f2) == null) {
            int width = getWidth() - (this.f19932h * 2);
            int height = getHeight() - (this.f19932h * 2);
            if (this.t == 0 && this.u == 0) {
                this.t = width;
                this.u = height;
            }
            if (f2 >= 0.0f) {
                if (getLeft() + width >= this.n || getTop() + height >= this.o) {
                    return;
                }
                setTextSize(2, t(getContext(), this.p.getTextSize()) + 1);
            } else if (this.p.getTextSize() <= v(getContext(), this.m)) {
            } else {
                setTextSize(2, t(getContext(), this.p.getTextSize()) - 1);
            }
        }
    }

    public View getEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19929e : (View) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p.getText().toString() : (String) invokeV.objValue;
    }

    public int getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p.getCurrentTextColor() : invokeV.intValue;
    }

    public float getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p.getTextSize() : invokeV.floatValue;
    }

    public TextView getTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : (TextView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.q) {
            return;
        }
        this.q = true;
        this.f19929e.setVisibility(4);
        this.p.setVisibility(0);
        this.f19930f.setVisibility(0);
        this.f19931g.setVisibility(0);
        setEditTextEnable(false);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds20);
            this.f19932h = dimensionPixelSize;
            this.r = dimensionPixelSize * 2;
            this.l = 24;
            this.m = 16;
            FrameLayout.LayoutParams q = q();
            addView(this.f19929e, q);
            r(q);
            o();
            p();
            setTextSize(2, this.l);
            m();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f19930f = imageView;
            imageView.setImageResource(R.drawable.icon_frame_close_n);
            this.f19930f.setOnClickListener(new b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            ImageView imageView2 = this.f19930f;
            int i2 = this.f19932h;
            imageView2.setPadding(i2, i2, i2, i2);
            addView(this.f19930f, layoutParams);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f19931g = imageView;
            imageView.setImageResource(R.drawable.icon_frame_enlarge_n);
            this.f19931g.setOnTouchListener(new a(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            ImageView imageView2 = this.f19931g;
            int i2 = this.f19932h;
            imageView2.setPadding(0, 0, i2, i2);
            addView(this.f19931g, layoutParams);
        }
    }

    public final FrameLayout.LayoutParams q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            EditText editText = new EditText(getContext());
            this.f19929e = editText;
            editText.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
            this.f19929e.setBackgroundDrawable(null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int i2 = this.r;
            layoutParams.setMargins(i2, i2, i2, i2);
            layoutParams.gravity = 17;
            EditText editText2 = this.f19929e;
            int i3 = this.f19932h;
            editText2.setPadding(i3, i3 / 2, i3, i3 / 2);
            this.f19929e.setSingleLine();
            this.f19929e.setIncludeFontPadding(false);
            this.f19929e.getPaint().setFakeBoldText(true);
            this.f19929e.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            i.e(this.f19929e, R.drawable.emotion_edittext_cursor);
            this.f19929e.addTextChangedListener(new c(this));
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public final void r(FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, layoutParams) == null) {
            TextView textView = new TextView(getContext());
            this.p = textView;
            textView.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
            this.p.setBackgroundResource(R.drawable.bg_emotion_edit);
            TextView textView2 = this.p;
            int i2 = this.f19932h;
            textView2.setPadding(i2, i2 / 2, i2, i2 / 2);
            this.p.setSingleLine();
            this.p.setIncludeFontPadding(false);
            this.p.setEllipsize(TextUtils.TruncateAt.END);
            this.p.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            this.p.getPaint().setFakeBoldText(true);
            addView(this.p, layoutParams);
        }
    }

    public final boolean s(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getRawX() - this.f19933i);
            float abs2 = Math.abs(motionEvent.getRawY() - this.j);
            float f2 = this.s;
            return abs < f2 && abs2 < f2;
        }
        return invokeL.booleanValue;
    }

    public void setEditTextEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f19929e.setFocusable(true);
                this.f19929e.setFocusableInTouchMode(true);
                this.f19929e.requestFocus();
                return;
            }
            this.f19929e.setFocusable(false);
            this.f19929e.setFocusableInTouchMode(false);
        }
    }

    public void setMaxImageSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            this.n = i2;
            this.o = i3;
            if (i2 < l.k(getContext()) / 4) {
                setTextSize(2, this.m);
            }
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f19929e.setTextColor(i2);
            this.p.setTextColor(i2);
        }
    }

    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.f19929e.getTextSize() != f2) {
                this.f19929e.setTextSize(i2, f2);
            }
            if (this.p.getTextSize() != f2) {
                this.p.setTextSize(i2, f2);
            }
        }
    }

    public int t(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048592, this, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.q) {
            this.q = false;
            this.f19929e.setVisibility(0);
            this.p.setVisibility(4);
            this.f19930f.setVisibility(4);
            this.f19931g.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public int v(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048594, this, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
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
    public EmotionEditText(Context context, AttributeSet attributeSet, int i2) {
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
        this.s = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        n();
    }
}
