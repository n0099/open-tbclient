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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes8.dex */
public class tz6 extends lo5<gx4, ox6> {
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

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rx6 a;
        public final /* synthetic */ tz6 b;

        public a(tz6 tz6Var, rx6 rx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz6Var, rx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tz6Var;
            this.a = rx6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13386");
                this.b.q.dispatchMvcEvent(new eo5(15, this.a, null, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx4 a;
        public final /* synthetic */ tz6 b;

        public b(tz6 tz6Var, gx4 gx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz6Var, gx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tz6Var;
            this.a = gx4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.b.o());
                bundle.putParcelable("info_forum_name_rect", this.b.p());
                eo5 eo5Var = new eo5(1, this.a, null, null);
                eo5Var.g(bundle);
                this.b.q.dispatchMvcEvent(eo5Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx4 a;
        public final /* synthetic */ tz6 b;

        public c(tz6 tz6Var, gx4 gx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz6Var, gx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tz6Var;
            this.a = gx4Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.b.q.dispatchMvcEvent(new eo5(12, this.a, null, null));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ tz6 c;

        public d(tz6 tz6Var, TextView textView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz6Var, textView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tz6Var;
            this.a = textView;
            this.b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int equipmentWidth;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (equipmentWidth = BdUtilHelper.getEquipmentWidth(this.c.b())) != 0) {
                this.a.setMaxWidth(equipmentWidth - (this.b + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tz6(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
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
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f092084);
        this.f = findViewById;
        this.g = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091993);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09166e);
        this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091d7e);
        this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0927b0);
        this.k = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0909c6);
        this.l = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0922e6);
        this.m = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090ee3);
        this.n = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091b2d);
        this.r = this.f.findViewById(R.id.obfuscated_res_0x7f090a7e);
        this.s = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0927cd);
        this.o = (BarImageView) this.f.findViewById(R.id.forum_avatar);
        this.t = this.f.findViewById(R.id.obfuscated_res_0x7f090c8e);
        this.p = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090c47);
        this.o.setPlaceHolder(1);
        this.o.setStrokeColorResId(R.color.CAM_X0201);
    }

    public final Rect o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Rect rect = new Rect();
            this.o.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public final Rect p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Rect rect = new Rect();
            this.g.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mva
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            jq5.a(tbPageContext, e());
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void r(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, textView, i) != null) || textView == null) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, textView, i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oo5
    /* renamed from: q */
    public void h(gx4 gx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gx4Var) == null) {
            super.h(gx4Var);
            if (gx4Var == null) {
                return;
            }
            t(gx4Var);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oo5
    /* renamed from: s */
    public void j(ox6 ox6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ox6Var) == null) {
            super.j(ox6Var);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
            stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
            this.f.setBackgroundDrawable(stateListDrawable);
            this.o.setPlaceHolder(1);
        }
    }

    public final void t(gx4 gx4Var) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gx4Var) != null) || gx4Var == null) {
            return;
        }
        ox6 ox6Var = (ox6) f();
        this.f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i4 = 0;
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        if (gx4Var instanceof rx6) {
            rx6 rx6Var = (rx6) gx4Var;
            this.g.setText(rx6Var.k());
            ImageView imageView = this.l;
            if (rx6Var.u() == 0) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
            if (rx6Var.h() == 0) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(rx6Var.h()));
            }
            this.o.setShowOval(true);
            this.o.startLoad(rx6Var.e(), 10, false);
            this.o.setShowOuterBorder(false);
            this.o.setShowInnerBorder(true);
            this.o.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.o.setStrokeColorResId(R.color.CAM_X0401);
            if (rx6Var.g() > 0) {
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.t, R.color.transparent);
            }
            this.p.setText(String.format(b().getString(R.string.obfuscated_res_0x7f0f0a44), StringHelper.numberUniformFormatExtraWithRoundInt(rx6Var.o())));
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(rx6Var.k())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            TextView textView = this.n;
            if (rx6Var.s() == 1 && rx6Var.t() == 1) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            if (rx6Var.p() == 1) {
                this.i.setVisibility(0);
                this.i.setText(R.string.obfuscated_res_0x7f0f0391);
                SkinManager.setBackgroundResource(this.i, R.drawable.enter_forum_brand_label_bg_shape);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
                this.h.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(JavaTypesHelper.toLong(rx6Var.getId(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.h.setVisibility(0);
                    this.h.setText("");
                    SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f080842);
                    SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0111);
                } else {
                    this.h.setVisibility(8);
                }
                this.i.setVisibility(8);
            }
            if (rx6Var.x()) {
                this.j.setVisibility(0);
                i3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.j.setVisibility(8);
                i3 = 0;
            }
            if (rx6Var.q()) {
                this.k.setVisibility(0);
                i3 += BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.k.setVisibility(8);
            }
            i4 = i3;
            this.k.setOnClickListener(new a(this, rx6Var));
        } else if (gx4Var instanceof wy4) {
            wy4 wy4Var = (wy4) gx4Var;
            this.g.setText(wy4Var.g());
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(wy4Var.g())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setBackgroundResource(this.n, R.drawable.obfuscated_res_0x7f080ac5);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        this.s.setVisibility(8);
        this.f.setOnClickListener(new b(this, gx4Var));
        this.f.setOnLongClickListener(new c(this, gx4Var));
        r(this.g, i4);
    }
}
