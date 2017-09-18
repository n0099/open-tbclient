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
    private int aRo;
    private int aRp;
    private TextView abu;
    private float bvU;
    private float cfs;
    private EditText dIv;
    private boolean eUA;
    public int eUB;
    private int eUC;
    private int eUD;
    private ImageView eUs;
    private ImageView eUt;
    private int eUu;
    private float eUv;
    private float eUw;
    private int eUx;
    private int eUy;
    private int eUz;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfs = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eUu = getResources().getDimensionPixelSize(d.f.ds20);
        this.eUB = this.eUu * 2;
        this.eUx = 24;
        this.eUy = 16;
        this.eUz = 40;
        FrameLayout.LayoutParams aUt = aUt();
        addView(this.dIv, aUt);
        a(aUt);
        aUs();
        aUr();
        setTextSize(2, this.eUx);
        aUu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Fb) < this.cfs && Math.abs(motionEvent.getRawY() - this.bvU) < this.cfs;
    }

    private void aUr() {
        this.eUt = new ImageView(getContext());
        this.eUt.setImageResource(d.g.icon_frame_enlarge_n);
        this.eUt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.Fb = motionEvent.getRawX();
                        b.this.bvU = motionEvent.getRawY();
                        b.this.eUv = b.this.Fb;
                        b.this.eUw = b.this.bvU;
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
                        float f = rawX - b.this.eUv;
                        if (!b.this.t(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eUv = rawX;
                        b.this.eUw = rawY;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eUt.setPadding(0, 0, this.eUu, this.eUu);
        addView(this.eUt, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.abu = new TextView(getContext());
        this.abu.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.abu.setBackgroundResource(d.g.bg_emotion_edit);
        this.abu.setPadding(this.eUu, this.eUu / 2, this.eUu, this.eUu / 2);
        this.abu.setSingleLine();
        this.abu.setIncludeFontPadding(false);
        this.abu.setEllipsize(TextUtils.TruncateAt.END);
        this.abu.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        this.abu.getPaint().setFakeBoldText(true);
        addView(this.abu, layoutParams);
    }

    private void aUs() {
        this.eUs = new ImageView(getContext());
        this.eUs.setImageResource(d.g.icon_frame_close_n);
        this.eUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dIv.setText("");
                b.this.abu.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eUs.setPadding(this.eUu, this.eUu, this.eUu, this.eUu);
        addView(this.eUs, layoutParams);
    }

    private FrameLayout.LayoutParams aUt() {
        this.dIv = new EditText(getContext());
        this.dIv.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.dIv.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eUB, this.eUB, this.eUB, this.eUB);
        layoutParams.gravity = 17;
        this.dIv.setPadding(this.eUu, this.eUu / 2, this.eUu, this.eUu / 2);
        this.dIv.setSingleLine();
        this.dIv.setIncludeFontPadding(false);
        this.dIv.getPaint().setFakeBoldText(true);
        this.dIv.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dIv, Integer.valueOf(d.g.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dIv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aRo - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.abu.getText().toString().length() || b.this.abu.getTextSize() <= b.this.d(b.this.getContext(), b.this.eUy) || b.this.abu.getTextSize() == b.this.d(b.this.getContext(), b.this.eUx) || width != 0) {
                        if (editable.toString().length() < b.this.abu.getText().toString().length() && width > 0 && b.this.abu.getTextSize() != b.this.d(b.this.getContext(), b.this.eUx)) {
                            b.this.setTextSize(2, b.this.c(b.this.getContext(), b.this.abu.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.c(b.this.getContext(), b.this.abu.getTextSize()) - 1);
                    }
                    b.this.abu.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dIv.setHint("");
                        b.this.abu.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eUx);
                    b.this.dIv.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                    b.this.abu.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eUu * 2);
        int height = getHeight() - (this.eUu * 2);
        if (this.eUC == 0 && this.eUD == 0) {
            this.eUC = width;
            this.eUD = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aRo && getTop() + height < this.aRp) {
                setTextSize(2, c(getContext(), this.abu.getTextSize()) + 1);
            }
        } else if (this.abu.getTextSize() > d(getContext(), this.eUy)) {
            setTextSize(2, c(getContext(), this.abu.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dIv.setTextColor(i);
        this.abu.setTextColor(i);
    }

    public void bo(int i, int i2) {
        this.aRo = i;
        this.aRp = i2;
        if (this.aRo < k.ae(getContext()) / 4) {
            setTextSize(2, this.eUy);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dIv.getTextSize() != f) {
            this.dIv.setTextSize(i, f);
        }
        if (this.abu.getTextSize() != f) {
            this.abu.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dIv.setFocusable(true);
            this.dIv.setFocusableInTouchMode(true);
            this.dIv.requestFocus();
            return;
        }
        this.dIv.setFocusable(false);
        this.dIv.setFocusableInTouchMode(false);
    }

    public void aUu() {
        if (!this.eUA) {
            this.eUA = true;
            this.dIv.setVisibility(4);
            this.abu.setVisibility(0);
            this.eUs.setVisibility(0);
            this.eUt.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aUv() {
        if (this.eUA) {
            this.eUA = false;
            this.dIv.setVisibility(0);
            this.abu.setVisibility(4);
            this.eUs.setVisibility(4);
            this.eUt.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.abu;
    }

    public View getEditText() {
        return this.dIv;
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
