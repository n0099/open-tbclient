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
import com.baidu.tieba.f;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class EmotionEditText extends FrameLayout {
    private int beJ;
    private int beK;
    private float bgZ;
    private float cVA;
    private ImageView fSc;
    private ImageView fSd;
    private float fSe;
    private int fSf;
    private int fSg;
    private boolean fSh;
    public int fSi;
    private int fSj;
    private int fSk;
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
        this.cVA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.mMargin = getResources().getDimensionPixelSize(f.e.ds20);
        this.fSi = this.mMargin * 2;
        this.fSf = 24;
        this.fSg = 16;
        FrameLayout.LayoutParams bhf = bhf();
        addView(this.mEditText, bhf);
        a(bhf);
        bhe();
        bhd();
        setTextSize(2, this.fSf);
        bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.cVA && Math.abs(motionEvent.getRawY() - this.bgZ) < this.cVA;
    }

    private void bhd() {
        this.fSd = new ImageView(getContext());
        this.fSd.setImageResource(f.C0146f.icon_frame_enlarge_n);
        this.fSd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.bgZ = motionEvent.getRawY();
                        EmotionEditText.this.fSe = EmotionEditText.this.mDownX;
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
                        float f = rawX - EmotionEditText.this.fSe;
                        if (!EmotionEditText.this.G(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.fSe = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.fSd.setPadding(0, 0, this.mMargin, this.mMargin);
        addView(this.fSd, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(f.j.emotion_edit_hint));
        this.mTextView.setBackgroundResource(f.C0146f.bg_emotion_edit);
        this.mTextView.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(f.d.cp_cont_e));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void bhe() {
        this.fSc = new ImageView(getContext());
        this.fSc.setImageResource(f.C0146f.icon_frame_close_n);
        this.fSc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionEditText.this.mEditText.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.fSc.setPadding(this.mMargin, this.mMargin, this.mMargin, this.mMargin);
        addView(this.fSc, layoutParams);
    }

    private FrameLayout.LayoutParams bhf() {
        this.mEditText = new EditText(getContext());
        this.mEditText.setHint(getContext().getResources().getString(f.j.emotion_edit_hint));
        this.mEditText.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.fSi, this.fSi, this.fSi, this.fSi);
        layoutParams.gravity = 17;
        this.mEditText.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mEditText.setSingleLine();
        this.mEditText.setIncludeFontPadding(false);
        this.mEditText.getPaint().setFakeBoldText(true);
        this.mEditText.setHintTextColor(getResources().getColor(f.d.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.mEditText, Integer.valueOf(f.C0146f.emotion_edittext_cursor));
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
                    int width = (EmotionEditText.this.beJ - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fSg) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fSf) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.e(EmotionEditText.this.getContext(), EmotionEditText.this.fSf)) {
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
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.fSf);
                    EmotionEditText.this.mEditText.setHint(EmotionEditText.this.getContext().getResources().getString(f.j.emotion_edit_hint));
                    EmotionEditText.this.mTextView.setHint(EmotionEditText.this.getContext().getResources().getString(f.j.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.mMargin * 2);
        int height = getHeight() - (this.mMargin * 2);
        if (this.fSj == 0 && this.fSk == 0) {
            this.fSj = width;
            this.fSk = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.beJ && getTop() + height < this.beK) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > e(getContext(), this.fSg)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.mEditText.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.beJ = i;
        this.beK = i2;
        if (this.beJ < l.ah(getContext()) / 4) {
            setTextSize(2, this.fSg);
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

    public void bhg() {
        if (!this.fSh) {
            this.fSh = true;
            this.mEditText.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.fSc.setVisibility(0);
            this.fSd.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void bhh() {
        if (this.fSh) {
            this.fSh = false;
            this.mEditText.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.fSc.setVisibility(4);
            this.fSd.setVisibility(4);
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
