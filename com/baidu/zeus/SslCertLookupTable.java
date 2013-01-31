package com.baidu.zeus;

import android.os.Bundle;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes.dex */
final class SslCertLookupTable {
    private static SslCertLookupTable sTable;
    private final Bundle table = new Bundle();

    public static SslCertLookupTable getInstance() {
        if (sTable == null) {
            sTable = new SslCertLookupTable();
        }
        return sTable;
    }

    private SslCertLookupTable() {
    }

    public void setIsAllowed(SslError sslError) {
        try {
            this.table.putInt(new URL(sslError.getUrl()).getHost(), sslError.getPrimaryError());
        } catch (MalformedURLException e) {
        }
    }

    public boolean isAllowed(SslError sslError) {
        try {
            String host = new URL(sslError.getUrl()).getHost();
            return this.table.containsKey(host) && sslError.getPrimaryError() <= this.table.getInt(host);
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public void clear() {
        this.table.clear();
    }
}
