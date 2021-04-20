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
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class RecordTabLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f21517e;

    /* renamed from: f  reason: collision with root package name */
    public View f21518f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21519g;

    /* renamed from: h  reason: collision with root package name */
    public int f21520h;
    public c i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21521e;

        public a(int i) {
            this.f21521e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = RecordTabLayout.this.f21520h;
            int i2 = this.f21521e;
            if (i == i2) {
                return;
            }
            RecordTabLayout.this.setCurrentTab(i2, true);
            if (RecordTabLayout.this.i != null) {
                RecordTabLayout.this.i.onTabChoosed(this.f21521e, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f21523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f21524f;

        public b(TextView textView, boolean z) {
            this.f21523e = textView;
            this.f21524f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            float x = (this.f21523e.getX() + ((this.f21523e.getWidth() - RecordTabLayout.this.f21518f.getWidth()) / 2)) - RecordTabLayout.this.f21518f.getLeft();
            if (this.f21524f) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.f21518f, "translationX", RecordTabLayout.this.f21518f.getTranslationX(), x);
                ofFloat.setDuration(500L);
                ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                ofFloat.start();
                return;
            }
            RecordTabLayout.this.f21518f.setTranslationX(x);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onTabChoosed(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.f21519g = true;
        e();
    }

    public void d(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, l.g(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new a(i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f21517e.getChildCount() != 0) {
            layoutParams.leftMargin = l.g(getContext(), R.dimen.ds44);
        }
        this.f21517e.addView(textView, layoutParams);
    }

    public final void e() {
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f21517e = linearLayout;
        linearLayout.setOrientation(0);
        this.f21517e.setGravity(17);
        addView(this.f21517e, new ViewGroup.LayoutParams(-1, -2));
        View view = new View(getContext());
        this.f21518f = view;
        view.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.ds44), l.g(getContext(), R.dimen.ds4));
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds18);
        addView(this.f21518f, layoutParams);
    }

    public int getCurrentTab() {
        return this.f21520h;
    }

    public void setCurrentTab(int i, boolean z) {
        if (this.f21520h == i) {
            return;
        }
        this.f21520h = i;
        TextView textView = null;
        for (int i2 = 0; i2 < this.f21517e.getChildCount(); i2++) {
            View childAt = this.f21517e.getChildAt(i2);
            if (childAt instanceof TextView) {
                Object tag = childAt.getTag();
                if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                    TextView textView2 = (TextView) childAt;
                    textView2.setTextColor(getResources().getColor(R.color.CAM_X0101));
                    textView = textView2;
                } else {
                    ((TextView) childAt).setTextColor(getResources().getColor(R.color.white_alpha80));
                }
            }
        }
        if (this.f21519g) {
            textView.post(new b(textView, z));
        }
    }

    public void setListener(c cVar) {
        this.i = cVar;
    }

    public void setShowIndicator(boolean z) {
        this.f21519g = z;
        if (z) {
            return;
        }
        this.f21518f.setVisibility(4);
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21519g = true;
        e();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21519g = true;
        e();
    }
}
