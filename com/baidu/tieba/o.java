package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tieba.t;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class o implements FileFilter {
    final /* synthetic */ LogoActivity aLA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LogoActivity logoActivity) {
        this.aLA = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.aLA.getPageContext().getString(t.j.app_name)) && name.endsWith(".apk");
    }
}
