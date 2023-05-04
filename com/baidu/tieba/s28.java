package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class s28 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s28 a;
    public transient /* synthetic */ FieldHolder $fh;

    public s28() {
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

    public static s28 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (s28.class) {
                    if (a == null) {
                        a = new s28();
                    }
                }
            }
            return a;
        }
        return (s28) invokeV.objValue;
    }

    public long a(@NonNull Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l)) == null) {
            GroupChatRoomPojo c = y08.f().c(TbadkCoreApplication.getCurrentAccount(), l.longValue());
            if (c != null) {
                return c.getTopTime();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public boolean d(@NonNull Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) {
            GroupChatRoomPojo c = y08.f().c(TbadkCoreApplication.getCurrentAccount(), l.longValue());
            if (c == null || c.W() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean c(@NonNull Long l, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l, j)) == null) {
            GroupChatRoomPojo c = y08.f().c(TbadkCoreApplication.getCurrentAccount(), l.longValue());
            if (c != null && c.getDeleteTime() != 0 && j <= c.getDeleteTime()) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void e(@NonNull Long l, @NonNull String str, @NonNull String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{l, str, str2, Long.valueOf(j)}) == null) {
            y08.f().m(TbadkCoreApplication.getCurrentAccount(), l.longValue(), str, str2, j);
        }
    }

    public void f(@NonNull Long l, @NonNull String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{l, str, str2, Boolean.valueOf(z)}) == null) {
            y08.f().p(TbadkCoreApplication.getCurrentAccount(), l.longValue(), str, str2, !z);
        }
    }

    public void g(@NonNull Long l, @NonNull String str, @NonNull String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{l, str, str2, Long.valueOf(j)}) == null) {
            y08.f().r(TbadkCoreApplication.getCurrentAccount(), l.longValue(), str, str2, j);
        }
    }
}
