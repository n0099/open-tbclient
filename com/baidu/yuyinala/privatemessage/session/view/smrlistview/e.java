package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes11.dex */
public class e {
    private Drawable icon;
    private Context mContext;
    private Drawable mJi;
    private int pfM;
    private String title;
    private int titleColor;
    private int width;

    public e(Context context) {
        this.mContext = context;
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public int getTitleSize() {
        return this.pfM;
    }

    public void setTitleSize(int i) {
        this.pfM = i;
    }

    public void setTitleColor(int i) {
        this.titleColor = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public Drawable getBackground() {
        return this.mJi;
    }

    public void setBackground(Drawable drawable) {
        this.mJi = drawable;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
