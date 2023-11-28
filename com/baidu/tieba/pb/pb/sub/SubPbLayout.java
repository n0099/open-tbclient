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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.g5a;
import com.baidu.tieba.nwa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public class SubPbLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener a;
    public View.OnLongClickListener b;
    public View.OnTouchListener c;
    public g5a d;
    public int e;
    public nwa f;
    public View g;
    public final Queue<b> h;
    public RelativeLayout i;
    public TextView j;
    public boolean k;
    public boolean l;
    public ViewGroup.MarginLayoutParams m;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;

        public b(int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), view2};
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
            this.b = view2;
        }

        public /* synthetic */ b(int i, View view2, a aVar) {
            this(i, view2);
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            long drawingTime = getDrawingTime();
            nwa nwaVar = this.f;
            if (nwaVar != null && nwaVar.k0() != null) {
                int i = this.e;
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
        this.e = 0;
        this.g = null;
        this.h = new LinkedList();
        this.k = false;
        this.l = false;
        this.m = new ViewGroup.MarginLayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.i = relativeLayout;
        relativeLayout.setId(R.id.obfuscated_res_0x7f091bb8);
        TextView textView = new TextView(context);
        this.j = textView;
        textView.setPadding(0, BdUtilHelper.getDimens(context, R.dimen.tbds_3), 0, BdUtilHelper.getDimens(context, R.dimen.tbds12));
        e();
        if (this.k) {
            this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_pb_comment_more_n), (Drawable) null);
            this.j.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        }
        this.i.addView(this.j);
        addView(this.i, -1, -2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new ViewGroup.MarginLayoutParams(-2, -2);
        }
        return (ViewGroup.MarginLayoutParams) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e();
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

    public final int b(int i, int i2) {
        InterceptResult invokeII;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if ((i > 0 && (this.f.P() == 1 || this.f.P() == 3 || this.f.m0() > this.e)) || this.f.A0(this.l)) {
                if (this.k) {
                    format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f14d3), Integer.valueOf(this.f.m0()));
                } else {
                    format = String.format(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f14d4), Integer.valueOf(this.f.m0()));
                }
                this.j.setText(format);
                this.i.setOnClickListener(this.a);
                SparseArray sparseArray = (SparseArray) this.i.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.i.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, this.f);
                sparseArray.put(R.id.tag_load_sub_view, this.g);
                this.i.setVisibility(0);
                this.i.measure(((i2 - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
            } else {
                this.i.setVisibility(8);
            }
            if (this.i.getVisibility() != 0) {
                return 0;
            }
            return this.i.getMeasuredHeight();
        }
        return invokeII.intValue;
    }

    public final int c(List<nwa> list, int i) {
        InterceptResult invokeLI;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i)) == null) {
            int count = ListUtils.getCount(list);
            this.e = count;
            if (!this.f.J0()) {
                if (count <= 4) {
                    this.e = count;
                } else {
                    this.e = 4;
                }
            }
            if (this.f.P() != 1 && this.f.P() != 3) {
                if (ListUtils.getCount(list) == 0) {
                    int childCount = getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = getChildAt(i2);
                        if (childAt != this.i) {
                            removeView(childAt);
                        }
                    }
                    this.h.clear();
                    return 0;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.e; i4++) {
                    View childAt2 = getChildAt(i4);
                    if (childAt2 == null || childAt2.equals(this.i)) {
                        childAt2 = this.d.b();
                        childAt2.setPadding(0, 0, 0, 0);
                        this.h.offer(new b(i4, childAt2, null));
                    }
                    childAt2.setOnClickListener(this.a);
                    if (!this.k) {
                        childAt2.setOnLongClickListener(this.b);
                    }
                    childAt2.setOnTouchListener(this.c);
                    childAt2.setClickable(true);
                    childAt2.setVisibility(0);
                    SparseArray sparseArray = (SparseArray) childAt2.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        childAt2.setTag(sparseArray);
                    }
                    Object obj = sparseArray.get(R.id.tag_load_sub_data);
                    nwa nwaVar = this.f;
                    if (obj != nwaVar) {
                        sparseArray.put(R.id.tag_load_sub_data, nwaVar);
                    }
                    sparseArray.put(R.id.tag_load_sub_view, this.g);
                    sparseArray.put(R.id.tag_is_subpb, Boolean.TRUE);
                    if (list.get(i4) != null && list.get(i4).u() != null) {
                        if (sparseArray.get(R.id.tag_load_sub_reply_data) != list.get(i4)) {
                            sparseArray.put(R.id.tag_load_sub_reply_data, list.get(i4));
                        }
                        sparseArray.put(R.id.tag_photo_username, list.get(i4).u().getUserName());
                        sparseArray.put(R.id.tag_photo_portrait, list.get(i4).u().getPortrait());
                        sparseArray.put(R.id.tag_photo_userid, list.get(i4).u().getUserId());
                        sparseArray.put(R.id.tag_clip_board, list.get(i4));
                    }
                    g5a.b bVar = (g5a.b) sparseArray.get(R.id.tag_holder);
                    g5a g5aVar = this.d;
                    nwa nwaVar2 = list.get(i4);
                    if (this.f.m0() <= list.size() && list.size() - i4 <= 1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (i4 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    g5aVar.c(bVar, nwaVar2, z, z2, false);
                    bVar.e.setPadding(0, 0, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
                    e();
                    childAt2.measure(((i - getPaddingLeft()) - getPaddingRight()) + 1073741824, 0);
                    i3 += childAt2.getMeasuredHeight();
                }
                return i3;
            }
            this.e = 0;
            return 0;
        }
        return invokeLI.intValue;
    }

    public final void e() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (textView = this.j) != null) {
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            if (this.k) {
                EMManager.from(this.j).setTextColor(R.color.CAM_X0304);
            } else {
                EMManager.from(this.j).setTextColor(R.color.CAM_X0108);
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, attributeSet)) == null) {
            return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public void setChildOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.a = onClickListener;
        }
    }

    public void setChildOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onLongClickListener) == null) {
            this.b = onLongClickListener;
        }
    }

    public void setChildOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onTouchListener) == null) {
            this.c = onTouchListener;
        }
    }

    public void setIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.l = z;
        }
    }

    public void setShowChildComment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.k = z;
        }
    }

    public void setSubPbAdapter(g5a g5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, g5aVar) == null) {
            this.d = g5aVar;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        nwa nwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && (nwaVar = this.f) != null && nwaVar.k0() != null) {
            int size = this.h.size();
            for (int i5 = 0; i5 < size; i5++) {
                b poll = this.h.poll();
                if (poll != null && poll.b.getParent() == null) {
                    addViewInLayout(poll.b, poll.a, this.m, true);
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i6 = this.e;
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
            for (int i13 = this.e; i13 < childCount; i13++) {
                View childAt2 = getChildAt(i13);
                if (childAt2 != null && childAt2 != this.i) {
                    childAt2.setVisibility(8);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        nwa nwaVar;
        ArrayList<nwa> k0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            if (this.d != null && (nwaVar = this.f) != null && nwaVar.k0() != null) {
                int size = View.MeasureSpec.getSize(i);
                if (this.f.J0()) {
                    k0 = this.f.E();
                } else {
                    k0 = this.f.k0();
                }
                setMeasuredDimension(size, c(k0, size) + 0 + b(ListUtils.getCount(k0), size) + getPaddingBottom() + getPaddingTop());
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    public void setData(nwa nwaVar, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, nwaVar, view2) == null) {
            this.f = nwaVar;
            requestLayout();
            this.g = view2;
        }
    }
}
