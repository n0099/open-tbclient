package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes7.dex */
public class nb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qb8> a;

    public nb8() {
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

    public void a(JoinUser joinUser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, joinUser) == null) {
            joinUser.join_user_num.longValue();
            this.a = new ArrayList();
            for (UserInfo userInfo : joinUser.join_user) {
                if (userInfo != null) {
                    qb8 qb8Var = new qb8();
                    qb8Var.a(userInfo);
                    this.a.add(qb8Var);
                }
            }
        }
    }
}
