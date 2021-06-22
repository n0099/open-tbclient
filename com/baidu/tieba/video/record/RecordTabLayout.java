package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class RecordTabLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f21489e;

    /* renamed from: f  reason: collision with root package name */
    public View f21490f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21491g;

    /* renamed from: h  reason: collision with root package name */
    public int f21492h;

    /* renamed from: i  reason: collision with root package name */
    public c f21493i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21494e;

        public a(int i2) {
            this.f21494e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2 = RecordTabLayout.this.f21492h;
            int i3 = this.f21494e;
            if (i2 == i3) {
                return;
            }
            RecordTabLayout.this.setCurrentTab(i3, true);
            if (RecordTabLayout.this.f21493i != null) {
                RecordTabLayout.this.f21493i.onTabChoosed(this.f21494e, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f21496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f21497f;

        public b(TextView textView, boolean z) {
            this.f21496e = textView;
            this.f21497f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            float x = (this.f21496e.getX() + ((this.f21496e.getWidth() - RecordTabLayout.this.f21490f.getWidth()) / 2)) - RecordTabLayout.this.f21490f.getLeft();
            if (this.f21497f) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.f21490f, "translationX", RecordTabLayout.this.f21490f.getTranslationX(), x);
                ofFloat.setDuration(500L);
                ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                ofFloat.start();
                return;
            }
            RecordTabLayout.this.f21490f.setTranslationX(x);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onTabChoosed(int i2, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.f21491g = true;
        e();
    }

    public void d(int i2, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, l.g(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i2));
        textView.setOnClickListener(new a(i2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f21489e.getChildCount() != 0) {
            layoutParams.leftMargin = l.g(getContext(), R.dimen.ds44);
        }
        this.f21489e.addView(textView, layoutParams);
    }

    public final void e() {
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f21489e = linearLayout;
        linearLayout.setOrientation(0);
        this.f21489e.setGravity(17);
        addView(this.f21489e, new ViewGroup.LayoutParams(-1, -2));
        View view = new View(getContext());
        this.f21490f = view;
        view.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.ds44), l.g(getContext(), R.dimen.ds4));
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds18);
        addView(this.f21490f, layoutParams);
    }

    public int getCurrentTab() {
        return this.f21492h;
    }

    public void setCurrentTab(int i2, boolean z) {
        if (this.f21492h == i2) {
            return;
        }
        this.f21492h = i2;
        TextView textView = null;
        for (int i3 = 0; i3 < this.f21489e.getChildCount(); i3++) {
            View childAt = this.f21489e.getChildAt(i3);
            if (childAt instanceof TextView) {
                Object tag = childAt.getTag();
                if ((tag instanceof Integer) && ((Integer) tag).intValue() == i2) {
                    TextView textView2 = (TextView) childAt;
                    textView2.setTextColor(getResources().getColor(R.color.CAM_X0101));
                    textView = textView2;
                } else {
                    ((TextView) childAt).setTextColor(getResources().getColor(R.color.white_alpha80));
                }
            }
        }
        if (this.f21491g) {
            textView.post(new b(textView, z));
        }
    }

    public void setListener(c cVar) {
        this.f21493i = cVar;
    }

    public void setShowIndicator(boolean z) {
        this.f21491g = z;
        if (z) {
            return;
        }
        this.f21490f.setVisibility(4);
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21491g = true;
        e();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21491g = true;
        e();
    }
}
