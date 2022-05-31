package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j57;
import com.repackage.l57;
/* loaded from: classes3.dex */
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
    public void queryAllBigImageUrls(String str, l57 l57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, l57Var) == null) {
            j57.k().q(str, l57Var);
        }
    }
}
