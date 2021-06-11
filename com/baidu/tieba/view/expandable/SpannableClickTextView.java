package com.baidu.tieba.view.expandable;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class SpannableClickTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f21869e;

    /* loaded from: classes5.dex */
    public static class a extends LinkMovementMethod {

        /* renamed from: a  reason: collision with root package name */
        public static a f21870a;

        public static a a() {
            if (f21870a == null) {
                f21870a = new a();
            }
            return f21870a;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 1 && action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (objArr.length != 0) {
                if (action == 1) {
                    objArr[0].onClick(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                }
                if (textView instanceof SpannableClickTextView) {
                    ((SpannableClickTextView) textView).f21869e = true;
                }
                return true;
            }
            Selection.removeSelection(spannable);
            super.onTouchEvent(textView, spannable, motionEvent);
            return false;
        }
    }

    public SpannableClickTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f21869e = false;
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f21869e) {
            return true;
        }
        return super.performClick();
    }

    public void setCustomMovementMethod() {
        setMovementMethod(a.a());
    }

    public SpannableClickTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SpannableClickTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
