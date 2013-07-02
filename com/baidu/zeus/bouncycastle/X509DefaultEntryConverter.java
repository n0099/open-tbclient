package com.baidu.zeus.bouncycastle;

import java.io.IOException;
/* loaded from: classes.dex */
public class X509DefaultEntryConverter extends X509NameEntryConverter {
    @Override // com.baidu.zeus.bouncycastle.X509NameEntryConverter
    public DERObject getConvertedValue(DERObjectIdentifier dERObjectIdentifier, String str) {
        if (str.length() != 0 && str.charAt(0) == '#') {
            try {
                return convertHexEncoded(str, 1);
            } catch (IOException e) {
                throw new RuntimeException("can't recode value for oid " + dERObjectIdentifier.getId());
            }
        } else if (dERObjectIdentifier.equals(X509Name.EmailAddress) || dERObjectIdentifier.equals(X509Name.DC)) {
            return new DERIA5String(str);
        } else {
            if (dERObjectIdentifier.equals(X509Name.DATE_OF_BIRTH)) {
                return new DERGeneralizedTime(str);
            }
            return new DERUTF8String(str);
        }
    }
}
