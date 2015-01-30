package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] bVy = {com.baidu.tieba.s.custom_state_focused};
    protected static final int[] bVz = {com.baidu.tieba.s.custom_state_skin};
    protected boolean bVu;
    protected boolean bVv;
    protected boolean bVw;
    protected boolean bVx;
    protected Context mContext;
    protected int mSkinType;
    protected TextView mTip;

    public EditorToolButton(Context context) {
        super(context);
        this.bVu = false;
        this.bVv = true;
        this.bVw = false;
        this.bVx = false;
        this.mSkinType = 0;
        this.mContext = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVu = false;
        this.bVv = true;
        this.bVw = false;
        this.bVx = false;
        this.mSkinType = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.custom_state);
        this.bVu = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.bVu) {
            mergeDrawableStates(onCreateDrawableState, bVy);
        }
        return onCreateDrawableState;
    }

    public void yR() {
        if (!this.bVx) {
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
        if (!this.bVw) {
            super.setEnabled(z);
        }
    }

    public void disable() {
        setEnabled(false);
    }

    public void h(TextView textView) {
        this.mTip = textView;
    }

    public void tV() {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
        }
    }

    public void ii(String str) {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
            this.mTip.setText(str);
        }
    }

    public void tW() {
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.bVv = z;
        if (!z) {
            aft();
        }
    }

    public boolean afr() {
        return this.bVv;
    }

    public void setHardDisabled(boolean z) {
        this.bVw = z;
        disable();
    }

    public void setHardInvisible(boolean z) {
        this.bVx = z;
        hide();
    }

    public void afs() {
        this.bVu = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.bVu;
    }

    public void aft() {
        this.bVu = false;
        refreshDrawableState();
    }
}
