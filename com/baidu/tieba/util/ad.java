package com.baidu.tieba.util;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes.dex */
class ad implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1747a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, String str) {
        this.f1747a = aaVar;
        this.b = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.contains(new StringBuilder(String.valueOf(this.b)).append("_").toString());
    }
}
