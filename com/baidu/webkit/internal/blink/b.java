package com.baidu.webkit.internal.blink;

import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* loaded from: classes5.dex */
public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f26643a;

    public b(String str, EngineManager engineManager, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        super(engineManager, webkitInstallListener);
        if (str != null) {
            String substring = str.substring(7);
            if (new File(substring).isFile()) {
                this.f26643a = substring;
            }
        }
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final boolean c() {
        return this.f26643a != null;
    }

    @Override // com.baidu.webkit.internal.blink.a
    public final String d() {
        return this.f26643a;
    }
}
