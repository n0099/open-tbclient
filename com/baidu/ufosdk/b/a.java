package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.ufosdk.f.p;
@SuppressLint({"NewApi"})
/* loaded from: classes22.dex */
public final class a {
    public static long a() {
        if (p.a("android.permission.MOUNT_UNMOUNT_FILESYSTEMS")) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return -1L;
    }
}
