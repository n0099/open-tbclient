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
import com.baidu.tieba.R;
import com.baidu.tieba.write.j;
/* loaded from: classes2.dex */
public class EmotionEditText extends FrameLayout {
    private EditText cDt;
    private float cGB;
    private int fYy;
    private int fYz;
    private float iRH;
    private float mDownX;
    private int mMargin;
    private TextView mTextView;
    private ImageView mmH;
    private ImageView mmI;
    private float mmJ;
    private int mmK;
    private int mmL;
    private boolean mmM;
    public int mmN;
    private int mmO;
    private int mmP;

    public EmotionEditText(Context context) {
        this(context, null);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iRH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.mMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
        this.mmN = this.mMargin * 2;
        this.mmK = 24;
        this.mmL = 16;
        FrameLayout.LayoutParams dxJ = dxJ();
        addView(this.cDt, dxJ);
        b(dxJ);
        dxI();
        dxH();
        setTextSize(2, this.mmK);
        dxK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iRH && Math.abs(motionEvent.getRawY() - this.cGB) < this.iRH;
    }

    private void dxH() {
        this.mmI = new ImageView(getContext());
        this.mmI.setImageResource(R.drawable.icon_frame_enlarge_n);
        this.mmI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.cGB = motionEvent.getRawY();
                        EmotionEditText.this.mmJ = EmotionEditText.this.mDownX;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(EmotionEditText.this.getLeft(), EmotionEditText.this.getTop(), 0, 0);
                        EmotionEditText.this.setLayoutParams(layoutParams);
                        return true;
                    case 1:
                    default:
                        return true;
                    case 2:
                        float rawX = motionEvent.getRawX();
                        motionEvent.getRawY();
                        float f = rawX - EmotionEditText.this.mmJ;
                        if (!EmotionEditText.this.ab(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.mmJ = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.mmI.setPadding(0, 0, this.mMargin, this.mMargin);
        addView(this.mmI, layoutParams);
    }

    private void b(FrameLayout.LayoutParams layoutParams) {
        this.mTextView = new TextView(getContext());
        this.mTextView.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.mTextView.setBackgroundResource(R.drawable.bg_emotion_edit);
        this.mTextView.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.mTextView.setSingleLine();
        this.mTextView.setIncludeFontPadding(false);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mTextView.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.mTextView.getPaint().setFakeBoldText(true);
        addView(this.mTextView, layoutParams);
    }

    private void dxI() {
        this.mmH = new ImageView(getContext());
        this.mmH.setImageResource(R.drawable.icon_frame_close_n);
        this.mmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionEditText.this.cDt.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mmH.setPadding(this.mMargin, this.mMargin, this.mMargin, this.mMargin);
        addView(this.mmH, layoutParams);
    }

    private FrameLayout.LayoutParams dxJ() {
        this.cDt = new EditText(getContext());
        this.cDt.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.cDt.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.mmN, this.mmN, this.mmN, this.mmN);
        layoutParams.gravity = 17;
        this.cDt.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.cDt.setSingleLine();
        this.cDt.setIncludeFontPadding(false);
        this.cDt.getPaint().setFakeBoldText(true);
        this.cDt.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        j.h(this.cDt, R.drawable.emotion_edittext_cursor);
        this.cDt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (EmotionEditText.this.fYy - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mmL) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mmK) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mmK)) {
                            EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) - 1);
                    }
                    EmotionEditText.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        EmotionEditText.this.cDt.setHint("");
                        EmotionEditText.this.mTextView.setHint("");
                        return;
                    }
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.mmK);
                    EmotionEditText.this.cDt.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
                    EmotionEditText.this.mTextView.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
                }
            }
        });
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(float f) {
        int width = getWidth() - (this.mMargin * 2);
        int height = getHeight() - (this.mMargin * 2);
        if (this.mmO == 0 && this.mmP == 0) {
            this.mmO = width;
            this.mmP = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.fYy && getTop() + height < this.fYz) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > h(getContext(), this.mmL)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.cDt.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.fYy = i;
        this.fYz = i2;
        if (this.fYy < l.getEquipmentWidth(getContext()) / 4) {
            setTextSize(2, this.mmL);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.cDt.getTextSize() != f) {
            this.cDt.setTextSize(i, f);
        }
        if (this.mTextView.getTextSize() != f) {
            this.mTextView.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.cDt.setFocusable(true);
            this.cDt.setFocusableInTouchMode(true);
            this.cDt.requestFocus();
            return;
        }
        this.cDt.setFocusable(false);
        this.cDt.setFocusableInTouchMode(false);
    }

    public void dxK() {
        if (!this.mmM) {
            this.mmM = true;
            this.cDt.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.mmH.setVisibility(0);
            this.mmI.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void dxL() {
        if (this.mmM) {
            this.mmM = false;
            this.cDt.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.mmH.setVisibility(4);
            this.mmI.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public View getEditText() {
        return this.cDt;
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

    public int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int h(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
