package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a;

import android.graphics.drawable.Drawable;
/* loaded from: classes11.dex */
public class a {
    private Drawable icon;
    private int pal;
    private boolean pam;
    private String title;
    private int titleColor;

    public a(int i, String str, Drawable drawable) {
        this.titleColor = -1;
        this.pal = -1;
        this.title = str;
        this.icon = drawable;
        this.pal = i;
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

    public int enj() {
        return this.pal;
    }

    public boolean isSticky() {
        return this.pam;
    }
}
