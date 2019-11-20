package com.baidu.tieba.realauthen.b;

import android.support.v4.view.InputDeviceCompat;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b {
    private static char[] iGq = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toMD5(String str, String str2) {
        if (str != null) {
            try {
                return F(str.getBytes(str2));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String toMds(JSONObject jSONObject, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                String str3 = (String) arrayList.get(i2);
                String str4 = null;
                try {
                    str4 = jSONObject.getString(str3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                sb.append(str3 + "=" + str4 + str2);
                i = i2 + 1;
            } else {
                sb.append("key=" + str);
                return toMD5(sb.toString(), HTTP.UTF_8);
            }
        }
    }

    private static synchronized String F(byte[] bArr) {
        String str;
        synchronized (b.class) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | InputDeviceCompat.SOURCE_ANY).substring(6));
                }
                str = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                str = null;
            }
        }
        return str;
    }
}
