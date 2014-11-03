package com.baidu.tieba;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class n implements FileFilter {
    final /* synthetic */ LogoActivity acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.acU = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.acU.getString(y.app_name)) && name.endsWith(".apk");
    }
}
