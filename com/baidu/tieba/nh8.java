package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nh8 implements jh8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public static int C;
    public static int D;
    public static int E;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public FrameLayout a;
    public RelativeLayout b;
    public RelativeLayout c;
    public RelativeLayout d;
    public ImageView e;
    public RoundRelativeLayout f;
    public View g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public RecyclerView l;
    public TextView m;
    public LinearLayout n;
    public ImageView o;
    public TextView p;
    public LinearLayout q;
    public ImageView r;
    public TextView s;
    public RelativeLayout t;
    public RelativeLayout u;
    public RelativeLayout v;
    public TbImageAutoSwitch w;
    public HeadImageView x;
    public LinearLayout y;
    public ImageView z;

    @Override // com.baidu.tieba.jh8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.jh8
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public a(nh8 nh8Var, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nh8Var, str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.a);
                nh8.w(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948002571, "Lcom/baidu/tieba/nh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948002571, "Lcom/baidu/tieba/nh8;");
                return;
            }
        }
        B = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds650);
        C = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds42);
        D = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.L_X03);
        E = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds10);
    }

    public nh8() {
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

    @Override // com.baidu.tieba.jh8
    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return E;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jh8
    public HeadImageView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.x;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    @NonNull
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return D;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jh8
    @NonNull
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return C;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jh8
    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public LinearLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.u;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public RecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.l;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return B;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jh8
    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.A;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public RelativeLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.t;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public TbImageAutoSwitch s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.w;
        }
        return (TbImageAutoSwitch) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.y;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public static nh8 v(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            GreyUtil.grey(view2);
            nh8 nh8Var = new nh8();
            nh8Var.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917bf);
            nh8Var.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917c6);
            nh8Var.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917c1);
            nh8Var.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917bc);
            nh8Var.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917c8);
            nh8Var.f = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f92);
            nh8Var.g = view2.findViewById(R.id.obfuscated_res_0x7f0917cd);
            nh8Var.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917c2);
            nh8Var.t = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917da);
            nh8Var.u = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917db);
            nh8Var.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917c5);
            nh8Var.l = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0917c0);
            nh8Var.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917c3);
            nh8Var.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917be);
            nh8Var.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917dd);
            nh8Var.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917b9);
            nh8Var.o = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917bb);
            nh8Var.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917ba);
            nh8Var.q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917d1);
            nh8Var.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d3);
            nh8Var.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917d2);
            nh8Var.v = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917b4);
            nh8Var.w = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f0917b5);
            nh8Var.x = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917b6);
            nh8Var.y = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091237);
            nh8Var.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091238);
            nh8Var.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091239);
            return nh8Var;
        }
        return (nh8) invokeL.objValue;
    }

    public static void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, null, j) == null) {
            StatisticItem statisticItem = new StatisticItem("c15335");
            statisticItem.param("fid", j);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.jh8
    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.g.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.tieba.jh8
    public void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            this.y.setOnClickListener(new a(this, str, j));
        }
    }

    @Override // com.baidu.tieba.jh8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            EMManager.from(this.a).setCorner(R.string.deprecated_J_X18).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.i).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            EMManager.from(this.j).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            EMManager.from(this.m).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.p).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.s).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f080555, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080fb8, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            EMManager.from(this.A).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0341);
            EMManager.from(this.c).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.d).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.l).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.g).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.t).setBackGroundColor(R.color.transparent);
            EMManager.from(this.u).setBackGroundColor(R.color.transparent);
            this.f.setRoundLayoutRadius(w65.B(R.string.J_X19));
            if (i == 4) {
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fbc);
                SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f080fb7);
                return;
            }
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fbb);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f080fb6);
        }
    }
}
