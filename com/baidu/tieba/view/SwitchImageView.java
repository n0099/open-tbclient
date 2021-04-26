package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
/* loaded from: classes5.dex */
public class SwitchImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f22564e;

    /* renamed from: f  reason: collision with root package name */
    public int f22565f;

    /* renamed from: g  reason: collision with root package name */
    public int f22566g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22567h;

    /* renamed from: i  reason: collision with root package name */
    public AbsSvgType f22568i;
    public AbsSvgType j;

    public SwitchImageView(Context context) {
        super(context);
        this.f22567h = false;
        a();
    }

    public final void a() {
        this.f22564e = 0;
        this.f22565f = 0;
        this.f22566g = 0;
    }

    public void b() {
        if (this.f22564e == 0) {
            this.f22564e = 1;
            setState(1);
            return;
        }
        this.f22564e = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.f22564e;
    }

    public void setState(int i2) {
        if (i2 == 0) {
            this.f22564e = 0;
            if (this.f22567h) {
                setImageDrawable(this.f22568i.getDrawable());
            } else {
                setImageResource(this.f22565f);
            }
        } else if (i2 == 1) {
            this.f22564e = 1;
            if (this.f22567h) {
                setImageDrawable(this.j.getDrawable());
            } else {
                setImageResource(this.f22566g);
            }
        }
    }

    public void setStateImage(int i2, int i3) {
        this.f22565f = i2;
        this.f22566g = i3;
    }

    public void setSvgStateImage(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        this.f22568i = absSvgType;
        this.j = absSvgType2;
        this.f22567h = true;
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22567h = false;
        a();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22567h = false;
        a();
    }
}
