package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.nn5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class xn5<T extends nn5> extends un5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xn5(int i, String str, Class<T> cls) {
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
                nn5 nn5Var = (nn5) a();
                if (nn5Var != null) {
                    if (nn5Var instanceof mn5) {
                        yz4.l();
                        ca<byte[]> k = yz4.k(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            nn5 nn5Var2 = (nn5) writeCacheMessage.getData();
                            if (nn5Var2 == null) {
                                BdCacheService.o().m(k);
                            } else {
                                k.remove(nn5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            nn5 nn5Var3 = (nn5) writeCacheMessage.getData();
                            if (nn5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            k.g(nn5Var3.getCacheKey(), ((mn5) nn5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (nn5Var instanceof pn5) {
                        yz4.l();
                        ca<String> n = yz4.n(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            nn5 nn5Var4 = (nn5) writeCacheMessage.getData();
                            if (nn5Var4 == null) {
                                BdCacheService.o().m(n);
                            } else {
                                n.remove(nn5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            nn5 nn5Var5 = (nn5) writeCacheMessage.getData();
                            if (nn5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String cacheString = ((pn5) nn5Var5).toCacheString();
                            if (cacheString != null) {
                                n.g(nn5Var5.getCacheKey(), cacheString);
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
