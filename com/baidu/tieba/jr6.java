package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import tbclient.Userlike.UserFollowLive;
/* loaded from: classes6.dex */
public class jr6 implements z87<Message> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jr6() {
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
    @Override // com.baidu.tieba.z87
    /* renamed from: a */
    public jb7<?> b(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (!(message instanceof UserFollowLive)) {
                return null;
            }
            n08 n08Var = new n08();
            n08Var.d((UserFollowLive) message);
            no6 no6Var = new no6(null, n08Var.c(), ImageViewerConfig.FROM_CONCERN);
            k87 k87Var = new k87();
            k87Var.a = no6Var;
            return new kb7(new x47(k87Var), "ala_live_attention");
        }
        return (jb7) invokeL.objValue;
    }
}
