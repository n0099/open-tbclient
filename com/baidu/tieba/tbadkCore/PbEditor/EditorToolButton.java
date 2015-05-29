package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class EditorToolButton extends ImageView {
    protected static final int[] cqb = {com.baidu.tieba.m.custom_state_focused};
    protected static final int[] cqc = {com.baidu.tieba.m.custom_state_skin};
    protected boolean cpX;
    protected boolean cpY;
    protected boolean cpZ;
    protected boolean cqa;
    protected Context mContext;
    protected int mSkinType;
    protected TextView mTip;

    public EditorToolButton(Context context) {
        super(context);
        this.cpX = false;
        this.cpY = true;
        this.cpZ = false;
        this.cqa = false;
        this.mSkinType = 0;
        this.mContext = context;
    }

    public EditorToolButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cpX = false;
        this.cpY = true;
        this.cpZ = false;
        this.cqa = false;
        this.mSkinType = 0;
        this.mContext = context;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, com.baidu.tieba.v.custom_state);
        this.cpX = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.cpX) {
            mergeDrawableStates(onCreateDrawableState, cqb);
        }
        return onCreateDrawableState;
    }

    public void CQ() {
        if (!this.cqa) {
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
        if (!this.cpZ) {
            super.setEnabled(z);
        }
    }

    public void disable() {
        setEnabled(false);
    }

    public void g(TextView textView) {
        this.mTip = textView;
    }

    public void displayTip() {
        if (this.mTip != null) {
            this.mTip.setVisibility(0);
        }
    }

    public void jx(String str) {
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
        this.cpY = z;
        if (!z) {
            anb();
        }
    }

    public boolean amZ() {
        return this.cpY;
    }

    public void setHardDisabled(boolean z) {
        this.cpZ = z;
        disable();
    }

    public void setHardInvisible(boolean z) {
        this.cqa = z;
        hide();
    }

    public void ana() {
        this.cpX = true;
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.cpX;
    }

    public void anb() {
        this.cpX = false;
        refreshDrawableState();
    }
}
