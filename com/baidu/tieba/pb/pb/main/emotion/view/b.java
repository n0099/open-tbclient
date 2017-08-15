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
    private float Hh;
    private int aRH;
    private int aRI;
    private float but;
    private float cbI;
    private EditText dAX;
    private ImageView eUV;
    private ImageView eUW;
    private int eUX;
    private float eUY;
    private float eUZ;
    private int eVa;
    private int eVb;
    private int eVc;
    private boolean eVd;
    public int eVe;
    private int eVf;
    private int eVg;
    private TextView mTextView;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cbI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eUX = getResources().getDimensionPixelSize(d.f.ds20);
        this.eVe = this.eUX * 2;
        this.eVa = 24;
        this.eVb = 16;
        this.eVc = 40;
        FrameLayout.LayoutParams aVc = aVc();
        addView(this.dAX, aVc);
        a(aVc);
        aVb();
        aVa();
        setTextSize(2, this.eVa);
        aVd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Hh) < this.cbI && Math.abs(motionEvent.getRawY() - this.but) < this.cbI;
    }

    private void aVa() {
        this.eUW = new ImageView(getContext());
        this.eUW.setImageResource(d.g.icon_frame_enlarge_n);
        this.eUW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.Hh = motionEvent.getRawX();
                        b.this.but = motionEvent.getRawY();
                        b.this.eUY = b.this.Hh;
                        b.this.eUZ = b.this.but;
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
                        float f = rawX - b.this.eUY;
                        if (!b.this.t(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eUY = rawX;
                        b.this.eUZ = rawY;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eUW.setPadding(0, 0, this.eUX, this.eUX);
        addView(this.eUW, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.mTextView.setBackgroundResource(d.g.bg_emotion_edit);
        this.mTextView.setPadding(this.eUX, this.eUX / 2, this.eUX, this.eUX / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void aVb() {
        this.eUV = new ImageView(getContext());
        this.eUV.setImageResource(d.g.icon_frame_close_n);
        this.eUV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dAX.setText("");
                b.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eUV.setPadding(this.eUX, this.eUX, this.eUX, this.eUX);
        addView(this.eUV, layoutParams);
    }

    private FrameLayout.LayoutParams aVc() {
        this.dAX = new EditText(getContext());
        this.dAX.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.dAX.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eVe, this.eVe, this.eVe, this.eVe);
        layoutParams.gravity = 17;
        this.dAX.setPadding(this.eUX, this.eUX / 2, this.eUX, this.eUX / 2);
        this.dAX.setSingleLine();
        this.dAX.setIncludeFontPadding(false);
        this.dAX.getPaint().setFakeBoldText(true);
        this.dAX.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dAX, Integer.valueOf(d.g.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dAX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aRH - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.mTextView.getText().toString().length() || b.this.mTextView.getTextSize() <= b.this.c(b.this.getContext(), b.this.eVb) || b.this.mTextView.getTextSize() == b.this.c(b.this.getContext(), b.this.eVa) || width != 0) {
                        if (editable.toString().length() < b.this.mTextView.getText().toString().length() && width > 0 && b.this.mTextView.getTextSize() != b.this.c(b.this.getContext(), b.this.eVa)) {
                            b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.mTextView.getTextSize()) - 1);
                    }
                    b.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dAX.setHint("");
                        b.this.mTextView.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eVa);
                    b.this.dAX.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                    b.this.mTextView.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eUX * 2);
        int height = getHeight() - (this.eUX * 2);
        if (this.eVf == 0 && this.eVg == 0) {
            this.eVf = width;
            this.eVg = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aRH && getTop() + height < this.aRI) {
                setTextSize(2, b(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > c(getContext(), this.eVb)) {
            setTextSize(2, b(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dAX.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void bl(int i, int i2) {
        this.aRH = i;
        this.aRI = i2;
        if (this.aRH < k.ag(getContext()) / 4) {
            setTextSize(2, this.eVb);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dAX.getTextSize() != f) {
            this.dAX.setTextSize(i, f);
        }
        if (this.mTextView.getTextSize() != f) {
            this.mTextView.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dAX.setFocusable(true);
            this.dAX.setFocusableInTouchMode(true);
            this.dAX.requestFocus();
            return;
        }
        this.dAX.setFocusable(false);
        this.dAX.setFocusableInTouchMode(false);
    }

    public void aVd() {
        if (!this.eVd) {
            this.eVd = true;
            this.dAX.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.eUV.setVisibility(0);
            this.eUW.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aVe() {
        if (this.eVd) {
            this.eVd = false;
            this.dAX.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.eUV.setVisibility(4);
            this.eUW.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public View getEditText() {
        return this.dAX;
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
