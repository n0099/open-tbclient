package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.ao5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ko5<T extends ao5> extends ho5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ko5(int i, String str, Class<T> cls) {
        super(i, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage != null && (customMessage instanceof WriteCacheMessage)) {
                WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.a);
                WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                ao5 ao5Var = (ao5) a();
                if (ao5Var != null) {
                    if (ao5Var instanceof zn5) {
                        e05.k();
                        da<byte[]> j = e05.j(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            ao5 ao5Var2 = (ao5) writeCacheMessage.getData();
                            if (ao5Var2 == null) {
                                BdCacheService.o().m(j);
                            } else {
                                j.remove(ao5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            ao5 ao5Var3 = (ao5) writeCacheMessage.getData();
                            if (ao5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            j.g(ao5Var3.getCacheKey(), ((zn5) ao5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (ao5Var instanceof co5) {
                        e05.k();
                        da<String> n = e05.n(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            ao5 ao5Var4 = (ao5) writeCacheMessage.getData();
                            if (ao5Var4 == null) {
                                BdCacheService.o().m(n);
                            } else {
                                n.remove(ao5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            ao5 ao5Var5 = (ao5) writeCacheMessage.getData();
                            if (ao5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String cacheString = ((co5) ao5Var5).toCacheString();
                            if (cacheString != null) {
                                n.g(ao5Var5.getCacheKey(), cacheString);
                                writeCacheRespMsg.setSuccess(true);
                            }
                        }
                    }
                }
                return writeCacheRespMsg;
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
