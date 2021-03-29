package com.baidu.ufosdk.f;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes5.dex */
public final class g implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f22954a;

    public g(f fVar) {
        this.f22954a = fVar;
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
