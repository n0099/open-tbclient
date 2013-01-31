package com.baidu.zeus.bouncycastle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
/* loaded from: classes.dex */
public class DERGeneralizedTime extends DERObject {
    String time;

    public static DERGeneralizedTime getInstance(Object obj) {
        if (obj == null || (obj instanceof DERGeneralizedTime)) {
            return (DERGeneralizedTime) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DERGeneralizedTime(((ASN1OctetString) obj).getOctets());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERGeneralizedTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DERGeneralizedTime(String str) {
        this.time = str;
    }

    public DERGeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = simpleDateFormat.format(date);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DERGeneralizedTime(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.time = new String(cArr);
    }

    public String getTime() {
        int length;
        int length2;
        if (this.time.charAt(this.time.length() - 1) == 'Z') {
            return this.time.substring(0, this.time.length() - 1) + "GMT+00:00";
        }
        char charAt = this.time.charAt(this.time.length() - 5);
        if (charAt == '-' || charAt == '+') {
            return this.time.substring(0, length) + "GMT" + this.time.substring(length, length + 3) + ":" + this.time.substring(length + 3);
        }
        char charAt2 = this.time.charAt(this.time.length() - 3);
        if (charAt2 == '-' || charAt2 == '+') {
            return this.time.substring(0, length2) + "GMT" + this.time.substring(length2) + ":00";
        }
        return this.time;
    }

    public Date getDate() {
        SimpleDateFormat simpleDateFormat;
        if (this.time.indexOf(46) == 14) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        }
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat.parse(this.time);
    }

    private byte[] getOctets() {
        char[] charArray = this.time.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i = 0; i != charArray.length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.bouncycastle.DERObject
    public void encode(DEROutputStream dEROutputStream) {
        dEROutputStream.writeEncoded(24, getOctets());
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DERGeneralizedTime)) {
            return false;
        }
        return this.time.equals(((DERGeneralizedTime) obj).time);
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return this.time.hashCode();
    }
}
