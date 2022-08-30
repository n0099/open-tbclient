package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.er;
import com.baidu.tieba.fr;
import com.baidu.tieba.gr;
import com.baidu.tieba.hr;
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
public class rr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static lr a(pr prVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, prVar, bArr)) != null) {
            return (lr) invokeLL.objValue;
        }
        lr lrVar = null;
        if (prVar == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            if (bArr[0] != 2) {
                return null;
            }
            lr lrVar2 = new lr();
            try {
                ir a = ir.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                if (a == null) {
                    return null;
                }
                lrVar2.a(a);
                List<gr> b = a.b();
                if (b == null) {
                    return null;
                }
                for (gr grVar : b) {
                    int a2 = grVar.a();
                    byte[] b2 = grVar.b();
                    if (a2 == 0) {
                        int a3 = xr.a(RSA.decrypt(b2));
                        prVar.e(DH.getDHSecretKey(a3, prVar.o().intValue(), prVar.p().intValue()));
                        prVar.l(Integer.valueOf(a3));
                    }
                }
                if (a.e() == null) {
                    return null;
                }
                er.a d = er.d();
                d.a(a.e());
                prVar.h(d.b().a());
                if (prVar.q() == null) {
                    return null;
                }
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("liftTime=" + a.c());
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("expireTime=" + currentTimeMillis);
                prVar.c(currentTimeMillis);
                if (a.d() != null) {
                    prVar.j(a.d());
                    return lrVar2;
                }
                return lrVar2;
            } catch (Exception e) {
                e = e;
                lrVar = lrVar2;
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                return lrVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static byte[] b(pr prVar, lr lrVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, prVar, lrVar)) == null) {
            if (lrVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            hr.a a = hr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(et.a(bArr));
            hr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            prVar.d(Integer.valueOf(dHGroupId));
            prVar.g(Integer.valueOf(dHSecret));
            prVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = xr.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = ft.b(ht.b(at.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            gr.a d2 = gr.d();
            d2.a(0);
            d2.b(et.a(encrypt));
            linkedList.offer(d2.c());
            gr.a d3 = gr.d();
            d3.a(1);
            d3.b(et.a(new byte[]{0}));
            linkedList.offer(d3.c());
            gr.a d4 = gr.d();
            d4.a(2);
            d4.b(et.a(xr.d(dHGroupId)));
            linkedList.offer(d4.c());
            gr.a d5 = gr.d();
            d5.a(3);
            d5.b(et.a(bytes));
            linkedList.offer(d5.c());
            if (cr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            fr.a d6 = fr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((gr) it.next());
            }
            d6.b(c);
            d6.c(et.a(qr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
