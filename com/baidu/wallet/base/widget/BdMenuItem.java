package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23409a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f23410b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23411c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23412d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23413e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f23414f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23415g;

    /* renamed from: h  reason: collision with root package name */
    public int f23416h;

    /* renamed from: i  reason: collision with root package name */
    public String f23417i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence) {
        this.f23411c = true;
        this.f23412d = false;
        this.f23413e = false;
        this.f23416h = 0;
        this.k = context;
        this.f23410b = i2;
        this.f23414f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f23415g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f23416h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f23416h);
            this.f23416h = 0;
            this.f23415g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.f23417i;
    }

    public int getItemId() {
        return this.f23410b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f23414f;
    }

    public boolean isChecked() {
        return this.f23412d;
    }

    public boolean isEnabled() {
        return this.f23411c;
    }

    public void setChecked(boolean z) {
        this.f23412d = z;
    }

    public void setEnabled(boolean z) {
        this.f23411c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f23416h = 0;
        this.f23415g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f23416h = 0;
        this.f23417i = str;
        return this;
    }

    public void setMenu(BdMenu bdMenu) {
        this.l = bdMenu;
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.j = onItemClickListener;
    }

    public void setShowTip(boolean z) {
        this.f23413e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f23414f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f23413e;
    }

    public BdMenuItem setTitle(int i2) {
        this.f23414f = this.k.getResources().getText(i2, this.f23414f);
        return this;
    }

    public BdMenuItem setIcon(int i2) {
        this.f23415g = null;
        this.f23416h = i2;
        return this;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, int i3) {
        this.f23411c = true;
        this.f23412d = false;
        this.f23413e = false;
        this.f23416h = 0;
        this.k = context;
        this.f23410b = i2;
        this.f23414f = charSequence;
        this.f23416h = i3;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, Drawable drawable) {
        this.f23411c = true;
        this.f23412d = false;
        this.f23413e = false;
        this.f23416h = 0;
        this.k = context;
        this.f23410b = i2;
        this.f23414f = charSequence;
        this.f23415g = drawable;
    }

    public BdMenuItem(Context context, int i2, CharSequence charSequence, String str) {
        this.f23411c = true;
        this.f23412d = false;
        this.f23413e = false;
        this.f23416h = 0;
        this.k = context;
        this.f23410b = i2;
        this.f23414f = charSequence;
        this.f23417i = str;
    }
}
