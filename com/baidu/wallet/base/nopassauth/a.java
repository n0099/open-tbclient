package com.baidu.wallet.base.nopassauth;

import android.content.Context;
import android.util.Log;
import com.baidu.apollon.armor.SafePay;
import com.baidu.webkit.internal.ABTestConstants;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public class a implements b {

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f23376g = {1, 10, 100, 1000, 10000, 100000, 1000000, ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT, 100000000};

    /* renamed from: c  reason: collision with root package name */
    public String f23377c;

    /* renamed from: d  reason: collision with root package name */
    public long f23378d;

    /* renamed from: e  reason: collision with root package name */
    public int f23379e;

    /* renamed from: f  reason: collision with root package name */
    public long f23380f;

    public a(String str, long j, int i) {
        this.f23377c = str;
        this.f23378d = j;
        this.f23379e = i;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public int a() {
        return 0;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public void a(long j) {
        this.f23380f = j;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public long b() {
        return this.f23380f;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public int c() {
        return 0;
    }

    public String d() {
        return this.f23377c;
    }

    public long e() {
        return this.f23378d;
    }

    public int f() {
        return this.f23379e;
    }

    public void a(String str) {
        this.f23377c = str;
    }

    public void b(long j) {
        this.f23378d = j;
        Log.d("aaa", "+++++++++HotpToken movingFactor is " + this.f23378d);
    }

    public void a(int i) {
        this.f23379e = i;
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    @Override // com.baidu.wallet.base.nopassauth.b
    public String a(Context context) {
        byte[] bArr = new byte[8];
        long j = this.f23378d;
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) (255 & j);
            j >>= 8;
        }
        SafePay safePay = SafePay.getInstance();
        byte[] b2 = b(this.f23377c);
        int[] iArr = f23376g;
        int i2 = this.f23379e;
        return safePay.getDyKey(b2, bArr, iArr[i2], i2);
    }

    public static String b(int i) {
        MessageDigest messageDigest;
        long timeInMillis = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
        byte[] bytes = ("" + timeInMillis).getBytes();
        try {
            if (i == 128) {
                messageDigest = MessageDigest.getInstance("MD5");
            } else {
                messageDigest = MessageDigest.getInstance("SHA1");
            }
            messageDigest.reset();
            messageDigest.update(bytes);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private byte[] a(byte[] bArr, byte[] bArr2) {
        Mac mac;
        try {
            try {
                mac = Mac.getInstance("HmacSHA1");
            } catch (NoSuchAlgorithmException unused) {
                mac = Mac.getInstance("HMAC-SHA-1");
            }
            mac.init(new SecretKeySpec(bArr, "RAW"));
            return mac.doFinal(bArr2);
        } catch (GeneralSecurityException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }
}
