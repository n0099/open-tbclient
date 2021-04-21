package com.baidu.webkit.logsdk.c;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes5.dex */
public final class d implements Comparator<File> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f26703a;

    public d(c cVar) {
        this.f26703a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(File file, File file2) {
        int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i == 0 ? 0 : -1;
    }
}
