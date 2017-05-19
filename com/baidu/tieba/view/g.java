package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class g extends LinkMovementMethod {
    private static g fIq;
    private com.baidu.tbadk.widget.richText.b fIn;
    private int fIo;
    private int fIp;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.b a = a(textView, spannable, motionEvent);
        if (a == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (a != null) {
            this.fIn = a;
        }
        if (motionEvent.getAction() == 0) {
            this.fIo = (int) motionEvent.getX();
            this.fIp = (int) motionEvent.getY();
            if (this.fIn != null) {
                this.fIn.fs(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.fIn), spannable.getSpanEnd(this.fIn));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.fIn != null && (Math.abs(this.fIo - motionEvent.getX()) > 20.0f || Math.abs(this.fIp - motionEvent.getY()) > 20.0f)) {
                this.fIn.fs(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.fIn != null) {
            this.fIn.fs(2);
            textView.invalidate();
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static g bkT() {
        if (fIq == null) {
            fIq = new g();
        }
        return fIq;
    }

    private com.baidu.tbadk.widget.richText.b a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.fIn;
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
