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
import c.a.e.e.p.l;
import c.a.p0.b4.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class EmotionEditText extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditText f55451e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55452f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55453g;

    /* renamed from: h  reason: collision with root package name */
    public int f55454h;

    /* renamed from: i  reason: collision with root package name */
    public float f55455i;

    /* renamed from: j  reason: collision with root package name */
    public float f55456j;
    public float k;
    public int l;
    public int m;
    public int mMarginParent;
    public int n;
    public int o;
    public TextView p;
    public boolean q;
    public float r;
    public int s;
    public int t;

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f55457e;

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
            this.f55457e = emotionEditText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f55457e.f55455i = motionEvent.getRawX();
                    this.f55457e.f55456j = motionEvent.getRawY();
                    EmotionEditText emotionEditText = this.f55457e;
                    emotionEditText.k = emotionEditText.f55455i;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(this.f55457e.getLeft(), this.f55457e.getTop(), 0, 0);
                    this.f55457e.setLayoutParams(layoutParams);
                    return true;
                } else if (action != 2) {
                    return true;
                } else {
                    float rawX = motionEvent.getRawX();
                    motionEvent.getRawY();
                    float f2 = rawX - this.f55457e.k;
                    if (!this.f55457e.r(motionEvent)) {
                        if (f2 > 0.0f) {
                            this.f55457e.setSize(f2);
                        } else {
                            this.f55457e.setSize(f2);
                        }
                    }
                    this.f55457e.k = rawX;
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f55458e;

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
            this.f55458e = emotionEditText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55458e.f55451e.setText("");
                this.f55458e.p.setText("");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionEditText f55459e;

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
            this.f55459e = emotionEditText;
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
            int width = (this.f55459e.n - this.f55459e.getWidth()) - this.f55459e.getLeft();
            if (editable.toString().length() > this.f55459e.p.getText().toString().length()) {
                float textSize = this.f55459e.p.getTextSize();
                EmotionEditText emotionEditText = this.f55459e;
                if (textSize > emotionEditText.sp2px(emotionEditText.getContext(), this.f55459e.m)) {
                    float textSize2 = this.f55459e.p.getTextSize();
                    EmotionEditText emotionEditText2 = this.f55459e;
                    if (textSize2 != emotionEditText2.sp2px(emotionEditText2.getContext(), this.f55459e.l) && width == 0) {
                        EmotionEditText emotionEditText3 = this.f55459e;
                        emotionEditText3.setTextSize(2, emotionEditText3.px2sp(emotionEditText3.getContext(), this.f55459e.p.getTextSize()) - 1);
                        this.f55459e.p.setText(editable.toString());
                        if (editable.toString().length() <= 0) {
                            this.f55459e.f55451e.setHint("");
                            this.f55459e.p.setHint("");
                            return;
                        }
                        EmotionEditText emotionEditText4 = this.f55459e;
                        emotionEditText4.setTextSize(2, emotionEditText4.l);
                        this.f55459e.f55451e.setHint(this.f55459e.getContext().getResources().getString(R.string.emotion_edit_hint));
                        this.f55459e.p.setHint(this.f55459e.getContext().getResources().getString(R.string.emotion_edit_hint));
                        return;
                    }
                }
            }
            if (editable.toString().length() < this.f55459e.p.getText().toString().length() && width > 0) {
                float textSize3 = this.f55459e.p.getTextSize();
                EmotionEditText emotionEditText5 = this.f55459e;
                if (textSize3 != emotionEditText5.sp2px(emotionEditText5.getContext(), this.f55459e.l)) {
                    EmotionEditText emotionEditText6 = this.f55459e;
                    emotionEditText6.setTextSize(2, emotionEditText6.px2sp(emotionEditText6.getContext(), this.f55459e.p.getTextSize()) + 1);
                }
            }
            this.f55459e.p.setText(editable.toString());
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
            int width = getWidth() - (this.f55454h * 2);
            int height = getHeight() - (this.f55454h * 2);
            if (this.s == 0 && this.t == 0) {
                this.s = width;
                this.t = height;
            }
            if (f2 >= 0.0f) {
                if (getLeft() + width >= this.n || getTop() + height >= this.o) {
                    return;
                }
                setTextSize(2, px2sp(getContext(), this.p.getTextSize()) + 1);
            } else if (this.p.getTextSize() <= sp2px(getContext(), this.m)) {
            } else {
                setTextSize(2, px2sp(getContext(), this.p.getTextSize()) - 1);
            }
        }
    }

    public View getEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55451e : (View) invokeV.objValue;
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

    public void hideEditText() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.q) {
            return;
        }
        this.q = true;
        this.f55451e.setVisibility(4);
        this.p.setVisibility(0);
        this.f55452f.setVisibility(0);
        this.f55453g.setVisibility(0);
        setEditTextEnable(false);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds20);
            this.f55454h = dimensionPixelSize;
            this.mMarginParent = dimensionPixelSize * 2;
            this.l = 24;
            this.m = 16;
            FrameLayout.LayoutParams p = p();
            addView(this.f55451e, p);
            q(p);
            n();
            o();
            setTextSize(2, this.l);
            hideEditText();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f55452f = imageView;
            imageView.setImageResource(R.drawable.icon_frame_close_n);
            this.f55452f.setOnClickListener(new b(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            ImageView imageView2 = this.f55452f;
            int i2 = this.f55454h;
            imageView2.setPadding(i2, i2, i2, i2);
            addView(this.f55452f, layoutParams);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f55453g = imageView;
            imageView.setImageResource(R.drawable.icon_frame_enlarge_n);
            this.f55453g.setOnTouchListener(new a(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            ImageView imageView2 = this.f55453g;
            int i2 = this.f55454h;
            imageView2.setPadding(0, 0, i2, i2);
            addView(this.f55453g, layoutParams);
        }
    }

    public final FrameLayout.LayoutParams p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            EditText editText = new EditText(getContext());
            this.f55451e = editText;
            editText.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
            this.f55451e.setBackgroundDrawable(null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int i2 = this.mMarginParent;
            layoutParams.setMargins(i2, i2, i2, i2);
            layoutParams.gravity = 17;
            EditText editText2 = this.f55451e;
            int i3 = this.f55454h;
            editText2.setPadding(i3, i3 / 2, i3, i3 / 2);
            this.f55451e.setSingleLine();
            this.f55451e.setIncludeFontPadding(false);
            this.f55451e.getPaint().setFakeBoldText(true);
            this.f55451e.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            i.e(this.f55451e, R.drawable.emotion_edittext_cursor);
            this.f55451e.addTextChangedListener(new c(this));
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public int px2sp(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048586, this, context, f2)) == null) ? (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f) : invokeLF.intValue;
    }

    public final void q(FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, layoutParams) == null) {
            TextView textView = new TextView(getContext());
            this.p = textView;
            textView.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
            this.p.setBackgroundResource(R.drawable.bg_emotion_edit);
            TextView textView2 = this.p;
            int i2 = this.f55454h;
            textView2.setPadding(i2, i2 / 2, i2, i2 / 2);
            this.p.setSingleLine();
            this.p.setIncludeFontPadding(false);
            this.p.setEllipsize(TextUtils.TruncateAt.END);
            this.p.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            this.p.getPaint().setFakeBoldText(true);
            addView(this.p, layoutParams);
        }
    }

    public final boolean r(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getRawX() - this.f55455i);
            float abs2 = Math.abs(motionEvent.getRawY() - this.f55456j);
            float f2 = this.r;
            return abs < f2 && abs2 < f2;
        }
        return invokeL.booleanValue;
    }

    public void setEditTextEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.f55451e.setFocusable(true);
                this.f55451e.setFocusableInTouchMode(true);
                this.f55451e.requestFocus();
                return;
            }
            this.f55451e.setFocusable(false);
            this.f55451e.setFocusableInTouchMode(false);
        }
    }

    public void setMaxImageSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            this.n = i2;
            this.o = i3;
            if (i2 < l.k(getContext()) / 4) {
                setTextSize(2, this.m);
            }
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f55451e.setTextColor(i2);
            this.p.setTextColor(i2);
        }
    }

    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.f55451e.getTextSize() != f2) {
                this.f55451e.setTextSize(i2, f2);
            }
            if (this.p.getTextSize() != f2) {
                this.p.setTextSize(i2, f2);
            }
        }
    }

    public void showEditText() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.q) {
            this.q = false;
            this.f55451e.setVisibility(0);
            this.p.setVisibility(4);
            this.f55452f.setVisibility(4);
            this.f55453g.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public int sp2px(Context context, float f2) {
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
        this.r = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        m();
    }
}
