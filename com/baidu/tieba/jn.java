package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.wm;
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
/* loaded from: classes6.dex */
public class jn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static dn a(hn hnVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, hnVar, bArr)) == null) {
            dn dnVar = null;
            if (hnVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                dn dnVar2 = new dn();
                try {
                    an a = an.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    dnVar2.a(a);
                    List<ym> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (ym ymVar : b) {
                        int a2 = ymVar.a();
                        byte[] b2 = ymVar.b();
                        if (a2 == 0) {
                            int a3 = pn.a(RSA.decrypt(b2));
                            hnVar.e(DH.getDHSecretKey(a3, hnVar.o().intValue(), hnVar.p().intValue()));
                            hnVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    wm.a d = wm.d();
                    d.a(a.e());
                    hnVar.h(d.b().a());
                    if (hnVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    hnVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        hnVar.j(a.d());
                        return dnVar2;
                    }
                    return dnVar2;
                } catch (Exception e) {
                    e = e;
                    dnVar = dnVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return dnVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (dn) invokeLL.objValue;
        }
    }

    public static byte[] b(hn hnVar, dn dnVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, hnVar, dnVar)) == null) {
            if (dnVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            zm.a a = zm.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(wo.a(bArr));
            zm c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            hnVar.d(Integer.valueOf(dHGroupId));
            hnVar.g(Integer.valueOf(dHSecret));
            hnVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = pn.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = xo.b(zo.b(so.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            ym.a d2 = ym.d();
            d2.a(0);
            d2.b(wo.a(encrypt));
            linkedList.offer(d2.c());
            ym.a d3 = ym.d();
            d3.a(1);
            d3.b(wo.a(new byte[]{0}));
            linkedList.offer(d3.c());
            ym.a d4 = ym.d();
            d4.a(2);
            d4.b(wo.a(pn.d(dHGroupId)));
            linkedList.offer(d4.c());
            ym.a d5 = ym.d();
            d5.a(3);
            d5.b(wo.a(bytes));
            linkedList.offer(d5.c());
            if (um.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            xm.a d6 = xm.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((ym) it.next());
            }
            d6.b(c);
            d6.c(wo.a(in.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
