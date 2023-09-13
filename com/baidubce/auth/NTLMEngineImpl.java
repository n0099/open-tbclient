package com.baidubce.auth;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes9.dex */
public final class NTLMEngineImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Charset DEFAULT_CHARSET;
    public static final int FLAG_DOMAIN_PRESENT = 4096;
    public static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
    public static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
    public static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
    public static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
    public static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
    public static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
    public static final int FLAG_REQUEST_NTLMv1 = 512;
    public static final int FLAG_REQUEST_SEAL = 32;
    public static final int FLAG_REQUEST_SIGN = 16;
    public static final int FLAG_REQUEST_TARGET = 4;
    public static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
    public static final int FLAG_REQUEST_VERSION = 33554432;
    public static final int FLAG_TARGETINFO_PRESENT = 8388608;
    public static final int FLAG_WORKSTATION_PRESENT = 8192;
    public static final SecureRandom RND_GEN;
    public static final byte[] SIGNATURE;
    public static final String TYPE_1_MESSAGE;
    public static final Charset UNICODE_LITTLE_UNMARKED;
    public transient /* synthetic */ FieldHolder $fh;

    public static int F(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i, i2, i3)) == null) ? ((~i) & i3) | (i2 & i) : invokeIII.intValue;
    }

    public static int G(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65539, null, i, i2, i3)) == null) ? (i & i3) | (i & i2) | (i2 & i3) : invokeIII.intValue;
    }

    public static int H(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, i3)) == null) ? (i ^ i2) ^ i3 : invokeIII.intValue;
    }

    public static int rotintlft(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65581, null, i, i2)) == null) ? (i >>> (32 - i2)) | (i << i2) : invokeII.intValue;
    }

    /* loaded from: classes9.dex */
    public static class CipherGen {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] challenge;
        public byte[] clientChallenge;
        public byte[] clientChallenge2;
        public final String domain;
        public byte[] lanManagerSessionKey;
        public byte[] lm2SessionResponse;
        public byte[] lmHash;
        public byte[] lmResponse;
        public byte[] lmUserSessionKey;
        public byte[] lmv2Hash;
        public byte[] lmv2Response;
        public byte[] ntlm2SessionResponse;
        public byte[] ntlm2SessionResponseUserSessionKey;
        public byte[] ntlmHash;
        public byte[] ntlmResponse;
        public byte[] ntlmUserSessionKey;
        public byte[] ntlmv2Blob;
        public byte[] ntlmv2Hash;
        public byte[] ntlmv2Response;
        public byte[] ntlmv2UserSessionKey;
        public final String password;
        public byte[] secondaryKey;
        public final String target;
        public final byte[] targetInformation;
        public byte[] timestamp;
        public final String user;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2) {
            this(str, str2, str3, bArr, str4, bArr2, null, null, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, str3, bArr, str4, bArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (byte[]) objArr2[3], (String) objArr2[4], (byte[]) objArr2[5], (byte[]) objArr2[6], (byte[]) objArr2[7], (byte[]) objArr2[8], (byte[]) objArr2[9]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public CipherGen(String str, String str2, String str3, byte[] bArr, String str4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, bArr, str4, bArr2, bArr3, bArr4, bArr5, bArr6};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.lmHash = null;
            this.lmResponse = null;
            this.ntlmHash = null;
            this.ntlmResponse = null;
            this.ntlmv2Hash = null;
            this.lmv2Hash = null;
            this.lmv2Response = null;
            this.ntlmv2Blob = null;
            this.ntlmv2Response = null;
            this.ntlm2SessionResponse = null;
            this.lm2SessionResponse = null;
            this.lmUserSessionKey = null;
            this.ntlmUserSessionKey = null;
            this.ntlmv2UserSessionKey = null;
            this.ntlm2SessionResponseUserSessionKey = null;
            this.lanManagerSessionKey = null;
            this.domain = str;
            this.target = str4;
            this.user = str2;
            this.password = str3;
            this.challenge = bArr;
            this.targetInformation = bArr2;
            this.clientChallenge = bArr3;
            this.clientChallenge2 = bArr4;
            this.secondaryKey = bArr5;
            this.timestamp = bArr6;
        }

        public byte[] getClientChallenge() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.clientChallenge == null) {
                    this.clientChallenge = NTLMEngineImpl.access$000();
                }
                return this.clientChallenge;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getClientChallenge2() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.clientChallenge2 == null) {
                    this.clientChallenge2 = NTLMEngineImpl.access$000();
                }
                return this.clientChallenge2;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getLM2SessionResponse() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.lm2SessionResponse == null) {
                    byte[] clientChallenge = getClientChallenge();
                    byte[] bArr = new byte[24];
                    this.lm2SessionResponse = bArr;
                    System.arraycopy(clientChallenge, 0, bArr, 0, clientChallenge.length);
                    byte[] bArr2 = this.lm2SessionResponse;
                    Arrays.fill(bArr2, clientChallenge.length, bArr2.length, (byte) 0);
                }
                return this.lm2SessionResponse;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getLMHash() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.lmHash == null) {
                    this.lmHash = NTLMEngineImpl.lmHash(this.password);
                }
                return this.lmHash;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getLMResponse() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.lmResponse == null) {
                    this.lmResponse = NTLMEngineImpl.lmResponse(getLMHash(), this.challenge);
                }
                return this.lmResponse;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getLMUserSessionKey() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.lmUserSessionKey == null) {
                    this.lmUserSessionKey = new byte[16];
                    System.arraycopy(getLMHash(), 0, this.lmUserSessionKey, 0, 8);
                    Arrays.fill(this.lmUserSessionKey, 8, 16, (byte) 0);
                }
                return this.lmUserSessionKey;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getLMv2Hash() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.lmv2Hash == null) {
                    this.lmv2Hash = NTLMEngineImpl.lmv2Hash(this.domain, this.user, getNTLMHash());
                }
                return this.lmv2Hash;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getLMv2Response() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.lmv2Response == null) {
                    this.lmv2Response = NTLMEngineImpl.lmv2Response(getLMv2Hash(), this.challenge, getClientChallenge());
                }
                return this.lmv2Response;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLM2SessionResponse() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.ntlm2SessionResponse == null) {
                    this.ntlm2SessionResponse = NTLMEngineImpl.ntlm2SessionResponse(getNTLMHash(), this.challenge, getClientChallenge());
                }
                return this.ntlm2SessionResponse;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLMHash() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.ntlmHash == null) {
                    this.ntlmHash = NTLMEngineImpl.ntlmHash(this.password);
                }
                return this.ntlmHash;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLMResponse() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.ntlmResponse == null) {
                    this.ntlmResponse = NTLMEngineImpl.lmResponse(getNTLMHash(), this.challenge);
                }
                return this.ntlmResponse;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLMUserSessionKey() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (this.ntlmUserSessionKey == null) {
                    MD4 md4 = new MD4();
                    md4.update(getNTLMHash());
                    this.ntlmUserSessionKey = md4.getOutput();
                }
                return this.ntlmUserSessionKey;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLMv2Blob() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.ntlmv2Blob == null) {
                    this.ntlmv2Blob = NTLMEngineImpl.createBlob(getClientChallenge2(), this.targetInformation, getTimestamp());
                }
                return this.ntlmv2Blob;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLMv2Hash() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (this.ntlmv2Hash == null) {
                    this.ntlmv2Hash = NTLMEngineImpl.ntlmv2Hash(this.domain, this.user, getNTLMHash());
                }
                return this.ntlmv2Hash;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLMv2Response() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (this.ntlmv2Response == null) {
                    this.ntlmv2Response = NTLMEngineImpl.lmv2Response(getNTLMv2Hash(), this.challenge, getNTLMv2Blob());
                }
                return this.ntlmv2Response;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLMv2UserSessionKey() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                if (this.ntlmv2UserSessionKey == null) {
                    byte[] nTLMv2Hash = getNTLMv2Hash();
                    byte[] bArr = new byte[16];
                    System.arraycopy(getNTLMv2Response(), 0, bArr, 0, 16);
                    this.ntlmv2UserSessionKey = NTLMEngineImpl.hmacMD5(bArr, nTLMv2Hash);
                }
                return this.ntlmv2UserSessionKey;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getSecondaryKey() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                if (this.secondaryKey == null) {
                    this.secondaryKey = NTLMEngineImpl.access$100();
                }
                return this.secondaryKey;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getLanManagerSessionKey() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.lanManagerSessionKey == null) {
                    try {
                        byte[] bArr = new byte[14];
                        System.arraycopy(getLMHash(), 0, bArr, 0, 8);
                        Arrays.fill(bArr, 8, 14, (byte) -67);
                        Key createDESKey = NTLMEngineImpl.createDESKey(bArr, 0);
                        Key createDESKey2 = NTLMEngineImpl.createDESKey(bArr, 7);
                        byte[] bArr2 = new byte[8];
                        System.arraycopy(getLMResponse(), 0, bArr2, 0, 8);
                        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
                        cipher.init(1, createDESKey);
                        byte[] doFinal = cipher.doFinal(bArr2);
                        Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
                        cipher2.init(1, createDESKey2);
                        byte[] doFinal2 = cipher2.doFinal(bArr2);
                        byte[] bArr3 = new byte[16];
                        this.lanManagerSessionKey = bArr3;
                        System.arraycopy(doFinal, 0, bArr3, 0, doFinal.length);
                        System.arraycopy(doFinal2, 0, this.lanManagerSessionKey, doFinal.length, doFinal2.length);
                    } catch (Exception e) {
                        throw new NTLMEngineException(e.getMessage(), e);
                    }
                }
                return this.lanManagerSessionKey;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getNTLM2SessionResponseUserSessionKey() throws NTLMEngineException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.ntlm2SessionResponseUserSessionKey == null) {
                    byte[] lM2SessionResponse = getLM2SessionResponse();
                    byte[] bArr = this.challenge;
                    byte[] bArr2 = new byte[bArr.length + lM2SessionResponse.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(lM2SessionResponse, 0, bArr2, this.challenge.length, lM2SessionResponse.length);
                    this.ntlm2SessionResponseUserSessionKey = NTLMEngineImpl.hmacMD5(bArr2, getNTLMUserSessionKey());
                }
                return this.ntlm2SessionResponseUserSessionKey;
            }
            return (byte[]) invokeV.objValue;
        }

        public byte[] getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                if (this.timestamp == null) {
                    long currentTimeMillis = (System.currentTimeMillis() + 11644473600000L) * 10000;
                    this.timestamp = new byte[8];
                    for (int i = 0; i < 8; i++) {
                        this.timestamp[i] = (byte) currentTimeMillis;
                        currentTimeMillis >>>= 8;
                    }
                }
                return this.timestamp;
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class HMACMD5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] ipad;
        public MessageDigest md5;
        public byte[] opad;

        public HMACMD5(byte[] bArr) throws NTLMEngineException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                this.md5 = messageDigest;
                this.ipad = new byte[64];
                this.opad = new byte[64];
                int length = bArr.length;
                if (length > 64) {
                    messageDigest.update(bArr);
                    bArr = this.md5.digest();
                    length = bArr.length;
                }
                int i3 = 0;
                while (i3 < length) {
                    this.ipad[i3] = (byte) (54 ^ bArr[i3]);
                    this.opad[i3] = (byte) (92 ^ bArr[i3]);
                    i3++;
                }
                while (i3 < 64) {
                    this.ipad[i3] = 54;
                    this.opad[i3] = 92;
                    i3++;
                }
                this.md5.reset();
                this.md5.update(this.ipad);
            } catch (Exception e) {
                throw new NTLMEngineException("Error getting md5 message digest implementation: " + e.getMessage(), e);
            }
        }

        public byte[] getOutput() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                byte[] digest = this.md5.digest();
                this.md5.update(this.opad);
                return this.md5.digest(digest);
            }
            return (byte[]) invokeV.objValue;
        }

        public void update(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
                this.md5.update(bArr);
            }
        }

        public void update(byte[] bArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2) == null) {
                this.md5.update(bArr, i, i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class MD4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int A;
        public int B;
        public int C;
        public int D;
        public long count;
        public byte[] dataBuffer;

        public MD4() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.A = 1732584193;
            this.B = -271733879;
            this.C = -1732584194;
            this.D = 271733878;
            this.count = 0L;
            this.dataBuffer = new byte[64];
        }

        public byte[] getOutput() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = (int) (this.count & 63);
                if (i2 < 56) {
                    i = 56 - i2;
                } else {
                    i = 120 - i2;
                }
                byte[] bArr = new byte[i + 8];
                bArr[0] = Byte.MIN_VALUE;
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr[i + i3] = (byte) ((this.count * 8) >>> (i3 * 8));
                }
                update(bArr);
                byte[] bArr2 = new byte[16];
                NTLMEngineImpl.writeULong(bArr2, this.A, 0);
                NTLMEngineImpl.writeULong(bArr2, this.B, 4);
                NTLMEngineImpl.writeULong(bArr2, this.C, 8);
                NTLMEngineImpl.writeULong(bArr2, this.D, 12);
                return bArr2;
            }
            return (byte[]) invokeV.objValue;
        }

        public void processBuffer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int[] iArr = new int[16];
                for (int i = 0; i < 16; i++) {
                    byte[] bArr = this.dataBuffer;
                    int i2 = i * 4;
                    iArr[i] = (bArr[i2] & 255) + ((bArr[i2 + 1] & 255) << 8) + ((bArr[i2 + 2] & 255) << 16) + ((bArr[i2 + 3] & 255) << 24);
                }
                int i3 = this.A;
                int i4 = this.B;
                int i5 = this.C;
                int i6 = this.D;
                round1(iArr);
                round2(iArr);
                round3(iArr);
                this.A += i3;
                this.B += i4;
                this.C += i5;
                this.D += i6;
            }
        }

        public void round1(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr) == null) {
                int rotintlft = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(this.B, this.C, this.D) + iArr[0], 3);
                this.A = rotintlft;
                int rotintlft2 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(rotintlft, this.B, this.C) + iArr[1], 7);
                this.D = rotintlft2;
                int rotintlft3 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(rotintlft2, this.A, this.B) + iArr[2], 11);
                this.C = rotintlft3;
                int rotintlft4 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(rotintlft3, this.D, this.A) + iArr[3], 19);
                this.B = rotintlft4;
                int rotintlft5 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(rotintlft4, this.C, this.D) + iArr[4], 3);
                this.A = rotintlft5;
                int rotintlft6 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(rotintlft5, this.B, this.C) + iArr[5], 7);
                this.D = rotintlft6;
                int rotintlft7 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(rotintlft6, this.A, this.B) + iArr[6], 11);
                this.C = rotintlft7;
                int rotintlft8 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(rotintlft7, this.D, this.A) + iArr[7], 19);
                this.B = rotintlft8;
                int rotintlft9 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(rotintlft8, this.C, this.D) + iArr[8], 3);
                this.A = rotintlft9;
                int rotintlft10 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(rotintlft9, this.B, this.C) + iArr[9], 7);
                this.D = rotintlft10;
                int rotintlft11 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(rotintlft10, this.A, this.B) + iArr[10], 11);
                this.C = rotintlft11;
                int rotintlft12 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(rotintlft11, this.D, this.A) + iArr[11], 19);
                this.B = rotintlft12;
                int rotintlft13 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.F(rotintlft12, this.C, this.D) + iArr[12], 3);
                this.A = rotintlft13;
                int rotintlft14 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.F(rotintlft13, this.B, this.C) + iArr[13], 7);
                this.D = rotintlft14;
                int rotintlft15 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.F(rotintlft14, this.A, this.B) + iArr[14], 11);
                this.C = rotintlft15;
                this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.F(rotintlft15, this.D, this.A) + iArr[15], 19);
            }
        }

        public void round2(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) {
                int rotintlft = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(this.B, this.C, this.D) + iArr[0] + 1518500249, 3);
                this.A = rotintlft;
                int rotintlft2 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(rotintlft, this.B, this.C) + iArr[4] + 1518500249, 5);
                this.D = rotintlft2;
                int rotintlft3 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(rotintlft2, this.A, this.B) + iArr[8] + 1518500249, 9);
                this.C = rotintlft3;
                int rotintlft4 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(rotintlft3, this.D, this.A) + iArr[12] + 1518500249, 13);
                this.B = rotintlft4;
                int rotintlft5 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(rotintlft4, this.C, this.D) + iArr[1] + 1518500249, 3);
                this.A = rotintlft5;
                int rotintlft6 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(rotintlft5, this.B, this.C) + iArr[5] + 1518500249, 5);
                this.D = rotintlft6;
                int rotintlft7 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(rotintlft6, this.A, this.B) + iArr[9] + 1518500249, 9);
                this.C = rotintlft7;
                int rotintlft8 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(rotintlft7, this.D, this.A) + iArr[13] + 1518500249, 13);
                this.B = rotintlft8;
                int rotintlft9 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(rotintlft8, this.C, this.D) + iArr[2] + 1518500249, 3);
                this.A = rotintlft9;
                int rotintlft10 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(rotintlft9, this.B, this.C) + iArr[6] + 1518500249, 5);
                this.D = rotintlft10;
                int rotintlft11 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(rotintlft10, this.A, this.B) + iArr[10] + 1518500249, 9);
                this.C = rotintlft11;
                int rotintlft12 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(rotintlft11, this.D, this.A) + iArr[14] + 1518500249, 13);
                this.B = rotintlft12;
                int rotintlft13 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.G(rotintlft12, this.C, this.D) + iArr[3] + 1518500249, 3);
                this.A = rotintlft13;
                int rotintlft14 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.G(rotintlft13, this.B, this.C) + iArr[7] + 1518500249, 5);
                this.D = rotintlft14;
                int rotintlft15 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.G(rotintlft14, this.A, this.B) + iArr[11] + 1518500249, 9);
                this.C = rotintlft15;
                this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.G(rotintlft15, this.D, this.A) + iArr[15] + 1518500249, 13);
            }
        }

        public void round3(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) {
                int rotintlft = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(this.B, this.C, this.D) + iArr[0] + 1859775393, 3);
                this.A = rotintlft;
                int rotintlft2 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(rotintlft, this.B, this.C) + iArr[8] + 1859775393, 9);
                this.D = rotintlft2;
                int rotintlft3 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(rotintlft2, this.A, this.B) + iArr[4] + 1859775393, 11);
                this.C = rotintlft3;
                int rotintlft4 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(rotintlft3, this.D, this.A) + iArr[12] + 1859775393, 15);
                this.B = rotintlft4;
                int rotintlft5 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(rotintlft4, this.C, this.D) + iArr[2] + 1859775393, 3);
                this.A = rotintlft5;
                int rotintlft6 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(rotintlft5, this.B, this.C) + iArr[10] + 1859775393, 9);
                this.D = rotintlft6;
                int rotintlft7 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(rotintlft6, this.A, this.B) + iArr[6] + 1859775393, 11);
                this.C = rotintlft7;
                int rotintlft8 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(rotintlft7, this.D, this.A) + iArr[14] + 1859775393, 15);
                this.B = rotintlft8;
                int rotintlft9 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(rotintlft8, this.C, this.D) + iArr[1] + 1859775393, 3);
                this.A = rotintlft9;
                int rotintlft10 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(rotintlft9, this.B, this.C) + iArr[9] + 1859775393, 9);
                this.D = rotintlft10;
                int rotintlft11 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(rotintlft10, this.A, this.B) + iArr[5] + 1859775393, 11);
                this.C = rotintlft11;
                int rotintlft12 = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(rotintlft11, this.D, this.A) + iArr[13] + 1859775393, 15);
                this.B = rotintlft12;
                int rotintlft13 = NTLMEngineImpl.rotintlft(this.A + NTLMEngineImpl.H(rotintlft12, this.C, this.D) + iArr[3] + 1859775393, 3);
                this.A = rotintlft13;
                int rotintlft14 = NTLMEngineImpl.rotintlft(this.D + NTLMEngineImpl.H(rotintlft13, this.B, this.C) + iArr[11] + 1859775393, 9);
                this.D = rotintlft14;
                int rotintlft15 = NTLMEngineImpl.rotintlft(this.C + NTLMEngineImpl.H(rotintlft14, this.A, this.B) + iArr[7] + 1859775393, 11);
                this.C = rotintlft15;
                this.B = NTLMEngineImpl.rotintlft(this.B + NTLMEngineImpl.H(rotintlft15, this.D, this.A) + iArr[15] + 1859775393, 15);
            }
        }

        public void update(byte[] bArr) {
            byte[] bArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
                int i = (int) (this.count & 63);
                int i2 = 0;
                while (true) {
                    int length = (bArr.length - i2) + i;
                    bArr2 = this.dataBuffer;
                    if (length < bArr2.length) {
                        break;
                    }
                    int length2 = bArr2.length - i;
                    System.arraycopy(bArr, i2, bArr2, i, length2);
                    this.count += length2;
                    i2 += length2;
                    processBuffer();
                    i = 0;
                }
                if (i2 < bArr.length) {
                    int length3 = bArr.length - i2;
                    System.arraycopy(bArr, i2, bArr2, i, length3);
                    this.count += length3;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class NTLMEngineException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NTLMEngineException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NTLMEngineException(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class NTLMMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentOutputPosition;
        public byte[] messageContents;

        public NTLMMessage() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.messageContents = null;
            this.currentOutputPosition = 0;
        }

        public int getMessageLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.currentOutputPosition;
            }
            return invokeV.intValue;
        }

        public int getPreambleLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return NTLMEngineImpl.SIGNATURE.length + 4;
            }
            return invokeV.intValue;
        }

        public String getResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                byte[] bArr = this.messageContents;
                int length = bArr.length;
                int i = this.currentOutputPosition;
                if (length > i) {
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
                return Base64.encodeToString(bArr, 2);
            }
            return (String) invokeV.objValue;
        }

        public NTLMMessage(String str, int i) throws NTLMEngineException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.messageContents = null;
            this.currentOutputPosition = 0;
            byte[] decode = Base64.decode(str.getBytes(NTLMEngineImpl.DEFAULT_CHARSET), 2);
            this.messageContents = decode;
            if (decode.length >= NTLMEngineImpl.SIGNATURE.length) {
                for (int i4 = 0; i4 < NTLMEngineImpl.SIGNATURE.length; i4++) {
                    if (this.messageContents[i4] != NTLMEngineImpl.SIGNATURE[i4]) {
                        throw new NTLMEngineException("NTLM message expected - instead got unrecognized bytes");
                    }
                }
                int readULong = readULong(NTLMEngineImpl.SIGNATURE.length);
                if (readULong == i) {
                    this.currentOutputPosition = this.messageContents.length;
                    return;
                }
                throw new NTLMEngineException("NTLM type " + Integer.toString(i) + " message expected - instead got type " + Integer.toString(readULong));
            }
            throw new NTLMEngineException("NTLM message decoding error - packet too short");
        }

        public void addByte(byte b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeB(1048576, this, b) == null) {
                byte[] bArr = this.messageContents;
                int i = this.currentOutputPosition;
                bArr[i] = b;
                this.currentOutputPosition = i + 1;
            }
        }

        public void addBytes(byte[] bArr) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) != null) || bArr == null) {
                return;
            }
            for (byte b : bArr) {
                byte[] bArr2 = this.messageContents;
                int i = this.currentOutputPosition;
                bArr2[i] = b;
                this.currentOutputPosition = i + 1;
            }
        }

        public void addULong(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                addByte((byte) (i & 255));
                addByte((byte) ((i >> 8) & 255));
                addByte((byte) ((i >> 16) & 255));
                addByte((byte) ((i >> 24) & 255));
            }
        }

        public void addUShort(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                addByte((byte) (i & 255));
                addByte((byte) ((i >> 8) & 255));
            }
        }

        public byte readByte(int i) throws NTLMEngineException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                byte[] bArr = this.messageContents;
                if (bArr.length >= i + 1) {
                    return bArr[i];
                }
                throw new NTLMEngineException("NTLM: Message too short");
            }
            return invokeI.byteValue;
        }

        public byte[] readSecurityBuffer(int i) throws NTLMEngineException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeI = interceptable.invokeI(1048586, this, i)) != null) {
                return (byte[]) invokeI.objValue;
            }
            return NTLMEngineImpl.readSecurityBuffer(this.messageContents, i);
        }

        public int readULong(int i) throws NTLMEngineException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeI = interceptable.invokeI(1048587, this, i)) != null) {
                return invokeI.intValue;
            }
            return NTLMEngineImpl.readULong(this.messageContents, i);
        }

        public int readUShort(int i) throws NTLMEngineException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeI = interceptable.invokeI(1048588, this, i)) != null) {
                return invokeI.intValue;
            }
            return NTLMEngineImpl.readUShort(this.messageContents, i);
        }

        public void prepareResponse(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
                this.messageContents = new byte[i];
                this.currentOutputPosition = 0;
                addBytes(NTLMEngineImpl.SIGNATURE);
                addULong(i2);
            }
        }

        public void readBytes(byte[] bArr, int i) throws NTLMEngineException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, bArr, i) == null) {
                byte[] bArr2 = this.messageContents;
                if (bArr2.length >= bArr.length + i) {
                    System.arraycopy(bArr2, i, bArr, 0, bArr.length);
                    return;
                }
                throw new NTLMEngineException("NTLM: Message too short");
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class Type1Message extends NTLMMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] domainBytes;
        public final byte[] hostBytes;

        public Type1Message() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.hostBytes = null;
            this.domainBytes = null;
        }

        public Type1Message(String str, String str2) throws NTLMEngineException {
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (NTLMEngineImpl.UNICODE_LITTLE_UNMARKED == null) {
                throw new NTLMEngineException("Unicode not supported");
            }
            String convertHost = NTLMEngineImpl.convertHost(str2);
            String convertDomain = NTLMEngineImpl.convertDomain(str);
            if (convertHost != null) {
                bArr = convertHost.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED);
            } else {
                bArr = null;
            }
            this.hostBytes = bArr;
            this.domainBytes = convertDomain != null ? convertDomain.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null;
        }

        @Override // com.baidubce.auth.NTLMEngineImpl.NTLMMessage
        public String getResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                prepareResponse(40, 1);
                addULong(-1576500735);
                addUShort(0);
                addUShort(0);
                addULong(40);
                addUShort(0);
                addUShort(0);
                addULong(40);
                addUShort(261);
                addULong(2600);
                addUShort(3840);
                byte[] bArr = this.hostBytes;
                if (bArr != null) {
                    addBytes(bArr);
                }
                byte[] bArr2 = this.domainBytes;
                if (bArr2 != null) {
                    addBytes(bArr2);
                }
                return super.getResponse();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class Type2Message extends NTLMMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] challenge;
        public int flags;
        public String target;
        public byte[] targetInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Type2Message(String str) throws NTLMEngineException {
            super(str, 2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            byte[] bArr = new byte[8];
            this.challenge = bArr;
            readBytes(bArr, 24);
            int readULong = readULong(20);
            this.flags = readULong;
            if ((readULong & 1) != 0) {
                this.target = null;
                if (getMessageLength() >= 20) {
                    byte[] readSecurityBuffer = readSecurityBuffer(12);
                    if (readSecurityBuffer.length != 0) {
                        try {
                            this.target = new String(readSecurityBuffer, "UnicodeLittleUnmarked");
                        } catch (UnsupportedEncodingException e) {
                            throw new NTLMEngineException(e.getMessage(), e);
                        }
                    }
                }
                this.targetInfo = null;
                if (getMessageLength() >= 48) {
                    byte[] readSecurityBuffer2 = readSecurityBuffer(40);
                    if (readSecurityBuffer2.length != 0) {
                        this.targetInfo = readSecurityBuffer2;
                        return;
                    }
                    return;
                }
                return;
            }
            throw new NTLMEngineException("NTLM type 2 message indicates no support for Unicode. Flags are: " + Integer.toString(this.flags));
        }

        public byte[] getChallenge() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.challenge;
            }
            return (byte[]) invokeV.objValue;
        }

        public int getFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.flags;
            }
            return invokeV.intValue;
        }

        public String getTarget() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.target;
            }
            return (String) invokeV.objValue;
        }

        public byte[] getTargetInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.targetInfo;
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class Type3Message extends NTLMMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] domainBytes;
        public byte[] hostBytes;
        public byte[] lmResp;
        public byte[] ntResp;
        public byte[] sessionKey;
        public int type2Flags;
        public byte[] userBytes;

        public Type3Message(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) throws NTLMEngineException {
            byte[] lMUserSessionKey;
            byte[] bArr3;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, bArr, Integer.valueOf(i), str5, bArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type2Flags = i;
            String convertHost = NTLMEngineImpl.convertHost(str2);
            String convertDomain = NTLMEngineImpl.convertDomain(str);
            CipherGen cipherGen = new CipherGen(convertDomain, str3, str4, bArr, str5, bArr2);
            try {
                if ((8388608 & i) != 0 && bArr2 != null && str5 != null) {
                    this.ntResp = cipherGen.getNTLMv2Response();
                    this.lmResp = cipherGen.getLMv2Response();
                    if ((i & 128) != 0) {
                        lMUserSessionKey = cipherGen.getLanManagerSessionKey();
                    } else {
                        lMUserSessionKey = cipherGen.getNTLMv2UserSessionKey();
                    }
                } else if ((524288 & i) != 0) {
                    this.ntResp = cipherGen.getNTLM2SessionResponse();
                    this.lmResp = cipherGen.getLM2SessionResponse();
                    if ((i & 128) != 0) {
                        lMUserSessionKey = cipherGen.getLanManagerSessionKey();
                    } else {
                        lMUserSessionKey = cipherGen.getNTLM2SessionResponseUserSessionKey();
                    }
                } else {
                    this.ntResp = cipherGen.getNTLMResponse();
                    this.lmResp = cipherGen.getLMResponse();
                    if ((i & 128) != 0) {
                        lMUserSessionKey = cipherGen.getLanManagerSessionKey();
                    } else {
                        lMUserSessionKey = cipherGen.getNTLMUserSessionKey();
                    }
                }
            } catch (NTLMEngineException unused) {
                this.ntResp = new byte[0];
                this.lmResp = cipherGen.getLMResponse();
                if ((i & 128) != 0) {
                    lMUserSessionKey = cipherGen.getLanManagerSessionKey();
                } else {
                    lMUserSessionKey = cipherGen.getLMUserSessionKey();
                }
            }
            if ((i & 16) != 0) {
                if ((i & 1073741824) != 0) {
                    this.sessionKey = NTLMEngineImpl.RC4(cipherGen.getSecondaryKey(), lMUserSessionKey);
                } else {
                    this.sessionKey = lMUserSessionKey;
                }
            } else {
                this.sessionKey = null;
            }
            if (NTLMEngineImpl.UNICODE_LITTLE_UNMARKED != null) {
                if (convertHost != null) {
                    bArr3 = convertHost.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED);
                } else {
                    bArr3 = null;
                }
                this.hostBytes = bArr3;
                this.domainBytes = convertDomain != null ? convertDomain.toUpperCase(Locale.ROOT).getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED) : null;
                this.userBytes = str3.getBytes(NTLMEngineImpl.UNICODE_LITTLE_UNMARKED);
                return;
            }
            throw new NTLMEngineException("Unicode not supported");
        }

        @Override // com.baidubce.auth.NTLMEngineImpl.NTLMMessage
        public String getResponse() {
            InterceptResult invokeV;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int length = this.ntResp.length;
                int length2 = this.lmResp.length;
                byte[] bArr = this.domainBytes;
                int i3 = 0;
                if (bArr != null) {
                    i = bArr.length;
                } else {
                    i = 0;
                }
                byte[] bArr2 = this.hostBytes;
                if (bArr2 != null) {
                    i2 = bArr2.length;
                } else {
                    i2 = 0;
                }
                int length3 = this.userBytes.length;
                byte[] bArr3 = this.sessionKey;
                if (bArr3 != null) {
                    i3 = bArr3.length;
                }
                int i4 = length2 + 72;
                int i5 = i4 + length;
                int i6 = i5 + i;
                int i7 = i6 + length3;
                int i8 = i7 + i2;
                prepareResponse(i8 + i3, 3);
                addUShort(length2);
                addUShort(length2);
                addULong(72);
                addUShort(length);
                addUShort(length);
                addULong(i4);
                addUShort(i);
                addUShort(i);
                addULong(i5);
                addUShort(length3);
                addUShort(length3);
                addULong(i6);
                addUShort(i2);
                addUShort(i2);
                addULong(i7);
                addUShort(i3);
                addUShort(i3);
                addULong(i8);
                int i9 = this.type2Flags;
                addULong((i9 & 4) | (i9 & 128) | (i9 & 512) | (524288 & i9) | 33554432 | (32768 & i9) | (i9 & 32) | (i9 & 16) | (536870912 & i9) | (Integer.MIN_VALUE & i9) | (1073741824 & i9) | (8388608 & i9) | (i9 & 1));
                addUShort(261);
                addULong(2600);
                addUShort(3840);
                addBytes(this.lmResp);
                addBytes(this.ntResp);
                addBytes(this.domainBytes);
                addBytes(this.userBytes);
                addBytes(this.hostBytes);
                byte[] bArr4 = this.sessionKey;
                if (bArr4 != null) {
                    addBytes(bArr4);
                }
                return super.getResponse();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        SecureRandom secureRandom;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1915219593, "Lcom/baidubce/auth/NTLMEngineImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1915219593, "Lcom/baidubce/auth/NTLMEngineImpl;");
                return;
            }
        }
        UNICODE_LITTLE_UNMARKED = Charset.forName("UnicodeLittleUnmarked");
        DEFAULT_CHARSET = Charset.forName("US-ASCII");
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception unused) {
            secureRandom = null;
        }
        RND_GEN = secureRandom;
        byte[] bytes = "NTLMSSP".getBytes(DEFAULT_CHARSET);
        byte[] bArr = new byte[bytes.length + 1];
        SIGNATURE = bArr;
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        SIGNATURE[bytes.length] = 0;
        TYPE_1_MESSAGE = new Type1Message().getResponse();
    }

    public NTLMEngineImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ byte[] access$000() throws NTLMEngineException {
        return makeRandomChallenge();
    }

    public static /* synthetic */ byte[] access$100() throws NTLMEngineException {
        return makeSecondaryKey();
    }

    public static byte[] makeRandomChallenge() throws NTLMEngineException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            SecureRandom secureRandom = RND_GEN;
            if (secureRandom != null) {
                byte[] bArr = new byte[8];
                synchronized (secureRandom) {
                    RND_GEN.nextBytes(bArr);
                }
                return bArr;
            }
            throw new NTLMEngineException("Random generator not available");
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] makeSecondaryKey() throws NTLMEngineException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            SecureRandom secureRandom = RND_GEN;
            if (secureRandom != null) {
                byte[] bArr = new byte[16];
                synchronized (secureRandom) {
                    RND_GEN.nextBytes(bArr);
                }
                return bArr;
            }
            throw new NTLMEngineException("Random generator not available");
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] RC4(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, bArr2)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("RC4");
                cipher.init(1, new SecretKeySpec(bArr2, "RC4"));
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                throw new NTLMEngineException(e.getMessage(), e);
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] readSecurityBuffer(byte[] bArr, int i) throws NTLMEngineException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65578, null, bArr, i)) == null) {
            int readUShort = readUShort(bArr, i);
            int readULong = readULong(bArr, i + 4);
            if (bArr.length >= readULong + readUShort) {
                byte[] bArr2 = new byte[readUShort];
                System.arraycopy(bArr, readULong, bArr2, 0, readUShort);
                return bArr2;
            }
            throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
        }
        return (byte[]) invokeLI.objValue;
    }

    public static int readULong(byte[] bArr, int i) throws NTLMEngineException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65579, null, bArr, i)) == null) {
            if (bArr.length >= i + 4) {
                return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            }
            throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
        }
        return invokeLI.intValue;
    }

    public static String getType1Message(String str, String str2) throws NTLMEngineException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, str, str2)) == null) {
            return TYPE_1_MESSAGE;
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] hmacMD5(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, bArr, bArr2)) == null) {
            HMACMD5 hmacmd5 = new HMACMD5(bArr2);
            hmacmd5.update(bArr);
            return hmacmd5.getOutput();
        }
        return (byte[]) invokeLL.objValue;
    }

    public static int readUShort(byte[] bArr, int i) throws NTLMEngineException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65580, null, bArr, i)) == null) {
            if (bArr.length >= i + 2) {
                return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
            }
            throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
        }
        return invokeLI.intValue;
    }

    public String generateType1Msg(String str, String str2) throws NTLMEngineException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            return getType1Message(str2, str);
        }
        return (String) invokeLL.objValue;
    }

    public static String convertDomain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            return stripDotSuffix(str);
        }
        return (String) invokeL.objValue;
    }

    public static String convertHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            return stripDotSuffix(str);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] ntlmHash(String str) throws NTLMEngineException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, str)) == null) {
            Charset charset = UNICODE_LITTLE_UNMARKED;
            if (charset != null) {
                byte[] bytes = str.getBytes(charset);
                MD4 md4 = new MD4();
                md4.update(bytes);
                return md4.getOutput();
            }
            throw new NTLMEngineException("Unicode not supported");
        }
        return (byte[]) invokeL.objValue;
    }

    public static String stripDotSuffix(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(".");
            if (indexOf != -1) {
                return str.substring(0, indexOf);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void writeULong(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65583, null, bArr, i, i2) == null) {
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
        }
    }

    public static byte[] createBlob(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, bArr, bArr2, bArr3)) == null) {
            byte[] bArr4 = new byte[bArr3.length + 8 + 8 + 4 + bArr2.length + 4];
            System.arraycopy(new byte[]{1, 1, 0, 0}, 0, bArr4, 0, 4);
            System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, 4, 4);
            System.arraycopy(bArr3, 0, bArr4, 8, bArr3.length);
            int length = bArr3.length + 8;
            System.arraycopy(bArr, 0, bArr4, length, 8);
            int i = length + 8;
            System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, i, 4);
            int i2 = i + 4;
            System.arraycopy(bArr2, 0, bArr4, i2, bArr2.length);
            System.arraycopy(new byte[]{0, 0, 0, 0}, 0, bArr4, i2 + bArr2.length, 4);
            return bArr4;
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static Key createDESKey(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65563, null, bArr, i)) == null) {
            byte[] bArr2 = new byte[7];
            System.arraycopy(bArr, i, bArr2, 0, 7);
            byte[] bArr3 = {bArr2[0], (byte) ((bArr2[0] << 7) | ((bArr2[1] & 255) >>> 1)), (byte) ((bArr2[1] << 6) | ((bArr2[2] & 255) >>> 2)), (byte) ((bArr2[2] << 5) | ((bArr2[3] & 255) >>> 3)), (byte) ((bArr2[3] << 4) | ((bArr2[4] & 255) >>> 4)), (byte) ((bArr2[4] << 3) | ((bArr2[5] & 255) >>> 5)), (byte) ((bArr2[5] << 2) | ((bArr2[6] & 255) >>> 6)), (byte) (bArr2[6] << 1)};
            oddParity(bArr3);
            return new SecretKeySpec(bArr3, Coder.KEY_DES);
        }
        return (Key) invokeLI.objValue;
    }

    public static byte[] lmResponse(byte[] bArr, byte[] bArr2) throws NTLMEngineException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, bArr, bArr2)) == null) {
            try {
                byte[] bArr3 = new byte[21];
                System.arraycopy(bArr, 0, bArr3, 0, 16);
                Key createDESKey = createDESKey(bArr3, 0);
                Key createDESKey2 = createDESKey(bArr3, 7);
                Key createDESKey3 = createDESKey(bArr3, 14);
                Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
                cipher.init(1, createDESKey);
                byte[] doFinal = cipher.doFinal(bArr2);
                cipher.init(1, createDESKey2);
                byte[] doFinal2 = cipher.doFinal(bArr2);
                cipher.init(1, createDESKey3);
                byte[] doFinal3 = cipher.doFinal(bArr2);
                byte[] bArr4 = new byte[24];
                System.arraycopy(doFinal, 0, bArr4, 0, 8);
                System.arraycopy(doFinal2, 0, bArr4, 8, 8);
                System.arraycopy(doFinal3, 0, bArr4, 16, 8);
                return bArr4;
            } catch (Exception e) {
                throw new NTLMEngineException(e.getMessage(), e);
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String getResponseFor(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65564, null, str, str2, str3, str4, str5)) == null) {
            if (str != null && !str.trim().equals("")) {
                Type2Message type2Message = new Type2Message(str);
                return getType3Message(str2, str3, str4, str5, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
            }
            return getType1Message(str4, str5);
        }
        return (String) invokeLLLLL.objValue;
    }

    public static String getType3Message(String str, String str2, String str3, String str4, byte[] bArr, int i, String str5, byte[] bArr2) throws NTLMEngineException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{str, str2, str3, str4, bArr, Integer.valueOf(i), str5, bArr2})) == null) {
            return new Type3Message(str4, str3, str, str2, bArr, i, str5, bArr2).getResponse();
        }
        return (String) invokeCommon.objValue;
    }

    public static byte[] lmHash(String str) throws NTLMEngineException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            try {
                byte[] bytes = str.toUpperCase(Locale.ROOT).getBytes(DEFAULT_CHARSET);
                byte[] bArr = new byte[14];
                System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 14));
                Key createDESKey = createDESKey(bArr, 0);
                Key createDESKey2 = createDESKey(bArr, 7);
                byte[] bytes2 = "KGS!@#$%".getBytes(DEFAULT_CHARSET);
                Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
                cipher.init(1, createDESKey);
                byte[] doFinal = cipher.doFinal(bytes2);
                cipher.init(1, createDESKey2);
                byte[] doFinal2 = cipher.doFinal(bytes2);
                byte[] bArr2 = new byte[16];
                System.arraycopy(doFinal, 0, bArr2, 0, 8);
                System.arraycopy(doFinal2, 0, bArr2, 8, 8);
                return bArr2;
            } catch (Exception e) {
                throw new NTLMEngineException(e.getMessage(), e);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] lmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, str, str2, bArr)) == null) {
            if (UNICODE_LITTLE_UNMARKED != null) {
                HMACMD5 hmacmd5 = new HMACMD5(bArr);
                hmacmd5.update(str2.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
                if (str != null) {
                    hmacmd5.update(str.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
                }
                return hmacmd5.getOutput();
            }
            throw new NTLMEngineException("Unicode not supported");
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] lmv2Response(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NTLMEngineException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65571, null, bArr, bArr2, bArr3)) == null) {
            HMACMD5 hmacmd5 = new HMACMD5(bArr);
            hmacmd5.update(bArr2);
            hmacmd5.update(bArr3);
            byte[] output = hmacmd5.getOutput();
            byte[] bArr4 = new byte[output.length + bArr3.length];
            System.arraycopy(output, 0, bArr4, 0, output.length);
            System.arraycopy(bArr3, 0, bArr4, output.length, bArr3.length);
            return bArr4;
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] ntlm2SessionResponse(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NTLMEngineException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65574, null, bArr, bArr2, bArr3)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr2);
                messageDigest.update(bArr3);
                byte[] digest = messageDigest.digest();
                byte[] bArr4 = new byte[8];
                System.arraycopy(digest, 0, bArr4, 0, 8);
                return lmResponse(bArr, bArr4);
            } catch (Exception e) {
                if (e instanceof NTLMEngineException) {
                    throw ((NTLMEngineException) e);
                }
                throw new NTLMEngineException(e.getMessage(), e);
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] ntlmv2Hash(String str, String str2, byte[] bArr) throws NTLMEngineException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65576, null, str, str2, bArr)) == null) {
            if (UNICODE_LITTLE_UNMARKED != null) {
                HMACMD5 hmacmd5 = new HMACMD5(bArr);
                hmacmd5.update(str2.toUpperCase(Locale.ROOT).getBytes(UNICODE_LITTLE_UNMARKED));
                if (str != null) {
                    hmacmd5.update(str.getBytes(UNICODE_LITTLE_UNMARKED));
                }
                return hmacmd5.getOutput();
            }
            throw new NTLMEngineException("Unicode not supported");
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static void oddParity(byte[] bArr) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, bArr) == null) {
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                if ((((b >>> 1) ^ ((((((b >>> 7) ^ (b >>> 6)) ^ (b >>> 5)) ^ (b >>> 4)) ^ (b >>> 3)) ^ (b >>> 2))) & 1) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    bArr[i] = (byte) (bArr[i] | 1);
                } else {
                    bArr[i] = (byte) (bArr[i] & (-2));
                }
            }
        }
    }

    public String generateType3Msg(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4, str5)) == null) {
            Type2Message type2Message = new Type2Message(str5);
            return getType3Message(str, str2, str4, str3, type2Message.getChallenge(), type2Message.getFlags(), type2Message.getTarget(), type2Message.getTargetInfo());
        }
        return (String) invokeLLLLL.objValue;
    }
}
