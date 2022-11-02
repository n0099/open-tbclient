package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class s36 {
    public static /* synthetic */ Interceptable $ic;
    public static s36 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<StatisticItem> a;

    public s36() {
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

    public static s36 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (s36.class) {
                    if (b == null) {
                        b = new s36();
                    }
                }
            }
            return b;
        }
        return (s36) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, statisticItem) != null) || statisticItem == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(statisticItem);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        int i = -1;
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null && i != statisticItem.getPosition()) {
                i = statisticItem.getPosition();
                statisticItem.delete(TiebaStatic.Params.OBJ_PARAM2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z) != null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null) {
                if (statisticItem.getKey() != null && !statisticItem.getKey().equals("c13756") && !statisticItem.getKey().equals("c13750") && !statisticItem.getKey().equals("c13751")) {
                    statisticItem.param("obj_type", z ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }
}
