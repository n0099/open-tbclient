package com.baidu.webkit.internal.blink;

import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* loaded from: classes7.dex */
public final class b extends a {
    public String a;

    public b(String str, EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        super(engineManager, webkitInstallListener);
        if (str != null) {
            String substring = str.substring(7);
            if (new File(substring).isFile()) {
                this.a = substring;
            }
        }
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final boolean c() {
        return this.a != null;
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final String d() {
        return this.a;
    }
}
