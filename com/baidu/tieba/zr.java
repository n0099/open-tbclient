package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.mr;
import com.baidu.tieba.nr;
import com.baidu.tieba.or;
import com.baidu.tieba.pr;
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
public class zr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static tr a(xr xrVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, xrVar, bArr)) == null) {
            tr trVar = null;
            if (xrVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                tr trVar2 = new tr();
                try {
                    qr a = qr.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    trVar2.a(a);
                    List<or> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (or orVar : b) {
                        int a2 = orVar.a();
                        byte[] b2 = orVar.b();
                        if (a2 == 0) {
                            int a3 = fs.a(RSA.decrypt(b2));
                            xrVar.e(DH.getDHSecretKey(a3, xrVar.o().intValue(), xrVar.p().intValue()));
                            xrVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    mr.a d = mr.d();
                    d.a(a.e());
                    xrVar.h(d.b().a());
                    if (xrVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    xrVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        xrVar.j(a.d());
                        return trVar2;
                    }
                    return trVar2;
                } catch (Exception e) {
                    e = e;
                    trVar = trVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return trVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (tr) invokeLL.objValue;
        }
    }

    public static byte[] b(xr xrVar, tr trVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, xrVar, trVar)) == null) {
            if (trVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            pr.a a = pr.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(mt.a(bArr));
            pr c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            xrVar.d(Integer.valueOf(dHGroupId));
            xrVar.g(Integer.valueOf(dHSecret));
            xrVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = fs.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = nt.b(pt.b(it.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            or.a d2 = or.d();
            d2.a(0);
            d2.b(mt.a(encrypt));
            linkedList.offer(d2.c());
            or.a d3 = or.d();
            d3.a(1);
            d3.b(mt.a(new byte[]{0}));
            linkedList.offer(d3.c());
            or.a d4 = or.d();
            d4.a(2);
            d4.b(mt.a(fs.d(dHGroupId)));
            linkedList.offer(d4.c());
            or.a d5 = or.d();
            d5.a(3);
            d5.b(mt.a(bytes));
            linkedList.offer(d5.c());
            if (kr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            nr.a d6 = nr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((or) it.next());
            }
            d6.b(c);
            d6.c(mt.a(yr.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
