package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c extends LinkMovementMethod {
    private static c lMB;
    private int color = -1;
    private long lMA;
    private com.baidu.tbadk.widget.richText.f lMz;
    private int mX;
    private int mY;

    public void setColor(int i) {
        this.color = i;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.f b = b(textView, spannable, motionEvent);
        if (b == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (b != null) {
            this.lMz = b;
        }
        if (this.color > -1) {
            this.lMz.setColor(this.color);
        }
        if (motionEvent.getAction() == 0) {
            this.mX = (int) motionEvent.getX();
            this.mY = (int) motionEvent.getY();
            this.lMA = System.currentTimeMillis();
            if (this.lMz != null) {
                this.lMz.oo(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.lMz), spannable.getSpanEnd(this.lMz));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.lMz != null && (Math.abs(this.mX - motionEvent.getX()) > 20.0f || Math.abs(this.mY - motionEvent.getY()) > 20.0f)) {
                this.lMz.oo(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.lMz != null) {
                this.lMz.oo(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
            if (a(this.mX, this.mY, motionEvent.getX(), motionEvent.getY(), this.lMA, System.currentTimeMillis(), 500L)) {
                return true;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static c dlQ() {
        if (lMB == null) {
            lMB = new c();
        }
        return lMB;
    }

    private com.baidu.tbadk.widget.richText.f b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.lMz;
        }
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        int scrollY = y + textView.getScrollY();
        try {
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            com.baidu.tbadk.widget.richText.f[] fVarArr = (com.baidu.tbadk.widget.richText.f[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.f.class);
            if (fVarArr == null || fVarArr.length <= 0 || fVarArr[0] == null) {
                return null;
            }
            return fVarArr[0];
        } catch (Exception e) {
            BdLog.e(e);
            return this.lMz;
        }
    }

    static boolean a(float f, float f2, float f3, float f4, long j, long j2, long j3) {
        return Math.abs(f3 - f) <= 100.0f && Math.abs(f4 - f2) <= 100.0f && j2 - j >= j3;
    }
}
