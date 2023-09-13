package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.jr;
import com.baidu.tieba.kr;
import com.baidu.tieba.lr;
import com.baidu.tieba.mr;
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
public class wr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static qr a(ur urVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, urVar, bArr)) == null) {
            qr qrVar = null;
            if (urVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                qr qrVar2 = new qr();
                try {
                    nr a = nr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    qrVar2.a(a);
                    List<lr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (lr lrVar : b) {
                        int a2 = lrVar.a();
                        byte[] b2 = lrVar.b();
                        if (a2 == 0) {
                            int a3 = cs.a(RSA.decrypt(b2));
                            urVar.e(DH.getDHSecretKey(a3, urVar.o().intValue(), urVar.p().intValue()));
                            urVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    jr.a d = jr.d();
                    d.a(a.e());
                    urVar.h(d.b().a());
                    if (urVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    urVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        urVar.j(a.d());
                        return qrVar2;
                    }
                    return qrVar2;
                } catch (Exception e) {
                    e = e;
                    qrVar = qrVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return qrVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (qr) invokeLL.objValue;
        }
    }

    public static byte[] b(ur urVar, qr qrVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, urVar, qrVar)) == null) {
            if (qrVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            mr.a a = mr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(jt.a(bArr));
            mr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            urVar.d(Integer.valueOf(dHGroupId));
            urVar.g(Integer.valueOf(dHSecret));
            urVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = cs.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = kt.b(mt.b(ft.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            lr.a d2 = lr.d();
            d2.a(0);
            d2.b(jt.a(encrypt));
            linkedList.offer(d2.c());
            lr.a d3 = lr.d();
            d3.a(1);
            d3.b(jt.a(new byte[]{0}));
            linkedList.offer(d3.c());
            lr.a d4 = lr.d();
            d4.a(2);
            d4.b(jt.a(cs.d(dHGroupId)));
            linkedList.offer(d4.c());
            lr.a d5 = lr.d();
            d5.a(3);
            d5.b(jt.a(bytes));
            linkedList.offer(d5.c());
            if (hr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            kr.a d6 = kr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((lr) it.next());
            }
            d6.b(c);
            d6.c(jt.a(vr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
