package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
/* loaded from: classes5.dex */
public class SwitchImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f21899e;

    /* renamed from: f  reason: collision with root package name */
    public int f21900f;

    /* renamed from: g  reason: collision with root package name */
    public int f21901g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21902h;
    public AbsSvgType i;
    public AbsSvgType j;

    public SwitchImageView(Context context) {
        super(context);
        this.f21902h = false;
        a();
    }

    public final void a() {
        this.f21899e = 0;
        this.f21900f = 0;
        this.f21901g = 0;
    }

    public void b() {
        if (this.f21899e == 0) {
            this.f21899e = 1;
            setState(1);
            return;
        }
        this.f21899e = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.f21899e;
    }

    public void setState(int i) {
        if (i == 0) {
            this.f21899e = 0;
            if (this.f21902h) {
                setImageDrawable(this.i.getDrawable());
            } else {
                setImageResource(this.f21900f);
            }
        } else if (i == 1) {
            this.f21899e = 1;
            if (this.f21902h) {
                setImageDrawable(this.j.getDrawable());
            } else {
                setImageResource(this.f21901g);
            }
        }
    }

    public void setStateImage(int i, int i2) {
        this.f21900f = i;
        this.f21901g = i2;
    }

    public void setSvgStateImage(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        this.i = absSvgType;
        this.j = absSvgType2;
        this.f21902h = true;
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21902h = false;
        a();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21902h = false;
        a();
    }
}
