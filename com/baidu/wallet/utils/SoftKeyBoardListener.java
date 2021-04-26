package com.baidu.wallet.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class SoftKeyBoardListener implements NoProguard {
    public OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    public View rootView;
    public int rootViewVisibleHeight;

    /* loaded from: classes5.dex */
    public interface OnSoftKeyBoardChangeListener {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.rootView = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.wallet.utils.SoftKeyBoardListener.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                SoftKeyBoardListener.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                SoftKeyBoardListener softKeyBoardListener = SoftKeyBoardListener.this;
                int i2 = softKeyBoardListener.rootViewVisibleHeight;
                if (i2 == 0) {
                    softKeyBoardListener.rootViewVisibleHeight = height;
                } else if (i2 == height) {
                } else {
                    if (i2 - height > 200) {
                        if (softKeyBoardListener.onSoftKeyBoardChangeListener != null) {
                            SoftKeyBoardListener.this.onSoftKeyBoardChangeListener.keyBoardShow(SoftKeyBoardListener.this.rootViewVisibleHeight - height);
                        }
                        SoftKeyBoardListener.this.rootViewVisibleHeight = height;
                    } else if (height - i2 > 200) {
                        if (softKeyBoardListener.onSoftKeyBoardChangeListener != null) {
                            SoftKeyBoardListener.this.onSoftKeyBoardChangeListener.keyBoardHide(height - SoftKeyBoardListener.this.rootViewVisibleHeight);
                        }
                        SoftKeyBoardListener.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        new SoftKeyBoardListener(activity).setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener);
    }

    private void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener;
    }
}
