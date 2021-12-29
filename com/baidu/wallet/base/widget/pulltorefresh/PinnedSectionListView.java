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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class PinnedSectionListView extends ListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsListView.OnScrollListener a;

    /* renamed from: b  reason: collision with root package name */
    public a f52868b;

    /* renamed from: c  reason: collision with root package name */
    public a f52869c;

    /* renamed from: d  reason: collision with root package name */
    public int f52870d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f52871e;

    /* renamed from: f  reason: collision with root package name */
    public final PointF f52872f;

    /* renamed from: g  reason: collision with root package name */
    public int f52873g;

    /* renamed from: h  reason: collision with root package name */
    public View f52874h;

    /* renamed from: i  reason: collision with root package name */
    public MotionEvent f52875i;

    /* renamed from: j  reason: collision with root package name */
    public int f52876j;

    /* renamed from: k  reason: collision with root package name */
    public final AbsListView.OnScrollListener f52877k;
    public final DataSetObserver l;

    /* loaded from: classes13.dex */
    public interface PinnedSectionListAdapter extends ListAdapter {
        boolean isItemViewTypePinned(int i2);
    }

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f52878b;

        /* renamed from: c  reason: collision with root package name */
        public long f52879c;

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
        this.f52871e = new Rect();
        this.f52872f = new PointF();
        this.f52877k = new AbsListView.OnScrollListener(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PinnedSectionListView a;

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
                this.a = this;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, absListView, i4, i5, i6) == null) {
                    AbsListView.OnScrollListener onScrollListener = this.a.a;
                    if (onScrollListener != null) {
                        onScrollListener.onScroll(absListView, i4, i5, i6);
                    }
                    ListAdapter adapter = this.a.getAdapter();
                    if (adapter == null || i5 == 0) {
                        return;
                    }
                    if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i4))) {
                        if (this.a.getChildAt(0).getTop() == this.a.getPaddingTop()) {
                            this.a.a();
                            return;
                        } else {
                            this.a.a(i4, i4, i5);
                            return;
                        }
                    }
                    int b2 = this.a.b(i4);
                    if (b2 > -1) {
                        this.a.a(b2, i4, i5);
                    } else {
                        this.a.a();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i4) {
                AbsListView.OnScrollListener onScrollListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i4) == null) || (onScrollListener = this.a.a) == null) {
                    return;
                }
                onScrollListener.onScrollStateChanged(absListView, i4);
            }
        };
        this.l = new DataSetObserver(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PinnedSectionListView a;

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
                this.a = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.b();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b();
                }
            }
        };
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            setOnScrollListener(this.f52877k);
            this.f52873g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.f52874h = null;
            MotionEvent motionEvent = this.f52875i;
            if (motionEvent != null) {
                motionEvent.recycle();
                this.f52875i = null;
            }
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        AdapterView.OnItemClickListener onItemClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.f52869c == null || (onItemClickListener = getOnItemClickListener()) == null || !getAdapter().isEnabled(this.f52869c.f52878b)) {
                return false;
            }
            View view = this.f52869c.a;
            playSoundEffect(0);
            if (view != null) {
                view.sendAccessibilityEvent(1);
            }
            a aVar = this.f52869c;
            onItemClickListener.onItemClick(this, view, aVar.f52878b, aVar.f52879c);
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
            a aVar = this.f52868b;
            this.f52868b = null;
            if (aVar == null) {
                aVar = new a();
            }
            View view = getAdapter().getView(i2, aVar.a, this);
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
            this.f52870d = 0;
            aVar.a = view;
            aVar.f52878b = i2;
            aVar.f52879c = getAdapter().getItemId(i2);
            this.f52869c = aVar;
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
            if (this.f52869c != null) {
                int listPaddingLeft = getListPaddingLeft();
                int listPaddingTop = getListPaddingTop();
                View view = this.f52869c.a;
                canvas.save();
                canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + listPaddingTop);
                canvas.translate(listPaddingLeft, listPaddingTop + this.f52870d);
                drawChild(canvas, this.f52869c.a, getDrawingTime());
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
            if (action == 0 && this.f52874h == null && (aVar = this.f52869c) != null && a(aVar.a, x, y)) {
                this.f52874h = this.f52869c.a;
                PointF pointF = this.f52872f;
                pointF.x = x;
                pointF.y = y;
                this.f52875i = MotionEvent.obtain(motionEvent);
            }
            View view = this.f52874h;
            if (view != null) {
                if (a(view, x, y)) {
                    this.f52874h.dispatchTouchEvent(motionEvent);
                }
                if (action == 1) {
                    super.dispatchTouchEvent(motionEvent);
                    e();
                    d();
                } else if (action == 3) {
                    d();
                } else if (action == 2 && Math.abs(y - this.f52872f.y) > this.f52873g) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    this.f52874h.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    super.dispatchTouchEvent(this.f52875i);
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
            if (this.f52869c == null || ((i4 - i2) - getPaddingLeft()) - getPaddingRight() == this.f52869c.a.getWidth()) {
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
                public final /* synthetic */ PinnedSectionListView a;

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
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.b();
                    }
                }
            });
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onScrollListener) == null) {
            if (onScrollListener == this.f52877k) {
                super.setOnScrollListener(onScrollListener);
            } else {
                this.a = onScrollListener;
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
        this.f52871e = new Rect();
        this.f52872f = new PointF();
        this.f52877k = new AbsListView.OnScrollListener(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PinnedSectionListView a;

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
                this.a = this;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, absListView, i4, i5, i6) == null) {
                    AbsListView.OnScrollListener onScrollListener = this.a.a;
                    if (onScrollListener != null) {
                        onScrollListener.onScroll(absListView, i4, i5, i6);
                    }
                    ListAdapter adapter = this.a.getAdapter();
                    if (adapter == null || i5 == 0) {
                        return;
                    }
                    if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i4))) {
                        if (this.a.getChildAt(0).getTop() == this.a.getPaddingTop()) {
                            this.a.a();
                            return;
                        } else {
                            this.a.a(i4, i4, i5);
                            return;
                        }
                    }
                    int b2 = this.a.b(i4);
                    if (b2 > -1) {
                        this.a.a(b2, i4, i5);
                    } else {
                        this.a.a();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i4) {
                AbsListView.OnScrollListener onScrollListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i4) == null) || (onScrollListener = this.a.a) == null) {
                    return;
                }
                onScrollListener.onScrollStateChanged(absListView, i4);
            }
        };
        this.l = new DataSetObserver(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PinnedSectionListView a;

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
                this.a = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.b();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b();
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
        this.f52871e = new Rect();
        this.f52872f = new PointF();
        this.f52877k = new AbsListView.OnScrollListener(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PinnedSectionListView a;

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
                this.a = this;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i42, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, absListView, i42, i5, i6) == null) {
                    AbsListView.OnScrollListener onScrollListener = this.a.a;
                    if (onScrollListener != null) {
                        onScrollListener.onScroll(absListView, i42, i5, i6);
                    }
                    ListAdapter adapter = this.a.getAdapter();
                    if (adapter == null || i5 == 0) {
                        return;
                    }
                    if (PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i42))) {
                        if (this.a.getChildAt(0).getTop() == this.a.getPaddingTop()) {
                            this.a.a();
                            return;
                        } else {
                            this.a.a(i42, i42, i5);
                            return;
                        }
                    }
                    int b2 = this.a.b(i42);
                    if (b2 > -1) {
                        this.a.a(b2, i42, i5);
                    } else {
                        this.a.a();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i42) {
                AbsListView.OnScrollListener onScrollListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i42) == null) || (onScrollListener = this.a.a) == null) {
                    return;
                }
                onScrollListener.onScrollStateChanged(absListView, i42);
            }
        };
        this.l = new DataSetObserver(this) { // from class: com.baidu.wallet.base.widget.pulltorefresh.PinnedSectionListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PinnedSectionListView a;

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
                this.a = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.b();
                }
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.b();
                }
            }
        };
        c();
    }

    public void a() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f52869c) == null) {
            return;
        }
        this.f52868b = aVar;
        this.f52869c = null;
    }

    public void a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
            if (i4 < 2) {
                a();
                return;
            }
            a aVar = this.f52869c;
            if (aVar != null && aVar.f52878b != i2) {
                a();
            }
            if (this.f52869c == null) {
                a(i2);
            }
            int i5 = i2 + 1;
            if (i5 < getCount()) {
                int a2 = a(i5, i4 - (i5 - i3));
                if (a2 > -1) {
                    int top = getChildAt(a2 - i3).getTop() - (this.f52869c.a.getBottom() + getPaddingTop());
                    this.f52876j = top;
                    if (top < 0) {
                        this.f52870d = top;
                        return;
                    } else {
                        this.f52870d = 0;
                        return;
                    }
                }
                this.f52870d = 0;
                this.f52876j = Integer.MAX_VALUE;
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
            view.getHitRect(this.f52871e);
            Rect rect = this.f52871e;
            int i2 = rect.top;
            int i3 = this.f52870d;
            rect.top = i2 + i3;
            rect.bottom += i3 + getPaddingTop();
            this.f52871e.left += getPaddingLeft();
            this.f52871e.right -= getPaddingRight();
            return this.f52871e.contains((int) f2, (int) f3);
        }
        return invokeCommon.booleanValue;
    }
}
