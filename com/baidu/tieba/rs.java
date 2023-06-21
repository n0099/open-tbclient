package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.es;
import com.baidu.tieba.fs;
import com.baidu.tieba.gs;
import com.baidu.tieba.hs;
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
public class rs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ls a(ps psVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, psVar, bArr)) == null) {
            ls lsVar = null;
            if (psVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                ls lsVar2 = new ls();
                try {
                    is a = is.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    lsVar2.a(a);
                    List<gs> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (gs gsVar : b) {
                        int a2 = gsVar.a();
                        byte[] b2 = gsVar.b();
                        if (a2 == 0) {
                            int a3 = xs.a(RSA.decrypt(b2));
                            psVar.e(DH.getDHSecretKey(a3, psVar.o().intValue(), psVar.p().intValue()));
                            psVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    es.a d = es.d();
                    d.a(a.e());
                    psVar.h(d.b().a());
                    if (psVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    psVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        psVar.j(a.d());
                        return lsVar2;
                    }
                    return lsVar2;
                } catch (Exception e) {
                    e = e;
                    lsVar = lsVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return lsVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (ls) invokeLL.objValue;
        }
    }

    public static byte[] b(ps psVar, ls lsVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, psVar, lsVar)) == null) {
            if (lsVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            hs.a a = hs.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(eu.a(bArr));
            hs c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            psVar.d(Integer.valueOf(dHGroupId));
            psVar.g(Integer.valueOf(dHSecret));
            psVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = xs.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = fu.b(hu.b(au.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            gs.a d2 = gs.d();
            d2.a(0);
            d2.b(eu.a(encrypt));
            linkedList.offer(d2.c());
            gs.a d3 = gs.d();
            d3.a(1);
            d3.b(eu.a(new byte[]{0}));
            linkedList.offer(d3.c());
            gs.a d4 = gs.d();
            d4.a(2);
            d4.b(eu.a(xs.d(dHGroupId)));
            linkedList.offer(d4.c());
            gs.a d5 = gs.d();
            d5.a(3);
            d5.b(eu.a(bytes));
            linkedList.offer(d5.c());
            if (cs.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            fs.a d6 = fs.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((gs) it.next());
            }
            d6.b(c);
            d6.c(eu.a(qs.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
