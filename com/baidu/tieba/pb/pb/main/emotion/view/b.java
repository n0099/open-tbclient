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
    private float FG;
    private int aQt;
    private int aQu;
    private float bZQ;
    private float bsT;
    private EditText dxI;
    private ImageView eRP;
    private ImageView eRQ;
    private int eRR;
    private float eRS;
    private float eRT;
    private int eRU;
    private int eRV;
    private int eRW;
    private boolean eRX;
    public int eRY;
    private int eRZ;
    private int eSa;
    private TextView mTextView;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZQ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.eRR = getResources().getDimensionPixelSize(d.f.ds20);
        this.eRY = this.eRR * 2;
        this.eRU = 24;
        this.eRV = 16;
        this.eRW = 40;
        FrameLayout.LayoutParams aUk = aUk();
        addView(this.dxI, aUk);
        a(aUk);
        aUj();
        aUi();
        setTextSize(2, this.eRU);
        aUl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.FG) < this.bZQ && Math.abs(motionEvent.getRawY() - this.bsT) < this.bZQ;
    }

    private void aUi() {
        this.eRQ = new ImageView(getContext());
        this.eRQ.setImageResource(d.g.icon_frame_enlarge_n);
        this.eRQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.FG = motionEvent.getRawX();
                        b.this.bsT = motionEvent.getRawY();
                        b.this.eRS = b.this.FG;
                        b.this.eRT = b.this.bsT;
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
                        float f = rawX - b.this.eRS;
                        if (!b.this.t(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.eRS = rawX;
                        b.this.eRT = rawY;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.eRQ.setPadding(0, 0, this.eRR, this.eRR);
        addView(this.eRQ, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.mTextView.setBackgroundResource(d.g.bg_emotion_edit);
        this.mTextView.setPadding(this.eRR, this.eRR / 2, this.eRR, this.eRR / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void aUj() {
        this.eRP = new ImageView(getContext());
        this.eRP.setImageResource(d.g.icon_frame_close_n);
        this.eRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dxI.setText("");
                b.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.eRP.setPadding(this.eRR, this.eRR, this.eRR, this.eRR);
        addView(this.eRP, layoutParams);
    }

    private FrameLayout.LayoutParams aUk() {
        this.dxI = new EditText(getContext());
        this.dxI.setHint(getContext().getResources().getString(d.l.emotion_edit_hint));
        this.dxI.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.eRY, this.eRY, this.eRY, this.eRY);
        layoutParams.gravity = 17;
        this.dxI.setPadding(this.eRR, this.eRR / 2, this.eRR, this.eRR / 2);
        this.dxI.setSingleLine();
        this.dxI.setIncludeFontPadding(false);
        this.dxI.getPaint().setFakeBoldText(true);
        this.dxI.setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.dxI, Integer.valueOf(d.g.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.dxI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.aQt - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.mTextView.getText().toString().length() || b.this.mTextView.getTextSize() <= b.this.c(b.this.getContext(), b.this.eRV) || b.this.mTextView.getTextSize() == b.this.c(b.this.getContext(), b.this.eRU) || width != 0) {
                        if (editable.toString().length() < b.this.mTextView.getText().toString().length() && width > 0 && b.this.mTextView.getTextSize() != b.this.c(b.this.getContext(), b.this.eRU)) {
                            b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.b(b.this.getContext(), b.this.mTextView.getTextSize()) - 1);
                    }
                    b.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.dxI.setHint("");
                        b.this.mTextView.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.eRU);
                    b.this.dxI.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                    b.this.mTextView.setHint(b.this.getContext().getResources().getString(d.l.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.eRR * 2);
        int height = getHeight() - (this.eRR * 2);
        if (this.eRZ == 0 && this.eSa == 0) {
            this.eRZ = width;
            this.eSa = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.aQt && getTop() + height < this.aQu) {
                setTextSize(2, b(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > c(getContext(), this.eRV)) {
            setTextSize(2, b(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.dxI.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void bc(int i, int i2) {
        this.aQt = i;
        this.aQu = i2;
        if (this.aQt < k.af(getContext()) / 4) {
            setTextSize(2, this.eRV);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.dxI.getTextSize() != f) {
            this.dxI.setTextSize(i, f);
        }
        if (this.mTextView.getTextSize() != f) {
            this.mTextView.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.dxI.setFocusable(true);
            this.dxI.setFocusableInTouchMode(true);
            this.dxI.requestFocus();
            return;
        }
        this.dxI.setFocusable(false);
        this.dxI.setFocusableInTouchMode(false);
    }

    public void aUl() {
        if (!this.eRX) {
            this.eRX = true;
            this.dxI.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.eRP.setVisibility(0);
            this.eRQ.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void aUm() {
        if (this.eRX) {
            this.eRX = false;
            this.dxI.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.eRP.setVisibility(4);
            this.eRQ.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public View getEditText() {
        return this.dxI;
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
