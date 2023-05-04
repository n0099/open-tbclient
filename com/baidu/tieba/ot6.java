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
/* loaded from: classes5.dex */
public class ot6 extends ol5<zx4, jr6> {
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mr6 a;
        public final /* synthetic */ ot6 b;

        public a(ot6 ot6Var, mr6 mr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var, mr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot6Var;
            this.a = mr6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13386");
                this.b.q.dispatchMvcEvent(new hl5(15, this.a, null, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx4 a;
        public final /* synthetic */ ot6 b;

        public b(ot6 ot6Var, zx4 zx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var, zx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot6Var;
            this.a = zx4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("info_forum_image_rect", this.b.m());
                bundle.putParcelable("info_forum_name_rect", this.b.n());
                hl5 hl5Var = new hl5(1, this.a, null, null);
                hl5Var.g(bundle);
                this.b.q.dispatchMvcEvent(hl5Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx4 a;
        public final /* synthetic */ ot6 b;

        public c(ot6 ot6Var, zx4 zx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var, zx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ot6Var;
            this.a = zx4Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.b.q.dispatchMvcEvent(new hl5(12, this.a, null, null));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ot6 c;

        public d(ot6 ot6Var, TextView textView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var, textView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ot6Var;
            this.a = textView;
            this.b = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.getParent() instanceof ViewGroup) && (l = ii.l(this.c.getContext())) != 0) {
                this.a.setMaxWidth(l - (this.b + ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                this.a.postInvalidate();
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ot6(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
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
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091e47);
        this.f = findViewById;
        this.g = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f0917b5);
        this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091503);
        this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091b72);
        this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092535);
        this.k = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090929);
        this.l = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09209d);
        this.m = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090e05);
        this.n = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09191c);
        this.r = this.f.findViewById(R.id.obfuscated_res_0x7f0909cd);
        this.s = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09255f);
        this.o = (BarImageView) this.f.findViewById(R.id.forum_avatar);
        this.t = this.f.findViewById(R.id.obfuscated_res_0x7f090bc4);
        this.p = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090b82);
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
    @Override // com.baidu.tieba.rl5
    /* renamed from: o */
    public void f(zx4 zx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zx4Var) == null) {
            super.f(zx4Var);
            if (zx4Var == null) {
                return;
            }
            r(zx4Var);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        }
    }

    @Override // com.baidu.tieba.mo9
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i)) == null) {
            tn5.a(tbPageContext, c());
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
    @Override // com.baidu.tieba.rl5
    /* renamed from: q */
    public void h(jr6 jr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jr6Var) == null) {
            super.h(jr6Var);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, SkinManager.getDrawable(R.color.CAM_X0204));
            stateListDrawable.addState(new int[0], SkinManager.getDrawable(R.color.CAM_X0205).mutate());
            this.f.setBackgroundDrawable(stateListDrawable);
            this.o.setPlaceHolder(1);
        }
    }

    public final void r(zx4 zx4Var) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zx4Var) != null) || zx4Var == null) {
            return;
        }
        jr6 jr6Var = (jr6) d();
        this.f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        int i4 = 0;
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        if (zx4Var instanceof mr6) {
            mr6 mr6Var = (mr6) zx4Var;
            this.g.setText(mr6Var.j());
            ImageView imageView = this.l;
            if (mr6Var.v() == 0) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
            if (mr6Var.h() == 0) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(mr6Var.h()));
            }
            this.o.setShowOval(true);
            this.o.N(mr6Var.e(), 10, false);
            this.o.setShowOuterBorder(false);
            this.o.setShowInnerBorder(true);
            this.o.setStrokeWith(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.o.setStrokeColorResId(R.color.CAM_X0401);
            if (mr6Var.g() > 0) {
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0302);
            } else {
                SkinManager.setBackgroundColor(this.t, R.color.transparent);
            }
            this.p.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0952), StringHelper.numberUniformFormatExtraWithRoundInt(mr6Var.n())));
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            if (YYLiveUtil.isLiveRoom(mr6Var.j())) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
            TextView textView = this.n;
            if (mr6Var.r() == 1 && mr6Var.t() == 1) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            if (mr6Var.o() == 1) {
                this.i.setVisibility(0);
                this.i.setText(R.string.obfuscated_res_0x7f0f034c);
                SkinManager.setBackgroundResource(this.i, R.drawable.enter_forum_brand_label_bg_shape);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0101);
                this.h.setVisibility(8);
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(gg.g(mr6Var.getId(), 0L)));
                if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                    this.h.setVisibility(0);
                    this.h.setText("");
                    SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f0806d0);
                    SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0111);
                } else {
                    this.h.setVisibility(8);
                }
                this.i.setVisibility(8);
            }
            if (mr6Var.x()) {
                this.j.setVisibility(0);
                i3 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
            } else {
                this.j.setVisibility(8);
                i3 = 0;
            }
            if (mr6Var.p()) {
                this.k.setVisibility(0);
                i3 += ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
            } else {
                this.k.setVisibility(8);
            }
            i4 = i3;
            this.k.setOnClickListener(new a(this, mr6Var));
        } else if (zx4Var instanceof pz4) {
            pz4 pz4Var = (pz4) zx4Var;
            this.g.setText(pz4Var.g());
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            if (YYLiveUtil.isLiveRoom(pz4Var.g())) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_CARD_ENTER_FORUM_SHOW);
                TiebaStaticHelper.addYYParam(statisticItem2);
                TiebaStatic.log(statisticItem2);
            }
        }
        SkinManager.setBackgroundResource(this.n, R.drawable.obfuscated_res_0x7f080932);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        this.s.setVisibility(8);
        this.f.setOnClickListener(new b(this, zx4Var));
        this.f.setOnLongClickListener(new c(this, zx4Var));
        p(this.g, i4);
    }
}
