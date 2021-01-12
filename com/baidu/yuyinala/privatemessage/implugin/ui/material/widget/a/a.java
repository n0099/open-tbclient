package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes10.dex */
public class a {
    private Drawable icon;
    private int oVI;
    private boolean oVJ;
    private String title;
    private int titleColor;

    public a(int i, String str, Drawable drawable) {
        this.titleColor = -1;
        this.oVI = -1;
        this.title = str;
        this.icon = drawable;
        this.oVI = i;
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
        return this.oVI;
    }

    public boolean isSticky() {
        return this.oVJ;
    }
}
