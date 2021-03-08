package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
/* loaded from: classes10.dex */
public class EmojiconTextView extends TextView {
    private int phn;

    public EmojiconTextView(Context context) {
        super(context);
        a(null, context);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, context);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, context);
    }

    private void a(AttributeSet attributeSet, Context context) {
        if (attributeSet == null) {
            this.phn = (int) (getTextSize() + f.dip2px(context, 2.0f));
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.Emojicon);
            this.phn = (int) obtainStyledAttributes.getDimension(a.j.Emojicon_emojiconSize, getTextSize() + f.dip2px(context, 2.0f));
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence == null || TextUtils.isEmpty(charSequence.toString())) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconTextView", "EmojiconTextView> setText is null");
            super.setText(charSequence, bufferType);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        b.a(getContext(), spannableStringBuilder, this.phn);
        super.setText(spannableStringBuilder, bufferType);
    }

    public void setEmojiconSize(int i) {
        this.phn = i;
    }
}
