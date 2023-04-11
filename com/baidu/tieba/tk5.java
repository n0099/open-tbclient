package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.fk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tk5<T extends fk5> extends qk5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tk5(int i, String str, Class<T> cls) {
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
                fk5 fk5Var = (fk5) a();
                if (fk5Var != null) {
                    if (fk5Var instanceof ek5) {
                        b05.d();
                        me<byte[]> c = b05.c(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            fk5 fk5Var2 = (fk5) writeCacheMessage.getData();
                            if (fk5Var2 == null) {
                                BdCacheService.n().l(c);
                            } else {
                                c.remove(fk5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            fk5 fk5Var3 = (fk5) writeCacheMessage.getData();
                            if (fk5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            c.g(fk5Var3.getCacheKey(), ((ek5) fk5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (fk5Var instanceof hk5) {
                        b05.d();
                        me<String> f = b05.f(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            fk5 fk5Var4 = (fk5) writeCacheMessage.getData();
                            if (fk5Var4 == null) {
                                BdCacheService.n().l(f);
                            } else {
                                f.remove(fk5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            fk5 fk5Var5 = (fk5) writeCacheMessage.getData();
                            if (fk5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String r = ((hk5) fk5Var5).r();
                            if (r != null) {
                                f.g(fk5Var5.getCacheKey(), r);
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
