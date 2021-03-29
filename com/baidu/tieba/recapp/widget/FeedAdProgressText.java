package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i0.r2.e0.a;
/* loaded from: classes5.dex */
public class FeedAdProgressText extends AppCompatTextView implements a {

    /* renamed from: e  reason: collision with root package name */
    public int f20907e;

    /* renamed from: f  reason: collision with root package name */
    public int f20908f;

    public FeedAdProgressText(Context context) {
        super(context);
        this.f20907e = 100;
        this.f20908f = 0;
        f(context);
    }

    @Override // d.b.i0.r2.e0.a
    public void a() {
        setTextColor(SkinManager.getColor(R.color.CAM_X0109));
    }

    @Override // d.b.i0.r2.e0.a
    public void d() {
        setTextColor(SkinManager.getColor(R.color.CAM_X0109));
    }

    public final void f(Context context) {
        setIncludeFontPadding(false);
    }

    public int getMax() {
        return this.f20907e;
    }

    public int getProgress() {
        return this.f20908f;
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonText(String str) {
        setText(str);
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonTextColor(int i) {
        setTextColor(i);
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonTextNightColor(int i) {
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonTextSize(int i) {
        setTextSize(1, i);
    }

    public void setMax(int i) {
        this.f20907e = i;
    }

    @Override // d.b.i0.r2.e0.a
    public void setProgress(int i) {
        if (i > this.f20907e) {
            return;
        }
        this.f20908f = i;
        setText("已下载" + i + "%");
    }

    @Override // d.b.i0.r2.e0.a
    public void setButtonText(String str, int i) {
        this.f20908f = i;
        setText(str);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20907e = 100;
        this.f20908f = 0;
        f(context);
    }

    public FeedAdProgressText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20907e = 100;
        this.f20908f = 0;
        f(context);
    }
}
