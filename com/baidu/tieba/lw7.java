package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.JoinUser;
import tbclient.Hottopic.UserInfo;
/* loaded from: classes5.dex */
public class lw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ow7> a;

    public lw7() {
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
                    ow7 ow7Var = new ow7();
                    ow7Var.a(userInfo);
                    this.a.add(ow7Var);
                }
            }
        }
    }
}
