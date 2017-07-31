package com.baidu.tieba.pb.pb.main.emotion.view;

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
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class b extends FrameLayout {
    private float Hf;
    private int aRG;
    private int aRH;
    private float bue;
    private float caW;
    private EditText dza;
    private ImageView eTc;
    private ImageView eTd;
    private int eTe;
    private float eTf;
    private float eTg;
    private int eTh;
    private int eTi;
    private int eTj;
    private boolean eTk;
    public int eTl;
    private int eTm;
    private int eTn;
    private TextView mTextView;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.caW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eTe = getResources().getDimensionPixelSize(d.f.ds20);
        this.eTl = this.eTe * 2;
        this.eTh = 24;
        this.eTi = 16;
        this.eTj = 40;
        FrameLayout.LayoutParams aUv = aUv();
        addView(this.dza, aUv);
        a(aUv);
        aUu();
        aUt();
        setTextSize(2, this.eTh);
        aUw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Hf) < this.caW && Math.abs(motionEvent.getRawY() - this.bue) < this.caW;
    }

    private void aUt() {
        this.eTd = new ImageView(getContext());
        this.eTd.setImageResource(d.g.icon_frame_enlarge_n);
        this.eTd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.Hf = motionEvent.getRawX();
                        b.this.bue = motionEvent.getRawY();
                        b.this.eTf = b.this.Hf;
                        b.this.eTg = b.this.bue;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(b.this.getLeft(), b.this.getTop(), 0, 0);
                        b.this.setLayoutParams(layoutParams);
                        return true;
                    case 1:
                    default:
                        return true;
                    case 2:
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float f = rawX - b.this.eTf;
                        if (!b.this.t(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eTf = rawX;
                        b.this.eTg = rawY;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eTd.setPadding(0, 0, this.eTe, this.eTe);
        addView(this.eTd, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.mTextView.setBackgroundResource(d.g.bg_emotion_edit);
        this.mTextView.setPadding(this.eTe, this.eTe / 2, this.eTe, this.eTe / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void aUu() {
        this.eTc = new ImageView(getContext());
        this.eTc.setImageResource(d.g.icon_frame_close_n);
        this.eTc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dza.setText("");
                b.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eTc.setPadding(this.eTe, this.eTe, this.eTe, this.eTe);
        addView(this.eTc, layoutParams);
    }

    private FrameLayout.LayoutParams aUv() {
        this.dza = new EditText(getContext());
        this.dza.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.dza.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eTl, this.eTl, this.eTl, this.eTl);
        layoutParams.gravity = 17;
        this.dza.setPadding(this.eTe, this.eTe / 2, this.eTe, this.eTe / 2);
        this.dza.setSingleLine();
        this.dza.setIncludeFontPadding(false);
        this.dza.getPaint().setFakeBoldText(true);
        this.dza.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dza, Integer.valueOf(d.g.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dza.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aRG - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.mTextView.getText().toString().length() || b.this.mTextView.getTextSize() <= b.this.c(b.this.getContext(), b.this.eTi) || b.this.mTextView.getTextSize() == b.this.c(b.this.getContext(), b.this.eTh) || width != 0) {
                        if (editable.toString().length() < b.this.mTextView.getText().toString().length() && width > 0 && b.this.mTextView.getTextSize() != b.this.c(b.this.getContext(), b.this.eTh)) {
                            b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.mTextView.getTextSize()) - 1);
                    }
                    b.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dza.setHint("");
                        b.this.mTextView.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eTh);
                    b.this.dza.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                    b.this.mTextView.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eTe * 2);
        int height = getHeight() - (this.eTe * 2);
        if (this.eTm == 0 && this.eTn == 0) {
            this.eTm = width;
            this.eTn = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aRG && getTop() + height < this.aRH) {
                setTextSize(2, b(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > c(getContext(), this.eTi)) {
            setTextSize(2, b(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dza.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void bd(int i, int i2) {
        this.aRG = i;
        this.aRH = i2;
        if (this.aRG < k.ag(getContext()) / 4) {
            setTextSize(2, this.eTi);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dza.getTextSize() != f) {
            this.dza.setTextSize(i, f);
        }
        if (this.mTextView.getTextSize() != f) {
            this.mTextView.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dza.setFocusable(true);
            this.dza.setFocusableInTouchMode(true);
            this.dza.requestFocus();
            return;
        }
        this.dza.setFocusable(false);
        this.dza.setFocusableInTouchMode(false);
    }

    public void aUw() {
        if (!this.eTk) {
            this.eTk = true;
            this.dza.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.eTc.setVisibility(0);
            this.eTd.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aUx() {
        if (this.eTk) {
            this.eTk = false;
            this.dza.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.eTc.setVisibility(4);
            this.eTd.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public View getEditText() {
        return this.dza;
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

    public int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
