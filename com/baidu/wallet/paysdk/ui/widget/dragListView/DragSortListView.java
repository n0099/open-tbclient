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
    public View f61456a;
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
    public Point f61457b;

    /* renamed from: c  reason: collision with root package name */
    public Point f61458c;

    /* renamed from: d  reason: collision with root package name */
    public int f61459d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61460e;

    /* renamed from: f  reason: collision with root package name */
    public DataSetObserver f61461f;

    /* renamed from: g  reason: collision with root package name */
    public float f61462g;

    /* renamed from: h  reason: collision with root package name */
    public float f61463h;

    /* renamed from: i  reason: collision with root package name */
    public int f61464i;
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
        public final /* synthetic */ DragSortListView f61467a;

        /* renamed from: b  reason: collision with root package name */
        public ListAdapter f61468b;

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
            this.f61467a = dragSortListView;
            this.f61468b = listAdapter;
            listAdapter.registerDataSetObserver(new DataSetObserver(this, dragSortListView) { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DragSortListView f61469a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61470b;

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
                    this.f61470b = this;
                    this.f61469a = dragSortListView;
                }

                @Override // android.database.DataSetObserver
                public void onChanged() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f61470b.notifyDataSetChanged();
                    }
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f61470b.notifyDataSetInvalidated();
                    }
                }
            });
        }

        public ListAdapter a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61468b : (ListAdapter) invokeV.objValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61468b.areAllItemsEnabled() : invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61468b.getCount() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f61468b.getItem(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f61468b.getItemId(i2) : invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f61468b.getItemViewType(i2) : invokeI.intValue;
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
                    View view2 = this.f61468b.getView(i2, childAt, this.f61467a);
                    if (view2 != childAt) {
                        if (childAt != null) {
                            dragSortItemView2.removeViewAt(0);
                        }
                        dragSortItemView2.addView(view2);
                    }
                } else {
                    View view3 = this.f61468b.getView(i2, null, this.f61467a);
                    if (view3 instanceof Checkable) {
                        dragSortItemView = new DragSortItemViewCheckable(this.f61467a.getContext());
                    } else {
                        dragSortItemView = new DragSortItemView(this.f61467a.getContext());
                    }
                    dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    dragSortItemView.addView(view3);
                    dragSortItemView2 = dragSortItemView;
                }
                DragSortListView dragSortListView = this.f61467a;
                dragSortListView.a(i2 + dragSortListView.getHeaderViewsCount(), (View) dragSortItemView2, true);
                return dragSortItemView2;
            }
            return (View) invokeILL.objValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f61468b.getViewTypeCount() : invokeV.intValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f61468b.hasStableIds() : invokeV.booleanValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f61468b.isEmpty() : invokeV.booleanValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f61468b.isEnabled(i2) : invokeI.booleanValue;
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
        public final /* synthetic */ DragSortListView f61471a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61472b;

        /* renamed from: c  reason: collision with root package name */
        public long f61473c;

        /* renamed from: d  reason: collision with root package name */
        public long f61474d;

        /* renamed from: e  reason: collision with root package name */
        public int f61475e;

        /* renamed from: f  reason: collision with root package name */
        public float f61476f;

        /* renamed from: g  reason: collision with root package name */
        public long f61477g;

        /* renamed from: h  reason: collision with root package name */
        public int f61478h;

        /* renamed from: i  reason: collision with root package name */
        public float f61479i;
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
            this.f61471a = dragSortListView;
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
                    return this.f61478h;
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f61472b) {
                    this.j = false;
                    return;
                }
                int firstVisiblePosition = this.f61471a.getFirstVisiblePosition();
                int lastVisiblePosition = this.f61471a.getLastVisiblePosition();
                int count = this.f61471a.getCount();
                int paddingTop = this.f61471a.getPaddingTop();
                int height = (this.f61471a.getHeight() - paddingTop) - this.f61471a.getPaddingBottom();
                int min = Math.min(this.f61471a.N, this.f61471a.f61459d + this.f61471a.y);
                int max = Math.max(this.f61471a.N, this.f61471a.f61459d - this.f61471a.y);
                if (this.f61478h == 0) {
                    View childAt = this.f61471a.getChildAt(0);
                    if (childAt == null) {
                        this.j = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.j = false;
                        return;
                    } else {
                        this.f61479i = this.f61471a.L.a((this.f61471a.H - max) / this.f61471a.I, this.f61473c);
                    }
                } else {
                    View childAt2 = this.f61471a.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.j = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.j = false;
                        return;
                    } else {
                        this.f61479i = -this.f61471a.L.a((min - this.f61471a.G) / this.f61471a.J, this.f61473c);
                    }
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f61474d = uptimeMillis;
                float f2 = (float) (uptimeMillis - this.f61473c);
                this.f61476f = f2;
                int round = Math.round(this.f61479i * f2);
                this.f61475e = round;
                if (round >= 0) {
                    this.f61475e = Math.min(height, round);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.f61475e = Math.max(-height, round);
                }
                View childAt3 = this.f61471a.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.f61475e;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                this.f61471a.af = true;
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f61471a.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                }
                this.f61471a.layoutChildren();
                this.f61471a.invalidate();
                this.f61471a.af = false;
                this.f61471a.d(lastVisiblePosition, childAt3, false);
                this.f61473c = this.f61474d;
                this.f61471a.post(this);
            }
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.j) {
                return;
            }
            this.f61472b = false;
            this.j = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f61477g = uptimeMillis;
            this.f61473c = uptimeMillis;
            this.f61478h = i2;
            this.f61471a.post(this);
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f61471a.removeCallbacks(this);
                    this.j = false;
                    return;
                }
                this.f61472b = true;
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
        public StringBuilder f61480a;

        /* renamed from: b  reason: collision with root package name */
        public File f61481b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f61482c;

        /* renamed from: d  reason: collision with root package name */
        public int f61483d;

        /* renamed from: e  reason: collision with root package name */
        public int f61484e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f61485f;

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61480a.append("<DSLVStates>\n");
                this.f61484e = 0;
                this.f61485f = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f61485f) {
                this.f61480a.append("<DSLVState>\n");
                int childCount = this.f61482c.getChildCount();
                int firstVisiblePosition = this.f61482c.getFirstVisiblePosition();
                this.f61480a.append("    <Positions>");
                for (int i2 = 0; i2 < childCount; i2++) {
                    StringBuilder sb = this.f61480a;
                    sb.append(firstVisiblePosition + i2);
                    sb.append(",");
                }
                this.f61480a.append("</Positions>\n");
                this.f61480a.append("    <Tops>");
                for (int i3 = 0; i3 < childCount; i3++) {
                    StringBuilder sb2 = this.f61480a;
                    sb2.append(this.f61482c.getChildAt(i3).getTop());
                    sb2.append(",");
                }
                this.f61480a.append("</Tops>\n");
                this.f61480a.append("    <Bottoms>");
                for (int i4 = 0; i4 < childCount; i4++) {
                    StringBuilder sb3 = this.f61480a;
                    sb3.append(this.f61482c.getChildAt(i4).getBottom());
                    sb3.append(",");
                }
                this.f61480a.append("</Bottoms>\n");
                StringBuilder sb4 = this.f61480a;
                sb4.append("    <FirstExpPos>");
                sb4.append(this.f61482c.j);
                sb4.append("</FirstExpPos>\n");
                StringBuilder sb5 = this.f61480a;
                sb5.append("    <FirstExpBlankHeight>");
                DragSortListView dragSortListView = this.f61482c;
                int a2 = dragSortListView.a(dragSortListView.j);
                DragSortListView dragSortListView2 = this.f61482c;
                sb5.append(a2 - dragSortListView2.c(dragSortListView2.j));
                sb5.append("</FirstExpBlankHeight>\n");
                StringBuilder sb6 = this.f61480a;
                sb6.append("    <SecondExpPos>");
                sb6.append(this.f61482c.k);
                sb6.append("</SecondExpPos>\n");
                StringBuilder sb7 = this.f61480a;
                sb7.append("    <SecondExpBlankHeight>");
                DragSortListView dragSortListView3 = this.f61482c;
                int a3 = dragSortListView3.a(dragSortListView3.k);
                DragSortListView dragSortListView4 = this.f61482c;
                sb7.append(a3 - dragSortListView4.c(dragSortListView4.k));
                sb7.append("</SecondExpBlankHeight>\n");
                StringBuilder sb8 = this.f61480a;
                sb8.append("    <SrcPos>");
                sb8.append(this.f61482c.m);
                sb8.append("</SrcPos>\n");
                StringBuilder sb9 = this.f61480a;
                sb9.append("    <SrcHeight>");
                sb9.append(this.f61482c.x + this.f61482c.getDividerHeight());
                sb9.append("</SrcHeight>\n");
                StringBuilder sb10 = this.f61480a;
                sb10.append("    <ViewHeight>");
                sb10.append(this.f61482c.getHeight());
                sb10.append("</ViewHeight>\n");
                StringBuilder sb11 = this.f61480a;
                sb11.append("    <LastY>");
                sb11.append(this.f61482c.P);
                sb11.append("</LastY>\n");
                StringBuilder sb12 = this.f61480a;
                sb12.append("    <FloatY>");
                sb12.append(this.f61482c.f61459d);
                sb12.append("</FloatY>\n");
                this.f61480a.append("    <ShuffleEdges>");
                for (int i5 = 0; i5 < childCount; i5++) {
                    StringBuilder sb13 = this.f61480a;
                    DragSortListView dragSortListView5 = this.f61482c;
                    sb13.append(dragSortListView5.a(firstVisiblePosition + i5, dragSortListView5.getChildAt(i5).getTop()));
                    sb13.append(",");
                }
                this.f61480a.append("</ShuffleEdges>\n");
                this.f61480a.append("</DSLVState>\n");
                int i6 = this.f61483d + 1;
                this.f61483d = i6;
                if (i6 > 1000) {
                    c();
                    this.f61483d = 0;
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f61485f) {
                try {
                    FileWriter fileWriter = new FileWriter(this.f61481b, this.f61484e != 0);
                    fileWriter.write(this.f61480a.toString());
                    this.f61480a.delete(0, this.f61480a.length());
                    fileWriter.flush();
                    fileWriter.close();
                    this.f61484e++;
                } catch (IOException unused) {
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f61485f) {
                this.f61480a.append("</DSLVStates>\n");
                c();
                this.f61485f = false;
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
        public float f61505a;

        /* renamed from: b  reason: collision with root package name */
        public long f61506b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f61507c;

        /* renamed from: d  reason: collision with root package name */
        public float f61508d;

        /* renamed from: e  reason: collision with root package name */
        public float f61509e;

        /* renamed from: f  reason: collision with root package name */
        public float f61510f;

        /* renamed from: g  reason: collision with root package name */
        public float f61511g;

        /* renamed from: h  reason: collision with root package name */
        public float f61512h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f61513i;

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
            this.f61507c = dragSortListView;
            this.f61508d = f2;
            this.f61505a = i2;
            float f3 = 1.0f / ((f2 * 2.0f) * (1.0f - f2));
            this.f61512h = f3;
            this.f61509e = f3;
            this.f61510f = f2 / ((f2 - 1.0f) * 2.0f);
            this.f61511g = 1.0f / (1.0f - f2);
        }

        public float a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f3 = this.f61508d;
                if (f2 < f3) {
                    return this.f61509e * f2 * f2;
                }
                if (f2 < 1.0f - f3) {
                    return this.f61510f + (this.f61511g * f2);
                }
                float f4 = f2 - 1.0f;
                return 1.0f - ((this.f61512h * f4) * f4);
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
                this.f61506b = SystemClock.uptimeMillis();
                this.f61513i = false;
                a();
                this.f61507c.post(this);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f61513i = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f61513i) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f61506b)) / this.f61505a;
            if (uptimeMillis >= 1.0f) {
                a(1.0f, 1.0f);
                b();
                return;
            }
            a(uptimeMillis, a(uptimeMillis));
            this.f61507c.post(this);
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
        this.f61457b = new Point();
        this.f61458c = new Point();
        this.f61460e = false;
        this.f61462g = 0.6f;
        this.f61463h = 0.6f;
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
            public final /* synthetic */ DragSortListView f61465a;

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
                this.f61465a = this;
            }

            @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.c
            public float a(float f2, long j2) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Long.valueOf(j2)})) == null) ? this.f61465a.K * f2 : invokeCommon.floatValue;
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
        this.f61461f = new DataSetObserver(this) { // from class: com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DragSortListView f61466a;

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
                this.f61466a = this;
            }

            private void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(65537, this) == null) && this.f61466a.v == 4) {
                    this.f61466a.cancelDrag();
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
            View view = this.f61456a;
            if (view != null) {
                int width = view.getWidth();
                int height = this.f61456a.getHeight();
                int i4 = this.f61457b.x;
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
                Point point = this.f61457b;
                canvas.translate(point.x, point.y);
                canvas.clipRect(0, 0, width, height);
                canvas.saveLayerAlpha(0.0f, 0.0f, width, height, (int) (this.f61463h * 255.0f * f2), 31);
                this.f61456a.draw(canvas);
                canvas.restore();
                canvas.restore();
            }
        }
    }

    public float getFloatAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61463h : invokeV.floatValue;
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
            View view = this.f61456a;
            if (view != null) {
                if (view.isLayoutRequested() && !this.f61460e) {
                    i();
                }
                View view2 = this.f61456a;
                view2.layout(0, 0, view2.getMeasuredWidth(), this.f61456a.getMeasuredHeight());
                this.f61460e = false;
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
            if (this.f61456a != null) {
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
            View view = this.f61456a;
            if (view != null) {
                if (view.isLayoutRequested()) {
                    i();
                }
                this.f61460e = true;
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
            this.f61463h = f2;
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
        public final /* synthetic */ DragSortListView f61495a;

        /* renamed from: d  reason: collision with root package name */
        public float f61496d;

        /* renamed from: e  reason: collision with root package name */
        public float f61497e;

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61496d = this.f61495a.o;
                this.f61497e = this.f61495a.y;
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (this.f61495a.v == 4) {
                    this.f61495a.o = (int) ((this.f61497e * f3) + ((1.0f - f3) * this.f61496d));
                    this.f61495a.f61457b.y = this.f61495a.N - this.f61495a.o;
                    this.f61495a.a(true);
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
            this.f61463h = this.f61462g;
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
        if (!(interceptable == null || interceptable.invokeV(65584, this) == null) || (view = this.f61456a) == null) {
            return;
        }
        a(view);
        int measuredHeight = this.f61456a.getMeasuredHeight();
        this.x = measuredHeight;
        this.y = measuredHeight / 2;
    }

    private void j() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            if (this.U != null) {
                this.f61458c.set(this.M, this.N);
                this.U.a(this.f61456a, this.f61457b, this.f61458c);
            }
            Point point = this.f61457b;
            int i4 = point.x;
            int i5 = point.y;
            int paddingLeft = getPaddingLeft();
            if ((this.R & 1) == 0 && i4 > paddingLeft) {
                this.f61457b.x = paddingLeft;
            } else if ((this.R & 2) == 0 && i4 < paddingLeft) {
                this.f61457b.x = paddingLeft;
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
                this.f61457b.y = paddingTop;
            } else {
                int i6 = this.x;
                if (i5 + i6 > height) {
                    this.f61457b.y = height - i6;
                }
            }
            this.f61459d = this.f61457b.y + this.y;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65587, this) == null) || (view = this.f61456a) == null) {
            return;
        }
        view.setVisibility(8);
        i iVar = this.U;
        if (iVar != null) {
            iVar.a(this.f61456a);
        }
        this.f61456a = null;
        invalidate();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, listAdapter) == null) {
            if (listAdapter != null) {
                this.ac = new a(this, listAdapter);
                listAdapter.registerDataSetObserver(this.f61461f);
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
                    this.f61464i = headerViewsCount;
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
            if (this.f61456a != null) {
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
            if (this.s != null && (i2 = this.f61464i) >= 0 && i2 < getCount()) {
                int headerViewsCount = getHeaderViewsCount();
                this.s.a_(this.m - headerViewsCount, this.f61464i - headerViewsCount);
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
            if (this.v == 0 && this.T && this.f61456a == null && view != null && this.u) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int headerViewsCount = i2 + getHeaderViewsCount();
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                this.m = headerViewsCount;
                this.f61464i = headerViewsCount;
                this.v = 4;
                this.R = 0;
                this.R = i3 | 0;
                this.f61456a = view;
                i();
                this.n = i4;
                this.o = i5;
                int i6 = this.N;
                this.Q = i6;
                Point point = this.f61457b;
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
        public final /* synthetic */ DragSortListView f61486a;

        /* renamed from: d  reason: collision with root package name */
        public int f61487d;

        /* renamed from: e  reason: collision with root package name */
        public int f61488e;

        /* renamed from: f  reason: collision with root package name */
        public float f61489f;

        /* renamed from: g  reason: collision with root package name */
        public float f61490g;

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
            this.f61486a = dragSortListView;
        }

        private int e() {
            InterceptResult invokeV;
            int bottom;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                int firstVisiblePosition = this.f61486a.getFirstVisiblePosition();
                int dividerHeight = (this.f61486a.w + this.f61486a.getDividerHeight()) / 2;
                View childAt = this.f61486a.getChildAt(this.f61487d - firstVisiblePosition);
                if (childAt != null) {
                    int i2 = this.f61487d;
                    int i3 = this.f61488e;
                    if (i2 == i3) {
                        return childAt.getTop();
                    }
                    if (i2 < i3) {
                        bottom = childAt.getTop();
                    } else {
                        bottom = childAt.getBottom() + dividerHeight;
                        dividerHeight = this.f61486a.x;
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
                this.f61487d = this.f61486a.f61464i;
                this.f61488e = this.f61486a.m;
                this.f61486a.v = 2;
                this.f61489f = this.f61486a.f61457b.y - e();
                this.f61490g = this.f61486a.f61457b.x - this.f61486a.getPaddingLeft();
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f61486a.c();
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                int e2 = e();
                float paddingLeft = this.f61486a.f61457b.x - this.f61486a.getPaddingLeft();
                float f4 = 1.0f - f3;
                if (f4 < Math.abs((this.f61486a.f61457b.y - e2) / this.f61489f) || f4 < Math.abs(paddingLeft / this.f61490g)) {
                    this.f61486a.f61457b.y = e2 + ((int) (this.f61489f * f4));
                    this.f61486a.f61457b.x = this.f61486a.getPaddingLeft() + ((int) (this.f61490g * f4));
                    this.f61486a.a(true);
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
            this.f61464i = -1;
        }
    }

    /* loaded from: classes10.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragSortListView f61491a;

        /* renamed from: b  reason: collision with root package name */
        public SparseIntArray f61492b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Integer> f61493c;

        /* renamed from: d  reason: collision with root package name */
        public int f61494d;

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
            this.f61491a = dragSortListView;
            this.f61492b = new SparseIntArray(i2);
            this.f61493c = new ArrayList<>(i2);
            this.f61494d = i2;
        }

        public void a(int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (i4 = this.f61492b.get(i2, -1)) == i3) {
                return;
            }
            if (i4 == -1) {
                if (this.f61492b.size() == this.f61494d) {
                    this.f61492b.delete(this.f61493c.remove(0).intValue());
                }
            } else {
                this.f61493c.remove(Integer.valueOf(i2));
            }
            this.f61492b.put(i2, i3);
            this.f61493c.add(Integer.valueOf(i2));
        }

        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f61492b.get(i2, -1) : invokeI.intValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f61492b.clear();
                this.f61493c.clear();
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
        public final /* synthetic */ DragSortListView f61498a;

        /* renamed from: d  reason: collision with root package name */
        public float f61499d;

        /* renamed from: e  reason: collision with root package name */
        public float f61500e;

        /* renamed from: f  reason: collision with root package name */
        public float f61501f;

        /* renamed from: g  reason: collision with root package name */
        public int f61502g;

        /* renamed from: h  reason: collision with root package name */
        public int f61503h;

        /* renamed from: i  reason: collision with root package name */
        public int f61504i;
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
            this.f61498a = dragSortListView;
            this.f61502g = -1;
            this.f61503h = -1;
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f61502g = -1;
                this.f61503h = -1;
                this.f61504i = this.f61498a.j;
                this.j = this.f61498a.k;
                this.k = this.f61498a.m;
                this.f61498a.v = 1;
                this.f61499d = this.f61498a.f61457b.x;
                if (!this.f61498a.al) {
                    this.f61498a.k();
                    return;
                }
                float width = this.f61498a.getWidth() * 2.0f;
                if (this.f61498a.am != 0.0f) {
                    float f2 = width * 2.0f;
                    if (this.f61498a.am < 0.0f) {
                        float f3 = -f2;
                        if (this.f61498a.am > f3) {
                            this.f61498a.am = f3;
                            return;
                        }
                    }
                    if (this.f61498a.am <= 0.0f || this.f61498a.am >= f2) {
                        return;
                    }
                    this.f61498a.am = f2;
                    return;
                }
                this.f61498a.am = (this.f61499d >= 0.0f ? 1 : -1) * width;
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f61498a.d();
            }
        }

        @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.n
        public void a(float f2, float f3) {
            View childAt;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                float f4 = 1.0f - f3;
                int firstVisiblePosition = this.f61498a.getFirstVisiblePosition();
                View childAt2 = this.f61498a.getChildAt(this.f61504i - firstVisiblePosition);
                if (this.f61498a.al) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f61506b)) / 1000.0f;
                    if (uptimeMillis == 0.0f) {
                        return;
                    }
                    float f5 = this.f61498a.am * uptimeMillis;
                    int width = this.f61498a.getWidth();
                    DragSortListView dragSortListView = this.f61498a;
                    float f6 = (this.f61498a.am > 0.0f ? 1 : -1) * uptimeMillis;
                    float f7 = width;
                    dragSortListView.am = dragSortListView.am + (f6 * f7);
                    this.f61499d += f5;
                    Point point = this.f61498a.f61457b;
                    float f8 = this.f61499d;
                    point.x = (int) f8;
                    if (f8 < f7 && f8 > (-width)) {
                        this.f61506b = SystemClock.uptimeMillis();
                        this.f61498a.a(true);
                        return;
                    }
                }
                if (childAt2 != null) {
                    if (this.f61502g == -1) {
                        this.f61502g = this.f61498a.b(this.f61504i, childAt2, false);
                        this.f61500e = childAt2.getHeight() - this.f61502g;
                    }
                    int max = Math.max((int) (this.f61500e * f4), 1);
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    layoutParams.height = this.f61502g + max;
                    childAt2.setLayoutParams(layoutParams);
                }
                int i2 = this.j;
                if (i2 == this.f61504i || (childAt = this.f61498a.getChildAt(i2 - firstVisiblePosition)) == null) {
                    return;
                }
                if (this.f61503h == -1) {
                    this.f61503h = this.f61498a.b(this.j, childAt, false);
                    this.f61501f = childAt.getHeight() - this.f61503h;
                }
                int max2 = Math.max((int) (f4 * this.f61501f), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = this.f61503h + max2;
                childAt.setLayoutParams(layoutParams2);
            }
        }
    }

    private void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65562, this, i2, i3) == null) {
            Point point = this.f61457b;
            point.x = i2 - this.n;
            point.y = i3 - this.o;
            a(true);
            int min = Math.min(i3, this.f61459d + this.y);
            int max = Math.max(i3, this.f61459d - this.y);
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
            if (this.f61459d < a2) {
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
                    if (this.f61459d >= a4) {
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
                    if (this.f61459d < a6) {
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
                if (this.f61459d < a2) {
                    int i9 = a2;
                    a2 = i3;
                    i3 = i9;
                }
                int i10 = (int) (this.aa * 0.5f * abs);
                float f3 = i10;
                int i11 = a2 + i10;
                int i12 = i3 - i10;
                int i13 = this.f61459d;
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
            int i14 = this.f61464i;
            if (i4 != i14) {
                b bVar = this.r;
                if (bVar != null) {
                    bVar.a(i14 - headerViewsCount, i4 - headerViewsCount);
                }
                this.f61464i = i4;
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
            if (i2 == this.m && this.f61456a != null) {
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
