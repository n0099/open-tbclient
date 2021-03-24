package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
/* loaded from: classes5.dex */
public class SwitchImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f22205e;

    /* renamed from: f  reason: collision with root package name */
    public int f22206f;

    /* renamed from: g  reason: collision with root package name */
    public int f22207g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22208h;
    public AbsSvgType i;
    public AbsSvgType j;

    public SwitchImageView(Context context) {
        super(context);
        this.f22208h = false;
        a();
    }

    public final void a() {
        this.f22205e = 0;
        this.f22206f = 0;
        this.f22207g = 0;
    }

    public void b() {
        if (this.f22205e == 0) {
            this.f22205e = 1;
            setState(1);
            return;
        }
        this.f22205e = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.f22205e;
    }

    public void setState(int i) {
        if (i == 0) {
            this.f22205e = 0;
            if (this.f22208h) {
                setImageDrawable(this.i.getDrawable());
            } else {
                setImageResource(this.f22206f);
            }
        } else if (i == 1) {
            this.f22205e = 1;
            if (this.f22208h) {
                setImageDrawable(this.j.getDrawable());
            } else {
                setImageResource(this.f22207g);
            }
        }
    }

    public void setStateImage(int i, int i2) {
        this.f22206f = i;
        this.f22207g = i2;
    }

    public void setSvgStateImage(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        this.i = absSvgType;
        this.j = absSvgType2;
        this.f22208h = true;
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22208h = false;
        a();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22208h = false;
        a();
    }
}
