package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class c extends LinkMovementMethod {
    private static c jJg;
    private int aFT;
    private int aFU;
    private int color = -1;
    private com.baidu.tbadk.widget.richText.c jJe;
    private long jJf;

    public void setColor(int i) {
        this.color = i;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.c b = b(textView, spannable, motionEvent);
        if (b == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (b != null) {
            this.jJe = b;
        }
        if (this.color > -1) {
            this.jJe.setColor(this.color);
        }
        if (motionEvent.getAction() == 0) {
            this.aFT = (int) motionEvent.getX();
            this.aFU = (int) motionEvent.getY();
            this.jJf = System.currentTimeMillis();
            if (this.jJe != null) {
                this.jJe.kO(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.jJe), spannable.getSpanEnd(this.jJe));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.jJe != null && (Math.abs(this.aFT - motionEvent.getX()) > 20.0f || Math.abs(this.aFU - motionEvent.getY()) > 20.0f)) {
                this.jJe.kO(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.jJe != null) {
                this.jJe.kO(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
            if (a(this.aFT, this.aFU, motionEvent.getX(), motionEvent.getY(), this.jJf, System.currentTimeMillis(), 500L)) {
                return true;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static c cwN() {
        if (jJg == null) {
            jJg = new c();
        }
        return jJg;
    }

    private com.baidu.tbadk.widget.richText.c b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.jJe;
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

    static boolean a(float f, float f2, float f3, float f4, long j, long j2, long j3) {
        return Math.abs(f3 - f) <= 100.0f && Math.abs(f4 - f2) <= 100.0f && j2 - j >= j3;
    }
}
