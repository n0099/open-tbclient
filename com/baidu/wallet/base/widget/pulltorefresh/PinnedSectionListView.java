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
    public AbsListView.OnScrollListener f24527a;

    /* renamed from: b  reason: collision with root package name */
    public a f24528b;

    /* renamed from: c  reason: collision with root package name */
    public a f24529c;

    /* renamed from: d  reason: collision with root package name */
    public int f24530d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f24531e;

    /* renamed from: f  reason: collision with root package name */
    public final PointF f24532f;

    /* renamed from: g  reason: collision with root package name */
    public int f24533g;

    /* renamed from: h  reason: collision with root package name */
    public View f24534h;

    /* renamed from: i  reason: collision with root package name */
    public MotionEvent f24535i;
    public int j;
    public final AbsListView.OnScrollListener k;
    public final DataSetObserver l;

    /* loaded from: classes5.dex */
    public interface PinnedSectionListAdapter extends ListAdapter {
        boolean isItemViewTypePinned(int i2);
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f24539a;

        /* renamed from: b  reason: collision with root package name */
        public int f24540b;

        /* renamed from: c  reason: collision with root package name */
        public long f24541c;
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24531e = new Rect();
        this.f24532f = new PointF();
        this.k = new AbsListView.OnScrollListener() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24527a;
                if (onScrollListener != null) {
                    onScrollListener.onScroll(absListView, i2, i3, i4);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i3 == 0) {
                    return;
                }
                if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i2))) {
                    if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                        PinnedSectionListView.this.a();
                        return;
                    } else {
                        PinnedSectionListView.this.a(i2, i2, i3);
                        return;
                    }
                }
                int b2 = PinnedSectionListView.this.b(i2);
                if (b2 > -1) {
                    PinnedSectionListView.this.a(b2, i2, i3);
                } else {
                    PinnedSectionListView.this.a();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24527a;
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

    private void c() {
        setOnScrollListener(this.k);
        this.f24533g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void d() {
        this.f24534h = null;
        MotionEvent motionEvent = this.f24535i;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f24535i = null;
        }
    }

    private boolean e() {
        AdapterView.OnItemClickListener onItemClickListener;
        if (this.f24529c == null || (onItemClickListener = getOnItemClickListener()) == null || !getAdapter().isEnabled(this.f24529c.f24540b)) {
            return false;
        }
        View view = this.f24529c.f24539a;
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        a aVar = this.f24529c;
        onItemClickListener.onItemClick(this, view, aVar.f24540b, aVar.f24541c);
        return true;
    }

    public static boolean isItemViewTypePinned(ListAdapter listAdapter, int i2) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return ((PinnedSectionListAdapter) listAdapter).isItemViewTypePinned(i2);
    }

    public void a(int i2) {
        a aVar = this.f24528b;
        this.f24528b = null;
        if (aVar == null) {
            aVar = new a();
        }
        View view = getAdapter().getView(i2, aVar.f24539a, this);
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
        this.f24530d = 0;
        aVar.f24539a = view;
        aVar.f24540b = i2;
        aVar.f24541c = getAdapter().getItemId(i2);
        this.f24529c = aVar;
    }

    public int b(int i2) {
        ListAdapter adapter = getAdapter();
        if (i2 >= adapter.getCount()) {
            return -1;
        }
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            int positionForSection = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i2));
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(positionForSection))) {
                return positionForSection;
            }
        }
        while (i2 >= 0) {
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i2))) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f24529c != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.f24529c.f24539a;
            canvas.save();
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + listPaddingTop);
            canvas.translate(listPaddingLeft, listPaddingTop + this.f24530d);
            drawChild(canvas, this.f24529c.f24539a, getDrawingTime());
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0 && this.f24534h == null && (aVar = this.f24529c) != null && a(aVar.f24539a, x, y)) {
            this.f24534h = this.f24529c.f24539a;
            PointF pointF = this.f24532f;
            pointF.x = x;
            pointF.y = y;
            this.f24535i = MotionEvent.obtain(motionEvent);
        }
        View view = this.f24534h;
        if (view != null) {
            if (a(view, x, y)) {
                this.f24534h.dispatchTouchEvent(motionEvent);
            }
            if (action == 1) {
                super.dispatchTouchEvent(motionEvent);
                e();
                d();
            } else if (action == 3) {
                d();
            } else if (action == 2 && Math.abs(y - this.f24532f.y) > this.f24533g) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                this.f24534h.dispatchTouchEvent(obtain);
                obtain.recycle();
                super.dispatchTouchEvent(this.f24535i);
                super.dispatchTouchEvent(motionEvent);
                d();
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f24529c == null || ((i4 - i2) - getPaddingLeft()) - getPaddingRight() == this.f24529c.f24539a.getWidth()) {
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
            this.f24527a = onScrollListener;
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
        this.f24531e = new Rect();
        this.f24532f = new PointF();
        this.k = new AbsListView.OnScrollListener() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24527a;
                if (onScrollListener != null) {
                    onScrollListener.onScroll(absListView, i2, i3, i4);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i3 == 0) {
                    return;
                }
                if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i2))) {
                    if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                        PinnedSectionListView.this.a();
                        return;
                    } else {
                        PinnedSectionListView.this.a(i2, i2, i3);
                        return;
                    }
                }
                int b2 = PinnedSectionListView.this.b(i2);
                if (b2 > -1) {
                    PinnedSectionListView.this.a(b2, i2, i3);
                } else {
                    PinnedSectionListView.this.a();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24527a;
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

    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24531e = new Rect();
        this.f24532f = new PointF();
        this.k = new AbsListView.OnScrollListener() { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i22, int i3, int i4) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24527a;
                if (onScrollListener != null) {
                    onScrollListener.onScroll(absListView, i22, i3, i4);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i3 == 0) {
                    return;
                }
                if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i22))) {
                    if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                        PinnedSectionListView.this.a();
                        return;
                    } else {
                        PinnedSectionListView.this.a(i22, i22, i3);
                        return;
                    }
                }
                int b2 = PinnedSectionListView.this.b(i22);
                if (b2 > -1) {
                    PinnedSectionListView.this.a(b2, i22, i3);
                } else {
                    PinnedSectionListView.this.a();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i22) {
                AbsListView.OnScrollListener onScrollListener = PinnedSectionListView.this.f24527a;
                if (onScrollListener != null) {
                    onScrollListener.onScrollStateChanged(absListView, i22);
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
        a aVar = this.f24529c;
        if (aVar != null) {
            this.f24528b = aVar;
            this.f24529c = null;
        }
    }

    public void a(int i2, int i3, int i4) {
        if (i4 < 2) {
            a();
            return;
        }
        a aVar = this.f24529c;
        if (aVar != null && aVar.f24540b != i2) {
            a();
        }
        if (this.f24529c == null) {
            a(i2);
        }
        int i5 = i2 + 1;
        if (i5 < getCount()) {
            int a2 = a(i5, i4 - (i5 - i3));
            if (a2 > -1) {
                int top = getChildAt(a2 - i3).getTop() - (this.f24529c.f24539a.getBottom() + getPaddingTop());
                this.j = top;
                if (top < 0) {
                    this.f24530d = top;
                    return;
                } else {
                    this.f24530d = 0;
                    return;
                }
            }
            this.f24530d = 0;
            this.j = Integer.MAX_VALUE;
        }
    }

    public int a(int i2, int i3) {
        ListAdapter adapter = getAdapter();
        int count = adapter.getCount();
        if (getLastVisiblePosition() >= count) {
            return -1;
        }
        if (i2 + i3 >= count) {
            i3 = count - i2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 + i4;
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i5))) {
                return i5;
            }
        }
        return -1;
    }

    private boolean a(View view, float f2, float f3) {
        view.getHitRect(this.f24531e);
        Rect rect = this.f24531e;
        int i2 = rect.top;
        int i3 = this.f24530d;
        rect.top = i2 + i3;
        rect.bottom += i3 + getPaddingTop();
        this.f24531e.left += getPaddingLeft();
        this.f24531e.right -= getPaddingRight();
        return this.f24531e.contains((int) f2, (int) f3);
    }
}
