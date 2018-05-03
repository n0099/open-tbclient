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
    private boolean gXM;
    private int gXN;
    private int gXO;
    private ValueAnimator gXP;
    private d gXQ;
    private float gXR;
    private float gXS;
    private float gXT;
    private float gXU;
    private int gXV;
    private boolean gXW;
    private c gXX;
    private boolean gXY;
    private boolean gXZ;
    private b gYa;
    private int gYb;
    private float gYc;
    private boolean gYd;
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
        this.gXM = false;
        this.gXN = 0;
        this.gXO = 300;
        this.gXW = false;
        this.gXX = null;
        this.gXY = false;
        this.gXZ = false;
        this.gYc = 0.5f;
        this.gYd = true;
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXM = false;
        this.gXN = 0;
        this.gXO = 300;
        this.gXW = false;
        this.gXX = null;
        this.gXY = false;
        this.gXZ = false;
        this.gYc = 0.5f;
        this.gYd = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.SwipeViewPager);
            c(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
        bAf();
        setOffscreenPageLimit(3);
        setOverScrollMode(2);
        setClipChildren(false);
        this.gXQ = new d(null);
        super.setAdapter(this.gXQ);
    }

    private void c(TypedArray typedArray) {
        this.gYc = typedArray.getFloat(d.m.SwipeViewPager_leftItemPercent, 0.5f);
        if (this.gYc > 1.0f) {
            this.gYc = 1.0f;
        } else if (this.gYc < 0.0f) {
            this.gYc = 0.0f;
        }
        this.mTextView = new TextView(getContext());
        String string = typedArray.getString(d.m.SwipeViewPager_tips);
        this.mTextView.setText(uw((string == null || string.length() < 1) ? "滑动显示全部信息" : "滑动显示全部信息"));
        this.mTextView.setTextSize(typedArray.getDimensionPixelSize(d.m.SwipeViewPager_svp_textSize, 20));
        this.mTextView.setPadding(typedArray.getDimensionPixelSize(d.m.SwipeViewPager_tipsPaddingLeft, 50), 0, 0, 0);
        this.mTextView.setTextColor(typedArray.getColor(d.m.SwipeViewPager_svp_textColor, Color.parseColor("#565656")));
        this.mTextView.setBackgroundColor(typedArray.getColor(d.m.SwipeViewPager_tipsBackground, Color.parseColor("#00000000")));
        this.gXO = typedArray.getDimensionPixelSize(d.m.SwipeViewPager_tipsWidth, 300);
        this.gYb = (int) (this.gXO * 1.5f);
        this.gXN = typedArray.getDimensionPixelSize(d.m.SwipeViewPager_maxSwipeWidth, 0);
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
            public boolean onTouch(View view2, MotionEvent motionEvent) {
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

    private String uw(String str) {
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
        if (this.gXO < this.mTextView.getWidth() + this.mIconSize) {
            this.gXO = this.mTextView.getWidth() + this.mIconSize;
        }
        this.mParentView.addView(this.mTextView);
        if (this.gXN == 0) {
            this.gXN = this.mWidth;
        }
        if (this.gXV == 0) {
            if (this.gXQ != null) {
                this.gXV = (int) ((1.0f - this.gXQ.getPageWidth(0)) * this.gYc * this.mWidth);
            } else {
                this.gXV = (int) (0.1f * this.mWidth);
            }
        }
        this.mTextView.setX(this.mParentView.getWidth());
        setOnPageChangeListener(new a());
        this.mParentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.view.SwipeViewPager.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
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

    private void bAf() {
        this.gXP = new ValueAnimator();
        this.gXP.setDuration(150L);
        this.gXP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SwipeViewPager.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SwipeViewPager.this.mParentView != null) {
                    SwipeViewPager.this.mParentView.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            }
        });
    }

    public void setFixPercent(float f) {
        this.gYc = f;
        if (this.gYc > 1.0f) {
            this.gYc = 1.0f;
        } else if (this.gYc < 0.0f) {
            this.gYc = 0.0f;
        }
        if (this.gXQ != null) {
            this.gXV = (int) ((1.0f - this.gXQ.getPageWidth(0)) * this.gYc * this.mWidth);
        } else {
            this.gXV = (int) (0.1f * this.mWidth);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int count;
        if (this.mParentView == null) {
            initial();
        }
        if ((motionEvent.getAction() & 255) == 0 && !this.gXW) {
            this.gXR = motionEvent.getRawX();
            this.gXS = motionEvent.getRawY();
            this.gXU = getScrollX();
            this.gXT = this.mParentView.getScrollX();
        }
        for (ViewParent parent = getParent(); parent != null && !bAh(); parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (this.gXQ != null && (count = this.gXQ.getCount()) != 0) {
            if (count * this.gXQ.getPageWidth(0) < 1.0f) {
                return bAg();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean bAg() {
        if (this.gXQ != null) {
            return this.gXQ.getCount() <= ((this.gXQ.getPageWidth(0) > 0.0f ? 1 : (this.gXQ.getPageWidth(0) == 0.0f ? 0 : -1)) > 0 ? (int) (1.0d / ((double) this.gXQ.getPageWidth(0))) : 0) + getCurrentItem();
        }
        return false;
    }

    private boolean bAh() {
        return getScrollX() == 0;
    }

    private boolean M(MotionEvent motionEvent) {
        int count;
        if (this.gXQ == null || (count = this.gXQ.getCount()) == 0) {
            return false;
        }
        if (count * this.gXQ.getPageWidth(0) < 1.0f) {
            return bAg();
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.gYd) {
            return M(motionEvent);
        }
        if (motionEvent.getPointerCount() <= 1) {
            if (this.gXP == null || !this.gXP.isRunning()) {
                int action = motionEvent.getAction();
                if (bAh() && (action & 255) == 2 && motionEvent.getRawX() - this.gXR > 0.0f) {
                    return false;
                }
                if (bAg()) {
                    switch (action & 255) {
                        case 1:
                        case 3:
                            if (this.gXW) {
                                N(motionEvent);
                            }
                            bAi();
                            break;
                        case 2:
                            if (O(motionEvent)) {
                                scrollTo((int) this.gXU, 0);
                                return true;
                            }
                            break;
                    }
                }
                return M(motionEvent);
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAi() {
        if (bAh()) {
            bR(this.mParentView.getScrollX(), 0);
        } else if (!bAg() && this.mParentView.getScrollX() != (-this.gXV)) {
            bR(this.mParentView.getScrollX(), -this.gXV);
        } else if (bAg() && bAj()) {
            bR(this.mParentView.getScrollX(), this.gXO);
        }
    }

    private boolean bAj() {
        return this.mTextView != null && this.mTextView.getVisibility() == 0;
    }

    private void bR(int i, int i2) {
        if (this.gXP == null) {
            bAf();
        }
        this.gXP.setIntValues(i, i2);
        this.gXP.start();
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

    private void N(MotionEvent motionEvent) {
        float rawX = (motionEvent.getRawX() - this.gXR) * 0.5f;
        this.gXW = false;
        if (this.mParentView != null) {
            if (bAj()) {
                bR(this.mParentView.getScrollX(), this.gXO);
            } else {
                bR(this.mParentView.getScrollX(), 0);
            }
        }
        if ((-rawX) > this.gXO && this.gXX != null && !this.gXY) {
            this.gXY = true;
            this.gXX.b(this, true);
        }
        if (this.gYa != null && this.gXZ) {
            this.gXZ = false;
            this.gYa.a(this, false);
        }
    }

    public void setTips(String str) {
        if (this.mTextView != null) {
            this.mTextView.setText(uw(str));
        }
    }

    private boolean O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.gXR;
        if (rawX < 0.0f) {
            float f = (rawX * 0.5f) - this.gXT;
            this.gXW = true;
            if (Math.abs(f) > Math.abs(this.gXN)) {
                return true;
            }
            if (Math.abs(f) > this.gYb && !this.gXZ) {
                this.gXZ = true;
                if (this.gYa != null) {
                    this.gYa.a(this, true);
                }
            } else if ((-f) < this.gYb && this.gXZ) {
                this.gXZ = false;
                if (this.gYa != null) {
                    this.gYa.a(this, false);
                }
            }
            if (this.mParentView != null) {
                this.mParentView.scrollTo(-((int) f), 0);
                return true;
            }
            return true;
        } else if (rawX < this.gXO + 20) {
            float f2 = this.gXT - rawX;
            if (this.mParentView != null) {
                this.mParentView.scrollTo((int) f2, 0);
            }
            this.gXW = true;
            return true;
        } else {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.gXQ == null) {
            this.gXQ = new d(pagerAdapter);
            super.setAdapter(this.gXQ);
            return;
        }
        this.gXQ.a(pagerAdapter);
        this.gXQ.notifyDataSetChanged();
    }

    public void setPagerWidth(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.gXQ == null) {
            this.gXQ = new d(null);
            super.setAdapter(this.gXQ);
        }
        this.gXV = -((int) ((1.0f - this.gXQ.getPageWidth(0)) * this.gYc * getWidth()));
        this.gXQ.setPagerWidth(f);
        this.gXQ.notifyDataSetChanged();
    }

    public void setCanDrag(boolean z) {
        this.gYd = z;
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
            SwipeViewPager.this.bAi();
        }
    }

    public void setOnSwipeListener(c cVar) {
        this.gXX = cVar;
    }

    public void setOnOverDragChanageListener(b bVar) {
        this.gYa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends PagerAdapter {
        private float gYf = 0.8f;
        private PagerAdapter mAdapter;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(PagerAdapter pagerAdapter) {
            this.mAdapter = pagerAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPagerWidth(float f) {
            this.gYf = f;
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
        public boolean isViewFromObject(View view2, Object obj) {
            return this.mAdapter != null && this.mAdapter.isViewFromObject(view2, obj);
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
            return this.gYf;
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
