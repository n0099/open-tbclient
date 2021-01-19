package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes10.dex */
public class a {
    private Drawable icon;
    private int oVJ;
    private boolean oVK;
    private String title;
    private int titleColor;

    public a(int i, String str, Drawable drawable) {
        this.titleColor = -1;
        this.oVJ = -1;
        this.title = str;
        this.icon = drawable;
        this.oVJ = i;
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

    public int ejp() {
        return this.oVJ;
    }

    public boolean isSticky() {
        return this.oVK;
    }
}
