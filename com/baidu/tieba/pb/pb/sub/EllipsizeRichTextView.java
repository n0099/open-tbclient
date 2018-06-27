package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class EllipsizeRichTextView extends TextView {
    private SpannableStringBuilder fKa;

    public EllipsizeRichTextView(Context context) {
        super(context);
        bgW();
    }

    public EllipsizeRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bgW();
    }

    public EllipsizeRichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bgW();
    }

    private void bgW() {
        this.fKa = new SpannableStringBuilder();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getText() != null && getLayout() != null) {
            CharSequence text = getText();
            int lineCount = getLineCount();
            int lineVisibleEnd = getLayout().getLineVisibleEnd((lineCount <= 2 ? lineCount : 2) - 1);
            if (text != null && text.length() > lineVisibleEnd) {
                if (this.fKa == null) {
                    bgW();
                } else {
                    this.fKa.clear();
                }
                if (this.fKa != null) {
                    this.fKa.append(text.subSequence(0, lineVisibleEnd));
                    setText(this.fKa);
                }
            }
        }
    }
}
