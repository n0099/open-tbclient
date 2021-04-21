package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import java.io.File;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23348a = "f";

    public static File a(Context context) {
        File file = new File(context.getCacheDir(), "idcard_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
