package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yl8 implements op4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final rl8 a;
    @NonNull
    public final sl8 b;
    @NonNull
    public final zl8 c;
    public boolean d;

    public yl8(@NonNull rl8 rl8Var, @NonNull sl8 sl8Var, @NonNull zl8 zl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rl8Var, sl8Var, zl8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.a = rl8Var;
        this.b = sl8Var;
        this.c = zl8Var;
    }

    @Override // com.baidu.tieba.op4
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i > 0) {
                SpeedStatsManager.getInstance().setAdLoadResult(i);
            } else if (i == -1 && !this.d) {
                SpeedStatsManager.getInstance().setAdLoadResult(i);
                BaseVM.m(30);
            } else if (i < -1) {
                SpeedStatsManager.getInstance().setAdLoadResult(i);
                BaseVM.m(30);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_POLICY_SO_END);
        }
    }

    @Override // com.baidu.tieba.op4
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c.k(true);
            this.a.getRootView().removeView(this.c.h());
            this.c.j();
            this.b.a();
            bf5.b().k(System.currentTimeMillis() - this.c.g());
            int l = py4.k().l("ad_load_fail_count", 0);
            SpeedStatsManager.getInstance().setAdFailCount(l);
            py4.k().w("ad_load_fail_count", l + 1);
            BaseVM.m(99);
        }
    }

    @Override // com.baidu.tieba.op4
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a.c();
            SpeedStatsManager.getInstance().setPlgAdType(str);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_CALL_SHOW_START_STAMP_KEY);
            this.c.i();
        }
    }

    @Override // com.baidu.tieba.op4
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_CALL_SHOW_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.op4
    public void e(boolean z, boolean z2, int i, String str, String str2, String str3) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), str, str2, str3}) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            SpeedStatsManager.getInstance().setStatsFlag(-1);
            if (!this.a.h()) {
                TiebaStatic.log(new StatisticItem("ignore_speed").param("obj_source", "click2"));
            }
            this.a.e();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK);
            this.a.getActivity().overridePendingTransition(0, 0);
            int i4 = 2;
            if (z2) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            statisticItem.param("obj_type", i2).param("obj_source", i);
            if (str2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str2);
            }
            if (str3 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str3);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
            statisticItem2.param("obj_source", i).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.SPLASH_UNI, this.a.i());
            if (!StringUtils.isNull(str)) {
                statisticItem2.param("nid", str);
            }
            if (!StringUtils.isNull(str2)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_TO, str2);
            }
            if (!StringUtils.isNull(str3)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str3);
            }
            TiebaStatic.log(statisticItem2);
            StatisticItem statisticItem3 = new StatisticItem("common_click");
            statisticItem3.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                if (z2) {
                    i3 = 4;
                } else {
                    i3 = 3;
                }
                statisticItem3.param("obj_type", i3);
            } else {
                if (!z2) {
                    i4 = 1;
                }
                statisticItem3.param("obj_type", i4);
            }
            nn8.g().c(this.a.getUniqueId(), statisticItem3);
        }
    }

    @Override // com.baidu.tieba.op4
    public void f(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            if ("5".equals(str)) {
                this.d = true;
                SpeedStatsManager.getInstance().setPlgLoadResult(z);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_PROLOGUE_END_STAMP_KEY);
                if (!z) {
                    BaseVM.m(99);
                }
            } else if ("6".equals(str)) {
                SpeedStatsManager.getInstance().setBearLoadResult(z);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tieba.op4
    public void g(boolean z, boolean z2, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            py4.k().w("ad_load_fail_count", 0);
            int i4 = 1;
            this.c.k(true);
            SpeedStatsManager.getInstance().setAdSource(String.valueOf(i));
            this.a.b(i);
            this.c.j();
            if (z2) {
                this.a.getRootView().setBackgroundDrawable(null);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW);
            if (z2) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2).param("obj_source", i));
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                if (z2) {
                    i3 = 4;
                } else {
                    i3 = 3;
                }
                statisticItem2.param("obj_type", i3);
            } else {
                if (z2) {
                    i4 = 2;
                }
                statisticItem2.param("obj_type", i4);
            }
            nn8.g().d(this.a.getUniqueId(), "bes_ad_id", statisticItem2);
            nn8.g().h(this.a.getUniqueId(), false);
            if (this.a.h()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.a.getActivity()));
            }
            bf5.b().m(System.currentTimeMillis());
            bf5.b().k(System.currentTimeMillis() - this.c.g());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921688, null));
        }
    }

    @Override // com.baidu.tieba.op4
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            this.a.e();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, hashCode()).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.a.d())));
            if (!this.a.d() && !ue1.r()) {
                SpeedStatsManager.getInstance().setStatsFlag(-1);
                if (!this.a.h()) {
                    TiebaStatic.log(new StatisticItem("ignore_speed").param("obj_source", "dismiss"));
                    return;
                }
                return;
            }
            this.b.a();
        }
    }
}
