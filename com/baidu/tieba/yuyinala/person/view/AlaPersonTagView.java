package com.baidu.tieba.yuyinala.person.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaPersonTagView extends TextView {
    public AlaPersonTagView(Context context) {
        this(context, null);
    }

    public AlaPersonTagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaPersonTagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        setCompoundDrawablePadding(context.getResources().getDimensionPixelSize(a.d.sdk_ds4));
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(17);
        setSingleLine();
        setIncludeFontPadding(false);
        setPadding(context.getResources().getDimensionPixelSize(a.d.sdk_ds14), 0, context.getResources().getDimensionPixelSize(a.d.sdk_ds14), 0);
        setTextSize(12.0f);
    }

    public void setAddTagView() {
        setBackgroundResource(a.e.bg_ala_person_add_tag);
        setTextColor(getResources().getColor(a.c.sdk_common_color_10106));
        setCompoundDrawablesWithIntrinsicBounds(a.e.icon_add_tag, 0, 0, 0);
        setText(a.h.ala_person_add_tag);
    }

    public void setTagView(String str, int i) {
        setBackgroundResource(i);
        setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        setText(str);
    }
}
