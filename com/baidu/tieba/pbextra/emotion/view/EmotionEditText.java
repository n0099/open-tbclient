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
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class EmotionEditText extends FrameLayout {
    private int bdk;
    private int bdl;
    private float cUP;
    private float ccd;
    private ImageView fNW;
    private ImageView fNX;
    private float fNY;
    private int fNZ;
    private int fOa;
    private boolean fOb;
    public int fOc;
    private int fOd;
    private int fOe;
    private float mDownX;
    private EditText mEditText;
    private int mMargin;
    private TextView mTextView;

    public EmotionEditText(Context context) {
        this(context, null);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cUP = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.mMargin = getResources().getDimensionPixelSize(d.e.ds20);
        this.fOc = this.mMargin * 2;
        this.fNZ = 24;
        this.fOa = 16;
        FrameLayout.LayoutParams bil = bil();
        addView(this.mEditText, bil);
        a(bil);
        bik();
        bij();
        setTextSize(2, this.fNZ);
        bim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cUP && Math.abs(motionEvent.getRawY() - this.ccd) < this.cUP;
    }

    private void bij() {
        this.fNX = new ImageView(getContext());
        this.fNX.setImageResource(d.f.icon_frame_enlarge_n);
        this.fNX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.ccd = motionEvent.getRawY();
                        EmotionEditText.this.fNY = EmotionEditText.this.mDownX;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(EmotionEditText.this.getLeft(), EmotionEditText.this.getTop(), 0, 0);
                        EmotionEditText.this.setLayoutParams(layoutParams);
                        return true;
                    case 1:
                    default:
                        return true;
                    case 2:
                        float rawX = motionEvent.getRawX();
                        motionEvent.getRawY();
                        float f = rawX - EmotionEditText.this.fNY;
                        if (!EmotionEditText.this.F(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.fNY = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.fNX.setPadding(0, 0, this.mMargin, this.mMargin);
        addView(this.fNX, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(d.k.emotion_edit_hint));
        this.mTextView.setBackgroundResource(d.f.bg_emotion_edit);
        this.mTextView.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void bik() {
        this.fNW = new ImageView(getContext());
        this.fNW.setImageResource(d.f.icon_frame_close_n);
        this.fNW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionEditText.this.mEditText.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.fNW.setPadding(this.mMargin, this.mMargin, this.mMargin, this.mMargin);
        addView(this.fNW, layoutParams);
    }

    private FrameLayout.LayoutParams bil() {
        this.mEditText = new EditText(getContext());
        this.mEditText.setHint(getContext().getResources().getString(d.k.emotion_edit_hint));
        this.mEditText.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.fOc, this.fOc, this.fOc, this.fOc);
        layoutParams.gravity = 17;
        this.mEditText.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mEditText.setSingleLine();
        this.mEditText.setIncludeFontPadding(false);
        this.mEditText.getPaint().setFakeBoldText(true);
        this.mEditText.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.mEditText, Integer.valueOf(d.f.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (EmotionEditText.this.bdk - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fOa) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fNZ) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fNZ)) {
                            EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) - 1);
                    }
                    EmotionEditText.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        EmotionEditText.this.mEditText.setHint("");
                        EmotionEditText.this.mTextView.setHint("");
                        return;
                    }
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.fNZ);
                    EmotionEditText.this.mEditText.setHint(EmotionEditText.this.getContext().getResources().getString(d.k.emotion_edit_hint));
                    EmotionEditText.this.mTextView.setHint(EmotionEditText.this.getContext().getResources().getString(d.k.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.mMargin * 2);
        int height = getHeight() - (this.mMargin * 2);
        if (this.fOd == 0 && this.fOe == 0) {
            this.fOd = width;
            this.fOe = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.bdk && getTop() + height < this.bdl) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > e(getContext(), this.fOa)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.mEditText.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.bdk = i;
        this.bdl = i2;
        if (this.bdk < l.ah(getContext()) / 4) {
            setTextSize(2, this.fOa);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.mEditText.getTextSize() != f) {
            this.mEditText.setTextSize(i, f);
        }
        if (this.mTextView.getTextSize() != f) {
            this.mTextView.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.mEditText.setFocusable(true);
            this.mEditText.setFocusableInTouchMode(true);
            this.mEditText.requestFocus();
            return;
        }
        this.mEditText.setFocusable(false);
        this.mEditText.setFocusableInTouchMode(false);
    }

    public void bim() {
        if (!this.fOb) {
            this.fOb = true;
            this.mEditText.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.fNW.setVisibility(0);
            this.fNX.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void bin() {
        if (this.fOb) {
            this.fOb = false;
            this.mEditText.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.fNW.setVisibility(4);
            this.fNX.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public View getEditText() {
        return this.mEditText;
    }

    public String getText() {
        return this.mTextView.getText().toString();
    }

    public float getTextSize() {
        return this.mTextView.getTextSize();
    }

    public int getTextColor() {
        return this.mTextView.getCurrentTextColor();
    }

    public int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int e(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
