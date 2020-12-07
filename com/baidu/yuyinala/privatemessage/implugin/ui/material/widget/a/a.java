package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
public class a {
    private Drawable icon;
    private int oUd;
    private boolean oUe;
    private String title;
    private int titleColor;

    public a(int i, String str, Drawable drawable) {
        this.titleColor = -1;
        this.oUd = -1;
        this.title = str;
        this.icon = drawable;
        this.oUd = i;
    }

    public a() {
        this(-1, null, null);
    }

    public a(int i, String str) {
        this(i, str, null);
    }

    public String getTitle() {
        return this.title;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int eng() {
        return this.oUd;
    }

    public boolean isSticky() {
        return this.oUe;
    }
}
