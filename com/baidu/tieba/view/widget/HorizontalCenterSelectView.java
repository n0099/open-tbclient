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
import com.baidu.tieba.s75;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class HorizontalCenterSelectView extends RecyclerView {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<String> a;
    public final Paint b;
    public c c;
    public LinearLayoutManager d;
    public float e;
    public float f;
    public int g;
    public boolean h;
    public int i;
    public d j;
    public int k;
    public final RecyclerView.OnScrollListener l;

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes8.dex */
    public class c extends RecyclerView.Adapter<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalCenterSelectView a;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ c b;

            public a(c cVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.b.a.n(this.a);
            }
        }

        /* loaded from: classes8.dex */
        public class b extends RecyclerView.ViewHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public RelativeLayout a;
            public TextView b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NonNull c cVar, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0926f2);
                this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092654);
            }
        }

        public c(HorizontalCenterSelectView horizontalCenterSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalCenterSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalCenterSelectView;
        }

        public /* synthetic */ c(HorizontalCenterSelectView horizontalCenterSelectView, a aVar) {
            this(horizontalCenterSelectView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: l */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                return new b(this, LayoutInflater.from(this.a.getContext()).inflate(this.a.k, viewGroup, false));
            }
            return (b) invokeLI.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.a.size();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i) == null) {
                if (this.a.a.get(i) == null) {
                    ViewGroup.LayoutParams layoutParams = bVar.b.getLayoutParams();
                    if (i < getItemCount() / 2) {
                        layoutParams.width = Math.round(this.a.f);
                    } else {
                        layoutParams.width = Math.round(this.a.e);
                    }
                    bVar.b.setText("");
                    bVar.b.setVisibility(4);
                } else {
                    bVar.b.getLayoutParams().width = -2;
                    bVar.b.setText((CharSequence) this.a.a.get(i));
                    bVar.b.setVisibility(0);
                }
                bVar.b.setTextSize(0, this.a.b.getTextSize());
                bVar.b.setTextColor(this.a.b.getColor());
                s75.d(bVar.b).B(R.array.S_O_X001);
                bVar.b.setOnClickListener(new a(this, i));
                if (i == this.a.i) {
                    bVar.b.setAlpha(1.0f);
                } else {
                    bVar.b.setAlpha(0.5f);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.leftMargin = this.a.g / 2;
                marginLayoutParams.rightMargin = this.a.g / 2;
                bVar.a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalCenterSelectView a;

        public a(HorizontalCenterSelectView horizontalCenterSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalCenterSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalCenterSelectView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0 && this.a.h) {
                    int findFirstVisibleItemPosition = this.a.d.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = findFirstVisibleItemPosition + ((this.a.d.findLastVisibleItemPosition() - findFirstVisibleItemPosition) / 2);
                    int width = this.a.getWidth() / 2;
                    View childAt = this.a.getChildAt(findLastVisibleItemPosition);
                    if (childAt != null) {
                        int left = childAt.getLeft();
                        int width2 = childAt.getWidth();
                        int i2 = left - width;
                        if (i2 < 0 && Math.abs(i2) > width2) {
                            findLastVisibleItemPosition++;
                        } else if (i2 > 0 && childAt.getRight() - width > width2) {
                            findLastVisibleItemPosition--;
                        }
                    }
                    this.a.o(findLastVisibleItemPosition);
                    this.a.h = false;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalCenterSelectView a;

        public b(HorizontalCenterSelectView horizontalCenterSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalCenterSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalCenterSelectView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HorizontalCenterSelectView horizontalCenterSelectView = this.a;
                horizontalCenterSelectView.n(horizontalCenterSelectView.i);
            }
        }
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
        m = UtilHelper.getDimenPixelSize(R.dimen.T_X05);
        n = UtilHelper.getDimenPixelSize(R.dimen.T_X05);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            float m2 = m(2, this.a.size() - 2);
            float m3 = m(2, (this.a.size() - 2) - 1);
            float m4 = m(3, this.a.size() - 2);
            int i3 = this.g;
            this.e = (m4 / 2.0f) - i3;
            this.f = (m3 / 2.0f) - i3;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.round(m2 + Math.max(m3, m4)), 1073741824), i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalCenterSelectView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new Paint();
        this.h = false;
        this.k = R.layout.obfuscated_res_0x7f0d0458;
        this.l = new a(this);
        init();
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                i = getChildAdapterPosition(childAt);
            }
            n(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1) {
                this.h = true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.a.clear();
            this.a.addAll(list);
            for (int i = 0; i < 2; i++) {
                this.a.add(0, null);
                this.a.add(null);
            }
            this.c.notifyDataSetChanged();
        }
    }

    public void setItemLayoutResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.k = i;
        }
    }

    public void setItemTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b.setColor(i);
        }
    }

    public void setItemTextPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.g = i;
        }
    }

    public void setItemTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.b.setTextSize(i);
        }
    }

    public void setOnItemSelected(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void setSelectedPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            int i2 = i + 2;
            this.i = i2;
            smoothScrollToPosition(i2);
            post(new b(this));
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setTextSize(m);
            this.g = n;
            c cVar = new c(this, null);
            this.c = cVar;
            setAdapter(cVar);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.d = linearLayoutManager;
            linearLayoutManager.setOrientation(0);
            setLayoutManager(this.d);
            addOnScrollListener(this.l);
        }
    }

    public final float m(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            float f = 0.0f;
            if (i >= 2 && i2 <= this.a.size() - 2) {
                while (i < i2) {
                    f += this.b.measureText(this.a.get(i)) + this.g;
                    i++;
                }
            }
            return f;
        }
        return invokeII.floatValue;
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i < 2) {
                i = 3;
            }
            if (i >= this.a.size() - 2) {
                i = (this.a.size() - 2) - 1;
            }
            int width = getWidth() / 2;
            View findViewByPosition = this.d.findViewByPosition(i);
            if (findViewByPosition != null) {
                int left = findViewByPosition.getLeft();
                this.i = i;
                this.c.notifyDataSetChanged();
                smoothScrollBy((left - width) + (findViewByPosition.getWidth() / 2), 0);
                d dVar = this.j;
                if (dVar != null) {
                    dVar.a(i - 2);
                }
            }
        }
    }
}
