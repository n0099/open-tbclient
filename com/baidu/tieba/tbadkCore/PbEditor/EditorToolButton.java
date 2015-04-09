package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] cmc = {com.baidu.tieba.r.custom_state_focused};
    protected static final int[] cme = {com.baidu.tieba.r.custom_state_skin};
    protected boolean clY;
    protected boolean clZ;
    protected boolean cma;
    protected boolean cmb;
    protected Context mContext;
    protected int mSkinType;
    protected TextView mTip;

    public EditorToolButton(Context context) {
        super(context);
        this.clY = false;
        this.clZ = true;
        this.cma = false;
        this.cmb = false;
        this.mSkinType = 0;
        this.mContext = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clY = false;
        this.clZ = true;
        this.cma = false;
        this.cmb = false;
        this.mSkinType = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.custom_state);
        this.clY = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.clY) {
            mergeDrawableStates(onCreateDrawableState, cmc);
        }
        return onCreateDrawableState;
    }

    public void Cf() {
        if (!this.cmb) {
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
        if (!this.cma) {
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

    public void iE(String str) {
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
        this.clZ = z;
        if (!z) {
            alq();
        }
    }

    public boolean alo() {
        return this.clZ;
    }

    public void setHardDisabled(boolean z) {
        this.cma = z;
        disable();
    }

    public void setHardInvisible(boolean z) {
        this.cmb = z;
        hide();
    }

    public void alp() {
        this.clY = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.clY;
    }

    public void alq() {
        this.clY = false;
        refreshDrawableState();
    }
}
