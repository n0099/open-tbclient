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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class SwipeViewPager extends ViewPager {
    private boolean hpZ;
    private int hqa;
    private int hqb;
    private ValueAnimator hqc;
    private d hqd;
    private float hqe;
    private float hqf;
    private float hqg;
    private float hqh;
    private int hqi;
    private boolean hqj;
    private c hqk;
    private boolean hql;
    private boolean hqm;
    private b hqn;
    private int hqo;
    private float hqp;
    private boolean hqq;
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
        this.hpZ = false;
        this.hqa = 0;
        this.hqb = 300;
        this.hqj = false;
        this.hqk = null;
        this.hql = false;
        this.hqm = false;
        this.hqp = 0.5f;
        this.hqq = true;
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hpZ = false;
        this.hqa = 0;
        this.hqb = 300;
        this.hqj = false;
        this.hqk = null;
        this.hql = false;
        this.hqm = false;
        this.hqp = 0.5f;
        this.hqq = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.SwipeViewPager);
            c(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
        bEx();
        setOffscreenPageLimit(3);
        setOverScrollMode(2);
        setClipChildren(false);
        this.hqd = new d(null);
        super.setAdapter(this.hqd);
    }

    private void c(TypedArray typedArray) {
        this.hqp = typedArray.getFloat(f.l.SwipeViewPager_leftItemPercent, 0.5f);
        if (this.hqp > 1.0f) {
            this.hqp = 1.0f;
        } else if (this.hqp < 0.0f) {
            this.hqp = 0.0f;
        }
        this.mTextView = new TextView(getContext());
        String string = typedArray.getString(f.l.SwipeViewPager_tips);
        this.mTextView.setText(vu((string == null || string.length() < 1) ? "滑动显示全部信息" : "滑动显示全部信息"));
        this.mTextView.setTextSize(typedArray.getDimensionPixelSize(f.l.SwipeViewPager_svp_textSize, 20));
        this.mTextView.setPadding(typedArray.getDimensionPixelSize(f.l.SwipeViewPager_tipsPaddingLeft, 50), 0, 0, 0);
        this.mTextView.setTextColor(typedArray.getColor(f.l.SwipeViewPager_svp_textColor, Color.parseColor("#565656")));
        this.mTextView.setBackgroundColor(typedArray.getColor(f.l.SwipeViewPager_tipsBackground, Color.parseColor("#00000000")));
        this.hqb = typedArray.getDimensionPixelSize(f.l.SwipeViewPager_tipsWidth, 300);
        this.hqo = (int) (this.hqb * 1.5f);
        this.hqa = typedArray.getDimensionPixelSize(f.l.SwipeViewPager_maxSwipeWidth, 0);
        this.mPageMargin = typedArray.getDimensionPixelOffset(f.l.SwipeViewPager_pageMargin, getResources().getDimensionPixelOffset(f.e.ds40));
        super.setPageMargin(this.mPageMargin);
        int resourceId = typedArray.getResourceId(f.l.SwipeViewPager_tipIcon, 0);
        if (resourceId != 0) {
            this.mDrawable = getContext().getResources().getDrawable(resourceId);
        }
        this.mIconSize = typedArray.getDimensionPixelOffset(f.l.SwipeViewPager_iconSize, 96);
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

    private String vu(String str) {
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
            this.mTextView.setCompoundDrawablePadding(l.f(getContext(), f.e.ds12));
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
            this.mTextView.setCompoundDrawablePadding(l.f(getContext(), f.e.ds12));
        }
        if (this.hqb < this.mTextView.getWidth() + this.mIconSize) {
            this.hqb = this.mTextView.getWidth() + this.mIconSize;
        }
        this.mParentView.addView(this.mTextView);
        if (this.hqa == 0) {
            this.hqa = this.mWidth;
        }
        if (this.hqi == 0) {
            if (this.hqd != null) {
                this.hqi = (int) ((1.0f - this.hqd.getPageWidth(0)) * this.hqp * this.mWidth);
            } else {
                this.hqi = (int) (0.1f * this.mWidth);
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

    private void bEx() {
        this.hqc = new ValueAnimator();
        this.hqc.setDuration(150L);
        this.hqc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SwipeViewPager.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SwipeViewPager.this.mParentView != null) {
                    SwipeViewPager.this.mParentView.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            }
        });
    }

    public void setFixPercent(float f) {
        this.hqp = f;
        if (this.hqp > 1.0f) {
            this.hqp = 1.0f;
        } else if (this.hqp < 0.0f) {
            this.hqp = 0.0f;
        }
        if (this.hqd != null) {
            this.hqi = (int) ((1.0f - this.hqd.getPageWidth(0)) * this.hqp * this.mWidth);
        } else {
            this.hqi = (int) (0.1f * this.mWidth);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int count;
        if (this.mParentView == null) {
            initial();
        }
        if ((motionEvent.getAction() & 255) == 0 && !this.hqj) {
            this.hqe = motionEvent.getRawX();
            this.hqf = motionEvent.getRawY();
            this.hqh = getScrollX();
            this.hqg = this.mParentView.getScrollX();
        }
        for (ViewParent parent = getParent(); parent != null && !bEz(); parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (this.hqd != null && (count = this.hqd.getCount()) != 0) {
            if (count * this.hqd.getPageWidth(0) < 1.0f) {
                return bEy();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean bEy() {
        if (this.hqd != null) {
            return this.hqd.getCount() <= ((this.hqd.getPageWidth(0) > 0.0f ? 1 : (this.hqd.getPageWidth(0) == 0.0f ? 0 : -1)) > 0 ? (int) (1.0d / ((double) this.hqd.getPageWidth(0))) : 0) + getCurrentItem();
        }
        return false;
    }

    private boolean bEz() {
        return getScrollX() == 0;
    }

    private boolean N(MotionEvent motionEvent) {
        int count;
        if (this.hqd == null || (count = this.hqd.getCount()) == 0) {
            return false;
        }
        if (count * this.hqd.getPageWidth(0) < 1.0f) {
            return bEy();
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.hqq) {
            return N(motionEvent);
        }
        if (motionEvent.getPointerCount() <= 1) {
            if (this.hqc == null || !this.hqc.isRunning()) {
                int action = motionEvent.getAction();
                if (bEz() && (action & 255) == 2 && motionEvent.getRawX() - this.hqe > 0.0f) {
                    return false;
                }
                if (bEy()) {
                    switch (action & 255) {
                        case 1:
                        case 3:
                            if (this.hqj) {
                                O(motionEvent);
                            }
                            bEA();
                            break;
                        case 2:
                            if (P(motionEvent)) {
                                scrollTo((int) this.hqh, 0);
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
    public void bEA() {
        if (bEz()) {
            bT(this.mParentView.getScrollX(), 0);
        } else if (!bEy() && this.mParentView.getScrollX() != (-this.hqi)) {
            bT(this.mParentView.getScrollX(), -this.hqi);
        } else if (bEy() && bEB()) {
            bT(this.mParentView.getScrollX(), this.hqb);
        }
    }

    private boolean bEB() {
        return this.mTextView != null && this.mTextView.getVisibility() == 0;
    }

    private void bT(int i, int i2) {
        if (this.hqc == null) {
            bEx();
        }
        this.hqc.setIntValues(i, i2);
        this.hqc.start();
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
        float rawX = (motionEvent.getRawX() - this.hqe) * 0.5f;
        this.hqj = false;
        if (this.mParentView != null) {
            if (bEB()) {
                bT(this.mParentView.getScrollX(), this.hqb);
            } else {
                bT(this.mParentView.getScrollX(), 0);
            }
        }
        if ((-rawX) > this.hqb && this.hqk != null && !this.hql) {
            this.hql = true;
            this.hqk.b(this, true);
        }
        if (this.hqn != null && this.hqm) {
            this.hqm = false;
            this.hqn.a(this, false);
        }
    }

    public void setTips(String str) {
        if (this.mTextView != null) {
            this.mTextView.setText(vu(str));
        }
    }

    private boolean P(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.hqe;
        if (rawX < 0.0f) {
            float f = (rawX * 0.5f) - this.hqg;
            this.hqj = true;
            if (Math.abs(f) > Math.abs(this.hqa)) {
                return true;
            }
            if (Math.abs(f) > this.hqo && !this.hqm) {
                this.hqm = true;
                if (this.hqn != null) {
                    this.hqn.a(this, true);
                }
            } else if ((-f) < this.hqo && this.hqm) {
                this.hqm = false;
                if (this.hqn != null) {
                    this.hqn.a(this, false);
                }
            }
            if (this.mParentView != null) {
                this.mParentView.scrollTo(-((int) f), 0);
                return true;
            }
            return true;
        } else if (rawX < this.hqb + 20) {
            float f2 = this.hqg - rawX;
            if (this.mParentView != null) {
                this.mParentView.scrollTo((int) f2, 0);
            }
            this.hqj = true;
            return true;
        } else {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.hqd == null) {
            this.hqd = new d(pagerAdapter);
            super.setAdapter(this.hqd);
            return;
        }
        this.hqd.a(pagerAdapter);
        this.hqd.notifyDataSetChanged();
    }

    public void setPagerWidth(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.hqd == null) {
            this.hqd = new d(null);
            super.setAdapter(this.hqd);
        }
        this.hqi = -((int) ((1.0f - this.hqd.getPageWidth(0)) * this.hqp * getWidth()));
        this.hqd.setPagerWidth(f);
        this.hqd.notifyDataSetChanged();
    }

    public void setCanDrag(boolean z) {
        this.hqq = z;
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
            SwipeViewPager.this.bEA();
        }
    }

    public void setOnSwipeListener(c cVar) {
        this.hqk = cVar;
    }

    public void setOnOverDragChanageListener(b bVar) {
        this.hqn = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends PagerAdapter {
        private float hqs = 0.8f;
        private PagerAdapter mAdapter;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(PagerAdapter pagerAdapter) {
            this.mAdapter = pagerAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPagerWidth(float f) {
            this.hqs = f;
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
            return this.hqs;
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
