package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class ChooseColorLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int[] f20191e;

    /* renamed from: f  reason: collision with root package name */
    public int f20192f;

    /* renamed from: g  reason: collision with root package name */
    public int f20193g;

    /* renamed from: h  reason: collision with root package name */
    public int f20194h;
    public int i;
    public int j;
    public int k;
    public b l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
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
            ChooseColorLayout.this.i = chooseColorView.getChooseColor();
            chooseColorView.setIsChooseView(true);
            if (ChooseColorLayout.this.l != null) {
                ChooseColorLayout.this.l.a(ChooseColorLayout.this.i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public final void f() {
        this.k = l.k(getContext());
        this.f20191e = getResources().getIntArray(R.array.choose_colors);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.f20194h = dimensionPixelSize;
        int i = (this.k - (dimensionPixelSize * 2)) / 8;
        this.f20192f = i;
        this.f20193g = (i - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        int i2 = this.f20192f;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 17;
        for (int i3 = 0; i3 < this.f20191e.length; i3++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.f20191e[i3]);
            chooseColorView.setTag(Integer.valueOf(i3));
            chooseColorView.setRadius(this.f20193g);
            if (i3 == 0) {
                chooseColorView.setIsChooseView(true);
                this.i = this.f20191e[i3];
                this.j = i3;
            }
            chooseColorView.setOnClickListener(this.m);
            addView(chooseColorView, layoutParams);
        }
        int i4 = this.f20194h;
        setPadding(i4, 0, i4, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.i;
    }

    public void setOnChooseColorChangeListener(b bVar) {
        this.l = bVar;
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new a();
        f();
    }
}
