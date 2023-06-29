package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.fs;
import com.baidu.tieba.gs;
import com.baidu.tieba.hs;
import com.baidu.tieba.is;
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
public class ss {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ms a(qs qsVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, qsVar, bArr)) == null) {
            ms msVar = null;
            if (qsVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                ms msVar2 = new ms();
                try {
                    js a = js.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    msVar2.a(a);
                    List<hs> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (hs hsVar : b) {
                        int a2 = hsVar.a();
                        byte[] b2 = hsVar.b();
                        if (a2 == 0) {
                            int a3 = ys.a(RSA.decrypt(b2));
                            qsVar.e(DH.getDHSecretKey(a3, qsVar.o().intValue(), qsVar.p().intValue()));
                            qsVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    fs.a d = fs.d();
                    d.a(a.e());
                    qsVar.h(d.b().a());
                    if (qsVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    qsVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        qsVar.j(a.d());
                        return msVar2;
                    }
                    return msVar2;
                } catch (Exception e) {
                    e = e;
                    msVar = msVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return msVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (ms) invokeLL.objValue;
        }
    }

    public static byte[] b(qs qsVar, ms msVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qsVar, msVar)) == null) {
            if (msVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            is.a a = is.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(fu.a(bArr));
            is c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            qsVar.d(Integer.valueOf(dHGroupId));
            qsVar.g(Integer.valueOf(dHSecret));
            qsVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = ys.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = gu.b(iu.b(bu.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            hs.a d2 = hs.d();
            d2.a(0);
            d2.b(fu.a(encrypt));
            linkedList.offer(d2.c());
            hs.a d3 = hs.d();
            d3.a(1);
            d3.b(fu.a(new byte[]{0}));
            linkedList.offer(d3.c());
            hs.a d4 = hs.d();
            d4.a(2);
            d4.b(fu.a(ys.d(dHGroupId)));
            linkedList.offer(d4.c());
            hs.a d5 = hs.d();
            d5.a(3);
            d5.b(fu.a(bytes));
            linkedList.offer(d5.c());
            if (ds.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            gs.a d6 = gs.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((hs) it.next());
            }
            d6.b(c);
            d6.c(fu.a(rs.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
