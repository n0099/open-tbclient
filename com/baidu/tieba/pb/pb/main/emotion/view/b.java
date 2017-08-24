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
    private int aRI;
    private int aRJ;
    private float buu;
    private float cbJ;
    private EditText dAX;
    private ImageView eUX;
    private ImageView eUY;
    private int eUZ;
    private float eVa;
    private float eVb;
    private int eVc;
    private int eVd;
    private int eVe;
    private boolean eVf;
    public int eVg;
    private int eVh;
    private int eVi;
    private TextView mTextView;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cbJ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eUZ = getResources().getDimensionPixelSize(d.f.ds20);
        this.eVg = this.eUZ * 2;
        this.eVc = 24;
        this.eVd = 16;
        this.eVe = 40;
        FrameLayout.LayoutParams aUX = aUX();
        addView(this.dAX, aUX);
        a(aUX);
        aUW();
        aUV();
        setTextSize(2, this.eVc);
        aUY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Hh) < this.cbJ && Math.abs(motionEvent.getRawY() - this.buu) < this.cbJ;
    }

    private void aUV() {
        this.eUY = new ImageView(getContext());
        this.eUY.setImageResource(d.g.icon_frame_enlarge_n);
        this.eUY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.Hh = motionEvent.getRawX();
                        b.this.buu = motionEvent.getRawY();
                        b.this.eVa = b.this.Hh;
                        b.this.eVb = b.this.buu;
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
                        float f = rawX - b.this.eVa;
                        if (!b.this.t(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eVa = rawX;
                        b.this.eVb = rawY;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eUY.setPadding(0, 0, this.eUZ, this.eUZ);
        addView(this.eUY, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.mTextView.setBackgroundResource(d.g.bg_emotion_edit);
        this.mTextView.setPadding(this.eUZ, this.eUZ / 2, this.eUZ, this.eUZ / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void aUW() {
        this.eUX = new ImageView(getContext());
        this.eUX.setImageResource(d.g.icon_frame_close_n);
        this.eUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dAX.setText("");
                b.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eUX.setPadding(this.eUZ, this.eUZ, this.eUZ, this.eUZ);
        addView(this.eUX, layoutParams);
    }

    private FrameLayout.LayoutParams aUX() {
        this.dAX = new EditText(getContext());
        this.dAX.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.dAX.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eVg, this.eVg, this.eVg, this.eVg);
        layoutParams.gravity = 17;
        this.dAX.setPadding(this.eUZ, this.eUZ / 2, this.eUZ, this.eUZ / 2);
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
                    int width = (b.this.aRI - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.mTextView.getText().toString().length() || b.this.mTextView.getTextSize() <= b.this.d(b.this.getContext(), b.this.eVd) || b.this.mTextView.getTextSize() == b.this.d(b.this.getContext(), b.this.eVc) || width != 0) {
                        if (editable.toString().length() < b.this.mTextView.getText().toString().length() && width > 0 && b.this.mTextView.getTextSize() != b.this.d(b.this.getContext(), b.this.eVc)) {
                            b.this.setTextSize(2, b.this.c(b.this.getContext(), b.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.c(b.this.getContext(), b.this.mTextView.getTextSize()) - 1);
                    }
                    b.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dAX.setHint("");
                        b.this.mTextView.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eVc);
                    b.this.dAX.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                    b.this.mTextView.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eUZ * 2);
        int height = getHeight() - (this.eUZ * 2);
        if (this.eVh == 0 && this.eVi == 0) {
            this.eVh = width;
            this.eVi = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aRI && getTop() + height < this.aRJ) {
                setTextSize(2, c(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > d(getContext(), this.eVd)) {
            setTextSize(2, c(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dAX.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void bl(int i, int i2) {
        this.aRI = i;
        this.aRJ = i2;
        if (this.aRI < k.ag(getContext()) / 4) {
            setTextSize(2, this.eVd);
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

    public void aUY() {
        if (!this.eVf) {
            this.eVf = true;
            this.dAX.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.eUX.setVisibility(0);
            this.eUY.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aUZ() {
        if (this.eVf) {
            this.eVf = false;
            this.dAX.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.eUX.setVisibility(4);
            this.eUY.setVisibility(4);
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

    public int c(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int d(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
