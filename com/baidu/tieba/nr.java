package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.ar;
import com.baidu.tieba.br;
import com.baidu.tieba.cr;
import com.baidu.tieba.dr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public class nr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static hr a(lr lrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, lrVar, bArr)) == null) {
            hr hrVar = null;
            if (lrVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                hr hrVar2 = new hr();
                try {
                    er a = er.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    hrVar2.a(a);
                    List<cr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (cr crVar : b) {
                        int a2 = crVar.a();
                        byte[] b2 = crVar.b();
                        if (a2 == 0) {
                            int a3 = tr.a(RSA.decrypt(b2));
                            lrVar.e(DH.getDHSecretKey(a3, lrVar.o().intValue(), lrVar.p().intValue()));
                            lrVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    ar.a d = ar.d();
                    d.a(a.e());
                    lrVar.h(d.b().a());
                    if (lrVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    lrVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        lrVar.j(a.d());
                        return hrVar2;
                    }
                    return hrVar2;
                } catch (Exception e) {
                    e = e;
                    hrVar = hrVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return hrVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (hr) invokeLL.objValue;
        }
    }

    public static byte[] b(lr lrVar, hr hrVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, lrVar, hrVar)) == null) {
            if (hrVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            dr.a a = dr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(at.a(bArr));
            dr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            lrVar.d(Integer.valueOf(dHGroupId));
            lrVar.g(Integer.valueOf(dHSecret));
            lrVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = tr.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = bt.b(dt.b(ws.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            cr.a d2 = cr.d();
            d2.a(0);
            d2.b(at.a(encrypt));
            linkedList.offer(d2.c());
            cr.a d3 = cr.d();
            d3.a(1);
            d3.b(at.a(new byte[]{0}));
            linkedList.offer(d3.c());
            cr.a d4 = cr.d();
            d4.a(2);
            d4.b(at.a(tr.d(dHGroupId)));
            linkedList.offer(d4.c());
            cr.a d5 = cr.d();
            d5.a(3);
            d5.b(at.a(bytes));
            linkedList.offer(d5.c());
            if (yq.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            br.a d6 = br.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((cr) it.next());
            }
            d6.b(c);
            d6.c(at.a(mr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
