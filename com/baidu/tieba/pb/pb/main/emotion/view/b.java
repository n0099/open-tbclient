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
    private float EP;
    private int aRp;
    private int aRq;
    private TextView abE;
    private float bCr;
    private float cmM;
    private EditText dMp;
    public int eXA;
    private int eXB;
    private int eXC;
    private ImageView eXt;
    private ImageView eXu;
    private int eXv;
    private float eXw;
    private int eXx;
    private int eXy;
    private boolean eXz;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmM = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eXv = getResources().getDimensionPixelSize(d.e.ds20);
        this.eXA = this.eXv * 2;
        this.eXx = 24;
        this.eXy = 16;
        FrameLayout.LayoutParams aVT = aVT();
        addView(this.dMp, aVT);
        a(aVT);
        aVS();
        aVR();
        setTextSize(2, this.eXx);
        aVU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cmM && Math.abs(motionEvent.getRawY() - this.bCr) < this.cmM;
    }

    private void aVR() {
        this.eXu = new ImageView(getContext());
        this.eXu.setImageResource(d.f.icon_frame_enlarge_n);
        this.eXu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.EP = motionEvent.getRawX();
                        b.this.bCr = motionEvent.getRawY();
                        b.this.eXw = b.this.EP;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(b.this.getLeft(), b.this.getTop(), 0, 0);
                        b.this.setLayoutParams(layoutParams);
                        return true;
                    case 1:
                    default:
                        return true;
                    case 2:
                        float rawX = motionEvent.getRawX();
                        motionEvent.getRawY();
                        float f = rawX - b.this.eXw;
                        if (!b.this.v(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eXw = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eXu.setPadding(0, 0, this.eXv, this.eXv);
        addView(this.eXu, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.abE = new TextView(getContext());
        this.abE.setHint(getContext().getResources().getString(d.j.emotion_edit_hint));
        this.abE.setBackgroundResource(d.f.bg_emotion_edit);
        this.abE.setPadding(this.eXv, this.eXv / 2, this.eXv, this.eXv / 2);
        this.abE.setSingleLine();
        this.abE.setIncludeFontPadding(false);
        this.abE.setEllipsize(TextUtils.TruncateAt.END);
        this.abE.setHintTextColor(getResources().getColor(d.C0080d.cp_cont_e));
        this.abE.getPaint().setFakeBoldText(true);
        addView(this.abE, layoutParams);
    }

    private void aVS() {
        this.eXt = new ImageView(getContext());
        this.eXt.setImageResource(d.f.icon_frame_close_n);
        this.eXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dMp.setText("");
                b.this.abE.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eXt.setPadding(this.eXv, this.eXv, this.eXv, this.eXv);
        addView(this.eXt, layoutParams);
    }

    private FrameLayout.LayoutParams aVT() {
        this.dMp = new EditText(getContext());
        this.dMp.setHint(getContext().getResources().getString(d.j.emotion_edit_hint));
        this.dMp.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eXA, this.eXA, this.eXA, this.eXA);
        layoutParams.gravity = 17;
        this.dMp.setPadding(this.eXv, this.eXv / 2, this.eXv, this.eXv / 2);
        this.dMp.setSingleLine();
        this.dMp.setIncludeFontPadding(false);
        this.dMp.getPaint().setFakeBoldText(true);
        this.dMp.setHintTextColor(getResources().getColor(d.C0080d.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dMp, Integer.valueOf(d.f.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dMp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aRp - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.abE.getText().toString().length() || b.this.abE.getTextSize() <= b.this.c(b.this.getContext(), b.this.eXy) || b.this.abE.getTextSize() == b.this.c(b.this.getContext(), b.this.eXx) || width != 0) {
                        if (editable.toString().length() < b.this.abE.getText().toString().length() && width > 0 && b.this.abE.getTextSize() != b.this.c(b.this.getContext(), b.this.eXx)) {
                            b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.abE.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.abE.getTextSize()) - 1);
                    }
                    b.this.abE.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dMp.setHint("");
                        b.this.abE.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eXx);
                    b.this.dMp.setHint(b.this.getContext().getResources().getString(d.j.emotion_edit_hint));
                    b.this.abE.setHint(b.this.getContext().getResources().getString(d.j.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eXv * 2);
        int height = getHeight() - (this.eXv * 2);
        if (this.eXB == 0 && this.eXC == 0) {
            this.eXB = width;
            this.eXC = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aRp && getTop() + height < this.aRq) {
                setTextSize(2, b(getContext(), this.abE.getTextSize()) + 1);
            }
        } else if (this.abE.getTextSize() > c(getContext(), this.eXy)) {
            setTextSize(2, b(getContext(), this.abE.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dMp.setTextColor(i);
        this.abE.setTextColor(i);
    }

    public void bw(int i, int i2) {
        this.aRp = i;
        this.aRq = i2;
        if (this.aRp < l.ac(getContext()) / 4) {
            setTextSize(2, this.eXy);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dMp.getTextSize() != f) {
            this.dMp.setTextSize(i, f);
        }
        if (this.abE.getTextSize() != f) {
            this.abE.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dMp.setFocusable(true);
            this.dMp.setFocusableInTouchMode(true);
            this.dMp.requestFocus();
            return;
        }
        this.dMp.setFocusable(false);
        this.dMp.setFocusableInTouchMode(false);
    }

    public void aVU() {
        if (!this.eXz) {
            this.eXz = true;
            this.dMp.setVisibility(4);
            this.abE.setVisibility(0);
            this.eXt.setVisibility(0);
            this.eXu.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aVV() {
        if (this.eXz) {
            this.eXz = false;
            this.dMp.setVisibility(0);
            this.abE.setVisibility(4);
            this.eXt.setVisibility(4);
            this.eXu.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.abE;
    }

    public View getEditText() {
        return this.dMp;
    }

    public String getText() {
        return this.abE.getText().toString();
    }

    public float getTextSize() {
        return this.abE.getTextSize();
    }

    public int getTextColor() {
        return this.abE.getCurrentTextColor();
    }

    public int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
