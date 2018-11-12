package com.baidu.tieba.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class SwipeViewPager extends ViewPager {
    private boolean hGP;
    private int hGQ;
    private int hGR;
    private ValueAnimator hGS;
    private d hGT;
    private float hGU;
    private float hGV;
    private float hGW;
    private float hGX;
    private int hGY;
    private boolean hGZ;
    private c hHa;
    private boolean hHb;
    private boolean hHc;
    private b hHd;
    private int hHe;
    private float hHf;
    private boolean hHg;
    private Drawable mDrawable;
    private int mHeight;
    private int mIconSize;
    private int mPageMargin;
    private ViewGroup mParentView;
    private TextView mTextView;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface b {
        void a(SwipeViewPager swipeViewPager, boolean z);
    }

    /* loaded from: classes.dex */
    public interface c {
        void b(SwipeViewPager swipeViewPager, boolean z);
    }

    public SwipeViewPager(Context context) {
        super(context);
        this.hGP = false;
        this.hGQ = 0;
        this.hGR = 300;
        this.hGZ = false;
        this.hHa = null;
        this.hHb = false;
        this.hHc = false;
        this.hHf = 0.5f;
        this.hHg = true;
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hGP = false;
        this.hGQ = 0;
        this.hGR = 300;
        this.hGZ = false;
        this.hHa = null;
        this.hHb = false;
        this.hHc = false;
        this.hHf = 0.5f;
        this.hHg = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.SwipeViewPager);
            c(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
        bJZ();
        setOffscreenPageLimit(3);
        setOverScrollMode(2);
        setClipChildren(false);
        this.hGT = new d(null);
        super.setAdapter(this.hGT);
    }

    private void c(TypedArray typedArray) {
        this.hHf = typedArray.getFloat(e.l.SwipeViewPager_leftItemPercent, 0.5f);
        if (this.hHf > 1.0f) {
            this.hHf = 1.0f;
        } else if (this.hHf < 0.0f) {
            this.hHf = 0.0f;
        }
        this.mTextView = new TextView(getContext());
        String string = typedArray.getString(e.l.SwipeViewPager_tips);
        this.mTextView.setText(wJ((string == null || string.length() < 1) ? "滑动显示全部信息" : "滑动显示全部信息"));
        this.mTextView.setTextSize(typedArray.getDimensionPixelSize(e.l.SwipeViewPager_svp_textSize, 20));
        this.mTextView.setPadding(typedArray.getDimensionPixelSize(e.l.SwipeViewPager_tipsPaddingLeft, 50), 0, 0, 0);
        this.mTextView.setTextColor(typedArray.getColor(e.l.SwipeViewPager_svp_textColor, Color.parseColor("#565656")));
        this.mTextView.setBackgroundColor(typedArray.getColor(e.l.SwipeViewPager_tipsBackground, Color.parseColor("#00000000")));
        this.hGR = typedArray.getDimensionPixelSize(e.l.SwipeViewPager_tipsWidth, 300);
        this.hHe = (int) (this.hGR * 1.5f);
        this.hGQ = typedArray.getDimensionPixelSize(e.l.SwipeViewPager_maxSwipeWidth, 0);
        this.mPageMargin = typedArray.getDimensionPixelOffset(e.l.SwipeViewPager_pageMargin, getResources().getDimensionPixelOffset(e.C0200e.ds40));
        super.setPageMargin(this.mPageMargin);
        int resourceId = typedArray.getResourceId(e.l.SwipeViewPager_tipIcon, 0);
        if (resourceId != 0) {
            this.mDrawable = getContext().getResources().getDrawable(resourceId);
        }
        this.mIconSize = typedArray.getDimensionPixelOffset(e.l.SwipeViewPager_iconSize, 96);
        this.mTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.view.SwipeViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((motionEvent.getAction() & 255) == 0) {
                    SwipeViewPager.this.onInterceptTouchEvent(motionEvent);
                }
                return SwipeViewPager.this.onTouchEvent(motionEvent);
            }
        });
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.SwipeViewPager.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (SwipeViewPager.this.mParentView == null || SwipeViewPager.this.mWidth == 0 || SwipeViewPager.this.mHeight == 0) {
                        SwipeViewPager.this.initial();
                    }
                }
            });
        }
    }

    public TextView getTipsTextView() {
        return this.mTextView;
    }

    private String wJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)).append("\n");
        }
        return sb.toString();
    }

    public void setDrawableResource(int i) {
        this.mDrawable = getResources().getDrawable(i);
        setDrawable(this.mDrawable);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null && this.mTextView != null) {
            this.mDrawable = drawable;
            if (this.mTextView.getCompoundDrawables().length > 0) {
                this.mTextView.setCompoundDrawables(null, null, null, null);
            }
            if (this.mDrawable != null) {
                int i = (-this.mIconSize) / 2;
                this.mDrawable.setBounds(0, i, this.mIconSize, this.mIconSize + i);
            }
            this.mTextView.setCompoundDrawables(this.mDrawable, null, null, null);
            this.mTextView.setCompoundDrawablePadding(l.h(getContext(), e.C0200e.ds12));
            this.mTextView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initial() {
        this.mParentView = (ViewGroup) getParent();
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        this.mTextView.setLayoutParams(new ViewGroup.LayoutParams(this.mWidth, this.mHeight));
        this.mTextView.setGravity(16);
        if (this.mDrawable != null) {
            int height = (this.mTextView.getHeight() / 2) - (this.mIconSize / 2);
            this.mDrawable.setBounds(0, 0, this.mIconSize, this.mIconSize);
            this.mTextView.setCompoundDrawables(this.mDrawable, null, null, null);
            this.mTextView.setCompoundDrawablePadding(l.h(getContext(), e.C0200e.ds12));
        }
        if (this.hGR < this.mTextView.getWidth() + this.mIconSize) {
            this.hGR = this.mTextView.getWidth() + this.mIconSize;
        }
        this.mParentView.addView(this.mTextView);
        if (this.hGQ == 0) {
            this.hGQ = this.mWidth;
        }
        if (this.hGY == 0) {
            if (this.hGT != null) {
                this.hGY = (int) ((1.0f - this.hGT.getPageWidth(0)) * this.hHf * this.mWidth);
            } else {
                this.hGY = (int) (0.1f * this.mWidth);
            }
        }
        this.mTextView.setX(this.mParentView.getWidth());
        setOnPageChangeListener(new a());
        this.mParentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.view.SwipeViewPager.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return SwipeViewPager.this.onTouchEvent(motionEvent);
            }
        });
        setClipChildren(false);
    }

    public void setTipsVisibility(int i) {
        if ((i == 8 || i == 0 || i == 4) && this.mTextView != null) {
            this.mTextView.setVisibility(i);
        }
    }

    private void bJZ() {
        this.hGS = new ValueAnimator();
        this.hGS.setDuration(150L);
        this.hGS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SwipeViewPager.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SwipeViewPager.this.mParentView != null) {
                    SwipeViewPager.this.mParentView.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            }
        });
    }

    public void setFixPercent(float f) {
        this.hHf = f;
        if (this.hHf > 1.0f) {
            this.hHf = 1.0f;
        } else if (this.hHf < 0.0f) {
            this.hHf = 0.0f;
        }
        if (this.hGT != null) {
            this.hGY = (int) ((1.0f - this.hGT.getPageWidth(0)) * this.hHf * this.mWidth);
        } else {
            this.hGY = (int) (0.1f * this.mWidth);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int count;
        if (this.mParentView == null) {
            initial();
        }
        if ((motionEvent.getAction() & 255) == 0 && !this.hGZ) {
            this.hGU = motionEvent.getRawX();
            this.hGV = motionEvent.getRawY();
            this.hGX = getScrollX();
            this.hGW = this.mParentView.getScrollX();
        }
        for (ViewParent parent = getParent(); parent != null && !bKb(); parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (this.hGT != null && (count = this.hGT.getCount()) != 0) {
            if (count * this.hGT.getPageWidth(0) < 1.0f) {
                return bKa();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean bKa() {
        if (this.hGT != null) {
            return this.hGT.getCount() <= ((this.hGT.getPageWidth(0) > 0.0f ? 1 : (this.hGT.getPageWidth(0) == 0.0f ? 0 : -1)) > 0 ? (int) (1.0d / ((double) this.hGT.getPageWidth(0))) : 0) + getCurrentItem();
        }
        return false;
    }

    private boolean bKb() {
        return getScrollX() == 0;
    }

    private boolean N(MotionEvent motionEvent) {
        int count;
        if (this.hGT == null || (count = this.hGT.getCount()) == 0) {
            return false;
        }
        if (count * this.hGT.getPageWidth(0) < 1.0f) {
            return bKa();
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.hHg) {
            return N(motionEvent);
        }
        if (motionEvent.getPointerCount() <= 1) {
            if (this.hGS == null || !this.hGS.isRunning()) {
                int action = motionEvent.getAction();
                if (bKb() && (action & 255) == 2 && motionEvent.getRawX() - this.hGU > 0.0f) {
                    return false;
                }
                if (bKa()) {
                    switch (action & 255) {
                        case 1:
                        case 3:
                            if (this.hGZ) {
                                O(motionEvent);
                            }
                            bKc();
                            break;
                        case 2:
                            if (P(motionEvent)) {
                                scrollTo((int) this.hGX, 0);
                                return true;
                            }
                            break;
                    }
                }
                return N(motionEvent);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKc() {
        if (bKb()) {
            cc(this.mParentView.getScrollX(), 0);
        } else if (!bKa() && this.mParentView.getScrollX() != (-this.hGY)) {
            cc(this.mParentView.getScrollX(), -this.hGY);
        } else if (bKa() && bKd()) {
            cc(this.mParentView.getScrollX(), this.hGR);
        }
    }

    private boolean bKd() {
        return this.mTextView != null && this.mTextView.getVisibility() == 0;
    }

    private void cc(int i, int i2) {
        if (this.hGS == null) {
            bJZ();
        }
        this.hGS.setIntValues(i, i2);
        this.hGS.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.view.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i3) {
                i3 = measuredHeight;
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, AiAppsFileUtils.GB));
    }

    private void O(MotionEvent motionEvent) {
        float rawX = (motionEvent.getRawX() - this.hGU) * 0.5f;
        this.hGZ = false;
        if (this.mParentView != null) {
            if (bKd()) {
                cc(this.mParentView.getScrollX(), this.hGR);
            } else {
                cc(this.mParentView.getScrollX(), 0);
            }
        }
        if ((-rawX) > this.hGR && this.hHa != null && !this.hHb) {
            this.hHb = true;
            this.hHa.b(this, true);
        }
        if (this.hHd != null && this.hHc) {
            this.hHc = false;
            this.hHd.a(this, false);
        }
    }

    public void setTips(String str) {
        if (this.mTextView != null) {
            this.mTextView.setText(wJ(str));
        }
    }

    private boolean P(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.hGU;
        if (rawX < 0.0f) {
            float f = (rawX * 0.5f) - this.hGW;
            this.hGZ = true;
            if (Math.abs(f) > Math.abs(this.hGQ)) {
                return true;
            }
            if (Math.abs(f) > this.hHe && !this.hHc) {
                this.hHc = true;
                if (this.hHd != null) {
                    this.hHd.a(this, true);
                }
            } else if ((-f) < this.hHe && this.hHc) {
                this.hHc = false;
                if (this.hHd != null) {
                    this.hHd.a(this, false);
                }
            }
            if (this.mParentView != null) {
                this.mParentView.scrollTo(-((int) f), 0);
                return true;
            }
            return true;
        } else if (rawX < this.hGR + 20) {
            float f2 = this.hGW - rawX;
            if (this.mParentView != null) {
                this.mParentView.scrollTo((int) f2, 0);
            }
            this.hGZ = true;
            return true;
        } else {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.hGT == null) {
            this.hGT = new d(pagerAdapter);
            super.setAdapter(this.hGT);
            return;
        }
        this.hGT.a(pagerAdapter);
        this.hGT.notifyDataSetChanged();
    }

    public void setPagerWidth(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.hGT == null) {
            this.hGT = new d(null);
            super.setAdapter(this.hGT);
        }
        this.hGY = -((int) ((1.0f - this.hGT.getPageWidth(0)) * this.hHf * getWidth()));
        this.hGT.setPagerWidth(f);
        this.hGT.notifyDataSetChanged();
    }

    public void setCanDrag(boolean z) {
        this.hHg = z;
        if (!z) {
            this.mTextView.setVisibility(8);
        } else {
            this.mTextView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends ViewPager.SimpleOnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SwipeViewPager.this.bKc();
        }
    }

    public void setOnSwipeListener(c cVar) {
        this.hHa = cVar;
    }

    public void setOnOverDragChanageListener(b bVar) {
        this.hHd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends PagerAdapter {
        private float hHi = 0.8f;
        private PagerAdapter mAdapter;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(PagerAdapter pagerAdapter) {
            this.mAdapter = pagerAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPagerWidth(float f) {
            this.hHi = f;
        }

        public d(PagerAdapter pagerAdapter) {
            this.mAdapter = pagerAdapter;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (this.mAdapter == null) {
                return 0;
            }
            return this.mAdapter.getCount();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return this.mAdapter != null && this.mAdapter.isViewFromObject(view, obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return this.mAdapter == null ? super.instantiateItem(viewGroup, i) : this.mAdapter.instantiateItem(viewGroup, i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (this.mAdapter != null) {
                this.mAdapter.destroyItem(viewGroup, i, obj);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public float getPageWidth(int i) {
            return this.hHi;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Parcelable saveState() {
            return this.mAdapter == null ? super.saveState() : this.mAdapter.saveState();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void startUpdate(ViewGroup viewGroup) {
            if (this.mAdapter != null) {
                this.mAdapter.startUpdate(viewGroup);
            } else {
                super.startUpdate(viewGroup);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (this.mAdapter != null) {
                this.mAdapter.setPrimaryItem(viewGroup, i, obj);
            } else {
                super.setPrimaryItem(viewGroup, i, obj);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public void finishUpdate(ViewGroup viewGroup) {
            if (this.mAdapter != null) {
                this.mAdapter.finishUpdate(viewGroup);
            } else {
                super.finishUpdate(viewGroup);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            if (this.mAdapter != null) {
                this.mAdapter.restoreState(parcelable, classLoader);
            } else {
                super.restoreState(parcelable, classLoader);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter != null) {
                this.mAdapter.notifyDataSetChanged();
            } else {
                super.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mAdapter == null ? super.getPageTitle(i) : this.mAdapter.getPageTitle(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.mAdapter == null) {
                super.registerDataSetObserver(dataSetObserver);
            } else {
                this.mAdapter.registerDataSetObserver(dataSetObserver);
            }
        }
    }
}
