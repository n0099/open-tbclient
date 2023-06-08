package com.baidu.tieba;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
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
import com.baidu.tbadk.widget.dragsort.DragSortItemView;
import com.baidu.tbadk.widget.dragsort.DragSortItemViewCheckable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class zy5 implements bz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public int C;
    public int D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public e J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public j Q;
    public MotionEvent R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public float f1192T;
    public float U;
    public c V;
    public boolean W;
    public g X;
    public boolean Y;
    public boolean Z;
    public View a;
    public k a0;
    public Point b;
    public m b0;
    public Point c;
    public l c0;
    public int d;
    public h d0;
    public boolean e;
    public boolean e0;
    public DataSetObserver f;
    public float f0;
    public float g;
    public ListView g0;
    public float h;
    public cz5 h0;
    public int i;
    public az5 i0;
    public int j;
    public boolean j0;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public d p;
    public i q;
    public n r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public View[] y;
    public f z;

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface e {
        float a(float f, long j);
    }

    /* loaded from: classes8.dex */
    public interface i {
        void a(int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a(View view2);

        View b(int i);

        void c(View view2, Point point, Point point2);
    }

    /* loaded from: classes8.dex */
    public class l extends o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface n {
        void remove(int i);
    }

    /* loaded from: classes8.dex */
    public class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ListAdapter a;
        public final /* synthetic */ zy5 b;

        /* loaded from: classes8.dex */
        public class a extends DataSetObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar, zy5 zy5Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, zy5Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.notifyDataSetChanged();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.notifyDataSetInvalidated();
                }
            }
        }

        public c(zy5 zy5Var, ListAdapter listAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var, listAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy5Var;
            this.a = listAdapter;
            listAdapter.registerDataSetObserver(new a(this, zy5Var));
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.areAllItemsEnabled();
            }
            return invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.getCount();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a.getViewTypeCount();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.a.hasStableIds();
            }
            return invokeV.booleanValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.a.isEmpty();
            }
            return invokeV.booleanValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.a.getItem(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.a.getItemId(i);
            }
            return invokeI.longValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return this.a.getItemViewType(i);
            }
            return invokeI.intValue;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
                return this.a.isEnabled(i);
            }
            return invokeI.booleanValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
                if (view2 != null) {
                    dragSortItemView2 = (DragSortItemView) view2;
                    View childAt = dragSortItemView2.getChildAt(0);
                    View view3 = this.a.getView(i, childAt, this.b.g0);
                    if (view3 != childAt) {
                        if (childAt != null) {
                            dragSortItemView2.removeViewAt(0);
                        }
                        dragSortItemView2.addView(view3);
                    }
                } else {
                    View view4 = this.a.getView(i, null, this.b.g0);
                    if (view4 instanceof Checkable) {
                        dragSortItemView = new DragSortItemViewCheckable(this.b.g0.getContext());
                    } else {
                        dragSortItemView = new DragSortItemView(this.b.g0.getContext());
                    }
                    dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                    dragSortItemView.addView(view4);
                    dragSortItemView2 = dragSortItemView;
                }
                zy5 zy5Var = this.b;
                zy5Var.M(i + zy5Var.g0.getHeaderViewsCount(), dragSortItemView2, true);
                return dragSortItemView2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public a(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        @Override // com.baidu.tieba.zy5.e
        public float a(float f, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Long.valueOf(j)})) == null) {
                return this.a.I * f;
            }
            return invokeCommon.floatValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy5 a;

        public b(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy5Var;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t == 4) {
                this.a.R();
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public long b;
        public long c;
        public int d;
        public float e;
        public long f;
        public int g;
        public float h;
        public boolean i;
        public final /* synthetic */ zy5 j;

        public f(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = zy5Var;
            this.i = false;
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && !this.i) {
                this.a = false;
                this.i = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f = uptimeMillis;
                this.b = uptimeMillis;
                this.g = i;
                this.j.g0.post(this);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (z) {
                    this.j.g0.removeCallbacks(this);
                    this.i = false;
                    return;
                }
                this.a = true;
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.i) {
                    return this.g;
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.i;
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.a) {
                    this.i = false;
                    return;
                }
                int firstVisiblePosition = this.j.g0.getFirstVisiblePosition();
                int lastVisiblePosition = this.j.g0.getLastVisiblePosition();
                int count = this.j.g0.getCount();
                int paddingTop = this.j.g0.getPaddingTop();
                int height = (this.j.g0.getHeight() - paddingTop) - this.j.g0.getPaddingBottom();
                int min = Math.min(this.j.L, this.j.d + this.j.w);
                int max = Math.max(this.j.L, this.j.d - this.j.w);
                if (this.g == 0) {
                    View childAt = this.j.g0.getChildAt(0);
                    if (childAt == null) {
                        this.i = false;
                        return;
                    } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.i = false;
                        return;
                    } else {
                        this.h = this.j.J.a((this.j.F - max) / this.j.G, this.b);
                    }
                } else {
                    View childAt2 = this.j.g0.getChildAt(lastVisiblePosition - firstVisiblePosition);
                    if (childAt2 == null) {
                        this.i = false;
                        return;
                    } else if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.i = false;
                        return;
                    } else {
                        this.h = -this.j.J.a((min - this.j.E) / this.j.H, this.b);
                    }
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                this.c = uptimeMillis;
                float f = (float) (uptimeMillis - this.b);
                this.e = f;
                int round = Math.round(this.h * f);
                this.d = round;
                if (round >= 0) {
                    this.d = Math.min(height, round);
                    lastVisiblePosition = firstVisiblePosition;
                } else {
                    this.d = Math.max(-height, round);
                }
                View childAt3 = this.j.g0.getChildAt(lastVisiblePosition - firstVisiblePosition);
                int top = childAt3.getTop() + this.d;
                if (lastVisiblePosition == 0 && top > paddingTop) {
                    top = paddingTop;
                }
                this.j.Y = true;
                this.j.g0.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
                this.j.a();
                this.j.g0.invalidate();
                this.j.Y = false;
                this.j.W(lastVisiblePosition, childAt3, false);
                this.b = this.c;
                this.j.g0.post(this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public StringBuilder a;
        public File b;
        public int c;
        public int d;
        public boolean e;
        public final /* synthetic */ zy5 f;

        public g(zy5 zy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = zy5Var;
            this.a = new StringBuilder();
            this.c = 0;
            this.d = 0;
            this.e = false;
            File file = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            this.b = file;
            if (!file.exists()) {
                try {
                    this.b.createNewFile();
                    Log.d("mobeta", "file created");
                } catch (IOException e) {
                    Log.w("mobeta", "Could not create dslv_state.txt");
                    Log.d("mobeta", e.getMessage());
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.e) {
                return;
            }
            this.a.append("<DSLVState>\n");
            int childCount = this.f.g0.getChildCount();
            int firstVisiblePosition = this.f.g0.getFirstVisiblePosition();
            this.a.append("    <Positions>");
            for (int i = 0; i < childCount; i++) {
                StringBuilder sb = this.a;
                sb.append(firstVisiblePosition + i);
                sb.append(",");
            }
            this.a.append("</Positions>\n");
            this.a.append("    <Tops>");
            for (int i2 = 0; i2 < childCount; i2++) {
                StringBuilder sb2 = this.a;
                sb2.append(this.f.g0.getChildAt(i2).getTop());
                sb2.append(",");
            }
            this.a.append("</Tops>\n");
            this.a.append("    <Bottoms>");
            for (int i3 = 0; i3 < childCount; i3++) {
                StringBuilder sb3 = this.a;
                sb3.append(this.f.g0.getChildAt(i3).getBottom());
                sb3.append(",");
            }
            this.a.append("</Bottoms>\n");
            StringBuilder sb4 = this.a;
            sb4.append("    <FirstExpPos>");
            sb4.append(this.f.j);
            sb4.append("</FirstExpPos>\n");
            StringBuilder sb5 = this.a;
            sb5.append("    <FirstExpBlankHeight>");
            zy5 zy5Var = this.f;
            int e0 = zy5Var.e0(zy5Var.j);
            zy5 zy5Var2 = this.f;
            sb5.append(e0 - zy5Var2.c0(zy5Var2.j));
            sb5.append("</FirstExpBlankHeight>\n");
            StringBuilder sb6 = this.a;
            sb6.append("    <SecondExpPos>");
            sb6.append(this.f.k);
            sb6.append("</SecondExpPos>\n");
            StringBuilder sb7 = this.a;
            sb7.append("    <SecondExpBlankHeight>");
            zy5 zy5Var3 = this.f;
            int e02 = zy5Var3.e0(zy5Var3.k);
            zy5 zy5Var4 = this.f;
            sb7.append(e02 - zy5Var4.c0(zy5Var4.k));
            sb7.append("</SecondExpBlankHeight>\n");
            StringBuilder sb8 = this.a;
            sb8.append("    <SrcPos>");
            sb8.append(this.f.m);
            sb8.append("</SrcPos>\n");
            StringBuilder sb9 = this.a;
            sb9.append("    <SrcHeight>");
            sb9.append(this.f.v + this.f.g0.getDividerHeight());
            sb9.append("</SrcHeight>\n");
            StringBuilder sb10 = this.a;
            sb10.append("    <ViewHeight>");
            sb10.append(this.f.g0.getHeight());
            sb10.append("</ViewHeight>\n");
            StringBuilder sb11 = this.a;
            sb11.append("    <LastY>");
            sb11.append(this.f.M);
            sb11.append("</LastY>\n");
            StringBuilder sb12 = this.a;
            sb12.append("    <FloatY>");
            sb12.append(this.f.d);
            sb12.append("</FloatY>\n");
            this.a.append("    <ShuffleEdges>");
            for (int i4 = 0; i4 < childCount; i4++) {
                StringBuilder sb13 = this.a;
                zy5 zy5Var5 = this.f;
                sb13.append(zy5Var5.f0(firstVisiblePosition + i4, zy5Var5.g0.getChildAt(i4).getTop()));
                sb13.append(",");
            }
            this.a.append("</ShuffleEdges>\n");
            this.a.append("</DSLVState>\n");
            int i5 = this.c + 1;
            this.c = i5;
            if (i5 > 1000) {
                b();
                this.c = 0;
            }
        }

        public void b() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.e) {
                return;
            }
            try {
                if (this.d == 0) {
                    z = false;
                } else {
                    z = true;
                }
                FileWriter fileWriter = new FileWriter(this.b, z);
                fileWriter.write(this.a.toString());
                this.a.delete(0, this.a.length());
                fileWriter.flush();
                fileWriter.close();
                this.d++;
            } catch (IOException unused) {
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.append("<DSLVStates>\n");
                this.d = 0;
                this.e = true;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.e) {
                this.a.append("</DSLVStates>\n");
                b();
                this.e = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int j;
        public int k;
        public float l;
        public float m;
        public final /* synthetic */ zy5 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(zy5 zy5Var, float f, int i) {
            super(zy5Var, f, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var, Float.valueOf(f), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((zy5) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = zy5Var;
        }

        @Override // com.baidu.tieba.zy5.o
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j = this.n.i;
                this.k = this.n.m;
                this.n.t = 2;
                this.l = this.n.b.y - f();
                this.m = this.n.b.x - this.n.g0.getPaddingLeft();
            }
        }

        public final int f() {
            InterceptResult invokeV;
            int bottom;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int firstVisiblePosition = this.n.g0.getFirstVisiblePosition();
                int dividerHeight = (this.n.u + this.n.g0.getDividerHeight()) / 2;
                View childAt = this.n.g0.getChildAt(this.j - firstVisiblePosition);
                if (childAt != null) {
                    int i = this.j;
                    int i2 = this.k;
                    if (i == i2) {
                        return childAt.getTop();
                    }
                    if (i < i2) {
                        bottom = childAt.getTop();
                    } else {
                        bottom = childAt.getBottom() + dividerHeight;
                        dividerHeight = this.n.v;
                    }
                    return bottom - dividerHeight;
                }
                cancel();
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.zy5.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.n.b0();
            }
        }

        @Override // com.baidu.tieba.zy5.o
        public void c(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                int f3 = f();
                float paddingLeft = this.n.b.x - this.n.g0.getPaddingLeft();
                float f4 = 1.0f - f2;
                if (f4 < Math.abs((this.n.b.y - f3) / this.l) || f4 < Math.abs(paddingLeft / this.m)) {
                    this.n.b.y = f3 + ((int) (this.l * f4));
                    this.n.b.x = this.n.g0.getPaddingLeft() + ((int) (this.m * f4));
                    this.n.X(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseIntArray a;
        public ArrayList<Integer> b;
        public int c;

        public k(zy5 zy5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new SparseIntArray(i);
            this.b = new ArrayList<>(i);
            this.c = i;
        }

        public void a(int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && (i3 = this.a.get(i, -1)) != i2) {
                if (i3 == -1) {
                    if (this.a.size() == this.c) {
                        this.a.delete(this.b.remove(0).intValue());
                    }
                } else {
                    this.b.remove(Integer.valueOf(i));
                }
                this.a.put(i, i2);
                this.b.add(Integer.valueOf(i));
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.clear();
                this.b.clear();
            }
        }

        public int c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.a.get(i, -1);
            }
            return invokeI.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class m extends o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float j;
        public float k;
        public float l;
        public int m;
        public int n;
        public int o;
        public int p;
        public final /* synthetic */ zy5 q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(zy5 zy5Var, float f, int i) {
            super(zy5Var, f, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var, Float.valueOf(f), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((zy5) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.q = zy5Var;
            this.m = -1;
            this.n = -1;
        }

        @Override // com.baidu.tieba.zy5.o
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = -1;
                this.m = -1;
                this.n = -1;
                this.o = this.q.j;
                this.p = this.q.k;
                int unused = this.q.m;
                this.q.t = 1;
                this.j = this.q.b.x;
                if (!this.q.e0) {
                    this.q.U();
                    return;
                }
                float width = this.q.g0.getWidth() * 2.0f;
                if (this.q.f0 == 0.0f) {
                    zy5 zy5Var = this.q;
                    if (this.j >= 0.0f) {
                        i = 1;
                    }
                    zy5Var.f0 = i * width;
                    return;
                }
                float f = width * 2.0f;
                if (this.q.f0 < 0.0f) {
                    float f2 = -f;
                    if (this.q.f0 > f2) {
                        this.q.f0 = f2;
                        return;
                    }
                }
                if (this.q.f0 <= 0.0f || this.q.f0 >= f) {
                    return;
                }
                this.q.f0 = f;
            }
        }

        @Override // com.baidu.tieba.zy5.o
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.q.Y();
            }
        }

        @Override // com.baidu.tieba.zy5.o
        public void c(float f, float f2) {
            View childAt;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                float f3 = 1.0f - f2;
                int firstVisiblePosition = this.q.g0.getFirstVisiblePosition();
                View childAt2 = this.q.g0.getChildAt(this.o - firstVisiblePosition);
                if (this.q.e0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.a)) / 1000.0f;
                    if (uptimeMillis == 0.0f) {
                        return;
                    }
                    float f4 = this.q.f0 * uptimeMillis;
                    int width = this.q.g0.getWidth();
                    zy5 zy5Var = this.q;
                    float f5 = zy5Var.f0;
                    if (this.q.f0 > 0.0f) {
                        i = 1;
                    } else {
                        i = -1;
                    }
                    float f6 = i * uptimeMillis;
                    float f7 = width;
                    zy5Var.f0 = f5 + (f6 * f7);
                    this.j += f4;
                    Point point = this.q.b;
                    float f8 = this.j;
                    point.x = (int) f8;
                    if (f8 < f7 && f8 > (-width)) {
                        this.a = SystemClock.uptimeMillis();
                        this.q.X(true);
                        return;
                    }
                }
                if (childAt2 != null) {
                    if (this.m == -1) {
                        this.m = this.q.d0(this.o, childAt2, false);
                        this.k = childAt2.getHeight() - this.m;
                    }
                    int max = Math.max((int) (this.k * f3), 1);
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    layoutParams.height = this.m + max;
                    childAt2.setLayoutParams(layoutParams);
                }
                if (this.p != this.o && (childAt = this.q.g0.getChildAt(this.p - firstVisiblePosition)) != null) {
                    if (this.n == -1) {
                        this.n = this.q.d0(this.p, childAt, false);
                        this.l = childAt.getHeight() - this.n;
                    }
                    int max2 = Math.max((int) (f3 * this.l), 1);
                    ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                    layoutParams2.height = this.n + max2;
                    childAt.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public boolean h;
        public final /* synthetic */ zy5 i;

        public abstract void a();

        public abstract void b();

        public abstract void c(float f, float f2);

        public o(zy5 zy5Var, float f, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy5Var, Float.valueOf(f), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = zy5Var;
            this.c = f;
            this.b = i;
            float f2 = 1.0f / ((f * 2.0f) * (1.0f - f));
            this.g = f2;
            this.d = f2;
            this.e = f / ((f - 1.0f) * 2.0f);
            this.f = 1.0f / (1.0f - f);
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.h = true;
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a = SystemClock.uptimeMillis();
                this.h = false;
                a();
                this.i.g0.post(this);
            }
        }

        public float e(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
                float f2 = this.c;
                if (f < f2) {
                    return this.d * f * f;
                }
                if (f < 1.0f - f2) {
                    return this.e + (this.f * f);
                }
                float f3 = f - 1.0f;
                return 1.0f - ((this.g * f3) * f3);
            }
            return invokeF.floatValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.h) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.a)) / this.b;
            if (uptimeMillis >= 1.0f) {
                c(1.0f, 1.0f);
                b();
                return;
            }
            c(uptimeMillis, e(uptimeMillis));
            this.i.g0.post(this);
        }
    }

    public zy5(ListView listView, cz5 cz5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listView, cz5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new Point();
        this.c = new Point();
        this.e = false;
        this.g = 1.0f;
        this.h = 1.0f;
        this.l = false;
        this.s = true;
        this.t = 0;
        this.u = 1;
        this.x = 0;
        this.y = new View[1];
        this.A = 0.33333334f;
        this.B = 0.33333334f;
        this.I = 0.5f;
        this.J = new a(this);
        this.N = 0;
        this.O = false;
        this.P = false;
        this.Q = null;
        this.S = 0;
        this.f1192T = 0.25f;
        this.U = 0.0f;
        this.W = false;
        this.Y = false;
        this.Z = false;
        this.a0 = new k(this, 3);
        this.f0 = 0.0f;
        this.j0 = false;
        this.h0 = cz5Var;
        this.g0 = listView;
    }

    public final void T(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            Point point = this.b;
            point.x = i2 - this.n;
            point.y = i3 - this.o;
            X(true);
            int min = Math.min(i3, this.d + this.w);
            int max = Math.max(i3, this.d - this.w);
            int a2 = this.z.a();
            if (min > this.M && min > this.D && a2 != 1) {
                if (a2 != -1) {
                    this.z.d(true);
                }
                this.z.c(1);
            } else if (max < this.M && max < this.C && a2 != 0) {
                if (a2 != -1) {
                    this.z.d(true);
                }
                this.z.c(0);
            } else if (max >= this.C && min <= this.D && this.z.b()) {
                this.z.d(true);
            }
        }
    }

    public final void a0(int i2, Canvas canvas) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, canvas) == null) {
            Drawable divider = this.g0.getDivider();
            int dividerHeight = this.g0.getDividerHeight();
            if (divider != null && dividerHeight != 0) {
                ListView listView = this.g0;
                ViewGroup viewGroup = (ViewGroup) listView.getChildAt(i2 - listView.getFirstVisiblePosition());
                if (viewGroup != null) {
                    int paddingLeft = this.g0.getPaddingLeft();
                    int width = this.g0.getWidth() - this.g0.getPaddingRight();
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
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r8 <= r7.m) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int f0(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048603, this, i2, i3)) == null) {
            int headerViewsCount = this.g0.getHeaderViewsCount();
            int footerViewsCount = this.g0.getFooterViewsCount();
            if (i2 > headerViewsCount && i2 < this.g0.getCount() - footerViewsCount) {
                int dividerHeight = this.g0.getDividerHeight();
                int i4 = this.v - this.u;
                int c0 = c0(i2);
                int e0 = e0(i2);
                int i5 = this.k;
                int i6 = this.m;
                if (i5 <= i6) {
                    if (i2 == i5 && this.j != i5) {
                        if (i2 == i6) {
                            i3 += e0;
                            i4 = this.v;
                        } else {
                            i3 += e0 - c0;
                        }
                    } else if (i2 > this.k) {
                    }
                    i3 -= i4;
                } else if (i2 > i6 && i2 <= this.j) {
                    i3 += i4;
                } else {
                    int i7 = this.k;
                    if (i2 == i7 && this.j != i7) {
                        i3 += e0 - c0;
                    }
                }
                if (i2 <= this.m) {
                    return i3 + (((this.v - dividerHeight) - c0(i2 - 1)) / 2);
                }
                return i3 + (((c0 - dividerHeight) - this.v) / 2);
            }
            return i3;
        }
        return invokeII.intValue;
    }

    public void m0(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            int i3 = this.t;
            if (i3 == 0 || i3 == 4) {
                if (this.t == 0) {
                    int headerViewsCount = this.g0.getHeaderViewsCount() + i2;
                    this.m = headerViewsCount;
                    this.j = headerViewsCount;
                    this.k = headerViewsCount;
                    this.i = headerViewsCount;
                    ListView listView = this.g0;
                    View childAt = listView.getChildAt(headerViewsCount - listView.getFirstVisiblePosition());
                    if (childAt != null) {
                        childAt.setVisibility(4);
                    }
                }
                this.t = 1;
                this.f0 = f2;
                if (this.P) {
                    int i4 = this.S;
                    if (i4 != 1) {
                        if (i4 == 2) {
                            this.h0.onInterceptTouchEvent(this.R);
                        }
                    } else {
                        this.h0.onTouchEvent(this.R);
                    }
                }
                m mVar = this.b0;
                if (mVar != null) {
                    mVar.d();
                } else {
                    Z(i2);
                }
            }
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            int firstVisiblePosition = this.g0.getFirstVisiblePosition() + (this.g0.getChildCount() / 2);
            ListView listView = this.g0;
            View childAt = listView.getChildAt(listView.getChildCount() / 2);
            if (childAt == null) {
                return;
            }
            W(firstVisiblePosition, childAt, z);
        }
    }

    public final void Z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.t = 1;
            n nVar = this.r;
            if (nVar != null) {
                nVar.remove(i2);
            }
            U();
            N();
            S();
            if (this.P) {
                this.t = 3;
            } else {
                this.t = 0;
            }
        }
    }

    public final int e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            ListView listView = this.g0;
            View childAt = listView.getChildAt(i2 - listView.getFirstVisiblePosition());
            if (childAt != null) {
                return childAt.getHeight();
            }
            return P(i2, c0(i2));
        }
        return invokeI.intValue;
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.e0 = false;
            m0(i2, 0.0f);
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.s = z;
        }
    }

    @Override // com.baidu.tieba.bz5
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, canvas) == null) {
            this.h0.onDraw(canvas);
            if (this.W) {
                this.X.a();
            }
        }
    }

    public void p0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, dVar) == null) {
            this.p = dVar;
        }
    }

    public void q0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            r0(f2, f2);
        }
    }

    public void s0(az5 az5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, az5Var) == null) {
            this.i0 = az5Var;
            this.g0.setOnTouchListener(az5Var);
        }
    }

    public void t0(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, iVar) == null) {
            this.q = iVar;
        }
    }

    public void u0(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, jVar) == null) {
            this.Q = jVar;
        }
    }

    public void v0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, nVar) == null) {
            this.r = nVar;
        }
    }

    public boolean y0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048629, this, z)) == null) {
            this.e0 = false;
            return z0(z, 0.0f);
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.bz5
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048616, this, i2, i3, i4, i5) == null) {
            this.h0.onSizeChanged(i2, i3, i4, i5);
            D0();
        }
    }

    public boolean w0(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        j jVar;
        View b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048627, this, i2, i3, i4, i5)) == null) {
            if (!this.P || (jVar = this.Q) == null || (b2 = jVar.b(i2)) == null) {
                return false;
            }
            return x0(i2, b2, i3, i4, i5);
        }
        return invokeIIII.booleanValue;
    }

    public boolean A0(boolean z, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)})) == null) {
            this.e0 = true;
            return z0(z, f2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.bz5
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i2, i3) == null) {
            this.h0.onMeasure(i2, i3);
            View view2 = this.a;
            if (view2 != null) {
                if (view2.isLayoutRequested()) {
                    i0();
                }
                this.e = true;
            }
            this.x = i2;
        }
    }

    public final int Q(int i2, View view2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view2, Boolean.valueOf(z)})) == null) {
            return P(i2, d0(i2, view2, z));
        }
        return invokeCommon.intValue;
    }

    public final void B0() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.Q != null) {
                this.c.set(this.K, this.L);
                this.Q.c(this.a, this.b, this.c);
            }
            Point point = this.b;
            int i4 = point.x;
            int i5 = point.y;
            int paddingLeft = this.g0.getPaddingLeft();
            if ((this.N & 1) == 0 && i4 > paddingLeft) {
                this.b.x = paddingLeft;
            } else if ((this.N & 2) == 0 && i4 < paddingLeft) {
                this.b.x = paddingLeft;
            }
            int headerViewsCount = this.g0.getHeaderViewsCount();
            int footerViewsCount = this.g0.getFooterViewsCount();
            int firstVisiblePosition = this.g0.getFirstVisiblePosition();
            int lastVisiblePosition = this.g0.getLastVisiblePosition();
            int paddingTop = this.g0.getPaddingTop();
            if (firstVisiblePosition < headerViewsCount) {
                paddingTop = this.g0.getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
            }
            if ((this.N & 8) == 0 && firstVisiblePosition <= (i3 = this.m)) {
                paddingTop = Math.max(this.g0.getChildAt(i3 - firstVisiblePosition).getTop(), paddingTop);
            }
            int height = this.g0.getHeight() - this.g0.getPaddingBottom();
            if (lastVisiblePosition >= (this.g0.getCount() - footerViewsCount) - 1) {
                ListView listView = this.g0;
                height = listView.getChildAt(((listView.getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
            }
            if ((this.N & 4) == 0 && lastVisiblePosition >= (i2 = this.m)) {
                height = Math.min(this.g0.getChildAt(i2 - firstVisiblePosition).getBottom(), height);
            }
            if (i5 < paddingTop) {
                this.b.y = paddingTop;
            } else {
                int i6 = this.v;
                if (i5 + i6 > height) {
                    this.b.y = height - i6;
                }
            }
            this.d = this.b.y + this.w;
        }
    }

    public final boolean C0() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int firstVisiblePosition = this.g0.getFirstVisiblePosition();
            int i4 = this.j;
            View childAt = this.g0.getChildAt(i4 - firstVisiblePosition);
            if (childAt == null) {
                i4 = (this.g0.getChildCount() / 2) + firstVisiblePosition;
                childAt = this.g0.getChildAt(i4 - firstVisiblePosition);
            }
            int top = childAt.getTop();
            int height = childAt.getHeight();
            int f0 = f0(i4, top);
            int dividerHeight = this.g0.getDividerHeight();
            if (this.d < f0) {
                while (i4 >= 0) {
                    i4--;
                    int e0 = e0(i4);
                    if (i4 == 0) {
                        i2 = (top - dividerHeight) - e0;
                        int i5 = f0;
                        f0 = i2;
                        i3 = i5;
                        break;
                    }
                    top -= e0 + dividerHeight;
                    int f02 = f0(i4, top);
                    if (this.d >= f02) {
                        i3 = f0;
                        f0 = f02;
                        break;
                    }
                    f0 = f02;
                }
                i3 = f0;
            } else {
                int count = this.g0.getCount();
                while (i4 < count) {
                    if (i4 == count - 1) {
                        i2 = top + dividerHeight + height;
                        int i52 = f0;
                        f0 = i2;
                        i3 = i52;
                        break;
                    }
                    top += height + dividerHeight;
                    int i6 = i4 + 1;
                    int e02 = e0(i6);
                    int f03 = f0(i6, top);
                    if (this.d < f03) {
                        i3 = f0;
                        f0 = f03;
                        break;
                    }
                    i4 = i6;
                    height = e02;
                    f0 = f03;
                }
                i3 = f0;
            }
            int headerViewsCount = this.g0.getHeaderViewsCount();
            int footerViewsCount = this.g0.getFooterViewsCount();
            boolean z = false;
            int i7 = this.j;
            int i8 = this.k;
            float f2 = this.U;
            if (this.l) {
                int abs = Math.abs(f0 - i3);
                if (this.d < f0) {
                    int i9 = f0;
                    f0 = i3;
                    i3 = i9;
                }
                int i10 = (int) (this.f1192T * 0.5f * abs);
                float f3 = i10;
                int i11 = f0 + i10;
                int i12 = i3 - i10;
                int i13 = this.d;
                if (i13 < i11) {
                    this.j = i4 - 1;
                    this.k = i4;
                    this.U = ((i11 - i13) * 0.5f) / f3;
                } else if (i13 < i12) {
                    this.j = i4;
                    this.k = i4;
                } else {
                    this.j = i4;
                    this.k = i4 + 1;
                    this.U = (((i3 - i13) / f3) + 1.0f) * 0.5f;
                }
            } else {
                this.j = i4;
                this.k = i4;
            }
            if (this.j < headerViewsCount) {
                this.j = headerViewsCount;
                this.k = headerViewsCount;
                i4 = headerViewsCount;
            } else if (this.k >= this.g0.getCount() - footerViewsCount) {
                i4 = (this.g0.getCount() - footerViewsCount) - 1;
                this.j = i4;
                this.k = i4;
            }
            z = (this.j == i7 && this.k == i8 && this.U == f2) ? true : true;
            int i14 = this.i;
            if (i4 != i14) {
                d dVar = this.p;
                if (dVar != null) {
                    dVar.a(i14 - headerViewsCount, i4 - headerViewsCount);
                }
                this.i = i4;
                return true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void D0() {
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int paddingTop = this.g0.getPaddingTop();
            float height2 = (this.g0.getHeight() - paddingTop) - this.g0.getPaddingBottom();
            float f2 = paddingTop;
            float f3 = (this.A * height2) + f2;
            this.F = f3;
            float f4 = ((1.0f - this.B) * height2) + f2;
            this.E = f4;
            this.C = (int) f3;
            this.D = (int) f4;
            this.G = f3 - f2;
            this.H = (paddingTop + height) - f4;
        }
    }

    public final void N() {
        int firstVisiblePosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.m < (firstVisiblePosition = this.g0.getFirstVisiblePosition())) {
            int i2 = 0;
            View childAt = this.g0.getChildAt(0);
            if (childAt != null) {
                i2 = childAt.getTop();
            }
            ListView listView = this.g0;
            listView.setSelectionFromTop(firstVisiblePosition - 1, i2 - listView.getPaddingTop());
        }
    }

    @Override // com.baidu.tieba.bz5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.h0.a();
            View view2 = this.a;
            if (view2 != null) {
                if (view2.isLayoutRequested() && !this.e) {
                    i0();
                }
                View view3 = this.a;
                view3.layout(0, 0, view3.getMeasuredWidth(), this.a.getMeasuredHeight());
                this.e = false;
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int firstVisiblePosition = this.g0.getFirstVisiblePosition();
            int lastVisiblePosition = this.g0.getLastVisiblePosition();
            int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((this.g0.getCount() - 1) - this.g0.getFooterViewsCount()) - firstVisiblePosition);
            for (int max = Math.max(0, this.g0.getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
                View childAt = this.g0.getChildAt(max);
                if (childAt != null) {
                    M(firstVisiblePosition + max, childAt, false);
                }
            }
        }
    }

    public final void b0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.t = 2;
            if (this.q != null && (i2 = this.i) >= 0 && i2 < this.g0.getCount()) {
                int headerViewsCount = this.g0.getHeaderViewsCount();
                this.q.a(this.m - headerViewsCount, this.i - headerViewsCount);
            }
            U();
            N();
            S();
            L();
            if (this.P) {
                this.t = 3;
            } else {
                this.t = 0;
            }
        }
    }

    public final void M(int i2, View view2, boolean z) {
        int Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view2, Boolean.valueOf(z)}) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (i2 != this.m && i2 != this.j && i2 != this.k) {
                Q = -2;
            } else {
                Q = Q(i2, view2, z);
            }
            if (Q != layoutParams.height) {
                layoutParams.height = Q;
                view2.setLayoutParams(layoutParams);
            }
            if (i2 == this.j || i2 == this.k) {
                int i3 = this.m;
                if (i2 < i3) {
                    ((DragSortItemView) view2).setGravity(80);
                } else if (i2 > i3) {
                    ((DragSortItemView) view2).setGravity(48);
                }
            }
            int visibility = view2.getVisibility();
            int i4 = 0;
            if (i2 == this.m && this.a != null) {
                i4 = 4;
            }
            if (i4 != visibility) {
                view2.setVisibility(i4);
            }
        }
    }

    public final int d0(int i2, View view2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), view2, Boolean.valueOf(z)})) == null) {
            if (i2 == this.m) {
                return 0;
            }
            if (i2 >= this.g0.getHeaderViewsCount() && i2 < this.g0.getCount() - this.g0.getFooterViewsCount()) {
                view2 = ((ViewGroup) view2).getChildAt(0);
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null && (i3 = layoutParams.height) > 0) {
                return i3;
            }
            int height = view2.getHeight();
            if (height == 0 || z) {
                j0(view2);
                return view2.getMeasuredHeight();
            }
            return height;
        }
        return invokeCommon.intValue;
    }

    public final int O(int i2, View view2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int c0 = c0(i2);
            int height = view2.getHeight();
            int P = P(i2, c0);
            if (i2 != this.m) {
                i5 = height - c0;
                i6 = P - c0;
            } else {
                i5 = height;
                i6 = P;
            }
            int i7 = this.v;
            int i8 = this.m;
            if (i8 != this.j && i8 != this.k) {
                i7 -= this.u;
            }
            if (i2 <= i3) {
                if (i2 <= this.j) {
                    return 0;
                }
                return 0 + (i7 - i6);
            } else if (i2 == i4) {
                if (i2 <= this.j) {
                    i5 -= i7;
                } else if (i2 == this.k) {
                    return 0 + (height - P);
                }
                return 0 + i5;
            } else if (i2 <= this.j) {
                return 0 - i7;
            } else {
                if (i2 != this.k) {
                    return 0;
                }
                return 0 - i6;
            }
        }
        return invokeCommon.intValue;
    }

    public final int P(int i2, int i3) {
        InterceptResult invokeII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            this.g0.getDividerHeight();
            if (this.l && this.j != this.k) {
                z = true;
            } else {
                z = false;
            }
            int i4 = this.v;
            int i5 = this.u;
            int i6 = i4 - i5;
            int i7 = (int) (this.U * i6);
            int i8 = this.m;
            if (i2 == i8) {
                if (i8 == this.j) {
                    if (z) {
                        return i7 + i5;
                    }
                    return i4;
                } else if (i8 == this.k) {
                    return i4 - i7;
                } else {
                    return i5;
                }
            } else if (i2 == this.j) {
                if (z) {
                    return i3 + i7;
                }
                return i3 + i6;
            } else if (i2 == this.k) {
                return (i3 + i6) - i7;
            } else {
                return i3;
            }
        }
        return invokeII.intValue;
    }

    public boolean z0(boolean z, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)})) == null) {
            if (this.a != null) {
                this.z.d(true);
                if (z) {
                    m0(this.m - this.g0.getHeaderViewsCount(), f2);
                } else {
                    h hVar = this.d0;
                    if (hVar != null) {
                        hVar.d();
                    } else {
                        b0();
                    }
                }
                if (this.W) {
                    this.X.d();
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.t == 4) {
            this.z.d(true);
            U();
            S();
            L();
            if (this.P) {
                this.t = 3;
            } else {
                this.t = 0;
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.m = -1;
            this.j = -1;
            this.k = -1;
            this.i = -1;
        }
    }

    public final void U() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (view2 = this.a) != null) {
            view2.setVisibility(8);
            j jVar = this.Q;
            if (jVar != null) {
                jVar.a(this.a);
            }
            this.a = null;
            this.g0.invalidate();
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.S = 0;
            this.P = false;
            if (this.t == 3) {
                this.t = 0;
            }
            this.h = this.g;
            this.j0 = false;
            this.a0.b();
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Z(this.m - this.g0.getHeaderViewsCount());
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.j0;
        }
        return invokeV.booleanValue;
    }

    public final void i0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (view2 = this.a) != null) {
            j0(view2);
            int measuredHeight = this.a.getMeasuredHeight();
            this.v = measuredHeight;
            this.w = measuredHeight / 2;
        }
    }

    @Override // com.baidu.tieba.bz5
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && !this.Y) {
            this.h0.requestLayout();
        }
    }

    public final void W(int i2, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), view2, Boolean.valueOf(z)}) == null) {
            this.Y = true;
            B0();
            int i3 = this.j;
            int i4 = this.k;
            boolean C0 = C0();
            if (C0) {
                L();
                this.g0.setSelectionFromTop(i2, (view2.getTop() + O(i2, view2, i3, i4)) - this.g0.getPaddingTop());
                a();
            }
            if (C0 || z) {
                this.g0.invalidate();
            }
            this.Y = false;
        }
    }

    @Override // com.baidu.tieba.bz5
    public void b(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, canvas) == null) {
            this.h0.b(canvas);
            if (this.t != 0) {
                int i2 = this.j;
                if (i2 != this.m) {
                    a0(i2, canvas);
                }
                int i3 = this.k;
                if (i3 != this.j && i3 != this.m) {
                    a0(i3, canvas);
                }
            }
            View view2 = this.a;
            if (view2 != null) {
                int width = view2.getWidth();
                int height = this.a.getHeight();
                int i4 = this.b.x;
                int width2 = this.g0.getWidth();
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
                Point point = this.b;
                canvas.translate(point.x, point.y);
                canvas.clipRect(0, 0, width, height);
                canvas.saveLayerAlpha(0.0f, 0.0f, width, height, (int) (this.h * 255.0f * f2), 31);
                this.a.draw(canvas);
                canvas.restore();
                canvas.restore();
            }
        }
    }

    public final int c0(int i2) {
        InterceptResult invokeI;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (i2 == this.m) {
                return 0;
            }
            ListView listView = this.g0;
            View childAt = listView.getChildAt(i2 - listView.getFirstVisiblePosition());
            if (childAt != null) {
                return d0(i2, childAt, false);
            }
            int c2 = this.a0.c(i2);
            if (c2 != -1) {
                return c2;
            }
            ListAdapter adapter = this.g0.getAdapter();
            int itemViewType = adapter.getItemViewType(i2);
            int viewTypeCount = adapter.getViewTypeCount();
            if (viewTypeCount != this.y.length) {
                this.y = new View[viewTypeCount];
            }
            if (itemViewType >= 0) {
                View[] viewArr = this.y;
                if (viewArr[itemViewType] == null) {
                    view2 = adapter.getView(i2, null, this.g0);
                    this.y[itemViewType] = view2;
                } else {
                    view2 = adapter.getView(i2, viewArr[itemViewType], this.g0);
                }
            } else {
                view2 = adapter.getView(i2, null, this.g0);
            }
            int d0 = d0(i2, view2, true);
            this.a0.a(i2, d0);
            return d0;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.bz5
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            if (!this.s) {
                return this.h0.onInterceptTouchEvent(motionEvent);
            }
            az5 az5Var = this.i0;
            if (az5Var != null) {
                az5Var.p().onTouchEvent(motionEvent);
            }
            n0(motionEvent);
            this.O = true;
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                if (this.t != 0) {
                    this.Z = true;
                    return true;
                }
                this.P = true;
            }
            if (this.a != null) {
                z = true;
            } else {
                if (this.h0.onInterceptTouchEvent(motionEvent)) {
                    this.j0 = true;
                    z = true;
                } else {
                    z = false;
                }
                if (action != 1 && action != 3) {
                    if (z) {
                        this.S = 1;
                    } else {
                        this.S = 2;
                    }
                } else {
                    V();
                }
            }
            if (action == 1 || action == 3) {
                this.P = false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bz5
    public void c(ListView listView, Context context, AttributeSet attributeSet) {
        int i2;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, listView, context, attributeSet) == null) {
            int i4 = 150;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r0a.DragSort, 0, 0);
                this.u = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(1, 1));
                boolean z2 = obtainStyledAttributes.getBoolean(16, false);
                this.W = z2;
                if (z2) {
                    this.X = new g(this);
                }
                float f2 = obtainStyledAttributes.getFloat(7, this.g);
                this.g = f2;
                this.h = f2;
                this.s = obtainStyledAttributes.getBoolean(2, this.s);
                float max = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(12, 0.75f)));
                this.f1192T = max;
                if (max > 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                this.l = z;
                q0(obtainStyledAttributes.getFloat(4, this.A));
                this.I = obtainStyledAttributes.getFloat(9, this.I);
                int i5 = obtainStyledAttributes.getInt(10, 150);
                i2 = obtainStyledAttributes.getInt(5, 150);
                if (obtainStyledAttributes.getBoolean(17, true)) {
                    boolean z3 = obtainStyledAttributes.getBoolean(11, false);
                    int i6 = obtainStyledAttributes.getInt(14, 1);
                    boolean z4 = obtainStyledAttributes.getBoolean(13, true);
                    int resourceId = obtainStyledAttributes.getResourceId(3, 0);
                    int resourceId2 = obtainStyledAttributes.getResourceId(6, 0);
                    int resourceId3 = obtainStyledAttributes.getResourceId(0, 0);
                    int color = obtainStyledAttributes.getColor(8, -16777216);
                    i3 = i5;
                    az5 az5Var = new az5(this, listView, resourceId, 2, i6, resourceId3, resourceId2);
                    az5Var.r(z3);
                    az5Var.u(z4);
                    az5Var.d(color);
                    this.Q = az5Var;
                    s0(az5Var);
                } else {
                    i3 = i5;
                }
                obtainStyledAttributes.recycle();
                i4 = i3;
            } else {
                i2 = 150;
            }
            this.z = new f(this);
            if (i4 > 0) {
                this.b0 = new m(this, 0.5f, i4);
            }
            if (i2 > 0) {
                this.d0 = new h(this, 0.5f, i2);
            }
            this.R = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            this.f = new b(this);
        }
    }

    public final void j0(View view2) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, -2);
                view2.setLayoutParams(layoutParams);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.x, this.g0.getListPaddingLeft() + this.g0.getListPaddingRight(), layoutParams.width);
            int i2 = layoutParams.height;
            if (i2 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(childMeasureSpec, makeMeasureSpec);
        }
    }

    public boolean k0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) {
            motionEvent.getAction();
            int action = motionEvent.getAction() & 255;
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        if (this.t == 4) {
                            R();
                        }
                        V();
                    }
                } else {
                    T((int) motionEvent.getX(), (int) motionEvent.getY());
                }
            } else {
                if (this.t == 4) {
                    y0(false);
                }
                V();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bz5
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) {
            boolean z = false;
            if (this.Z) {
                this.Z = false;
                return false;
            } else if (!this.s) {
                return this.h0.onTouchEvent(motionEvent);
            } else {
                boolean z2 = this.O;
                this.O = false;
                if (!z2) {
                    n0(motionEvent);
                }
                int i2 = this.t;
                if (i2 == 4) {
                    k0(motionEvent);
                    return true;
                }
                if (i2 == 0 && this.h0.onTouchEvent(motionEvent)) {
                    z = true;
                }
                int action = motionEvent.getAction() & 255;
                if (action != 1 && action != 3) {
                    if (z) {
                        this.S = 1;
                    }
                } else {
                    V();
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public final void n0(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, motionEvent) == null) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                this.M = this.L;
            }
            this.K = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.L = y;
            if (action == 0) {
                this.M = y;
            }
            motionEvent.getRawX();
            motionEvent.getRawY();
        }
    }

    @Override // com.baidu.tieba.bz5
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, listAdapter) == null) {
            if (listAdapter != null) {
                this.V = new c(this, listAdapter);
                listAdapter.registerDataSetObserver(this.f);
                if (listAdapter instanceof i) {
                    t0((i) listAdapter);
                }
                if (listAdapter instanceof d) {
                    p0((d) listAdapter);
                }
                if (listAdapter instanceof n) {
                    v0((n) listAdapter);
                }
            } else {
                this.V = null;
            }
            this.h0.setAdapter(this.V);
        }
    }

    public void r0(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (f3 > 0.5f) {
                this.B = 0.5f;
            } else {
                this.B = f3;
            }
            if (f2 > 0.5f) {
                this.A = 0.5f;
            } else {
                this.A = f2;
            }
            if (this.g0.getHeight() != 0) {
                D0();
            }
        }
    }

    public boolean x0(int i2, View view2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), view2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (this.t != 0 || !this.P || this.a != null || view2 == null || !this.s) {
                return false;
            }
            if (this.g0.getParent() != null) {
                this.g0.getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = i2 + this.g0.getHeaderViewsCount();
            this.j = headerViewsCount;
            this.k = headerViewsCount;
            this.m = headerViewsCount;
            this.i = headerViewsCount;
            this.t = 4;
            this.N = 0;
            this.N = i3 | 0;
            this.a = view2;
            i0();
            this.n = i4;
            this.o = i5;
            int i6 = this.L;
            Point point = this.b;
            point.x = this.K - i4;
            point.y = i6 - i5;
            ListView listView = this.g0;
            View childAt = listView.getChildAt(this.m - listView.getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.W) {
                this.X.c();
            }
            int i7 = this.S;
            if (i7 != 1) {
                if (i7 == 2) {
                    this.h0.onInterceptTouchEvent(this.R);
                }
            } else {
                this.h0.onTouchEvent(this.R);
            }
            this.g0.requestLayout();
            l lVar = this.c0;
            if (lVar != null) {
                lVar.d();
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
