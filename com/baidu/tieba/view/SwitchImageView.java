package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
/* loaded from: classes5.dex */
public class SwitchImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f21922e;

    /* renamed from: f  reason: collision with root package name */
    public int f21923f;

    /* renamed from: g  reason: collision with root package name */
    public int f21924g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21925h;

    /* renamed from: i  reason: collision with root package name */
    public AbsSvgType f21926i;
    public AbsSvgType j;

    public SwitchImageView(Context context) {
        super(context);
        this.f21925h = false;
        a();
    }

    public final void a() {
        this.f21922e = 0;
        this.f21923f = 0;
        this.f21924g = 0;
    }

    public void b() {
        if (this.f21922e == 0) {
            this.f21922e = 1;
            setState(1);
            return;
        }
        this.f21922e = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.f21922e;
    }

    public void setState(int i2) {
        if (i2 == 0) {
            this.f21922e = 0;
            if (this.f21925h) {
                setImageDrawable(this.f21926i.getDrawable());
            } else {
                setImageResource(this.f21923f);
            }
        } else if (i2 == 1) {
            this.f21922e = 1;
            if (this.f21925h) {
                setImageDrawable(this.j.getDrawable());
            } else {
                setImageResource(this.f21924g);
            }
        }
    }

    public void setStateImage(int i2, int i3) {
        this.f21923f = i2;
        this.f21924g = i3;
    }

    public void setSvgStateImage(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        this.f21926i = absSvgType;
        this.j = absSvgType2;
        this.f21925h = true;
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21925h = false;
        a();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21925h = false;
        a();
    }
}
