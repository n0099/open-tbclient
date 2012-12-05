package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class KeyboardLayout extends RelativeLayout {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    private boolean mHasInit;
    private boolean mHasKeybord;
    private int mHeight;
    private onKybdsChangeListener mListener;

    /* loaded from: classes.dex */
    public interface onKybdsChangeListener {
        void onKeyBoardStateChange(int i);
    }

    public KeyboardLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mHasInit = false;
    }

    public KeyboardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mHasInit = false;
    }

    public KeyboardLayout(Context context) {
        super(context);
        this.mHasInit = false;
    }

    public void setOnkbdStateListener(onKybdsChangeListener listener) {
        this.mListener = listener;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mHeight = b;
            if (this.mListener != null) {
                this.mListener.onKeyBoardStateChange(-1);
            }
        } else {
            this.mHeight = this.mHeight < b ? b : this.mHeight;
        }
        if (this.mHasInit && this.mHeight > b) {
            this.mHasKeybord = true;
            if (this.mListener != null) {
                this.mListener.onKeyBoardStateChange(-3);
            }
        }
        if (this.mHasInit && this.mHasKeybord && this.mHeight == b) {
            this.mHasKeybord = false;
            if (this.mListener != null) {
                this.mListener.onKeyBoardStateChange(-2);
            }
        }
    }
}
