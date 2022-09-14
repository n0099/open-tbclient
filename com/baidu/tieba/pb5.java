package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.bb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pb5<T extends bb5> extends mb5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pb5(int i, String str, Class<T> cls) {
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
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof WriteCacheMessage)) {
                return null;
            }
            WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.a);
            WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            bb5 bb5Var = (bb5) a();
            if (bb5Var != null) {
                if (bb5Var instanceof ab5) {
                    zt4.f();
                    jf<byte[]> e = zt4.e(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        bb5 bb5Var2 = (bb5) writeCacheMessage.getData();
                        if (bb5Var2 == null) {
                            BdCacheService.k().j(e);
                        } else {
                            e.remove(bb5Var2.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        bb5 bb5Var3 = (bb5) writeCacheMessage.getData();
                        if (bb5Var3 == null) {
                            return writeCacheRespMsg;
                        }
                        e.g(bb5Var3.getCacheKey(), ((ab5) bb5Var3).toCacheByteArray());
                        writeCacheRespMsg.setSuccess(true);
                    }
                } else if (bb5Var instanceof db5) {
                    zt4.f();
                    jf<String> h = zt4.h(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        bb5 bb5Var4 = (bb5) writeCacheMessage.getData();
                        if (bb5Var4 == null) {
                            BdCacheService.k().j(h);
                        } else {
                            h.remove(bb5Var4.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        bb5 bb5Var5 = (bb5) writeCacheMessage.getData();
                        if (bb5Var5 != null && (k = ((db5) bb5Var5).k()) != null) {
                            h.g(bb5Var5.getCacheKey(), k);
                            writeCacheRespMsg.setSuccess(true);
                        }
                    }
                }
            }
            return writeCacheRespMsg;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
