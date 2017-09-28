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
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class b extends FrameLayout {
    private float Fd;
    private int aSq;
    private int aSr;
    private TextView abv;
    private float bxE;
    private float cfl;
    private EditText dEK;
    private boolean eOA;
    public int eOB;
    private int eOC;
    private int eOD;
    private ImageView eOs;
    private ImageView eOt;
    private int eOu;
    private float eOv;
    private float eOw;
    private int eOx;
    private int eOy;
    private int eOz;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfl = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eOu = getResources().getDimensionPixelSize(d.f.ds20);
        this.eOB = this.eOu * 2;
        this.eOx = 24;
        this.eOy = 16;
        this.eOz = 40;
        FrameLayout.LayoutParams aSC = aSC();
        addView(this.dEK, aSC);
        a(aSC);
        aSB();
        aSA();
        setTextSize(2, this.eOx);
        aSD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Fd) < this.cfl && Math.abs(motionEvent.getRawY() - this.bxE) < this.cfl;
    }

    private void aSA() {
        this.eOt = new ImageView(getContext());
        this.eOt.setImageResource(d.g.icon_frame_enlarge_n);
        this.eOt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.Fd = motionEvent.getRawX();
                        b.this.bxE = motionEvent.getRawY();
                        b.this.eOv = b.this.Fd;
                        b.this.eOw = b.this.bxE;
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
                        float f = rawX - b.this.eOv;
                        if (!b.this.t(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eOv = rawX;
                        b.this.eOw = rawY;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eOt.setPadding(0, 0, this.eOu, this.eOu);
        addView(this.eOt, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.abv = new TextView(getContext());
        this.abv.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.abv.setBackgroundResource(d.g.bg_emotion_edit);
        this.abv.setPadding(this.eOu, this.eOu / 2, this.eOu, this.eOu / 2);
        this.abv.setSingleLine();
        this.abv.setIncludeFontPadding(false);
        this.abv.setEllipsize(TextUtils.TruncateAt.END);
        this.abv.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        this.abv.getPaint().setFakeBoldText(true);
        addView(this.abv, layoutParams);
    }

    private void aSB() {
        this.eOs = new ImageView(getContext());
        this.eOs.setImageResource(d.g.icon_frame_close_n);
        this.eOs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dEK.setText("");
                b.this.abv.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eOs.setPadding(this.eOu, this.eOu, this.eOu, this.eOu);
        addView(this.eOs, layoutParams);
    }

    private FrameLayout.LayoutParams aSC() {
        this.dEK = new EditText(getContext());
        this.dEK.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.dEK.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eOB, this.eOB, this.eOB, this.eOB);
        layoutParams.gravity = 17;
        this.dEK.setPadding(this.eOu, this.eOu / 2, this.eOu, this.eOu / 2);
        this.dEK.setSingleLine();
        this.dEK.setIncludeFontPadding(false);
        this.dEK.getPaint().setFakeBoldText(true);
        this.dEK.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dEK, Integer.valueOf(d.g.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dEK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aSq - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.abv.getText().toString().length() || b.this.abv.getTextSize() <= b.this.d(b.this.getContext(), b.this.eOy) || b.this.abv.getTextSize() == b.this.d(b.this.getContext(), b.this.eOx) || width != 0) {
                        if (editable.toString().length() < b.this.abv.getText().toString().length() && width > 0 && b.this.abv.getTextSize() != b.this.d(b.this.getContext(), b.this.eOx)) {
                            b.this.setTextSize(2, b.this.c(b.this.getContext(), b.this.abv.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.c(b.this.getContext(), b.this.abv.getTextSize()) - 1);
                    }
                    b.this.abv.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dEK.setHint("");
                        b.this.abv.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eOx);
                    b.this.dEK.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                    b.this.abv.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eOu * 2);
        int height = getHeight() - (this.eOu * 2);
        if (this.eOC == 0 && this.eOD == 0) {
            this.eOC = width;
            this.eOD = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aSq && getTop() + height < this.aSr) {
                setTextSize(2, c(getContext(), this.abv.getTextSize()) + 1);
            }
        } else if (this.abv.getTextSize() > d(getContext(), this.eOy)) {
            setTextSize(2, c(getContext(), this.abv.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dEK.setTextColor(i);
        this.abv.setTextColor(i);
    }

    public void bv(int i, int i2) {
        this.aSq = i;
        this.aSr = i2;
        if (this.aSq < l.ad(getContext()) / 4) {
            setTextSize(2, this.eOy);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dEK.getTextSize() != f) {
            this.dEK.setTextSize(i, f);
        }
        if (this.abv.getTextSize() != f) {
            this.abv.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dEK.setFocusable(true);
            this.dEK.setFocusableInTouchMode(true);
            this.dEK.requestFocus();
            return;
        }
        this.dEK.setFocusable(false);
        this.dEK.setFocusableInTouchMode(false);
    }

    public void aSD() {
        if (!this.eOA) {
            this.eOA = true;
            this.dEK.setVisibility(4);
            this.abv.setVisibility(0);
            this.eOs.setVisibility(0);
            this.eOt.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aSE() {
        if (this.eOA) {
            this.eOA = false;
            this.dEK.setVisibility(0);
            this.abv.setVisibility(4);
            this.eOs.setVisibility(4);
            this.eOt.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.abv;
    }

    public View getEditText() {
        return this.dEK;
    }

    public String getText() {
        return this.abv.getText().toString();
    }

    public float getTextSize() {
        return this.abv.getTextSize();
    }

    public int getTextColor() {
        return this.abv.getCurrentTextColor();
    }

    public int c(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int d(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
