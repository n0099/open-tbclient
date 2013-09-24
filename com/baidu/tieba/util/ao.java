package com.baidu.tieba.util;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes.dex */
class ao implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1904a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar, String str) {
        this.f1904a = alVar;
        this.b = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.contains(new StringBuilder(String.valueOf(this.b)).append("_").toString());
    }
}
