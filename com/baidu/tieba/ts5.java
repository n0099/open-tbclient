package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ts5 {
    public static /* synthetic */ Interceptable $ic;
    public static ts5 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<StatisticItem> a;

    public ts5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ts5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (ts5.class) {
                    if (b == null) {
                        b = new ts5();
                    }
                }
            }
            return b;
        }
        return (ts5) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        List<StatisticItem> list = this.a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || str == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        List<StatisticItem> list = this.a;
        if (list != null) {
            list.add(new StatisticItem(str));
        }
    }

    public final long d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData == null || threadData.getThreadAlaInfo() == null) {
                return -1L;
            }
            return threadData.getThreadAlaInfo().live_id;
        }
        return invokeL.longValue;
    }

    public StatisticItem e(int i, String str, int i2, String str2, ThreadData threadData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, threadData})) == null) {
            if (threadData == null) {
                return null;
            }
            String str3 = (threadData.getThreadAlaInfo() == null || StringUtils.isNull(threadData.getThreadAlaInfo().appId)) ? "" : threadData.getThreadAlaInfo().appId;
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_id", d(threadData));
            statisticItem.param("tid", threadData.getId());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str3);
            statisticItem.param("entryid", i2);
            statisticItem.param("name", str2);
            statisticItem.param("is_small_follow", i);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public void f(String str, int i, int i2, String str2, long j, String str3, AlaInfoData alaInfoData) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, Long.valueOf(j), str3, alaInfoData}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", i);
            statisticItem.param("obj_type", i2);
            statisticItem.param("tid", str2);
            if (j > 0) {
                statisticItem.param("fid", j);
            }
            if (!TextUtils.isEmpty(str3)) {
                statisticItem.param("fname", str3);
            }
            int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData);
            if (alaInfoData == null || !alaInfoData.isLegalYYLiveData()) {
                str4 = "";
            } else {
                TiebaStaticHelper.addYYParam(statisticItem, alaInfoData.mYyExtData);
                str4 = TiebaStatic.YYValues.YY_LIVE;
            }
            statisticItem.param("obj_param1", calculateLiveType);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str4);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null) {
                if (!statisticItem.getParams().contains(TiebaStatic.Params.OBJ_PARAM2)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }
}
