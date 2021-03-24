package com.baidu.wallet.core.utils;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class CommonUtils {
    public static void setPressedAlpha(View view) {
        if (view == null) {
            return;
        }
        setPressedAlpha(view, 0.5f);
    }

    public static void setPressedAlpha(View view, final float f2) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.core.utils.CommonUtils.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0 && action != 2) {
                    view2.setAlpha(1.0f);
                    return false;
                }
                view2.setAlpha(f2);
                return false;
            }
        });
    }
}
