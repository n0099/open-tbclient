package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class o {
    public static final o a = new o(null, 0, null, null, null);
    @Nullable
    public final Signature[] b;
    public final int c;
    @Nullable
    public final ArraySet<PublicKey> d;
    @Nullable
    public final Signature[] e;
    @Nullable
    public final int[] f;

    public final int hashCode() {
        int i;
        int hashCode = ((Arrays.hashCode(this.b) * 31) + this.c) * 31;
        ArraySet<PublicKey> arraySet = this.d;
        if (arraySet != null) {
            i = arraySet.hashCode();
        } else {
            i = 0;
        }
        return ((((hashCode + i) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f);
    }

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public o(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.b = signatureArr;
        this.c = i;
        this.d = arraySet;
        this.e = signatureArr2;
        this.f = iArr;
    }

    public o(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i, a(signatureArr), signatureArr2, iArr);
    }

    public static ArraySet<PublicKey> a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method a2 = com.bytedance.pangle.a.a.a.a(Signature.class, "getPublicKey", new Class[0]);
            if (a2 != null && a2.isAccessible()) {
                try {
                    arraySet.add((PublicKey) a2.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.c.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.c.a((Object[]) signatureArr2, (Object[]) signatureArr)) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.c != oVar.c || !a(this.b, oVar.b)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.d;
        if (arraySet != null) {
            if (!arraySet.equals(oVar.d)) {
                return false;
            }
        } else if (oVar.d != null) {
            return false;
        }
        if (Arrays.equals(this.e, oVar.e) && Arrays.equals(this.f, oVar.f)) {
            return true;
        }
        return false;
    }
}
