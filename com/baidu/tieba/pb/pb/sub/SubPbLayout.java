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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
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
import d.a.c.e.p.l;
import d.a.r0.b.d;
import d.a.r0.r.u.c;
import d.a.s0.h2.k.g.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes5.dex */
public class SubPbLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f19610e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnLongClickListener f19611f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnTouchListener f19612g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.h2.k.g.b f19613h;

    /* renamed from: i  reason: collision with root package name */
    public int f19614i;
    public PostData j;
    public View k;
    public final Queue<b> l;
    public RelativeLayout m;
    public TextView n;
    public boolean o;
    public ViewGroup.MarginLayoutParams p;
    public SparseArray<Object> q;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19615a;

        /* renamed from: b  reason: collision with root package name */
        public View f19616b;

        public /* synthetic */ b(int i2, View view, a aVar) {
            this(i2, view);
        }

        public b(int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19615a = i2;
            this.f19616b = view;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public final int b(int i2, int i3) {
        InterceptResult invokeII;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (i2 > 0 && (this.j.C() == 1 || this.j.C() == 3 || this.j.N() > this.f19614i)) {
                if (this.o) {
                    format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_all_more), Integer.valueOf(this.j.N()));
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.sub_pb_load_more), Integer.valueOf(this.j.N()));
                }
                this.n.setText(format);
                this.m.setOnClickListener(this.f19610e);
                SparseArray sparseArray = (SparseArray) this.m.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.m.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, this.j);
                sparseArray.put(R.id.tag_load_sub_view, this.k);
                this.m.setVisibility(0);
                this.m.measure(((i3 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            } else {
                this.m.setVisibility(8);
            }
            if (this.m.getVisibility() == 0) {
                return this.m.getMeasuredHeight();
            }
            return 0;
        }
        return invokeII.intValue;
    }

    public final int c(List<PostData> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i2)) == null) {
            if (this.j.C() != 1 && this.j.C() != 3) {
                if (ListUtils.getCount(list) == 0) {
                    return 0;
                }
                int count = ListUtils.getCount(list);
                this.f19614i = count;
                if (!this.j.a0()) {
                    if (count <= 4) {
                        this.f19614i = count;
                    } else {
                        this.f19614i = 4;
                    }
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < this.f19614i) {
                    View childAt = getChildAt(i3);
                    if (childAt == null || childAt.equals(this.m)) {
                        childAt = this.f19613h.b();
                        childAt.setPadding(0, 0, 0, 0);
                        this.l.offer(new b(i3, childAt, null));
                    }
                    childAt.setOnClickListener(this.f19610e);
                    if (!this.o) {
                        childAt.setOnLongClickListener(this.f19611f);
                    }
                    childAt.setOnTouchListener(this.f19612g);
                    childAt.setClickable(true);
                    childAt.setVisibility(0);
                    SparseArray sparseArray = (SparseArray) childAt.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        childAt.setTag(sparseArray);
                    }
                    Object obj = sparseArray.get(R.id.tag_load_sub_data);
                    PostData postData = this.j;
                    if (obj != postData) {
                        sparseArray.put(R.id.tag_load_sub_data, postData);
                    }
                    sparseArray.put(R.id.tag_load_sub_view, this.k);
                    sparseArray.put(R.id.tag_is_subpb, Boolean.TRUE);
                    if (list.get(i3) != null && list.get(i3).t() != null) {
                        if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i3)) {
                            sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i3));
                        }
                        sparseArray.put(R.id.tag_photo_username, list.get(i3).t().getUserName());
                        sparseArray.put(R.id.tag_photo_userid, list.get(i3).t().getUserId());
                        sparseArray.put(R.id.tag_clip_board, list.get(i3));
                    }
                    SparseArray<Object> sparseArray2 = this.q;
                    if (sparseArray2 != null) {
                        sparseArray.put(-1, sparseArray2.get(-1));
                        sparseArray.put(-2, this.q.get(-2));
                        sparseArray.put(-3, this.q.get(-3));
                        sparseArray.put(-4, this.q.get(-4));
                    }
                    b.C1474b c1474b = (b.C1474b) sparseArray.get(R.id.tag_holder);
                    this.f19613h.c(c1474b, list.get(i3), this.j.N() > list.size() || list.size() - i3 > 1, i3 == 0, false);
                    c1474b.f60859e.setPadding(0, 0, 0, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                    if (d.y()) {
                        f();
                    } else {
                        e();
                    }
                    childAt.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                    i4 += childAt.getMeasuredHeight();
                    i3++;
                }
                return i4;
            }
            this.f19614i = 0;
            return 0;
        }
        return invokeLI.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (d.y()) {
                f();
            } else {
                e();
            }
            TextView textView = this.n;
            if (textView != null) {
                if (this.o) {
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
            PostData postData = this.j;
            if (postData == null || postData.M() == null) {
                return;
            }
            int i2 = this.f19614i;
            for (int i3 = 0; i3 < i2; i3++) {
                if (i2 < getChildCount()) {
                    drawChild(canvas, getChildAt(i3), drawingTime);
                }
            }
            if (this.m.getVisibility() == 0) {
                drawChild(canvas, this.m, drawingTime);
            }
        }
    }

    public final void e() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (textView = this.n) == null) {
            return;
        }
        textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.o) {
            c.d(this.n).t(R.color.CAM_X0304);
        } else {
            c.d(this.n).t(R.color.CAM_X0108);
        }
    }

    public final void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.n) == null) {
            return;
        }
        textView.setTextSize(0, TbConfig.getTestContentSizeOfLzl());
        if (this.o) {
            c.d(this.n).t(R.color.CAM_X0318);
        } else {
            c.d(this.n).t(R.color.CAM_X0108);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, attributeSet)) == null) ? new ViewGroup.MarginLayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (postData = this.j) == null || postData.M() == null) {
            return;
        }
        int size = this.l.size();
        for (int i6 = 0; i6 < size; i6++) {
            b poll = this.l.poll();
            if (poll.f19616b.getParent() == null) {
                addViewInLayout(poll.f19616b, poll.f19615a, this.p, true);
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i7 = this.f19614i;
        for (int i8 = 0; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            if (childAt != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams == null) {
                    marginLayoutParams = generateDefaultLayoutParams();
                }
                int i9 = marginLayoutParams.leftMargin;
                int i10 = paddingLeft + i9;
                int i11 = paddingTop + marginLayoutParams.topMargin;
                int measuredWidth = i9 + paddingLeft + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i11;
                childAt.layout(i10, i11, measuredWidth, measuredHeight);
                paddingTop = measuredHeight + marginLayoutParams.bottomMargin;
            }
        }
        if (this.m.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.m.getLayoutParams();
            RelativeLayout relativeLayout = this.m;
            int i12 = marginLayoutParams2.leftMargin;
            int i13 = paddingTop + marginLayoutParams2.topMargin;
            relativeLayout.layout(paddingLeft + i12, i13, paddingLeft + i12 + relativeLayout.getMeasuredWidth(), this.m.getMeasuredHeight() + i13);
        }
        int childCount = getChildCount();
        for (int i14 = this.f19614i; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2 != null && childAt2 != this.m) {
                childAt2.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        PostData postData;
        ArrayList<PostData> M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            if (this.f19613h != null && (postData = this.j) != null && postData.M() != null) {
                int size = View.MeasureSpec.getSize(i2);
                if (this.j.a0()) {
                    M = this.j.x();
                } else {
                    M = this.j.M();
                }
                setMeasuredDimension(size, c(M, size) + 0 + b(ListUtils.getCount(M), size) + getPaddingBottom() + getPaddingTop());
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.f19610e = onClickListener;
        }
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onLongClickListener) == null) {
            this.f19611f = onLongClickListener;
        }
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onTouchListener) == null) {
            this.f19612g = onTouchListener;
        }
    }

    public void setData(PostData postData, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, postData, view) == null) {
            this.j = postData;
            requestLayout();
            this.k = view;
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sparseArray) == null) {
            this.q = sparseArray;
        }
    }

    public void setShowChildComment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.o = z;
        }
    }

    public void setSubPbAdapter(d.a.s0.h2.k.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.f19613h = bVar;
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
        this.f19614i = 0;
        this.k = null;
        this.l = new LinkedList();
        this.o = false;
        this.p = new ViewGroup.MarginLayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.m = relativeLayout;
        relativeLayout.setId(R.id.pb_floor_reply_more);
        TextView textView = new TextView(context);
        this.n = textView;
        textView.setPadding(0, l.g(context, R.dimen.tbds_3), 0, l.g(context, R.dimen.tbds12));
        if (d.y()) {
            f();
        } else {
            e();
        }
        if (this.o) {
            this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.n.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.m.addView(this.n);
        addView(this.m, -1, -2);
    }
}
