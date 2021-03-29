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
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.u3.j;
/* loaded from: classes5.dex */
public class EmotionEditText extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public EditText f20207e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20208f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20209g;

    /* renamed from: h  reason: collision with root package name */
    public int f20210h;
    public float i;
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
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                EmotionEditText.this.i = motionEvent.getRawX();
                EmotionEditText.this.j = motionEvent.getRawY();
                EmotionEditText emotionEditText = EmotionEditText.this;
                emotionEditText.k = emotionEditText.i;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(EmotionEditText.this.getLeft(), EmotionEditText.this.getTop(), 0, 0);
                EmotionEditText.this.setLayoutParams(layoutParams);
                return true;
            } else if (action != 2) {
                return true;
            } else {
                float rawX = motionEvent.getRawX();
                motionEvent.getRawY();
                float f2 = rawX - EmotionEditText.this.k;
                if (!EmotionEditText.this.s(motionEvent)) {
                    if (f2 > 0.0f) {
                        EmotionEditText.this.setSize(f2);
                    } else {
                        EmotionEditText.this.setSize(f2);
                    }
                }
                EmotionEditText.this.k = rawX;
                return true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EmotionEditText.this.f20207e.setText("");
            EmotionEditText.this.p.setText("");
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0115  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            int width = (EmotionEditText.this.n - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
            if (editable.toString().length() > EmotionEditText.this.p.getText().toString().length()) {
                float textSize = EmotionEditText.this.p.getTextSize();
                EmotionEditText emotionEditText = EmotionEditText.this;
                if (textSize > emotionEditText.v(emotionEditText.getContext(), EmotionEditText.this.m)) {
                    float textSize2 = EmotionEditText.this.p.getTextSize();
                    EmotionEditText emotionEditText2 = EmotionEditText.this;
                    if (textSize2 != emotionEditText2.v(emotionEditText2.getContext(), EmotionEditText.this.l) && width == 0) {
                        EmotionEditText emotionEditText3 = EmotionEditText.this;
                        emotionEditText3.setTextSize(2, emotionEditText3.t(emotionEditText3.getContext(), EmotionEditText.this.p.getTextSize()) - 1);
                        EmotionEditText.this.p.setText(editable.toString());
                        if (editable.toString().length() <= 0) {
                            EmotionEditText.this.f20207e.setHint("");
                            EmotionEditText.this.p.setHint("");
                            return;
                        }
                        EmotionEditText emotionEditText4 = EmotionEditText.this;
                        emotionEditText4.setTextSize(2, emotionEditText4.l);
                        EmotionEditText.this.f20207e.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
                        EmotionEditText.this.p.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
                        return;
                    }
                }
            }
            if (editable.toString().length() < EmotionEditText.this.p.getText().toString().length() && width > 0) {
                float textSize3 = EmotionEditText.this.p.getTextSize();
                EmotionEditText emotionEditText5 = EmotionEditText.this;
                if (textSize3 != emotionEditText5.v(emotionEditText5.getContext(), EmotionEditText.this.l)) {
                    EmotionEditText emotionEditText6 = EmotionEditText.this;
                    emotionEditText6.setTextSize(2, emotionEditText6.t(emotionEditText6.getContext(), EmotionEditText.this.p.getTextSize()) + 1);
                }
            }
            EmotionEditText.this.p.setText(editable.toString());
            if (editable.toString().length() <= 0) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public EmotionEditText(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f2) {
        int width = getWidth() - (this.f20210h * 2);
        int height = getHeight() - (this.f20210h * 2);
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

    public View getEditText() {
        return this.f20207e;
    }

    public String getText() {
        return this.p.getText().toString();
    }

    public int getTextColor() {
        return this.p.getCurrentTextColor();
    }

    public float getTextSize() {
        return this.p.getTextSize();
    }

    public TextView getTextView() {
        return this.p;
    }

    public void m() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.f20207e.setVisibility(4);
        this.p.setVisibility(0);
        this.f20208f.setVisibility(0);
        this.f20209g.setVisibility(0);
        setEditTextEnable(false);
    }

    public final void n() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds20);
        this.f20210h = dimensionPixelSize;
        this.r = dimensionPixelSize * 2;
        this.l = 24;
        this.m = 16;
        FrameLayout.LayoutParams q = q();
        addView(this.f20207e, q);
        r(q);
        o();
        p();
        setTextSize(2, this.l);
        m();
    }

    public final void o() {
        ImageView imageView = new ImageView(getContext());
        this.f20208f = imageView;
        imageView.setImageResource(R.drawable.icon_frame_close_n);
        this.f20208f.setOnClickListener(new b());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        ImageView imageView2 = this.f20208f;
        int i = this.f20210h;
        imageView2.setPadding(i, i, i, i);
        addView(this.f20208f, layoutParams);
    }

    public final void p() {
        ImageView imageView = new ImageView(getContext());
        this.f20209g = imageView;
        imageView.setImageResource(R.drawable.icon_frame_enlarge_n);
        this.f20209g.setOnTouchListener(new a());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        ImageView imageView2 = this.f20209g;
        int i = this.f20210h;
        imageView2.setPadding(0, 0, i, i);
        addView(this.f20209g, layoutParams);
    }

    public final FrameLayout.LayoutParams q() {
        EditText editText = new EditText(getContext());
        this.f20207e = editText;
        editText.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.f20207e.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i = this.r;
        layoutParams.setMargins(i, i, i, i);
        layoutParams.gravity = 17;
        EditText editText2 = this.f20207e;
        int i2 = this.f20210h;
        editText2.setPadding(i2, i2 / 2, i2, i2 / 2);
        this.f20207e.setSingleLine();
        this.f20207e.setIncludeFontPadding(false);
        this.f20207e.getPaint().setFakeBoldText(true);
        this.f20207e.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        j.e(this.f20207e, R.drawable.emotion_edittext_cursor);
        this.f20207e.addTextChangedListener(new c());
        return layoutParams;
    }

    public final void r(FrameLayout.LayoutParams layoutParams) {
        TextView textView = new TextView(getContext());
        this.p = textView;
        textView.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.p.setBackgroundResource(R.drawable.bg_emotion_edit);
        TextView textView2 = this.p;
        int i = this.f20210h;
        textView2.setPadding(i, i / 2, i, i / 2);
        this.p.setSingleLine();
        this.p.setIncludeFontPadding(false);
        this.p.setEllipsize(TextUtils.TruncateAt.END);
        this.p.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.p.getPaint().setFakeBoldText(true);
        addView(this.p, layoutParams);
    }

    public final boolean s(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getRawX() - this.i);
        float abs2 = Math.abs(motionEvent.getRawY() - this.j);
        float f2 = this.s;
        return abs < f2 && abs2 < f2;
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.f20207e.setFocusable(true);
            this.f20207e.setFocusableInTouchMode(true);
            this.f20207e.requestFocus();
            return;
        }
        this.f20207e.setFocusable(false);
        this.f20207e.setFocusableInTouchMode(false);
    }

    public void setMaxImageSize(int i, int i2) {
        this.n = i;
        this.o = i2;
        if (i < l.k(getContext()) / 4) {
            setTextSize(2, this.m);
        }
    }

    public void setTextColor(int i) {
        this.f20207e.setTextColor(i);
        this.p.setTextColor(i);
    }

    public void setTextSize(int i, float f2) {
        if (this.f20207e.getTextSize() != f2) {
            this.f20207e.setTextSize(i, f2);
        }
        if (this.p.getTextSize() != f2) {
            this.p.setTextSize(i, f2);
        }
    }

    public int t(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void u() {
        if (this.q) {
            this.q = false;
            this.f20207e.setVisibility(0);
            this.p.setVisibility(4);
            this.f20208f.setVisibility(4);
            this.f20209g.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public int v(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        n();
    }
}
