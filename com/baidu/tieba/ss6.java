package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import tbclient.Userlike.UserFollowLive;
/* loaded from: classes7.dex */
public class ss6 implements ca7<Message> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ss6() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ca7
    /* renamed from: a */
    public mc7<?> b(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (!(message instanceof UserFollowLive)) {
                return null;
            }
            h18 h18Var = new h18();
            h18Var.d((UserFollowLive) message);
            yp6 yp6Var = new yp6(null, h18Var.c(), ImageViewerConfig.FROM_CONCERN);
            n97 n97Var = new n97();
            n97Var.a = yp6Var;
            return new nc7(new a67(n97Var), "ala_live_attention");
        }
        return (mc7) invokeL.objValue;
    }
}
