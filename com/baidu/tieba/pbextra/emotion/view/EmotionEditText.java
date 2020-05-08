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
import com.baidu.tieba.R;
import java.lang.reflect.Field;
/* loaded from: classes9.dex */
public class EmotionEditText extends FrameLayout {
    private int eok;
    private int eol;
    private float gLb;
    private ImageView jQO;
    private ImageView jQP;
    private float jQQ;
    private int jQR;
    private int jQS;
    private boolean jQT;
    public int jQU;
    private int jQV;
    private int jQW;
    private float mDownX;
    private float mDownY;
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
        this.gLb = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.mMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
        this.jQU = this.mMargin * 2;
        this.jQR = 24;
        this.jQS = 16;
        FrameLayout.LayoutParams cFI = cFI();
        addView(this.mEditText, cFI);
        a(cFI);
        cFH();
        cFG();
        setTextSize(2, this.jQR);
        cFJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.gLb && Math.abs(motionEvent.getRawY() - this.mDownY) < this.gLb;
    }

    private void cFG() {
        this.jQP = new ImageView(getContext());
        this.jQP.setImageResource(R.drawable.icon_frame_enlarge_n);
        this.jQP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.mDownY = motionEvent.getRawY();
                        EmotionEditText.this.jQQ = EmotionEditText.this.mDownX;
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
                        float f = rawX - EmotionEditText.this.jQQ;
                        if (!EmotionEditText.this.D(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.jQQ = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.jQP.setPadding(0, 0, this.mMargin, this.mMargin);
        addView(this.jQP, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.mTextView.setBackgroundResource(R.drawable.bg_emotion_edit);
        this.mTextView.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void cFH() {
        this.jQO = new ImageView(getContext());
        this.jQO.setImageResource(R.drawable.icon_frame_close_n);
        this.jQO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionEditText.this.mEditText.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.jQO.setPadding(this.mMargin, this.mMargin, this.mMargin, this.mMargin);
        addView(this.jQO, layoutParams);
    }

    private FrameLayout.LayoutParams cFI() {
        this.mEditText = new EditText(getContext());
        this.mEditText.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.mEditText.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.jQU, this.jQU, this.jQU, this.jQU);
        layoutParams.gravity = 17;
        this.mEditText.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mEditText.setSingleLine();
        this.mEditText.setIncludeFontPadding(false);
        this.mEditText.getPaint().setFakeBoldText(true);
        this.mEditText.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.mEditText, Integer.valueOf((int) R.drawable.emotion_edittext_cursor));
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
                    int width = (EmotionEditText.this.eok - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.jQS) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.jQR) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.jQR)) {
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
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.jQR);
                    EmotionEditText.this.mEditText.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
                    EmotionEditText.this.mTextView.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.mMargin * 2);
        int height = getHeight() - (this.mMargin * 2);
        if (this.jQV == 0 && this.jQW == 0) {
            this.jQV = width;
            this.jQW = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.eok && getTop() + height < this.eol) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > h(getContext(), this.jQS)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.mEditText.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.eok = i;
        this.eol = i2;
        if (this.eok < l.getEquipmentWidth(getContext()) / 4) {
            setTextSize(2, this.jQS);
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

    public void cFJ() {
        if (!this.jQT) {
            this.jQT = true;
            this.mEditText.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.jQO.setVisibility(0);
            this.jQP.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void cFK() {
        if (this.jQT) {
            this.jQT = false;
            this.mEditText.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.jQO.setVisibility(4);
            this.jQP.setVisibility(4);
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

    public int h(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
