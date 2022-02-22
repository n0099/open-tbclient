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
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final X509Certificate[][] a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f53270b;

        public a(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509CertificateArr, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x509CertificateArr;
            this.f53270b = bArr;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, str)) != null) {
            return (a) invokeL.objValue;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            a a2 = a(randomAccessFile, f.a(randomAccessFile, (int) ApkSignatureSchemeV2Verifier.APK_SIGNATURE_SCHEME_V2_BLOCK_ID));
            randomAccessFile.close();
            return a2;
        } finally {
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
                    int i2 = 0;
                    while (a2.hasRemaining()) {
                        i2++;
                        try {
                            arrayList.add(a(f.a(a2), arrayMap, certificateFactory));
                        } catch (IOException | SecurityException | BufferUnderflowException e2) {
                            throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e2);
                        }
                    }
                    if (i2 > 0) {
                        if (!arrayMap.isEmpty()) {
                            f.a(arrayMap, randomAccessFile, mVar);
                            return new a((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]), arrayMap.containsKey(3) ? f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar) : null);
                        }
                        throw new SecurityException("No content digests found");
                    }
                    throw new SecurityException("No signers found");
                } catch (IOException e3) {
                    throw new SecurityException("Failed to read list of signers", e3);
                }
            } catch (CertificateException e4) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
            }
        }
        return (a) invokeLL.objValue;
    }

    public static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) {
        InterceptResult invokeLLL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65539, null, byteBuffer, map, certificateFactory)) != null) {
            return (X509Certificate[]) invokeLLL.objValue;
        }
        ByteBuffer a3 = f.a(byteBuffer);
        ByteBuffer a4 = f.a(byteBuffer);
        byte[] b2 = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (!a4.hasRemaining()) {
                if (i2 == -1) {
                    if (i3 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String c2 = f.c(i2);
                Pair<String, ? extends AlgorithmParameterSpec> d2 = f.d(i2);
                String str = (String) d2.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) d2.second;
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(c2).generatePublic(new X509EncodedKeySpec(b2));
                    Signature signature = Signature.getInstance(str);
                    signature.initVerify(generatePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(a3);
                    if (signature.verify(bArr2)) {
                        a3.clear();
                        ByteBuffer a5 = f.a(a3);
                        ArrayList arrayList2 = new ArrayList();
                        int i4 = 0;
                        while (a5.hasRemaining()) {
                            i4++;
                            try {
                                ByteBuffer a6 = f.a(a5);
                                if (a6.remaining() >= 8) {
                                    int i5 = a6.getInt();
                                    arrayList2.add(Integer.valueOf(i5));
                                    if (i5 == i2) {
                                        bArr = f.b(a6);
                                    }
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e2) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            byte[] put = map.put(Integer.valueOf(f.a(i2)), bArr);
                            if (put != null && !MessageDigest.isEqual(put, bArr)) {
                                throw new SecurityException(f.b(a2) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer a7 = f.a(a3);
                            ArrayList arrayList3 = new ArrayList();
                            int i6 = 0;
                            while (a7.hasRemaining()) {
                                i6++;
                                byte[] b3 = f.b(a7);
                                try {
                                    arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b3)), b3));
                                } catch (CertificateException e3) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(b2, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
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
            i3++;
            try {
                ByteBuffer a8 = f.a(a4);
                if (a8.remaining() >= 8) {
                    int i7 = a8.getInt();
                    arrayList.add(Integer.valueOf(i7));
                    if (i7 != 513 && i7 != 514 && i7 != 769 && i7 != 1057 && i7 != 1059 && i7 != 1061) {
                        switch (i7) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                break;
                            default:
                                z = false;
                                break;
                        }
                    }
                    if (z && (i2 == -1 || f.a(i7, i2) > 0)) {
                        bArr2 = f.b(a8);
                        i2 = i7;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e5) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i3)), e5);
            }
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, byteBuffer) == null) {
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
}
