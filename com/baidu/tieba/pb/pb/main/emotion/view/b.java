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
    private float Fe;
    private int aSd;
    private int aSe;
    private TextView abi;
    private float bxs;
    private float ceZ;
    private EditText dEw;
    private ImageView eOe;
    private ImageView eOf;
    private int eOg;
    private float eOh;
    private float eOi;
    private int eOj;
    private int eOk;
    private int eOl;
    private boolean eOm;
    public int eOn;
    private int eOo;
    private int eOp;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ceZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eOg = getResources().getDimensionPixelSize(d.f.ds20);
        this.eOn = this.eOg * 2;
        this.eOj = 24;
        this.eOk = 16;
        this.eOl = 40;
        FrameLayout.LayoutParams aSx = aSx();
        addView(this.dEw, aSx);
        a(aSx);
        aSw();
        aSv();
        setTextSize(2, this.eOj);
        aSy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Fe) < this.ceZ && Math.abs(motionEvent.getRawY() - this.bxs) < this.ceZ;
    }

    private void aSv() {
        this.eOf = new ImageView(getContext());
        this.eOf.setImageResource(d.g.icon_frame_enlarge_n);
        this.eOf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.Fe = motionEvent.getRawX();
                        b.this.bxs = motionEvent.getRawY();
                        b.this.eOh = b.this.Fe;
                        b.this.eOi = b.this.bxs;
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
                        float f = rawX - b.this.eOh;
                        if (!b.this.t(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eOh = rawX;
                        b.this.eOi = rawY;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eOf.setPadding(0, 0, this.eOg, this.eOg);
        addView(this.eOf, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.abi = new TextView(getContext());
        this.abi.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.abi.setBackgroundResource(d.g.bg_emotion_edit);
        this.abi.setPadding(this.eOg, this.eOg / 2, this.eOg, this.eOg / 2);
        this.abi.setSingleLine();
        this.abi.setIncludeFontPadding(false);
        this.abi.setEllipsize(TextUtils.TruncateAt.END);
        this.abi.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        this.abi.getPaint().setFakeBoldText(true);
        addView(this.abi, layoutParams);
    }

    private void aSw() {
        this.eOe = new ImageView(getContext());
        this.eOe.setImageResource(d.g.icon_frame_close_n);
        this.eOe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dEw.setText("");
                b.this.abi.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eOe.setPadding(this.eOg, this.eOg, this.eOg, this.eOg);
        addView(this.eOe, layoutParams);
    }

    private FrameLayout.LayoutParams aSx() {
        this.dEw = new EditText(getContext());
        this.dEw.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.dEw.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eOn, this.eOn, this.eOn, this.eOn);
        layoutParams.gravity = 17;
        this.dEw.setPadding(this.eOg, this.eOg / 2, this.eOg, this.eOg / 2);
        this.dEw.setSingleLine();
        this.dEw.setIncludeFontPadding(false);
        this.dEw.getPaint().setFakeBoldText(true);
        this.dEw.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dEw, Integer.valueOf(d.g.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dEw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aSd - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.abi.getText().toString().length() || b.this.abi.getTextSize() <= b.this.c(b.this.getContext(), b.this.eOk) || b.this.abi.getTextSize() == b.this.c(b.this.getContext(), b.this.eOj) || width != 0) {
                        if (editable.toString().length() < b.this.abi.getText().toString().length() && width > 0 && b.this.abi.getTextSize() != b.this.c(b.this.getContext(), b.this.eOj)) {
                            b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.abi.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.abi.getTextSize()) - 1);
                    }
                    b.this.abi.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dEw.setHint("");
                        b.this.abi.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eOj);
                    b.this.dEw.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                    b.this.abi.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eOg * 2);
        int height = getHeight() - (this.eOg * 2);
        if (this.eOo == 0 && this.eOp == 0) {
            this.eOo = width;
            this.eOp = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aSd && getTop() + height < this.aSe) {
                setTextSize(2, b(getContext(), this.abi.getTextSize()) + 1);
            }
        } else if (this.abi.getTextSize() > c(getContext(), this.eOk)) {
            setTextSize(2, b(getContext(), this.abi.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dEw.setTextColor(i);
        this.abi.setTextColor(i);
    }

    public void bv(int i, int i2) {
        this.aSd = i;
        this.aSe = i2;
        if (this.aSd < l.ad(getContext()) / 4) {
            setTextSize(2, this.eOk);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dEw.getTextSize() != f) {
            this.dEw.setTextSize(i, f);
        }
        if (this.abi.getTextSize() != f) {
            this.abi.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dEw.setFocusable(true);
            this.dEw.setFocusableInTouchMode(true);
            this.dEw.requestFocus();
            return;
        }
        this.dEw.setFocusable(false);
        this.dEw.setFocusableInTouchMode(false);
    }

    public void aSy() {
        if (!this.eOm) {
            this.eOm = true;
            this.dEw.setVisibility(4);
            this.abi.setVisibility(0);
            this.eOe.setVisibility(0);
            this.eOf.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aSz() {
        if (this.eOm) {
            this.eOm = false;
            this.dEw.setVisibility(0);
            this.abi.setVisibility(4);
            this.eOe.setVisibility(4);
            this.eOf.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.abi;
    }

    public View getEditText() {
        return this.dEw;
    }

    public String getText() {
        return this.abi.getText().toString();
    }

    public float getTextSize() {
        return this.abi.getTextSize();
    }

    public int getTextColor() {
        return this.abi.getCurrentTextColor();
    }

    public int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
