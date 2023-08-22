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
/* loaded from: classes7.dex */
public class rj7 extends om<tj7, CardViewHolder<oj7>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public oj7 b;
    public boolean c;
    public List<oj7> d;
    public Handler e;
    public nj7 f;
    public boolean g;
    public jo6<tj7> h;

    /* loaded from: classes7.dex */
    public class a extends jo6<tj7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj7 b;

        public a(rj7 rj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rj7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, tj7 tj7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tj7Var) == null) && view2 != null && tj7Var != null) {
                if ((view2.getId() == R.id.video_container || view2.getId() == R.id.obfuscated_res_0x7f0928c8 || view2.getId() == R.id.obfuscated_res_0x7f091789) && view2.getTag() != null && (view2.getTag() instanceof oj7)) {
                    oj7 oj7Var = (oj7) view2.getTag();
                    if (this.b.b != null && this.b.b != oj7Var && (view2.getId() == R.id.video_container || view2.getId() == R.id.obfuscated_res_0x7f091789)) {
                        this.b.b.Q();
                    }
                    if (this.b.b != oj7Var) {
                        this.b.b = oj7Var;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09258f) {
                    StatisticItem statisticItem = new StatisticItem("c12411");
                    statisticItem.param("fid", tj7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090172) {
                    StatisticItem statisticItem2 = new StatisticItem("c12414");
                    statisticItem2.param("fid", tj7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (view2.getId() != R.id.thread_info_commont_container && view2.getId() != R.id.card_root_view) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f09284e && view2.getId() != R.id.user_name) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f0902e6) {
                            StatisticItem statisticItem3 = new StatisticItem("c12413");
                            statisticItem3.param("fid", tj7Var.a);
                            if (TbadkCoreApplication.isLogin()) {
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091789) {
                            StatisticItem statisticItem4 = new StatisticItem("c12416");
                            statisticItem4.param("fid", tj7Var.a);
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
                    statisticItem5.param("fid", tj7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem5);
                } else {
                    StatisticItem statisticItem6 = new StatisticItem("c12415");
                    statisticItem6.param("fid", tj7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem6);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rj7 a;

        public b(rj7 rj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rj7Var;
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
    public rj7(TbPageContext<?> tbPageContext, nj7 nj7Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), tj7.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, nj7Var, Boolean.valueOf(z)};
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
        this.f = nj7Var;
        this.g = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: A */
    public CardViewHolder<oj7> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            oj7 oj7Var = new oj7(this.a, this.g);
            oj7Var.k(this.h);
            this.d.add(oj7Var);
            return new CardViewHolder<>(oj7Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public boolean C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            oj7 oj7Var = this.b;
            if (oj7Var == null) {
                return false;
            }
            return oj7Var.I(i);
        }
        return invokeI.booleanValue;
    }

    public void z(Configuration configuration) {
        oj7 oj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (oj7Var = this.b) != null) {
            this.c = true;
            oj7Var.G(configuration);
            if (configuration.orientation == 1) {
                this.e.postDelayed(new b(this), 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tj7 tj7Var, CardViewHolder<oj7> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tj7Var, cardViewHolder})) == null) {
            if (tj7Var != null && cardViewHolder != null) {
                if (!this.c) {
                    cardViewHolder.b().F(tj7Var, i, this.f);
                    cardViewHolder.b().F = i;
                }
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void D() {
        oj7 oj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (oj7Var = this.b) == null) {
            return;
        }
        oj7Var.J();
    }

    public void E() {
        oj7 oj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (oj7Var = this.b) == null) {
            return;
        }
        oj7Var.Q();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (oj7 oj7Var : this.d) {
                if (oj7Var != null) {
                    oj7Var.H();
                }
            }
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            oj7 oj7Var = this.b;
            if (oj7Var != null) {
                return oj7Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
