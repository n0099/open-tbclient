package com.baidu.tieba;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes.dex */
class m implements FileFilter {
    final /* synthetic */ LogoActivity atK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.atK = logoActivity;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        return !TextUtils.isEmpty(name) && name.contains(this.atK.getPageContext().getString(y.app_name)) && name.endsWith(".apk");
    }
}
