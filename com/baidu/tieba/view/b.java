package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class b extends LinkMovementMethod {
    private static b gxx;
    private com.baidu.tbadk.widget.richText.b gxu;
    private int gxv;
    private int gxw;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.b a = a(textView, spannable, motionEvent);
        if (a == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (a != null) {
            this.gxu = a;
        }
        if (motionEvent.getAction() == 0) {
            this.gxv = (int) motionEvent.getX();
            this.gxw = (int) motionEvent.getY();
            if (this.gxu != null) {
                this.gxu.fA(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.gxu), spannable.getSpanEnd(this.gxu));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.gxu != null && (Math.abs(this.gxv - motionEvent.getX()) > 20.0f || Math.abs(this.gxw - motionEvent.getY()) > 20.0f)) {
                this.gxu.fA(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.gxu != null) {
            this.gxu.fA(2);
            textView.invalidate();
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static b bxm() {
        if (gxx == null) {
            gxx = new b();
        }
        return gxx;
    }

    private com.baidu.tbadk.widget.richText.b a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.gxu;
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
