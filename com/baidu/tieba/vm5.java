package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tieba.im5;
import com.baidu.tieba.se;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class vm5<T extends im5> extends tm5<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vm5(int i, String str, Class<T> cls) {
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
        im5 im5Var;
        byte[] bArr;
        im5 im5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            im5 im5Var3 = null;
            if (customMessage == null || !(customMessage instanceof ReadCacheMessage)) {
                return null;
            }
            ReadCacheMessage readCacheMessage = (ReadCacheMessage) customMessage;
            im5 im5Var4 = (im5) a();
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
                    if (im5Var4 != null) {
                        if (readCacheMessage.getRequestData() == null) {
                            try {
                                if (im5Var4 instanceof hm5) {
                                    c25.d();
                                    List<se.b<byte[]>> a = xi.a(c25.c(this.b, str));
                                    if (a != null) {
                                        arrayList = new ArrayList(a.size());
                                        for (se.b<byte[]> bVar : a) {
                                            if (bVar != null && (bArr = bVar.b) != null && (im5Var2 = (im5) a()) != null) {
                                                ((hm5) im5Var2).initByByteArray(bArr);
                                                arrayList.add(im5Var2);
                                            }
                                        }
                                        im5Var3 = arrayList;
                                    }
                                } else if (im5Var4 instanceof km5) {
                                    c25.d();
                                    List<se.b<String>> b = xi.b(c25.f(this.b, str));
                                    if (b != null) {
                                        arrayList = new ArrayList(b.size());
                                        for (se.b<String> bVar2 : b) {
                                            if (bVar2 != null && (str2 = bVar2.b) != null && (im5Var = (im5) a()) != null) {
                                                ((km5) im5Var).H(str2);
                                                arrayList.add(im5Var);
                                            }
                                        }
                                        im5Var3 = arrayList;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                im5Var3 = im5Var4;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, im5Var3);
                            } catch (Throwable th) {
                                th = th;
                                im5Var3 = im5Var4;
                                new ReadCacheRespMsg(this.a, im5Var3);
                                throw th;
                            }
                        } else {
                            String cacheKey = readCacheMessage.getRequestData().getCacheKey();
                            String T = readCacheMessage.getRequestData().T();
                            try {
                                if (im5Var4 instanceof hm5) {
                                    c25.d();
                                    byte[] bArr2 = c25.c(T, str).get(cacheKey);
                                    if (bArr2 != null) {
                                        ((hm5) im5Var4).initByByteArray(bArr2);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(im5Var4);
                                        T = arrayList2;
                                        im5Var3 = T;
                                    }
                                } else if (im5Var4 instanceof km5) {
                                    c25.d();
                                    String str3 = c25.f(T, str).get(cacheKey);
                                    if (str3 != null) {
                                        ((km5) im5Var4).H(str3);
                                        ?? arrayList3 = new ArrayList();
                                        arrayList3.add(im5Var4);
                                        T = arrayList3;
                                        im5Var3 = T;
                                    }
                                }
                            } catch (Exception e2) {
                                im5Var3 = T;
                                e = e2;
                                e.printStackTrace();
                                return new ReadCacheRespMsg(this.a, im5Var3);
                            } catch (Throwable th2) {
                                im5Var3 = T;
                                th = th2;
                                new ReadCacheRespMsg(this.a, im5Var3);
                                throw th;
                            }
                        }
                    }
                    return new ReadCacheRespMsg(this.a, im5Var3);
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
