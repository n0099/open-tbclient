package com.baidu.zeus.bouncycastle;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.MKSearch;
/* loaded from: classes.dex */
public abstract class X509NameEntryConverter {
    public abstract DERObject getConvertedValue(DERObjectIdentifier dERObjectIdentifier, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public DERObject convertHexEncoded(String str, int i) {
        String lowerCase = Strings.toLowerCase(str);
        byte[] bArr = new byte[(lowerCase.length() - i) / 2];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            char charAt = lowerCase.charAt((i2 * 2) + i);
            char charAt2 = lowerCase.charAt((i2 * 2) + i + 1);
            if (charAt < 'a') {
                bArr[i2] = (byte) ((charAt - '0') << 4);
            } else {
                bArr[i2] = (byte) (((charAt - 'a') + 10) << 4);
            }
            if (charAt2 < 'a') {
                bArr[i2] = (byte) (bArr[i2] | ((byte) (charAt2 - '0')));
            } else {
                bArr[i2] = (byte) (bArr[i2] | ((byte) ((charAt2 - 'a') + 10)));
            }
        }
        return new ASN1InputStream(bArr).readObject();
    }

    protected boolean canBePrintable(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (str.charAt(length) > 127) {
                return false;
            }
            if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && ('0' > charAt || charAt > '9'))) {
                switch (charAt) {
                    case ' ':
                    case '\'':
                    case '(':
                    case ')':
                    case '+':
                    case MKSearch.TYPE_AREA_MULTI_POI_LIST /* 45 */:
                    case '.':
                    case ':':
                    case BDLocation.TypeGpsLocation /* 61 */:
                    case BDLocation.TypeNetWorkException /* 63 */:
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }
}
