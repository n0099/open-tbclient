package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class b extends LinkMovementMethod {
    private static b gwT;
    private com.baidu.tbadk.widget.richText.b gwQ;
    private int gwR;
    private int gwS;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.b a = a(textView, spannable, motionEvent);
        if (a == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (a != null) {
            this.gwQ = a;
        }
        if (motionEvent.getAction() == 0) {
            this.gwR = (int) motionEvent.getX();
            this.gwS = (int) motionEvent.getY();
            if (this.gwQ != null) {
                this.gwQ.fB(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.gwQ), spannable.getSpanEnd(this.gwQ));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.gwQ != null && (Math.abs(this.gwR - motionEvent.getX()) > 20.0f || Math.abs(this.gwS - motionEvent.getY()) > 20.0f)) {
                this.gwQ.fB(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.gwQ != null) {
            this.gwQ.fB(2);
            textView.invalidate();
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static b bwG() {
        if (gwT == null) {
            gwT = new b();
        }
        return gwT;
    }

    private com.baidu.tbadk.widget.richText.b a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.gwQ;
        }
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        int scrollY = y + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        com.baidu.tbadk.widget.richText.b[] bVarArr = (com.baidu.tbadk.widget.richText.b[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.b.class);
        if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
            return null;
        }
        return bVarArr[0];
    }
}
