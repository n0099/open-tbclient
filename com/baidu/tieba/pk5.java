package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.ck5;
import com.baidu.tieba.jf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class pk5<T extends ck5> extends nk5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pk5(int i, String str, Class<T> cls) {
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
        ck5 ck5Var;
        byte[] bArr;
        ck5 ck5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            ck5 ck5Var3 = null;
            if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
                return null;
            }
            ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
            ck5 ck5Var4 = (ck5) a();
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
                    if (ck5Var4 != null) {
                        if (readCacheMessage.getRequestData() == null) {
                            try {
                                if (ck5Var4 instanceof bk5) {
                                    p15.d();
                                    List<jf.b<byte[]>> a = kj.a(p15.c(this.b, str));
                                    if (a != null) {
                                        arrayList = new ArrayList(a.size());
                                        for (jf.b<byte[]> bVar : a) {
                                            if (bVar != null && (bArr = bVar.b) != null && (ck5Var2 = (ck5) a()) != null) {
                                                ((bk5) ck5Var2).initByByteArray(bArr);
                                                arrayList.add(ck5Var2);
                                            }
                                        }
                                        ck5Var3 = arrayList;
                                    }
                                } else if (ck5Var4 instanceof ek5) {
                                    p15.d();
                                    List<jf.b<String>> b = kj.b(p15.f(this.b, str));
                                    if (b != null) {
                                        arrayList = new ArrayList(b.size());
                                        for (jf.b<String> bVar2 : b) {
                                            if (bVar2 != null && (str2 = bVar2.b) != null && (ck5Var = (ck5) a()) != null) {
                                                ((ek5) ck5Var).A(str2);
                                                arrayList.add(ck5Var);
                                            }
                                        }
                                        ck5Var3 = arrayList;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                ck5Var3 = ck5Var4;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, ck5Var3);
                            } catch (Throwable th) {
                                th = th;
                                ck5Var3 = ck5Var4;
                                new ReadCacheRespMsg(this.a, ck5Var3);
                                throw th;
                            }
                        } else {
                            String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                            String M = readCacheMessage.getRequestData().M();
                            try {
                                if (ck5Var4 instanceof bk5) {
                                    p15.d();
                                    byte[] bArr2 = p15.c(M, str).get(cacheKey);
                                    if (bArr2 != null) {
                                        ((bk5) ck5Var4).initByByteArray(bArr2);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(ck5Var4);
                                        M = arrayList2;
                                        ck5Var3 = M;
                                    }
                                } else if (ck5Var4 instanceof ek5) {
                                    p15.d();
                                    String str3 = p15.f(M, str).get(cacheKey);
                                    if (str3 != null) {
                                        ((ek5) ck5Var4).A(str3);
                                        ?? arrayList3 = new ArrayList();
                                        arrayList3.add(ck5Var4);
                                        M = arrayList3;
                                        ck5Var3 = M;
                                    }
                                }
                            } catch (Exception e2) {
                                ck5Var3 = M;
                                e = e2;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, ck5Var3);
                            } catch (Throwable th2) {
                                ck5Var3 = M;
                                th = th2;
                                new ReadCacheRespMsg(this.a, ck5Var3);
                                throw th;
                            }
                        }
                    }
                    return new ReadCacheRespMsg(this.a, ck5Var3);
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
