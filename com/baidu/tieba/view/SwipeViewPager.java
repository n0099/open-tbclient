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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SwipeViewPager extends ViewPager {
    private boolean hoQ;
    private int hoR;
    private int hoS;
    private ValueAnimator hoT;
    private d hoU;
    private float hoV;
    private float hoW;
    private float hoX;
    private float hoY;
    private int hoZ;
    private boolean hpa;
    private c hpb;
    private boolean hpc;
    private boolean hpd;
    private b hpe;
    private int hpf;
    private float hpg;
    private boolean hph;
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
        this.hoQ = false;
        this.hoR = 0;
        this.hoS = 300;
        this.hpa = false;
        this.hpb = null;
        this.hpc = false;
        this.hpd = false;
        this.hpg = 0.5f;
        this.hph = true;
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hoQ = false;
        this.hoR = 0;
        this.hoS = 300;
        this.hpa = false;
        this.hpb = null;
        this.hpc = false;
        this.hpd = false;
        this.hpg = 0.5f;
        this.hph = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.SwipeViewPager);
            c(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
        bFK();
        setOffscreenPageLimit(3);
        setOverScrollMode(2);
        setClipChildren(false);
        this.hoU = new d(null);
        super.setAdapter(this.hoU);
    }

    private void c(TypedArray typedArray) {
        this.hpg = typedArray.getFloat(d.m.SwipeViewPager_leftItemPercent, 0.5f);
        if (this.hpg > 1.0f) {
            this.hpg = 1.0f;
        } else if (this.hpg < 0.0f) {
            this.hpg = 0.0f;
        }
        this.mTextView = new TextView(getContext());
        String string = typedArray.getString(d.m.SwipeViewPager_tips);
        this.mTextView.setText(vp((string == null || string.length() < 1) ? "滑动显示全部信息" : "滑动显示全部信息"));
        this.mTextView.setTextSize(typedArray.getDimensionPixelSize(d.m.SwipeViewPager_svp_textSize, 20));
        this.mTextView.setPadding(typedArray.getDimensionPixelSize(d.m.SwipeViewPager_tipsPaddingLeft, 50), 0, 0, 0);
        this.mTextView.setTextColor(typedArray.getColor(d.m.SwipeViewPager_svp_textColor, Color.parseColor("#565656")));
        this.mTextView.setBackgroundColor(typedArray.getColor(d.m.SwipeViewPager_tipsBackground, Color.parseColor("#00000000")));
        this.hoS = typedArray.getDimensionPixelSize(d.m.SwipeViewPager_tipsWidth, 300);
        this.hpf = (int) (this.hoS * 1.5f);
        this.hoR = typedArray.getDimensionPixelSize(d.m.SwipeViewPager_maxSwipeWidth, 0);
        this.mPageMargin = typedArray.getDimensionPixelOffset(d.m.SwipeViewPager_pageMargin, getResources().getDimensionPixelOffset(d.e.ds40));
        super.setPageMargin(this.mPageMargin);
        int resourceId = typedArray.getResourceId(d.m.SwipeViewPager_tipIcon, 0);
        if (resourceId != 0) {
            this.mDrawable = getContext().getResources().getDrawable(resourceId);
        }
        this.mIconSize = typedArray.getDimensionPixelOffset(d.m.SwipeViewPager_iconSize, 96);
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

    private String vp(String str) {
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
            this.mTextView.setCompoundDrawablePadding(l.e(getContext(), d.e.ds12));
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
            this.mTextView.setCompoundDrawablePadding(l.e(getContext(), d.e.ds12));
        }
        if (this.hoS < this.mTextView.getWidth() + this.mIconSize) {
            this.hoS = this.mTextView.getWidth() + this.mIconSize;
        }
        this.mParentView.addView(this.mTextView);
        if (this.hoR == 0) {
            this.hoR = this.mWidth;
        }
        if (this.hoZ == 0) {
            if (this.hoU != null) {
                this.hoZ = (int) ((1.0f - this.hoU.getPageWidth(0)) * this.hpg * this.mWidth);
            } else {
                this.hoZ = (int) (0.1f * this.mWidth);
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

    private void bFK() {
        this.hoT = new ValueAnimator();
        this.hoT.setDuration(150L);
        this.hoT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SwipeViewPager.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SwipeViewPager.this.mParentView != null) {
                    SwipeViewPager.this.mParentView.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            }
        });
    }

    public void setFixPercent(float f) {
        this.hpg = f;
        if (this.hpg > 1.0f) {
            this.hpg = 1.0f;
        } else if (this.hpg < 0.0f) {
            this.hpg = 0.0f;
        }
        if (this.hoU != null) {
            this.hoZ = (int) ((1.0f - this.hoU.getPageWidth(0)) * this.hpg * this.mWidth);
        } else {
            this.hoZ = (int) (0.1f * this.mWidth);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int count;
        if (this.mParentView == null) {
            initial();
        }
        if ((motionEvent.getAction() & 255) == 0 && !this.hpa) {
            this.hoV = motionEvent.getRawX();
            this.hoW = motionEvent.getRawY();
            this.hoY = getScrollX();
            this.hoX = this.mParentView.getScrollX();
        }
        for (ViewParent parent = getParent(); parent != null && !bFM(); parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (this.hoU != null && (count = this.hoU.getCount()) != 0) {
            if (count * this.hoU.getPageWidth(0) < 1.0f) {
                return bFL();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean bFL() {
        if (this.hoU != null) {
            return this.hoU.getCount() <= ((this.hoU.getPageWidth(0) > 0.0f ? 1 : (this.hoU.getPageWidth(0) == 0.0f ? 0 : -1)) > 0 ? (int) (1.0d / ((double) this.hoU.getPageWidth(0))) : 0) + getCurrentItem();
        }
        return false;
    }

    private boolean bFM() {
        return getScrollX() == 0;
    }

    private boolean N(MotionEvent motionEvent) {
        int count;
        if (this.hoU == null || (count = this.hoU.getCount()) == 0) {
            return false;
        }
        if (count * this.hoU.getPageWidth(0) < 1.0f) {
            return bFL();
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.hph) {
            return N(motionEvent);
        }
        if (motionEvent.getPointerCount() <= 1) {
            if (this.hoT == null || !this.hoT.isRunning()) {
                int action = motionEvent.getAction();
                if (bFM() && (action & 255) == 2 && motionEvent.getRawX() - this.hoV > 0.0f) {
                    return false;
                }
                if (bFL()) {
                    switch (action & 255) {
                        case 1:
                        case 3:
                            if (this.hpa) {
                                O(motionEvent);
                            }
                            bFN();
                            break;
                        case 2:
                            if (P(motionEvent)) {
                                scrollTo((int) this.hoY, 0);
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
    public void bFN() {
        if (bFM()) {
            bR(this.mParentView.getScrollX(), 0);
        } else if (!bFL() && this.mParentView.getScrollX() != (-this.hoZ)) {
            bR(this.mParentView.getScrollX(), -this.hoZ);
        } else if (bFL() && bFO()) {
            bR(this.mParentView.getScrollX(), this.hoS);
        }
    }

    private boolean bFO() {
        return this.mTextView != null && this.mTextView.getVisibility() == 0;
    }

    private void bR(int i, int i2) {
        if (this.hoT == null) {
            bFK();
        }
        this.hoT.setIntValues(i, i2);
        this.hoT.start();
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
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    private void O(MotionEvent motionEvent) {
        float rawX = (motionEvent.getRawX() - this.hoV) * 0.5f;
        this.hpa = false;
        if (this.mParentView != null) {
            if (bFO()) {
                bR(this.mParentView.getScrollX(), this.hoS);
            } else {
                bR(this.mParentView.getScrollX(), 0);
            }
        }
        if ((-rawX) > this.hoS && this.hpb != null && !this.hpc) {
            this.hpc = true;
            this.hpb.b(this, true);
        }
        if (this.hpe != null && this.hpd) {
            this.hpd = false;
            this.hpe.a(this, false);
        }
    }

    public void setTips(String str) {
        if (this.mTextView != null) {
            this.mTextView.setText(vp(str));
        }
    }

    private boolean P(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.hoV;
        if (rawX < 0.0f) {
            float f = (rawX * 0.5f) - this.hoX;
            this.hpa = true;
            if (Math.abs(f) > Math.abs(this.hoR)) {
                return true;
            }
            if (Math.abs(f) > this.hpf && !this.hpd) {
                this.hpd = true;
                if (this.hpe != null) {
                    this.hpe.a(this, true);
                }
            } else if ((-f) < this.hpf && this.hpd) {
                this.hpd = false;
                if (this.hpe != null) {
                    this.hpe.a(this, false);
                }
            }
            if (this.mParentView != null) {
                this.mParentView.scrollTo(-((int) f), 0);
                return true;
            }
            return true;
        } else if (rawX < this.hoS + 20) {
            float f2 = this.hoX - rawX;
            if (this.mParentView != null) {
                this.mParentView.scrollTo((int) f2, 0);
            }
            this.hpa = true;
            return true;
        } else {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.hoU == null) {
            this.hoU = new d(pagerAdapter);
            super.setAdapter(this.hoU);
            return;
        }
        this.hoU.a(pagerAdapter);
        this.hoU.notifyDataSetChanged();
    }

    public void setPagerWidth(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.hoU == null) {
            this.hoU = new d(null);
            super.setAdapter(this.hoU);
        }
        this.hoZ = -((int) ((1.0f - this.hoU.getPageWidth(0)) * this.hpg * getWidth()));
        this.hoU.setPagerWidth(f);
        this.hoU.notifyDataSetChanged();
    }

    public void setCanDrag(boolean z) {
        this.hph = z;
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
            SwipeViewPager.this.bFN();
        }
    }

    public void setOnSwipeListener(c cVar) {
        this.hpb = cVar;
    }

    public void setOnOverDragChanageListener(b bVar) {
        this.hpe = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends PagerAdapter {
        private float hpj = 0.8f;
        private PagerAdapter mAdapter;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(PagerAdapter pagerAdapter) {
            this.mAdapter = pagerAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPagerWidth(float f) {
            this.hpj = f;
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
            return this.hpj;
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
