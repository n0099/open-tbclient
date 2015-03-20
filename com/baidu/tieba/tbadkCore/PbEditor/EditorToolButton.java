package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] clM = {com.baidu.tieba.r.custom_state_focused};
    protected static final int[] clN = {com.baidu.tieba.r.custom_state_skin};
    protected boolean clI;
    protected boolean clJ;
    protected boolean clK;
    protected boolean clL;
    protected Context mContext;
    protected int mSkinType;
    protected TextView mTip;

    public EditorToolButton(Context context) {
        super(context);
        this.clI = false;
        this.clJ = true;
        this.clK = false;
        this.clL = false;
        this.mSkinType = 0;
        this.mContext = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clI = false;
        this.clJ = true;
        this.clK = false;
        this.clL = false;
        this.mSkinType = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.custom_state);
        this.clI = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.clI) {
            mergeDrawableStates(onCreateDrawableState, clM);
        }
        return onCreateDrawableState;
    }

    public void BZ() {
        if (!this.clL) {
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
        if (!this.clK) {
            super.setEnabled(z);
        }
    }

    public void disable() {
        setEnabled(false);
    }

    public void h(TextView textView) {
        this.mTip = textView;
    }

    public void displayTip() {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
        }
    }

    public void iB(String str) {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
            this.mTip.setText(str);
        }
    }

    public void hideTip() {
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.clJ = z;
        if (!z) {
            alb();
        }
    }

    public boolean akZ() {
        return this.clJ;
    }

    public void setHardDisabled(boolean z) {
        this.clK = z;
        disable();
    }

    public void setHardInvisible(boolean z) {
        this.clL = z;
        hide();
    }

    public void ala() {
        this.clI = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.clI;
    }

    public void alb() {
        this.clI = false;
        refreshDrawableState();
    }
}
