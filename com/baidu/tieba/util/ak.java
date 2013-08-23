package com.baidu.tieba.util;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes.dex */
class ak implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ah f1785a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar, String str) {
        this.f1785a = ahVar;
        this.b = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.contains(new StringBuilder(String.valueOf(this.b)).append("_").toString());
    }
}
