package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes6.dex */
public class EllipsizeRichTextView extends TextView {
    private SpannableStringBuilder glv;

    public EllipsizeRichTextView(Context context) {
        super(context);
        bnI();
    }

    public EllipsizeRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bnI();
    }

    public EllipsizeRichTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bnI();
    }

    private void bnI() {
        this.glv = new SpannableStringBuilder();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getText() != null && getLayout() != null) {
            CharSequence text = getText();
            int lineCount = getLineCount();
            int lineVisibleEnd = getLayout().getLineVisibleEnd((lineCount <= 2 ? lineCount : 2) - 1);
            if (text != null && text.length() > lineVisibleEnd) {
                if (this.glv == null) {
                    bnI();
                } else {
                    this.glv.clear();
                }
                if (this.glv != null) {
                    this.glv.append(text.subSequence(0, lineVisibleEnd));
                    setText(this.glv);
                }
            }
        }
    }
}
