package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23439a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f23440b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23441c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23442d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23443e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f23444f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23445g;

    /* renamed from: h  reason: collision with root package name */
    public int f23446h;
    public String i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence) {
        this.f23441c = true;
        this.f23442d = false;
        this.f23443e = false;
        this.f23446h = 0;
        this.k = context;
        this.f23440b = i;
        this.f23444f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f23445g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f23446h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f23446h);
            this.f23446h = 0;
            this.f23445g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.i;
    }

    public int getItemId() {
        return this.f23440b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f23444f;
    }

    public boolean isChecked() {
        return this.f23442d;
    }

    public boolean isEnabled() {
        return this.f23441c;
    }

    public void setChecked(boolean z) {
        this.f23442d = z;
    }

    public void setEnabled(boolean z) {
        this.f23441c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f23446h = 0;
        this.f23445g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f23446h = 0;
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
        this.f23443e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f23444f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f23443e;
    }

    public BdMenuItem setTitle(int i) {
        this.f23444f = this.k.getResources().getText(i, this.f23444f);
        return this;
    }

    public BdMenuItem setIcon(int i) {
        this.f23445g = null;
        this.f23446h = i;
        return this;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, int i2) {
        this.f23441c = true;
        this.f23442d = false;
        this.f23443e = false;
        this.f23446h = 0;
        this.k = context;
        this.f23440b = i;
        this.f23444f = charSequence;
        this.f23446h = i2;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, Drawable drawable) {
        this.f23441c = true;
        this.f23442d = false;
        this.f23443e = false;
        this.f23446h = 0;
        this.k = context;
        this.f23440b = i;
        this.f23444f = charSequence;
        this.f23445g = drawable;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, String str) {
        this.f23441c = true;
        this.f23442d = false;
        this.f23443e = false;
        this.f23446h = 0;
        this.k = context;
        this.f23440b = i;
        this.f23444f = charSequence;
        this.i = str;
    }
}
