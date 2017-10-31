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
    private int aRh;
    private int aRi;
    private TextView abE;
    private float bCe;
    private float cmt;
    private EditText dMk;
    private ImageView eWY;
    private ImageView eWZ;
    private int eXa;
    private float eXb;
    private int eXc;
    private int eXd;
    private boolean eXe;
    public int eXf;
    private int eXg;
    private int eXh;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eXa = getResources().getDimensionPixelSize(d.e.ds20);
        this.eXf = this.eXa * 2;
        this.eXc = 24;
        this.eXd = 16;
        FrameLayout.LayoutParams aVL = aVL();
        addView(this.dMk, aVL);
        a(aVL);
        aVK();
        aVJ();
        setTextSize(2, this.eXc);
        aVM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.EP) < this.cmt && Math.abs(motionEvent.getRawY() - this.bCe) < this.cmt;
    }

    private void aVJ() {
        this.eWZ = new ImageView(getContext());
        this.eWZ.setImageResource(d.f.icon_frame_enlarge_n);
        this.eWZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.EP = motionEvent.getRawX();
                        b.this.bCe = motionEvent.getRawY();
                        b.this.eXb = b.this.EP;
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
                        float f = rawX - b.this.eXb;
                        if (!b.this.v(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eXb = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eWZ.setPadding(0, 0, this.eXa, this.eXa);
        addView(this.eWZ, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.abE = new TextView(getContext());
        this.abE.setHint(getContext().getResources().getString(d.j.emotion_edit_hint));
        this.abE.setBackgroundResource(d.f.bg_emotion_edit);
        this.abE.setPadding(this.eXa, this.eXa / 2, this.eXa, this.eXa / 2);
        this.abE.setSingleLine();
        this.abE.setIncludeFontPadding(false);
        this.abE.setEllipsize(TextUtils.TruncateAt.END);
        this.abE.setHintTextColor(getResources().getColor(d.C0080d.cp_cont_e));
        this.abE.getPaint().setFakeBoldText(true);
        addView(this.abE, layoutParams);
    }

    private void aVK() {
        this.eWY = new ImageView(getContext());
        this.eWY.setImageResource(d.f.icon_frame_close_n);
        this.eWY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dMk.setText("");
                b.this.abE.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eWY.setPadding(this.eXa, this.eXa, this.eXa, this.eXa);
        addView(this.eWY, layoutParams);
    }

    private FrameLayout.LayoutParams aVL() {
        this.dMk = new EditText(getContext());
        this.dMk.setHint(getContext().getResources().getString(d.j.emotion_edit_hint));
        this.dMk.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eXf, this.eXf, this.eXf, this.eXf);
        layoutParams.gravity = 17;
        this.dMk.setPadding(this.eXa, this.eXa / 2, this.eXa, this.eXa / 2);
        this.dMk.setSingleLine();
        this.dMk.setIncludeFontPadding(false);
        this.dMk.getPaint().setFakeBoldText(true);
        this.dMk.setHintTextColor(getResources().getColor(d.C0080d.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dMk, Integer.valueOf(d.f.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dMk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aRh - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.abE.getText().toString().length() || b.this.abE.getTextSize() <= b.this.c(b.this.getContext(), b.this.eXd) || b.this.abE.getTextSize() == b.this.c(b.this.getContext(), b.this.eXc) || width != 0) {
                        if (editable.toString().length() < b.this.abE.getText().toString().length() && width > 0 && b.this.abE.getTextSize() != b.this.c(b.this.getContext(), b.this.eXc)) {
                            b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.abE.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.abE.getTextSize()) - 1);
                    }
                    b.this.abE.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dMk.setHint("");
                        b.this.abE.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eXc);
                    b.this.dMk.setHint(b.this.getContext().getResources().getString(d.j.emotion_edit_hint));
                    b.this.abE.setHint(b.this.getContext().getResources().getString(d.j.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eXa * 2);
        int height = getHeight() - (this.eXa * 2);
        if (this.eXg == 0 && this.eXh == 0) {
            this.eXg = width;
            this.eXh = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aRh && getTop() + height < this.aRi) {
                setTextSize(2, b(getContext(), this.abE.getTextSize()) + 1);
            }
        } else if (this.abE.getTextSize() > c(getContext(), this.eXd)) {
            setTextSize(2, b(getContext(), this.abE.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dMk.setTextColor(i);
        this.abE.setTextColor(i);
    }

    public void bx(int i, int i2) {
        this.aRh = i;
        this.aRi = i2;
        if (this.aRh < l.ac(getContext()) / 4) {
            setTextSize(2, this.eXd);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dMk.getTextSize() != f) {
            this.dMk.setTextSize(i, f);
        }
        if (this.abE.getTextSize() != f) {
            this.abE.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dMk.setFocusable(true);
            this.dMk.setFocusableInTouchMode(true);
            this.dMk.requestFocus();
            return;
        }
        this.dMk.setFocusable(false);
        this.dMk.setFocusableInTouchMode(false);
    }

    public void aVM() {
        if (!this.eXe) {
            this.eXe = true;
            this.dMk.setVisibility(4);
            this.abE.setVisibility(0);
            this.eWY.setVisibility(0);
            this.eWZ.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aVN() {
        if (this.eXe) {
            this.eXe = false;
            this.dMk.setVisibility(0);
            this.abE.setVisibility(4);
            this.eWY.setVisibility(4);
            this.eWZ.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.abE;
    }

    public View getEditText() {
        return this.dMk;
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
