package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class c extends LinkMovementMethod {
    private static c jAu;
    private int alR;
    private int alS;
    private int color = -1;
    private com.baidu.tbadk.widget.richText.c jAs;
    private long jAt;

    public void setColor(int i) {
        this.color = i;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.c a = a(textView, spannable, motionEvent);
        if (a == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (a != null) {
            this.jAs = a;
        }
        if (this.color > -1) {
            this.jAs.setColor(this.color);
        }
        if (motionEvent.getAction() == 0) {
            this.alR = (int) motionEvent.getX();
            this.alS = (int) motionEvent.getY();
            this.jAt = System.currentTimeMillis();
            if (this.jAs != null) {
                this.jAs.lz(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.jAs), spannable.getSpanEnd(this.jAs));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.jAs != null && (Math.abs(this.alR - motionEvent.getX()) > 20.0f || Math.abs(this.alS - motionEvent.getY()) > 20.0f)) {
                this.jAs.lz(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.jAs != null) {
                this.jAs.lz(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
            if (a(this.alR, this.alS, motionEvent.getX(), motionEvent.getY(), this.jAt, System.currentTimeMillis(), 500L)) {
                return true;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static c cvd() {
        if (jAu == null) {
            jAu = new c();
        }
        return jAu;
    }

    private com.baidu.tbadk.widget.richText.c a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.jAs;
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
