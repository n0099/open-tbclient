package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.slidingmenu.lib.R;
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
    private l h;
    private ImagePagerAdapter i;
    private k j;
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

    public void setOnScrollOutListener(a aVar) {
        if (this.e != null) {
            this.e.setOnFlipOutListener(aVar);
        }
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
        this.m = com.baidu.tieba.d.ag.d(getContext());
        g();
        h();
    }

    private void g() {
        this.d = new ag(this);
        this.f = new ah(this);
        this.h = new ai(this);
        this.j = new aj(this);
    }

    public void a() {
        if (this.e.getCurrentView() != null) {
            if (this.l) {
                int childCount = this.e.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.e.getChildAt(i);
                    if (childAt != null && (childAt instanceof ap) && ((ap) childAt).getImageView() != this.e.getCurrentView()) {
                        ((ap) childAt).d();
                    }
                }
            }
            View findViewWithTag = this.e.findViewWithTag(String.valueOf(this.e.getCurrentItem()));
            if (findViewWithTag != null && (findViewWithTag instanceof ap)) {
                ((ap) findViewWithTag).f();
            }
            this.e.getCurrentView().e();
        }
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
                if (childAt != null && (childAt instanceof ap)) {
                    ((ap) childAt).c();
                }
            }
        }
    }

    private void h() {
        this.e = new GalleryViewPager(getContext());
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.e.setOnPageChangeListener(this.f);
        addView(this.e);
        this.c = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.tieba.d.ag.a(getContext(), 10.0f);
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

    public void setOnPageChangeListener(android.support.v4.view.aj ajVar) {
        this.g = ajVar;
    }

    public int getItemNum() {
        return this.i.getCount();
    }

    public int getCurrentItem() {
        return this.e.getCurrentItem();
    }

    public void setZoomButton(g gVar) {
        if (gVar != null) {
            if (gVar.p()) {
                this.a.setEnabled(true);
            } else {
                this.a.setEnabled(false);
            }
            if (gVar.q()) {
                this.b.setEnabled(true);
                return;
            } else {
                this.b.setEnabled(false);
                return;
            }
        }
        this.b.setEnabled(false);
        this.a.setEnabled(false);
    }

    public void d() {
        if (!this.m) {
            this.c.setVisibility(0);
        }
    }

    public void e() {
        if (!this.m) {
            this.c.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g getCurrentImageView() {
        return this.e.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setPageMargin(int i) {
        this.e.setPageMargin(i);
    }

    public void a(int i, int i2) {
        this.e.setOffscreenPageLimit(i);
        this.k = com.baidu.tieba.d.ag.c(getContext()) - ((((i * 2) + 1) * i2) * 2);
        this.k = (int) (this.k * 0.8d);
        if (this.k < 6291456) {
            this.l = true;
            this.k = (int) (com.baidu.tieba.d.ag.c(getContext()) * 0.7d);
        } else {
            this.l = false;
        }
        android.support.v4.view.k adapter = this.e.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).b(this.k);
        }
    }

    private void setAdapter(ImagePagerAdapter imagePagerAdapter) {
        imagePagerAdapter.a(this.h);
        this.e.setAdapter(imagePagerAdapter);
    }

    public void a(int i, boolean z) {
        this.e.a(i, z);
    }

    public void setTempSize(int i) {
        this.i.a(i);
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public void setUrlData(ArrayList arrayList) {
        this.i.a(arrayList);
        this.i.notifyDataSetChanged();
    }

    public void setHasNext(boolean z) {
        this.i.a(z);
    }

    public boolean getHasNext() {
        return this.i.a();
    }

    public void setNextTitle(String str) {
        this.i.a(str);
    }

    public byte[] getCurrentImageData() {
        byte[] bArr = null;
        g selectedView = this.e.getSelectedView();
        if (selectedView != null) {
            return selectedView.getImageData();
        }
        return bArr;
    }

    public String getCurrentImageUrl() {
        g selectedView = this.e.getSelectedView();
        if (!(selectedView.getTag() instanceof String)) {
            return null;
        }
        return (String) selectedView.getTag();
    }
}
