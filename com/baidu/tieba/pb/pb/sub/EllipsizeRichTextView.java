package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class EllipsizeRichTextView extends TextView {
    private SpannableStringBuilder hTj;

    public EllipsizeRichTextView(Context context) {
        super(context);
        bVX();
    }

    public EllipsizeRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bVX();
    }

    public EllipsizeRichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bVX();
    }

    private void bVX() {
        this.hTj = new SpannableStringBuilder();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getText() != null && getLayout() != null) {
            CharSequence text = getText();
            int lineCount = getLineCount();
            int lineVisibleEnd = getLayout().getLineVisibleEnd((lineCount <= 2 ? lineCount : 2) - 1);
            if (text != null && text.length() > lineVisibleEnd) {
                if (this.hTj == null) {
                    bVX();
                } else {
                    this.hTj.clear();
                }
                if (this.hTj != null) {
                    this.hTj.append(text.subSequence(0, lineVisibleEnd));
                    setText(this.hTj);
                }
            }
        }
    }
}
