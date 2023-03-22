package com.baidu.tieba;

import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class uo6 extends oj5<gx4, nm6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public ImageView m;
    public TextView n;
    public BarImageView o;
    public TextView p;
    public ViewEventCenter q;
    public View r;
    public TextView s;
    public View t;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm6 a;
        public final /* synthetic */ uo6 b;

        public a(uo6 uo6Var, qm6 qm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo6Var, qm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uo6Var;
            this.a = qm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13386");
                this.b.q.dispatchMvcEvent(new hj5(15, this.a, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx4 a;
        public final /* synthetic */ uo6 b;

        public b(uo6 uo6Var, gx4 gx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo6Var, gx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uo6Var;
            this.a = gx4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.b.m());
                bundle.putParcelable("info_forum_name_rect", this.b.n());
                hj5 hj5Var = new hj5(1, this.a, null, null);
                hj5Var.g(bundle);
                this.b.q.dispatchMvcEvent(hj5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx4 a;
        public final /* synthetic */ uo6 b;

        public c(uo6 uo6Var, gx4 gx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo6Var, gx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uo6Var;
            this.a = gx4Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.b.q.dispatchMvcEvent(new hj5(12, this.a, null, null));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ uo6 c;

        public d(uo6 uo6Var, TextView textView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo6Var, textView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uo6Var;
            this.a = textView;
            this.b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (l = hi.l(this.c.getContext())) != 0) {
                this.a.setMaxWidth(l - (this.b + hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uo6(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = viewEventCenter;
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091e46);
        this.f = findViewById;
        this.g = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0917a3);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0914f2);
        this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091b74);
        this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092526);
        this.k = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090924);
        this.l = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09209c);
        this.m = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090dfc);
        this.n = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09190d);
        this.r = this.f.findViewById(R.id.obfuscated_res_0x7f0909c8);
        this.s = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092550);
        this.o = (BarImageView) this.f.findViewById(R.id.forum_avatar);
        this.t = this.f.findViewById(R.id.obfuscated_res_0x7f090bbc);
        this.p = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090b7b);
        this.o.setPlaceHolder(1);
        this.o.setStrokeColorResId(R.color.CAM_X0201);
    }

    public final Rect m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Rect rect = new Rect();
            this.o.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final Rect n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Rect rect = new Rect();
            this.g.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rj5
    /* renamed from: o */
    public void f(gx4 gx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gx4Var) == null) {
            super.f(gx4Var);
            if (gx4Var == null) {
                return;
            }
            r(gx4Var);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        }
    }

    @Override // com.baidu.tieba.ya9
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i)) == null) {
            tl5.a(tbPageContext, c());
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void p(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, textView, i) != null) || textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, textView, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rj5
    /* renamed from: q */
    public void h(nm6 nm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nm6Var) == null) {
            super.h(nm6Var);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
            stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
            this.f.setBackgroundDrawable(stateListDrawable);
            this.o.setPlaceHolder(1);
        }
    }

    public final void r(gx4 gx4Var) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gx4Var) != null) || gx4Var == null) {
            return;
        }
        nm6 nm6Var = (nm6) d();
        this.f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i4 = 0;
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        if (gx4Var instanceof qm6) {
            qm6 qm6Var = (qm6) gx4Var;
            this.g.setText(qm6Var.m());
            ImageView imageView = this.l;
            if (qm6Var.w() == 0) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
            if (qm6Var.k() == 0) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(qm6Var.k()));
            }
            this.o.setShowOval(true);
            this.o.M(qm6Var.g(), 10, false);
            this.o.setShowOuterBorder(false);
            this.o.setShowInnerBorder(true);
            this.o.setStrokeWith(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.o.setStrokeColorResId(R.color.CAM_X0401);
            if (qm6Var.i() > 0) {
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.t, R.color.transparent);
            }
            this.p.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0941), StringHelper.numberUniformFormatExtraWithRoundInt(qm6Var.r())));
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(qm6Var.m())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            TextView textView = this.n;
            if (qm6Var.u() == 1 && qm6Var.v() == 1) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            if (qm6Var.s() == 1) {
                this.i.setVisibility(0);
                this.i.setText(R.string.obfuscated_res_0x7f0f034f);
                SkinManager.setBackgroundResource(this.i, R.drawable.enter_forum_brand_label_bg_shape);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
                this.h.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(gg.g(qm6Var.getId(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.h.setVisibility(0);
                    this.h.setText("");
                    SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f0806d3);
                    SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0111);
                } else {
                    this.h.setVisibility(8);
                }
                this.i.setVisibility(8);
            }
            if (qm6Var.y()) {
                this.j.setVisibility(0);
                i3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.j.setVisibility(8);
                i3 = 0;
            }
            if (qm6Var.t()) {
                this.k.setVisibility(0);
                i3 += hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.k.setVisibility(8);
            }
            i4 = i3;
            this.k.setOnClickListener(new a(this, qm6Var));
        } else if (gx4Var instanceof wy4) {
            wy4 wy4Var = (wy4) gx4Var;
            this.g.setText(wy4Var.i());
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(wy4Var.i())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setBackgroundResource(this.n, R.drawable.obfuscated_res_0x7f080914);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        this.s.setVisibility(8);
        this.f.setOnClickListener(new b(this, gx4Var));
        this.f.setOnLongClickListener(new c(this, gx4Var));
        p(this.g, i4);
    }
}
