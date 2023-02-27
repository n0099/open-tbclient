package com.baidu.tieba;

import com.baidu.bdptask.bdtls.DH;
import com.baidu.bdptask.bdtls.RSA;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tieba.as;
import com.baidu.tieba.xr;
import com.baidu.tieba.yr;
import com.baidu.tieba.zr;
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
public class ks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static es a(is isVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, isVar, bArr)) == null) {
            es esVar = null;
            if (isVar == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                es esVar2 = new es();
                try {
                    bs a = bs.a(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (a == null) {
                        return null;
                    }
                    esVar2.a(a);
                    List<zr> b = a.b();
                    if (b == null) {
                        return null;
                    }
                    for (zr zrVar : b) {
                        int a2 = zrVar.a();
                        byte[] b2 = zrVar.b();
                        if (a2 == 0) {
                            int a3 = qs.a(RSA.decrypt(b2));
                            isVar.e(DH.getDHSecretKey(a3, isVar.o().intValue(), isVar.p().intValue()));
                            isVar.l(Integer.valueOf(a3));
                        }
                    }
                    if (a.e() == null) {
                        return null;
                    }
                    xr.a d = xr.d();
                    d.a(a.e());
                    isVar.h(d.b().a());
                    if (isVar.q() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + a.c();
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("liftTime=" + a.c());
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("expireTime=" + currentTimeMillis);
                    isVar.c(currentTimeMillis);
                    if (a.d() != null) {
                        isVar.j(a.d());
                        return esVar2;
                    }
                    return esVar2;
                } catch (Exception e) {
                    e = e;
                    esVar = esVar2;
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e.getMessage());
                    return esVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (es) invokeLL.objValue;
        }
    }

    public static byte[] b(is isVar, es esVar) throws Exception {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, isVar, esVar)) == null) {
            if (esVar == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            as.a a = as.a();
            a.a(Integer.valueOf(currentTimeMillis));
            a.b(xt.a(bArr));
            as c = a.c();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            isVar.d(Integer.valueOf(dHGroupId));
            isVar.g(Integer.valueOf(dHSecret));
            isVar.i(Integer.valueOf(dHPublicKey));
            byte[] d = qs.d(dHPublicKey);
            if (d == null || (encrypt = RSA.encrypt(d)) == null) {
                return null;
            }
            byte[] bytes = yt.b(au.b(tt.a()), false).getBytes();
            LinkedList linkedList = new LinkedList();
            zr.a d2 = zr.d();
            d2.a(0);
            d2.b(xt.a(encrypt));
            linkedList.offer(d2.c());
            zr.a d3 = zr.d();
            d3.a(1);
            d3.b(xt.a(new byte[]{0}));
            linkedList.offer(d3.c());
            zr.a d4 = zr.d();
            d4.a(2);
            d4.b(xt.a(qs.d(dHGroupId)));
            linkedList.offer(d4.c());
            zr.a d5 = zr.d();
            d5.a(3);
            d5.b(xt.a(bytes));
            linkedList.offer(d5.c());
            if (vr.c.h().c()) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("groupId encode=" + dHGroupId);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("secretC encode=" + dHSecret);
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("pubKey encode=" + dHPublicKey);
                DebugTrace debugTrace4 = DebugTrace.a;
                debugTrace4.a("signature encode=" + new String(bytes));
            }
            yr.a d6 = yr.d();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d6.a((zr) it.next());
            }
            d6.b(c);
            d6.c(xt.a(js.a));
            byte[] a2 = d6.d().a();
            ByteBuffer allocate = ByteBuffer.allocate(a2.length + 1);
            allocate.put((byte) 1);
            allocate.put(a2);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
