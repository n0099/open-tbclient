package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.wq5;
import com.baidu.tieba.xe;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class jr5<T extends wq5> extends hr5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jr5(int i, String str, Class<T> cls) {
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
        wq5 wq5Var;
        byte[] bArr;
        wq5 wq5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            wq5 wq5Var3 = null;
            if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
                return null;
            }
            ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
            wq5 wq5Var4 = (wq5) a();
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
                    if (wq5Var4 != null) {
                        if (readCacheMessage.getRequestData() == null) {
                            try {
                                if (wq5Var4 instanceof vq5) {
                                    f55.d();
                                    List<xe.b<byte[]>> a = dj.a(f55.c(this.b, str));
                                    if (a != null) {
                                        arrayList = new ArrayList(a.size());
                                        for (xe.b<byte[]> bVar : a) {
                                            if (bVar != null && (bArr = bVar.b) != null && (wq5Var2 = (wq5) a()) != null) {
                                                ((vq5) wq5Var2).initByByteArray(bArr);
                                                arrayList.add(wq5Var2);
                                            }
                                        }
                                        wq5Var3 = arrayList;
                                    }
                                } else if (wq5Var4 instanceof yq5) {
                                    f55.d();
                                    List<xe.b<String>> b = dj.b(f55.f(this.b, str));
                                    if (b != null) {
                                        arrayList = new ArrayList(b.size());
                                        for (xe.b<String> bVar2 : b) {
                                            if (bVar2 != null && (str2 = bVar2.b) != null && (wq5Var = (wq5) a()) != null) {
                                                ((yq5) wq5Var).H(str2);
                                                arrayList.add(wq5Var);
                                            }
                                        }
                                        wq5Var3 = arrayList;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                wq5Var3 = wq5Var4;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, wq5Var3);
                            } catch (Throwable th) {
                                th = th;
                                wq5Var3 = wq5Var4;
                                new ReadCacheRespMsg(this.a, wq5Var3);
                                throw th;
                            }
                        } else {
                            String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                            String T2 = readCacheMessage.getRequestData().T();
                            try {
                                if (wq5Var4 instanceof vq5) {
                                    f55.d();
                                    byte[] bArr2 = f55.c(T2, str).get(cacheKey);
                                    if (bArr2 != null) {
                                        ((vq5) wq5Var4).initByByteArray(bArr2);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(wq5Var4);
                                        T2 = arrayList2;
                                        wq5Var3 = T2;
                                    }
                                } else if (wq5Var4 instanceof yq5) {
                                    f55.d();
                                    String str3 = f55.f(T2, str).get(cacheKey);
                                    if (str3 != null) {
                                        ((yq5) wq5Var4).H(str3);
                                        ?? arrayList3 = new ArrayList();
                                        arrayList3.add(wq5Var4);
                                        T2 = arrayList3;
                                        wq5Var3 = T2;
                                    }
                                }
                            } catch (Exception e2) {
                                wq5Var3 = T2;
                                e = e2;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, wq5Var3);
                            } catch (Throwable th2) {
                                wq5Var3 = T2;
                                th = th2;
                                new ReadCacheRespMsg(this.a, wq5Var3);
                                throw th;
                            }
                        }
                    }
                    return new ReadCacheRespMsg(this.a, wq5Var3);
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
