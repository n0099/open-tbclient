package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tieba.r;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class m implements FileFilter {
    final /* synthetic */ LogoActivity aKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.aKf = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.aKf.getPageContext().getString(r.l.app_name)) && name.endsWith(".apk");
    }
}
