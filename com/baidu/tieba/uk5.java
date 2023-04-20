package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.gk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class uk5<T extends gk5> extends rk5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uk5(int i, String str, Class<T> cls) {
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
                gk5 gk5Var = (gk5) a();
                if (gk5Var != null) {
                    if (gk5Var instanceof fk5) {
                        c05.d();
                        me<byte[]> c = c05.c(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            gk5 gk5Var2 = (gk5) writeCacheMessage.getData();
                            if (gk5Var2 == null) {
                                BdCacheService.n().l(c);
                            } else {
                                c.remove(gk5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            gk5 gk5Var3 = (gk5) writeCacheMessage.getData();
                            if (gk5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            c.g(gk5Var3.getCacheKey(), ((fk5) gk5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (gk5Var instanceof ik5) {
                        c05.d();
                        me<String> f = c05.f(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            gk5 gk5Var4 = (gk5) writeCacheMessage.getData();
                            if (gk5Var4 == null) {
                                BdCacheService.n().l(f);
                            } else {
                                f.remove(gk5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            gk5 gk5Var5 = (gk5) writeCacheMessage.getData();
                            if (gk5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String r = ((ik5) gk5Var5).r();
                            if (r != null) {
                                f.g(gk5Var5.getCacheKey(), r);
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
