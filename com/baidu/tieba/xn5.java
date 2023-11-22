package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.ca;
import com.baidu.tieba.on5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class xn5<T extends on5> extends vn5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xn5(int i, String str, Class<T> cls) {
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
        on5 on5Var;
        byte[] bArr;
        on5 on5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            on5 on5Var3 = null;
            if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
                return null;
            }
            ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
            on5 on5Var4 = (on5) a();
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
                    if (on5Var4 != null) {
                        if (readCacheMessage.getRequestData() == null) {
                            try {
                                if (on5Var4 instanceof nn5) {
                                    yz4.l();
                                    List<ca.b<byte[]>> a = vd.a(yz4.k(this.b, str));
                                    if (a != null) {
                                        arrayList = new ArrayList(a.size());
                                        for (ca.b<byte[]> bVar : a) {
                                            if (bVar != null && (bArr = bVar.b) != null && (on5Var2 = (on5) a()) != null) {
                                                ((nn5) on5Var2).initByByteArray(bArr);
                                                arrayList.add(on5Var2);
                                            }
                                        }
                                        on5Var3 = arrayList;
                                    }
                                } else if (on5Var4 instanceof qn5) {
                                    yz4.l();
                                    List<ca.b<String>> b = vd.b(yz4.n(this.b, str));
                                    if (b != null) {
                                        arrayList = new ArrayList(b.size());
                                        for (ca.b<String> bVar2 : b) {
                                            if (bVar2 != null && (str2 = bVar2.b) != null && (on5Var = (on5) a()) != null) {
                                                ((qn5) on5Var).initByString(str2);
                                                arrayList.add(on5Var);
                                            }
                                        }
                                        on5Var3 = arrayList;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                on5Var3 = on5Var4;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, on5Var3);
                            } catch (Throwable th) {
                                th = th;
                                on5Var3 = on5Var4;
                                new ReadCacheRespMsg(this.a, on5Var3);
                                throw th;
                            }
                        } else {
                            String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                            String cacheTableName = readCacheMessage.getRequestData().getCacheTableName();
                            try {
                                if (on5Var4 instanceof nn5) {
                                    yz4.l();
                                    byte[] bArr2 = yz4.k(cacheTableName, str).get(cacheKey);
                                    if (bArr2 != null) {
                                        ((nn5) on5Var4).initByByteArray(bArr2);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(on5Var4);
                                        cacheTableName = arrayList2;
                                        on5Var3 = cacheTableName;
                                    }
                                } else if (on5Var4 instanceof qn5) {
                                    yz4.l();
                                    String str3 = yz4.n(cacheTableName, str).get(cacheKey);
                                    if (str3 != null) {
                                        ((qn5) on5Var4).initByString(str3);
                                        ?? arrayList3 = new ArrayList();
                                        arrayList3.add(on5Var4);
                                        cacheTableName = arrayList3;
                                        on5Var3 = cacheTableName;
                                    }
                                }
                            } catch (Exception e2) {
                                on5Var3 = cacheTableName;
                                e = e2;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, on5Var3);
                            } catch (Throwable th2) {
                                on5Var3 = cacheTableName;
                                th = th2;
                                new ReadCacheRespMsg(this.a, on5Var3);
                                throw th;
                            }
                        }
                    }
                    return new ReadCacheRespMsg(this.a, on5Var3);
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
