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
    private float Fb;
    private int aRr;
    private int aRs;
    private TextView abu;
    private float bvg;
    private float ceA;
    private EditText dHA;
    private int eTA;
    private float eTB;
    private float eTC;
    private int eTD;
    private int eTE;
    private int eTF;
    private boolean eTG;
    public int eTH;
    private int eTI;
    private int eTJ;
    private ImageView eTy;
    private ImageView eTz;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ceA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eTA = getResources().getDimensionPixelSize(d.f.ds20);
        this.eTH = this.eTA * 2;
        this.eTD = 24;
        this.eTE = 16;
        this.eTF = 40;
        FrameLayout.LayoutParams aUi = aUi();
        addView(this.dHA, aUi);
        a(aUi);
        aUh();
        aUg();
        setTextSize(2, this.eTD);
        aUj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Fb) < this.ceA && Math.abs(motionEvent.getRawY() - this.bvg) < this.ceA;
    }

    private void aUg() {
        this.eTz = new ImageView(getContext());
        this.eTz.setImageResource(d.g.icon_frame_enlarge_n);
        this.eTz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.Fb = motionEvent.getRawX();
                        b.this.bvg = motionEvent.getRawY();
                        b.this.eTB = b.this.Fb;
                        b.this.eTC = b.this.bvg;
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
                        float f = rawX - b.this.eTB;
                        if (!b.this.t(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eTB = rawX;
                        b.this.eTC = rawY;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eTz.setPadding(0, 0, this.eTA, this.eTA);
        addView(this.eTz, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.abu = new TextView(getContext());
        this.abu.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.abu.setBackgroundResource(d.g.bg_emotion_edit);
        this.abu.setPadding(this.eTA, this.eTA / 2, this.eTA, this.eTA / 2);
        this.abu.setSingleLine();
        this.abu.setIncludeFontPadding(false);
        this.abu.setEllipsize(TextUtils.TruncateAt.END);
        this.abu.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        this.abu.getPaint().setFakeBoldText(true);
        addView(this.abu, layoutParams);
    }

    private void aUh() {
        this.eTy = new ImageView(getContext());
        this.eTy.setImageResource(d.g.icon_frame_close_n);
        this.eTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dHA.setText("");
                b.this.abu.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eTy.setPadding(this.eTA, this.eTA, this.eTA, this.eTA);
        addView(this.eTy, layoutParams);
    }

    private FrameLayout.LayoutParams aUi() {
        this.dHA = new EditText(getContext());
        this.dHA.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.dHA.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eTH, this.eTH, this.eTH, this.eTH);
        layoutParams.gravity = 17;
        this.dHA.setPadding(this.eTA, this.eTA / 2, this.eTA, this.eTA / 2);
        this.dHA.setSingleLine();
        this.dHA.setIncludeFontPadding(false);
        this.dHA.getPaint().setFakeBoldText(true);
        this.dHA.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dHA, Integer.valueOf(d.g.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dHA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aRr - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.abu.getText().toString().length() || b.this.abu.getTextSize() <= b.this.d(b.this.getContext(), b.this.eTE) || b.this.abu.getTextSize() == b.this.d(b.this.getContext(), b.this.eTD) || width != 0) {
                        if (editable.toString().length() < b.this.abu.getText().toString().length() && width > 0 && b.this.abu.getTextSize() != b.this.d(b.this.getContext(), b.this.eTD)) {
                            b.this.setTextSize(2, b.this.c(b.this.getContext(), b.this.abu.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.c(b.this.getContext(), b.this.abu.getTextSize()) - 1);
                    }
                    b.this.abu.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dHA.setHint("");
                        b.this.abu.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eTD);
                    b.this.dHA.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                    b.this.abu.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eTA * 2);
        int height = getHeight() - (this.eTA * 2);
        if (this.eTI == 0 && this.eTJ == 0) {
            this.eTI = width;
            this.eTJ = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aRr && getTop() + height < this.aRs) {
                setTextSize(2, c(getContext(), this.abu.getTextSize()) + 1);
            }
        } else if (this.abu.getTextSize() > d(getContext(), this.eTE)) {
            setTextSize(2, c(getContext(), this.abu.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dHA.setTextColor(i);
        this.abu.setTextColor(i);
    }

    public void bk(int i, int i2) {
        this.aRr = i;
        this.aRs = i2;
        if (this.aRr < k.ad(getContext()) / 4) {
            setTextSize(2, this.eTE);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dHA.getTextSize() != f) {
            this.dHA.setTextSize(i, f);
        }
        if (this.abu.getTextSize() != f) {
            this.abu.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dHA.setFocusable(true);
            this.dHA.setFocusableInTouchMode(true);
            this.dHA.requestFocus();
            return;
        }
        this.dHA.setFocusable(false);
        this.dHA.setFocusableInTouchMode(false);
    }

    public void aUj() {
        if (!this.eTG) {
            this.eTG = true;
            this.dHA.setVisibility(4);
            this.abu.setVisibility(0);
            this.eTy.setVisibility(0);
            this.eTz.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aUk() {
        if (this.eTG) {
            this.eTG = false;
            this.dHA.setVisibility(0);
            this.abu.setVisibility(4);
            this.eTy.setVisibility(4);
            this.eTz.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.abu;
    }

    public View getEditText() {
        return this.dHA;
    }

    public String getText() {
        return this.abu.getText().toString();
    }

    public float getTextSize() {
        return this.abu.getTextSize();
    }

    public int getTextColor() {
        return this.abu.getCurrentTextColor();
    }

    public int c(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int d(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
