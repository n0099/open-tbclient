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
public class om8 implements km8 {
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

    @Override // com.baidu.tieba.km8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.km8
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

        public a(om8 om8Var, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om8Var, str, Long.valueOf(j)};
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
                om8.w(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948037167, "Lcom/baidu/tieba/om8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948037167, "Lcom/baidu/tieba/om8;");
                return;
            }
        }
        B = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds650);
        C = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds42);
        D = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.L_X03);
        E = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds10);
    }

    public om8() {
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

    @Override // com.baidu.tieba.km8
    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return E;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.km8
    public HeadImageView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.x;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    @NonNull
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return D;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.km8
    @NonNull
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return C;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.km8
    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public LinearLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.u;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public RecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.l;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return B;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.km8
    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.A;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public RelativeLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.t;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public TbImageAutoSwitch s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.w;
        }
        return (TbImageAutoSwitch) invokeV.objValue;
    }

    @Override // com.baidu.tieba.km8
    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.y;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public static om8 v(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            GreyUtil.grey(view2);
            om8 om8Var = new om8();
            om8Var.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917ea);
            om8Var.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f1);
            om8Var.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917ec);
            om8Var.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917e7);
            om8Var.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917f3);
            om8Var.f = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ff7);
            om8Var.g = view2.findViewById(R.id.obfuscated_res_0x7f0917f8);
            om8Var.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917ed);
            om8Var.t = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091805);
            om8Var.u = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091806);
            om8Var.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917f0);
            om8Var.l = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0917eb);
            om8Var.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917ee);
            om8Var.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917e9);
            om8Var.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091808);
            om8Var.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917e4);
            om8Var.o = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917e6);
            om8Var.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917e5);
            om8Var.q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917fc);
            om8Var.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917fe);
            om8Var.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917fd);
            om8Var.v = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917df);
            om8Var.w = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f0917e0);
            om8Var.x = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917e1);
            om8Var.y = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091253);
            om8Var.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091254);
            om8Var.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091255);
            return om8Var;
        }
        return (om8) invokeL.objValue;
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

    @Override // com.baidu.tieba.km8
    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.g.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.tieba.km8
    public void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            this.y.setOnClickListener(new a(this, str, j));
        }
    }

    @Override // com.baidu.tieba.km8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            EMManager.from(this.a).setCorner(R.string.deprecated_J_X18).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.i).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            EMManager.from(this.j).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            EMManager.from(this.m).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.p).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.s).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f080563, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080fe5, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            EMManager.from(this.A).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0341);
            EMManager.from(this.c).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.d).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.l).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.g).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.t).setBackGroundColor(R.color.transparent);
            EMManager.from(this.u).setBackGroundColor(R.color.transparent);
            this.f.setRoundLayoutRadius(l75.B(R.string.J_X19));
            if (i == 4) {
                this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080fec);
                SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f080fe4);
                return;
            }
            this.e.setBackgroundResource(R.drawable.obfuscated_res_0x7f080feb);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f080fe3);
        }
    }
}
