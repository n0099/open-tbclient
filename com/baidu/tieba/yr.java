package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.lr;
import com.baidu.tieba.mr;
import com.baidu.tieba.nr;
import com.baidu.tieba.or;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes8.dex */
public class yr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static sr a(wr wrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, wrVar, bArr)) == null) {
            sr srVar = null;
            if (wrVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                sr srVar2 = new sr();
                try {
                    pr a = pr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    srVar2.a(a);
                    List<nr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (nr nrVar : b) {
                        int a2 = nrVar.a();
                        byte[] b2 = nrVar.b();
                        if (a2 == 0) {
                            int a3 = es.a(RSA.decrypt(b2));
                            wrVar.e(DH.getDHSecretKey(a3, wrVar.o().intValue(), wrVar.p().intValue()));
                            wrVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    lr.a d = lr.d();
                    d.a(a.e());
                    wrVar.h(d.b().a());
                    if (wrVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    wrVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        wrVar.j(a.d());
                        return srVar2;
                    }
                    return srVar2;
                } catch (Exception e) {
                    e = e;
                    srVar = srVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return srVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (sr) invokeLL.objValue;
        }
    }

    public static byte[] b(wr wrVar, sr srVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, wrVar, srVar)) == null) {
            if (srVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            or.a a = or.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(lt.a(bArr));
            or c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            wrVar.d(Integer.valueOf(dHGroupId));
            wrVar.g(Integer.valueOf(dHSecret));
            wrVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = es.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = mt.b(ot.b(ht.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            nr.a d2 = nr.d();
            d2.a(0);
            d2.b(lt.a(encrypt));
            linkedList.offer(d2.c());
            nr.a d3 = nr.d();
            d3.a(1);
            d3.b(lt.a(new byte[]{0}));
            linkedList.offer(d3.c());
            nr.a d4 = nr.d();
            d4.a(2);
            d4.b(lt.a(es.d(dHGroupId)));
            linkedList.offer(d4.c());
            nr.a d5 = nr.d();
            d5.a(3);
            d5.b(lt.a(bytes));
            linkedList.offer(d5.c());
            if (jr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            mr.a d6 = mr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((nr) it.next());
            }
            d6.b(c);
            d6.c(lt.a(xr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
