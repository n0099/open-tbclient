package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private Button a;
    private Button b;
    private LinearLayout c;
    private View.OnClickListener d;
    private GalleryViewPager e;
    private android.support.v4.view.aj f;
    private android.support.v4.view.aj g;
    private k h;
    private ImagePagerAdapter i;
    private j j;
    private int k;
    private boolean l;
    private boolean m;

    public MultiImageView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = true;
        this.m = false;
        f();
    }

    public MultiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = true;
        this.m = false;
        f();
    }

    public MultiImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = true;
        this.m = false;
        f();
    }

    private void f() {
        this.m = com.baidu.tieba.c.ag.d(getContext());
        g();
        h();
    }

    private void g() {
        this.d = new ab(this);
        this.f = new ac(this);
        this.h = new ad(this);
        this.j = new ae(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f getCurrentImageView() {
        return this.e.getCurrentView();
    }

    private void h() {
        this.e = new GalleryViewPager(getContext());
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.e.setOnPageChangeListener(this.f);
        addView(this.e);
        this.c = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.tieba.c.ag.a(getContext(), 10.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.c.setOrientation(0);
        this.c.setLayoutParams(layoutParams);
        addView(this.c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.b = new Button(getContext());
        this.b.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.image_zoomout));
        this.b.setLayoutParams(layoutParams2);
        this.b.setOnClickListener(this.d);
        this.b.setEnabled(false);
        this.c.addView(this.b);
        this.a = new Button(getContext());
        this.a.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.image_zoomin));
        this.a.setLayoutParams(layoutParams2);
        this.a.setOnClickListener(this.d);
        this.a.setEnabled(false);
        this.c.addView(this.a);
        if (this.m) {
            this.c.setVisibility(8);
        }
        this.i = new ImagePagerAdapter(getContext(), null, this.j);
        setAdapter(this.i);
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.h);
        this.e.setAdapter(imagePagerAdapter);
    }

    public void a() {
        if (this.e.getCurrentView() == null) {
            return;
        }
        if (this.l) {
            int childCount = this.e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.e.getChildAt(i);
                if (childAt != null && (childAt instanceof ah) && ((ah) childAt).getImageView() != this.e.getCurrentView()) {
                    ((ah) childAt).d();
                }
            }
        }
        View findViewWithTag = this.e.findViewWithTag(String.valueOf(this.e.getCurrentItem()));
        if (findViewWithTag != null && (findViewWithTag instanceof ah)) {
            ((ah) findViewWithTag).f();
        }
        this.e.getCurrentView().e();
    }

    public void a(int i, int i2) {
        this.e.setOffscreenPageLimit(i);
        this.k = com.baidu.tieba.c.ag.c(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.k = (int) (this.k * 0.8d);
        if (this.k < 6291456) {
            this.l = true;
            this.k = (int) (com.baidu.tieba.c.ag.c(getContext()) * 0.7d);
        } else {
            this.l = false;
        }
        android.support.v4.view.k adapter = this.e.getAdapter();
        if (adapter == null || !(adapter instanceof ImagePagerAdapter)) {
            return;
        }
        ((ImagePagerAdapter) adapter).a(this.k);
    }

    public void a(int i, boolean z) {
        this.e.a(i, z);
    }

    public void b() {
        if (this.e.getCurrentView() != null) {
            this.e.getCurrentView().f();
        }
    }

    public void c() {
        if (this.e != null) {
            int childCount = this.e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.e.getChildAt(i);
                if (childAt != null && (childAt instanceof ah)) {
                    ((ah) childAt).c();
                }
            }
        }
    }

    public void d() {
        if (this.m) {
            return;
        }
        this.c.setVisibility(0);
    }

    public void e() {
        if (this.m) {
            return;
        }
        this.c.setVisibility(8);
    }

    public byte[] getCurrentImageData() {
        byte[] bArr = null;
        f selectedView = this.e.getSelectedView();
        return selectedView != null ? selectedView.getImageData() : bArr;
    }

    public String getCurrentImageUrl() {
        f selectedView = this.e.getSelectedView();
        if (selectedView.getTag() instanceof String) {
            return (String) selectedView.getTag();
        }
        return null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setHasNext(boolean z) {
        this.i.a(z);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public void setNextTitle(String str) {
        this.i.a(str);
    }

    public void setOnPageChangeListener(android.support.v4.view.aj ajVar) {
        this.g = ajVar;
    }

    public void setOnScrollOutListener(a aVar) {
        if (this.e != null) {
            this.e.setOnScrollOutListener(aVar);
        }
    }

    public void setPageMargin(int i) {
        this.e.setPageMargin(i);
    }

    public void setUrlData(ArrayList arrayList) {
        this.i.a(arrayList);
        this.i.notifyDataSetChanged();
    }

    public void setZoomButton(f fVar) {
        if (fVar == null) {
            this.b.setEnabled(false);
            this.a.setEnabled(false);
            return;
        }
        if (fVar.p()) {
            this.a.setEnabled(true);
        } else {
            this.a.setEnabled(false);
        }
        if (fVar.q()) {
            this.b.setEnabled(true);
        } else {
            this.b.setEnabled(false);
        }
    }
}
