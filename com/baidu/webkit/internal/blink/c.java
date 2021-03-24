package com.baidu.webkit.internal.blink;

import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* loaded from: classes5.dex */
public final class c extends a {

    /* renamed from: c  reason: collision with root package name */
    public String f26885c;

    public c(String str, EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        super(engineManager, webkitInstallListener);
        if (str != null) {
            String substring = str.substring(7);
            if (new File(substring).isFile()) {
                this.f26885c = substring;
            }
        }
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final boolean b() {
        return this.f26885c != null;
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final String c() {
        return this.f26885c;
    }
}
