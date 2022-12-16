package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.bdtls.Certificate;
import com.baidu.swan.bdtls.DH;
import com.baidu.swan.bdtls.RSA;
import com.baidu.swan.bdtls.impl.model.Bdtls$ApplicationData;
import com.baidu.swan.bdtls.impl.model.Bdtls$ClientHello;
import com.baidu.swan.bdtls.impl.model.Bdtls$Extension;
import com.baidu.swan.bdtls.impl.model.Bdtls$Random;
import com.baidu.swan.bdtls.impl.model.Bdtls$ServerHello;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public class qn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mn3 a(pn3 pn3Var, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, pn3Var, bArr)) == null) {
            mn3 mn3Var = null;
            if (pn3Var == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                mn3 mn3Var2 = new mn3();
                try {
                    Bdtls$ServerHello parseFrom = Bdtls$ServerHello.parseFrom(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (parseFrom == null) {
                        return null;
                    }
                    mn3Var2.a(parseFrom);
                    List<Bdtls$Extension> extensionsList = parseFrom.getExtensionsList();
                    if (extensionsList == null) {
                        return null;
                    }
                    for (Bdtls$Extension bdtls$Extension : extensionsList) {
                        int type = bdtls$Extension.getType();
                        byte[] byteArray = bdtls$Extension.getData().toByteArray();
                        if (type == 0) {
                            byte[] decrypt = RSA.decrypt(byteArray);
                            int a = en3.a(decrypt);
                            byte[] dHSecretKey = DH.getDHSecretKey(a, pn3Var.d().intValue(), pn3Var.f().intValue());
                            pn3Var.l(dHSecretKey);
                            pn3Var.p(Integer.valueOf(a));
                            if (an3.a) {
                                Log.d("BDTLS", "GroupId=" + pn3Var.d());
                                Log.d("BDTLS", "client dh pubkey secret=" + pn3Var.f());
                                Log.d("BDTLS", "client dh pubkey=" + pn3Var.e());
                                Log.d("BDTLS", "server dh pubkey=" + a);
                                Log.d("BDTLS", "server dh raw pubkey=" + en3.d(decrypt));
                                Log.d("BDTLS", "aeskey=" + en3.d(dHSecretKey));
                            }
                        }
                    }
                    if (parseFrom.getSKR() == null) {
                        return null;
                    }
                    Bdtls$ApplicationData.b newBuilder = Bdtls$ApplicationData.newBuilder();
                    newBuilder.v(parseFrom.getSKR());
                    Bdtls$ApplicationData build = newBuilder.build();
                    pn3Var.t(build.toByteArray());
                    if (pn3Var.c() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                    if (an3.a) {
                        Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                        Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                    }
                    pn3Var.r(currentTimeMillis);
                    if (parseFrom.getCipherSuite() != null) {
                        pn3Var.q(parseFrom.getCipherSuite().toByteArray());
                    }
                    if (cy2.c()) {
                        new ln3().edit().putString("secretKey", Arrays.toString(pn3Var.c())).putString("sessionTicket", String.valueOf(build)).putLong("expireTime", currentTimeMillis).apply();
                        return mn3Var2;
                    }
                    return mn3Var2;
                } catch (Exception e) {
                    e = e;
                    mn3Var = mn3Var2;
                    if (an3.a) {
                        e.printStackTrace();
                        Log.d("BDTLS", "exception=" + e.getMessage());
                    }
                    return mn3Var;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (mn3) invokeLL.objValue;
        }
    }

    public static byte[] b(pn3 pn3Var, mn3 mn3Var) {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pn3Var, mn3Var)) == null) {
            if (mn3Var == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder();
            newBuilder.w(currentTimeMillis);
            newBuilder.x(ByteString.copyFrom(bArr));
            Bdtls$Random build = newBuilder.build();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            pn3Var.m(Integer.valueOf(dHGroupId));
            pn3Var.o(Integer.valueOf(dHSecret));
            pn3Var.n(Integer.valueOf(dHPublicKey));
            byte[] g = en3.g(dHPublicKey);
            if (g == null || (encrypt = RSA.encrypt(g)) == null) {
                return null;
            }
            byte[] bytes = kk4.a(Certificate.getSignature(ln2.c()), "", false).getBytes(StandardCharsets.UTF_8);
            LinkedList linkedList = new LinkedList();
            Bdtls$Extension.b newBuilder2 = Bdtls$Extension.newBuilder();
            newBuilder2.w(0);
            newBuilder2.v(ByteString.copyFrom(encrypt));
            linkedList.offer(newBuilder2.build());
            Bdtls$Extension.b newBuilder3 = Bdtls$Extension.newBuilder();
            newBuilder3.w(1);
            newBuilder3.v(ByteString.copyFrom(new byte[]{0}));
            linkedList.offer(newBuilder3.build());
            Bdtls$Extension.b newBuilder4 = Bdtls$Extension.newBuilder();
            newBuilder4.w(2);
            newBuilder4.v(ByteString.copyFrom(en3.g(dHGroupId)));
            linkedList.offer(newBuilder4.build());
            Bdtls$Extension.b newBuilder5 = Bdtls$Extension.newBuilder();
            newBuilder5.w(3);
            newBuilder5.v(ByteString.copyFrom(bytes));
            linkedList.offer(newBuilder5.build());
            if (cy2.c()) {
                if (zn3.getContext() != null) {
                    Bdtls$Extension.b newBuilder6 = Bdtls$Extension.newBuilder();
                    newBuilder6.w(4);
                    newBuilder6.v(ByteString.copyFrom(zn3.getContext().b().getBytes()));
                    linkedList.offer(newBuilder6.build());
                }
                if (zn3.getContext() != null) {
                    Bdtls$Extension.b newBuilder7 = Bdtls$Extension.newBuilder();
                    newBuilder7.w(5);
                    newBuilder7.v(ByteString.copyFrom(fk4.f().getBytes()));
                    linkedList.offer(newBuilder7.build());
                }
            }
            if (an3.a) {
                Log.d("BDTLS", "groupId encode=" + dHGroupId);
                Log.d("BDTLS", "secretC encode=" + dHSecret);
                Log.d("BDTLS", "pubKey encode=" + dHPublicKey);
                Log.d("BDTLS", "signature encode=" + new String(bytes));
            }
            Bdtls$ClientHello.b newBuilder8 = Bdtls$ClientHello.newBuilder();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                newBuilder8.n((Bdtls$Extension) it.next());
            }
            newBuilder8.C(build);
            newBuilder8.m(ByteString.copyFrom(bn3.c));
            byte[] byteArray = newBuilder8.build().toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
            allocate.put((byte) 1);
            allocate.put(byteArray);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
