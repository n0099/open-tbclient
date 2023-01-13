package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ub extends wb<CustomMessage<?>, CustomMessageTask, hb, CustomResponsedMessage<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public na i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ub(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = null;
        this.i = new na(messageManager);
        this.e = zb.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ja
    /* renamed from: A */
    public void f(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, customMessage, customMessageTask) == null) {
            this.i.f(customMessage, customMessageTask);
        }
    }

    @Override // com.baidu.tieba.ja
    public LinkedList<CustomMessage<?>> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bdUniqueId)) == null) {
            return this.i.e(i, bdUniqueId);
        }
        return (LinkedList) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.ja
    public void h(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, bdUniqueId) == null) {
            this.i.h(i, bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wb
    /* renamed from: x */
    public CustomMessage<?> m(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, customMessage, customMessageTask)) == null) {
            return this.a.getController().e(customMessage, customMessageTask);
        }
        return (CustomMessage) invokeLL.objValue;
    }

    public LinkedList<CustomMessage<?>> w(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdUniqueId)) == null) {
            return this.i.i(bdUniqueId);
        }
        return (LinkedList) invokeL.objValue;
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.i.j(bdUniqueId);
        }
    }

    public <T> CustomResponsedMessage<T> z(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customMessage, customMessageTask, cls)) == null) {
            return this.i.k(customMessage, customMessageTask, cls);
        }
        return (CustomResponsedMessage) invokeLLL.objValue;
    }
}
