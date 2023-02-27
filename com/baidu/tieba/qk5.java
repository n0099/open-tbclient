package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.ck5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qk5<T extends ck5> extends nk5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qk5(int i, String str, Class<T> cls) {
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
                ck5 ck5Var = (ck5) a();
                if (ck5Var != null) {
                    if (ck5Var instanceof bk5) {
                        p15.d();
                        jf<byte[]> c = p15.c(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            ck5 ck5Var2 = (ck5) writeCacheMessage.getData();
                            if (ck5Var2 == null) {
                                BdCacheService.n().l(c);
                            } else {
                                c.remove(ck5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            ck5 ck5Var3 = (ck5) writeCacheMessage.getData();
                            if (ck5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            c.g(ck5Var3.getCacheKey(), ((bk5) ck5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (ck5Var instanceof ek5) {
                        p15.d();
                        jf<String> f = p15.f(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            ck5 ck5Var4 = (ck5) writeCacheMessage.getData();
                            if (ck5Var4 == null) {
                                BdCacheService.n().l(f);
                            } else {
                                f.remove(ck5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            ck5 ck5Var5 = (ck5) writeCacheMessage.getData();
                            if (ck5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String m = ((ek5) ck5Var5).m();
                            if (m != null) {
                                f.g(ck5Var5.getCacheKey(), m);
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
