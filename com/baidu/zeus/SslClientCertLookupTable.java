package com.baidu.zeus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
final class SslClientCertLookupTable {
    private static SslClientCertLookupTable sTable;
    private final Map privateKeys = new HashMap();
    private final Map certificateChains = new HashMap();
    private final Set denied = new HashSet();

    public static synchronized SslClientCertLookupTable getInstance() {
        SslClientCertLookupTable sslClientCertLookupTable;
        synchronized (SslClientCertLookupTable.class) {
            if (sTable == null) {
                sTable = new SslClientCertLookupTable();
            }
            sslClientCertLookupTable = sTable;
        }
        return sslClientCertLookupTable;
    }

    private SslClientCertLookupTable() {
    }

    public void Allow(String str, byte[] bArr, byte[][] bArr2) {
        this.privateKeys.put(str, bArr);
        this.certificateChains.put(str, bArr2);
        this.denied.remove(str);
    }

    public void Deny(String str) {
        this.privateKeys.remove(str);
        this.certificateChains.remove(str);
        this.denied.add(str);
    }

    public boolean IsAllowed(String str) {
        return this.privateKeys.containsKey(str);
    }

    public boolean IsDenied(String str) {
        return this.denied.contains(str);
    }

    public byte[] PrivateKey(String str) {
        return (byte[]) this.privateKeys.get(str);
    }

    public byte[][] CertificateChain(String str) {
        return (byte[][]) this.certificateChains.get(str);
    }
}
