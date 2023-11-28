package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.an;
import com.baidu.tieba.xm;
import com.baidu.tieba.ym;
import com.baidu.tieba.zm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes7.dex */
public class kn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static en a(in inVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, inVar, bArr)) == null) {
            en enVar = null;
            if (inVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                en enVar2 = new en();
                try {
                    bn a = bn.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    enVar2.a(a);
                    List<zm> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (zm zmVar : b) {
                        int a2 = zmVar.a();
                        byte[] b2 = zmVar.b();
                        if (a2 == 0) {
                            int a3 = qn.a(RSA.decrypt(b2));
                            inVar.e(DH.getDHSecretKey(a3, inVar.o().intValue(), inVar.p().intValue()));
                            inVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    xm.a d = xm.d();
                    d.a(a.e());
                    inVar.h(d.b().a());
                    if (inVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    inVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        inVar.j(a.d());
                        return enVar2;
                    }
                    return enVar2;
                } catch (Exception e) {
                    e = e;
                    enVar = enVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return enVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (en) invokeLL.objValue;
        }
    }

    public static byte[] b(in inVar, en enVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, inVar, enVar)) == null) {
            if (enVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            an.a a = an.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(xo.a(bArr));
            an c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            inVar.d(Integer.valueOf(dHGroupId));
            inVar.g(Integer.valueOf(dHSecret));
            inVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = qn.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = yo.b(ap.b(to.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            zm.a d2 = zm.d();
            d2.a(0);
            d2.b(xo.a(encrypt));
            linkedList.offer(d2.c());
            zm.a d3 = zm.d();
            d3.a(1);
            d3.b(xo.a(new byte[]{0}));
            linkedList.offer(d3.c());
            zm.a d4 = zm.d();
            d4.a(2);
            d4.b(xo.a(qn.d(dHGroupId)));
            linkedList.offer(d4.c());
            zm.a d5 = zm.d();
            d5.a(3);
            d5.b(xo.a(bytes));
            linkedList.offer(d5.c());
            if (vm.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            ym.a d6 = ym.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((zm) it.next());
            }
            d6.b(c);
            d6.c(xo.a(jn.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
