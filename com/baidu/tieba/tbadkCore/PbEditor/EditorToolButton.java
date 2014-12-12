package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] bTG = {com.baidu.tieba.s.custom_state_focused};
    protected static final int[] bTH = {com.baidu.tieba.s.custom_state_skin};
    protected boolean bTC;
    protected boolean bTD;
    protected boolean bTE;
    protected boolean bTF;
    protected Context mContext;
    protected int mSkinType;
    protected TextView mTip;

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public EditorToolButton(Context context) {
        super(context);
        this.bTC = false;
        this.bTD = true;
        this.bTE = false;
        this.bTF = false;
        this.mSkinType = 0;
        this.mContext = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTC = false;
        this.bTD = true;
        this.bTE = false;
        this.bTF = false;
        this.mSkinType = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.ab.custom_state);
        this.bTC = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.bTC) {
            mergeDrawableStates(onCreateDrawableState, bTG);
        }
        return onCreateDrawableState;
    }

    public void yB() {
        if (!this.bTF) {
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
        if (!this.bTE) {
            super.setEnabled(z);
        }
    }

    public void disable() {
        setEnabled(false);
    }

    public void h(TextView textView) {
        this.mTip = textView;
    }

    public void tE() {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
        }
    }

    public void ia(String str) {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
            this.mTip.setText(str);
        }
    }

    public void tF() {
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.bTD = z;
        if (!z) {
            aeP();
        }
    }

    public boolean aeN() {
        return this.bTD;
    }

    public void setHardDisabled(boolean z) {
        this.bTE = z;
        disable();
    }

    public void setHardInvisible(boolean z) {
        this.bTF = z;
        hide();
    }

    public void aeO() {
        this.bTC = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.bTC;
    }

    public void aeP() {
        this.bTC = false;
        refreshDrawableState();
    }
}
