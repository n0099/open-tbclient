package com.baidu.tieba.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import c.a.d.f.p.l;
import c.a.k.q;
import c.a.q0.s.u.c;
import c.a.r0.w2.b;
import c.a.r0.w2.d;
import c.a.r0.w2.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.widget.InterestForumTagView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public class InterestForumTagLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final float f50740e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f50741f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f50742g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f50743h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f50744i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f50745j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f50746k;
    public List<SelectForumData> l;

    /* loaded from: classes11.dex */
    public class a implements InterestForumTagView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterestForumTagLayout a;

        public a(InterestForumTagLayout interestForumTagLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestForumTagLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interestForumTagLayout;
        }

        @Override // com.baidu.tieba.widget.InterestForumTagView.b
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || ListUtils.isEmpty(this.a.l) || selectForumData == null || this.a.f50743h == null) {
                return;
            }
            int indexOf = this.a.l.indexOf(selectForumData);
            if (indexOf != -1 && this.a.f50743h.getChildCount() > indexOf) {
                this.a.f50743h.removeViewAt(indexOf);
                this.a.l.remove(selectForumData);
            }
            if (ListUtils.isEmpty(this.a.l)) {
                this.a.e();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagLayout(Context context) {
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

    private InterestForumTagView.b getCloseListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new a(this) : (InterestForumTagView.b) invokeV.objValue;
    }

    public void bindForums(List<SelectForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            bindForums(this.f50741f, list, this.f50746k);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.l) || getContext() == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.f(getContext(), b.M_W_X004), 0);
        int size = this.l.size();
        if (size > 2) {
            size = 2;
        }
        for (int i2 = 0; i2 < size; i2++) {
            f(layoutParams, this.l.get(i2));
        }
    }

    public final void e() {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f50743h == null || getContext() == null) {
            return;
        }
        if (this.f50746k) {
            string = this.f50741f.getString(g.interest_forum_empty_concern_hint);
        } else {
            string = this.f50741f.getString(g.interest_forum_choose_hint);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        EMTextView eMTextView = new EMTextView(getContext());
        this.f50744i = eMTextView;
        eMTextView.setText(string);
        this.f50743h.addView(this.f50744i, layoutParams);
        g();
    }

    public final void f(LinearLayout.LayoutParams layoutParams, SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, layoutParams, selectForumData) == null) || selectForumData == null || layoutParams == null || getContext() == null) {
            return;
        }
        InterestForumTagView interestForumTagView = new InterestForumTagView(getContext());
        interestForumTagView.onChangeSkinType(this.f50741f, TbadkCoreApplication.getInst().getSkinType());
        interestForumTagView.bindForum(selectForumData);
        interestForumTagView.setCloseListener(getCloseListener());
        float f2 = this.f50740e;
        if (interestForumTagView.getInitialMeasuredWidth() > f2) {
            interestForumTagView.resetNameWithMaxWidth(f2);
        }
        this.f50743h.addView(interestForumTagView, layoutParams);
    }

    public final void g() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eMTextView = this.f50744i) == null) {
            return;
        }
        c d2 = c.d(eMTextView);
        d2.v(c.a.r0.w2.a.CAM_X0110);
        d2.z(b.T_X06);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setPadding(l.f(getContext(), b.M_W_X012), l.f(getContext(), b.tbds36), l.f(getContext(), b.M_W_X009), l.f(getContext(), b.M_W_X002));
            setOrientation(1);
            EMTextView eMTextView = new EMTextView(getContext());
            this.f50742g = eMTextView;
            eMTextView.setText(getContext().getString(g.interest_forum_tag_title));
            addView(this.f50742g);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, l.f(getContext(), b.M_H_X004), 0, 0);
            addView(relativeLayout, layoutParams);
            ImageView imageView = new ImageView(getContext());
            this.f50745j = imageView;
            imageView.setId(d.interest_forum_tag_arrow_id);
            int f2 = l.f(getContext(), b.tbds42);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f2, f2);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(15, -1);
            relativeLayout.addView(this.f50745j, layoutParams2);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f50743h = linearLayout;
            linearLayout.setGravity(16);
            this.f50743h.setMinimumHeight(l.f(getContext(), b.tbds68));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(15, -1);
            layoutParams3.addRule(0, d.interest_forum_tag_arrow_id);
            relativeLayout.addView(this.f50743h, layoutParams3);
            onChangeSkinType(this.f50741f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            EMTextView eMTextView = this.f50742g;
            if (eMTextView != null) {
                c d2 = c.d(eMTextView);
                d2.v(c.a.r0.w2.a.CAM_X0108);
                d2.z(b.T_X06);
            }
            LinearLayout linearLayout = this.f50743h;
            if (linearLayout != null) {
                int childCount = linearLayout.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.f50743h.getChildAt(i3);
                    if (childAt instanceof q) {
                        ((q) childAt).onChangeSkinType(tbPageContext, i2);
                    }
                }
            }
            ImageView imageView = this.f50745j;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, c.a.r0.w2.c.icon_common_arrow16_right_n, c.a.r0.w2.a.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            }
            g();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void bindForums(TbPageContext tbPageContext, List<SelectForumData> list, boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, tbPageContext, list, z) == null) || tbPageContext == null || (linearLayout = this.f50743h) == null) {
            return;
        }
        this.l = list;
        this.f50741f = tbPageContext;
        this.f50746k = z;
        linearLayout.removeAllViews();
        this.f50744i = null;
        if (ListUtils.isEmpty(list)) {
            e();
        } else {
            d();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public InterestForumTagLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f50740e = ((((((l.k(getContext()) - l.f(getContext(), b.M_W_X012)) - l.f(getContext(), b.M_W_X009)) - l.f(getContext(), b.tbds42)) - l.f(getContext(), b.M_W_X008)) - (l.f(getContext(), b.M_W_X004) * 2)) * 1.0f) / 2.0f;
        h();
    }
}
