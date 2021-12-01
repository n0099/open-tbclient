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
import c.a.q0.b.d;
import c.a.q0.s.u.c;
import c.a.r0.q2.f;
import c.a.r0.q2.g;
import c.a.r0.q2.h;
import c.a.r0.q2.i;
import c.a.r0.q2.l;
import c.a.r0.q2.u.h.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
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
/* loaded from: classes11.dex */
public class SubPbLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f47857e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnLongClickListener f47858f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnTouchListener f47859g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.q2.u.h.b f47860h;

    /* renamed from: i  reason: collision with root package name */
    public int f47861i;

    /* renamed from: j  reason: collision with root package name */
    public PostData f47862j;

    /* renamed from: k  reason: collision with root package name */
    public View f47863k;
    public final Queue<b> l;
    public RelativeLayout m;
    public TextView n;
    public boolean o;
    public boolean p;
    public ViewGroup.MarginLayoutParams q;
    public SparseArray<Object> r;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f47864b;

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
            this.a = i2;
            this.f47864b = view;
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

    public final int a(int i2, int i3) {
        InterceptResult invokeII;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            if ((i2 > 0 && (this.f47862j.E() == 1 || this.f47862j.E() == 3 || this.f47862j.Q() > this.f47861i)) || this.f47862j.Z(this.p)) {
                if (this.o) {
                    format = String.format(TbadkCoreApplication.getInst().getApp().getString(l.sub_pb_load_all_more), Integer.valueOf(this.f47862j.Q()));
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getApp().getString(l.sub_pb_load_more), Integer.valueOf(this.f47862j.Q()));
                }
                this.n.setText(format);
                this.m.setOnClickListener(this.f47857e);
                SparseArray sparseArray = (SparseArray) this.m.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.m.setTag(sparseArray);
                }
                sparseArray.put(i.tag_load_sub_data, this.f47862j);
                sparseArray.put(i.tag_load_sub_view, this.f47863k);
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

    public final int b(List<PostData> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2)) == null) {
            int count = ListUtils.getCount(list);
            this.f47861i = count;
            if (!this.f47862j.e0()) {
                if (count <= 4) {
                    this.f47861i = count;
                } else {
                    this.f47861i = 4;
                }
            }
            if (this.f47862j.E() != 1 && this.f47862j.E() != 3) {
                if (ListUtils.getCount(list) == 0) {
                    int childCount = getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = getChildAt(i3);
                        if (childAt != this.m) {
                            removeView(childAt);
                        }
                    }
                    this.l.clear();
                    return 0;
                }
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f47861i) {
                    View childAt2 = getChildAt(i4);
                    if (childAt2 == null || childAt2.equals(this.m)) {
                        childAt2 = this.f47860h.b();
                        childAt2.setPadding(0, 0, 0, 0);
                        this.l.offer(new b(i4, childAt2, null));
                    }
                    childAt2.setOnClickListener(this.f47857e);
                    if (!this.o) {
                        childAt2.setOnLongClickListener(this.f47858f);
                    }
                    childAt2.setOnTouchListener(this.f47859g);
                    childAt2.setClickable(true);
                    childAt2.setVisibility(0);
                    SparseArray sparseArray = (SparseArray) childAt2.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        childAt2.setTag(sparseArray);
                    }
                    Object obj = sparseArray.get(i.tag_load_sub_data);
                    PostData postData = this.f47862j;
                    if (obj != postData) {
                        sparseArray.put(i.tag_load_sub_data, postData);
                    }
                    sparseArray.put(i.tag_load_sub_view, this.f47863k);
                    sparseArray.put(i.tag_is_subpb, Boolean.TRUE);
                    if (list.get(i4) != null && list.get(i4).t() != null) {
                        if (sparseArray.get(i.tag_load_sub_reply_data) != list.get(i4)) {
                            sparseArray.put(i.tag_load_sub_reply_data, list.get(i4));
                        }
                        sparseArray.put(i.tag_photo_username, list.get(i4).t().getUserName());
                        sparseArray.put(i.tag_photo_portrait, list.get(i4).t().getPortrait());
                        sparseArray.put(i.tag_photo_userid, list.get(i4).t().getUserId());
                        sparseArray.put(i.tag_clip_board, list.get(i4));
                    }
                    SparseArray<Object> sparseArray2 = this.r;
                    if (sparseArray2 != null) {
                        sparseArray.put(-1, sparseArray2.get(-1));
                        sparseArray.put(-2, this.r.get(-2));
                        sparseArray.put(-3, this.r.get(-3));
                        sparseArray.put(-4, this.r.get(-4));
                    }
                    b.C1291b c1291b = (b.C1291b) sparseArray.get(i.tag_holder);
                    this.f47860h.c(c1291b, list.get(i4), this.f47862j.Q() > list.size() || list.size() - i4 > 1, i4 == 0, false);
                    c1291b.f22301e.setPadding(0, 0, 0, c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), g.tbds7));
                    if (d.L()) {
                        d();
                    } else {
                        c();
                    }
                    childAt2.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                    i5 += childAt2.getMeasuredHeight();
                    i4++;
                }
                return i5;
            }
            this.f47861i = 0;
            return 0;
        }
        return invokeLI.intValue;
    }

    public final void c() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (textView = this.n) == null) {
            return;
        }
        textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
        if (this.o) {
            c.d(this.n).v(f.CAM_X0304);
        } else {
            c.d(this.n).v(f.CAM_X0108);
        }
    }

    public final void d() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (textView = this.n) == null) {
            return;
        }
        textView.setTextSize(0, TbConfig.getTestContentSizeOfLzl());
        if (this.o) {
            c.d(this.n).v(f.CAM_X0318);
        } else {
            c.d(this.n).v(f.CAM_X0108);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            long drawingTime = getDrawingTime();
            PostData postData = this.f47862j;
            if (postData == null || postData.O() == null) {
                return;
            }
            int i2 = this.f47861i;
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

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, attributeSet)) == null) ? new ViewGroup.MarginLayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (d.L()) {
                d();
            } else {
                c();
            }
            TextView textView = this.n;
            if (textView != null) {
                if (this.o) {
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(h.icon_pb_comment_more_n), (Drawable) null);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (postData = this.f47862j) == null || postData.O() == null) {
            return;
        }
        int size = this.l.size();
        for (int i6 = 0; i6 < size; i6++) {
            b poll = this.l.poll();
            if (poll.f47864b.getParent() == null) {
                addViewInLayout(poll.f47864b, poll.a, this.q, true);
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i7 = this.f47861i;
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
        for (int i14 = this.f47861i; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2 != null && childAt2 != this.m) {
                childAt2.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        PostData postData;
        ArrayList<PostData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            if (this.f47860h != null && (postData = this.f47862j) != null && postData.O() != null) {
                int size = View.MeasureSpec.getSize(i2);
                if (this.f47862j.e0()) {
                    O = this.f47862j.x();
                } else {
                    O = this.f47862j.O();
                }
                setMeasuredDimension(size, b(O, size) + 0 + a(ListUtils.getCount(O), size) + getPaddingBottom() + getPaddingTop());
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.f47857e = onClickListener;
        }
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onLongClickListener) == null) {
            this.f47858f = onLongClickListener;
        }
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onTouchListener) == null) {
            this.f47859g = onTouchListener;
        }
    }

    public void setData(PostData postData, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, postData, view) == null) {
            this.f47862j = postData;
            requestLayout();
            this.f47863k = view;
        }
    }

    public void setDefaultTag(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sparseArray) == null) {
            this.r = sparseArray;
        }
    }

    public void setIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.p = z;
        }
    }

    public void setShowChildComment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.o = z;
        }
    }

    public void setSubPbAdapter(c.a.r0.q2.u.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f47860h = bVar;
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
        this.f47861i = 0;
        this.f47863k = null;
        this.l = new LinkedList();
        this.o = false;
        this.p = false;
        this.q = new ViewGroup.MarginLayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.m = relativeLayout;
        relativeLayout.setId(i.pb_floor_reply_more);
        TextView textView = new TextView(context);
        this.n = textView;
        textView.setPadding(0, c.a.d.f.p.l.f(context, g.tbds_3), 0, c.a.d.f.p.l.f(context, g.tbds12));
        if (d.L()) {
            d();
        } else {
            c();
        }
        if (this.o) {
            this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.n.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(h.icon_pb_comment_more_n), (Drawable) null);
            this.n.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(g.tbds4));
        }
        this.m.addView(this.n);
        addView(this.m, -1, -2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ViewGroup.MarginLayoutParams(-2, -2) : (ViewGroup.MarginLayoutParams) invokeV.objValue;
    }
}
