package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class HeadImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private String f1794a;
    private String b;

    public HeadImageView(Context context) {
        super(context);
        this.f1794a = null;
        this.b = null;
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1794a = null;
        this.b = null;
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1794a = null;
        this.b = null;
    }

    public void setUserId(String str) {
        this.f1794a = str;
    }

    public String getUserId() {
        return this.f1794a;
    }

    public void setUserName(String str) {
        this.b = str;
    }

    public String getUserName() {
        return this.b;
    }
}
