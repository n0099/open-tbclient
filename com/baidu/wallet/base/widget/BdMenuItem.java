package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23745a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f23746b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23747c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23748d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23749e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f23750f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23751g;

    /* renamed from: h  reason: collision with root package name */
    public int f23752h;
    public String i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence) {
        this.f23747c = true;
        this.f23748d = false;
        this.f23749e = false;
        this.f23752h = 0;
        this.k = context;
        this.f23746b = i;
        this.f23750f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f23751g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f23752h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f23752h);
            this.f23752h = 0;
            this.f23751g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.i;
    }

    public int getItemId() {
        return this.f23746b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f23750f;
    }

    public boolean isChecked() {
        return this.f23748d;
    }

    public boolean isEnabled() {
        return this.f23747c;
    }

    public void setChecked(boolean z) {
        this.f23748d = z;
    }

    public void setEnabled(boolean z) {
        this.f23747c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f23752h = 0;
        this.f23751g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f23752h = 0;
        this.i = str;
        return this;
    }

    public void setMenu(BdMenu bdMenu) {
        this.l = bdMenu;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.j = onItemClickListener;
    }

    public void setShowTip(boolean z) {
        this.f23749e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f23750f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f23749e;
    }

    public BdMenuItem setTitle(int i) {
        this.f23750f = this.k.getResources().getText(i, this.f23750f);
        return this;
    }

    public BdMenuItem setIcon(int i) {
        this.f23751g = null;
        this.f23752h = i;
        return this;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, int i2) {
        this.f23747c = true;
        this.f23748d = false;
        this.f23749e = false;
        this.f23752h = 0;
        this.k = context;
        this.f23746b = i;
        this.f23750f = charSequence;
        this.f23752h = i2;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, Drawable drawable) {
        this.f23747c = true;
        this.f23748d = false;
        this.f23749e = false;
        this.f23752h = 0;
        this.k = context;
        this.f23746b = i;
        this.f23750f = charSequence;
        this.f23751g = drawable;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, String str) {
        this.f23747c = true;
        this.f23748d = false;
        this.f23749e = false;
        this.f23752h = 0;
        this.k = context;
        this.f23746b = i;
        this.f23750f = charSequence;
        this.i = str;
    }
}
