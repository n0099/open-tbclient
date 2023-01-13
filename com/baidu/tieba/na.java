package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class na extends ma<CustomMessage<?>, CustomMessageTask> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, String, CustomResponsedMessage<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CustomMessage a;
        public CustomMessageTask b;
        public final /* synthetic */ na c;

        public a(na naVar, CustomMessage customMessage, CustomMessageTask customMessageTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {naVar, customMessage, customMessageTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = naVar;
            this.a = null;
            this.b = null;
            setPriority(customMessageTask.getPriority());
            setParallel(customMessageTask.getParallel());
            if (customMessage != null) {
                setTag(customMessage.getTag());
            }
            setKey(String.valueOf(customMessageTask.getCmd()));
            setParallel(customMessageTask.getTaskParallel());
            if (customMessageTask.isImme()) {
                setPriority(4);
            }
            this.a = customMessage;
            this.b = customMessageTask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public CustomResponsedMessage doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                CustomMessageTask customMessageTask = this.b;
                if (customMessageTask == null) {
                    return null;
                }
                if (customMessageTask.getRunnable() == null) {
                    BdLog.e("CustomTask :" + this.b.getClass().getName() + "did not contain a runnable!!");
                    return null;
                }
                try {
                    return this.b.getRunnable().run(this.a);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return null;
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }

        public CustomMessage c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (CustomMessage) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customResponsedMessage) == null) {
                if (customResponsedMessage != null) {
                    customResponsedMessage.setOrginalMessage(this.a);
                    this.c.a.dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                BdLog.e("CustomTask :" + this.b.getClass().getName() + "returns a NULL!!");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public na(MessageManager messageManager) {
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
    }

    @Override // com.baidu.tieba.ja
    public LinkedList<CustomMessage<?>> e(int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bdUniqueId)) == null) {
            if (i != 0) {
                str = String.valueOf(i);
            } else {
                str = null;
            }
            LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, str);
            LinkedList<CustomMessage<?>> linkedList = new LinkedList<>();
            Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next instanceof a) {
                    linkedList.add(((a) next).c());
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ja
    /* renamed from: l */
    public void f(CustomMessage customMessage, CustomMessageTask customMessageTask) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, customMessage, customMessageTask) == null) && customMessage != null && customMessageTask != null) {
            if (customMessageTask.getType() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                CustomResponsedMessage<?> customResponsedMessage = null;
                try {
                    customResponsedMessage = customMessageTask.getRunnable().run(customMessage);
                    if (customResponsedMessage != null) {
                        customResponsedMessage.setOrginalMessage(customMessage);
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                if (customResponsedMessage != null) {
                    this.a.dispatchResponsedMessage(customResponsedMessage);
                    return;
                }
                return;
            }
            new a(this, customMessage, customMessageTask).execute(new String[0]);
        }
    }

    @Override // com.baidu.tieba.ja
    public void h(int i, BdUniqueId bdUniqueId) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bdUniqueId) == null) {
            if (i != 0) {
                str = String.valueOf(i);
            } else {
                str = null;
            }
            BdAsyncTask.removeAllTask(bdUniqueId, str);
        }
    }

    public LinkedList<CustomMessage<?>> i(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bdUniqueId)) == null) {
            return e(0, bdUniqueId);
        }
        return (LinkedList) invokeL.objValue;
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            h(0, bdUniqueId);
        }
    }

    public <T> CustomResponsedMessage<T> k(CustomMessage customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, customMessage, customMessageTask, cls)) == null) {
            CustomResponsedMessage<T> customResponsedMessage = null;
            if (customMessageTask == null) {
                return null;
            }
            if (customMessageTask.getType() == CustomMessageTask.TASK_TYPE.SYNCHRONIZED) {
                try {
                    customResponsedMessage = (CustomResponsedMessage<T>) customMessageTask.getRunnable().run(customMessage);
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                if (customResponsedMessage != null) {
                    this.a.dispatchResponsedMessage(customResponsedMessage);
                }
            } else {
                new a(this, customMessage, customMessageTask).execute(new String[0]);
            }
            return customResponsedMessage;
        }
        return (CustomResponsedMessage) invokeLLL.objValue;
    }
}
