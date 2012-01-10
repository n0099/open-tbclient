package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
/* loaded from: classes.dex */
public class SearchEditText extends EditText {
    private OnBackPressedListener mOnBackPressedListener;

    /* loaded from: classes.dex */
    public interface OnBackPressedListener {
        void onBackPressed();
    }

    public SearchEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SearchEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchEditText(Context context) {
        super(context);
    }

    public void setOnBackPressedListener(OnBackPressedListener listener) {
        this.mOnBackPressedListener = listener;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == 4 && event.getAction() == 0) {
            this.mOnBackPressedListener.onBackPressed();
            return false;
        }
        return super.dispatchKeyEvent(event);
    }
}
