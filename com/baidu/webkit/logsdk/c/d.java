package com.baidu.webkit.logsdk.c;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes11.dex */
final class d implements Comparator<File> {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(File file, File file2) {
        long lastModified = file.lastModified() - file2.lastModified();
        if (lastModified > 0) {
            return 1;
        }
        return lastModified == 0 ? 0 : -1;
    }
}
