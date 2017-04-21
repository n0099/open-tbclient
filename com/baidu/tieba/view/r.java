package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class r extends LinkMovementMethod {
    private static r fMl;

    public static r bnq() {
        if (fMl == null) {
            fMl = new r();
        }
        return fMl;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        q b = b(textView, spannable, motionEvent);
        if (motionEvent.getAction() == 0) {
            if (b != null) {
                b.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(b), spannable.getSpanEnd(b));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (b != null) {
                b.setPressed(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
        } else if (motionEvent.getAction() == 1) {
            if (b != null) {
                b.setPressed(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            Selection.removeSelection(spannable);
            textView.invalidate();
        } else if (motionEvent.getAction() == 3) {
            if (b != null) {
                b.setPressed(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            Selection.removeSelection(spannable);
            textView.invalidate();
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    private q b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        int scrollY = y + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        q[] qVarArr = (q[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, q.class);
        if (qVarArr.length <= 0) {
            return null;
        }
        return qVarArr[0];
    }
}
