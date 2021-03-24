package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
/* loaded from: classes5.dex */
public class PinnedSectionListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public AbsListView.OnScrollListener f24094a;

    /* renamed from: b  reason: collision with root package name */
    public a f24095b;

    /* renamed from: c  reason: collision with root package name */
    public a f24096c;

    /* renamed from: d  reason: collision with root package name */
    public int f24097d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f24098e;

    /* renamed from: f  reason: collision with root package name */
    public final PointF f24099f;

    /* renamed from: g  reason: collision with root package name */
    public int f24100g;

    /* renamed from: h  reason: collision with root package name */
    public View f24101h;
    public MotionEvent i;
    public int j;
    public final AbsListView.OnScrollListener k;
    public final DataSetObserver l;

    /* loaded from: classes5.dex */
    public interface PinnedSectionListAdapter extends ListAdapter {
        boolean isItemViewTypePinned(int i);
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f24105a;

        /* renamed from: b  reason: collision with root package name */
        public int f24106b;

        /* renamed from: c  reason: collision with root package name */
        public long f24107c;
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24098e = new Rect();
        this.f24099f = new PointF();
        this.k = new AbsListView.OnScrollListener() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24094a;
                if (onScrollListener != null) {
                    onScrollListener.onScroll(absListView, i, i2, i3);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i2 == 0) {
                    return;
                }
                if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i))) {
                    if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                        PinnedSectionListView.this.a();
                        return;
                    } else {
                        PinnedSectionListView.this.a(i, i, i2);
                        return;
                    }
                }
                int b2 = PinnedSectionListView.this.b(i);
                if (b2 > -1) {
                    PinnedSectionListView.this.a(b2, i, i2);
                } else {
                    PinnedSectionListView.this.a();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24094a;
                if (onScrollListener != null) {
                    onScrollListener.onScrollStateChanged(absListView, i);
                }
            }
        };
        this.l = new DataSetObserver() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                PinnedSectionListView.this.b();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                PinnedSectionListView.this.b();
            }
        };
        c();
    }

    private void c() {
        setOnScrollListener(this.k);
        this.f24100g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void d() {
        this.f24101h = null;
        MotionEvent motionEvent = this.i;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.i = null;
        }
    }

    private boolean e() {
        AdapterView.OnItemClickListener onItemClickListener;
        if (this.f24096c == null || (onItemClickListener = getOnItemClickListener()) == null || !getAdapter().isEnabled(this.f24096c.f24106b)) {
            return false;
        }
        View view = this.f24096c.f24105a;
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        a aVar = this.f24096c;
        onItemClickListener.onItemClick(this, view, aVar.f24106b, aVar.f24107c);
        return true;
    }

    public static boolean isItemViewTypePinned(ListAdapter listAdapter, int i) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return ((PinnedSectionListAdapter) listAdapter).isItemViewTypePinned(i);
    }

    public void a(int i) {
        a aVar = this.f24095b;
        this.f24095b = null;
        if (aVar == null) {
            aVar = new a();
        }
        View view = getAdapter().getView(i, aVar.f24105a, this);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        int mode = View.MeasureSpec.getMode(layoutParams.height);
        int size = View.MeasureSpec.getSize(layoutParams.height);
        if (mode == 0) {
            mode = 1073741824;
        }
        int height = (getHeight() - getListPaddingTop()) - getListPaddingBottom();
        if (size > height) {
            size = height;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getWidth() - getListPaddingLeft()) - getListPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(size, mode));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.f24097d = 0;
        aVar.f24105a = view;
        aVar.f24106b = i;
        aVar.f24107c = getAdapter().getItemId(i);
        this.f24096c = aVar;
    }

    public int b(int i) {
        ListAdapter adapter = getAdapter();
        if (i >= adapter.getCount()) {
            return -1;
        }
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            int positionForSection = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i));
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(positionForSection))) {
                return positionForSection;
            }
        }
        while (i >= 0) {
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f24096c != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.f24096c.f24105a;
            canvas.save();
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + listPaddingTop);
            canvas.translate(listPaddingLeft, listPaddingTop + this.f24097d);
            drawChild(canvas, this.f24096c.f24105a, getDrawingTime());
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0 && this.f24101h == null && (aVar = this.f24096c) != null && a(aVar.f24105a, x, y)) {
            this.f24101h = this.f24096c.f24105a;
            PointF pointF = this.f24099f;
            pointF.x = x;
            pointF.y = y;
            this.i = MotionEvent.obtain(motionEvent);
        }
        View view = this.f24101h;
        if (view != null) {
            if (a(view, x, y)) {
                this.f24101h.dispatchTouchEvent(motionEvent);
            }
            if (action == 1) {
                super.dispatchTouchEvent(motionEvent);
                e();
                d();
            } else if (action == 3) {
                d();
            } else if (action == 2 && Math.abs(y - this.f24099f.y) > this.f24100g) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                this.f24101h.dispatchTouchEvent(obtain);
                obtain.recycle();
                super.dispatchTouchEvent(this.i);
                super.dispatchTouchEvent(motionEvent);
                d();
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f24096c == null || ((i3 - i) - getPaddingLeft()) - getPaddingRight() == this.f24096c.f24105a.getWidth()) {
            return;
        }
        b();
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        post(new Runnable() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.3
            @Override // java.lang.Runnable
            public void run() {
                PinnedSectionListView.this.b();
            }
        });
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        if (onScrollListener == this.k) {
            super.setOnScrollListener(onScrollListener);
        } else {
            this.f24094a = onScrollListener;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter == null || !(listAdapter instanceof PinnedSectionListAdapter) || listAdapter.getViewTypeCount() < 2) {
            return;
        }
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterDataSetObserver(this.l);
        }
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.l);
        }
        if (adapter != listAdapter) {
            a();
        }
        super.setAdapter(listAdapter);
    }

    public PinnedSectionListView(Context context) {
        super(context);
        this.f24098e = new Rect();
        this.f24099f = new PointF();
        this.k = new AbsListView.OnScrollListener() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24094a;
                if (onScrollListener != null) {
                    onScrollListener.onScroll(absListView, i, i2, i3);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i2 == 0) {
                    return;
                }
                if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i))) {
                    if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                        PinnedSectionListView.this.a();
                        return;
                    } else {
                        PinnedSectionListView.this.a(i, i, i2);
                        return;
                    }
                }
                int b2 = PinnedSectionListView.this.b(i);
                if (b2 > -1) {
                    PinnedSectionListView.this.a(b2, i, i2);
                } else {
                    PinnedSectionListView.this.a();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24094a;
                if (onScrollListener != null) {
                    onScrollListener.onScrollStateChanged(absListView, i);
                }
            }
        };
        this.l = new DataSetObserver() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                PinnedSectionListView.this.b();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                PinnedSectionListView.this.b();
            }
        };
        c();
    }

    public void b() {
        int firstVisiblePosition;
        int b2;
        a();
        ListAdapter adapter = getAdapter();
        if (adapter == null || adapter.getCount() <= 0 || (b2 = b((firstVisiblePosition = getFirstVisiblePosition()))) == -1) {
            return;
        }
        a(b2, firstVisiblePosition, getLastVisiblePosition() - firstVisiblePosition);
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24098e = new Rect();
        this.f24099f = new PointF();
        this.k = new AbsListView.OnScrollListener() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24094a;
                if (onScrollListener != null) {
                    onScrollListener.onScroll(absListView, i2, i22, i3);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i22 == 0) {
                    return;
                }
                if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i2))) {
                    if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                        PinnedSectionListView.this.a();
                        return;
                    } else {
                        PinnedSectionListView.this.a(i2, i2, i22);
                        return;
                    }
                }
                int b2 = PinnedSectionListView.this.b(i2);
                if (b2 > -1) {
                    PinnedSectionListView.this.a(b2, i2, i22);
                } else {
                    PinnedSectionListView.this.a();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24094a;
                if (onScrollListener != null) {
                    onScrollListener.onScrollStateChanged(absListView, i2);
                }
            }
        };
        this.l = new DataSetObserver() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                PinnedSectionListView.this.b();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                PinnedSectionListView.this.b();
            }
        };
        c();
    }

    public void a() {
        a aVar = this.f24096c;
        if (aVar != null) {
            this.f24095b = aVar;
            this.f24096c = null;
        }
    }

    public void a(int i, int i2, int i3) {
        if (i3 < 2) {
            a();
            return;
        }
        a aVar = this.f24096c;
        if (aVar != null && aVar.f24106b != i) {
            a();
        }
        if (this.f24096c == null) {
            a(i);
        }
        int i4 = i + 1;
        if (i4 < getCount()) {
            int a2 = a(i4, i3 - (i4 - i2));
            if (a2 > -1) {
                int top = getChildAt(a2 - i2).getTop() - (this.f24096c.f24105a.getBottom() + getPaddingTop());
                this.j = top;
                if (top < 0) {
                    this.f24097d = top;
                    return;
                } else {
                    this.f24097d = 0;
                    return;
                }
            }
            this.f24097d = 0;
            this.j = Integer.MAX_VALUE;
        }
    }

    public int a(int i, int i2) {
        ListAdapter adapter = getAdapter();
        int count = adapter.getCount();
        if (getLastVisiblePosition() >= count) {
            return -1;
        }
        if (i + i2 >= count) {
            i2 = count - i;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i4))) {
                return i4;
            }
        }
        return -1;
    }

    private boolean a(View view, float f2, float f3) {
        view.getHitRect(this.f24098e);
        Rect rect = this.f24098e;
        int i = rect.top;
        int i2 = this.f24097d;
        rect.top = i + i2;
        rect.bottom += i2 + getPaddingTop();
        this.f24098e.left += getPaddingLeft();
        this.f24098e.right -= getPaddingRight();
        return this.f24098e.contains((int) f2, (int) f3);
    }
}
