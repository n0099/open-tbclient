package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.oe;
import com.baidu.tieba.pr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class yr5<T extends pr5> extends wr5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yr5(int i, String str, Class<T> cls) {
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
        pr5 pr5Var;
        byte[] bArr;
        pr5 pr5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            pr5 pr5Var3 = null;
            if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
                return null;
            }
            ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
            pr5 pr5Var4 = (pr5) a();
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
                    if (pr5Var4 != null) {
                        if (readCacheMessage.getRequestData() == null) {
                            try {
                                if (pr5Var4 instanceof or5) {
                                    x45.k();
                                    List<oe.b<byte[]>> a = ji.a(x45.j(this.b, str));
                                    if (a != null) {
                                        arrayList = new ArrayList(a.size());
                                        for (oe.b<byte[]> bVar : a) {
                                            if (bVar != null && (bArr = bVar.b) != null && (pr5Var2 = (pr5) a()) != null) {
                                                ((or5) pr5Var2).initByByteArray(bArr);
                                                arrayList.add(pr5Var2);
                                            }
                                        }
                                        pr5Var3 = arrayList;
                                    }
                                } else if (pr5Var4 instanceof rr5) {
                                    x45.k();
                                    List<oe.b<String>> b = ji.b(x45.m(this.b, str));
                                    if (b != null) {
                                        arrayList = new ArrayList(b.size());
                                        for (oe.b<String> bVar2 : b) {
                                            if (bVar2 != null && (str2 = bVar2.b) != null && (pr5Var = (pr5) a()) != null) {
                                                ((rr5) pr5Var).initByString(str2);
                                                arrayList.add(pr5Var);
                                            }
                                        }
                                        pr5Var3 = arrayList;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                pr5Var3 = pr5Var4;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, pr5Var3);
                            } catch (Throwable th) {
                                th = th;
                                pr5Var3 = pr5Var4;
                                new ReadCacheRespMsg(this.a, pr5Var3);
                                throw th;
                            }
                        } else {
                            String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                            String cacheTableName = readCacheMessage.getRequestData().getCacheTableName();
                            try {
                                if (pr5Var4 instanceof or5) {
                                    x45.k();
                                    byte[] bArr2 = x45.j(cacheTableName, str).get(cacheKey);
                                    if (bArr2 != null) {
                                        ((or5) pr5Var4).initByByteArray(bArr2);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(pr5Var4);
                                        cacheTableName = arrayList2;
                                        pr5Var3 = cacheTableName;
                                    }
                                } else if (pr5Var4 instanceof rr5) {
                                    x45.k();
                                    String str3 = x45.m(cacheTableName, str).get(cacheKey);
                                    if (str3 != null) {
                                        ((rr5) pr5Var4).initByString(str3);
                                        ?? arrayList3 = new ArrayList();
                                        arrayList3.add(pr5Var4);
                                        cacheTableName = arrayList3;
                                        pr5Var3 = cacheTableName;
                                    }
                                }
                            } catch (Exception e2) {
                                pr5Var3 = cacheTableName;
                                e = e2;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, pr5Var3);
                            } catch (Throwable th2) {
                                pr5Var3 = cacheTableName;
                                th = th2;
                                new ReadCacheRespMsg(this.a, pr5Var3);
                                throw th;
                            }
                        }
                    }
                    return new ReadCacheRespMsg(this.a, pr5Var3);
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
