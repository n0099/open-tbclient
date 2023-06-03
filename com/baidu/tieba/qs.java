package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.ds;
import com.baidu.tieba.es;
import com.baidu.tieba.fs;
import com.baidu.tieba.gs;
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
public class qs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ks a(os osVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, osVar, bArr)) == null) {
            ks ksVar = null;
            if (osVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                ks ksVar2 = new ks();
                try {
                    hs a = hs.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    ksVar2.a(a);
                    List<fs> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (fs fsVar : b) {
                        int a2 = fsVar.a();
                        byte[] b2 = fsVar.b();
                        if (a2 == 0) {
                            int a3 = ws.a(RSA.decrypt(b2));
                            osVar.e(DH.getDHSecretKey(a3, osVar.o().intValue(), osVar.p().intValue()));
                            osVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    ds.a d = ds.d();
                    d.a(a.e());
                    osVar.h(d.b().a());
                    if (osVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    osVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        osVar.j(a.d());
                        return ksVar2;
                    }
                    return ksVar2;
                } catch (Exception e) {
                    e = e;
                    ksVar = ksVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return ksVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (ks) invokeLL.objValue;
        }
    }

    public static byte[] b(os osVar, ks ksVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, osVar, ksVar)) == null) {
            if (ksVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            gs.a a = gs.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(du.a(bArr));
            gs c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            osVar.d(Integer.valueOf(dHGroupId));
            osVar.g(Integer.valueOf(dHSecret));
            osVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = ws.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = eu.b(gu.b(zt.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            fs.a d2 = fs.d();
            d2.a(0);
            d2.b(du.a(encrypt));
            linkedList.offer(d2.c());
            fs.a d3 = fs.d();
            d3.a(1);
            d3.b(du.a(new byte[]{0}));
            linkedList.offer(d3.c());
            fs.a d4 = fs.d();
            d4.a(2);
            d4.b(du.a(ws.d(dHGroupId)));
            linkedList.offer(d4.c());
            fs.a d5 = fs.d();
            d5.a(3);
            d5.b(du.a(bytes));
            linkedList.offer(d5.c());
            if (bs.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            es.a d6 = es.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((fs) it.next());
            }
            d6.b(c);
            d6.c(du.a(ps.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
