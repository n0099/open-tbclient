package com.bytedance.embedapplog;

import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class ch {

    /* renamed from: a  reason: collision with root package name */
    boolean f3929a;
    boolean b;
    boolean c;
    boolean d;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=5, 117=5, 123=5, 124=5, 126=5] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        FileLock lock;
        byte[] bArr;
        int read;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api.embed/cache";
        String str4 = str3 + "/" + str;
        FileLock fileLock2 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            File file = new File(str3);
            if (!file.exists() && !file.mkdirs()) {
                if (0 != 0) {
                    try {
                        fileLock2.release();
                    } catch (Exception e) {
                    }
                }
                if (0 != 0) {
                    try {
                        randomAccessFile2.close();
                        return str2;
                    } catch (Exception e2) {
                        return str2;
                    }
                }
                return str2;
            }
            File file2 = new File(str4);
            randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                lock = randomAccessFile.getChannel().lock();
            } catch (IOException e3) {
                e = e3;
                fileLock = null;
            } catch (Throwable th) {
                th = th;
                fileLock = null;
            }
            try {
                if (file2.isFile() && (read = randomAccessFile.read((bArr = new byte[129]), 0, 129)) > 0 && read < 129) {
                    String str5 = new String(bArr, 0, read, "UTF-8");
                    if (m.d(str5)) {
                        if (lock != null) {
                            try {
                                lock.release();
                            } catch (Exception e4) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        return str5;
                    }
                }
                byte[] bytes = str2.getBytes("UTF-8");
                randomAccessFile.setLength(0L);
                randomAccessFile.write(bytes);
                if (lock != null) {
                    try {
                        lock.release();
                    } catch (Exception e6) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        return str2;
                    } catch (Exception e7) {
                        return str2;
                    }
                }
                return str2;
            } catch (IOException e8) {
                e = e8;
                fileLock = lock;
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        if (bx.eoo().f3925a.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                            throw new SecurityException(e);
                        }
                        au.a(e);
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception e9) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                            return str2;
                        } catch (Exception e10) {
                            return str2;
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception e11) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e12) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileLock = lock;
                if (fileLock != null) {
                }
                if (randomAccessFile != null) {
                }
                throw th;
            }
        } catch (IOException e13) {
            e = e13;
            randomAccessFile = null;
            fileLock = null;
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            fileLock = null;
        }
    }
}
