package com.baidu.wallet.base.iddetect.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class c {
    public static void a(OutputStream outputStream) {
        a((Closeable) outputStream);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
