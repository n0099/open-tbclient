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
    private boolean hkL;
    private int hkM;
    private int hkN;
    private ValueAnimator hkO;
    private d hkP;
    private float hkQ;
    private float hkR;
    private float hkS;
    private float hkT;
    private int hkU;
    private boolean hkV;
    private c hkW;
    private boolean hkX;
    private boolean hkY;
    private b hkZ;
    private int hla;
    private float hlb;
    private boolean hlc;
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
        this.hkL = false;
        this.hkM = 0;
        this.hkN = 300;
        this.hkV = false;
        this.hkW = null;
        this.hkX = false;
        this.hkY = false;
        this.hlb = 0.5f;
        this.hlc = true;
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkL = false;
        this.hkM = 0;
        this.hkN = 300;
        this.hkV = false;
        this.hkW = null;
        this.hkX = false;
        this.hkY = false;
        this.hlb = 0.5f;
        this.hlc = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.SwipeViewPager);
            c(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
        bFk();
        setOffscreenPageLimit(3);
        setOverScrollMode(2);
        setClipChildren(false);
        this.hkP = new d(null);
        super.setAdapter(this.hkP);
    }

    private void c(TypedArray typedArray) {
        this.hlb = typedArray.getFloat(d.m.SwipeViewPager_leftItemPercent, 0.5f);
        if (this.hlb > 1.0f) {
            this.hlb = 1.0f;
        } else if (this.hlb < 0.0f) {
            this.hlb = 0.0f;
        }
        this.mTextView = new TextView(getContext());
        String string = typedArray.getString(d.m.SwipeViewPager_tips);
        this.mTextView.setText(vt((string == null || string.length() < 1) ? "滑动显示全部信息" : "滑动显示全部信息"));
        this.mTextView.setTextSize(typedArray.getDimensionPixelSize(d.m.SwipeViewPager_svp_textSize, 20));
        this.mTextView.setPadding(typedArray.getDimensionPixelSize(d.m.SwipeViewPager_tipsPaddingLeft, 50), 0, 0, 0);
        this.mTextView.setTextColor(typedArray.getColor(d.m.SwipeViewPager_svp_textColor, Color.parseColor("#565656")));
        this.mTextView.setBackgroundColor(typedArray.getColor(d.m.SwipeViewPager_tipsBackground, Color.parseColor("#00000000")));
        this.hkN = typedArray.getDimensionPixelSize(d.m.SwipeViewPager_tipsWidth, 300);
        this.hla = (int) (this.hkN * 1.5f);
        this.hkM = typedArray.getDimensionPixelSize(d.m.SwipeViewPager_maxSwipeWidth, 0);
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

    private String vt(String str) {
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
        if (this.hkN < this.mTextView.getWidth() + this.mIconSize) {
            this.hkN = this.mTextView.getWidth() + this.mIconSize;
        }
        this.mParentView.addView(this.mTextView);
        if (this.hkM == 0) {
            this.hkM = this.mWidth;
        }
        if (this.hkU == 0) {
            if (this.hkP != null) {
                this.hkU = (int) ((1.0f - this.hkP.getPageWidth(0)) * this.hlb * this.mWidth);
            } else {
                this.hkU = (int) (0.1f * this.mWidth);
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

    private void bFk() {
        this.hkO = new ValueAnimator();
        this.hkO.setDuration(150L);
        this.hkO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SwipeViewPager.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SwipeViewPager.this.mParentView != null) {
                    SwipeViewPager.this.mParentView.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            }
        });
    }

    public void setFixPercent(float f) {
        this.hlb = f;
        if (this.hlb > 1.0f) {
            this.hlb = 1.0f;
        } else if (this.hlb < 0.0f) {
            this.hlb = 0.0f;
        }
        if (this.hkP != null) {
            this.hkU = (int) ((1.0f - this.hkP.getPageWidth(0)) * this.hlb * this.mWidth);
        } else {
            this.hkU = (int) (0.1f * this.mWidth);
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int count;
        if (this.mParentView == null) {
            initial();
        }
        if ((motionEvent.getAction() & 255) == 0 && !this.hkV) {
            this.hkQ = motionEvent.getRawX();
            this.hkR = motionEvent.getRawY();
            this.hkT = getScrollX();
            this.hkS = this.mParentView.getScrollX();
        }
        for (ViewParent parent = getParent(); parent != null && !bFm(); parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        if (this.hkP != null && (count = this.hkP.getCount()) != 0) {
            if (count * this.hkP.getPageWidth(0) < 1.0f) {
                return bFl();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean bFl() {
        if (this.hkP != null) {
            return this.hkP.getCount() <= ((this.hkP.getPageWidth(0) > 0.0f ? 1 : (this.hkP.getPageWidth(0) == 0.0f ? 0 : -1)) > 0 ? (int) (1.0d / ((double) this.hkP.getPageWidth(0))) : 0) + getCurrentItem();
        }
        return false;
    }

    private boolean bFm() {
        return getScrollX() == 0;
    }

    private boolean N(MotionEvent motionEvent) {
        int count;
        if (this.hkP == null || (count = this.hkP.getCount()) == 0) {
            return false;
        }
        if (count * this.hkP.getPageWidth(0) < 1.0f) {
            return bFl();
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.hlc) {
            return N(motionEvent);
        }
        if (motionEvent.getPointerCount() <= 1) {
            if (this.hkO == null || !this.hkO.isRunning()) {
                int action = motionEvent.getAction();
                if (bFm() && (action & 255) == 2 && motionEvent.getRawX() - this.hkQ > 0.0f) {
                    return false;
                }
                if (bFl()) {
                    switch (action & 255) {
                        case 1:
                        case 3:
                            if (this.hkV) {
                                O(motionEvent);
                            }
                            bFn();
                            break;
                        case 2:
                            if (P(motionEvent)) {
                                scrollTo((int) this.hkT, 0);
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
    public void bFn() {
        if (bFm()) {
            bT(this.mParentView.getScrollX(), 0);
        } else if (!bFl() && this.mParentView.getScrollX() != (-this.hkU)) {
            bT(this.mParentView.getScrollX(), -this.hkU);
        } else if (bFl() && bFo()) {
            bT(this.mParentView.getScrollX(), this.hkN);
        }
    }

    private boolean bFo() {
        return this.mTextView != null && this.mTextView.getVisibility() == 0;
    }

    private void bT(int i, int i2) {
        if (this.hkO == null) {
            bFk();
        }
        this.hkO.setIntValues(i, i2);
        this.hkO.start();
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
        float rawX = (motionEvent.getRawX() - this.hkQ) * 0.5f;
        this.hkV = false;
        if (this.mParentView != null) {
            if (bFo()) {
                bT(this.mParentView.getScrollX(), this.hkN);
            } else {
                bT(this.mParentView.getScrollX(), 0);
            }
        }
        if ((-rawX) > this.hkN && this.hkW != null && !this.hkX) {
            this.hkX = true;
            this.hkW.b(this, true);
        }
        if (this.hkZ != null && this.hkY) {
            this.hkY = false;
            this.hkZ.a(this, false);
        }
    }

    public void setTips(String str) {
        if (this.mTextView != null) {
            this.mTextView.setText(vt(str));
        }
    }

    private boolean P(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.hkQ;
        if (rawX < 0.0f) {
            float f = (rawX * 0.5f) - this.hkS;
            this.hkV = true;
            if (Math.abs(f) > Math.abs(this.hkM)) {
                return true;
            }
            if (Math.abs(f) > this.hla && !this.hkY) {
                this.hkY = true;
                if (this.hkZ != null) {
                    this.hkZ.a(this, true);
                }
            } else if ((-f) < this.hla && this.hkY) {
                this.hkY = false;
                if (this.hkZ != null) {
                    this.hkZ.a(this, false);
                }
            }
            if (this.mParentView != null) {
                this.mParentView.scrollTo(-((int) f), 0);
                return true;
            }
            return true;
        } else if (rawX < this.hkN + 20) {
            float f2 = this.hkS - rawX;
            if (this.mParentView != null) {
                this.mParentView.scrollTo((int) f2, 0);
            }
            this.hkV = true;
            return true;
        } else {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.hkP == null) {
            this.hkP = new d(pagerAdapter);
            super.setAdapter(this.hkP);
            return;
        }
        this.hkP.a(pagerAdapter);
        this.hkP.notifyDataSetChanged();
    }

    public void setPagerWidth(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.hkP == null) {
            this.hkP = new d(null);
            super.setAdapter(this.hkP);
        }
        this.hkU = -((int) ((1.0f - this.hkP.getPageWidth(0)) * this.hlb * getWidth()));
        this.hkP.setPagerWidth(f);
        this.hkP.notifyDataSetChanged();
    }

    public void setCanDrag(boolean z) {
        this.hlc = z;
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
            SwipeViewPager.this.bFn();
        }
    }

    public void setOnSwipeListener(c cVar) {
        this.hkW = cVar;
    }

    public void setOnOverDragChanageListener(b bVar) {
        this.hkZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends PagerAdapter {
        private float hle = 0.8f;
        private PagerAdapter mAdapter;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(PagerAdapter pagerAdapter) {
            this.mAdapter = pagerAdapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPagerWidth(float f) {
            this.hle = f;
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
            return this.hle;
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
