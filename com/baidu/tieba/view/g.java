package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class g extends LinkMovementMethod {
    private static g fDi;
    private com.baidu.tbadk.widget.richText.b fDf;
    private int fDg;
    private int fDh;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.b a = a(textView, spannable, motionEvent);
        if (a == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (a != null) {
            this.fDf = a;
        }
        if (motionEvent.getAction() == 0) {
            this.fDg = (int) motionEvent.getX();
            this.fDh = (int) motionEvent.getY();
            if (this.fDf != null) {
                this.fDf.fz(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.fDf), spannable.getSpanEnd(this.fDf));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.fDf != null && (Math.abs(this.fDg - motionEvent.getX()) > 20.0f || Math.abs(this.fDh - motionEvent.getY()) > 20.0f)) {
                this.fDf.fz(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.fDf != null) {
            this.fDf.fz(2);
            textView.invalidate();
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static g blN() {
        if (fDi == null) {
            fDi = new g();
        }
        return fDi;
    }

    private com.baidu.tbadk.widget.richText.b a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
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
