package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.eq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oq5<T extends eq5> extends lq5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oq5(int i, String str, Class<T> cls) {
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
                eq5 eq5Var = (eq5) a();
                if (eq5Var != null) {
                    if (eq5Var instanceof dq5) {
                        l45.e();
                        ne<byte[]> d = l45.d(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            eq5 eq5Var2 = (eq5) writeCacheMessage.getData();
                            if (eq5Var2 == null) {
                                BdCacheService.n().l(d);
                            } else {
                                d.remove(eq5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            eq5 eq5Var3 = (eq5) writeCacheMessage.getData();
                            if (eq5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            d.g(eq5Var3.getCacheKey(), ((dq5) eq5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (eq5Var instanceof gq5) {
                        l45.e();
                        ne<String> g = l45.g(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            eq5 eq5Var4 = (eq5) writeCacheMessage.getData();
                            if (eq5Var4 == null) {
                                BdCacheService.n().l(g);
                            } else {
                                g.remove(eq5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            eq5 eq5Var5 = (eq5) writeCacheMessage.getData();
                            if (eq5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String cacheString = ((gq5) eq5Var5).toCacheString();
                            if (cacheString != null) {
                                g.g(eq5Var5.getCacheKey(), cacheString);
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
