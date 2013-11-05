package com.baidu.tieba.util;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes.dex */
class ax implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2434a;
    final /* synthetic */ au b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(au auVar, String str) {
        this.b = auVar;
        this.f2434a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.contains(new StringBuilder().append(this.f2434a).append("_").toString());
    }
}
