package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z48 implements CustomMessageTask.CustomRunnable<LoadDraftMessage.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g48 a;
    public int b;

    public z48(g48 g48Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g48Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = g48Var;
        this.b = i;
    }

    public final LoadDraftResponsedMessage a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(i);
            loadDraftResponsedMessage.setError(-18);
            return loadDraftResponsedMessage;
        }
        return (LoadDraftResponsedMessage) invokeI.objValue;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<LoadDraftMessage.a> customMessage) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customMessage)) == null) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage(this.b);
            if (customMessage != null && (customMessage instanceof LoadDraftMessage)) {
                LoadDraftMessage loadDraftMessage = (LoadDraftMessage) customMessage;
                if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                    str = TbadkCoreApplication.getCurrentAccountObj().getID();
                } else {
                    str = "";
                }
                LoadDraftMessage.a data = loadDraftMessage.getData();
                ChatSetting a = this.a.a(str, data.a);
                if (a == null) {
                    return a(loadDraftMessage.getCmd());
                }
                String draft = a.getDraft();
                LoadDraftResponsedMessage.a aVar = new LoadDraftResponsedMessage.a();
                aVar.a = draft;
                String str2 = data.a;
                try {
                    loadDraftResponsedMessage.decodeInBackGround(this.b, aVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return loadDraftResponsedMessage;
            }
            return a(this.b);
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
