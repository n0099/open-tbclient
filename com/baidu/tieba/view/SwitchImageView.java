package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
/* loaded from: classes5.dex */
public class SwitchImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f21809e;

    /* renamed from: f  reason: collision with root package name */
    public int f21810f;

    /* renamed from: g  reason: collision with root package name */
    public int f21811g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21812h;

    /* renamed from: i  reason: collision with root package name */
    public AbsSvgType f21813i;
    public AbsSvgType j;

    public SwitchImageView(Context context) {
        super(context);
        this.f21812h = false;
        a();
    }

    public final void a() {
        this.f21809e = 0;
        this.f21810f = 0;
        this.f21811g = 0;
    }

    public void b() {
        if (this.f21809e == 0) {
            this.f21809e = 1;
            setState(1);
            return;
        }
        this.f21809e = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.f21809e;
    }

    public void setState(int i2) {
        if (i2 == 0) {
            this.f21809e = 0;
            if (this.f21812h) {
                setImageDrawable(this.f21813i.getDrawable());
            } else {
                setImageResource(this.f21810f);
            }
        } else if (i2 == 1) {
            this.f21809e = 1;
            if (this.f21812h) {
                setImageDrawable(this.j.getDrawable());
            } else {
                setImageResource(this.f21811g);
            }
        }
    }

    public void setStateImage(int i2, int i3) {
        this.f21810f = i2;
        this.f21811g = i3;
    }

    public void setSvgStateImage(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        this.f21813i = absSvgType;
        this.j = absSvgType2;
        this.f21812h = true;
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21812h = false;
        a();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21812h = false;
        a();
    }
}
