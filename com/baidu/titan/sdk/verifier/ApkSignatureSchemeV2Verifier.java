package com.baidu.titan.sdk.verifier;

import android.util.Pair;
import com.baidu.titan.sdk.internal.util.Closes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class ApkSignatureSchemeV2Verifier {
    public static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    public static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    public static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    public static final int APK_SIG_BLOCK_MIN_SIZE = 32;
    public static final int CHUNK_SIZE_BYTES = 1048576;
    public static final int CONTENT_DIGEST_CHUNKED_SHA256 = 1;
    public static final int CONTENT_DIGEST_CHUNKED_SHA512 = 2;
    public static final int SF_ATTRIBUTE_ANDROID_APK_SIGNED_ID = 2;
    public static final String SF_ATTRIBUTE_ANDROID_APK_SIGNED_NAME = "X-Android-APK-Signed";
    public static final int SIGNATURE_DSA_WITH_SHA256 = 769;
    public static final int SIGNATURE_ECDSA_WITH_SHA256 = 513;
    public static final int SIGNATURE_ECDSA_WITH_SHA512 = 514;
    public static final int SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 = 259;
    public static final int SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA512 = 260;
    public static final int SIGNATURE_RSA_PSS_WITH_SHA256 = 257;
    public static final int SIGNATURE_RSA_PSS_WITH_SHA512 = 258;

    /* loaded from: classes9.dex */
    public interface DataSource {
        void feedIntoMessageDigests(MessageDigest[] messageDigestArr, long j, int i) throws IOException;

        long size();
    }

    public static boolean isSupportedSignatureAlgorithm(int i) {
        if (i == 513 || i == 514 || i == 769) {
            return true;
        }
        switch (i) {
            case 257:
            case SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
            case SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
            case 260:
                return true;
            default:
                return false;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ByteBufferDataSource implements DataSource {
        public final ByteBuffer mBuf;

        public ByteBufferDataSource(ByteBuffer byteBuffer) {
            this.mBuf = byteBuffer.slice();
        }

        @Override // com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier.DataSource
        public void feedIntoMessageDigests(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
            ByteBuffer slice;
            synchronized (this.mBuf) {
                int i2 = (int) j;
                this.mBuf.position(i2);
                this.mBuf.limit(i2 + i);
                slice = this.mBuf.slice();
            }
            for (MessageDigest messageDigest : messageDigestArr) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }

        @Override // com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier.DataSource
        public long size() {
            return this.mBuf.capacity();
        }
    }

    /* loaded from: classes9.dex */
    public static final class MemoryMappedFileDataSource implements DataSource {
        public final FileChannel mChannel;
        public final long mFilePosition;
        public final long mSize;

        public MemoryMappedFileDataSource(FileChannel fileChannel, long j, long j2) {
            this.mChannel = fileChannel;
            this.mFilePosition = j;
            this.mSize = j2;
        }

        @Override // com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier.DataSource
        public void feedIntoMessageDigests(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
            MappedByteBuffer map = this.mChannel.map(FileChannel.MapMode.READ_ONLY, this.mFilePosition + j, i);
            for (MessageDigest messageDigest : messageDigestArr) {
                map.position(0);
                messageDigest.update(map);
            }
        }

        @Override // com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier.DataSource
        public long size() {
            return this.mSize;
        }
    }

    /* loaded from: classes9.dex */
    public static class SignatureInfo {
        public final long apkSigningBlockOffset;
        public final long centralDirOffset;
        public final ByteBuffer eocd;
        public final long eocdOffset;
        public final ByteBuffer signatureBlock;

        public SignatureInfo(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
            this.signatureBlock = byteBuffer;
            this.apkSigningBlockOffset = j;
            this.centralDirOffset = j2;
            this.eocdOffset = j3;
            this.eocd = byteBuffer2;
        }
    }

    /* loaded from: classes9.dex */
    public static class SignatureNotFoundException extends Exception {
        public static final long serialVersionUID = 1;

        public SignatureNotFoundException(String str) {
            super(str);
        }

        public SignatureNotFoundException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes9.dex */
    public static class VerbatimX509Certificate extends WrappedX509Certificate {
        public byte[] encodedVerbatim;

        public VerbatimX509Certificate(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            this.encodedVerbatim = bArr;
        }

        @Override // com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier.WrappedX509Certificate, java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            return this.encodedVerbatim;
        }
    }

    /* loaded from: classes9.dex */
    public static class WrappedX509Certificate extends X509Certificate {
        public final X509Certificate wrapped;

        public WrappedX509Certificate(X509Certificate x509Certificate) {
            this.wrapped = x509Certificate;
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
            this.wrapped.checkValidity(date);
        }

        @Override // java.security.cert.X509Extension
        public byte[] getExtensionValue(String str) {
            return this.wrapped.getExtensionValue(str);
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.wrapped.verify(publicKey);
        }

        @Override // java.security.cert.X509Certificate
        public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
            this.wrapped.checkValidity();
        }

        @Override // java.security.cert.X509Certificate
        public int getBasicConstraints() {
            return this.wrapped.getBasicConstraints();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getCriticalExtensionOIDs() {
            return this.wrapped.getCriticalExtensionOIDs();
        }

        @Override // java.security.cert.Certificate
        public byte[] getEncoded() throws CertificateEncodingException {
            return this.wrapped.getEncoded();
        }

        @Override // java.security.cert.X509Certificate
        public Principal getIssuerDN() {
            return this.wrapped.getIssuerDN();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getIssuerUniqueID() {
            return this.wrapped.getIssuerUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getKeyUsage() {
            return this.wrapped.getKeyUsage();
        }

        @Override // java.security.cert.X509Extension
        public Set<String> getNonCriticalExtensionOIDs() {
            return this.wrapped.getNonCriticalExtensionOIDs();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotAfter() {
            return this.wrapped.getNotAfter();
        }

        @Override // java.security.cert.X509Certificate
        public Date getNotBefore() {
            return this.wrapped.getNotBefore();
        }

        @Override // java.security.cert.Certificate
        public PublicKey getPublicKey() {
            return this.wrapped.getPublicKey();
        }

        @Override // java.security.cert.X509Certificate
        public BigInteger getSerialNumber() {
            return this.wrapped.getSerialNumber();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgName() {
            return this.wrapped.getSigAlgName();
        }

        @Override // java.security.cert.X509Certificate
        public String getSigAlgOID() {
            return this.wrapped.getSigAlgOID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSigAlgParams() {
            return this.wrapped.getSigAlgParams();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getSignature() {
            return this.wrapped.getSignature();
        }

        @Override // java.security.cert.X509Certificate
        public Principal getSubjectDN() {
            return this.wrapped.getSubjectDN();
        }

        @Override // java.security.cert.X509Certificate
        public boolean[] getSubjectUniqueID() {
            return this.wrapped.getSubjectUniqueID();
        }

        @Override // java.security.cert.X509Certificate
        public byte[] getTBSCertificate() throws CertificateEncodingException {
            return this.wrapped.getTBSCertificate();
        }

        @Override // java.security.cert.X509Certificate
        public int getVersion() {
            return this.wrapped.getVersion();
        }

        @Override // java.security.cert.X509Extension
        public boolean hasUnsupportedCriticalExtension() {
            return this.wrapped.hasUnsupportedCriticalExtension();
        }

        @Override // java.security.cert.Certificate
        public String toString() {
            return this.wrapped.toString();
        }

        @Override // java.security.cert.Certificate
        public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
            this.wrapped.verify(publicKey, str);
        }
    }

    public static void checkByteOrderLittleEndian(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            return;
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static final long getChunkCount(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    public static String getContentDigestAlgorithmJcaDigestAlgorithm(int i) {
        if (i != 1) {
            if (i == 2) {
                return "SHA-512";
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
        return "SHA-256";
    }

    public static int getContentDigestAlgorithmOutputSizeBytes(int i) {
        if (i != 1) {
            if (i == 2) {
                return 64;
            }
            throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
        return 32;
    }

    public static Pair<ByteBuffer, Long> getEocd(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord = ZipUtils.findZipEndOfCentralDirectoryRecord(randomAccessFile);
        if (findZipEndOfCentralDirectoryRecord != null) {
            return findZipEndOfCentralDirectoryRecord;
        }
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static boolean hasSignature(File file) throws IOException {
        boolean z;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            findSignature(randomAccessFile);
            z = true;
        } catch (SignatureNotFoundException unused) {
            z = false;
        } catch (Throwable th) {
            Closes.closeQuiet(randomAccessFile);
            throw th;
        }
        Closes.closeQuiet(randomAccessFile);
        return z;
    }

    public static X509Certificate[][] verify(File file) throws SignatureNotFoundException, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return verify(randomAccessFile);
        } finally {
            Closes.closeQuiet(randomAccessFile);
        }
    }

    public static int compareContentDigestAlgorithm(int i, int i2) {
        if (i != 1) {
            if (i == 2) {
                if (i2 == 1) {
                    return 1;
                }
                if (i2 == 2) {
                    return 0;
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i);
        } else if (i2 == 1) {
            return 0;
        } else {
            if (i2 == 2) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
        }
    }

    public static ByteBuffer getByteBuffer(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 >= position && i2 <= limit) {
                byteBuffer.limit(i2);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: " + i);
    }

    public static int compareSignatureAlgorithm(int i, int i2) {
        return compareContentDigestAlgorithm(getSignatureAlgorithmContentDigestAlgorithm(i), getSignatureAlgorithmContentDigestAlgorithm(i2));
    }

    public static byte[][] computeContentDigests(int[] iArr, DataSource[] dataSourceArr) throws DigestException {
        MessageDigest messageDigest;
        DataSource[] dataSourceArr2 = dataSourceArr;
        long j = 0;
        long j2 = 0;
        for (DataSource dataSource : dataSourceArr2) {
            j2 += getChunkCount(dataSource.size());
        }
        if (j2 < 2097151) {
            int i = (int) j2;
            byte[][] bArr = new byte[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                byte[] bArr2 = new byte[(getContentDigestAlgorithmOutputSizeBytes(iArr[i2]) * i) + 5];
                bArr2[0] = 90;
                setUnsignedInt32LittleEndian(i, bArr2, 1);
                bArr[i2] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                String contentDigestAlgorithmJcaDigestAlgorithm = getContentDigestAlgorithmJcaDigestAlgorithm(iArr[i3]);
                try {
                    messageDigestArr[i3] = MessageDigest.getInstance(contentDigestAlgorithmJcaDigestAlgorithm);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(contentDigestAlgorithmJcaDigestAlgorithm + " digest not supported", e);
                }
            }
            int length2 = dataSourceArr2.length;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < length2) {
                DataSource dataSource2 = dataSourceArr2[i4];
                int i7 = length2;
                int i8 = i4;
                long size = dataSource2.size();
                long j3 = j;
                while (size > j) {
                    int min = (int) Math.min(size, 1048576L);
                    setUnsignedInt32LittleEndian(min, bArr3, 1);
                    for (int i9 = 0; i9 < length; i9++) {
                        messageDigestArr[i9].update(bArr3);
                    }
                    try {
                        dataSource2.feedIntoMessageDigests(messageDigestArr, j3, min);
                        int i10 = 0;
                        while (i10 < iArr.length) {
                            int i11 = iArr[i10];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i10];
                            int contentDigestAlgorithmOutputSizeBytes = getContentDigestAlgorithmOutputSizeBytes(i11);
                            DataSource dataSource3 = dataSource2;
                            int i12 = length;
                            int digest = messageDigestArr[i10].digest(bArr5, (i5 * contentDigestAlgorithmOutputSizeBytes) + 5, contentDigestAlgorithmOutputSizeBytes);
                            if (digest == contentDigestAlgorithmOutputSizeBytes) {
                                i10++;
                                bArr3 = bArr4;
                                dataSource2 = dataSource3;
                                length = i12;
                            } else {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                        }
                        long j4 = min;
                        j3 += j4;
                        size -= j4;
                        i5++;
                        bArr3 = bArr3;
                        j = 0;
                    } catch (IOException e2) {
                        throw new DigestException("Failed to digest chunk #" + i5 + " of section #" + i6, e2);
                    }
                }
                i6++;
                i4 = i8 + 1;
                dataSourceArr2 = dataSourceArr;
                length2 = i7;
                j = 0;
            }
            byte[][] bArr6 = new byte[iArr.length];
            for (int i13 = 0; i13 < iArr.length; i13++) {
                int i14 = iArr[i13];
                byte[] bArr7 = bArr[i13];
                String contentDigestAlgorithmJcaDigestAlgorithm2 = getContentDigestAlgorithmJcaDigestAlgorithm(i14);
                try {
                    bArr6[i13] = MessageDigest.getInstance(contentDigestAlgorithmJcaDigestAlgorithm2).digest(bArr7);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(contentDigestAlgorithmJcaDigestAlgorithm2 + " digest not supported", e3);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: " + j2);
    }

    public static ByteBuffer findApkSignatureSchemeV2Block(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (sliceFromTo.hasRemaining()) {
            i++;
            if (sliceFromTo.remaining() >= 8) {
                long j = sliceFromTo.getLong();
                if (j >= 4 && j <= 2147483647L) {
                    int i2 = (int) j;
                    int position = sliceFromTo.position() + i2;
                    if (i2 <= sliceFromTo.remaining()) {
                        if (sliceFromTo.getInt() == 1896449818) {
                            return getByteBuffer(sliceFromTo, i2 - 4);
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
            }
        }
        throw new SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
    }

    public static Pair<ByteBuffer, Long> findApkSigningBlock(RandomAccessFile randomAccessFile, long j) throws IOException, SignatureNotFoundException {
        if (j >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(j - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == APK_SIG_BLOCK_MAGIC_HI) {
                long j2 = allocate.getLong(0);
                if (j2 >= allocate.capacity() && j2 <= 2147483639) {
                    int i = (int) (8 + j2);
                    long j3 = j - i;
                    if (j3 >= 0) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(i);
                        allocate2.order(ByteOrder.LITTLE_ENDIAN);
                        randomAccessFile.seek(j3);
                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        long j4 = allocate2.getLong(0);
                        if (j4 == j2) {
                            return Pair.create(allocate2, Long.valueOf(j3));
                        }
                        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                    }
                    throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j3);
                }
                throw new SignatureNotFoundException("APK Signing Block size out of range: " + j2);
            }
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
    }

    public static SignatureInfo findSignature(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> eocd = getEocd(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) eocd.first;
        long longValue = ((Long) eocd.second).longValue();
        if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
            long centralDirOffset = getCentralDirOffset(byteBuffer, longValue);
            Pair<ByteBuffer, Long> findApkSigningBlock = findApkSigningBlock(randomAccessFile, centralDirOffset);
            return new SignatureInfo(findApkSignatureSchemeV2Block((ByteBuffer) findApkSigningBlock.first), ((Long) findApkSigningBlock.second).longValue(), centralDirOffset, longValue, byteBuffer);
        }
        throw new SignatureNotFoundException("ZIP64 APK not supported");
    }

    public static int getSignatureAlgorithmContentDigestAlgorithm(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    switch (i) {
                        case 257:
                        case SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                            return 1;
                        case SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                        case 260:
                            return 2;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    public static String getSignatureAlgorithmJcaKeyAlgorithm(int i) {
        if (i != 513 && i != 514) {
            if (i != 769) {
                switch (i) {
                    case 257:
                    case SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                    case SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                    case 260:
                        return "RSA";
                    default:
                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                }
            }
            return "DSA";
        }
        return "EC";
    }

    public static byte[] readLengthPrefixedByteArray(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    public static long getCentralDirOffset(ByteBuffer byteBuffer, long j) throws SignatureNotFoundException {
        long zipEocdCentralDirectoryOffset = ZipUtils.getZipEocdCentralDirectoryOffset(byteBuffer);
        if (zipEocdCentralDirectoryOffset < j) {
            if (ZipUtils.getZipEocdCentralDirectorySizeBytes(byteBuffer) + zipEocdCentralDirectoryOffset == j) {
                return zipEocdCentralDirectoryOffset;
            }
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + zipEocdCentralDirectoryOffset + ". ZIP End of Central Directory offset: " + j);
    }

    public static ByteBuffer getLengthPrefixedSlice(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return getByteBuffer(byteBuffer, i);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> getSignatureAlgorithmJcaSignatureAlgorithm(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    switch (i) {
                        case 257:
                            return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                        case SIGNATURE_RSA_PSS_WITH_SHA512 /* 258 */:
                            return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                        case SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256 /* 259 */:
                            return Pair.create("SHA256withRSA", null);
                        case 260:
                            return Pair.create("SHA512withRSA", null);
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                    }
                }
                return Pair.create("SHA256withDSA", null);
            }
            return Pair.create("SHA512withECDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    public static boolean hasSignature(String str) throws IOException {
        boolean z;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            findSignature(randomAccessFile);
            z = true;
        } catch (SignatureNotFoundException unused) {
            z = false;
        } catch (Throwable th) {
            Closes.closeQuiet(randomAccessFile);
            throw th;
        }
        Closes.closeQuiet(randomAccessFile);
        return z;
    }

    public static X509Certificate[][] verify(RandomAccessFile randomAccessFile) throws SignatureNotFoundException, SecurityException, IOException {
        return verify(randomAccessFile, randomAccessFile.getFD(), findSignature(randomAccessFile));
    }

    public static void setUnsignedInt32LittleEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    public static ByteBuffer sliceFromTo(ByteBuffer byteBuffer, int i, int i2) {
        if (i >= 0) {
            if (i2 >= i) {
                int capacity = byteBuffer.capacity();
                if (i2 <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(i2);
                        byteBuffer.position(i);
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        return slice;
                    } finally {
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                    }
                }
                throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
            }
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        throw new IllegalArgumentException("start: " + i);
    }

    public static X509Certificate[][] verify(RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, SignatureInfo signatureInfo) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer lengthPrefixedSlice = getLengthPrefixedSlice(signatureInfo.signatureBlock);
                int i = 0;
                while (lengthPrefixedSlice.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(verifySigner(getLengthPrefixedSlice(lengthPrefixedSlice), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i >= 1) {
                    if (!hashMap.isEmpty()) {
                        verifyIntegrity(hashMap, randomAccessFile, fileDescriptor, signatureInfo.apkSigningBlockOffset, signatureInfo.centralDirOffset, signatureInfo.eocdOffset, signatureInfo.eocd);
                        return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
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

    public static X509Certificate[][] verify(String str) throws SignatureNotFoundException, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            return verify(randomAccessFile);
        } finally {
            Closes.closeQuiet(randomAccessFile);
        }
    }

    public static void verifyIntegrity(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, FileDescriptor fileDescriptor, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        DataSource byteBufferDataSource;
        DataSource byteBufferDataSource2;
        if (!map.isEmpty()) {
            if (j > 1048576) {
                byteBufferDataSource = new MemoryMappedFileDataSource(randomAccessFile.getChannel(), 0L, j);
                byteBufferDataSource2 = new MemoryMappedFileDataSource(randomAccessFile.getChannel(), j2, j3 - j2);
            } else {
                ByteBuffer allocate = ByteBuffer.allocate((int) j);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                try {
                    randomAccessFile.seek(0L);
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    byteBufferDataSource = new ByteBufferDataSource(allocate);
                    ByteBuffer allocate2 = ByteBuffer.allocate((int) (j3 - j2));
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    try {
                        randomAccessFile.seek(j2);
                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        byteBufferDataSource2 = new ByteBufferDataSource(allocate2);
                    } catch (IOException e) {
                        throw new SecurityException("Failed to get apk contents", e);
                    }
                } catch (IOException e2) {
                    throw new SecurityException("Failed to get apk contents", e2);
                }
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            ZipUtils.setZipEocdCentralDirectoryOffset(duplicate, j);
            ByteBufferDataSource byteBufferDataSource3 = new ByteBufferDataSource(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i = 0;
            for (Integer num : map.keySet()) {
                iArr[i] = num.intValue();
                i++;
            }
            try {
                byte[][] computeContentDigests = computeContentDigests(iArr, new DataSource[]{byteBufferDataSource, byteBufferDataSource2, byteBufferDataSource3});
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = iArr[i2];
                    if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), computeContentDigests[i2])) {
                        throw new SecurityException(getContentDigestAlgorithmJcaDigestAlgorithm(i3) + " digest of contents did not verify");
                    }
                }
                return;
            } catch (DigestException e3) {
                throw new SecurityException("Failed to compute digest(s) of contents", e3);
            }
        }
        throw new SecurityException("No digests provided");
    }

    public static X509Certificate[] verifySigner(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        int signatureAlgorithmContentDigestAlgorithm;
        ByteBuffer lengthPrefixedSlice = getLengthPrefixedSlice(byteBuffer);
        ByteBuffer lengthPrefixedSlice2 = getLengthPrefixedSlice(byteBuffer);
        byte[] readLengthPrefixedByteArray = readLengthPrefixedByteArray(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i = -1;
        int i2 = 0;
        while (lengthPrefixedSlice2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer lengthPrefixedSlice3 = getLengthPrefixedSlice(lengthPrefixedSlice2);
                if (lengthPrefixedSlice3.remaining() >= 8) {
                    int i3 = lengthPrefixedSlice3.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    if (isSupportedSignatureAlgorithm(i3) && (i == -1 || compareSignatureAlgorithm(i3, i) > 0)) {
                        bArr2 = readLengthPrefixedByteArray(lengthPrefixedSlice3);
                        i = i3;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #" + i2, e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String signatureAlgorithmJcaKeyAlgorithm = getSignatureAlgorithmJcaKeyAlgorithm(i);
        Pair<String, ? extends AlgorithmParameterSpec> signatureAlgorithmJcaSignatureAlgorithm = getSignatureAlgorithmJcaSignatureAlgorithm(i);
        String str = (String) signatureAlgorithmJcaSignatureAlgorithm.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) signatureAlgorithmJcaSignatureAlgorithm.second;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(signatureAlgorithmJcaKeyAlgorithm).generatePublic(new X509EncodedKeySpec(readLengthPrefixedByteArray));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(generatePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(lengthPrefixedSlice);
            if (signature.verify(bArr2)) {
                lengthPrefixedSlice.clear();
                ByteBuffer lengthPrefixedSlice4 = getLengthPrefixedSlice(lengthPrefixedSlice);
                ArrayList arrayList2 = new ArrayList();
                int i4 = 0;
                while (lengthPrefixedSlice4.hasRemaining()) {
                    i4++;
                    try {
                        ByteBuffer lengthPrefixedSlice5 = getLengthPrefixedSlice(lengthPrefixedSlice4);
                        if (lengthPrefixedSlice5.remaining() >= 8) {
                            int i5 = lengthPrefixedSlice5.getInt();
                            arrayList2.add(Integer.valueOf(i5));
                            if (i5 == i) {
                                bArr = readLengthPrefixedByteArray(lengthPrefixedSlice5);
                            }
                        } else {
                            throw new IOException("Record too short");
                        }
                    } catch (IOException | BufferUnderflowException e2) {
                        throw new IOException("Failed to parse digest record #" + i4, e2);
                    }
                }
                if (arrayList.equals(arrayList2)) {
                    byte[] put = map.put(Integer.valueOf(getSignatureAlgorithmContentDigestAlgorithm(i)), bArr);
                    if (put != null && !MessageDigest.isEqual(put, bArr)) {
                        throw new SecurityException(getContentDigestAlgorithmJcaDigestAlgorithm(signatureAlgorithmContentDigestAlgorithm) + " contents digest does not match the digest specified by a preceding signer");
                    }
                    ByteBuffer lengthPrefixedSlice6 = getLengthPrefixedSlice(lengthPrefixedSlice);
                    ArrayList arrayList3 = new ArrayList();
                    int i6 = 0;
                    while (lengthPrefixedSlice6.hasRemaining()) {
                        i6++;
                        byte[] readLengthPrefixedByteArray2 = readLengthPrefixedByteArray(lengthPrefixedSlice6);
                        try {
                            arrayList3.add(new VerbatimX509Certificate((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(readLengthPrefixedByteArray2)), readLengthPrefixedByteArray2));
                        } catch (CertificateException e3) {
                            throw new SecurityException("Failed to decode certificate #" + i6, e3);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        if (Arrays.equals(readLengthPrefixedByteArray, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
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
