package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class me8 implements ue8 {
    public static /* synthetic */ Interceptable $ic;
    public static int A;
    public static int B;
    public static final int y;
    public static int z;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public RelativeLayout b;
    public RelativeLayout c;
    public View d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public RecyclerView i;
    public View j;
    public View k;
    public View l;
    public TextView m;
    public LinearLayout n;
    public ImageView o;
    public EMTextView p;
    public LinearLayout q;
    public ImageView r;
    public EMTextView s;
    public RelativeLayout t;
    public RelativeLayout u;
    public RelativeLayout v;
    public TbImageAutoSwitch w;
    public HeadImageView x;

    @Override // com.baidu.tieba.ue8
    public void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
        }
    }

    @Override // com.baidu.tieba.ue8
    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969897, "Lcom/baidu/tieba/me8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969897, "Lcom/baidu/tieba/me8;");
                return;
            }
        }
        y = xi.g(TbadkApplication.getInst(), R.dimen.tbds600);
        z = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds56);
        A = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        B = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
    }

    public me8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ue8
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return B;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ue8
    public HeadImageView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.x;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    @NonNull
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return A;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ue8
    @NonNull
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return z;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ue8
    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public LinearLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.u;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    @Nullable
    public RecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return y;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ue8
    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public RelativeLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.t;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public TbImageAutoSwitch s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.w;
        }
        return (TbImageAutoSwitch) invokeV.objValue;
    }

    public static me8 v(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            GreyUtil.grey(view2);
            me8 me8Var = new me8();
            me8Var.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e72);
            me8Var.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e92);
            me8Var.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e76);
            me8Var.d = view2.findViewById(R.id.obfuscated_res_0x7f090ecc);
            me8Var.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e78);
            me8Var.t = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091927);
            me8Var.u = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091930);
            me8Var.j = view2.findViewById(R.id.obfuscated_res_0x7f090e93);
            me8Var.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e8f);
            me8Var.k = view2.findViewById(R.id.obfuscated_res_0x7f09116b);
            me8Var.l = view2.findViewById(R.id.obfuscated_res_0x7f09150f);
            me8Var.i = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090e75);
            me8Var.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e81);
            me8Var.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e6b);
            me8Var.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bc8);
            me8Var.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090804);
            me8Var.o = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090806);
            me8Var.p = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090805);
            me8Var.q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091692);
            me8Var.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091694);
            me8Var.s = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091693);
            me8Var.v = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09077b);
            me8Var.w = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f09077c);
            me8Var.x = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090780);
            return me8Var;
        }
        return (me8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ue8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            s75.d(this.a).o(R.string.deprecated_J_X18);
            s75 d = s75.d(this.j);
            d.n(0);
            d.o(R.string.J_X03);
            d.f(R.color.CAM_X0618);
            s75 d2 = s75.d(this.k);
            d2.o(R.string.deprecated_J_X18);
            d2.f(R.color.CAM_X0201);
            s75 d3 = s75.d(this.f);
            d3.x(R.color.CAM_X0101);
            d3.C(R.dimen.T_X04);
            d3.D(R.string.F_X02);
            s75 d4 = s75.d(this.g);
            d4.x(R.color.CAM_X0102);
            d4.C(R.dimen.T_X12);
            d4.D(R.string.F_X01);
            s75.d(this.b).o(R.string.deprecated_J_X18);
            SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f08070d);
            s75.d(this.c).o(R.string.deprecated_J_X18);
            s75 d5 = s75.d(this.m);
            d5.C(R.dimen.T_X07);
            d5.D(R.string.F_X02);
            d5.x(R.color.CAM_X0105);
            s75 d6 = s75.d(this.p);
            d6.C(R.dimen.T_X12);
            d6.D(R.string.F_X01);
            d6.x(R.color.CAM_X0105);
            s75 d7 = s75.d(this.s);
            d7.C(R.dimen.T_X12);
            d7.D(R.string.F_X01);
            d7.x(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f080554, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080f58, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.ue8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.l.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.tieba.ue8
    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.k.getLayoutParams().height = i;
        }
    }
}
