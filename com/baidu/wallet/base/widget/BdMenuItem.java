package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23441a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f23442b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23443c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23444d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23445e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f23446f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23447g;

    /* renamed from: h  reason: collision with root package name */
    public int f23448h;

    /* renamed from: i  reason: collision with root package name */
    public String f23449i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        this.f23443c = true;
        this.f23444d = false;
        this.f23445e = false;
        this.f23448h = 0;
        this.k = context;
        this.f23442b = i2;
        this.f23446f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f23447g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f23448h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f23448h);
            this.f23448h = 0;
            this.f23447g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.f23449i;
    }

    public int getItemId() {
        return this.f23442b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f23446f;
    }

    public boolean isChecked() {
        return this.f23444d;
    }

    public boolean isEnabled() {
        return this.f23443c;
    }

    public void setChecked(boolean z) {
        this.f23444d = z;
    }

    public void setEnabled(boolean z) {
        this.f23443c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f23448h = 0;
        this.f23447g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f23448h = 0;
        this.f23449i = str;
        return this;
    }

    public void setMenu(BdMenu bdMenu) {
        this.l = bdMenu;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.j = onItemClickListener;
    }

    public void setShowTip(boolean z) {
        this.f23445e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f23446f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f23445e;
    }

    public BdMenuItem setTitle(int i2) {
        this.f23446f = this.k.getResources().getText(i2, this.f23446f);
        return this;
    }

    public BdMenuItem setIcon(int i2) {
        this.f23447g = null;
        this.f23448h = i2;
        return this;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        this.f23443c = true;
        this.f23444d = false;
        this.f23445e = false;
        this.f23448h = 0;
        this.k = context;
        this.f23442b = i2;
        this.f23446f = charSequence;
        this.f23448h = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f23443c = true;
        this.f23444d = false;
        this.f23445e = false;
        this.f23448h = 0;
        this.k = context;
        this.f23442b = i2;
        this.f23446f = charSequence;
        this.f23447g = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        this.f23443c = true;
        this.f23444d = false;
        this.f23445e = false;
        this.f23448h = 0;
        this.k = context;
        this.f23442b = i2;
        this.f23446f = charSequence;
        this.f23449i = str;
    }
}
