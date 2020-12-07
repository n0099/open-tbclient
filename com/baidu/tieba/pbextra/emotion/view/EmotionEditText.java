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
import com.baidu.tieba.write.j;
/* loaded from: classes22.dex */
public class EmotionEditText extends FrameLayout {
    private float cBL;
    private int fOV;
    private int fOW;
    private float iFt;
    private float mDownX;
    private EditText mEditText;
    private int mMargin;
    private TextView mTextView;
    private int mhA;
    private boolean mhB;
    public int mhC;
    private int mhD;
    private int mhE;
    private ImageView mhw;
    private ImageView mhx;
    private float mhy;
    private int mhz;

    public EmotionEditText(Context context) {
        this(context, null);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iFt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.mMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
        this.mhC = this.mMargin * 2;
        this.mhz = 24;
        this.mhA = 16;
        FrameLayout.LayoutParams dxS = dxS();
        addView(this.mEditText, dxS);
        a(dxS);
        dxR();
        dxQ();
        setTextSize(2, this.mhz);
        dxT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iFt && Math.abs(motionEvent.getRawY() - this.cBL) < this.iFt;
    }

    private void dxQ() {
        this.mhx = new ImageView(getContext());
        this.mhx.setImageResource(R.drawable.icon_frame_enlarge_n);
        this.mhx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.cBL = motionEvent.getRawY();
                        EmotionEditText.this.mhy = EmotionEditText.this.mDownX;
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
                        float f = rawX - EmotionEditText.this.mhy;
                        if (!EmotionEditText.this.ab(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.mhy = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.mhx.setPadding(0, 0, this.mMargin, this.mMargin);
        addView(this.mhx, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.mTextView.setBackgroundResource(R.drawable.bg_emotion_edit);
        this.mTextView.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void dxR() {
        this.mhw = new ImageView(getContext());
        this.mhw.setImageResource(R.drawable.icon_frame_close_n);
        this.mhw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionEditText.this.mEditText.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mhw.setPadding(this.mMargin, this.mMargin, this.mMargin, this.mMargin);
        addView(this.mhw, layoutParams);
    }

    private FrameLayout.LayoutParams dxS() {
        this.mEditText = new EditText(getContext());
        this.mEditText.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.mEditText.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.mhC, this.mhC, this.mhC, this.mhC);
        layoutParams.gravity = 17;
        this.mEditText.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mEditText.setSingleLine();
        this.mEditText.setIncludeFontPadding(false);
        this.mEditText.getPaint().setFakeBoldText(true);
        this.mEditText.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        j.h(this.mEditText, R.drawable.emotion_edittext_cursor);
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
                    int width = (EmotionEditText.this.fOV - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mhA) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mhz) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mhz)) {
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
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.mhz);
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
        if (this.mhD == 0 && this.mhE == 0) {
            this.mhD = width;
            this.mhE = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.fOV && getTop() + height < this.fOW) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > h(getContext(), this.mhA)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.mEditText.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.fOV = i;
        this.fOW = i2;
        if (this.fOV < l.getEquipmentWidth(getContext()) / 4) {
            setTextSize(2, this.mhA);
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

    public void dxT() {
        if (!this.mhB) {
            this.mhB = true;
            this.mEditText.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.mhw.setVisibility(0);
            this.mhx.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void dxU() {
        if (this.mhB) {
            this.mhB = false;
            this.mEditText.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.mhw.setVisibility(4);
            this.mhx.setVisibility(4);
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
