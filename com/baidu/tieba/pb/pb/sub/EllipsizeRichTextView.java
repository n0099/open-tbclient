package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes5.dex */
public class EllipsizeRichTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f19875e;

    public EllipsizeRichTextView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f19875e = new SpannableStringBuilder();
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getText() == null || getLayout() == null) {
            return;
        }
        CharSequence text = getText();
        int lineCount = getLineCount();
        if (lineCount > 2) {
            lineCount = 2;
        }
        int lineVisibleEnd = getLayout().getLineVisibleEnd(lineCount - 1);
        if (text == null || text.length() <= lineVisibleEnd) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = this.f19875e;
        if (spannableStringBuilder == null) {
            a();
        } else {
            spannableStringBuilder.clear();
        }
        SpannableStringBuilder spannableStringBuilder2 = this.f19875e;
        if (spannableStringBuilder2 != null) {
            spannableStringBuilder2.append(text.subSequence(0, lineVisibleEnd));
            setText(this.f19875e);
        }
    }

    public EllipsizeRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public EllipsizeRichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
