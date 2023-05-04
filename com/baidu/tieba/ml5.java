package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.me;
import com.baidu.tieba.zk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ml5<T extends zk5> extends kl5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ml5(int i, String str, Class<T> cls) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x0073 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x00d6 */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v12. Raw type applied. Possible types: T */
    /* JADX DEBUG: Type inference failed for r2v9. Raw type applied. Possible types: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v36 */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String str;
        ?? arrayList;
        String str2;
        zk5 zk5Var;
        byte[] bArr;
        zk5 zk5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            zk5 zk5Var3 = null;
            if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
                return null;
            }
            ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
            zk5 zk5Var4 = (zk5) a();
            try {
                try {
                    if (readCacheMessage.isNeedUid()) {
                        str = TbadkCoreApplication.getCurrentAccount();
                        if (str == null) {
                            str = "";
                        }
                    } else {
                        str = null;
                    }
                    if (zk5Var4 != null) {
                        if (readCacheMessage.getRequestData() == null) {
                            try {
                                if (zk5Var4 instanceof yk5) {
                                    t05.d();
                                    List<me.b<byte[]>> a = oi.a(t05.c(this.b, str));
                                    if (a != null) {
                                        arrayList = new ArrayList(a.size());
                                        for (me.b<byte[]> bVar : a) {
                                            if (bVar != null && (bArr = bVar.b) != null && (zk5Var2 = (zk5) a()) != null) {
                                                ((yk5) zk5Var2).initByByteArray(bArr);
                                                arrayList.add(zk5Var2);
                                            }
                                        }
                                        zk5Var3 = arrayList;
                                    }
                                } else if (zk5Var4 instanceof bl5) {
                                    t05.d();
                                    List<me.b<String>> b = oi.b(t05.f(this.b, str));
                                    if (b != null) {
                                        arrayList = new ArrayList(b.size());
                                        for (me.b<String> bVar2 : b) {
                                            if (bVar2 != null && (str2 = bVar2.b) != null && (zk5Var = (zk5) a()) != null) {
                                                ((bl5) zk5Var).I(str2);
                                                arrayList.add(zk5Var);
                                            }
                                        }
                                        zk5Var3 = arrayList;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                zk5Var3 = zk5Var4;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, zk5Var3);
                            } catch (Throwable th) {
                                th = th;
                                zk5Var3 = zk5Var4;
                                new ReadCacheRespMsg(this.a, zk5Var3);
                                throw th;
                            }
                        } else {
                            String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                            String U = readCacheMessage.getRequestData().U();
                            try {
                                if (zk5Var4 instanceof yk5) {
                                    t05.d();
                                    byte[] bArr2 = t05.c(U, str).get(cacheKey);
                                    if (bArr2 != null) {
                                        ((yk5) zk5Var4).initByByteArray(bArr2);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(zk5Var4);
                                        U = arrayList2;
                                        zk5Var3 = U;
                                    }
                                } else if (zk5Var4 instanceof bl5) {
                                    t05.d();
                                    String str3 = t05.f(U, str).get(cacheKey);
                                    if (str3 != null) {
                                        ((bl5) zk5Var4).I(str3);
                                        ?? arrayList3 = new ArrayList();
                                        arrayList3.add(zk5Var4);
                                        U = arrayList3;
                                        zk5Var3 = U;
                                    }
                                }
                            } catch (Exception e2) {
                                zk5Var3 = U;
                                e = e2;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, zk5Var3);
                            } catch (Throwable th2) {
                                zk5Var3 = U;
                                th = th2;
                                new ReadCacheRespMsg(this.a, zk5Var3);
                                throw th;
                            }
                        }
                    }
                    return new ReadCacheRespMsg(this.a, zk5Var3);
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }
}
