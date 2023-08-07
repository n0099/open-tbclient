package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.fr;
import com.baidu.tieba.gr;
import com.baidu.tieba.hr;
import com.baidu.tieba.ir;
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
public class sr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mr a(qr qrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, qrVar, bArr)) == null) {
            mr mrVar = null;
            if (qrVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                mr mrVar2 = new mr();
                try {
                    jr a = jr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    mrVar2.a(a);
                    List<hr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (hr hrVar : b) {
                        int a2 = hrVar.a();
                        byte[] b2 = hrVar.b();
                        if (a2 == 0) {
                            int a3 = yr.a(RSA.decrypt(b2));
                            qrVar.e(DH.getDHSecretKey(a3, qrVar.o().intValue(), qrVar.p().intValue()));
                            qrVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    fr.a d = fr.d();
                    d.a(a.e());
                    qrVar.h(d.b().a());
                    if (qrVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    qrVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        qrVar.j(a.d());
                        return mrVar2;
                    }
                    return mrVar2;
                } catch (Exception e) {
                    e = e;
                    mrVar = mrVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return mrVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (mr) invokeLL.objValue;
        }
    }

    public static byte[] b(qr qrVar, mr mrVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qrVar, mrVar)) == null) {
            if (mrVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            ir.a a = ir.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(ft.a(bArr));
            ir c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            qrVar.d(Integer.valueOf(dHGroupId));
            qrVar.g(Integer.valueOf(dHSecret));
            qrVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = yr.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = gt.b(it.b(bt.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            hr.a d2 = hr.d();
            d2.a(0);
            d2.b(ft.a(encrypt));
            linkedList.offer(d2.c());
            hr.a d3 = hr.d();
            d3.a(1);
            d3.b(ft.a(new byte[]{0}));
            linkedList.offer(d3.c());
            hr.a d4 = hr.d();
            d4.a(2);
            d4.b(ft.a(yr.d(dHGroupId)));
            linkedList.offer(d4.c());
            hr.a d5 = hr.d();
            d5.a(3);
            d5.b(ft.a(bytes));
            linkedList.offer(d5.c());
            if (dr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            gr.a d6 = gr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((hr) it.next());
            }
            d6.b(c);
            d6.c(ft.a(rr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
