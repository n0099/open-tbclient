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
    private int aVf;
    private int aVg;
    private float bTq;
    private float cKF;
    private int fBA;
    private float fBB;
    private int fBC;
    private int fBD;
    private boolean fBE;
    public int fBF;
    private int fBG;
    private int fBH;
    private ImageView fBy;
    private ImageView fBz;
    private float mDownX;
    private EditText mEditText;
    private TextView mTextView;

    public EmotionEditText(Context context) {
        this(context, null);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKF = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.fBA = getResources().getDimensionPixelSize(d.e.ds20);
        this.fBF = this.fBA * 2;
        this.fBC = 24;
        this.fBD = 16;
        FrameLayout.LayoutParams bdl = bdl();
        addView(this.mEditText, bdl);
        a(bdl);
        bdk();
        bdj();
        setTextSize(2, this.fBC);
        bdm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cKF && Math.abs(motionEvent.getRawY() - this.bTq) < this.cKF;
    }

    private void bdj() {
        this.fBz = new ImageView(getContext());
        this.fBz.setImageResource(d.f.icon_frame_enlarge_n);
        this.fBz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.bTq = motionEvent.getRawY();
                        EmotionEditText.this.fBB = EmotionEditText.this.mDownX;
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
                        float f = rawX - EmotionEditText.this.fBB;
                        if (!EmotionEditText.this.E(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.fBB = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.fBz.setPadding(0, 0, this.fBA, this.fBA);
        addView(this.fBz, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(d.k.emotion_edit_hint));
        this.mTextView.setBackgroundResource(d.f.bg_emotion_edit);
        this.mTextView.setPadding(this.fBA, this.fBA / 2, this.fBA, this.fBA / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_e));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void bdk() {
        this.fBy = new ImageView(getContext());
        this.fBy.setImageResource(d.f.icon_frame_close_n);
        this.fBy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EmotionEditText.this.mEditText.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.fBy.setPadding(this.fBA, this.fBA, this.fBA, this.fBA);
        addView(this.fBy, layoutParams);
    }

    private FrameLayout.LayoutParams bdl() {
        this.mEditText = new EditText(getContext());
        this.mEditText.setHint(getContext().getResources().getString(d.k.emotion_edit_hint));
        this.mEditText.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.fBF, this.fBF, this.fBF, this.fBF);
        layoutParams.gravity = 17;
        this.mEditText.setPadding(this.fBA, this.fBA / 2, this.fBA, this.fBA / 2);
        this.mEditText.setSingleLine();
        this.mEditText.setIncludeFontPadding(false);
        this.mEditText.getPaint().setFakeBoldText(true);
        this.mEditText.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_e));
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
                    int width = (EmotionEditText.this.aVf - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fBD) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fBC) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fBC)) {
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
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.fBC);
                    EmotionEditText.this.mEditText.setHint(EmotionEditText.this.getContext().getResources().getString(d.k.emotion_edit_hint));
                    EmotionEditText.this.mTextView.setHint(EmotionEditText.this.getContext().getResources().getString(d.k.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.fBA * 2);
        int height = getHeight() - (this.fBA * 2);
        if (this.fBG == 0 && this.fBH == 0) {
            this.fBG = width;
            this.fBH = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aVf && getTop() + height < this.aVg) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > e(getContext(), this.fBD)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.mEditText.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.aVf = i;
        this.aVg = i2;
        if (this.aVf < l.af(getContext()) / 4) {
            setTextSize(2, this.fBD);
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

    public void bdm() {
        if (!this.fBE) {
            this.fBE = true;
            this.mEditText.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.fBy.setVisibility(0);
            this.fBz.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void bdn() {
        if (this.fBE) {
            this.fBE = false;
            this.mEditText.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.fBy.setVisibility(4);
            this.fBz.setVisibility(4);
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
