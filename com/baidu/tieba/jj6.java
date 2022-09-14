package com.baidu.tieba;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class jj6 extends qn<lj6, CardViewHolder<gj6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public gj6 b;
    public boolean c;
    public List<gj6> d;
    public Handler e;
    public fj6 f;
    public boolean g;
    public v16<lj6> h;

    /* loaded from: classes4.dex */
    public class a extends v16<lj6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jj6 b;

        public a(jj6 jj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jj6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, lj6 lj6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lj6Var) == null) || view2 == null || lj6Var == null) {
                return;
            }
            if ((view2.getId() == R.id.obfuscated_res_0x7f092513 || view2.getId() == R.id.obfuscated_res_0x7f092507 || view2.getId() == R.id.obfuscated_res_0x7f091545) && view2.getTag() != null && (view2.getTag() instanceof gj6)) {
                gj6 gj6Var = (gj6) view2.getTag();
                if (this.b.b != null && this.b.b != gj6Var && (view2.getId() == R.id.obfuscated_res_0x7f092513 || view2.getId() == R.id.obfuscated_res_0x7f091545)) {
                    this.b.b.P();
                }
                if (this.b.b != gj6Var) {
                    this.b.b = gj6Var;
                }
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f092216) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", lj6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090161) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", lj6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f092192 && view2.getId() != R.id.obfuscated_res_0x7f09057d) {
                if (view2.getId() != R.id.obfuscated_res_0x7f0924a4 && view2.getId() != R.id.obfuscated_res_0x7f0924b4) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0902d4) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", lj6Var.a);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091545) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", lj6Var.a);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem4);
                        return;
                    } else {
                        return;
                    }
                }
                StatisticItem statisticItem5 = new StatisticItem("c12412");
                statisticItem5.param("fid", lj6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", lj6Var.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jj6 a;

        public b(jj6 jj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jj6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c) {
                this.a.c = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jj6(TbPageContext<?> tbPageContext, fj6 fj6Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), lj6.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fj6Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.e = new Handler();
        this.h = new a(this);
        this.a = tbPageContext;
        this.f = fj6Var;
        this.g = z;
    }

    public boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            gj6 gj6Var = this.b;
            if (gj6Var == null) {
                return false;
            }
            return gj6Var.G(i);
        }
        return invokeI.booleanValue;
    }

    public void B() {
        gj6 gj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gj6Var = this.b) == null) {
            return;
        }
        gj6Var.H();
    }

    public void C() {
        gj6 gj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gj6Var = this.b) == null) {
            return;
        }
        gj6Var.P();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (gj6 gj6Var : this.d) {
                if (gj6Var != null) {
                    gj6Var.F();
                }
            }
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            gj6 gj6Var = this.b;
            if (gj6Var != null) {
                return gj6Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x(Configuration configuration) {
        gj6 gj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, configuration) == null) || (gj6Var = this.b) == null) {
            return;
        }
        this.c = true;
        gj6Var.E(configuration);
        if (configuration.orientation == 1) {
            this.e.postDelayed(new b(this), 500L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public CardViewHolder<gj6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            gj6 gj6Var = new gj6(this.a, this.g);
            gj6Var.n(this.h);
            this.d.add(gj6Var);
            return new CardViewHolder<>(gj6Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lj6 lj6Var, CardViewHolder<gj6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lj6Var, cardViewHolder})) == null) {
            if (lj6Var == null || cardViewHolder == null) {
                return null;
            }
            if (!this.c) {
                cardViewHolder.a().D(lj6Var, i, this.f);
                cardViewHolder.a().F = i;
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
