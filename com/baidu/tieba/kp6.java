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
public class kp6 implements a97<Message> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kp6() {
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
    @Override // com.baidu.tieba.a97
    /* renamed from: a */
    public rb7<?> b(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (!(message instanceof UserFollowLive)) {
                return null;
            }
            gc8 gc8Var = new gc8();
            gc8Var.d((UserFollowLive) message);
            qm6 qm6Var = new qm6(null, gc8Var.c(), ImageViewerConfig.FROM_CONCERN);
            u77 u77Var = new u77();
            u77Var.a = qm6Var;
            return new sb7(new i37(u77Var), "ala_live_attention");
        }
        return (rb7) invokeL.objValue;
    }
}
