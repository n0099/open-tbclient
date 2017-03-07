package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tieba.w;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class r implements FileFilter {
    final /* synthetic */ LogoActivity aPQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LogoActivity logoActivity) {
        this.aPQ = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.aPQ.getPageContext().getString(w.l.app_name)) && name.endsWith(".apk");
    }
}
