package com.baidu.zeus.bouncycastle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
/* loaded from: classes.dex */
public class DERUTCTime extends DERObject {
    String time;

    public static DERUTCTime getInstance(Object obj) {
        if (obj == null || (obj instanceof DERUTCTime)) {
            return (DERUTCTime) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new DERUTCTime(((ASN1OctetString) obj).getOctets());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERUTCTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DERUTCTime(String str) {
        this.time = str;
    }

    public DERUTCTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = simpleDateFormat.format(date);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DERUTCTime(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.time = new String(cArr);
    }

    public String getTime() {
        if (this.time.length() == 11) {
            return this.time.substring(0, 10) + "00GMT+00:00";
        }
        if (this.time.length() == 13) {
            return this.time.substring(0, 12) + "GMT+00:00";
        }
        if (this.time.length() == 17) {
            return this.time.substring(0, 12) + "GMT" + this.time.substring(12, 15) + ":" + this.time.substring(15, 17);
        }
        return this.time;
    }

    public String getAdjustedTime() {
        String time = getTime();
        return time.charAt(0) < '5' ? "20" + time : "19" + time;
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
        dEROutputStream.writeEncoded(23, getOctets());
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DERUTCTime)) {
            return false;
        }
        return this.time.equals(((DERUTCTime) obj).time);
    }

    @Override // com.baidu.zeus.bouncycastle.DERObject, com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        return this.time.hashCode();
    }

    public String toString() {
        return this.time;
    }
}
