package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tieba.us7;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ss7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<us7.e> a;
    public final LayoutInflater b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public LinearLayout b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public RoundRelativeLayout h;
        public ImageView i;
        public LinearLayout j;

        public a(ss7 ss7Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss7Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d2a);
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906fd);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b2);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b4);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b1);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b3);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092488);
            this.h = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b2e);
            this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d80);
            this.h.setRoundLayoutRadius(new float[]{ss7Var.g, ss7Var.g, ss7Var.g, ss7Var.g, ss7Var.g, ss7Var.g, 0.0f, ss7Var.g});
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b2d);
        }
    }

    public ss7(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = LayoutInflater.from(tbPageContext.getPageActivity());
        this.c = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds294);
        this.d = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds416);
        this.e = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.M_H_X007);
        this.f = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.g = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds42);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public us7.e getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (us7.e) ListUtils.getItem(this.a, i);
        }
        return (us7.e) invokeI.objValue;
    }

    public void f(List<us7.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.a = list;
        }
    }

    public us7.e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ListUtils.isEmpty(this.a)) {
                return null;
            }
            for (us7.e eVar : this.a) {
                if (eVar != null && eVar.i) {
                    return eVar;
                }
            }
            return null;
        }
        return (us7.e) invokeV.objValue;
    }

    public final void d(int i, us7.e eVar, a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, eVar, aVar) == null) && eVar != null && eVar.f >= 0) {
            aVar.g.setText(h(eVar.b, 7));
            if (TextUtils.isEmpty(eVar.c)) {
                aVar.f.setVisibility(4);
            } else {
                aVar.f.setVisibility(0);
                aVar.f.setText(h(eVar.c, 10));
            }
            TextView textView = aVar.e;
            textView.setText("" + (eVar.f / 100));
            if (TextUtils.isEmpty(eVar.d)) {
                aVar.j.setVisibility(4);
                aVar.h.setVisibility(4);
                aVar.d.setVisibility(4);
            } else {
                aVar.h.setVisibility(0);
                aVar.d.setVisibility(0);
                aVar.j.setVisibility(0);
                aVar.d.setText(eVar.d);
            }
            if (i == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
                layoutParams.width = this.c;
                layoutParams.height = this.d;
                layoutParams.leftMargin = this.e;
                layoutParams.rightMargin = this.f;
                aVar.a.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
                layoutParams2.width = this.c;
                layoutParams2.height = this.d;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = this.f;
                aVar.a.setLayoutParams(layoutParams2);
            }
            SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(aVar.d, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(aVar.d, R.drawable.member_price_tag_bg_shape);
            rw4.d(aVar.d).A(R.string.F_X02);
            SkinManager.setViewTextColor(aVar.e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(aVar.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(aVar.g, (int) R.color.CAM_X0105);
            rw4.d(aVar.g).A(R.string.F_X01);
            e(aVar);
            g(eVar, aVar);
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds42)).setShadowColor(R.color.CAM_X0301).setShadowAlpha(200).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds16)).setOffsetX(0).setOffsetY(UtilHelper.getDimenPixelSize(R.dimen.tbds45)).into(aVar.j);
        }
    }

    public final void g(us7.e eVar, a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, eVar, aVar) == null) && eVar != null && aVar != null) {
            SkinManager.setViewTextColor(aVar.e, (int) R.color.CAM_X0301);
            SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0301);
            aVar.i.setVisibility(8);
            if (eVar.i) {
                SkinManager.setBackgroundResource(aVar.b, R.drawable.member_price_bg_shape_s);
                rw4 d = rw4.d(aVar.b);
                d.e(R.string.A_X09);
                d.n(R.string.J_X07);
                d.k(R.color.CAM_X0335);
                d.j(R.string.A_X05);
                d.l(R.dimen.L_X04);
                d.f(R.color.CAM_X0335);
                rw4 d2 = rw4.d(aVar.g);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0311);
                rw4 d3 = rw4.d(aVar.f);
                d3.v(R.color.CAM_X0311);
                d3.z(R.dimen.T_X09);
                d3.A(R.string.F_X02);
                if (aVar.f.getVisibility() == 0) {
                    aVar.i.setVisibility(0);
                    return;
                } else {
                    aVar.i.setVisibility(8);
                    return;
                }
            }
            SkinManager.setBackgroundResource(aVar.b, R.drawable.member_price_bg_shape_n);
            rw4 d4 = rw4.d(aVar.b);
            d4.m(0);
            d4.n(R.string.J_X07);
            d4.k(R.color.CAM_X0335);
            d4.l(R.dimen.L_X04);
            d4.j(R.string.A_X09);
            d4.f(R.color.CAM_X0201);
            rw4 d5 = rw4.d(aVar.f);
            d5.v(R.color.CAM_X0109);
            d5.z(R.dimen.T_X09);
            d5.A(R.string.F_X01);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d05a1, (ViewGroup) null);
                view2.setTag(new a(this, view2));
            }
            d(i, getItem(i), (a) view2.getTag());
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final String h(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (str.length() > i) {
                return str.substring(0, i - 1) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public void i(us7.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) && eVar != null && !ListUtils.isEmpty(this.a)) {
            for (us7.e eVar2 : this.a) {
                if (eVar2 != null) {
                    eVar2.i = eVar2.a.equals(eVar.a);
                }
            }
            notifyDataSetChanged();
        }
    }
}
