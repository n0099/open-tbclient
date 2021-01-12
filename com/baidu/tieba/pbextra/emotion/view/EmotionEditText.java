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
    private float cBP;
    private EditText cyH;
    private int fTR;
    private int fTS;
    private float iNa;
    private float mDownX;
    private int mMargin;
    private TextView mTextView;
    private ImageView mib;
    private ImageView mic;
    private float mie;
    private int mif;
    private int mig;
    private boolean mih;
    public int mii;
    private int mij;
    private int mik;

    public EmotionEditText(Context context) {
        this(context, null);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iNa = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.mMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
        this.mii = this.mMargin * 2;
        this.mif = 24;
        this.mig = 16;
        FrameLayout.LayoutParams dtR = dtR();
        addView(this.cyH, dtR);
        b(dtR);
        dtQ();
        dtP();
        setTextSize(2, this.mif);
        dtS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iNa && Math.abs(motionEvent.getRawY() - this.cBP) < this.iNa;
    }

    private void dtP() {
        this.mic = new ImageView(getContext());
        this.mic.setImageResource(R.drawable.icon_frame_enlarge_n);
        this.mic.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.cBP = motionEvent.getRawY();
                        EmotionEditText.this.mie = EmotionEditText.this.mDownX;
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
                        float f = rawX - EmotionEditText.this.mie;
                        if (!EmotionEditText.this.ab(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.mie = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.mic.setPadding(0, 0, this.mMargin, this.mMargin);
        addView(this.mic, layoutParams);
    }

    private void b(FrameLayout.LayoutParams layoutParams) {
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

    private void dtQ() {
        this.mib = new ImageView(getContext());
        this.mib.setImageResource(R.drawable.icon_frame_close_n);
        this.mib.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionEditText.this.cyH.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mib.setPadding(this.mMargin, this.mMargin, this.mMargin, this.mMargin);
        addView(this.mib, layoutParams);
    }

    private FrameLayout.LayoutParams dtR() {
        this.cyH = new EditText(getContext());
        this.cyH.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.cyH.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.mii, this.mii, this.mii, this.mii);
        layoutParams.gravity = 17;
        this.cyH.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.cyH.setSingleLine();
        this.cyH.setIncludeFontPadding(false);
        this.cyH.getPaint().setFakeBoldText(true);
        this.cyH.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        j.h(this.cyH, R.drawable.emotion_edittext_cursor);
        this.cyH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (EmotionEditText.this.fTR - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mig) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mif) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mif)) {
                            EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) - 1);
                    }
                    EmotionEditText.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        EmotionEditText.this.cyH.setHint("");
                        EmotionEditText.this.mTextView.setHint("");
                        return;
                    }
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.mif);
                    EmotionEditText.this.cyH.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
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
        if (this.mij == 0 && this.mik == 0) {
            this.mij = width;
            this.mik = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.fTR && getTop() + height < this.fTS) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > h(getContext(), this.mig)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.cyH.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.fTR = i;
        this.fTS = i2;
        if (this.fTR < l.getEquipmentWidth(getContext()) / 4) {
            setTextSize(2, this.mig);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.cyH.getTextSize() != f) {
            this.cyH.setTextSize(i, f);
        }
        if (this.mTextView.getTextSize() != f) {
            this.mTextView.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.cyH.setFocusable(true);
            this.cyH.setFocusableInTouchMode(true);
            this.cyH.requestFocus();
            return;
        }
        this.cyH.setFocusable(false);
        this.cyH.setFocusableInTouchMode(false);
    }

    public void dtS() {
        if (!this.mih) {
            this.mih = true;
            this.cyH.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.mib.setVisibility(0);
            this.mic.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void dtT() {
        if (this.mih) {
            this.mih = false;
            this.cyH.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.mib.setVisibility(4);
            this.mic.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public View getEditText() {
        return this.cyH;
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
