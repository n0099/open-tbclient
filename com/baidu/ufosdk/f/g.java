package com.baidu.ufosdk.f;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes21.dex */
final class g implements Comparator {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        if (file.lastModified() > file2.lastModified()) {
            return 1;
        }
        return file.lastModified() == file2.lastModified() ? 0 : -1;
    }
}
