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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class DragSortListView extends ListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DRAG_NEG_X = 2;
    public static final int DRAG_NEG_Y = 8;
    public static final int DRAG_POS_X = 1;
    public static final int DRAG_POS_Y = 4;
    public transient /* synthetic */ FieldHolder $fh;
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
    public View f60534a;
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
    public Point f60535b;

    /* renamed from: c  reason: collision with root package name */
    public Point f60536c;

    /* renamed from: d  reason: collision with root package name */
    public int f60537d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60538e;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f60539f;

    /* renamed from: g  reason: collision with root package name */
    public float f60540g;

    /* renamed from: h  reason: collision with root package name */
    public float f60541h;

    /* renamed from: i  reason: collision with root package name */
    public int f60542i;
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

    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f60545a;

        /* renamed from: b  reason: collision with root package name */
        public ListAdapter f60546b;

        public a(DragSortListView dragSortListView, ListAdapter listAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragSortListView, listAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60545a = dragSortListView;
            this.f60546b = listAdapter;
            listAdapter.registerDataSetObserver(new DataSetObserver(this, dragSortListView) { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DragSortListView f60547a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f60548b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, dragSortListView};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f60548b = this;
                    this.f60547a = dragSortListView;
                }

                @Override // android.database.DataSetObserver
                public void onChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f60548b.notifyDataSetChanged();
                    }
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f60548b.notifyDataSetInvalidated();
                    }
                }
            });
        }

        public ListAdapter a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60546b : (ListAdapter) invokeV.objValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60546b.areAllItemsEnabled() : invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60546b.getCount() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f60546b.getItem(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f60546b.getItemId(i2) : invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f60546b.getItemViewType(i2) : invokeI.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
                if (view != null) {
                    dragSortItemView2 = (DragSortItemView) view;
                    View childAt = dragSortItemView2.getChildAt(0);
                    View view2 = this.f60546b.getView(i2, childAt, this.f60545a);
                    if (view2 != childAt) {
                        if (childAt != null) {
                            dragSortItemView2.removeViewAt(0);
                        }
                        dragSortItemView2.addView(view2);
                    }
                } else {
                    View view3 = this.f60546b.getView(i2, null, this.f60545a);
                    if (view3 instanceof Checkable) {
                        dragSortItemView = new DragSortItemViewCheckable(this.f60545a.getContext());
                    } else {
                        dragSortItemView = new DragSortItemView(this.f60545a.getContext());
                    }
                    dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    dragSortItemView.addView(view3);
                    dragSortItemView2 = dragSortItemView;
                }
                DragSortListView dragSortListView = this.f60545a;
                dragSortListView.a(i2 + dragSortListView.getHeaderViewsCount(), (View) dragSortItemView2, true);
                return dragSortItemView2;
            }
            return (View) invokeILL.objValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60546b.getViewTypeCount() : invokeV.intValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60546b.hasStableIds() : invokeV.booleanValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f60546b.isEmpty() : invokeV.booleanValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f60546b.isEnabled(i2) : invokeI.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(int i2, int i3);
    }

    /* loaded from: classes10.dex */
    public interface c {
        float a(float f2, long j);
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f60549a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f60550b;

        /* renamed from: c  reason: collision with root package name */
        public long f60551c;

        /* renamed from: d  reason: collision with root package name */
        public long f60552d;

        /* renamed from: e  reason: collision with root package name */
        public int f60553e;

        /* renamed from: f  reason: collision with root package name */
        public float f60554f;

        /* renamed from: g  reason: collision with root package name */
        public long f60555g;

        /* renamed from: h  reason: collision with root package name */
        public int f60556h;

        /* renamed from: i  reason: collision with root package name */
        public float f60557i;
        public boolean j;

        public d(DragSortListView dragSortListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragSortListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60549a = dragSortListView;
            this.j = false;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.booleanValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.j) {
                    return this.f60556h;
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f60550b) {
                    this.j = false;
                    return;
                }
                int firstVisiblePosition = this.f60549a.getFirstVisiblePosition();
                int lastVisiblePosition = this.f60549a.getLastVisiblePosition();
                int count = this.f60549a.getCount();
                int paddingTop = this.f60549a.getPaddingTop();
                int height = (this.f60549a.getHeight() - paddingTop) - this.f60549a.getPaddingBottom();
                int min = Math.min(this.f60549a.N, this.f60549a.f60537d + this.f60549a.y);
                int max = Math.max(this.f60549a.N, this.f60549a.f60537d - this.f60549a.y);
                if (this.f60556h == 0) {
                    View childAt = this.f60549a.getChildAt(0);
                    if (childAt == null) {
                        this.j = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.j = false;
                        return;
                    } else {
                        this.f60557i = this.f60549a.L.a((this.f60549a.H - max) / this.f60549a.I, this.f60551c);
                    }
                } else {
                    View childAt2 = this.f60549a.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.j = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.j = false;
                        return;
                    } else {
                        this.f60557i = -this.f60549a.L.a((min - this.f60549a.G) / this.f60549a.J, this.f60551c);
                    }
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f60552d = uptimeMillis;
                float f2 = (float) (uptimeMillis - this.f60551c);
                this.f60554f = f2;
                int round = Math.round(this.f60557i * f2);
                this.f60553e = round;
                if (round >= 0) {
                    this.f60553e = Math.min(height, round);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.f60553e = Math.max(-height, round);
                }
                View childAt3 = this.f60549a.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.f60553e;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                this.f60549a.af = true;
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f60549a.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                }
                this.f60549a.layoutChildren();
                this.f60549a.invalidate();
                this.f60549a.af = false;
                this.f60549a.d(lastVisiblePosition, childAt3, false);
                this.f60551c = this.f60552d;
                this.f60549a.post(this);
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.j) {
                return;
            }
            this.f60550b = false;
            this.j = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f60555g = uptimeMillis;
            this.f60551c = uptimeMillis;
            this.f60556h = i2;
            this.f60549a.post(this);
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f60549a.removeCallbacks(this);
                    this.j = false;
                    return;
                }
                this.f60550b = true;
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface e extends b, h, m {
    }

    /* loaded from: classes10.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public StringBuilder f60558a;

        /* renamed from: b  reason: collision with root package name */
        public File f60559b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f60560c;

        /* renamed from: d  reason: collision with root package name */
        public int f60561d;

        /* renamed from: e  reason: collision with root package name */
        public int f60562e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f60563f;

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60558a.append("<DSLVStates>\n");
                this.f60562e = 0;
                this.f60563f = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f60563f) {
                this.f60558a.append("<DSLVState>\n");
                int childCount = this.f60560c.getChildCount();
                int firstVisiblePosition = this.f60560c.getFirstVisiblePosition();
                this.f60558a.append("    <Positions>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    StringBuilder sb = this.f60558a;
                    sb.append(firstVisiblePosition + i2);
                    sb.append(",");
                }
                this.f60558a.append("</Positions>\n");
                this.f60558a.append("    <Tops>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    StringBuilder sb2 = this.f60558a;
                    sb2.append(this.f60560c.getChildAt(i3).getTop());
                    sb2.append(",");
                }
                this.f60558a.append("</Tops>\n");
                this.f60558a.append("    <Bottoms>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    StringBuilder sb3 = this.f60558a;
                    sb3.append(this.f60560c.getChildAt(i4).getBottom());
                    sb3.append(",");
                }
                this.f60558a.append("</Bottoms>\n");
                StringBuilder sb4 = this.f60558a;
                sb4.append("    <FirstExpPos>");
                sb4.append(this.f60560c.j);
                sb4.append("</FirstExpPos>\n");
                StringBuilder sb5 = this.f60558a;
                sb5.append("    <FirstExpBlankHeight>");
                DragSortListView dragSortListView = this.f60560c;
                int a2 = dragSortListView.a(dragSortListView.j);
                DragSortListView dragSortListView2 = this.f60560c;
                sb5.append(a2 - dragSortListView2.c(dragSortListView2.j));
                sb5.append("</FirstExpBlankHeight>\n");
                StringBuilder sb6 = this.f60558a;
                sb6.append("    <SecondExpPos>");
                sb6.append(this.f60560c.k);
                sb6.append("</SecondExpPos>\n");
                StringBuilder sb7 = this.f60558a;
                sb7.append("    <SecondExpBlankHeight>");
                DragSortListView dragSortListView3 = this.f60560c;
                int a3 = dragSortListView3.a(dragSortListView3.k);
                DragSortListView dragSortListView4 = this.f60560c;
                sb7.append(a3 - dragSortListView4.c(dragSortListView4.k));
                sb7.append("</SecondExpBlankHeight>\n");
                StringBuilder sb8 = this.f60558a;
                sb8.append("    <SrcPos>");
                sb8.append(this.f60560c.m);
                sb8.append("</SrcPos>\n");
                StringBuilder sb9 = this.f60558a;
                sb9.append("    <SrcHeight>");
                sb9.append(this.f60560c.x + this.f60560c.getDividerHeight());
                sb9.append("</SrcHeight>\n");
                StringBuilder sb10 = this.f60558a;
                sb10.append("    <ViewHeight>");
                sb10.append(this.f60560c.getHeight());
                sb10.append("</ViewHeight>\n");
                StringBuilder sb11 = this.f60558a;
                sb11.append("    <LastY>");
                sb11.append(this.f60560c.P);
                sb11.append("</LastY>\n");
                StringBuilder sb12 = this.f60558a;
                sb12.append("    <FloatY>");
                sb12.append(this.f60560c.f60537d);
                sb12.append("</FloatY>\n");
                this.f60558a.append("    <ShuffleEdges>");
                for (int i5 = 0; i5 < childCount; i5++) {
                    StringBuilder sb13 = this.f60558a;
                    DragSortListView dragSortListView5 = this.f60560c;
                    sb13.append(dragSortListView5.a(firstVisiblePosition + i5, dragSortListView5.getChildAt(i5).getTop()));
                    sb13.append(",");
                }
                this.f60558a.append("</ShuffleEdges>\n");
                this.f60558a.append("</DSLVState>\n");
                int i6 = this.f60561d + 1;
                this.f60561d = i6;
                if (i6 > 1000) {
                    c();
                    this.f60561d = 0;
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f60563f) {
                try {
                    FileWriter fileWriter = new FileWriter(this.f60559b, this.f60562e != 0);
                    fileWriter.write(this.f60558a.toString());
                    this.f60558a.delete(0, this.f60558a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.f60562e++;
                } catch (IOException unused) {
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f60563f) {
                this.f60558a.append("</DSLVStates>\n");
                c();
                this.f60563f = false;
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface h {
        void a_(int i2, int i3);
    }

    /* loaded from: classes10.dex */
    public interface i {
        void a(View view);

        void a(View view, Point point, Point point2);

        View c(int i2);
    }

    /* loaded from: classes10.dex */
    public interface m {
        void a(int i2);
    }

    /* loaded from: classes10.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f60583a;

        /* renamed from: b  reason: collision with root package name */
        public long f60584b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f60585c;

        /* renamed from: d  reason: collision with root package name */
        public float f60586d;

        /* renamed from: e  reason: collision with root package name */
        public float f60587e;

        /* renamed from: f  reason: collision with root package name */
        public float f60588f;

        /* renamed from: g  reason: collision with root package name */
        public float f60589g;

        /* renamed from: h  reason: collision with root package name */
        public float f60590h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f60591i;

        public n(DragSortListView dragSortListView, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragSortListView, Float.valueOf(f2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60585c = dragSortListView;
            this.f60586d = f2;
            this.f60583a = i2;
            float f3 = 1.0f / ((f2 * 2.0f) * (1.0f - f2));
            this.f60590h = f3;
            this.f60587e = f3;
            this.f60588f = f2 / ((f2 - 1.0f) * 2.0f);
            this.f60589g = 1.0f / (1.0f - f2);
        }

        public float a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f3 = this.f60586d;
                if (f2 < f3) {
                    return this.f60587e * f2 * f2;
                }
                if (f2 < 1.0f - f3) {
                    return this.f60588f + (this.f60589g * f2);
                }
                float f4 = f2 - 1.0f;
                return 1.0f - ((this.f60590h * f4) * f4);
            }
            return invokeF.floatValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f60584b = SystemClock.uptimeMillis();
                this.f60591i = false;
                a();
                this.f60585c.post(this);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f60591i = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f60591i) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f60584b)) / this.f60583a;
            if (uptimeMillis >= 1.0f) {
                a(1.0f, 1.0f);
                b();
                return;
            }
            a(uptimeMillis, a(uptimeMillis));
            this.f60585c.post(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60535b = new Point();
        this.f60536c = new Point();
        this.f60538e = false;
        this.f60540g = 0.6f;
        this.f60541h = 0.6f;
        this.l = false;
        this.u = true;
        this.v = 0;
        this.w = 1;
        this.z = 0;
        this.A = new View[1];
        this.C = 0.33333334f;
        this.D = 0.33333334f;
        this.K = 0.5f;
        this.L = new c(this) { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DragSortListView f60543a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f60543a = this;
            }

            @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.c
            public float a(float f2, long j2) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Long.valueOf(j2)})) == null) ? this.f60543a.K * f2 : invokeCommon.floatValue;
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
        this.ah = new j(this, 3);
        this.am = 0.0f;
        this.an = false;
        this.ao = false;
        this.l = true;
        com.baidu.wallet.paysdk.ui.widget.dragListView.a aVar = new com.baidu.wallet.paysdk.ui.widget.dragListView.a(this, 0, 0, 0, 0, 0);
        aVar.b(false);
        aVar.a(true);
        aVar.d(-16777216);
        this.U = aVar;
        setOnTouchListener(aVar);
        this.B = new d(this);
        this.ai = new l(this, 0.5f, 150);
        this.ak = new g(this, 0.5f, 150);
        this.V = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f60539f = new DataSetObserver(this) { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DragSortListView f60544a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f60544a = this;
            }

            private void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(65537, this) == null) && this.f60544a.v == 4) {
                    this.f60544a.cancelDrag();
                }
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    a();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    a();
                }
            }
        };
    }

    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(AdIconUtil.AD_TEXT_ID, null, i2, i3, i4, i5)) == null) {
            int i6 = i5 - i4;
            int i7 = i2 + i3;
            return i7 < i4 ? i7 + i6 : i7 >= i5 ? i7 - i6 : i7;
        }
        return invokeIIII.intValue;
    }

    public void cancelDrag() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.v == 4) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
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
            View view = this.f60534a;
            if (view != null) {
                int width = view.getWidth();
                int height = this.f60534a.getHeight();
                int i4 = this.f60535b.x;
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
                Point point = this.f60535b;
                canvas.translate(point.x, point.y);
                canvas.clipRect(0, 0, width, height);
                canvas.saveLayerAlpha(0.0f, 0.0f, width, height, (int) (this.f60541h * 255.0f * f2), 31);
                this.f60534a.draw(canvas);
                canvas.restore();
                canvas.restore();
            }
        }
    }

    public float getFloatAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60541h : invokeV.floatValue;
    }

    public ListAdapter getInputAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a aVar = this.ac;
            if (aVar == null) {
                return null;
            }
            return aVar.a();
        }
        return (ListAdapter) invokeV.objValue;
    }

    public boolean isDragEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u : invokeV.booleanValue;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.layoutChildren();
            View view = this.f60534a;
            if (view != null) {
                if (view.isLayoutRequested() && !this.f60538e) {
                    i();
                }
                View view2 = this.f60534a;
                view2.layout(0, 0, view2.getMeasuredWidth(), this.f60534a.getMeasuredHeight());
                this.f60538e = false;
            }
        }
    }

    public boolean listViewIntercepted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.an : invokeV.booleanValue;
    }

    public void moveCheckState(int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
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
    }

    public void moveItem(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) || this.s == null) {
            return;
        }
        int count = getInputAdapter().getCount();
        if (i2 < 0 || i2 >= count || i3 < 0 || i3 >= count) {
            return;
        }
        this.s.a_(i2, i3);
    }

    public boolean onDragTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.ad) {
                this.ae.b();
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
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
            if (this.f60534a != null) {
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
        return invokeL.booleanValue;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            View view = this.f60534a;
            if (view != null) {
                if (view.isLayoutRequested()) {
                    i();
                }
                this.f60538e = true;
            }
            this.z = i2;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            g();
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    public void removeCheckState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
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
    }

    public void removeItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.al = false;
            removeItem(i2, 0.0f);
        }
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.af) {
            return;
        }
        super.requestLayout();
    }

    public void setDragEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.u = z;
        }
    }

    public void setDragListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void setDragScrollProfile(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) || cVar == null) {
            return;
        }
        this.L = cVar;
    }

    public void setDragScrollStart(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            setDragScrollStarts(f2, f2);
        }
    }

    public void setDragScrollStarts(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
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
    }

    public void setDragSortListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, eVar) == null) {
            setDropListener(eVar);
            setDragListener(eVar);
            setRemoveListener(eVar);
        }
    }

    public void setDropListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, hVar) == null) {
            this.s = hVar;
        }
    }

    public void setFloatAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048604, this, f2) == null) {
            this.f60541h = f2;
        }
    }

    public void setFloatViewManager(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iVar) == null) {
            this.U = iVar;
        }
    }

    public void setMaxScrollSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.K = f2;
        }
    }

    public void setRemoveListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, mVar) == null) {
            this.t = mVar;
        }
    }

    public boolean startDrag(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        i iVar;
        View c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048608, this, i2, i3, i4, i5)) == null) {
            if (!this.T || (iVar = this.U) == null || (c2 = iVar.c(i2)) == null) {
                return false;
            }
            return startDrag(i2, c2, i3, i4, i5);
        }
        return invokeIIII.booleanValue;
    }

    public boolean stopDrag(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
            this.al = false;
            return stopDrag(z, 0.0f);
        }
        return invokeZ.booleanValue;
    }

    public boolean stopDragWithVelocity(boolean z, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)})) == null) {
            this.al = true;
            return stopDrag(z, f2);
        }
        return invokeCommon.booleanValue;
    }

    /* loaded from: classes10.dex */
    public class k extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f60573a;

        /* renamed from: d  reason: collision with root package name */
        public float f60574d;

        /* renamed from: e  reason: collision with root package name */
        public float f60575e;

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60574d = this.f60573a.o;
                this.f60575e = this.f60573a.y;
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (this.f60573a.v == 4) {
                    this.f60573a.o = (int) ((this.f60575e * f3) + ((1.0f - f3) * this.f60574d));
                    this.f60573a.f60535b.y = this.f60573a.N - this.f60573a.o;
                    this.f60573a.a(true);
                    return;
                }
                d();
            }
        }
    }

    private void e() {
        int firstVisiblePosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || this.m >= (firstVisiblePosition = getFirstVisiblePosition())) {
            return;
        }
        View childAt = getChildAt(0);
        setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - getPaddingTop());
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            this.W = 0;
            this.T = false;
            if (this.v == 3) {
                this.v = 0;
            }
            this.f60541h = this.f60540g;
            this.an = false;
            this.ah.a();
        }
    }

    private void g() {
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
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
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
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
    }

    private void i() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65584, this) == null) || (view = this.f60534a) == null) {
            return;
        }
        a(view);
        int measuredHeight = this.f60534a.getMeasuredHeight();
        this.x = measuredHeight;
        this.y = measuredHeight / 2;
    }

    private void j() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            if (this.U != null) {
                this.f60536c.set(this.M, this.N);
                this.U.a(this.f60534a, this.f60535b, this.f60536c);
            }
            Point point = this.f60535b;
            int i4 = point.x;
            int i5 = point.y;
            int paddingLeft = getPaddingLeft();
            if ((this.R & 1) == 0 && i4 > paddingLeft) {
                this.f60535b.x = paddingLeft;
            } else if ((this.R & 2) == 0 && i4 < paddingLeft) {
                this.f60535b.x = paddingLeft;
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
                this.f60535b.y = paddingTop;
            } else {
                int i6 = this.x;
                if (i5 + i6 > height) {
                    this.f60535b.y = height - i6;
                }
            }
            this.f60537d = this.f60535b.y + this.y;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65587, this) == null) || (view = this.f60534a) == null) {
            return;
        }
        view.setVisibility(8);
        i iVar = this.U;
        if (iVar != null) {
            iVar.a(this.f60534a);
        }
        this.f60534a = null;
        invalidate();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, listAdapter) == null) {
            if (listAdapter != null) {
                this.ac = new a(this, listAdapter);
                listAdapter.registerDataSetObserver(this.f60539f);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            b(this.m - getHeaderViewsCount());
        }
    }

    public void removeItem(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int i3 = this.v;
            if (i3 == 0 || i3 == 4) {
                if (this.v == 0) {
                    int headerViewsCount = getHeaderViewsCount() + i2;
                    this.m = headerViewsCount;
                    this.j = headerViewsCount;
                    this.k = headerViewsCount;
                    this.f60542i = headerViewsCount;
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
    }

    public boolean stopDrag(boolean z, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)})) == null) {
            if (this.f60534a != null) {
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
        return invokeCommon.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.v = 2;
            if (this.s != null && (i2 = this.f60542i) >= 0 && i2 < getCount()) {
                int headerViewsCount = getHeaderViewsCount();
                this.s.a_(this.m - headerViewsCount, this.f60542i - headerViewsCount);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65574, this, new Object[]{Integer.valueOf(i2), view, Boolean.valueOf(z)}) == null) {
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
    }

    public boolean startDrag(int i2, View view, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), view, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (this.v == 0 && this.T && this.f60534a == null && view != null && this.u) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int headerViewsCount = i2 + getHeaderViewsCount();
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                this.m = headerViewsCount;
                this.f60542i = headerViewsCount;
                this.v = 4;
                this.R = 0;
                this.R = i3 | 0;
                this.f60534a = view;
                i();
                this.n = i4;
                this.o = i5;
                int i6 = this.N;
                this.Q = i6;
                Point point = this.f60535b;
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
        return invokeCommon.booleanValue;
    }

    /* loaded from: classes10.dex */
    public class g extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f60564a;

        /* renamed from: d  reason: collision with root package name */
        public int f60565d;

        /* renamed from: e  reason: collision with root package name */
        public int f60566e;

        /* renamed from: f  reason: collision with root package name */
        public float f60567f;

        /* renamed from: g  reason: collision with root package name */
        public float f60568g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(DragSortListView dragSortListView, float f2, int i2) {
            super(dragSortListView, f2, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragSortListView, Float.valueOf(f2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((DragSortListView) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60564a = dragSortListView;
        }

        private int e() {
            InterceptResult invokeV;
            int bottom;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                int firstVisiblePosition = this.f60564a.getFirstVisiblePosition();
                int dividerHeight = (this.f60564a.w + this.f60564a.getDividerHeight()) / 2;
                View childAt = this.f60564a.getChildAt(this.f60565d - firstVisiblePosition);
                if (childAt != null) {
                    int i2 = this.f60565d;
                    int i3 = this.f60566e;
                    if (i2 == i3) {
                        return childAt.getTop();
                    }
                    if (i2 < i3) {
                        bottom = childAt.getTop();
                    } else {
                        bottom = childAt.getBottom() + dividerHeight;
                        dividerHeight = this.f60564a.x;
                    }
                    return bottom - dividerHeight;
                }
                d();
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60565d = this.f60564a.f60542i;
                this.f60566e = this.f60564a.m;
                this.f60564a.v = 2;
                this.f60567f = this.f60564a.f60535b.y - e();
                this.f60568g = this.f60564a.f60535b.x - this.f60564a.getPaddingLeft();
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f60564a.c();
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                int e2 = e();
                float paddingLeft = this.f60564a.f60535b.x - this.f60564a.getPaddingLeft();
                float f4 = 1.0f - f3;
                if (f4 < Math.abs((this.f60564a.f60535b.y - e2) / this.f60567f) || f4 < Math.abs(paddingLeft / this.f60568g)) {
                    this.f60564a.f60535b.y = e2 + ((int) (this.f60567f * f4));
                    this.f60564a.f60535b.x = this.f60564a.getPaddingLeft() + ((int) (this.f60568g * f4));
                    this.f60564a.a(true);
                }
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.m = -1;
            this.j = -1;
            this.k = -1;
            this.f60542i = -1;
        }
    }

    /* loaded from: classes10.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f60569a;

        /* renamed from: b  reason: collision with root package name */
        public SparseIntArray f60570b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Integer> f60571c;

        /* renamed from: d  reason: collision with root package name */
        public int f60572d;

        public j(DragSortListView dragSortListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragSortListView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60569a = dragSortListView;
            this.f60570b = new SparseIntArray(i2);
            this.f60571c = new ArrayList<>(i2);
            this.f60572d = i2;
        }

        public void a(int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (i4 = this.f60570b.get(i2, -1)) == i3) {
                return;
            }
            if (i4 == -1) {
                if (this.f60570b.size() == this.f60572d) {
                    this.f60570b.delete(this.f60571c.remove(0).intValue());
                }
            } else {
                this.f60571c.remove(Integer.valueOf(i2));
            }
            this.f60570b.put(i2, i3);
            this.f60571c.add(Integer.valueOf(i2));
        }

        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f60570b.get(i2, -1) : invokeI.intValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f60570b.clear();
                this.f60571c.clear();
            }
        }
    }

    private void a(int i2, Canvas canvas) {
        ViewGroup viewGroup;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65548, this, i2, canvas) == null) {
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
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65561, this, i2) == null) {
            this.v = 1;
            m mVar = this.t;
            if (mVar != null) {
                mVar.a(i2);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(int i2) {
        InterceptResult invokeI;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, this, i2)) == null) {
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
        return invokeI.intValue;
    }

    /* loaded from: classes10.dex */
    public class l extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f60576a;

        /* renamed from: d  reason: collision with root package name */
        public float f60577d;

        /* renamed from: e  reason: collision with root package name */
        public float f60578e;

        /* renamed from: f  reason: collision with root package name */
        public float f60579f;

        /* renamed from: g  reason: collision with root package name */
        public int f60580g;

        /* renamed from: h  reason: collision with root package name */
        public int f60581h;

        /* renamed from: i  reason: collision with root package name */
        public int f60582i;
        public int j;
        public int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(DragSortListView dragSortListView, float f2, int i2) {
            super(dragSortListView, f2, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dragSortListView, Float.valueOf(f2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((DragSortListView) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60576a = dragSortListView;
            this.f60580g = -1;
            this.f60581h = -1;
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60580g = -1;
                this.f60581h = -1;
                this.f60582i = this.f60576a.j;
                this.j = this.f60576a.k;
                this.k = this.f60576a.m;
                this.f60576a.v = 1;
                this.f60577d = this.f60576a.f60535b.x;
                if (!this.f60576a.al) {
                    this.f60576a.k();
                    return;
                }
                float width = this.f60576a.getWidth() * 2.0f;
                if (this.f60576a.am != 0.0f) {
                    float f2 = width * 2.0f;
                    if (this.f60576a.am < 0.0f) {
                        float f3 = -f2;
                        if (this.f60576a.am > f3) {
                            this.f60576a.am = f3;
                            return;
                        }
                    }
                    if (this.f60576a.am <= 0.0f || this.f60576a.am >= f2) {
                        return;
                    }
                    this.f60576a.am = f2;
                    return;
                }
                this.f60576a.am = (this.f60577d >= 0.0f ? 1 : -1) * width;
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f60576a.d();
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            View childAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                float f4 = 1.0f - f3;
                int firstVisiblePosition = this.f60576a.getFirstVisiblePosition();
                View childAt2 = this.f60576a.getChildAt(this.f60582i - firstVisiblePosition);
                if (this.f60576a.al) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f60584b)) / 1000.0f;
                    if (uptimeMillis == 0.0f) {
                        return;
                    }
                    float f5 = this.f60576a.am * uptimeMillis;
                    int width = this.f60576a.getWidth();
                    DragSortListView dragSortListView = this.f60576a;
                    float f6 = (this.f60576a.am > 0.0f ? 1 : -1) * uptimeMillis;
                    float f7 = width;
                    dragSortListView.am = dragSortListView.am + (f6 * f7);
                    this.f60577d += f5;
                    Point point = this.f60576a.f60535b;
                    float f8 = this.f60577d;
                    point.x = (int) f8;
                    if (f8 < f7 && f8 > (-width)) {
                        this.f60584b = SystemClock.uptimeMillis();
                        this.f60576a.a(true);
                        return;
                    }
                }
                if (childAt2 != null) {
                    if (this.f60580g == -1) {
                        this.f60580g = this.f60576a.b(this.f60582i, childAt2, false);
                        this.f60578e = childAt2.getHeight() - this.f60580g;
                    }
                    int max = Math.max((int) (this.f60578e * f4), 1);
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    layoutParams.height = this.f60580g + max;
                    childAt2.setLayoutParams(layoutParams);
                }
                int i2 = this.j;
                if (i2 == this.f60582i || (childAt = this.f60576a.getChildAt(i2 - firstVisiblePosition)) == null) {
                    return;
                }
                if (this.f60581h == -1) {
                    this.f60581h = this.f60576a.b(this.j, childAt, false);
                    this.f60579f = childAt.getHeight() - this.f60581h;
                }
                int max2 = Math.max((int) (f4 * this.f60579f), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = this.f60581h + max2;
                childAt.setLayoutParams(layoutParams2);
            }
        }
    }

    private void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65562, this, i2, i3) == null) {
            Point point = this.f60535b;
            point.x = i2 - this.n;
            point.y = i3 - this.o;
            a(true);
            int min = Math.min(i3, this.f60537d + this.y);
            int max = Math.max(i3, this.f60537d - this.y);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            View childAt = getChildAt(i2 - getFirstVisiblePosition());
            if (childAt != null) {
                return childAt.getHeight();
            }
            return c(i2, c(i2));
        }
        return invokeI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r8 <= r7.m) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3)) == null) {
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
        return invokeII.intValue;
    }

    private int c(int i2, View view, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, this, new Object[]{Integer.valueOf(i2), view, Boolean.valueOf(z)})) == null) ? c(i2, b(i2, view, z)) : invokeCommon.intValue;
    }

    private int c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65565, this, i2, i3)) == null) {
            getDividerHeight();
            boolean z = this.l && this.j != this.k;
            int i4 = this.x;
            int i5 = this.w;
            int i6 = i4 - i5;
            int i7 = (int) (this.ab * i6);
            int i8 = this.m;
            return i2 == i8 ? i8 == this.j ? z ? i7 + i5 : i4 : i8 == this.k ? i4 - i7 : i5 : i2 == this.j ? z ? i3 + i7 : i3 + i6 : i2 == this.k ? (i3 + i6) - i7 : i3;
        }
        return invokeII.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i2, View view, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, this, new Object[]{Integer.valueOf(i2), view, Boolean.valueOf(z)})) == null) {
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
        return invokeCommon.intValue;
    }

    private boolean a() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
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
            if (this.f60537d < a2) {
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
                    if (this.f60537d >= a4) {
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
                    if (this.f60537d < a6) {
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
                if (this.f60537d < a2) {
                    int i9 = a2;
                    a2 = i3;
                    i3 = i9;
                }
                int i10 = (int) (this.aa * 0.5f * abs);
                float f3 = i10;
                int i11 = a2 + i10;
                int i12 = i3 - i10;
                int i13 = this.f60537d;
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
            int i14 = this.f60542i;
            if (i4 != i14) {
                b bVar = this.r;
                if (bVar != null) {
                    bVar.a(i14 - headerViewsCount, i4 - headerViewsCount);
                }
                this.f60542i = i4;
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, motionEvent) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Integer.valueOf(i2), view, Boolean.valueOf(z)}) == null) {
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
            if (i2 == this.m && this.f60534a != null) {
                i4 = 4;
            }
            if (i4 != visibility) {
                view.setVisibility(i4);
            }
        }
    }

    private int a(int i2, View view, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Integer.valueOf(i2), view, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
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
        return invokeCommon.intValue;
    }

    private void a(View view) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, view) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
            View childAt = getChildAt(getChildCount() / 2);
            if (childAt == null) {
                return;
            }
            d(firstVisiblePosition, childAt, z);
        }
    }

    public static int a(SparseBooleanArray sparseBooleanArray, int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        int keyAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{sparseBooleanArray, Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) {
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
        return invokeCommon.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r4.keyAt(r5) < r6) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(SparseBooleanArray sparseBooleanArray, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, sparseBooleanArray, i2, i3)) == null) {
            int size = sparseBooleanArray.size();
            int a2 = a(sparseBooleanArray, i2);
            while (a2 < size && sparseBooleanArray.keyAt(a2) < i3 && !sparseBooleanArray.valueAt(a2)) {
                a2++;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static int a(SparseBooleanArray sparseBooleanArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, sparseBooleanArray, i2)) == null) {
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
        return invokeLI.intValue;
    }
}
