package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public class sh8 implements gm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final lh8 a;
    @NonNull
    public final mh8 b;
    @NonNull
    public final th8 c;
    public boolean d;

    public sh8(@NonNull lh8 lh8Var, @NonNull mh8 mh8Var, @NonNull th8 th8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lh8Var, mh8Var, th8Var};
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
        this.a = lh8Var;
        this.b = mh8Var;
        this.c = th8Var;
    }

    @Override // com.baidu.tieba.gm4
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i > 0) {
                SpeedStatsManager.getInstance().setAdLoadResult(i);
            } else if (i == -1 && !this.d) {
                SpeedStatsManager.getInstance().setAdLoadResult(i);
            } else if (i < -1) {
                SpeedStatsManager.getInstance().setAdLoadResult(i);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_POLICY_SO_END);
        }
    }

    @Override // com.baidu.tieba.gm4
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c.k(true);
            this.a.getRootView().removeView(this.c.h());
            this.c.j();
            this.b.a();
            ya5.b().k(System.currentTimeMillis() - this.c.g());
            int l = tu4.k().l("ad_load_fail_count", 0);
            SpeedStatsManager.getInstance().setAdFailCount(l);
            tu4.k().w("ad_load_fail_count", l + 1);
        }
    }

    @Override // com.baidu.tieba.gm4
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a.c();
            SpeedStatsManager.getInstance().setPlgAdType(str);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_CALL_SHOW_START_STAMP_KEY);
            this.c.i();
        }
    }

    @Override // com.baidu.tieba.gm4
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_CALL_SHOW_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.gm4
    public void e(boolean z, boolean z2, int i, String str, String str2, String str3) {
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
            statisticItem.param("obj_type", z2 ? 2 : 1).param("obj_source", i);
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
                statisticItem3.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem3.param("obj_type", z2 ? 2 : 1);
            }
            kj8.g().c(this.a.getUniqueId(), statisticItem3);
        }
    }

    @Override // com.baidu.tieba.gm4
    public void f(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            if ("5".equals(str)) {
                this.d = true;
                SpeedStatsManager.getInstance().setPlgLoadResult(z);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_PROLOGUE_END_STAMP_KEY);
            } else if ("6".equals(str)) {
                SpeedStatsManager.getInstance().setBearLoadResult(z);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tieba.gm4
    public void g(boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            tu4.k().w("ad_load_fail_count", 0);
            this.c.k(true);
            SpeedStatsManager.getInstance().setAdSource(String.valueOf(i));
            this.a.b(i);
            this.c.j();
            if (z2) {
                this.a.getRootView().setBackgroundDrawable(null);
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).param("obj_type", z2 ? 2 : 1).param("obj_source", i));
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem.param("obj_type", z2 ? 2 : 1);
            }
            kj8.g().d(this.a.getUniqueId(), "bes_ad_id", statisticItem);
            kj8.g().h(this.a.getUniqueId(), false);
            if (this.a.h()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.a.getActivity()));
            }
            ya5.b().m(System.currentTimeMillis());
            ya5.b().k(System.currentTimeMillis() - this.c.g());
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921688, null));
        }
    }

    @Override // com.baidu.tieba.gm4
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
            this.a.e();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getActivity().getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, hashCode()).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.a.d())));
            if (!this.a.d() && !qb1.q()) {
                SpeedStatsManager.getInstance().setStatsFlag(-1);
                if (this.a.h()) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("ignore_speed").param("obj_source", "dismiss"));
                return;
            }
            this.b.a();
        }
    }
}
