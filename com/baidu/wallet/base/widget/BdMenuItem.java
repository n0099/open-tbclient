package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23338a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f23339b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23340c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23341d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23342e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f23343f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23344g;

    /* renamed from: h  reason: collision with root package name */
    public int f23345h;

    /* renamed from: i  reason: collision with root package name */
    public String f23346i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        this.f23340c = true;
        this.f23341d = false;
        this.f23342e = false;
        this.f23345h = 0;
        this.k = context;
        this.f23339b = i2;
        this.f23343f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f23344g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f23345h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f23345h);
            this.f23345h = 0;
            this.f23344g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.f23346i;
    }

    public int getItemId() {
        return this.f23339b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f23343f;
    }

    public boolean isChecked() {
        return this.f23341d;
    }

    public boolean isEnabled() {
        return this.f23340c;
    }

    public void setChecked(boolean z) {
        this.f23341d = z;
    }

    public void setEnabled(boolean z) {
        this.f23340c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f23345h = 0;
        this.f23344g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f23345h = 0;
        this.f23346i = str;
        return this;
    }

    public void setMenu(BdMenu bdMenu) {
        this.l = bdMenu;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.j = onItemClickListener;
    }

    public void setShowTip(boolean z) {
        this.f23342e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f23343f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f23342e;
    }

    public BdMenuItem setTitle(int i2) {
        this.f23343f = this.k.getResources().getText(i2, this.f23343f);
        return this;
    }

    public BdMenuItem setIcon(int i2) {
        this.f23344g = null;
        this.f23345h = i2;
        return this;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        this.f23340c = true;
        this.f23341d = false;
        this.f23342e = false;
        this.f23345h = 0;
        this.k = context;
        this.f23339b = i2;
        this.f23343f = charSequence;
        this.f23345h = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f23340c = true;
        this.f23341d = false;
        this.f23342e = false;
        this.f23345h = 0;
        this.k = context;
        this.f23339b = i2;
        this.f23343f = charSequence;
        this.f23344g = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        this.f23340c = true;
        this.f23341d = false;
        this.f23342e = false;
        this.f23345h = 0;
        this.k = context;
        this.f23339b = i2;
        this.f23343f = charSequence;
        this.f23346i = str;
    }
}
