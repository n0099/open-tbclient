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
/* loaded from: classes7.dex */
public class pu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static lu3 a(ou3 ou3Var, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ou3Var, bArr)) == null) {
            lu3 lu3Var = null;
            if (ou3Var == null || bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                if (bArr[0] != 2) {
                    return null;
                }
                lu3 lu3Var2 = new lu3();
                try {
                    Bdtls$ServerHello parseFrom = Bdtls$ServerHello.parseFrom(Arrays.copyOfRange(bArr, 1, bArr.length));
                    if (parseFrom == null) {
                        return null;
                    }
                    lu3Var2.a(parseFrom);
                    List<Bdtls$Extension> extensionsList = parseFrom.getExtensionsList();
                    if (extensionsList == null) {
                        return null;
                    }
                    for (Bdtls$Extension bdtls$Extension : extensionsList) {
                        int type = bdtls$Extension.getType();
                        byte[] byteArray = bdtls$Extension.getData().toByteArray();
                        if (type == 0) {
                            byte[] decrypt = RSA.decrypt(byteArray);
                            int a = du3.a(decrypt);
                            byte[] dHSecretKey = DH.getDHSecretKey(a, ou3Var.d().intValue(), ou3Var.f().intValue());
                            ou3Var.l(dHSecretKey);
                            ou3Var.p(Integer.valueOf(a));
                            if (zt3.a) {
                                Log.d("BDTLS", "GroupId=" + ou3Var.d());
                                Log.d("BDTLS", "client dh pubkey secret=" + ou3Var.f());
                                Log.d("BDTLS", "client dh pubkey=" + ou3Var.e());
                                Log.d("BDTLS", "server dh pubkey=" + a);
                                Log.d("BDTLS", "server dh raw pubkey=" + du3.d(decrypt));
                                Log.d("BDTLS", "aeskey=" + du3.d(dHSecretKey));
                            }
                        }
                    }
                    if (parseFrom.getSKR() == null) {
                        return null;
                    }
                    Bdtls$ApplicationData.b newBuilder = Bdtls$ApplicationData.newBuilder();
                    newBuilder.u(parseFrom.getSKR());
                    Bdtls$ApplicationData build = newBuilder.build();
                    ou3Var.t(build.toByteArray());
                    if (ou3Var.c() == null) {
                        return null;
                    }
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) + parseFrom.getLifeTime();
                    if (zt3.a) {
                        Log.d("BDTLS", "liftTime=" + parseFrom.getLifeTime());
                        Log.d("BDTLS", "expireTime=" + currentTimeMillis);
                    }
                    ou3Var.r(currentTimeMillis);
                    if (parseFrom.getCipherSuite() != null) {
                        ou3Var.q(parseFrom.getCipherSuite().toByteArray());
                    }
                    if (b53.c()) {
                        new ku3().edit().putString("secretKey", Arrays.toString(ou3Var.c())).putString("sessionTicket", String.valueOf(build)).putLong("expireTime", currentTimeMillis).apply();
                        return lu3Var2;
                    }
                    return lu3Var2;
                } catch (Exception e) {
                    e = e;
                    lu3Var = lu3Var2;
                    if (zt3.a) {
                        e.printStackTrace();
                        Log.d("BDTLS", "exception=" + e.getMessage());
                    }
                    return lu3Var;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (lu3) invokeLL.objValue;
        }
    }

    public static byte[] b(ou3 ou3Var, lu3 lu3Var) {
        InterceptResult invokeLL;
        byte[] encrypt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ou3Var, lu3Var)) == null) {
            if (lu3Var == null) {
                return null;
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            byte[] bArr = new byte[32];
            new Random().nextBytes(bArr);
            Bdtls$Random.b newBuilder = Bdtls$Random.newBuilder();
            newBuilder.v(currentTimeMillis);
            newBuilder.w(ByteString.copyFrom(bArr));
            Bdtls$Random build = newBuilder.build();
            int dHGroupId = DH.getDHGroupId();
            int dHSecret = DH.getDHSecret();
            int dHPublicKey = DH.getDHPublicKey(dHGroupId, dHSecret);
            ou3Var.m(Integer.valueOf(dHGroupId));
            ou3Var.o(Integer.valueOf(dHSecret));
            ou3Var.n(Integer.valueOf(dHPublicKey));
            byte[] g = du3.g(dHPublicKey);
            if (g == null || (encrypt = RSA.encrypt(g)) == null) {
                return null;
            }
            byte[] bytes = jr4.a(Certificate.getSignature(ku2.c()), "", false).getBytes(StandardCharsets.UTF_8);
            LinkedList linkedList = new LinkedList();
            Bdtls$Extension.b newBuilder2 = Bdtls$Extension.newBuilder();
            newBuilder2.v(0);
            newBuilder2.u(ByteString.copyFrom(encrypt));
            linkedList.offer(newBuilder2.build());
            Bdtls$Extension.b newBuilder3 = Bdtls$Extension.newBuilder();
            newBuilder3.v(1);
            newBuilder3.u(ByteString.copyFrom(new byte[]{0}));
            linkedList.offer(newBuilder3.build());
            Bdtls$Extension.b newBuilder4 = Bdtls$Extension.newBuilder();
            newBuilder4.v(2);
            newBuilder4.u(ByteString.copyFrom(du3.g(dHGroupId)));
            linkedList.offer(newBuilder4.build());
            Bdtls$Extension.b newBuilder5 = Bdtls$Extension.newBuilder();
            newBuilder5.v(3);
            newBuilder5.u(ByteString.copyFrom(bytes));
            linkedList.offer(newBuilder5.build());
            if (b53.c()) {
                if (yu3.getContext() != null) {
                    Bdtls$Extension.b newBuilder6 = Bdtls$Extension.newBuilder();
                    newBuilder6.v(4);
                    newBuilder6.u(ByteString.copyFrom(yu3.getContext().b().getBytes()));
                    linkedList.offer(newBuilder6.build());
                }
                if (yu3.getContext() != null) {
                    Bdtls$Extension.b newBuilder7 = Bdtls$Extension.newBuilder();
                    newBuilder7.v(5);
                    newBuilder7.u(ByteString.copyFrom(er4.f().getBytes()));
                    linkedList.offer(newBuilder7.build());
                }
            }
            if (zt3.a) {
                Log.d("BDTLS", "groupId encode=" + dHGroupId);
                Log.d("BDTLS", "secretC encode=" + dHSecret);
                Log.d("BDTLS", "pubKey encode=" + dHPublicKey);
                Log.d("BDTLS", "signature encode=" + new String(bytes));
            }
            Bdtls$ClientHello.b newBuilder8 = Bdtls$ClientHello.newBuilder();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                newBuilder8.m((Bdtls$Extension) it.next());
            }
            newBuilder8.B(build);
            newBuilder8.l(ByteString.copyFrom(au3.c));
            byte[] byteArray = newBuilder8.build().toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 1);
            allocate.put((byte) 1);
            allocate.put(byteArray);
            return allocate.array();
        }
        return (byte[]) invokeLL.objValue;
    }
}
