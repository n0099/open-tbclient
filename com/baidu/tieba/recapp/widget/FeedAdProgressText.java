package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.k0.s2.k0.a;
/* loaded from: classes5.dex */
public class FeedAdProgressText extends AppCompatTextView implements a {

    /* renamed from: e  reason: collision with root package name */
    public int f20397e;

    /* renamed from: f  reason: collision with root package name */
    public int f20398f;

    public FeedAdProgressText(Context context) {
        super(context);
        this.f20397e = 100;
        this.f20398f = 0;
        f(context);
    }

    @Override // d.a.k0.s2.k0.a
    public void a() {
        setTextColor(SkinManager.getColor(R.color.CAM_X0109));
    }

    @Override // d.a.k0.s2.k0.a
    public void d() {
        setTextColor(SkinManager.getColor(R.color.CAM_X0109));
    }

    public final void f(Context context) {
        setIncludeFontPadding(false);
    }

    public int getMax() {
        return this.f20397e;
    }

    public int getProgress() {
        return this.f20398f;
    }

    @Override // d.a.k0.s2.k0.a
    public void setButtonText(String str) {
        setText(str);
    }

    @Override // d.a.k0.s2.k0.a
    public void setButtonTextColor(int i2) {
        setTextColor(i2);
    }

    @Override // d.a.k0.s2.k0.a
    public void setButtonTextNightColor(int i2) {
    }

    @Override // d.a.k0.s2.k0.a
    public void setButtonTextSize(int i2) {
        setTextSize(1, i2);
    }

    public void setMax(int i2) {
        this.f20397e = i2;
    }

    @Override // d.a.k0.s2.k0.a
    public void setProgress(int i2) {
        if (i2 > this.f20397e) {
            return;
        }
        this.f20398f = i2;
        setText("已下载" + i2 + "%");
    }

    @Override // d.a.k0.s2.k0.a
    public void setButtonText(String str, int i2) {
        this.f20398f = i2;
        setText(str);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20397e = 100;
        this.f20398f = 0;
        f(context);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20397e = 100;
        this.f20398f = 0;
        f(context);
    }
}
