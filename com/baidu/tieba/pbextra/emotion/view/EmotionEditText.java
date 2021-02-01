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
    private EditText cBd;
    private float cEl;
    private int fWg;
    private int fWh;
    private float iSH;
    private float mDownX;
    private int mMargin;
    private TextView mTextView;
    private ImageView mre;
    private ImageView mrf;
    private float mrg;
    private int mrh;
    private int mri;
    private boolean mrj;
    public int mrk;
    private int mrl;
    private int mrm;

    public EmotionEditText(Context context) {
        this(context, null);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmotionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iSH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        init();
    }

    private void init() {
        this.mMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
        this.mrk = this.mMargin * 2;
        this.mrh = 24;
        this.mri = 16;
        FrameLayout.LayoutParams dwa = dwa();
        addView(this.cBd, dwa);
        b(dwa);
        dvZ();
        dvY();
        setTextSize(2, this.mrh);
        dwb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.mDownX) < this.iSH && Math.abs(motionEvent.getRawY() - this.cEl) < this.iSH;
    }

    private void dvY() {
        this.mrf = new ImageView(getContext());
        this.mrf.setImageResource(R.drawable.icon_frame_enlarge_n);
        this.mrf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        EmotionEditText.this.mDownX = motionEvent.getRawX();
                        EmotionEditText.this.cEl = motionEvent.getRawY();
                        EmotionEditText.this.mrg = EmotionEditText.this.mDownX;
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
                        float f = rawX - EmotionEditText.this.mrg;
                        if (!EmotionEditText.this.ab(motionEvent)) {
                            if (f > 0.0f) {
                                EmotionEditText.this.setSize(f);
                            } else {
                                EmotionEditText.this.setSize(f);
                            }
                        }
                        EmotionEditText.this.mrg = rawX;
                        return true;
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        this.mrf.setPadding(0, 0, this.mMargin, this.mMargin);
        addView(this.mrf, layoutParams);
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

    private void dvZ() {
        this.mre = new ImageView(getContext());
        this.mre.setImageResource(R.drawable.icon_frame_close_n);
        this.mre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EmotionEditText.this.cBd.setText("");
                EmotionEditText.this.mTextView.setText("");
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mre.setPadding(this.mMargin, this.mMargin, this.mMargin, this.mMargin);
        addView(this.mre, layoutParams);
    }

    private FrameLayout.LayoutParams dwa() {
        this.cBd = new EditText(getContext());
        this.cBd.setHint(getContext().getResources().getString(R.string.emotion_edit_hint));
        this.cBd.setBackgroundDrawable(null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(this.mrk, this.mrk, this.mrk, this.mrk);
        layoutParams.gravity = 17;
        this.cBd.setPadding(this.mMargin, this.mMargin / 2, this.mMargin, this.mMargin / 2);
        this.cBd.setSingleLine();
        this.cBd.setIncludeFontPadding(false);
        this.cBd.getPaint().setFakeBoldText(true);
        this.cBd.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        j.h(this.cBd, R.drawable.emotion_edittext_cursor);
        this.cBd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pbextra.emotion.view.EmotionEditText.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    int width = (EmotionEditText.this.fWg - EmotionEditText.this.getWidth()) - EmotionEditText.this.getLeft();
                    if (editable.toString().length() <= EmotionEditText.this.mTextView.getText().toString().length() || EmotionEditText.this.mTextView.getTextSize() <= EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mri) || EmotionEditText.this.mTextView.getTextSize() == EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mrh) || width != 0) {
                        if (editable.toString().length() < EmotionEditText.this.mTextView.getText().toString().length() && width > 0 && EmotionEditText.this.mTextView.getTextSize() != EmotionEditText.this.h(EmotionEditText.this.getContext(), EmotionEditText.this.mrh)) {
                            EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) + 1);
                        }
                    } else {
                        EmotionEditText.this.setTextSize(2, EmotionEditText.this.px2sp(EmotionEditText.this.getContext(), EmotionEditText.this.mTextView.getTextSize()) - 1);
                    }
                    EmotionEditText.this.mTextView.setText(editable.toString());
                    if (editable.toString().length() > 0) {
                        EmotionEditText.this.cBd.setHint("");
                        EmotionEditText.this.mTextView.setHint("");
                        return;
                    }
                    EmotionEditText.this.setTextSize(2, EmotionEditText.this.mrh);
                    EmotionEditText.this.cBd.setHint(EmotionEditText.this.getContext().getResources().getString(R.string.emotion_edit_hint));
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
        if (this.mrl == 0 && this.mrm == 0) {
            this.mrl = width;
            this.mrm = height;
        }
        if (f >= 0.0f) {
            if (width + getLeft() < this.fWg && getTop() + height < this.fWh) {
                setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) + 1);
            }
        } else if (this.mTextView.getTextSize() > h(getContext(), this.mri)) {
            setTextSize(2, px2sp(getContext(), this.mTextView.getTextSize()) - 1);
        }
    }

    public void setTextColor(int i) {
        this.cBd.setTextColor(i);
        this.mTextView.setTextColor(i);
    }

    public void setMaxImageSize(int i, int i2) {
        this.fWg = i;
        this.fWh = i2;
        if (this.fWg < l.getEquipmentWidth(getContext()) / 4) {
            setTextSize(2, this.mri);
        }
    }

    public void setTextSize(int i, float f) {
        if (this.cBd.getTextSize() != f) {
            this.cBd.setTextSize(i, f);
        }
        if (this.mTextView.getTextSize() != f) {
            this.mTextView.setTextSize(i, f);
        }
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.cBd.setFocusable(true);
            this.cBd.setFocusableInTouchMode(true);
            this.cBd.requestFocus();
            return;
        }
        this.cBd.setFocusable(false);
        this.cBd.setFocusableInTouchMode(false);
    }

    public void dwb() {
        if (!this.mrj) {
            this.mrj = true;
            this.cBd.setVisibility(4);
            this.mTextView.setVisibility(0);
            this.mre.setVisibility(0);
            this.mrf.setVisibility(0);
            setEditTextEnable(false);
        }
    }

    public void dwc() {
        if (this.mrj) {
            this.mrj = false;
            this.cBd.setVisibility(0);
            this.mTextView.setVisibility(4);
            this.mre.setVisibility(4);
            this.mrf.setVisibility(4);
            setEditTextEnable(true);
        }
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public View getEditText() {
        return this.cBd;
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
