package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tieba.as5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class os5<T extends as5> extends ls5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public os5(int i, String str, Class<T> cls) {
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
                as5 as5Var = (as5) a();
                if (as5Var != null) {
                    if (as5Var instanceof zr5) {
                        o55.e();
                        ye<byte[]> d = o55.d(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            as5 as5Var2 = (as5) writeCacheMessage.getData();
                            if (as5Var2 == null) {
                                BdCacheService.n().l(d);
                            } else {
                                d.remove(as5Var2.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            as5 as5Var3 = (as5) writeCacheMessage.getData();
                            if (as5Var3 == null) {
                                return writeCacheRespMsg;
                            }
                            d.g(as5Var3.getCacheKey(), ((zr5) as5Var3).toCacheByteArray());
                            writeCacheRespMsg.setSuccess(true);
                        }
                    } else if (as5Var instanceof cs5) {
                        o55.e();
                        ye<String> g = o55.g(this.b, currentAccount);
                        if (writeCacheMessage.isClear()) {
                            as5 as5Var4 = (as5) writeCacheMessage.getData();
                            if (as5Var4 == null) {
                                BdCacheService.n().l(g);
                            } else {
                                g.remove(as5Var4.getCacheKey());
                            }
                            writeCacheRespMsg.setSuccess(true);
                        } else {
                            as5 as5Var5 = (as5) writeCacheMessage.getData();
                            if (as5Var5 == null) {
                                return writeCacheRespMsg;
                            }
                            String u = ((cs5) as5Var5).u();
                            if (u != null) {
                                g.g(as5Var5.getCacheKey(), u);
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
