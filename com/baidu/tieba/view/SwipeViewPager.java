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
    private boolean gXP;
    private int gXQ;
    private int gXR;
    private ValueAnimator gXS;
    private d gXT;
    private float gXU;
    private float gXV;
    private float gXW;
    private float gXX;
    private int gXY;
    private boolean gXZ;
    private c gYa;
    private boolean gYb;
    private boolean gYc;
    private b gYd;
    private int gYe;
    private float gYf;
    private boolean gYg;
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
        this.gXP = false;
        this.gXQ = 0;
        this.gXR = 300;
        this.gXZ = false;
        this.gYa = null;
        this.gYb = false;
        this.gYc = false;
        this.gYf = 0.5f;
        this.gYg = true;
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXP = false;
        this.gXQ = 0;
        this.gXR = 300;
        this.gXZ = false;
        this.gYa = null;
        this.gYb = false;
        this.gYc = false;
        this.gYf = 0.5f;
        this.gYg = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.SwipeViewPager);
            c(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
        bAf();
        setOffscreenPageLimit(3);
        setOverScrollMode(2);
        setClipChildren(false);
        this.gXT = new d(null);
        super.setAdapter(this.gXT);
    }

    private void c(TypedArray typedArray) {
        this.gYf = typedArray.getFloat(d.m.SwipeViewPager_leftItemPercent, 0.5f);
        if (this.gYf > 1.0f) {
            this.gYf = 1.0f;
        } else if (this.gYf < 0.0f) {
            this.gYf = 0.0f;
        }
        this.mTextView = new TextView(getContext());
        String string = typedArray.getString(d.m.SwipeViewPager_tips);
        this.mTextView.setText(uw((string == null || string.length() < 1) ? "滑动显示全部信息" : "滑动显示全部信息"));
        this.mTextView.setTextSize(typedArray.getDimensionPixelSize(d.m.SwipeViewPager_svp_textSize, 20));
        this.mTextView.setPadding(typedArray.getDimensionPixelSize(d.m.SwipeViewPager_tipsPaddingLeft, 50), 0, 0, 0);
        this.mTextView.setTextColor(typedArray.getColor(d.m.SwipeViewPager_svp_textColor, Color.parseColor("#565656")));
        this.mTextView.setBackgroundColor(typedArray.getColor(d.m.SwipeViewPager_tipsBackground, Color.parseColor("#00000000")));
        this.gXR = typedArray.getDimensionPixelSize(d.m.SwipeViewPager_tipsWidth, 300);
        this.gYe = (int) (this.gXR * 1.5f);
        this.gXQ = typedArray.getDimensionPixelSize(d.m.SwipeViewPager_maxSwipeWidth, 0);
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
        if (this.gXR < this.mTextView.getWidth() + this.mIconSize) {
            this.gXR = this.mTextView.getWidth() + this.mIconSize;
        }
        this.mParentView.addView(this.mTextView);
        if (this.gXQ == 0) {
            this.gXQ = this.mWidth;
        }
        if (this.gXY == 0) {
            if (this.gXT != null) {
                this.gXY = (int) ((1.0f - this.gXT.getPageWidth(0)) * this.gYf * this.mWidth);
            } else {
                this.gXY = (int) (0.1f * this.mWidth);
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
        this.gXS = new ValueAnimator();
        this.gXS.setDuration(150L);
        this.gXS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SwipeViewPager.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SwipeViewPager.this.mParentView != null) {
                    SwipeViewPager.this.mParentView.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            }
        });
    }

    public void setFixPercent(float f) {
        this.gYf = f;
        if (this.gYf > 1.0f) {
            this.gYf = 1.0f;
        } else if (this.gYf < 0.0f) {
            this.gYf = 0.0f;
        }
        if (this.gXT != null) {
            this.gXY = (int) ((1.0f - this.gXT.getPageWidth(0)) * this.gYf * this.mWidth);
        } else {
            this.gXY = (int) (0.1f * this.mWidth);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int count;
        if (this.mParentView == null) {
            initial();
        }
        if ((motionEvent.getAction() & 255) == 0 && !this.gXZ) {
            this.gXU = motionEvent.getRawX();
            this.gXV = motionEvent.getRawY();
            this.gXX = getScrollX();
            this.gXW = this.mParentView.getScrollX();
        }
        for (ViewParent parent = getParent(); parent != null && !bAh(); parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (this.gXT != null && (count = this.gXT.getCount()) != 0) {
            if (count * this.gXT.getPageWidth(0) < 1.0f) {
                return bAg();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean bAg() {
        if (this.gXT != null) {
            return this.gXT.getCount() <= ((this.gXT.getPageWidth(0) > 0.0f ? 1 : (this.gXT.getPageWidth(0) == 0.0f ? 0 : -1)) > 0 ? (int) (1.0d / ((double) this.gXT.getPageWidth(0))) : 0) + getCurrentItem();
        }
        return false;
    }

    private boolean bAh() {
        return getScrollX() == 0;
    }

    private boolean M(MotionEvent motionEvent) {
        int count;
        if (this.gXT == null || (count = this.gXT.getCount()) == 0) {
            return false;
        }
        if (count * this.gXT.getPageWidth(0) < 1.0f) {
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
        if (!this.gYg) {
            return M(motionEvent);
        }
        if (motionEvent.getPointerCount() <= 1) {
            if (this.gXS == null || !this.gXS.isRunning()) {
                int action = motionEvent.getAction();
                if (bAh() && (action & 255) == 2 && motionEvent.getRawX() - this.gXU > 0.0f) {
                    return false;
                }
                if (bAg()) {
                    switch (action & 255) {
                        case 1:
                        case 3:
                            if (this.gXZ) {
                                N(motionEvent);
                            }
                            bAi();
                            break;
                        case 2:
                            if (O(motionEvent)) {
                                scrollTo((int) this.gXX, 0);
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
            bS(this.mParentView.getScrollX(), 0);
        } else if (!bAg() && this.mParentView.getScrollX() != (-this.gXY)) {
            bS(this.mParentView.getScrollX(), -this.gXY);
        } else if (bAg() && bAj()) {
            bS(this.mParentView.getScrollX(), this.gXR);
        }
    }

    private boolean bAj() {
        return this.mTextView != null && this.mTextView.getVisibility() == 0;
    }

    private void bS(int i, int i2) {
        if (this.gXS == null) {
            bAf();
        }
        this.gXS.setIntValues(i, i2);
        this.gXS.start();
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
        float rawX = (motionEvent.getRawX() - this.gXU) * 0.5f;
        this.gXZ = false;
        if (this.mParentView != null) {
            if (bAj()) {
                bS(this.mParentView.getScrollX(), this.gXR);
            } else {
                bS(this.mParentView.getScrollX(), 0);
            }
        }
        if ((-rawX) > this.gXR && this.gYa != null && !this.gYb) {
            this.gYb = true;
            this.gYa.b(this, true);
        }
        if (this.gYd != null && this.gYc) {
            this.gYc = false;
            this.gYd.a(this, false);
        }
    }

    public void setTips(String str) {
        if (this.mTextView != null) {
            this.mTextView.setText(uw(str));
        }
    }

    private boolean O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.gXU;
        if (rawX < 0.0f) {
            float f = (rawX * 0.5f) - this.gXW;
            this.gXZ = true;
            if (Math.abs(f) > Math.abs(this.gXQ)) {
                return true;
            }
            if (Math.abs(f) > this.gYe && !this.gYc) {
                this.gYc = true;
                if (this.gYd != null) {
                    this.gYd.a(this, true);
                }
            } else if ((-f) < this.gYe && this.gYc) {
                this.gYc = false;
                if (this.gYd != null) {
                    this.gYd.a(this, false);
                }
            }
            if (this.mParentView != null) {
                this.mParentView.scrollTo(-((int) f), 0);
                return true;
            }
            return true;
        } else if (rawX < this.gXR + 20) {
            float f2 = this.gXW - rawX;
            if (this.mParentView != null) {
                this.mParentView.scrollTo((int) f2, 0);
            }
            this.gXZ = true;
            return true;
        } else {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.gXT == null) {
            this.gXT = new d(pagerAdapter);
            super.setAdapter(this.gXT);
            return;
        }
        this.gXT.a(pagerAdapter);
        this.gXT.notifyDataSetChanged();
    }

    public void setPagerWidth(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.gXT == null) {
            this.gXT = new d(null);
            super.setAdapter(this.gXT);
        }
        this.gXY = -((int) ((1.0f - this.gXT.getPageWidth(0)) * this.gYf * getWidth()));
        this.gXT.setPagerWidth(f);
        this.gXT.notifyDataSetChanged();
    }

    public void setCanDrag(boolean z) {
        this.gYg = z;
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
        this.gYa = cVar;
    }

    public void setOnOverDragChanageListener(b bVar) {
        this.gYd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends PagerAdapter {
        private float gYi = 0.8f;
        private PagerAdapter mAdapter;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(PagerAdapter pagerAdapter) {
            this.mAdapter = pagerAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPagerWidth(float f) {
            this.gYi = f;
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
            return this.gYi;
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
