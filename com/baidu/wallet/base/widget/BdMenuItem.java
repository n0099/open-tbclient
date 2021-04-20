package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* loaded from: classes5.dex */
public class BdMenuItem {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23431a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final int f23432b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23433c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23434d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23435e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f23436f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f23437g;

    /* renamed from: h  reason: collision with root package name */
    public int f23438h;
    public String i;
    public OnItemClickListener j;
    public Context k;
    public BdMenu l;

    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onClick(BdMenuItem bdMenuItem);
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence) {
        this.f23433c = true;
        this.f23434d = false;
        this.f23435e = false;
        this.f23438h = 0;
        this.k = context;
        this.f23432b = i;
        this.f23436f = charSequence;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f23437g;
        if (drawable != null) {
            return drawable;
        }
        if (this.f23438h != 0) {
            Drawable drawable2 = this.k.getResources().getDrawable(this.f23438h);
            this.f23438h = 0;
            this.f23437g = drawable2;
            return drawable2;
        }
        return null;
    }

    public String getIconUrl() {
        return this.i;
    }

    public int getItemId() {
        return this.f23432b;
    }

    public BdMenu getMenu() {
        return this.l;
    }

    public OnItemClickListener getOnClickListener() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.f23436f;
    }

    public boolean isChecked() {
        return this.f23434d;
    }

    public boolean isEnabled() {
        return this.f23433c;
    }

    public void setChecked(boolean z) {
        this.f23434d = z;
    }

    public void setEnabled(boolean z) {
        this.f23433c = z;
    }

    public BdMenuItem setIcon(Drawable drawable) {
        this.f23438h = 0;
        this.f23437g = drawable;
        return this;
    }

    public BdMenuItem setIconUrl(String str) {
        this.f23438h = 0;
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
        this.f23435e = z;
    }

    public BdMenuItem setTitle(CharSequence charSequence) {
        this.f23436f = charSequence;
        return this;
    }

    public boolean showTip() {
        return this.f23435e;
    }

    public BdMenuItem setTitle(int i) {
        this.f23436f = this.k.getResources().getText(i, this.f23436f);
        return this;
    }

    public BdMenuItem setIcon(int i) {
        this.f23437g = null;
        this.f23438h = i;
        return this;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, int i2) {
        this.f23433c = true;
        this.f23434d = false;
        this.f23435e = false;
        this.f23438h = 0;
        this.k = context;
        this.f23432b = i;
        this.f23436f = charSequence;
        this.f23438h = i2;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, Drawable drawable) {
        this.f23433c = true;
        this.f23434d = false;
        this.f23435e = false;
        this.f23438h = 0;
        this.k = context;
        this.f23432b = i;
        this.f23436f = charSequence;
        this.f23437g = drawable;
    }

    public BdMenuItem(Context context, int i, CharSequence charSequence, String str) {
        this.f23433c = true;
        this.f23434d = false;
        this.f23435e = false;
        this.f23438h = 0;
        this.k = context;
        this.f23432b = i;
        this.f23436f = charSequence;
        this.i = str;
    }
}
