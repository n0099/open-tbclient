package com.baidu.tieba.view.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class HorizontalCenterSelectView extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public static final int DEFAULT_ITEM_TEXT_PADDING;
    public static final int DEFAULT_ITEM_TEXT_SIZE;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f58497e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f58498f;

    /* renamed from: g  reason: collision with root package name */
    public c f58499g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayoutManager f58500h;

    /* renamed from: i  reason: collision with root package name */
    public float f58501i;

    /* renamed from: j  reason: collision with root package name */
    public float f58502j;
    public int k;
    public boolean l;
    public int m;
    public d n;
    public int o;
    public final RecyclerView.OnScrollListener p;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalCenterSelectView f58503a;

        public a(HorizontalCenterSelectView horizontalCenterSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalCenterSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58503a = horizontalCenterSelectView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && this.f58503a.l) {
                    int findFirstVisibleItemPosition = this.f58503a.f58500h.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = findFirstVisibleItemPosition + ((this.f58503a.f58500h.findLastVisibleItemPosition() - findFirstVisibleItemPosition) / 2);
                    int width = this.f58503a.getWidth() / 2;
                    View childAt = this.f58503a.getChildAt(findLastVisibleItemPosition);
                    if (childAt != null) {
                        int left = childAt.getLeft();
                        int width2 = childAt.getWidth();
                        int i3 = left - width;
                        if (i3 < 0 && Math.abs(i3) > width2) {
                            findLastVisibleItemPosition++;
                        } else if (i3 > 0 && childAt.getRight() - width > width2) {
                            findLastVisibleItemPosition--;
                        }
                    }
                    this.f58503a.p(findLastVisibleItemPosition);
                    this.f58503a.l = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalCenterSelectView f58504e;

        public b(HorizontalCenterSelectView horizontalCenterSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalCenterSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58504e = horizontalCenterSelectView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HorizontalCenterSelectView horizontalCenterSelectView = this.f58504e;
                horizontalCenterSelectView.o(horizontalCenterSelectView.m);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalCenterSelectView f58505a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58506e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f58507f;

            public a(c cVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58507f = cVar;
                this.f58506e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f58507f.f58505a.o(this.f58506e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public RelativeLayout f58508a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f58509b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NonNull c cVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58508a = (RelativeLayout) view.findViewById(R.id.tv_parent);
                this.f58509b = (TextView) view.findViewById(R.id.tv);
            }
        }

        public c(HorizontalCenterSelectView horizontalCenterSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalCenterSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58505a = horizontalCenterSelectView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, bVar, i2) == null) {
                if (this.f58505a.f58497e.get(i2) == null) {
                    ViewGroup.LayoutParams layoutParams = bVar.f58509b.getLayoutParams();
                    if (i2 < getItemCount() / 2) {
                        layoutParams.width = Math.round(this.f58505a.f58502j);
                    } else {
                        layoutParams.width = Math.round(this.f58505a.f58501i);
                    }
                    bVar.f58509b.setText("");
                    bVar.f58509b.setVisibility(4);
                } else {
                    bVar.f58509b.getLayoutParams().width = -2;
                    bVar.f58509b.setText((CharSequence) this.f58505a.f58497e.get(i2));
                    bVar.f58509b.setVisibility(0);
                }
                bVar.f58509b.setTextSize(0, this.f58505a.f58498f.getTextSize());
                bVar.f58509b.setTextColor(this.f58505a.f58498f.getColor());
                c.a.q0.s.u.c.d(bVar.f58509b).z(R.array.S_O_X001);
                bVar.f58509b.setOnClickListener(new a(this, i2));
                if (i2 == this.f58505a.m) {
                    bVar.f58509b.setAlpha(1.0f);
                } else {
                    bVar.f58509b.setAlpha(0.5f);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.leftMargin = this.f58505a.k / 2;
                marginLayoutParams.rightMargin = this.f58505a.k / 2;
                bVar.f58508a.setLayoutParams(marginLayoutParams);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new b(this, LayoutInflater.from(this.f58505a.getContext()).inflate(this.f58505a.o, viewGroup, false)) : (b) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58505a.f58497e.size() : invokeV.intValue;
        }

        public /* synthetic */ c(HorizontalCenterSelectView horizontalCenterSelectView, a aVar) {
            this(horizontalCenterSelectView);
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void onSelected(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2141726734, "Lcom/baidu/tieba/view/widget/HorizontalCenterSelectView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2141726734, "Lcom/baidu/tieba/view/widget/HorizontalCenterSelectView;");
                return;
            }
        }
        DEFAULT_ITEM_TEXT_SIZE = UtilHelper.getDimenPixelSize(R.dimen.T_X05);
        DEFAULT_ITEM_TEXT_PADDING = UtilHelper.getDimenPixelSize(R.dimen.T_X05);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HorizontalCenterSelectView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final float m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            float f2 = 0.0f;
            if (i2 >= 2 && i3 <= this.f58497e.size() - 2) {
                while (i2 < i3) {
                    f2 += this.f58498f.measureText(this.f58497e.get(i2)) + this.k;
                    i2++;
                }
            }
            return f2;
        }
        return invokeII.floatValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f58498f.setTextSize(DEFAULT_ITEM_TEXT_SIZE);
            this.k = DEFAULT_ITEM_TEXT_PADDING;
            c cVar = new c(this, null);
            this.f58499g = cVar;
            setAdapter(cVar);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f58500h = linearLayoutManager;
            linearLayoutManager.setOrientation(0);
            setLayoutManager(this.f58500h);
            addOnScrollListener(this.p);
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 < 2) {
                i2 = 3;
            }
            if (i2 >= this.f58497e.size() - 2) {
                i2 = (this.f58497e.size() - 2) - 1;
            }
            int width = getWidth() / 2;
            View findViewByPosition = this.f58500h.findViewByPosition(i2);
            if (findViewByPosition != null) {
                int left = findViewByPosition.getLeft();
                this.m = i2;
                this.f58499g.notifyDataSetChanged();
                smoothScrollBy((left - width) + (findViewByPosition.getWidth() / 2), 0);
                d dVar = this.n;
                if (dVar != null) {
                    dVar.onSelected(i2 - 2);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            float m = m(2, this.f58497e.size() - 2);
            float m2 = m(2, (this.f58497e.size() - 2) - 1);
            float m3 = m(3, this.f58497e.size() - 2);
            int i4 = this.k;
            this.f58501i = (m3 / 2.0f) - i4;
            this.f58502j = (m2 / 2.0f) - i4;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.round(m + Math.max(m2, m3)), 1073741824), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                this.l = true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                i2 = getChildAdapterPosition(childAt);
            }
            o(i2);
        }
    }

    public void setData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f58497e.clear();
            this.f58497e.addAll(list);
            for (int i2 = 0; i2 < 2; i2++) {
                this.f58497e.add(0, null);
                this.f58497e.add(null);
            }
            this.f58499g.notifyDataSetChanged();
        }
    }

    public void setItemLayoutResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setItemTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f58498f.setColor(i2);
        }
    }

    public void setItemTextPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setItemTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f58498f.setTextSize(i2);
        }
    }

    public void setOnItemSelected(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void setSelectedPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            int i3 = i2 + 2;
            this.m = i3;
            smoothScrollToPosition(i3);
            post(new b(this));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HorizontalCenterSelectView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalCenterSelectView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f58497e = new ArrayList();
        this.f58498f = new Paint();
        this.l = false;
        this.o = R.layout.item_pading;
        this.p = new a(this);
        n();
    }
}
