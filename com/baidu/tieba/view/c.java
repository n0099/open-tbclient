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
    private static c nMU;
    private int cHF;
    private int cHG;
    private int color = -1;
    private com.baidu.tbadk.widget.richText.f nMS;
    private long nMT;

    public void setColor(int i) {
        this.color = i;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        com.baidu.tbadk.widget.richText.f b2 = b(textView, spannable, motionEvent);
        if (b2 == null && motionEvent.getAction() == 0) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        if (b2 != null) {
            this.nMS = b2;
        }
        if (this.color > -1) {
            this.nMS.setColor(this.color);
        }
        if (motionEvent.getAction() == 0) {
            this.cHF = (int) motionEvent.getX();
            this.cHG = (int) motionEvent.getY();
            this.nMT = System.currentTimeMillis();
            if (this.nMS != null) {
                this.nMS.sh(1);
                Selection.setSelection(spannable, spannable.getSpanStart(this.nMS), spannable.getSpanEnd(this.nMS));
            }
            textView.invalidate();
        } else if (motionEvent.getAction() == 2) {
            if (this.nMS != null && (Math.abs(this.cHF - motionEvent.getX()) > 20.0f || Math.abs(this.cHG - motionEvent.getY()) > 20.0f)) {
                this.nMS.sh(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.nMS != null) {
                this.nMS.sh(2);
                textView.invalidate();
                Selection.removeSelection(spannable);
            }
            if (a(this.cHF, this.cHG, motionEvent.getX(), motionEvent.getY(), this.nMT, System.currentTimeMillis(), 500L)) {
                return true;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    public static c dTE() {
        if (nMU == null) {
            nMU = new c();
        }
        return nMU;
    }

    private com.baidu.tbadk.widget.richText.f b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 3) {
            return this.nMS;
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
            return this.nMS;
        }
    }

    static boolean a(float f, float f2, float f3, float f4, long j, long j2, long j3) {
        return Math.abs(f3 - f) <= 100.0f && Math.abs(f4 - f2) <= 100.0f && j2 - j >= j3;
    }
}
