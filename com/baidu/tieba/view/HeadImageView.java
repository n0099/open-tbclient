package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class HeadImageView extends ImageView {
    private String a;
    private String b;

    public HeadImageView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
    }

    public void setUserId(String str) {
        this.a = str;
    }

    public String getUserId() {
        return this.a;
    }

    public void setUserName(String str) {
        this.b = str;
    }

    public String getUserName() {
        return this.b;
    }
}
