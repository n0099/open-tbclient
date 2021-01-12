package com.bytedance.sdk.a.b.a.i;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
/* loaded from: classes4.dex */
public final class a extends c {
    private final f pgu;

    public a(f fVar) {
        this.pgu = fVar;
    }

    @Override // com.bytedance.sdk.a.b.a.i.c
    public List<Certificate> u(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        boolean z = false;
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i < 9) {
                X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
                X509Certificate b2 = this.pgu.b(x509Certificate);
                if (b2 != null) {
                    if (arrayList.size() > 1 || !x509Certificate.equals(b2)) {
                        arrayList.add(b2);
                    }
                    if (a(b2, b2)) {
                        return arrayList;
                    }
                    z = true;
                } else {
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        X509Certificate x509Certificate2 = (X509Certificate) it.next();
                        if (a(x509Certificate, x509Certificate2)) {
                            it.remove();
                            arrayList.add(x509Certificate2);
                            z = z2;
                        }
                    }
                    if (z2) {
                        return arrayList;
                    }
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                i++;
            } else {
                throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
            }
        }
    }

    private boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return true;
            } catch (GeneralSecurityException e) {
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.pgu.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && ((a) obj).pgu.equals(this.pgu);
    }
}
