package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
import c.a.p0.w2.m.h.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes5.dex */
public class SubPbLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnLongClickListener f35112b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnTouchListener f35113c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.w2.m.h.b f35114d;

    /* renamed from: e  reason: collision with root package name */
    public int f35115e;

    /* renamed from: f  reason: collision with root package name */
    public PostData f35116f;

    /* renamed from: g  reason: collision with root package name */
    public View f35117g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<b> f35118h;
    public RelativeLayout i;
    public TextView j;
    public boolean k;
    public boolean l;
    public ViewGroup.MarginLayoutParams m;
    public SparseArray<Object> n;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f35119b;

        public /* synthetic */ b(int i, View view, a aVar) {
            this(i, view);
        }

        public b(int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f35119b = view;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubPbLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ViewGroup.MarginLayoutParams(-2, -2) : (ViewGroup.MarginLayoutParams) invokeV.objValue;
    }

    public final int b(int i, int i2) {
        InterceptResult invokeII;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if ((i > 0 && (this.f35116f.E() == 1 || this.f35116f.E() == 3 || this.f35116f.R() > this.f35115e)) || this.f35116f.a0(this.l)) {
                if (this.k) {
                    format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f11e2), Integer.valueOf(this.f35116f.R()));
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f11e3), Integer.valueOf(this.f35116f.R()));
                }
                this.j.setText(format);
                this.i.setOnClickListener(this.a);
                SparseArray sparseArray = (SparseArray) this.i.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.i.setTag(sparseArray);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e85, this.f35116f);
                sparseArray.put(R.id.obfuscated_res_0x7f091e87, this.f35117g);
                this.i.setVisibility(0);
                this.i.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            } else {
                this.i.setVisibility(8);
            }
            if (this.i.getVisibility() == 0) {
                return this.i.getMeasuredHeight();
            }
            return 0;
        }
        return invokeII.intValue;
    }

    public final int c(List<PostData> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i)) == null) {
            int count = ListUtils.getCount(list);
            this.f35115e = count;
            if (!this.f35116f.f0()) {
                if (count <= 4) {
                    this.f35115e = count;
                } else {
                    this.f35115e = 4;
                }
            }
            if (this.f35116f.E() != 1 && this.f35116f.E() != 3) {
                if (ListUtils.getCount(list) == 0) {
                    int childCount = getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = getChildAt(i2);
                        if (childAt != this.i) {
                            removeView(childAt);
                        }
                    }
                    this.f35118h.clear();
                    return 0;
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.f35115e) {
                    View childAt2 = getChildAt(i3);
                    if (childAt2 == null || childAt2.equals(this.i)) {
                        childAt2 = this.f35114d.b();
                        childAt2.setPadding(0, 0, 0, 0);
                        this.f35118h.offer(new b(i3, childAt2, null));
                    }
                    childAt2.setOnClickListener(this.a);
                    if (!this.k) {
                        childAt2.setOnLongClickListener(this.f35112b);
                    }
                    childAt2.setOnTouchListener(this.f35113c);
                    childAt2.setClickable(true);
                    childAt2.setVisibility(0);
                    SparseArray sparseArray = (SparseArray) childAt2.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        childAt2.setTag(sparseArray);
                    }
                    Object obj = sparseArray.get(R.id.obfuscated_res_0x7f091e85);
                    PostData postData = this.f35116f;
                    if (obj != postData) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e85, postData);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091e87, this.f35117g);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e82, Boolean.TRUE);
                    if (list.get(i3) != null && list.get(i3).s() != null) {
                        if (sparseArray.get(R.id.obfuscated_res_0x7f091e86) != list.get(i3)) {
                            sparseArray.put(R.id.obfuscated_res_0x7f091e86, list.get(i3));
                        }
                        sparseArray.put(R.id.obfuscated_res_0x7f091e99, list.get(i3).s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e97, list.get(i3).s().getPortrait());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e98, list.get(i3).s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f091e69, list.get(i3));
                    }
                    SparseArray<Object> sparseArray2 = this.n;
                    if (sparseArray2 != null) {
                        sparseArray.put(-1, sparseArray2.get(-1));
                        sparseArray.put(-2, this.n.get(-2));
                        sparseArray.put(-3, this.n.get(-3));
                        sparseArray.put(-4, this.n.get(-4));
                    }
                    b.C1520b c1520b = (b.C1520b) sparseArray.get(R.id.obfuscated_res_0x7f091e7e);
                    this.f35114d.c(c1520b, list.get(i3), this.f35116f.R() > list.size() || list.size() - i3 > 1, i3 == 0, false);
                    c1520b.f20387e.setPadding(0, 0, 0, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                    if (UbsABTestHelper.isPBPlanA()) {
                        f();
                    } else {
                        e();
                    }
                    childAt2.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                    i4 += childAt2.getMeasuredHeight();
                    i3++;
                }
                return i4;
            }
            this.f35115e = 0;
            return 0;
        }
        return invokeLI.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (UbsABTestHelper.isPBPlanA()) {
                f();
            } else {
                e();
            }
            TextView textView = this.j;
            if (textView != null) {
                if (this.k) {
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            long drawingTime = getDrawingTime();
            PostData postData = this.f35116f;
            if (postData == null || postData.P() == null) {
                return;
            }
            int i = this.f35115e;
            for (int i2 = 0; i2 < i; i2++) {
                if (i < getChildCount()) {
                    drawChild(canvas, getChildAt(i2), drawingTime);
                }
            }
            if (this.i.getVisibility() == 0) {
                drawChild(canvas, this.i, drawingTime);
            }
        }
    }

    public final void e() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.k) {
            c.d(this.j).v(R.color.CAM_X0304);
        } else {
            c.d(this.j).v(R.color.CAM_X0108);
        }
    }

    public final void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextSize(0, TbConfig.getTestContentSizeOfLzl());
        if (this.k) {
            c.d(this.j).v(R.color.CAM_X0318);
        } else {
            c.d(this.j).v(R.color.CAM_X0108);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, attributeSet)) == null) ? new ViewGroup.MarginLayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || (postData = this.f35116f) == null || postData.P() == null) {
            return;
        }
        int size = this.f35118h.size();
        for (int i5 = 0; i5 < size; i5++) {
            b poll = this.f35118h.poll();
            if (poll.f35119b.getParent() == null) {
                addViewInLayout(poll.f35119b, poll.a, this.m, true);
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = this.f35115e;
        for (int i7 = 0; i7 < i6; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams == null) {
                    marginLayoutParams = generateDefaultLayoutParams();
                }
                int i8 = marginLayoutParams.leftMargin;
                int i9 = paddingLeft + i8;
                int i10 = paddingTop + marginLayoutParams.topMargin;
                int measuredWidth = i8 + paddingLeft + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i10;
                childAt.layout(i9, i10, measuredWidth, measuredHeight);
                paddingTop = measuredHeight + marginLayoutParams.bottomMargin;
            }
        }
        if (this.i.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            RelativeLayout relativeLayout = this.i;
            int i11 = marginLayoutParams2.leftMargin;
            int i12 = paddingTop + marginLayoutParams2.topMargin;
            relativeLayout.layout(paddingLeft + i11, i12, paddingLeft + i11 + relativeLayout.getMeasuredWidth(), this.i.getMeasuredHeight() + i12);
        }
        int childCount = getChildCount();
        for (int i13 = this.f35115e; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2 != null && childAt2 != this.i) {
                childAt2.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        PostData postData;
        ArrayList<PostData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            if (this.f35114d != null && (postData = this.f35116f) != null && postData.P() != null) {
                int size = View.MeasureSpec.getSize(i);
                if (this.f35116f.f0()) {
                    P = this.f35116f.x();
                } else {
                    P = this.f35116f.P();
                }
                setMeasuredDimension(size, c(P, size) + 0 + b(ListUtils.getCount(P), size) + getPaddingBottom() + getPaddingTop());
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.a = onClickListener;
        }
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onLongClickListener) == null) {
            this.f35112b = onLongClickListener;
        }
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onTouchListener) == null) {
            this.f35113c = onTouchListener;
        }
    }

    public void setData(PostData postData, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, postData, view) == null) {
            this.f35116f = postData;
            requestLayout();
            this.f35117g = view;
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sparseArray) == null) {
            this.n = sparseArray;
        }
    }

    public void setIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.l = z;
        }
    }

    public void setShowChildComment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.k = z;
        }
    }

    public void setSubPbAdapter(c.a.p0.w2.m.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f35114d = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35115e = 0;
        this.f35117g = null;
        this.f35118h = new LinkedList();
        this.k = false;
        this.l = false;
        this.m = new ViewGroup.MarginLayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.i = relativeLayout;
        relativeLayout.setId(R.id.obfuscated_res_0x7f0916b6);
        TextView textView = new TextView(context);
        this.j = textView;
        textView.setPadding(0, n.f(context, R.dimen.tbds_3), 0, n.f(context, R.dimen.tbds12));
        if (UbsABTestHelper.isPBPlanA()) {
            f();
        } else {
            e();
        }
        if (this.k) {
            this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.j.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.i.addView(this.j);
        addView(this.i, -1, -2);
    }
}
