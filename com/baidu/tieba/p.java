package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tieba.u;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class p implements FileFilter {
    final /* synthetic */ LogoActivity aHs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LogoActivity logoActivity) {
        this.aHs = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.aHs.getPageContext().getString(u.j.app_name)) && name.endsWith(".apk");
    }
}
