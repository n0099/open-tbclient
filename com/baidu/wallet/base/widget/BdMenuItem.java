package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f24164a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f24165b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24166c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24167d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24168e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f24169f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f24170g;

    /* renamed from: h  reason: collision with root package name */
    public int f24171h;

    /* renamed from: i  reason: collision with root package name */
    public String f24172i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        this.f24166c = true;
        this.f24167d = false;
        this.f24168e = false;
        this.f24171h = 0;
        this.k = context;
        this.f24165b = i2;
        this.f24169f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f24170g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f24171h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f24171h);
            this.f24171h = 0;
            this.f24170g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.f24172i;
    }

    public int getItemId() {
        return this.f24165b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f24169f;
    }

    public boolean isChecked() {
        return this.f24167d;
    }

    public boolean isEnabled() {
        return this.f24166c;
    }

    public void setChecked(boolean z) {
        this.f24167d = z;
    }

    public void setEnabled(boolean z) {
        this.f24166c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f24171h = 0;
        this.f24170g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f24171h = 0;
        this.f24172i = str;
        return this;
    }

    public void setMenu(BdMenu bdMenu) {
        this.l = bdMenu;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.j = onItemClickListener;
    }

    public void setShowTip(boolean z) {
        this.f24168e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f24169f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f24168e;
    }

    public BdMenuItem setTitle(int i2) {
        this.f24169f = this.k.getResources().getText(i2, this.f24169f);
        return this;
    }

    public BdMenuItem setIcon(int i2) {
        this.f24170g = null;
        this.f24171h = i2;
        return this;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        this.f24166c = true;
        this.f24167d = false;
        this.f24168e = false;
        this.f24171h = 0;
        this.k = context;
        this.f24165b = i2;
        this.f24169f = charSequence;
        this.f24171h = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f24166c = true;
        this.f24167d = false;
        this.f24168e = false;
        this.f24171h = 0;
        this.k = context;
        this.f24165b = i2;
        this.f24169f = charSequence;
        this.f24170g = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        this.f24166c = true;
        this.f24167d = false;
        this.f24168e = false;
        this.f24171h = 0;
        this.k = context;
        this.f24165b = i2;
        this.f24169f = charSequence;
        this.f24172i = str;
    }
}
