package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.gs;
import com.baidu.tieba.hs;
import com.baidu.tieba.is;
import com.baidu.tieba.js;
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
public class ts {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ns a(rs rsVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, rsVar, bArr)) == null) {
            ns nsVar = null;
            if (rsVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                ns nsVar2 = new ns();
                try {
                    ks a = ks.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    nsVar2.a(a);
                    List<is> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (is isVar : b) {
                        int a2 = isVar.a();
                        byte[] b2 = isVar.b();
                        if (a2 == 0) {
                            int a3 = zs.a(RSA.decrypt(b2));
                            rsVar.e(DH.getDHSecretKey(a3, rsVar.o().intValue(), rsVar.p().intValue()));
                            rsVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    gs.a d = gs.d();
                    d.a(a.e());
                    rsVar.h(d.b().a());
                    if (rsVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    rsVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        rsVar.j(a.d());
                        return nsVar2;
                    }
                    return nsVar2;
                } catch (Exception e) {
                    e = e;
                    nsVar = nsVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return nsVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (ns) invokeLL.objValue;
        }
    }

    public static byte[] b(rs rsVar, ns nsVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, rsVar, nsVar)) == null) {
            if (nsVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            js.a a = js.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(gu.a(bArr));
            js c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            rsVar.d(Integer.valueOf(dHGroupId));
            rsVar.g(Integer.valueOf(dHSecret));
            rsVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = zs.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = hu.b(ju.b(cu.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            is.a d2 = is.d();
            d2.a(0);
            d2.b(gu.a(encrypt));
            linkedList.offer(d2.c());
            is.a d3 = is.d();
            d3.a(1);
            d3.b(gu.a(new byte[]{0}));
            linkedList.offer(d3.c());
            is.a d4 = is.d();
            d4.a(2);
            d4.b(gu.a(zs.d(dHGroupId)));
            linkedList.offer(d4.c());
            is.a d5 = is.d();
            d5.a(3);
            d5.b(gu.a(bytes));
            linkedList.offer(d5.c());
            if (es.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            hs.a d6 = hs.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((is) it.next());
            }
            d6.b(c);
            d6.c(gu.a(ss.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
