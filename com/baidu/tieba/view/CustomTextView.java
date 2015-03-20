package com.baidu.tieba.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        setLongClickable(false);
        super.onTouchEvent(motionEvent);
        return motionEvent.getAction() == 0 && hasSelection();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException e) {
            A(i, i2);
        }
    }

    private void A(int i, int i2) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            a(new SpannableStringBuilder(text), i, i2);
        } else {
            B(i, i2);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        d c = c(spannableStringBuilder, i, i2);
        if (c.arW) {
            a(i, i2, spannableStringBuilder, c);
        } else {
            B(i, i2);
        }
    }

    private d c(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
        ArrayList arrayList = new ArrayList(spans.length);
        ArrayList arrayList2 = new ArrayList(spans.length);
        for (Object obj : spans) {
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            if (b(spannableStringBuilder, spanStart - 1)) {
                spannableStringBuilder.insert(spanStart, " ");
                arrayList.add(obj);
            }
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            if (b(spannableStringBuilder, spanEnd)) {
                spannableStringBuilder.insert(spanEnd, " ");
                arrayList2.add(obj);
            }
            try {
                c((CharSequence) spannableStringBuilder, i, i2);
                return d.e(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e) {
                BdLog.e(e.getMessage());
            }
        }
        return d.apu();
    }

    private boolean b(CharSequence charSequence, int i) {
        return i < 0 || charSequence.charAt(i) != ' ';
    }

    private void c(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        measure(i, i2);
    }

    private void a(int i, int i2, SpannableStringBuilder spannableStringBuilder, d dVar) {
        for (Object obj : dVar.arY) {
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            spannableStringBuilder.delete(spanEnd, spanEnd + 1);
            try {
                c((CharSequence) spannableStringBuilder, i, i2);
            } catch (IndexOutOfBoundsException e) {
                spannableStringBuilder.insert(spanEnd, " ");
            }
        }
        boolean z = true;
        for (Object obj2 : dVar.arX) {
            int spanStart = spannableStringBuilder.getSpanStart(obj2);
            spannableStringBuilder.delete(spanStart - 1, spanStart);
            try {
                c((CharSequence) spannableStringBuilder, i, i2);
                z = false;
            } catch (IndexOutOfBoundsException e2) {
                spannableStringBuilder.insert(spanStart - 1, " ");
                z = true;
            }
        }
        if (z) {
            setText(spannableStringBuilder);
            measure(i, i2);
        }
    }

    private void B(int i, int i2) {
        c(getText().toString(), i, i2);
    }
}
