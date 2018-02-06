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
    private int bKA;
    private int bKB;
    private float cDu;
    private float drX;
    private ImageView ggX;
    private ImageView ggY;
    private int ggZ;
    private float gha;
    private int ghb;
    private int ghc;
    private boolean ghd;
    public int ghe;
    private int ghf;
    private int ghg;
    private float mDownX;
    private EditText rE;
    private TextView rz;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drX = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.ggZ = getResources().getDimensionPixelSize(d.e.ds20);
        this.ghe = this.ggZ * 2;
        this.ghb = 24;
        this.ghc = 16;
        FrameLayout.LayoutParams bil = bil();
        addView(this.rE, bil);
        a(bil);
        bik();
        bij();
        setTextSize(2, this.ghb);
        bim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.drX && Math.abs(motionEvent.getRawY() - this.cDu) < this.drX;
    }

    private void bij() {
        this.ggY = new ImageView(getContext());
        this.ggY.setImageResource(d.f.icon_frame_enlarge_n);
        this.ggY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mDownX = motionEvent.getRawX();
                        b.this.cDu = motionEvent.getRawY();
                        b.this.gha = b.this.mDownX;
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
                        float f = rawX - b.this.gha;
                        if (!b.this.M(motionEvent)) {
                            if (f > 0.0f) {
                                b.this.setSize(f);
                            } else {
                                b.this.setSize(f);
                            }
                        }
                        b.this.gha = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.ggY.setPadding(0, 0, this.ggZ, this.ggZ);
        addView(this.ggY, layoutParams);
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        this.rz = new TextView(getContext());
        this.rz.setHint(getContext().getResources().getString(d.j.emotion_edit_hint));
        this.rz.setBackgroundResource(d.f.bg_emotion_edit);
        this.rz.setPadding(this.ggZ, this.ggZ / 2, this.ggZ, this.ggZ / 2);
        this.rz.setSingleLine();
        this.rz.setIncludeFontPadding(false);
        this.rz.setEllipsize(TextUtils.TruncateAt.END);
        this.rz.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e));
        this.rz.getPaint().setFakeBoldText(true);
        addView(this.rz, layoutParams);
    }

    private void bik() {
        this.ggX = new ImageView(getContext());
        this.ggX.setImageResource(d.f.icon_frame_close_n);
        this.ggX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.rE.setText("");
                b.this.rz.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.ggX.setPadding(this.ggZ, this.ggZ, this.ggZ, this.ggZ);
        addView(this.ggX, layoutParams);
    }

    private FrameLayout.LayoutParams bil() {
        this.rE = new EditText(getContext());
        this.rE.setHint(getContext().getResources().getString(d.j.emotion_edit_hint));
        this.rE.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.ghe, this.ghe, this.ghe, this.ghe);
        layoutParams.gravity = 17;
        this.rE.setPadding(this.ggZ, this.ggZ / 2, this.ggZ, this.ggZ / 2);
        this.rE.setSingleLine();
        this.rE.setIncludeFontPadding(false);
        this.rE.getPaint().setFakeBoldText(true);
        this.rE.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e));
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.rE, Integer.valueOf(d.f.emotion_edittext_cursor));
        } catch (Exception e) {
        }
        this.rE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pbextra.emotion.view.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (b.this.bKA - b.this.getWidth()) - b.this.getLeft();
                    if (editable.toString().length() <= b.this.rz.getText().toString().length() || b.this.rz.getTextSize() <= b.this.e(b.this.getContext(), b.this.ghc) || b.this.rz.getTextSize() == b.this.e(b.this.getContext(), b.this.ghb) || width != 0) {
                        if (editable.toString().length() < b.this.rz.getText().toString().length() && width > 0 && b.this.rz.getTextSize() != b.this.e(b.this.getContext(), b.this.ghb)) {
                            b.this.setTextSize(2, b.this.px2sp(b.this.getContext(), b.this.rz.getTextSize()) + 1);
                        }
                    } else {
                        b.this.setTextSize(2, b.this.px2sp(b.this.getContext(), b.this.rz.getTextSize()) - 1);
                    }
                    b.this.rz.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        b.this.rE.setHint("");
                        b.this.rz.setHint("");
                        return;
                    }
                    b.this.setTextSize(2, b.this.ghb);
                    b.this.rE.setHint(b.this.getContext().getResources().getString(d.j.emotion_edit_hint));
                    b.this.rz.setHint(b.this.getContext().getResources().getString(d.j.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.ggZ * 2);
        int height = getHeight() - (this.ggZ * 2);
        if (this.ghf == 0 && this.ghg == 0) {
            this.ghf = width;
            this.ghg = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.bKA && getTop() + height < this.bKB) {
                setTextSize(2, px2sp(getContext(), this.rz.getTextSize()) + 1);
            }
        } else if (this.rz.getTextSize() > e(getContext(), this.ghc)) {
            setTextSize(2, px2sp(getContext(), this.rz.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.rE.setTextColor(i);
        this.rz.setTextColor(i);
    }

    public void cu(int i, int i2) {
        this.bKA = i;
        this.bKB = i2;
        if (this.bKA < l.ao(getContext()) / 4) {
            setTextSize(2, this.ghc);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.rE.getTextSize() != f) {
            this.rE.setTextSize(i, f);
        }
        if (this.rz.getTextSize() != f) {
            this.rz.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.rE.setFocusable(true);
            this.rE.setFocusableInTouchMode(true);
            this.rE.requestFocus();
            return;
        }
        this.rE.setFocusable(false);
        this.rE.setFocusableInTouchMode(false);
    }

    public void bim() {
        if (!this.ghd) {
            this.ghd = true;
            this.rE.setVisibility(4);
            this.rz.setVisibility(0);
            this.ggX.setVisibility(0);
            this.ggY.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void bin() {
        if (this.ghd) {
            this.ghd = false;
            this.rE.setVisibility(0);
            this.rz.setVisibility(4);
            this.ggX.setVisibility(4);
            this.ggY.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.rz;
    }

    public View getEditText() {
        return this.rE;
    }

    public String getText() {
        return this.rz.getText().toString();
    }

    public float getTextSize() {
        return this.rz.getTextSize();
    }

    public int getTextColor() {
        return this.rz.getCurrentTextColor();
    }

    public int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int e(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
