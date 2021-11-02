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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class PinnedSectionListView extends ListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AbsListView.OnScrollListener f57832a;

    /* renamed from: b  reason: collision with root package name */
    public a f57833b;

    /* renamed from: c  reason: collision with root package name */
    public a f57834c;

    /* renamed from: d  reason: collision with root package name */
    public int f57835d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f57836e;

    /* renamed from: f  reason: collision with root package name */
    public final PointF f57837f;

    /* renamed from: g  reason: collision with root package name */
    public int f57838g;

    /* renamed from: h  reason: collision with root package name */
    public View f57839h;

    /* renamed from: i  reason: collision with root package name */
    public MotionEvent f57840i;
    public int j;
    public final AbsListView.OnScrollListener k;
    public final DataSetObserver l;

    /* loaded from: classes10.dex */
    public interface PinnedSectionListAdapter extends ListAdapter {
        boolean isItemViewTypePinned(int i2);
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f57844a;

        /* renamed from: b  reason: collision with root package name */
        public int f57845b;

        /* renamed from: c  reason: collision with root package name */
        public long f57846c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57836e = new Rect();
        this.f57837f = new PointF();
        this.k = new AbsListView.OnScrollListener(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PinnedSectionListView f57841a;

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
                this.f57841a = this;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, absListView, i4, i5, i6) == null) {
                    AbsListView.OnScrollListener onScrollListener = this.f57841a.f57832a;
                    if (onScrollListener != null) {
                        onScrollListener.onScroll(absListView, i4, i5, i6);
                    }
                    ListAdapter adapter = this.f57841a.getAdapter();
                    if (adapter == null || i5 == 0) {
                        return;
                    }
                    if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i4))) {
                        if (this.f57841a.getChildAt(0).getTop() == this.f57841a.getPaddingTop()) {
                            this.f57841a.a();
                            return;
                        } else {
                            this.f57841a.a(i4, i4, i5);
                            return;
                        }
                    }
                    int b2 = this.f57841a.b(i4);
                    if (b2 > -1) {
                        this.f57841a.a(b2, i4, i5);
                    } else {
                        this.f57841a.a();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i4) {
                AbsListView.OnScrollListener onScrollListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i4) == null) || (onScrollListener = this.f57841a.f57832a) == null) {
                    return;
                }
                onScrollListener.onScrollStateChanged(absListView, i4);
            }
        };
        this.l = new DataSetObserver(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PinnedSectionListView f57842a;

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
                this.f57842a = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f57842a.b();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f57842a.b();
                }
            }
        };
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            setOnScrollListener(this.k);
            this.f57838g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f57839h = null;
            MotionEvent motionEvent = this.f57840i;
            if (motionEvent != null) {
                motionEvent.recycle();
                this.f57840i = null;
            }
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        AdapterView.OnItemClickListener onItemClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.f57834c == null || (onItemClickListener = getOnItemClickListener()) == null || !getAdapter().isEnabled(this.f57834c.f57845b)) {
                return false;
            }
            View view = this.f57834c.f57844a;
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            a aVar = this.f57834c;
            onItemClickListener.onItemClick(this, view, aVar.f57845b, aVar.f57846c);
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isItemViewTypePinned(ListAdapter listAdapter, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, listAdapter, i2)) == null) {
            if (listAdapter instanceof HeaderViewListAdapter) {
                listAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
            }
            return ((PinnedSectionListAdapter) listAdapter).isItemViewTypePinned(i2);
        }
        return invokeLI.booleanValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            a aVar = this.f57833b;
            this.f57833b = null;
            if (aVar == null) {
                aVar = new a();
            }
            View view = getAdapter().getView(i2, aVar.f57844a, this);
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
            this.f57835d = 0;
            aVar.f57844a = view;
            aVar.f57845b = i2;
            aVar.f57846c = getAdapter().getItemId(i2);
            this.f57834c = aVar;
        }
    }

    public int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
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
        return invokeI.intValue;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.f57834c != null) {
                int listPaddingLeft = getListPaddingLeft();
                int listPaddingTop = getListPaddingTop();
                View view = this.f57834c.f57844a;
                canvas.save();
                canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + listPaddingTop);
                canvas.translate(listPaddingLeft, listPaddingTop + this.f57835d);
                drawChild(canvas, this.f57834c.f57844a, getDrawingTime());
                canvas.restore();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0 && this.f57839h == null && (aVar = this.f57834c) != null && a(aVar.f57844a, x, y)) {
                this.f57839h = this.f57834c.f57844a;
                PointF pointF = this.f57837f;
                pointF.x = x;
                pointF.y = y;
                this.f57840i = MotionEvent.obtain(motionEvent);
            }
            View view = this.f57839h;
            if (view != null) {
                if (a(view, x, y)) {
                    this.f57839h.dispatchTouchEvent(motionEvent);
                }
                if (action == 1) {
                    super.dispatchTouchEvent(motionEvent);
                    e();
                    d();
                } else if (action == 3) {
                    d();
                } else if (action == 2 && Math.abs(y - this.f57837f.y) > this.f57838g) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    this.f57839h.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    super.dispatchTouchEvent(this.f57840i);
                    super.dispatchTouchEvent(motionEvent);
                    d();
                }
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.f57834c == null || ((i4 - i2) - getPaddingLeft()) - getPaddingRight() == this.f57834c.f57844a.getWidth()) {
                return;
            }
            b();
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, parcelable) == null) {
            super.onRestoreInstanceState(parcelable);
            post(new Runnable(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PinnedSectionListView f57843a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57843a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f57843a.b();
                    }
                }
            });
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onScrollListener) == null) {
            if (onScrollListener == this.k) {
                super.setOnScrollListener(onScrollListener);
            } else {
                this.f57832a = onScrollListener;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, listAdapter) == null) || listAdapter == null || !(listAdapter instanceof PinnedSectionListAdapter) || listAdapter.getViewTypeCount() < 2) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinnedSectionListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57836e = new Rect();
        this.f57837f = new PointF();
        this.k = new AbsListView.OnScrollListener(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PinnedSectionListView f57841a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
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
                this.f57841a = this;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, absListView, i4, i5, i6) == null) {
                    AbsListView.OnScrollListener onScrollListener = this.f57841a.f57832a;
                    if (onScrollListener != null) {
                        onScrollListener.onScroll(absListView, i4, i5, i6);
                    }
                    ListAdapter adapter = this.f57841a.getAdapter();
                    if (adapter == null || i5 == 0) {
                        return;
                    }
                    if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i4))) {
                        if (this.f57841a.getChildAt(0).getTop() == this.f57841a.getPaddingTop()) {
                            this.f57841a.a();
                            return;
                        } else {
                            this.f57841a.a(i4, i4, i5);
                            return;
                        }
                    }
                    int b2 = this.f57841a.b(i4);
                    if (b2 > -1) {
                        this.f57841a.a(b2, i4, i5);
                    } else {
                        this.f57841a.a();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i4) {
                AbsListView.OnScrollListener onScrollListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i4) == null) || (onScrollListener = this.f57841a.f57832a) == null) {
                    return;
                }
                onScrollListener.onScrollStateChanged(absListView, i4);
            }
        };
        this.l = new DataSetObserver(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PinnedSectionListView f57842a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
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
                this.f57842a = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f57842a.b();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f57842a.b();
                }
            }
        };
        c();
    }

    public void b() {
        int firstVisiblePosition;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            ListAdapter adapter = getAdapter();
            if (adapter == null || adapter.getCount() <= 0 || (b2 = b((firstVisiblePosition = getFirstVisiblePosition()))) == -1) {
                return;
            }
            a(b2, firstVisiblePosition, getLastVisiblePosition() - firstVisiblePosition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f57836e = new Rect();
        this.f57837f = new PointF();
        this.k = new AbsListView.OnScrollListener(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PinnedSectionListView f57841a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f57841a = this;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i42, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, absListView, i42, i5, i6) == null) {
                    AbsListView.OnScrollListener onScrollListener = this.f57841a.f57832a;
                    if (onScrollListener != null) {
                        onScrollListener.onScroll(absListView, i42, i5, i6);
                    }
                    ListAdapter adapter = this.f57841a.getAdapter();
                    if (adapter == null || i5 == 0) {
                        return;
                    }
                    if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i42))) {
                        if (this.f57841a.getChildAt(0).getTop() == this.f57841a.getPaddingTop()) {
                            this.f57841a.a();
                            return;
                        } else {
                            this.f57841a.a(i42, i42, i5);
                            return;
                        }
                    }
                    int b2 = this.f57841a.b(i42);
                    if (b2 > -1) {
                        this.f57841a.a(b2, i42, i5);
                    } else {
                        this.f57841a.a();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i42) {
                AbsListView.OnScrollListener onScrollListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i42) == null) || (onScrollListener = this.f57841a.f57832a) == null) {
                    return;
                }
                onScrollListener.onScrollStateChanged(absListView, i42);
            }
        };
        this.l = new DataSetObserver(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PinnedSectionListView f57842a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f57842a = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f57842a.b();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f57842a.b();
                }
            }
        };
        c();
    }

    public void a() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f57834c) == null) {
            return;
        }
        this.f57833b = aVar;
        this.f57834c = null;
    }

    public void a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
            if (i4 < 2) {
                a();
                return;
            }
            a aVar = this.f57834c;
            if (aVar != null && aVar.f57845b != i2) {
                a();
            }
            if (this.f57834c == null) {
                a(i2);
            }
            int i5 = i2 + 1;
            if (i5 < getCount()) {
                int a2 = a(i5, i4 - (i5 - i3));
                if (a2 > -1) {
                    int top = getChildAt(a2 - i3).getTop() - (this.f57834c.f57844a.getBottom() + getPaddingTop());
                    this.j = top;
                    if (top < 0) {
                        this.f57835d = top;
                        return;
                    } else {
                        this.f57835d = 0;
                        return;
                    }
                }
                this.f57835d = 0;
                this.j = Integer.MAX_VALUE;
            }
        }
    }

    public int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
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
        return invokeII.intValue;
    }

    private boolean a(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            view.getHitRect(this.f57836e);
            Rect rect = this.f57836e;
            int i2 = rect.top;
            int i3 = this.f57835d;
            rect.top = i2 + i3;
            rect.bottom += i3 + getPaddingTop();
            this.f57836e.left += getPaddingLeft();
            this.f57836e.right -= getPaddingRight();
            return this.f57836e.contains((int) f2, (int) f3);
        }
        return invokeCommon.booleanValue;
    }
}
