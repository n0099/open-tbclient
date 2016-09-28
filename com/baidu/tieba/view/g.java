package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class g extends LinkMovementMethod {
    private static g fXW;
    private int fXU;
    private int fXV;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.h a = a(textView, spannable, motionEvent);
        if (a == null) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.fXU = (int) motionEvent.getX();
            this.fXV = (int) motionEvent.getY();
            if (a != null) {
                a.fv(1);
                Selection.setSelection(spannable, spannable.getSpanStart(a), spannable.getSpanEnd(a));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (a != null && (Math.abs(this.fXU - motionEvent.getX()) > 20.0f || Math.abs(this.fXV - motionEvent.getY()) > 20.0f)) {
                a.fv(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && a != null) {
            a.fv(2);
            textView.invalidate();
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static g bqP() {
        if (fXW == null) {
            fXW = new g();
        }
        return fXW;
    }

    private com.baidu.tbadk.widget.richText.h a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        int scrollY = y + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        com.baidu.tbadk.widget.richText.h[] hVarArr = (com.baidu.tbadk.widget.richText.h[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.h.class);
        if (hVarArr == null || hVarArr.length <= 0 || hVarArr[0] == null) {
            return null;
        }
        return hVarArr[0];
    }
}
