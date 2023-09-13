package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.pr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zr5<T extends pr5> extends wr5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zr5(int i, String str, Class<T> cls) {
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
                pr5 pr5Var = (pr5) a();
                if (pr5Var != null) {
                    if (pr5Var instanceof or5) {
                        x45.k();
                        oe<byte[]> j = x45.j(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            pr5 pr5Var2 = (pr5) writeCacheMessage.getData();
                            if (pr5Var2 == null) {
                                BdCacheService.n().l(j);
                            } else {
                                j.remove(pr5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            pr5 pr5Var3 = (pr5) writeCacheMessage.getData();
                            if (pr5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            j.g(pr5Var3.getCacheKey(), ((or5) pr5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (pr5Var instanceof rr5) {
                        x45.k();
                        oe<String> m = x45.m(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            pr5 pr5Var4 = (pr5) writeCacheMessage.getData();
                            if (pr5Var4 == null) {
                                BdCacheService.n().l(m);
                            } else {
                                m.remove(pr5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            pr5 pr5Var5 = (pr5) writeCacheMessage.getData();
                            if (pr5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String cacheString = ((rr5) pr5Var5).toCacheString();
                            if (cacheString != null) {
                                m.g(pr5Var5.getCacheKey(), cacheString);
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
