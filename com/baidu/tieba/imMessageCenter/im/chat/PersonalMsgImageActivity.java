package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.fb7;
import com.baidu.tieba.hb7;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PersonalMsgImageActivity extends AbsMsgImageActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PersonalMsgImageActivity() {
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

    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    public void j2(String str, hb7 hb7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, hb7Var) == null) {
            fb7.k().q(str, hb7Var);
        }
    }
}
