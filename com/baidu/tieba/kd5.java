package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.wc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kd5<T extends wc5> extends hd5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kd5(int i, String str, Class<T> cls) {
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
                wc5 wc5Var = (wc5) a();
                if (wc5Var != null) {
                    if (wc5Var instanceof vc5) {
                        iv4.f();
                        df<byte[]> e = iv4.e(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            wc5 wc5Var2 = (wc5) writeCacheMessage.getData();
                            if (wc5Var2 == null) {
                                BdCacheService.k().j(e);
                            } else {
                                e.remove(wc5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            wc5 wc5Var3 = (wc5) writeCacheMessage.getData();
                            if (wc5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            e.g(wc5Var3.getCacheKey(), ((vc5) wc5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (wc5Var instanceof yc5) {
                        iv4.f();
                        df<String> h = iv4.h(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            wc5 wc5Var4 = (wc5) writeCacheMessage.getData();
                            if (wc5Var4 == null) {
                                BdCacheService.k().j(h);
                            } else {
                                h.remove(wc5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            wc5 wc5Var5 = (wc5) writeCacheMessage.getData();
                            if (wc5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String k = ((yc5) wc5Var5).k();
                            if (k != null) {
                                h.g(wc5Var5.getCacheKey(), k);
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
