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
/* loaded from: classes6.dex */
public class vm6 extends kn<xm6, CardViewHolder<sm6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public sm6 b;
    public boolean c;
    public List<sm6> d;
    public Handler e;
    public rm6 f;
    public boolean g;
    public h56<xm6> h;

    /* loaded from: classes6.dex */
    public class a extends h56<xm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm6 b;

        public a(vm6 vm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h56
        /* renamed from: d */
        public void a(View view2, xm6 xm6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xm6Var) == null) && view2 != null && xm6Var != null) {
                if ((view2.getId() == R.id.video_container || view2.getId() == R.id.obfuscated_res_0x7f0925cc || view2.getId() == R.id.obfuscated_res_0x7f0915df) && view2.getTag() != null && (view2.getTag() instanceof sm6)) {
                    sm6 sm6Var = (sm6) view2.getTag();
                    if (this.b.b != null && this.b.b != sm6Var && (view2.getId() == R.id.video_container || view2.getId() == R.id.obfuscated_res_0x7f0915df)) {
                        this.b.b.P();
                    }
                    if (this.b.b != sm6Var) {
                        this.b.b = sm6Var;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f0922d4) {
                    StatisticItem statisticItem = new StatisticItem("c12411");
                    statisticItem.param("fid", xm6Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090169) {
                    StatisticItem statisticItem2 = new StatisticItem("c12414");
                    statisticItem2.param("fid", xm6Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (view2.getId() != R.id.thread_info_commont_container && view2.getId() != R.id.card_root_view) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f092568 && view2.getId() != R.id.user_name) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f0902e3) {
                            StatisticItem statisticItem3 = new StatisticItem("c12413");
                            statisticItem3.param("fid", xm6Var.a);
                            if (TbadkCoreApplication.isLogin()) {
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0915df) {
                            StatisticItem statisticItem4 = new StatisticItem("c12416");
                            statisticItem4.param("fid", xm6Var.a);
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
                    statisticItem5.param("fid", xm6Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem5);
                } else {
                    StatisticItem statisticItem6 = new StatisticItem("c12415");
                    statisticItem6.param("fid", xm6Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem6);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vm6 a;

        public b(vm6 vm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vm6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.c) {
                return;
            }
            this.a.c = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vm6(TbPageContext<?> tbPageContext, rm6 rm6Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), xm6.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, rm6Var, Boolean.valueOf(z)};
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
        this.f = rm6Var;
        this.g = z;
    }

    public boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            sm6 sm6Var = this.b;
            if (sm6Var == null) {
                return false;
            }
            return sm6Var.G(i);
        }
        return invokeI.booleanValue;
    }

    public void x(Configuration configuration) {
        sm6 sm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, configuration) == null) && (sm6Var = this.b) != null) {
            this.c = true;
            sm6Var.E(configuration);
            if (configuration.orientation == 1) {
                this.e.postDelayed(new b(this), 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: y */
    public CardViewHolder<sm6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            sm6 sm6Var = new sm6(this.a, this.g);
            sm6Var.n(this.h);
            this.d.add(sm6Var);
            return new CardViewHolder<>(sm6Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public void B() {
        sm6 sm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (sm6Var = this.b) == null) {
            return;
        }
        sm6Var.H();
    }

    public void C() {
        sm6 sm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (sm6Var = this.b) == null) {
            return;
        }
        sm6Var.P();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (sm6 sm6Var : this.d) {
                if (sm6Var != null) {
                    sm6Var.F();
                }
            }
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            sm6 sm6Var = this.b;
            if (sm6Var != null) {
                return sm6Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xm6 xm6Var, CardViewHolder<sm6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xm6Var, cardViewHolder})) == null) {
            if (xm6Var != null && cardViewHolder != null) {
                if (!this.c) {
                    cardViewHolder.a().D(xm6Var, i, this.f);
                    cardViewHolder.a().F = i;
                }
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
