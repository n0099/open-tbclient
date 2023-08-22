package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.ir;
import com.baidu.tieba.jr;
import com.baidu.tieba.kr;
import com.baidu.tieba.lr;
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
public class vr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static pr a(tr trVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, trVar, bArr)) == null) {
            pr prVar = null;
            if (trVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                pr prVar2 = new pr();
                try {
                    mr a = mr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    prVar2.a(a);
                    List<kr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (kr krVar : b) {
                        int a2 = krVar.a();
                        byte[] b2 = krVar.b();
                        if (a2 == 0) {
                            int a3 = bs.a(RSA.decrypt(b2));
                            trVar.e(DH.getDHSecretKey(a3, trVar.o().intValue(), trVar.p().intValue()));
                            trVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    ir.a d = ir.d();
                    d.a(a.e());
                    trVar.h(d.b().a());
                    if (trVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    trVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        trVar.j(a.d());
                        return prVar2;
                    }
                    return prVar2;
                } catch (Exception e) {
                    e = e;
                    prVar = prVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return prVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (pr) invokeLL.objValue;
        }
    }

    public static byte[] b(tr trVar, pr prVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, trVar, prVar)) == null) {
            if (prVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            lr.a a = lr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(it.a(bArr));
            lr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            trVar.d(Integer.valueOf(dHGroupId));
            trVar.g(Integer.valueOf(dHSecret));
            trVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = bs.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = jt.b(lt.b(et.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            kr.a d2 = kr.d();
            d2.a(0);
            d2.b(it.a(encrypt));
            linkedList.offer(d2.c());
            kr.a d3 = kr.d();
            d3.a(1);
            d3.b(it.a(new byte[]{0}));
            linkedList.offer(d3.c());
            kr.a d4 = kr.d();
            d4.a(2);
            d4.b(it.a(bs.d(dHGroupId)));
            linkedList.offer(d4.c());
            kr.a d5 = kr.d();
            d5.a(3);
            d5.b(it.a(bytes));
            linkedList.offer(d5.c());
            if (gr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            jr.a d6 = jr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((kr) it.next());
            }
            d6.b(c);
            d6.c(it.a(ur.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
