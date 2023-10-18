package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rh8 implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rh8() {
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

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof RequestOfficialBarMenuLocalMessage)) {
                gz4.k();
                byte[] bArr = gz4.i("tb.official_bar_menu").get(ResponseOfficialBarMenuMessage.OFFICIAL_BAR_MENU_KEY_PRE + ((RequestOfficialBarMenuLocalMessage) customMessage).getForumId());
                ResponseOfficialBarMenuLocalMessage responseOfficialBarMenuLocalMessage = new ResponseOfficialBarMenuLocalMessage();
                try {
                    responseOfficialBarMenuLocalMessage.decodeInBackGround(2001177, bArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return responseOfficialBarMenuLocalMessage;
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
