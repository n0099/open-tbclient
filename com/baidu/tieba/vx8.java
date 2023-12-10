package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class vx8 implements CustomMessageTask.CustomRunnable<SaveDraftMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cx8 a;
    public int b;

    public vx8(cx8 cx8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cx8Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cx8Var;
        this.b = i;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<SaveDraftMessage.a> customMessage) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.b);
            if (customMessage == null || !(customMessage instanceof SaveDraftMessage)) {
                return null;
            }
            SaveDraftMessage.a data = customMessage.getData();
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = TbadkCoreApplication.getCurrentAccountObj().getID();
            } else {
                str = "";
            }
            ChatSetting setting = this.a.getSetting(str, data.b);
            if (setting == null) {
                return null;
            }
            setting.setDraft(data.a);
            this.a.saveSetting(setting);
            return customResponsedMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
