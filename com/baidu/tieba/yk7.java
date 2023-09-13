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
/* loaded from: classes8.dex */
public class yk7 extends pm<al7, CardViewHolder<vk7>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public vk7 b;
    public boolean c;
    public List<vk7> d;
    public Handler e;
    public uk7 f;
    public boolean g;
    public mp6<al7> h;

    /* loaded from: classes8.dex */
    public class a extends mp6<al7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk7 b;

        public a(yk7 yk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yk7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, al7 al7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, al7Var) == null) && view2 != null && al7Var != null) {
                if ((view2.getId() == R.id.video_container || view2.getId() == R.id.obfuscated_res_0x7f0928fb || view2.getId() == R.id.obfuscated_res_0x7f091792) && view2.getTag() != null && (view2.getTag() instanceof vk7)) {
                    vk7 vk7Var = (vk7) view2.getTag();
                    if (this.b.b != null && this.b.b != vk7Var && (view2.getId() == R.id.video_container || view2.getId() == R.id.obfuscated_res_0x7f091792)) {
                        this.b.b.Q();
                    }
                    if (this.b.b != vk7Var) {
                        this.b.b = vk7Var;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f0925d1) {
                    StatisticItem statisticItem = new StatisticItem("c12411");
                    statisticItem.param("fid", al7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09016e) {
                    StatisticItem statisticItem2 = new StatisticItem("c12414");
                    statisticItem2.param("fid", al7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (view2.getId() != R.id.thread_info_commont_container && view2.getId() != R.id.card_root_view) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f092881 && view2.getId() != R.id.user_name) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f0902ea) {
                            StatisticItem statisticItem3 = new StatisticItem("c12413");
                            statisticItem3.param("fid", al7Var.a);
                            if (TbadkCoreApplication.isLogin()) {
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091792) {
                            StatisticItem statisticItem4 = new StatisticItem("c12416");
                            statisticItem4.param("fid", al7Var.a);
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
                    statisticItem5.param("fid", al7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem5);
                } else {
                    StatisticItem statisticItem6 = new StatisticItem("c12415");
                    statisticItem6.param("fid", al7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem6);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk7 a;

        public b(yk7 yk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yk7Var;
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
    public yk7(TbPageContext<?> tbPageContext, uk7 uk7Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), al7.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, uk7Var, Boolean.valueOf(z)};
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
        this.f = uk7Var;
        this.g = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: A */
    public CardViewHolder<vk7> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            vk7 vk7Var = new vk7(this.a, this.g);
            vk7Var.k(this.h);
            this.d.add(vk7Var);
            return new CardViewHolder<>(vk7Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public boolean C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            vk7 vk7Var = this.b;
            if (vk7Var == null) {
                return false;
            }
            return vk7Var.I(i);
        }
        return invokeI.booleanValue;
    }

    public void z(Configuration configuration) {
        vk7 vk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (vk7Var = this.b) != null) {
            this.c = true;
            vk7Var.G(configuration);
            if (configuration.orientation == 1) {
                this.e.postDelayed(new b(this), 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, al7 al7Var, CardViewHolder<vk7> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, al7Var, cardViewHolder})) == null) {
            if (al7Var != null && cardViewHolder != null) {
                if (!this.c) {
                    cardViewHolder.a().F(al7Var, i, this.f);
                    cardViewHolder.a().F = i;
                }
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void D() {
        vk7 vk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (vk7Var = this.b) == null) {
            return;
        }
        vk7Var.J();
    }

    public void E() {
        vk7 vk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (vk7Var = this.b) == null) {
            return;
        }
        vk7Var.Q();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (vk7 vk7Var : this.d) {
                if (vk7Var != null) {
                    vk7Var.H();
                }
            }
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            vk7 vk7Var = this.b;
            if (vk7Var != null) {
                return vk7Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
