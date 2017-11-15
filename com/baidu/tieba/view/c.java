package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class c extends LinkMovementMethod {
    private static c gNh;
    private com.baidu.tbadk.widget.richText.c gNe;
    private int gNf;
    private int gNg;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.c a = a(textView, spannable, motionEvent);
        if (a == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (a != null) {
            this.gNe = a;
        }
        if (motionEvent.getAction() == 0) {
            this.gNf = (int) motionEvent.getX();
            this.gNg = (int) motionEvent.getY();
            if (this.gNe != null) {
                this.gNe.fV(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.gNe), spannable.getSpanEnd(this.gNe));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.gNe != null && (Math.abs(this.gNf - motionEvent.getX()) > 20.0f || Math.abs(this.gNg - motionEvent.getY()) > 20.0f)) {
                this.gNe.fV(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.gNe != null) {
            this.gNe.fV(2);
            textView.invalidate();
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static c bBt() {
        if (gNh == null) {
            gNh = new c();
        }
        return gNh;
    }

    private com.baidu.tbadk.widget.richText.c a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.gNe;
        }
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        int scrollY = y + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        com.baidu.tbadk.widget.richText.c[] cVarArr = (com.baidu.tbadk.widget.richText.c[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.c.class);
        if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
            return null;
        }
        return cVarArr[0];
    }
}
