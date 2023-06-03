package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.kq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yq5<T extends kq5> extends vq5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yq5(int i, String str, Class<T> cls) {
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
                kq5 kq5Var = (kq5) a();
                if (kq5Var != null) {
                    if (kq5Var instanceof jq5) {
                        z45.d();
                        we<byte[]> c = z45.c(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            kq5 kq5Var2 = (kq5) writeCacheMessage.getData();
                            if (kq5Var2 == null) {
                                BdCacheService.n().l(c);
                            } else {
                                c.remove(kq5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            kq5 kq5Var3 = (kq5) writeCacheMessage.getData();
                            if (kq5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            c.g(kq5Var3.getCacheKey(), ((jq5) kq5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (kq5Var instanceof mq5) {
                        z45.d();
                        we<String> f = z45.f(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            kq5 kq5Var4 = (kq5) writeCacheMessage.getData();
                            if (kq5Var4 == null) {
                                BdCacheService.n().l(f);
                            } else {
                                f.remove(kq5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            kq5 kq5Var5 = (kq5) writeCacheMessage.getData();
                            if (kq5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String t = ((mq5) kq5Var5).t();
                            if (t != null) {
                                f.g(kq5Var5.getCacheKey(), t);
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
