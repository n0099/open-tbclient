package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23523a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f23524b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23525c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23526d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23527e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f23528f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23529g;

    /* renamed from: h  reason: collision with root package name */
    public int f23530h;

    /* renamed from: i  reason: collision with root package name */
    public String f23531i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        this.f23525c = true;
        this.f23526d = false;
        this.f23527e = false;
        this.f23530h = 0;
        this.k = context;
        this.f23524b = i2;
        this.f23528f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f23529g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f23530h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f23530h);
            this.f23530h = 0;
            this.f23529g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.f23531i;
    }

    public int getItemId() {
        return this.f23524b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f23528f;
    }

    public boolean isChecked() {
        return this.f23526d;
    }

    public boolean isEnabled() {
        return this.f23525c;
    }

    public void setChecked(boolean z) {
        this.f23526d = z;
    }

    public void setEnabled(boolean z) {
        this.f23525c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f23530h = 0;
        this.f23529g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f23530h = 0;
        this.f23531i = str;
        return this;
    }

    public void setMenu(BdMenu bdMenu) {
        this.l = bdMenu;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.j = onItemClickListener;
    }

    public void setShowTip(boolean z) {
        this.f23527e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f23528f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f23527e;
    }

    public BdMenuItem setTitle(int i2) {
        this.f23528f = this.k.getResources().getText(i2, this.f23528f);
        return this;
    }

    public BdMenuItem setIcon(int i2) {
        this.f23529g = null;
        this.f23530h = i2;
        return this;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        this.f23525c = true;
        this.f23526d = false;
        this.f23527e = false;
        this.f23530h = 0;
        this.k = context;
        this.f23524b = i2;
        this.f23528f = charSequence;
        this.f23530h = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f23525c = true;
        this.f23526d = false;
        this.f23527e = false;
        this.f23530h = 0;
        this.k = context;
        this.f23524b = i2;
        this.f23528f = charSequence;
        this.f23529g = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        this.f23525c = true;
        this.f23526d = false;
        this.f23527e = false;
        this.f23530h = 0;
        this.k = context;
        this.f23524b = i2;
        this.f23528f = charSequence;
        this.f23531i = str;
    }
}
