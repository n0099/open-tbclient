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
public class b extends FrameLayout {
    private int bKn;
    private int bKo;
    private float cDi;
    private float drL;
    private ImageView ggM;
    private ImageView ggN;
    private int ggO;
    private float ggP;
    private int ggQ;
    private int ggR;
    private boolean ggS;
    public int ggT;
    private int ggU;
    private int ggV;
    private float mDownX;
    private EditText rD;
    private TextView ry;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drL = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.ggO = getResources().getDimensionPixelSize(d.e.ds20);
        this.ggT = this.ggO * 2;
        this.ggQ = 24;
        this.ggR = 16;
        FrameLayout.LayoutParams bik = bik();
        addView(this.rD, bik);
        a(bik);
        bij();
        bii();
        setTextSize(2, this.ggQ);
        bil();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drL && Math.abs(motionEvent.getRawY() - this.cDi) < this.drL;
    }

    private void bii() {
        this.ggN = new ImageView(getContext());
        this.ggN.setImageResource(d.f.icon_frame_enlarge_n);
        this.ggN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mDownX = motionEvent.getRawX();
                        b.this.cDi = motionEvent.getRawY();
                        b.this.ggP = b.this.mDownX;
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
                        float f = rawX - b.this.ggP;
                        if (!b.this.M(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.ggP = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.ggN.setPadding(0, 0, this.ggO, this.ggO);
        addView(this.ggN, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.ry = new TextView(getContext());
        this.ry.setHint(getContext().getResources().getString(d.j.emotion_edit_hint));
        this.ry.setBackgroundResource(d.f.bg_emotion_edit);
        this.ry.setPadding(this.ggO, this.ggO / 2, this.ggO, this.ggO / 2);
        this.ry.setSingleLine();
        this.ry.setIncludeFontPadding(false);
        this.ry.setEllipsize(TextUtils.TruncateAt.END);
        this.ry.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        this.ry.getPaint().setFakeBoldText(true);
        addView(this.ry, layoutParams);
    }

    private void bij() {
        this.ggM = new ImageView(getContext());
        this.ggM.setImageResource(d.f.icon_frame_close_n);
        this.ggM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.rD.setText("");
                b.this.ry.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.ggM.setPadding(this.ggO, this.ggO, this.ggO, this.ggO);
        addView(this.ggM, layoutParams);
    }

    private FrameLayout.LayoutParams bik() {
        this.rD = new EditText(getContext());
        this.rD.setHint(getContext().getResources().getString(d.j.emotion_edit_hint));
        this.rD.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.ggT, this.ggT, this.ggT, this.ggT);
        layoutParams.gravity = 17;
        this.rD.setPadding(this.ggO, this.ggO / 2, this.ggO, this.ggO / 2);
        this.rD.setSingleLine();
        this.rD.setIncludeFontPadding(false);
        this.rD.getPaint().setFakeBoldText(true);
        this.rD.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.rD, Integer.valueOf(d.f.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.rD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pbextra.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.bKn - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.ry.getText().toString().length() || b.this.ry.getTextSize() <= b.this.e(b.this.getContext(), b.this.ggR) || b.this.ry.getTextSize() == b.this.e(b.this.getContext(), b.this.ggQ) || width != 0) {
                        if (editable.toString().length() < b.this.ry.getText().toString().length() && width > 0 && b.this.ry.getTextSize() != b.this.e(b.this.getContext(), b.this.ggQ)) {
                            b.this.setTextSize(2, b.this.px2sp(b.this.getContext(), b.this.ry.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.px2sp(b.this.getContext(), b.this.ry.getTextSize()) - 1);
                    }
                    b.this.ry.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.rD.setHint("");
                        b.this.ry.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.ggQ);
                    b.this.rD.setHint(b.this.getContext().getResources().getString(d.j.emotion_edit_hint));
                    b.this.ry.setHint(b.this.getContext().getResources().getString(d.j.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.ggO * 2);
        int height = getHeight() - (this.ggO * 2);
        if (this.ggU == 0 && this.ggV == 0) {
            this.ggU = width;
            this.ggV = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.bKn && getTop() + height < this.bKo) {
                setTextSize(2, px2sp(getContext(), this.ry.getTextSize()) + 1);
            }
        } else if (this.ry.getTextSize() > e(getContext(), this.ggR)) {
            setTextSize(2, px2sp(getContext(), this.ry.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.rD.setTextColor(i);
        this.ry.setTextColor(i);
    }

    public void cu(int i, int i2) {
        this.bKn = i;
        this.bKo = i2;
        if (this.bKn < l.ao(getContext()) / 4) {
            setTextSize(2, this.ggR);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.rD.getTextSize() != f) {
            this.rD.setTextSize(i, f);
        }
        if (this.ry.getTextSize() != f) {
            this.ry.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.rD.setFocusable(true);
            this.rD.setFocusableInTouchMode(true);
            this.rD.requestFocus();
            return;
        }
        this.rD.setFocusable(false);
        this.rD.setFocusableInTouchMode(false);
    }

    public void bil() {
        if (!this.ggS) {
            this.ggS = true;
            this.rD.setVisibility(4);
            this.ry.setVisibility(0);
            this.ggM.setVisibility(0);
            this.ggN.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void bim() {
        if (this.ggS) {
            this.ggS = false;
            this.rD.setVisibility(0);
            this.ry.setVisibility(4);
            this.ggM.setVisibility(4);
            this.ggN.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.ry;
    }

    public View getEditText() {
        return this.rD;
    }

    public String getText() {
        return this.ry.getText().toString();
    }

    public float getTextSize() {
        return this.ry.getTextSize();
    }

    public int getTextColor() {
        return this.ry.getCurrentTextColor();
    }

    public int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int e(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
