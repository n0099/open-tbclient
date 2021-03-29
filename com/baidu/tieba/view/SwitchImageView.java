package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
/* loaded from: classes5.dex */
public class SwitchImageView extends AppCompatImageView {

    /* renamed from: e  reason: collision with root package name */
    public int f22206e;

    /* renamed from: f  reason: collision with root package name */
    public int f22207f;

    /* renamed from: g  reason: collision with root package name */
    public int f22208g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22209h;
    public AbsSvgType i;
    public AbsSvgType j;

    public SwitchImageView(Context context) {
        super(context);
        this.f22209h = false;
        a();
    }

    public final void a() {
        this.f22206e = 0;
        this.f22207f = 0;
        this.f22208g = 0;
    }

    public void b() {
        if (this.f22206e == 0) {
            this.f22206e = 1;
            setState(1);
            return;
        }
        this.f22206e = 0;
        setState(0);
    }

    public int getCurrentState() {
        return this.f22206e;
    }

    public void setState(int i) {
        if (i == 0) {
            this.f22206e = 0;
            if (this.f22209h) {
                setImageDrawable(this.i.getDrawable());
            } else {
                setImageResource(this.f22207f);
            }
        } else if (i == 1) {
            this.f22206e = 1;
            if (this.f22209h) {
                setImageDrawable(this.j.getDrawable());
            } else {
                setImageResource(this.f22208g);
            }
        }
    }

    public void setStateImage(int i, int i2) {
        this.f22207f = i;
        this.f22208g = i2;
    }

    public void setSvgStateImage(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        this.i = absSvgType;
        this.j = absSvgType2;
        this.f22209h = true;
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22209h = false;
        a();
    }

    public SwitchImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22209h = false;
        a();
    }
}
