package com.bytedance.pangle.f;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
@RequiresApi(api = 21)
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final X509Certificate[][] a;
        public final byte[] b;

        public a(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509CertificateArr, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x509CertificateArr;
            this.b = bArr;
        }
    }

    public static a a(RandomAccessFile randomAccessFile, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, randomAccessFile, mVar)) == null) {
            ArrayMap arrayMap = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                try {
                    ByteBuffer a2 = f.a(mVar.a);
                    int i = 0;
                    while (a2.hasRemaining()) {
                        i++;
                        try {
                            arrayList.add(a(f.a(a2), arrayMap, certificateFactory));
                        } catch (IOException | SecurityException | BufferUnderflowException e) {
                            throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                        }
                    }
                    if (i > 0) {
                        if (!arrayMap.isEmpty()) {
                            f.a(arrayMap, randomAccessFile, mVar);
                            byte[] bArr = null;
                            if (arrayMap.containsKey(3)) {
                                bArr = f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                            }
                            return new a((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]), bArr);
                        }
                        throw new SecurityException("No content digests found");
                    }
                    throw new SecurityException("No signers found");
                } catch (IOException e2) {
                    throw new SecurityException("Failed to read list of signers", e2);
                }
            } catch (CertificateException e3) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
            }
        }
        return (a) invokeLL.objValue;
    }

    public static void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, byteBuffer) == null) {
            while (byteBuffer.hasRemaining()) {
                ByteBuffer a2 = f.a(byteBuffer);
                if (a2.remaining() >= 4) {
                    if (a2.getInt() == -1091571699) {
                        if (a2.remaining() >= 4) {
                            if (a2.getInt() == 3) {
                                throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                            }
                        } else {
                            throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + a2.remaining());
                        }
                    }
                } else {
                    throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a2.remaining());
                }
            }
        }
    }

    public static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        InterceptResult invokeLLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, byteBuffer, map, certificateFactory)) == null) {
            ByteBuffer a3 = f.a(byteBuffer);
            ByteBuffer a4 = f.a(byteBuffer);
            byte[] b = f.b(byteBuffer);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = null;
            byte[] bArr2 = null;
            int i = -1;
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (a4.hasRemaining()) {
                    i2++;
                    try {
                        ByteBuffer a5 = f.a(a4);
                        if (a5.remaining() >= 8) {
                            int i3 = a5.getInt();
                            arrayList.add(Integer.valueOf(i3));
                            if (i3 != 513 && i3 != 514 && i3 != 769 && i3 != 1057 && i3 != 1059 && i3 != 1061) {
                                switch (i3) {
                                    case 257:
                                    case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                                    case ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                                    case 260:
                                        break;
                                    default:
                                        z = false;
                                        break;
                                }
                            }
                            if (z && (i == -1 || f.a(i3, i) > 0)) {
                                bArr2 = f.b(a5);
                                i = i3;
                            }
                        } else {
                            throw new SecurityException("Signature record too short");
                        }
                    } catch (IOException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i2)), e);
                    }
                } else if (i == -1) {
                    if (i2 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                } else {
                    String c = f.c(i);
                    Pair<String, ? extends AlgorithmParameterSpec> d = f.d(i);
                    String str = (String) d.first;
                    AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) d.second;
                    try {
                        PublicKey generatePublic = KeyFactory.getInstance(c).generatePublic(new X509EncodedKeySpec(b));
                        Signature signature = Signature.getInstance(str);
                        signature.initVerify(generatePublic);
                        if (algorithmParameterSpec != null) {
                            signature.setParameter(algorithmParameterSpec);
                        }
                        signature.update(a3);
                        if (signature.verify(bArr2)) {
                            a3.clear();
                            ByteBuffer a6 = f.a(a3);
                            ArrayList arrayList2 = new ArrayList();
                            int i4 = 0;
                            while (a6.hasRemaining()) {
                                i4++;
                                try {
                                    ByteBuffer a7 = f.a(a6);
                                    if (a7.remaining() >= 8) {
                                        int i5 = a7.getInt();
                                        arrayList2.add(Integer.valueOf(i5));
                                        if (i5 == i) {
                                            bArr = f.b(a7);
                                        }
                                    } else {
                                        throw new IOException("Record too short");
                                    }
                                } catch (IOException | BufferUnderflowException e2) {
                                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                                }
                            }
                            if (arrayList.equals(arrayList2)) {
                                byte[] put = map.put(Integer.valueOf(f.a(i)), bArr);
                                if (put != null && !MessageDigest.isEqual(put, bArr)) {
                                    throw new SecurityException(f.b(a2) + " contents digest does not match the digest specified by a preceding signer");
                                }
                                ByteBuffer a8 = f.a(a3);
                                ArrayList arrayList3 = new ArrayList();
                                int i6 = 0;
                                while (a8.hasRemaining()) {
                                    i6++;
                                    byte[] b2 = f.b(a8);
                                    try {
                                        arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b2)), b2));
                                    } catch (CertificateException e3) {
                                        throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                                    }
                                }
                                if (!arrayList3.isEmpty()) {
                                    if (Arrays.equals(b, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                        a(f.a(a3));
                                        return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                                    }
                                    throw new SecurityException("Public key mismatch between certificate and signature record");
                                }
                                throw new SecurityException("No certificates listed");
                            }
                            throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                        }
                        throw new SecurityException(str + " signature did not verify");
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                        throw new SecurityException("Failed to verify " + str + " signature", e4);
                    }
                }
            }
        } else {
            return (X509Certificate[]) invokeLLL.objValue;
        }
    }
}
