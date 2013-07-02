package com.baidu.zeus.security;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.security.KeyPair;
/* loaded from: classes.dex */
public class Credentials {
    public static final String CA_CERTIFICATE = "CACERT_";
    public static final String CERTIFICATE = "CERT";
    public static final String INSTALL_ACTION = "android.credentials.INSTALL";
    private static final String LOGTAG = "Credentials";
    public static final String PKCS12 = "PKCS12";
    public static final String PRIVATE_KEY = "PKEY";
    public static final String PUBLIC_KEY = "KEY";
    public static final String SYSTEM_INSTALL_ACTION = "android.credentials.SYSTEM_INSTALL";
    public static final String UNLOCK_ACTION = "android.credentials.UNLOCK";
    public static final String USER_CERTIFICATE = "USRCERT_";
    public static final String USER_PRIVATE_KEY = "USRPKEY_";
    public static final String VPN = "VPN_";
    public static final String WIFI = "WIFI_";
    private static Credentials singleton;

    public static Credentials getInstance() {
        if (singleton == null) {
            singleton = new Credentials();
        }
        return singleton;
    }

    public void unlock(Context context) {
        try {
            context.startActivity(new Intent(UNLOCK_ACTION));
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    public void install(Context context, KeyPair keyPair) {
        try {
            Intent intent = new Intent(INSTALL_ACTION);
            intent.putExtra(PRIVATE_KEY, keyPair.getPrivate().getEncoded());
            intent.putExtra(PUBLIC_KEY, keyPair.getPublic().getEncoded());
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    public void install(Context context, String str, byte[] bArr) {
        try {
            Intent intent = new Intent(INSTALL_ACTION);
            intent.putExtra(str, bArr);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    public void installFromSdCard(Context context) {
        try {
            context.startActivity(new Intent(INSTALL_ACTION));
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }
}
