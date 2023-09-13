package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes7.dex */
public class rs6 implements ea7<Message> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rs6() {
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
            if (!(message instanceof LiveAnswer)) {
                return null;
            }
            h78 h78Var = new h78();
            h78Var.c((LiveAnswer) message);
            p97 p97Var = new p97();
            p97Var.a = h78Var;
            return new qc7(new b67(p97Var), "recommend_banner");
        }
        return (pc7) invokeL.objValue;
    }
}
