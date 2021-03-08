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
/* loaded from: classes2.dex */
public class EmotionEditText extends FrameLayout {
    private EditText cCD;
    private float cFL;
    private int fXG;
    private int fXH;
    private float iUE;
    private float mDownX;
    private int mMargin;
    private TextView mTextView;
    private int mtA;
    private boolean mtB;
    public int mtC;
    private int mtD;
    private int mtE;
    private ImageView mtw;
    private ImageView mtx;
    private float mty;
    private int mtz;

    public EmotionEditText(Context context) {
        this(context, null);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.mMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
        this.mtC = this.mMargin * 2;
        this.mtz = 24;
        this.mtA = 16;
        FrameLayout.LayoutParams dwq = dwq();
        addView(this.cCD, dwq);
        a(dwq);
        dwp();
        dwo();
        setTextSize(2, this.mtz);
        dwr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iUE && Math.abs(motionEvent.getRawY() - this.cFL) < this.iUE;
    }

    private void dwo() {
        this.mtx = new ImageView(getContext());
        this.mtx.setImageResource(R.drawable.icon_frame_enlarge_n);
        this.mtx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.cFL = motionEvent.getRawY();
                        EmotionEditText.this.mty = EmotionEditText.this.mDownX;
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
                        float f = rawX - EmotionEditText.this.mty;
                        if (!EmotionEditText.this.ab(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.mty = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.mtx.setPadding(0, 0, this.mMargin, this.mMargin);
        addView(this.mtx, layoutParams);
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

    private void dwp() {
        this.mtw = new ImageView(getContext());
        this.mtw.setImageResource(R.drawable.icon_frame_close_n);
        this.mtw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionEditText.this.cCD.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mtw.setPadding(this.mMargin, this.mMargin, this.mMargin, this.mMargin);
        addView(this.mtw, layoutParams);
    }

    private FrameLayout.LayoutParams dwq() {
        this.cCD = new EditText(getContext());
        this.cCD.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.cCD.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.mtC, this.mtC, this.mtC, this.mtC);
        layoutParams.gravity = 17;
        this.cCD.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.cCD.setSingleLine();
        this.cCD.setIncludeFontPadding(false);
        this.cCD.getPaint().setFakeBoldText(true);
        this.cCD.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        j.h(this.cCD, R.drawable.emotion_edittext_cursor);
        this.cCD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (EmotionEditText.this.fXG - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mtA) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mtz) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mtz)) {
                            EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) - 1);
                    }
                    EmotionEditText.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        EmotionEditText.this.cCD.setHint("");
                        EmotionEditText.this.mTextView.setHint("");
                        return;
                    }
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.mtz);
                    EmotionEditText.this.cCD.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
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
        if (this.mtD == 0 && this.mtE == 0) {
            this.mtD = width;
            this.mtE = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.fXG && getTop() + height < this.fXH) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > h(getContext(), this.mtA)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.cCD.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.fXG = i;
        this.fXH = i2;
        if (this.fXG < l.getEquipmentWidth(getContext()) / 4) {
            setTextSize(2, this.mtA);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.cCD.getTextSize() != f) {
            this.cCD.setTextSize(i, f);
        }
        if (this.mTextView.getTextSize() != f) {
            this.mTextView.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.cCD.setFocusable(true);
            this.cCD.setFocusableInTouchMode(true);
            this.cCD.requestFocus();
            return;
        }
        this.cCD.setFocusable(false);
        this.cCD.setFocusableInTouchMode(false);
    }

    public void dwr() {
        if (!this.mtB) {
            this.mtB = true;
            this.cCD.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.mtw.setVisibility(0);
            this.mtx.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void dws() {
        if (this.mtB) {
            this.mtB = false;
            this.cCD.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.mtw.setVisibility(4);
            this.mtx.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public View getEditText() {
        return this.cCD;
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
