package com.baidu.tieba.personPolymeric.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.k0.a;
import d.a.o0.r.f0.t.b;
import java.util.List;
/* loaded from: classes4.dex */
public class BlueLikeButton extends TextView implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20236e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20237f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlueLikeButton(Context context) {
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
        this.f20236e = false;
        this.f20237f = false;
    }

    @Override // d.a.o0.r.f0.t.b
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20237f) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "4"));
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            StatisticItem statisticItem = new StatisticItem("c12507");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", 2);
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            TiebaStatic.log(statisticItem);
        }
        if (this.f20236e) {
            return;
        }
        Context context = getContext();
        if ((context instanceof Activity) && (context instanceof a)) {
            String stringExtra = ((Activity) context).getIntent().getStringExtra("thread_id");
            List<String> currentPageSourceKeyList = ((a) context).getCurrentPageSourceKeyList();
            if (currentPageSourceKeyList == null || !StringHelper.equals((String) ListUtils.getItem(currentPageSourceKeyList, currentPageSourceKeyList.size() - 1), "a002") || k.isEmpty(stringExtra)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12613").param("obj_type", 1).param("tid", stringExtra));
        }
    }

    @Override // d.a.o0.r.f0.t.b
    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    @Override // d.a.o0.r.f0.t.b
    public void c(boolean z, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            e(z, i2);
        }
    }

    @Override // d.a.o0.r.f0.t.b
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    @Override // d.a.o0.r.f0.t.b
    public void e(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            f(z);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f20236e = z;
            if (z) {
                if (this.f20237f) {
                    setText(R.string.followed);
                    TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(l.g(getContext(), R.dimen.tbds42)).defaultColor(R.color.CAM_X0204).into(this);
                    SkinManager.setViewTextColor(this, R.color.CAM_X0105, 1);
                    return;
                }
                setText(R.string.followed);
                setBackgroundDrawable(SkinManager.getDrawable(R.drawable.selector_like_button_gray_bg));
                setPadding(0, 0, 0, 0);
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this, R.color.CAM_X0110, 1);
            } else if (this.f20237f) {
                setText(R.string.attention);
                TBSelector.selectorBackgroundDrawable(DrawableSelector.make().setShape(0).setType(1).radius(l.g(getContext(), R.dimen.tbds42)).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0303, R.color.CAM_X0302).build(), DrawableSelector.make().setShape(0).setType(1).radius(l.g(getContext(), R.dimen.tbds42)).gradientLinear(DrawableSelector.TL_BR, R.color.cp_link_tip_b_alpha50, R.color.cp_link_tip_a_alpha50).build()).into(this);
                SkinManager.setViewTextColor(this, R.color.CAM_X0101, 1);
            } else {
                setText(R.string.attention);
                setBackgroundDrawable(SkinManager.getDrawable(R.drawable.selector_like_button_bg));
                setPadding(getResources().getDimensionPixelSize(R.dimen.tbds20), 0, 0, 0);
                setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this, R.color.CAM_X0111, 1);
            }
        }
    }

    public void setBJH(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20237f = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlueLikeButton(Context context, AttributeSet attributeSet) {
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
        this.f20236e = false;
        this.f20237f = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlueLikeButton(Context context, AttributeSet attributeSet, int i2) {
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
        this.f20236e = false;
        this.f20237f = false;
    }
}
