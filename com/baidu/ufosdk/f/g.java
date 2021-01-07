package com.baidu.ufosdk.f;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes8.dex */
final class g implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f5668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f5668a = fVar;
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
