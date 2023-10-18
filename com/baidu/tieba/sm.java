package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.fm;
import com.baidu.tieba.gm;
import com.baidu.tieba.hm;
import com.baidu.tieba.im;
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
public class sm {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mm a(qm qmVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, qmVar, bArr)) == null) {
            mm mmVar = null;
            if (qmVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                mm mmVar2 = new mm();
                try {
                    jm a = jm.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    mmVar2.a(a);
                    List<hm> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (hm hmVar : b) {
                        int a2 = hmVar.a();
                        byte[] b2 = hmVar.b();
                        if (a2 == 0) {
                            int a3 = ym.a(RSA.decrypt(b2));
                            qmVar.e(DH.getDHSecretKey(a3, qmVar.o().intValue(), qmVar.p().intValue()));
                            qmVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    fm.a d = fm.d();
                    d.a(a.e());
                    qmVar.h(d.b().a());
                    if (qmVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    qmVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        qmVar.j(a.d());
                        return mmVar2;
                    }
                    return mmVar2;
                } catch (Exception e) {
                    e = e;
                    mmVar = mmVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return mmVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (mm) invokeLL.objValue;
        }
    }

    public static byte[] b(qm qmVar, mm mmVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qmVar, mmVar)) == null) {
            if (mmVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            im.a a = im.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(fo.a(bArr));
            im c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            qmVar.d(Integer.valueOf(dHGroupId));
            qmVar.g(Integer.valueOf(dHSecret));
            qmVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = ym.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = go.b(io.b(bo.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            hm.a d2 = hm.d();
            d2.a(0);
            d2.b(fo.a(encrypt));
            linkedList.offer(d2.c());
            hm.a d3 = hm.d();
            d3.a(1);
            d3.b(fo.a(new byte[]{0}));
            linkedList.offer(d3.c());
            hm.a d4 = hm.d();
            d4.a(2);
            d4.b(fo.a(ym.d(dHGroupId)));
            linkedList.offer(d4.c());
            hm.a d5 = hm.d();
            d5.a(3);
            d5.b(fo.a(bytes));
            linkedList.offer(d5.c());
            if (dm.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            gm.a d6 = gm.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((hm) it.next());
            }
            d6.b(c);
            d6.c(fo.a(rm.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
