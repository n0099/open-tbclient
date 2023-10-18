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
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
/* loaded from: classes9.dex */
public class yl8 implements ul8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int D;
    public static int E;
    public static int F;
    public static int G;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public ImageView B;
    public TextView C;
    public FrameLayout a;
    public RelativeLayout b;
    public RelativeLayout c;
    public RelativeLayout d;
    public TbImage e;
    public View f;
    public View g;
    public RoundRelativeLayout h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public RecyclerView n;
    public TextView o;
    public LinearLayout p;
    public ImageView q;
    public TextView r;
    public LinearLayout s;
    public ImageView t;
    public TextView u;
    public RelativeLayout v;
    public RelativeLayout w;
    public RelativeLayout x;
    public TbImageAutoSwitch y;
    public HeadImageView z;

    @Override // com.baidu.tieba.ul8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.ul8
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public a(yl8 yl8Var, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yl8Var, str, Long.valueOf(j)};
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
                yl8.y(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948334116, "Lcom/baidu/tieba/yl8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948334116, "Lcom/baidu/tieba/yl8;");
                return;
            }
        }
        D = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds650);
        E = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds42);
        F = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.L_X03);
        G = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds10);
    }

    public yl8() {
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

    @Override // com.baidu.tieba.ul8
    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return G;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ul8
    public HeadImageView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.z;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    @NonNull
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return F;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ul8
    @NonNull
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return E;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ul8
    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.s;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public LinearLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.p;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.w;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public RecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.n;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return D;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ul8
    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.C;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public RelativeLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.v;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public TbImageAutoSwitch s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.y;
        }
        return (TbImageAutoSwitch) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul8
    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.A;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @NonNull
    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    @NonNull
    public TbImage x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.e;
        }
        return (TbImage) invokeV.objValue;
    }

    public static yl8 v(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            GreyUtil.grey(view2);
            yl8 yl8Var = new yl8();
            yl8Var.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f2);
            yl8Var.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f9);
            yl8Var.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f4);
            yl8Var.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917ef);
            yl8Var.h = (RoundRelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091fcc);
            yl8Var.g = view2.findViewById(R.id.obfuscated_res_0x7f0917fc);
            yl8Var.e = (TbImage) view2.findViewById(R.id.obfuscated_res_0x7f0917fb);
            yl8Var.f = view2.findViewById(R.id.obfuscated_res_0x7f0917fd);
            yl8Var.i = view2.findViewById(R.id.obfuscated_res_0x7f091802);
            yl8Var.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917f5);
            yl8Var.v = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09180f);
            yl8Var.w = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091810);
            yl8Var.m = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917f8);
            yl8Var.n = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0917f3);
            yl8Var.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917f6);
            yl8Var.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f1);
            yl8Var.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091812);
            yl8Var.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917ec);
            yl8Var.q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917ee);
            yl8Var.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917ed);
            yl8Var.s = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091806);
            yl8Var.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091808);
            yl8Var.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091807);
            yl8Var.x = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917e7);
            yl8Var.y = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f0917e8);
            yl8Var.z = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917e9);
            yl8Var.A = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09125a);
            yl8Var.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09125b);
            yl8Var.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09125c);
            return yl8Var;
        }
        return (yl8) invokeL.objValue;
    }

    public static void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, null, j) == null) {
            StatisticItem statisticItem = new StatisticItem("c15335");
            statisticItem.param("fid", j);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.ul8
    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.i.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.tieba.ul8
    public void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            this.A.setOnClickListener(new a(this, str, j));
        }
    }

    @Override // com.baidu.tieba.ul8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            EMManager.from(this.a).setCorner(R.string.deprecated_J_X18).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            EMManager.from(this.l).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            EMManager.from(this.o).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.r).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.u).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f080563, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.t, R.drawable.obfuscated_res_0x7f080fdf, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            EMManager.from(this.C).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0341);
            EMManager.from(this.c).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.d).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.n).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.i).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.v).setBackGroundColor(R.color.transparent);
            EMManager.from(this.w).setBackGroundColor(R.color.transparent);
            this.h.setRoundLayoutRadius(x15.B(R.string.J_X19));
            SkinManager.setBackgroundResource(this.f, R.drawable.msg_tab_header_gradient_mask);
            this.e.setScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            if (i == 4) {
                SkinManager.setBackgroundResource(this.m, R.drawable.obfuscated_res_0x7f080fde);
            } else {
                SkinManager.setBackgroundResource(this.m, R.drawable.obfuscated_res_0x7f080fdd);
            }
        }
    }
}
