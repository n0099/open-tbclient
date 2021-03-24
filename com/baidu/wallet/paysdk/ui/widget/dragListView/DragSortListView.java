package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class DragSortListView extends ListView {
    public static final int DRAG_NEG_X = 2;
    public static final int DRAG_NEG_Y = 8;
    public static final int DRAG_POS_X = 1;
    public static final int DRAG_POS_Y = 4;
    public View[] A;
    public d B;
    public float C;
    public float D;
    public int E;
    public int F;
    public float G;
    public float H;
    public float I;
    public float J;
    public float K;
    public c L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public i U;
    public MotionEvent V;
    public int W;

    /* renamed from: a  reason: collision with root package name */
    public View f26461a;
    public float aa;
    public float ab;
    public a ac;
    public boolean ad;
    public f ae;
    public boolean af;
    public boolean ag;
    public j ah;
    public l ai;
    public k aj;
    public g ak;
    public boolean al;
    public float am;
    public boolean an;
    public boolean ao;

    /* renamed from: b  reason: collision with root package name */
    public Point f26462b;

    /* renamed from: c  reason: collision with root package name */
    public Point f26463c;

    /* renamed from: d  reason: collision with root package name */
    public int f26464d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26465e;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f26466f;

    /* renamed from: g  reason: collision with root package name */
    public float f26467g;

    /* renamed from: h  reason: collision with root package name */
    public float f26468h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public b r;
    public h s;
    public m t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public ListAdapter f26472b;

        public a(ListAdapter listAdapter) {
            this.f26472b = listAdapter;
            listAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.a.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    a.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    a.this.notifyDataSetInvalidated();
                }
            });
        }

        public ListAdapter a() {
            return this.f26472b;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.f26472b.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f26472b.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f26472b.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.f26472b.getItemId(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.f26472b.getItemViewType(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            if (view != null) {
                dragSortItemView2 = (DragSortItemView) view;
                View childAt = dragSortItemView2.getChildAt(0);
                View view2 = this.f26472b.getView(i, childAt, DragSortListView.this);
                if (view2 != childAt) {
                    if (childAt != null) {
                        dragSortItemView2.removeViewAt(0);
                    }
                    dragSortItemView2.addView(view2);
                }
            } else {
                View view3 = this.f26472b.getView(i, null, DragSortListView.this);
                if (view3 instanceof Checkable) {
                    dragSortItemView = new DragSortItemViewCheckable(DragSortListView.this.getContext());
                } else {
                    dragSortItemView = new DragSortItemView(DragSortListView.this.getContext());
                }
                dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                dragSortItemView.addView(view3);
                dragSortItemView2 = dragSortItemView;
            }
            DragSortListView dragSortListView = DragSortListView.this;
            dragSortListView.a(i + dragSortListView.getHeaderViewsCount(), (View) dragSortItemView2, true);
            return dragSortItemView2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.f26472b.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.f26472b.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.f26472b.isEmpty();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.f26472b.isEnabled(i);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void drag(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        float a(float f2, long j);
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public boolean f26476b;

        /* renamed from: c  reason: collision with root package name */
        public long f26477c;

        /* renamed from: d  reason: collision with root package name */
        public long f26478d;

        /* renamed from: e  reason: collision with root package name */
        public int f26479e;

        /* renamed from: f  reason: collision with root package name */
        public float f26480f;

        /* renamed from: g  reason: collision with root package name */
        public long f26481g;

        /* renamed from: h  reason: collision with root package name */
        public int f26482h;
        public float i;
        public boolean j = false;

        public d() {
        }

        public boolean a() {
            return this.j;
        }

        public int b() {
            if (this.j) {
                return this.f26482h;
            }
            return -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f26476b) {
                this.j = false;
                return;
            }
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int min = Math.min(DragSortListView.this.N, DragSortListView.this.f26464d + DragSortListView.this.y);
            int max = Math.max(DragSortListView.this.N, DragSortListView.this.f26464d - DragSortListView.this.y);
            if (this.f26482h == 0) {
                View childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.j = false;
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.j = false;
                    return;
                } else {
                    this.i = DragSortListView.this.L.a((DragSortListView.this.H - max) / DragSortListView.this.I, this.f26477c);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.j = false;
                    return;
                } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                    this.j = false;
                    return;
                } else {
                    this.i = -DragSortListView.this.L.a((min - DragSortListView.this.G) / DragSortListView.this.J, this.f26477c);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f26478d = uptimeMillis;
            float f2 = (float) (uptimeMillis - this.f26477c);
            this.f26480f = f2;
            int round = Math.round(this.i * f2);
            this.f26479e = round;
            if (round >= 0) {
                this.f26479e = Math.min(height, round);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.f26479e = Math.max(-height, round);
            }
            View childAt3 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            int top = childAt3.getTop() + this.f26479e;
            if (lastVisiblePosition == 0 && top > paddingTop) {
                top = paddingTop;
            }
            DragSortListView.this.af = true;
            if (Build.VERSION.SDK_INT >= 21) {
                DragSortListView.this.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
            }
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.af = false;
            DragSortListView.this.d(lastVisiblePosition, childAt3, false);
            this.f26477c = this.f26478d;
            DragSortListView.this.post(this);
        }

        public void a(int i) {
            if (this.j) {
                return;
            }
            this.f26476b = false;
            this.j = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f26481g = uptimeMillis;
            this.f26477c = uptimeMillis;
            this.f26482h = i;
            DragSortListView.this.post(this);
        }

        public void a(boolean z) {
            if (z) {
                DragSortListView.this.removeCallbacks(this);
                this.j = false;
                return;
            }
            this.f26476b = true;
        }
    }

    /* loaded from: classes5.dex */
    public interface e extends b, h, m {
    }

    /* loaded from: classes5.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f26483a;

        /* renamed from: b  reason: collision with root package name */
        public File f26484b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f26485c;

        /* renamed from: d  reason: collision with root package name */
        public int f26486d;

        /* renamed from: e  reason: collision with root package name */
        public int f26487e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26488f;

        public void a() {
            this.f26483a.append("<DSLVStates>\n");
            this.f26487e = 0;
            this.f26488f = true;
        }

        public void b() {
            if (this.f26488f) {
                this.f26483a.append("<DSLVState>\n");
                int childCount = this.f26485c.getChildCount();
                int firstVisiblePosition = this.f26485c.getFirstVisiblePosition();
                this.f26483a.append("    <Positions>");
                for (int i = 0; i < childCount; i++) {
                    StringBuilder sb = this.f26483a;
                    sb.append(firstVisiblePosition + i);
                    sb.append(",");
                }
                this.f26483a.append("</Positions>\n");
                this.f26483a.append("    <Tops>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    StringBuilder sb2 = this.f26483a;
                    sb2.append(this.f26485c.getChildAt(i2).getTop());
                    sb2.append(",");
                }
                this.f26483a.append("</Tops>\n");
                this.f26483a.append("    <Bottoms>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    StringBuilder sb3 = this.f26483a;
                    sb3.append(this.f26485c.getChildAt(i3).getBottom());
                    sb3.append(",");
                }
                this.f26483a.append("</Bottoms>\n");
                StringBuilder sb4 = this.f26483a;
                sb4.append("    <FirstExpPos>");
                sb4.append(this.f26485c.j);
                sb4.append("</FirstExpPos>\n");
                StringBuilder sb5 = this.f26483a;
                sb5.append("    <FirstExpBlankHeight>");
                DragSortListView dragSortListView = this.f26485c;
                int a2 = dragSortListView.a(dragSortListView.j);
                DragSortListView dragSortListView2 = this.f26485c;
                sb5.append(a2 - dragSortListView2.c(dragSortListView2.j));
                sb5.append("</FirstExpBlankHeight>\n");
                StringBuilder sb6 = this.f26483a;
                sb6.append("    <SecondExpPos>");
                sb6.append(this.f26485c.k);
                sb6.append("</SecondExpPos>\n");
                StringBuilder sb7 = this.f26483a;
                sb7.append("    <SecondExpBlankHeight>");
                DragSortListView dragSortListView3 = this.f26485c;
                int a3 = dragSortListView3.a(dragSortListView3.k);
                DragSortListView dragSortListView4 = this.f26485c;
                sb7.append(a3 - dragSortListView4.c(dragSortListView4.k));
                sb7.append("</SecondExpBlankHeight>\n");
                StringBuilder sb8 = this.f26483a;
                sb8.append("    <SrcPos>");
                sb8.append(this.f26485c.m);
                sb8.append("</SrcPos>\n");
                StringBuilder sb9 = this.f26483a;
                sb9.append("    <SrcHeight>");
                sb9.append(this.f26485c.x + this.f26485c.getDividerHeight());
                sb9.append("</SrcHeight>\n");
                StringBuilder sb10 = this.f26483a;
                sb10.append("    <ViewHeight>");
                sb10.append(this.f26485c.getHeight());
                sb10.append("</ViewHeight>\n");
                StringBuilder sb11 = this.f26483a;
                sb11.append("    <LastY>");
                sb11.append(this.f26485c.P);
                sb11.append("</LastY>\n");
                StringBuilder sb12 = this.f26483a;
                sb12.append("    <FloatY>");
                sb12.append(this.f26485c.f26464d);
                sb12.append("</FloatY>\n");
                this.f26483a.append("    <ShuffleEdges>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    StringBuilder sb13 = this.f26483a;
                    DragSortListView dragSortListView5 = this.f26485c;
                    sb13.append(dragSortListView5.a(firstVisiblePosition + i4, dragSortListView5.getChildAt(i4).getTop()));
                    sb13.append(",");
                }
                this.f26483a.append("</ShuffleEdges>\n");
                this.f26483a.append("</DSLVState>\n");
                int i5 = this.f26486d + 1;
                this.f26486d = i5;
                if (i5 > 1000) {
                    c();
                    this.f26486d = 0;
                }
            }
        }

        public void c() {
            if (this.f26488f) {
                try {
                    FileWriter fileWriter = new FileWriter(this.f26484b, this.f26487e != 0);
                    fileWriter.write(this.f26483a.toString());
                    this.f26483a.delete(0, this.f26483a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.f26487e++;
                } catch (IOException unused) {
                }
            }
        }

        public void d() {
            if (this.f26488f) {
                this.f26483a.append("</DSLVStates>\n");
                c();
                this.f26488f = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        void drop(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(View view);

        void a(View view, Point point, Point point2);

        View d(int i);
    }

    /* loaded from: classes5.dex */
    public interface m {
        void remove(int i);
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public float f26507a;

        /* renamed from: b  reason: collision with root package name */
        public long f26508b;

        /* renamed from: d  reason: collision with root package name */
        public float f26510d;

        /* renamed from: e  reason: collision with root package name */
        public float f26511e;

        /* renamed from: f  reason: collision with root package name */
        public float f26512f;

        /* renamed from: g  reason: collision with root package name */
        public float f26513g;

        /* renamed from: h  reason: collision with root package name */
        public float f26514h;
        public boolean i;

        public n(float f2, int i) {
            this.f26510d = f2;
            this.f26507a = i;
            float f3 = 1.0f / ((f2 * 2.0f) * (1.0f - f2));
            this.f26514h = f3;
            this.f26511e = f3;
            this.f26512f = f2 / ((f2 - 1.0f) * 2.0f);
            this.f26513g = 1.0f / (1.0f - f2);
        }

        public float a(float f2) {
            float f3 = this.f26510d;
            if (f2 < f3) {
                return this.f26511e * f2 * f2;
            }
            if (f2 < 1.0f - f3) {
                return this.f26512f + (this.f26513g * f2);
            }
            float f4 = f2 - 1.0f;
            return 1.0f - ((this.f26514h * f4) * f4);
        }

        public void a() {
        }

        public void a(float f2, float f3) {
        }

        public void b() {
        }

        public void c() {
            this.f26508b = SystemClock.uptimeMillis();
            this.i = false;
            a();
            DragSortListView.this.post(this);
        }

        public void d() {
            this.i = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.i) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f26508b)) / this.f26507a;
            if (uptimeMillis >= 1.0f) {
                a(1.0f, 1.0f);
                b();
                return;
            }
            a(uptimeMillis, a(uptimeMillis));
            DragSortListView.this.post(this);
        }
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26462b = new Point();
        this.f26463c = new Point();
        this.f26465e = false;
        this.f26467g = 0.6f;
        this.f26468h = 0.6f;
        this.l = false;
        this.u = true;
        this.v = 0;
        this.w = 1;
        this.z = 0;
        this.A = new View[1];
        this.C = 0.33333334f;
        this.D = 0.33333334f;
        this.K = 0.5f;
        this.L = new c() { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.1
            @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.c
            public float a(float f2, long j2) {
                return DragSortListView.this.K * f2;
            }
        };
        this.R = 0;
        this.S = false;
        this.T = false;
        this.U = null;
        this.W = 0;
        this.aa = 0.25f;
        this.ab = 0.0f;
        this.ad = false;
        this.af = false;
        this.ag = false;
        this.ah = new j(3);
        this.am = 0.0f;
        this.an = false;
        this.ao = false;
        this.l = true;
        com.baidu.wallet.paysdk.ui.widget.dragListView.a aVar = new com.baidu.wallet.paysdk.ui.widget.dragListView.a(this, 0, 0, 0, 0, 0);
        aVar.b(false);
        aVar.a(true);
        aVar.e(-16777216);
        this.U = aVar;
        setOnTouchListener(aVar);
        this.B = new d();
        this.ai = new l(0.5f, 150);
        this.ak = new g(0.5f, 150);
        this.V = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f26466f = new DataSetObserver() { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.2
            private void a() {
                if (DragSortListView.this.v == 4) {
                    DragSortListView.this.cancelDrag();
                }
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                a();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                a();
            }
        };
    }

    public static int a(int i2, int i3, int i4, int i5) {
        int i6 = i5 - i4;
        int i7 = i2 + i3;
        return i7 < i4 ? i7 + i6 : i7 >= i5 ? i7 - i6 : i7;
    }

    public void cancelDrag() {
        if (this.v == 4) {
            this.B.a(true);
            k();
            b();
            h();
            if (this.T) {
                this.v = 3;
            } else {
                this.v = 0;
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f2;
        super.dispatchDraw(canvas);
        if (this.v != 0) {
            int i2 = this.j;
            if (i2 != this.m) {
                a(i2, canvas);
            }
            int i3 = this.k;
            if (i3 != this.j && i3 != this.m) {
                a(i3, canvas);
            }
        }
        View view = this.f26461a;
        if (view != null) {
            int width = view.getWidth();
            int height = this.f26461a.getHeight();
            int i4 = this.f26462b.x;
            int width2 = getWidth();
            if (i4 < 0) {
                i4 = -i4;
            }
            if (i4 < width2) {
                float f3 = (width2 - i4) / width2;
                f2 = f3 * f3;
            } else {
                f2 = 0.0f;
            }
            canvas.save();
            Point point = this.f26462b;
            canvas.translate(point.x, point.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, (int) (this.f26468h * 255.0f * f2), 31);
            this.f26461a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    public float getFloatAlpha() {
        return this.f26468h;
    }

    public ListAdapter getInputAdapter() {
        a aVar = this.ac;
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    public boolean isDragEnabled() {
        return this.u;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        super.layoutChildren();
        View view = this.f26461a;
        if (view != null) {
            if (view.isLayoutRequested() && !this.f26465e) {
                i();
            }
            View view2 = this.f26461a;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.f26461a.getMeasuredHeight());
            this.f26465e = false;
        }
    }

    public boolean listViewIntercepted() {
        return this.an;
    }

    public void moveCheckState(int i2, int i3) {
        int i4;
        int i5;
        SparseBooleanArray checkedItemPositions = getCheckedItemPositions();
        if (i3 < i2) {
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
        }
        int i6 = i5 + 1;
        int[] iArr = new int[checkedItemPositions.size()];
        int[] iArr2 = new int[checkedItemPositions.size()];
        int a2 = a(checkedItemPositions, i4, i6, iArr, iArr2);
        if (a2 == 1 && iArr[0] == iArr2[0]) {
            return;
        }
        if (i2 < i3) {
            for (int i7 = 0; i7 != a2; i7++) {
                setItemChecked(a(iArr[i7], -1, i4, i6), true);
                setItemChecked(a(iArr2[i7], -1, i4, i6), false);
            }
            return;
        }
        for (int i8 = 0; i8 != a2; i8++) {
            setItemChecked(iArr[i8], false);
            setItemChecked(iArr2[i8], true);
        }
    }

    public void moveItem(int i2, int i3) {
        if (this.s != null) {
            int count = getInputAdapter().getCount();
            if (i2 < 0 || i2 >= count || i3 < 0 || i3 >= count) {
                return;
            }
            this.s.drop(i2, i3);
        }
    }

    public boolean onDragTouchEvent(MotionEvent motionEvent) {
        motionEvent.getAction();
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            if (this.v == 4) {
                stopDrag(false);
            }
            f();
        } else if (action == 2) {
            b((int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (action == 3) {
            if (this.v == 4) {
                cancelDrag();
            }
            f();
        }
        return true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ad) {
            this.ae.b();
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.u) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        a(motionEvent);
        this.S = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.v != 0) {
                this.ag = true;
                return true;
            }
            this.T = true;
        }
        if (this.f26461a != null) {
            z = true;
        } else {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.an = true;
                z = true;
            } else {
                z = false;
            }
            if (action == 1 || action == 3) {
                f();
            } else if (z) {
                this.W = 1;
            } else {
                this.W = 2;
            }
        }
        if (action == 1 || action == 3) {
            this.T = false;
        }
        return z;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.f26461a;
        if (view != null) {
            if (view.isLayoutRequested()) {
                i();
            }
            this.f26465e = true;
        }
        this.z = i2;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        g();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.ag) {
            this.ag = false;
            return false;
        } else if (!this.u) {
            return super.onTouchEvent(motionEvent);
        } else {
            boolean z2 = this.S;
            this.S = false;
            if (!z2) {
                a(motionEvent);
            }
            int i2 = this.v;
            if (i2 == 4) {
                onDragTouchEvent(motionEvent);
                return true;
            }
            if (i2 == 0 && super.onTouchEvent(motionEvent)) {
                z = true;
            }
            int action = motionEvent.getAction() & 255;
            if (action == 1 || action == 3) {
                f();
            } else if (z) {
                this.W = 1;
            }
            return z;
        }
    }

    public void removeCheckState(int i2) {
        SparseBooleanArray checkedItemPositions = getCheckedItemPositions();
        if (checkedItemPositions.size() == 0) {
            return;
        }
        int[] iArr = new int[checkedItemPositions.size()];
        int[] iArr2 = new int[checkedItemPositions.size()];
        int keyAt = checkedItemPositions.keyAt(checkedItemPositions.size() - 1) + 1;
        int a2 = a(checkedItemPositions, i2, keyAt, iArr, iArr2);
        for (int i3 = 0; i3 != a2; i3++) {
            if (iArr[i3] != i2 && (iArr2[i3] >= iArr[i3] || iArr2[i3] <= i2)) {
                setItemChecked(a(iArr[i3], -1, i2, keyAt), true);
            }
            setItemChecked(a(iArr2[i3], -1, i2, keyAt), false);
        }
    }

    public void removeItem(int i2) {
        this.al = false;
        removeItem(i2, 0.0f);
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.af) {
            return;
        }
        super.requestLayout();
    }

    public void setDragEnabled(boolean z) {
        this.u = z;
    }

    public void setDragListener(b bVar) {
        this.r = bVar;
    }

    public void setDragScrollProfile(c cVar) {
        if (cVar != null) {
            this.L = cVar;
        }
    }

    public void setDragScrollStart(float f2) {
        setDragScrollStarts(f2, f2);
    }

    public void setDragScrollStarts(float f2, float f3) {
        if (f3 > 0.5f) {
            this.D = 0.5f;
        } else {
            this.D = f3;
        }
        if (f2 > 0.5f) {
            this.C = 0.5f;
        } else {
            this.C = f2;
        }
        if (getHeight() != 0) {
            g();
        }
    }

    public void setDragSortListener(e eVar) {
        setDropListener(eVar);
        setDragListener(eVar);
        setRemoveListener(eVar);
    }

    public void setDropListener(h hVar) {
        this.s = hVar;
    }

    public void setFloatAlpha(float f2) {
        this.f26468h = f2;
    }

    public void setFloatViewManager(i iVar) {
        this.U = iVar;
    }

    public void setMaxScrollSpeed(float f2) {
        this.K = f2;
    }

    public void setRemoveListener(m mVar) {
        this.t = mVar;
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        i iVar;
        View d2;
        if (!this.T || (iVar = this.U) == null || (d2 = iVar.d(i2)) == null) {
            return false;
        }
        return startDrag(i2, d2, i3, i4, i5);
    }

    public boolean stopDrag(boolean z) {
        this.al = false;
        return stopDrag(z, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        this.al = true;
        return stopDrag(z, f2);
    }

    /* loaded from: classes5.dex */
    public class k extends n {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f26498a;

        /* renamed from: d  reason: collision with root package name */
        public float f26499d;

        /* renamed from: e  reason: collision with root package name */
        public float f26500e;

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a() {
            this.f26499d = this.f26498a.o;
            this.f26500e = this.f26498a.y;
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            if (this.f26498a.v != 4) {
                d();
                return;
            }
            this.f26498a.o = (int) ((this.f26500e * f3) + ((1.0f - f3) * this.f26499d));
            this.f26498a.f26462b.y = this.f26498a.N - this.f26498a.o;
            this.f26498a.a(true);
        }
    }

    private void e() {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.m < firstVisiblePosition) {
            View childAt = getChildAt(0);
            setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - getPaddingTop());
        }
    }

    private void f() {
        this.W = 0;
        this.T = false;
        if (this.v == 3) {
            this.v = 0;
        }
        this.f26468h = this.f26467g;
        this.an = false;
        this.ah.a();
    }

    private void g() {
        int height;
        int paddingTop = getPaddingTop();
        float height2 = (getHeight() - paddingTop) - getPaddingBottom();
        float f2 = paddingTop;
        float f3 = (this.C * height2) + f2;
        this.H = f3;
        float f4 = ((1.0f - this.D) * height2) + f2;
        this.G = f4;
        this.E = (int) f3;
        this.F = (int) f4;
        this.I = f3 - f2;
        this.J = (paddingTop + height) - f4;
    }

    private void h() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    private void i() {
        View view = this.f26461a;
        if (view != null) {
            a(view);
            int measuredHeight = this.f26461a.getMeasuredHeight();
            this.x = measuredHeight;
            this.y = measuredHeight / 2;
        }
    }

    private void j() {
        int i2;
        int i3;
        if (this.U != null) {
            this.f26463c.set(this.M, this.N);
            this.U.a(this.f26461a, this.f26462b, this.f26463c);
        }
        Point point = this.f26462b;
        int i4 = point.x;
        int i5 = point.y;
        int paddingLeft = getPaddingLeft();
        if ((this.R & 1) == 0 && i4 > paddingLeft) {
            this.f26462b.x = paddingLeft;
        } else if ((this.R & 2) == 0 && i4 < paddingLeft) {
            this.f26462b.x = paddingLeft;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int paddingTop = getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.R & 8) == 0 && firstVisiblePosition <= (i3 = this.m)) {
            paddingTop = Math.max(getChildAt(i3 - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            height = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.R & 4) == 0 && lastVisiblePosition >= (i2 = this.m)) {
            height = Math.min(getChildAt(i2 - firstVisiblePosition).getBottom(), height);
        }
        if (i5 < paddingTop) {
            this.f26462b.y = paddingTop;
        } else {
            int i6 = this.x;
            if (i5 + i6 > height) {
                this.f26462b.y = height - i6;
            }
        }
        this.f26464d = this.f26462b.y + this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View view = this.f26461a;
        if (view != null) {
            view.setVisibility(8);
            i iVar = this.U;
            if (iVar != null) {
                iVar.a(this.f26461a);
            }
            this.f26461a = null;
            invalidate();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.ac = new a(listAdapter);
            listAdapter.registerDataSetObserver(this.f26466f);
            if (listAdapter instanceof h) {
                setDropListener((h) listAdapter);
            }
            if (listAdapter instanceof b) {
                setDragListener((b) listAdapter);
            }
            if (listAdapter instanceof m) {
                setRemoveListener((m) listAdapter);
            }
        } else {
            this.ac = null;
        }
        super.setAdapter((ListAdapter) this.ac);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        b(this.m - getHeaderViewsCount());
    }

    public void removeItem(int i2, float f2) {
        int i3 = this.v;
        if (i3 == 0 || i3 == 4) {
            if (this.v == 0) {
                int headerViewsCount = getHeaderViewsCount() + i2;
                this.m = headerViewsCount;
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                this.i = headerViewsCount;
                View childAt = getChildAt(headerViewsCount - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.v = 1;
            this.am = f2;
            if (this.T) {
                int i4 = this.W;
                if (i4 == 1) {
                    super.onTouchEvent(this.V);
                } else if (i4 == 2) {
                    super.onInterceptTouchEvent(this.V);
                }
            }
            l lVar = this.ai;
            if (lVar != null) {
                lVar.c();
            } else {
                b(i2);
            }
        }
    }

    public boolean stopDrag(boolean z, float f2) {
        if (this.f26461a != null) {
            this.B.a(true);
            if (z) {
                removeItem(this.m - getHeaderViewsCount(), f2);
            } else {
                g gVar = this.ak;
                if (gVar != null) {
                    gVar.c();
                } else {
                    c();
                }
            }
            if (this.ad) {
                this.ae.d();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i2;
        this.v = 2;
        if (this.s != null && (i2 = this.i) >= 0 && i2 < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.s.drop(this.m - headerViewsCount, this.i - headerViewsCount);
        }
        k();
        e();
        b();
        h();
        if (this.T) {
            this.v = 3;
        } else {
            this.v = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2, View view, boolean z) {
        this.af = true;
        j();
        int i3 = this.j;
        int i4 = this.k;
        boolean a2 = a();
        if (a2) {
            h();
            setSelectionFromTop(i2, (view.getTop() + a(i2, view, i3, i4)) - getPaddingTop());
            layoutChildren();
        }
        if (a2 || z) {
            invalidate();
        }
        this.af = false;
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        if (this.v == 0 && this.T && this.f26461a == null && view != null && this.u) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = i2 + getHeaderViewsCount();
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            this.m = headerViewsCount;
            this.i = headerViewsCount;
            this.v = 4;
            this.R = 0;
            this.R = i3 | 0;
            this.f26461a = view;
            i();
            this.n = i4;
            this.o = i5;
            int i6 = this.N;
            this.Q = i6;
            Point point = this.f26462b;
            point.x = this.M - i4;
            point.y = i6 - i5;
            View childAt = getChildAt(this.m - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.ad) {
                this.ae.a();
            }
            int i7 = this.W;
            if (i7 == 1) {
                super.onTouchEvent(this.V);
            } else if (i7 == 2) {
                super.onInterceptTouchEvent(this.V);
            }
            requestLayout();
            k kVar = this.aj;
            if (kVar != null) {
                kVar.c();
            }
            return true;
        }
        return false;
    }

    /* loaded from: classes5.dex */
    public class g extends n {

        /* renamed from: d  reason: collision with root package name */
        public int f26490d;

        /* renamed from: e  reason: collision with root package name */
        public int f26491e;

        /* renamed from: f  reason: collision with root package name */
        public float f26492f;

        /* renamed from: g  reason: collision with root package name */
        public float f26493g;

        public g(float f2, int i) {
            super(f2, i);
        }

        private int e() {
            int bottom;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int dividerHeight = (DragSortListView.this.w + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.f26490d - firstVisiblePosition);
            if (childAt != null) {
                int i = this.f26490d;
                int i2 = this.f26491e;
                if (i == i2) {
                    return childAt.getTop();
                }
                if (i < i2) {
                    bottom = childAt.getTop();
                } else {
                    bottom = childAt.getBottom() + dividerHeight;
                    dividerHeight = DragSortListView.this.x;
                }
                return bottom - dividerHeight;
            }
            d();
            return -1;
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a() {
            this.f26490d = DragSortListView.this.i;
            this.f26491e = DragSortListView.this.m;
            DragSortListView.this.v = 2;
            this.f26492f = DragSortListView.this.f26462b.y - e();
            this.f26493g = DragSortListView.this.f26462b.x - DragSortListView.this.getPaddingLeft();
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void b() {
            DragSortListView.this.c();
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            int e2 = e();
            float paddingLeft = DragSortListView.this.f26462b.x - DragSortListView.this.getPaddingLeft();
            float f4 = 1.0f - f3;
            if (f4 < Math.abs((DragSortListView.this.f26462b.y - e2) / this.f26492f) || f4 < Math.abs(paddingLeft / this.f26493g)) {
                DragSortListView.this.f26462b.y = e2 + ((int) (this.f26492f * f4));
                DragSortListView.this.f26462b.x = DragSortListView.this.getPaddingLeft() + ((int) (this.f26493g * f4));
                DragSortListView.this.a(true);
            }
        }
    }

    private void b() {
        this.m = -1;
        this.j = -1;
        this.k = -1;
        this.i = -1;
    }

    /* loaded from: classes5.dex */
    public class j {

        /* renamed from: b  reason: collision with root package name */
        public SparseIntArray f26495b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Integer> f26496c;

        /* renamed from: d  reason: collision with root package name */
        public int f26497d;

        public j(int i) {
            this.f26495b = new SparseIntArray(i);
            this.f26496c = new ArrayList<>(i);
            this.f26497d = i;
        }

        public void a(int i, int i2) {
            int i3 = this.f26495b.get(i, -1);
            if (i3 != i2) {
                if (i3 == -1) {
                    if (this.f26495b.size() == this.f26497d) {
                        this.f26495b.delete(this.f26496c.remove(0).intValue());
                    }
                } else {
                    this.f26496c.remove(Integer.valueOf(i));
                }
                this.f26495b.put(i, i2);
                this.f26496c.add(Integer.valueOf(i));
            }
        }

        public int a(int i) {
            return this.f26495b.get(i, -1);
        }

        public void a() {
            this.f26495b.clear();
            this.f26496c.clear();
        }
    }

    private void a(int i2, Canvas canvas) {
        ViewGroup viewGroup;
        int i3;
        int i4;
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider == null || dividerHeight == 0 || (viewGroup = (ViewGroup) getChildAt(i2 - getFirstVisiblePosition())) == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = viewGroup.getChildAt(0).getHeight();
        if (i2 > this.m) {
            i4 = viewGroup.getTop() + height;
            i3 = dividerHeight + i4;
        } else {
            int bottom = viewGroup.getBottom() - height;
            int i5 = bottom - dividerHeight;
            i3 = bottom;
            i4 = i5;
        }
        canvas.save();
        canvas.clipRect(paddingLeft, i4, width, i3);
        divider.setBounds(paddingLeft, i4, width, i3);
        divider.draw(canvas);
        canvas.restore();
    }

    private void b(int i2) {
        this.v = 1;
        m mVar = this.t;
        if (mVar != null) {
            mVar.remove(i2);
        }
        k();
        e();
        b();
        if (this.T) {
            this.v = 3;
        } else {
            this.v = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i2) {
        View view;
        if (i2 == this.m) {
            return 0;
        }
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i2, childAt, false);
        }
        int a2 = this.ah.a(i2);
        if (a2 != -1) {
            return a2;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i2);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.A.length) {
            this.A = new View[viewTypeCount];
        }
        if (itemViewType >= 0) {
            View[] viewArr = this.A;
            if (viewArr[itemViewType] == null) {
                view = adapter.getView(i2, null, this);
                this.A[itemViewType] = view;
            } else {
                view = adapter.getView(i2, viewArr[itemViewType], this);
            }
        } else {
            view = adapter.getView(i2, null, this);
        }
        int b2 = b(i2, view, true);
        this.ah.a(i2, b2);
        return b2;
    }

    /* loaded from: classes5.dex */
    public class l extends n {

        /* renamed from: d  reason: collision with root package name */
        public float f26502d;

        /* renamed from: e  reason: collision with root package name */
        public float f26503e;

        /* renamed from: f  reason: collision with root package name */
        public float f26504f;

        /* renamed from: g  reason: collision with root package name */
        public int f26505g;

        /* renamed from: h  reason: collision with root package name */
        public int f26506h;
        public int i;
        public int j;
        public int k;

        public l(float f2, int i) {
            super(f2, i);
            this.f26505g = -1;
            this.f26506h = -1;
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a() {
            this.f26505g = -1;
            this.f26506h = -1;
            this.i = DragSortListView.this.j;
            this.j = DragSortListView.this.k;
            this.k = DragSortListView.this.m;
            DragSortListView.this.v = 1;
            this.f26502d = DragSortListView.this.f26462b.x;
            if (!DragSortListView.this.al) {
                DragSortListView.this.k();
                return;
            }
            float width = DragSortListView.this.getWidth() * 2.0f;
            if (DragSortListView.this.am != 0.0f) {
                float f2 = width * 2.0f;
                if (DragSortListView.this.am < 0.0f) {
                    float f3 = -f2;
                    if (DragSortListView.this.am > f3) {
                        DragSortListView.this.am = f3;
                        return;
                    }
                }
                if (DragSortListView.this.am <= 0.0f || DragSortListView.this.am >= f2) {
                    return;
                }
                DragSortListView.this.am = f2;
                return;
            }
            DragSortListView.this.am = (this.f26502d >= 0.0f ? 1 : -1) * width;
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void b() {
            DragSortListView.this.d();
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            View childAt;
            float f4 = 1.0f - f3;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt2 = DragSortListView.this.getChildAt(this.i - firstVisiblePosition);
            if (DragSortListView.this.al) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f26508b)) / 1000.0f;
                if (uptimeMillis == 0.0f) {
                    return;
                }
                float f5 = DragSortListView.this.am * uptimeMillis;
                int width = DragSortListView.this.getWidth();
                DragSortListView dragSortListView = DragSortListView.this;
                float f6 = (DragSortListView.this.am > 0.0f ? 1 : -1) * uptimeMillis;
                float f7 = width;
                dragSortListView.am = dragSortListView.am + (f6 * f7);
                this.f26502d += f5;
                Point point = DragSortListView.this.f26462b;
                float f8 = this.f26502d;
                point.x = (int) f8;
                if (f8 < f7 && f8 > (-width)) {
                    this.f26508b = SystemClock.uptimeMillis();
                    DragSortListView.this.a(true);
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.f26505g == -1) {
                    this.f26505g = DragSortListView.this.b(this.i, childAt2, false);
                    this.f26503e = childAt2.getHeight() - this.f26505g;
                }
                int max = Math.max((int) (this.f26503e * f4), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = this.f26505g + max;
                childAt2.setLayoutParams(layoutParams);
            }
            int i = this.j;
            if (i == this.i || (childAt = DragSortListView.this.getChildAt(i - firstVisiblePosition)) == null) {
                return;
            }
            if (this.f26506h == -1) {
                this.f26506h = DragSortListView.this.b(this.j, childAt, false);
                this.f26504f = childAt.getHeight() - this.f26506h;
            }
            int max2 = Math.max((int) (f4 * this.f26504f), 1);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            layoutParams2.height = this.f26506h + max2;
            childAt.setLayoutParams(layoutParams2);
        }
    }

    private void b(int i2, int i3) {
        Point point = this.f26462b;
        point.x = i2 - this.n;
        point.y = i3 - this.o;
        a(true);
        int min = Math.min(i3, this.f26464d + this.y);
        int max = Math.max(i3, this.f26464d - this.y);
        int b2 = this.B.b();
        if (min > this.P && min > this.F && b2 != 1) {
            if (b2 != -1) {
                this.B.a(true);
            }
            this.B.a(1);
        } else if (max < this.P && max < this.E && b2 != 0) {
            if (b2 != -1) {
                this.B.a(true);
            }
            this.B.a(0);
        } else if (max < this.E || min > this.F || !this.B.a()) {
        } else {
            this.B.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2) {
        View childAt = getChildAt(i2 - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return c(i2, c(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r8 <= r7.m) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(int i2, int i3) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i2 <= headerViewsCount || i2 >= getCount() - footerViewsCount) {
            return i3;
        }
        int dividerHeight = getDividerHeight();
        int i4 = this.x - this.w;
        int c2 = c(i2);
        int a2 = a(i2);
        int i5 = this.k;
        int i6 = this.m;
        if (i5 <= i6) {
            if (i2 != i5 || this.j == i5) {
                if (i2 > this.k) {
                }
            } else if (i2 == i6) {
                i3 += a2;
                i4 = this.x;
            } else {
                i3 += a2 - c2;
            }
            i3 -= i4;
        } else if (i2 <= i6 || i2 > this.j) {
            int i7 = this.k;
            if (i2 == i7 && this.j != i7) {
                i3 += a2 - c2;
            }
        } else {
            i3 += i4;
        }
        if (i2 <= this.m) {
            return i3 + (((this.x - dividerHeight) - c(i2 - 1)) / 2);
        }
        return i3 + (((c2 - dividerHeight) - this.x) / 2);
    }

    private int c(int i2, View view, boolean z) {
        return c(i2, b(i2, view, z));
    }

    private int c(int i2, int i3) {
        getDividerHeight();
        boolean z = this.l && this.j != this.k;
        int i4 = this.x;
        int i5 = this.w;
        int i6 = i4 - i5;
        int i7 = (int) (this.ab * i6);
        int i8 = this.m;
        return i2 == i8 ? i8 == this.j ? z ? i7 + i5 : i4 : i8 == this.k ? i4 - i7 : i5 : i2 == this.j ? z ? i3 + i7 : i3 + i6 : i2 == this.k ? (i3 + i6) - i7 : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i2, View view, boolean z) {
        int i3;
        if (i2 == this.m) {
            return 0;
        }
        if (i2 >= getHeaderViewsCount() && i2 < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null || (i3 = layoutParams.height) <= 0) {
            int height = view.getHeight();
            if (height == 0 || z) {
                a(view);
                return view.getMeasuredHeight();
            }
            return height;
        }
        return i3;
    }

    private boolean a() {
        int i2;
        int i3;
        int firstVisiblePosition = getFirstVisiblePosition();
        int i4 = this.j;
        View childAt = getChildAt(i4 - firstVisiblePosition);
        if (childAt == null) {
            i4 = (getChildCount() / 2) + firstVisiblePosition;
            childAt = getChildAt(i4 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int a2 = a(i4, top);
        int dividerHeight = getDividerHeight();
        if (this.f26464d < a2) {
            while (i4 >= 0) {
                i4--;
                int a3 = a(i4);
                if (i4 == 0) {
                    i2 = (top - dividerHeight) - a3;
                    int i5 = a2;
                    a2 = i2;
                    i3 = i5;
                    break;
                }
                top -= a3 + dividerHeight;
                int a4 = a(i4, top);
                if (this.f26464d >= a4) {
                    i3 = a2;
                    a2 = a4;
                    break;
                }
                a2 = a4;
            }
            i3 = a2;
        } else {
            int count = getCount();
            while (i4 < count) {
                if (i4 == count - 1) {
                    i2 = top + dividerHeight + height;
                    int i52 = a2;
                    a2 = i2;
                    i3 = i52;
                    break;
                }
                top += height + dividerHeight;
                int i6 = i4 + 1;
                int a5 = a(i6);
                int a6 = a(i6, top);
                if (this.f26464d < a6) {
                    i3 = a2;
                    a2 = a6;
                    break;
                }
                i4 = i6;
                height = a5;
                a2 = a6;
            }
            i3 = a2;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        boolean z = false;
        int i7 = this.j;
        int i8 = this.k;
        float f2 = this.ab;
        if (this.l) {
            int abs = Math.abs(a2 - i3);
            if (this.f26464d < a2) {
                int i9 = a2;
                a2 = i3;
                i3 = i9;
            }
            int i10 = (int) (this.aa * 0.5f * abs);
            float f3 = i10;
            int i11 = a2 + i10;
            int i12 = i3 - i10;
            int i13 = this.f26464d;
            if (i13 < i11) {
                this.j = i4 - 1;
                this.k = i4;
                this.ab = ((i11 - i13) * 0.5f) / f3;
            } else if (i13 < i12) {
                this.j = i4;
                this.k = i4;
            } else {
                this.j = i4;
                this.k = i4 + 1;
                this.ab = (((i3 - i13) / f3) + 1.0f) * 0.5f;
            }
        } else {
            this.j = i4;
            this.k = i4;
        }
        if (this.j < headerViewsCount) {
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            i4 = headerViewsCount;
        } else if (this.k >= getCount() - footerViewsCount) {
            i4 = (getCount() - footerViewsCount) - 1;
            this.j = i4;
            this.k = i4;
        }
        z = (this.j == i7 && this.k == i8 && this.ab == f2) ? true : true;
        int i14 = this.i;
        if (i4 != i14) {
            b bVar = this.r;
            if (bVar != null) {
                bVar.drag(i14 - headerViewsCount, i4 - headerViewsCount);
            }
            this.i = i4;
            return true;
        }
        return z;
    }

    private void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.O = this.M;
            this.P = this.N;
        }
        this.M = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.N = y;
        if (action == 0) {
            this.O = this.M;
            this.P = y;
        }
        this.p = ((int) motionEvent.getRawX()) - this.M;
        this.q = ((int) motionEvent.getRawY()) - this.N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int c2 = (i2 == this.m || i2 == this.j || i2 == this.k) ? c(i2, view, z) : -2;
        if (c2 != layoutParams.height) {
            layoutParams.height = c2;
            view.setLayoutParams(layoutParams);
        }
        if (i2 == this.j || i2 == this.k) {
            int i3 = this.m;
            if (i2 < i3) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i2 > i3) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i4 = 0;
        if (i2 == this.m && this.f26461a != null) {
            i4 = 4;
        }
        if (i4 != visibility) {
            view.setVisibility(i4);
        }
    }

    private int a(int i2, View view, int i3, int i4) {
        int i5;
        int i6;
        int c2 = c(i2);
        int height = view.getHeight();
        int c3 = c(i2, c2);
        if (i2 != this.m) {
            i5 = height - c2;
            i6 = c3 - c2;
        } else {
            i5 = height;
            i6 = c3;
        }
        int i7 = this.x;
        int i8 = this.m;
        if (i8 != this.j && i8 != this.k) {
            i7 -= this.w;
        }
        if (i2 <= i3) {
            if (i2 > this.j) {
                return 0 + (i7 - i6);
            }
            return 0;
        } else if (i2 == i4) {
            if (i2 <= this.j) {
                i5 -= i7;
            } else if (i2 == this.k) {
                return 0 + (height - c3);
            }
            return 0 + i5;
        } else if (i2 <= this.j) {
            return 0 - i7;
        } else {
            if (i2 == this.k) {
                return 0 - i6;
            }
            return 0;
        }
    }

    private void a(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.z, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt == null) {
            return;
        }
        d(firstVisiblePosition, childAt, z);
    }

    public static int a(SparseBooleanArray sparseBooleanArray, int i2, int i3, int[] iArr, int[] iArr2) {
        int keyAt;
        int a2 = a(sparseBooleanArray, i2, i3);
        if (a2 == -1) {
            return 0;
        }
        int keyAt2 = sparseBooleanArray.keyAt(a2);
        int i4 = keyAt2 + 1;
        int i5 = 0;
        for (int i6 = a2 + 1; i6 < sparseBooleanArray.size() && (keyAt = sparseBooleanArray.keyAt(i6)) < i3; i6++) {
            if (sparseBooleanArray.valueAt(i6)) {
                if (keyAt == i4) {
                    i4++;
                } else {
                    iArr[i5] = keyAt2;
                    iArr2[i5] = i4;
                    i5++;
                    i4 = keyAt + 1;
                    keyAt2 = keyAt;
                }
            }
        }
        if (i4 == i3) {
            i4 = i2;
        }
        iArr[i5] = keyAt2;
        iArr2[i5] = i4;
        int i7 = i5 + 1;
        if (i7 <= 1 || iArr[0] != i2) {
            return i7;
        }
        int i8 = i7 - 1;
        if (iArr2[i8] == i2) {
            iArr[0] = iArr[i8];
            return i7 - 1;
        }
        return i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r2.keyAt(r3) < r4) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(SparseBooleanArray sparseBooleanArray, int i2, int i3) {
        int size = sparseBooleanArray.size();
        int a2 = a(sparseBooleanArray, i2);
        while (a2 < size && sparseBooleanArray.keyAt(a2) < i3 && !sparseBooleanArray.valueAt(a2)) {
            a2++;
        }
        return -1;
    }

    public static int a(SparseBooleanArray sparseBooleanArray, int i2) {
        int size = sparseBooleanArray.size();
        int i3 = 0;
        while (size - i3 > 0) {
            int i4 = (i3 + size) >> 1;
            if (sparseBooleanArray.keyAt(i4) < i2) {
                i3 = i4 + 1;
            } else {
                size = i4;
            }
        }
        return i3;
    }
}
