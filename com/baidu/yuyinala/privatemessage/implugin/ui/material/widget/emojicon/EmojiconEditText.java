package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public class EmojiconEditText extends EditText {
    private int oSR;

    public EmojiconEditText(Context context) {
        super(context);
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, context);
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, context);
    }

    private void a(AttributeSet attributeSet, Context context) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.Emojicon);
        this.oSR = (int) obtainStyledAttributes.getDimension(a.j.Emojicon_emojiconSize, getTextSize() + f.dip2px(context, 2.0f));
        try {
            Field declaredField = getClass().getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(a.e.bd_im_cursor_drawable));
        } catch (Exception e) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("EmojiconEditText", "exception " + e.getMessage());
        }
        obtainStyledAttributes.recycle();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(400)});
        setText(getText());
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        b.a(getContext(), getText(), this.oSR, i, i2, i3);
    }

    public void setEmojiconSize(int i) {
        this.oSR = i;
    }
}
