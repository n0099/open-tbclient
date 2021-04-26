package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int[] f20392e;

    /* renamed from: f  reason: collision with root package name */
    public int f20393f;

    /* renamed from: g  reason: collision with root package name */
    public int f20394g;

    /* renamed from: h  reason: collision with root package name */
    public int f20395h;

    /* renamed from: i  reason: collision with root package name */
    public int f20396i;
    public int j;
    public int k;
    public b l;
    public View.OnClickListener m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (!(view instanceof ChooseColorView) || (intValue = ((Integer) view.getTag()).intValue()) == ChooseColorLayout.this.j) {
                return;
            }
            ChooseColorLayout chooseColorLayout = ChooseColorLayout.this;
            View childAt = chooseColorLayout.getChildAt(chooseColorLayout.j);
            if (childAt instanceof ChooseColorView) {
                ((ChooseColorView) childAt).setIsChooseView(false);
            }
            ChooseColorLayout.this.j = intValue;
            ChooseColorView chooseColorView = (ChooseColorView) view;
            ChooseColorLayout.this.f20396i = chooseColorView.getChooseColor();
            chooseColorView.setIsChooseView(true);
            if (ChooseColorLayout.this.l != null) {
                ChooseColorLayout.this.l.a(ChooseColorLayout.this.f20396i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public final void f() {
        this.k = l.k(getContext());
        this.f20392e = getResources().getIntArray(R.array.choose_colors);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.f20395h = dimensionPixelSize;
        int i2 = (this.k - (dimensionPixelSize * 2)) / 8;
        this.f20393f = i2;
        this.f20394g = (i2 - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        int i3 = this.f20393f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        for (int i4 = 0; i4 < this.f20392e.length; i4++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.f20392e[i4]);
            chooseColorView.setTag(Integer.valueOf(i4));
            chooseColorView.setRadius(this.f20394g);
            if (i4 == 0) {
                chooseColorView.setIsChooseView(true);
                this.f20396i = this.f20392e[i4];
                this.j = i4;
            }
            chooseColorView.setOnClickListener(this.m);
            addView(chooseColorView, layoutParams);
        }
        int i5 = this.f20395h;
        setPadding(i5, 0, i5, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.f20396i;
    }

    public void setOnChooseColorChangeListener(b bVar) {
        this.l = bVar;
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = new a();
        f();
    }
}
