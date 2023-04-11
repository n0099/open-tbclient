package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.br;
import com.baidu.tieba.cr;
import com.baidu.tieba.dr;
import com.baidu.tieba.er;
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
public class or {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ir a(mr mrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, mrVar, bArr)) == null) {
            ir irVar = null;
            if (mrVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                ir irVar2 = new ir();
                try {
                    fr a = fr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    irVar2.a(a);
                    List<dr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (dr drVar : b) {
                        int a2 = drVar.a();
                        byte[] b2 = drVar.b();
                        if (a2 == 0) {
                            int a3 = ur.a(RSA.decrypt(b2));
                            mrVar.e(DH.getDHSecretKey(a3, mrVar.o().intValue(), mrVar.p().intValue()));
                            mrVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    br.a d = br.d();
                    d.a(a.e());
                    mrVar.h(d.b().a());
                    if (mrVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    mrVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        mrVar.j(a.d());
                        return irVar2;
                    }
                    return irVar2;
                } catch (Exception e) {
                    e = e;
                    irVar = irVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return irVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (ir) invokeLL.objValue;
        }
    }

    public static byte[] b(mr mrVar, ir irVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, mrVar, irVar)) == null) {
            if (irVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            er.a a = er.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(bt.a(bArr));
            er c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            mrVar.d(Integer.valueOf(dHGroupId));
            mrVar.g(Integer.valueOf(dHSecret));
            mrVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = ur.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = ct.b(et.b(xs.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            dr.a d2 = dr.d();
            d2.a(0);
            d2.b(bt.a(encrypt));
            linkedList.offer(d2.c());
            dr.a d3 = dr.d();
            d3.a(1);
            d3.b(bt.a(new byte[]{0}));
            linkedList.offer(d3.c());
            dr.a d4 = dr.d();
            d4.a(2);
            d4.b(bt.a(ur.d(dHGroupId)));
            linkedList.offer(d4.c());
            dr.a d5 = dr.d();
            d5.a(3);
            d5.b(bt.a(bytes));
            linkedList.offer(d5.c());
            if (zq.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            cr.a d6 = cr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((dr) it.next());
            }
            d6.b(c);
            d6.c(bt.a(nr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
