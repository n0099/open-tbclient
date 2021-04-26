package com.baidu.wallet.base.camera.util;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f23991a = -1;

    /* renamed from: com.baidu.wallet.base.camera.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0238a implements FileFilter {

        /* renamed from: a  reason: collision with root package name */
        public Pattern f23992a = Pattern.compile("cpu\\d{1,2}");

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return this.f23992a.matcher(file.getName()).matches();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f23993a = new a();
    }

    public static int a() {
        if (-1 == b.f23993a.f23991a) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C0238a());
                b.f23993a.f23991a = listFiles.length;
            } catch (Exception e2) {
                e2.printStackTrace();
                b.f23993a.f23991a = 1;
            }
        }
        return b.f23993a.f23991a;
    }
}
