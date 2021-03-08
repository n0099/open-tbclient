package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes10.dex */
public class MarqueeTextView extends TextView {
    private int jDJ;
    private String mText;

    public MarqueeTextView(Context context) {
        super(context);
        this.jDJ = 217;
        this.mText = "";
        init();
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jDJ = 217;
        this.mText = "";
        init();
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDJ = 217;
        this.mText = "";
        init();
    }

    private void init() {
        setSingleLine();
        setFocusable(true);
        setMarqueeRepeatLimit(-1);
    }

    public void setTextViewWidth(int i) {
        this.jDJ = i;
    }

    public void setScrollText(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mText) || !str.equals(this.mText)) {
            this.mText = str;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            TextPaint paint = getPaint();
            float measureText = paint.measureText(str);
            float measureText2 = paint.measureText("m");
            float dip2px = BdUtilHelper.dip2px(getContext(), this.jDJ) - measureText;
            if (dip2px >= 0.0f) {
                int ceil = (int) Math.ceil(dip2px / measureText2);
                if (ceil == 0 || dip2px % measureText2 == 0.0f) {
                    ceil++;
                }
                for (int i = 0; i < ceil; i++) {
                    spannableStringBuilder.append((CharSequence) "m");
                }
                spannableStringBuilder.setSpan(new ForegroundColorSpan(0), str.length(), ceil + str.length(), 33);
            }
            setText(spannableStringBuilder);
        }
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }
}
