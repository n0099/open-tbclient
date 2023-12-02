package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class kp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kp8() {
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

    public void a(int i, int i2, String str, long j, String str2, long j2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(j), str2, Long.valueOf(j2), str3}) == null) {
            TiebaStatic.log(new StatisticItem("c15134").param("obj_type", i).param("obj_source", i2).param("obj_name", str).param("fid", j).param("fname", str2).param("room_id", j2).param("obj_id", str3).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void b(int i, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) {
            TiebaStatic.log(new StatisticItem("c15134").param("obj_type", i).param("fid", j).param("fname", str).param("room_id", j2).param("obj_id", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void c(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            TiebaStatic.log(new StatisticItem("c15128").param("fid", j).param("room_id", j2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
