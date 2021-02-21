package com.bytedance.sdk.a.b.a.f;

import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface a {
    public static final a prf = new a() { // from class: com.bytedance.sdk.a.b.a.f.a.1
        @Override // com.bytedance.sdk.a.b.a.f.a
        public void a(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.f.a
        public boolean b(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.a.b.a.f.a
        public long aj(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.a.b.a.f.a
        public void a(File file, File file2) throws IOException {
            a(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }
    };

    void a(File file) throws IOException;

    void a(File file, File file2) throws IOException;

    long aj(File file);

    boolean b(File file);
}
