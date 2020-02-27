package com.baidu.webkit.internal.blink;

import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class c extends a {
    private String c;

    public c(String str, EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        super(engineManager, webkitInstallListener);
        this.c = null;
        if (str != null) {
            String substring = str.substring(7);
            if (new File(substring).isFile()) {
                this.c = substring;
            }
        }
    }

    @Override // com.baidu.webkit.internal.blink.a
    protected final boolean b() {
        return this.c != null;
    }

    @Override // com.baidu.webkit.internal.blink.a
    protected final String c() {
        return this.c;
    }
}
