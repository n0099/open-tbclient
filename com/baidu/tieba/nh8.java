package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class nh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, ImMessageCenterPojo> a;

    /* loaded from: classes7.dex */
    public interface a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public nh8() {
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
        this.a = new ConcurrentHashMap<>();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
        }
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, imMessageCenterPojo) != null) || imMessageCenterPojo == null) {
            return;
        }
        this.a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
    }

    public ImMessageCenterPojo c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.a.get(str);
        }
        return (ImMessageCenterPojo) invokeL.objValue;
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.a(this.a.values().iterator());
        }
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str) || this.a.remove(str) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
