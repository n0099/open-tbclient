package com.bytedance.pangle.util;

import android.content.Context;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
/* loaded from: classes9.dex */
public final class f {
    public static String a;
    public static String b;
    public static final byte[] c = new byte[4194304];

    public static String a(Context context) {
        File parentFile;
        if (a == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            a = parentFile.getAbsolutePath();
        }
        return a;
    }

    public static String b(Context context) {
        File parentFile;
        if (b == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                b = parentFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    Files.walkFileTree(Paths.get(file.getAbsolutePath(), new String[0]), new SimpleFileVisitor<Path>() { // from class: com.bytedance.pangle.util.g.1
                        public static FileVisitResult a(Path path) {
                            if (path != null) {
                                try {
                                    Files.deleteIfExists(path);
                                } catch (IOException unused) {
                                }
                            }
                            return FileVisitResult.CONTINUE;
                        }

                        public static FileVisitResult b(Path path) {
                            if (path != null) {
                                try {
                                    Files.deleteIfExists(path);
                                } catch (IOException unused) {
                                }
                            }
                            return FileVisitResult.CONTINUE;
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public final /* synthetic */ FileVisitResult postVisitDirectory(Object obj, IOException iOException) {
                            return b((Path) obj);
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public final /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
                            return FileVisitResult.CONTINUE;
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public final /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
                            return a((Path) obj);
                        }

                        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                        public final /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object obj, IOException iOException) {
                            return FileVisitResult.CONTINUE;
                        }
                    });
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    a(file2);
                }
            }
            file.delete();
        }
    }

    public static void a(String str) {
        a(new File(str));
    }
}
