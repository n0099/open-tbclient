package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes11.dex */
public class a {
    private Drawable icon;
    private int pfW;
    private boolean pfX;
    private String title;
    private int titleColor;

    public a(int i, String str, Drawable drawable) {
        this.titleColor = -1;
        this.pfW = -1;
        this.title = str;
        this.icon = drawable;
        this.pfW = i;
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

    public int elJ() {
        return this.pfW;
    }

    public boolean isSticky() {
        return this.pfX;
    }
}
