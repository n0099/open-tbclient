package com.baidu.tieba.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.s0.s.u.c;
import c.a.t0.y2.b;
import c.a.t0.y2.d;
import c.a.t0.y2.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.widget.InterestForumTagView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes13.dex */
public class InterestForumTagLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final float f51538e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f51539f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51540g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f51541h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f51542i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f51543j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f51544k;
    public List<SelectForumData> l;
    public InterestForumTagView.b m;

    /* loaded from: classes13.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || ListUtils.isEmpty(this.a.l) || selectForumData == null || this.a.f51541h == null) {
                return;
            }
            int indexOf = this.a.l.indexOf(selectForumData);
            if (indexOf != -1 && this.a.f51541h.getChildCount() > indexOf) {
                this.a.f51541h.removeViewAt(indexOf);
                this.a.l.remove(selectForumData);
            }
            if (ListUtils.isEmpty(this.a.l)) {
                this.a.f();
            }
            if (this.a.m != null) {
                this.a.m.a(selectForumData);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? new a(this) : (InterestForumTagView.b) invokeV.objValue;
    }

    public void bindForums(List<SelectForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            bindForums(this.f51539f, list, this.f51544k);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.l) || getContext() == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, n.f(getContext(), b.M_W_X004), 0);
        int size = this.l.size();
        if (size > 2) {
            size = 2;
        }
        for (int i2 = 0; i2 < size; i2++) {
            g(layoutParams, this.l.get(i2));
        }
    }

    public final void f() {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f51541h == null || getContext() == null) {
            return;
        }
        if (this.f51544k) {
            string = this.f51539f.getString(g.interest_forum_empty_concern_hint);
        } else {
            string = this.f51539f.getString(g.interest_forum_choose_hint);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        EMTextView eMTextView = new EMTextView(getContext());
        this.f51542i = eMTextView;
        eMTextView.setText(string);
        this.f51541h.addView(this.f51542i, layoutParams);
        h();
    }

    public final void g(LinearLayout.LayoutParams layoutParams, SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, layoutParams, selectForumData) == null) || selectForumData == null || layoutParams == null || getContext() == null) {
            return;
        }
        InterestForumTagView interestForumTagView = new InterestForumTagView(getContext());
        interestForumTagView.onChangeSkinType(this.f51539f, TbadkCoreApplication.getInst().getSkinType());
        interestForumTagView.bindForum(selectForumData);
        interestForumTagView.setCloseListener(getCloseListener());
        float f2 = this.f51538e;
        if (interestForumTagView.getInitialMeasuredWidth() > f2) {
            interestForumTagView.resetNameWithMaxWidth(f2);
        }
        this.f51541h.addView(interestForumTagView, layoutParams);
    }

    public final void h() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eMTextView = this.f51542i) == null) {
            return;
        }
        c d2 = c.d(eMTextView);
        d2.v(c.a.t0.y2.a.CAM_X0110);
        d2.z(b.T_X06);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setPadding(n.f(getContext(), b.ds40), n.f(getContext(), b.tbds36), n.f(getContext(), b.ds40), n.f(getContext(), b.tbds36));
            setOrientation(1);
            TextView textView = new TextView(getContext());
            this.f51540g = textView;
            textView.setText(getContext().getString(g.interest_forum_tag_title));
            addView(this.f51540g, new LinearLayout.LayoutParams(-2, -2));
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, n.f(getContext(), b.tbds18), 0, 0);
            addView(relativeLayout, layoutParams);
            ImageView imageView = new ImageView(getContext());
            this.f51543j = imageView;
            imageView.setId(d.interest_forum_tag_arrow_id);
            int f2 = n.f(getContext(), b.tbds42);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f2, f2);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(15, -1);
            relativeLayout.addView(this.f51543j, layoutParams2);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f51541h = linearLayout;
            linearLayout.setGravity(16);
            this.f51541h.setMinimumHeight(n.f(getContext(), b.tbds68));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(15, -1);
            layoutParams3.addRule(0, d.interest_forum_tag_arrow_id);
            relativeLayout.addView(this.f51541h, layoutParams3);
            onChangeSkinType(this.f51539f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            TextView textView = this.f51540g;
            if (textView != null) {
                c d2 = c.d(textView);
                d2.v(c.a.t0.y2.a.CAM_X0109);
                d2.z(b.T_X06);
            }
            LinearLayout linearLayout = this.f51541h;
            if (linearLayout != null) {
                int childCount = linearLayout.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.f51541h.getChildAt(i3);
                    if (childAt instanceof q) {
                        ((q) childAt).onChangeSkinType(tbPageContext, i2);
                    }
                }
            }
            ImageView imageView = this.f51543j;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, c.a.t0.y2.c.icon_common_arrow16_right_n, c.a.t0.y2.a.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            }
            h();
        }
    }

    public void setDeleteForumListener(InterestForumTagView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void setMustFill(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (textView = this.f51540g) == null) {
            return;
        }
        if (z) {
            Drawable pureDrawable = WebPManager.getPureDrawable(c.a.t0.y2.c.icon_pure_mustfill, SkinManager.getColor(c.a.t0.y2.a.CAM_X0301), null);
            if (pureDrawable != null) {
                this.f51540g.setCompoundDrawablePadding(n.f(getContext(), b.M_W_X002));
                this.f51540g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                return;
            }
            return;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
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
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, tbPageContext, list, z) == null) || tbPageContext == null || (linearLayout = this.f51541h) == null) {
            return;
        }
        this.l = list;
        this.f51539f = tbPageContext;
        this.f51544k = z;
        linearLayout.removeAllViews();
        this.f51542i = null;
        if (ListUtils.isEmpty(list)) {
            f();
        } else {
            e();
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
        this.f51538e = ((((((n.k(getContext()) - n.f(getContext(), b.ds40)) - n.f(getContext(), b.ds40)) - n.f(getContext(), b.tbds42)) - n.f(getContext(), b.M_W_X008)) - (n.f(getContext(), b.M_W_X004) * 2)) * 1.0f) / 2.0f;
        i();
    }
}
