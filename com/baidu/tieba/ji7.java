package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ji7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ji7 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ji7() {
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

    public static ji7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ji7.class) {
                    if (a == null) {
                        a = new ji7();
                    }
                }
            }
            return a;
        }
        return (ji7) invokeV.objValue;
    }

    public void a(String str, String str2, String str3, String str4, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) && j != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && pg7.f().c(TbadkCoreApplication.getCurrentAccount(), j) == null) {
            pg7.f().l(TbadkCoreApplication.getCurrentAccount(), str, str2, str3, str4, j, 0L, j3, true);
        }
    }

    public long b(@NonNull Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l)) == null) {
            GroupChatRoomPojo c = pg7.f().c(TbadkCoreApplication.getCurrentAccount(), l.longValue());
            if (c != null) {
                return c.getTopTime();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public boolean e(@NonNull Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, l)) == null) {
            GroupChatRoomPojo c = pg7.f().c(TbadkCoreApplication.getCurrentAccount(), l.longValue());
            if (c == null || c.H() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean d(@NonNull Long l, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, l, j)) == null) {
            GroupChatRoomPojo c = pg7.f().c(TbadkCoreApplication.getCurrentAccount(), l.longValue());
            if (c != null && c.getDeleteTime() != 0 && j <= c.getDeleteTime()) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void f(@NonNull Long l, @NonNull String str, @NonNull String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{l, str, str2, Long.valueOf(j)}) == null) {
            pg7.f().m(TbadkCoreApplication.getCurrentAccount(), l.longValue(), str, str2, j);
        }
    }

    public void g(@NonNull Long l, @NonNull String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{l, str, str2, Boolean.valueOf(z)}) == null) {
            pg7.f().p(TbadkCoreApplication.getCurrentAccount(), l.longValue(), str, str2, !z);
        }
    }

    public void h(@NonNull Long l, @NonNull String str, @NonNull String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{l, str, str2, Long.valueOf(j)}) == null) {
            pg7.f().q(TbadkCoreApplication.getCurrentAccount(), l.longValue(), str, str2, j);
        }
    }
}
