package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public ThreadData d;
    public int e;
    public tt9 f;
    public String g;
    public boolean h;
    public d79 i;

    public wt9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = 0L;
        this.e = 1;
        this.g = "1";
        this.i = new d79();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.b > 0) {
                this.a += System.currentTimeMillis() - this.b;
                this.b = 0L;
            }
            k();
            this.a = 0L;
            this.b = 0L;
            this.h = false;
            this.i.a();
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = this.c;
            float f = ((float) this.a) / ((float) j);
            if (j <= 60000) {
                if (f >= 0.9d) {
                    return true;
                }
                return false;
            } else if (j <= LiveFeedPageSdk.REFRESH_TIME) {
                if (f >= 0.8d) {
                    return true;
                }
                return false;
            } else if (j <= 600000) {
                if (f >= 0.7d) {
                    return true;
                }
                return false;
            } else if (f >= 0.6d) {
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public tt9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (tt9) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b > 0) {
            this.a += System.currentTimeMillis() - this.b;
            this.b = 0L;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.b > 0) {
                this.a += System.currentTimeMillis() - this.b;
                this.b = 0L;
            }
            this.h = false;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.i.e();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.b != 0) {
                this.a += System.currentTimeMillis() - this.b;
            }
            this.b = System.currentTimeMillis();
            this.h = true;
            this.i.b();
        }
    }

    public void f(et9 et9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, et9Var) == null) {
            this.i.d(et9Var);
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.c = j;
            this.i.c();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.g = str;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.e = i;
        }
    }

    public void n(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) {
            this.d = threadData;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.c = i;
        }
    }

    public void p(tt9 tt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tt9Var) == null) {
            this.f = tt9Var;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.a = i;
        }
    }

    public final void k() {
        StatisticItem statisticItem;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            long j = this.a;
            if (j >= 0 && j < 86400000) {
                if (j > 0) {
                    if (this.e == 2) {
                        statisticItem = new StatisticItem(TbadkCoreStatisticKey.VIDEO_LIVE_PAGE_STAY_TIME);
                    } else {
                        statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                    }
                    statisticItem.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
                    statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.a);
                    statisticItem.param("obj_type", this.g);
                    statisticItem.param("playduration", this.c);
                    statisticItem.param("player_type", 1);
                    statisticItem.param("is_finish", a() ? 1 : 0);
                    if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                    }
                    tt9 tt9Var = this.f;
                    if (tt9Var != null) {
                        tt9Var.a(statisticItem);
                    }
                    if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (threadData = this.d) != null) {
                        if (threadData.getBaijiahaoData() != null) {
                            if (this.d.getBaijiahaoData().oriUgcType == 2) {
                                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                            } else if (this.d.getBaijiahaoData().oriUgcType == 4) {
                                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                            }
                        } else {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                        }
                    }
                    ThreadData threadData2 = this.d;
                    if (threadData2 != null) {
                        statisticItem.param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0);
                    }
                    TiebaStatic.log(statisticItem);
                    it9.d(this.a, this.g, this.f, "", this.c);
                } else if (this.h) {
                    it9.d(j, this.g, this.f, "", this.c);
                }
            }
        }
    }
}
