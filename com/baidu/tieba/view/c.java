package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes.dex */
public class c extends LinkMovementMethod {
    private static c jhz;
    private int alF;
    private int alG;
    private int color = -1;
    private com.baidu.tbadk.widget.richText.c jhx;
    private long jhy;

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
            this.jhx = a;
        }
        if (this.color > -1) {
            this.jhx.setColor(this.color);
        }
        if (motionEvent.getAction() == 0) {
            this.alF = (int) motionEvent.getX();
            this.alG = (int) motionEvent.getY();
            this.jhy = System.currentTimeMillis();
            if (this.jhx != null) {
                this.jhx.kK(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.jhx), spannable.getSpanEnd(this.jhx));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.jhx != null && (Math.abs(this.alF - motionEvent.getX()) > 20.0f || Math.abs(this.alG - motionEvent.getY()) > 20.0f)) {
                this.jhx.kK(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.jhx != null) {
                this.jhx.kK(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
            if (a(this.alF, this.alG, motionEvent.getX(), motionEvent.getY(), this.jhy, System.currentTimeMillis(), 500L)) {
                return true;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static c cmY() {
        if (jhz == null) {
            jhz = new c();
        }
        return jhz;
    }

    private com.baidu.tbadk.widget.richText.c a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.jhx;
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
