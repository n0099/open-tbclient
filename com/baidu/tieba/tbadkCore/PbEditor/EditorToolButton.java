package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] bVx = {com.baidu.tieba.s.custom_state_focused};
    protected static final int[] bVy = {com.baidu.tieba.s.custom_state_skin};
    protected boolean bVt;
    protected boolean bVu;
    protected boolean bVv;
    protected boolean bVw;
    protected Context mContext;
    protected int mSkinType;
    protected TextView mTip;

    public EditorToolButton(Context context) {
        super(context);
        this.bVt = false;
        this.bVu = true;
        this.bVv = false;
        this.bVw = false;
        this.mSkinType = 0;
        this.mContext = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVt = false;
        this.bVu = true;
        this.bVv = false;
        this.bVw = false;
        this.mSkinType = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.custom_state);
        this.bVt = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.bVt) {
            mergeDrawableStates(onCreateDrawableState, bVx);
        }
        return onCreateDrawableState;
    }

    public void yL() {
        if (!this.bVw) {
            setVisibility(0);
        }
    }

    public TextView getTip() {
        return this.mTip;
    }

    public void hide() {
        setVisibility(8);
    }

    public void enable() {
        setEnabled(true);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!this.bVv) {
            super.setEnabled(z);
        }
    }

    public void disable() {
        setEnabled(false);
    }

    public void h(TextView textView) {
        this.mTip = textView;
    }

    public void tP() {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
        }
    }

    public void ig(String str) {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
            this.mTip.setText(str);
        }
    }

    public void tQ() {
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.bVu = z;
        if (!z) {
            afo();
        }
    }

    public boolean afm() {
        return this.bVu;
    }

    public void setHardDisabled(boolean z) {
        this.bVv = z;
        disable();
    }

    public void setHardInvisible(boolean z) {
        this.bVw = z;
        hide();
    }

    public void afn() {
        this.bVt = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.bVt;
    }

    public void afo() {
        this.bVt = false;
        refreshDrawableState();
    }
}
