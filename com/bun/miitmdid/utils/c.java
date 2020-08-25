package com.bun.miitmdid.utils;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public class c {
    public static String a(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            int available = open.available();
            byte[] bArr = new byte[available];
            open.read(bArr);
            open.close();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr, 0, available);
            return byteArrayOutputStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
