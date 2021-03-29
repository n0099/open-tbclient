package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23746a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f23747b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23748c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23749d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23750e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f23751f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23752g;

    /* renamed from: h  reason: collision with root package name */
    public int f23753h;
    public String i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence) {
        this.f23748c = true;
        this.f23749d = false;
        this.f23750e = false;
        this.f23753h = 0;
        this.k = context;
        this.f23747b = i;
        this.f23751f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f23752g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f23753h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f23753h);
            this.f23753h = 0;
            this.f23752g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.i;
    }

    public int getItemId() {
        return this.f23747b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f23751f;
    }

    public boolean isChecked() {
        return this.f23749d;
    }

    public boolean isEnabled() {
        return this.f23748c;
    }

    public void setChecked(boolean z) {
        this.f23749d = z;
    }

    public void setEnabled(boolean z) {
        this.f23748c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f23753h = 0;
        this.f23752g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f23753h = 0;
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
        this.f23750e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f23751f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f23750e;
    }

    public BdMenuItem setTitle(int i) {
        this.f23751f = this.k.getResources().getText(i, this.f23751f);
        return this;
    }

    public BdMenuItem setIcon(int i) {
        this.f23752g = null;
        this.f23753h = i;
        return this;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, int i2) {
        this.f23748c = true;
        this.f23749d = false;
        this.f23750e = false;
        this.f23753h = 0;
        this.k = context;
        this.f23747b = i;
        this.f23751f = charSequence;
        this.f23753h = i2;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, Drawable drawable) {
        this.f23748c = true;
        this.f23749d = false;
        this.f23750e = false;
        this.f23753h = 0;
        this.k = context;
        this.f23747b = i;
        this.f23751f = charSequence;
        this.f23752g = drawable;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, String str) {
        this.f23748c = true;
        this.f23749d = false;
        this.f23750e = false;
        this.f23753h = 0;
        this.k = context;
        this.f23747b = i;
        this.f23751f = charSequence;
        this.i = str;
    }
}
