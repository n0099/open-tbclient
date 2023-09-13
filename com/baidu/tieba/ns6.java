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
public class ns6 implements ea7<Message> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ns6() {
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
    @Override // com.baidu.tieba.ea7
    /* renamed from: a */
    public pc7<?> b(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (!(message instanceof UserFollowLive)) {
                return null;
            }
            y18 y18Var = new y18();
            y18Var.d((UserFollowLive) message);
            qp6 qp6Var = new qp6(null, y18Var.c(), ImageViewerConfig.FROM_CONCERN);
            p97 p97Var = new p97();
            p97Var.a = qp6Var;
            return new qc7(new b67(p97Var), "ala_live_attention");
        }
        return (pc7) invokeL.objValue;
    }
}
